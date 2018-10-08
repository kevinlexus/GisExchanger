
package ru.gosuslugi.dom.schema.integration.house_management;

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
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * ДУ (для экспорта)
 * 
 * <p>Java class for ContractExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocNum"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="PlanDateComptetion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Validity" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Month" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;totalDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Year" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                         &lt;totalDigits value="4"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Owners" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Cooperative" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *           &lt;element name="MunicipalHousing" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *           &lt;element name="BuildingOwner" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Protocol" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence minOccurs="0"&gt;
 *                   &lt;element name="ProtocolAdd" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;sequence&gt;
 *                               &lt;sequence minOccurs="0"&gt;
 *                                 &lt;element name="PurchaseNumber" minOccurs="0"&gt;
 *                                   &lt;simpleType&gt;
 *                                     &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *                                       &lt;maxLength value="60"/&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/simpleType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="ProtocolOK" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;element name="ProtocolMeetingBoard" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;element name="ProtocolBuildingOwner" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContractBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="DateDetails" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DateDetailsExportType" minOccurs="0"/&gt;
 *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AgreementAttachment" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ImprintAgreement" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ImprintAgreementExportType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SignedOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CommissioningPermitAgreement" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Charter" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AutomaticRollOverOneYear" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="IndicationsAnyDay" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractExportType", propOrder = {
    "docNum",
    "signingDate",
    "effectiveDate",
    "planDateComptetion",
    "validity",
    "owners",
    "cooperative",
    "municipalHousing",
    "buildingOwner",
    "protocol",
    "contractBase",
    "dateDetails",
    "contractAttachment",
    "agreementAttachment",
    "signedOwners",
    "commissioningPermitAgreement",
    "charter",
    "automaticRollOverOneYear",
    "indicationsAnyDay"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportCAChResultType.Contract.class
})
public class ContractExportType {

    @XmlElement(name = "DocNum", required = true)
    protected String docNum;
    @XmlElement(name = "SigningDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar signingDate;
    @XmlElement(name = "EffectiveDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "PlanDateComptetion", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar planDateComptetion;
    @XmlElement(name = "Validity")
    protected ContractExportType.Validity validity;
    @XmlElement(name = "Owners")
    protected Boolean owners;
    @XmlElement(name = "Cooperative")
    protected RegOrgType cooperative;
    @XmlElement(name = "MunicipalHousing")
    protected RegOrgType municipalHousing;
    @XmlElement(name = "BuildingOwner")
    protected RegOrgType buildingOwner;
    @XmlElement(name = "Protocol")
    protected ContractExportType.Protocol protocol;
    @XmlElement(name = "ContractBase", required = true)
    protected NsiRef contractBase;
    @XmlElement(name = "DateDetails")
    protected DateDetailsExportType dateDetails;
    @XmlElement(name = "ContractAttachment")
    protected List<AttachmentType> contractAttachment;
    @XmlElement(name = "AgreementAttachment")
    protected List<ContractExportType.AgreementAttachment> agreementAttachment;
    @XmlElement(name = "SignedOwners")
    protected List<AttachmentType> signedOwners;
    @XmlElement(name = "CommissioningPermitAgreement")
    protected List<AttachmentType> commissioningPermitAgreement;
    @XmlElement(name = "Charter")
    protected List<AttachmentType> charter;
    @XmlElement(name = "AutomaticRollOverOneYear")
    protected Boolean automaticRollOverOneYear;
    @XmlElement(name = "IndicationsAnyDay")
    protected Boolean indicationsAnyDay;

    /**
     * Gets the value of the docNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNum() {
        return docNum;
    }

    /**
     * Sets the value of the docNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNum(String value) {
        this.docNum = value;
    }

    /**
     * Gets the value of the signingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSigningDate() {
        return signingDate;
    }

    /**
     * Sets the value of the signingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSigningDate(XMLGregorianCalendar value) {
        this.signingDate = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the planDateComptetion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlanDateComptetion() {
        return planDateComptetion;
    }

    /**
     * Sets the value of the planDateComptetion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlanDateComptetion(XMLGregorianCalendar value) {
        this.planDateComptetion = value;
    }

    /**
     * Gets the value of the validity property.
     * 
     * @return
     *     possible object is
     *     {@link ContractExportType.Validity }
     *     
     */
    public ContractExportType.Validity getValidity() {
        return validity;
    }

    /**
     * Sets the value of the validity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractExportType.Validity }
     *     
     */
    public void setValidity(ContractExportType.Validity value) {
        this.validity = value;
    }

    /**
     * Gets the value of the owners property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOwners() {
        return owners;
    }

    /**
     * Sets the value of the owners property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwners(Boolean value) {
        this.owners = value;
    }

    /**
     * Gets the value of the cooperative property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getCooperative() {
        return cooperative;
    }

    /**
     * Sets the value of the cooperative property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setCooperative(RegOrgType value) {
        this.cooperative = value;
    }

    /**
     * Gets the value of the municipalHousing property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getMunicipalHousing() {
        return municipalHousing;
    }

    /**
     * Sets the value of the municipalHousing property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setMunicipalHousing(RegOrgType value) {
        this.municipalHousing = value;
    }

    /**
     * Gets the value of the buildingOwner property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getBuildingOwner() {
        return buildingOwner;
    }

    /**
     * Sets the value of the buildingOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setBuildingOwner(RegOrgType value) {
        this.buildingOwner = value;
    }

    /**
     * Gets the value of the protocol property.
     * 
     * @return
     *     possible object is
     *     {@link ContractExportType.Protocol }
     *     
     */
    public ContractExportType.Protocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractExportType.Protocol }
     *     
     */
    public void setProtocol(ContractExportType.Protocol value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the contractBase property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getContractBase() {
        return contractBase;
    }

    /**
     * Sets the value of the contractBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setContractBase(NsiRef value) {
        this.contractBase = value;
    }

    /**
     * Gets the value of the dateDetails property.
     * 
     * @return
     *     possible object is
     *     {@link DateDetailsExportType }
     *     
     */
    public DateDetailsExportType getDateDetails() {
        return dateDetails;
    }

    /**
     * Sets the value of the dateDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateDetailsExportType }
     *     
     */
    public void setDateDetails(DateDetailsExportType value) {
        this.dateDetails = value;
    }

    /**
     * Gets the value of the contractAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getContractAttachment() {
        if (contractAttachment == null) {
            contractAttachment = new ArrayList<AttachmentType>();
        }
        return this.contractAttachment;
    }

    /**
     * Gets the value of the agreementAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agreementAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgreementAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractExportType.AgreementAttachment }
     * 
     * 
     */
    public List<ContractExportType.AgreementAttachment> getAgreementAttachment() {
        if (agreementAttachment == null) {
            agreementAttachment = new ArrayList<ContractExportType.AgreementAttachment>();
        }
        return this.agreementAttachment;
    }

    /**
     * Gets the value of the signedOwners property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signedOwners property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignedOwners().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getSignedOwners() {
        if (signedOwners == null) {
            signedOwners = new ArrayList<AttachmentType>();
        }
        return this.signedOwners;
    }

    /**
     * Gets the value of the commissioningPermitAgreement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commissioningPermitAgreement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommissioningPermitAgreement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getCommissioningPermitAgreement() {
        if (commissioningPermitAgreement == null) {
            commissioningPermitAgreement = new ArrayList<AttachmentType>();
        }
        return this.commissioningPermitAgreement;
    }

    /**
     * Gets the value of the charter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getCharter() {
        if (charter == null) {
            charter = new ArrayList<AttachmentType>();
        }
        return this.charter;
    }

    /**
     * Gets the value of the automaticRollOverOneYear property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutomaticRollOverOneYear() {
        return automaticRollOverOneYear;
    }

    /**
     * Sets the value of the automaticRollOverOneYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutomaticRollOverOneYear(Boolean value) {
        this.automaticRollOverOneYear = value;
    }

    /**
     * Gets the value of the indicationsAnyDay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndicationsAnyDay() {
        return indicationsAnyDay;
    }

    /**
     * Sets the value of the indicationsAnyDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndicationsAnyDay(Boolean value) {
        this.indicationsAnyDay = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ImprintAgreement" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ImprintAgreementExportType"/&gt;
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
        "imprintAgreement"
    })
    public static class AgreementAttachment
        extends AttachmentType
    {

        @XmlElement(name = "ImprintAgreement", required = true)
        protected ImprintAgreementExportType imprintAgreement;

        /**
         * Gets the value of the imprintAgreement property.
         * 
         * @return
         *     possible object is
         *     {@link ImprintAgreementExportType }
         *     
         */
        public ImprintAgreementExportType getImprintAgreement() {
            return imprintAgreement;
        }

        /**
         * Sets the value of the imprintAgreement property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImprintAgreementExportType }
         *     
         */
        public void setImprintAgreement(ImprintAgreementExportType value) {
            this.imprintAgreement = value;
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
     *       &lt;sequence minOccurs="0"&gt;
     *         &lt;element name="ProtocolAdd" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;sequence&gt;
     *                     &lt;sequence minOccurs="0"&gt;
     *                       &lt;element name="PurchaseNumber" minOccurs="0"&gt;
     *                         &lt;simpleType&gt;
     *                           &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
     *                             &lt;maxLength value="60"/&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/simpleType&gt;
     *                       &lt;/element&gt;
     *                       &lt;element name="ProtocolOK" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;element name="ProtocolMeetingBoard" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element name="ProtocolBuildingOwner" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "protocolAdd",
        "votingProtocolGUID"
    })
    public static class Protocol {

        @XmlElement(name = "ProtocolAdd")
        protected ContractExportType.Protocol.ProtocolAdd protocolAdd;
        @XmlElement(name = "VotingProtocolGUID")
        protected List<String> votingProtocolGUID;

        /**
         * Gets the value of the protocolAdd property.
         * 
         * @return
         *     possible object is
         *     {@link ContractExportType.Protocol.ProtocolAdd }
         *     
         */
        public ContractExportType.Protocol.ProtocolAdd getProtocolAdd() {
            return protocolAdd;
        }

        /**
         * Sets the value of the protocolAdd property.
         * 
         * @param value
         *     allowed object is
         *     {@link ContractExportType.Protocol.ProtocolAdd }
         *     
         */
        public void setProtocolAdd(ContractExportType.Protocol.ProtocolAdd value) {
            this.protocolAdd = value;
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
         *           &lt;sequence minOccurs="0"&gt;
         *             &lt;element name="PurchaseNumber" minOccurs="0"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
         *                   &lt;maxLength value="60"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *             &lt;element name="ProtocolOK" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="ProtocolMeetingOwners" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;/sequence&gt;
         *         &lt;element name="ProtocolMeetingBoard" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element name="ProtocolBuildingOwner" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "purchaseNumber",
            "protocolOK",
            "protocolMeetingOwners",
            "protocolMeetingBoard",
            "protocolBuildingOwner"
        })
        public static class ProtocolAdd {

            @XmlElement(name = "PurchaseNumber")
            protected String purchaseNumber;
            @XmlElement(name = "ProtocolOK")
            protected List<AttachmentType> protocolOK;
            @XmlElement(name = "ProtocolMeetingOwners")
            protected List<AttachmentType> protocolMeetingOwners;
            @XmlElement(name = "ProtocolMeetingBoard")
            protected List<AttachmentType> protocolMeetingBoard;
            @XmlElement(name = "ProtocolBuildingOwner")
            protected List<AttachmentType> protocolBuildingOwner;

            /**
             * Gets the value of the purchaseNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPurchaseNumber() {
                return purchaseNumber;
            }

            /**
             * Sets the value of the purchaseNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPurchaseNumber(String value) {
                this.purchaseNumber = value;
            }

            /**
             * Gets the value of the protocolOK property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the protocolOK property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProtocolOK().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getProtocolOK() {
                if (protocolOK == null) {
                    protocolOK = new ArrayList<AttachmentType>();
                }
                return this.protocolOK;
            }

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
             * Gets the value of the protocolMeetingBoard property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the protocolMeetingBoard property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProtocolMeetingBoard().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getProtocolMeetingBoard() {
                if (protocolMeetingBoard == null) {
                    protocolMeetingBoard = new ArrayList<AttachmentType>();
                }
                return this.protocolMeetingBoard;
            }

            /**
             * Gets the value of the protocolBuildingOwner property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the protocolBuildingOwner property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getProtocolBuildingOwner().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AttachmentType }
             * 
             * 
             */
            public List<AttachmentType> getProtocolBuildingOwner() {
                if (protocolBuildingOwner == null) {
                    protocolBuildingOwner = new ArrayList<AttachmentType>();
                }
                return this.protocolBuildingOwner;
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
     *         &lt;element name="Month" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;totalDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Year" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *               &lt;totalDigits value="4"/&gt;
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
        "month",
        "year"
    })
    public static class Validity {

        @XmlElement(name = "Month")
        protected BigInteger month;
        @XmlElement(name = "Year")
        protected BigInteger year;

        /**
         * Gets the value of the month property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMonth() {
            return month;
        }

        /**
         * Sets the value of the month property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMonth(BigInteger value) {
            this.month = value;
        }

        /**
         * Gets the value of the year property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getYear() {
            return year;
        }

        /**
         * Sets the value of the year property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setYear(BigInteger value) {
            this.year = value;
        }

    }

}
