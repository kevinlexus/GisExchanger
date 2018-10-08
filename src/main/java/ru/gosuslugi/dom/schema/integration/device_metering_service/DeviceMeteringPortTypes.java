
package ru.gosuslugi.dom.schema.integration.device_metering_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DeviceMeteringPortTypes", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.device_metering.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.metering_device_base.ObjectFactory.class
})
public interface DeviceMeteringPortTypes {


    /**
     * Передать показания ПУ
     * 
     * @param importMeteringDeviceValuesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importMeteringDeviceValues")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "ImportResult")
    public ImportResult importMeteringDeviceValues(
        @WebParam(name = "importMeteringDeviceValuesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "importMeteringDeviceValuesRequest")
        ImportMeteringDeviceValuesRequest importMeteringDeviceValuesRequest)
        throws Fault
    ;

    /**
     * Получить историю показаний ПУ
     * 
     * @param exportMeteringDeviceHistoryRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportMeteringDeviceHistory")
    @WebResult(name = "exportMeteringDeviceHistoryResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "exportMeteringDeviceHistoryResult")
    public ExportMeteringDeviceHistoryResult exportMeteringDeviceHistory(
        @WebParam(name = "exportMeteringDeviceHistoryRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "exportMeteringDeviceHistoryRequest")
        ExportMeteringDeviceHistoryRequest exportMeteringDeviceHistoryRequest)
        throws Fault
    ;

}
