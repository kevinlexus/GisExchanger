
package ru.gosuslugi.dom.schema.integration.licenses_service_async;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * Асинхронный сервис управления экспортом лицензий и дисквалифицированных лиц
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LicenseServiceAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/licenses-service-async/", wsdlLocation = "file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.11.0.15/hcs_wsdl_xsd_v.11.11.0.15/licenses/hcs-licenses-service-async.wsdl")
public class LicenseServiceAsync
    extends Service
{

    private final static URL LICENSESERVICEASYNC_WSDL_LOCATION;
    private final static WebServiceException LICENSESERVICEASYNC_EXCEPTION;
    private final static QName LICENSESERVICEASYNC_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service-async/", "LicenseServiceAsync");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/work/GIS_MUP/\u0413\u0418\u0421%20\u0416\u041a\u0425_\u0418\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044f_v.11.11.0.15/hcs_wsdl_xsd_v.11.11.0.15/licenses/hcs-licenses-service-async.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LICENSESERVICEASYNC_WSDL_LOCATION = url;
        LICENSESERVICEASYNC_EXCEPTION = e;
    }

    public LicenseServiceAsync() {
        super(__getWsdlLocation(), LICENSESERVICEASYNC_QNAME);
    }

    public LicenseServiceAsync(WebServiceFeature... features) {
        super(__getWsdlLocation(), LICENSESERVICEASYNC_QNAME, features);
    }

    public LicenseServiceAsync(URL wsdlLocation) {
        super(wsdlLocation, LICENSESERVICEASYNC_QNAME);
    }

    public LicenseServiceAsync(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LICENSESERVICEASYNC_QNAME, features);
    }

    public LicenseServiceAsync(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LicenseServiceAsync(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LicensePortsTypeAsync
     */
    @WebEndpoint(name = "LicensesPortAsync")
    public LicensePortsTypeAsync getLicensesPortAsync() {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service-async/", "LicensesPortAsync"), LicensePortsTypeAsync.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LicensePortsTypeAsync
     */
    @WebEndpoint(name = "LicensesPortAsync")
    public LicensePortsTypeAsync getLicensesPortAsync(WebServiceFeature... features) {
        return super.getPort(new QName("http://dom.gosuslugi.ru/schema/integration/licenses-service-async/", "LicensesPortAsync"), LicensePortsTypeAsync.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LICENSESERVICEASYNC_EXCEPTION!= null) {
            throw LICENSESERVICEASYNC_EXCEPTION;
        }
        return LICENSESERVICEASYNC_WSDL_LOCATION;
    }

}
