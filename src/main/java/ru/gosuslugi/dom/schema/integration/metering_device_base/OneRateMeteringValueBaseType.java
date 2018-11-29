
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Коммунальный ресурс и показание ПУ для однотарифного ПУ. Используется при импорте показаний поверки и фиксации показаний ПУ при его замене, а также, как базовый класс для других типов
 * 
 * <p>Java class for OneRateMeteringValueBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneRateMeteringValueBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="MeteringValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneRateMeteringValueBaseType", propOrder = {
    "municipalResource",
    "meteringValue"
})
@XmlSeeAlso({
    OneRateMeteringValueExportType.class
})
public class OneRateMeteringValueBaseType {

    @XmlElement(name = "MunicipalResource", required = true)
    protected NsiRef municipalResource;
    @XmlElement(name = "MeteringValue", required = true)
    protected String meteringValue;

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
     * Gets the value of the meteringValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeteringValue() {
        return meteringValue;
    }

    /**
     * Sets the value of the meteringValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeteringValue(String value) {
        this.meteringValue = value;
    }

}
