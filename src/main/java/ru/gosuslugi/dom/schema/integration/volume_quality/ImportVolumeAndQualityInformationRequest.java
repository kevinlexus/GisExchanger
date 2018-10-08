
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="importVolumeAndQualityInformation"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="Base"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="RegistrationPeriodInformation"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="PlacingRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="AnnulmentRegistrationPeriod"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="ReasonOfAnnulment"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
 *                                     &lt;minLength value="1"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DeleteProjectRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="DeleteAddressObject"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="ObjectAddress" maxOccurs="1000"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                                         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.11.0.4""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="Base"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="RegistrationPeriodInformation"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="PlacingRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *           &lt;element name="AnnulmentRegistrationPeriod"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="ReasonOfAnnulment"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
     *                           &lt;minLength value="1"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="DeleteProjectRegistrationPeriod" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *           &lt;element name="DeleteAddressObject"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="ObjectAddress" maxOccurs="1000"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ReasonOfAnnulment"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ObjectAddress" maxOccurs="1000"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
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
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}RegistrationPeriodType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="QualityResources" maxOccurs="1000" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="QualityServices" maxOccurs="1000" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="VolumeResources" maxOccurs="1000" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
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
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityResourcesType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}QualityServicesType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourcesType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
