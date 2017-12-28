
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *           &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;/choice>
 *         &lt;element name="ObjectAddress" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                     &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;element name="LoadObject">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType">
 *                             &lt;sequence>
 *                               &lt;element name="Pair" maxOccurs="100">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType">
 *                                       &lt;sequence>
 *                                         &lt;element name="HeatingSystemType" minOccurs="0">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="OpenOrNot">
 *                                                     &lt;simpleType>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                         &lt;enumeration value="Opened"/>
 *                                                         &lt;enumeration value="Closed"/>
 *                                                       &lt;/restriction>
 *                                                     &lt;/simpleType>
 *                                                   &lt;/element>
 *                                                   &lt;element name="CentralizedOrNot">
 *                                                     &lt;simpleType>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                         &lt;enumeration value="Centralized"/>
 *                                                         &lt;enumeration value="Decentralized"/>
 *                                                       &lt;/restriction>
 *                                                     &lt;/simpleType>
 *                                                   &lt;/element>
 *                                                 &lt;/sequence>
 *                                               &lt;/restriction>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                                         &lt;element name="IndicatorValue">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
 *                                               &lt;/extension>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
 *                                         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                         &lt;element name="FlowLineTemperature">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                               &lt;minExclusive value="0"/>
 *                                               &lt;fractionDigits value="1"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/element>
 *                                         &lt;element name="OppositeLineTemperature">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                               &lt;minExclusive value="0"/>
 *                                               &lt;fractionDigits value="1"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/element>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="DeleteObject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "contractGUID",
    "contractRootGUID",
    "objectAddress"
})
@XmlRootElement(name = "importSupplyResourceContractObjectAddressRequest")
public class ImportSupplyResourceContractObjectAddressRequest
    extends BaseType
{

    @XmlElement(name = "ContractGUID")
    protected String contractGUID;
    @XmlElement(name = "ContractRootGUID")
    protected String contractRootGUID;
    @XmlElement(name = "ObjectAddress", required = true)
    protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress> objectAddress;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

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
     * Gets the value of the objectAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress }
     * 
     * 
     */
    public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress> getObjectAddress() {
        if (objectAddress == null) {
            objectAddress = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress>();
        }
        return this.objectAddress;
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
     *           &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;element name="LoadObject">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType">
     *                   &lt;sequence>
     *                     &lt;element name="Pair" maxOccurs="100">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType">
     *                             &lt;sequence>
     *                               &lt;element name="HeatingSystemType" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                       &lt;sequence>
     *                                         &lt;element name="OpenOrNot">
     *                                           &lt;simpleType>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                               &lt;enumeration value="Opened"/>
     *                                               &lt;enumeration value="Closed"/>
     *                                             &lt;/restriction>
     *                                           &lt;/simpleType>
     *                                         &lt;/element>
     *                                         &lt;element name="CentralizedOrNot">
     *                                           &lt;simpleType>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                               &lt;enumeration value="Centralized"/>
     *                                               &lt;enumeration value="Decentralized"/>
     *                                             &lt;/restriction>
     *                                           &lt;/simpleType>
     *                                         &lt;/element>
     *                                       &lt;/sequence>
     *                                     &lt;/restriction>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                               &lt;element name="IndicatorValue">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
     *                                     &lt;/extension>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
     *                               &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                               &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                               &lt;element name="FlowLineTemperature">
     *                                 &lt;simpleType>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                     &lt;minExclusive value="0"/>
     *                                     &lt;fractionDigits value="1"/>
     *                                   &lt;/restriction>
     *                                 &lt;/simpleType>
     *                               &lt;/element>
     *                               &lt;element name="OppositeLineTemperature">
     *                                 &lt;simpleType>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                     &lt;minExclusive value="0"/>
     *                                     &lt;fractionDigits value="1"/>
     *                                   &lt;/restriction>
     *                                 &lt;/simpleType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="DeleteObject" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "objectGUID",
        "loadObject",
        "deleteObject"
    })
    public static class ObjectAddress {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ObjectGUID")
        protected String objectGUID;
        @XmlElement(name = "LoadObject")
        protected ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject loadObject;
        @XmlElement(name = "DeleteObject")
        protected Boolean deleteObject;

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
         * Gets the value of the objectGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectGUID() {
            return objectGUID;
        }

        /**
         * Sets the value of the objectGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectGUID(String value) {
            this.objectGUID = value;
        }

        /**
         * Gets the value of the loadObject property.
         * 
         * @return
         *     possible object is
         *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject }
         *     
         */
        public ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject getLoadObject() {
            return loadObject;
        }

        /**
         * Sets the value of the loadObject property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject }
         *     
         */
        public void setLoadObject(ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject value) {
            this.loadObject = value;
        }

        /**
         * Gets the value of the deleteObject property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeleteObject() {
            return deleteObject;
        }

        /**
         * Sets the value of the deleteObject property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeleteObject(Boolean value) {
            this.deleteObject = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType">
         *       &lt;sequence>
         *         &lt;element name="Pair" maxOccurs="100">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType">
         *                 &lt;sequence>
         *                   &lt;element name="HeatingSystemType" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="OpenOrNot">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;enumeration value="Opened"/>
         *                                   &lt;enumeration value="Closed"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="CentralizedOrNot">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;enumeration value="Centralized"/>
         *                                   &lt;enumeration value="Decentralized"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *                   &lt;element name="IndicatorValue">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
         *                         &lt;/extension>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
         *                   &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="FlowLineTemperature">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                         &lt;minExclusive value="0"/>
         *                         &lt;fractionDigits value="1"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="OppositeLineTemperature">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                         &lt;minExclusive value="0"/>
         *                         &lt;fractionDigits value="1"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pair",
            "quality",
            "otherQualityIndicator",
            "temperatureChart"
        })
        public static class LoadObject
            extends ObjectAddressType
        {

            @XmlElement(name = "Pair", required = true)
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair> pair;
            @XmlElement(name = "Quality")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality> quality;
            @XmlElement(name = "OtherQualityIndicator")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.OtherQualityIndicator> otherQualityIndicator;
            @XmlElement(name = "TemperatureChart")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.TemperatureChart> temperatureChart;

            /**
             * Gets the value of the pair property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the pair property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPair().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair> getPair() {
                if (pair == null) {
                    pair = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair>();
                }
                return this.pair;
            }

            /**
             * Gets the value of the quality property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the quality property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getQuality().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality> getQuality() {
                if (quality == null) {
                    quality = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality>();
                }
                return this.quality;
            }

            /**
             * Gets the value of the otherQualityIndicator property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the otherQualityIndicator property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOtherQualityIndicator().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.OtherQualityIndicator }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.OtherQualityIndicator> getOtherQualityIndicator() {
                if (otherQualityIndicator == null) {
                    otherQualityIndicator = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.OtherQualityIndicator>();
                }
                return this.otherQualityIndicator;
            }

            /**
             * Gets the value of the temperatureChart property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the temperatureChart property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTemperatureChart().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.TemperatureChart }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.TemperatureChart> getTemperatureChart() {
                if (temperatureChart == null) {
                    temperatureChart = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.TemperatureChart>();
                }
                return this.temperatureChart;
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
             *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
             *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
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
                "pairKey",
                "indicatorName",
                "number",
                "okei"
            })
            public static class OtherQualityIndicator {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "IndicatorName", required = true)
                protected String indicatorName;
                @XmlElement(name = "Number", required = true)
                protected BigDecimal number;
                @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String okei;

                /**
                 * Gets the value of the pairKey property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPairKey() {
                    return pairKey;
                }

                /**
                 * Sets the value of the pairKey property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPairKey(String value) {
                    this.pairKey = value;
                }

                /**
                 * Gets the value of the indicatorName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIndicatorName() {
                    return indicatorName;
                }

                /**
                 * Sets the value of the indicatorName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIndicatorName(String value) {
                    this.indicatorName = value;
                }

                /**
                 * Gets the value of the number property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNumber() {
                    return number;
                }

                /**
                 * Sets the value of the number property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNumber(BigDecimal value) {
                    this.number = value;
                }

                /**
                 * Gets the value of the okei property.
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

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType">
             *       &lt;sequence>
             *         &lt;element name="HeatingSystemType" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="OpenOrNot">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;enumeration value="Opened"/>
             *                         &lt;enumeration value="Closed"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="CentralizedOrNot">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;enumeration value="Centralized"/>
             *                         &lt;enumeration value="Decentralized"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
             *       &lt;/sequence>
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "heatingSystemType",
                "transportGUID"
            })
            public static class Pair
                extends ContractSubjectObjectAdressType
            {

                @XmlElement(name = "HeatingSystemType")
                protected ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.HeatingSystemType heatingSystemType;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the heatingSystemType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.HeatingSystemType }
                 *     
                 */
                public ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.HeatingSystemType getHeatingSystemType() {
                    return heatingSystemType;
                }

                /**
                 * Sets the value of the heatingSystemType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.HeatingSystemType }
                 *     
                 */
                public void setHeatingSystemType(ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.HeatingSystemType value) {
                    this.heatingSystemType = value;
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
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="OpenOrNot">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;enumeration value="Opened"/>
                 *               &lt;enumeration value="Closed"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="CentralizedOrNot">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;enumeration value="Centralized"/>
                 *               &lt;enumeration value="Decentralized"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
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
                    "openOrNot",
                    "centralizedOrNot"
                })
                public static class HeatingSystemType {

                    @XmlElement(name = "OpenOrNot", required = true)
                    protected String openOrNot;
                    @XmlElement(name = "CentralizedOrNot", required = true)
                    protected String centralizedOrNot;

                    /**
                     * Gets the value of the openOrNot property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getOpenOrNot() {
                        return openOrNot;
                    }

                    /**
                     * Sets the value of the openOrNot property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setOpenOrNot(String value) {
                        this.openOrNot = value;
                    }

                    /**
                     * Gets the value of the centralizedOrNot property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCentralizedOrNot() {
                        return centralizedOrNot;
                    }

                    /**
                     * Sets the value of the centralizedOrNot property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCentralizedOrNot(String value) {
                        this.centralizedOrNot = value;
                    }

                }

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
             *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
             *         &lt;element name="IndicatorValue">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
             *               &lt;/extension>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "pairKey",
                "qualityIndicator",
                "indicatorValue"
            })
            public static class Quality {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "QualityIndicator", required = true)
                protected NsiRef qualityIndicator;
                @XmlElement(name = "IndicatorValue", required = true)
                protected ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue indicatorValue;

                /**
                 * Gets the value of the pairKey property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPairKey() {
                    return pairKey;
                }

                /**
                 * Sets the value of the pairKey property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPairKey(String value) {
                    this.pairKey = value;
                }

                /**
                 * Gets the value of the qualityIndicator property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getQualityIndicator() {
                    return qualityIndicator;
                }

                /**
                 * Sets the value of the qualityIndicator property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setQualityIndicator(NsiRef value) {
                    this.qualityIndicator = value;
                }

                /**
                 * Gets the value of the indicatorValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue }
                 *     
                 */
                public ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue getIndicatorValue() {
                    return indicatorValue;
                }

                /**
                 * Sets the value of the indicatorValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue }
                 *     
                 */
                public void setIndicatorValue(ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue value) {
                    this.indicatorValue = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
                 *     &lt;/extension>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class IndicatorValue
                    extends IndicatorValueType
                {


                }

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
             *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="FlowLineTemperature">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *               &lt;minExclusive value="0"/>
             *               &lt;fractionDigits value="1"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="OppositeLineTemperature">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *               &lt;minExclusive value="0"/>
             *               &lt;fractionDigits value="1"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
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
                "pairKey",
                "outsideTemperature",
                "flowLineTemperature",
                "oppositeLineTemperature"
            })
            public static class TemperatureChart {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "OutsideTemperature")
                protected int outsideTemperature;
                @XmlElement(name = "FlowLineTemperature", required = true)
                protected BigDecimal flowLineTemperature;
                @XmlElement(name = "OppositeLineTemperature", required = true)
                protected BigDecimal oppositeLineTemperature;

                /**
                 * Gets the value of the pairKey property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPairKey() {
                    return pairKey;
                }

                /**
                 * Sets the value of the pairKey property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPairKey(String value) {
                    this.pairKey = value;
                }

                /**
                 * Gets the value of the outsideTemperature property.
                 * 
                 */
                public int getOutsideTemperature() {
                    return outsideTemperature;
                }

                /**
                 * Sets the value of the outsideTemperature property.
                 * 
                 */
                public void setOutsideTemperature(int value) {
                    this.outsideTemperature = value;
                }

                /**
                 * Gets the value of the flowLineTemperature property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getFlowLineTemperature() {
                    return flowLineTemperature;
                }

                /**
                 * Sets the value of the flowLineTemperature property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setFlowLineTemperature(BigDecimal value) {
                    this.flowLineTemperature = value;
                }

                /**
                 * Gets the value of the oppositeLineTemperature property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getOppositeLineTemperature() {
                    return oppositeLineTemperature;
                }

                /**
                 * Sets the value of the oppositeLineTemperature property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setOppositeLineTemperature(BigDecimal value) {
                    this.oppositeLineTemperature = value;
                }

            }

        }

    }

}
