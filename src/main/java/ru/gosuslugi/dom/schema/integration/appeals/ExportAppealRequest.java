
package ru.gosuslugi.dom.schema.integration.appeals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType" maxOccurs="1000"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *             &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *             &lt;element name="AppealTheme" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *             &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *             &lt;element name="StatusOfAppeal" minOccurs="0"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="NotSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                       &lt;element name="Sent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                       &lt;element name="InWork" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                       &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                       &lt;element name="Withdrawn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AnswerGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="StartCreateDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *             &lt;element name="EndCreateDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *             &lt;element name="StartPostDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *             &lt;element name="EndPostDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.2.0.11""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "appealGUID",
    "appealNumber",
    "startDate",
    "endDate",
    "appealTheme",
    "fiasHouseGuid",
    "statusOfAppeal",
    "answerGUID",
    "startCreateDate",
    "endCreateDate",
    "startPostDate",
    "endPostDate"
})
@XmlRootElement(name = "exportAppealRequest")
public class ExportAppealRequest
    extends BaseType
{

    @XmlElement(name = "AppealGUID")
    protected List<String> appealGUID;
    @XmlElement(name = "AppealNumber")
    protected List<String> appealNumber;
    @XmlElement(name = "StartDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "AppealTheme")
    protected NsiRef appealTheme;
    @XmlElement(name = "FIASHouseGuid")
    protected List<String> fiasHouseGuid;
    @XmlElement(name = "StatusOfAppeal")
    protected ExportAppealRequest.StatusOfAppeal statusOfAppeal;
    @XmlElement(name = "AnswerGUID")
    protected List<String> answerGUID;
    @XmlElement(name = "StartCreateDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startCreateDate;
    @XmlElement(name = "EndCreateDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endCreateDate;
    @XmlElement(name = "StartPostDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startPostDate;
    @XmlElement(name = "EndPostDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endPostDate;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the appealGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appealGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppealGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAppealGUID() {
        if (appealGUID == null) {
            appealGUID = new ArrayList<String>();
        }
        return this.appealGUID;
    }

    /**
     * Gets the value of the appealNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appealNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppealNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAppealNumber() {
        if (appealNumber == null) {
            appealNumber = new ArrayList<String>();
        }
        return this.appealNumber;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the appealTheme property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getAppealTheme() {
        return appealTheme;
    }

    /**
     * Sets the value of the appealTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setAppealTheme(NsiRef value) {
        this.appealTheme = value;
    }

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fiasHouseGuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFIASHouseGuid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFIASHouseGuid() {
        if (fiasHouseGuid == null) {
            fiasHouseGuid = new ArrayList<String>();
        }
        return this.fiasHouseGuid;
    }

    /**
     * Gets the value of the statusOfAppeal property.
     * 
     * @return
     *     possible object is
     *     {@link ExportAppealRequest.StatusOfAppeal }
     *     
     */
    public ExportAppealRequest.StatusOfAppeal getStatusOfAppeal() {
        return statusOfAppeal;
    }

    /**
     * Sets the value of the statusOfAppeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportAppealRequest.StatusOfAppeal }
     *     
     */
    public void setStatusOfAppeal(ExportAppealRequest.StatusOfAppeal value) {
        this.statusOfAppeal = value;
    }

    /**
     * Gets the value of the answerGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answerGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswerGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAnswerGUID() {
        if (answerGUID == null) {
            answerGUID = new ArrayList<String>();
        }
        return this.answerGUID;
    }

    /**
     * Gets the value of the startCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartCreateDate() {
        return startCreateDate;
    }

    /**
     * Sets the value of the startCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartCreateDate(XMLGregorianCalendar value) {
        this.startCreateDate = value;
    }

    /**
     * Gets the value of the endCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndCreateDate() {
        return endCreateDate;
    }

    /**
     * Sets the value of the endCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndCreateDate(XMLGregorianCalendar value) {
        this.endCreateDate = value;
    }

    /**
     * Gets the value of the startPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartPostDate() {
        return startPostDate;
    }

    /**
     * Sets the value of the startPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartPostDate(XMLGregorianCalendar value) {
        this.startPostDate = value;
    }

    /**
     * Gets the value of the endPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndPostDate() {
        return endPostDate;
    }

    /**
     * Sets the value of the endPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndPostDate(XMLGregorianCalendar value) {
        this.endPostDate = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "12.2.0.11";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
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
     *         &lt;element name="NotSent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="Sent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="InWork" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="Withdrawn" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "notSent",
        "sent",
        "inWork",
        "executed",
        "withdrawn"
    })
    public static class StatusOfAppeal {

        @XmlElement(name = "NotSent")
        protected Boolean notSent;
        @XmlElement(name = "Sent")
        protected Boolean sent;
        @XmlElement(name = "InWork")
        protected Boolean inWork;
        @XmlElement(name = "Executed")
        protected Boolean executed;
        @XmlElement(name = "Withdrawn")
        protected Boolean withdrawn;

        /**
         * Gets the value of the notSent property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotSent() {
            return notSent;
        }

        /**
         * Sets the value of the notSent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotSent(Boolean value) {
            this.notSent = value;
        }

        /**
         * Gets the value of the sent property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSent() {
            return sent;
        }

        /**
         * Sets the value of the sent property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSent(Boolean value) {
            this.sent = value;
        }

        /**
         * Gets the value of the inWork property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isInWork() {
            return inWork;
        }

        /**
         * Sets the value of the inWork property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setInWork(Boolean value) {
            this.inWork = value;
        }

        /**
         * Gets the value of the executed property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isExecuted() {
            return executed;
        }

        /**
         * Sets the value of the executed property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setExecuted(Boolean value) {
            this.executed = value;
        }

        /**
         * Gets the value of the withdrawn property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isWithdrawn() {
            return withdrawn;
        }

        /**
         * Sets the value of the withdrawn property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setWithdrawn(Boolean value) {
            this.withdrawn = value;
        }

    }

}
