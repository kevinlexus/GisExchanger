
package ru.gosuslugi.dom.schema.integration.payments_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Сведения о платежных реквизитах организации
 * 
 * <p>Java class for PaymentInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RecipientINN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INNType"/&gt;
 *         &lt;element name="RecipientKPP" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPPType" minOccurs="0"/&gt;
 *         &lt;element name="BankName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="45"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentRecipient"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="160"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BankBIK" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
 *         &lt;element name="operatingAccountNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CorrespondentBankAccount" type="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountType" minOccurs="0"/&gt;
 *         &lt;element name="KBK" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="20"/&gt;
 *               &lt;pattern value="[0-9]{20}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMOImportType" minOccurs="0"/&gt;
 *         &lt;element name="NumberBudgetaryAccount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;pattern value="[0-9]{1,30}"/&gt;
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
@XmlType(name = "PaymentInformationType", propOrder = {
    "recipientINN",
    "recipientKPP",
    "bankName",
    "paymentRecipient",
    "bankBIK",
    "operatingAccountNumber",
    "correspondentBankAccount",
    "kbk",
    "oktmo",
    "numberBudgetaryAccount"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.payments_base.NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation.class
})
public class PaymentInformationType {

    @XmlElement(name = "RecipientINN", required = true)
    protected String recipientINN;
    @XmlElement(name = "RecipientKPP")
    protected String recipientKPP;
    @XmlElement(name = "BankName", required = true)
    protected String bankName;
    @XmlElement(name = "PaymentRecipient", required = true)
    protected String paymentRecipient;
    @XmlElement(name = "BankBIK", required = true)
    protected String bankBIK;
    @XmlElement(required = true)
    protected String operatingAccountNumber;
    @XmlElement(name = "CorrespondentBankAccount")
    protected String correspondentBankAccount;
    @XmlElement(name = "KBK")
    protected String kbk;
    @XmlElement(name = "OKTMO")
    protected String oktmo;
    @XmlElement(name = "NumberBudgetaryAccount")
    protected String numberBudgetaryAccount;

    /**
     * Gets the value of the recipientINN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientINN() {
        return recipientINN;
    }

    /**
     * Sets the value of the recipientINN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientINN(String value) {
        this.recipientINN = value;
    }

    /**
     * Gets the value of the recipientKPP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientKPP() {
        return recipientKPP;
    }

    /**
     * Sets the value of the recipientKPP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientKPP(String value) {
        this.recipientKPP = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the paymentRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentRecipient() {
        return paymentRecipient;
    }

    /**
     * Sets the value of the paymentRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentRecipient(String value) {
        this.paymentRecipient = value;
    }

    /**
     * Gets the value of the bankBIK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankBIK() {
        return bankBIK;
    }

    /**
     * Sets the value of the bankBIK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankBIK(String value) {
        this.bankBIK = value;
    }

    /**
     * Gets the value of the operatingAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatingAccountNumber() {
        return operatingAccountNumber;
    }

    /**
     * Sets the value of the operatingAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatingAccountNumber(String value) {
        this.operatingAccountNumber = value;
    }

    /**
     * Gets the value of the correspondentBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrespondentBankAccount() {
        return correspondentBankAccount;
    }

    /**
     * Sets the value of the correspondentBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrespondentBankAccount(String value) {
        this.correspondentBankAccount = value;
    }

    /**
     * Gets the value of the kbk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKBK() {
        return kbk;
    }

    /**
     * Sets the value of the kbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKBK(String value) {
        this.kbk = value;
    }

    /**
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKTMO(String value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the numberBudgetaryAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberBudgetaryAccount() {
        return numberBudgetaryAccount;
    }

    /**
     * Sets the value of the numberBudgetaryAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberBudgetaryAccount(String value) {
        this.numberBudgetaryAccount = value;
    }

}
