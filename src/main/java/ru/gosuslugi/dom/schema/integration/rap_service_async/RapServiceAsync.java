
package ru.gosuslugi.dom.schema.integration.rap_service_async;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Асинхронный сервис работы с административными правонарушениями
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RapServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/rap-service-async/", wsdlLocation = "file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/rap/hcs-rap-service-async.wsdl")
public class RapServiceAsync
    extends Service
{

    private final static URL RAPSERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException RAPSERVICEASYNC_EXCEPTION;
    private final static QName RAPSERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/rap-service-async/", "RapServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/rap/hcs-rap-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RAPSERVICEASYNC_WSDL_LOCATION = url;
        RAPSERVICEASYNC_EXCEPTION = e;
    }

    public RapServiceAsync() {
        super(__getWsdlLocation(), RAPSERVICEASYNC_QNAME);
    }

    public RapServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), RAPSERVICEASYNC_QNAME, features);
    }

    public RapServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, RAPSERVICEASYNC_QNAME);
    }

    public RapServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RAPSERVICEASYNC_QNAME, features);
    }

    public RapServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RapServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RapPortAsync
     */
    @WebEndpoint(name = "RapPortAsync")
    public RapPortAsync getRapPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/rap-service-async/", "RapPortAsync"), RapPortAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RapPortAsync
     */
    @WebEndpoint(name = "RapPortAsync")
    public RapPortAsync getRapPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/rap-service-async/", "RapPortAsync"), RapPortAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RAPSERVICEASYNC_EXCEPTION!= null) {
            throw RAPSERVICEASYNC_EXCEPTION;
        }
        return RAPSERVICEASYNC_WSDL_LOCATION;
    }

}
