
package ru.gosuslugi.dom.schema.integration.licenses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.LegalType;


/**
 * Лицензия
 * 
 * <p>Java class for LicenseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LicenseNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="\d{9}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LicenseRegDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="LicenseStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="A"/&gt;
 *               &lt;pattern value="F"/&gt;
 *               &lt;pattern value="C"/&gt;
 *               &lt;pattern value="R"/&gt;
 *               &lt;enumeration value="A"/&gt;
 *               &lt;enumeration value="F"/&gt;
 *               &lt;enumeration value="C"/&gt;
 *               &lt;enumeration value="R"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="LicensingAuthority"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RegionFIASGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="LicensableTypeOfActivity" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"/&gt;
 *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType" minOccurs="0"/&gt;
 *         &lt;element name="LicenseOrganization" type="{http://dom.gosuslugi.ru/schema/integration/licenses/}LicenseOrganizationType"/&gt;
 *         &lt;element name="AccompanyingDocument" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/licenses/}AccompanyingDocumentType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="DocumentStatus"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="A"/&gt;
 *                         &lt;enumeration value="C"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="House" type="{http://dom.gosuslugi.ru/schema/integration/licenses/}HouseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseType", propOrder = {
    "licenseNumber",
    "licenseRegDate",
    "licenseStatus",
    "licensingAuthority",
    "regionFIASGuid",
    "licensableTypeOfActivity",
    "additionalInformation",
    "licenseOrganization",
    "accompanyingDocument",
    "house"
})
@XmlSeeAlso({
    ExportLicenseResultType.class
})
public class LicenseType {

    @XmlElement(name = "LicenseNumber", required = true)
    protected String licenseNumber;
    @XmlElement(name = "LicenseRegDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar licenseRegDate;
    @XmlElement(name = "LicenseStatus", required = true)
    protected String licenseStatus;
    @XmlElement(name = "LicensingAuthority", required = true)
    protected LicenseType.LicensingAuthority licensingAuthority;
    @XmlElement(name = "RegionFIASGuid")
    protected String regionFIASGuid;
    @XmlElement(name = "LicensableTypeOfActivity", required = true)
    protected String licensableTypeOfActivity;
    @XmlElement(name = "AdditionalInformation")
    protected String additionalInformation;
    @XmlElement(name = "LicenseOrganization", required = true)
    protected LicenseOrganizationType licenseOrganization;
    @XmlElement(name = "AccompanyingDocument", required = true)
    protected List<LicenseType.AccompanyingDocument> accompanyingDocument;
    @XmlElement(name = "House")
    protected List<HouseType> house;

    /**
     * Gets the value of the licenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the value of the licenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseNumber(String value) {
        this.licenseNumber = value;
    }

    /**
     * Gets the value of the licenseRegDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLicenseRegDate() {
        return licenseRegDate;
    }

    /**
     * Sets the value of the licenseRegDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLicenseRegDate(XMLGregorianCalendar value) {
        this.licenseRegDate = value;
    }

    /**
     * Gets the value of the licenseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the value of the licenseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseStatus(String value) {
        this.licenseStatus = value;
    }

    /**
     * Gets the value of the licensingAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseType.LicensingAuthority }
     *     
     */
    public LicenseType.LicensingAuthority getLicensingAuthority() {
        return licensingAuthority;
    }

    /**
     * Sets the value of the licensingAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseType.LicensingAuthority }
     *     
     */
    public void setLicensingAuthority(LicenseType.LicensingAuthority value) {
        this.licensingAuthority = value;
    }

    /**
     * Gets the value of the regionFIASGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionFIASGuid() {
        return regionFIASGuid;
    }

    /**
     * Sets the value of the regionFIASGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionFIASGuid(String value) {
        this.regionFIASGuid = value;
    }

    /**
     * Gets the value of the licensableTypeOfActivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicensableTypeOfActivity() {
        return licensableTypeOfActivity;
    }

    /**
     * Sets the value of the licensableTypeOfActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicensableTypeOfActivity(String value) {
        this.licensableTypeOfActivity = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the licenseOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseOrganizationType }
     *     
     */
    public LicenseOrganizationType getLicenseOrganization() {
        return licenseOrganization;
    }

    /**
     * Sets the value of the licenseOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseOrganizationType }
     *     
     */
    public void setLicenseOrganization(LicenseOrganizationType value) {
        this.licenseOrganization = value;
    }

    /**
     * Gets the value of the accompanyingDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accompanyingDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccompanyingDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LicenseType.AccompanyingDocument }
     * 
     * 
     */
    public List<LicenseType.AccompanyingDocument> getAccompanyingDocument() {
        if (accompanyingDocument == null) {
            accompanyingDocument = new ArrayList<LicenseType.AccompanyingDocument>();
        }
        return this.accompanyingDocument;
    }

    /**
     * Gets the value of the house property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the house property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHouse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HouseType }
     * 
     * 
     */
    public List<HouseType> getHouse() {
        if (house == null) {
            house = new ArrayList<HouseType>();
        }
        return this.house;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/licenses/}AccompanyingDocumentType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="DateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="DocumentStatus"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="A"/&gt;
     *               &lt;enumeration value="C"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
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
        "dateFrom",
        "documentStatus"
    })
    public static class AccompanyingDocument
        extends AccompanyingDocumentType
    {

        @XmlElement(name = "DateFrom", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dateFrom;
        @XmlElement(name = "DocumentStatus", required = true)
        protected String documentStatus;

        /**
         * Gets the value of the dateFrom property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDateFrom() {
            return dateFrom;
        }

        /**
         * Sets the value of the dateFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDateFrom(XMLGregorianCalendar value) {
            this.dateFrom = value;
        }

        /**
         * Gets the value of the documentStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentStatus() {
            return documentStatus;
        }

        /**
         * Sets the value of the documentStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentStatus(String value) {
            this.documentStatus = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LicensingAuthority
        extends LegalType
    {


    }

}
