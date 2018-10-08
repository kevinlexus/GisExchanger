
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
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AnswerAction" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                     &lt;choice&gt;
 *                       &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType"/&gt;
 *                     &lt;/choice&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="Answer" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                             &lt;element name="AnswerGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                             &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="LoadAnswer" minOccurs="0"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="AnswerText" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String10000Type"/&gt;
 *                                           &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/restriction&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="SendAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="DeleteAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;/choice&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AppealAction" maxOccurs="1000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Performer" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                               &lt;element name="DateOfAppointment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="Executed" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="RedirectAppeal" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RedirectAppealType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="RollOverAppeal" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RollOverAppealType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="AnswerIsNotRequired" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                               &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.2.0.13""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "answerAction",
    "appealAction"
})
@XmlRootElement(name = "importAnswerRequest")
public class ImportAnswerRequest
    extends BaseType
{

    @XmlElement(name = "AnswerAction")
    protected List<ImportAnswerRequest.AnswerAction> answerAction;
    @XmlElement(name = "AppealAction")
    protected List<ImportAnswerRequest.AppealAction> appealAction;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the answerAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answerAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswerAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAnswerRequest.AnswerAction }
     * 
     * 
     */
    public List<ImportAnswerRequest.AnswerAction> getAnswerAction() {
        if (answerAction == null) {
            answerAction = new ArrayList<ImportAnswerRequest.AnswerAction>();
        }
        return this.answerAction;
    }

    /**
     * Gets the value of the appealAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appealAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppealAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportAnswerRequest.AppealAction }
     * 
     * 
     */
    public List<ImportAnswerRequest.AppealAction> getAppealAction() {
        if (appealAction == null) {
            appealAction = new ArrayList<ImportAnswerRequest.AppealAction>();
        }
        return this.appealAction;
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
            return "12.2.0.13";
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
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *           &lt;choice&gt;
     *             &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *             &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType"/&gt;
     *           &lt;/choice&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="Answer" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                   &lt;element name="AnswerGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                   &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element name="LoadAnswer" minOccurs="0"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element name="AnswerText" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String10000Type"/&gt;
     *                                 &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/restriction&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                       &lt;element name="SendAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;element name="DeleteAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
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
        "transportGUID",
        "appealGUID",
        "appealNumber",
        "answer"
    })
    public static class AnswerAction {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AppealGUID")
        protected String appealGUID;
        @XmlElement(name = "AppealNumber")
        protected String appealNumber;
        @XmlElement(name = "Answer", required = true)
        protected List<ImportAnswerRequest.AnswerAction.Answer> answer;

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
        }

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
         * Gets the value of the answer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the answer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnswer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportAnswerRequest.AnswerAction.Answer }
         * 
         * 
         */
        public List<ImportAnswerRequest.AnswerAction.Answer> getAnswer() {
            if (answer == null) {
                answer = new ArrayList<ImportAnswerRequest.AnswerAction.Answer>();
            }
            return this.answer;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="AnswerGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *         &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *         &lt;choice&gt;
         *           &lt;sequence&gt;
         *             &lt;element name="LoadAnswer" minOccurs="0"&gt;
         *               &lt;complexType&gt;
         *                 &lt;complexContent&gt;
         *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                     &lt;sequence&gt;
         *                       &lt;element name="AnswerText" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}String10000Type"/&gt;
         *                       &lt;element name="Attachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *                     &lt;/sequence&gt;
         *                   &lt;/restriction&gt;
         *                 &lt;/complexContent&gt;
         *               &lt;/complexType&gt;
         *             &lt;/element&gt;
         *             &lt;element name="SendAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="DeleteAnswer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
            "transportGUID",
            "answerGUID",
            "answererGUID",
            "loadAnswer",
            "sendAnswer",
            "deleteAnswer"
        })
        public static class Answer {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "AnswerGUID")
            protected String answerGUID;
            @XmlElement(name = "AnswererGUID", required = true)
            protected String answererGUID;
            @XmlElement(name = "LoadAnswer")
            protected ImportAnswerRequest.AnswerAction.Answer.LoadAnswer loadAnswer;
            @XmlElement(name = "SendAnswer")
            protected Boolean sendAnswer;
            @XmlElement(name = "DeleteAnswer")
            protected Boolean deleteAnswer;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the answerGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAnswerGUID() {
                return answerGUID;
            }

            /**
             * Sets the value of the answerGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAnswerGUID(String value) {
                this.answerGUID = value;
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
             * Gets the value of the loadAnswer property.
             * 
             * @return
             *     possible object is
             *     {@link ImportAnswerRequest.AnswerAction.Answer.LoadAnswer }
             *     
             */
            public ImportAnswerRequest.AnswerAction.Answer.LoadAnswer getLoadAnswer() {
                return loadAnswer;
            }

            /**
             * Sets the value of the loadAnswer property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportAnswerRequest.AnswerAction.Answer.LoadAnswer }
             *     
             */
            public void setLoadAnswer(ImportAnswerRequest.AnswerAction.Answer.LoadAnswer value) {
                this.loadAnswer = value;
            }

            /**
             * Gets the value of the sendAnswer property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isSendAnswer() {
                return sendAnswer;
            }

            /**
             * Sets the value of the sendAnswer property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setSendAnswer(Boolean value) {
                this.sendAnswer = value;
            }

            /**
             * Gets the value of the deleteAnswer property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDeleteAnswer() {
                return deleteAnswer;
            }

            /**
             * Sets the value of the deleteAnswer property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDeleteAnswer(Boolean value) {
                this.deleteAnswer = value;
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
            @XmlType(name = "", propOrder = {
                "answerText",
                "attachment"
            })
            public static class LoadAnswer {

                @XmlElement(name = "AnswerText", required = true)
                protected String answerText;
                @XmlElement(name = "Attachment")
                protected List<AttachmentType> attachment;

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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="AppealGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="AppealNumber" type="{http://dom.gosuslugi.ru/schema/integration/appeals/}AppealNumberType"/&gt;
     *         &lt;/choice&gt;
     *         &lt;sequence&gt;
     *           &lt;element name="Performer" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                     &lt;element name="DateOfAppointment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="Executed" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="RedirectAppeal" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RedirectAppealType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="RollOverAppeal" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RollOverAppealType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="AnswerIsNotRequired" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                     &lt;element name="AnswererGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/sequence&gt;
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
        "transportGUID",
        "appealGUID",
        "appealNumber",
        "performer",
        "executed",
        "redirectAppeal",
        "rollOverAppeal",
        "answerIsNotRequired"
    })
    public static class AppealAction {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "AppealGUID")
        protected String appealGUID;
        @XmlElement(name = "AppealNumber")
        protected String appealNumber;
        @XmlElement(name = "Performer")
        protected ImportAnswerRequest.AppealAction.Performer performer;
        @XmlElement(name = "Executed")
        protected ImportAnswerRequest.AppealAction.Executed executed;
        @XmlElement(name = "RedirectAppeal")
        protected List<ImportAnswerRequest.AppealAction.RedirectAppeal> redirectAppeal;
        @XmlElement(name = "RollOverAppeal")
        protected ImportAnswerRequest.AppealAction.RollOverAppeal rollOverAppeal;
        @XmlElement(name = "AnswerIsNotRequired")
        protected ImportAnswerRequest.AppealAction.AnswerIsNotRequired answerIsNotRequired;

        /**
         * Gets the value of the transportGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGUID() {
            return transportGUID;
        }

        /**
         * Sets the value of the transportGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGUID(String value) {
            this.transportGUID = value;
        }

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
         * Gets the value of the performer property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAnswerRequest.AppealAction.Performer }
         *     
         */
        public ImportAnswerRequest.AppealAction.Performer getPerformer() {
            return performer;
        }

        /**
         * Sets the value of the performer property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAnswerRequest.AppealAction.Performer }
         *     
         */
        public void setPerformer(ImportAnswerRequest.AppealAction.Performer value) {
            this.performer = value;
        }

        /**
         * Gets the value of the executed property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAnswerRequest.AppealAction.Executed }
         *     
         */
        public ImportAnswerRequest.AppealAction.Executed getExecuted() {
            return executed;
        }

        /**
         * Sets the value of the executed property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAnswerRequest.AppealAction.Executed }
         *     
         */
        public void setExecuted(ImportAnswerRequest.AppealAction.Executed value) {
            this.executed = value;
        }

        /**
         * Gets the value of the redirectAppeal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the redirectAppeal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRedirectAppeal().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportAnswerRequest.AppealAction.RedirectAppeal }
         * 
         * 
         */
        public List<ImportAnswerRequest.AppealAction.RedirectAppeal> getRedirectAppeal() {
            if (redirectAppeal == null) {
                redirectAppeal = new ArrayList<ImportAnswerRequest.AppealAction.RedirectAppeal>();
            }
            return this.redirectAppeal;
        }

        /**
         * Gets the value of the rollOverAppeal property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAnswerRequest.AppealAction.RollOverAppeal }
         *     
         */
        public ImportAnswerRequest.AppealAction.RollOverAppeal getRollOverAppeal() {
            return rollOverAppeal;
        }

        /**
         * Sets the value of the rollOverAppeal property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAnswerRequest.AppealAction.RollOverAppeal }
         *     
         */
        public void setRollOverAppeal(ImportAnswerRequest.AppealAction.RollOverAppeal value) {
            this.rollOverAppeal = value;
        }

        /**
         * Gets the value of the answerIsNotRequired property.
         * 
         * @return
         *     possible object is
         *     {@link ImportAnswerRequest.AppealAction.AnswerIsNotRequired }
         *     
         */
        public ImportAnswerRequest.AppealAction.AnswerIsNotRequired getAnswerIsNotRequired() {
            return answerIsNotRequired;
        }

        /**
         * Sets the value of the answerIsNotRequired property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportAnswerRequest.AppealAction.AnswerIsNotRequired }
         *     
         */
        public void setAnswerIsNotRequired(ImportAnswerRequest.AppealAction.AnswerIsNotRequired value) {
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
         *         &lt;element name="Cause" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "cause",
            "answererGUID"
        })
        public static class AnswerIsNotRequired {

            @XmlElement(name = "Cause", required = true)
            protected String cause;
            @XmlElement(name = "AnswererGUID", required = true)
            protected String answererGUID;

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
        public static class Executed {

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
         *         &lt;element name="DateOfAppointment" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
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
            "answererGUID",
            "dateOfAppointment"
        })
        public static class Performer {

            @XmlElement(name = "AnswererGUID", required = true)
            protected String answererGUID;
            @XmlElement(name = "DateOfAppointment")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateOfAppointment;

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
             * Gets the value of the dateOfAppointment property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateOfAppointment() {
                return dateOfAppointment;
            }

            /**
             * Sets the value of the dateOfAppointment property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateOfAppointment(XMLGregorianCalendar value) {
                this.dateOfAppointment = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/appeals/}RedirectAppealType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class RedirectAppeal
            extends RedirectAppealType
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
        public static class RollOverAppeal
            extends RollOverAppealType
        {


        }

    }

}
