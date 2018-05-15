
package ru.gosuslugi.dom.schema.integration.house_management_service_async;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HouseManagementServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management-service-async/", wsdlLocation = "file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.11.0.15/hcs_wsdl_xsd_v.11.11.0.15/house-management/hcs-house-management-service-async.wsdl")
public class HouseManagementServiceAsync
    extends Service
{

    private final static URL HOUSEMANAGEMENTSERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException HOUSEMANAGEMENTSERVICEASYNC_EXCEPTION;
    private final static QName HOUSEMANAGEMENTSERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service-async/", "HouseManagementServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.11.0.15/hcs_wsdl_xsd_v.11.11.0.15/house-management/hcs-house-management-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOUSEMANAGEMENTSERVICEASYNC_WSDL_LOCATION = url;
        HOUSEMANAGEMENTSERVICEASYNC_EXCEPTION = e;
    }

    public HouseManagementServiceAsync() {
        super(__getWsdlLocation(), HOUSEMANAGEMENTSERVICEASYNC_QNAME);
    }

    public HouseManagementServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOUSEMANAGEMENTSERVICEASYNC_QNAME, features);
    }

    public HouseManagementServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, HOUSEMANAGEMENTSERVICEASYNC_QNAME);
    }

    public HouseManagementServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOUSEMANAGEMENTSERVICEASYNC_QNAME, features);
    }

    public HouseManagementServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HouseManagementServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HouseManagementPortsTypeAsync
     */
    @WebEndpoint(name = "HouseManagementPortAsync")
    public HouseManagementPortsTypeAsync getHouseManagementPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service-async/", "HouseManagementPortAsync"), HouseManagementPortsTypeAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HouseManagementPortsTypeAsync
     */
    @WebEndpoint(name = "HouseManagementPortAsync")
    public HouseManagementPortsTypeAsync getHouseManagementPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/house-management-service-async/", "HouseManagementPortAsync"), HouseManagementPortsTypeAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOUSEMANAGEMENTSERVICEASYNC_EXCEPTION!= null) {
            throw HOUSEMANAGEMENTSERVICEASYNC_EXCEPTION;
        }
        return HOUSEMANAGEMENTSERVICEASYNC_WSDL_LOCATION;
    }

}
