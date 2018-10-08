
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="Contract" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;element name="ContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="PublicPropertyContract"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PublicPropertyContractType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="PaymentInterval" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
 *                                           &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                         &lt;element name="Other"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"&gt;
 *                                               &lt;minLength value="1"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/choice&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="AnnulmentContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AddAgreementPayment" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="ContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="DatePeriod"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Bill" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/&gt;
 *                   &lt;element name="Debt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/&gt;
 *                   &lt;element name="Paid" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AnnulAgreementPayment" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DelAgreementPayment" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contract",
    "addAgreementPayment",
    "annulAgreementPayment",
    "delAgreementPayment"
})
@XmlRootElement(name = "importPublicPropertyContractRequest")
public class ImportPublicPropertyContractRequest
    extends BaseType
{

    @XmlElement(name = "Contract")
    protected List<ImportPublicPropertyContractRequest.Contract> contract;
    @XmlElement(name = "AddAgreementPayment")
    protected List<ImportPublicPropertyContractRequest.AddAgreementPayment> addAgreementPayment;
    @XmlElement(name = "AnnulAgreementPayment")
    protected List<ImportPublicPropertyContractRequest.AnnulAgreementPayment> annulAgreementPayment;
    @XmlElement(name = "DelAgreementPayment")
    protected List<ImportPublicPropertyContractRequest.DelAgreementPayment> delAgreementPayment;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPublicPropertyContractRequest.Contract }
     * 
     * 
     */
    public List<ImportPublicPropertyContractRequest.Contract> getContract() {
        if (contract == null) {
            contract = new ArrayList<ImportPublicPropertyContractRequest.Contract>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the addAgreementPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addAgreementPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddAgreementPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPublicPropertyContractRequest.AddAgreementPayment }
     * 
     * 
     */
    public List<ImportPublicPropertyContractRequest.AddAgreementPayment> getAddAgreementPayment() {
        if (addAgreementPayment == null) {
            addAgreementPayment = new ArrayList<ImportPublicPropertyContractRequest.AddAgreementPayment>();
        }
        return this.addAgreementPayment;
    }

    /**
     * Gets the value of the annulAgreementPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the annulAgreementPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnnulAgreementPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPublicPropertyContractRequest.AnnulAgreementPayment }
     * 
     * 
     */
    public List<ImportPublicPropertyContractRequest.AnnulAgreementPayment> getAnnulAgreementPayment() {
        if (annulAgreementPayment == null) {
            annulAgreementPayment = new ArrayList<ImportPublicPropertyContractRequest.AnnulAgreementPayment>();
        }
        return this.annulAgreementPayment;
    }

    /**
     * Gets the value of the delAgreementPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delAgreementPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelAgreementPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportPublicPropertyContractRequest.DelAgreementPayment }
     * 
     * 
     */
    public List<ImportPublicPropertyContractRequest.DelAgreementPayment> getDelAgreementPayment() {
        if (delAgreementPayment == null) {
            delAgreementPayment = new ArrayList<ImportPublicPropertyContractRequest.DelAgreementPayment>();
        }
        return this.delAgreementPayment;
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
            return "11.2.0.10";
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="ContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="DatePeriod"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Bill" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/&gt;
     *         &lt;element name="Debt" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyType"/&gt;
     *         &lt;element name="Paid" type="{http://dom.gosuslugi.ru/schema/integration/bills-base/}SmallMoneyPositiveType"/&gt;
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
        "transportGUID",
        "contractVersionGUID",
        "agreementPaymentVersionGUID",
        "datePeriod",
        "bill",
        "debt",
        "paid"
    })
    public static class AddAgreementPayment {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ContractVersionGUID")
        protected String contractVersionGUID;
        @XmlElement(name = "AgreementPaymentVersionGUID")
        protected String agreementPaymentVersionGUID;
        @XmlElement(name = "DatePeriod", required = true)
        protected ImportPublicPropertyContractRequest.AddAgreementPayment.DatePeriod datePeriod;
        @XmlElement(name = "Bill", required = true)
        protected BigDecimal bill;
        @XmlElement(name = "Debt", required = true)
        protected BigDecimal debt;
        @XmlElement(name = "Paid", required = true)
        protected BigDecimal paid;

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

        /**
         * Gets the value of the contractVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractVersionGUID() {
            return contractVersionGUID;
        }

        /**
         * Sets the value of the contractVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractVersionGUID(String value) {
            this.contractVersionGUID = value;
        }

        /**
         * Gets the value of the agreementPaymentVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgreementPaymentVersionGUID() {
            return agreementPaymentVersionGUID;
        }

        /**
         * Sets the value of the agreementPaymentVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgreementPaymentVersionGUID(String value) {
            this.agreementPaymentVersionGUID = value;
        }

        /**
         * Gets the value of the datePeriod property.
         * 
         * @return
         *     possible object is
         *     {@link ImportPublicPropertyContractRequest.AddAgreementPayment.DatePeriod }
         *     
         */
        public ImportPublicPropertyContractRequest.AddAgreementPayment.DatePeriod getDatePeriod() {
            return datePeriod;
        }

        /**
         * Sets the value of the datePeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportPublicPropertyContractRequest.AddAgreementPayment.DatePeriod }
         *     
         */
        public void setDatePeriod(ImportPublicPropertyContractRequest.AddAgreementPayment.DatePeriod value) {
            this.datePeriod = value;
        }

        /**
         * Gets the value of the bill property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getBill() {
            return bill;
        }

        /**
         * Sets the value of the bill property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setBill(BigDecimal value) {
            this.bill = value;
        }

        /**
         * Gets the value of the debt property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDebt() {
            return debt;
        }

        /**
         * Sets the value of the debt property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDebt(BigDecimal value) {
            this.debt = value;
        }

        /**
         * Gets the value of the paid property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getPaid() {
            return paid;
        }

        /**
         * Sets the value of the paid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setPaid(BigDecimal value) {
            this.paid = value;
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
         *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
            "dateFrom",
            "dateTo"
        })
        public static class DatePeriod {

            @XmlElement(name = "DateFrom", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateFrom;
            @XmlElement(name = "DateTo", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateTo;

            /**
             * Gets the value of the dateFrom property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateFrom() {
                return dateFrom;
            }

            /**
             * Sets the value of the dateFrom property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateFrom(XMLGregorianCalendar value) {
                this.dateFrom = value;
            }

            /**
             * Gets the value of the dateTo property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateTo() {
                return dateTo;
            }

            /**
             * Sets the value of the dateTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateTo(XMLGregorianCalendar value) {
                this.dateTo = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "transportGUID",
        "agreementPaymentVersionGUID"
    })
    public static class AnnulAgreementPayment
        extends AnnulmentType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AgreementPaymentVersionGUID", required = true)
        protected String agreementPaymentVersionGUID;

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

        /**
         * Gets the value of the agreementPaymentVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgreementPaymentVersionGUID() {
            return agreementPaymentVersionGUID;
        }

        /**
         * Sets the value of the agreementPaymentVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgreementPaymentVersionGUID(String value) {
            this.agreementPaymentVersionGUID = value;
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
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *           &lt;element name="ContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="PublicPropertyContract"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PublicPropertyContractType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="PaymentInterval" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;choice&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
     *                                 &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
     *                               &lt;/sequence&gt;
     *                               &lt;element name="Other"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"&gt;
     *                                     &lt;minLength value="1"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/choice&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="AnnulmentContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"/&gt;
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
        "transportGUID",
        "contractVersionGUID",
        "publicPropertyContract",
        "annulmentContract"
    })
    public static class Contract {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "ContractVersionGUID")
        protected String contractVersionGUID;
        @XmlElement(name = "PublicPropertyContract")
        protected ImportPublicPropertyContractRequest.Contract.PublicPropertyContract publicPropertyContract;
        @XmlElement(name = "AnnulmentContract")
        protected AnnulmentType annulmentContract;

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

        /**
         * Gets the value of the contractVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractVersionGUID() {
            return contractVersionGUID;
        }

        /**
         * Sets the value of the contractVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractVersionGUID(String value) {
            this.contractVersionGUID = value;
        }

        /**
         * Gets the value of the publicPropertyContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportPublicPropertyContractRequest.Contract.PublicPropertyContract }
         *     
         */
        public ImportPublicPropertyContractRequest.Contract.PublicPropertyContract getPublicPropertyContract() {
            return publicPropertyContract;
        }

        /**
         * Sets the value of the publicPropertyContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportPublicPropertyContractRequest.Contract.PublicPropertyContract }
         *     
         */
        public void setPublicPropertyContract(ImportPublicPropertyContractRequest.Contract.PublicPropertyContract value) {
            this.publicPropertyContract = value;
        }

        /**
         * Gets the value of the annulmentContract property.
         * 
         * @return
         *     possible object is
         *     {@link AnnulmentType }
         *     
         */
        public AnnulmentType getAnnulmentContract() {
            return annulmentContract;
        }

        /**
         * Sets the value of the annulmentContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link AnnulmentType }
         *     
         */
        public void setAnnulmentContract(AnnulmentType value) {
            this.annulmentContract = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PublicPropertyContractType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PaymentInterval" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;choice&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
         *                     &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
         *                   &lt;/sequence&gt;
         *                   &lt;element name="Other"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/choice&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "paymentInterval"
        })
        public static class PublicPropertyContract
            extends PublicPropertyContractType
        {

            @XmlElement(name = "PaymentInterval")
            protected ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.PaymentInterval paymentInterval;

            /**
             * Gets the value of the paymentInterval property.
             * 
             * @return
             *     possible object is
             *     {@link ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.PaymentInterval }
             *     
             */
            public ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.PaymentInterval getPaymentInterval() {
                return paymentInterval;
            }

            /**
             * Sets the value of the paymentInterval property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.PaymentInterval }
             *     
             */
            public void setPaymentInterval(ImportPublicPropertyContractRequest.Contract.PublicPropertyContract.PaymentInterval value) {
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
             *       &lt;choice&gt;
             *         &lt;sequence&gt;
             *           &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
             *           &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionType"/&gt;
             *         &lt;/sequence&gt;
             *         &lt;element name="Other"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"&gt;
             *               &lt;minLength value="1"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
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
                "startDate",
                "endDate",
                "other"
            })
            public static class PaymentInterval {

                @XmlElement(name = "StartDate")
                protected DaySelectionType startDate;
                @XmlElement(name = "EndDate")
                protected DaySelectionType endDate;
                @XmlElement(name = "Other")
                protected String other;

                /**
                 * Gets the value of the startDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DaySelectionType }
                 *     
                 */
                public DaySelectionType getStartDate() {
                    return startDate;
                }

                /**
                 * Sets the value of the startDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DaySelectionType }
                 *     
                 */
                public void setStartDate(DaySelectionType value) {
                    this.startDate = value;
                }

                /**
                 * Gets the value of the endDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DaySelectionType }
                 *     
                 */
                public DaySelectionType getEndDate() {
                    return endDate;
                }

                /**
                 * Sets the value of the endDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DaySelectionType }
                 *     
                 */
                public void setEndDate(DaySelectionType value) {
                    this.endDate = value;
                }

                /**
                 * Gets the value of the other property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOther() {
                    return other;
                }

                /**
                 * Sets the value of the other property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOther(String value) {
                    this.other = value;
                }

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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "transportGUID",
        "agreementPaymentVersionGUID"
    })
    public static class DelAgreementPayment {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AgreementPaymentVersionGUID", required = true)
        protected String agreementPaymentVersionGUID;

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

        /**
         * Gets the value of the agreementPaymentVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgreementPaymentVersionGUID() {
            return agreementPaymentVersionGUID;
        }

        /**
         * Sets the value of the agreementPaymentVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgreementPaymentVersionGUID(String value) {
            this.agreementPaymentVersionGUID = value;
        }

    }

}
