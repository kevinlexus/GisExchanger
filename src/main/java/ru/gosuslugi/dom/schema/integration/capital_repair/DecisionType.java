
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
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Тип данных для решения о выборе способа формирования фонда капитального ремонта
 * 
 * <p>Java class for DecisionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionCommonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Protocol"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ProtocolType"&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="DecisionDocument" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentDecisionType"/&gt;
 *           &lt;element name="DocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="FormationFundInSpecialAccount"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="AccountCreationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="CreditOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *                     &lt;element name="BIKCredOrg" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
 *                     &lt;element name="AccountNumber" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountNumberType"/&gt;
 *                     &lt;element name="AccountOpeningDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="FormationFundInRegOperatorAccount" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionType", propOrder = {
    "protocol",
    "decisionDocument",
    "documentGUID",
    "formationFundInSpecialAccount",
    "formationFundInRegOperatorAccount"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportDecisionsFormingFundRequest.ImportDecision.LoadDecision.class,
    ExportDecisionType.class
})
public class DecisionType
    extends DecisionCommonType
{

    @XmlElement(name = "Protocol")
    protected DecisionType.Protocol protocol;
    @XmlElement(name = "DecisionDocument")
    protected DocumentDecisionType decisionDocument;
    @XmlElement(name = "DocumentGUID")
    protected String documentGUID;
    @XmlElement(name = "FormationFundInSpecialAccount")
    protected DecisionType.FormationFundInSpecialAccount formationFundInSpecialAccount;
    @XmlElement(name = "FormationFundInRegOperatorAccount")
    protected Boolean formationFundInRegOperatorAccount;

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType.Protocol }
     *     
     */
    public DecisionType.Protocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType.Protocol }
     *     
     */
    public void setProtocol(DecisionType.Protocol value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the decisionDocument property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentDecisionType }
     *     
     */
    public DocumentDecisionType getDecisionDocument() {
        return decisionDocument;
    }

    /**
     * Sets the value of the decisionDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentDecisionType }
     *     
     */
    public void setDecisionDocument(DocumentDecisionType value) {
        this.decisionDocument = value;
    }

    /**
     * Gets the value of the documentGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentGUID() {
        return documentGUID;
    }

    /**
     * Sets the value of the documentGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentGUID(String value) {
        this.documentGUID = value;
    }

    /**
     * Gets the value of the formationFundInSpecialAccount property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionType.FormationFundInSpecialAccount }
     *     
     */
    public DecisionType.FormationFundInSpecialAccount getFormationFundInSpecialAccount() {
        return formationFundInSpecialAccount;
    }

    /**
     * Sets the value of the formationFundInSpecialAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionType.FormationFundInSpecialAccount }
     *     
     */
    public void setFormationFundInSpecialAccount(DecisionType.FormationFundInSpecialAccount value) {
        this.formationFundInSpecialAccount = value;
    }

    /**
     * Gets the value of the formationFundInRegOperatorAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFormationFundInRegOperatorAccount() {
        return formationFundInRegOperatorAccount;
    }

    /**
     * Sets the value of the formationFundInRegOperatorAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFormationFundInRegOperatorAccount(Boolean value) {
        this.formationFundInRegOperatorAccount = value;
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
     *         &lt;element name="AccountCreationDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="CreditOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
     *         &lt;element name="BIKCredOrg" type="{http://dom.gosuslugi.ru/schema/integration/organizations-base/}BIKType"/&gt;
     *         &lt;element name="AccountNumber" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}AccountNumberType"/&gt;
     *         &lt;element name="AccountOpeningDocument" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/&gt;
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
        "accountCreationDate",
        "creditOrganization",
        "bikCredOrg",
        "accountNumber",
        "accountOpeningDocument"
    })
    public static class FormationFundInSpecialAccount {

        @XmlElement(name = "AccountCreationDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar accountCreationDate;
        @XmlElement(name = "CreditOrganization", required = true)
        protected RegOrgType creditOrganization;
        @XmlElement(name = "BIKCredOrg", required = true)
        protected String bikCredOrg;
        @XmlElement(name = "AccountNumber", required = true)
        protected String accountNumber;
        @XmlElement(name = "AccountOpeningDocument", required = true)
        protected List<AttachmentType> accountOpeningDocument;

        /**
         * Gets the value of the accountCreationDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAccountCreationDate() {
            return accountCreationDate;
        }

        /**
         * Sets the value of the accountCreationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAccountCreationDate(XMLGregorianCalendar value) {
            this.accountCreationDate = value;
        }

        /**
         * Gets the value of the creditOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link RegOrgType }
         *     
         */
        public RegOrgType getCreditOrganization() {
            return creditOrganization;
        }

        /**
         * Sets the value of the creditOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegOrgType }
         *     
         */
        public void setCreditOrganization(RegOrgType value) {
            this.creditOrganization = value;
        }

        /**
         * Gets the value of the bikCredOrg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBIKCredOrg() {
            return bikCredOrg;
        }

        /**
         * Sets the value of the bikCredOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBIKCredOrg(String value) {
            this.bikCredOrg = value;
        }

        /**
         * Gets the value of the accountNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountNumber() {
            return accountNumber;
        }

        /**
         * Sets the value of the accountNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountNumber(String value) {
            this.accountNumber = value;
        }

        /**
         * Gets the value of the accountOpeningDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the accountOpeningDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAccountOpeningDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getAccountOpeningDocument() {
            if (accountOpeningDocument == null) {
                accountOpeningDocument = new ArrayList<AttachmentType>();
            }
            return this.accountOpeningDocument;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ProtocolType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Protocol
        extends ProtocolType
    {


    }

}
