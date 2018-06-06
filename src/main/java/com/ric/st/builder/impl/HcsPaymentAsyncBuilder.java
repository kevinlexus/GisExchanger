package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.NotifDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.NotifMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Notif;
import com.ric.bill.model.exs.Pdoc;
import com.ric.bill.model.exs.Task;
import com.ric.cmn.Utl;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsPaymentAsyncBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
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
public class HcsPaymentAsyncBuilder implements HcsPaymentAsyncBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private NotifMng notifMng;
	@Autowired
	private NotifDAO notifDao;

	private PaymentsServiceAsync service;
	private PaymentPortsTypeAsync port;
	private SoapBuilder sb;

	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private PseudoTaskBuilders ptb;

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
		String errStr = null;
		GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		sb.setTrace(false);

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
			// контроль кол-ва выполнения запроса
			Integer errAckCnt = reqProp.getFoundTask().getErrAckCnt();
			if (errAckCnt.compareTo(1000) < 0) {
				// увеличить на 1 кол-во ошибок
				reqProp.getFoundTask().setErrAckCnt(++errAckCnt);
			} else {
				// ошибка
				log.error("Task.id={}, Превышено количество запросов статуса!", task.getId());
				reqProp.getFoundTask().setState("ERA");
			}
			return null;
		}

		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
			task.setResult(errStr);
			log.error("Task.id={}, ОШИБКА выполнения запроса = {}", task.getId(), errStr);
		} else if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			errStr = state.getErrorMessage().getDescription();
			task.setResult(errStr);
			log.error("Task.id={}, ОШИБКА контроля или бизнес-процесса = {}", task.getId(), errStr);
		}
		return state;
	}


	/**
	 * Импорт извещений исполнителя о принятии к исполнению распоряжения
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importSupplierNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		// есть ли документы на загрузку?
		Boolean isExistJob = false;

		ImportSupplierNotificationsOfOrderExecutionRequest req = new ImportSupplierNotificationsOfOrderExecutionRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

		// дом
		Eolink house = reqProp.getFoundTask().getEolink();

		// получить список незагруженных, действующих извещений в ГИС по Дому
		for (Notif t: notifMng.getNotifForLoadByHouse(house).stream()
			.filter(t-> t.getV().equals(1)) // действующие
			.collect(Collectors.toList())) {
			// добавить не более 1000 вхождений ПД
			log.info("Добавление Извещения, Notif.id={}", t.getId());
			addNotification(t, req);
			isExistJob = true;
		}

		if (isExistJob) {
			log.info("******* Task.id={}, импорт извещений исполнителя, по дому, вызов", task.getId());
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
		} else {
			// Установить статус "Выполнено", так как нечего загружать
			//log.info("Task.id={}, Нет документов для загрузки!", task.getId());
			reqProp.getFoundTask().setState("ACP");
		}

		// сбросить кол-во ошибок запросов Ack
		reqProp.getFoundTask().setErrAckCnt(0);

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
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {

			retState.getImportResult().stream().forEach(t -> {
				// Найти Извещение по Транспортному GUID
				Notif notif = notifDao.getByTGUID(t.getTransportGUID());

				boolean isErr = false;
				for (Error f: t.getError()) {
					log.error("Произошла ОШИБКА при загрузке Извещения Notif.id={}", notif.getId());
					String errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
					log.error(errStr);
					// пометить документ, что загружен с ошибкой
					notif.setErr(1);
					isErr = true;
				};

				if (!isErr) {
					log.info("После импорта Извещений исполнителя по Task.id={} и TGUID={}, получены следующие параметры:",
							reqProp.getFoundTask().getId(), t.getTransportGUID());
					log.info("GUID={}, UniqueNumber={}", t.getGUID(), t.getUniqueNumber());

					// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
					if (notif.getGuid() == null) {
						notif.setGuid(t.getGUID());
						notif.setUn(t.getUniqueNumber());
					}

					// установить статус, если не было ошибки
					if (notif.getStatus().equals(0) && notif.getV().equals(1)) {
						// если был "добавлен" и "действующий", то статус - загружен
						notif.setStatus(1);
					} else if (notif.getStatus().equals(1) && notif.getV().equals(0)) {
						// если был "загружен" и "отменен", то статус - отменен
						// статус - отменен
						notif.setStatus(2);
					}
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
	public void importNotificationsOfOrderExecutionCancelation(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		// есть ли документы на загрузку?
		Boolean isExistJob = false;

		ImportNotificationsOfOrderExecutionCancellationRequest req = new ImportNotificationsOfOrderExecutionCancellationRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

		// дом
		Eolink house = reqProp.getFoundTask().getEolink();

		// получить список незагруженных, отменённых извещений в ГИС по Дому
		for (Notif t : notifMng.getNotifForLoadByHouse(house).stream()
			.filter(t-> t.getV().equals(0)) // недействующие
			.collect(Collectors.toList())) {
			// добавить не более 1000 вхождений ПД
			log.info("Добавление аннулирования Извещения, Notif.id={}", t.getId());
			addNotificationCancellation(t, req);
			isExistJob = true;
		}

		if (isExistJob) {
			log.info("******* Task.id={}, Импорт документов \"Извещение об аннулировании извещения о "
					+ "принятии к исполнению распоряжения\", вызов", task.getId());
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
		} else {
			// Установить статус "Выполнено", так как нечего загружать
			//log.info("Task.id={}, Нет документов для загрузки!", task.getId());
			reqProp.getFoundTask().setState("ACP");
		}

		// сбросить кол-во ошибок запросов Ack
		reqProp.getFoundTask().setErrAckCnt(0);
	}

	/**
	 * Добавление аннулирования извещения
	 * @param notif - извещение
	 * @param req - запрос
	 * @throws CantPrepSoap
	 * @throws WrongGetMethod
	 * @throws DatatypeConfigurationException
	 */
	private void addNotificationCancellation(Notif notification,
			ImportNotificationsOfOrderExecutionCancellationRequest req) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {

		NotificationOfOrderExecutionCancellationType notif = new NotificationOfOrderExecutionCancellationType();
		// уникальный номер извещения
		notif.setOrderID(notification.getUn());
		// дата отмены
		notif.setCancellationDate(Utl.getXMLDate(new Date()));
		// Транспортный GUID
		String tguid = Utl.getRndUuid().toString();
		notif.setTransportGUID(tguid);
		notification.setTguid(tguid);

		req.getNotificationOfOrderExecutionCancellation().add(notif);
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
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {
			retState.getImportResult().stream().forEach(t -> {
				// Найти Извещение по Транспортному GUID
				Notif notif = notifDao.getByTGUID(t.getTransportGUID());

				boolean isErr = false;
				for (Error f: t.getError()) {
					log.error("Произошла ОШИБКА при загрузке аннулирования Извещения Notif.id={}", notif.getId());
					String errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
					log.error(errStr);
					// пометить документ, что загружен с ошибкой
					notif.setErr(1);
					isErr = true;
				};

				if (!isErr) {
					log.info("После импорта аннулирований Извещений исполнителя по Task.id={} и TGUID={}, получены следующие параметры:",
							reqProp.getFoundTask().getId(), t.getTransportGUID());
					log.info("GUID={}, UniqueNumber={}", t.getGUID(), t.getUniqueNumber());

					// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
					if (notif.getGuid() == null) {
						notif.setGuid(t.getGUID());
						notif.setUn(t.getUniqueNumber());
					}

					// установить статус, если не было ошибки
					if (notif.getStatus().equals(0) && notif.getV().equals(1)) {
						// если был "добавлен" и "действующий", то статус - загружен
						notif.setStatus(1);
					} else if (notif.getStatus().equals(1) && notif.getV().equals(0)) {
						// если был "загружен" и "отменен", то статус - отменен
						// статус - отменен
						notif.setStatus(2);
					}
				}

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
	public void exportPaymentDocumentDetails(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
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

	}

	/**
	 * Получить экспорт детализации платежного документа
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
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {
			retState.getImportResult().forEach(t-> {
				log.info("TGUID={}", t.getGUID());
			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

		}
	}


	/**
	 * Проверить наличие заданий на импорт Извещений ПД
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicSupplierImpNotif(Task task) throws WrongParam {
		//log.info("******* Task.id={}, проверка наличия заданий на импорт извещений ПД, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на импорт извещений ПД, если их нет
		String actTp = "GIS_IMP_SUP_NOTIFS";
		String parentCD = "SYSTEM_RPT_IMP_SUP_NOTIF";
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, "STP");
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.info("Добавлено задание на импорт извещений ПД по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
		//log.info("******* Task.id={}, проверка наличия заданий импорт извещений ПД, выполнено!", task.getId());
	}

	/**
	 * Проверить наличие заданий на импорт Извещений ПД
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicImpCancelNotif(Task task) throws WrongParam {
		//log.info("******* Task.id={}, проверка наличия заданий на импорт отмены извещений ПД, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на импорт отмены извещений ПД, если их нет
		String actTp = "GIS_IMP_CANCEL_NOTIFS";
		String parentCD = "SYSTEM_RPT_IMP_NOTIF_CANCEL";
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, "STP");
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.info("Добавлено задание на импорт отмены извещений ПД по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
		//log.info("******* Task.id={}, проверка наличия заданий импорт отмены извещений ПД, выполнено!", task.getId());
	}

}
