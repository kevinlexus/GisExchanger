
package ru.gosuslugi.dom.schema.integration.device_metering_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DeviceMeteringPortTypesAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.device_metering.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.metering_device_base.ObjectFactory.class
})
public interface DeviceMeteringPortTypesAsync {


    /**
     * Передать показания ПУ
     * 
     * @param importMeteringDeviceValuesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importMeteringDeviceValues")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importMeteringDeviceValues(
        @WebParam(name = "importMeteringDeviceValuesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "importMeteringDeviceValuesRequest")
        ImportMeteringDeviceValuesRequest importMeteringDeviceValuesRequest)
        throws Fault
    ;

    /**
     * Получить историю показаний ПУ
     * 
     * @param exportMeteringDeviceHistoryRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportMeteringDeviceHistory")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportMeteringDeviceHistory(
        @WebParam(name = "exportMeteringDeviceHistoryRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "exportMeteringDeviceHistoryRequest")
        ExportMeteringDeviceHistoryRequest exportMeteringDeviceHistoryRequest)
        throws Fault
    ;

    /**
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/device-metering/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

}
