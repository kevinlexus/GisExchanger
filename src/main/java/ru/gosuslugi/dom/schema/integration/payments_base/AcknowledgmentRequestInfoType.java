
package ru.gosuslugi.dom.schema.integration.payments_base;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Запрос на квитирование
 * 
 * <p>Java class for AcknowledgmentRequestInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcknowledgmentRequestInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/&gt;
 *           &lt;sequence&gt;
 *             &lt;choice&gt;
 *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
 *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderIDMultipurpose"/&gt;
 *             &lt;/choice&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="PaymentDocumentAck"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
 *                     &lt;choice&gt;
 *                       &lt;element name="HSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;element name="ASType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;element name="PServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                     &lt;/choice&gt;
 *                     &lt;element name="Amount"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                           &lt;totalDigits value="13"/&gt;
 *                           &lt;fractionDigits value="2"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
 *                     &lt;element name="PaymentInformation" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="BankBIK" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
 *                                 &lt;element name="operatingAccountNumber"&gt;
 *                                   &lt;simpleType&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                       &lt;length value="20"/&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/simpleType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="AckImpossible"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/&gt;
 *                     &lt;element name="Reason" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="210"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="DelayPeriod" minOccurs="0"&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcknowledgmentRequestInfoType", propOrder = {
    "notificationsOfOrderExecutionGUID",
    "orderID",
    "orderIDMultipurpose",
    "orgPPAGUID",
    "paymentDocumentAck",
    "ackImpossible",
    "delayPeriod"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ImportAcknowledgmentRequest.AcknowledgmentRequestInfo.class
})
public class AcknowledgmentRequestInfoType {

    @XmlElement(name = "NotificationsOfOrderExecutionGUID")
    protected String notificationsOfOrderExecutionGUID;
    @XmlElement(name = "OrderID")
    protected String orderID;
    @XmlElement(name = "OrderIDMultipurpose")
    protected String orderIDMultipurpose;
    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected String orgPPAGUID;
    @XmlElement(name = "PaymentDocumentAck")
    protected AcknowledgmentRequestInfoType.PaymentDocumentAck paymentDocumentAck;
    @XmlElement(name = "AckImpossible")
    protected AcknowledgmentRequestInfoType.AckImpossible ackImpossible;
    @XmlElement(name = "DelayPeriod")
    protected AcknowledgmentRequestInfoType.DelayPeriod delayPeriod;

    /**
     * Gets the value of the notificationsOfOrderExecutionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationsOfOrderExecutionGUID() {
        return notificationsOfOrderExecutionGUID;
    }

    /**
     * Sets the value of the notificationsOfOrderExecutionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationsOfOrderExecutionGUID(String value) {
        this.notificationsOfOrderExecutionGUID = value;
    }

    /**
     * Gets the value of the orderID property.
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
     * Gets the value of the orderIDMultipurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderIDMultipurpose() {
        return orderIDMultipurpose;
    }

    /**
     * Sets the value of the orderIDMultipurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderIDMultipurpose(String value) {
        this.orderIDMultipurpose = value;
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
     * Gets the value of the paymentDocumentAck property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck }
     *     
     */
    public AcknowledgmentRequestInfoType.PaymentDocumentAck getPaymentDocumentAck() {
        return paymentDocumentAck;
    }

    /**
     * Sets the value of the paymentDocumentAck property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck }
     *     
     */
    public void setPaymentDocumentAck(AcknowledgmentRequestInfoType.PaymentDocumentAck value) {
        this.paymentDocumentAck = value;
    }

    /**
     * Gets the value of the ackImpossible property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgmentRequestInfoType.AckImpossible }
     *     
     */
    public AcknowledgmentRequestInfoType.AckImpossible getAckImpossible() {
        return ackImpossible;
    }

    /**
     * Sets the value of the ackImpossible property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgmentRequestInfoType.AckImpossible }
     *     
     */
    public void setAckImpossible(AcknowledgmentRequestInfoType.AckImpossible value) {
        this.ackImpossible = value;
    }

    /**
     * Gets the value of the delayPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgmentRequestInfoType.DelayPeriod }
     *     
     */
    public AcknowledgmentRequestInfoType.DelayPeriod getDelayPeriod() {
        return delayPeriod;
    }

    /**
     * Sets the value of the delayPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgmentRequestInfoType.DelayPeriod }
     *     
     */
    public void setDelayPeriod(AcknowledgmentRequestInfoType.DelayPeriod value) {
        this.delayPeriod = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/&gt;
     *         &lt;element name="Reason" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="210"/&gt;
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
        "paymentDocumentID",
        "reason"
    })
    public static class AckImpossible {

        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentID;
        @XmlElement(name = "Reason")
        protected String reason;

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
         * Gets the value of the reason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReason() {
            return reason;
        }

        /**
         * Sets the value of the reason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReason(String value) {
            this.reason = value;
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
    public static class DelayPeriod {

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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="HSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="ASType" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="PServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="Amount"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="13"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
     *         &lt;element name="PaymentInformation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="BankBIK" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
     *                     &lt;element name="operatingAccountNumber"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;length value="20"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                 &lt;/choice&gt;
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
    @XmlType(name = "", propOrder = {
        "paymentDocumentID",
        "hsType",
        "msType",
        "asType",
        "pServiceType",
        "amount",
        "paymentDocumentNumber",
        "paymentInformation"
    })
    public static class PaymentDocumentAck {

        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/", required = true)
        protected String paymentDocumentID;
        @XmlElement(name = "HSType")
        protected String hsType;
        @XmlElement(name = "MSType")
        protected String msType;
        @XmlElement(name = "ASType")
        protected String asType;
        @XmlElement(name = "PServiceType")
        protected NsiRef pServiceType;
        @XmlElement(name = "Amount", required = true)
        protected BigDecimal amount;
        @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentNumber;
        @XmlElement(name = "PaymentInformation")
        protected AcknowledgmentRequestInfoType.PaymentDocumentAck.PaymentInformation paymentInformation;

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
         * Gets the value of the hsType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHSType() {
            return hsType;
        }

        /**
         * Sets the value of the hsType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHSType(String value) {
            this.hsType = value;
        }

        /**
         * Gets the value of the msType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMSType() {
            return msType;
        }

        /**
         * Sets the value of the msType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMSType(String value) {
            this.msType = value;
        }

        /**
         * Gets the value of the asType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getASType() {
            return asType;
        }

        /**
         * Sets the value of the asType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setASType(String value) {
            this.asType = value;
        }

        /**
         * Gets the value of the pServiceType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getPServiceType() {
            return pServiceType;
        }

        /**
         * Sets the value of the pServiceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setPServiceType(NsiRef value) {
            this.pServiceType = value;
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
         * Gets the value of the paymentDocumentNumber property.
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
         * Gets the value of the paymentInformation property.
         * 
         * @return
         *     possible object is
         *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck.PaymentInformation }
         *     
         */
        public AcknowledgmentRequestInfoType.PaymentDocumentAck.PaymentInformation getPaymentInformation() {
            return paymentInformation;
        }

        /**
         * Sets the value of the paymentInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcknowledgmentRequestInfoType.PaymentDocumentAck.PaymentInformation }
         *     
         */
        public void setPaymentInformation(AcknowledgmentRequestInfoType.PaymentDocumentAck.PaymentInformation value) {
            this.paymentInformation = value;
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
         *       &lt;choice&gt;
         *         &lt;sequence&gt;
         *           &lt;element name="BankBIK" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
         *           &lt;element name="operatingAccountNumber"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                 &lt;length value="20"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="PaymentInformationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "bankBIK",
            "operatingAccountNumber",
            "paymentInformationGuid"
        })
        public static class PaymentInformation {

            @XmlElement(name = "BankBIK")
            protected String bankBIK;
            protected String operatingAccountNumber;
            @XmlElement(name = "PaymentInformationGuid")
            protected String paymentInformationGuid;

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

}
