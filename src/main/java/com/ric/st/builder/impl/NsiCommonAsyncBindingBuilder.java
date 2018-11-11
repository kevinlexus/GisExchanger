package com.ric.st.builder.impl;


import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import com.ric.st.ReqProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.st.builder.NsiCommonAsyncBindingBuilders;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListRequest;
import ru.gosuslugi.dom.schema.integration.nsi_common.GetStateResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_common_service_async.NsiPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.nsi_common_service_async.NsiServiceAsync;

@Service
@Slf4j
public class NsiCommonAsyncBindingBuilder implements NsiCommonAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private SoapConfig config;
	@Autowired
	private ReqProps reqProp;

	private NsiServiceAsync service;
	private NsiPortsTypeAsync port;
	private SoapBuilder sb;

	private void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new NsiServiceAsync();
    	port = service.getNsiPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, false, config.getOrgPPGuid(), config.getHostIp());
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());

	}

	/**
	 * Получить список справочников
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault
	 * @throws CantSendSoap
	 * @throws CantSignSoap
	 * @throws ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault
	 * @throws Exception
	 */
	@Override
	public NsiListType getNsiList(String grp) throws Fault, CantSignSoap, CantSendSoap, ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault {
		// выполнить инициализацию
		setUp();

		ExportNsiListRequest req = new ExportNsiListRequest();
		req.setListGroup(grp);
		req.setId("foo");
		sb.setSign(true);

		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());
		GetStateRequest gs = new GetStateRequest();
		AckRequest ack = port.exportNsiList(req);
		gs.setMessageGUID( ack.getAck().getMessageGUID() );
		GetStateResult state = null;

		sb.setSign(false);
		while (state == null || state.getRequestState() != 3){

			state = port.getState(gs);
			log.info("Состояние запроса state = {}", state.getRequestState());
			// задержка 1 сек
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			log.info("Вложенная ошибка XML: {}", state.getErrorMessage().getDescription());
			throw new CantSendSoap(state.getErrorMessage().getDescription());
		}
		return state.getNsiList();
	}

	/**
	 * Получить справочник
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault
	 * @throws CantSendSoap
	 * @throws CantSignSoap
	 * @throws ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault
	 * @throws Exception
	 */
	@Override
	public NsiItemType getNsiItem(String grp, BigInteger id) throws Fault, CantSignSoap, CantSendSoap, ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault {
		// выполнить инициализацию
		setUp();

		ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		req.setId("foo");
		sb.setSign(true);
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());
		AckRequest ack = port.exportNsiItem(req);
		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID( ack.getAck().getMessageGUID() );
		GetStateResult state = null;

		sb.setSign(false);
		sb.setTrace(false);
		while (state == null || state.getRequestState() != 3){

				state = port.getState(gs);
				log.info("Состояние запроса state = {}", state.getRequestState());
				// задержка 1 сек
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			log.info("Вложенная ошибка XML: код={},  описание={}", state.getErrorMessage().getErrorCode(),  state.getErrorMessage().getDescription());
			if (state.getErrorMessage().getErrorCode().equals("INT016001") ||
					state.getErrorMessage().getErrorCode().equals("INT016041")
					) {
				// Справочник пустой в ГИС, не загружен!
				return null;
			} else {
				throw new CantSendSoap(state.getErrorMessage().getDescription());
			}
		}
		return state.getNsiItem();
		// освободить ресурсы
		//sb.closeResource();
	   //return ex;
	}


}
