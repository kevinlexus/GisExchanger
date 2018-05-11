
package ru.gosuslugi.dom.schema.integration.rap;

import java.math.BigDecimal;
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
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Данные постановления
 * 
 * <p>Java class for DecreeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecreeInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Offender">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;sequence>
 *                     &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *                     &lt;element name="OfficialName" minOccurs="0">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType">
 *                             &lt;sequence>
 *                               &lt;element name="Position">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type">
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="ControlRoleCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;element name="Person" type="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ReviewResult">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ResultKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="DecreeDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/>
 *                   &lt;element name="PunishmentKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100" minOccurs="0"/>
 *                   &lt;element name="TakingDecisionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="TakingDecisionAuthorityName" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="2500"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PositionOfAcceptedPerson">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type">
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ViolationObject" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100"/>
 *                   &lt;element name="ProceedingDate" type="{http://dom.gosuslugi.ru/schema/integration/rap/}LimitedDateType"/>
 *                   &lt;element name="Fine" type="{http://dom.gosuslugi.ru/schema/integration/rap/}FineType" minOccurs="0"/>
 *                   &lt;element name="FinePaymentDate" type="{http://dom.gosuslugi.ru/schema/integration/rap/}LimitedDateType" minOccurs="0"/>
 *                   &lt;element name="DisqualificationPeriod" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="Months">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minExclusive value="0"/>
 *                                   &lt;maxExclusive value="1000"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Years">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minExclusive value="0"/>
 *                                   &lt;maxExclusive value="1000"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ViolationShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/>
 *                   &lt;element name="TakenAction" type="{http://dom.gosuslugi.ru/schema/integration/base/}String1500Type" minOccurs="0"/>
 *                   &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "DecreeInfoType", propOrder = {
    "offender",
    "reviewResult"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.rap.ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo.class
})
public class DecreeInfoType {

    @XmlElement(name = "Offender", required = true)
    protected DecreeInfoType.Offender offender;
    @XmlElement(name = "ReviewResult", required = true)
    protected DecreeInfoType.ReviewResult reviewResult;

    /**
     * Gets the value of the offender property.
     * 
     * @return
     *     possible object is
     *     {@link DecreeInfoType.Offender }
     *     
     */
    public DecreeInfoType.Offender getOffender() {
        return offender;
    }

    /**
     * Sets the value of the offender property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecreeInfoType.Offender }
     *     
     */
    public void setOffender(DecreeInfoType.Offender value) {
        this.offender = value;
    }

    /**
     * Gets the value of the reviewResult property.
     * 
     * @return
     *     possible object is
     *     {@link DecreeInfoType.ReviewResult }
     *     
     */
    public DecreeInfoType.ReviewResult getReviewResult() {
        return reviewResult;
    }

    /**
     * Sets the value of the reviewResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecreeInfoType.ReviewResult }
     *     
     */
    public void setReviewResult(DecreeInfoType.ReviewResult value) {
        this.reviewResult = value;
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
     *         &lt;sequence>
     *           &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
     *           &lt;element name="OfficialName" minOccurs="0">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType">
     *                   &lt;sequence>
     *                     &lt;element name="Position">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type">
     *                           &lt;minLength value="1"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="ControlRoleCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;element name="Person" type="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"/>
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
        "organization",
        "officialName",
        "controlRoleCode",
        "person"
    })
    public static class Offender {

        @XmlElement(name = "Organization")
        protected RegOrgType organization;
        @XmlElement(name = "OfficialName")
        protected DecreeInfoType.Offender.OfficialName officialName;
        @XmlElement(name = "ControlRoleCode")
        protected List<NsiRef> controlRoleCode;
        @XmlElement(name = "Person")
        protected DecreeIndType person;

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
         * Gets the value of the officialName property.
         * 
         * @return
         *     possible object is
         *     {@link DecreeInfoType.Offender.OfficialName }
         *     
         */
        public DecreeInfoType.Offender.OfficialName getOfficialName() {
            return officialName;
        }

        /**
         * Sets the value of the officialName property.
         * 
         * @param value
         *     allowed object is
         *     {@link DecreeInfoType.Offender.OfficialName }
         *     
         */
        public void setOfficialName(DecreeInfoType.Offender.OfficialName value) {
            this.officialName = value;
        }

        /**
         * Gets the value of the controlRoleCode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the controlRoleCode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getControlRoleCode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getControlRoleCode() {
            if (controlRoleCode == null) {
                controlRoleCode = new ArrayList<NsiRef>();
            }
            return this.controlRoleCode;
        }

        /**
         * Gets the value of the person property.
         * 
         * @return
         *     possible object is
         *     {@link DecreeIndType }
         *     
         */
        public DecreeIndType getPerson() {
            return person;
        }

        /**
         * Sets the value of the person property.
         * 
         * @param value
         *     allowed object is
         *     {@link DecreeIndType }
         *     
         */
        public void setPerson(DecreeIndType value) {
            this.person = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType">
         *       &lt;sequence>
         *         &lt;element name="Position">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type">
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "position"
        })
        public static class OfficialName
            extends DecreeIndType
        {

            @XmlElement(name = "Position", required = true)
            protected String position;

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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ResultKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="DecreeDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/>
     *         &lt;element name="PunishmentKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100" minOccurs="0"/>
     *         &lt;element name="TakingDecisionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="TakingDecisionAuthorityName" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="2500"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PositionOfAcceptedPerson">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type">
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ViolationObject" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100"/>
     *         &lt;element name="ProceedingDate" type="{http://dom.gosuslugi.ru/schema/integration/rap/}LimitedDateType"/>
     *         &lt;element name="Fine" type="{http://dom.gosuslugi.ru/schema/integration/rap/}FineType" minOccurs="0"/>
     *         &lt;element name="FinePaymentDate" type="{http://dom.gosuslugi.ru/schema/integration/rap/}LimitedDateType" minOccurs="0"/>
     *         &lt;element name="DisqualificationPeriod" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="Months">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minExclusive value="0"/>
     *                         &lt;maxExclusive value="1000"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Years">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minExclusive value="0"/>
     *                         &lt;maxExclusive value="1000"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ViolationShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/>
     *         &lt;element name="TakenAction" type="{http://dom.gosuslugi.ru/schema/integration/base/}String1500Type" minOccurs="0"/>
     *         &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
        "resultKind",
        "decreeDocument",
        "punishmentKind",
        "takingDecisionAuthority",
        "takingDecisionAuthorityName",
        "positionOfAcceptedPerson",
        "violationObject",
        "proceedingDate",
        "fine",
        "finePaymentDate",
        "disqualificationPeriod",
        "violationShortDescription",
        "takenAction",
        "executed"
    })
    public static class ReviewResult {

        @XmlElement(name = "ResultKind", required = true)
        protected NsiRef resultKind;
        @XmlElement(name = "DecreeDocument", required = true)
        protected ProceduralDocumentType decreeDocument;
        @XmlElement(name = "PunishmentKind")
        protected List<NsiRef> punishmentKind;
        @XmlElement(name = "TakingDecisionAuthority", required = true)
        protected NsiRef takingDecisionAuthority;
        @XmlElement(name = "TakingDecisionAuthorityName")
        protected String takingDecisionAuthorityName;
        @XmlElement(name = "PositionOfAcceptedPerson", required = true)
        protected String positionOfAcceptedPerson;
        @XmlElement(name = "ViolationObject", required = true)
        protected List<NsiRef> violationObject;
        @XmlElement(name = "ProceedingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar proceedingDate;
        @XmlElement(name = "Fine")
        protected BigDecimal fine;
        @XmlElement(name = "FinePaymentDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar finePaymentDate;
        @XmlElement(name = "DisqualificationPeriod")
        protected DecreeInfoType.ReviewResult.DisqualificationPeriod disqualificationPeriod;
        @XmlElement(name = "ViolationShortDescription")
        protected String violationShortDescription;
        @XmlElement(name = "TakenAction")
        protected String takenAction;
        @XmlElement(name = "Executed")
        protected Boolean executed;

        /**
         * Gets the value of the resultKind property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getResultKind() {
            return resultKind;
        }

        /**
         * Sets the value of the resultKind property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setResultKind(NsiRef value) {
            this.resultKind = value;
        }

        /**
         * Gets the value of the decreeDocument property.
         * 
         * @return
         *     possible object is
         *     {@link ProceduralDocumentType }
         *     
         */
        public ProceduralDocumentType getDecreeDocument() {
            return decreeDocument;
        }

        /**
         * Sets the value of the decreeDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProceduralDocumentType }
         *     
         */
        public void setDecreeDocument(ProceduralDocumentType value) {
            this.decreeDocument = value;
        }

        /**
         * Gets the value of the punishmentKind property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the punishmentKind property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPunishmentKind().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getPunishmentKind() {
            if (punishmentKind == null) {
                punishmentKind = new ArrayList<NsiRef>();
            }
            return this.punishmentKind;
        }

        /**
         * Gets the value of the takingDecisionAuthority property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getTakingDecisionAuthority() {
            return takingDecisionAuthority;
        }

        /**
         * Sets the value of the takingDecisionAuthority property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setTakingDecisionAuthority(NsiRef value) {
            this.takingDecisionAuthority = value;
        }

        /**
         * Gets the value of the takingDecisionAuthorityName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTakingDecisionAuthorityName() {
            return takingDecisionAuthorityName;
        }

        /**
         * Sets the value of the takingDecisionAuthorityName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTakingDecisionAuthorityName(String value) {
            this.takingDecisionAuthorityName = value;
        }

        /**
         * Gets the value of the positionOfAcceptedPerson property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPositionOfAcceptedPerson() {
            return positionOfAcceptedPerson;
        }

        /**
         * Sets the value of the positionOfAcceptedPerson property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPositionOfAcceptedPerson(String value) {
            this.positionOfAcceptedPerson = value;
        }

        /**
         * Gets the value of the violationObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the violationObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getViolationObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getViolationObject() {
            if (violationObject == null) {
                violationObject = new ArrayList<NsiRef>();
            }
            return this.violationObject;
        }

        /**
         * Gets the value of the proceedingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getProceedingDate() {
            return proceedingDate;
        }

        /**
         * Sets the value of the proceedingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setProceedingDate(XMLGregorianCalendar value) {
            this.proceedingDate = value;
        }

        /**
         * Gets the value of the fine property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFine() {
            return fine;
        }

        /**
         * Sets the value of the fine property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFine(BigDecimal value) {
            this.fine = value;
        }

        /**
         * Gets the value of the finePaymentDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFinePaymentDate() {
            return finePaymentDate;
        }

        /**
         * Sets the value of the finePaymentDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFinePaymentDate(XMLGregorianCalendar value) {
            this.finePaymentDate = value;
        }

        /**
         * Gets the value of the disqualificationPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link DecreeInfoType.ReviewResult.DisqualificationPeriod }
         *     
         */
        public DecreeInfoType.ReviewResult.DisqualificationPeriod getDisqualificationPeriod() {
            return disqualificationPeriod;
        }

        /**
         * Sets the value of the disqualificationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link DecreeInfoType.ReviewResult.DisqualificationPeriod }
         *     
         */
        public void setDisqualificationPeriod(DecreeInfoType.ReviewResult.DisqualificationPeriod value) {
            this.disqualificationPeriod = value;
        }

        /**
         * Gets the value of the violationShortDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getViolationShortDescription() {
            return violationShortDescription;
        }

        /**
         * Sets the value of the violationShortDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setViolationShortDescription(String value) {
            this.violationShortDescription = value;
        }

        /**
         * Gets the value of the takenAction property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTakenAction() {
            return takenAction;
        }

        /**
         * Sets the value of the takenAction property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTakenAction(String value) {
            this.takenAction = value;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="Months">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minExclusive value="0"/>
         *               &lt;maxExclusive value="1000"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Years">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minExclusive value="0"/>
         *               &lt;maxExclusive value="1000"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
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
            "months",
            "years"
        })
        public static class DisqualificationPeriod {

            @XmlElement(name = "Months")
            protected Integer months;
            @XmlElement(name = "Years")
            protected Integer years;

            /**
             * Gets the value of the months property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getMonths() {
                return months;
            }

            /**
             * Sets the value of the months property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setMonths(Integer value) {
                this.months = value;
            }

            /**
             * Gets the value of the years property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getYears() {
                return years;
            }

            /**
             * Sets the value of the years property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setYears(Integer value) {
                this.years = value;
            }

        }

    }

}
