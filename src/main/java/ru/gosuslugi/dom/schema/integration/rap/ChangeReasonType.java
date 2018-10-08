
package ru.gosuslugi.dom.schema.integration.rap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Причина изменения постановления
 * 
 * <p>Java class for ChangeReasonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeReasonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Reason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="ChangeBaseDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType" minOccurs="0"/&gt;
 *         &lt;element name="ChangeShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String2000Type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeReasonType", propOrder = {
    "reason",
    "changeBaseDocument",
    "changeShortDescription"
})
public class ChangeReasonType {

    @XmlElement(name = "Reason", required = true)
    protected NsiRef reason;
    @XmlElement(name = "ChangeBaseDocument")
    protected ProceduralDocumentType changeBaseDocument;
    @XmlElement(name = "ChangeShortDescription")
    protected String changeShortDescription;

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
     * Gets the value of the changeBaseDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ProceduralDocumentType }
     *     
     */
    public ProceduralDocumentType getChangeBaseDocument() {
        return changeBaseDocument;
    }

    /**
     * Sets the value of the changeBaseDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProceduralDocumentType }
     *     
     */
    public void setChangeBaseDocument(ProceduralDocumentType value) {
        this.changeBaseDocument = value;
    }

    /**
     * Gets the value of the changeShortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeShortDescription() {
        return changeShortDescription;
    }

    /**
     * Sets the value of the changeShortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeShortDescription(String value) {
        this.changeShortDescription = value;
    }

}
