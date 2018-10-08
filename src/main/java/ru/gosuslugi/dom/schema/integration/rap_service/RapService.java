
package ru.gosuslugi.dom.schema.integration.rap_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис работы с административными правонарушениями
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RapService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/rap-service/", wsdlLocation = "file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/rap/hcs-rap-service.wsdl")
public class RapService
    extends Service
{

    private final static URL RAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException RAPSERVICE_EXCEPTION;
    private final static QName RAPSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/rap-service/", "RapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/rap/hcs-rap-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RAPSERVICE_WSDL_LOCATION = url;
        RAPSERVICE_EXCEPTION = e;
    }

    public RapService() {
        super(__getWsdlLocation(), RAPSERVICE_QNAME);
    }

    public RapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RAPSERVICE_QNAME, features);
    }

    public RapService(URL wsdlLocation) {
        super(wsdlLocation, RAPSERVICE_QNAME);
    }

    public RapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RAPSERVICE_QNAME, features);
    }

    public RapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RapPort
     */
    @WebEndpoint(name = "RapPort")
    public RapPort getRapPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/rap-service/", "RapPort"), RapPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RapPort
     */
    @WebEndpoint(name = "RapPort")
    public RapPort getRapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/rap-service/", "RapPort"), RapPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RAPSERVICE_EXCEPTION!= null) {
            throw RAPSERVICE_EXCEPTION;
        }
        return RAPSERVICE_WSDL_LOCATION;
    }

}
