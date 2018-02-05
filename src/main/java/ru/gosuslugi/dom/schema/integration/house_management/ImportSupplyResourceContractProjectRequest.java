
package ru.gosuslugi.dom.schema.integration.house_management;

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
 *         &lt;element name="Contract" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;choice minOccurs="0">
 *                       &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                       &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;/choice>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="ContractProject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}SupplyResourceContractProjectType"/>
 *                     &lt;element name="DeleteContractProject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="PlacingContractProject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.7.0.3""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contract"
})
@XmlRootElement(name = "importSupplyResourceContractProjectRequest")
public class ImportSupplyResourceContractProjectRequest
    extends BaseType
{

    @XmlElement(name = "Contract", required = true)
    protected List<ImportSupplyResourceContractProjectRequest.Contract> contract;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportSupplyResourceContractProjectRequest.Contract }
     * 
     * 
     */
    public List<ImportSupplyResourceContractProjectRequest.Contract> getContract() {
        if (contract == null) {
            contract = new ArrayList<ImportSupplyResourceContractProjectRequest.Contract>();
        }
        return this.contract;
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
            return "11.7.0.3";
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
     *         &lt;sequence>
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *           &lt;choice minOccurs="0">
     *             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *             &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;/choice>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="ContractProject" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}SupplyResourceContractProjectType"/>
     *           &lt;element name="DeleteContractProject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="PlacingContractProject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "transportGUID",
        "contractGUID",
        "contractRootGUID",
        "contractProject",
        "deleteContractProject",
        "placingContractProject"
    })
    public static class Contract {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ContractGUID")
        protected String contractGUID;
        @XmlElement(name = "ContractRootGUID")
        protected String contractRootGUID;
        @XmlElement(name = "ContractProject")
        protected SupplyResourceContractProjectType contractProject;
        @XmlElement(name = "DeleteContractProject")
        protected Boolean deleteContractProject;
        @XmlElement(name = "PlacingContractProject")
        protected Boolean placingContractProject;

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
        }

        /**
         * Gets the value of the contractGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractGUID() {
            return contractGUID;
        }

        /**
         * Sets the value of the contractGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractGUID(String value) {
            this.contractGUID = value;
        }

        /**
         * Gets the value of the contractRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractRootGUID() {
            return contractRootGUID;
        }

        /**
         * Sets the value of the contractRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractRootGUID(String value) {
            this.contractRootGUID = value;
        }

        /**
         * Gets the value of the contractProject property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractProjectType }
         *     
         */
        public SupplyResourceContractProjectType getContractProject() {
            return contractProject;
        }

        /**
         * Sets the value of the contractProject property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractProjectType }
         *     
         */
        public void setContractProject(SupplyResourceContractProjectType value) {
            this.contractProject = value;
        }

        /**
         * Gets the value of the deleteContractProject property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeleteContractProject() {
            return deleteContractProject;
        }

        /**
         * Sets the value of the deleteContractProject property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeleteContractProject(Boolean value) {
            this.deleteContractProject = value;
        }

        /**
         * Gets the value of the placingContractProject property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPlacingContractProject() {
            return placingContractProject;
        }

        /**
         * Sets the value of the placingContractProject property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPlacingContractProject(Boolean value) {
            this.placingContractProject = value;
        }

    }

}
