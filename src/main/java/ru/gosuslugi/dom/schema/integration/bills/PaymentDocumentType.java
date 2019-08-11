
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Платежный документ (ПД)
 * 
 * <p>Java class for PaymentDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountGuid"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="ChargeInfo" maxOccurs="unbounded" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceChargeType"&gt;
 *                   &lt;/extension&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="CapitalRepairCharge" minOccurs="0"&gt;
 *                 &lt;complexType&gt;
 *                   &lt;complexContent&gt;
 *                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairImportType"&gt;
 *                     &lt;/extension&gt;
 *                   &lt;/complexContent&gt;
 *                 &lt;/complexType&gt;
 *               &lt;/element&gt;
 *               &lt;element name="CapitalRepairYearCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairYearImportType" minOccurs="0"/&gt;
 *             &lt;/sequence&gt;
 *             &lt;element name="Insurance" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/&gt;
 *                       &lt;element name="Rate"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                             &lt;fractionDigits value="6"/&gt;
 *                             &lt;totalDigits value="14"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="TotalPayable"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
 *                             &lt;totalDigits value="13"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
 *                             &lt;totalDigits value="13"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="CalcExplanation" minOccurs="0"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;minLength value="1"/&gt;
 *                             &lt;maxLength value="500"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
 *                       &lt;element name="Consumption" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="Volume" maxOccurs="2"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;simpleContent&gt;
 *                                       &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                                         &lt;attribute name="type"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;enumeration value="I"/&gt;
 *                                               &lt;enumeration value="O"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/attribute&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/simpleContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                       &lt;element name="PaymentInformationKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;element name="PenaltiesAndCourtCosts" maxOccurs="unbounded" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                       &lt;element name="Cause"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;minLength value="1"/&gt;
 *                             &lt;maxLength value="1000"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="TotalPayable"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                             &lt;totalDigits value="13"/&gt;
 *                             &lt;fractionDigits value="2"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                       &lt;element name="PaymentInformationKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="CapitalRepairDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills/}DebtImportCRType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *             &lt;element name="ChargeDebt" type="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceDebtImportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="Expose" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Withdraw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="TotalPayableByChargeInfo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DebtPreviousPeriods" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minInclusive value="-99999999.99"/&gt;
 *               &lt;maxInclusive value="99999999.99"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdvanceBllingPeriod" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minInclusive value="-99999999.99"/&gt;
 *               &lt;maxInclusive value="99999999.99"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="totalPiecemealPaymentSum" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;totalDigits value="13"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentsTaken" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="31"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdditionalInformation" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="1000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalPayableByPDWithDebtAndAdvance" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalByPenaltiesAndCourtCosts" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalPayableByPD" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ComponentsOfCost" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nameComponent" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="cost"&gt;
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
 *         &lt;element name="PaidCash" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DateOfLastReceivedPayment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="LimitIndex" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxExclusive value="1000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SubsidiesCompensationSocialSupport" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;maxExclusive value="100000000"/&gt;
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
@XmlType(name = "PaymentDocumentType", propOrder = {
    "accountGuid",
    "paymentDocumentNumber",
    "chargeInfo",
    "capitalRepairCharge",
    "capitalRepairYearCharge",
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
    "totalPayableByPDWithDebtAndAdvance",
    "totalByPenaltiesAndCourtCosts",
    "totalPayableByPD",
    "componentsOfCost",
    "paidCash",
    "dateOfLastReceivedPayment",
    "limitIndex",
    "subsidiesCompensationSocialSupport"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.PaymentDocument.class
})
public class PaymentDocumentType {

    @XmlElement(name = "AccountGuid", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
    protected String accountGuid;
    @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected String paymentDocumentNumber;
    @XmlElement(name = "ChargeInfo")
    protected List<PaymentDocumentType.ChargeInfo> chargeInfo;
    @XmlElement(name = "CapitalRepairCharge")
    protected PaymentDocumentType.CapitalRepairCharge capitalRepairCharge;
    @XmlElement(name = "CapitalRepairYearCharge")
    protected CapitalRepairYearImportType capitalRepairYearCharge;
    @XmlElement(name = "Insurance")
    protected PaymentDocumentType.Insurance insurance;
    @XmlElement(name = "PenaltiesAndCourtCosts")
    protected List<PaymentDocumentType.PenaltiesAndCourtCosts> penaltiesAndCourtCosts;
    @XmlElement(name = "CapitalRepairDebt")
    protected List<DebtImportCRType> capitalRepairDebt;
    @XmlElement(name = "ChargeDebt")
    protected List<PDServiceDebtImportType> chargeDebt;
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
    @XmlElement(name = "TotalPayableByPDWithDebtAndAdvance")
    protected BigDecimal totalPayableByPDWithDebtAndAdvance;
    @XmlElement(name = "TotalByPenaltiesAndCourtCosts")
    protected BigDecimal totalByPenaltiesAndCourtCosts;
    @XmlElement(name = "TotalPayableByPD")
    protected BigDecimal totalPayableByPD;
    @XmlElement(name = "ComponentsOfCost")
    protected List<PaymentDocumentType.ComponentsOfCost> componentsOfCost;
    @XmlElement(name = "PaidCash")
    protected BigDecimal paidCash;
    @XmlElement(name = "DateOfLastReceivedPayment")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfLastReceivedPayment;
    @XmlElement(name = "LimitIndex")
    protected BigDecimal limitIndex;
    @XmlElement(name = "SubsidiesCompensationSocialSupport")
    protected BigDecimal subsidiesCompensationSocialSupport;

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
     * {@link PaymentDocumentType.ChargeInfo }
     * 
     * 
     */
    public List<PaymentDocumentType.ChargeInfo> getChargeInfo() {
        if (chargeInfo == null) {
            chargeInfo = new ArrayList<PaymentDocumentType.ChargeInfo>();
        }
        return this.chargeInfo;
    }

    /**
     * Gets the value of the capitalRepairCharge property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocumentType.CapitalRepairCharge }
     *     
     */
    public PaymentDocumentType.CapitalRepairCharge getCapitalRepairCharge() {
        return capitalRepairCharge;
    }

    /**
     * Sets the value of the capitalRepairCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentType.CapitalRepairCharge }
     *     
     */
    public void setCapitalRepairCharge(PaymentDocumentType.CapitalRepairCharge value) {
        this.capitalRepairCharge = value;
    }

    /**
     * Gets the value of the capitalRepairYearCharge property.
     * 
     * @return
     *     possible object is
     *     {@link CapitalRepairYearImportType }
     *     
     */
    public CapitalRepairYearImportType getCapitalRepairYearCharge() {
        return capitalRepairYearCharge;
    }

    /**
     * Sets the value of the capitalRepairYearCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapitalRepairYearImportType }
     *     
     */
    public void setCapitalRepairYearCharge(CapitalRepairYearImportType value) {
        this.capitalRepairYearCharge = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocumentType.Insurance }
     *     
     */
    public PaymentDocumentType.Insurance getInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentType.Insurance }
     *     
     */
    public void setInsurance(PaymentDocumentType.Insurance value) {
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
     * {@link PaymentDocumentType.PenaltiesAndCourtCosts }
     * 
     * 
     */
    public List<PaymentDocumentType.PenaltiesAndCourtCosts> getPenaltiesAndCourtCosts() {
        if (penaltiesAndCourtCosts == null) {
            penaltiesAndCourtCosts = new ArrayList<PaymentDocumentType.PenaltiesAndCourtCosts>();
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
     * {@link DebtImportCRType }
     * 
     * 
     */
    public List<DebtImportCRType> getCapitalRepairDebt() {
        if (capitalRepairDebt == null) {
            capitalRepairDebt = new ArrayList<DebtImportCRType>();
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
     * {@link PDServiceDebtImportType }
     * 
     * 
     */
    public List<PDServiceDebtImportType> getChargeDebt() {
        if (chargeDebt == null) {
            chargeDebt = new ArrayList<PDServiceDebtImportType>();
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
     * Gets the value of the totalByPenaltiesAndCourtCosts property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalByPenaltiesAndCourtCosts() {
        return totalByPenaltiesAndCourtCosts;
    }

    /**
     * Sets the value of the totalByPenaltiesAndCourtCosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalByPenaltiesAndCourtCosts(BigDecimal value) {
        this.totalByPenaltiesAndCourtCosts = value;
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
     * Gets the value of the componentsOfCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componentsOfCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponentsOfCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentDocumentType.ComponentsOfCost }
     * 
     * 
     */
    public List<PaymentDocumentType.ComponentsOfCost> getComponentsOfCost() {
        if (componentsOfCost == null) {
            componentsOfCost = new ArrayList<PaymentDocumentType.ComponentsOfCost>();
        }
        return this.componentsOfCost;
    }

    /**
     * Gets the value of the paidCash property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPaidCash() {
        return paidCash;
    }

    /**
     * Sets the value of the paidCash property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPaidCash(BigDecimal value) {
        this.paidCash = value;
    }

    /**
     * Gets the value of the dateOfLastReceivedPayment property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfLastReceivedPayment() {
        return dateOfLastReceivedPayment;
    }

    /**
     * Sets the value of the dateOfLastReceivedPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfLastReceivedPayment(XMLGregorianCalendar value) {
        this.dateOfLastReceivedPayment = value;
    }

    /**
     * Gets the value of the limitIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLimitIndex() {
        return limitIndex;
    }

    /**
     * Sets the value of the limitIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLimitIndex(BigDecimal value) {
        this.limitIndex = value;
    }

    /**
     * Gets the value of the subsidiesCompensationSocialSupport property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSubsidiesCompensationSocialSupport() {
        return subsidiesCompensationSocialSupport;
    }

    /**
     * Sets the value of the subsidiesCompensationSocialSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSubsidiesCompensationSocialSupport(BigDecimal value) {
        this.subsidiesCompensationSocialSupport = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairImportType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CapitalRepairCharge
        extends CapitalRepairImportType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceChargeType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ChargeInfo
        extends PDServiceChargeType
    {


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
     *         &lt;element name="nameComponent" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="cost"&gt;
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
        "nameComponent",
        "cost"
    })
    public static class ComponentsOfCost {

        @XmlElement(required = true)
        protected NsiRef nameComponent;
        @XmlElement(required = true)
        protected BigDecimal cost;

        /**
         * Gets the value of the nameComponent property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getNameComponent() {
            return nameComponent;
        }

        /**
         * Sets the value of the nameComponent property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setNameComponent(NsiRef value) {
            this.nameComponent = value;
        }

        /**
         * Gets the value of the cost property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getCost() {
            return cost;
        }

        /**
         * Sets the value of the cost property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setCost(BigDecimal value) {
            this.cost = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID"/&gt;
     *         &lt;element name="Rate"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;fractionDigits value="6"/&gt;
     *               &lt;totalDigits value="14"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TotalPayable"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
     *               &lt;totalDigits value="13"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
     *               &lt;totalDigits value="13"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CalcExplanation" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="500"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
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
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="PaymentInformationKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "insuranceProductGUID",
        "rate",
        "totalPayable",
        "accountingPeriodTotal",
        "calcExplanation",
        "serviceCharge",
        "consumption",
        "orgPPAGUID",
        "paymentInformationKey"
    })
    public static class Insurance {

        @XmlElement(name = "InsuranceProductGUID", required = true)
        protected String insuranceProductGUID;
        @XmlElement(name = "Rate", required = true)
        protected BigDecimal rate;
        @XmlElement(name = "TotalPayable", required = true)
        protected BigDecimal totalPayable;
        @XmlElement(name = "AccountingPeriodTotal")
        protected BigDecimal accountingPeriodTotal;
        @XmlElement(name = "CalcExplanation")
        protected String calcExplanation;
        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeImportType serviceCharge;
        @XmlElement(name = "Consumption")
        protected PaymentDocumentType.Insurance.Consumption consumption;
        protected String orgPPAGUID;
        @XmlElement(name = "PaymentInformationKey")
        protected String paymentInformationKey;

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
         * Gets the value of the consumption property.
         * 
         * @return
         *     possible object is
         *     {@link PaymentDocumentType.Insurance.Consumption }
         *     
         */
        public PaymentDocumentType.Insurance.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PaymentDocumentType.Insurance.Consumption }
         *     
         */
        public void setConsumption(PaymentDocumentType.Insurance.Consumption value) {
            this.consumption = value;
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
         * Gets the value of the paymentInformationKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationKey() {
            return paymentInformationKey;
        }

        /**
         * Sets the value of the paymentInformationKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationKey(String value) {
            this.paymentInformationKey = value;
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
            protected List<PaymentDocumentType.Insurance.Consumption.Volume> volume;

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
             * {@link PaymentDocumentType.Insurance.Consumption.Volume }
             * 
             * 
             */
            public List<PaymentDocumentType.Insurance.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PaymentDocumentType.Insurance.Consumption.Volume>();
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="Cause"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="1000"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TotalPayable"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="13"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="PaymentInformationKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "serviceType",
        "cause",
        "totalPayable",
        "orgPPAGUID",
        "paymentInformationKey"
    })
    public static class PenaltiesAndCourtCosts {

        @XmlElement(name = "ServiceType", required = true)
        protected NsiRef serviceType;
        @XmlElement(name = "Cause", required = true)
        protected String cause;
        @XmlElement(name = "TotalPayable", required = true)
        protected BigDecimal totalPayable;
        protected String orgPPAGUID;
        @XmlElement(name = "PaymentInformationKey")
        protected String paymentInformationKey;

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

        /**
         * Gets the value of the paymentInformationKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationKey() {
            return paymentInformationKey;
        }

        /**
         * Sets the value of the paymentInformationKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationKey(String value) {
            this.paymentInformationKey = value;
        }

    }

}
