
package ru.gosuslugi.dom.schema.integration.rap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Причина отмены постановления (экспорт)
 * 
 * <p>Java class for ExportCancelReasonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCancelReasonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="CancelBaseDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType"/>
 *         &lt;element name="CancelShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String2000Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCancelReasonType", propOrder = {
    "reason",
    "cancelBaseDocument",
    "cancelShortDescription"
})
public class ExportCancelReasonType {

    @XmlElement(name = "Reason", required = true)
    protected NsiRef reason;
    @XmlElement(name = "CancelBaseDocument", required = true)
    protected ExportProceduralDocumentType cancelBaseDocument;
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
     *     {@link ExportProceduralDocumentType }
     *     
     */
    public ExportProceduralDocumentType getCancelBaseDocument() {
        return cancelBaseDocument;
    }

    /**
     * Sets the value of the cancelBaseDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportProceduralDocumentType }
     *     
     */
    public void setCancelBaseDocument(ExportProceduralDocumentType value) {
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
