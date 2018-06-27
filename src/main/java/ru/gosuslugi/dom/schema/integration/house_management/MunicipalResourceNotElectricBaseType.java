
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * &lt;complexType name="MunicipalResourceNotElectricBaseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueBaseType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="Unit" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="112"/>
 *               &lt;enumeration value="113"/>
 *               &lt;enumeration value="233"/>
 *               &lt;enumeration value="245"/>
 *               &lt;enumeration value="246"/>
 *               &lt;enumeration value="271"/>
 *               &lt;enumeration value="A056"/>
 *               &lt;enumeration value="A058"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MunicipalResourceNotElectricBaseType", propOrder = {
    "unit"
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
