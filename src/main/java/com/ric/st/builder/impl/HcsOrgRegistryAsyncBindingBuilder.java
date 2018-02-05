package com.ric.st.builder.impl;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResultType;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportDataProviderRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgServiceAsync;

import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.bill.mm.TaskMng;
import com.sun.xml.ws.developer.WSBindingProvider;

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

	private RegOrgServiceAsync service;
	private RegOrgPortsTypeAsync port;

	private SoapBuilder sb;

	public void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new RegOrgServiceAsync();
    	port = service.getRegOrgAsyncPort();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов
    	sb.setTrace(false);
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
	public void exportDataProvider() {
	/*	ExportDataProviderRequest req = new ExportDataProviderRequest();
		req.setVersion(req.getVersion());
		
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

		RetState retState = getState(ack);
		if (err || retState.getErr()) {
			// Ошибка
			log.info("Ошибка выполнения запроса = {}", retState.getErrStr());

		} else {
			// Ошибок нет
			retState.getState().getExportDataProviderResult().stream().forEach(t->{
				log.info("Provider={}", t.getDataProviderGUID());
			});		
		}
		*/
	}

	/**
	 * Экспорт данных организации
	 * @return 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean exportOrgRegistry(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, экспорт параметров организации, вызов", task.getId());
		//sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);	
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		Eolink eolOrg = reqProp.getFoundTask().getEolink(); 
		String reu = eolOrg.getReu(); 

		ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());

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
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		
		return err;
		}
	
	/**
	 * Получить результат экспорта параметров организации
	 * @param task - задание
	 * @throws WrongGetMethod 
	 * @throws IOException 
	 * @throws CantPrepSoap 
	 * @throws WrongParam 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportOrgRegistryAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam {
		log.info("******* Task.id={}, экспорт параметров организации, запрос ответа", task.getId());
		//sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		Eolink eolOrg = reqProp.getFoundTask().getEolink(); 
		// получить состояние запроса
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {

			retState.getExportOrgRegistryResult().stream().forEach(t->{
				if (eolOrg.getGuid() == null) {
					log.info("По Организации: {} сохранен GUID={}", eolOrg.getReu(), t.getOrgPPAGUID());
					eolOrg.setGuid(t.getOrgPPAGUID());
				} else {
					log.info("По Организации: {} получен GUID={}", eolOrg.getReu(), t.getOrgPPAGUID());
				}
			});		
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
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
		log.info("******* Task.id={}, проверка наличия заданий на выгрузку параметров организаций, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем организациям задания, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Организация", "GIS_EXP_ORG")) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_EXP_ORG", "STP");
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addAsChild("SYSTEM_RPT_ORG_EXP");
			ptb.save();
			log.info("Добавлено задание на выгрузку параметров организаций по Организации Eolink.id={}", e.getId());
		};
		// Установить статус выполнения задания
		foundTask.setState("ACP");
		
	}



}
