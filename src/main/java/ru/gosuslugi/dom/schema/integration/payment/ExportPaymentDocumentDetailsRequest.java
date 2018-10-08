
package ru.gosuslugi.dom.schema.integration.payment;

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
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentID"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year" minOccurs="0"/&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month" minOccurs="0"/&gt;
 *             &lt;choice&gt;
 *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/&gt;
 *               &lt;sequence&gt;
 *                 &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *                 &lt;choice minOccurs="0"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ResidentialPremise"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="255"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ResidentialPremiseRoom" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="255"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ResidentialBlock"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="255"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ResidentialBlockRoom" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="255"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="NonResidentialApartment"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="255"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="NonResidentialBlock"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                         &lt;maxLength value="255"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}AccountNumber"/&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills-base/}PaymentDocumentNumber"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/sequence&gt;
 *               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
 *             &lt;/choice&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="AmountRequired" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payment/}Individual"/&gt;
 *                   &lt;element name="Legal"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
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
    "residentialPremise",
    "residentialPremiseRoom",
    "residentialBlock",
    "residentialBlockRoom",
    "nonResidentialApartment",
    "nonResidentialBlock",
    "accountNumber",
    "paymentDocumentNumber",
    "serviceID",
    "amountRequired"
})
@XmlRootElement(name = "exportPaymentDocumentDetailsRequest")
public class ExportPaymentDocumentDetailsRequest
    extends BaseType
{

    @XmlElement(name = "PaymentDocumentID", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected String paymentDocumentID;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Short year;
    @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected Integer month;
    @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected String unifiedAccountNumber;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "ResidentialPremise")
    protected String residentialPremise;
    @XmlElement(name = "ResidentialPremiseRoom")
    protected String residentialPremiseRoom;
    @XmlElement(name = "ResidentialBlock")
    protected String residentialBlock;
    @XmlElement(name = "ResidentialBlockRoom")
    protected String residentialBlockRoom;
    @XmlElement(name = "NonResidentialApartment")
    protected String nonResidentialApartment;
    @XmlElement(name = "NonResidentialBlock")
    protected String nonResidentialBlock;
    @XmlElement(name = "AccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected String accountNumber;
    @XmlElement(name = "PaymentDocumentNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/bills-base/")
    protected String paymentDocumentNumber;
    @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected String serviceID;
    @XmlElement(name = "AmountRequired")
    protected ExportPaymentDocumentDetailsRequest.AmountRequired amountRequired;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

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
     * Gets the value of the residentialPremise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidentialPremise() {
        return residentialPremise;
    }

    /**
     * Sets the value of the residentialPremise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidentialPremise(String value) {
        this.residentialPremise = value;
    }

    /**
     * Gets the value of the residentialPremiseRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidentialPremiseRoom() {
        return residentialPremiseRoom;
    }

    /**
     * Sets the value of the residentialPremiseRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidentialPremiseRoom(String value) {
        this.residentialPremiseRoom = value;
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
     * Gets the value of the nonResidentialApartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonResidentialApartment() {
        return nonResidentialApartment;
    }

    /**
     * Sets the value of the nonResidentialApartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonResidentialApartment(String value) {
        this.nonResidentialApartment = value;
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
     * Gets the value of the amountRequired property.
     * 
     * @return
     *     possible object is
     *     {@link ExportPaymentDocumentDetailsRequest.AmountRequired }
     *     
     */
    public ExportPaymentDocumentDetailsRequest.AmountRequired getAmountRequired() {
        return amountRequired;
    }

    /**
     * Sets the value of the amountRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportPaymentDocumentDetailsRequest.AmountRequired }
     *     
     */
    public void setAmountRequired(ExportPaymentDocumentDetailsRequest.AmountRequired value) {
        this.amountRequired = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/payment/}Individual"/&gt;
     *         &lt;element name="Legal"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "individual",
        "legal"
    })
    public static class AmountRequired {

        @XmlElement(name = "Individual")
        protected Individual individual;
        @XmlElement(name = "Legal")
        protected ExportPaymentDocumentDetailsRequest.AmountRequired.Legal legal;

        /**
         * Gets the value of the individual property.
         * 
         * @return
         *     possible object is
         *     {@link Individual }
         *     
         */
        public Individual getIndividual() {
            return individual;
        }

        /**
         * Sets the value of the individual property.
         * 
         * @param value
         *     allowed object is
         *     {@link Individual }
         *     
         */
        public void setIndividual(Individual value) {
            this.individual = value;
        }

        /**
         * Gets the value of the legal property.
         * 
         * @return
         *     possible object is
         *     {@link ExportPaymentDocumentDetailsRequest.AmountRequired.Legal }
         *     
         */
        public ExportPaymentDocumentDetailsRequest.AmountRequired.Legal getLegal() {
            return legal;
        }

        /**
         * Sets the value of the legal property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportPaymentDocumentDetailsRequest.AmountRequired.Legal }
         *     
         */
        public void setLegal(ExportPaymentDocumentDetailsRequest.AmountRequired.Legal value) {
            this.legal = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}INN"/&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}KPP"/&gt;
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
            "kpp"
        })
        public static class Legal {

            @XmlElement(name = "INN", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String inn;
            @XmlElement(name = "KPP", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-base/", required = true)
            protected String kpp;

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

        }

    }

}
