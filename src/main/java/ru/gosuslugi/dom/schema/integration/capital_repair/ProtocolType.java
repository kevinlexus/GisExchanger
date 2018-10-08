
package ru.gosuslugi.dom.schema.integration.capital_repair;

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
 * Общий тип для ротокола общего собрания собственников
 * 
 * <p>Java class for ProtocolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtocolType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"/&gt;
 *           &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *           &lt;choice&gt;
 *             &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/&gt;
 *             &lt;element name="DocumentIsNotAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;/choice&gt;
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
@XmlType(name = "ProtocolType", propOrder = {
    "votingProtocolGUID",
    "number",
    "date",
    "attachment",
    "documentIsNotAvailable"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.DecisionType.Protocol.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.DecisionPDType.Reason.Protocol.class
})
public class ProtocolType {

    @XmlElement(name = "VotingProtocolGUID")
    protected String votingProtocolGUID;
    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Attachment")
    protected List<AttachmentType> attachment;
    @XmlElement(name = "DocumentIsNotAvailable")
    protected Boolean documentIsNotAvailable;

    /**
     * Gets the value of the votingProtocolGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVotingProtocolGUID() {
        return votingProtocolGUID;
    }

    /**
     * Sets the value of the votingProtocolGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVotingProtocolGUID(String value) {
        this.votingProtocolGUID = value;
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
     * Gets the value of the documentIsNotAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDocumentIsNotAvailable() {
        return documentIsNotAvailable;
    }

    /**
     * Sets the value of the documentIsNotAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDocumentIsNotAvailable(Boolean value) {
        this.documentIsNotAvailable = value;
    }

}
