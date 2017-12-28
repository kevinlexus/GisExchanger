
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * Устав (для экспорта)
 * 
 * <p>Java class for CharterExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CharterExportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DateDetails" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterDateDetailsType" minOccurs="0"/>
 *         &lt;element name="MeetingProtocol" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="100" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NoCharterApproveProtocol" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AttachmentCharter" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CharterExportType", propOrder = {
    "date",
    "dateDetails",
    "meetingProtocol",
    "noCharterApproveProtocol",
    "attachmentCharter"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Charter.class
})
public class CharterExportType {

    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "DateDetails")
    protected CharterDateDetailsType dateDetails;
    @XmlElement(name = "MeetingProtocol")
    protected CharterExportType.MeetingProtocol meetingProtocol;
    @XmlElement(name = "NoCharterApproveProtocol")
    protected Boolean noCharterApproveProtocol;
    @XmlElement(name = "AttachmentCharter", required = true)
    protected List<AttachmentType> attachmentCharter;

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
     * Gets the value of the dateDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CharterDateDetailsType }
     *     
     */
    public CharterDateDetailsType getDateDetails() {
        return dateDetails;
    }

    /**
     * Sets the value of the dateDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterDateDetailsType }
     *     
     */
    public void setDateDetails(CharterDateDetailsType value) {
        this.dateDetails = value;
    }

    /**
     * Gets the value of the meetingProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link CharterExportType.MeetingProtocol }
     *     
     */
    public CharterExportType.MeetingProtocol getMeetingProtocol() {
        return meetingProtocol;
    }

    /**
     * Sets the value of the meetingProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharterExportType.MeetingProtocol }
     *     
     */
    public void setMeetingProtocol(CharterExportType.MeetingProtocol value) {
        this.meetingProtocol = value;
    }

    /**
     * Gets the value of the noCharterApproveProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoCharterApproveProtocol() {
        return noCharterApproveProtocol;
    }

    /**
     * Sets the value of the noCharterApproveProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoCharterApproveProtocol(Boolean value) {
        this.noCharterApproveProtocol = value;
    }

    /**
     * Gets the value of the attachmentCharter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachmentCharter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachmentCharter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getAttachmentCharter() {
        if (attachmentCharter == null) {
            attachmentCharter = new ArrayList<AttachmentType>();
        }
        return this.attachmentCharter;
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
     *         &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="100" minOccurs="0"/>
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
        "protocolMeetingOwners",
        "votingProtocolGUID"
    })
    public static class MeetingProtocol {

        @XmlElement(name = "ProtocolMeetingOwners")
        protected List<AttachmentType> protocolMeetingOwners;
        @XmlElement(name = "VotingProtocolGUID")
        protected List<String> votingProtocolGUID;

        /**
         * Gets the value of the protocolMeetingOwners property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the protocolMeetingOwners property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProtocolMeetingOwners().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getProtocolMeetingOwners() {
            if (protocolMeetingOwners == null) {
                protocolMeetingOwners = new ArrayList<AttachmentType>();
            }
            return this.protocolMeetingOwners;
        }

        /**
         * Gets the value of the votingProtocolGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the votingProtocolGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVotingProtocolGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getVotingProtocolGUID() {
            if (votingProtocolGUID == null) {
                votingProtocolGUID = new ArrayList<String>();
            }
            return this.votingProtocolGUID;
        }

    }

}
