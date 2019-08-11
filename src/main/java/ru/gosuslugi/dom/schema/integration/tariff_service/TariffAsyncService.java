
package ru.gosuslugi.dom.schema.integration.tariff_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис Ведение тарифов
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TariffAsyncService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/tariff-service/", wsdlLocation = "file:/C:/doc/GIS/gis_wsimport/tariff/hcs-tariff-service-async.wsdl")
public class TariffAsyncService
    extends Service
{

    private final static URL TARIFFASYNCSERVICE_WSDL_LOCATION;
    private final static WebServiceException TARIFFASYNCSERVICE_EXCEPTION;
    private final static QName TARIFFASYNCSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/tariff-service/", "TariffAsyncService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/doc/GIS/gis_wsimport/tariff/hcs-tariff-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TARIFFASYNCSERVICE_WSDL_LOCATION = url;
        TARIFFASYNCSERVICE_EXCEPTION = e;
    }

    public TariffAsyncService() {
        super(__getWsdlLocation(), TARIFFASYNCSERVICE_QNAME);
    }

    public TariffAsyncService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TARIFFASYNCSERVICE_QNAME, features);
    }

    public TariffAsyncService(URL wsdlLocation) {
        super(wsdlLocation, TARIFFASYNCSERVICE_QNAME);
    }

    public TariffAsyncService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TARIFFASYNCSERVICE_QNAME, features);
    }

    public TariffAsyncService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TariffAsyncService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TariffAsyncPort
     */
    @WebEndpoint(name = "TariffAsyncPort")
    public TariffAsyncPort getTariffAsyncPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/tariff-service/", "TariffAsyncPort"), TariffAsyncPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TariffAsyncPort
     */
    @WebEndpoint(name = "TariffAsyncPort")
    public TariffAsyncPort getTariffAsyncPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/tariff-service/", "TariffAsyncPort"), TariffAsyncPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TARIFFASYNCSERVICE_EXCEPTION!= null) {
            throw TARIFFASYNCSERVICE_EXCEPTION;
        }
        return TARIFFASYNCSERVICE_WSDL_LOCATION;
    }

}
