
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *         &lt;element name="CommonResult" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType">
 *                 &lt;choice minOccurs="0">
 *                   &lt;element name="ImportHouseUO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
 *                   &lt;element name="ImportHouseRSO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
 *                   &lt;element name="ImportHouseOMS" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
 *                   &lt;element name="ImportHouseESP" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
 *                   &lt;element name="importContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importContractResultType"/>
 *                   &lt;element name="importCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importCharterResultType"/>
 *                   &lt;element name="importMeteringDevice">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ImportAccount">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ImportSupplyResourceContract">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ImportSupplyResourceContractProject">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="importSupplyResourceContractObjectAddress">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "commonResult"
})
@XmlRootElement(name = "ImportResult")
public class ImportResult
    extends BaseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "CommonResult")
    protected List<ImportResult.CommonResult> commonResult;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the commonResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportResult.CommonResult }
     * 
     * 
     */
    public List<ImportResult.CommonResult> getCommonResult() {
        if (commonResult == null) {
            commonResult = new ArrayList<ImportResult.CommonResult>();
        }
        return this.commonResult;
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
            return "10.0.1.1";
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType">
     *       &lt;choice minOccurs="0">
     *         &lt;element name="ImportHouseUO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
     *         &lt;element name="ImportHouseRSO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
     *         &lt;element name="ImportHouseOMS" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
     *         &lt;element name="ImportHouseESP" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/>
     *         &lt;element name="importContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importContractResultType"/>
     *         &lt;element name="importCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importCharterResultType"/>
     *         &lt;element name="importMeteringDevice">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ImportAccount">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ImportSupplyResourceContract">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ImportSupplyResourceContractProject">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="importSupplyResourceContractObjectAddress">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "importHouseUO",
        "importHouseRSO",
        "importHouseOMS",
        "importHouseESP",
        "importContract",
        "importCharter",
        "importMeteringDevice",
        "importAccount",
        "importSupplyResourceContract",
        "importSupplyResourceContractProject",
        "importSupplyResourceContractObjectAddress"
    })
    public static class CommonResult
        extends CommonResultType
    {

        @XmlElement(name = "ImportHouseUO")
        protected OGFImportStatusType importHouseUO;
        @XmlElement(name = "ImportHouseRSO")
        protected OGFImportStatusType importHouseRSO;
        @XmlElement(name = "ImportHouseOMS")
        protected OGFImportStatusType importHouseOMS;
        @XmlElement(name = "ImportHouseESP")
        protected OGFImportStatusType importHouseESP;
        protected ImportContractResultType importContract;
        protected ImportCharterResultType importCharter;
        protected ImportResult.CommonResult.ImportMeteringDevice importMeteringDevice;
        @XmlElement(name = "ImportAccount")
        protected ImportResult.CommonResult.ImportAccount importAccount;
        @XmlElement(name = "ImportSupplyResourceContract")
        protected ImportResult.CommonResult.ImportSupplyResourceContract importSupplyResourceContract;
        @XmlElement(name = "ImportSupplyResourceContractProject")
        protected ImportResult.CommonResult.ImportSupplyResourceContractProject importSupplyResourceContractProject;
        protected ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress importSupplyResourceContractObjectAddress;

        /**
         * Gets the value of the importHouseUO property.
         * 
         * @return
         *     possible object is
         *     {@link OGFImportStatusType }
         *     
         */
        public OGFImportStatusType getImportHouseUO() {
            return importHouseUO;
        }

        /**
         * Sets the value of the importHouseUO property.
         * 
         * @param value
         *     allowed object is
         *     {@link OGFImportStatusType }
         *     
         */
        public void setImportHouseUO(OGFImportStatusType value) {
            this.importHouseUO = value;
        }

        /**
         * Gets the value of the importHouseRSO property.
         * 
         * @return
         *     possible object is
         *     {@link OGFImportStatusType }
         *     
         */
        public OGFImportStatusType getImportHouseRSO() {
            return importHouseRSO;
        }

        /**
         * Sets the value of the importHouseRSO property.
         * 
         * @param value
         *     allowed object is
         *     {@link OGFImportStatusType }
         *     
         */
        public void setImportHouseRSO(OGFImportStatusType value) {
            this.importHouseRSO = value;
        }

        /**
         * Gets the value of the importHouseOMS property.
         * 
         * @return
         *     possible object is
         *     {@link OGFImportStatusType }
         *     
         */
        public OGFImportStatusType getImportHouseOMS() {
            return importHouseOMS;
        }

        /**
         * Sets the value of the importHouseOMS property.
         * 
         * @param value
         *     allowed object is
         *     {@link OGFImportStatusType }
         *     
         */
        public void setImportHouseOMS(OGFImportStatusType value) {
            this.importHouseOMS = value;
        }

        /**
         * Gets the value of the importHouseESP property.
         * 
         * @return
         *     possible object is
         *     {@link OGFImportStatusType }
         *     
         */
        public OGFImportStatusType getImportHouseESP() {
            return importHouseESP;
        }

        /**
         * Sets the value of the importHouseESP property.
         * 
         * @param value
         *     allowed object is
         *     {@link OGFImportStatusType }
         *     
         */
        public void setImportHouseESP(OGFImportStatusType value) {
            this.importHouseESP = value;
        }

        /**
         * Gets the value of the importContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportContractResultType }
         *     
         */
        public ImportContractResultType getImportContract() {
            return importContract;
        }

        /**
         * Sets the value of the importContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportContractResultType }
         *     
         */
        public void setImportContract(ImportContractResultType value) {
            this.importContract = value;
        }

        /**
         * Gets the value of the importCharter property.
         * 
         * @return
         *     possible object is
         *     {@link ImportCharterResultType }
         *     
         */
        public ImportCharterResultType getImportCharter() {
            return importCharter;
        }

        /**
         * Sets the value of the importCharter property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportCharterResultType }
         *     
         */
        public void setImportCharter(ImportCharterResultType value) {
            this.importCharter = value;
        }

        /**
         * Gets the value of the importMeteringDevice property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResult.CommonResult.ImportMeteringDevice }
         *     
         */
        public ImportResult.CommonResult.ImportMeteringDevice getImportMeteringDevice() {
            return importMeteringDevice;
        }

        /**
         * Sets the value of the importMeteringDevice property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResult.CommonResult.ImportMeteringDevice }
         *     
         */
        public void setImportMeteringDevice(ImportResult.CommonResult.ImportMeteringDevice value) {
            this.importMeteringDevice = value;
        }

        /**
         * Gets the value of the importAccount property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResult.CommonResult.ImportAccount }
         *     
         */
        public ImportResult.CommonResult.ImportAccount getImportAccount() {
            return importAccount;
        }

        /**
         * Sets the value of the importAccount property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResult.CommonResult.ImportAccount }
         *     
         */
        public void setImportAccount(ImportResult.CommonResult.ImportAccount value) {
            this.importAccount = value;
        }

        /**
         * Gets the value of the importSupplyResourceContract property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContract }
         *     
         */
        public ImportResult.CommonResult.ImportSupplyResourceContract getImportSupplyResourceContract() {
            return importSupplyResourceContract;
        }

        /**
         * Sets the value of the importSupplyResourceContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContract }
         *     
         */
        public void setImportSupplyResourceContract(ImportResult.CommonResult.ImportSupplyResourceContract value) {
            this.importSupplyResourceContract = value;
        }

        /**
         * Gets the value of the importSupplyResourceContractProject property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContractProject }
         *     
         */
        public ImportResult.CommonResult.ImportSupplyResourceContractProject getImportSupplyResourceContractProject() {
            return importSupplyResourceContractProject;
        }

        /**
         * Sets the value of the importSupplyResourceContractProject property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContractProject }
         *     
         */
        public void setImportSupplyResourceContractProject(ImportResult.CommonResult.ImportSupplyResourceContractProject value) {
            this.importSupplyResourceContractProject = value;
        }

        /**
         * Gets the value of the importSupplyResourceContractObjectAddress property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress }
         *     
         */
        public ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress getImportSupplyResourceContractObjectAddress() {
            return importSupplyResourceContractObjectAddress;
        }

        /**
         * Sets the value of the importSupplyResourceContractObjectAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress }
         *     
         */
        public void setImportSupplyResourceContractObjectAddress(ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress value) {
            this.importSupplyResourceContractObjectAddress = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/>
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
            "unifiedAccountNumber",
            "serviceID"
        })
        public static class ImportAccount {

            @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
            protected String unifiedAccountNumber;
            @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
            protected String serviceID;

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
         *         &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/>
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
            "meteringDeviceGUID"
        })
        public static class ImportMeteringDevice {

            @XmlElement(name = "MeteringDeviceGUID", required = true)
            protected String meteringDeviceGUID;

            /**
             * Gets the value of the meteringDeviceGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMeteringDeviceGUID() {
                return meteringDeviceGUID;
            }

            /**
             * Sets the value of the meteringDeviceGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMeteringDeviceGUID(String value) {
                this.meteringDeviceGUID = value;
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
         *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "contractGUID",
            "contractRootGUID"
        })
        public static class ImportSupplyResourceContract {

            @XmlElement(name = "ContractGUID", required = true)
            protected String contractGUID;
            @XmlElement(name = "ContractRootGUID", required = true)
            protected String contractRootGUID;

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
             * Gets the value of the contractRootGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractRootGUID() {
                return contractRootGUID;
            }

            /**
             * Sets the value of the contractRootGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractRootGUID(String value) {
                this.contractRootGUID = value;
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
         *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "contractGUID",
            "contractRootGUID"
        })
        public static class ImportSupplyResourceContractObjectAddress {

            @XmlElement(name = "ContractGUID", required = true)
            protected String contractGUID;
            @XmlElement(name = "ContractRootGUID", required = true)
            protected String contractRootGUID;

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
             * Gets the value of the contractRootGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractRootGUID() {
                return contractRootGUID;
            }

            /**
             * Sets the value of the contractRootGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractRootGUID(String value) {
                this.contractRootGUID = value;
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
         *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
        public static class ImportSupplyResourceContractProject {

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

    }

}
