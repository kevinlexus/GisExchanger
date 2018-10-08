
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.device_metering.VolumeMeteringValueExportBaseType;
import ru.gosuslugi.dom.schema.integration.device_metering.VolumeMeteringValueImportType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Объемы потребленных ресурсов по ПУ (электроэнергия, тепловая энергия, газ, горячая вода, холодная вода, сточные бытовые воды)
 * 
 * <p>Java class for VolumeMeteringValueBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeMeteringValueBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="MeteringValueT1" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
 *         &lt;element name="MeteringValueT2" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
 *         &lt;element name="MeteringValueT3" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeMeteringValueBaseType", propOrder = {
    "municipalResource",
    "meteringValueT1",
    "meteringValueT2",
    "meteringValueT3"
})
@XmlSeeAlso({
    VolumeMeteringValueImportType.class,
    VolumeMeteringValueExportBaseType.class
})
public class VolumeMeteringValueBaseType {

    @XmlElement(name = "MunicipalResource", required = true)
    protected NsiRef municipalResource;
    @XmlElement(name = "MeteringValueT1", required = true)
    protected String meteringValueT1;
    @XmlElement(name = "MeteringValueT2")
    protected String meteringValueT2;
    @XmlElement(name = "MeteringValueT3")
    protected String meteringValueT3;

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMunicipalResource(NsiRef value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the meteringValueT1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringValueT1() {
        return meteringValueT1;
    }

    /**
     * Sets the value of the meteringValueT1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringValueT1(String value) {
        this.meteringValueT1 = value;
    }

    /**
     * Gets the value of the meteringValueT2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringValueT2() {
        return meteringValueT2;
    }

    /**
     * Sets the value of the meteringValueT2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringValueT2(String value) {
        this.meteringValueT2 = value;
    }

    /**
     * Gets the value of the meteringValueT3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringValueT3() {
        return meteringValueT3;
    }

    /**
     * Sets the value of the meteringValueT3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringValueT3(String value) {
        this.meteringValueT3 = value;
    }

}
