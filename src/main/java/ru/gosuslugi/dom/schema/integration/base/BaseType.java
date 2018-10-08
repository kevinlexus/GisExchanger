
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig_.SignatureType;
import ru.gosuslugi.dom.schema.integration.bills.ExportInsuranceProductRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportInsuranceProductResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionPaginalRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionPaginalResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentResult;
import ru.gosuslugi.dom.schema.integration.bills.ExportSettlementsRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportSettlementsResult;
import ru.gosuslugi.dom.schema.integration.bills.ImportAcknowledgmentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportIKUSettlementsRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportInsuranceProductRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportRSOSettlementsRequest;


/**
 * Базовый тип бизнес-сообщения с подписью
 * 
 * <p>Java class for BaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseType", propOrder = {
    "signature"
})
@XmlSeeAlso({
    ImportResult.class,
    BaseAsyncResponseType.class,
    ExportInsuranceProductResult.class,
    ExportInsuranceProductRequest.class,
    ImportInsuranceProductRequest.class,
    ExportSettlementsResult.class,
    ExportSettlementsRequest.class,
    ImportIKUSettlementsRequest.class,
    ImportRSOSettlementsRequest.class,
    ImportAcknowledgmentRequest.class,
    ExportNotificationsOfOrderExecutionPaginalResult.class,
    ExportNotificationsOfOrderExecutionPaginalRequest.class,
    ExportNotificationsOfOrderExecutionResult.class,
    ExportNotificationsOfOrderExecutionRequest.class,
    ExportPaymentDocumentResult.class,
    ExportPaymentDocumentRequest.class,
    ImportPaymentDocumentRequest.class
})
public class BaseType {

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
