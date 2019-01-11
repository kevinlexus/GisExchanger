
package ru.gosuslugi.dom.schema.integration.bills;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CapitalRepairYearImportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapitalRepairYearImportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CapitalRepairMonthlyCharge" maxOccurs="12" minOccurs="12"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairMonthlyImportType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
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
@XmlType(name = "CapitalRepairYearImportType", propOrder = {
    "capitalRepairMonthlyCharge",
    "year",
    "orgPPAGUID",
    "paymentInformationKey"
})
public class CapitalRepairYearImportType {

    @XmlElement(name = "CapitalRepairMonthlyCharge", required = true)
    protected List<CapitalRepairYearImportType.CapitalRepairMonthlyCharge> capitalRepairMonthlyCharge;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected short year;
    protected String orgPPAGUID;
    @XmlElement(name = "PaymentInformationKey")
    protected String paymentInformationKey;

    /**
     * Gets the value of the capitalRepairMonthlyCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capitalRepairMonthlyCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapitalRepairMonthlyCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapitalRepairYearImportType.CapitalRepairMonthlyCharge }
     * 
     * 
     */
    public List<CapitalRepairYearImportType.CapitalRepairMonthlyCharge> getCapitalRepairMonthlyCharge() {
        if (capitalRepairMonthlyCharge == null) {
            capitalRepairMonthlyCharge = new ArrayList<CapitalRepairYearImportType.CapitalRepairMonthlyCharge>();
        }
        return this.capitalRepairMonthlyCharge;
    }

    /**
     * Год расчетного периода
     * 
     */
    public short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(short value) {
        this.year = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}CapitalRepairMonthlyImportType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
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
        "month"
    })
    public static class CapitalRepairMonthlyCharge
        extends CapitalRepairMonthlyImportType
    {

        @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected int month;

        /**
         * Год расчетного периода
         * 
         */
        public int getMonth() {
            return month;
        }

        /**
         * Sets the value of the month property.
         * 
         */
        public void setMonth(int value) {
            this.month = value;
        }

    }

}