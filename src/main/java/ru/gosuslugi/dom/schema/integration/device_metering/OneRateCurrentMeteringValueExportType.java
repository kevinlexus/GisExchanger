
package ru.gosuslugi.dom.schema.integration.device_metering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Текущие показания однотарифного ПУ: расширяет тип базовых показаний однотарифного ПУ датой снятия показаний. Используется при экспорте текущих и контрольных показаний ПУ
 * 
 * <p>Java class for OneRateCurrentMeteringValueExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneRateCurrentMeteringValueExportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/device-metering/}OneRateMeteringValueExportType">
 *       &lt;sequence>
 *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneRateCurrentMeteringValueExportType", propOrder = {
    "dateValue"
})
public class OneRateCurrentMeteringValueExportType
    extends OneRateMeteringValueExportType
{

    @XmlElement(name = "DateValue", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateValue;

    /**
     * Gets the value of the dateValue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValue() {
        return dateValue;
    }

    /**
     * Sets the value of the dateValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValue(XMLGregorianCalendar value) {
        this.dateValue = value;
    }

}
