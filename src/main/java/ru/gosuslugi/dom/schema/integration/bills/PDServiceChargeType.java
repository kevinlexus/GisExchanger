
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Потребление и начисление по услугам в ПД
 * 
 * <p>Java class for PDServiceChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PDServiceChargeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="HousingService">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
 *                   &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                             &lt;element name="Consumption" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Volume">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
 *                                               &lt;attribute name="type">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;enumeration value="O"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="determiningMethod">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;length value="1"/>
 *                                                     &lt;enumeration value="N"/>
 *                                                     &lt;enumeration value="M"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Rate">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;fractionDigits value="6"/>
 *                                   &lt;totalDigits value="14"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="AccountingPeriodTotal" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="18"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
 *                             &lt;element name="MunicipalServiceCommunalConsumptionPayable">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="18"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ServiceInformation" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *                                       &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalService">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
 *                   &lt;element name="Consumption" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Volume" maxOccurs="2">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
 *                                     &lt;attribute name="type">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="I"/>
 *                                           &lt;enumeration value="O"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MunicipalService">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/>
 *                   &lt;element name="PaymentRecalculation" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="recalculationReason">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="500"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="sum">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;fractionDigits value="2"/>
 *                                   &lt;minInclusive value="-9999999999.99"/>
 *                                   &lt;maxInclusive value="9999999999.99"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/>
 *                   &lt;element name="Consumption" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Volume" maxOccurs="2">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
 *                                     &lt;attribute name="type">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="I"/>
 *                                           &lt;enumeration value="O"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="determiningMethod">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;length value="1"/>
 *                                           &lt;enumeration value="N"/>
 *                                           &lt;enumeration value="M"/>
 *                                           &lt;enumeration value="O"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="MultiplyingFactor" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Ratio">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="5"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="AmountOfExcessFees" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="18"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;totalDigits value="18"/>
 *                         &lt;fractionDigits value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;totalDigits value="18"/>
 *                         &lt;fractionDigits value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PDServiceChargeType", propOrder = {
    "housingService",
    "additionalService",
    "municipalService"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.ChargeInfo.class
})
public class PDServiceChargeType {

    @XmlElement(name = "HousingService")
    protected PDServiceChargeType.HousingService housingService;
    @XmlElement(name = "AdditionalService")
    protected PDServiceChargeType.AdditionalService additionalService;
    @XmlElement(name = "MunicipalService")
    protected PDServiceChargeType.MunicipalService municipalService;

    /**
     * Gets the value of the housingService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeType.HousingService }
     *     
     */
    public PDServiceChargeType.HousingService getHousingService() {
        return housingService;
    }

    /**
     * Sets the value of the housingService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeType.HousingService }
     *     
     */
    public void setHousingService(PDServiceChargeType.HousingService value) {
        this.housingService = value;
    }

    /**
     * Gets the value of the additionalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeType.AdditionalService }
     *     
     */
    public PDServiceChargeType.AdditionalService getAdditionalService() {
        return additionalService;
    }

    /**
     * Sets the value of the additionalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeType.AdditionalService }
     *     
     */
    public void setAdditionalService(PDServiceChargeType.AdditionalService value) {
        this.additionalService = value;
    }

    /**
     * Gets the value of the municipalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeType.MunicipalService }
     *     
     */
    public PDServiceChargeType.MunicipalService getMunicipalService() {
        return municipalService;
    }

    /**
     * Sets the value of the municipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeType.MunicipalService }
     *     
     */
    public void setMunicipalService(PDServiceChargeType.MunicipalService value) {
        this.municipalService = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
     *         &lt;element name="Consumption" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Volume" maxOccurs="2">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
     *                           &lt;attribute name="type">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="I"/>
     *                                 &lt;enumeration value="O"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
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
        "serviceCharge",
        "consumption"
    })
    public static class AdditionalService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "Consumption")
        protected PDServiceChargeType.AdditionalService.Consumption consumption;

        /**
         * Перерасчеты, льготы, субсидии
         * 
         * @return
         *     possible object is
         *     {@link ServiceChargeType }
         *     
         */
        public ServiceChargeType getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceChargeType }
         *     
         */
        public void setServiceCharge(ServiceChargeType value) {
            this.serviceCharge = value;
        }

        /**
         * Gets the value of the consumption property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeType.AdditionalService.Consumption }
         *     
         */
        public PDServiceChargeType.AdditionalService.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeType.AdditionalService.Consumption }
         *     
         */
        public void setConsumption(PDServiceChargeType.AdditionalService.Consumption value) {
            this.consumption = value;
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
         *         &lt;element name="Volume" maxOccurs="2">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
         *                 &lt;attribute name="type">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="I"/>
         *                       &lt;enumeration value="O"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
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
            "volume"
        })
        public static class Consumption {

            @XmlElement(name = "Volume", required = true)
            protected List<PDServiceChargeType.AdditionalService.Consumption.Volume> volume;

            /**
             * Gets the value of the volume property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the volume property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVolume().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PDServiceChargeType.AdditionalService.Consumption.Volume }
             * 
             * 
             */
            public List<PDServiceChargeType.AdditionalService.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PDServiceChargeType.AdditionalService.Consumption.Volume>();
                }
                return this.volume;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
             *       &lt;attribute name="type">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="I"/>
             *             &lt;enumeration value="O"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Volume {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "type")
                protected String type;

                /**
                 * Тип объема потребления КУ
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
     *       &lt;sequence minOccurs="0">
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
     *         &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *                   &lt;element name="Consumption" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Volume">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
     *                                     &lt;attribute name="type">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;enumeration value="O"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="determiningMethod">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;length value="1"/>
     *                                           &lt;enumeration value="N"/>
     *                                           &lt;enumeration value="M"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Rate">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;fractionDigits value="6"/>
     *                         &lt;totalDigits value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="AccountingPeriodTotal" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="18"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
     *                   &lt;element name="MunicipalServiceCommunalConsumptionPayable">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="18"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ServiceInformation" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
     *                             &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
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
        "serviceCharge",
        "municipalResource"
    })
    public static class HousingService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "MunicipalResource")
        protected List<PDServiceChargeType.HousingService.MunicipalResource> municipalResource;

        /**
         * Перерасчеты, льготы, субсидии
         * 
         * @return
         *     possible object is
         *     {@link ServiceChargeType }
         *     
         */
        public ServiceChargeType getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceChargeType }
         *     
         */
        public void setServiceCharge(ServiceChargeType value) {
            this.serviceCharge = value;
        }

        /**
         * Gets the value of the municipalResource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the municipalResource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMunicipalResource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PDServiceChargeType.HousingService.MunicipalResource }
         * 
         * 
         */
        public List<PDServiceChargeType.HousingService.MunicipalResource> getMunicipalResource() {
            if (municipalResource == null) {
                municipalResource = new ArrayList<PDServiceChargeType.HousingService.MunicipalResource>();
            }
            return this.municipalResource;
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
         *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
         *         &lt;element name="Consumption" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Volume">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
         *                           &lt;attribute name="type">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;enumeration value="O"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="determiningMethod">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;length value="1"/>
         *                                 &lt;enumeration value="N"/>
         *                                 &lt;enumeration value="M"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Rate">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;fractionDigits value="6"/>
         *               &lt;totalDigits value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="AccountingPeriodTotal" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="18"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
         *         &lt;element name="MunicipalServiceCommunalConsumptionPayable">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="18"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ServiceInformation" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
         *                   &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
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
        @XmlType(name = "", propOrder = {
            "serviceType",
            "consumption",
            "rate",
            "accountingPeriodTotal",
            "serviceCharge",
            "municipalServiceCommunalConsumptionPayable",
            "serviceInformation"
        })
        public static class MunicipalResource {

            @XmlElement(name = "ServiceType", required = true)
            protected NsiRef serviceType;
            @XmlElement(name = "Consumption")
            protected PDServiceChargeType.HousingService.MunicipalResource.Consumption consumption;
            @XmlElement(name = "Rate", required = true)
            protected BigDecimal rate;
            @XmlElement(name = "AccountingPeriodTotal")
            protected BigDecimal accountingPeriodTotal;
            @XmlElement(name = "ServiceCharge")
            protected ServiceChargeType serviceCharge;
            @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable", required = true)
            protected BigDecimal municipalServiceCommunalConsumptionPayable;
            @XmlElement(name = "ServiceInformation")
            protected PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation serviceInformation;

            /**
             * Gets the value of the serviceType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getServiceType() {
                return serviceType;
            }

            /**
             * Sets the value of the serviceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setServiceType(NsiRef value) {
                this.serviceType = value;
            }

            /**
             * Gets the value of the consumption property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption }
             *     
             */
            public PDServiceChargeType.HousingService.MunicipalResource.Consumption getConsumption() {
                return consumption;
            }

            /**
             * Sets the value of the consumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption }
             *     
             */
            public void setConsumption(PDServiceChargeType.HousingService.MunicipalResource.Consumption value) {
                this.consumption = value;
            }

            /**
             * Gets the value of the rate property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRate() {
                return rate;
            }

            /**
             * Sets the value of the rate property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRate(BigDecimal value) {
                this.rate = value;
            }

            /**
             * Gets the value of the accountingPeriodTotal property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAccountingPeriodTotal() {
                return accountingPeriodTotal;
            }

            /**
             * Sets the value of the accountingPeriodTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAccountingPeriodTotal(BigDecimal value) {
                this.accountingPeriodTotal = value;
            }

            /**
             * Перерасчеты, льготы, субсидии
             * 
             * @return
             *     possible object is
             *     {@link ServiceChargeType }
             *     
             */
            public ServiceChargeType getServiceCharge() {
                return serviceCharge;
            }

            /**
             * Sets the value of the serviceCharge property.
             * 
             * @param value
             *     allowed object is
             *     {@link ServiceChargeType }
             *     
             */
            public void setServiceCharge(ServiceChargeType value) {
                this.serviceCharge = value;
            }

            /**
             * Gets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getMunicipalServiceCommunalConsumptionPayable() {
                return municipalServiceCommunalConsumptionPayable;
            }

            /**
             * Sets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setMunicipalServiceCommunalConsumptionPayable(BigDecimal value) {
                this.municipalServiceCommunalConsumptionPayable = value;
            }

            /**
             * Gets the value of the serviceInformation property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation }
             *     
             */
            public PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation getServiceInformation() {
                return serviceInformation;
            }

            /**
             * Sets the value of the serviceInformation property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation }
             *     
             */
            public void setServiceInformation(PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation value) {
                this.serviceInformation = value;
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
             *         &lt;element name="Volume">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
             *                 &lt;attribute name="type">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;enumeration value="O"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="determiningMethod">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;length value="1"/>
             *                       &lt;enumeration value="N"/>
             *                       &lt;enumeration value="M"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/extension>
             *             &lt;/simpleContent>
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
                "volume"
            })
            public static class Consumption {

                @XmlElement(name = "Volume", required = true)
                protected PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume volume;

                /**
                 * Gets the value of the volume property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume }
                 *     
                 */
                public PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume getVolume() {
                    return volume;
                }

                /**
                 * Sets the value of the volume property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume }
                 *     
                 */
                public void setVolume(PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume value) {
                    this.volume = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
                 *       &lt;attribute name="type">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;enumeration value="O"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="determiningMethod">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;length value="1"/>
                 *             &lt;enumeration value="N"/>
                 *             &lt;enumeration value="M"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Volume {

                    @XmlValue
                    protected BigDecimal value;
                    @XmlAttribute(name = "type")
                    protected String type;
                    @XmlAttribute(name = "determiningMethod")
                    protected String determiningMethod;

                    /**
                     * Тип объема потребления КУ
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setValue(BigDecimal value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the type property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     * Sets the value of the type property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setType(String value) {
                        this.type = value;
                    }

                    /**
                     * Gets the value of the determiningMethod property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDeterminingMethod() {
                        return determiningMethod;
                    }

                    /**
                     * Sets the value of the determiningMethod property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDeterminingMethod(String value) {
                        this.determiningMethod = value;
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
             *         &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
             *         &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/>
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
                "houseOverallNeedsNorm",
                "houseTotalHouseOverallNeeds"
            })
            public static class ServiceInformation {

                protected BigDecimal houseOverallNeedsNorm;
                protected BigDecimal houseTotalHouseOverallNeeds;

                /**
                 * Gets the value of the houseOverallNeedsNorm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getHouseOverallNeedsNorm() {
                    return houseOverallNeedsNorm;
                }

                /**
                 * Sets the value of the houseOverallNeedsNorm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setHouseOverallNeedsNorm(BigDecimal value) {
                    this.houseOverallNeedsNorm = value;
                }

                /**
                 * Gets the value of the houseTotalHouseOverallNeeds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getHouseTotalHouseOverallNeeds() {
                    return houseTotalHouseOverallNeeds;
                }

                /**
                 * Sets the value of the houseTotalHouseOverallNeeds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setHouseTotalHouseOverallNeeds(BigDecimal value) {
                    this.houseTotalHouseOverallNeeds = value;
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/>
     *         &lt;element name="PaymentRecalculation" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="recalculationReason">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="500"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="sum">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;fractionDigits value="2"/>
     *                         &lt;minInclusive value="-9999999999.99"/>
     *                         &lt;maxInclusive value="9999999999.99"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/>
     *         &lt;element name="Consumption" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Volume" maxOccurs="2">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
     *                           &lt;attribute name="type">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="I"/>
     *                                 &lt;enumeration value="O"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="determiningMethod">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;length value="1"/>
     *                                 &lt;enumeration value="N"/>
     *                                 &lt;enumeration value="M"/>
     *                                 &lt;enumeration value="O"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MultiplyingFactor" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Ratio">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="5"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="AmountOfExcessFees" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="18"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="18"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="18"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "serviceCharge",
        "piecemealPayment",
        "paymentRecalculation",
        "serviceInformation",
        "consumption",
        "multiplyingFactor",
        "municipalServiceIndividualConsumptionPayable",
        "municipalServiceCommunalConsumptionPayable"
    })
    public static class MunicipalService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "PiecemealPayment")
        protected PiecemealPayment piecemealPayment;
        @XmlElement(name = "PaymentRecalculation")
        protected PDServiceChargeType.MunicipalService.PaymentRecalculation paymentRecalculation;
        @XmlElement(name = "ServiceInformation")
        protected ru.gosuslugi.dom.schema.integration.bills.ServiceInformation serviceInformation;
        @XmlElement(name = "Consumption")
        protected PDServiceChargeType.MunicipalService.Consumption consumption;
        @XmlElement(name = "MultiplyingFactor")
        protected PDServiceChargeType.MunicipalService.MultiplyingFactor multiplyingFactor;
        @XmlElement(name = "MunicipalServiceIndividualConsumptionPayable")
        protected BigDecimal municipalServiceIndividualConsumptionPayable;
        @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
        protected BigDecimal municipalServiceCommunalConsumptionPayable;

        /**
         * Перерасчеты, льготы, субсидии
         * 
         * @return
         *     possible object is
         *     {@link ServiceChargeType }
         *     
         */
        public ServiceChargeType getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceChargeType }
         *     
         */
        public void setServiceCharge(ServiceChargeType value) {
            this.serviceCharge = value;
        }

        /**
         * Рассрочка
         * 
         * @return
         *     possible object is
         *     {@link PiecemealPayment }
         *     
         */
        public PiecemealPayment getPiecemealPayment() {
            return piecemealPayment;
        }

        /**
         * Sets the value of the piecemealPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link PiecemealPayment }
         *     
         */
        public void setPiecemealPayment(PiecemealPayment value) {
            this.piecemealPayment = value;
        }

        /**
         * Gets the value of the paymentRecalculation property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeType.MunicipalService.PaymentRecalculation }
         *     
         */
        public PDServiceChargeType.MunicipalService.PaymentRecalculation getPaymentRecalculation() {
            return paymentRecalculation;
        }

        /**
         * Sets the value of the paymentRecalculation property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeType.MunicipalService.PaymentRecalculation }
         *     
         */
        public void setPaymentRecalculation(PDServiceChargeType.MunicipalService.PaymentRecalculation value) {
            this.paymentRecalculation = value;
        }

        /**
         * Справочная информация
         * 
         * @return
         *     possible object is
         *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
         *     
         */
        public ru.gosuslugi.dom.schema.integration.bills.ServiceInformation getServiceInformation() {
            return serviceInformation;
        }

        /**
         * Sets the value of the serviceInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
         *     
         */
        public void setServiceInformation(ru.gosuslugi.dom.schema.integration.bills.ServiceInformation value) {
            this.serviceInformation = value;
        }

        /**
         * Gets the value of the consumption property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeType.MunicipalService.Consumption }
         *     
         */
        public PDServiceChargeType.MunicipalService.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeType.MunicipalService.Consumption }
         *     
         */
        public void setConsumption(PDServiceChargeType.MunicipalService.Consumption value) {
            this.consumption = value;
        }

        /**
         * Gets the value of the multiplyingFactor property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeType.MunicipalService.MultiplyingFactor }
         *     
         */
        public PDServiceChargeType.MunicipalService.MultiplyingFactor getMultiplyingFactor() {
            return multiplyingFactor;
        }

        /**
         * Sets the value of the multiplyingFactor property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeType.MunicipalService.MultiplyingFactor }
         *     
         */
        public void setMultiplyingFactor(PDServiceChargeType.MunicipalService.MultiplyingFactor value) {
            this.multiplyingFactor = value;
        }

        /**
         * Gets the value of the municipalServiceIndividualConsumptionPayable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMunicipalServiceIndividualConsumptionPayable() {
            return municipalServiceIndividualConsumptionPayable;
        }

        /**
         * Sets the value of the municipalServiceIndividualConsumptionPayable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMunicipalServiceIndividualConsumptionPayable(BigDecimal value) {
            this.municipalServiceIndividualConsumptionPayable = value;
        }

        /**
         * Gets the value of the municipalServiceCommunalConsumptionPayable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMunicipalServiceCommunalConsumptionPayable() {
            return municipalServiceCommunalConsumptionPayable;
        }

        /**
         * Sets the value of the municipalServiceCommunalConsumptionPayable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMunicipalServiceCommunalConsumptionPayable(BigDecimal value) {
            this.municipalServiceCommunalConsumptionPayable = value;
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
         *         &lt;element name="Volume" maxOccurs="2">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
         *                 &lt;attribute name="type">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="I"/>
         *                       &lt;enumeration value="O"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="determiningMethod">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;length value="1"/>
         *                       &lt;enumeration value="N"/>
         *                       &lt;enumeration value="M"/>
         *                       &lt;enumeration value="O"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
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
            "volume"
        })
        public static class Consumption {

            @XmlElement(name = "Volume", required = true)
            protected List<PDServiceChargeType.MunicipalService.Consumption.Volume> volume;

            /**
             * Gets the value of the volume property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the volume property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVolume().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PDServiceChargeType.MunicipalService.Consumption.Volume }
             * 
             * 
             */
            public List<PDServiceChargeType.MunicipalService.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PDServiceChargeType.MunicipalService.Consumption.Volume>();
                }
                return this.volume;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
             *       &lt;attribute name="type">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="I"/>
             *             &lt;enumeration value="O"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="determiningMethod">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;length value="1"/>
             *             &lt;enumeration value="N"/>
             *             &lt;enumeration value="M"/>
             *             &lt;enumeration value="O"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Volume {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "type")
                protected String type;
                @XmlAttribute(name = "determiningMethod")
                protected String determiningMethod;

                /**
                 * Тип объема потребления КУ
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Gets the value of the determiningMethod property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDeterminingMethod() {
                    return determiningMethod;
                }

                /**
                 * Sets the value of the determiningMethod property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDeterminingMethod(String value) {
                    this.determiningMethod = value;
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
         *         &lt;element name="Ratio">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="5"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="AmountOfExcessFees" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="18"/>
         *               &lt;fractionDigits value="2"/>
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
            "ratio",
            "amountOfExcessFees"
        })
        public static class MultiplyingFactor {

            @XmlElement(name = "Ratio", required = true)
            protected BigDecimal ratio;
            @XmlElement(name = "AmountOfExcessFees")
            protected BigDecimal amountOfExcessFees;

            /**
             * Gets the value of the ratio property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRatio() {
                return ratio;
            }

            /**
             * Sets the value of the ratio property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRatio(BigDecimal value) {
                this.ratio = value;
            }

            /**
             * Gets the value of the amountOfExcessFees property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountOfExcessFees() {
                return amountOfExcessFees;
            }

            /**
             * Sets the value of the amountOfExcessFees property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountOfExcessFees(BigDecimal value) {
                this.amountOfExcessFees = value;
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
         *         &lt;element name="recalculationReason">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="500"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="sum">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;fractionDigits value="2"/>
         *               &lt;minInclusive value="-9999999999.99"/>
         *               &lt;maxInclusive value="9999999999.99"/>
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
            "recalculationReason",
            "sum"
        })
        public static class PaymentRecalculation {

            @XmlElement(required = true)
            protected String recalculationReason;
            @XmlElement(required = true)
            protected BigDecimal sum;

            /**
             * Gets the value of the recalculationReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecalculationReason() {
                return recalculationReason;
            }

            /**
             * Sets the value of the recalculationReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecalculationReason(String value) {
                this.recalculationReason = value;
            }

            /**
             * Gets the value of the sum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSum() {
                return sum;
            }

            /**
             * Sets the value of the sum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSum(BigDecimal value) {
                this.sum = value;
            }

        }

    }

}
