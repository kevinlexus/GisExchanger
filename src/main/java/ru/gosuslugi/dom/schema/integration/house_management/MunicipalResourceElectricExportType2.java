
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Данные многотарифного ПУ: коммунальный ресурс, последние полученные показания в единицах измерения ПУ и (если отличается) в единицах измерения коммунального ресурса по умолчанию, источник данных о показаниях ПУ. Используется при экспорте данных ПУ
 * 
 * <p>Java class for MunicipalResourceElectricExportType2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceElectricExportType2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceElectricBaseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="MeteringValueInDefaultUnit" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MeteringValueT1" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
 *                   &lt;element name="MeteringValueT2" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
 *                   &lt;element name="MeteringValueT3" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
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
@XmlType(name = "MunicipalResourceElectricExportType2", propOrder = {
    "meteringValueInDefaultUnit",
    "readingsSource",
    "orgPPAGUID"
})
public class MunicipalResourceElectricExportType2
    extends MunicipalResourceElectricBaseType
{

    @XmlElement(name = "MeteringValueInDefaultUnit")
    protected MunicipalResourceElectricExportType2 .MeteringValueInDefaultUnit meteringValueInDefaultUnit;
    @XmlElement(name = "ReadingsSource")
    protected String readingsSource;
    protected String orgPPAGUID;

    /**
     * Gets the value of the meteringValueInDefaultUnit property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceElectricExportType2 .MeteringValueInDefaultUnit }
     *     
     */
    public MunicipalResourceElectricExportType2 .MeteringValueInDefaultUnit getMeteringValueInDefaultUnit() {
        return meteringValueInDefaultUnit;
    }

    /**
     * Sets the value of the meteringValueInDefaultUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceElectricExportType2 .MeteringValueInDefaultUnit }
     *     
     */
    public void setMeteringValueInDefaultUnit(MunicipalResourceElectricExportType2 .MeteringValueInDefaultUnit value) {
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
     *         &lt;element name="MeteringValueT1" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType"/&gt;
     *         &lt;element name="MeteringValueT2" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
     *         &lt;element name="MeteringValueT3" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringValueType" minOccurs="0"/&gt;
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
        "meteringValueT1",
        "meteringValueT2",
        "meteringValueT3",
        "defaultUnit"
    })
    public static class MeteringValueInDefaultUnit {

        @XmlElement(name = "MeteringValueT1", required = true)
        protected String meteringValueT1;
        @XmlElement(name = "MeteringValueT2")
        protected String meteringValueT2;
        @XmlElement(name = "MeteringValueT3")
        protected String meteringValueT3;
        @XmlElement(name = "DefaultUnit", required = true)
        protected String defaultUnit;

        /**
         * Gets the value of the meteringValueT1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringValueT1() {
            return meteringValueT1;
        }

        /**
         * Sets the value of the meteringValueT1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringValueT1(String value) {
            this.meteringValueT1 = value;
        }

        /**
         * Gets the value of the meteringValueT2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringValueT2() {
            return meteringValueT2;
        }

        /**
         * Sets the value of the meteringValueT2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringValueT2(String value) {
            this.meteringValueT2 = value;
        }

        /**
         * Gets the value of the meteringValueT3 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeteringValueT3() {
            return meteringValueT3;
        }

        /**
         * Sets the value of the meteringValueT3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeteringValueT3(String value) {
            this.meteringValueT3 = value;
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
