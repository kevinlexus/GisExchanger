
package ru.gosuslugi.dom.schema.integration.volume_quality;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Объем ресурса 
 * 
 * <p>Java class for VolumeNotEnergyResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeNotEnergyResourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourceType"/>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeNotEnergyResourceType", propOrder = {
    "volume",
    "okei"
})
public class VolumeNotEnergyResourceType {

    @XmlElement(name = "Volume", required = true)
    protected BigDecimal volume;
    @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String okei;

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolume(BigDecimal value) {
        this.volume = value;
    }

    /**
     * Gets the value of the okei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKEI() {
        return okei;
    }

    /**
     * Sets the value of the okei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKEI(String value) {
        this.okei = value;
    }

}
