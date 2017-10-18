
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Плановая проверка (пункт плана проверок) - экспорт
 * 
 * <p>Java class for exportPlannedExaminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportPlannedExaminationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberInPlan">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}NumberType">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="URIRegistrationNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{1,18}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInPlanInfoType"/>
 *         &lt;element name="RegulatoryAuthorityInformation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType" minOccurs="0"/>
 *                   &lt;element name="AuthorizedPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *         &lt;element name="PlannedExaminationInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="LastExaminationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="MonthFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}MonthType"/>
 *                   &lt;element name="YearFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/>
 *                   &lt;element name="Duration">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="WorkDays">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="WorkHours">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/>
 *                   &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
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
@XmlType(name = "exportPlannedExaminationType", propOrder = {
    "numberInPlan",
    "uriRegistrationNumber",
    "uriRegistrationDate",
    "subject",
    "regulatoryAuthorityInformation",
    "oversightActivitiesRef",
    "plannedExaminationInfo"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo.class
})
public class ExportPlannedExaminationType {

    @XmlElement(name = "NumberInPlan")
    protected int numberInPlan;
    @XmlElement(name = "URIRegistrationNumber")
    protected String uriRegistrationNumber;
    @XmlElement(name = "URIRegistrationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar uriRegistrationDate;
    @XmlElement(name = "Subject", required = true)
    protected ScheduledExaminationSubjectInPlanInfoType subject;
    @XmlElement(name = "RegulatoryAuthorityInformation", required = true)
    protected ExportPlannedExaminationType.RegulatoryAuthorityInformation regulatoryAuthorityInformation;
    @XmlElement(name = "OversightActivitiesRef")
    protected NsiRef oversightActivitiesRef;
    @XmlElement(name = "PlannedExaminationInfo", required = true)
    protected ExportPlannedExaminationType.PlannedExaminationInfo plannedExaminationInfo;

    /**
     * Gets the value of the numberInPlan property.
     * 
     */
    public int getNumberInPlan() {
        return numberInPlan;
    }

    /**
     * Sets the value of the numberInPlan property.
     * 
     */
    public void setNumberInPlan(int value) {
        this.numberInPlan = value;
    }

    /**
     * Gets the value of the uriRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURIRegistrationNumber() {
        return uriRegistrationNumber;
    }

    /**
     * Sets the value of the uriRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURIRegistrationNumber(String value) {
        this.uriRegistrationNumber = value;
    }

    /**
     * Gets the value of the uriRegistrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getURIRegistrationDate() {
        return uriRegistrationDate;
    }

    /**
     * Sets the value of the uriRegistrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setURIRegistrationDate(XMLGregorianCalendar value) {
        this.uriRegistrationDate = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType }
     *     
     */
    public ScheduledExaminationSubjectInPlanInfoType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType }
     *     
     */
    public void setSubject(ScheduledExaminationSubjectInPlanInfoType value) {
        this.subject = value;
    }

    /**
     * Gets the value of the regulatoryAuthorityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ExportPlannedExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public ExportPlannedExaminationType.RegulatoryAuthorityInformation getRegulatoryAuthorityInformation() {
        return regulatoryAuthorityInformation;
    }

    /**
     * Sets the value of the regulatoryAuthorityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportPlannedExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public void setRegulatoryAuthorityInformation(ExportPlannedExaminationType.RegulatoryAuthorityInformation value) {
        this.regulatoryAuthorityInformation = value;
    }

    /**
     * Gets the value of the oversightActivitiesRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getOversightActivitiesRef() {
        return oversightActivitiesRef;
    }

    /**
     * Sets the value of the oversightActivitiesRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setOversightActivitiesRef(NsiRef value) {
        this.oversightActivitiesRef = value;
    }

    /**
     * Gets the value of the plannedExaminationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportPlannedExaminationType.PlannedExaminationInfo }
     *     
     */
    public ExportPlannedExaminationType.PlannedExaminationInfo getPlannedExaminationInfo() {
        return plannedExaminationInfo;
    }

    /**
     * Sets the value of the plannedExaminationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportPlannedExaminationType.PlannedExaminationInfo }
     *     
     */
    public void setPlannedExaminationInfo(ExportPlannedExaminationType.PlannedExaminationInfo value) {
        this.plannedExaminationInfo = value;
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
     *         &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="LastExaminationEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="MonthFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}MonthType"/>
     *         &lt;element name="YearFrom" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/>
     *         &lt;element name="Duration">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="WorkDays">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="WorkHours">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/>
     *         &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "objective",
        "base",
        "additionalInfoAboutExamBase",
        "lastExaminationEndDate",
        "monthFrom",
        "yearFrom",
        "duration",
        "examinationForm",
        "cooperationWith",
        "prosecutorAgreementInformation"
    })
    public static class PlannedExaminationInfo {

        @XmlElement(name = "Objective", required = true)
        protected String objective;
        @XmlElement(name = "Base")
        protected NsiRef base;
        @XmlElement(name = "AdditionalInfoAboutExamBase")
        protected String additionalInfoAboutExamBase;
        @XmlElement(name = "LastExaminationEndDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar lastExaminationEndDate;
        @XmlElement(name = "MonthFrom")
        protected int monthFrom;
        @XmlElement(name = "YearFrom")
        protected short yearFrom;
        @XmlElement(name = "Duration", required = true)
        protected ExportPlannedExaminationType.PlannedExaminationInfo.Duration duration;
        @XmlElement(name = "ExaminationForm", required = true)
        protected NsiRef examinationForm;
        @XmlElement(name = "CooperationWith")
        protected String cooperationWith;
        @XmlElement(name = "ProsecutorAgreementInformation")
        protected String prosecutorAgreementInformation;

        /**
         * Gets the value of the objective property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjective() {
            return objective;
        }

        /**
         * Sets the value of the objective property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjective(String value) {
            this.objective = value;
        }

        /**
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setBase(NsiRef value) {
            this.base = value;
        }

        /**
         * Gets the value of the additionalInfoAboutExamBase property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInfoAboutExamBase() {
            return additionalInfoAboutExamBase;
        }

        /**
         * Sets the value of the additionalInfoAboutExamBase property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInfoAboutExamBase(String value) {
            this.additionalInfoAboutExamBase = value;
        }

        /**
         * Gets the value of the lastExaminationEndDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getLastExaminationEndDate() {
            return lastExaminationEndDate;
        }

        /**
         * Sets the value of the lastExaminationEndDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setLastExaminationEndDate(XMLGregorianCalendar value) {
            this.lastExaminationEndDate = value;
        }

        /**
         * Gets the value of the monthFrom property.
         * 
         */
        public int getMonthFrom() {
            return monthFrom;
        }

        /**
         * Sets the value of the monthFrom property.
         * 
         */
        public void setMonthFrom(int value) {
            this.monthFrom = value;
        }

        /**
         * Gets the value of the yearFrom property.
         * 
         */
        public short getYearFrom() {
            return yearFrom;
        }

        /**
         * Sets the value of the yearFrom property.
         * 
         */
        public void setYearFrom(short value) {
            this.yearFrom = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link ExportPlannedExaminationType.PlannedExaminationInfo.Duration }
         *     
         */
        public ExportPlannedExaminationType.PlannedExaminationInfo.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportPlannedExaminationType.PlannedExaminationInfo.Duration }
         *     
         */
        public void setDuration(ExportPlannedExaminationType.PlannedExaminationInfo.Duration value) {
            this.duration = value;
        }

        /**
         * Gets the value of the examinationForm property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getExaminationForm() {
            return examinationForm;
        }

        /**
         * Sets the value of the examinationForm property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setExaminationForm(NsiRef value) {
            this.examinationForm = value;
        }

        /**
         * Gets the value of the cooperationWith property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCooperationWith() {
            return cooperationWith;
        }

        /**
         * Sets the value of the cooperationWith property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCooperationWith(String value) {
            this.cooperationWith = value;
        }

        /**
         * Gets the value of the prosecutorAgreementInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProsecutorAgreementInformation() {
            return prosecutorAgreementInformation;
        }

        /**
         * Sets the value of the prosecutorAgreementInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProsecutorAgreementInformation(String value) {
            this.prosecutorAgreementInformation = value;
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
         *         &lt;element name="WorkDays">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="WorkHours">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
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
            "workDays",
            "workHours"
        })
        public static class Duration {

            @XmlElement(name = "WorkDays")
            protected Double workDays;
            @XmlElement(name = "WorkHours")
            protected Double workHours;

            /**
             * Gets the value of the workDays property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWorkDays() {
                return workDays;
            }

            /**
             * Sets the value of the workDays property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWorkDays(Double value) {
                this.workDays = value;
            }

            /**
             * Gets the value of the workHours property.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWorkHours() {
                return workHours;
            }

            /**
             * Sets the value of the workHours property.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWorkHours(Double value) {
                this.workHours = value;
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
     *       &lt;sequence>
     *         &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType" minOccurs="0"/>
     *         &lt;element name="AuthorizedPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
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
        "functionRegistryNumber",
        "authorizedPersons",
        "involvedExperts"
    })
    public static class RegulatoryAuthorityInformation {

        @XmlElement(name = "FunctionRegistryNumber")
        protected String functionRegistryNumber;
        @XmlElement(name = "AuthorizedPersons")
        protected String authorizedPersons;
        @XmlElement(name = "InvolvedExperts")
        protected String involvedExperts;

        /**
         * Gets the value of the functionRegistryNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFunctionRegistryNumber() {
            return functionRegistryNumber;
        }

        /**
         * Sets the value of the functionRegistryNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFunctionRegistryNumber(String value) {
            this.functionRegistryNumber = value;
        }

        /**
         * Gets the value of the authorizedPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthorizedPersons() {
            return authorizedPersons;
        }

        /**
         * Sets the value of the authorizedPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthorizedPersons(String value) {
            this.authorizedPersons = value;
        }

        /**
         * Gets the value of the involvedExperts property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInvolvedExperts() {
            return involvedExperts;
        }

        /**
         * Sets the value of the involvedExperts property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInvolvedExperts(String value) {
            this.involvedExperts = value;
        }

    }

}
