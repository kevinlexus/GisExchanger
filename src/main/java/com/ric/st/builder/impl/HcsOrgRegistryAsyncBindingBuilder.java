package com.ric.st.builder.impl;

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
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportDataProviderRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.ExportOrgRegistryRequest.SearchCriteria;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.RegOrgServiceAsync;

import com.ric.bill.mm.EolinkMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
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
	private SoapConfig config;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private TaskMng taskMng;

	private RegOrgServiceAsync service;
	private RegOrgPortsTypeAsync port;

	private SoapBuilder sb;
	// внутренний DTO класс
	private class RetState {
		private GetStateResult state;
		private Boolean err;
		private String errStr;
		
		private RetState(GetStateResult state, Boolean err, String errStr) {
			super();
			setState(state);
			setErr(err);
			setErrStr(errStr);
		}
		
		public GetStateResult getState() {
			return state;
		}
		public void setState(GetStateResult state) {
			this.state = state;
		}
		public Boolean getErr() {
			return err;
		}
		public void setErr(Boolean err) {
			this.err = err;
		}
		public String getErrStr() {
			return errStr;
		}
		public void setErrStr(String errStr) {
			this.errStr = errStr;
		}

	}

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
	
	private RetState getState(AckRequest ack) {
		Boolean err = false;
		String errStr = null;
		GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID( ack.getAck().getMessageGUID() );
		sb.setSign(false); // не подписывать запрос состояния!
		
		int i = 2;
		while (!err && (state == null || state.getRequestState() != 3)){
			// задержка 1 сек
			try {
				Thread.sleep(50 * i++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sb.makeRndMsgGuid();
			try {
				state = port.getState(gs);
			} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e) {
				e.printStackTrace();
				err = true;
				errStr = "Запрос вернул ошибку!";
			}
			log.info("Статус запроса={}, timeout={}", state.getRequestState(), i);
			if (i > 50) {
				// не более 50 раз выполнить проверку запроса
				err=true;
				errStr = "Превышено время выполнения запроса!";
			}
		}
		
		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
		} if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Прочие ошибки
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
		}
		
		return new RetState(state, err, errStr);

	}

	/**
	 * Экспорт данных провайдера
	 */
	public void exportDataProvider() {
		ExportDataProviderRequest req = new ExportDataProviderRequest();
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
		
	}

	/**
	 * Экспорт данных организации
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void exportOrgRegistry(Task task, String reu) {
		Task foundTask = null;
		Eolink eolOrg = null;
		if (task != null) {
			// если есть задание
			foundTask = em.find(Task.class, task.getId());
			eolOrg = foundTask.getEolink(); 
			reu = eolOrg.getReu(); 
		} else {
			// если запрос без задания, найти Организацию в EOLINK по reu  
			eolOrg = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация");
		}

		ExportOrgRegistryRequest req = new ExportOrgRegistryRequest();
		req.setVersion(req.getVersion());
		req.setId("foo");
		sb.setSign(true);
		// GUID текущей организации
		sb.setPpGuid(config.getOrgPPGuid());

		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		SearchCriteria sc = new SearchCriteria();

		//sc.setOGRN("1154250016051"); // металл
		//sc.setOGRN("1114205043468"); // риц
		//sc.setOGRN("1154250016293"); // ООО "УПРАВЛЯЮЩАЯ КОМПАНИЯ ЖИЛКОМСЕРВИС"
		sc.setOGRN(eolOrg.getOgrn());
		req.getSearchCriteria().add(sc);

		try {
			ack = port.exportOrgRegistry(req);
		} catch (ru.gosuslugi.dom.schema.integration.organizations_registry_common_service_async.Fault e1) {
			e1.printStackTrace();
			err = true;
			errMainStr = "Ошибка выполнения основного SOAP запроса!";
		}

		RetState retState = getState(ack);
		if (err || retState.getErr()) {
			if (task != null) {
				String errStr;
				
				if (err) {
					errStr = errMainStr;
				} else {
					errStr = retState.getErrStr();
					
				}
				foundTask.setState("ERR");
				foundTask.setResult("Ошибка: "+errStr);
			}
		} else {
			// Ошибок нет
			String reu2 = reu;
			Eolink eolOrg2  = eolOrg; 
			retState.getState().getExportOrgRegistryResult().stream().forEach(t->{
				log.info("По Организации: {} найден GUID={}", reu2, t.getOrgPPAGUID());
				eolOrg2.setGuid(t.getOrgPPAGUID());
			});		
			
			if (task != null) {
				// Установить статус выполнения задания
				foundTask.setState("ACP");
			}

		}
		}
}
