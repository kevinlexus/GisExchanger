
package ru.gosuslugi.dom.schema.integration.rap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Причина изменения постановления (экспорт)
 * 
 * <p>Java class for ExportChangeReasonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportChangeReasonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="ChangeBaseDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType" minOccurs="0"/>
 *         &lt;element name="ChangeShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String2000Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportChangeReasonType", propOrder = {
    "reason",
    "changeBaseDocument",
    "changeShortDescription"
})
public class ExportChangeReasonType {

    @XmlElement(name = "Reason", required = true)
    protected NsiRef reason;
    @XmlElement(name = "ChangeBaseDocument")
    protected ExportProceduralDocumentType changeBaseDocument;
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
     *     {@link ExportProceduralDocumentType }
     *     
     */
    public ExportProceduralDocumentType getChangeBaseDocument() {
        return changeBaseDocument;
    }

    /**
     * Sets the value of the changeBaseDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportProceduralDocumentType }
     *     
     */
    public void setChangeBaseDocument(ExportProceduralDocumentType value) {
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
