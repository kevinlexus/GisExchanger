
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Проверка.
 * 
 * <p>Java class for ExaminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExaminationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExaminationOverview">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;choice>
 *                     &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;sequence>
 *                       &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                       &lt;element name="URIRegistrationNumber" minOccurs="0">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;pattern value="\d{14}|\d{12}"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="URIRegistrationDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType" minOccurs="0"/>
 *                     &lt;/sequence>
 *                   &lt;/choice>
 *                   &lt;element name="ExaminationTypeType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="Scheduled">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Unscheduled">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/>
 *                   &lt;element name="OrderDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RegulatoryAuthorityInformation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/>
 *                   &lt;element name="RegulatoryAuthorityID" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}RegulatoryAuthorityIDType">
 *                         &lt;pattern value="\d{1,22}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AuthorizedPersons" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
 *                             &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NotificationInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;sequence>
 *                     &lt;element name="NotificationDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/>
 *                     &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExaminationInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                   &lt;element name="BasedOnPrecept" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="RelatedExamination" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
 *                   &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
 *                   &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
 *                   &lt;element name="From" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateTimeType"/>
 *                   &lt;element name="To" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateTimeType" minOccurs="0"/>
 *                   &lt;element name="Duration" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="WorkDays" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="WorkHours" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/>
 *                   &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ProsecutorAgreementInformationType" minOccurs="0"/>
 *                   &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/>
 *                   &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExecutingInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded"/>
 *                   &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ResultsInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ResultsInfoType" minOccurs="0"/>
 *         &lt;element name="Attachments" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExaminationType", propOrder = {
    "examinationOverview",
    "regulatoryAuthorityInformation",
    "notificationInfo",
    "examinationInfo",
    "executingInfo",
    "resultsInfo",
    "attachments"
})
public class ExaminationType {

    @XmlElement(name = "ExaminationOverview", required = true)
    protected ExaminationType.ExaminationOverview examinationOverview;
    @XmlElement(name = "RegulatoryAuthorityInformation", required = true)
    protected ExaminationType.RegulatoryAuthorityInformation regulatoryAuthorityInformation;
    @XmlElement(name = "NotificationInfo", required = true)
    protected ExaminationType.NotificationInfo notificationInfo;
    @XmlElement(name = "ExaminationInfo", required = true)
    protected ExaminationType.ExaminationInfo examinationInfo;
    @XmlElement(name = "ExecutingInfo")
    protected ExaminationType.ExecutingInfo executingInfo;
    @XmlElement(name = "ResultsInfo")
    protected ResultsInfoType resultsInfo;
    @XmlElement(name = "Attachments")
    protected List<AttachmentType> attachments;

    /**
     * Gets the value of the examinationOverview property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationType.ExaminationOverview }
     *     
     */
    public ExaminationType.ExaminationOverview getExaminationOverview() {
        return examinationOverview;
    }

    /**
     * Sets the value of the examinationOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationType.ExaminationOverview }
     *     
     */
    public void setExaminationOverview(ExaminationType.ExaminationOverview value) {
        this.examinationOverview = value;
    }

    /**
     * Gets the value of the regulatoryAuthorityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public ExaminationType.RegulatoryAuthorityInformation getRegulatoryAuthorityInformation() {
        return regulatoryAuthorityInformation;
    }

    /**
     * Sets the value of the regulatoryAuthorityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public void setRegulatoryAuthorityInformation(ExaminationType.RegulatoryAuthorityInformation value) {
        this.regulatoryAuthorityInformation = value;
    }

    /**
     * Gets the value of the notificationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationType.NotificationInfo }
     *     
     */
    public ExaminationType.NotificationInfo getNotificationInfo() {
        return notificationInfo;
    }

    /**
     * Sets the value of the notificationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationType.NotificationInfo }
     *     
     */
    public void setNotificationInfo(ExaminationType.NotificationInfo value) {
        this.notificationInfo = value;
    }

    /**
     * Gets the value of the examinationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationType.ExaminationInfo }
     *     
     */
    public ExaminationType.ExaminationInfo getExaminationInfo() {
        return examinationInfo;
    }

    /**
     * Sets the value of the examinationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationType.ExaminationInfo }
     *     
     */
    public void setExaminationInfo(ExaminationType.ExaminationInfo value) {
        this.examinationInfo = value;
    }

    /**
     * Gets the value of the executingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExaminationType.ExecutingInfo }
     *     
     */
    public ExaminationType.ExecutingInfo getExecutingInfo() {
        return executingInfo;
    }

    /**
     * Sets the value of the executingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExaminationType.ExecutingInfo }
     *     
     */
    public void setExecutingInfo(ExaminationType.ExecutingInfo value) {
        this.executingInfo = value;
    }

    /**
     * Gets the value of the resultsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResultsInfoType }
     *     
     */
    public ResultsInfoType getResultsInfo() {
        return resultsInfo;
    }

    /**
     * Sets the value of the resultsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultsInfoType }
     *     
     */
    public void setResultsInfo(ResultsInfoType value) {
        this.resultsInfo = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<AttachmentType>();
        }
        return this.attachments;
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
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="BasedOnPrecept" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="RelatedExamination" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/>
     *         &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
     *         &lt;element name="From" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateTimeType"/>
     *         &lt;element name="To" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateTimeType" minOccurs="0"/>
     *         &lt;element name="Duration" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="WorkDays" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="WorkHours" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/>
     *         &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ProsecutorAgreementInformationType" minOccurs="0"/>
     *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/>
     *         &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/>
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
        "base",
        "basedOnPrecept",
        "relatedExamination",
        "objective",
        "additionalInfoAboutExamBase",
        "tasks",
        "object",
        "from",
        "to",
        "duration",
        "cooperationWith",
        "prosecutorAgreementInformation",
        "additionalInfo",
        "inspectionInabilityReason"
    })
    public static class ExaminationInfo {

        @XmlElement(name = "Base")
        protected NsiRef base;
        @XmlElement(name = "BasedOnPrecept")
        protected ExaminationType.ExaminationInfo.BasedOnPrecept basedOnPrecept;
        @XmlElement(name = "RelatedExamination")
        protected ExaminationType.ExaminationInfo.RelatedExamination relatedExamination;
        @XmlElement(name = "Objective", required = true)
        protected String objective;
        @XmlElement(name = "AdditionalInfoAboutExamBase")
        protected String additionalInfoAboutExamBase;
        @XmlElement(name = "Tasks", required = true)
        protected String tasks;
        @XmlElement(name = "Object", required = true)
        protected List<NsiRef> object;
        @XmlElement(name = "From", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar from;
        @XmlElement(name = "To")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar to;
        @XmlElement(name = "Duration")
        protected ExaminationType.ExaminationInfo.Duration duration;
        @XmlElement(name = "CooperationWith")
        protected String cooperationWith;
        @XmlElement(name = "ProsecutorAgreementInformation")
        protected ProsecutorAgreementInformationType prosecutorAgreementInformation;
        @XmlElement(name = "AdditionalInfo")
        protected String additionalInfo;
        @XmlElement(name = "InspectionInabilityReason")
        protected String inspectionInabilityReason;

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
         * Gets the value of the basedOnPrecept property.
         * 
         * @return
         *     possible object is
         *     {@link ExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public ExaminationType.ExaminationInfo.BasedOnPrecept getBasedOnPrecept() {
            return basedOnPrecept;
        }

        /**
         * Sets the value of the basedOnPrecept property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public void setBasedOnPrecept(ExaminationType.ExaminationInfo.BasedOnPrecept value) {
            this.basedOnPrecept = value;
        }

        /**
         * Gets the value of the relatedExamination property.
         * 
         * @return
         *     possible object is
         *     {@link ExaminationType.ExaminationInfo.RelatedExamination }
         *     
         */
        public ExaminationType.ExaminationInfo.RelatedExamination getRelatedExamination() {
            return relatedExamination;
        }

        /**
         * Sets the value of the relatedExamination property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType.ExaminationInfo.RelatedExamination }
         *     
         */
        public void setRelatedExamination(ExaminationType.ExaminationInfo.RelatedExamination value) {
            this.relatedExamination = value;
        }

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
         * Gets the value of the tasks property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTasks() {
            return tasks;
        }

        /**
         * Sets the value of the tasks property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTasks(String value) {
            this.tasks = value;
        }

        /**
         * Gets the value of the object property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the object property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getObject() {
            if (object == null) {
                object = new ArrayList<NsiRef>();
            }
            return this.object;
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
         *     {@link ExaminationType.ExaminationInfo.Duration }
         *     
         */
        public ExaminationType.ExaminationInfo.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType.ExaminationInfo.Duration }
         *     
         */
        public void setDuration(ExaminationType.ExaminationInfo.Duration value) {
            this.duration = value;
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
         *     {@link ProsecutorAgreementInformationType }
         *     
         */
        public ProsecutorAgreementInformationType getProsecutorAgreementInformation() {
            return prosecutorAgreementInformation;
        }

        /**
         * Sets the value of the prosecutorAgreementInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProsecutorAgreementInformationType }
         *     
         */
        public void setProsecutorAgreementInformation(ProsecutorAgreementInformationType value) {
            this.prosecutorAgreementInformation = value;
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
         * Gets the value of the inspectionInabilityReason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInspectionInabilityReason() {
            return inspectionInabilityReason;
        }

        /**
         * Sets the value of the inspectionInabilityReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInspectionInabilityReason(String value) {
            this.inspectionInabilityReason = value;
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
         *         &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "preceptGuid"
        })
        public static class BasedOnPrecept {

            @XmlElement(name = "PreceptGuid", required = true)
            protected String preceptGuid;

            /**
             * Gets the value of the preceptGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPreceptGuid() {
                return preceptGuid;
            }

            /**
             * Sets the value of the preceptGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPreceptGuid(String value) {
                this.preceptGuid = value;
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
         *         &lt;element name="WorkDays" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="WorkHours" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType">
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
         *         &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
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
            "examinationGuid"
        })
        public static class RelatedExamination {

            @XmlElement(name = "ExaminationGuid", required = true)
            protected String examinationGuid;

            /**
             * Gets the value of the examinationGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExaminationGuid() {
                return examinationGuid;
            }

            /**
             * Sets the value of the examinationGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExaminationGuid(String value) {
                this.examinationGuid = value;
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
     *         &lt;choice>
     *           &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;sequence>
     *             &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *             &lt;element name="URIRegistrationNumber" minOccurs="0">
     *               &lt;simpleType>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                   &lt;pattern value="\d{14}|\d{12}"/>
     *                 &lt;/restriction>
     *               &lt;/simpleType>
     *             &lt;/element>
     *             &lt;element name="URIRegistrationDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType" minOccurs="0"/>
     *           &lt;/sequence>
     *         &lt;/choice>
     *         &lt;element name="ExaminationTypeType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="Scheduled">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Unscheduled">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/>
     *         &lt;element name="OrderDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType" minOccurs="0"/>
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
        "shouldNotBeRegistered",
        "shouldBeRegistered",
        "uriRegistrationNumber",
        "uriRegistrationDate",
        "examinationTypeType",
        "oversightActivitiesRef",
        "examinationForm",
        "orderNumber",
        "orderDate"
    })
    public static class ExaminationOverview {

        @XmlElement(name = "ShouldNotBeRegistered")
        protected Boolean shouldNotBeRegistered;
        @XmlElement(name = "ShouldBeRegistered")
        protected Boolean shouldBeRegistered;
        @XmlElement(name = "URIRegistrationNumber")
        protected String uriRegistrationNumber;
        @XmlElement(name = "URIRegistrationDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar uriRegistrationDate;
        @XmlElement(name = "ExaminationTypeType", required = true)
        protected ExaminationType.ExaminationOverview.ExaminationTypeType examinationTypeType;
        @XmlElement(name = "OversightActivitiesRef", required = true)
        protected NsiRef oversightActivitiesRef;
        @XmlElement(name = "ExaminationForm", required = true)
        protected NsiRef examinationForm;
        @XmlElement(name = "OrderNumber")
        protected String orderNumber;
        @XmlElement(name = "OrderDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar orderDate;

        /**
         * Gets the value of the shouldNotBeRegistered property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isShouldNotBeRegistered() {
            return shouldNotBeRegistered;
        }

        /**
         * Sets the value of the shouldNotBeRegistered property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setShouldNotBeRegistered(Boolean value) {
            this.shouldNotBeRegistered = value;
        }

        /**
         * Gets the value of the shouldBeRegistered property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isShouldBeRegistered() {
            return shouldBeRegistered;
        }

        /**
         * Sets the value of the shouldBeRegistered property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setShouldBeRegistered(Boolean value) {
            this.shouldBeRegistered = value;
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
         * Gets the value of the examinationTypeType property.
         * 
         * @return
         *     possible object is
         *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public ExaminationType.ExaminationOverview.ExaminationTypeType getExaminationTypeType() {
            return examinationTypeType;
        }

        /**
         * Sets the value of the examinationTypeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public void setExaminationTypeType(ExaminationType.ExaminationOverview.ExaminationTypeType value) {
            this.examinationTypeType = value;
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
         * Gets the value of the orderNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrderNumber() {
            return orderNumber;
        }

        /**
         * Sets the value of the orderNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrderNumber(String value) {
            this.orderNumber = value;
        }

        /**
         * Gets the value of the orderDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getOrderDate() {
            return orderDate;
        }

        /**
         * Sets the value of the orderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setOrderDate(XMLGregorianCalendar value) {
            this.orderDate = value;
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
         *         &lt;element name="Scheduled">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Unscheduled">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
            "scheduled",
            "unscheduled"
        })
        public static class ExaminationTypeType {

            @XmlElement(name = "Scheduled")
            protected ExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled scheduled;
            @XmlElement(name = "Unscheduled")
            protected ExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled unscheduled;

            /**
             * Gets the value of the scheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public ExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled getScheduled() {
                return scheduled;
            }

            /**
             * Sets the value of the scheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public void setScheduled(ExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled value) {
                this.scheduled = value;
            }

            /**
             * Gets the value of the unscheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public ExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled getUnscheduled() {
                return unscheduled;
            }

            /**
             * Sets the value of the unscheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public void setUnscheduled(ExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled value) {
                this.unscheduled = value;
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
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/>
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
                "subject"
            })
            public static class Scheduled {

                @XmlElement(name = "Subject", required = true)
                protected ScheduledExaminationSubjectInfoType subject;

                /**
                 * Gets the value of the subject property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ScheduledExaminationSubjectInfoType }
                 *     
                 */
                public ScheduledExaminationSubjectInfoType getSubject() {
                    return subject;
                }

                /**
                 * Sets the value of the subject property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ScheduledExaminationSubjectInfoType }
                 *     
                 */
                public void setSubject(ScheduledExaminationSubjectInfoType value) {
                    this.subject = value;
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
             *         &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}UnscheduledExaminationSubjectInfoType"/>
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
                "baseURIRegistration",
                "subject"
            })
            public static class Unscheduled {

                @XmlElement(name = "BaseURIRegistration")
                protected NsiRef baseURIRegistration;
                @XmlElement(name = "Subject", required = true)
                protected UnscheduledExaminationSubjectInfoType subject;

                /**
                 * Gets the value of the baseURIRegistration property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getBaseURIRegistration() {
                    return baseURIRegistration;
                }

                /**
                 * Sets the value of the baseURIRegistration property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setBaseURIRegistration(NsiRef value) {
                    this.baseURIRegistration = value;
                }

                /**
                 * Gets the value of the subject property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link UnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public UnscheduledExaminationSubjectInfoType getSubject() {
                    return subject;
                }

                /**
                 * Sets the value of the subject property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link UnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public void setSubject(UnscheduledExaminationSubjectInfoType value) {
                    this.subject = value;
                }

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
     *         &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded"/>
     *         &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/>
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
        "event",
        "place"
    })
    public static class ExecutingInfo {

        @XmlElement(name = "Event", required = true)
        protected List<ExaminationEventType> event;
        @XmlElement(name = "Place")
        protected List<ExaminationPlaceType> place;

        /**
         * Gets the value of the event property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the event property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExaminationEventType }
         * 
         * 
         */
        public List<ExaminationEventType> getEvent() {
            if (event == null) {
                event = new ArrayList<ExaminationEventType>();
            }
            return this.event;
        }

        /**
         * Gets the value of the place property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the place property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlace().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExaminationPlaceType }
         * 
         * 
         */
        public List<ExaminationPlaceType> getPlace() {
            if (place == null) {
                place = new ArrayList<ExaminationPlaceType>();
            }
            return this.place;
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
     *       &lt;choice>
     *         &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;sequence>
     *           &lt;element name="NotificationDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/>
     *           &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/>
     *         &lt;/sequence>
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
        "notRequired",
        "requiredAndNotSent",
        "notificationDate",
        "notificationMethod"
    })
    public static class NotificationInfo {

        @XmlElement(name = "NotRequired")
        protected Boolean notRequired;
        @XmlElement(name = "RequiredAndNotSent")
        protected Boolean requiredAndNotSent;
        @XmlElement(name = "NotificationDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar notificationDate;
        @XmlElement(name = "NotificationMethod")
        protected String notificationMethod;

        /**
         * Gets the value of the notRequired property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotRequired() {
            return notRequired;
        }

        /**
         * Sets the value of the notRequired property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotRequired(Boolean value) {
            this.notRequired = value;
        }

        /**
         * Gets the value of the requiredAndNotSent property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRequiredAndNotSent() {
            return requiredAndNotSent;
        }

        /**
         * Sets the value of the requiredAndNotSent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRequiredAndNotSent(Boolean value) {
            this.requiredAndNotSent = value;
        }

        /**
         * Gets the value of the notificationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getNotificationDate() {
            return notificationDate;
        }

        /**
         * Sets the value of the notificationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setNotificationDate(XMLGregorianCalendar value) {
            this.notificationDate = value;
        }

        /**
         * Gets the value of the notificationMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotificationMethod() {
            return notificationMethod;
        }

        /**
         * Sets the value of the notificationMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotificationMethod(String value) {
            this.notificationMethod = value;
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
     *         &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/>
     *         &lt;element name="RegulatoryAuthorityID" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}RegulatoryAuthorityIDType">
     *               &lt;pattern value="\d{1,22}"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AuthorizedPersons" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
     *                   &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "regulatoryAuthorityID",
        "authorizedPersons",
        "involvedExperts"
    })
    public static class RegulatoryAuthorityInformation {

        @XmlElement(name = "FunctionRegistryNumber", required = true)
        protected String functionRegistryNumber;
        @XmlElement(name = "RegulatoryAuthorityID")
        protected String regulatoryAuthorityID;
        @XmlElement(name = "AuthorizedPersons")
        protected ExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons authorizedPersons;
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
         * Gets the value of the regulatoryAuthorityID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegulatoryAuthorityID() {
            return regulatoryAuthorityID;
        }

        /**
         * Sets the value of the regulatoryAuthorityID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegulatoryAuthorityID(String value) {
            this.regulatoryAuthorityID = value;
        }

        /**
         * Gets the value of the authorizedPersons property.
         * 
         * @return
         *     possible object is
         *     {@link ExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons }
         *     
         */
        public ExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons getAuthorizedPersons() {
            return authorizedPersons;
        }

        /**
         * Sets the value of the authorizedPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons }
         *     
         */
        public void setAuthorizedPersons(ExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons value) {
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
         *         &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
         *         &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/>
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
            "fullName",
            "position"
        })
        public static class AuthorizedPersons {

            @XmlElement(name = "FullName")
            protected String fullName;
            @XmlElement(name = "Position")
            protected String position;

            /**
             * Gets the value of the fullName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFullName() {
                return fullName;
            }

            /**
             * Sets the value of the fullName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFullName(String value) {
                this.fullName = value;
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

    }

}
