
package ru.gosuslugi.dom.schema.integration.services_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.services.ExportCompletedWorksRequest;
import ru.gosuslugi.dom.schema.integration.services.ExportCompletedWorksResult;
import ru.gosuslugi.dom.schema.integration.services.ExportHMServicesTarifsRequest;
import ru.gosuslugi.dom.schema.integration.services.ExportHMServicesTarifsResult;
import ru.gosuslugi.dom.schema.integration.services.ExportWorkingListRequest;
import ru.gosuslugi.dom.schema.integration.services.ExportWorkingListResult;
import ru.gosuslugi.dom.schema.integration.services.ExportWorkingPlanRequest;
import ru.gosuslugi.dom.schema.integration.services.ExportWorkingPlanResult;
import ru.gosuslugi.dom.schema.integration.services.ImportCompletedWorksRequest;
import ru.gosuslugi.dom.schema.integration.services.ImportWorkingListRequest;
import ru.gosuslugi.dom.schema.integration.services.ImportWorkingPlanRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicesPortsType", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.services.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface ServicesPortsType {


    /**
     * ВИ_ИПОЧ_УК_ТФ_ЭКСП. экспорт тарифов ЖКУ
     * 
     * @param exportHMServicesTarifsDataRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.services.ExportHMServicesTarifsResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportHMServicesTarifs")
    @WebResult(name = "exportHMServicesTarifsResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportHMServicesTarifsDataResult")
    public ExportHMServicesTarifsResult exportHMServicesTarifs(
        @WebParam(name = "exportHMServicesTarifsRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportHMServicesTarifsDataRequest")
        ExportHMServicesTarifsRequest exportHMServicesTarifsDataRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ПЕР_ЭКСП. экспорт основных сведений по перечню работ
     * 
     * @param exportWorkingListRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.services.ExportWorkingListResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportWorkingList")
    @WebResult(name = "exportWorkingListResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportWorkingListResult")
    public ExportWorkingListResult exportWorkingList(
        @WebParam(name = "exportWorkingListRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportWorkingListRequest")
        ExportWorkingListRequest exportWorkingListRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ПЕР_ИМП. импорт основных сведений по перечню работ
     * 
     * @param importWorkingListRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importWorkingList")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importWorkingListResult")
    public ImportResult importWorkingList(
        @WebParam(name = "importWorkingListRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "importWorkingListRequest")
        ImportWorkingListRequest importWorkingListRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ПЛАН_ИМП. импорт актуальных планов по перечню работ/услуг
     * 
     * @param importWorkingPlanRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importWorkingPlan")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importWorkingPlanResult")
    public ImportResult importWorkingPlan(
        @WebParam(name = "importWorkingPlanRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "importWorkingPlanRequest")
        ImportWorkingPlanRequest importWorkingPlanRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ПЛАН_ЭКСП. экспорт актуальных планов по перечню работ/услуг
     * 
     * @param exportWorkingPlanRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.services.ExportWorkingPlanResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportWorkingPlan")
    @WebResult(name = "exportWorkingPlanResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportWorkingPlanResult")
    public ExportWorkingPlanResult exportWorkingPlan(
        @WebParam(name = "exportWorkingPlanRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportWorkingPlanRequest")
        ExportWorkingPlanRequest exportWorkingPlanRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ВЫП_ИМП. импорт сведений о выполненных работах и услугах
     * 
     * @param importCompletedWorksRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importCompletedWorks")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importCompletedWorksResult")
    public ImportResult importCompletedWorks(
        @WebParam(name = "importCompletedWorksRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "importCompletedWorksRequest")
        ImportCompletedWorksRequest importCompletedWorksRequest)
        throws Fault
    ;

    /**
     * ВИ_ИПФР_ВЫП_ЭКСП. экспорт сведений о выполненных работах и услугах
     * 
     * @param exportCompletedWorksRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.services.ExportCompletedWorksResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCompletedWorks")
    @WebResult(name = "exportCompletedWorksResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportCompletedWorksResult")
    public ExportCompletedWorksResult exportCompletedWorks(
        @WebParam(name = "exportCompletedWorksRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/services/", partName = "exportCompletedWorksRequest")
        ExportCompletedWorksRequest exportCompletedWorksRequest)
        throws Fault
    ;

}
