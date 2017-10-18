
package ru.gosuslugi.dom.schema.integration.organizations_registry_common_service;

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
@WebServiceClient(name = "RegOrgService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-common-service/", wsdlLocation = "file:/C:/work/GIS_MUP/GIS11.5.0.8/hcs_wsdl_xsd_v.11.5.0.8/organizations-registry-common/hcs-organizations-registry-common-service.wsdl")
public class RegOrgService
    extends Service
{

    private final static URL REGORGSERVICE_WSDL_LOCATION;
    private final static WebServiceException REGORGSERVICE_EXCEPTION;
    private final static QName REGORGSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-common-service/", "RegOrgService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/GIS11.5.0.8/hcs_wsdl_xsd_v.11.5.0.8/organizations-registry-common/hcs-organizations-registry-common-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        REGORGSERVICE_WSDL_LOCATION = url;
        REGORGSERVICE_EXCEPTION = e;
    }

    public RegOrgService() {
        super(__getWsdlLocation(), REGORGSERVICE_QNAME);
    }

    public RegOrgService(WebServiceFeature... features) {
        super(__getWsdlLocation(), REGORGSERVICE_QNAME, features);
    }

    public RegOrgService(URL wsdlLocation) {
        super(wsdlLocation, REGORGSERVICE_QNAME);
    }

    public RegOrgService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, REGORGSERVICE_QNAME, features);
    }

    public RegOrgService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RegOrgService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RegOrgPortsType
     */
    @WebEndpoint(name = "RegOrgPort")
    public RegOrgPortsType getRegOrgPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-common-service/", "RegOrgPort"), RegOrgPortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RegOrgPortsType
     */
    @WebEndpoint(name = "RegOrgPort")
    public RegOrgPortsType getRegOrgPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/organizations-registry-common-service/", "RegOrgPort"), RegOrgPortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (REGORGSERVICE_EXCEPTION!= null) {
            throw REGORGSERVICE_EXCEPTION;
        }
        return REGORGSERVICE_WSDL_LOCATION;
    }

}
