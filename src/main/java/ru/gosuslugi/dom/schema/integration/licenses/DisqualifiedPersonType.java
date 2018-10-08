
package ru.gosuslugi.dom.schema.integration.licenses;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.individual_registry_base.FIOType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.EntpsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.LegalType;


/**
 * Сведение о дисквалифицированном лице
 * 
 * <p>Java class for DisqualifiedPersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisqualifiedPersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DisqualifiedPerson"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FIO" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
 *                   &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Org" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="Legal"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="Entrp"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="LicenseNumber" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="\d{9}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="LicenseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                   &lt;element name="LicenseRegOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Judgement"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DisqualificationBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="JudgementName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="JudgementDocumentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="JudgementDocumentNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="JudgementDocumentDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="Duration"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="DurationYears"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;minInclusive value="0"/&gt;
 *                                   &lt;pattern value="\d{1,2}"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DurationMonths"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;minInclusive value="0"/&gt;
 *                                   &lt;pattern value="(0?\d)|(1[0-1])"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DurationDays"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;minInclusive value="0"/&gt;
 *                                   &lt;pattern value="[0-2]?\d|(30)"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ExclusionDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
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
@XmlType(name = "DisqualifiedPersonType", propOrder = {
    "disqualifiedPerson",
    "org",
    "judgement"
})
public class DisqualifiedPersonType {

    @XmlElement(name = "DisqualifiedPerson", required = true)
    protected DisqualifiedPersonType.DisqualifiedPerson disqualifiedPerson;
    @XmlElement(name = "Org")
    protected DisqualifiedPersonType.Org org;
    @XmlElement(name = "Judgement", required = true)
    protected DisqualifiedPersonType.Judgement judgement;

    /**
     * Gets the value of the disqualifiedPerson property.
     * 
     * @return
     *     possible object is
     *     {@link DisqualifiedPersonType.DisqualifiedPerson }
     *     
     */
    public DisqualifiedPersonType.DisqualifiedPerson getDisqualifiedPerson() {
        return disqualifiedPerson;
    }

    /**
     * Sets the value of the disqualifiedPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisqualifiedPersonType.DisqualifiedPerson }
     *     
     */
    public void setDisqualifiedPerson(DisqualifiedPersonType.DisqualifiedPerson value) {
        this.disqualifiedPerson = value;
    }

    /**
     * Gets the value of the org property.
     * 
     * @return
     *     possible object is
     *     {@link DisqualifiedPersonType.Org }
     *     
     */
    public DisqualifiedPersonType.Org getOrg() {
        return org;
    }

    /**
     * Sets the value of the org property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisqualifiedPersonType.Org }
     *     
     */
    public void setOrg(DisqualifiedPersonType.Org value) {
        this.org = value;
    }

    /**
     * Gets the value of the judgement property.
     * 
     * @return
     *     possible object is
     *     {@link DisqualifiedPersonType.Judgement }
     *     
     */
    public DisqualifiedPersonType.Judgement getJudgement() {
        return judgement;
    }

    /**
     * Sets the value of the judgement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisqualifiedPersonType.Judgement }
     *     
     */
    public void setJudgement(DisqualifiedPersonType.Judgement value) {
        this.judgement = value;
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
     *         &lt;element name="FIO" type="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"/&gt;
     *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="BirthPlace" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "fio",
        "dateOfBirth",
        "birthPlace",
        "position"
    })
    public static class DisqualifiedPerson {

        @XmlElement(name = "FIO", required = true)
        protected FIOType fio;
        @XmlElement(name = "DateOfBirth", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateOfBirth;
        @XmlElement(name = "BirthPlace", required = true)
        protected String birthPlace;
        @XmlElement(name = "Position", required = true)
        protected String position;

        /**
         * Gets the value of the fio property.
         * 
         * @return
         *     possible object is
         *     {@link FIOType }
         *     
         */
        public FIOType getFIO() {
            return fio;
        }

        /**
         * Sets the value of the fio property.
         * 
         * @param value
         *     allowed object is
         *     {@link FIOType }
         *     
         */
        public void setFIO(FIOType value) {
            this.fio = value;
        }

        /**
         * Gets the value of the dateOfBirth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateOfBirth() {
            return dateOfBirth;
        }

        /**
         * Sets the value of the dateOfBirth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateOfBirth(XMLGregorianCalendar value) {
            this.dateOfBirth = value;
        }

        /**
         * Gets the value of the birthPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBirthPlace() {
            return birthPlace;
        }

        /**
         * Sets the value of the birthPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBirthPlace(String value) {
            this.birthPlace = value;
        }

        /**
         * Gets the value of the position property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPosition(String value) {
            this.position = value;
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
     *         &lt;element name="DisqualificationBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="JudgementName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="JudgementDocumentName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="JudgementDocumentNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="JudgementDocumentDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="Duration"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="DurationYears"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;minInclusive value="0"/&gt;
     *                         &lt;pattern value="\d{1,2}"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationMonths"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;minInclusive value="0"/&gt;
     *                         &lt;pattern value="(0?\d)|(1[0-1])"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DurationDays"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;minInclusive value="0"/&gt;
     *                         &lt;pattern value="[0-2]?\d|(30)"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ExclusionDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/&gt;
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
        "disqualificationBase",
        "judgementName",
        "judgementDocumentName",
        "judgementDocumentNumber",
        "judgementDocumentDate",
        "dateFrom",
        "duration",
        "exclusionDate",
        "additionalInformation"
    })
    public static class Judgement {

        @XmlElement(name = "DisqualificationBase", required = true)
        protected NsiRef disqualificationBase;
        @XmlElement(name = "JudgementName", required = true)
        protected String judgementName;
        @XmlElement(name = "JudgementDocumentName", required = true)
        protected String judgementDocumentName;
        @XmlElement(name = "JudgementDocumentNumber", required = true)
        protected String judgementDocumentNumber;
        @XmlElement(name = "JudgementDocumentDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar judgementDocumentDate;
        @XmlElement(name = "DateFrom", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateFrom;
        @XmlElement(name = "Duration", required = true)
        protected DisqualifiedPersonType.Judgement.Duration duration;
        @XmlElement(name = "ExclusionDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar exclusionDate;
        @XmlElement(name = "AdditionalInformation")
        protected String additionalInformation;

        /**
         * Gets the value of the disqualificationBase property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getDisqualificationBase() {
            return disqualificationBase;
        }

        /**
         * Sets the value of the disqualificationBase property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setDisqualificationBase(NsiRef value) {
            this.disqualificationBase = value;
        }

        /**
         * Gets the value of the judgementName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJudgementName() {
            return judgementName;
        }

        /**
         * Sets the value of the judgementName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJudgementName(String value) {
            this.judgementName = value;
        }

        /**
         * Gets the value of the judgementDocumentName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJudgementDocumentName() {
            return judgementDocumentName;
        }

        /**
         * Sets the value of the judgementDocumentName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJudgementDocumentName(String value) {
            this.judgementDocumentName = value;
        }

        /**
         * Gets the value of the judgementDocumentNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJudgementDocumentNumber() {
            return judgementDocumentNumber;
        }

        /**
         * Sets the value of the judgementDocumentNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJudgementDocumentNumber(String value) {
            this.judgementDocumentNumber = value;
        }

        /**
         * Gets the value of the judgementDocumentDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getJudgementDocumentDate() {
            return judgementDocumentDate;
        }

        /**
         * Sets the value of the judgementDocumentDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setJudgementDocumentDate(XMLGregorianCalendar value) {
            this.judgementDocumentDate = value;
        }

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
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link DisqualifiedPersonType.Judgement.Duration }
         *     
         */
        public DisqualifiedPersonType.Judgement.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link DisqualifiedPersonType.Judgement.Duration }
         *     
         */
        public void setDuration(DisqualifiedPersonType.Judgement.Duration value) {
            this.duration = value;
        }

        /**
         * Gets the value of the exclusionDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getExclusionDate() {
            return exclusionDate;
        }

        /**
         * Sets the value of the exclusionDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setExclusionDate(XMLGregorianCalendar value) {
            this.exclusionDate = value;
        }

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInformation(String value) {
            this.additionalInformation = value;
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
         *         &lt;element name="DurationYears"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;minInclusive value="0"/&gt;
         *               &lt;pattern value="\d{1,2}"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationMonths"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;minInclusive value="0"/&gt;
         *               &lt;pattern value="(0?\d)|(1[0-1])"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DurationDays"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;minInclusive value="0"/&gt;
         *               &lt;pattern value="[0-2]?\d|(30)"/&gt;
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
            "durationYears",
            "durationMonths",
            "durationDays"
        })
        public static class Duration {

            @XmlElement(name = "DurationYears", required = true)
            protected BigInteger durationYears;
            @XmlElement(name = "DurationMonths", required = true)
            protected BigInteger durationMonths;
            @XmlElement(name = "DurationDays", required = true)
            protected BigInteger durationDays;

            /**
             * Gets the value of the durationYears property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDurationYears() {
                return durationYears;
            }

            /**
             * Sets the value of the durationYears property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDurationYears(BigInteger value) {
                this.durationYears = value;
            }

            /**
             * Gets the value of the durationMonths property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDurationMonths() {
                return durationMonths;
            }

            /**
             * Sets the value of the durationMonths property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDurationMonths(BigInteger value) {
                this.durationMonths = value;
            }

            /**
             * Gets the value of the durationDays property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDurationDays() {
                return durationDays;
            }

            /**
             * Sets the value of the durationDays property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDurationDays(BigInteger value) {
                this.durationDays = value;
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
     *         &lt;choice&gt;
     *           &lt;element name="Legal"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="Entrp"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="LicenseNumber" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="\d{9}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="LicenseDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="LicenseRegOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
        "legal",
        "entrp",
        "licenseNumber",
        "licenseDate",
        "licenseRegOrg"
    })
    public static class Org {

        @XmlElement(name = "Legal")
        protected DisqualifiedPersonType.Org.Legal legal;
        @XmlElement(name = "Entrp")
        protected DisqualifiedPersonType.Org.Entrp entrp;
        @XmlElement(name = "LicenseNumber")
        protected String licenseNumber;
        @XmlElement(name = "LicenseDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar licenseDate;
        @XmlElement(name = "LicenseRegOrg")
        protected String licenseRegOrg;

        /**
         * Gets the value of the legal property.
         * 
         * @return
         *     possible object is
         *     {@link DisqualifiedPersonType.Org.Legal }
         *     
         */
        public DisqualifiedPersonType.Org.Legal getLegal() {
            return legal;
        }

        /**
         * Sets the value of the legal property.
         * 
         * @param value
         *     allowed object is
         *     {@link DisqualifiedPersonType.Org.Legal }
         *     
         */
        public void setLegal(DisqualifiedPersonType.Org.Legal value) {
            this.legal = value;
        }

        /**
         * Gets the value of the entrp property.
         * 
         * @return
         *     possible object is
         *     {@link DisqualifiedPersonType.Org.Entrp }
         *     
         */
        public DisqualifiedPersonType.Org.Entrp getEntrp() {
            return entrp;
        }

        /**
         * Sets the value of the entrp property.
         * 
         * @param value
         *     allowed object is
         *     {@link DisqualifiedPersonType.Org.Entrp }
         *     
         */
        public void setEntrp(DisqualifiedPersonType.Org.Entrp value) {
            this.entrp = value;
        }

        /**
         * Gets the value of the licenseNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLicenseNumber() {
            return licenseNumber;
        }

        /**
         * Sets the value of the licenseNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLicenseNumber(String value) {
            this.licenseNumber = value;
        }

        /**
         * Gets the value of the licenseDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLicenseDate() {
            return licenseDate;
        }

        /**
         * Sets the value of the licenseDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLicenseDate(XMLGregorianCalendar value) {
            this.licenseDate = value;
        }

        /**
         * Gets the value of the licenseRegOrg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLicenseRegOrg() {
            return licenseRegOrg;
        }

        /**
         * Sets the value of the licenseRegOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLicenseRegOrg(String value) {
            this.licenseRegOrg = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Entrp
            extends EntpsType
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Legal
            extends LegalType
        {


        }

    }

}
