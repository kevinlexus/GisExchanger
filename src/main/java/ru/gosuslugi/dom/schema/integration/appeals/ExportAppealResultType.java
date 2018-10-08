
package ru.gosuslugi.dom.schema.integration.appeals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 *  Тип результата экспорта обращений
 * 
 * <p>Java class for exportAppealResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportAppealResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="ParentAppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="ApplicantInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}ApplicantType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType"/&gt;
 *         &lt;element name="AppealCreateDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AppealTopic" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *           &lt;element name="AnotherTopic"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;maxLength value="250"/&gt;
 *                 &lt;minLength value="1"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/&gt;
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *         &lt;element name="AppealText" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String10000Type"/&gt;
 *         &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="AppealHistory" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
 *                   &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;choice minOccurs="0"&gt;
 *                     &lt;element name="Answer"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}AnswerInfoType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="AnswerIsSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="Redirected"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="Receiver"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="Comment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type" minOccurs="0"/&gt;
 *                               &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="RolledOver"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RollOverAppealType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="IsNotRequired"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="Assesment"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="InformationIsReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;choice&gt;
 *                                   &lt;element name="AnswerIsPartlyReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                   &lt;element name="AnswerIsNotSatisfied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                                 &lt;/choice&gt;
 *                                 &lt;element name="DeclineComment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/choice&gt;
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
 *         &lt;element name="AppealStatus" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealStatusType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Redirected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;element name="RedirectedIsNotHCS" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="RolledOver" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="AnswerIsNotRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportAppealResultType", propOrder = {
    "appealGUID",
    "parentAppealGUID",
    "applicantInfo",
    "appealNumber",
    "appealCreateDate",
    "appealTopic",
    "anotherTopic",
    "fiasHouseGuid",
    "oktmo",
    "appealText",
    "attachment",
    "answererGUID",
    "appealHistory",
    "appealStatus",
    "redirected",
    "redirectedIsNotHCS",
    "rolledOver",
    "answerIsNotRequired"
})
public class ExportAppealResultType {

    @XmlElement(name = "AppealGUID", required = true)
    protected String appealGUID;
    @XmlElement(name = "ParentAppealGUID")
    protected String parentAppealGUID;
    @XmlElement(name = "ApplicantInfo", required = true)
    protected ExportAppealResultType.ApplicantInfo applicantInfo;
    @XmlElement(name = "AppealNumber", required = true)
    protected String appealNumber;
    @XmlElement(name = "AppealCreateDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar appealCreateDate;
    @XmlElement(name = "AppealTopic")
    protected NsiRef appealTopic;
    @XmlElement(name = "AnotherTopic")
    protected String anotherTopic;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "AppealText", required = true)
    protected String appealText;
    @XmlElement(name = "Attachment")
    protected List<AttachmentType> attachment;
    @XmlElement(name = "AnswererGUID")
    protected String answererGUID;
    @XmlElement(name = "AppealHistory")
    protected List<ExportAppealResultType.AppealHistory> appealHistory;
    @XmlElement(name = "AppealStatus", required = true)
    @XmlSchemaType(name = "string")
    protected AppealStatusType appealStatus;
    @XmlElement(name = "Redirected")
    protected Boolean redirected;
    @XmlElement(name = "RedirectedIsNotHCS")
    protected Boolean redirectedIsNotHCS;
    @XmlElement(name = "RolledOver")
    protected Boolean rolledOver;
    @XmlElement(name = "AnswerIsNotRequired")
    protected Boolean answerIsNotRequired;

    /**
     * Gets the value of the appealGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppealGUID() {
        return appealGUID;
    }

    /**
     * Sets the value of the appealGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppealGUID(String value) {
        this.appealGUID = value;
    }

    /**
     * Gets the value of the parentAppealGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentAppealGUID() {
        return parentAppealGUID;
    }

    /**
     * Sets the value of the parentAppealGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentAppealGUID(String value) {
        this.parentAppealGUID = value;
    }

    /**
     * Gets the value of the applicantInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExportAppealResultType.ApplicantInfo }
     *     
     */
    public ExportAppealResultType.ApplicantInfo getApplicantInfo() {
        return applicantInfo;
    }

    /**
     * Sets the value of the applicantInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportAppealResultType.ApplicantInfo }
     *     
     */
    public void setApplicantInfo(ExportAppealResultType.ApplicantInfo value) {
        this.applicantInfo = value;
    }

    /**
     * Gets the value of the appealNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppealNumber() {
        return appealNumber;
    }

    /**
     * Sets the value of the appealNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppealNumber(String value) {
        this.appealNumber = value;
    }

    /**
     * Gets the value of the appealCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAppealCreateDate() {
        return appealCreateDate;
    }

    /**
     * Sets the value of the appealCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAppealCreateDate(XMLGregorianCalendar value) {
        this.appealCreateDate = value;
    }

    /**
     * Gets the value of the appealTopic property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getAppealTopic() {
        return appealTopic;
    }

    /**
     * Sets the value of the appealTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setAppealTopic(NsiRef value) {
        this.appealTopic = value;
    }

    /**
     * Gets the value of the anotherTopic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnotherTopic() {
        return anotherTopic;
    }

    /**
     * Sets the value of the anotherTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnotherTopic(String value) {
        this.anotherTopic = value;
    }

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
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the appealText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppealText() {
        return appealText;
    }

    /**
     * Sets the value of the appealText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppealText(String value) {
        this.appealText = value;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachment() {
        if (attachment == null) {
            attachment = new ArrayList<AttachmentType>();
        }
        return this.attachment;
    }

    /**
     * Gets the value of the answererGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswererGUID() {
        return answererGUID;
    }

    /**
     * Sets the value of the answererGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswererGUID(String value) {
        this.answererGUID = value;
    }

    /**
     * Gets the value of the appealHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appealHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppealHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAppealResultType.AppealHistory }
     * 
     * 
     */
    public List<ExportAppealResultType.AppealHistory> getAppealHistory() {
        if (appealHistory == null) {
            appealHistory = new ArrayList<ExportAppealResultType.AppealHistory>();
        }
        return this.appealHistory;
    }

    /**
     * Gets the value of the appealStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AppealStatusType }
     *     
     */
    public AppealStatusType getAppealStatus() {
        return appealStatus;
    }

    /**
     * Sets the value of the appealStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppealStatusType }
     *     
     */
    public void setAppealStatus(AppealStatusType value) {
        this.appealStatus = value;
    }

    /**
     * Gets the value of the redirected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRedirected() {
        return redirected;
    }

    /**
     * Sets the value of the redirected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedirected(Boolean value) {
        this.redirected = value;
    }

    /**
     * Gets the value of the redirectedIsNotHCS property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRedirectedIsNotHCS() {
        return redirectedIsNotHCS;
    }

    /**
     * Sets the value of the redirectedIsNotHCS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedirectedIsNotHCS(Boolean value) {
        this.redirectedIsNotHCS = value;
    }

    /**
     * Gets the value of the rolledOver property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRolledOver() {
        return rolledOver;
    }

    /**
     * Sets the value of the rolledOver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRolledOver(Boolean value) {
        this.rolledOver = value;
    }

    /**
     * Gets the value of the answerIsNotRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnswerIsNotRequired() {
        return answerIsNotRequired;
    }

    /**
     * Sets the value of the answerIsNotRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnswerIsNotRequired(Boolean value) {
        this.answerIsNotRequired = value;
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
     *         &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
     *         &lt;element name="ChangeDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;choice minOccurs="0"&gt;
     *           &lt;element name="Answer"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}AnswerInfoType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="AnswerIsSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="Redirected"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="Receiver"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Comment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type" minOccurs="0"/&gt;
     *                     &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                     &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="RolledOver"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RollOverAppealType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="IsNotRequired"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="Assesment"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="InformationIsReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                     &lt;sequence&gt;
     *                       &lt;choice&gt;
     *                         &lt;element name="AnswerIsPartlyReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                         &lt;element name="AnswerIsNotSatisfied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                       &lt;/choice&gt;
     *                       &lt;element name="DeclineComment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/choice&gt;
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
        "organization",
        "changeDate",
        "answer",
        "redirected",
        "rolledOver",
        "isNotRequired",
        "assesment"
    })
    public static class AppealHistory {

        @XmlElement(name = "Organization")
        protected RegOrgType organization;
        @XmlElement(name = "ChangeDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar changeDate;
        @XmlElement(name = "Answer")
        protected ExportAppealResultType.AppealHistory.Answer answer;
        @XmlElement(name = "Redirected")
        protected ExportAppealResultType.AppealHistory.Redirected redirected;
        @XmlElement(name = "RolledOver")
        protected ExportAppealResultType.AppealHistory.RolledOver rolledOver;
        @XmlElement(name = "IsNotRequired")
        protected ExportAppealResultType.AppealHistory.IsNotRequired isNotRequired;
        @XmlElement(name = "Assesment")
        protected ExportAppealResultType.AppealHistory.Assesment assesment;

        /**
         * Gets the value of the organization property.
         * 
         * @return
         *     possible object is
         *     {@link RegOrgType }
         *     
         */
        public RegOrgType getOrganization() {
            return organization;
        }

        /**
         * Sets the value of the organization property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegOrgType }
         *     
         */
        public void setOrganization(RegOrgType value) {
            this.organization = value;
        }

        /**
         * Gets the value of the changeDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getChangeDate() {
            return changeDate;
        }

        /**
         * Sets the value of the changeDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setChangeDate(XMLGregorianCalendar value) {
            this.changeDate = value;
        }

        /**
         * Gets the value of the answer property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAppealResultType.AppealHistory.Answer }
         *     
         */
        public ExportAppealResultType.AppealHistory.Answer getAnswer() {
            return answer;
        }

        /**
         * Sets the value of the answer property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAppealResultType.AppealHistory.Answer }
         *     
         */
        public void setAnswer(ExportAppealResultType.AppealHistory.Answer value) {
            this.answer = value;
        }

        /**
         * Gets the value of the redirected property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAppealResultType.AppealHistory.Redirected }
         *     
         */
        public ExportAppealResultType.AppealHistory.Redirected getRedirected() {
            return redirected;
        }

        /**
         * Sets the value of the redirected property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAppealResultType.AppealHistory.Redirected }
         *     
         */
        public void setRedirected(ExportAppealResultType.AppealHistory.Redirected value) {
            this.redirected = value;
        }

        /**
         * Gets the value of the rolledOver property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAppealResultType.AppealHistory.RolledOver }
         *     
         */
        public ExportAppealResultType.AppealHistory.RolledOver getRolledOver() {
            return rolledOver;
        }

        /**
         * Sets the value of the rolledOver property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAppealResultType.AppealHistory.RolledOver }
         *     
         */
        public void setRolledOver(ExportAppealResultType.AppealHistory.RolledOver value) {
            this.rolledOver = value;
        }

        /**
         * Gets the value of the isNotRequired property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAppealResultType.AppealHistory.IsNotRequired }
         *     
         */
        public ExportAppealResultType.AppealHistory.IsNotRequired getIsNotRequired() {
            return isNotRequired;
        }

        /**
         * Sets the value of the isNotRequired property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAppealResultType.AppealHistory.IsNotRequired }
         *     
         */
        public void setIsNotRequired(ExportAppealResultType.AppealHistory.IsNotRequired value) {
            this.isNotRequired = value;
        }

        /**
         * Gets the value of the assesment property.
         * 
         * @return
         *     possible object is
         *     {@link ExportAppealResultType.AppealHistory.Assesment }
         *     
         */
        public ExportAppealResultType.AppealHistory.Assesment getAssesment() {
            return assesment;
        }

        /**
         * Sets the value of the assesment property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportAppealResultType.AppealHistory.Assesment }
         *     
         */
        public void setAssesment(ExportAppealResultType.AppealHistory.Assesment value) {
            this.assesment = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}AnswerInfoType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="AnswerIsSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
            "answerIsSent"
        })
        public static class Answer
            extends AnswerInfoType
        {

            @XmlElement(name = "AnswerIsSent")
            protected Boolean answerIsSent;

            /**
             * Gets the value of the answerIsSent property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAnswerIsSent() {
                return answerIsSent;
            }

            /**
             * Sets the value of the answerIsSent property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAnswerIsSent(Boolean value) {
                this.answerIsSent = value;
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
         *         &lt;element name="InformationIsReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *         &lt;sequence&gt;
         *           &lt;choice&gt;
         *             &lt;element name="AnswerIsPartlyReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *             &lt;element name="AnswerIsNotSatisfied" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
         *           &lt;/choice&gt;
         *           &lt;element name="DeclineComment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type"/&gt;
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
            "informationIsReceived",
            "answerIsPartlyReceived",
            "answerIsNotSatisfied",
            "declineComment"
        })
        public static class Assesment {

            @XmlElement(name = "InformationIsReceived")
            protected Boolean informationIsReceived;
            @XmlElement(name = "AnswerIsPartlyReceived")
            protected Boolean answerIsPartlyReceived;
            @XmlElement(name = "AnswerIsNotSatisfied")
            protected Boolean answerIsNotSatisfied;
            @XmlElement(name = "DeclineComment")
            protected String declineComment;

            /**
             * Gets the value of the informationIsReceived property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isInformationIsReceived() {
                return informationIsReceived;
            }

            /**
             * Sets the value of the informationIsReceived property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setInformationIsReceived(Boolean value) {
                this.informationIsReceived = value;
            }

            /**
             * Gets the value of the answerIsPartlyReceived property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAnswerIsPartlyReceived() {
                return answerIsPartlyReceived;
            }

            /**
             * Sets the value of the answerIsPartlyReceived property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAnswerIsPartlyReceived(Boolean value) {
                this.answerIsPartlyReceived = value;
            }

            /**
             * Gets the value of the answerIsNotSatisfied property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAnswerIsNotSatisfied() {
                return answerIsNotSatisfied;
            }

            /**
             * Sets the value of the answerIsNotSatisfied property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAnswerIsNotSatisfied(Boolean value) {
                this.answerIsNotSatisfied = value;
            }

            /**
             * Gets the value of the declineComment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDeclineComment() {
                return declineComment;
            }

            /**
             * Sets the value of the declineComment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDeclineComment(String value) {
                this.declineComment = value;
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
         *         &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "cause"
        })
        public static class IsNotRequired {

            @XmlElement(name = "Cause", required = true)
            protected String cause;

            /**
             * Gets the value of the cause property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCause() {
                return cause;
            }

            /**
             * Sets the value of the cause property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCause(String value) {
                this.cause = value;
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
         *         &lt;element name="Receiver"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Comment" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String1000Type" minOccurs="0"/&gt;
         *         &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
            "receiver",
            "comment",
            "attachment",
            "answererGUID"
        })
        public static class Redirected {

            @XmlElement(name = "Receiver", required = true)
            protected ExportAppealResultType.AppealHistory.Redirected.Receiver receiver;
            @XmlElement(name = "Comment")
            protected String comment;
            @XmlElement(name = "Attachment")
            protected List<AttachmentType> attachment;
            @XmlElement(name = "AnswererGUID")
            protected String answererGUID;

            /**
             * Gets the value of the receiver property.
             * 
             * @return
             *     possible object is
             *     {@link ExportAppealResultType.AppealHistory.Redirected.Receiver }
             *     
             */
            public ExportAppealResultType.AppealHistory.Redirected.Receiver getReceiver() {
                return receiver;
            }

            /**
             * Sets the value of the receiver property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportAppealResultType.AppealHistory.Redirected.Receiver }
             *     
             */
            public void setReceiver(ExportAppealResultType.AppealHistory.Redirected.Receiver value) {
                this.receiver = value;
            }

            /**
             * Gets the value of the comment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComment() {
                return comment;
            }

            /**
             * Sets the value of the comment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComment(String value) {
                this.comment = value;
            }

            /**
             * Gets the value of the attachment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the attachment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAttachment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getAttachment() {
                if (attachment == null) {
                    attachment = new ArrayList<AttachmentType>();
                }
                return this.attachment;
            }

            /**
             * Gets the value of the answererGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAnswererGUID() {
                return answererGUID;
            }

            /**
             * Sets the value of the answererGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAnswererGUID(String value) {
                this.answererGUID = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
             *     &lt;/extension&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Receiver
                extends RegOrgType
            {


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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RollOverAppealType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class RolledOver
            extends RollOverAppealType
        {


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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}ApplicantType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ApplicantInfo
        extends ApplicantType
    {


    }

}
