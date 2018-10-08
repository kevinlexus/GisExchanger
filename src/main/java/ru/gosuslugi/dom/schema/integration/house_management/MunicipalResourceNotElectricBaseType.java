
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueBaseType;


/**
 * Сведения о коммунальном ресурсе ПУ и последнее полученное показание (холодная вода, горячая вода, тепловая энергия, газ, сточные бытовые воды). Используется при создании / изменении ПУ для определения КР
 * 
 * <p>Java class for MunicipalResourceNotElectricBaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceNotElectricBaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="Unit" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="112"/&gt;
 *               &lt;enumeration value="113"/&gt;
 *               &lt;enumeration value="233"/&gt;
 *               &lt;enumeration value="245"/&gt;
 *               &lt;enumeration value="246"/&gt;
 *               &lt;enumeration value="271"/&gt;
 *               &lt;enumeration value="A056"/&gt;
 *               &lt;enumeration value="A058"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MunicipalResourceNotElectricBaseType", propOrder = {
    "unit"
})
@XmlSeeAlso({
    MunicipalResourceNotElectricExportType2 .class
})
public class MunicipalResourceNotElectricBaseType
    extends OneRateMeteringValueBaseType
{

    @XmlElement(name = "Unit")
    protected String unit;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
