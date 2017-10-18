
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 * Платежный документ (ПД)
 * 
 * <p>Java class for PaymentDocumentExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDocumentExportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountGuid"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/>
 *         &lt;element name="AddressInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LivingPersonsNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="ResidentialSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
 *                   &lt;element name="HeatedArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
 *                   &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="ChargeInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceChargeExportType" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="CapitalRepairCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairType" minOccurs="0"/>
 *             &lt;element name="Insurance" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/>
 *                       &lt;element name="Rate">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                             &lt;fractionDigits value="6"/>
 *                             &lt;totalDigits value="14"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="TotalPayable" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *                       &lt;element name="AccountingPeriodTotal" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
 *                       &lt;element name="CalcExplanation" minOccurs="0">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;minLength value="1"/>
 *                             &lt;maxLength value="500"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
 *                       &lt;element name="Consumption" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                               &lt;sequence>
 *                                 &lt;element name="Volume">
 *                                   &lt;complexType>
 *                                     &lt;simpleContent>
 *                                       &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
 *                                         &lt;attribute name="type">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                               &lt;enumeration value="I"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/attribute>
 *                                       &lt;/extension>
 *                                     &lt;/simpleContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                             &lt;/restriction>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *             &lt;element name="PenaltiesAndCourtCosts" maxOccurs="unbounded" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                       &lt;element name="Cause">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;minLength value="1"/>
 *                             &lt;maxLength value="1000"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="TotalPayable">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                             &lt;totalDigits value="20"/>
 *                             &lt;fractionDigits value="2"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="CapitalRepairDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills/}DebtType" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="ChargeDebt" maxOccurs="unbounded" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceDebtType">
 *                   &lt;/extension>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Expose" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="Withdraw" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="TotalPayableByChargeInfo" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="18"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DebtPreviousPeriods" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="-99999999.99"/>
 *               &lt;maxInclusive value="99999999.99"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AdvanceBllingPeriod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="-99999999.99"/>
 *               &lt;maxInclusive value="99999999.99"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="totalPiecemealPaymentSum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PaymentsTaken" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="31"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AdditionalInformation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalPayableByPD" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="20"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TotalPayableByPDWithDebtAndAdvance" minOccurs="0">
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
@XmlType(name = "PaymentDocumentExportType", propOrder = {
    "accountGuid",
    "paymentDocumentNumber",
    "addressInfo",
    "chargeInfo",
    "capitalRepairCharge",
    "insurance",
    "penaltiesAndCourtCosts",
    "capitalRepairDebt",
    "chargeDebt",
    "expose",
    "withdraw",
    "totalPayableByChargeInfo",
    "debtPreviousPeriods",
    "advanceBllingPeriod",
    "totalPiecemealPaymentSum",
    "paymentsTaken",
    "additionalInformation",
    "totalPayableByPD",
    "totalPayableByPDWithDebtAndAdvance"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ExportPaymentDocumentResultType.PaymentDocument.class
})
public class PaymentDocumentExportType {

    @XmlElement(name = "AccountGuid", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
    protected String accountGuid;
    @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected String paymentDocumentNumber;
    @XmlElement(name = "AddressInfo")
    protected PaymentDocumentExportType.AddressInfo addressInfo;
    @XmlElement(name = "ChargeInfo")
    protected List<PDServiceChargeExportType> chargeInfo;
    @XmlElement(name = "CapitalRepairCharge")
    protected CapitalRepairType capitalRepairCharge;
    @XmlElement(name = "Insurance")
    protected PaymentDocumentExportType.Insurance insurance;
    @XmlElement(name = "PenaltiesAndCourtCosts")
    protected List<PaymentDocumentExportType.PenaltiesAndCourtCosts> penaltiesAndCourtCosts;
    @XmlElement(name = "CapitalRepairDebt")
    protected List<DebtType> capitalRepairDebt;
    @XmlElement(name = "ChargeDebt")
    protected List<PaymentDocumentExportType.ChargeDebt> chargeDebt;
    @XmlElement(name = "Expose")
    protected Boolean expose;
    @XmlElement(name = "Withdraw")
    protected Boolean withdraw;
    @XmlElement(name = "TotalPayableByChargeInfo")
    protected BigDecimal totalPayableByChargeInfo;
    @XmlElement(name = "DebtPreviousPeriods")
    protected BigDecimal debtPreviousPeriods;
    @XmlElement(name = "AdvanceBllingPeriod")
    protected BigDecimal advanceBllingPeriod;
    protected BigDecimal totalPiecemealPaymentSum;
    @XmlElement(name = "PaymentsTaken")
    protected Byte paymentsTaken;
    @XmlElement(name = "AdditionalInformation")
    protected String additionalInformation;
    @XmlElement(name = "TotalPayableByPD")
    protected BigDecimal totalPayableByPD;
    @XmlElement(name = "TotalPayableByPDWithDebtAndAdvance")
    protected BigDecimal totalPayableByPDWithDebtAndAdvance;

    /**
     * Идентификатор лицевого счета
     * Ссылка на пост. 924 – Приложение 2, п. 2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountGuid() {
        return accountGuid;
    }

    /**
     * Sets the value of the accountGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountGuid(String value) {
        this.accountGuid = value;
    }

    /**
     * Номер платежного документа, по которому внесена плата, присвоенный такому документу исполнителем в целях осуществления расчетов по внесению платы
     * Ссылка на пост. 924 – Приложение 2, п. 2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDocumentNumber() {
        return paymentDocumentNumber;
    }

    /**
     * Sets the value of the paymentDocumentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDocumentNumber(String value) {
        this.paymentDocumentNumber = value;
    }

    /**
     * Gets the value of the addressInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocumentExportType.AddressInfo }
     *     
     */
    public PaymentDocumentExportType.AddressInfo getAddressInfo() {
        return addressInfo;
    }

    /**
     * Sets the value of the addressInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentExportType.AddressInfo }
     *     
     */
    public void setAddressInfo(PaymentDocumentExportType.AddressInfo value) {
        this.addressInfo = value;
    }

    /**
     * Gets the value of the chargeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PDServiceChargeExportType }
     * 
     * 
     */
    public List<PDServiceChargeExportType> getChargeInfo() {
        if (chargeInfo == null) {
            chargeInfo = new ArrayList<PDServiceChargeExportType>();
        }
        return this.chargeInfo;
    }

    /**
     * Gets the value of the capitalRepairCharge property.
     * 
     * @return
     *     possible object is
     *     {@link CapitalRepairType }
     *     
     */
    public CapitalRepairType getCapitalRepairCharge() {
        return capitalRepairCharge;
    }

    /**
     * Sets the value of the capitalRepairCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapitalRepairType }
     *     
     */
    public void setCapitalRepairCharge(CapitalRepairType value) {
        this.capitalRepairCharge = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocumentExportType.Insurance }
     *     
     */
    public PaymentDocumentExportType.Insurance getInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentExportType.Insurance }
     *     
     */
    public void setInsurance(PaymentDocumentExportType.Insurance value) {
        this.insurance = value;
    }

    /**
     * Gets the value of the penaltiesAndCourtCosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the penaltiesAndCourtCosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPenaltiesAndCourtCosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDocumentExportType.PenaltiesAndCourtCosts }
     * 
     * 
     */
    public List<PaymentDocumentExportType.PenaltiesAndCourtCosts> getPenaltiesAndCourtCosts() {
        if (penaltiesAndCourtCosts == null) {
            penaltiesAndCourtCosts = new ArrayList<PaymentDocumentExportType.PenaltiesAndCourtCosts>();
        }
        return this.penaltiesAndCourtCosts;
    }

    /**
     * Gets the value of the capitalRepairDebt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capitalRepairDebt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapitalRepairDebt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DebtType }
     * 
     * 
     */
    public List<DebtType> getCapitalRepairDebt() {
        if (capitalRepairDebt == null) {
            capitalRepairDebt = new ArrayList<DebtType>();
        }
        return this.capitalRepairDebt;
    }

    /**
     * Gets the value of the chargeDebt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeDebt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeDebt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDocumentExportType.ChargeDebt }
     * 
     * 
     */
    public List<PaymentDocumentExportType.ChargeDebt> getChargeDebt() {
        if (chargeDebt == null) {
            chargeDebt = new ArrayList<PaymentDocumentExportType.ChargeDebt>();
        }
        return this.chargeDebt;
    }

    /**
     * Gets the value of the expose property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpose() {
        return expose;
    }

    /**
     * Sets the value of the expose property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpose(Boolean value) {
        this.expose = value;
    }

    /**
     * Gets the value of the withdraw property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithdraw() {
        return withdraw;
    }

    /**
     * Sets the value of the withdraw property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithdraw(Boolean value) {
        this.withdraw = value;
    }

    /**
     * Gets the value of the totalPayableByChargeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPayableByChargeInfo() {
        return totalPayableByChargeInfo;
    }

    /**
     * Sets the value of the totalPayableByChargeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPayableByChargeInfo(BigDecimal value) {
        this.totalPayableByChargeInfo = value;
    }

    /**
     * Gets the value of the debtPreviousPeriods property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebtPreviousPeriods() {
        return debtPreviousPeriods;
    }

    /**
     * Sets the value of the debtPreviousPeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebtPreviousPeriods(BigDecimal value) {
        this.debtPreviousPeriods = value;
    }

    /**
     * Gets the value of the advanceBllingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAdvanceBllingPeriod() {
        return advanceBllingPeriod;
    }

    /**
     * Sets the value of the advanceBllingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAdvanceBllingPeriod(BigDecimal value) {
        this.advanceBllingPeriod = value;
    }

    /**
     * Gets the value of the totalPiecemealPaymentSum property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPiecemealPaymentSum() {
        return totalPiecemealPaymentSum;
    }

    /**
     * Sets the value of the totalPiecemealPaymentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPiecemealPaymentSum(BigDecimal value) {
        this.totalPiecemealPaymentSum = value;
    }

    /**
     * Gets the value of the paymentsTaken property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPaymentsTaken() {
        return paymentsTaken;
    }

    /**
     * Sets the value of the paymentsTaken property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPaymentsTaken(Byte value) {
        this.paymentsTaken = value;
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
     * Gets the value of the totalPayableByPD property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPayableByPD() {
        return totalPayableByPD;
    }

    /**
     * Sets the value of the totalPayableByPD property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPayableByPD(BigDecimal value) {
        this.totalPayableByPD = value;
    }

    /**
     * Gets the value of the totalPayableByPDWithDebtAndAdvance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPayableByPDWithDebtAndAdvance() {
        return totalPayableByPDWithDebtAndAdvance;
    }

    /**
     * Sets the value of the totalPayableByPDWithDebtAndAdvance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPayableByPDWithDebtAndAdvance(BigDecimal value) {
        this.totalPayableByPDWithDebtAndAdvance = value;
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
     *         &lt;element name="LivingPersonsNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="ResidentialSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
     *         &lt;element name="HeatedArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
     *         &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/>
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
        "livingPersonsNumber",
        "residentialSquare",
        "heatedArea",
        "totalSquare"
    })
    public static class AddressInfo {

        @XmlElement(name = "LivingPersonsNumber")
        protected BigInteger livingPersonsNumber;
        @XmlElement(name = "ResidentialSquare")
        protected BigDecimal residentialSquare;
        @XmlElement(name = "HeatedArea")
        protected BigDecimal heatedArea;
        @XmlElement(name = "TotalSquare")
        protected BigDecimal totalSquare;

        /**
         * Gets the value of the livingPersonsNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getLivingPersonsNumber() {
            return livingPersonsNumber;
        }

        /**
         * Sets the value of the livingPersonsNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setLivingPersonsNumber(BigInteger value) {
            this.livingPersonsNumber = value;
        }

        /**
         * Gets the value of the residentialSquare property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getResidentialSquare() {
            return residentialSquare;
        }

        /**
         * Sets the value of the residentialSquare property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setResidentialSquare(BigDecimal value) {
            this.residentialSquare = value;
        }

        /**
         * Gets the value of the heatedArea property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getHeatedArea() {
            return heatedArea;
        }

        /**
         * Sets the value of the heatedArea property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setHeatedArea(BigDecimal value) {
            this.heatedArea = value;
        }

        /**
         * Gets the value of the totalSquare property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSquare() {
            return totalSquare;
        }

        /**
         * Sets the value of the totalSquare property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSquare(BigDecimal value) {
            this.totalSquare = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceDebtType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ChargeDebt
        extends PDServiceDebtType
    {


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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/>
     *         &lt;element name="Rate">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="6"/>
     *               &lt;totalDigits value="14"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotalPayable" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
     *         &lt;element name="AccountingPeriodTotal" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"/>
     *         &lt;element name="CalcExplanation" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="500"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/>
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
     *                                 &lt;enumeration value="I"/>
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "insuranceProductGUID",
        "rate",
        "totalPayable",
        "accountingPeriodTotal",
        "calcExplanation",
        "serviceCharge",
        "consumption"
    })
    public static class Insurance {

        @XmlElement(name = "InsuranceProductGUID", required = true)
        protected String insuranceProductGUID;
        @XmlElement(name = "Rate", required = true)
        protected BigDecimal rate;
        @XmlElement(name = "TotalPayable", required = true)
        protected BigDecimal totalPayable;
        @XmlElement(name = "AccountingPeriodTotal", required = true)
        protected BigDecimal accountingPeriodTotal;
        @XmlElement(name = "CalcExplanation")
        protected String calcExplanation;
        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "Consumption")
        protected PaymentDocumentExportType.Insurance.Consumption consumption;

        /**
         * Gets the value of the insuranceProductGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInsuranceProductGUID() {
            return insuranceProductGUID;
        }

        /**
         * Sets the value of the insuranceProductGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInsuranceProductGUID(String value) {
            this.insuranceProductGUID = value;
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
         *     {@link PaymentDocumentExportType.Insurance.Consumption }
         *     
         */
        public PaymentDocumentExportType.Insurance.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PaymentDocumentExportType.Insurance.Consumption }
         *     
         */
        public void setConsumption(PaymentDocumentExportType.Insurance.Consumption value) {
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
         *         &lt;element name="Volume">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/>ConsumptionVolumeType">
         *                 &lt;attribute name="type">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="I"/>
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
            protected PaymentDocumentExportType.Insurance.Consumption.Volume volume;

            /**
             * Gets the value of the volume property.
             * 
             * @return
             *     possible object is
             *     {@link PaymentDocumentExportType.Insurance.Consumption.Volume }
             *     
             */
            public PaymentDocumentExportType.Insurance.Consumption.Volume getVolume() {
                return volume;
            }

            /**
             * Sets the value of the volume property.
             * 
             * @param value
             *     allowed object is
             *     {@link PaymentDocumentExportType.Insurance.Consumption.Volume }
             *     
             */
            public void setVolume(PaymentDocumentExportType.Insurance.Consumption.Volume value) {
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
             *             &lt;enumeration value="I"/>
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="Cause">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="1000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TotalPayable">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="20"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
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
        "cause",
        "totalPayable",
        "orgPPAGUID"
    })
    public static class PenaltiesAndCourtCosts {

        @XmlElement(name = "ServiceType", required = true)
        protected NsiRef serviceType;
        @XmlElement(name = "Cause", required = true)
        protected String cause;
        @XmlElement(name = "TotalPayable", required = true)
        protected BigDecimal totalPayable;
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
         * Gets the value of the cause property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCause() {
            return cause;
        }

        /**
         * Sets the value of the cause property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCause(String value) {
            this.cause = value;
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

    }

}
