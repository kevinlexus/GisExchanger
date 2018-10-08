
package ru.gosuslugi.dom.schema.integration.metering_device_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Данные многотарифного ПУ: коммунальный ресурс, последние полученные показания в единицах измерения ПУ, источник данных о показаниях ПУ. Используется при экспорте данных ПУ
 * 
 * <p>Java class for ElectricMeteringValueExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectricMeteringValueExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="ReadingsSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orgPPAGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectricMeteringValueExportType", propOrder = {
    "readingsSource",
    "orgPPAGUID"
})
@XmlSeeAlso({
    ElectricMeteringValueExportWithTSType.class
})
public class ElectricMeteringValueExportType
    extends ElectricMeteringValueBaseType
{

    @XmlElement(name = "ReadingsSource")
    protected String readingsSource;
    protected String orgPPAGUID;

    /**
     * Gets the value of the readingsSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadingsSource() {
        return readingsSource;
    }

    /**
     * Sets the value of the readingsSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadingsSource(String value) {
        this.readingsSource = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
    }

}
