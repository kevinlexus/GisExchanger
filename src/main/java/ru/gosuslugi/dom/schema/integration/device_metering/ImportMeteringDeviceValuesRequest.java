
package ru.gosuslugi.dom.schema.integration.device_metering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.ElectricMeteringValueBaseType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueBaseType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.VolumeMeteringValueBaseType;
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
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="MeteringDevicesValues" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
 *                     &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="OneRateDeviceValue"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
 *                               &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
 *                               &lt;element name="VerificationValue" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ElectricDeviceValue"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
 *                               &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
 *                               &lt;element name="VerificationValue" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="VolumeDeviceValue"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
 *                               &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
 *                               &lt;element name="VerificationValue" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;/choice&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fiasHouseGuid",
    "meteringDevicesValues"
})
@XmlRootElement(name = "importMeteringDeviceValuesRequest")
public class ImportMeteringDeviceValuesRequest
    extends BaseType
{

    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "MeteringDevicesValues", required = true)
    protected List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues> meteringDevicesValues;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the meteringDevicesValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meteringDevicesValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeteringDevicesValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues }
     * 
     * 
     */
    public List<ImportMeteringDeviceValuesRequest.MeteringDevicesValues> getMeteringDevicesValues() {
        if (meteringDevicesValues == null) {
            meteringDevicesValues = new ArrayList<ImportMeteringDeviceValuesRequest.MeteringDevicesValues>();
        }
        return this.meteringDevicesValues;
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
            return "10.0.1.1";
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
     *         &lt;choice&gt;
     *           &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
     *           &lt;element name="MeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
     *         &lt;/choice&gt;
     *         &lt;choice&gt;
     *           &lt;element name="OneRateDeviceValue"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
     *                     &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
     *                     &lt;element name="VerificationValue" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
     *                               &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                                 &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="ElectricDeviceValue"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
     *                     &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
     *                     &lt;element name="VerificationValue" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
     *                               &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                                 &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="VolumeDeviceValue"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
     *                     &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
     *                     &lt;element name="VerificationValue" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
     *                               &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
     *                               &lt;choice&gt;
     *                                 &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                                 &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                               &lt;/choice&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
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
    @XmlType(name = "", propOrder = {
        "meteringDeviceRootGUID",
        "meteringDeviceVersionGUID",
        "oneRateDeviceValue",
        "electricDeviceValue",
        "volumeDeviceValue"
    })
    public static class MeteringDevicesValues {

        @XmlElement(name = "MeteringDeviceRootGUID")
        protected String meteringDeviceRootGUID;
        @XmlElement(name = "MeteringDeviceVersionGUID")
        protected String meteringDeviceVersionGUID;
        @XmlElement(name = "OneRateDeviceValue")
        protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue oneRateDeviceValue;
        @XmlElement(name = "ElectricDeviceValue")
        protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue electricDeviceValue;
        @XmlElement(name = "VolumeDeviceValue")
        protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue volumeDeviceValue;

        /**
         * Gets the value of the meteringDeviceRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringDeviceRootGUID() {
            return meteringDeviceRootGUID;
        }

        /**
         * Sets the value of the meteringDeviceRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringDeviceRootGUID(String value) {
            this.meteringDeviceRootGUID = value;
        }

        /**
         * Gets the value of the meteringDeviceVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringDeviceVersionGUID() {
            return meteringDeviceVersionGUID;
        }

        /**
         * Sets the value of the meteringDeviceVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringDeviceVersionGUID(String value) {
            this.meteringDeviceVersionGUID = value;
        }

        /**
         * Gets the value of the oneRateDeviceValue property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue }
         *     
         */
        public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue getOneRateDeviceValue() {
            return oneRateDeviceValue;
        }

        /**
         * Sets the value of the oneRateDeviceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue }
         *     
         */
        public void setOneRateDeviceValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue value) {
            this.oneRateDeviceValue = value;
        }

        /**
         * Gets the value of the electricDeviceValue property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue }
         *     
         */
        public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue getElectricDeviceValue() {
            return electricDeviceValue;
        }

        /**
         * Sets the value of the electricDeviceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue }
         *     
         */
        public void setElectricDeviceValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue value) {
            this.electricDeviceValue = value;
        }

        /**
         * Gets the value of the volumeDeviceValue property.
         * 
         * @return
         *     possible object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue }
         *     
         */
        public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue getVolumeDeviceValue() {
            return volumeDeviceValue;
        }

        /**
         * Sets the value of the volumeDeviceValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue }
         *     
         */
        public void setVolumeDeviceValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue value) {
            this.volumeDeviceValue = value;
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
         *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
         *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueImportType" minOccurs="0"/&gt;
         *         &lt;element name="VerificationValue" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
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
        @XmlType(name = "", propOrder = {
            "currentValue",
            "controlValue",
            "verificationValue"
        })
        public static class ElectricDeviceValue {

            @XmlElement(name = "CurrentValue")
            protected ElectricMeteringValueImportType currentValue;
            @XmlElement(name = "ControlValue")
            protected ElectricMeteringValueImportType controlValue;
            @XmlElement(name = "VerificationValue")
            protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue verificationValue;

            /**
             * Gets the value of the currentValue property.
             * 
             * @return
             *     possible object is
             *     {@link ElectricMeteringValueImportType }
             *     
             */
            public ElectricMeteringValueImportType getCurrentValue() {
                return currentValue;
            }

            /**
             * Sets the value of the currentValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ElectricMeteringValueImportType }
             *     
             */
            public void setCurrentValue(ElectricMeteringValueImportType value) {
                this.currentValue = value;
            }

            /**
             * Gets the value of the controlValue property.
             * 
             * @return
             *     possible object is
             *     {@link ElectricMeteringValueImportType }
             *     
             */
            public ElectricMeteringValueImportType getControlValue() {
                return controlValue;
            }

            /**
             * Sets the value of the controlValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ElectricMeteringValueImportType }
             *     
             */
            public void setControlValue(ElectricMeteringValueImportType value) {
                this.controlValue = value;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue }
             *     
             */
            public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue getVerificationValue() {
                return verificationValue;
            }

            /**
             * Sets the value of the verificationValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue }
             *     
             */
            public void setVerificationValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.VerificationValue value) {
                this.verificationValue = value;
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
             *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
             *         &lt;/choice&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason",
                "transportGUID"
            })
            public static class VerificationValue {

                @XmlElement(name = "StartDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar startDateValue;
                @XmlElement(name = "EndDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar endDateValue;
                @XmlElement(name = "SealDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar sealDate;
                @XmlElement(name = "StartValue", required = true)
                protected ElectricMeteringValueBaseType startValue;
                @XmlElement(name = "EndValue", required = true)
                protected ElectricMeteringValueBaseType endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the startDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDateValue() {
                    return startDateValue;
                }

                /**
                 * Sets the value of the startDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDateValue(XMLGregorianCalendar value) {
                    this.startDateValue = value;
                }

                /**
                 * Gets the value of the endDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDateValue() {
                    return endDateValue;
                }

                /**
                 * Sets the value of the endDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDateValue(XMLGregorianCalendar value) {
                    this.endDateValue = value;
                }

                /**
                 * Gets the value of the sealDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSealDate() {
                    return sealDate;
                }

                /**
                 * Sets the value of the sealDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSealDate(XMLGregorianCalendar value) {
                    this.sealDate = value;
                }

                /**
                 * Gets the value of the startValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueBaseType }
                 *     
                 */
                public ElectricMeteringValueBaseType getStartValue() {
                    return startValue;
                }

                /**
                 * Sets the value of the startValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueBaseType }
                 *     
                 */
                public void setStartValue(ElectricMeteringValueBaseType value) {
                    this.startValue = value;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueBaseType }
                 *     
                 */
                public ElectricMeteringValueBaseType getEndValue() {
                    return endValue;
                }

                /**
                 * Sets the value of the endValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueBaseType }
                 *     
                 */
                public void setEndValue(ElectricMeteringValueBaseType value) {
                    this.endValue = value;
                }

                /**
                 * Gets the value of the plannedVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPlannedVerification() {
                    return plannedVerification;
                }

                /**
                 * Sets the value of the plannedVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPlannedVerification(Boolean value) {
                    this.plannedVerification = value;
                }

                /**
                 * Gets the value of the verificationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getVerificationReason() {
                    return verificationReason;
                }

                /**
                 * Sets the value of the verificationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setVerificationReason(NsiRef value) {
                    this.verificationReason = value;
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
         *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
         *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
         *         &lt;element name="VerificationValue" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
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
        @XmlType(name = "", propOrder = {
            "currentValue",
            "controlValue",
            "verificationValue"
        })
        public static class OneRateDeviceValue {

            @XmlElement(name = "CurrentValue")
            protected List<OneRateMeteringValueImportType> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<OneRateMeteringValueImportType> controlValue;
            @XmlElement(name = "VerificationValue")
            protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue verificationValue;

            /**
             * Gets the value of the currentValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currentValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrentValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OneRateMeteringValueImportType }
             * 
             * 
             */
            public List<OneRateMeteringValueImportType> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<OneRateMeteringValueImportType>();
                }
                return this.currentValue;
            }

            /**
             * Gets the value of the controlValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the controlValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getControlValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OneRateMeteringValueImportType }
             * 
             * 
             */
            public List<OneRateMeteringValueImportType> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<OneRateMeteringValueImportType>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue }
             *     
             */
            public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue getVerificationValue() {
                return verificationValue;
            }

            /**
             * Sets the value of the verificationValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue }
             *     
             */
            public void setVerificationValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.VerificationValue value) {
                this.verificationValue = value;
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
             *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType" maxOccurs="3"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
             *         &lt;/choice&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason",
                "transportGUID"
            })
            public static class VerificationValue {

                @XmlElement(name = "StartDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar startDateValue;
                @XmlElement(name = "EndDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar endDateValue;
                @XmlElement(name = "SealDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar sealDate;
                @XmlElement(name = "StartValue", required = true)
                protected List<OneRateMeteringValueBaseType> startValue;
                @XmlElement(name = "EndValue", required = true)
                protected List<OneRateMeteringValueBaseType> endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the startDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDateValue() {
                    return startDateValue;
                }

                /**
                 * Sets the value of the startDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDateValue(XMLGregorianCalendar value) {
                    this.startDateValue = value;
                }

                /**
                 * Gets the value of the endDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDateValue() {
                    return endDateValue;
                }

                /**
                 * Sets the value of the endDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDateValue(XMLGregorianCalendar value) {
                    this.endDateValue = value;
                }

                /**
                 * Gets the value of the sealDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSealDate() {
                    return sealDate;
                }

                /**
                 * Sets the value of the sealDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSealDate(XMLGregorianCalendar value) {
                    this.sealDate = value;
                }

                /**
                 * Gets the value of the startValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the startValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getStartValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OneRateMeteringValueBaseType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueBaseType> getStartValue() {
                    if (startValue == null) {
                        startValue = new ArrayList<OneRateMeteringValueBaseType>();
                    }
                    return this.startValue;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the endValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getEndValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link OneRateMeteringValueBaseType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueBaseType> getEndValue() {
                    if (endValue == null) {
                        endValue = new ArrayList<OneRateMeteringValueBaseType>();
                    }
                    return this.endValue;
                }

                /**
                 * Gets the value of the plannedVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPlannedVerification() {
                    return plannedVerification;
                }

                /**
                 * Sets the value of the plannedVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPlannedVerification(Boolean value) {
                    this.plannedVerification = value;
                }

                /**
                 * Gets the value of the verificationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getVerificationReason() {
                    return verificationReason;
                }

                /**
                 * Sets the value of the verificationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setVerificationReason(NsiRef value) {
                    this.verificationReason = value;
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
         *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
         *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueImportType" maxOccurs="3" minOccurs="0"/&gt;
         *         &lt;element name="VerificationValue" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
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
        @XmlType(name = "", propOrder = {
            "currentValue",
            "controlValue",
            "verificationValue"
        })
        public static class VolumeDeviceValue {

            @XmlElement(name = "CurrentValue")
            protected List<VolumeMeteringValueImportType> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<VolumeMeteringValueImportType> controlValue;
            @XmlElement(name = "VerificationValue")
            protected ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue.VerificationValue verificationValue;

            /**
             * Gets the value of the currentValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the currentValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCurrentValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link VolumeMeteringValueImportType }
             * 
             * 
             */
            public List<VolumeMeteringValueImportType> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<VolumeMeteringValueImportType>();
                }
                return this.currentValue;
            }

            /**
             * Gets the value of the controlValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the controlValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getControlValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link VolumeMeteringValueImportType }
             * 
             * 
             */
            public List<VolumeMeteringValueImportType> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<VolumeMeteringValueImportType>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * @return
             *     possible object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue.VerificationValue }
             *     
             */
            public ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue.VerificationValue getVerificationValue() {
                return verificationValue;
            }

            /**
             * Sets the value of the verificationValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue.VerificationValue }
             *     
             */
            public void setVerificationValue(ImportMeteringDeviceValuesRequest.MeteringDevicesValues.VolumeDeviceValue.VerificationValue value) {
                this.verificationValue = value;
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
             *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}VolumeMeteringValueBaseType" maxOccurs="3" minOccurs="0"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
             *         &lt;/choice&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason",
                "transportGUID"
            })
            public static class VerificationValue {

                @XmlElement(name = "StartDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar startDateValue;
                @XmlElement(name = "EndDateValue", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar endDateValue;
                @XmlElement(name = "SealDate", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar sealDate;
                @XmlElement(name = "StartValue")
                protected List<VolumeMeteringValueBaseType> startValue;
                @XmlElement(name = "EndValue")
                protected List<VolumeMeteringValueBaseType> endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the startDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getStartDateValue() {
                    return startDateValue;
                }

                /**
                 * Sets the value of the startDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setStartDateValue(XMLGregorianCalendar value) {
                    this.startDateValue = value;
                }

                /**
                 * Gets the value of the endDateValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getEndDateValue() {
                    return endDateValue;
                }

                /**
                 * Sets the value of the endDateValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setEndDateValue(XMLGregorianCalendar value) {
                    this.endDateValue = value;
                }

                /**
                 * Gets the value of the sealDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSealDate() {
                    return sealDate;
                }

                /**
                 * Sets the value of the sealDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSealDate(XMLGregorianCalendar value) {
                    this.sealDate = value;
                }

                /**
                 * Gets the value of the startValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the startValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getStartValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link VolumeMeteringValueBaseType }
                 * 
                 * 
                 */
                public List<VolumeMeteringValueBaseType> getStartValue() {
                    if (startValue == null) {
                        startValue = new ArrayList<VolumeMeteringValueBaseType>();
                    }
                    return this.startValue;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the endValue property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getEndValue().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link VolumeMeteringValueBaseType }
                 * 
                 * 
                 */
                public List<VolumeMeteringValueBaseType> getEndValue() {
                    if (endValue == null) {
                        endValue = new ArrayList<VolumeMeteringValueBaseType>();
                    }
                    return this.endValue;
                }

                /**
                 * Gets the value of the plannedVerification property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isPlannedVerification() {
                    return plannedVerification;
                }

                /**
                 * Sets the value of the plannedVerification property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setPlannedVerification(Boolean value) {
                    this.plannedVerification = value;
                }

                /**
                 * Gets the value of the verificationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getVerificationReason() {
                    return verificationReason;
                }

                /**
                 * Sets the value of the verificationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setVerificationReason(NsiRef value) {
                    this.verificationReason = value;
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

            }

        }

    }

}
