
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * Ответ на запрос экспорта ДУ/уставов
 * 
 * <p>Java class for exportRolloverStatusCAChResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportRolloverStatusCAChResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID" maxOccurs="1000"/&gt;
 *         &lt;element name="Status"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="CACh" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/&gt;
 *                                 &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/&gt;
 *                                 &lt;element name="PreviousCharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="State" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="Running"/&gt;
 *                                   &lt;enumeration value="NotRunning"/&gt;
 *                                   &lt;enumeration value="Expired"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/&gt;
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/&gt;
 *                                       &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                                       &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                                       &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                             &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage" minOccurs="0"/&gt;
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
@XmlType(name = "exportRolloverStatusCAChResultType", propOrder = {
    "orgPPAGUID",
    "status"
})
public class ExportRolloverStatusCAChResultType {

    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected List<String> orgPPAGUID;
    @XmlElement(name = "Status", required = true)
    protected ExportRolloverStatusCAChResultType.Status status;

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgPPAGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgPPAGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOrgPPAGUID() {
        if (orgPPAGUID == null) {
            orgPPAGUID = new ArrayList<String>();
        }
        return this.orgPPAGUID;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRolloverStatusCAChResultType.Status }
     *     
     */
    public ExportRolloverStatusCAChResultType.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRolloverStatusCAChResultType.Status }
     *     
     */
    public void setStatus(ExportRolloverStatusCAChResultType.Status value) {
        this.status = value;
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
     *         &lt;element name="CACh" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/&gt;
     *                       &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/&gt;
     *                       &lt;element name="PreviousCharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="State" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="Running"/&gt;
     *                         &lt;enumeration value="NotRunning"/&gt;
     *                         &lt;enumeration value="Expired"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/&gt;
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/&gt;
     *                             &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                             &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                             &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *                   &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                   &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage" minOccurs="0"/&gt;
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
        "caCh",
        "errorMessage"
    })
    public static class Status {

        @XmlElement(name = "CACh")
        protected List<ExportRolloverStatusCAChResultType.Status.CACh> caCh;
        @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected ErrorMessageType errorMessage;

        /**
         * Gets the value of the caCh property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the caCh property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCACh().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportRolloverStatusCAChResultType.Status.CACh }
         * 
         * 
         */
        public List<ExportRolloverStatusCAChResultType.Status.CACh> getCACh() {
            if (caCh == null) {
                caCh = new ArrayList<ExportRolloverStatusCAChResultType.Status.CACh>();
            }
            return this.caCh;
        }

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
         *           &lt;sequence&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/&gt;
         *             &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *           &lt;/sequence&gt;
         *           &lt;sequence&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/&gt;
         *             &lt;element name="PreviousCharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *           &lt;/sequence&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="State" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="Running"/&gt;
         *               &lt;enumeration value="NotRunning"/&gt;
         *               &lt;enumeration value="Expired"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/&gt;
         *                   &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *                   &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *                   &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
         *         &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *         &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "contractGUID",
            "contractVersionGUID",
            "contractStatus",
            "previousContractVersionGUID",
            "charterGUID",
            "charterVersionGUID",
            "charterStatus",
            "previousCharterVersionGUID",
            "state",
            "contractObject",
            "versionNumber",
            "isRollover",
            "rolloverDescription"
        })
        public static class CACh {

            @XmlElement(name = "ContractGUID")
            protected String contractGUID;
            @XmlElement(name = "ContractVersionGUID")
            protected String contractVersionGUID;
            @XmlElement(name = "ContractStatus")
            @XmlSchemaType(name = "string")
            protected ContractStatusType contractStatus;
            @XmlElement(name = "PreviousContractVersionGUID")
            protected String previousContractVersionGUID;
            @XmlElement(name = "CharterGUID")
            protected String charterGUID;
            @XmlElement(name = "CharterVersionGUID")
            protected String charterVersionGUID;
            @XmlElement(name = "CharterStatus")
            @XmlSchemaType(name = "string")
            protected CharterStatusType charterStatus;
            @XmlElement(name = "PreviousCharterVersionGUID")
            protected String previousCharterVersionGUID;
            @XmlElement(name = "State")
            protected String state;
            @XmlElement(name = "ContractObject")
            protected List<ExportRolloverStatusCAChResultType.Status.CACh.ContractObject> contractObject;
            @XmlElement(name = "VersionNumber", required = true)
            protected BigInteger versionNumber;
            @XmlElement(name = "IsRollover")
            protected boolean isRollover;
            @XmlElement(name = "RolloverDescription", required = true)
            protected String rolloverDescription;

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
             * Статус ДУ:
             *  Project - проект
             *  ApprovalProcess - на утверждении
             *  Approved - утвержден
             *  Rejected- отклонен
             *  Terminated - расторгнут/закрыт
             *  Reviewed - рассмотрен
             *  Annul - сведения аннулированы
             * 
             * @return
             *     possible object is
             *     {@link ContractStatusType }
             *     
             */
            public ContractStatusType getContractStatus() {
                return contractStatus;
            }

            /**
             * Sets the value of the contractStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link ContractStatusType }
             *     
             */
            public void setContractStatus(ContractStatusType value) {
                this.contractStatus = value;
            }

            /**
             * Gets the value of the previousContractVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPreviousContractVersionGUID() {
                return previousContractVersionGUID;
            }

            /**
             * Sets the value of the previousContractVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPreviousContractVersionGUID(String value) {
                this.previousContractVersionGUID = value;
            }

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

            /**
             * Gets the value of the charterVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCharterVersionGUID() {
                return charterVersionGUID;
            }

            /**
             * Sets the value of the charterVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCharterVersionGUID(String value) {
                this.charterVersionGUID = value;
            }

            /**
             * Gets the value of the charterStatus property.
             * 
             * @return
             *     possible object is
             *     {@link CharterStatusType }
             *     
             */
            public CharterStatusType getCharterStatus() {
                return charterStatus;
            }

            /**
             * Sets the value of the charterStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link CharterStatusType }
             *     
             */
            public void setCharterStatus(CharterStatusType value) {
                this.charterStatus = value;
            }

            /**
             * Gets the value of the previousCharterVersionGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPreviousCharterVersionGUID() {
                return previousCharterVersionGUID;
            }

            /**
             * Sets the value of the previousCharterVersionGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPreviousCharterVersionGUID(String value) {
                this.previousCharterVersionGUID = value;
            }

            /**
             * Gets the value of the state property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Sets the value of the state property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Gets the value of the contractObject property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the contractObject property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContractObject().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportRolloverStatusCAChResultType.Status.CACh.ContractObject }
             * 
             * 
             */
            public List<ExportRolloverStatusCAChResultType.Status.CACh.ContractObject> getContractObject() {
                if (contractObject == null) {
                    contractObject = new ArrayList<ExportRolloverStatusCAChResultType.Status.CACh.ContractObject>();
                }
                return this.contractObject;
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
             * Gets the value of the isRollover property.
             * 
             */
            public boolean isIsRollover() {
                return isRollover;
            }

            /**
             * Sets the value of the isRollover property.
             * 
             */
            public void setIsRollover(boolean value) {
                this.isRollover = value;
            }

            /**
             * Gets the value of the rolloverDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRolloverDescription() {
                return rolloverDescription;
            }

            /**
             * Sets the value of the rolloverDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRolloverDescription(String value) {
                this.rolloverDescription = value;
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
             *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/&gt;
             *         &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
             *         &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
             *         &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
                "managedObjectStatus",
                "contractObjectVersionGUID",
                "isConflicted",
                "isBlocked",
                "previousContractObjectVersionGUID"
            })
            public static class ContractObject {

                @XmlElement(name = "FIASHouseGuid", required = true)
                protected String fiasHouseGuid;
                @XmlElement(name = "ManagedObjectStatus", required = true)
                @XmlSchemaType(name = "string")
                protected StatusMKDType managedObjectStatus;
                @XmlElement(name = "ContractObjectVersionGUID")
                protected String contractObjectVersionGUID;
                @XmlElement(name = "IsConflicted")
                protected Boolean isConflicted;
                @XmlElement(name = "IsBlocked")
                protected Boolean isBlocked;
                @XmlElement(name = "PreviousContractObjectVersionGUID")
                protected String previousContractObjectVersionGUID;

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
                 * Статус управляемого объекта:
                 *  Project - проект
                 *  ApprovalProcess - на утверждении
                 *  Approved - утвержден
                 *  Rejected- отклонен
                 *  Terminated - расторгнут
                 *  Reviewed - рассмотрен
                 *  Locked - заблокирован
                 * 
                 * @return
                 *     possible object is
                 *     {@link StatusMKDType }
                 *     
                 */
                public StatusMKDType getManagedObjectStatus() {
                    return managedObjectStatus;
                }

                /**
                 * Sets the value of the managedObjectStatus property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link StatusMKDType }
                 *     
                 */
                public void setManagedObjectStatus(StatusMKDType value) {
                    this.managedObjectStatus = value;
                }

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
                }

                /**
                 * Gets the value of the isConflicted property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isIsConflicted() {
                    return isConflicted;
                }

                /**
                 * Sets the value of the isConflicted property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsConflicted(Boolean value) {
                    this.isConflicted = value;
                }

                /**
                 * Gets the value of the isBlocked property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isIsBlocked() {
                    return isBlocked;
                }

                /**
                 * Sets the value of the isBlocked property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsBlocked(Boolean value) {
                    this.isBlocked = value;
                }

                /**
                 * Gets the value of the previousContractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPreviousContractObjectVersionGUID() {
                    return previousContractObjectVersionGUID;
                }

                /**
                 * Sets the value of the previousContractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPreviousContractObjectVersionGUID(String value) {
                    this.previousContractObjectVersionGUID = value;
                }

            }

        }

    }

}
