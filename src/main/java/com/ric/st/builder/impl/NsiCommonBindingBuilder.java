package com.ric.st.builder.impl;


import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;

import com.ric.st.ReqProps;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.st.builder.NsiCommonBindingBuilders;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.impl.SoapConfig;
import com.ric.st.impl.SoapBuilder;
import com.sun.xml.ws.developer.WSBindingProvider;

@Service
@Slf4j
public class NsiCommonBindingBuilder implements NsiCommonBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private SoapConfig config;
	@Autowired
	private ReqProps reqProp;

//	private NsiService service;
	//private NsiPortsType port;
	private SoapBuilder sb;

	private void setUp() throws CantSendSoap {
    	// создать сервис и порт
//		service = new NsiService();
//    	port = service.getNsiPort();

    	// подоготовительный объект для SOAP
		/*  	SoapBuilder sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, false, config.getOrgPPGuid(), config.getHostIp());
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());*/
	}

/*
	*/
/**
	 * Получить список справочников
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault
	 * @throws CantSendSoap
	 * @throws CantSignSoap
	 * @throws Exception
	 *//*

	public ExportNsiListResult getNsiList(String grp) throws Fault, CantSignSoap, CantSendSoap {
		// выполнить инициализацию
		setUp();

		ExportNsiListRequest req = new ExportNsiListRequest();
		req.setListGroup(grp);
		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());


		ExportNsiListResult ex = port.exportNsiList(req);
		return ex;
	}

	*/
/**
	 * Получить справочник
	 * @param grp - вид справочника (NSI, NISRAO)
	 * @throws Fault
	 * @throws CantSendSoap
	 * @throws CantSignSoap
	 * @throws Exception
	 *//*

	public ExportNsiItemResult getNsiItem(String grp, BigInteger id) throws Fault, CantSignSoap, CantSendSoap {
		// выполнить инициализацию
		setUp();

		ExportNsiItemRequest req = new ExportNsiItemRequest();
	    req.setListGroup(grp);
	    req.setRegistryNumber(id);
		//req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());

		ExportNsiItemResult ex = port.exportNsiItem(req);

		// освободить ресурсы
		//sb.closeResource();
	   return ex;
	}
*/
}
