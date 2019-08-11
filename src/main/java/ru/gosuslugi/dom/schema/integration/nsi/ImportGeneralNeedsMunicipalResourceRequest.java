
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


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="TopLevelMunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ParentCode"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                           &lt;enumeration value="1"/&gt;
 *                           &lt;enumeration value="2"/&gt;
 *                           &lt;enumeration value="3"/&gt;
 *                           &lt;enumeration value="8"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ImportGeneralMunicipalResource" maxOccurs="1000" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi/}importGeneralNeedsMunicipalResourceType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="RecoverGeneralMunicipalResource" maxOccurs="1000" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="DeleteGeneralMunicipalResource" maxOccurs="1000" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.2.2.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "topLevelMunicipalResource",
    "recoverGeneralMunicipalResource",
    "deleteGeneralMunicipalResource"
})
@XmlRootElement(name = "importGeneralNeedsMunicipalResourceRequest")
public class ImportGeneralNeedsMunicipalResourceRequest
    extends BaseType
{

    @XmlElement(name = "TopLevelMunicipalResource")
    protected List<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource> topLevelMunicipalResource;
    @XmlElement(name = "RecoverGeneralMunicipalResource")
    protected List<ImportGeneralNeedsMunicipalResourceRequest.RecoverGeneralMunicipalResource> recoverGeneralMunicipalResource;
    @XmlElement(name = "DeleteGeneralMunicipalResource")
    protected List<ImportGeneralNeedsMunicipalResourceRequest.DeleteGeneralMunicipalResource> deleteGeneralMunicipalResource;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the topLevelMunicipalResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topLevelMunicipalResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopLevelMunicipalResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource }
     * 
     * 
     */
    public List<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource> getTopLevelMunicipalResource() {
        if (topLevelMunicipalResource == null) {
            topLevelMunicipalResource = new ArrayList<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource>();
        }
        return this.topLevelMunicipalResource;
    }

    /**
     * Gets the value of the recoverGeneralMunicipalResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recoverGeneralMunicipalResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecoverGeneralMunicipalResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportGeneralNeedsMunicipalResourceRequest.RecoverGeneralMunicipalResource }
     * 
     * 
     */
    public List<ImportGeneralNeedsMunicipalResourceRequest.RecoverGeneralMunicipalResource> getRecoverGeneralMunicipalResource() {
        if (recoverGeneralMunicipalResource == null) {
            recoverGeneralMunicipalResource = new ArrayList<ImportGeneralNeedsMunicipalResourceRequest.RecoverGeneralMunicipalResource>();
        }
        return this.recoverGeneralMunicipalResource;
    }

    /**
     * Gets the value of the deleteGeneralMunicipalResource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deleteGeneralMunicipalResource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeleteGeneralMunicipalResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportGeneralNeedsMunicipalResourceRequest.DeleteGeneralMunicipalResource }
     * 
     * 
     */
    public List<ImportGeneralNeedsMunicipalResourceRequest.DeleteGeneralMunicipalResource> getDeleteGeneralMunicipalResource() {
        if (deleteGeneralMunicipalResource == null) {
            deleteGeneralMunicipalResource = new ArrayList<ImportGeneralNeedsMunicipalResourceRequest.DeleteGeneralMunicipalResource>();
        }
        return this.deleteGeneralMunicipalResource;
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
            return "12.2.2.1";
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
    public static class DeleteGeneralMunicipalResource {

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
    public static class RecoverGeneralMunicipalResource {

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
     *         &lt;element name="ParentCode"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="8"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="ImportGeneralMunicipalResource" maxOccurs="1000" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi/}importGeneralNeedsMunicipalResourceType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "parentCode",
        "transportGUID",
        "importGeneralMunicipalResource"
    })
    public static class TopLevelMunicipalResource {

        @XmlElement(name = "ParentCode")
        protected byte parentCode;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ImportGeneralMunicipalResource")
        protected List<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource.ImportGeneralMunicipalResource> importGeneralMunicipalResource;

        /**
         * Gets the value of the parentCode property.
         * 
         */
        public byte getParentCode() {
            return parentCode;
        }

        /**
         * Sets the value of the parentCode property.
         * 
         */
        public void setParentCode(byte value) {
            this.parentCode = value;
        }

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
         * Gets the value of the importGeneralMunicipalResource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the importGeneralMunicipalResource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImportGeneralMunicipalResource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource.ImportGeneralMunicipalResource }
         * 
         * 
         */
        public List<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource.ImportGeneralMunicipalResource> getImportGeneralMunicipalResource() {
            if (importGeneralMunicipalResource == null) {
                importGeneralMunicipalResource = new ArrayList<ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource.ImportGeneralMunicipalResource>();
            }
            return this.importGeneralMunicipalResource;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi/}importGeneralNeedsMunicipalResourceType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ImportGeneralMunicipalResource
            extends ImportGeneralNeedsMunicipalResourceType
        {


        }

    }

}
