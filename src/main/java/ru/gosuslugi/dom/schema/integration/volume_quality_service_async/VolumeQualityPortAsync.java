
package ru.gosuslugi.dom.schema.integration.volume_quality_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.volume_quality.GetStateResult;
import ru.gosuslugi.dom.schema.integration.volume_quality.ImportIntervalRequest;
import ru.gosuslugi.dom.schema.integration.volume_quality.ImportVolumeAndQualityInformationRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VolumeQualityPortAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.account_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.metering_device_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface VolumeQualityPortAsync {


    /**
     * Импорт информаци об объеме и качестве КР и КУ
     * 
     * @param importVolumeAndQualityInformationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importVolumeAndQualityInformation")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importVolumeAndQualityInformationResult")
    public AckRequest importVolumeAndQualityInformation(
        @WebParam(name = "importVolumeAndQualityInformationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", partName = "importVolumeAndQualityInformationRequest")
        ImportVolumeAndQualityInformationRequest importVolumeAndQualityInformationRequest)
        throws Fault
    ;

    /**
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.volume_quality.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * 
     * @param importIntervalRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importInterval")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importInterval(
        @WebParam(name = "importIntervalRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", partName = "importIntervalRequest")
        ImportIntervalRequest importIntervalRequest)
        throws Fault
    ;

}
