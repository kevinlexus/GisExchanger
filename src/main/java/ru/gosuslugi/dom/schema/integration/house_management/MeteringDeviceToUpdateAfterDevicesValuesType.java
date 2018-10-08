
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueBaseType;


/**
 * Тип для редактирования ПУ после начала внесения показаний
 * 
 * <p>Java class for MeteringDeviceToUpdateAfterDevicesValuesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteringDeviceToUpdateAfterDevicesValuesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InstallationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="RemoteMeteringMode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="RemoteMeteringInfo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TemperatureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="PressureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="CollectiveDevice" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TemperatureSensorInformation" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="2000"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PressureSensorInformation" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="2000"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="MunicipalResourceNotEnergy" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
 *           &lt;element name="MunicipalResourceEnergy" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceElectricUpdateType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="FirstVerificationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="FactorySealDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="ConsumedVolume" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="NotLinkedWithMetering" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="LinkedWithMetering"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="InstallationPlace"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;enumeration value="in"/&gt;
 *                           &lt;enumeration value="out"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="AddressChatacteristicts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="ResidentialPremiseDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="NonResidentialPremiseDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ApartmentHouseDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                             &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CollectiveDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                             &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="LivingRoomDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CollectiveApartmentDevice"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
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
@XmlType(name = "MeteringDeviceToUpdateAfterDevicesValuesType", propOrder = {
    "installationDate",
    "remoteMeteringMode",
    "remoteMeteringInfo",
    "temperatureSensor",
    "pressureSensor",
    "collectiveDevice",
    "accountGUID",
    "certificate",
    "municipalResourceNotEnergy",
    "municipalResourceEnergy",
    "firstVerificationDate",
    "factorySealDate",
    "consumedVolume",
    "notLinkedWithMetering",
    "linkedWithMetering",
    "addressChatacteristicts"
})
public class MeteringDeviceToUpdateAfterDevicesValuesType {

    @XmlElement(name = "InstallationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar installationDate;
    @XmlElement(name = "RemoteMeteringMode")
    protected Boolean remoteMeteringMode;
    @XmlElement(name = "RemoteMeteringInfo")
    protected String remoteMeteringInfo;
    @XmlElement(name = "TemperatureSensor")
    protected Boolean temperatureSensor;
    @XmlElement(name = "PressureSensor")
    protected Boolean pressureSensor;
    @XmlElement(name = "CollectiveDevice")
    protected MeteringDeviceToUpdateAfterDevicesValuesType.CollectiveDevice collectiveDevice;
    @XmlElement(name = "AccountGUID")
    protected List<String> accountGUID;
    @XmlElement(name = "Certificate")
    protected List<AttachmentType> certificate;
    @XmlElement(name = "MunicipalResourceNotEnergy")
    protected List<OneRateMeteringValueBaseType> municipalResourceNotEnergy;
    @XmlElement(name = "MunicipalResourceEnergy")
    protected MunicipalResourceElectricUpdateType municipalResourceEnergy;
    @XmlElement(name = "FirstVerificationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar firstVerificationDate;
    @XmlElement(name = "FactorySealDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar factorySealDate;
    @XmlElement(name = "ConsumedVolume")
    protected Boolean consumedVolume;
    @XmlElement(name = "NotLinkedWithMetering")
    protected Boolean notLinkedWithMetering;
    @XmlElement(name = "LinkedWithMetering")
    protected MeteringDeviceToUpdateAfterDevicesValuesType.LinkedWithMetering linkedWithMetering;
    @XmlElement(name = "AddressChatacteristicts")
    protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts addressChatacteristicts;

    /**
     * Gets the value of the installationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInstallationDate() {
        return installationDate;
    }

    /**
     * Sets the value of the installationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInstallationDate(XMLGregorianCalendar value) {
        this.installationDate = value;
    }

    /**
     * Gets the value of the remoteMeteringMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoteMeteringMode() {
        return remoteMeteringMode;
    }

    /**
     * Sets the value of the remoteMeteringMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoteMeteringMode(Boolean value) {
        this.remoteMeteringMode = value;
    }

    /**
     * Gets the value of the remoteMeteringInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteMeteringInfo() {
        return remoteMeteringInfo;
    }

    /**
     * Sets the value of the remoteMeteringInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteMeteringInfo(String value) {
        this.remoteMeteringInfo = value;
    }

    /**
     * Gets the value of the temperatureSensor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTemperatureSensor() {
        return temperatureSensor;
    }

    /**
     * Sets the value of the temperatureSensor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTemperatureSensor(Boolean value) {
        this.temperatureSensor = value;
    }

    /**
     * Gets the value of the pressureSensor property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPressureSensor() {
        return pressureSensor;
    }

    /**
     * Sets the value of the pressureSensor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPressureSensor(Boolean value) {
        this.pressureSensor = value;
    }

    /**
     * Gets the value of the collectiveDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.CollectiveDevice }
     *     
     */
    public MeteringDeviceToUpdateAfterDevicesValuesType.CollectiveDevice getCollectiveDevice() {
        return collectiveDevice;
    }

    /**
     * Sets the value of the collectiveDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.CollectiveDevice }
     *     
     */
    public void setCollectiveDevice(MeteringDeviceToUpdateAfterDevicesValuesType.CollectiveDevice value) {
        this.collectiveDevice = value;
    }

    /**
     * Gets the value of the accountGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountGUID() {
        if (accountGUID == null) {
            accountGUID = new ArrayList<String>();
        }
        return this.accountGUID;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getCertificate() {
        if (certificate == null) {
            certificate = new ArrayList<AttachmentType>();
        }
        return this.certificate;
    }

    /**
     * Gets the value of the municipalResourceNotEnergy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipalResourceNotEnergy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipalResourceNotEnergy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OneRateMeteringValueBaseType }
     * 
     * 
     */
    public List<OneRateMeteringValueBaseType> getMunicipalResourceNotEnergy() {
        if (municipalResourceNotEnergy == null) {
            municipalResourceNotEnergy = new ArrayList<OneRateMeteringValueBaseType>();
        }
        return this.municipalResourceNotEnergy;
    }

    /**
     * Gets the value of the municipalResourceEnergy property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceElectricUpdateType }
     *     
     */
    public MunicipalResourceElectricUpdateType getMunicipalResourceEnergy() {
        return municipalResourceEnergy;
    }

    /**
     * Sets the value of the municipalResourceEnergy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceElectricUpdateType }
     *     
     */
    public void setMunicipalResourceEnergy(MunicipalResourceElectricUpdateType value) {
        this.municipalResourceEnergy = value;
    }

    /**
     * Gets the value of the firstVerificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstVerificationDate() {
        return firstVerificationDate;
    }

    /**
     * Sets the value of the firstVerificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstVerificationDate(XMLGregorianCalendar value) {
        this.firstVerificationDate = value;
    }

    /**
     * Gets the value of the factorySealDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFactorySealDate() {
        return factorySealDate;
    }

    /**
     * Sets the value of the factorySealDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFactorySealDate(XMLGregorianCalendar value) {
        this.factorySealDate = value;
    }

    /**
     * Gets the value of the consumedVolume property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsumedVolume() {
        return consumedVolume;
    }

    /**
     * Sets the value of the consumedVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsumedVolume(Boolean value) {
        this.consumedVolume = value;
    }

    /**
     * Gets the value of the notLinkedWithMetering property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotLinkedWithMetering() {
        return notLinkedWithMetering;
    }

    /**
     * Sets the value of the notLinkedWithMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotLinkedWithMetering(Boolean value) {
        this.notLinkedWithMetering = value;
    }

    /**
     * Gets the value of the linkedWithMetering property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.LinkedWithMetering }
     *     
     */
    public MeteringDeviceToUpdateAfterDevicesValuesType.LinkedWithMetering getLinkedWithMetering() {
        return linkedWithMetering;
    }

    /**
     * Sets the value of the linkedWithMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.LinkedWithMetering }
     *     
     */
    public void setLinkedWithMetering(MeteringDeviceToUpdateAfterDevicesValuesType.LinkedWithMetering value) {
        this.linkedWithMetering = value;
    }

    /**
     * Gets the value of the addressChatacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts }
     *     
     */
    public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts getAddressChatacteristicts() {
        return addressChatacteristicts;
    }

    /**
     * Sets the value of the addressChatacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts }
     *     
     */
    public void setAddressChatacteristicts(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts value) {
        this.addressChatacteristicts = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="ResidentialPremiseDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="NonResidentialPremiseDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ApartmentHouseDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                   &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CollectiveDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                   &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="LivingRoomDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CollectiveApartmentDevice"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "residentialPremiseDevice",
        "nonResidentialPremiseDevice",
        "apartmentHouseDevice",
        "collectiveDevice",
        "livingRoomDevice",
        "collectiveApartmentDevice"
    })
    public static class AddressChatacteristicts {

        @XmlElement(name = "ResidentialPremiseDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ResidentialPremiseDevice residentialPremiseDevice;
        @XmlElement(name = "NonResidentialPremiseDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.NonResidentialPremiseDevice nonResidentialPremiseDevice;
        @XmlElement(name = "ApartmentHouseDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ApartmentHouseDevice apartmentHouseDevice;
        @XmlElement(name = "CollectiveDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveDevice collectiveDevice;
        @XmlElement(name = "LivingRoomDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.LivingRoomDevice livingRoomDevice;
        @XmlElement(name = "CollectiveApartmentDevice")
        protected MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveApartmentDevice collectiveApartmentDevice;

        /**
         * Gets the value of the residentialPremiseDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ResidentialPremiseDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ResidentialPremiseDevice getResidentialPremiseDevice() {
            return residentialPremiseDevice;
        }

        /**
         * Sets the value of the residentialPremiseDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ResidentialPremiseDevice }
         *     
         */
        public void setResidentialPremiseDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ResidentialPremiseDevice value) {
            this.residentialPremiseDevice = value;
        }

        /**
         * Gets the value of the nonResidentialPremiseDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.NonResidentialPremiseDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.NonResidentialPremiseDevice getNonResidentialPremiseDevice() {
            return nonResidentialPremiseDevice;
        }

        /**
         * Sets the value of the nonResidentialPremiseDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.NonResidentialPremiseDevice }
         *     
         */
        public void setNonResidentialPremiseDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.NonResidentialPremiseDevice value) {
            this.nonResidentialPremiseDevice = value;
        }

        /**
         * Gets the value of the apartmentHouseDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ApartmentHouseDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ApartmentHouseDevice getApartmentHouseDevice() {
            return apartmentHouseDevice;
        }

        /**
         * Sets the value of the apartmentHouseDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ApartmentHouseDevice }
         *     
         */
        public void setApartmentHouseDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.ApartmentHouseDevice value) {
            this.apartmentHouseDevice = value;
        }

        /**
         * Gets the value of the collectiveDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveDevice getCollectiveDevice() {
            return collectiveDevice;
        }

        /**
         * Sets the value of the collectiveDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveDevice }
         *     
         */
        public void setCollectiveDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveDevice value) {
            this.collectiveDevice = value;
        }

        /**
         * Gets the value of the livingRoomDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.LivingRoomDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.LivingRoomDevice getLivingRoomDevice() {
            return livingRoomDevice;
        }

        /**
         * Sets the value of the livingRoomDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.LivingRoomDevice }
         *     
         */
        public void setLivingRoomDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.LivingRoomDevice value) {
            this.livingRoomDevice = value;
        }

        /**
         * Gets the value of the collectiveApartmentDevice property.
         * 
         * @return
         *     possible object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveApartmentDevice }
         *     
         */
        public MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveApartmentDevice getCollectiveApartmentDevice() {
            return collectiveApartmentDevice;
        }

        /**
         * Sets the value of the collectiveApartmentDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveApartmentDevice }
         *     
         */
        public void setCollectiveApartmentDevice(MeteringDeviceToUpdateAfterDevicesValuesType.AddressChatacteristicts.CollectiveApartmentDevice value) {
            this.collectiveApartmentDevice = value;
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
         *       &lt;choice&gt;
         *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
         *         &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fiasHouseGuid",
            "isChangeToFIASHouseGuid"
        })
        public static class ApartmentHouseDevice {

            @XmlElement(name = "FIASHouseGuid")
            protected List<String> fiasHouseGuid;
            protected Boolean isChangeToFIASHouseGuid;

            /**
             * Gets the value of the fiasHouseGuid property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFIASHouseGuid().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getFIASHouseGuid() {
                if (fiasHouseGuid == null) {
                    fiasHouseGuid = new ArrayList<String>();
                }
                return this.fiasHouseGuid;
            }

            /**
             * Gets the value of the isChangeToFIASHouseGuid property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsChangeToFIASHouseGuid() {
                return isChangeToFIASHouseGuid;
            }

            /**
             * Sets the value of the isChangeToFIASHouseGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsChangeToFIASHouseGuid(Boolean value) {
                this.isChangeToFIASHouseGuid = value;
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
         *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
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
            "premiseGUID"
        })
        public static class CollectiveApartmentDevice {

            @XmlElement(name = "PremiseGUID", required = true)
            protected List<String> premiseGUID;

            /**
             * Gets the value of the premiseGUID property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseGUID property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseGUID().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getPremiseGUID() {
                if (premiseGUID == null) {
                    premiseGUID = new ArrayList<String>();
                }
                return this.premiseGUID;
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
         *       &lt;choice&gt;
         *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
         *         &lt;element name="isChangeToFIASHouseGuid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fiasHouseGuid",
            "isChangeToFIASHouseGuid"
        })
        public static class CollectiveDevice {

            @XmlElement(name = "FIASHouseGuid")
            protected List<String> fiasHouseGuid;
            protected Boolean isChangeToFIASHouseGuid;

            /**
             * Gets the value of the fiasHouseGuid property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFIASHouseGuid().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getFIASHouseGuid() {
                if (fiasHouseGuid == null) {
                    fiasHouseGuid = new ArrayList<String>();
                }
                return this.fiasHouseGuid;
            }

            /**
             * Gets the value of the isChangeToFIASHouseGuid property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsChangeToFIASHouseGuid() {
                return isChangeToFIASHouseGuid;
            }

            /**
             * Sets the value of the isChangeToFIASHouseGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsChangeToFIASHouseGuid(Boolean value) {
                this.isChangeToFIASHouseGuid = value;
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
         *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
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
            "livingRoomGUID"
        })
        public static class LivingRoomDevice {

            @XmlElement(name = "LivingRoomGUID", required = true)
            protected List<String> livingRoomGUID;

            /**
             * Gets the value of the livingRoomGUID property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomGUID property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomGUID().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getLivingRoomGUID() {
                if (livingRoomGUID == null) {
                    livingRoomGUID = new ArrayList<String>();
                }
                return this.livingRoomGUID;
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
         *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
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
            "premiseGUID"
        })
        public static class NonResidentialPremiseDevice {

            @XmlElement(name = "PremiseGUID", required = true)
            protected List<String> premiseGUID;

            /**
             * Gets the value of the premiseGUID property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseGUID property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseGUID().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getPremiseGUID() {
                if (premiseGUID == null) {
                    premiseGUID = new ArrayList<String>();
                }
                return this.premiseGUID;
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
         *         &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
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
            "premiseGUID"
        })
        public static class ResidentialPremiseDevice {

            @XmlElement(name = "PremiseGUID", required = true)
            protected List<String> premiseGUID;

            /**
             * Gets the value of the premiseGUID property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseGUID property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseGUID().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getPremiseGUID() {
                if (premiseGUID == null) {
                    premiseGUID = new ArrayList<String>();
                }
                return this.premiseGUID;
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
     *         &lt;element name="TemperatureSensorInformation" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="2000"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PressureSensorInformation" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="2000"/&gt;
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
        "temperatureSensorInformation",
        "pressureSensorInformation"
    })
    public static class CollectiveDevice {

        @XmlElement(name = "TemperatureSensorInformation")
        protected String temperatureSensorInformation;
        @XmlElement(name = "PressureSensorInformation")
        protected String pressureSensorInformation;

        /**
         * Gets the value of the temperatureSensorInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemperatureSensorInformation() {
            return temperatureSensorInformation;
        }

        /**
         * Sets the value of the temperatureSensorInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemperatureSensorInformation(String value) {
            this.temperatureSensorInformation = value;
        }

        /**
         * Gets the value of the pressureSensorInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPressureSensorInformation() {
            return pressureSensorInformation;
        }

        /**
         * Sets the value of the pressureSensorInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPressureSensorInformation(String value) {
            this.pressureSensorInformation = value;
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
     *         &lt;element name="InstallationPlace"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="in"/&gt;
     *               &lt;enumeration value="out"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10" minOccurs="0"/&gt;
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
        "installationPlace",
        "linkedMeteringDeviceVersionGUID"
    })
    public static class LinkedWithMetering {

        @XmlElement(name = "InstallationPlace", required = true)
        protected String installationPlace;
        @XmlElement(name = "LinkedMeteringDeviceVersionGUID")
        protected List<String> linkedMeteringDeviceVersionGUID;

        /**
         * Gets the value of the installationPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInstallationPlace() {
            return installationPlace;
        }

        /**
         * Sets the value of the installationPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInstallationPlace(String value) {
            this.installationPlace = value;
        }

        /**
         * Gets the value of the linkedMeteringDeviceVersionGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the linkedMeteringDeviceVersionGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLinkedMeteringDeviceVersionGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLinkedMeteringDeviceVersionGUID() {
            if (linkedMeteringDeviceVersionGUID == null) {
                linkedMeteringDeviceVersionGUID = new ArrayList<String>();
            }
            return this.linkedMeteringDeviceVersionGUID;
        }

    }

}
