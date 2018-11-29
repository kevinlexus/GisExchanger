
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.math.BigInteger;
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
 * <p>Java class for PaymentDocumentExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDocumentExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountGuid"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
 *         &lt;element name="AddressInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="LivingPersonsNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *                   &lt;element name="ResidentialSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
 *                   &lt;element name="HeatedArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
 *                   &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="ChargeInfo" type="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceChargeExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *             &lt;choice&gt;
 *               &lt;element name="CapitalRepairCharge" minOccurs="0"&gt;
 *                 &lt;complexType&gt;
 *                   &lt;complexContent&gt;
 *                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairType"&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                       &lt;/sequence&gt;
 *                     &lt;/extension&gt;
 *                   &lt;/complexContent&gt;
 *                 &lt;/complexType&gt;
 *               &lt;/element&gt;
 *               &lt;element name="CapitalRepairYearCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairYearImportType" minOccurs="0"/&gt;
 *             &lt;/choice&gt;
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
 *                             &lt;totalDigits value="18"/&gt;
 *                             &lt;fractionDigits value="2"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                       &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;element name="Insurance" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID" minOccurs="0"/&gt;
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
 *                             &lt;totalDigits value="18"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="AccountingPeriodTotal"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
 *                             &lt;totalDigits value="18"/&gt;
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
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/&gt;
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
 *                       &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="CapitalRepairDebt" maxOccurs="unbounded" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}DebtType"&gt;
 *                     &lt;sequence minOccurs="0"&gt;
 *                       &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/extension&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;element name="ChargeDebt" maxOccurs="unbounded" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceDebtType"&gt;
 *                   &lt;/extension&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="Expose" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Withdraw" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="TotalPayableByChargeInfo" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="18"/&gt;
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
 *               &lt;totalDigits value="18"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentsTaken" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *               &lt;minInclusive value="0"/&gt;
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
 *         &lt;element name="TotalPayableByPD" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="18"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalByPenaltiesAndCourtCosts" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="18"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TotalPayableByPDWithDebtAndAdvance" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="18"/&gt;
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
 *                         &lt;totalDigits value="18"/&gt;
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
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month" minOccurs="0"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year" minOccurs="0"/&gt;
 *         &lt;element name="PaymentProviderInformation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
@XmlType(name = "PaymentDocumentExportType", propOrder = {
    "accountGuid",
    "paymentDocumentNumber",
    "addressInfo",
    "chargeInfo",
    "capitalRepairCharge",
    "capitalRepairYearCharge",
    "penaltiesAndCourtCosts",
    "insurance",
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
    "totalByPenaltiesAndCourtCosts",
    "totalPayableByPDWithDebtAndAdvance",
    "componentsOfCost",
    "paidCash",
    "dateOfLastReceivedPayment",
    "month",
    "year",
    "paymentProviderInformation"
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
    protected PaymentDocumentExportType.CapitalRepairCharge capitalRepairCharge;
    @XmlElement(name = "CapitalRepairYearCharge")
    protected CapitalRepairYearImportType capitalRepairYearCharge;
    @XmlElement(name = "PenaltiesAndCourtCosts")
    protected List<PaymentDocumentExportType.PenaltiesAndCourtCosts> penaltiesAndCourtCosts;
    @XmlElement(name = "Insurance")
    protected PaymentDocumentExportType.Insurance insurance;
    @XmlElement(name = "CapitalRepairDebt")
    protected List<PaymentDocumentExportType.CapitalRepairDebt> capitalRepairDebt;
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
    @XmlElement(name = "TotalByPenaltiesAndCourtCosts")
    protected BigDecimal totalByPenaltiesAndCourtCosts;
    @XmlElement(name = "TotalPayableByPDWithDebtAndAdvance")
    protected BigDecimal totalPayableByPDWithDebtAndAdvance;
    @XmlElement(name = "ComponentsOfCost")
    protected List<PaymentDocumentExportType.ComponentsOfCost> componentsOfCost;
    @XmlElement(name = "PaidCash")
    protected BigDecimal paidCash;
    @XmlElement(name = "DateOfLastReceivedPayment")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfLastReceivedPayment;
    @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Integer month;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Short year;
    @XmlElement(name = "PaymentProviderInformation")
    protected PaymentDocumentExportType.PaymentProviderInformation paymentProviderInformation;

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
     *     {@link PaymentDocumentExportType.CapitalRepairCharge }
     *     
     */
    public PaymentDocumentExportType.CapitalRepairCharge getCapitalRepairCharge() {
        return capitalRepairCharge;
    }

    /**
     * Sets the value of the capitalRepairCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentExportType.CapitalRepairCharge }
     *     
     */
    public void setCapitalRepairCharge(PaymentDocumentExportType.CapitalRepairCharge value) {
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
     * {@link PaymentDocumentExportType.CapitalRepairDebt }
     * 
     * 
     */
    public List<PaymentDocumentExportType.CapitalRepairDebt> getCapitalRepairDebt() {
        if (capitalRepairDebt == null) {
            capitalRepairDebt = new ArrayList<PaymentDocumentExportType.CapitalRepairDebt>();
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
     * {@link PaymentDocumentExportType.ComponentsOfCost }
     * 
     * 
     */
    public List<PaymentDocumentExportType.ComponentsOfCost> getComponentsOfCost() {
        if (componentsOfCost == null) {
            componentsOfCost = new ArrayList<PaymentDocumentExportType.ComponentsOfCost>();
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
     * Месяц расчетного периода
     * Ссылка на пост. 924 – Приложение 2, п. 6 в).
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMonth(Integer value) {
        this.month = value;
    }

    /**
     * Год расчетного периода
     * Ссылка на пост. 924 – Приложение 2, п. 6 в).
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setYear(Short value) {
        this.year = value;
    }

    /**
     * Gets the value of the paymentProviderInformation property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDocumentExportType.PaymentProviderInformation }
     *     
     */
    public PaymentDocumentExportType.PaymentProviderInformation getPaymentProviderInformation() {
        return paymentProviderInformation;
    }

    /**
     * Sets the value of the paymentProviderInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDocumentExportType.PaymentProviderInformation }
     *     
     */
    public void setPaymentProviderInformation(PaymentDocumentExportType.PaymentProviderInformation value) {
        this.paymentProviderInformation = value;
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
     *         &lt;element name="LivingPersonsNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
     *         &lt;element name="ResidentialSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
     *         &lt;element name="HeatedArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
     *         &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaExportType" minOccurs="0"/&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "paymentInformationGuid"
    })
    public static class CapitalRepairCharge
        extends CapitalRepairType
    {

        @XmlElement(name = "PaymentInformationGuid")
        protected String paymentInformationGuid;

        /**
         * Gets the value of the paymentInformationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationGuid() {
            return paymentInformationGuid;
        }

        /**
         * Sets the value of the paymentInformationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationGuid(String value) {
            this.paymentInformationGuid = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}DebtType"&gt;
     *       &lt;sequence minOccurs="0"&gt;
     *         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "paymentInformationGuid"
    })
    public static class CapitalRepairDebt
        extends DebtType
    {

        @XmlElement(name = "PaymentInformationGuid")
        protected String paymentInformationGuid;

        /**
         * Gets the value of the paymentInformationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationGuid() {
            return paymentInformationGuid;
        }

        /**
         * Sets the value of the paymentInformationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationGuid(String value) {
            this.paymentInformationGuid = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}PDServiceDebtType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="nameComponent" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="cost"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="18"/&gt;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}InsuranceProductGUID" minOccurs="0"/&gt;
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
     *               &lt;totalDigits value="18"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AccountingPeriodTotal"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/bills-base/}MoneyType"&gt;
     *               &lt;totalDigits value="18"/&gt;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceCharge" minOccurs="0"/&gt;
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
     *         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "paymentInformationGuid"
    })
    public static class Insurance {

        @XmlElement(name = "InsuranceProductGUID")
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
        protected String orgPPAGUID;
        @XmlElement(name = "PaymentInformationGuid")
        protected String paymentInformationGuid;

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
         * Gets the value of the paymentInformationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationGuid() {
            return paymentInformationGuid;
        }

        /**
         * Sets the value of the paymentInformationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationGuid(String value) {
            this.paymentInformationGuid = value;
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
            protected List<PaymentDocumentExportType.Insurance.Consumption.Volume> volume;

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
             * {@link PaymentDocumentExportType.Insurance.Consumption.Volume }
             * 
             * 
             */
            public List<PaymentDocumentExportType.Insurance.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PaymentDocumentExportType.Insurance.Consumption.Volume>();
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
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "orgPPAGUID"
    })
    public static class PaymentProviderInformation {

        @XmlElement(required = true)
        protected String orgPPAGUID;

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
     *               &lt;totalDigits value="18"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "paymentInformationGuid"
    })
    public static class PenaltiesAndCourtCosts {

        @XmlElement(name = "ServiceType", required = true)
        protected NsiRef serviceType;
        @XmlElement(name = "Cause", required = true)
        protected String cause;
        @XmlElement(name = "TotalPayable", required = true)
        protected BigDecimal totalPayable;
        protected String orgPPAGUID;
        @XmlElement(name = "PaymentInformationGuid")
        protected String paymentInformationGuid;

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
         * Gets the value of the paymentInformationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationGuid() {
            return paymentInformationGuid;
        }

        /**
         * Sets the value of the paymentInformationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationGuid(String value) {
            this.paymentInformationGuid = value;
        }

    }

}
