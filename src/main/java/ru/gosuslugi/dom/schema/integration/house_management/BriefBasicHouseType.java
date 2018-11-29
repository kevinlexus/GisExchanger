
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Кратка базовая информация о доме
 * 
 * <p>Java class for BriefBasicHouseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BriefBasicHouseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LocationInfo" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefLocationType"/&gt;
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefBasicCharactericticsType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BriefBasicHouseType", propOrder = {
    "locationInfo",
    "basicCharacteristicts"
})
public class BriefBasicHouseType {

    @XmlElement(name = "LocationInfo", required = true)
    protected BriefLocationType locationInfo;
    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected BriefBasicCharactericticsType basicCharacteristicts;

    /**
     * Gets the value of the locationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BriefLocationType }
     *     
     */
    public BriefLocationType getLocationInfo() {
        return locationInfo;
    }

    /**
     * Sets the value of the locationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BriefLocationType }
     *     
     */
    public void setLocationInfo(BriefLocationType value) {
        this.locationInfo = value;
    }

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link BriefBasicCharactericticsType }
     *     
     */
    public BriefBasicCharactericticsType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link BriefBasicCharactericticsType }
     *     
     */
    public void setBasicCharacteristicts(BriefBasicCharactericticsType value) {
        this.basicCharacteristicts = value;
    }

}
