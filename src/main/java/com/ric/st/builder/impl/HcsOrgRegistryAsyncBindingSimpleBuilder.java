package com.ric.st.builder.impl;

import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingSimpleBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.sun.xml.ws.developer.WSBindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import java.io.IOException;

@Service
@Slf4j
public class HcsOrgRegistryAsyncBindingSimpleBuilder implements HcsOrgRegistryAsyncBindingSimpleBuilders {

	private final ApplicationContext ctx;
	private final TaskMng taskMng;
	private final ReqProps reqProp;
	private RegOrgPortsTypeAsync port;
	private SoapBuilder sb;

	public HcsOrgRegistryAsyncBindingSimpleBuilder(ApplicationContext ctx, TaskMng taskMng, ReqProps reqProp) {
		this.ctx = ctx;
		this.taskMng = taskMng;
		this.reqProp = reqProp;
	}

	@Override
	public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
    	// создать сервис и порт
		RegOrgServiceAsync service = new RegOrgServiceAsync();
    	port = service.getRegOrgAsyncPort();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		reqProp.setPropBeforeSimple(task);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(), reqProp.getHostIp());

		// логгинг запросов
    	sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());
	}

	/**
	 * Получить состояние запроса
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public GetStateResult getState2(Task task) {

		// Признак ошибки
		boolean err = false;
		// Признак ошибки в CommonResult
		boolean errChld = false;
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
			if (state.getRequestState() == 1) {
				// статус запроса - ACK - увеличить время ожидания + 10 секунд
				task.alterDtNextStart(10);
			}
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
	 * Экспорт данных организации
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
}
