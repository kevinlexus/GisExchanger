
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Импортируемый документ программы (плана)
 * 
 * <p>Java class for ImportDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="DocumentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LoadDocument"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentType"&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="DeleteDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
@XmlType(name = "ImportDocumentType", propOrder = {
    "transportGuid",
    "documentGuid",
    "loadDocument",
    "deleteDocument"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportPlanRequest.ImportPlan.PlanDocument.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportRegionalProgramRequest.ImportRegionalProgram.RegionalProgramDocument.class
})
public class ImportDocumentType {

    @XmlElement(name = "TransportGuid", required = true)
    protected String transportGuid;
    @XmlElement(name = "DocumentGuid")
    protected String documentGuid;
    @XmlElement(name = "LoadDocument")
    protected ImportDocumentType.LoadDocument loadDocument;
    @XmlElement(name = "DeleteDocument")
    protected Boolean deleteDocument;

    /**
     * Gets the value of the transportGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportGuid() {
        return transportGuid;
    }

    /**
     * Sets the value of the transportGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportGuid(String value) {
        this.transportGuid = value;
    }

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
     * Gets the value of the loadDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ImportDocumentType.LoadDocument }
     *     
     */
    public ImportDocumentType.LoadDocument getLoadDocument() {
        return loadDocument;
    }

    /**
     * Sets the value of the loadDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportDocumentType.LoadDocument }
     *     
     */
    public void setLoadDocument(ImportDocumentType.LoadDocument value) {
        this.loadDocument = value;
    }

    /**
     * Gets the value of the deleteDocument property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeleteDocument() {
        return deleteDocument;
    }

    /**
     * Sets the value of the deleteDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteDocument(Boolean value) {
        this.deleteDocument = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LoadDocument
        extends DocumentType
    {


    }

}
