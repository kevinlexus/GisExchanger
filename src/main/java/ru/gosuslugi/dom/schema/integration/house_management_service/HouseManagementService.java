
package ru.gosuslugi.dom.schema.integration.house_management_service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Сервис управления объектами РАО
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HouseManagementService", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management-service/", wsdlLocation = "file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.1.10/house-management/hcs-house-management-service.wsdl")
public class HouseManagementService
    extends Service
{

    private final static URL HOUSEMANAGEMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException HOUSEMANAGEMENTSERVICE_EXCEPTION;
    private final static QName HOUSEMANAGEMENTSERVICE_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service/", "HouseManagementService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Progs/GisExchanger/wsdl/hcs_wsdl_xsd_v.12.2.1.10/house-management/hcs-house-management-service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOUSEMANAGEMENTSERVICE_WSDL_LOCATION = url;
        HOUSEMANAGEMENTSERVICE_EXCEPTION = e;
    }

    public HouseManagementService() {
        super(__getWsdlLocation(), HOUSEMANAGEMENTSERVICE_QNAME);
    }

    public HouseManagementService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOUSEMANAGEMENTSERVICE_QNAME, features);
    }

    public HouseManagementService(URL wsdlLocation) {
        super(wsdlLocation, HOUSEMANAGEMENTSERVICE_QNAME);
    }

    public HouseManagementService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOUSEMANAGEMENTSERVICE_QNAME, features);
    }

    public HouseManagementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HouseManagementService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HouseManagementPortsType
     */
    @WebEndpoint(name = "HouseManagementPort")
    public HouseManagementPortsType getHouseManagementPort() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service/", "HouseManagementPort"), HouseManagementPortsType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HouseManagementPortsType
     */
    @WebEndpoint(name = "HouseManagementPort")
    public HouseManagementPortsType getHouseManagementPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service/", "HouseManagementPort"), HouseManagementPortsType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOUSEMANAGEMENTSERVICE_EXCEPTION!= null) {
            throw HOUSEMANAGEMENTSERVICE_EXCEPTION;
        }
        return HOUSEMANAGEMENTSERVICE_WSDL_LOCATION;
    }

}
