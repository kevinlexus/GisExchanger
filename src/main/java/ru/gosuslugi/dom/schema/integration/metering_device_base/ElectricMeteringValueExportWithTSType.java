
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Данные многотарифного ПУ: коммунальный ресурс, последнее полученное показание в единицах измерения ПУ, источник данных о показаниях ПУ, время внесения в Систему. Используется при экспорте показаний ПУ
 * 
 * <p>Java class for ElectricMeteringValueExportWithTSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectricMeteringValueExportWithTSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueExportType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EnterIntoSystem" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectricMeteringValueExportWithTSType", propOrder = {
    "enterIntoSystem"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.device_metering.ElectricMeteringValueExportType.class
})
public class ElectricMeteringValueExportWithTSType
    extends ru.gosuslugi.dom.schema.integration.metering_device_base.ElectricMeteringValueExportType
{

    @XmlElement(name = "EnterIntoSystem", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enterIntoSystem;

    /**
     * Gets the value of the enterIntoSystem property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnterIntoSystem() {
        return enterIntoSystem;
    }

    /**
     * Sets the value of the enterIntoSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnterIntoSystem(XMLGregorianCalendar value) {
        this.enterIntoSystem = value;
    }

}
