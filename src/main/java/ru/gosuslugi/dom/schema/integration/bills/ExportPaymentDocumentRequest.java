
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" maxOccurs="1000"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *           &lt;choice&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber" maxOccurs="1000"/&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *               &lt;choice&gt;
 *                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountNumber" maxOccurs="1000"/&gt;
 *                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" maxOccurs="1000"/&gt;
 *               &lt;/choice&gt;
 *             &lt;/sequence&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID" maxOccurs="1000"/&gt;
 *             &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/&gt;
 *           &lt;/choice&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paymentDocumentID",
    "year",
    "month",
    "unifiedAccountNumber",
    "fiasHouseGuid",
    "accountNumber",
    "paymentDocumentNumber",
    "serviceID",
    "accountGUID"
})
@XmlRootElement(name = "exportPaymentDocumentRequest")
public class ExportPaymentDocumentRequest
    extends BaseType
{

    @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected List<String> paymentDocumentID;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Short year;
    @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Integer month;
    @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected List<String> unifiedAccountNumber;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "AccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected List<String> accountNumber;
    @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected List<String> paymentDocumentNumber;
    @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected List<String> serviceID;
    @XmlElement(name = "AccountGUID")
    protected List<String> accountGUID;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the paymentDocumentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentDocumentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentDocumentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaymentDocumentID() {
        if (paymentDocumentID == null) {
            paymentDocumentID = new ArrayList<String>();
        }
        return this.paymentDocumentID;
    }

    /**
     * Gets the value of the year property.
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
     * Gets the value of the month property.
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
     * Gets the value of the unifiedAccountNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unifiedAccountNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnifiedAccountNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUnifiedAccountNumber() {
        if (unifiedAccountNumber == null) {
            unifiedAccountNumber = new ArrayList<String>();
        }
        return this.unifiedAccountNumber;
    }

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountNumber() {
        if (accountNumber == null) {
            accountNumber = new ArrayList<String>();
        }
        return this.accountNumber;
    }

    /**
     * Gets the value of the paymentDocumentNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentDocumentNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentDocumentNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaymentDocumentNumber() {
        if (paymentDocumentNumber == null) {
            paymentDocumentNumber = new ArrayList<String>();
        }
        return this.paymentDocumentNumber;
    }

    /**
     * Gets the value of the serviceID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceID() {
        if (serviceID == null) {
            serviceID = new ArrayList<String>();
        }
        return this.serviceID;
    }

    /**
     * Gets the value of the accountGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAccountGUID() {
        if (accountGUID == null) {
            accountGUID = new ArrayList<String>();
        }
        return this.accountGUID;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
