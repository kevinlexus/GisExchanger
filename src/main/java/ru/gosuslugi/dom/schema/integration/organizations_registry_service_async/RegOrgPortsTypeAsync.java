
package ru.gosuslugi.dom.schema.integration.organizations_registry_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry.GetStateResult;
import ru.gosuslugi.dom.schema.integration.organizations_registry.ImportForeignBranchRequest;
import ru.gosuslugi.dom.schema.integration.organizations_registry.ImportSubsidiaryRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RegOrgPortsTypeAsync", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-service-async/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.organizations_registry.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface RegOrgPortsTypeAsync {


    /**
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.organizations_registry.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * 
     * @param importSubsidiaryRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importSubsidiary")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importSubsidiary(
        @WebParam(name = "importSubsidiaryRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry/", partName = "importSubsidiaryRequest")
        ImportSubsidiaryRequest importSubsidiaryRequest)
        throws Fault
    ;

    /**
     * импорт сведений о филиале или представительстве иностранного юридического лица
     * 
     * @param importForeignBranchRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importForeignBranch")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "AckRequest")
    public AckRequest importForeignBranch(
        @WebParam(name = "importForeignBranchRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry/", partName = "importForeignBranchRequest")
        ImportForeignBranchRequest importForeignBranchRequest)
        throws Fault
    ;

}
