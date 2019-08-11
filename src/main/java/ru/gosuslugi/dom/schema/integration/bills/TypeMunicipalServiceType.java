
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Вид коммунальной услуги
 * 
 * <p>Java class for TypeMunicipalServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeMunicipalServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="Consumption" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Volume" maxOccurs="2"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                           &lt;attribute name="type"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                 &lt;enumeration value="I"/&gt;
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
 *         &lt;element name="Rate" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="6"/&gt;
 *               &lt;totalDigits value="14"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
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
 *         &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Ratio"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="5"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="13"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
 *         &lt;element name="TotalPayable"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CalcExplanation" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="4000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/&gt;
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
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeMunicipalServiceType", propOrder = {
    "serviceType",
    "consumption",
    "rate",
    "amountOfPaymentMunicipalServiceIndividualConsumption",
    "amountOfPaymentMunicipalServiceCommunalConsumption",
    "accountingPeriodTotal",
    "multiplyingFactor",
    "serviceCharge",
    "totalPayable",
    "municipalServiceIndividualConsumptionPayable",
    "municipalServiceCommunalConsumptionPayable",
    "calcExplanation",
    "orgPPAGUID",
    "piecemealPayment",
    "paymentRecalculation",
    "serviceInformation"
})
public class TypeMunicipalServiceType {

    @XmlElement(name = "ServiceType", required = true)
    protected NsiRef serviceType;
    @XmlElement(name = "Consumption")
    protected TypeMunicipalServiceType.Consumption consumption;
    @XmlElement(name = "Rate")
    protected BigDecimal rate;
    @XmlElement(name = "AmountOfPaymentMunicipalServiceIndividualConsumption")
    protected BigDecimal amountOfPaymentMunicipalServiceIndividualConsumption;
    @XmlElement(name = "AmountOfPaymentMunicipalServiceCommunalConsumption")
    protected BigDecimal amountOfPaymentMunicipalServiceCommunalConsumption;
    @XmlElement(name = "AccountingPeriodTotal")
    protected BigDecimal accountingPeriodTotal;
    @XmlElement(name = "MultiplyingFactor")
    protected TypeMunicipalServiceType.MultiplyingFactor multiplyingFactor;
    @XmlElement(name = "ServiceCharge")
    protected ServiceChargeImportType serviceCharge;
    @XmlElement(name = "TotalPayable", required = true)
    protected BigDecimal totalPayable;
    @XmlElement(name = "MunicipalServiceIndividualConsumptionPayable")
    protected BigDecimal municipalServiceIndividualConsumptionPayable;
    @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
    protected BigDecimal municipalServiceCommunalConsumptionPayable;
    @XmlElement(name = "CalcExplanation")
    protected String calcExplanation;
    protected String orgPPAGUID;
    @XmlElement(name = "PiecemealPayment")
    protected PiecemealPayment piecemealPayment;
    @XmlElement(name = "PaymentRecalculation")
    protected TypeMunicipalServiceType.PaymentRecalculation paymentRecalculation;
    @XmlElement(name = "ServiceInformation")
    protected ServiceInformation serviceInformation;

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
     *     {@link TypeMunicipalServiceType.Consumption }
     *     
     */
    public TypeMunicipalServiceType.Consumption getConsumption() {
        return consumption;
    }

    /**
     * Sets the value of the consumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeMunicipalServiceType.Consumption }
     *     
     */
    public void setConsumption(TypeMunicipalServiceType.Consumption value) {
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
     * Gets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountOfPaymentMunicipalServiceIndividualConsumption() {
        return amountOfPaymentMunicipalServiceIndividualConsumption;
    }

    /**
     * Sets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountOfPaymentMunicipalServiceIndividualConsumption(BigDecimal value) {
        this.amountOfPaymentMunicipalServiceIndividualConsumption = value;
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
     * Gets the value of the multiplyingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link TypeMunicipalServiceType.MultiplyingFactor }
     *     
     */
    public TypeMunicipalServiceType.MultiplyingFactor getMultiplyingFactor() {
        return multiplyingFactor;
    }

    /**
     * Sets the value of the multiplyingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeMunicipalServiceType.MultiplyingFactor }
     *     
     */
    public void setMultiplyingFactor(TypeMunicipalServiceType.MultiplyingFactor value) {
        this.multiplyingFactor = value;
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
     * Gets the value of the calcExplanation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalcExplanation() {
        return calcExplanation;
    }

    /**
     * Sets the value of the calcExplanation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalcExplanation(String value) {
        this.calcExplanation = value;
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
     *     {@link TypeMunicipalServiceType.PaymentRecalculation }
     *     
     */
    public TypeMunicipalServiceType.PaymentRecalculation getPaymentRecalculation() {
        return paymentRecalculation;
    }

    /**
     * Sets the value of the paymentRecalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeMunicipalServiceType.PaymentRecalculation }
     *     
     */
    public void setPaymentRecalculation(TypeMunicipalServiceType.PaymentRecalculation value) {
        this.paymentRecalculation = value;
    }

    /**
     * Справочная информация
     * 
     * @return
     *     possible object is
     *     {@link ServiceInformation }
     *     
     */
    public ServiceInformation getServiceInformation() {
        return serviceInformation;
    }

    /**
     * Sets the value of the serviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceInformation }
     *     
     */
    public void setServiceInformation(ServiceInformation value) {
        this.serviceInformation = value;
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
     *         &lt;element name="Volume" maxOccurs="2"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                 &lt;attribute name="type"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                       &lt;enumeration value="I"/&gt;
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
        protected List<TypeMunicipalServiceType.Consumption.Volume> volume;

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
         * {@link TypeMunicipalServiceType.Consumption.Volume }
         * 
         * 
         */
        public List<TypeMunicipalServiceType.Consumption.Volume> getVolume() {
            if (volume == null) {
                volume = new ArrayList<TypeMunicipalServiceType.Consumption.Volume>();
            }
            return this.volume;
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
         *             &lt;enumeration value="I"/&gt;
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
     *         &lt;element name="Ratio"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="5"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="13"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
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

}
