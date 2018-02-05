
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспорт ЛС
 * 
 * <p>Java class for exportAccountResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportAccountResultType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountExportType">
 *       &lt;sequence>
 *         &lt;element name="AccountReasons" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountReasonsImportType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element name="Contract" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Charter" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OverhaulFormingKindProtocol" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OverhaulFormingKindProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OverhaulFormingKindOMSDescision" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OverhaulFormingKindOMSDescisionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AccountNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AccountGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportAccountResultType", propOrder = {
    "accountReasons",
    "accountNumber",
    "accountGUID",
    "unifiedAccountNumber",
    "serviceID"
})
public class ExportAccountResultType
    extends AccountExportType
{

    @XmlElement(name = "AccountReasons")
    protected ExportAccountResultType.AccountReasons accountReasons;
    @XmlElement(name = "AccountNumber")
    protected String accountNumber;
    @XmlElement(name = "AccountGUID", required = true)
    protected String accountGUID;
    @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
    protected String unifiedAccountNumber;
    @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/")
    protected String serviceID;

    /**
     * Gets the value of the accountReasons property.
     * 
     * @return
     *     possible object is
     *     {@link ExportAccountResultType.AccountReasons }
     *     
     */
    public ExportAccountResultType.AccountReasons getAccountReasons() {
        return accountReasons;
    }

    /**
     * Sets the value of the accountReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportAccountResultType.AccountReasons }
     *     
     */
    public void setAccountReasons(ExportAccountResultType.AccountReasons value) {
        this.accountReasons = value;
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
     * Gets the value of the accountGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountGUID() {
        return accountGUID;
    }

    /**
     * Sets the value of the accountGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountGUID(String value) {
        this.accountGUID = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AccountReasonsImportType">
     *       &lt;sequence minOccurs="0">
     *         &lt;element name="Contract" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Charter" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OverhaulFormingKindProtocol" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OverhaulFormingKindProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OverhaulFormingKindOMSDescision" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OverhaulFormingKindOMSDescisionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "contract",
        "charter",
        "overhaulFormingKindProtocol",
        "overhaulFormingKindOMSDescision"
    })
    public static class AccountReasons
        extends AccountReasonsImportType
    {

        @XmlElement(name = "Contract")
        protected ExportAccountResultType.AccountReasons.Contract contract;
        @XmlElement(name = "Charter")
        protected ExportAccountResultType.AccountReasons.Charter charter;
        @XmlElement(name = "OverhaulFormingKindProtocol")
        protected ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol overhaulFormingKindProtocol;
        @XmlElement(name = "OverhaulFormingKindOMSDescision")
        protected ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision overhaulFormingKindOMSDescision;

        /**
         * Gets the value of the contract property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAccountResultType.AccountReasons.Contract }
         *     
         */
        public ExportAccountResultType.AccountReasons.Contract getContract() {
            return contract;
        }

        /**
         * Sets the value of the contract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAccountResultType.AccountReasons.Contract }
         *     
         */
        public void setContract(ExportAccountResultType.AccountReasons.Contract value) {
            this.contract = value;
        }

        /**
         * Gets the value of the charter property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAccountResultType.AccountReasons.Charter }
         *     
         */
        public ExportAccountResultType.AccountReasons.Charter getCharter() {
            return charter;
        }

        /**
         * Sets the value of the charter property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAccountResultType.AccountReasons.Charter }
         *     
         */
        public void setCharter(ExportAccountResultType.AccountReasons.Charter value) {
            this.charter = value;
        }

        /**
         * Gets the value of the overhaulFormingKindProtocol property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol }
         *     
         */
        public ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol getOverhaulFormingKindProtocol() {
            return overhaulFormingKindProtocol;
        }

        /**
         * Sets the value of the overhaulFormingKindProtocol property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol }
         *     
         */
        public void setOverhaulFormingKindProtocol(ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol value) {
            this.overhaulFormingKindProtocol = value;
        }

        /**
         * Gets the value of the overhaulFormingKindOMSDescision property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision }
         *     
         */
        public ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision getOverhaulFormingKindOMSDescision() {
            return overhaulFormingKindOMSDescision;
        }

        /**
         * Sets the value of the overhaulFormingKindOMSDescision property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision }
         *     
         */
        public void setOverhaulFormingKindOMSDescision(ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision value) {
            this.overhaulFormingKindOMSDescision = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
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
            "charterGUID"
        })
        public static class Charter {

            @XmlElement(name = "CharterGUID", required = true)
            protected String charterGUID;

            /**
             * Gets the value of the charterGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharterGUID() {
                return charterGUID;
            }

            /**
             * Sets the value of the charterGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharterGUID(String value) {
                this.charterGUID = value;
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
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
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
            "contractGUID"
        })
        public static class Contract {

            @XmlElement(name = "ContractGUID", required = true)
            protected String contractGUID;

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
         *         &lt;element name="OverhaulFormingKindOMSDescisionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "overhaulFormingKindOMSDescisionGUID"
        })
        public static class OverhaulFormingKindOMSDescision {

            @XmlElement(name = "OverhaulFormingKindOMSDescisionGUID", required = true)
            protected String overhaulFormingKindOMSDescisionGUID;

            /**
             * Gets the value of the overhaulFormingKindOMSDescisionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOverhaulFormingKindOMSDescisionGUID() {
                return overhaulFormingKindOMSDescisionGUID;
            }

            /**
             * Sets the value of the overhaulFormingKindOMSDescisionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOverhaulFormingKindOMSDescisionGUID(String value) {
                this.overhaulFormingKindOMSDescisionGUID = value;
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
         *       &lt;sequence>
         *         &lt;element name="OverhaulFormingKindProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "overhaulFormingKindProtocolGUID"
        })
        public static class OverhaulFormingKindProtocol {

            @XmlElement(name = "OverhaulFormingKindProtocolGUID", required = true)
            protected String overhaulFormingKindProtocolGUID;

            /**
             * Gets the value of the overhaulFormingKindProtocolGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOverhaulFormingKindProtocolGUID() {
                return overhaulFormingKindProtocolGUID;
            }

            /**
             * Sets the value of the overhaulFormingKindProtocolGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOverhaulFormingKindProtocolGUID(String value) {
                this.overhaulFormingKindProtocolGUID = value;
            }

        }

    }

}
