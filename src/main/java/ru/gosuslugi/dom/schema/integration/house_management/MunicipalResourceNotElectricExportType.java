
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.OneRateMeteringValueExportType;


/**
 * Сведения о коммунальном ресурсе ПУ и последнее полученное показание (холодная вода, горячая вода, тепловая энергия, газ, сточные бытовые воды). Используется при создании / изменении ПУ для определения КР
 * 
 * <p>Java class for MunicipalResourceNotElectricExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceNotElectricExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}OneRateMeteringValueExportType"&gt;
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
 *         &lt;element name="MeteringValueInDefaultUnit" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MeteringValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
 *                   &lt;element name="DefaultUnit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "MunicipalResourceNotElectricExportType", propOrder = {
    "unit",
    "meteringValueInDefaultUnit"
})
public class MunicipalResourceNotElectricExportType
    extends OneRateMeteringValueExportType
{

    @XmlElement(name = "Unit")
    protected String unit;
    @XmlElement(name = "MeteringValueInDefaultUnit")
    protected MunicipalResourceNotElectricExportType.MeteringValueInDefaultUnit meteringValueInDefaultUnit;

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

    /**
     * Gets the value of the meteringValueInDefaultUnit property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceNotElectricExportType.MeteringValueInDefaultUnit }
     *     
     */
    public MunicipalResourceNotElectricExportType.MeteringValueInDefaultUnit getMeteringValueInDefaultUnit() {
        return meteringValueInDefaultUnit;
    }

    /**
     * Sets the value of the meteringValueInDefaultUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceNotElectricExportType.MeteringValueInDefaultUnit }
     *     
     */
    public void setMeteringValueInDefaultUnit(MunicipalResourceNotElectricExportType.MeteringValueInDefaultUnit value) {
        this.meteringValueInDefaultUnit = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="MeteringValue" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
     *         &lt;element name="DefaultUnit" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "meteringValue",
        "defaultUnit"
    })
    public static class MeteringValueInDefaultUnit {

        @XmlElement(name = "MeteringValue", required = true)
        protected String meteringValue;
        @XmlElement(name = "DefaultUnit", required = true)
        protected String defaultUnit;

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

        /**
         * Gets the value of the defaultUnit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultUnit() {
            return defaultUnit;
        }

        /**
         * Sets the value of the defaultUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultUnit(String value) {
            this.defaultUnit = value;
        }

    }

}
