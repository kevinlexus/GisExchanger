
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
import ru.gosuslugi.dom.schema.integration.payments_base.AcknowledgmentRequestInfoType;


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
 *         &lt;element name="AcknowledgmentRequestInfo" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AckCancellation" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/&gt;
 *                     &lt;sequence&gt;
 *                       &lt;choice&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderIDMultipurpose"/&gt;
 *                       &lt;/choice&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.2""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "acknowledgmentRequestInfo",
    "ackCancellation"
})
@XmlRootElement(name = "importAcknowledgmentRequest")
public class ImportAcknowledgmentRequest
    extends BaseType
{

    @XmlElement(name = "AcknowledgmentRequestInfo")
    protected List<ImportAcknowledgmentRequest.AcknowledgmentRequestInfo> acknowledgmentRequestInfo;
    @XmlElement(name = "AckCancellation")
    protected List<ImportAcknowledgmentRequest.AckCancellation> ackCancellation;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the acknowledgmentRequestInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acknowledgmentRequestInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcknowledgmentRequestInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAcknowledgmentRequest.AcknowledgmentRequestInfo }
     * 
     * 
     */
    public List<ImportAcknowledgmentRequest.AcknowledgmentRequestInfo> getAcknowledgmentRequestInfo() {
        if (acknowledgmentRequestInfo == null) {
            acknowledgmentRequestInfo = new ArrayList<ImportAcknowledgmentRequest.AcknowledgmentRequestInfo>();
        }
        return this.acknowledgmentRequestInfo;
    }

    /**
     * Gets the value of the ackCancellation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ackCancellation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAckCancellation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAcknowledgmentRequest.AckCancellation }
     * 
     * 
     */
    public List<ImportAcknowledgmentRequest.AckCancellation> getAckCancellation() {
        if (ackCancellation == null) {
            ackCancellation = new ArrayList<ImportAcknowledgmentRequest.AckCancellation>();
        }
        return this.ackCancellation;
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
        if (version == null) {
            return "11.0.0.2";
        } else {
            return version;
        }
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
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}NotificationsOfOrderExecutionGUID"/&gt;
     *           &lt;sequence&gt;
     *             &lt;choice&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderIDMultipurpose"/&gt;
     *             &lt;/choice&gt;
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID"/&gt;
     *           &lt;/sequence&gt;
     *         &lt;/choice&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
        "notificationsOfOrderExecutionGUID",
        "orderID",
        "orderIDMultipurpose",
        "orgPPAGUID",
        "paymentDocumentID",
        "transportGUID"
    })
    public static class AckCancellation {

        @XmlElement(name = "NotificationsOfOrderExecutionGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/")
        protected String notificationsOfOrderExecutionGUID;
        @XmlElement(name = "OrderID", namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/")
        protected String orderID;
        @XmlElement(name = "OrderIDMultipurpose", namespace = "http://dom.gosuslugi.ru/schema/integration/payments-base/")
        protected String orderIDMultipurpose;
        @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected String orgPPAGUID;
        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/", required = true)
        protected String paymentDocumentID;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

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
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}AcknowledgmentRequestInfoType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
        "transportGUID"
    })
    public static class AcknowledgmentRequestInfo
        extends AcknowledgmentRequestInfoType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
        }

    }

}
