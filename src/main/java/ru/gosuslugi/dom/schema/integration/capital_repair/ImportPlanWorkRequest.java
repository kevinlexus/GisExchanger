
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PlanGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="importPlanWork" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="WorkGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadPlanWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkPlanType"/&gt;
 *                     &lt;element name="DeletePlanWork" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "planGUID",
    "importPlanWork"
})
@XmlRootElement(name = "importPlanWorkRequest")
public class ImportPlanWorkRequest
    extends BaseType
{

    @XmlElement(name = "PlanGUID", required = true)
    protected String planGUID;
    @XmlElement(required = true)
    protected List<ImportPlanWorkRequest.ImportPlanWork> importPlanWork;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the planGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGUID() {
        return planGUID;
    }

    /**
     * Sets the value of the planGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGUID(String value) {
        this.planGUID = value;
    }

    /**
     * Gets the value of the importPlanWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importPlanWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportPlanWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPlanWorkRequest.ImportPlanWork }
     * 
     * 
     */
    public List<ImportPlanWorkRequest.ImportPlanWork> getImportPlanWork() {
        if (importPlanWork == null) {
            importPlanWork = new ArrayList<ImportPlanWorkRequest.ImportPlanWork>();
        }
        return this.importPlanWork;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="WorkGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadPlanWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkPlanType"/&gt;
     *           &lt;element name="DeletePlanWork" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    @XmlType(name = "", propOrder = {
        "transportGuid",
        "workGuid",
        "loadPlanWork",
        "deletePlanWork"
    })
    public static class ImportPlanWork {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "WorkGuid")
        protected String workGuid;
        @XmlElement(name = "LoadPlanWork")
        protected WorkPlanType loadPlanWork;
        @XmlElement(name = "DeletePlanWork")
        protected Boolean deletePlanWork;

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
         * Gets the value of the workGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkGuid() {
            return workGuid;
        }

        /**
         * Sets the value of the workGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkGuid(String value) {
            this.workGuid = value;
        }

        /**
         * Gets the value of the loadPlanWork property.
         * 
         * @return
         *     possible object is
         *     {@link WorkPlanType }
         *     
         */
        public WorkPlanType getLoadPlanWork() {
            return loadPlanWork;
        }

        /**
         * Sets the value of the loadPlanWork property.
         * 
         * @param value
         *     allowed object is
         *     {@link WorkPlanType }
         *     
         */
        public void setLoadPlanWork(WorkPlanType value) {
            this.loadPlanWork = value;
        }

        /**
         * Gets the value of the deletePlanWork property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeletePlanWork() {
            return deletePlanWork;
        }

        /**
         * Sets the value of the deletePlanWork property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeletePlanWork(Boolean value) {
            this.deletePlanWork = value;
        }

    }

}
