
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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Основные характеристики ПУ
 * 
 * <p>Java class for MeteringDeviceBasicCharacteristicsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteringDeviceBasicCharacteristicsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MeteringDeviceNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MeteringDeviceStamp" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MeteringDeviceModel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="InstallationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="CommissioningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="RemoteMeteringMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="RemoteMeteringInfo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FirstVerificationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="VerificationInterval" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="FactorySealDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="TemperatureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="PressureSensor" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="ConsumedVolume" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="CollectiveDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                     &lt;element name="TemperatureSensingElementInfo" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="2000"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="PressureSensingElementInfo" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="2000"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ProjectRegistrationNode" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ResidentialPremiseDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="NonResidentialPremiseDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ApartmentHouseDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="LivingRoomDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="CollectiveApartmentDevice"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="PremiseGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
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
@XmlType(name = "MeteringDeviceBasicCharacteristicsType", propOrder = {
    "meteringDeviceNumber",
    "meteringDeviceStamp",
    "meteringDeviceModel",
    "installationDate",
    "commissioningDate",
    "remoteMeteringMode",
    "remoteMeteringInfo",
    "firstVerificationDate",
    "verificationInterval",
    "factorySealDate",
    "temperatureSensor",
    "pressureSensor",
    "consumedVolume",
    "collectiveDevice",
    "residentialPremiseDevice",
    "nonResidentialPremiseDevice",
    "apartmentHouseDevice",
    "livingRoomDevice",
    "collectiveApartmentDevice"
})
public class MeteringDeviceBasicCharacteristicsType {

    @XmlElement(name = "MeteringDeviceNumber", required = true)
    protected String meteringDeviceNumber;
    @XmlElement(name = "MeteringDeviceStamp")
    protected String meteringDeviceStamp;
    @XmlElement(name = "MeteringDeviceModel")
    protected String meteringDeviceModel;
    @XmlElement(name = "InstallationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar installationDate;
    @XmlElement(name = "CommissioningDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar commissioningDate;
    @XmlElement(name = "RemoteMeteringMode")
    protected boolean remoteMeteringMode;
    @XmlElement(name = "RemoteMeteringInfo")
    protected String remoteMeteringInfo;
    @XmlElement(name = "FirstVerificationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar firstVerificationDate;
    @XmlElement(name = "VerificationInterval")
    protected NsiRef verificationInterval;
    @XmlElement(name = "FactorySealDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar factorySealDate;
    @XmlElement(name = "TemperatureSensor")
    protected boolean temperatureSensor;
    @XmlElement(name = "PressureSensor")
    protected boolean pressureSensor;
    @XmlElement(name = "ConsumedVolume")
    protected Boolean consumedVolume;
    @XmlElement(name = "CollectiveDevice")
    protected MeteringDeviceBasicCharacteristicsType.CollectiveDevice collectiveDevice;
    @XmlElement(name = "ResidentialPremiseDevice")
    protected MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice residentialPremiseDevice;
    @XmlElement(name = "NonResidentialPremiseDevice")
    protected MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice nonResidentialPremiseDevice;
    @XmlElement(name = "ApartmentHouseDevice")
    protected MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice apartmentHouseDevice;
    @XmlElement(name = "LivingRoomDevice")
    protected MeteringDeviceBasicCharacteristicsType.LivingRoomDevice livingRoomDevice;
    @XmlElement(name = "CollectiveApartmentDevice")
    protected MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice collectiveApartmentDevice;

    /**
     * Gets the value of the meteringDeviceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceNumber() {
        return meteringDeviceNumber;
    }

    /**
     * Sets the value of the meteringDeviceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceNumber(String value) {
        this.meteringDeviceNumber = value;
    }

    /**
     * Gets the value of the meteringDeviceStamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceStamp() {
        return meteringDeviceStamp;
    }

    /**
     * Sets the value of the meteringDeviceStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceStamp(String value) {
        this.meteringDeviceStamp = value;
    }

    /**
     * Gets the value of the meteringDeviceModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringDeviceModel() {
        return meteringDeviceModel;
    }

    /**
     * Sets the value of the meteringDeviceModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringDeviceModel(String value) {
        this.meteringDeviceModel = value;
    }

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
     * Gets the value of the commissioningDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommissioningDate() {
        return commissioningDate;
    }

    /**
     * Sets the value of the commissioningDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommissioningDate(XMLGregorianCalendar value) {
        this.commissioningDate = value;
    }

    /**
     * Gets the value of the remoteMeteringMode property.
     * 
     */
    public boolean isRemoteMeteringMode() {
        return remoteMeteringMode;
    }

    /**
     * Sets the value of the remoteMeteringMode property.
     * 
     */
    public void setRemoteMeteringMode(boolean value) {
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
     * Gets the value of the verificationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getVerificationInterval() {
        return verificationInterval;
    }

    /**
     * Sets the value of the verificationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setVerificationInterval(NsiRef value) {
        this.verificationInterval = value;
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
     * Gets the value of the temperatureSensor property.
     * 
     */
    public boolean isTemperatureSensor() {
        return temperatureSensor;
    }

    /**
     * Sets the value of the temperatureSensor property.
     * 
     */
    public void setTemperatureSensor(boolean value) {
        this.temperatureSensor = value;
    }

    /**
     * Gets the value of the pressureSensor property.
     * 
     */
    public boolean isPressureSensor() {
        return pressureSensor;
    }

    /**
     * Sets the value of the pressureSensor property.
     * 
     */
    public void setPressureSensor(boolean value) {
        this.pressureSensor = value;
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
     * Gets the value of the collectiveDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.CollectiveDevice getCollectiveDevice() {
        return collectiveDevice;
    }

    /**
     * Sets the value of the collectiveDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveDevice }
     *     
     */
    public void setCollectiveDevice(MeteringDeviceBasicCharacteristicsType.CollectiveDevice value) {
        this.collectiveDevice = value;
    }

    /**
     * Gets the value of the residentialPremiseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice getResidentialPremiseDevice() {
        return residentialPremiseDevice;
    }

    /**
     * Sets the value of the residentialPremiseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice }
     *     
     */
    public void setResidentialPremiseDevice(MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice value) {
        this.residentialPremiseDevice = value;
    }

    /**
     * Gets the value of the nonResidentialPremiseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice getNonResidentialPremiseDevice() {
        return nonResidentialPremiseDevice;
    }

    /**
     * Sets the value of the nonResidentialPremiseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice }
     *     
     */
    public void setNonResidentialPremiseDevice(MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice value) {
        this.nonResidentialPremiseDevice = value;
    }

    /**
     * Gets the value of the apartmentHouseDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice getApartmentHouseDevice() {
        return apartmentHouseDevice;
    }

    /**
     * Sets the value of the apartmentHouseDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice }
     *     
     */
    public void setApartmentHouseDevice(MeteringDeviceBasicCharacteristicsType.ApartmentHouseDevice value) {
        this.apartmentHouseDevice = value;
    }

    /**
     * Gets the value of the livingRoomDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.LivingRoomDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.LivingRoomDevice getLivingRoomDevice() {
        return livingRoomDevice;
    }

    /**
     * Sets the value of the livingRoomDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.LivingRoomDevice }
     *     
     */
    public void setLivingRoomDevice(MeteringDeviceBasicCharacteristicsType.LivingRoomDevice value) {
        this.livingRoomDevice = value;
    }

    /**
     * Gets the value of the collectiveApartmentDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice getCollectiveApartmentDevice() {
        return collectiveApartmentDevice;
    }

    /**
     * Sets the value of the collectiveApartmentDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice }
     *     
     */
    public void setCollectiveApartmentDevice(MeteringDeviceBasicCharacteristicsType.CollectiveApartmentDevice value) {
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
     *       &lt;sequence&gt;
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "fiasHouseGuid",
        "accountGUID",
        "certificate"
    })
    public static class ApartmentHouseDevice {

        @XmlElement(name = "FIASHouseGuid")
        protected List<String> fiasHouseGuid;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "premiseGUID",
        "accountGUID",
        "certificate"
    })
    public static class CollectiveApartmentDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected List<String> premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="TemperatureSensingElementInfo" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="2000"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PressureSensingElementInfo" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="2000"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ProjectRegistrationNode" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "fiasHouseGuid",
        "temperatureSensingElementInfo",
        "pressureSensingElementInfo",
        "projectRegistrationNode",
        "certificate"
    })
    public static class CollectiveDevice {

        @XmlElement(name = "FIASHouseGuid")
        protected List<String> fiasHouseGuid;
        @XmlElement(name = "TemperatureSensingElementInfo")
        protected String temperatureSensingElementInfo;
        @XmlElement(name = "PressureSensingElementInfo")
        protected String pressureSensingElementInfo;
        @XmlElement(name = "ProjectRegistrationNode")
        protected List<AttachmentType> projectRegistrationNode;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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
         * Gets the value of the temperatureSensingElementInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTemperatureSensingElementInfo() {
            return temperatureSensingElementInfo;
        }

        /**
         * Sets the value of the temperatureSensingElementInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTemperatureSensingElementInfo(String value) {
            this.temperatureSensingElementInfo = value;
        }

        /**
         * Gets the value of the pressureSensingElementInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPressureSensingElementInfo() {
            return pressureSensingElementInfo;
        }

        /**
         * Sets the value of the pressureSensingElementInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPressureSensingElementInfo(String value) {
            this.pressureSensingElementInfo = value;
        }

        /**
         * Gets the value of the projectRegistrationNode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the projectRegistrationNode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProjectRegistrationNode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getProjectRegistrationNode() {
            if (projectRegistrationNode == null) {
                projectRegistrationNode = new ArrayList<AttachmentType>();
            }
            return this.projectRegistrationNode;
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
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "livingRoomGUID",
        "accountGUID",
        "certificate"
    })
    public static class LivingRoomDevice {

        @XmlElement(name = "LivingRoomGUID", required = true)
        protected List<String> livingRoomGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "premiseGUID",
        "accountGUID",
        "certificate"
    })
    public static class NonResidentialPremiseDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected List<String> premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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
     *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *         &lt;element name="Certificate" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
        "premiseGUID",
        "accountGUID",
        "certificate"
    })
    public static class ResidentialPremiseDevice {

        @XmlElement(name = "PremiseGUID", required = true)
        protected List<String> premiseGUID;
        @XmlElement(name = "AccountGUID", required = true)
        protected List<String> accountGUID;
        @XmlElement(name = "Certificate")
        protected List<AttachmentType> certificate;

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

    }

}
