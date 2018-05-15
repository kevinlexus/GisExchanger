
package ru.gosuslugi.dom.schema.integration.volume_quality;

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


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="importVolumeAndQualityInformation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;element name="Base">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="RegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *                   &lt;choice>
 *                     &lt;element name="RegistrationPeriodInformation">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType">
 *                             &lt;sequence>
 *                               &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType">
 *                                       &lt;sequence>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="PlacingRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="AnnulmentRegistrationPeriod">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="ReasonOfAnnulment">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType">
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="DeleteProjectRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="DeleteAddressObject">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="ObjectAddress" maxOccurs="1000">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
 *                                       &lt;sequence>
 *                                         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                                       &lt;/sequence>
 *                                     &lt;/extension>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.11.0.4""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importVolumeAndQualityInformation"
})
@XmlRootElement(name = "importVolumeAndQualityInformationRequest")
public class ImportVolumeAndQualityInformationRequest
    extends ru.gosuslugi.dom.schema.integration.base.BaseType
{

    @XmlElement(required = true)
    protected ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation importVolumeAndQualityInformation;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importVolumeAndQualityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation }
     *     
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation getImportVolumeAndQualityInformation() {
        return importVolumeAndQualityInformation;
    }

    /**
     * Sets the value of the importVolumeAndQualityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation }
     *     
     */
    public void setImportVolumeAndQualityInformation(ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation value) {
        this.importVolumeAndQualityInformation = value;
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
            return "11.11.0.4";
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;element name="Base">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="RegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
     *         &lt;choice>
     *           &lt;element name="RegistrationPeriodInformation">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType">
     *                   &lt;sequence>
     *                     &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType">
     *                             &lt;sequence>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="PlacingRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="AnnulmentRegistrationPeriod">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="ReasonOfAnnulment">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType">
     *                           &lt;minLength value="1"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="DeleteProjectRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="DeleteAddressObject">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="ObjectAddress" maxOccurs="1000">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
     *                             &lt;sequence>
     *                               &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *                             &lt;/sequence>
     *                           &lt;/extension>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/choice>
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
        "transportGUID",
        "base",
        "registrationPeriod",
        "registrationPeriodInformation",
        "placingRegistrationPeriod",
        "annulmentRegistrationPeriod",
        "deleteProjectRegistrationPeriod",
        "deleteAddressObject"
    })
    public static class ImportVolumeAndQualityInformation {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "Base", required = true)
        protected ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base base;
        @XmlElement(name = "RegistrationPeriod", required = true)
        @XmlSchemaType(name = "gYearMonth")
        protected XMLGregorianCalendar registrationPeriod;
        @XmlElement(name = "RegistrationPeriodInformation")
        protected ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation registrationPeriodInformation;
        @XmlElement(name = "PlacingRegistrationPeriod")
        protected Boolean placingRegistrationPeriod;
        @XmlElement(name = "AnnulmentRegistrationPeriod")
        protected ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod annulmentRegistrationPeriod;
        @XmlElement(name = "DeleteProjectRegistrationPeriod")
        protected Boolean deleteProjectRegistrationPeriod;
        @XmlElement(name = "DeleteAddressObject")
        protected ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject deleteAddressObject;

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
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base }
         *     
         */
        public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base }
         *     
         */
        public void setBase(ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base value) {
            this.base = value;
        }

        /**
         * Gets the value of the registrationPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRegistrationPeriod() {
            return registrationPeriod;
        }

        /**
         * Sets the value of the registrationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRegistrationPeriod(XMLGregorianCalendar value) {
            this.registrationPeriod = value;
        }

        /**
         * Gets the value of the registrationPeriodInformation property.
         * 
         * @return
         *     possible object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation }
         *     
         */
        public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation getRegistrationPeriodInformation() {
            return registrationPeriodInformation;
        }

        /**
         * Sets the value of the registrationPeriodInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation }
         *     
         */
        public void setRegistrationPeriodInformation(ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation value) {
            this.registrationPeriodInformation = value;
        }

        /**
         * Gets the value of the placingRegistrationPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPlacingRegistrationPeriod() {
            return placingRegistrationPeriod;
        }

        /**
         * Sets the value of the placingRegistrationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPlacingRegistrationPeriod(Boolean value) {
            this.placingRegistrationPeriod = value;
        }

        /**
         * Gets the value of the annulmentRegistrationPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod }
         *     
         */
        public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod getAnnulmentRegistrationPeriod() {
            return annulmentRegistrationPeriod;
        }

        /**
         * Sets the value of the annulmentRegistrationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod }
         *     
         */
        public void setAnnulmentRegistrationPeriod(ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod value) {
            this.annulmentRegistrationPeriod = value;
        }

        /**
         * Gets the value of the deleteProjectRegistrationPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeleteProjectRegistrationPeriod() {
            return deleteProjectRegistrationPeriod;
        }

        /**
         * Sets the value of the deleteProjectRegistrationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeleteProjectRegistrationPeriod(Boolean value) {
            this.deleteProjectRegistrationPeriod = value;
        }

        /**
         * Gets the value of the deleteAddressObject property.
         * 
         * @return
         *     possible object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject }
         *     
         */
        public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject getDeleteAddressObject() {
            return deleteAddressObject;
        }

        /**
         * Sets the value of the deleteAddressObject property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject }
         *     
         */
        public void setDeleteAddressObject(ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject value) {
            this.deleteAddressObject = value;
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
         *         &lt;element name="ReasonOfAnnulment">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType">
         *               &lt;minLength value="1"/>
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
            "reasonOfAnnulment"
        })
        public static class AnnulmentRegistrationPeriod {

            @XmlElement(name = "ReasonOfAnnulment", required = true)
            protected String reasonOfAnnulment;

            /**
             * Gets the value of the reasonOfAnnulment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReasonOfAnnulment() {
                return reasonOfAnnulment;
            }

            /**
             * Sets the value of the reasonOfAnnulment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReasonOfAnnulment(String value) {
                this.reasonOfAnnulment = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Base
            extends ru.gosuslugi.dom.schema.integration.volume_quality.BaseType
        {


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
         *         &lt;element name="ObjectAddress" maxOccurs="1000">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
         *                 &lt;sequence>
         *                   &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
        @XmlType(name = "", propOrder = {
            "objectAddress"
        })
        public static class DeleteAddressObject {

            @XmlElement(name = "ObjectAddress", required = true)
            protected List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress> objectAddress;

            /**
             * Gets the value of the objectAddress property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the objectAddress property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getObjectAddress().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress }
             * 
             * 
             */
            public List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress> getObjectAddress() {
                if (objectAddress == null) {
                    objectAddress = new ArrayList<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress>();
                }
                return this.objectAddress;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
             *       &lt;sequence>
             *         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "notFromContract",
                "transportGUID"
            })
            public static class ObjectAddress
                extends ObjectAddressType
            {

                @XmlElement(name = "NotFromContract")
                protected Boolean notFromContract;
                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the notFromContract property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isNotFromContract() {
                    return notFromContract;
                }

                /**
                 * Sets the value of the notFromContract property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setNotFromContract(Boolean value) {
                    this.notFromContract = value;
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

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType">
         *       &lt;sequence>
         *         &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType">
         *                 &lt;sequence>
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
         *                 &lt;/sequence>
         *               &lt;/extension>
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
            "qualityResources",
            "qualityServices",
            "volumeResources"
        })
        public static class RegistrationPeriodInformation
            extends RegistrationPeriodType
        {

            @XmlElement(name = "QualityResources")
            protected List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources> qualityResources;
            @XmlElement(name = "QualityServices")
            protected List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices> qualityServices;
            @XmlElement(name = "VolumeResources")
            protected List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources> volumeResources;

            /**
             * Gets the value of the qualityResources property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the qualityResources property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getQualityResources().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources }
             * 
             * 
             */
            public List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources> getQualityResources() {
                if (qualityResources == null) {
                    qualityResources = new ArrayList<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources>();
                }
                return this.qualityResources;
            }

            /**
             * Gets the value of the qualityServices property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the qualityServices property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getQualityServices().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices }
             * 
             * 
             */
            public List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices> getQualityServices() {
                if (qualityServices == null) {
                    qualityServices = new ArrayList<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices>();
                }
                return this.qualityServices;
            }

            /**
             * Gets the value of the volumeResources property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the volumeResources property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVolumeResources().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources }
             * 
             * 
             */
            public List<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources> getVolumeResources() {
                if (volumeResources == null) {
                    volumeResources = new ArrayList<ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources>();
                }
                return this.volumeResources;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class QualityResources
                extends QualityResourcesType
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


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class QualityServices
                extends QualityServicesType
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


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType">
             *       &lt;sequence>
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
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
                "transportGUID"
            })
            public static class VolumeResources
                extends VolumeResourcesType
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

    }

}
