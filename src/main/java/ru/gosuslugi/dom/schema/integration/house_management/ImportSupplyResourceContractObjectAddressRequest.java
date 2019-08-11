
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *           &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="ObjectAddress" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadObject"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="Pair" maxOccurs="100"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="HeatingSystemType" minOccurs="0"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                 &lt;sequence&gt;
 *                                                   &lt;element name="OpenOrNot"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;enumeration value="Opened"/&gt;
 *                                                         &lt;enumeration value="Closed"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                   &lt;element name="CentralizedOrNot"&gt;
 *                                                     &lt;simpleType&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                         &lt;enumeration value="Centralized"/&gt;
 *                                                         &lt;enumeration value="Decentralized"/&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/simpleType&gt;
 *                                                   &lt;/element&gt;
 *                                                 &lt;/sequence&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;element name="IndicatorValue"&gt;
 *                                           &lt;complexType&gt;
 *                                             &lt;complexContent&gt;
 *                                               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
 *                                               &lt;/extension&gt;
 *                                             &lt;/complexContent&gt;
 *                                           &lt;/complexType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;sequence&gt;
 *                                             &lt;choice&gt;
 *                                               &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                                                 &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/choice&gt;
 *                                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
 *                                           &lt;/sequence&gt;
 *                                           &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                                         &lt;element name="FlowLineTemperature"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                               &lt;minInclusive value="0"/&gt;
 *                                               &lt;fractionDigits value="1"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="OppositeLineTemperature"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                               &lt;minInclusive value="0"/&gt;
 *                                               &lt;fractionDigits value="1"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
 *                                         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
 *                                         &lt;element name="FeedingMode"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
 *                                               &lt;maxLength value="250"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="CountingResource" minOccurs="0"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;enumeration value="R"/&gt;
 *                                     &lt;enumeration value="P"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                               &lt;element name="Tariff" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="Norm" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DeleteObject" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.7.0.3""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *           &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadObject"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="Pair" maxOccurs="100"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="HeatingSystemType" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="OpenOrNot"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;enumeration value="Opened"/&gt;
     *                                               &lt;enumeration value="Closed"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                         &lt;element name="CentralizedOrNot"&gt;
     *                                           &lt;simpleType&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                               &lt;enumeration value="Centralized"/&gt;
     *                                               &lt;enumeration value="Decentralized"/&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/simpleType&gt;
     *                                         &lt;/element&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                               &lt;element name="IndicatorValue"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
     *                                     &lt;/extension&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
     *                               &lt;choice&gt;
     *                                 &lt;sequence&gt;
     *                                   &lt;choice&gt;
     *                                     &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *                                       &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/choice&gt;
     *                                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
     *                                 &lt;/sequence&gt;
     *                                 &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                               &lt;element name="FlowLineTemperature"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                     &lt;minInclusive value="0"/&gt;
     *                                     &lt;fractionDigits value="1"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="OppositeLineTemperature"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                     &lt;minInclusive value="0"/&gt;
     *                                     &lt;fractionDigits value="1"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
     *                               &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
     *                               &lt;element name="FeedingMode"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
     *                                     &lt;maxLength value="250"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="CountingResource" minOccurs="0"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;enumeration value="R"/&gt;
     *                           &lt;enumeration value="P"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                     &lt;element name="Tariff" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Norm" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="DeleteObject" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Pair" maxOccurs="100"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectObjectAdressType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="HeatingSystemType" minOccurs="0"&gt;
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
         *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;sequence&gt;
         *                       &lt;choice&gt;
         *                         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
         *                         &lt;sequence&gt;
         *                           &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
         *                           &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
         *                         &lt;/sequence&gt;
         *                       &lt;/choice&gt;
         *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
         *                     &lt;/sequence&gt;
         *                     &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
         *                   &lt;element name="FlowLineTemperature"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;minInclusive value="0"/&gt;
         *                         &lt;fractionDigits value="1"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="OppositeLineTemperature"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;minInclusive value="0"/&gt;
         *                         &lt;fractionDigits value="1"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
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
         *                   &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
         *                   &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
         *                   &lt;element name="FeedingMode"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
         *                         &lt;maxLength value="250"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
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
         *         &lt;element name="Tariff" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Norm" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "pair",
            "quality",
            "otherQualityIndicator",
            "temperatureChart",
            "plannedVolume",
            "countingResource",
            "meteringDeviceInformation",
            "tariff",
            "norm"
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
            @XmlElement(name = "PlannedVolume")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.PlannedVolume> plannedVolume;
            @XmlElement(name = "CountingResource")
            protected String countingResource;
            @XmlElement(name = "MeteringDeviceInformation")
            protected Boolean meteringDeviceInformation;
            @XmlElement(name = "Tariff")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Tariff> tariff;
            @XmlElement(name = "Norm")
            protected List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Norm> norm;

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
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.PlannedVolume }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.PlannedVolume> getPlannedVolume() {
                if (plannedVolume == null) {
                    plannedVolume = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.PlannedVolume>();
                }
                return this.plannedVolume;
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
             * Gets the value of the tariff property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the tariff property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTariff().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Tariff }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Tariff> getTariff() {
                if (tariff == null) {
                    tariff = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Tariff>();
                }
                return this.tariff;
            }

            /**
             * Gets the value of the norm property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the norm property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNorm().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Norm }
             * 
             * 
             */
            public List<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Norm> getNorm() {
                if (norm == null) {
                    norm = new ArrayList<ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Norm>();
                }
                return this.norm;
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
             *         &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "normGUID"
            })
            public static class Norm {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "NormGUID", required = true)
                protected String normGUID;

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
                 * Gets the value of the normGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNormGUID() {
                    return normGUID;
                }

                /**
                 * Sets the value of the normGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNormGUID(String value) {
                    this.normGUID = value;
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
             *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
             *         &lt;choice&gt;
             *           &lt;sequence&gt;
             *             &lt;choice&gt;
             *               &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
             *               &lt;sequence&gt;
             *                 &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
             *                 &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
             *               &lt;/sequence&gt;
             *             &lt;/choice&gt;
             *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
             *           &lt;/sequence&gt;
             *           &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;/choice&gt;
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
                "number",
                "startRange",
                "endRange",
                "okei",
                "correspond",
                "additionalInformation"
            })
            public static class OtherQualityIndicator {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "IndicatorName", required = true)
                protected String indicatorName;
                @XmlElement(name = "Number")
                protected BigDecimal number;
                @XmlElement(name = "StartRange")
                protected BigDecimal startRange;
                @XmlElement(name = "EndRange")
                protected BigDecimal endRange;
                @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
                protected String okei;
                @XmlElement(name = "Correspond")
                protected Boolean correspond;
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
                 * Gets the value of the startRange property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getStartRange() {
                    return startRange;
                }

                /**
                 * Sets the value of the startRange property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setStartRange(BigDecimal value) {
                    this.startRange = value;
                }

                /**
                 * Gets the value of the endRange property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getEndRange() {
                    return endRange;
                }

                /**
                 * Sets the value of the endRange property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setEndRange(BigDecimal value) {
                    this.endRange = value;
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

                /**
                 * Gets the value of the correspond property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isCorrespond() {
                    return correspond;
                }

                /**
                 * Sets the value of the correspond property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setCorrespond(Boolean value) {
                    this.correspond = value;
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
             *         &lt;element name="HeatingSystemType" minOccurs="0"&gt;
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
             *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
             *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
             *         &lt;element name="FeedingMode"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
             *               &lt;maxLength value="250"/&gt;
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
                "pairKey",
                "volume",
                "unit",
                "feedingMode"
            })
            public static class PlannedVolume {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "Volume", required = true)
                protected BigDecimal volume;
                @XmlElement(name = "Unit", required = true)
                protected String unit;
                @XmlElement(name = "FeedingMode", required = true)
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
                "qualityIndicator",
                "indicatorValue",
                "additionalInformation"
            })
            public static class Quality {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "QualityIndicator", required = true)
                protected NsiRef qualityIndicator;
                @XmlElement(name = "IndicatorValue", required = true)
                protected ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue indicatorValue;
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
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
             *         &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "priceGUID"
            })
            public static class Tariff {

                @XmlElement(name = "PairKey", required = true)
                protected String pairKey;
                @XmlElement(name = "PriceGUID", required = true)
                protected String priceGUID;

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
                 * Gets the value of the priceGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPriceGUID() {
                    return priceGUID;
                }

                /**
                 * Sets the value of the priceGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPriceGUID(String value) {
                    this.priceGUID = value;
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
             *         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
             *         &lt;element name="FlowLineTemperature"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;minInclusive value="0"/&gt;
             *               &lt;fractionDigits value="1"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="OppositeLineTemperature"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;minInclusive value="0"/&gt;
             *               &lt;fractionDigits value="1"/&gt;
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
                "outsideTemperature",
                "flowLineTemperature",
                "oppositeLineTemperature"
            })
            public static class TemperatureChart {

                @XmlElement(name = "OutsideTemperature")
                protected int outsideTemperature;
                @XmlElement(name = "FlowLineTemperature", required = true)
                protected BigDecimal flowLineTemperature;
                @XmlElement(name = "OppositeLineTemperature", required = true)
                protected BigDecimal oppositeLineTemperature;

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
