package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.diffplug.common.base.Errors;
import com.ric.cmn.Utl;
import com.ric.bill.dao.NotifDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.NotifMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Notif;
import com.ric.bill.model.exs.Pdoc;
import com.ric.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsPaymentAsyncBuilders2;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.payment.ExportPaymentDocumentDetailsRequest;
import ru.gosuslugi.dom.schema.integration.payment.GetStateResult;
import ru.gosuslugi.dom.schema.integration.payment.ImportNotificationsOfOrderExecutionCancellationRequest;
import ru.gosuslugi.dom.schema.integration.payment.ImportSupplierNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.payment.ImportSupplierNotificationsOfOrderExecutionRequest.SupplierNotificationOfOrderExecution;
import ru.gosuslugi.dom.schema.integration.payment.SupplierNotificationOfOrderExecutionType.OrderPeriod;
import ru.gosuslugi.dom.schema.integration.payment_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.payment_service_async.PaymentPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.payment_service_async.PaymentsServiceAsync;
import ru.gosuslugi.dom.schema.integration.payments_base.NotificationOfOrderExecutionCancellationType;

@Slf4j
@Service
public class HcsPaymentAsyncBuilder2 implements HcsPaymentAsyncBuilders2 {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private NotifMng notifMng;
	@Autowired
	private NotifDAO notifDao;

	private PaymentsServiceAsync service;
	private PaymentPortsTypeAsync port;
	private SoapBuilder sb;

	/**
	 * Инициализация
	 */
	@Override
	public void setUp() throws CantSendSoap {
		service = new PaymentsServiceAsync();
    	port = service.getPaymentPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов
    	sb.setTrace(false);
	}


	/**
	 * Получить состояние запроса
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public GetStateResult getState2(Task task) {

		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!

		sb.makeRndMsgGuid();
		try {
			state = port.getState(gs);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errStr = "Запрос вернул ошибку!";
		}

		if (state != null && state.getRequestState() != 3) {
			// вернуться, если задание всё еще не выполнено
			log.info("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());
			return null;
		}

		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
			task.setState("ERR");
			task.setResult(errStr);
		}/* else {

			for (CommonResultType e : state.getImportResult()) {
					for (Error f: e.getError()) {
						// Найти элемент задания по Транспортному GUID
						Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
						// Установить статусы ошибки по заданиям
						task2.setState("ERR");
						errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
						task2.setResult(errStr);
						log.error(errStr);

						errChld = true;
					};
			}
		}
*/
/*		if (!err) {
			// если в главном задании нет ошибок, но в любом дочернем задании обнаружена ошибка - статус - "Ошибка"
			// и если уже не установлен признак ошибки
			if (errChld && !task.getState().equals("ERR")
					 && !task.getState().equals("ERS")) {
				task.setState("ERS");
				task.setResult(errStr);
				log.error("Ошибки в элементе CommonResult");
			}
		}
*/
		return state;
	}


	/**
	 * Импорт извещений исполнителя о принятии к исполнению распоряжения
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importSupplierNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, импорт извещений исполнителя, по дому, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ImportSupplierNotificationsOfOrderExecutionRequest req = new ImportSupplierNotificationsOfOrderExecutionRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

		// дом
		Eolink house = reqProp.getFoundTask().getEolink();

		// получить список незагруженных извещений в ГИС по Дому
		notifMng.getNotifForLoadByHouse(house).stream().forEach(Errors.rethrow().wrap(t-> {
			// добавить не более 1000 вхождений ПД
			addNotification(t, req);
		}));


//		// добавить не более 1000 извещений
//		taskDao.getByTaskAddrTp(task, "Извещение исполнителя по ПД", null).stream().filter(t-> t.getAct().getCd().equals("GIS_IMP_SUPPLIER_NOTIF"))
//		.forEach(Errors.rethrow().wrap(t-> {
//			log.info("Добавление извещения, Task.id={}", t.getId());
//			addNotification(t, house, req);
//		}));


		try {
			ack = port.importSupplierNotificationsOfOrderExecution(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}

	}

	/**
	 * Добавление извещения
	 * @param notif - извещение
	 * @param req - запрос
	 * @throws CantPrepSoap
	 * @throws WrongGetMethod
	 * @throws DatatypeConfigurationException
	 */
	private void addNotification(Notif notification, ImportSupplierNotificationsOfOrderExecutionRequest req) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
		// получить ПД
		Pdoc pd = notification.getPdoc();

		SupplierNotificationOfOrderExecution notif = new SupplierNotificationOfOrderExecution();

		log.info("Добавлено извещение по ПД id={}", pd.getUn());
		// идентификатор ПД
		notif.setPaymentDocumentID(pd.getUn());
		// сумма в рублях
		notif.setAmount(BigDecimal.valueOf(notification.getSumma()));
		// дата внесения оплаты (в случае отсутствия: дата поступления средств)
		notif.setOrderDate(Utl.getXMLDate(notification.getDt()));
		OrderPeriod period = new OrderPeriod();
		period.setMonth(3);
		short year = 2018;
		period.setYear(year);
		notif.setOrderPeriod(period );

		// транспортный GUID извещения
		String tguid = Utl.getRndUuid().toString();
		notif.setTransportGUID(tguid);
		notification.setTguid(tguid);

		req.getSupplierNotificationOfOrderExecution().add(notif);
	}

	/**
	 * Получить результат импорта извещений исполнителя о принятии к исполнению распоряжения
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importSupplierNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, импорт Извещений исполнителя, по дому, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);

		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {

			retState.getImportResult().stream().forEach(t -> {
				// Найти Извещение по Транспортному GUID
				Notif notif = notifDao.getByTGUID(t.getTransportGUID());

				boolean isErr = false;
				for (Error f: t.getError()) {
					log.error("Произошла ОШИБКА при загрузке Извещения Notif.id={}", notif.getId());
					String errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
					log.error(errStr);
					isErr = true;
				};

				log.info("После импорта Извещений исполнителя по Task.id={} и TGUID={}, получены следующие параметры:",
						reqProp.getFoundTask().getId(), t.getTransportGUID());
				log.info("GUID={}, UniqueNumber={}", t.getGUID(), t.getUniqueNumber());
				// Найти элемент задания по Транспортному GUID
				Task task2 = taskMng.getByTguid(reqProp.getFoundTask(), t.getTransportGUID());

				// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
				if (notif.getGuid() == null) {
					notif.setGuid(t.getGUID());
					notif.setUn(t.getUniqueNumber());
				}

				// установить статус, если не было ошибки
				if (!isErr && notif.getStatus().equals(0) && notif.getV().equals(1)) {
					// если был "добавлен" и "действующий", то статус - загружен
					notif.setStatus(1);
				} else if (!isErr && notif.getStatus().equals(1) && notif.getV().equals(0)) {
					// если был "загружен" и "отменен", то статус - отменен
					// статус - отменен
					notif.setStatus(2);
				}

			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

		}
	}


	/**
	 * Импорт документов "Извещение об аннулировании извещения о принятии к исполнению распоряжения"
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importNotificationsOfOrderExecutionCancelation(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, Импорт документов \"Извещение об аннулировании извещения о "
				+ "принятии к исполнению распоряжения\", вызов", task.getId());

		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ImportNotificationsOfOrderExecutionCancellationRequest req = new ImportNotificationsOfOrderExecutionCancellationRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

		NotificationOfOrderExecutionCancellationType notif = new NotificationOfOrderExecutionCancellationType();
		req.getNotificationOfOrderExecutionCancellation().add(notif);
		notif.setOrderID("10000000000000001710260003800886");
		notif.setCancellationDate(Utl.getXMLDate(new Date()));
		// Транспортный GUID
		String tguid = Utl.getRndUuid().toString();
		notif.setTransportGUID(tguid);

		try {
			ack = port.importNotificationsOfOrderExecutionCancellation(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;

	}


	/**
	 * Получить результат импорта документов "Извещение об аннулировании извещения о принятии к исполнению распоряжения"
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importNotificationsOfOrderExecutionCancelationAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, Импорт документов \"Извещение об аннулировании извещения о "
				+ "принятии к исполнению распоряжения\", запрос ответа", task.getId());
		// Трассировка XML
		sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getImportResult().forEach(t-> {
				log.info("TGUID={}", t.getGUID());
			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

		}
	}


	/**
	 * Экспорт детализации платежного документа TODO (Lev: не завершен метод)
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportPaymentDocumentDetails(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, Экспорт детализации платежного документа, вызов", task.getId());

		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ExportPaymentDocumentDetailsRequest req = new ExportPaymentDocumentDetailsRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

		req.setPaymentDocumentID("70ВВ288566-03-8039");

		try {
			ack = port.exportPaymentDocumentDetails(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;

	}

	/**
	 * Получить экспорта детализации платежного документа
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportPaymentDocumentDetailsAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, Экспорт детализации платежного документа, запрос ответа", task.getId());
		// Трассировка XML
		sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getImportResult().forEach(t-> {
				log.info("TGUID={}", t.getGUID());
			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

		}
	}

}
