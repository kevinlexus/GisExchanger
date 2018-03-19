
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportStatusPublicPropertyContractResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportStatusPublicPropertyContractResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicPropertyContract" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PublicPropertyContractExportType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *                   &lt;element name="StatusContract" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                   &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="StatusVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PaymentInterval" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;sequence>
 *                               &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
 *                               &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;element name="Other">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type">
 *                                   &lt;minLength value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AgreementPayment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="DatePeriod">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                       &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Bill">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="10"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Debt">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="10"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Paid">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="10"/>
 *                                   &lt;fractionDigits value="2"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IsGratuitousBasis" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportStatusPublicPropertyContractResultType", propOrder = {
    "publicPropertyContract"
})
public class ExportStatusPublicPropertyContractResultType {

    @XmlElement(name = "PublicPropertyContract", required = true)
    protected List<ExportStatusPublicPropertyContractResultType.PublicPropertyContract> publicPropertyContract;

    /**
     * Gets the value of the publicPropertyContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publicPropertyContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublicPropertyContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract }
     * 
     * 
     */
    public List<ExportStatusPublicPropertyContractResultType.PublicPropertyContract> getPublicPropertyContract() {
        if (publicPropertyContract == null) {
            publicPropertyContract = new ArrayList<ExportStatusPublicPropertyContractResultType.PublicPropertyContract>();
        }
        return this.publicPropertyContract;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PublicPropertyContractExportType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
     *         &lt;element name="StatusContract" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="StatusVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PaymentInterval" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;sequence>
     *                     &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
     *                     &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;element name="Other">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type">
     *                         &lt;minLength value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AgreementPayment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="DatePeriod">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Bill">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="10"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Debt">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="10"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Paid">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="10"/>
     *                         &lt;fractionDigits value="2"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="IsGratuitousBasis" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contractGUID",
        "statusContract",
        "contractVersionGUID",
        "versionNumber",
        "statusVersion",
        "paymentInterval",
        "agreementPayment",
        "isGratuitousBasis"
    })
    public static class PublicPropertyContract
        extends PublicPropertyContractExportType
    {

        @XmlElement(name = "ContractGUID", required = true)
        protected String contractGUID;
        @XmlElement(name = "StatusContract", required = true)
        protected String statusContract;
        @XmlElement(name = "ContractVersionGUID", required = true)
        protected String contractVersionGUID;
        @XmlElement(name = "VersionNumber", required = true)
        protected BigInteger versionNumber;
        @XmlElement(name = "StatusVersion", required = true)
        protected String statusVersion;
        @XmlElement(name = "PaymentInterval")
        protected ExportStatusPublicPropertyContractResultType.PublicPropertyContract.PaymentInterval paymentInterval;
        @XmlElement(name = "AgreementPayment")
        protected List<ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment> agreementPayment;
        @XmlElement(name = "IsGratuitousBasis")
        protected Boolean isGratuitousBasis;

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
         * Gets the value of the statusContract property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusContract() {
            return statusContract;
        }

        /**
         * Sets the value of the statusContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusContract(String value) {
            this.statusContract = value;
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
         * Gets the value of the versionNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getVersionNumber() {
            return versionNumber;
        }

        /**
         * Sets the value of the versionNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setVersionNumber(BigInteger value) {
            this.versionNumber = value;
        }

        /**
         * Gets the value of the statusVersion property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusVersion() {
            return statusVersion;
        }

        /**
         * Sets the value of the statusVersion property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusVersion(String value) {
            this.statusVersion = value;
        }

        /**
         * Gets the value of the paymentInterval property.
         * 
         * @return
         *     possible object is
         *     {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract.PaymentInterval }
         *     
         */
        public ExportStatusPublicPropertyContractResultType.PublicPropertyContract.PaymentInterval getPaymentInterval() {
            return paymentInterval;
        }

        /**
         * Sets the value of the paymentInterval property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract.PaymentInterval }
         *     
         */
        public void setPaymentInterval(ExportStatusPublicPropertyContractResultType.PublicPropertyContract.PaymentInterval value) {
            this.paymentInterval = value;
        }

        /**
         * Gets the value of the agreementPayment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the agreementPayment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAgreementPayment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment }
         * 
         * 
         */
        public List<ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment> getAgreementPayment() {
            if (agreementPayment == null) {
                agreementPayment = new ArrayList<ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment>();
            }
            return this.agreementPayment;
        }

        /**
         * Gets the value of the isGratuitousBasis property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsGratuitousBasis() {
            return isGratuitousBasis;
        }

        /**
         * Sets the value of the isGratuitousBasis property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsGratuitousBasis(Boolean value) {
            this.isGratuitousBasis = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="AgreementPaymentVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="DatePeriod">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Bill">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="10"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Debt">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="10"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Paid">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="10"/>
         *               &lt;fractionDigits value="2"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "agreementPaymentVersionGUID",
            "datePeriod",
            "bill",
            "debt",
            "paid"
        })
        public static class AgreementPayment {

            @XmlElement(name = "AgreementPaymentVersionGUID", required = true)
            protected String agreementPaymentVersionGUID;
            @XmlElement(name = "DatePeriod", required = true)
            protected ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment.DatePeriod datePeriod;
            @XmlElement(name = "Bill", required = true)
            protected BigDecimal bill;
            @XmlElement(name = "Debt", required = true)
            protected BigDecimal debt;
            @XmlElement(name = "Paid", required = true)
            protected BigDecimal paid;

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
             *     {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment.DatePeriod }
             *     
             */
            public ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment.DatePeriod getDatePeriod() {
                return datePeriod;
            }

            /**
             * Sets the value of the datePeriod property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment.DatePeriod }
             *     
             */
            public void setDatePeriod(ExportStatusPublicPropertyContractResultType.PublicPropertyContract.AgreementPayment.DatePeriod value) {
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
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="DateTo" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
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
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;sequence>
         *           &lt;element name="StartDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
         *           &lt;element name="EndDate" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DaySelectionExportType" minOccurs="0"/>
         *         &lt;/sequence>
         *         &lt;element name="Other">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type">
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
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
            protected DaySelectionExportType startDate;
            @XmlElement(name = "EndDate")
            protected DaySelectionExportType endDate;
            @XmlElement(name = "Other")
            protected String other;

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
