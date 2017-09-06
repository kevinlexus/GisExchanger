package com.ric.st.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ric.bill.Utl;
import com.ric.st.SoapBuilders;
import com.ric.st.excp.CantSendSoap;
import com.sun.xml.ws.developer.WSBindingProvider;

import ru.gosuslugi.dom.schema.integration.base.RequestHeader;

/**
 * Вспомогательный класс для постройки SOAP запроса
 * @author lev
 *
 */
@Service
@Scope("prototype")
public class SoapBuilder implements SoapBuilders{
	@Autowired
	private SoapConfig config;

	@Autowired
	private TaskController taskCtrl;

	private BindingProvider bp;
	private WSBindingProvider ws;
	private RequestHeader rh;
	// GUID организации, от которой отправляется запрос
	private String ppGuid; 

	public void makeRndMsgGuid() {
    	UUID messGUID = Utl.getRndUuid();
		rh.setMessageGUID(messGUID.toString());
	}

	// подписывать ли XML
	public void setSign(boolean sign) {
    	// подписывать ли XML?
    	if (sign) {
        	bp.getRequestContext().put("sign", "");
    	} else {
    		bp.getRequestContext().remove("sign", "");
    	}
    	
    	// Получить объект подписывания
    	//bp.getRequestContext().put("sc", taskCtrl.sc);
    	
	}
	
	// логгировать ли обмен
	public void setTrace(boolean trace) {
    	if (trace) {
        	bp.getRequestContext().put("trace", "");
    	} else {
    		bp.getRequestContext().remove("trace", "");
    	}
	}

	/**
	 * Инициализация
	 * @param port 
	 * @param port2
	 * @param sign - подписать XML?
	 * @throws CantSendSoap
	 */
	public void setUp(BindingProvider port, WSBindingProvider port2, boolean sign) throws CantSendSoap {
		bp = (BindingProvider) port;
		ws = (WSBindingProvider) port;
		rh = new RequestHeader();
		
		// подпись
		setSign(sign);
		
    	rh.setIsOperatorSignature(true);
    	
    	// установить Random Message GUID и дату
    	GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar cl = null;
		try {
			cl = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
			throw new CantSendSoap("Ошибка при подготовке даты для SOAP Message");
		}
		rh.setDate(cl);
    	UUID messGUID = Utl.getRndUuid();
		rh.setMessageGUID(messGUID.toString());
    	
    	ws.setOutboundHeaders(rh);
		
		String endPoint = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		String urlStr = endPoint;
		String path = null;
		try {
			path = Utl.getPathFromUrl(urlStr);
		} catch (UnknownHostException | MalformedURLException e) {
			e.printStackTrace();
			throw new CantSendSoap("Ошибка при определении хоста");
		}
		
		Map<String, List<String>> requestHeaders = new HashMap<>();
        @SuppressWarnings("restriction")
		String authorization = new sun.misc.BASE64Encoder().encode((config.getBscLogin()+":"+config.getBscPass()).getBytes());
		requestHeaders.put("Authorization", Arrays.asList("Basic " + authorization));
		requestHeaders.put("X-Client-Cert-Fingerprint", Arrays.asList(config.getFingerPrint()));
		
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				config.getSrvTestHost()+path);
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		
		// добавить хэндлер, для установщика подписи ЭЦП
		Binding binding = bp.getBinding();
    	List<Handler> handlerChain = binding.getHandlerChain();
    	handlerChain.add(new LoggingSOAPHandler());
    	binding.setHandlerChain(handlerChain);
	}

	
	public String getPpGuid() {
		return ppGuid;
	}

	public void setPpGuid(String ppGuid) {
		this.ppGuid = ppGuid;
		rh.setOrgPPAGUID(ppGuid);
	}

	public void closeResource() throws CantSendSoap {
	   	try {
			ws.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CantSendSoap("Ошибка при освобождении ресурса WSBindingProvider");
		}
		
	}


	
	
	
}
