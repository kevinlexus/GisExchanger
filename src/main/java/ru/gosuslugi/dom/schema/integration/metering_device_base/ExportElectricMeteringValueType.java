
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Экспортируемые показания по ПУ электрической энергии
 * 
 * <p>Java class for ExportElectricMeteringValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportElectricMeteringValueType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueType">
 *       &lt;sequence>
 *         &lt;element name="EnterIntoSystem" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportElectricMeteringValueType", propOrder = {
    "enterIntoSystem"
})
public class ExportElectricMeteringValueType
    extends ElectricMeteringValueType
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
