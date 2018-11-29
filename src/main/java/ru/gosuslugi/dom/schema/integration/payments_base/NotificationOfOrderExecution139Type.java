
package ru.gosuslugi.dom.schema.integration.payments_base;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Извещение о принятии к исполнению распоряжения
 * 
 * <p>Java class for NotificationOfOrderExecution139Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationOfOrderExecution139Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrderInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
 *                   &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="Amount"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                         &lt;totalDigits value="16"/&gt;
 *                         &lt;fractionDigits value="0"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MonthAndYear" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
 *                       &lt;element name="ServiceIDGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
 *                       &lt;element name="PaymentDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="PaymentInformationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
@XmlType(name = "NotificationOfOrderExecution139Type", propOrder = {
    "orderInfo"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.payment.ImportNotificationsOfOrderExecutionRequest.NotificationOfOrderExecution139Type.class
})
public class NotificationOfOrderExecution139Type {

    @XmlElement(name = "OrderInfo", required = true)
    protected NotificationOfOrderExecution139Type.OrderInfo orderInfo;

    /**
     * Gets the value of the orderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationOfOrderExecution139Type.OrderInfo }
     *     
     */
    public NotificationOfOrderExecution139Type.OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets the value of the orderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationOfOrderExecution139Type.OrderInfo }
     *     
     */
    public void setOrderInfo(NotificationOfOrderExecution139Type.OrderInfo value) {
        this.orderInfo = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
     *         &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="Amount"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *               &lt;totalDigits value="16"/&gt;
     *               &lt;fractionDigits value="0"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MonthAndYear" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
     *             &lt;element name="ServiceIDGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
     *             &lt;element name="PaymentDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;/sequence&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="PaymentInformationGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
        "orderID",
        "orderDate",
        "amount",
        "monthAndYear",
        "serviceID",
        "serviceIDGUID",
        "paymentDocumentID",
        "paymentDocumentGUID",
        "paymentInformationGUID"
    })
    public static class OrderInfo {

        @XmlElement(name = "OrderID", required = true)
        protected String orderID;
        @XmlElement(name = "OrderDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar orderDate;
        @XmlElement(name = "Amount", required = true)
        protected BigDecimal amount;
        @XmlElement(name = "MonthAndYear")
        protected NotificationOfOrderExecution139Type.OrderInfo.MonthAndYear monthAndYear;
        @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
        protected String serviceID;
        @XmlElement(name = "ServiceIDGUID")
        protected String serviceIDGUID;
        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentID;
        @XmlElement(name = "PaymentDocumentGUID")
        protected String paymentDocumentGUID;
        @XmlElement(name = "PaymentInformationGUID")
        protected String paymentInformationGUID;

        /**
         * Уникальный номер платежа (идентификатор операции)
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderID() {
            return orderID;
        }

        /**
         * Sets the value of the orderID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderID(String value) {
            this.orderID = value;
        }

        /**
         * Gets the value of the orderDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOrderDate() {
            return orderDate;
        }

        /**
         * Sets the value of the orderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOrderDate(XMLGregorianCalendar value) {
            this.orderDate = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the monthAndYear property.
         * 
         * @return
         *     possible object is
         *     {@link NotificationOfOrderExecution139Type.OrderInfo.MonthAndYear }
         *     
         */
        public NotificationOfOrderExecution139Type.OrderInfo.MonthAndYear getMonthAndYear() {
            return monthAndYear;
        }

        /**
         * Sets the value of the monthAndYear property.
         * 
         * @param value
         *     allowed object is
         *     {@link NotificationOfOrderExecution139Type.OrderInfo.MonthAndYear }
         *     
         */
        public void setMonthAndYear(NotificationOfOrderExecution139Type.OrderInfo.MonthAndYear value) {
            this.monthAndYear = value;
        }

        /**
         * Gets the value of the serviceID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceID() {
            return serviceID;
        }

        /**
         * Sets the value of the serviceID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceID(String value) {
            this.serviceID = value;
        }

        /**
         * Gets the value of the serviceIDGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceIDGUID() {
            return serviceIDGUID;
        }

        /**
         * Sets the value of the serviceIDGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceIDGUID(String value) {
            this.serviceIDGUID = value;
        }

        /**
         * Gets the value of the paymentDocumentID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentDocumentID() {
            return paymentDocumentID;
        }

        /**
         * Sets the value of the paymentDocumentID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentDocumentID(String value) {
            this.paymentDocumentID = value;
        }

        /**
         * Gets the value of the paymentDocumentGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentDocumentGUID() {
            return paymentDocumentGUID;
        }

        /**
         * Sets the value of the paymentDocumentGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentDocumentGUID(String value) {
            this.paymentDocumentGUID = value;
        }

        /**
         * Gets the value of the paymentInformationGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentInformationGUID() {
            return paymentInformationGUID;
        }

        /**
         * Sets the value of the paymentInformationGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentInformationGUID(String value) {
            this.paymentInformationGUID = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
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
            "year",
            "month"
        })
        public static class MonthAndYear {

            @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
            protected short year;
            @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
            protected int month;

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

        }

    }

}
