
package ru.gosuslugi.dom.schema.integration.volume_quality;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Тип для информации о показателях качества КУ
 * 
 * <p>Java class for QualityServicesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QualityServicesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ObjectAddress"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="ColdWater"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsSignedAct"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="ColdWaterConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityDays"&gt;
 *                                             &lt;simpleType&gt;
 *                                               &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"&gt;
 *                                               &lt;/restriction&gt;
 *                                             &lt;/simpleType&gt;
 *                                           &lt;/element&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                               &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="HotWater"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsSignedAct"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="TemperatureConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityTemperature" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}NotConformityTemperatureHotWaterType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DurationDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                               &lt;element name="VolumeDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                               &lt;element name="HotWaterConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                               &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Electricity"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsSignedAct"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="ElectricityConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Gas"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsSignedAct"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="GasConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                               &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Heating"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsSignedAct"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="HeatingConformity"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                           &lt;element name="NotConformityTemperature"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="TemperatureExcess" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
 *                                                     &lt;element name="TemperatureDecline" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/restriction&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="NotConformityHours" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
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
@XmlType(name = "QualityServicesType", propOrder = {
    "objectAddress",
    "coldWater",
    "hotWater",
    "electricity",
    "gas",
    "heating"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices.class
})
public class QualityServicesType {

    @XmlElement(name = "ObjectAddress", required = true)
    protected QualityServicesType.ObjectAddress objectAddress;
    @XmlElement(name = "ColdWater")
    protected QualityServicesType.ColdWater coldWater;
    @XmlElement(name = "HotWater")
    protected QualityServicesType.HotWater hotWater;
    @XmlElement(name = "Electricity")
    protected QualityServicesType.Electricity electricity;
    @XmlElement(name = "Gas")
    protected QualityServicesType.Gas gas;
    @XmlElement(name = "Heating")
    protected QualityServicesType.Heating heating;

    /**
     * Gets the value of the objectAddress property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.ObjectAddress }
     *     
     */
    public QualityServicesType.ObjectAddress getObjectAddress() {
        return objectAddress;
    }

    /**
     * Sets the value of the objectAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.ObjectAddress }
     *     
     */
    public void setObjectAddress(QualityServicesType.ObjectAddress value) {
        this.objectAddress = value;
    }

    /**
     * Gets the value of the coldWater property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.ColdWater }
     *     
     */
    public QualityServicesType.ColdWater getColdWater() {
        return coldWater;
    }

    /**
     * Sets the value of the coldWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.ColdWater }
     *     
     */
    public void setColdWater(QualityServicesType.ColdWater value) {
        this.coldWater = value;
    }

    /**
     * Gets the value of the hotWater property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.HotWater }
     *     
     */
    public QualityServicesType.HotWater getHotWater() {
        return hotWater;
    }

    /**
     * Sets the value of the hotWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.HotWater }
     *     
     */
    public void setHotWater(QualityServicesType.HotWater value) {
        this.hotWater = value;
    }

    /**
     * Gets the value of the electricity property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.Electricity }
     *     
     */
    public QualityServicesType.Electricity getElectricity() {
        return electricity;
    }

    /**
     * Sets the value of the electricity property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.Electricity }
     *     
     */
    public void setElectricity(QualityServicesType.Electricity value) {
        this.electricity = value;
    }

    /**
     * Gets the value of the gas property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.Gas }
     *     
     */
    public QualityServicesType.Gas getGas() {
        return gas;
    }

    /**
     * Sets the value of the gas property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.Gas }
     *     
     */
    public void setGas(QualityServicesType.Gas value) {
        this.gas = value;
    }

    /**
     * Gets the value of the heating property.
     * 
     * @return
     *     possible object is
     *     {@link QualityServicesType.Heating }
     *     
     */
    public QualityServicesType.Heating getHeating() {
        return heating;
    }

    /**
     * Sets the value of the heating property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityServicesType.Heating }
     *     
     */
    public void setHeating(QualityServicesType.Heating value) {
        this.heating = value;
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
     *         &lt;element name="IsSignedAct"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ColdWaterConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityDays"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                   &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "isSignedAct",
        "isNotSignedAct"
    })
    public static class ColdWater {

        @XmlElement(name = "IsSignedAct")
        protected QualityServicesType.ColdWater.IsSignedAct isSignedAct;
        @XmlElement(name = "IsNotSignedAct")
        protected Boolean isNotSignedAct;

        /**
         * Gets the value of the isSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link QualityServicesType.ColdWater.IsSignedAct }
         *     
         */
        public QualityServicesType.ColdWater.IsSignedAct getIsSignedAct() {
            return isSignedAct;
        }

        /**
         * Sets the value of the isSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link QualityServicesType.ColdWater.IsSignedAct }
         *     
         */
        public void setIsSignedAct(QualityServicesType.ColdWater.IsSignedAct value) {
            this.isSignedAct = value;
        }

        /**
         * Gets the value of the isNotSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsNotSignedAct() {
            return isNotSignedAct;
        }

        /**
         * Sets the value of the isNotSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsNotSignedAct(Boolean value) {
            this.isNotSignedAct = value;
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
         *         &lt;element name="ColdWaterConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityDays"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *         &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
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
            "coldWaterConformity",
            "durationPressure25",
            "daysPressure25"
        })
        public static class IsSignedAct {

            @XmlElement(name = "ColdWaterConformity", required = true)
            protected QualityServicesType.ColdWater.IsSignedAct.ColdWaterConformity coldWaterConformity;
            @XmlElement(name = "DurationPressure25", required = true)
            protected BigDecimal durationPressure25;
            @XmlElement(name = "DaysPressure25", required = true)
            protected BigDecimal daysPressure25;

            /**
             * Gets the value of the coldWaterConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.ColdWater.IsSignedAct.ColdWaterConformity }
             *     
             */
            public QualityServicesType.ColdWater.IsSignedAct.ColdWaterConformity getColdWaterConformity() {
                return coldWaterConformity;
            }

            /**
             * Sets the value of the coldWaterConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.ColdWater.IsSignedAct.ColdWaterConformity }
             *     
             */
            public void setColdWaterConformity(QualityServicesType.ColdWater.IsSignedAct.ColdWaterConformity value) {
                this.coldWaterConformity = value;
            }

            /**
             * Gets the value of the durationPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDurationPressure25() {
                return durationPressure25;
            }

            /**
             * Sets the value of the durationPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDurationPressure25(BigDecimal value) {
                this.durationPressure25 = value;
            }

            /**
             * Gets the value of the daysPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDaysPressure25() {
                return daysPressure25;
            }

            /**
             * Sets the value of the daysPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDaysPressure25(BigDecimal value) {
                this.daysPressure25 = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityDays"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityDays"
            })
            public static class ColdWaterConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityDays")
                protected BigDecimal notConformityDays;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityDays property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNotConformityDays() {
                    return notConformityDays;
                }

                /**
                 * Sets the value of the notConformityDays property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNotConformityDays(BigDecimal value) {
                    this.notConformityDays = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="IsSignedAct"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ElectricityConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "isSignedAct",
        "isNotSignedAct"
    })
    public static class Electricity {

        @XmlElement(name = "IsSignedAct")
        protected QualityServicesType.Electricity.IsSignedAct isSignedAct;
        @XmlElement(name = "IsNotSignedAct")
        protected Boolean isNotSignedAct;

        /**
         * Gets the value of the isSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link QualityServicesType.Electricity.IsSignedAct }
         *     
         */
        public QualityServicesType.Electricity.IsSignedAct getIsSignedAct() {
            return isSignedAct;
        }

        /**
         * Sets the value of the isSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link QualityServicesType.Electricity.IsSignedAct }
         *     
         */
        public void setIsSignedAct(QualityServicesType.Electricity.IsSignedAct value) {
            this.isSignedAct = value;
        }

        /**
         * Gets the value of the isNotSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsNotSignedAct() {
            return isNotSignedAct;
        }

        /**
         * Sets the value of the isNotSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsNotSignedAct(Boolean value) {
            this.isNotSignedAct = value;
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
         *         &lt;element name="ElectricityConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
         *                   &lt;/sequence&gt;
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
        @XmlType(name = "", propOrder = {
            "electricityConformity"
        })
        public static class IsSignedAct {

            @XmlElement(name = "ElectricityConformity", required = true)
            protected QualityServicesType.Electricity.IsSignedAct.ElectricityConformity electricityConformity;

            /**
             * Gets the value of the electricityConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.Electricity.IsSignedAct.ElectricityConformity }
             *     
             */
            public QualityServicesType.Electricity.IsSignedAct.ElectricityConformity getElectricityConformity() {
                return electricityConformity;
            }

            /**
             * Sets the value of the electricityConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.Electricity.IsSignedAct.ElectricityConformity }
             *     
             */
            public void setElectricityConformity(QualityServicesType.Electricity.IsSignedAct.ElectricityConformity value) {
                this.electricityConformity = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityDays"
            })
            public static class ElectricityConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityDays")
                protected BigDecimal notConformityDays;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityDays property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNotConformityDays() {
                    return notConformityDays;
                }

                /**
                 * Sets the value of the notConformityDays property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNotConformityDays(BigDecimal value) {
                    this.notConformityDays = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="IsSignedAct"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="GasConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                   &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "isSignedAct",
        "isNotSignedAct"
    })
    public static class Gas {

        @XmlElement(name = "IsSignedAct")
        protected QualityServicesType.Gas.IsSignedAct isSignedAct;
        @XmlElement(name = "IsNotSignedAct")
        protected Boolean isNotSignedAct;

        /**
         * Gets the value of the isSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link QualityServicesType.Gas.IsSignedAct }
         *     
         */
        public QualityServicesType.Gas.IsSignedAct getIsSignedAct() {
            return isSignedAct;
        }

        /**
         * Sets the value of the isSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link QualityServicesType.Gas.IsSignedAct }
         *     
         */
        public void setIsSignedAct(QualityServicesType.Gas.IsSignedAct value) {
            this.isSignedAct = value;
        }

        /**
         * Gets the value of the isNotSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsNotSignedAct() {
            return isNotSignedAct;
        }

        /**
         * Sets the value of the isNotSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsNotSignedAct(Boolean value) {
            this.isNotSignedAct = value;
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
         *         &lt;element name="GasConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *         &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
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
            "gasConformity",
            "durationPressure25",
            "daysPressure25"
        })
        public static class IsSignedAct {

            @XmlElement(name = "GasConformity", required = true)
            protected QualityServicesType.Gas.IsSignedAct.GasConformity gasConformity;
            @XmlElement(name = "DurationPressure25", required = true)
            protected BigDecimal durationPressure25;
            @XmlElement(name = "DaysPressure25", required = true)
            protected BigDecimal daysPressure25;

            /**
             * Gets the value of the gasConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.Gas.IsSignedAct.GasConformity }
             *     
             */
            public QualityServicesType.Gas.IsSignedAct.GasConformity getGasConformity() {
                return gasConformity;
            }

            /**
             * Sets the value of the gasConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.Gas.IsSignedAct.GasConformity }
             *     
             */
            public void setGasConformity(QualityServicesType.Gas.IsSignedAct.GasConformity value) {
                this.gasConformity = value;
            }

            /**
             * Gets the value of the durationPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDurationPressure25() {
                return durationPressure25;
            }

            /**
             * Sets the value of the durationPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDurationPressure25(BigDecimal value) {
                this.durationPressure25 = value;
            }

            /**
             * Gets the value of the daysPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDaysPressure25() {
                return daysPressure25;
            }

            /**
             * Sets the value of the daysPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDaysPressure25(BigDecimal value) {
                this.daysPressure25 = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityDays"
            })
            public static class GasConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityDays")
                protected BigDecimal notConformityDays;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityDays property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNotConformityDays() {
                    return notConformityDays;
                }

                /**
                 * Sets the value of the notConformityDays property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNotConformityDays(BigDecimal value) {
                    this.notConformityDays = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="IsSignedAct"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="HeatingConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityTemperature"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="TemperatureExcess" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
     *                                         &lt;element name="TemperatureDecline" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/restriction&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="NotConformityHours" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "isSignedAct",
        "isNotSignedAct"
    })
    public static class Heating {

        @XmlElement(name = "IsSignedAct")
        protected QualityServicesType.Heating.IsSignedAct isSignedAct;
        @XmlElement(name = "IsNotSignedAct")
        protected Boolean isNotSignedAct;

        /**
         * Gets the value of the isSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link QualityServicesType.Heating.IsSignedAct }
         *     
         */
        public QualityServicesType.Heating.IsSignedAct getIsSignedAct() {
            return isSignedAct;
        }

        /**
         * Sets the value of the isSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link QualityServicesType.Heating.IsSignedAct }
         *     
         */
        public void setIsSignedAct(QualityServicesType.Heating.IsSignedAct value) {
            this.isSignedAct = value;
        }

        /**
         * Gets the value of the isNotSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsNotSignedAct() {
            return isNotSignedAct;
        }

        /**
         * Sets the value of the isNotSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsNotSignedAct(Boolean value) {
            this.isNotSignedAct = value;
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
         *         &lt;element name="HeatingConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityTemperature"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="TemperatureExcess" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
         *                               &lt;element name="TemperatureDecline" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/restriction&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="NotConformityHours" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
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
            "heatingConformity",
            "daysPressure25"
        })
        public static class IsSignedAct {

            @XmlElement(name = "HeatingConformity", required = true)
            protected QualityServicesType.Heating.IsSignedAct.HeatingConformity heatingConformity;
            @XmlElement(name = "DaysPressure25", required = true)
            protected BigDecimal daysPressure25;

            /**
             * Gets the value of the heatingConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.Heating.IsSignedAct.HeatingConformity }
             *     
             */
            public QualityServicesType.Heating.IsSignedAct.HeatingConformity getHeatingConformity() {
                return heatingConformity;
            }

            /**
             * Sets the value of the heatingConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.Heating.IsSignedAct.HeatingConformity }
             *     
             */
            public void setHeatingConformity(QualityServicesType.Heating.IsSignedAct.HeatingConformity value) {
                this.heatingConformity = value;
            }

            /**
             * Gets the value of the daysPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDaysPressure25() {
                return daysPressure25;
            }

            /**
             * Sets the value of the daysPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDaysPressure25(BigDecimal value) {
                this.daysPressure25 = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityTemperature"&gt;
             *             &lt;complexType&gt;
             *               &lt;complexContent&gt;
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                   &lt;sequence&gt;
             *                     &lt;element name="TemperatureExcess" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
             *                     &lt;element name="TemperatureDecline" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
             *                   &lt;/sequence&gt;
             *                 &lt;/restriction&gt;
             *               &lt;/complexContent&gt;
             *             &lt;/complexType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="NotConformityHours" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityTemperature",
                "notConformityHours"
            })
            public static class HeatingConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityTemperature")
                protected QualityServicesType.Heating.IsSignedAct.HeatingConformity.NotConformityTemperature notConformityTemperature;
                @XmlElement(name = "NotConformityHours")
                protected BigDecimal notConformityHours;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityTemperature property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link QualityServicesType.Heating.IsSignedAct.HeatingConformity.NotConformityTemperature }
                 *     
                 */
                public QualityServicesType.Heating.IsSignedAct.HeatingConformity.NotConformityTemperature getNotConformityTemperature() {
                    return notConformityTemperature;
                }

                /**
                 * Sets the value of the notConformityTemperature property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link QualityServicesType.Heating.IsSignedAct.HeatingConformity.NotConformityTemperature }
                 *     
                 */
                public void setNotConformityTemperature(QualityServicesType.Heating.IsSignedAct.HeatingConformity.NotConformityTemperature value) {
                    this.notConformityTemperature = value;
                }

                /**
                 * Gets the value of the notConformityHours property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNotConformityHours() {
                    return notConformityHours;
                }

                /**
                 * Sets the value of the notConformityHours property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNotConformityHours(BigDecimal value) {
                    this.notConformityHours = value;
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
                 *         &lt;element name="TemperatureExcess" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
                 *         &lt;element name="TemperatureDecline" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType" minOccurs="0"/&gt;
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
                    "temperatureExcess",
                    "temperatureDecline"
                })
                public static class NotConformityTemperature {

                    @XmlElement(name = "TemperatureExcess")
                    protected BigDecimal temperatureExcess;
                    @XmlElement(name = "TemperatureDecline")
                    protected BigDecimal temperatureDecline;

                    /**
                     * Gets the value of the temperatureExcess property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getTemperatureExcess() {
                        return temperatureExcess;
                    }

                    /**
                     * Sets the value of the temperatureExcess property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setTemperatureExcess(BigDecimal value) {
                        this.temperatureExcess = value;
                    }

                    /**
                     * Gets the value of the temperatureDecline property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getTemperatureDecline() {
                        return temperatureDecline;
                    }

                    /**
                     * Sets the value of the temperatureDecline property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setTemperatureDecline(BigDecimal value) {
                        this.temperatureDecline = value;
                    }

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
     *       &lt;choice&gt;
     *         &lt;element name="IsSignedAct"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TemperatureConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityTemperature" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}NotConformityTemperatureHotWaterType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                   &lt;element name="VolumeDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                   &lt;element name="HotWaterConformity"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;choice&gt;
     *                             &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                               &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/choice&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
     *                   &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="IsNotSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "isSignedAct",
        "isNotSignedAct"
    })
    public static class HotWater {

        @XmlElement(name = "IsSignedAct")
        protected QualityServicesType.HotWater.IsSignedAct isSignedAct;
        @XmlElement(name = "IsNotSignedAct")
        protected Boolean isNotSignedAct;

        /**
         * Gets the value of the isSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link QualityServicesType.HotWater.IsSignedAct }
         *     
         */
        public QualityServicesType.HotWater.IsSignedAct getIsSignedAct() {
            return isSignedAct;
        }

        /**
         * Sets the value of the isSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link QualityServicesType.HotWater.IsSignedAct }
         *     
         */
        public void setIsSignedAct(QualityServicesType.HotWater.IsSignedAct value) {
            this.isSignedAct = value;
        }

        /**
         * Gets the value of the isNotSignedAct property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsNotSignedAct() {
            return isNotSignedAct;
        }

        /**
         * Sets the value of the isNotSignedAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsNotSignedAct(Boolean value) {
            this.isNotSignedAct = value;
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
         *         &lt;element name="TemperatureConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityTemperature" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}NotConformityTemperatureHotWaterType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *         &lt;element name="VolumeDeg40" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *         &lt;element name="HotWaterConformity"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *                     &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/&gt;
         *         &lt;element name="DaysPressure25" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
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
            "temperatureConformity",
            "durationDeg40",
            "volumeDeg40",
            "hotWaterConformity",
            "durationPressure25",
            "daysPressure25"
        })
        public static class IsSignedAct {

            @XmlElement(name = "TemperatureConformity", required = true)
            protected QualityServicesType.HotWater.IsSignedAct.TemperatureConformity temperatureConformity;
            @XmlElement(name = "DurationDeg40", required = true)
            protected BigDecimal durationDeg40;
            @XmlElement(name = "VolumeDeg40", required = true)
            protected BigDecimal volumeDeg40;
            @XmlElement(name = "HotWaterConformity", required = true)
            protected QualityServicesType.HotWater.IsSignedAct.HotWaterConformity hotWaterConformity;
            @XmlElement(name = "DurationPressure25", required = true)
            protected BigDecimal durationPressure25;
            @XmlElement(name = "DaysPressure25", required = true)
            protected BigDecimal daysPressure25;

            /**
             * Gets the value of the temperatureConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.HotWater.IsSignedAct.TemperatureConformity }
             *     
             */
            public QualityServicesType.HotWater.IsSignedAct.TemperatureConformity getTemperatureConformity() {
                return temperatureConformity;
            }

            /**
             * Sets the value of the temperatureConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.HotWater.IsSignedAct.TemperatureConformity }
             *     
             */
            public void setTemperatureConformity(QualityServicesType.HotWater.IsSignedAct.TemperatureConformity value) {
                this.temperatureConformity = value;
            }

            /**
             * Gets the value of the durationDeg40 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDurationDeg40() {
                return durationDeg40;
            }

            /**
             * Sets the value of the durationDeg40 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDurationDeg40(BigDecimal value) {
                this.durationDeg40 = value;
            }

            /**
             * Gets the value of the volumeDeg40 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getVolumeDeg40() {
                return volumeDeg40;
            }

            /**
             * Sets the value of the volumeDeg40 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setVolumeDeg40(BigDecimal value) {
                this.volumeDeg40 = value;
            }

            /**
             * Gets the value of the hotWaterConformity property.
             * 
             * @return
             *     possible object is
             *     {@link QualityServicesType.HotWater.IsSignedAct.HotWaterConformity }
             *     
             */
            public QualityServicesType.HotWater.IsSignedAct.HotWaterConformity getHotWaterConformity() {
                return hotWaterConformity;
            }

            /**
             * Sets the value of the hotWaterConformity property.
             * 
             * @param value
             *     allowed object is
             *     {@link QualityServicesType.HotWater.IsSignedAct.HotWaterConformity }
             *     
             */
            public void setHotWaterConformity(QualityServicesType.HotWater.IsSignedAct.HotWaterConformity value) {
                this.hotWaterConformity = value;
            }

            /**
             * Gets the value of the durationPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDurationPressure25() {
                return durationPressure25;
            }

            /**
             * Sets the value of the durationPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDurationPressure25(BigDecimal value) {
                this.durationPressure25 = value;
            }

            /**
             * Gets the value of the daysPressure25 property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getDaysPressure25() {
                return daysPressure25;
            }

            /**
             * Sets the value of the daysPressure25 property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setDaysPressure25(BigDecimal value) {
                this.daysPressure25 = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityDays" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceDaysType"/&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityDays"
            })
            public static class HotWaterConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityDays")
                protected BigDecimal notConformityDays;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityDays property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getNotConformityDays() {
                    return notConformityDays;
                }

                /**
                 * Sets the value of the notConformityDays property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setNotConformityDays(BigDecimal value) {
                    this.notConformityDays = value;
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
             *         &lt;element name="Conformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="NotConformed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
             *           &lt;element name="NotConformityTemperature" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}NotConformityTemperatureHotWaterType"/&gt;
             *         &lt;/sequence&gt;
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
                "conformed",
                "notConformed",
                "notConformityTemperature"
            })
            public static class TemperatureConformity {

                @XmlElement(name = "Conformed")
                protected Boolean conformed;
                @XmlElement(name = "NotConformed")
                protected Boolean notConformed;
                @XmlElement(name = "NotConformityTemperature")
                protected NotConformityTemperatureHotWaterType notConformityTemperature;

                /**
                 * Gets the value of the conformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isConformed() {
                    return conformed;
                }

                /**
                 * Sets the value of the conformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setConformed(Boolean value) {
                    this.conformed = value;
                }

                /**
                 * Gets the value of the notConformed property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotConformed() {
                    return notConformed;
                }

                /**
                 * Sets the value of the notConformed property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotConformed(Boolean value) {
                    this.notConformed = value;
                }

                /**
                 * Gets the value of the notConformityTemperature property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NotConformityTemperatureHotWaterType }
                 *     
                 */
                public NotConformityTemperatureHotWaterType getNotConformityTemperature() {
                    return notConformityTemperature;
                }

                /**
                 * Sets the value of the notConformityTemperature property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NotConformityTemperatureHotWaterType }
                 *     
                 */
                public void setNotConformityTemperature(NotConformityTemperatureHotWaterType value) {
                    this.notConformityTemperature = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "notFromContract"
    })
    public static class ObjectAddress
        extends ObjectAddressType
    {

        @XmlElement(name = "NotFromContract")
        protected Boolean notFromContract;

        /**
         * Gets the value of the notFromContract property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotFromContract() {
            return notFromContract;
        }

        /**
         * Sets the value of the notFromContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotFromContract(Boolean value) {
            this.notFromContract = value;
        }

    }

}
