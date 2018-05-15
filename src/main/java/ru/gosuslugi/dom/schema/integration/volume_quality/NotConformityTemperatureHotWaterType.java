
package ru.gosuslugi.dom.schema.integration.volume_quality;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Продолжительность предоставления  КУ "Горячее водоснабжение" при отклонении температуры воды
 * 
 * <p>Java class for NotConformityTemperatureHotWaterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotConformityTemperatureHotWaterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Deviation3" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg3" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deviation6" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg6" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deviation9" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg9" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deviation12" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg12" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deviation15" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg15" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Deviation18" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DeviationDeg18" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotConformityTemperatureHotWaterType", propOrder = {
    "deviation3",
    "deviation6",
    "deviation9",
    "deviation12",
    "deviation15",
    "deviation18"
})
public class NotConformityTemperatureHotWaterType {

    @XmlElement(name = "Deviation3")
    protected NotConformityTemperatureHotWaterType.Deviation3 deviation3;
    @XmlElement(name = "Deviation6")
    protected NotConformityTemperatureHotWaterType.Deviation6 deviation6;
    @XmlElement(name = "Deviation9")
    protected NotConformityTemperatureHotWaterType.Deviation9 deviation9;
    @XmlElement(name = "Deviation12")
    protected NotConformityTemperatureHotWaterType.Deviation12 deviation12;
    @XmlElement(name = "Deviation15")
    protected NotConformityTemperatureHotWaterType.Deviation15 deviation15;
    @XmlElement(name = "Deviation18")
    protected NotConformityTemperatureHotWaterType.Deviation18 deviation18;

    /**
     * Gets the value of the deviation3 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation3 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation3 getDeviation3() {
        return deviation3;
    }

    /**
     * Sets the value of the deviation3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation3 }
     *     
     */
    public void setDeviation3(NotConformityTemperatureHotWaterType.Deviation3 value) {
        this.deviation3 = value;
    }

    /**
     * Gets the value of the deviation6 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation6 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation6 getDeviation6() {
        return deviation6;
    }

    /**
     * Sets the value of the deviation6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation6 }
     *     
     */
    public void setDeviation6(NotConformityTemperatureHotWaterType.Deviation6 value) {
        this.deviation6 = value;
    }

    /**
     * Gets the value of the deviation9 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation9 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation9 getDeviation9() {
        return deviation9;
    }

    /**
     * Sets the value of the deviation9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation9 }
     *     
     */
    public void setDeviation9(NotConformityTemperatureHotWaterType.Deviation9 value) {
        this.deviation9 = value;
    }

    /**
     * Gets the value of the deviation12 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation12 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation12 getDeviation12() {
        return deviation12;
    }

    /**
     * Sets the value of the deviation12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation12 }
     *     
     */
    public void setDeviation12(NotConformityTemperatureHotWaterType.Deviation12 value) {
        this.deviation12 = value;
    }

    /**
     * Gets the value of the deviation15 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation15 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation15 getDeviation15() {
        return deviation15;
    }

    /**
     * Sets the value of the deviation15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation15 }
     *     
     */
    public void setDeviation15(NotConformityTemperatureHotWaterType.Deviation15 value) {
        this.deviation15 = value;
    }

    /**
     * Gets the value of the deviation18 property.
     * 
     * @return
     *     possible object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation18 }
     *     
     */
    public NotConformityTemperatureHotWaterType.Deviation18 getDeviation18() {
        return deviation18;
    }

    /**
     * Sets the value of the deviation18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotConformityTemperatureHotWaterType.Deviation18 }
     *     
     */
    public void setDeviation18(NotConformityTemperatureHotWaterType.Deviation18 value) {
        this.deviation18 = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg12" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg12"
    })
    public static class Deviation12 {

        @XmlElement(name = "DeviationDeg12", required = true)
        protected BigDecimal deviationDeg12;

        /**
         * Gets the value of the deviationDeg12 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg12() {
            return deviationDeg12;
        }

        /**
         * Sets the value of the deviationDeg12 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg12(BigDecimal value) {
            this.deviationDeg12 = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg15" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg15"
    })
    public static class Deviation15 {

        @XmlElement(name = "DeviationDeg15", required = true)
        protected BigDecimal deviationDeg15;

        /**
         * Gets the value of the deviationDeg15 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg15() {
            return deviationDeg15;
        }

        /**
         * Sets the value of the deviationDeg15 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg15(BigDecimal value) {
            this.deviationDeg15 = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg18" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg18"
    })
    public static class Deviation18 {

        @XmlElement(name = "DeviationDeg18", required = true)
        protected BigDecimal deviationDeg18;

        /**
         * Gets the value of the deviationDeg18 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg18() {
            return deviationDeg18;
        }

        /**
         * Sets the value of the deviationDeg18 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg18(BigDecimal value) {
            this.deviationDeg18 = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg3" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg3"
    })
    public static class Deviation3 {

        @XmlElement(name = "DeviationDeg3", required = true)
        protected BigDecimal deviationDeg3;

        /**
         * Gets the value of the deviationDeg3 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg3() {
            return deviationDeg3;
        }

        /**
         * Sets the value of the deviationDeg3 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg3(BigDecimal value) {
            this.deviationDeg3 = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg6" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg6"
    })
    public static class Deviation6 {

        @XmlElement(name = "DeviationDeg6", required = true)
        protected BigDecimal deviationDeg6;

        /**
         * Gets the value of the deviationDeg6 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg6() {
            return deviationDeg6;
        }

        /**
         * Sets the value of the deviationDeg6 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg6(BigDecimal value) {
            this.deviationDeg6 = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DeviationDeg9" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorServiceNumberType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "deviationDeg9"
    })
    public static class Deviation9 {

        @XmlElement(name = "DeviationDeg9", required = true)
        protected BigDecimal deviationDeg9;

        /**
         * Gets the value of the deviationDeg9 property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDeviationDeg9() {
            return deviationDeg9;
        }

        /**
         * Sets the value of the deviationDeg9 property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDeviationDeg9(BigDecimal value) {
            this.deviationDeg9 = value;
        }

    }

}
