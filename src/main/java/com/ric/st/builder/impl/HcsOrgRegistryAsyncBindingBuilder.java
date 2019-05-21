package com.ric.st.builder.impl;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import com.ric.st.impl.SoapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.dao.EolinkDAO;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportDataProviderRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgServiceAsync;

@Service
@Slf4j
public class HcsOrgRegistryAsyncBindingBuilder implements HcsOrgRegistryAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private PseudoTaskBuilders ptb;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private SoapConfig soapConfig;

	private RegOrgServiceAsync service;
	private RegOrgPortsTypeAsync port;

	private SoapBuilder sb;

	@Override
	public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
    	// создать сервис и порт
		service = new RegOrgServiceAsync();
    	port = service.getRegOrgAsyncPort();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		reqProp.setPropBefore(task);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(), reqProp.getHostIp());

		// логгинг запросов
    	sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());
	}



	/**
	 * Получить состояние запроса
	 * @param task - задание
	 * @return
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
		} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e) {
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
		} else {

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

		if (!err) {
			// если в главном задании нет ошибок, но в любом дочернем задании обнаружена ошибка - статус - "Ошибка"
			// и если уже не установлен признак ошибки
			if (errChld && !task.getState().equals("ERR")
					 && !task.getState().equals("ERS")) {
				task.setState("ERS");
				task.setResult(errStr);
				log.error("Ошибки в элементе CommonResult");
			}
		}

		return state;
	}

	/**
	 * Экспорт данных провайдера
	 */
/*	@Override
	public void exportDataProvider() {
		ExportDataProviderRequest req = new ExportDataProviderRequest();
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());

		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		sb.setSign(false);

		try {
			ack = port.exportDataProvider(req);
		} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e1) {
			e1.printStackTrace();
			err = true;
		}

		RetState retState = getState2(ack);
		if (err || retState.getErr()) {
			// Ошибка
			log.info("Ошибка выполнения запроса = {}", retState.getErrStr());

		} else {
			// Ошибок нет
			retState.getState().getExportDataProviderResult().stream().forEach(t->{
				log.info("Provider={}", t.getDataProviderGUID());
			});
		}

	}*/

	/**
	 * Экспорт данных организации
	 * @return
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean exportOrgRegistry(Task task) throws CantPrepSoap {
		taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropWOGUID(task, sb);
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		AckRequest ack = null;
		// для обработки ошибок
		boolean err = false;
		String errMainStr = null;
		Eolink eolOrg = reqProp.getFoundTask().getEolink();

		ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();

		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());

		if (eolOrg.getOgrn() != null) {
			SearchCriteria sc = new SearchCriteria();
			sc.setOGRN(eolOrg.getOgrn());
			req.getSearchCriteria().add(sc);

			try {
				ack = port.exportOrgRegistry(req);
			} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e1) {
				e1.printStackTrace();
				err = true;
				errMainStr = "Ошибка выполнения основного SOAP запроса!";
			}
		} else {
			// Не заполнен ОГРН
			err = true;
			errMainStr = "Отсутствует ОГРН!";
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
			taskMng.logTask(task, false, false);

		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
			taskMng.logTask(task, false, true);

		}

		return err;
		}

	/**
	 * Получить результат экспорта параметров организации
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportOrgRegistryAsk(Task task) throws CantPrepSoap {
		taskMng.logTask(task, true, null);
        // установить параметры SOAP
		reqProp.setPropWOGUID(task, sb);
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		Eolink eolOrg = reqProp.getFoundTask().getEolink();
		// получить состояние запроса
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {

			retState.getExportOrgRegistryResult().forEach(t->{
				if (eolOrg.getGuid() == null) {
					eolOrg.setGuid(t.getOrgPPAGUID());
					log.info("По Организации: Eolink.id={} сохранен GUID={}", eolOrg.getId(), t.getOrgPPAGUID());
				} else {
					log.info("По Организации: Eolink.id={} получен GUID={}", eolOrg.getId(), t.getOrgPPAGUID());
				}
			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			taskMng.logTask(task, false, true);
		}
	}

	/**
	 * Экспорт данных провайдера
	 * @return
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean exportDataProvider(Task task) throws CantPrepSoap {
		//log.info("******* Task.id={}, экспорт сведений о поставщиках данных, вызов", task.getId());
		taskMng.logTask(task, true, null);

		// Установить параметры SOAP
        reqProp.setPropWOGUID(task, sb);
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);

		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ExportDataProviderRequest req = new ExportDataProviderRequest();
		req.setIsActual(true);
		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());
		try {
			ack = port.exportDataProvider(req);
		} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e1) {
			e1.printStackTrace();
			err = true;
			errMainStr = "Ошибка выполнения основного SOAP запроса!";
		}

		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
			taskMng.logTask(task, false, false);

		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
			taskMng.logTask(task, false, true);

		}

		return err;
		}

	/**
	 * Получить результат экспорта данных провайдера
	 * @param task - задание
	 * @throws WrongGetMethod
	 * @throws IOException
	 * @throws CantPrepSoap
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportDataProviderAsk(Task task) throws CantPrepSoap {
		//log.info("******* Task.id={}, экспорт сведений о поставщиках данных, запрос ответа", task.getId());
		taskMng.logTask(task, true, null);

		// установить параметры SOAP
		reqProp.setPropWOGUID(task, sb);
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// получить состояние запроса
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {

			retState.getExportDataProviderResult().stream().forEach(t->{
					log.info("Получен DATA PROVIDER GUID={}", t.getDataProviderGUID());
			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			taskMng.logTask(task, false, true);

		}
	}

	/**
	 * Проверить наличие заданий на выгрузку параметров организаций
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicTask(Task task) throws WrongParam {
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем организациям задания, если у них нет родительской (по главным)
		createTask("GIS_EXP_ORG", "SYSTEM_RPT_ORG_EXP", "STP", "Организация",
				"выгрузку параметров организации");
		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

	private void createTask(String actTp, String parentCD, String state, String eolTp, String purpose) {
		int a;// создавать по 100 штук, иначе -блокировка Task (нужен коммит)
		a=1;
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp(eolTp, actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, state, soapConfig.getCurUser().getId());
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.info("Добавлено задание на {}, по объекту {}, Eolink.id={}", purpose, eolTp, e.getId());
			a++;
			if (a++>=100) {
				break;
			}
		}
	}

}
