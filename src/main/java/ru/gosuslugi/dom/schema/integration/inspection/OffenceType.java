
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


/**
 * Протокол об административном правонарушении.
 * 
 * <p>Java class for OffenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OffenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
 *         &lt;element name="Date" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/&gt;
 *         &lt;element name="ShortInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *         &lt;element name="IsFulfiledOffence" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IsSubmittedToCourt" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CourtName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
 *                   &lt;element name="SubmittedDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/&gt;
 *                   &lt;element name="SubmittedNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ActualFulfiledOffenceDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType" minOccurs="0"/&gt;
 *         &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OffenceType", propOrder = {
    "number",
    "date",
    "shortInfo",
    "isFulfiledOffence",
    "isSubmittedToCourt",
    "actualFulfiledOffenceDate",
    "attachment"
})
public class OffenceType {

    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "ShortInfo")
    protected String shortInfo;
    @XmlElement(name = "IsFulfiledOffence")
    protected Boolean isFulfiledOffence;
    @XmlElement(name = "IsSubmittedToCourt")
    protected OffenceType.IsSubmittedToCourt isSubmittedToCourt;
    @XmlElement(name = "ActualFulfiledOffenceDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actualFulfiledOffenceDate;
    @XmlElement(name = "Attachment", required = true)
    protected List<AttachmentType> attachment;

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
     * Gets the value of the shortInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortInfo() {
        return shortInfo;
    }

    /**
     * Sets the value of the shortInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortInfo(String value) {
        this.shortInfo = value;
    }

    /**
     * Gets the value of the isFulfiledOffence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFulfiledOffence() {
        return isFulfiledOffence;
    }

    /**
     * Sets the value of the isFulfiledOffence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFulfiledOffence(Boolean value) {
        this.isFulfiledOffence = value;
    }

    /**
     * Gets the value of the isSubmittedToCourt property.
     * 
     * @return
     *     possible object is
     *     {@link OffenceType.IsSubmittedToCourt }
     *     
     */
    public OffenceType.IsSubmittedToCourt getIsSubmittedToCourt() {
        return isSubmittedToCourt;
    }

    /**
     * Sets the value of the isSubmittedToCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link OffenceType.IsSubmittedToCourt }
     *     
     */
    public void setIsSubmittedToCourt(OffenceType.IsSubmittedToCourt value) {
        this.isSubmittedToCourt = value;
    }

    /**
     * Gets the value of the actualFulfiledOffenceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualFulfiledOffenceDate() {
        return actualFulfiledOffenceDate;
    }

    /**
     * Sets the value of the actualFulfiledOffenceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualFulfiledOffenceDate(XMLGregorianCalendar value) {
        this.actualFulfiledOffenceDate = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="CourtName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
     *         &lt;element name="SubmittedDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/&gt;
     *         &lt;element name="SubmittedNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
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
        "courtName",
        "submittedDate",
        "submittedNumber"
    })
    public static class IsSubmittedToCourt {

        @XmlElement(name = "CourtName", required = true)
        protected String courtName;
        @XmlElement(name = "SubmittedDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar submittedDate;
        @XmlElement(name = "SubmittedNumber", required = true)
        protected String submittedNumber;

        /**
         * Gets the value of the courtName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCourtName() {
            return courtName;
        }

        /**
         * Sets the value of the courtName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCourtName(String value) {
            this.courtName = value;
        }

        /**
         * Gets the value of the submittedDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSubmittedDate() {
            return submittedDate;
        }

        /**
         * Sets the value of the submittedDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSubmittedDate(XMLGregorianCalendar value) {
            this.submittedDate = value;
        }

        /**
         * Gets the value of the submittedNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmittedNumber() {
            return submittedNumber;
        }

        /**
         * Sets the value of the submittedNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmittedNumber(String value) {
            this.submittedNumber = value;
        }

    }

}
