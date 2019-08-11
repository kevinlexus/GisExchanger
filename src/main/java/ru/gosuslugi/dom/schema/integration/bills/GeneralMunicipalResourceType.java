
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for GeneralMunicipalResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeneralMunicipalResourceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="Consumption" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Volume"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                           &lt;attribute name="type"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="O"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                           &lt;attribute name="determiningMethod"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;length value="1"/&gt;
 *                                 &lt;enumeration value="N"/&gt;
 *                                 &lt;enumeration value="M"/&gt;
 *                                 &lt;enumeration value="O"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Rate"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="6"/&gt;
 *               &lt;totalDigits value="14"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
 *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="recalculationReason"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="500"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="sum"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                         &lt;minInclusive value="-9999999999.99"/&gt;
 *                         &lt;maxInclusive value="9999999999.99"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalPayable"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServiceInformation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                   &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                   &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneralMunicipalResourceType", propOrder = {
    "serviceType",
    "consumption",
    "rate",
    "amountOfPaymentMunicipalServiceCommunalConsumption",
    "accountingPeriodTotal",
    "serviceCharge",
    "municipalServiceCommunalConsumptionPayable",
    "paymentRecalculation",
    "totalPayable",
    "serviceInformation",
    "orgPPAGUID"
})
public class GeneralMunicipalResourceType {

    @XmlElement(name = "ServiceType", required = true)
    protected NsiRef serviceType;
    @XmlElement(name = "Consumption")
    protected GeneralMunicipalResourceType.Consumption consumption;
    @XmlElement(name = "Rate", required = true)
    protected BigDecimal rate;
    @XmlElement(name = "AmountOfPaymentMunicipalServiceCommunalConsumption")
    protected BigDecimal amountOfPaymentMunicipalServiceCommunalConsumption;
    @XmlElement(name = "AccountingPeriodTotal")
    protected BigDecimal accountingPeriodTotal;
    @XmlElement(name = "ServiceCharge")
    protected ServiceChargeImportType serviceCharge;
    @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
    protected BigDecimal municipalServiceCommunalConsumptionPayable;
    @XmlElement(name = "PaymentRecalculation")
    protected GeneralMunicipalResourceType.PaymentRecalculation paymentRecalculation;
    @XmlElement(name = "TotalPayable", required = true)
    protected BigDecimal totalPayable;
    @XmlElement(name = "ServiceInformation")
    protected GeneralMunicipalResourceType.ServiceInformation serviceInformation;
    protected String orgPPAGUID;

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
     *     {@link GeneralMunicipalResourceType.Consumption }
     *     
     */
    public GeneralMunicipalResourceType.Consumption getConsumption() {
        return consumption;
    }

    /**
     * Sets the value of the consumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMunicipalResourceType.Consumption }
     *     
     */
    public void setConsumption(GeneralMunicipalResourceType.Consumption value) {
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
     * Gets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOfPaymentMunicipalServiceCommunalConsumption() {
        return amountOfPaymentMunicipalServiceCommunalConsumption;
    }

    /**
     * Sets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOfPaymentMunicipalServiceCommunalConsumption(BigDecimal value) {
        this.amountOfPaymentMunicipalServiceCommunalConsumption = value;
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
     * Gets the value of the serviceCharge property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceChargeImportType }
     *     
     */
    public ServiceChargeImportType getServiceCharge() {
        return serviceCharge;
    }

    /**
     * Sets the value of the serviceCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceChargeImportType }
     *     
     */
    public void setServiceCharge(ServiceChargeImportType value) {
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
     * Gets the value of the paymentRecalculation property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralMunicipalResourceType.PaymentRecalculation }
     *     
     */
    public GeneralMunicipalResourceType.PaymentRecalculation getPaymentRecalculation() {
        return paymentRecalculation;
    }

    /**
     * Sets the value of the paymentRecalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMunicipalResourceType.PaymentRecalculation }
     *     
     */
    public void setPaymentRecalculation(GeneralMunicipalResourceType.PaymentRecalculation value) {
        this.paymentRecalculation = value;
    }

    /**
     * Gets the value of the totalPayable property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPayable() {
        return totalPayable;
    }

    /**
     * Sets the value of the totalPayable property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPayable(BigDecimal value) {
        this.totalPayable = value;
    }

    /**
     * Gets the value of the serviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralMunicipalResourceType.ServiceInformation }
     *     
     */
    public GeneralMunicipalResourceType.ServiceInformation getServiceInformation() {
        return serviceInformation;
    }

    /**
     * Sets the value of the serviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralMunicipalResourceType.ServiceInformation }
     *     
     */
    public void setServiceInformation(GeneralMunicipalResourceType.ServiceInformation value) {
        this.serviceInformation = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
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
     *         &lt;element name="Volume"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                 &lt;attribute name="type"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;enumeration value="O"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *                 &lt;attribute name="determiningMethod"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;length value="1"/&gt;
     *                       &lt;enumeration value="N"/&gt;
     *                       &lt;enumeration value="M"/&gt;
     *                       &lt;enumeration value="O"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
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
        "volume"
    })
    public static class Consumption {

        @XmlElement(name = "Volume", required = true)
        protected GeneralMunicipalResourceType.Consumption.Volume volume;

        /**
         * Gets the value of the volume property.
         * 
         * @return
         *     possible object is
         *     {@link GeneralMunicipalResourceType.Consumption.Volume }
         *     
         */
        public GeneralMunicipalResourceType.Consumption.Volume getVolume() {
            return volume;
        }

        /**
         * Sets the value of the volume property.
         * 
         * @param value
         *     allowed object is
         *     {@link GeneralMunicipalResourceType.Consumption.Volume }
         *     
         */
        public void setVolume(GeneralMunicipalResourceType.Consumption.Volume value) {
            this.volume = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
         *       &lt;attribute name="type"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="O"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *       &lt;attribute name="determiningMethod"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;length value="1"/&gt;
         *             &lt;enumeration value="N"/&gt;
         *             &lt;enumeration value="M"/&gt;
         *             &lt;enumeration value="O"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="recalculationReason"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="500"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="sum"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *               &lt;minInclusive value="-9999999999.99"/&gt;
     *               &lt;maxInclusive value="9999999999.99"/&gt;
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
     *         &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
     *         &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
     *         &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
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
        "houseOverallNeedsNorm",
        "houseOverallNeedsCurrentValue",
        "houseTotalHouseOverallNeeds"
    })
    public static class ServiceInformation {

        protected BigDecimal houseOverallNeedsNorm;
        protected BigDecimal houseOverallNeedsCurrentValue;
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
         * Gets the value of the houseOverallNeedsCurrentValue property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getHouseOverallNeedsCurrentValue() {
            return houseOverallNeedsCurrentValue;
        }

        /**
         * Sets the value of the houseOverallNeedsCurrentValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setHouseOverallNeedsCurrentValue(BigDecimal value) {
            this.houseOverallNeedsCurrentValue = value;
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
