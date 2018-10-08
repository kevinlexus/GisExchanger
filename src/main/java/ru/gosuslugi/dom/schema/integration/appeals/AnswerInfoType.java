
package ru.gosuslugi.dom.schema.integration.appeals;

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
 * Информация об ответе
 * 
 * <p>Java class for AnswerInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnswerInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnswerNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AnswerNumberType" minOccurs="0"/&gt;
 *         &lt;element name="SendAnswerDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="Answerer"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AnswerText" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String10000Type"/&gt;
 *         &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnswerInfoType", propOrder = {
    "answerNumber",
    "sendAnswerDate",
    "answerer",
    "answerText",
    "attachment"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.appeals.ExportAppealResultType.AppealHistory.Answer.class
})
public class AnswerInfoType {

    @XmlElement(name = "AnswerNumber")
    protected String answerNumber;
    @XmlElement(name = "SendAnswerDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sendAnswerDate;
    @XmlElement(name = "Answerer", required = true)
    protected AnswerInfoType.Answerer answerer;
    @XmlElement(name = "AnswerText", required = true)
    protected String answerText;
    @XmlElement(name = "Attachment")
    protected List<AttachmentType> attachment;

    /**
     * Gets the value of the answerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerNumber() {
        return answerNumber;
    }

    /**
     * Sets the value of the answerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerNumber(String value) {
        this.answerNumber = value;
    }

    /**
     * Gets the value of the sendAnswerDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSendAnswerDate() {
        return sendAnswerDate;
    }

    /**
     * Sets the value of the sendAnswerDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSendAnswerDate(XMLGregorianCalendar value) {
        this.sendAnswerDate = value;
    }

    /**
     * Gets the value of the answerer property.
     * 
     * @return
     *     possible object is
     *     {@link AnswerInfoType.Answerer }
     *     
     */
    public AnswerInfoType.Answerer getAnswerer() {
        return answerer;
    }

    /**
     * Sets the value of the answerer property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnswerInfoType.Answerer }
     *     
     */
    public void setAnswerer(AnswerInfoType.Answerer value) {
        this.answerer = value;
    }

    /**
     * Gets the value of the answerText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerText() {
        return answerText;
    }

    /**
     * Sets the value of the answerText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerText(String value) {
        this.answerText = value;
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
     *         &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "answererGUID"
    })
    public static class Answerer {

        @XmlElement(name = "AnswererGUID", required = true)
        protected String answererGUID;

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

    }

}
