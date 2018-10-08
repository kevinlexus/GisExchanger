
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Данные однотарифного ПУ: коммунальный ресурс, последнее полученное показание в единицах измерения ПУ и (если отличается) в единицах измерения коммунального ресурса по умолчанию, источник данных о показаниях ПУ. Используется при экспорте данных ПУ
 * 
 * <p>Java class for MunicipalResourceNotElectricExportType2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceNotElectricExportType2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceNotElectricBaseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
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
@XmlType(name = "MunicipalResourceNotElectricExportType2", propOrder = {
    "meteringValueInDefaultUnit",
    "readingsSource",
    "orgPPAGUID"
})
public class MunicipalResourceNotElectricExportType2
    extends MunicipalResourceNotElectricBaseType
{

    @XmlElement(name = "MeteringValueInDefaultUnit")
    protected MunicipalResourceNotElectricExportType2 .MeteringValueInDefaultUnit meteringValueInDefaultUnit;
    @XmlElement(name = "ReadingsSource")
    protected String readingsSource;
    protected String orgPPAGUID;

    /**
     * Gets the value of the meteringValueInDefaultUnit property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceNotElectricExportType2 .MeteringValueInDefaultUnit }
     *     
     */
    public MunicipalResourceNotElectricExportType2 .MeteringValueInDefaultUnit getMeteringValueInDefaultUnit() {
        return meteringValueInDefaultUnit;
    }

    /**
     * Sets the value of the meteringValueInDefaultUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceNotElectricExportType2 .MeteringValueInDefaultUnit }
     *     
     */
    public void setMeteringValueInDefaultUnit(MunicipalResourceNotElectricExportType2 .MeteringValueInDefaultUnit value) {
        this.meteringValueInDefaultUnit = value;
    }

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
