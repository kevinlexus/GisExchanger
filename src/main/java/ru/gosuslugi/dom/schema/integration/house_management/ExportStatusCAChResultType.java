
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exportStatusCAChResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportStatusCAChResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/&gt;
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
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportStatusCAChResultType", propOrder = {
    "contractGUID",
    "contractVersionGUID",
    "contractStatus",
    "charterGUID",
    "charterVersionGUID",
    "charterStatus",
    "state",
    "contractObject",
    "versionNumber"
})
@XmlSeeAlso({
    ImportContractResultType.class,
    ImportCharterResultType.class
})
public class ExportStatusCAChResultType {

    @XmlElement(name = "ContractGUID")
    protected String contractGUID;
    @XmlElement(name = "ContractVersionGUID")
    protected String contractVersionGUID;
    @XmlElement(name = "ContractStatus")
    @XmlSchemaType(name = "string")
    protected ContractStatusType contractStatus;
    @XmlElement(name = "CharterGUID")
    protected String charterGUID;
    @XmlElement(name = "CharterVersionGUID")
    protected String charterVersionGUID;
    @XmlElement(name = "CharterStatus")
    @XmlSchemaType(name = "string")
    protected CharterStatusType charterStatus;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "ContractObject")
    protected List<ExportStatusCAChResultType.ContractObject> contractObject;
    @XmlElement(name = "VersionNumber", required = true)
    protected BigInteger versionNumber;

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
     * {@link ExportStatusCAChResultType.ContractObject }
     * 
     * 
     */
    public List<ExportStatusCAChResultType.ContractObject> getContractObject() {
        if (contractObject == null) {
            contractObject = new ArrayList<ExportStatusCAChResultType.ContractObject>();
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
        "isBlocked"
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

    }

}
