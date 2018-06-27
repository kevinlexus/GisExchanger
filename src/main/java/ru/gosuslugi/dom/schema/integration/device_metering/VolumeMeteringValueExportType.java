
package ru.gosuslugi.dom.schema.integration.device_metering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Экспортируемые виды показаний ПУ (тепловая энергия, газ, горячая вода, холодная вода, сточные бытовые воды) (используется при экспорте показаний)
 * 
 * <p>Java class for VolumeMeteringValueExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeMeteringValueExportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ControlValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeCurrentMeteringValueExportType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VerificationValue" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportBaseType" maxOccurs="3" minOccurs="0"/>
 *                   &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportBaseType" maxOccurs="3" minOccurs="0"/>
 *                   &lt;choice>
 *                     &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
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
@XmlType(name = "VolumeMeteringValueExportType", propOrder = {
    "currentValue",
    "controlValue",
    "verificationValue"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResultType.VolumeDeviceValue.class
})
public class VolumeMeteringValueExportType {

    @XmlElement(name = "CurrentValue")
    protected List<VolumeCurrentMeteringValueExportType> currentValue;
    @XmlElement(name = "ControlValue")
    protected List<VolumeCurrentMeteringValueExportType> controlValue;
    @XmlElement(name = "VerificationValue")
    protected List<VolumeMeteringValueExportType.VerificationValue> verificationValue;

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
     * {@link VolumeCurrentMeteringValueExportType }
     * 
     * 
     */
    public List<VolumeCurrentMeteringValueExportType> getCurrentValue() {
        if (currentValue == null) {
            currentValue = new ArrayList<VolumeCurrentMeteringValueExportType>();
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
     * {@link VolumeCurrentMeteringValueExportType }
     * 
     * 
     */
    public List<VolumeCurrentMeteringValueExportType> getControlValue() {
        if (controlValue == null) {
            controlValue = new ArrayList<VolumeCurrentMeteringValueExportType>();
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
     * {@link VolumeMeteringValueExportType.VerificationValue }
     * 
     * 
     */
    public List<VolumeMeteringValueExportType.VerificationValue> getVerificationValue() {
        if (verificationValue == null) {
            verificationValue = new ArrayList<VolumeMeteringValueExportType.VerificationValue>();
        }
        return this.verificationValue;
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
     *         &lt;element name="StartDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EndDateValue" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="SealDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="StartValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportBaseType" maxOccurs="3" minOccurs="0"/>
     *         &lt;element name="EndValue" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportBaseType" maxOccurs="3" minOccurs="0"/>
     *         &lt;choice>
     *           &lt;element name="PlannedVerification" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="VerificationReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
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
        @XmlElement(name = "StartValue")
        protected List<VolumeMeteringValueExportBaseType> startValue;
        @XmlElement(name = "EndValue")
        protected List<VolumeMeteringValueExportBaseType> endValue;
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
         * {@link VolumeMeteringValueExportBaseType }
         * 
         * 
         */
        public List<VolumeMeteringValueExportBaseType> getStartValue() {
            if (startValue == null) {
                startValue = new ArrayList<VolumeMeteringValueExportBaseType>();
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
         * {@link VolumeMeteringValueExportBaseType }
         * 
         * 
         */
        public List<VolumeMeteringValueExportBaseType> getEndValue() {
            if (endValue == null) {
                endValue = new ArrayList<VolumeMeteringValueExportBaseType>();
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
