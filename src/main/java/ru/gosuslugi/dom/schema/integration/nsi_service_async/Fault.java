
package ru.gosuslugi.dom.schema.integration.nsi_service_async;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "Fault", targetNamespace = "http://dom.gosuslugi.ru/schema/integration/base/")
public class Fault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ru.gosuslugi.dom.schema.integration.base.Fault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public Fault(String message, ru.gosuslugi.dom.schema.integration.base.Fault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public Fault(String message, ru.gosuslugi.dom.schema.integration.base.Fault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.gosuslugi.dom.schema.integration.base.Fault
     */
    public ru.gosuslugi.dom.schema.integration.base.Fault getFaultInfo() {
        return faultInfo;
    }

}
