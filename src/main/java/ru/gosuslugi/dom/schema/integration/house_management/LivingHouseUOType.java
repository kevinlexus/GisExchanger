
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Жилой дом (для импорта от УО)
 * 
 * <p>Java class for LivingHouseUOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LivingHouseUOType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicUOType"/&gt;
 *         &lt;element name="HasBlocks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="HasMultipleHousesWithSameAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivingHouseUOType", propOrder = {
    "basicCharacteristicts",
    "hasBlocks",
    "hasMultipleHousesWithSameAddress"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.LivingHouse.LivingHouseToCreate.class
})
public class LivingHouseUOType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicUOType basicCharacteristicts;
    @XmlElement(name = "HasBlocks")
    protected Boolean hasBlocks;
    @XmlElement(name = "HasMultipleHousesWithSameAddress")
    protected Boolean hasMultipleHousesWithSameAddress;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicUOType }
     *     
     */
    public HouseBasicUOType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicUOType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicUOType value) {
        this.basicCharacteristicts = value;
    }

    /**
     * Gets the value of the hasBlocks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasBlocks() {
        return hasBlocks;
    }

    /**
     * Sets the value of the hasBlocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasBlocks(Boolean value) {
        this.hasBlocks = value;
    }

    /**
     * Gets the value of the hasMultipleHousesWithSameAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasMultipleHousesWithSameAddress() {
        return hasMultipleHousesWithSameAddress;
    }

    /**
     * Sets the value of the hasMultipleHousesWithSameAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasMultipleHousesWithSameAddress(Boolean value) {
        this.hasMultipleHousesWithSameAddress = value;
    }

}
