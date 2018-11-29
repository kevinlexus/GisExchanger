
package ru.gosuslugi.dom.schema.integration.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Основные сведения по перечню работ/услуг
 * 
 * <p>Java class for WorkingListBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkingListBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WorkListGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *         &lt;element name="MonthYearFrom"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MonthYearTo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkingListBaseType", propOrder = {
    "workListGUID",
    "fiasHouseGuid",
    "monthYearFrom",
    "monthYearTo",
    "contractGUID"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.services.ImportWorkingListRequest.ApprovedWorkingListData.class,
    ru.gosuslugi.dom.schema.integration.services.ExportWorkingListResultType.WorkingList.class
})
public class WorkingListBaseType {

    @XmlElement(name = "WorkListGUID")
    protected String workListGUID;
    @XmlElement(name = "FIASHouseGuid", required = true)
    protected String fiasHouseGuid;
    @XmlElement(name = "MonthYearFrom", required = true)
    protected WorkingListBaseType.MonthYearFrom monthYearFrom;
    @XmlElement(name = "MonthYearTo", required = true)
    protected WorkingListBaseType.MonthYearTo monthYearTo;
    @XmlElement(name = "ContractGUID")
    protected String contractGUID;

    /**
     * Gets the value of the workListGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkListGUID() {
        return workListGUID;
    }

    /**
     * Sets the value of the workListGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkListGUID(String value) {
        this.workListGUID = value;
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
     * Gets the value of the monthYearFrom property.
     * 
     * @return
     *     possible object is
     *     {@link WorkingListBaseType.MonthYearFrom }
     *     
     */
    public WorkingListBaseType.MonthYearFrom getMonthYearFrom() {
        return monthYearFrom;
    }

    /**
     * Sets the value of the monthYearFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkingListBaseType.MonthYearFrom }
     *     
     */
    public void setMonthYearFrom(WorkingListBaseType.MonthYearFrom value) {
        this.monthYearFrom = value;
    }

    /**
     * Gets the value of the monthYearTo property.
     * 
     * @return
     *     possible object is
     *     {@link WorkingListBaseType.MonthYearTo }
     *     
     */
    public WorkingListBaseType.MonthYearTo getMonthYearTo() {
        return monthYearTo;
    }

    /**
     * Sets the value of the monthYearTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkingListBaseType.MonthYearTo }
     *     
     */
    public void setMonthYearTo(WorkingListBaseType.MonthYearTo value) {
        this.monthYearTo = value;
    }

    /**
     * Gets the value of the contractGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractGUID() {
        return contractGUID;
    }

    /**
     * Sets the value of the contractGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractGUID(String value) {
        this.contractGUID = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
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
        "month",
        "year"
    })
    public static class MonthYearFrom {

        @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected int month;
        @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected short year;

        /**
         * Gets the value of the month property.
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

        /**
         * Gets the value of the year property.
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
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
        "month",
        "year"
    })
    public static class MonthYearTo {

        @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected int month;
        @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected short year;

        /**
         * Gets the value of the month property.
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

        /**
         * Gets the value of the year property.
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

    }

}
