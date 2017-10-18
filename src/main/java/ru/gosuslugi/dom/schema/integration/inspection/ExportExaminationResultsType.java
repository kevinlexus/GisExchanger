
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Результат проверки для экспорта
 * 
 * <p>Java class for ExportExaminationResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportExaminationResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;choice>
 *           &lt;element name="HasNoOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="HasOffence" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element name="IdentifiedOffencesInfo" minOccurs="0">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element name="NatureOffence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="DetailsMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="RegulationOffencedLegalAct" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
 *                       &lt;element name="OtherMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
 *                       &lt;element name="PersonsOffenceList" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
 *                       &lt;element name="MaterialsDirectionAgency" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="MaterialsDirectionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                       &lt;element name="ApplyingMeasures" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="PersonsAdministrativeResponsibilityInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="PermittingDocumensAnnulmentInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                       &lt;element name="AppealInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Duration" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Days" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element name="Hours" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *         &lt;element name="InspectionPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *         &lt;element name="AbsentRepresentatives" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RepresentativesRegionPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *         &lt;element name="SettlingDocumentPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportExaminationResultsType", propOrder = {
    "documentType",
    "number",
    "date",
    "hasNoOffence",
    "hasOffence",
    "identifiedOffencesInfo",
    "from",
    "to",
    "duration",
    "place",
    "inspectionPersons",
    "absentRepresentatives",
    "representativesRegionPersons",
    "settlingDocumentPlace",
    "additionalInfo"
})
public class ExportExaminationResultsType {

    @XmlElement(name = "DocumentType", required = true)
    protected NsiRef documentType;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "HasNoOffence")
    protected Boolean hasNoOffence;
    @XmlElement(name = "HasOffence")
    protected Boolean hasOffence;
    @XmlElement(name = "IdentifiedOffencesInfo")
    protected ExportExaminationResultsType.IdentifiedOffencesInfo identifiedOffencesInfo;
    @XmlElement(name = "From")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar from;
    @XmlElement(name = "To")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar to;
    @XmlElement(name = "Duration")
    protected ExportExaminationResultsType.Duration duration;
    @XmlElement(name = "Place")
    protected String place;
    @XmlElement(name = "InspectionPersons")
    protected String inspectionPersons;
    @XmlElement(name = "AbsentRepresentatives")
    protected Boolean absentRepresentatives;
    @XmlElement(name = "RepresentativesRegionPersons")
    protected String representativesRegionPersons;
    @XmlElement(name = "SettlingDocumentPlace")
    protected String settlingDocumentPlace;
    @XmlElement(name = "AdditionalInfo")
    protected String additionalInfo;

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setDocumentType(NsiRef value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the hasNoOffence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasNoOffence() {
        return hasNoOffence;
    }

    /**
     * Sets the value of the hasNoOffence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasNoOffence(Boolean value) {
        this.hasNoOffence = value;
    }

    /**
     * Gets the value of the hasOffence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasOffence() {
        return hasOffence;
    }

    /**
     * Sets the value of the hasOffence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasOffence(Boolean value) {
        this.hasOffence = value;
    }

    /**
     * Gets the value of the identifiedOffencesInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationResultsType.IdentifiedOffencesInfo }
     *     
     */
    public ExportExaminationResultsType.IdentifiedOffencesInfo getIdentifiedOffencesInfo() {
        return identifiedOffencesInfo;
    }

    /**
     * Sets the value of the identifiedOffencesInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationResultsType.IdentifiedOffencesInfo }
     *     
     */
    public void setIdentifiedOffencesInfo(ExportExaminationResultsType.IdentifiedOffencesInfo value) {
        this.identifiedOffencesInfo = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationResultsType.Duration }
     *     
     */
    public ExportExaminationResultsType.Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationResultsType.Duration }
     *     
     */
    public void setDuration(ExportExaminationResultsType.Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the place property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets the value of the place property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlace(String value) {
        this.place = value;
    }

    /**
     * Gets the value of the inspectionPersons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionPersons() {
        return inspectionPersons;
    }

    /**
     * Sets the value of the inspectionPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionPersons(String value) {
        this.inspectionPersons = value;
    }

    /**
     * Gets the value of the absentRepresentatives property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAbsentRepresentatives() {
        return absentRepresentatives;
    }

    /**
     * Sets the value of the absentRepresentatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAbsentRepresentatives(Boolean value) {
        this.absentRepresentatives = value;
    }

    /**
     * Gets the value of the representativesRegionPersons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepresentativesRegionPersons() {
        return representativesRegionPersons;
    }

    /**
     * Sets the value of the representativesRegionPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepresentativesRegionPersons(String value) {
        this.representativesRegionPersons = value;
    }

    /**
     * Gets the value of the settlingDocumentPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlingDocumentPlace() {
        return settlingDocumentPlace;
    }

    /**
     * Sets the value of the settlingDocumentPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlingDocumentPlace(String value) {
        this.settlingDocumentPlace = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
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
     *         &lt;element name="Days" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element name="Hours" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType" minOccurs="0"/>
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
        "days",
        "hours"
    })
    public static class Duration {

        @XmlElement(name = "Days")
        protected Object days;
        @XmlElement(name = "Hours")
        protected Double hours;

        /**
         * Gets the value of the days property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getDays() {
            return days;
        }

        /**
         * Sets the value of the days property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setDays(Object value) {
            this.days = value;
        }

        /**
         * Gets the value of the hours property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getHours() {
            return hours;
        }

        /**
         * Sets the value of the hours property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setHours(Double value) {
            this.hours = value;
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
     *         &lt;element name="NatureOffence" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="DetailsMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="RegulationOffencedLegalAct" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
     *         &lt;element name="OtherMismatch" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
     *         &lt;element name="PersonsOffenceList" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String1024Type" minOccurs="0"/>
     *         &lt;element name="MaterialsDirectionAgency" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="MaterialsDirectionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="ApplyingMeasures" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="PersonsAdministrativeResponsibilityInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="PermittingDocumensAnnulmentInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="AppealInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "natureOffence",
        "detailsMismatch",
        "regulationOffencedLegalAct",
        "otherMismatch",
        "personsOffenceList",
        "materialsDirectionAgency",
        "materialsDirectionDate",
        "applyingMeasures",
        "personsAdministrativeResponsibilityInfo",
        "permittingDocumensAnnulmentInfo",
        "appealInfo"
    })
    public static class IdentifiedOffencesInfo {

        @XmlElement(name = "NatureOffence")
        protected String natureOffence;
        @XmlElement(name = "DetailsMismatch")
        protected String detailsMismatch;
        @XmlElement(name = "RegulationOffencedLegalAct")
        protected String regulationOffencedLegalAct;
        @XmlElement(name = "OtherMismatch")
        protected String otherMismatch;
        @XmlElement(name = "PersonsOffenceList")
        protected String personsOffenceList;
        @XmlElement(name = "MaterialsDirectionAgency")
        protected String materialsDirectionAgency;
        @XmlElement(name = "MaterialsDirectionDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar materialsDirectionDate;
        @XmlElement(name = "ApplyingMeasures")
        protected String applyingMeasures;
        @XmlElement(name = "PersonsAdministrativeResponsibilityInfo")
        protected String personsAdministrativeResponsibilityInfo;
        @XmlElement(name = "PermittingDocumensAnnulmentInfo")
        protected String permittingDocumensAnnulmentInfo;
        @XmlElement(name = "AppealInfo")
        protected String appealInfo;

        /**
         * Gets the value of the natureOffence property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNatureOffence() {
            return natureOffence;
        }

        /**
         * Sets the value of the natureOffence property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNatureOffence(String value) {
            this.natureOffence = value;
        }

        /**
         * Gets the value of the detailsMismatch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetailsMismatch() {
            return detailsMismatch;
        }

        /**
         * Sets the value of the detailsMismatch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetailsMismatch(String value) {
            this.detailsMismatch = value;
        }

        /**
         * Gets the value of the regulationOffencedLegalAct property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegulationOffencedLegalAct() {
            return regulationOffencedLegalAct;
        }

        /**
         * Sets the value of the regulationOffencedLegalAct property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegulationOffencedLegalAct(String value) {
            this.regulationOffencedLegalAct = value;
        }

        /**
         * Gets the value of the otherMismatch property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOtherMismatch() {
            return otherMismatch;
        }

        /**
         * Sets the value of the otherMismatch property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOtherMismatch(String value) {
            this.otherMismatch = value;
        }

        /**
         * Gets the value of the personsOffenceList property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPersonsOffenceList() {
            return personsOffenceList;
        }

        /**
         * Sets the value of the personsOffenceList property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPersonsOffenceList(String value) {
            this.personsOffenceList = value;
        }

        /**
         * Gets the value of the materialsDirectionAgency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaterialsDirectionAgency() {
            return materialsDirectionAgency;
        }

        /**
         * Sets the value of the materialsDirectionAgency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaterialsDirectionAgency(String value) {
            this.materialsDirectionAgency = value;
        }

        /**
         * Gets the value of the materialsDirectionDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMaterialsDirectionDate() {
            return materialsDirectionDate;
        }

        /**
         * Sets the value of the materialsDirectionDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMaterialsDirectionDate(XMLGregorianCalendar value) {
            this.materialsDirectionDate = value;
        }

        /**
         * Gets the value of the applyingMeasures property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplyingMeasures() {
            return applyingMeasures;
        }

        /**
         * Sets the value of the applyingMeasures property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplyingMeasures(String value) {
            this.applyingMeasures = value;
        }

        /**
         * Gets the value of the personsAdministrativeResponsibilityInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPersonsAdministrativeResponsibilityInfo() {
            return personsAdministrativeResponsibilityInfo;
        }

        /**
         * Sets the value of the personsAdministrativeResponsibilityInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPersonsAdministrativeResponsibilityInfo(String value) {
            this.personsAdministrativeResponsibilityInfo = value;
        }

        /**
         * Gets the value of the permittingDocumensAnnulmentInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPermittingDocumensAnnulmentInfo() {
            return permittingDocumensAnnulmentInfo;
        }

        /**
         * Sets the value of the permittingDocumensAnnulmentInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPermittingDocumensAnnulmentInfo(String value) {
            this.permittingDocumensAnnulmentInfo = value;
        }

        /**
         * Gets the value of the appealInfo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAppealInfo() {
            return appealInfo;
        }

        /**
         * Sets the value of the appealInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAppealInfo(String value) {
            this.appealInfo = value;
        }

    }

}
