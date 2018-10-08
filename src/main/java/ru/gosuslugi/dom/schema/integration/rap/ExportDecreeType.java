
package ru.gosuslugi.dom.schema.integration.rap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Экспортируемое постановление и процессуальные документы
 * 
 * <p>Java class for ExportDecreeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportDecreeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DecreeGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="RegistryNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ControlOrganization"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DecreeInfo" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportDecreeInfoType"/&gt;
 *         &lt;element name="ProceduralDocuments" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ProceduralDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeStatusType"/&gt;
 *         &lt;element name="ChangeReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportChangeReasonType" minOccurs="0"/&gt;
 *         &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportCancelReasonType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportDecreeType", propOrder = {
    "decreeGUID",
    "registryNumber",
    "controlOrganization",
    "decreeInfo",
    "proceduralDocuments",
    "status",
    "changeReason",
    "cancelReason"
})
public class ExportDecreeType {

    @XmlElement(name = "DecreeGUID", required = true)
    protected String decreeGUID;
    @XmlElement(name = "RegistryNumber")
    protected String registryNumber;
    @XmlElement(name = "ControlOrganization", required = true)
    protected ExportDecreeType.ControlOrganization controlOrganization;
    @XmlElement(name = "DecreeInfo", required = true)
    protected ExportDecreeInfoType decreeInfo;
    @XmlElement(name = "ProceduralDocuments")
    protected List<ExportDecreeType.ProceduralDocuments> proceduralDocuments;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected DecreeStatusType status;
    @XmlElement(name = "ChangeReason")
    protected ExportChangeReasonType changeReason;
    @XmlElement(name = "CancelReason")
    protected ExportCancelReasonType cancelReason;

    /**
     * Gets the value of the decreeGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecreeGUID() {
        return decreeGUID;
    }

    /**
     * Sets the value of the decreeGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecreeGUID(String value) {
        this.decreeGUID = value;
    }

    /**
     * Gets the value of the registryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistryNumber() {
        return registryNumber;
    }

    /**
     * Sets the value of the registryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistryNumber(String value) {
        this.registryNumber = value;
    }

    /**
     * Gets the value of the controlOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDecreeType.ControlOrganization }
     *     
     */
    public ExportDecreeType.ControlOrganization getControlOrganization() {
        return controlOrganization;
    }

    /**
     * Sets the value of the controlOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDecreeType.ControlOrganization }
     *     
     */
    public void setControlOrganization(ExportDecreeType.ControlOrganization value) {
        this.controlOrganization = value;
    }

    /**
     * Gets the value of the decreeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDecreeInfoType }
     *     
     */
    public ExportDecreeInfoType getDecreeInfo() {
        return decreeInfo;
    }

    /**
     * Sets the value of the decreeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDecreeInfoType }
     *     
     */
    public void setDecreeInfo(ExportDecreeInfoType value) {
        this.decreeInfo = value;
    }

    /**
     * Gets the value of the proceduralDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proceduralDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProceduralDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDecreeType.ProceduralDocuments }
     * 
     * 
     */
    public List<ExportDecreeType.ProceduralDocuments> getProceduralDocuments() {
        if (proceduralDocuments == null) {
            proceduralDocuments = new ArrayList<ExportDecreeType.ProceduralDocuments>();
        }
        return this.proceduralDocuments;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link DecreeStatusType }
     *     
     */
    public DecreeStatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecreeStatusType }
     *     
     */
    public void setStatus(DecreeStatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the changeReason property.
     * 
     * @return
     *     possible object is
     *     {@link ExportChangeReasonType }
     *     
     */
    public ExportChangeReasonType getChangeReason() {
        return changeReason;
    }

    /**
     * Sets the value of the changeReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportChangeReasonType }
     *     
     */
    public void setChangeReason(ExportChangeReasonType value) {
        this.changeReason = value;
    }

    /**
     * Gets the value of the cancelReason property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCancelReasonType }
     *     
     */
    public ExportCancelReasonType getCancelReason() {
        return cancelReason;
    }

    /**
     * Sets the value of the cancelReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCancelReasonType }
     *     
     */
    public void setCancelReason(ExportCancelReasonType value) {
        this.cancelReason = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ControlOrganization
        extends RegOrgType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ProceduralDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "proceduralDocumentGUID"
    })
    public static class ProceduralDocuments
        extends ExportProceduralDocumentType
    {

        @XmlElement(name = "ProceduralDocumentGUID", required = true)
        protected String proceduralDocumentGUID;

        /**
         * Gets the value of the proceduralDocumentGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProceduralDocumentGUID() {
            return proceduralDocumentGUID;
        }

        /**
         * Sets the value of the proceduralDocumentGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProceduralDocumentGUID(String value) {
            this.proceduralDocumentGUID = value;
        }

    }

}
