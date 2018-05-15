
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Иной показатель качества КР
 * 
 * <p>Java class for OtherQualityIndicatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtherQualityIndicatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"/>
 *         &lt;element name="IndicatorValue" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorValueType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherQualityIndicatorType", propOrder = {
    "indicatorName",
    "indicatorValue"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.QualityResourcesType.OtherQualityIndicatorResource.class
})
public class OtherQualityIndicatorType {

    @XmlElement(name = "IndicatorName", required = true)
    protected String indicatorName;
    @XmlElement(name = "IndicatorValue")
    protected IndicatorValueType indicatorValue;

    /**
     * Gets the value of the indicatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatorName() {
        return indicatorName;
    }

    /**
     * Sets the value of the indicatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatorName(String value) {
        this.indicatorName = value;
    }

    /**
     * Gets the value of the indicatorValue property.
     * 
     * @return
     *     possible object is
     *     {@link IndicatorValueType }
     *     
     */
    public IndicatorValueType getIndicatorValue() {
        return indicatorValue;
    }

    /**
     * Sets the value of the indicatorValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndicatorValueType }
     *     
     */
    public void setIndicatorValue(IndicatorValueType value) {
        this.indicatorValue = value;
    }

}
