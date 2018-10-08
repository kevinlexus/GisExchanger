
package ru.gosuslugi.dom.schema.integration.payments_base;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.individual_registry_base.FIOType;


/**
 * Извещение о принятии к исполнению распоряжения
 * 
 * <p>Java class for NotificationOfOrderExecutionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotificationOfOrderExecutionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SupplierInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SupplierID" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="25"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SupplierName" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="160"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RecipientInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/&gt;
 *                     &lt;choice&gt;
 *                       &lt;element name="Entpr" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
 *                       &lt;element name="Legal"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
 *                                 &lt;element name="Name"&gt;
 *                                   &lt;simpleType&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                       &lt;maxLength value="4000"/&gt;
 *                                       &lt;minLength value="1"/&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/simpleType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="EntprFIO"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;minLength value="1"/&gt;
 *                             &lt;maxLength value="160"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/choice&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="PaymentInformation" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}PaymentInformationType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OrderInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payments-base/}OrderID"/&gt;
 *                   &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="OrderNum" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="9"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Amount"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                         &lt;totalDigits value="16"/&gt;
 *                         &lt;fractionDigits value="0"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PaymentPurpose" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="1000"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Comment" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;maxLength value="210"/&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
 *                       &lt;sequence minOccurs="0"&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                       &lt;/sequence&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber" minOccurs="0"/&gt;
 *                         &lt;element name="AddressAndConsumer" minOccurs="0"&gt;
 *                           &lt;complexType&gt;
 *                             &lt;complexContent&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                 &lt;sequence&gt;
 *                                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *                                   &lt;choice minOccurs="0"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Apartment" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="255"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Placement" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="255"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;element name="NonLivingApartment"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;minLength value="1"/&gt;
 *                                           &lt;maxLength value="255"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/element&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ResidentialBlock"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="255"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="ResidentialBlockRoom" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="255"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;element name="NonResidentialBlock"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;minLength value="1"/&gt;
 *                                           &lt;maxLength value="255"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/element&gt;
 *                                   &lt;/choice&gt;
 *                                   &lt;choice&gt;
 *                                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
 *                                     &lt;element name="INN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INNType"/&gt;
 *                                   &lt;/choice&gt;
 *                                 &lt;/sequence&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/complexContent&gt;
 *                           &lt;/complexType&gt;
 *                         &lt;/element&gt;
 *                         &lt;element name="Service" minOccurs="0"&gt;
 *                           &lt;complexType&gt;
 *                             &lt;complexContent&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                 &lt;sequence&gt;
 *                                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
 *                                 &lt;/sequence&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/complexContent&gt;
 *                           &lt;/complexType&gt;
 *                         &lt;/element&gt;
 *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountNumber" minOccurs="0"/&gt;
 *                       &lt;/sequence&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/sequence&gt;
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
@XmlType(name = "NotificationOfOrderExecutionType", propOrder = {
    "supplierInfo",
    "recipientInfo",
    "orderInfo"
})
public class NotificationOfOrderExecutionType {

    @XmlElement(name = "SupplierInfo")
    protected NotificationOfOrderExecutionType.SupplierInfo supplierInfo;
    @XmlElement(name = "RecipientInfo")
    protected NotificationOfOrderExecutionType.RecipientInfo recipientInfo;
    @XmlElement(name = "OrderInfo", required = true)
    protected NotificationOfOrderExecutionType.OrderInfo orderInfo;

    /**
     * Gets the value of the supplierInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationOfOrderExecutionType.SupplierInfo }
     *     
     */
    public NotificationOfOrderExecutionType.SupplierInfo getSupplierInfo() {
        return supplierInfo;
    }

    /**
     * Sets the value of the supplierInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationOfOrderExecutionType.SupplierInfo }
     *     
     */
    public void setSupplierInfo(NotificationOfOrderExecutionType.SupplierInfo value) {
        this.supplierInfo = value;
    }

    /**
     * Gets the value of the recipientInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationOfOrderExecutionType.RecipientInfo }
     *     
     */
    public NotificationOfOrderExecutionType.RecipientInfo getRecipientInfo() {
        return recipientInfo;
    }

    /**
     * Sets the value of the recipientInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationOfOrderExecutionType.RecipientInfo }
     *     
     */
    public void setRecipientInfo(NotificationOfOrderExecutionType.RecipientInfo value) {
        this.recipientInfo = value;
    }

    /**
     * Gets the value of the orderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationOfOrderExecutionType.OrderInfo }
     *     
     */
    public NotificationOfOrderExecutionType.OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets the value of the orderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationOfOrderExecutionType.OrderInfo }
     *     
     */
    public void setOrderInfo(NotificationOfOrderExecutionType.OrderInfo value) {
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
     *         &lt;element name="OrderNum" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="9"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Amount"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *               &lt;totalDigits value="16"/&gt;
     *               &lt;fractionDigits value="0"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PaymentPurpose" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="1000"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Comment" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="210"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID" minOccurs="0"/&gt;
     *           &lt;sequence&gt;
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber" minOccurs="0"/&gt;
     *             &lt;sequence minOccurs="0"&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
     *             &lt;/sequence&gt;
     *             &lt;sequence&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber" minOccurs="0"/&gt;
     *               &lt;element name="AddressAndConsumer" minOccurs="0"&gt;
     *                 &lt;complexType&gt;
     *                   &lt;complexContent&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                       &lt;sequence&gt;
     *                         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
     *                         &lt;choice minOccurs="0"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Apartment" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="255"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Placement" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="255"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;element name="NonLivingApartment"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;minLength value="1"/&gt;
     *                                 &lt;maxLength value="255"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/element&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ResidentialBlock"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="255"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="ResidentialBlockRoom" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="255"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;element name="NonResidentialBlock"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;minLength value="1"/&gt;
     *                                 &lt;maxLength value="255"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/element&gt;
     *                         &lt;/choice&gt;
     *                         &lt;choice&gt;
     *                           &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
     *                           &lt;element name="INN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INNType"/&gt;
     *                         &lt;/choice&gt;
     *                       &lt;/sequence&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/complexContent&gt;
     *                 &lt;/complexType&gt;
     *               &lt;/element&gt;
     *               &lt;element name="Service" minOccurs="0"&gt;
     *                 &lt;complexType&gt;
     *                   &lt;complexContent&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                       &lt;sequence&gt;
     *                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
     *                       &lt;/sequence&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/complexContent&gt;
     *                 &lt;/complexType&gt;
     *               &lt;/element&gt;
     *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountNumber" minOccurs="0"/&gt;
     *             &lt;/sequence&gt;
     *           &lt;/sequence&gt;
     *         &lt;/sequence&gt;
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
        "orderNum",
        "amount",
        "paymentPurpose",
        "comment",
        "paymentDocumentID",
        "paymentDocumentNumber",
        "year",
        "month",
        "unifiedAccountNumber",
        "addressAndConsumer",
        "service",
        "accountNumber"
    })
    public static class OrderInfo {

        @XmlElement(name = "OrderID", required = true)
        protected String orderID;
        @XmlElement(name = "OrderDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar orderDate;
        @XmlElement(name = "OrderNum")
        protected String orderNum;
        @XmlElement(name = "Amount", required = true)
        protected BigDecimal amount;
        @XmlElement(name = "PaymentPurpose")
        protected String paymentPurpose;
        @XmlElement(name = "Comment")
        protected String comment;
        @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentID;
        @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
        protected String paymentDocumentNumber;
        @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected Short year;
        @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected Integer month;
        @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
        protected String unifiedAccountNumber;
        @XmlElement(name = "AddressAndConsumer")
        protected NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer addressAndConsumer;
        @XmlElement(name = "Service")
        protected NotificationOfOrderExecutionType.OrderInfo.Service service;
        @XmlElement(name = "AccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
        protected String accountNumber;

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
         * Gets the value of the orderNum property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderNum() {
            return orderNum;
        }

        /**
         * Sets the value of the orderNum property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderNum(String value) {
            this.orderNum = value;
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
         * Gets the value of the paymentPurpose property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentPurpose() {
            return paymentPurpose;
        }

        /**
         * Sets the value of the paymentPurpose property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentPurpose(String value) {
            this.paymentPurpose = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
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
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnifiedAccountNumber() {
            return unifiedAccountNumber;
        }

        /**
         * Sets the value of the unifiedAccountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnifiedAccountNumber(String value) {
            this.unifiedAccountNumber = value;
        }

        /**
         * Gets the value of the addressAndConsumer property.
         * 
         * @return
         *     possible object is
         *     {@link NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer }
         *     
         */
        public NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer getAddressAndConsumer() {
            return addressAndConsumer;
        }

        /**
         * Sets the value of the addressAndConsumer property.
         * 
         * @param value
         *     allowed object is
         *     {@link NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer }
         *     
         */
        public void setAddressAndConsumer(NotificationOfOrderExecutionType.OrderInfo.AddressAndConsumer value) {
            this.addressAndConsumer = value;
        }

        /**
         * Gets the value of the service property.
         * 
         * @return
         *     possible object is
         *     {@link NotificationOfOrderExecutionType.OrderInfo.Service }
         *     
         */
        public NotificationOfOrderExecutionType.OrderInfo.Service getService() {
            return service;
        }

        /**
         * Sets the value of the service property.
         * 
         * @param value
         *     allowed object is
         *     {@link NotificationOfOrderExecutionType.OrderInfo.Service }
         *     
         */
        public void setService(NotificationOfOrderExecutionType.OrderInfo.Service value) {
            this.service = value;
        }

        /**
         * Gets the value of the accountNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * Sets the value of the accountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNumber(String value) {
            this.accountNumber = value;
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
         *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
         *         &lt;choice minOccurs="0"&gt;
         *           &lt;sequence&gt;
         *             &lt;element name="Apartment" minOccurs="0"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                   &lt;minLength value="1"/&gt;
         *                   &lt;maxLength value="255"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *             &lt;element name="Placement" minOccurs="0"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                   &lt;minLength value="1"/&gt;
         *                   &lt;maxLength value="255"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="NonLivingApartment"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                 &lt;minLength value="1"/&gt;
         *                 &lt;maxLength value="255"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;sequence&gt;
         *             &lt;element name="ResidentialBlock"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                   &lt;minLength value="1"/&gt;
         *                   &lt;maxLength value="255"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *             &lt;element name="ResidentialBlockRoom" minOccurs="0"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                   &lt;minLength value="1"/&gt;
         *                   &lt;maxLength value="255"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="NonResidentialBlock"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                 &lt;minLength value="1"/&gt;
         *                 &lt;maxLength value="255"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;choice&gt;
         *           &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
         *           &lt;element name="INN" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INNType"/&gt;
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
            "fiasHouseGuid",
            "apartment",
            "placement",
            "nonLivingApartment",
            "residentialBlock",
            "residentialBlockRoom",
            "nonResidentialBlock",
            "ind",
            "inn"
        })
        public static class AddressAndConsumer {

            @XmlElement(name = "FIASHouseGuid", required = true)
            protected String fiasHouseGuid;
            @XmlElement(name = "Apartment")
            protected String apartment;
            @XmlElement(name = "Placement")
            protected String placement;
            @XmlElement(name = "NonLivingApartment")
            protected String nonLivingApartment;
            @XmlElement(name = "ResidentialBlock")
            protected String residentialBlock;
            @XmlElement(name = "ResidentialBlockRoom")
            protected String residentialBlockRoom;
            @XmlElement(name = "NonResidentialBlock")
            protected String nonResidentialBlock;
            @XmlElement(name = "Ind")
            protected FIOType ind;
            @XmlElement(name = "INN")
            protected String inn;

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
             * Gets the value of the apartment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApartment() {
                return apartment;
            }

            /**
             * Sets the value of the apartment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApartment(String value) {
                this.apartment = value;
            }

            /**
             * Gets the value of the placement property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPlacement() {
                return placement;
            }

            /**
             * Sets the value of the placement property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPlacement(String value) {
                this.placement = value;
            }

            /**
             * Gets the value of the nonLivingApartment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNonLivingApartment() {
                return nonLivingApartment;
            }

            /**
             * Sets the value of the nonLivingApartment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNonLivingApartment(String value) {
                this.nonLivingApartment = value;
            }

            /**
             * Gets the value of the residentialBlock property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getResidentialBlock() {
                return residentialBlock;
            }

            /**
             * Sets the value of the residentialBlock property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setResidentialBlock(String value) {
                this.residentialBlock = value;
            }

            /**
             * Gets the value of the residentialBlockRoom property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getResidentialBlockRoom() {
                return residentialBlockRoom;
            }

            /**
             * Sets the value of the residentialBlockRoom property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setResidentialBlockRoom(String value) {
                this.residentialBlockRoom = value;
            }

            /**
             * Gets the value of the nonResidentialBlock property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNonResidentialBlock() {
                return nonResidentialBlock;
            }

            /**
             * Sets the value of the nonResidentialBlock property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNonResidentialBlock(String value) {
                this.nonResidentialBlock = value;
            }

            /**
             * Gets the value of the ind property.
             * 
             * @return
             *     possible object is
             *     {@link FIOType }
             *     
             */
            public FIOType getInd() {
                return ind;
            }

            /**
             * Sets the value of the ind property.
             * 
             * @param value
             *     allowed object is
             *     {@link FIOType }
             *     
             */
            public void setInd(FIOType value) {
                this.ind = value;
            }

            /**
             * Gets the value of the inn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getINN() {
                return inn;
            }

            /**
             * Sets the value of the inn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setINN(String value) {
                this.inn = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
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
            "serviceID"
        })
        public static class Service {

            @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
            protected String serviceID;

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
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/&gt;
     *           &lt;choice&gt;
     *             &lt;element name="Entpr" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
     *             &lt;element name="Legal"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
     *                       &lt;element name="Name"&gt;
     *                         &lt;simpleType&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                             &lt;maxLength value="4000"/&gt;
     *                             &lt;minLength value="1"/&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/simpleType&gt;
     *                       &lt;/element&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/restriction&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *             &lt;element name="EntprFIO"&gt;
     *               &lt;simpleType&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;minLength value="1"/&gt;
     *                   &lt;maxLength value="160"/&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/simpleType&gt;
     *             &lt;/element&gt;
     *           &lt;/choice&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="PaymentInformation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}PaymentInformationType"&gt;
     *               &lt;/extension&gt;
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
        "inn",
        "entpr",
        "legal",
        "entprFIO",
        "paymentInformation"
    })
    public static class RecipientInfo {

        @XmlElement(name = "INN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
        protected String inn;
        @XmlElement(name = "Entpr")
        protected FIOType entpr;
        @XmlElement(name = "Legal")
        protected NotificationOfOrderExecutionType.RecipientInfo.Legal legal;
        @XmlElement(name = "EntprFIO")
        protected String entprFIO;
        @XmlElement(name = "PaymentInformation")
        protected NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation paymentInformation;

        /**
         * Gets the value of the inn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getINN() {
            return inn;
        }

        /**
         * Sets the value of the inn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setINN(String value) {
            this.inn = value;
        }

        /**
         * Gets the value of the entpr property.
         * 
         * @return
         *     possible object is
         *     {@link FIOType }
         *     
         */
        public FIOType getEntpr() {
            return entpr;
        }

        /**
         * Sets the value of the entpr property.
         * 
         * @param value
         *     allowed object is
         *     {@link FIOType }
         *     
         */
        public void setEntpr(FIOType value) {
            this.entpr = value;
        }

        /**
         * Gets the value of the legal property.
         * 
         * @return
         *     possible object is
         *     {@link NotificationOfOrderExecutionType.RecipientInfo.Legal }
         *     
         */
        public NotificationOfOrderExecutionType.RecipientInfo.Legal getLegal() {
            return legal;
        }

        /**
         * Sets the value of the legal property.
         * 
         * @param value
         *     allowed object is
         *     {@link NotificationOfOrderExecutionType.RecipientInfo.Legal }
         *     
         */
        public void setLegal(NotificationOfOrderExecutionType.RecipientInfo.Legal value) {
            this.legal = value;
        }

        /**
         * Gets the value of the entprFIO property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntprFIO() {
            return entprFIO;
        }

        /**
         * Sets the value of the entprFIO property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntprFIO(String value) {
            this.entprFIO = value;
        }

        /**
         * Gets the value of the paymentInformation property.
         * 
         * @return
         *     possible object is
         *     {@link NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation }
         *     
         */
        public NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation getPaymentInformation() {
            return paymentInformation;
        }

        /**
         * Sets the value of the paymentInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation }
         *     
         */
        public void setPaymentInformation(NotificationOfOrderExecutionType.RecipientInfo.PaymentInformation value) {
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
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
         *         &lt;element name="Name"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="4000"/&gt;
         *               &lt;minLength value="1"/&gt;
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
            "kpp",
            "name"
        })
        public static class Legal {

            @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String kpp;
            @XmlElement(name = "Name", required = true)
            protected String name;

            /**
             * Gets the value of the kpp property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKPP() {
                return kpp;
            }

            /**
             * Sets the value of the kpp property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKPP(String value) {
                this.kpp = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/payments-base/}PaymentInformationType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class PaymentInformation
            extends PaymentInformationType
        {


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
     *         &lt;element name="SupplierID" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="25"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SupplierName" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="160"/&gt;
     *               &lt;minLength value="1"/&gt;
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
        "supplierID",
        "supplierName"
    })
    public static class SupplierInfo {

        @XmlElement(name = "SupplierID")
        protected String supplierID;
        @XmlElement(name = "SupplierName")
        protected String supplierName;

        /**
         * Gets the value of the supplierID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSupplierID() {
            return supplierID;
        }

        /**
         * Sets the value of the supplierID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSupplierID(String value) {
            this.supplierID = value;
        }

        /**
         * Gets the value of the supplierName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSupplierName() {
            return supplierName;
        }

        /**
         * Sets the value of the supplierName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSupplierName(String value) {
            this.supplierName = value;
        }

    }

}
