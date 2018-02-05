
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
 *         &lt;element name="RegionalProgramGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="importRegionalProgramWork" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="WorkGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;element name="LoadRegionalProgramWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramWorkType"/>
 *                     &lt;element name="DeleteRegionalProgramWork" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "regionalProgramGuid",
    "importRegionalProgramWork"
})
@XmlRootElement(name = "importRegionalProgramWorkRequest")
public class ImportRegionalProgramWorkRequest
    extends BaseType
{

    @XmlElement(name = "RegionalProgramGuid", required = true)
    protected String regionalProgramGuid;
    @XmlElement(required = true)
    protected List<ImportRegionalProgramWorkRequest.ImportRegionalProgramWork> importRegionalProgramWork;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the regionalProgramGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalProgramGuid() {
        return regionalProgramGuid;
    }

    /**
     * Sets the value of the regionalProgramGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalProgramGuid(String value) {
        this.regionalProgramGuid = value;
    }

    /**
     * Gets the value of the importRegionalProgramWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importRegionalProgramWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportRegionalProgramWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportRegionalProgramWorkRequest.ImportRegionalProgramWork }
     * 
     * 
     */
    public List<ImportRegionalProgramWorkRequest.ImportRegionalProgramWork> getImportRegionalProgramWork() {
        if (importRegionalProgramWork == null) {
            importRegionalProgramWork = new ArrayList<ImportRegionalProgramWorkRequest.ImportRegionalProgramWork>();
        }
        return this.importRegionalProgramWork;
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
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="WorkGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="LoadRegionalProgramWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramWorkType"/>
     *           &lt;element name="DeleteRegionalProgramWork" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "workGuid",
        "loadRegionalProgramWork",
        "deleteRegionalProgramWork"
    })
    public static class ImportRegionalProgramWork {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "WorkGuid")
        protected String workGuid;
        @XmlElement(name = "LoadRegionalProgramWork")
        protected RegionalProgramWorkType loadRegionalProgramWork;
        @XmlElement(name = "DeleteRegionalProgramWork")
        protected Boolean deleteRegionalProgramWork;

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
         * Gets the value of the loadRegionalProgramWork property.
         * 
         * @return
         *     possible object is
         *     {@link RegionalProgramWorkType }
         *     
         */
        public RegionalProgramWorkType getLoadRegionalProgramWork() {
            return loadRegionalProgramWork;
        }

        /**
         * Sets the value of the loadRegionalProgramWork property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegionalProgramWorkType }
         *     
         */
        public void setLoadRegionalProgramWork(RegionalProgramWorkType value) {
            this.loadRegionalProgramWork = value;
        }

        /**
         * Gets the value of the deleteRegionalProgramWork property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeleteRegionalProgramWork() {
            return deleteRegionalProgramWork;
        }

        /**
         * Sets the value of the deleteRegionalProgramWork property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeleteRegionalProgramWork(Boolean value) {
            this.deleteRegionalProgramWork = value;
        }

    }

}
