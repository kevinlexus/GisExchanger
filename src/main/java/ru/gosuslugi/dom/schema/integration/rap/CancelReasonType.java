
package ru.gosuslugi.dom.schema.integration.rap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Причина отмены постановления
 * 
 * <p>Java class for CancelReasonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelReasonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Reason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="CancelBaseDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/&gt;
 *         &lt;element name="CancelShortDescription"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String2000Type"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelReasonType", propOrder = {
    "reason",
    "cancelBaseDocument",
    "cancelShortDescription"
})
public class CancelReasonType {

    @XmlElement(name = "Reason", required = true)
    protected NsiRef reason;
    @XmlElement(name = "CancelBaseDocument", required = true)
    protected ProceduralDocumentType cancelBaseDocument;
    @XmlElement(name = "CancelShortDescription", required = true)
    protected String cancelShortDescription;

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setReason(NsiRef value) {
        this.reason = value;
    }

    /**
     * Gets the value of the cancelBaseDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ProceduralDocumentType }
     *     
     */
    public ProceduralDocumentType getCancelBaseDocument() {
        return cancelBaseDocument;
    }

    /**
     * Sets the value of the cancelBaseDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProceduralDocumentType }
     *     
     */
    public void setCancelBaseDocument(ProceduralDocumentType value) {
        this.cancelBaseDocument = value;
    }

    /**
     * Gets the value of the cancelShortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelShortDescription() {
        return cancelShortDescription;
    }

    /**
     * Sets the value of the cancelShortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelShortDescription(String value) {
        this.cancelShortDescription = value;
    }

}
