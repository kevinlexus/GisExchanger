
package ru.gosuslugi.dom.schema.integration.nsi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


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
 *         &lt;element name="ImportMainMunicipalService" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="MunicipalServiceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="GeneralNeeds" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="SelfProduced" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="MainMunicipalServiceName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/&gt;
 *                   &lt;element name="MunicipalResourceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="SortOrder"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="3"/&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="SortOrderNotDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RecoverMainMunicipalService" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="HierarchyRecover" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DeleteMainMunicipalService" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.4""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importMainMunicipalService",
    "recoverMainMunicipalService",
    "deleteMainMunicipalService"
})
@XmlRootElement(name = "importMunicipalServicesRequest")
public class ImportMunicipalServicesRequest
    extends BaseType
{

    @XmlElement(name = "ImportMainMunicipalService")
    protected List<ImportMunicipalServicesRequest.ImportMainMunicipalService> importMainMunicipalService;
    @XmlElement(name = "RecoverMainMunicipalService")
    protected List<ImportMunicipalServicesRequest.RecoverMainMunicipalService> recoverMainMunicipalService;
    @XmlElement(name = "DeleteMainMunicipalService")
    protected List<ImportMunicipalServicesRequest.DeleteMainMunicipalService> deleteMainMunicipalService;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importMainMunicipalService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importMainMunicipalService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportMainMunicipalService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMunicipalServicesRequest.ImportMainMunicipalService }
     * 
     * 
     */
    public List<ImportMunicipalServicesRequest.ImportMainMunicipalService> getImportMainMunicipalService() {
        if (importMainMunicipalService == null) {
            importMainMunicipalService = new ArrayList<ImportMunicipalServicesRequest.ImportMainMunicipalService>();
        }
        return this.importMainMunicipalService;
    }

    /**
     * Gets the value of the recoverMainMunicipalService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recoverMainMunicipalService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecoverMainMunicipalService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMunicipalServicesRequest.RecoverMainMunicipalService }
     * 
     * 
     */
    public List<ImportMunicipalServicesRequest.RecoverMainMunicipalService> getRecoverMainMunicipalService() {
        if (recoverMainMunicipalService == null) {
            recoverMainMunicipalService = new ArrayList<ImportMunicipalServicesRequest.RecoverMainMunicipalService>();
        }
        return this.recoverMainMunicipalService;
    }

    /**
     * Gets the value of the deleteMainMunicipalService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deleteMainMunicipalService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeleteMainMunicipalService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMunicipalServicesRequest.DeleteMainMunicipalService }
     * 
     * 
     */
    public List<ImportMunicipalServicesRequest.DeleteMainMunicipalService> getDeleteMainMunicipalService() {
        if (deleteMainMunicipalService == null) {
            deleteMainMunicipalService = new ArrayList<ImportMunicipalServicesRequest.DeleteMainMunicipalService>();
        }
        return this.deleteMainMunicipalService;
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
            return "11.0.0.4";
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "transportGUID",
        "elementGuid"
    })
    public static class DeleteMainMunicipalService {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ElementGuid", required = true)
        protected String elementGuid;

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
         * Gets the value of the elementGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getElementGuid() {
            return elementGuid;
        }

        /**
         * Sets the value of the elementGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setElementGuid(String value) {
            this.elementGuid = value;
        }

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
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *           &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="MunicipalServiceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="GeneralNeeds" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="SelfProduced" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="MainMunicipalServiceName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"/&gt;
     *         &lt;element name="MunicipalResourceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="SortOrder"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;maxLength value="3"/&gt;
     *                 &lt;minLength value="1"/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="SortOrderNotDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "transportGUID",
        "elementGuid",
        "municipalServiceRef",
        "generalNeeds",
        "selfProduced",
        "mainMunicipalServiceName",
        "municipalResourceRef",
        "okei",
        "sortOrder",
        "sortOrderNotDefined"
    })
    public static class ImportMainMunicipalService {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ElementGuid")
        protected String elementGuid;
        @XmlElement(name = "MunicipalServiceRef", required = true)
        protected NsiRef municipalServiceRef;
        @XmlElement(name = "GeneralNeeds")
        protected Boolean generalNeeds;
        @XmlElement(name = "SelfProduced")
        protected Boolean selfProduced;
        @XmlElement(name = "MainMunicipalServiceName", required = true)
        protected String mainMunicipalServiceName;
        @XmlElement(name = "MunicipalResourceRef", required = true)
        protected NsiRef municipalResourceRef;
        @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected String okei;
        @XmlElement(name = "SortOrder")
        protected String sortOrder;
        @XmlElement(name = "SortOrderNotDefined")
        protected Boolean sortOrderNotDefined;

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
         * Gets the value of the elementGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getElementGuid() {
            return elementGuid;
        }

        /**
         * Sets the value of the elementGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setElementGuid(String value) {
            this.elementGuid = value;
        }

        /**
         * Gets the value of the municipalServiceRef property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getMunicipalServiceRef() {
            return municipalServiceRef;
        }

        /**
         * Sets the value of the municipalServiceRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setMunicipalServiceRef(NsiRef value) {
            this.municipalServiceRef = value;
        }

        /**
         * Gets the value of the generalNeeds property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isGeneralNeeds() {
            return generalNeeds;
        }

        /**
         * Sets the value of the generalNeeds property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setGeneralNeeds(Boolean value) {
            this.generalNeeds = value;
        }

        /**
         * Gets the value of the selfProduced property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSelfProduced() {
            return selfProduced;
        }

        /**
         * Sets the value of the selfProduced property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSelfProduced(Boolean value) {
            this.selfProduced = value;
        }

        /**
         * Gets the value of the mainMunicipalServiceName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMainMunicipalServiceName() {
            return mainMunicipalServiceName;
        }

        /**
         * Sets the value of the mainMunicipalServiceName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMainMunicipalServiceName(String value) {
            this.mainMunicipalServiceName = value;
        }

        /**
         * Gets the value of the municipalResourceRef property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getMunicipalResourceRef() {
            return municipalResourceRef;
        }

        /**
         * Sets the value of the municipalResourceRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setMunicipalResourceRef(NsiRef value) {
            this.municipalResourceRef = value;
        }

        /**
         * (не используется)
         * Единница измерения из справочника ОКЕИ.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOKEI() {
            return okei;
        }

        /**
         * Sets the value of the okei property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOKEI(String value) {
            this.okei = value;
        }

        /**
         * Gets the value of the sortOrder property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSortOrder() {
            return sortOrder;
        }

        /**
         * Sets the value of the sortOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSortOrder(String value) {
            this.sortOrder = value;
        }

        /**
         * Gets the value of the sortOrderNotDefined property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSortOrderNotDefined() {
            return sortOrderNotDefined;
        }

        /**
         * Sets the value of the sortOrderNotDefined property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSortOrderNotDefined(Boolean value) {
            this.sortOrderNotDefined = value;
        }

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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="HierarchyRecover" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "transportGUID",
        "elementGuid",
        "hierarchyRecover"
    })
    public static class RecoverMainMunicipalService {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ElementGuid", required = true)
        protected String elementGuid;
        @XmlElement(name = "HierarchyRecover")
        protected Boolean hierarchyRecover;

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
         * Gets the value of the elementGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getElementGuid() {
            return elementGuid;
        }

        /**
         * Sets the value of the elementGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setElementGuid(String value) {
            this.elementGuid = value;
        }

        /**
         * Gets the value of the hierarchyRecover property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHierarchyRecover() {
            return hierarchyRecover;
        }

        /**
         * Sets the value of the hierarchyRecover property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHierarchyRecover(Boolean value) {
            this.hierarchyRecover = value;
        }

    }

}
