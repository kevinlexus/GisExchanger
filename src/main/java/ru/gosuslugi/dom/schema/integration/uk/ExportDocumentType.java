
package ru.gosuslugi.dom.schema.integration.uk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемый документ
 * 
 * <p>Java class for exportDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocumentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="DocumentFederal" type="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentFederalExportType"/&gt;
 *           &lt;element name="DocumentRegion" type="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentRegionExportType"/&gt;
 *           &lt;element name="DocumentMunicipal" type="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentMunicipalExportType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportDocumentType", propOrder = {
    "documentGuid",
    "documentFederal",
    "documentRegion",
    "documentMunicipal"
})
public class ExportDocumentType {

    @XmlElement(name = "DocumentGuid", required = true)
    protected String documentGuid;
    @XmlElement(name = "DocumentFederal")
    protected DocumentFederalExportType documentFederal;
    @XmlElement(name = "DocumentRegion")
    protected DocumentRegionExportType documentRegion;
    @XmlElement(name = "DocumentMunicipal")
    protected DocumentMunicipalExportType documentMunicipal;

    /**
     * Gets the value of the documentGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentGuid() {
        return documentGuid;
    }

    /**
     * Sets the value of the documentGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentGuid(String value) {
        this.documentGuid = value;
    }

    /**
     * Gets the value of the documentFederal property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentFederalExportType }
     *     
     */
    public DocumentFederalExportType getDocumentFederal() {
        return documentFederal;
    }

    /**
     * Sets the value of the documentFederal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentFederalExportType }
     *     
     */
    public void setDocumentFederal(DocumentFederalExportType value) {
        this.documentFederal = value;
    }

    /**
     * Gets the value of the documentRegion property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentRegionExportType }
     *     
     */
    public DocumentRegionExportType getDocumentRegion() {
        return documentRegion;
    }

    /**
     * Sets the value of the documentRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentRegionExportType }
     *     
     */
    public void setDocumentRegion(DocumentRegionExportType value) {
        this.documentRegion = value;
    }

    /**
     * Gets the value of the documentMunicipal property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentMunicipalExportType }
     *     
     */
    public DocumentMunicipalExportType getDocumentMunicipal() {
        return documentMunicipal;
    }

    /**
     * Sets the value of the documentMunicipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentMunicipalExportType }
     *     
     */
    public void setDocumentMunicipal(DocumentMunicipalExportType value) {
        this.documentMunicipal = value;
    }

}
