
package ru.gosuslugi.dom.schema.integration.rap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Экспорт данных постановления
 * 
 * <p>Java class for ExportDecreeInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportDecreeInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Offender"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
 *                     &lt;element name="OfficialName" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ControlRoleCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;element name="Person" type="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ReviewResult"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ResultKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="DecreeDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType" minOccurs="0"/&gt;
 *                   &lt;element name="PunishmentKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000" minOccurs="0"/&gt;
 *                   &lt;element name="TakingDecisionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                   &lt;element name="TakingDecisionAuthorityName" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="0"/&gt;
 *                         &lt;maxLength value="2500"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PositionOfAcceptedPerson" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type" minOccurs="0"/&gt;
 *                   &lt;element name="Fine" type="{http://dom.gosuslugi.ru/schema/integration/rap/}FineType" minOccurs="0"/&gt;
 *                   &lt;element name="FinePaymentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                   &lt;element name="DisqualificationPeriod" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="Months"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                                   &lt;minExclusive value="0"/&gt;
 *                                   &lt;maxExclusive value="1000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Years"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                                   &lt;minExclusive value="0"/&gt;
 *                                   &lt;maxExclusive value="1000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ViolationObject" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000" minOccurs="0"/&gt;
 *                   &lt;element name="ProceedingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                   &lt;element name="ViolationShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                   &lt;element name="TakenAction" type="{http://dom.gosuslugi.ru/schema/integration/base/}String1500Type" minOccurs="0"/&gt;
 *                   &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "ExportDecreeInfoType", propOrder = {
    "offender",
    "reviewResult"
})
public class ExportDecreeInfoType {

    @XmlElement(name = "Offender", required = true)
    protected ExportDecreeInfoType.Offender offender;
    @XmlElement(name = "ReviewResult", required = true)
    protected ExportDecreeInfoType.ReviewResult reviewResult;

    /**
     * Gets the value of the offender property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDecreeInfoType.Offender }
     *     
     */
    public ExportDecreeInfoType.Offender getOffender() {
        return offender;
    }

    /**
     * Sets the value of the offender property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDecreeInfoType.Offender }
     *     
     */
    public void setOffender(ExportDecreeInfoType.Offender value) {
        this.offender = value;
    }

    /**
     * Gets the value of the reviewResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDecreeInfoType.ReviewResult }
     *     
     */
    public ExportDecreeInfoType.ReviewResult getReviewResult() {
        return reviewResult;
    }

    /**
     * Sets the value of the reviewResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDecreeInfoType.ReviewResult }
     *     
     */
    public void setReviewResult(ExportDecreeInfoType.ReviewResult value) {
        this.reviewResult = value;
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
     *         &lt;sequence&gt;
     *           &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
     *           &lt;element name="OfficialName" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="ControlRoleCode" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;element name="Person" type="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"/&gt;
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
        "organization",
        "officialName",
        "controlRoleCode",
        "person"
    })
    public static class Offender {

        @XmlElement(name = "Organization")
        protected RegOrgType organization;
        @XmlElement(name = "OfficialName")
        protected ExportDecreeInfoType.Offender.OfficialName officialName;
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
         *     {@link ExportDecreeInfoType.Offender.OfficialName }
         *     
         */
        public ExportDecreeInfoType.Offender.OfficialName getOfficialName() {
            return officialName;
        }

        /**
         * Sets the value of the officialName property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportDecreeInfoType.Offender.OfficialName }
         *     
         */
        public void setOfficialName(ExportDecreeInfoType.Offender.OfficialName value) {
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeIndType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Position" type="{http://dom.gosuslugi.ru/schema/integration/base/}String300Type"/&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ResultKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="DecreeDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ExportProceduralDocumentType" minOccurs="0"/&gt;
     *         &lt;element name="PunishmentKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000" minOccurs="0"/&gt;
     *         &lt;element name="TakingDecisionAuthority" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *         &lt;element name="TakingDecisionAuthorityName" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="0"/&gt;
     *               &lt;maxLength value="2500"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PositionOfAcceptedPerson" type="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type" minOccurs="0"/&gt;
     *         &lt;element name="Fine" type="{http://dom.gosuslugi.ru/schema/integration/rap/}FineType" minOccurs="0"/&gt;
     *         &lt;element name="FinePaymentDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="DisqualificationPeriod" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="Months"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *                         &lt;minExclusive value="0"/&gt;
     *                         &lt;maxExclusive value="1000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Years"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *                         &lt;minExclusive value="0"/&gt;
     *                         &lt;maxExclusive value="1000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ViolationObject" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000" minOccurs="0"/&gt;
     *         &lt;element name="ProceedingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="ViolationShortDescription" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
     *         &lt;element name="TakenAction" type="{http://dom.gosuslugi.ru/schema/integration/base/}String1500Type" minOccurs="0"/&gt;
     *         &lt;element name="Executed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "resultKind",
        "decreeDocument",
        "punishmentKind",
        "takingDecisionAuthority",
        "takingDecisionAuthorityName",
        "positionOfAcceptedPerson",
        "fine",
        "finePaymentDate",
        "disqualificationPeriod",
        "violationObject",
        "proceedingDate",
        "violationShortDescription",
        "takenAction",
        "executed"
    })
    public static class ReviewResult {

        @XmlElement(name = "ResultKind", required = true)
        protected NsiRef resultKind;
        @XmlElement(name = "DecreeDocument")
        protected ExportProceduralDocumentType decreeDocument;
        @XmlElement(name = "PunishmentKind")
        protected List<NsiRef> punishmentKind;
        @XmlElement(name = "TakingDecisionAuthority")
        protected NsiRef takingDecisionAuthority;
        @XmlElement(name = "TakingDecisionAuthorityName")
        protected String takingDecisionAuthorityName;
        @XmlElement(name = "PositionOfAcceptedPerson")
        protected String positionOfAcceptedPerson;
        @XmlElement(name = "Fine")
        protected BigDecimal fine;
        @XmlElement(name = "FinePaymentDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar finePaymentDate;
        @XmlElement(name = "DisqualificationPeriod")
        protected ExportDecreeInfoType.ReviewResult.DisqualificationPeriod disqualificationPeriod;
        @XmlElement(name = "ViolationObject")
        protected List<NsiRef> violationObject;
        @XmlElement(name = "ProceedingDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar proceedingDate;
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
         *     {@link ExportProceduralDocumentType }
         *     
         */
        public ExportProceduralDocumentType getDecreeDocument() {
            return decreeDocument;
        }

        /**
         * Sets the value of the decreeDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportProceduralDocumentType }
         *     
         */
        public void setDecreeDocument(ExportProceduralDocumentType value) {
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
         *     {@link ExportDecreeInfoType.ReviewResult.DisqualificationPeriod }
         *     
         */
        public ExportDecreeInfoType.ReviewResult.DisqualificationPeriod getDisqualificationPeriod() {
            return disqualificationPeriod;
        }

        /**
         * Sets the value of the disqualificationPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportDecreeInfoType.ReviewResult.DisqualificationPeriod }
         *     
         */
        public void setDisqualificationPeriod(ExportDecreeInfoType.ReviewResult.DisqualificationPeriod value) {
            this.disqualificationPeriod = value;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;choice&gt;
         *         &lt;element name="Months"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
         *               &lt;minExclusive value="0"/&gt;
         *               &lt;maxExclusive value="1000"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Years"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
         *               &lt;minExclusive value="0"/&gt;
         *               &lt;maxExclusive value="1000"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
