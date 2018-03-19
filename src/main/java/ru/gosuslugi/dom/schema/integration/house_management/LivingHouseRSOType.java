
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Жилой дом (для импорта от РСО)
 * 
 * <p>Java class for LivingHouseRSOType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LivingHouseRSOType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicRSOType"/>
 *         &lt;element name="HasBlocks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HasMultipleHousesWithSameAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivingHouseRSOType", propOrder = {
    "basicCharacteristicts",
    "hasBlocks",
    "hasMultipleHousesWithSameAddress"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseRSORequest.LivingHouse.LivingHouseToCreate.class
})
public class LivingHouseRSOType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicRSOType basicCharacteristicts;
    @XmlElement(name = "HasBlocks")
    protected Boolean hasBlocks;
    @XmlElement(name = "HasMultipleHousesWithSameAddress")
    protected Boolean hasMultipleHousesWithSameAddress;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicRSOType }
     *     
     */
    public HouseBasicRSOType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicRSOType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicRSOType value) {
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
