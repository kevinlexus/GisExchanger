
package ru.gosuslugi.dom.schema.integration.house_management_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountIndividualServicesRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChAsyncRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusCAChRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportStatusPublicPropertyContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportVotingProtocolRequest;
import ru.gosuslugi.dom.schema.integration.house_management.GetStateResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountIndividualServicesRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportCharterRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseESPRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseOMSRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseRSORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportNotificationRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportPublicPropertyContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportSupplyResourceContractRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportVotingProtocolRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HouseManagementPortsTypeAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ObjectFactory.class,
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
public interface HouseManagementPortsTypeAsync {


    /**
     * Передать данные ПУ
     * 
     * @param importMeteringDeviceDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importMeteringDeviceData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importMeteringDeviceData(
        @WebParam(name = "importMeteringDeviceDataRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importMeteringDeviceDataRequest")
        ImportMeteringDeviceDataRequest importMeteringDeviceDataRequest)
        throws Fault
    ;

    /**
     * Получить перечень ПУ
     * 
     * @param exportMeteringDeviceDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportMeteringDeviceData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportMeteringDeviceData(
        @WebParam(name = "exportMeteringDeviceDataRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportMeteringDeviceDataRequest")
        ExportMeteringDeviceDataRequest exportMeteringDeviceDataRequest)
        throws Fault
    ;

    /**
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.house_management.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * Cоздание/редактирование, удаление, пролонгация, расторжение ДУ
     * 
     * @param importContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importContractData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importContractData(
        @WebParam(name = "importContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importContractRequest")
        ImportContractRequest importContractRequest)
        throws Fault
    ;

    /**
     * Cоздание/редактирование, удаление, пролонгация, расторжение устава
     * 
     * @param importCharterRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importCharterData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importCharterData(
        @WebParam(name = "importCharterRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importCharterRequest")
        ImportCharterRequest importCharterRequest)
        throws Fault
    ;

    /**
     * Экспорт статусов договоров управления, уставов, доп. соглашений
     * 
     * @param exportStatusCAChRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportStatusCAChData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportStatusCAChData(
        @WebParam(name = "exportStatusCAChRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportStatusCAChRequest")
        ExportStatusCAChRequest exportStatusCAChRequest)
        throws Fault
    ;

    /**
     * ВИ_ИРАО_ДОМ_ЭКСП. Экспорт данных дома.
     * 
     * @param exportHouseRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportHouseData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportHouseData(
        @WebParam(name = "exportHouseRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportHouseRequest")
        ExportHouseRequest exportHouseRequest)
        throws Fault
    ;

    /**
     * ВИ_ИЛС_СЗЛС. передать данные лицевых счетов
     * 
     * @param importAccountData
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importAccountData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckResult")
    public AckRequest importAccountData(
        @WebParam(name = "importAccountRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importAccountData")
        ImportAccountRequest importAccountData)
        throws Fault
    ;

    /**
     * ВИ_ИЛС_РЛС. получить перечень лицевых счетов
     * 
     * @param exportAccountDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportAccountData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportAccountData(
        @WebParam(name = "exportAccountRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportAccountDataRequest")
        ExportAccountRequest exportAccountDataRequest)
        throws Fault
    ;

    /**
     * Импорт ДОИ (Договор на пользование общим имуществом)
     * 
     * @param importPublicPropertyContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importPublicPropertyContract")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckResult")
    public AckRequest importPublicPropertyContract(
        @WebParam(name = "importPublicPropertyContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importPublicPropertyContractRequest")
        ImportPublicPropertyContractRequest importPublicPropertyContractRequest)
        throws Fault
    ;

    /**
     * Экспорт списка ДОИ
     * 
     * @param exportStatusPublicPropertyContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportStatusPublicPropertyContract")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportStatusPublicPropertyContract(
        @WebParam(name = "exportStatusPublicPropertyContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportStatusPublicPropertyContractRequest")
        ExportStatusPublicPropertyContractRequest exportStatusPublicPropertyContractRequest)
        throws Fault
    ;

    /**
     * ВИ_ИО_И_1. Импорт новостей для информирования граждан
     * 
     * @param importNotificationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importNotificationData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckResult")
    public AckRequest importNotificationData(
        @WebParam(name = "importNotificationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importNotificationRequest")
        ImportNotificationRequest importNotificationRequest)
        throws Fault
    ;

    /**
     * Импорт протокола ОСС
     * 
     * @param importVotingProtocolRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importVotingProtocol")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importVotingProtocol(
        @WebParam(name = "importVotingProtocolRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importVotingProtocolRequest")
        ImportVotingProtocolRequest importVotingProtocolRequest)
        throws Fault
    ;

    /**
     * Экспорт протокола ОСС
     * 
     * @param exportVotingProtocolRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportVotingProtocol")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequestr")
    public AckRequest exportVotingProtocol(
        @WebParam(name = "exportVotingProtocolRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportVotingProtocolRequest")
        ExportVotingProtocolRequest exportVotingProtocolRequest)
        throws Fault
    ;

    /**
     * Экспорт договоров управления, уставов, доп. соглашений
     * 
     * @param exportCAChDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCAChData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "exportCAChDataResult")
    public AckRequest exportCAChData(
        @WebParam(name = "exportCAChAsyncRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportCAChDataRequest")
        ExportCAChAsyncRequest exportCAChDataRequest)
        throws Fault
    ;

    /**
     * Импорт данных дома для полномочия УО
     * 
     * @param importHouseUODataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importHouseUOData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importHouseUOData(
        @WebParam(name = "importHouseUORequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importHouseUODataRequest")
        ImportHouseUORequest importHouseUODataRequest)
        throws Fault
    ;

    /**
     * Импорт данных дома для полномочия РСО
     * 
     * @param importHouseRSODataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importHouseRSOData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importHouseRSOData(
        @WebParam(name = "importHouseRSORequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importHouseRSODataRequest")
        ImportHouseRSORequest importHouseRSODataRequest)
        throws Fault
    ;

    /**
     * Импорт данных дома для полномочия ОМС
     * 
     * @param importHouseOMSDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importHouseOMSData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importHouseOMSData(
        @WebParam(name = "importHouseOMSRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importHouseOMSDataRequest")
        ImportHouseOMSRequest importHouseOMSDataRequest)
        throws Fault
    ;

    /**
     * Импорт данных дома для полномочия ЕСП
     * 
     * @param importHouseESPDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importHouseESPData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importHouseESPData(
        @WebParam(name = "importHouseESPRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importHouseESPDataRequest")
        ImportHouseESPRequest importHouseESPDataRequest)
        throws Fault
    ;

    /**
     * Импорт договора ресурсоснабжения с РСО
     * 
     * @param importSupplyResourceContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importSupplyResourceContractData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importSupplyResourceContractData(
        @WebParam(name = "importSupplyResourceContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importSupplyResourceContractRequest")
        ImportSupplyResourceContractRequest importSupplyResourceContractRequest)
        throws Fault
    ;

    /**
     * Экспорт договоров ресурсоснабжения
     * 
     * @param exportSupplyResourceContractRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportSupplyResourceContractData")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportSupplyResourceContractData(
        @WebParam(name = "exportSupplyResourceContractRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportSupplyResourceContractRequest")
        ExportSupplyResourceContractRequest exportSupplyResourceContractRequest)
        throws Fault
    ;

    /**
     * Импорт индивидуальных услуг лицевого счета
     * 
     * @param importAccountIndividualServicesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importAccountIndividualServices")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importAccountIndividualServices(
        @WebParam(name = "importAccountIndividualServicesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "importAccountIndividualServicesRequest")
        ImportAccountIndividualServicesRequest importAccountIndividualServicesRequest)
        throws Fault
    ;

    /**
     * Экспорт индивидуальных услуг лицевого счета
     * 
     * @param exportAccountIndividualServicesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportAccountIndividualServices")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest exportAccountIndividualServices(
        @WebParam(name = "exportAccountIndividualServicesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", partName = "exportAccountIndividualServicesRequest")
        ExportAccountIndividualServicesRequest exportAccountIndividualServicesRequest)
        throws Fault
    ;

}
