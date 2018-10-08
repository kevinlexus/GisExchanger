
package ru.gosuslugi.dom.schema.integration.device_metering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for exportMeteringDeviceHistoryResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportMeteringDeviceHistoryResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="OneRateDeviceValue"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="BaseValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3" minOccurs="0"/&gt;
 *                     &lt;element name="Values" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;/choice&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
 *                     &lt;element name="BaseValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType" minOccurs="0"/&gt;
 *                     &lt;element name="Values" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
 *                                         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
 *                                         &lt;choice&gt;
 *                                           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                         &lt;/choice&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="ArchivedValues" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
@XmlType(name = "exportMeteringDeviceHistoryResultType", propOrder = {
    "meteringDeviceRootGUID",
    "oneRateDeviceValue",
    "electricDeviceValue",
    "volumeDeviceValue",
    "archivedValues"
})
public class ExportMeteringDeviceHistoryResultType {

    @XmlElement(name = "MeteringDeviceRootGUID", required = true)
    protected String meteringDeviceRootGUID;
    @XmlElement(name = "OneRateDeviceValue")
    protected ExportMeteringDeviceHistoryResultType.OneRateDeviceValue oneRateDeviceValue;
    @XmlElement(name = "ElectricDeviceValue")
    protected ExportMeteringDeviceHistoryResultType.ElectricDeviceValue electricDeviceValue;
    @XmlElement(name = "VolumeDeviceValue")
    protected ExportMeteringDeviceHistoryResultType.VolumeDeviceValue volumeDeviceValue;
    @XmlElement(name = "ArchivedValues")
    protected ExportMeteringDeviceHistoryResultType.ArchivedValues archivedValues;

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
     * Gets the value of the oneRateDeviceValue property.
     * 
     * @return
     *     possible object is
     *     {@link ExportMeteringDeviceHistoryResultType.OneRateDeviceValue }
     *     
     */
    public ExportMeteringDeviceHistoryResultType.OneRateDeviceValue getOneRateDeviceValue() {
        return oneRateDeviceValue;
    }

    /**
     * Sets the value of the oneRateDeviceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportMeteringDeviceHistoryResultType.OneRateDeviceValue }
     *     
     */
    public void setOneRateDeviceValue(ExportMeteringDeviceHistoryResultType.OneRateDeviceValue value) {
        this.oneRateDeviceValue = value;
    }

    /**
     * Gets the value of the electricDeviceValue property.
     * 
     * @return
     *     possible object is
     *     {@link ExportMeteringDeviceHistoryResultType.ElectricDeviceValue }
     *     
     */
    public ExportMeteringDeviceHistoryResultType.ElectricDeviceValue getElectricDeviceValue() {
        return electricDeviceValue;
    }

    /**
     * Sets the value of the electricDeviceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportMeteringDeviceHistoryResultType.ElectricDeviceValue }
     *     
     */
    public void setElectricDeviceValue(ExportMeteringDeviceHistoryResultType.ElectricDeviceValue value) {
        this.electricDeviceValue = value;
    }

    /**
     * Gets the value of the volumeDeviceValue property.
     * 
     * @return
     *     possible object is
     *     {@link ExportMeteringDeviceHistoryResultType.VolumeDeviceValue }
     *     
     */
    public ExportMeteringDeviceHistoryResultType.VolumeDeviceValue getVolumeDeviceValue() {
        return volumeDeviceValue;
    }

    /**
     * Sets the value of the volumeDeviceValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportMeteringDeviceHistoryResultType.VolumeDeviceValue }
     *     
     */
    public void setVolumeDeviceValue(ExportMeteringDeviceHistoryResultType.VolumeDeviceValue value) {
        this.volumeDeviceValue = value;
    }

    /**
     * Gets the value of the archivedValues property.
     * 
     * @return
     *     possible object is
     *     {@link ExportMeteringDeviceHistoryResultType.ArchivedValues }
     *     
     */
    public ExportMeteringDeviceHistoryResultType.ArchivedValues getArchivedValues() {
        return archivedValues;
    }

    /**
     * Sets the value of the archivedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportMeteringDeviceHistoryResultType.ArchivedValues }
     *     
     */
    public void setArchivedValues(ExportMeteringDeviceHistoryResultType.ArchivedValues value) {
        this.archivedValues = value;
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
     *         &lt;element name="ArchivingReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
        "archivingReason"
    })
    public static class ArchivedValues {

        @XmlElement(name = "ArchivingReason", required = true)
        protected NsiRef archivingReason;

        /**
         * Gets the value of the archivingReason property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getArchivingReason() {
            return archivingReason;
        }

        /**
         * Sets the value of the archivingReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setArchivingReason(NsiRef value) {
            this.archivingReason = value;
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
     *         &lt;element name="BaseValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType" minOccurs="0"/&gt;
     *         &lt;element name="Values" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
     *                             &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
     *                             &lt;choice&gt;
     *                               &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                             &lt;/choice&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "baseValue",
        "values"
    })
    public static class ElectricDeviceValue {

        @XmlElement(name = "BaseValue")
        protected ElectricMeteringValueExportType baseValue;
        @XmlElement(name = "Values")
        protected ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values values;

        /**
         * Gets the value of the baseValue property.
         * 
         * @return
         *     possible object is
         *     {@link ElectricMeteringValueExportType }
         *     
         */
        public ElectricMeteringValueExportType getBaseValue() {
            return baseValue;
        }

        /**
         * Sets the value of the baseValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ElectricMeteringValueExportType }
         *     
         */
        public void setBaseValue(ElectricMeteringValueExportType value) {
            this.baseValue = value;
        }

        /**
         * Gets the value of the values property.
         * 
         * @return
         *     possible object is
         *     {@link ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values }
         *     
         */
        public ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values getValues() {
            return values;
        }

        /**
         * Sets the value of the values property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values }
         *     
         */
        public void setValues(ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values value) {
            this.values = value;
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
         *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;/choice&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
            "verificationValue",
            "excludeISValues"
        })
        public static class Values {

            @XmlElement(name = "CurrentValue")
            protected List<ElectricCurrentMeteringValueExportType> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<ElectricCurrentMeteringValueExportType> controlValue;
            @XmlElement(name = "VerificationValue")
            protected List<ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values.VerificationValue> verificationValue;
            protected Boolean excludeISValues;

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
             * {@link ElectricCurrentMeteringValueExportType }
             * 
             * 
             */
            public List<ElectricCurrentMeteringValueExportType> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<ElectricCurrentMeteringValueExportType>();
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
             * {@link ElectricCurrentMeteringValueExportType }
             * 
             * 
             */
            public List<ElectricCurrentMeteringValueExportType> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<ElectricCurrentMeteringValueExportType>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the verificationValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVerificationValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values.VerificationValue }
             * 
             * 
             */
            public List<ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values.VerificationValue> getVerificationValue() {
                if (verificationValue == null) {
                    verificationValue = new ArrayList<ExportMeteringDeviceHistoryResultType.ElectricDeviceValue.Values.VerificationValue>();
                }
                return this.verificationValue;
            }

            /**
             * Gets the value of the excludeISValues property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isExcludeISValues() {
                return excludeISValues;
            }

            /**
             * Sets the value of the excludeISValues property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setExcludeISValues(Boolean value) {
                this.excludeISValues = value;
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
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}ElectricMeteringValueExportType"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason"
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
                protected ElectricMeteringValueExportType startValue;
                @XmlElement(name = "EndValue", required = true)
                protected ElectricMeteringValueExportType endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;

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
                 *     {@link ElectricMeteringValueExportType }
                 *     
                 */
                public ElectricMeteringValueExportType getStartValue() {
                    return startValue;
                }

                /**
                 * Sets the value of the startValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueExportType }
                 *     
                 */
                public void setStartValue(ElectricMeteringValueExportType value) {
                    this.startValue = value;
                }

                /**
                 * Gets the value of the endValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ElectricMeteringValueExportType }
                 *     
                 */
                public ElectricMeteringValueExportType getEndValue() {
                    return endValue;
                }

                /**
                 * Sets the value of the endValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ElectricMeteringValueExportType }
                 *     
                 */
                public void setEndValue(ElectricMeteringValueExportType value) {
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
     *         &lt;element name="BaseValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3" minOccurs="0"/&gt;
     *         &lt;element name="Values" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
     *                             &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
     *                             &lt;choice&gt;
     *                               &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                             &lt;/choice&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "baseValue",
        "values"
    })
    public static class OneRateDeviceValue {

        @XmlElement(name = "BaseValue")
        protected List<OneRateMeteringValueExportType> baseValue;
        @XmlElement(name = "Values")
        protected ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values values;

        /**
         * Gets the value of the baseValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the baseValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBaseValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OneRateMeteringValueExportType }
         * 
         * 
         */
        public List<OneRateMeteringValueExportType> getBaseValue() {
            if (baseValue == null) {
                baseValue = new ArrayList<OneRateMeteringValueExportType>();
            }
            return this.baseValue;
        }

        /**
         * Gets the value of the values property.
         * 
         * @return
         *     possible object is
         *     {@link ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values }
         *     
         */
        public ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values getValues() {
            return values;
        }

        /**
         * Sets the value of the values property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values }
         *     
         */
        public void setValues(ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values value) {
            this.values = value;
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
         *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
         *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;/choice&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
            "verificationValue",
            "excludeISValues"
        })
        public static class Values {

            @XmlElement(name = "CurrentValue")
            protected List<OneRateCurrentMeteringValueExportType> currentValue;
            @XmlElement(name = "ControlValue")
            protected List<OneRateCurrentMeteringValueExportType> controlValue;
            @XmlElement(name = "VerificationValue")
            protected List<ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values.VerificationValue> verificationValue;
            protected Boolean excludeISValues;

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
             * {@link OneRateCurrentMeteringValueExportType }
             * 
             * 
             */
            public List<OneRateCurrentMeteringValueExportType> getCurrentValue() {
                if (currentValue == null) {
                    currentValue = new ArrayList<OneRateCurrentMeteringValueExportType>();
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
             * {@link OneRateCurrentMeteringValueExportType }
             * 
             * 
             */
            public List<OneRateCurrentMeteringValueExportType> getControlValue() {
                if (controlValue == null) {
                    controlValue = new ArrayList<OneRateCurrentMeteringValueExportType>();
                }
                return this.controlValue;
            }

            /**
             * Gets the value of the verificationValue property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the verificationValue property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVerificationValue().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values.VerificationValue }
             * 
             * 
             */
            public List<ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values.VerificationValue> getVerificationValue() {
                if (verificationValue == null) {
                    verificationValue = new ArrayList<ExportMeteringDeviceHistoryResultType.OneRateDeviceValue.Values.VerificationValue>();
                }
                return this.verificationValue;
            }

            /**
             * Gets the value of the excludeISValues property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isExcludeISValues() {
                return excludeISValues;
            }

            /**
             * Sets the value of the excludeISValues property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setExcludeISValues(Boolean value) {
                this.excludeISValues = value;
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
             *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
             *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType" maxOccurs="3"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
                "startDateValue",
                "endDateValue",
                "sealDate",
                "startValue",
                "endValue",
                "plannedVerification",
                "verificationReason"
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
                protected List<OneRateMeteringValueExportType> startValue;
                @XmlElement(name = "EndValue", required = true)
                protected List<OneRateMeteringValueExportType> endValue;
                @XmlElement(name = "PlannedVerification")
                protected Boolean plannedVerification;
                @XmlElement(name = "VerificationReason")
                protected NsiRef verificationReason;

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
                 * {@link OneRateMeteringValueExportType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueExportType> getStartValue() {
                    if (startValue == null) {
                        startValue = new ArrayList<OneRateMeteringValueExportType>();
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
                 * {@link OneRateMeteringValueExportType }
                 * 
                 * 
                 */
                public List<OneRateMeteringValueExportType> getEndValue() {
                    if (endValue == null) {
                        endValue = new ArrayList<OneRateMeteringValueExportType>();
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="excludeISValues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "excludeISValues"
    })
    public static class VolumeDeviceValue
        extends VolumeMeteringValueExportType
    {

        protected Boolean excludeISValues;

        /**
         * Gets the value of the excludeISValues property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isExcludeISValues() {
            return excludeISValues;
        }

        /**
         * Sets the value of the excludeISValues property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setExcludeISValues(Boolean value) {
            this.excludeISValues = value;
        }

    }

}
