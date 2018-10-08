
package ru.gosuslugi.dom.schema.integration.nsi_common_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис экспорта общих справочников подсистемы НСИ
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NsiService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/nsi-common-service/", wsdlLocation = "file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/nsi-common/hcs-nsi-common-service.wsdl")
public class NsiService
    extends Service
{

    private final static URL NSISERVICE_WSDL_LOCATION;
    private final static WebServiceException NSISERVICE_EXCEPTION;
    private final static QName NSISERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/nsi-common-service/", "NsiService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.0.18/nsi-common/hcs-nsi-common-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NSISERVICE_WSDL_LOCATION = url;
        NSISERVICE_EXCEPTION = e;
    }

    public NsiService() {
        super(__getWsdlLocation(), NSISERVICE_QNAME);
    }

    public NsiService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NSISERVICE_QNAME, features);
    }

    public NsiService(URL wsdlLocation) {
        super(wsdlLocation, NSISERVICE_QNAME);
    }

    public NsiService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NSISERVICE_QNAME, features);
    }

    public NsiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NsiService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NsiPortsType
     */
    @WebEndpoint(name = "NsiPort")
    public NsiPortsType getNsiPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/nsi-common-service/", "NsiPort"), NsiPortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NsiPortsType
     */
    @WebEndpoint(name = "NsiPort")
    public NsiPortsType getNsiPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/nsi-common-service/", "NsiPort"), NsiPortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NSISERVICE_EXCEPTION!= null) {
            throw NSISERVICE_EXCEPTION;
        }
        return NSISERVICE_WSDL_LOCATION;
    }

}
