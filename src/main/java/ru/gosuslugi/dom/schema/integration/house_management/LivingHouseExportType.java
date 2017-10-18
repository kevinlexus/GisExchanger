
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Жилой дом (для экспорта)
 * 
 * <p>Java class for LivingHouseExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LivingHouseExportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicExportType"/>
 *         &lt;element name="HasBlocks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivingHouseExportType", propOrder = {
    "basicCharacteristicts",
    "hasBlocks"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.LivingHouse.class
})
public class LivingHouseExportType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicExportType basicCharacteristicts;
    @XmlElement(name = "HasBlocks")
    protected Boolean hasBlocks;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicExportType }
     *     
     */
    public HouseBasicExportType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicExportType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicExportType value) {
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

}
