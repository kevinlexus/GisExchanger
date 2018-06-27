
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for exportRolloverStatusCAChResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportRolloverStatusCAChResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID" maxOccurs="1000"/>
 *         &lt;element name="Status">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="CACh" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;choice>
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
 *                                 &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                               &lt;/sequence>
 *                               &lt;sequence>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
 *                                 &lt;element name="CharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                               &lt;/sequence>
 *                             &lt;/choice>
 *                             &lt;element name="State" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Running"/>
 *                                   &lt;enumeration value="NotRunning"/>
 *                                   &lt;enumeration value="Expired"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/>
 *                                       &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                       &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                       &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="CACh" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;choice>
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
     *                       &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                     &lt;/sequence>
     *                     &lt;sequence>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
     *                       &lt;element name="CharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                     &lt;/sequence>
     *                   &lt;/choice>
     *                   &lt;element name="State" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Running"/>
     *                         &lt;enumeration value="NotRunning"/>
     *                         &lt;enumeration value="Expired"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/>
     *                             &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                             &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                             &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage" minOccurs="0"/>
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
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;choice>
         *           &lt;sequence>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractVersionGUID"/>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractStatus"/>
         *             &lt;element name="PreviousContractVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *           &lt;/sequence>
         *           &lt;sequence>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterGUID"/>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/>
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterStatus"/>
         *             &lt;element name="CharterVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *           &lt;/sequence>
         *         &lt;/choice>
         *         &lt;element name="State" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Running"/>
         *               &lt;enumeration value="NotRunning"/>
         *               &lt;enumeration value="Expired"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/>
         *                   &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *                   &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *                   &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="IsRollover" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="RolloverDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "content"
        })
        public static class CACh {

            @XmlElementRefs({
                @XmlElementRef(name = "ContractGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "VersionNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "PreviousContractVersionGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "RolloverDescription", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "State", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ContractVersionGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CharterGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CharterVersionGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ContractStatus", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "ContractObject", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "IsRollover", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "CharterStatus", namespace = "http://dom.gosuslugi.ru/schema/integration/house-management/", type = JAXBElement.class, required = false)
            })
            protected List<JAXBElement<?>> content;

            /**
             * Gets the rest of the content model. 
             * 
             * <p>
             * You are getting this "catch-all" property because of the following reason: 
             * The field name "CharterVersionGUID" is used by two different parts of a schema. See: 
             * line 3403 of file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/house-management/hcs-house-management-types.xsd
             * line 3401 of file:/C:/Progs/Soap2Gis/wsdl/hcs_wsdl_xsd_v.11.13.0.11/house-management/hcs-house-management-types.xsd
             * <p>
             * To get rid of this property, apply a property customization to one 
             * of both of the following declarations to change their names: 
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link ContractStatusType }{@code >}
             * {@link JAXBElement }{@code <}{@link ExportRolloverStatusCAChResultType.Status.CACh.ContractObject }{@code >}
             * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
             * {@link JAXBElement }{@code <}{@link CharterStatusType }{@code >}
             * 
             * 
             */
            public List<JAXBElement<?>> getContent() {
                if (content == null) {
                    content = new ArrayList<JAXBElement<?>>();
                }
                return this.content;
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
             *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManagedObjectStatus"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID" minOccurs="0"/>
             *         &lt;element name="IsConflicted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
             *         &lt;element name="IsBlocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
             *         &lt;element name="PreviousContractObjectVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
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
