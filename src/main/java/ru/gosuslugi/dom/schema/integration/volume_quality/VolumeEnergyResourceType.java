
package ru.gosuslugi.dom.schema.integration.volume_quality;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Объем ресурса "Электрическая энергия"
 * 
 * <p>Java class for VolumeEnergyResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeEnergyResourceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeteringDeviceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;sequence>
 *           &lt;element name="VolumeT1" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourceType"/>
 *           &lt;element name="VolumeT2" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourceType" minOccurs="0"/>
 *           &lt;element name="VolumeT3" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeResourceType" minOccurs="0"/>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeEnergyResourceType", propOrder = {
    "meteringDeviceType",
    "volumeT1",
    "volumeT2",
    "volumeT3",
    "okei"
})
public class VolumeEnergyResourceType {

    @XmlElement(name = "MeteringDeviceType", required = true)
    protected NsiRef meteringDeviceType;
    @XmlElement(name = "VolumeT1", required = true)
    protected BigDecimal volumeT1;
    @XmlElement(name = "VolumeT2")
    protected BigDecimal volumeT2;
    @XmlElement(name = "VolumeT3")
    protected BigDecimal volumeT3;
    @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String okei;

    /**
     * Gets the value of the meteringDeviceType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMeteringDeviceType() {
        return meteringDeviceType;
    }

    /**
     * Sets the value of the meteringDeviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMeteringDeviceType(NsiRef value) {
        this.meteringDeviceType = value;
    }

    /**
     * Gets the value of the volumeT1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeT1() {
        return volumeT1;
    }

    /**
     * Sets the value of the volumeT1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeT1(BigDecimal value) {
        this.volumeT1 = value;
    }

    /**
     * Gets the value of the volumeT2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeT2() {
        return volumeT2;
    }

    /**
     * Sets the value of the volumeT2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeT2(BigDecimal value) {
        this.volumeT2 = value;
    }

    /**
     * Gets the value of the volumeT3 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVolumeT3() {
        return volumeT3;
    }

    /**
     * Sets the value of the volumeT3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVolumeT3(BigDecimal value) {
        this.volumeT3 = value;
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
