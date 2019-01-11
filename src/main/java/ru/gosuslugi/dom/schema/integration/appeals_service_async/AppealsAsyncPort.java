
package ru.gosuslugi.dom.schema.integration.appeals_service_async;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import ru.gosuslugi.dom.schema.integration.appeals.ExportAppealRequest;
import ru.gosuslugi.dom.schema.integration.appeals.GetStateResult;
import ru.gosuslugi.dom.schema.integration.appeals.ImportAnswerRequest;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AppealsAsyncPort", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/appeals-service-async")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.appeals.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.nsi_base.ObjectFactory.class,
    org.w3._2000._09.xmldsig_.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.account_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.bills_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.individual_registry_base.ObjectFactory.class,
    ru.gosuslugi.dom.schema.integration.organizations_base.ObjectFactory.class
})
public interface AppealsAsyncPort {


    /**
     * Результат обработки асинхронного вызова
     * 
     * @param getStateRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.appeals.GetStateResult
     * @throws Fault
     */
    @WebMethod(action = "urn:getState")
    @WebResult(name = "getStateResult", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/appeals/", partName = "getStateResult")
    public GetStateResult getState(
        @WebParam(name = "getStateRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "getStateRequest")
        GetStateRequest getStateRequest)
        throws Fault
    ;

    /**
     * Экспорт обращений и ответов на обращения
     * 
     * @param exportAppealRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:exportAppeal")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "exportAppealResult")
    public AckRequest exportAppeal(
        @WebParam(name = "exportAppealRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/appeals/", partName = "exportAppealRequest")
        ExportAppealRequest exportAppealRequest)
        throws Fault
    ;

    /**
     * Импорт ответов на обращения
     * 
     * @param importAnswerRequest
     * @return
     *     returns ru.gosuslugi.dom.schema.integration.base.AckRequest
     * @throws Fault
     */
    @WebMethod(action = "urn:importAnswer")
    @WebResult(name = "AckRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/", partName = "importAnswerResult")
    public AckRequest importAnswer(
        @WebParam(name = "importAnswerRequest", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/appeals/", partName = "importAnswerRequest")
        ImportAnswerRequest importAnswerRequest)
        throws Fault
    ;

}