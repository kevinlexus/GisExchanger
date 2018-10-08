
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgVersionType;


/**
 * Протокол ОСС (для экспорта)
 * 
 * <p>Java class for ProtocolExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtocolExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/&gt;
 *         &lt;element name="ProtocolNum" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="30"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ProtocolDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AVoting"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="ResolutionPlace"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="3000"/&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Meeting"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoitingType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="EVoting"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="EVotingDateBegin" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element name="EVotingDateEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element name="Discipline" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="InfoReview"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="MeetingAVoting"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                     &lt;element name="VotingPlace"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="3000"/&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="ResolutionPlace"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;maxLength value="200"/&gt;
 *                           &lt;minLength value="1"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="ExtraVoting" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="AnnualVoting" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="VoteInitiators" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}VotingInitiatorIndType"/&gt;
 *                   &lt;element name="Org" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MeetingEligibility"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="C"/&gt;
 *               &lt;enumeration value="N"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DecisionList" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="QuestionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *                     &lt;element name="QuestionName"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="3000"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DecisionsType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="Agree" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *                       &lt;element name="Against" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *                       &lt;element name="Abstent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;element name="FormingFund" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                     &lt;element name="ManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="votingResume" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="M"/&gt;
 *                         &lt;enumeration value="N"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Modification" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
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
@XmlType(name = "ProtocolExportType", propOrder = {
    "fiasHouseGuid",
    "protocolNum",
    "protocolDate",
    "aVoting",
    "meeting",
    "eVoting",
    "meetingAVoting",
    "extraVoting",
    "annualVoting",
    "voteInitiators",
    "meetingEligibility",
    "decisionList",
    "modification"
})
@XmlSeeAlso({
    ExportVotingProtocolResultType.class
})
public class ProtocolExportType {

    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "ProtocolNum")
    protected String protocolNum;
    @XmlElement(name = "ProtocolDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar protocolDate;
    @XmlElement(name = "AVoting")
    protected ProtocolExportType.AVoting aVoting;
    @XmlElement(name = "Meeting")
    protected ProtocolExportType.Meeting meeting;
    @XmlElement(name = "EVoting")
    protected ProtocolExportType.EVoting eVoting;
    @XmlElement(name = "MeetingAVoting")
    protected ProtocolExportType.MeetingAVoting meetingAVoting;
    @XmlElement(name = "ExtraVoting")
    protected Boolean extraVoting;
    @XmlElement(name = "AnnualVoting")
    protected Boolean annualVoting;
    @XmlElement(name = "VoteInitiators")
    protected List<ProtocolExportType.VoteInitiators> voteInitiators;
    @XmlElement(name = "MeetingEligibility", required = true)
    protected String meetingEligibility;
    @XmlElement(name = "DecisionList", required = true)
    protected List<ProtocolExportType.DecisionList> decisionList;
    @XmlElement(name = "Modification")
    protected String modification;

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
     * Gets the value of the protocolNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProtocolNum() {
        return protocolNum;
    }

    /**
     * Sets the value of the protocolNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProtocolNum(String value) {
        this.protocolNum = value;
    }

    /**
     * Gets the value of the protocolDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProtocolDate() {
        return protocolDate;
    }

    /**
     * Sets the value of the protocolDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProtocolDate(XMLGregorianCalendar value) {
        this.protocolDate = value;
    }

    /**
     * Gets the value of the aVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolExportType.AVoting }
     *     
     */
    public ProtocolExportType.AVoting getAVoting() {
        return aVoting;
    }

    /**
     * Sets the value of the aVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolExportType.AVoting }
     *     
     */
    public void setAVoting(ProtocolExportType.AVoting value) {
        this.aVoting = value;
    }

    /**
     * Gets the value of the meeting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolExportType.Meeting }
     *     
     */
    public ProtocolExportType.Meeting getMeeting() {
        return meeting;
    }

    /**
     * Sets the value of the meeting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolExportType.Meeting }
     *     
     */
    public void setMeeting(ProtocolExportType.Meeting value) {
        this.meeting = value;
    }

    /**
     * Gets the value of the eVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolExportType.EVoting }
     *     
     */
    public ProtocolExportType.EVoting getEVoting() {
        return eVoting;
    }

    /**
     * Sets the value of the eVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolExportType.EVoting }
     *     
     */
    public void setEVoting(ProtocolExportType.EVoting value) {
        this.eVoting = value;
    }

    /**
     * Gets the value of the meetingAVoting property.
     * 
     * @return
     *     possible object is
     *     {@link ProtocolExportType.MeetingAVoting }
     *     
     */
    public ProtocolExportType.MeetingAVoting getMeetingAVoting() {
        return meetingAVoting;
    }

    /**
     * Sets the value of the meetingAVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtocolExportType.MeetingAVoting }
     *     
     */
    public void setMeetingAVoting(ProtocolExportType.MeetingAVoting value) {
        this.meetingAVoting = value;
    }

    /**
     * Gets the value of the extraVoting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtraVoting() {
        return extraVoting;
    }

    /**
     * Sets the value of the extraVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtraVoting(Boolean value) {
        this.extraVoting = value;
    }

    /**
     * Gets the value of the annualVoting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnualVoting() {
        return annualVoting;
    }

    /**
     * Sets the value of the annualVoting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnualVoting(Boolean value) {
        this.annualVoting = value;
    }

    /**
     * Gets the value of the voteInitiators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voteInitiators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoteInitiators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProtocolExportType.VoteInitiators }
     * 
     * 
     */
    public List<ProtocolExportType.VoteInitiators> getVoteInitiators() {
        if (voteInitiators == null) {
            voteInitiators = new ArrayList<ProtocolExportType.VoteInitiators>();
        }
        return this.voteInitiators;
    }

    /**
     * Gets the value of the meetingEligibility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeetingEligibility() {
        return meetingEligibility;
    }

    /**
     * Sets the value of the meetingEligibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeetingEligibility(String value) {
        this.meetingEligibility = value;
    }

    /**
     * Gets the value of the decisionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProtocolExportType.DecisionList }
     * 
     * 
     */
    public List<ProtocolExportType.DecisionList> getDecisionList() {
        if (decisionList == null) {
            decisionList = new ArrayList<ProtocolExportType.DecisionList>();
        }
        return this.decisionList;
    }

    /**
     * Gets the value of the modification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModification() {
        return modification;
    }

    /**
     * Sets the value of the modification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModification(String value) {
        this.modification = value;
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
     *         &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="ResolutionPlace"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="3000"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
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
        "aVotingDate",
        "resolutionPlace",
        "attachments"
    })
    public static class AVoting {

        @XmlElement(name = "AVotingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar aVotingDate;
        @XmlElement(name = "ResolutionPlace", required = true)
        protected String resolutionPlace;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the aVotingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAVotingDate() {
            return aVotingDate;
        }

        /**
         * Sets the value of the aVotingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAVotingDate(XMLGregorianCalendar value) {
            this.aVotingDate = value;
        }

        /**
         * Gets the value of the resolutionPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResolutionPlace() {
            return resolutionPlace;
        }

        /**
         * Sets the value of the resolutionPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResolutionPlace(String value) {
            this.resolutionPlace = value;
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
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *         &lt;sequence&gt;
     *           &lt;element name="QuestionNumber" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
     *           &lt;element name="QuestionName"&gt;
     *             &lt;simpleType&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                 &lt;minLength value="1"/&gt;
     *                 &lt;maxLength value="3000"/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/simpleType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="DecisionsType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="Agree" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
     *             &lt;element name="Against" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
     *             &lt;element name="Abstent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;element name="FormingFund" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *           &lt;element name="ManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="votingResume" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="M"/&gt;
     *               &lt;enumeration value="N"/&gt;
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
        "questionNumber",
        "questionName",
        "decisionsType",
        "agree",
        "against",
        "abstent",
        "formingFund",
        "managementType",
        "votingResume"
    })
    public static class DecisionList {

        @XmlElement(name = "QuestionNumber")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger questionNumber;
        @XmlElement(name = "QuestionName", required = true)
        protected String questionName;
        @XmlElement(name = "DecisionsType", required = true)
        protected NsiRef decisionsType;
        @XmlElement(name = "Agree")
        protected BigDecimal agree;
        @XmlElement(name = "Against")
        protected BigDecimal against;
        @XmlElement(name = "Abstent")
        protected BigDecimal abstent;
        @XmlElement(name = "FormingFund")
        protected NsiRef formingFund;
        @XmlElement(name = "ManagementType")
        protected NsiRef managementType;
        protected String votingResume;

        /**
         * Gets the value of the questionNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getQuestionNumber() {
            return questionNumber;
        }

        /**
         * Sets the value of the questionNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setQuestionNumber(BigInteger value) {
            this.questionNumber = value;
        }

        /**
         * Gets the value of the questionName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQuestionName() {
            return questionName;
        }

        /**
         * Sets the value of the questionName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQuestionName(String value) {
            this.questionName = value;
        }

        /**
         * Gets the value of the decisionsType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getDecisionsType() {
            return decisionsType;
        }

        /**
         * Sets the value of the decisionsType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setDecisionsType(NsiRef value) {
            this.decisionsType = value;
        }

        /**
         * Gets the value of the agree property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAgree() {
            return agree;
        }

        /**
         * Sets the value of the agree property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAgree(BigDecimal value) {
            this.agree = value;
        }

        /**
         * Gets the value of the against property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAgainst() {
            return against;
        }

        /**
         * Sets the value of the against property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAgainst(BigDecimal value) {
            this.against = value;
        }

        /**
         * Gets the value of the abstent property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAbstent() {
            return abstent;
        }

        /**
         * Sets the value of the abstent property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAbstent(BigDecimal value) {
            this.abstent = value;
        }

        /**
         * Gets the value of the formingFund property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getFormingFund() {
            return formingFund;
        }

        /**
         * Sets the value of the formingFund property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setFormingFund(NsiRef value) {
            this.formingFund = value;
        }

        /**
         * Gets the value of the managementType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getManagementType() {
            return managementType;
        }

        /**
         * Sets the value of the managementType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setManagementType(NsiRef value) {
            this.managementType = value;
        }

        /**
         * Gets the value of the votingResume property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVotingResume() {
            return votingResume;
        }

        /**
         * Sets the value of the votingResume property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVotingResume(String value) {
            this.votingResume = value;
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
     *         &lt;element name="EVotingDateBegin" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="EVotingDateEnd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="Discipline" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="InfoReview"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "eVotingDateBegin",
        "eVotingDateEnd",
        "discipline",
        "infoReview",
        "attachments"
    })
    public static class EVoting {

        @XmlElement(name = "EVotingDateBegin", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar eVotingDateBegin;
        @XmlElement(name = "EVotingDateEnd", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar eVotingDateEnd;
        @XmlElement(name = "Discipline")
        protected String discipline;
        @XmlElement(name = "InfoReview", required = true)
        protected String infoReview;
        @XmlElement(name = "Attachments")
        protected List<Attachments> attachments;

        /**
         * Gets the value of the eVotingDateBegin property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEVotingDateBegin() {
            return eVotingDateBegin;
        }

        /**
         * Sets the value of the eVotingDateBegin property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEVotingDateBegin(XMLGregorianCalendar value) {
            this.eVotingDateBegin = value;
        }

        /**
         * Gets the value of the eVotingDateEnd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEVotingDateEnd() {
            return eVotingDateEnd;
        }

        /**
         * Sets the value of the eVotingDateEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEVotingDateEnd(XMLGregorianCalendar value) {
            this.eVotingDateEnd = value;
        }

        /**
         * Gets the value of the discipline property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDiscipline() {
            return discipline;
        }

        /**
         * Sets the value of the discipline property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDiscipline(String value) {
            this.discipline = value;
        }

        /**
         * Gets the value of the infoReview property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInfoReview() {
            return infoReview;
        }

        /**
         * Sets the value of the infoReview property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInfoReview(String value) {
            this.infoReview = value;
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
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}VoitingType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
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
        "meetingDate",
        "attachments"
    })
    public static class Meeting
        extends VoitingType
    {

        @XmlElement(name = "MeetingDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar meetingDate;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the meetingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMeetingDate() {
            return meetingDate;
        }

        /**
         * Sets the value of the meetingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMeetingDate(XMLGregorianCalendar value) {
            this.meetingDate = value;
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
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *         &lt;element name="MeetingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="VotingPlace"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="3000"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AVotingDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="ResolutionPlace"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;maxLength value="200"/&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}Attachments" maxOccurs="unbounded"/&gt;
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
        "meetingDate",
        "votingPlace",
        "aVotingDate",
        "resolutionPlace",
        "attachments"
    })
    public static class MeetingAVoting {

        @XmlElement(name = "MeetingDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar meetingDate;
        @XmlElement(name = "VotingPlace", required = true)
        protected String votingPlace;
        @XmlElement(name = "AVotingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar aVotingDate;
        @XmlElement(name = "ResolutionPlace", required = true)
        protected String resolutionPlace;
        @XmlElement(name = "Attachments", required = true)
        protected List<Attachments> attachments;

        /**
         * Gets the value of the meetingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getMeetingDate() {
            return meetingDate;
        }

        /**
         * Sets the value of the meetingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setMeetingDate(XMLGregorianCalendar value) {
            this.meetingDate = value;
        }

        /**
         * Gets the value of the votingPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVotingPlace() {
            return votingPlace;
        }

        /**
         * Sets the value of the votingPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVotingPlace(String value) {
            this.votingPlace = value;
        }

        /**
         * Gets the value of the aVotingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAVotingDate() {
            return aVotingDate;
        }

        /**
         * Sets the value of the aVotingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAVotingDate(XMLGregorianCalendar value) {
            this.aVotingDate = value;
        }

        /**
         * Gets the value of the resolutionPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getResolutionPlace() {
            return resolutionPlace;
        }

        /**
         * Sets the value of the resolutionPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setResolutionPlace(String value) {
            this.resolutionPlace = value;
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
         * {@link Attachments }
         * 
         * 
         */
        public List<Attachments> getAttachments() {
            if (attachments == null) {
                attachments = new ArrayList<Attachments>();
            }
            return this.attachments;
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
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}VotingInitiatorIndType"/&gt;
     *         &lt;element name="Org" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgVersionType"/&gt;
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
        "ind",
        "org"
    })
    public static class VoteInitiators {

        @XmlElement(name = "Ind")
        protected VotingInitiatorIndType ind;
        @XmlElement(name = "Org")
        protected RegOrgVersionType org;

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link VotingInitiatorIndType }
         *     
         */
        public VotingInitiatorIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link VotingInitiatorIndType }
         *     
         */
        public void setInd(VotingInitiatorIndType value) {
            this.ind = value;
        }

        /**
         * Gets the value of the org property.
         * 
         * @return
         *     possible object is
         *     {@link RegOrgVersionType }
         *     
         */
        public RegOrgVersionType getOrg() {
            return org;
        }

        /**
         * Sets the value of the org property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegOrgVersionType }
         *     
         */
        public void setOrg(RegOrgVersionType value) {
            this.org = value;
        }

    }

}
