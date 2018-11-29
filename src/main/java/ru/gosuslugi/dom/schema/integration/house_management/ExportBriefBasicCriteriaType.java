
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Критерии поиска дома
 * 
 * <p>Java class for ExportBriefBasicCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportBriefBasicCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="HouseUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PremisesUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LivingRoomUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="BlockUniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportBriefBasicCriteriaType", propOrder = {
    "houseUniqueNumber",
    "premisesUniqueNumber",
    "livingRoomUniqueNumber",
    "blockUniqueNumber",
    "fiasHouseGuid"
})
public class ExportBriefBasicCriteriaType {

    @XmlElement(name = "HouseUniqueNumber")
    protected String houseUniqueNumber;
    @XmlElement(name = "PremisesUniqueNumber")
    protected String premisesUniqueNumber;
    @XmlElement(name = "LivingRoomUniqueNumber")
    protected String livingRoomUniqueNumber;
    @XmlElement(name = "BlockUniqueNumber")
    protected String blockUniqueNumber;
    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;

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
     * Gets the value of the premisesUniqueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremisesUniqueNumber() {
        return premisesUniqueNumber;
    }

    /**
     * Sets the value of the premisesUniqueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremisesUniqueNumber(String value) {
        this.premisesUniqueNumber = value;
    }

    /**
     * Gets the value of the livingRoomUniqueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLivingRoomUniqueNumber() {
        return livingRoomUniqueNumber;
    }

    /**
     * Sets the value of the livingRoomUniqueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLivingRoomUniqueNumber(String value) {
        this.livingRoomUniqueNumber = value;
    }

    /**
     * Gets the value of the blockUniqueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockUniqueNumber() {
        return blockUniqueNumber;
    }

    /**
     * Sets the value of the blockUniqueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockUniqueNumber(String value) {
        this.blockUniqueNumber = value;
    }

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

}
