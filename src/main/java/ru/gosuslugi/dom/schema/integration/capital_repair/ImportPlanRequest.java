
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="importPlan">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="PlanGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="LoadPlan" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}PlanPassportType" minOccurs="0"/>
 *                   &lt;element name="PlanDocument" maxOccurs="1000" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="DeletePlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="PublishPlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="CancelPlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importPlan"
})
@XmlRootElement(name = "importPlanRequest")
public class ImportPlanRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected ImportPlanRequest.ImportPlan importPlan;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ImportPlanRequest.ImportPlan }
     *     
     */
    public ImportPlanRequest.ImportPlan getImportPlan() {
        return importPlan;
    }

    /**
     * Sets the value of the importPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportPlanRequest.ImportPlan }
     *     
     */
    public void setImportPlan(ImportPlanRequest.ImportPlan value) {
        this.importPlan = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "11.2.0.10";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="PlanGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="LoadPlan" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}PlanPassportType" minOccurs="0"/>
     *         &lt;element name="PlanDocument" maxOccurs="1000" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;choice minOccurs="0">
     *           &lt;element name="DeletePlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="PublishPlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="CancelPlan" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transportGuid",
        "planGuid",
        "loadPlan",
        "planDocument",
        "deletePlan",
        "publishPlan",
        "cancelPlan"
    })
    public static class ImportPlan {

        @XmlElement(name = "TransportGuid")
        protected String transportGuid;
        @XmlElement(name = "PlanGuid")
        protected String planGuid;
        @XmlElement(name = "LoadPlan")
        protected PlanPassportType loadPlan;
        @XmlElement(name = "PlanDocument")
        protected List<ImportPlanRequest.ImportPlan.PlanDocument> planDocument;
        @XmlElement(name = "DeletePlan")
        protected Boolean deletePlan;
        @XmlElement(name = "PublishPlan")
        protected Boolean publishPlan;
        @XmlElement(name = "CancelPlan")
        protected Boolean cancelPlan;

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
         * Gets the value of the planGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlanGuid() {
            return planGuid;
        }

        /**
         * Sets the value of the planGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlanGuid(String value) {
            this.planGuid = value;
        }

        /**
         * Gets the value of the loadPlan property.
         * 
         * @return
         *     possible object is
         *     {@link PlanPassportType }
         *     
         */
        public PlanPassportType getLoadPlan() {
            return loadPlan;
        }

        /**
         * Sets the value of the loadPlan property.
         * 
         * @param value
         *     allowed object is
         *     {@link PlanPassportType }
         *     
         */
        public void setLoadPlan(PlanPassportType value) {
            this.loadPlan = value;
        }

        /**
         * Gets the value of the planDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the planDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlanDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportPlanRequest.ImportPlan.PlanDocument }
         * 
         * 
         */
        public List<ImportPlanRequest.ImportPlan.PlanDocument> getPlanDocument() {
            if (planDocument == null) {
                planDocument = new ArrayList<ImportPlanRequest.ImportPlan.PlanDocument>();
            }
            return this.planDocument;
        }

        /**
         * Gets the value of the deletePlan property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeletePlan() {
            return deletePlan;
        }

        /**
         * Sets the value of the deletePlan property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeletePlan(Boolean value) {
            this.deletePlan = value;
        }

        /**
         * Gets the value of the publishPlan property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPublishPlan() {
            return publishPlan;
        }

        /**
         * Sets the value of the publishPlan property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPublishPlan(Boolean value) {
            this.publishPlan = value;
        }

        /**
         * Gets the value of the cancelPlan property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelPlan() {
            return cancelPlan;
        }

        /**
         * Sets the value of the cancelPlan property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelPlan(Boolean value) {
            this.cancelPlan = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class PlanDocument
            extends ImportDocumentType
        {


        }

    }

}
