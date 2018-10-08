
package ru.gosuslugi.dom.schema.integration.device_metering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Данные текущих показаний ПУ, измеряющего объем потребляемого коммунального ресурса: расширяет базовый тип датой снятия показаний. Используется при экспорте текущих и контрольных показаний
 * 
 * <p>Java class for VolumeCurrentMeteringValueExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeCurrentMeteringValueExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/device-metering/}VolumeMeteringValueExportBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DateValue" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeCurrentMeteringValueExportType", propOrder = {
    "dateValue"
})
public class VolumeCurrentMeteringValueExportType
    extends VolumeMeteringValueExportBaseType
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
