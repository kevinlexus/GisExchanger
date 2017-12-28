
package ru.gosuslugi.dom.schema.integration.services_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicesService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services-service/", wsdlLocation = "file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.7.0.10.1/hcs_wsdl_xsd_v.11.7.0.10/services/hcs-services-service.wsdl")
public class ServicesService
    extends Service
{

    private final static URL SERVICESSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICESSERVICE_EXCEPTION;
    private final static QName SERVICESSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/services-service/", "ServicesService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.7.0.10.1/hcs_wsdl_xsd_v.11.7.0.10/services/hcs-services-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICESSERVICE_WSDL_LOCATION = url;
        SERVICESSERVICE_EXCEPTION = e;
    }

    public ServicesService() {
        super(__getWsdlLocation(), SERVICESSERVICE_QNAME);
    }

    public ServicesService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICESSERVICE_QNAME, features);
    }

    public ServicesService(URL wsdlLocation) {
        super(wsdlLocation, SERVICESSERVICE_QNAME);
    }

    public ServicesService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICESSERVICE_QNAME, features);
    }

    public ServicesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicesService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicesPortsType
     */
    @WebEndpoint(name = "defaultPort")
    public ServicesPortsType getDefaultPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/services-service/", "defaultPort"), ServicesPortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicesPortsType
     */
    @WebEndpoint(name = "defaultPort")
    public ServicesPortsType getDefaultPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/services-service/", "defaultPort"), ServicesPortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICESSERVICE_EXCEPTION!= null) {
            throw SERVICESSERVICE_EXCEPTION;
        }
        return SERVICESSERVICE_WSDL_LOCATION;
    }

}
