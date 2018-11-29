
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Краткая информация о расположении дома
 * 
 * <p>Java class for BriefLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BriefLocationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HCSHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *         &lt;element name="FIASHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/&gt;
 *         &lt;element name="Address"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="2500"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AOGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="HOUSENUM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BUILDNUM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="STRUCNUM" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="10"/&gt;
 *               &lt;minLength value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ESTSTATUS"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
 *               &lt;enumeration value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="STRSTATUS" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *               &lt;enumeration value="0"/&gt;
 *               &lt;enumeration value="1"/&gt;
 *               &lt;enumeration value="2"/&gt;
 *               &lt;enumeration value="3"/&gt;
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
@XmlType(name = "BriefLocationType", propOrder = {
    "hcsHouseGUID",
    "fiasHouseGUID",
    "address",
    "aoguid",
    "housenum",
    "buildnum",
    "strucnum",
    "eststatus",
    "strstatus"
})
public class BriefLocationType {

    @XmlElement(name = "HCSHouseGUID", required = true)
    protected String hcsHouseGUID;
    @XmlElement(name = "FIASHouseGUID")
    protected String fiasHouseGUID;
    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "AOGUID", required = true)
    protected String aoguid;
    @XmlElement(name = "HOUSENUM")
    protected String housenum;
    @XmlElement(name = "BUILDNUM")
    protected String buildnum;
    @XmlElement(name = "STRUCNUM")
    protected String strucnum;
    @XmlElement(name = "ESTSTATUS")
    protected byte eststatus;
    @XmlElement(name = "STRSTATUS")
    protected Byte strstatus;

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
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the aoguid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAOGUID() {
        return aoguid;
    }

    /**
     * Sets the value of the aoguid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAOGUID(String value) {
        this.aoguid = value;
    }

    /**
     * Gets the value of the housenum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOUSENUM() {
        return housenum;
    }

    /**
     * Sets the value of the housenum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOUSENUM(String value) {
        this.housenum = value;
    }

    /**
     * Gets the value of the buildnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBUILDNUM() {
        return buildnum;
    }

    /**
     * Sets the value of the buildnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBUILDNUM(String value) {
        this.buildnum = value;
    }

    /**
     * Gets the value of the strucnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTRUCNUM() {
        return strucnum;
    }

    /**
     * Sets the value of the strucnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTRUCNUM(String value) {
        this.strucnum = value;
    }

    /**
     * Gets the value of the eststatus property.
     * 
     */
    public byte getESTSTATUS() {
        return eststatus;
    }

    /**
     * Sets the value of the eststatus property.
     * 
     */
    public void setESTSTATUS(byte value) {
        this.eststatus = value;
    }

    /**
     * Gets the value of the strstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getSTRSTATUS() {
        return strstatus;
    }

    /**
     * Sets the value of the strstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setSTRSTATUS(Byte value) {
        this.strstatus = value;
    }

}
