
package ru.gosuslugi.dom.schema.integration.msp_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.ImportResult;
import ru.gosuslugi.dom.schema.integration.msp.ExportCategoriesRequest;
import ru.gosuslugi.dom.schema.integration.msp.ExportCategoriesResult;
import ru.gosuslugi.dom.schema.integration.msp.ExportCitizenCompensationRequest;
import ru.gosuslugi.dom.schema.integration.msp.ExportCitizenCompensationResult;
import ru.gosuslugi.dom.schema.integration.msp.ExportCitizenSubsidyRequest;
import ru.gosuslugi.dom.schema.integration.msp.ExportCitizenSubsidyResult;
import ru.gosuslugi.dom.schema.integration.msp.ImportCitizenCompensationRequest;
import ru.gosuslugi.dom.schema.integration.msp.ImportCitizenSubsidyRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MSPPort", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp-service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.msp.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class
})
public interface MSPPort {


    /**
     * Импорт сведений о гражданах, получающих субсидии
     * 
     * @param importCitizenSubsidyRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importCitizenSubsidy")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importCitizenSubsidyResult")
    public ImportResult importCitizenSubsidy(
        @WebParam(name = "importCitizenSubsidyRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "importCitizenSubsidyRequest")
        ImportCitizenSubsidyRequest importCitizenSubsidyRequest)
        throws Fault
    ;

    /**
     * Импорт сведений о гражданах, получающих компенсации расходов
     * 
     * @param importCitizenCompensationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.ImportResult
     * @throws Fault
     */
    @WebMethod(action = "urn:importCitizenCompensation")
    @WebResult(name = "ImportResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importCitizenCompensationResult")
    public ImportResult importCitizenCompensation(
        @WebParam(name = "importCitizenCompensationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "importCitizenCompensationRequest")
        ImportCitizenCompensationRequest importCitizenCompensationRequest)
        throws Fault
    ;

    /**
     * Экспорт перечня отдельных категорий граждан, имеющих право на получение компенсации расходов
     * 
     * @param exportCategoriesRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.msp.ExportCategoriesResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCategories")
    @WebResult(name = "exportCategoriesResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCategoriesResult")
    public ExportCategoriesResult exportCategories(
        @WebParam(name = "exportCategoriesRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCategoriesRequest")
        ExportCategoriesRequest exportCategoriesRequest)
        throws Fault
    ;

    /**
     * Экспорт сведений о гражданах, получающих субсидии
     * 
     * @param exportCitizenSubsidyRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.msp.ExportCitizenSubsidyResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCitizenSubsidy")
    @WebResult(name = "exportCitizenSubsidyResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCitizenSubsidyResult")
    public ExportCitizenSubsidyResult exportCitizenSubsidy(
        @WebParam(name = "exportCitizenSubsidyRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCitizenSubsidyRequest")
        ExportCitizenSubsidyRequest exportCitizenSubsidyRequest)
        throws Fault
    ;

    /**
     * Экспорт сведений о гражданах, получающих компенсации расходов
     * 
     * @param exportCitizenCompensationRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.msp.ExportCitizenCompensationResult
     * @throws Fault
     */
    @WebMethod(action = "urn:exportCitizenCompensation")
    @WebResult(name = "exportCitizenCompensationResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCitizenCompensationResult")
    public ExportCitizenCompensationResult exportCitizenCompensation(
        @WebParam(name = "exportCitizenCompensationRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/msp/", partName = "exportCitizenCompensationRequest")
        ExportCitizenCompensationRequest exportCitizenCompensationRequest)
        throws Fault
    ;

}
