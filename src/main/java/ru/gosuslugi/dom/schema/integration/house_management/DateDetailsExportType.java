
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateDetailsExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateDetailsExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeriodMetering" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/&gt;
 *                   &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentDocumentInterval" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="StartDate"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PaymentInterval" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="StartDate"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
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
@XmlType(name = "DateDetailsExportType", propOrder = {
    "periodMetering",
    "paymentDocumentInterval",
    "paymentInterval"
})
public class DateDetailsExportType {

    @XmlElement(name = "PeriodMetering")
    protected DateDetailsExportType.PeriodMetering periodMetering;
    @XmlElement(name = "PaymentDocumentInterval")
    protected DateDetailsExportType.PaymentDocumentInterval paymentDocumentInterval;
    @XmlElement(name = "PaymentInterval")
    protected DateDetailsExportType.PaymentInterval paymentInterval;

    /**
     * Gets the value of the periodMetering property.
     * 
     * @return
     *     possible object is
     *     {@link DateDetailsExportType.PeriodMetering }
     *     
     */
    public DateDetailsExportType.PeriodMetering getPeriodMetering() {
        return periodMetering;
    }

    /**
     * Sets the value of the periodMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateDetailsExportType.PeriodMetering }
     *     
     */
    public void setPeriodMetering(DateDetailsExportType.PeriodMetering value) {
        this.periodMetering = value;
    }

    /**
     * Gets the value of the paymentDocumentInterval property.
     * 
     * @return
     *     possible object is
     *     {@link DateDetailsExportType.PaymentDocumentInterval }
     *     
     */
    public DateDetailsExportType.PaymentDocumentInterval getPaymentDocumentInterval() {
        return paymentDocumentInterval;
    }

    /**
     * Sets the value of the paymentDocumentInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateDetailsExportType.PaymentDocumentInterval }
     *     
     */
    public void setPaymentDocumentInterval(DateDetailsExportType.PaymentDocumentInterval value) {
        this.paymentDocumentInterval = value;
    }

    /**
     * Gets the value of the paymentInterval property.
     * 
     * @return
     *     possible object is
     *     {@link DateDetailsExportType.PaymentInterval }
     *     
     */
    public DateDetailsExportType.PaymentInterval getPaymentInterval() {
        return paymentInterval;
    }

    /**
     * Sets the value of the paymentInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateDetailsExportType.PaymentInterval }
     *     
     */
    public void setPaymentInterval(DateDetailsExportType.PaymentInterval value) {
        this.paymentInterval = value;
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
     *         &lt;choice&gt;
     *           &lt;element name="StartDate"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
     *         &lt;choice&gt;
     *           &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *           &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
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
        "startDate",
        "lastDay",
        "currentMounth",
        "nextMounth"
    })
    public static class PaymentDocumentInterval {

        @XmlElement(name = "StartDate")
        protected Byte startDate;
        @XmlElement(name = "LastDay")
        protected Boolean lastDay;
        @XmlElement(name = "CurrentMounth")
        protected Boolean currentMounth;
        @XmlElement(name = "NextMounth")
        protected Boolean nextMounth;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStartDate(Byte value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the lastDay property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isLastDay() {
            return lastDay;
        }

        /**
         * Sets the value of the lastDay property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLastDay(Boolean value) {
            this.lastDay = value;
        }

        /**
         * Gets the value of the currentMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCurrentMounth() {
            return currentMounth;
        }

        /**
         * Sets the value of the currentMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCurrentMounth(Boolean value) {
            this.currentMounth = value;
        }

        /**
         * Gets the value of the nextMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNextMounth() {
            return nextMounth;
        }

        /**
         * Sets the value of the nextMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNextMounth(Boolean value) {
            this.nextMounth = value;
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
     *         &lt;choice&gt;
     *           &lt;element name="StartDate"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
     *         &lt;choice&gt;
     *           &lt;element name="CurrentMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *           &lt;element name="NextMounth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
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
        "startDate",
        "lastDay",
        "currentMounth",
        "nextMounth"
    })
    public static class PaymentInterval {

        @XmlElement(name = "StartDate")
        protected Byte startDate;
        @XmlElement(name = "LastDay")
        protected Boolean lastDay;
        @XmlElement(name = "CurrentMounth")
        protected Boolean currentMounth;
        @XmlElement(name = "NextMounth")
        protected Boolean nextMounth;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setStartDate(Byte value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the lastDay property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isLastDay() {
            return lastDay;
        }

        /**
         * Sets the value of the lastDay property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLastDay(Boolean value) {
            this.lastDay = value;
        }

        /**
         * Gets the value of the currentMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCurrentMounth() {
            return currentMounth;
        }

        /**
         * Sets the value of the currentMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCurrentMounth(Boolean value) {
            this.currentMounth = value;
        }

        /**
         * Gets the value of the nextMounth property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNextMounth() {
            return nextMounth;
        }

        /**
         * Sets the value of the nextMounth property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNextMounth(Boolean value) {
            this.nextMounth = value;
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
     *         &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/&gt;
     *         &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/&gt;
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
        "startDate",
        "endDate"
    })
    public static class PeriodMetering {

        @XmlElement(name = "StartDate")
        protected DaySelectionExportType startDate;
        @XmlElement(name = "EndDate")
        protected DaySelectionExportType endDate;

        /**
         * Gets the value of the startDate property.
         * 
         * @return
         *     possible object is
         *     {@link DaySelectionExportType }
         *     
         */
        public DaySelectionExportType getStartDate() {
            return startDate;
        }

        /**
         * Sets the value of the startDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DaySelectionExportType }
         *     
         */
        public void setStartDate(DaySelectionExportType value) {
            this.startDate = value;
        }

        /**
         * Gets the value of the endDate property.
         * 
         * @return
         *     possible object is
         *     {@link DaySelectionExportType }
         *     
         */
        public DaySelectionExportType getEndDate() {
            return endDate;
        }

        /**
         * Sets the value of the endDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link DaySelectionExportType }
         *     
         */
        public void setEndDate(DaySelectionExportType value) {
            this.endDate = value;
        }

    }

}
