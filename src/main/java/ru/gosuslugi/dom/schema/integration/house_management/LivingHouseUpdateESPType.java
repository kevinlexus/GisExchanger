
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Жилой дом (обновление данных ЕСП)
 * 
 * <p>Java class for LivingHouseUpdateESPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LivingHouseUpdateESPType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicCharacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}HouseBasicUpdateESPType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivingHouseUpdateESPType", propOrder = {
    "basicCharacteristicts"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseESPRequest.LivingHouse.LivingHouseToUpdate.class
})
public class LivingHouseUpdateESPType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected HouseBasicUpdateESPType basicCharacteristicts;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link HouseBasicUpdateESPType }
     *     
     */
    public HouseBasicUpdateESPType getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link HouseBasicUpdateESPType }
     *     
     */
    public void setBasicCharacteristicts(HouseBasicUpdateESPType value) {
        this.basicCharacteristicts = value;
    }

}
