
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Экспорт объектов жилищного фонда из договора ресурсоснабжения
 * 
 * <p>Java class for exportSupplyResourceContractObjectAddressResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportSupplyResourceContractObjectAddressResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Pair" maxOccurs="100" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="HeatingSystemType" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="OpenOrNot"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="Opened"/&gt;
 *                                   &lt;enumeration value="Closed"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CentralizedOrNot"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="Centralized"/&gt;
 *                                   &lt;enumeration value="Decentralized"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="IndicatorValue" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
 *                   &lt;element name="IndicatorValue"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType" minOccurs="0"/&gt;
 *                   &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType" minOccurs="0"/&gt;
 *                   &lt;element name="FeedingMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="VersionNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VersionStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Posted"/&gt;
 *               &lt;enumeration value="Terminated"/&gt;
 *               &lt;enumeration value="Draft"/&gt;
 *               &lt;enumeration value="Annul"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CountingResource" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="R"/&gt;
 *               &lt;enumeration value="P"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportSupplyResourceContractObjectAddressResultType", propOrder = {
    "pair",
    "quality",
    "otherQualityIndicator",
    "plannedVolume",
    "objectGUID",
    "contractRootGUID",
    "contractGUID",
    "versionNumber",
    "versionStatus",
    "countingResource",
    "meteringDeviceInformation"
})
public class ExportSupplyResourceContractObjectAddressResultType
    extends ObjectAddressType
{

    @XmlElement(name = "Pair")
    protected List<ExportSupplyResourceContractObjectAddressResultType.Pair> pair;
    @XmlElement(name = "Quality")
    protected List<ExportSupplyResourceContractObjectAddressResultType.Quality> quality;
    @XmlElement(name = "OtherQualityIndicator")
    protected List<ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator> otherQualityIndicator;
    @XmlElement(name = "PlannedVolume")
    protected List<ExportSupplyResourceContractObjectAddressResultType.PlannedVolume> plannedVolume;
    @XmlElement(name = "ObjectGUID", required = true)
    protected String objectGUID;
    @XmlElement(name = "ContractRootGUID", required = true)
    protected String contractRootGUID;
    @XmlElement(name = "ContractGUID", required = true)
    protected String contractGUID;
    @XmlElement(name = "VersionNumber", required = true)
    protected BigInteger versionNumber;
    @XmlElement(name = "VersionStatus", required = true)
    protected String versionStatus;
    @XmlElement(name = "CountingResource")
    protected String countingResource;
    @XmlElement(name = "MeteringDeviceInformation")
    protected Boolean meteringDeviceInformation;

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
     * {@link ExportSupplyResourceContractObjectAddressResultType.Pair }
     * 
     * 
     */
    public List<ExportSupplyResourceContractObjectAddressResultType.Pair> getPair() {
        if (pair == null) {
            pair = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.Pair>();
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
     * {@link ExportSupplyResourceContractObjectAddressResultType.Quality }
     * 
     * 
     */
    public List<ExportSupplyResourceContractObjectAddressResultType.Quality> getQuality() {
        if (quality == null) {
            quality = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.Quality>();
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
     * {@link ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator }
     * 
     * 
     */
    public List<ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator> getOtherQualityIndicator() {
        if (otherQualityIndicator == null) {
            otherQualityIndicator = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator>();
        }
        return this.otherQualityIndicator;
    }

    /**
     * Gets the value of the plannedVolume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedVolume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedVolume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractObjectAddressResultType.PlannedVolume }
     * 
     * 
     */
    public List<ExportSupplyResourceContractObjectAddressResultType.PlannedVolume> getPlannedVolume() {
        if (plannedVolume == null) {
            plannedVolume = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.PlannedVolume>();
        }
        return this.plannedVolume;
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
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersionNumber(BigInteger value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the versionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionStatus() {
        return versionStatus;
    }

    /**
     * Sets the value of the versionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionStatus(String value) {
        this.versionStatus = value;
    }

    /**
     * Gets the value of the countingResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountingResource() {
        return countingResource;
    }

    /**
     * Sets the value of the countingResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountingResource(String value) {
        this.countingResource = value;
    }

    /**
     * Gets the value of the meteringDeviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMeteringDeviceInformation() {
        return meteringDeviceInformation;
    }

    /**
     * Sets the value of the meteringDeviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMeteringDeviceInformation(Boolean value) {
        this.meteringDeviceInformation = value;
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
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
     *         &lt;element name="IndicatorValue"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
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
        "pairKey",
        "indicatorName",
        "indicatorValue",
        "additionalInformation"
    })
    public static class OtherQualityIndicator {

        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "IndicatorName", required = true)
        protected String indicatorName;
        @XmlElement(name = "IndicatorValue", required = true)
        protected ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue indicatorValue;
        @XmlElement(name = "AdditionalInformation")
        protected String additionalInformation;

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
         * Gets the value of the indicatorValue property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue }
         *     
         */
        public ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue getIndicatorValue() {
            return indicatorValue;
        }

        /**
         * Sets the value of the indicatorValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue }
         *     
         */
        public void setIndicatorValue(ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue value) {
            this.indicatorValue = value;
        }

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInformation(String value) {
            this.additionalInformation = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="HeatingSystemType" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="OpenOrNot"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="Opened"/&gt;
     *                         &lt;enumeration value="Closed"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CentralizedOrNot"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="Centralized"/&gt;
     *                         &lt;enumeration value="Decentralized"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
        "heatingSystemType",
        "transportGUID"
    })
    public static class Pair
        extends ContractSubjectObjectAdressType
    {

        @XmlElement(name = "HeatingSystemType")
        protected List<ExportSupplyResourceContractObjectAddressResultType.Pair.HeatingSystemType> heatingSystemType;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the heatingSystemType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the heatingSystemType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHeatingSystemType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractObjectAddressResultType.Pair.HeatingSystemType }
         * 
         * 
         */
        public List<ExportSupplyResourceContractObjectAddressResultType.Pair.HeatingSystemType> getHeatingSystemType() {
            if (heatingSystemType == null) {
                heatingSystemType = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.Pair.HeatingSystemType>();
            }
            return this.heatingSystemType;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="OpenOrNot"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="Opened"/&gt;
         *               &lt;enumeration value="Closed"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CentralizedOrNot"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="Centralized"/&gt;
         *               &lt;enumeration value="Decentralized"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType" minOccurs="0"/&gt;
     *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType" minOccurs="0"/&gt;
     *         &lt;element name="FeedingMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
        "pairKey",
        "volume",
        "unit",
        "feedingMode"
    })
    public static class PlannedVolume {

        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "Volume")
        protected BigDecimal volume;
        @XmlElement(name = "Unit")
        protected String unit;
        @XmlElement(name = "FeedingMode")
        protected String feedingMode;

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
         * Gets the value of the volume property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVolume() {
            return volume;
        }

        /**
         * Sets the value of the volume property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVolume(BigDecimal value) {
            this.volume = value;
        }

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

        /**
         * Gets the value of the feedingMode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeedingMode() {
            return feedingMode;
        }

        /**
         * Sets the value of the feedingMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeedingMode(String value) {
            this.feedingMode = value;
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
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="IndicatorValue" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
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
        "pairKey",
        "qualityIndicator",
        "indicatorValue",
        "additionalInformation"
    })
    public static class Quality {

        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "QualityIndicator", required = true)
        protected NsiRef qualityIndicator;
        @XmlElement(name = "IndicatorValue")
        protected List<ExportSupplyResourceContractObjectAddressResultType.Quality.IndicatorValue> indicatorValue;
        @XmlElement(name = "AdditionalInformation")
        protected String additionalInformation;

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
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the indicatorValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndicatorValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractObjectAddressResultType.Quality.IndicatorValue }
         * 
         * 
         */
        public List<ExportSupplyResourceContractObjectAddressResultType.Quality.IndicatorValue> getIndicatorValue() {
            if (indicatorValue == null) {
                indicatorValue = new ArrayList<ExportSupplyResourceContractObjectAddressResultType.Quality.IndicatorValue>();
            }
            return this.indicatorValue;
        }

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInformation(String value) {
            this.additionalInformation = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
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

}
