
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Краткая информация о многоквартирном доме
 * 
 * <p>Java class for BriefApartmentHouseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BriefApartmentHouseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HCSHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *         &lt;element name="FIASHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/&gt;
 *         &lt;element name="HouseUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ModificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Entrance" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefEntranceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ResidentialPremises" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefResidentialPremisesType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="NonResidentialPremises" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefNonResidentialPremisesType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="TerminationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="AnnulmentReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="AnnulmentInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DemolishionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DemolishionReason" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *         &lt;element name="IsAsyncProcessed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BriefApartmentHouseType", propOrder = {
    "hcsHouseGUID",
    "fiasHouseGUID",
    "houseUniqueNumber",
    "modificationDate",
    "entrance",
    "residentialPremises",
    "nonResidentialPremises",
    "houseManagementType",
    "terminationDate",
    "annulmentReason",
    "annulmentInfo",
    "demolishionDate",
    "demolishionReason",
    "isAsyncProcessed"
})
public class BriefApartmentHouseType {

    @XmlElement(name = "HCSHouseGUID", required = true)
    protected String hcsHouseGUID;
    @XmlElement(name = "FIASHouseGUID")
    protected String fiasHouseGUID;
    @XmlElement(name = "HouseUniqueNumber", required = true)
    protected String houseUniqueNumber;
    @XmlElement(name = "ModificationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationDate;
    @XmlElement(name = "Entrance")
    protected List<BriefEntranceType> entrance;
    @XmlElement(name = "ResidentialPremises")
    protected List<BriefResidentialPremisesType> residentialPremises;
    @XmlElement(name = "NonResidentialPremises")
    protected List<BriefNonResidentialPremisesType> nonResidentialPremises;
    @XmlElement(name = "HouseManagementType")
    protected NsiRef houseManagementType;
    @XmlElement(name = "TerminationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar terminationDate;
    @XmlElement(name = "AnnulmentReason")
    protected NsiRef annulmentReason;
    @XmlElement(name = "AnnulmentInfo")
    protected String annulmentInfo;
    @XmlElement(name = "DemolishionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar demolishionDate;
    @XmlElement(name = "DemolishionReason")
    protected String demolishionReason;
    @XmlElement(name = "IsAsyncProcessed")
    protected Boolean isAsyncProcessed;

    /**
     * Gets the value of the hcsHouseGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHCSHouseGUID() {
        return hcsHouseGUID;
    }

    /**
     * Sets the value of the hcsHouseGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHCSHouseGUID(String value) {
        this.hcsHouseGUID = value;
    }

    /**
     * Gets the value of the fiasHouseGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGUID() {
        return fiasHouseGUID;
    }

    /**
     * Sets the value of the fiasHouseGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGUID(String value) {
        this.fiasHouseGUID = value;
    }

    /**
     * Gets the value of the houseUniqueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseUniqueNumber() {
        return houseUniqueNumber;
    }

    /**
     * Sets the value of the houseUniqueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseUniqueNumber(String value) {
        this.houseUniqueNumber = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationDate(XMLGregorianCalendar value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the entrance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entrance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntrance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BriefEntranceType }
     * 
     * 
     */
    public List<BriefEntranceType> getEntrance() {
        if (entrance == null) {
            entrance = new ArrayList<BriefEntranceType>();
        }
        return this.entrance;
    }

    /**
     * Gets the value of the residentialPremises property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residentialPremises property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidentialPremises().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BriefResidentialPremisesType }
     * 
     * 
     */
    public List<BriefResidentialPremisesType> getResidentialPremises() {
        if (residentialPremises == null) {
            residentialPremises = new ArrayList<BriefResidentialPremisesType>();
        }
        return this.residentialPremises;
    }

    /**
     * Gets the value of the nonResidentialPremises property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremises property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNonResidentialPremises().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BriefNonResidentialPremisesType }
     * 
     * 
     */
    public List<BriefNonResidentialPremisesType> getNonResidentialPremises() {
        if (nonResidentialPremises == null) {
            nonResidentialPremises = new ArrayList<BriefNonResidentialPremisesType>();
        }
        return this.nonResidentialPremises;
    }

    /**
     * Gets the value of the houseManagementType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getHouseManagementType() {
        return houseManagementType;
    }

    /**
     * Sets the value of the houseManagementType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setHouseManagementType(NsiRef value) {
        this.houseManagementType = value;
    }

    /**
     * Gets the value of the terminationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationDate() {
        return terminationDate;
    }

    /**
     * Sets the value of the terminationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationDate(XMLGregorianCalendar value) {
        this.terminationDate = value;
    }

    /**
     * Gets the value of the annulmentReason property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getAnnulmentReason() {
        return annulmentReason;
    }

    /**
     * Sets the value of the annulmentReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setAnnulmentReason(NsiRef value) {
        this.annulmentReason = value;
    }

    /**
     * Gets the value of the annulmentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnulmentInfo() {
        return annulmentInfo;
    }

    /**
     * Sets the value of the annulmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnulmentInfo(String value) {
        this.annulmentInfo = value;
    }

    /**
     * Gets the value of the demolishionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDemolishionDate() {
        return demolishionDate;
    }

    /**
     * Sets the value of the demolishionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDemolishionDate(XMLGregorianCalendar value) {
        this.demolishionDate = value;
    }

    /**
     * Gets the value of the demolishionReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDemolishionReason() {
        return demolishionReason;
    }

    /**
     * Sets the value of the demolishionReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDemolishionReason(String value) {
        this.demolishionReason = value;
    }

    /**
     * Gets the value of the isAsyncProcessed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAsyncProcessed() {
        return isAsyncProcessed;
    }

    /**
     * Sets the value of the isAsyncProcessed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAsyncProcessed(Boolean value) {
        this.isAsyncProcessed = value;
    }

}
