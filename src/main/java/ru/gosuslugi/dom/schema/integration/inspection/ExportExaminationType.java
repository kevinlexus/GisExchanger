
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
 * Проверка (экспорт)
 * 
 * <p>Java class for exportExaminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportExaminationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExaminationOverview"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                       &lt;element name="URIRegistrationNumber" minOccurs="0"&gt;
 *                         &lt;simpleType&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                             &lt;pattern value="\d{1,18}"/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/simpleType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="ExaminationTypeType"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="Scheduled"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Unscheduled"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                                       &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportUnscheduledExaminationSubjectInfoType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                   &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *                   &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RegulatoryAuthorityInformation" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/&gt;
 *                   &lt;element name="RegulatoryAuthorityID" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}RegulatoryAuthorityIDType"&gt;
 *                         &lt;pattern value="\d{1,22}"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AuthorizedPersons" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
 *                             &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NotificationInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="NotificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExaminationInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                   &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/&gt;
 *                   &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                   &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                   &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="BasedOnPrecept" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RelatedExamination" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                   &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                   &lt;element name="Duration" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="WorkDays" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="WorkHours" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/&gt;
 *                   &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportProsecutorAgreementInformationType" minOccurs="0"/&gt;
 *                   &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/&gt;
 *                   &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExecutingInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ResultsInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportResultsInfoType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExaminationChangeInfo" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationChangeInfoType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
 *         &lt;element name="Attachments" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportExaminationType", propOrder = {
    "examinationOverview",
    "regulatoryAuthorityInformation",
    "notificationInfo",
    "examinationInfo",
    "executingInfo",
    "resultsInfo",
    "examinationChangeInfo",
    "cancelledInfo",
    "attachments"
})
public class ExportExaminationType {

    @XmlElement(name = "ExaminationOverview", required = true)
    protected ExportExaminationType.ExaminationOverview examinationOverview;
    @XmlElement(name = "RegulatoryAuthorityInformation")
    protected ExportExaminationType.RegulatoryAuthorityInformation regulatoryAuthorityInformation;
    @XmlElement(name = "NotificationInfo")
    protected ExportExaminationType.NotificationInfo notificationInfo;
    @XmlElement(name = "ExaminationInfo", required = true)
    protected ExportExaminationType.ExaminationInfo examinationInfo;
    @XmlElement(name = "ExecutingInfo")
    protected ExportExaminationType.ExecutingInfo executingInfo;
    @XmlElement(name = "ResultsInfo")
    protected ExportExaminationType.ResultsInfo resultsInfo;
    @XmlElement(name = "ExaminationChangeInfo")
    protected ExportExaminationType.ExaminationChangeInfo examinationChangeInfo;
    @XmlElement(name = "CancelledInfo")
    protected ExportCancelledInfoWithAttachmentsType cancelledInfo;
    @XmlElement(name = "Attachments")
    protected List<AttachmentType> attachments;

    /**
     * Gets the value of the examinationOverview property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExaminationOverview }
     *     
     */
    public ExportExaminationType.ExaminationOverview getExaminationOverview() {
        return examinationOverview;
    }

    /**
     * Sets the value of the examinationOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExaminationOverview }
     *     
     */
    public void setExaminationOverview(ExportExaminationType.ExaminationOverview value) {
        this.examinationOverview = value;
    }

    /**
     * Gets the value of the regulatoryAuthorityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public ExportExaminationType.RegulatoryAuthorityInformation getRegulatoryAuthorityInformation() {
        return regulatoryAuthorityInformation;
    }

    /**
     * Sets the value of the regulatoryAuthorityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.RegulatoryAuthorityInformation }
     *     
     */
    public void setRegulatoryAuthorityInformation(ExportExaminationType.RegulatoryAuthorityInformation value) {
        this.regulatoryAuthorityInformation = value;
    }

    /**
     * Gets the value of the notificationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.NotificationInfo }
     *     
     */
    public ExportExaminationType.NotificationInfo getNotificationInfo() {
        return notificationInfo;
    }

    /**
     * Sets the value of the notificationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.NotificationInfo }
     *     
     */
    public void setNotificationInfo(ExportExaminationType.NotificationInfo value) {
        this.notificationInfo = value;
    }

    /**
     * Gets the value of the examinationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExaminationInfo }
     *     
     */
    public ExportExaminationType.ExaminationInfo getExaminationInfo() {
        return examinationInfo;
    }

    /**
     * Sets the value of the examinationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExaminationInfo }
     *     
     */
    public void setExaminationInfo(ExportExaminationType.ExaminationInfo value) {
        this.examinationInfo = value;
    }

    /**
     * Gets the value of the executingInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExecutingInfo }
     *     
     */
    public ExportExaminationType.ExecutingInfo getExecutingInfo() {
        return executingInfo;
    }

    /**
     * Sets the value of the executingInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExecutingInfo }
     *     
     */
    public void setExecutingInfo(ExportExaminationType.ExecutingInfo value) {
        this.executingInfo = value;
    }

    /**
     * Gets the value of the resultsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ResultsInfo }
     *     
     */
    public ExportExaminationType.ResultsInfo getResultsInfo() {
        return resultsInfo;
    }

    /**
     * Sets the value of the resultsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ResultsInfo }
     *     
     */
    public void setResultsInfo(ExportExaminationType.ResultsInfo value) {
        this.resultsInfo = value;
    }

    /**
     * Gets the value of the examinationChangeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportExaminationType.ExaminationChangeInfo }
     *     
     */
    public ExportExaminationType.ExaminationChangeInfo getExaminationChangeInfo() {
        return examinationChangeInfo;
    }

    /**
     * Sets the value of the examinationChangeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportExaminationType.ExaminationChangeInfo }
     *     
     */
    public void setExaminationChangeInfo(ExportExaminationType.ExaminationChangeInfo value) {
        this.examinationChangeInfo = value;
    }

    /**
     * Gets the value of the cancelledInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportCancelledInfoWithAttachmentsType }
     *     
     */
    public ExportCancelledInfoWithAttachmentsType getCancelledInfo() {
        return cancelledInfo;
    }

    /**
     * Sets the value of the cancelledInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportCancelledInfoWithAttachmentsType }
     *     
     */
    public void setCancelledInfo(ExportCancelledInfoWithAttachmentsType value) {
        this.cancelledInfo = value;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationChangeInfoType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExaminationChangeInfo
        extends ExportExaminationChangeInfoType
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
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *         &lt;element name="Objective" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/&gt;
     *         &lt;element name="AdditionalInfoAboutExamBase" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
     *         &lt;element name="Tasks" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
     *         &lt;element name="Object" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="BasedOnPrecept" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RelatedExamination" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *         &lt;element name="Duration" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="WorkDays" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="WorkHours" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CooperationWith" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2048Type" minOccurs="0"/&gt;
     *         &lt;element name="ProsecutorAgreementInformation" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportProsecutorAgreementInformationType" minOccurs="0"/&gt;
     *         &lt;element name="AdditionalInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/&gt;
     *         &lt;element name="InspectionInabilityReason" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String4000Type" minOccurs="0"/&gt;
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
        "base",
        "objective",
        "additionalInfoAboutExamBase",
        "tasks",
        "object",
        "basedOnPrecept",
        "relatedExamination",
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
        @XmlElement(name = "Objective", required = true)
        protected String objective;
        @XmlElement(name = "AdditionalInfoAboutExamBase")
        protected String additionalInfoAboutExamBase;
        @XmlElement(name = "Tasks")
        protected String tasks;
        @XmlElement(name = "Object")
        protected List<NsiRef> object;
        @XmlElement(name = "BasedOnPrecept")
        protected ExportExaminationType.ExaminationInfo.BasedOnPrecept basedOnPrecept;
        @XmlElement(name = "RelatedExamination")
        protected ExportExaminationType.ExaminationInfo.RelatedExamination relatedExamination;
        @XmlElement(name = "From", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar from;
        @XmlElement(name = "To")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar to;
        @XmlElement(name = "Duration")
        protected ExportExaminationType.ExaminationInfo.Duration duration;
        @XmlElement(name = "CooperationWith")
        protected String cooperationWith;
        @XmlElement(name = "ProsecutorAgreementInformation")
        protected ExportProsecutorAgreementInformationType prosecutorAgreementInformation;
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
         * Gets the value of the basedOnPrecept property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public ExportExaminationType.ExaminationInfo.BasedOnPrecept getBasedOnPrecept() {
            return basedOnPrecept;
        }

        /**
         * Sets the value of the basedOnPrecept property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationInfo.BasedOnPrecept }
         *     
         */
        public void setBasedOnPrecept(ExportExaminationType.ExaminationInfo.BasedOnPrecept value) {
            this.basedOnPrecept = value;
        }

        /**
         * Gets the value of the relatedExamination property.
         * 
         * @return
         *     possible object is
         *     {@link ExportExaminationType.ExaminationInfo.RelatedExamination }
         *     
         */
        public ExportExaminationType.ExaminationInfo.RelatedExamination getRelatedExamination() {
            return relatedExamination;
        }

        /**
         * Sets the value of the relatedExamination property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationInfo.RelatedExamination }
         *     
         */
        public void setRelatedExamination(ExportExaminationType.ExaminationInfo.RelatedExamination value) {
            this.relatedExamination = value;
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
         *     {@link ExportExaminationType.ExaminationInfo.Duration }
         *     
         */
        public ExportExaminationType.ExaminationInfo.Duration getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationInfo.Duration }
         *     
         */
        public void setDuration(ExportExaminationType.ExaminationInfo.Duration value) {
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
         *     {@link ExportProsecutorAgreementInformationType }
         *     
         */
        public ExportProsecutorAgreementInformationType getProsecutorAgreementInformation() {
            return prosecutorAgreementInformation;
        }

        /**
         * Sets the value of the prosecutorAgreementInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportProsecutorAgreementInformationType }
         *     
         */
        public void setProsecutorAgreementInformation(ExportProsecutorAgreementInformationType value) {
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="PreceptGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="WorkDays" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="WorkHours" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}TimeUnitCountType"&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *             &lt;element name="URIRegistrationNumber" minOccurs="0"&gt;
     *               &lt;simpleType&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                   &lt;pattern value="\d{1,18}"/&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/simpleType&gt;
     *             &lt;/element&gt;
     *             &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *           &lt;/sequence&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="ExaminationTypeType"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="Scheduled"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Unscheduled"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                             &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportUnscheduledExaminationSubjectInfoType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="OversightActivitiesRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *         &lt;element name="ExaminationForm" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="OrderNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
     *         &lt;element name="OrderDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
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
        protected ExportExaminationType.ExaminationOverview.ExaminationTypeType examinationTypeType;
        @XmlElement(name = "OversightActivitiesRef")
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
         *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public ExportExaminationType.ExaminationOverview.ExaminationTypeType getExaminationTypeType() {
            return examinationTypeType;
        }

        /**
         * Sets the value of the examinationTypeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType }
         *     
         */
        public void setExaminationTypeType(ExportExaminationType.ExaminationOverview.ExaminationTypeType value) {
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;choice&gt;
         *         &lt;element name="Scheduled"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Unscheduled"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
         *                   &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportUnscheduledExaminationSubjectInfoType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "scheduled",
            "unscheduled"
        })
        public static class ExaminationTypeType {

            @XmlElement(name = "Scheduled")
            protected ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled scheduled;
            @XmlElement(name = "Unscheduled")
            protected ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled unscheduled;

            /**
             * Gets the value of the scheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled getScheduled() {
                return scheduled;
            }

            /**
             * Sets the value of the scheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled }
             *     
             */
            public void setScheduled(ExportExaminationType.ExaminationOverview.ExaminationTypeType.Scheduled value) {
                this.scheduled = value;
            }

            /**
             * Gets the value of the unscheduled property.
             * 
             * @return
             *     possible object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled getUnscheduled() {
                return unscheduled;
            }

            /**
             * Sets the value of the unscheduled property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled }
             *     
             */
            public void setUnscheduled(ExportExaminationType.ExaminationOverview.ExaminationTypeType.Unscheduled value) {
                this.unscheduled = value;
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
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ScheduledExaminationSubjectInfoType"/&gt;
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
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="BaseURIRegistration" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
             *         &lt;element name="Subject" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportUnscheduledExaminationSubjectInfoType"/&gt;
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
                "baseURIRegistration",
                "subject"
            })
            public static class Unscheduled {

                @XmlElement(name = "BaseURIRegistration")
                protected NsiRef baseURIRegistration;
                @XmlElement(name = "Subject", required = true)
                protected ExportUnscheduledExaminationSubjectInfoType subject;

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
                 *     {@link ExportUnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public ExportUnscheduledExaminationSubjectInfoType getSubject() {
                    return subject;
                }

                /**
                 * Sets the value of the subject property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ExportUnscheduledExaminationSubjectInfoType }
                 *     
                 */
                public void setSubject(ExportUnscheduledExaminationSubjectInfoType value) {
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Event" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="Place" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationPlaceType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "event",
        "place"
    })
    public static class ExecutingInfo {

        @XmlElement(name = "Event")
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="NotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="RequiredAndNotSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;sequence&gt;
     *           &lt;element name="NotificationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *           &lt;element name="NotificationMethod" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="FunctionRegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}FunctionRegistryNumberType"/&gt;
     *         &lt;element name="RegulatoryAuthorityID" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}RegulatoryAuthorityIDType"&gt;
     *               &lt;pattern value="\d{1,22}"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AuthorizedPersons" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
     *                   &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="InvolvedExperts" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
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
        protected ExportExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons authorizedPersons;
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
         *     {@link ExportExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons }
         *     
         */
        public ExportExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons getAuthorizedPersons() {
            return authorizedPersons;
        }

        /**
         * Sets the value of the authorizedPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons }
         *     
         */
        public void setAuthorizedPersons(ExportExaminationType.RegulatoryAuthorityInformation.AuthorizedPersons value) {
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="FullName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
         *         &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String256Type" minOccurs="0"/&gt;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportResultsInfoType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="CancelExaminationResults" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
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
        "cancelExaminationResults"
    })
    public static class ResultsInfo
        extends ExportResultsInfoType
    {

        @XmlElement(name = "CancelExaminationResults")
        protected ExportCancelledInfoWithAttachmentsType cancelExaminationResults;

        /**
         * Gets the value of the cancelExaminationResults property.
         * 
         * @return
         *     possible object is
         *     {@link ExportCancelledInfoWithAttachmentsType }
         *     
         */
        public ExportCancelledInfoWithAttachmentsType getCancelExaminationResults() {
            return cancelExaminationResults;
        }

        /**
         * Sets the value of the cancelExaminationResults property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportCancelledInfoWithAttachmentsType }
         *     
         */
        public void setCancelExaminationResults(ExportCancelledInfoWithAttachmentsType value) {
            this.cancelExaminationResults = value;
        }

    }

}
