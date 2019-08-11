
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Выбор значения показателя качества
 * 
 * <p>Java class for IndicatorValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndicatorValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;choice&gt;
 *             &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *               &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *             &lt;/sequence&gt;
 *           &lt;/choice&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndicatorValueType", propOrder = {
    "number",
    "startRange",
    "endRange",
    "okei",
    "correspond"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Quality.IndicatorValue.class,
    ru.gosuslugi.dom.schema.integration.house_management.SupplyResourceContractType.Quality.IndicatorValue.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractObjectAddressResultType.Quality.IndicatorValue.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractObjectAddressResultType.OtherQualityIndicator.IndicatorValue.class,
    ru.gosuslugi.dom.schema.integration.house_management.SupplyResourceContractProjectType.Quality.IndicatorValue.class
})
public class IndicatorValueType {

    @XmlElement(name = "Number")
    protected BigDecimal number;
    @XmlElement(name = "StartRange")
    protected BigDecimal startRange;
    @XmlElement(name = "EndRange")
    protected BigDecimal endRange;
    @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected String okei;
    @XmlElement(name = "Correspond")
    protected Boolean correspond;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumber(BigDecimal value) {
        this.number = value;
    }

    /**
     * Gets the value of the startRange property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStartRange() {
        return startRange;
    }

    /**
     * Sets the value of the startRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStartRange(BigDecimal value) {
        this.startRange = value;
    }

    /**
     * Gets the value of the endRange property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEndRange() {
        return endRange;
    }

    /**
     * Sets the value of the endRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEndRange(BigDecimal value) {
        this.endRange = value;
    }

    /**
     * Gets the value of the okei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKEI() {
        return okei;
    }

    /**
     * Sets the value of the okei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKEI(String value) {
        this.okei = value;
    }

    /**
     * Gets the value of the correspond property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCorrespond() {
        return correspond;
    }

    /**
     * Sets the value of the correspond property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCorrespond(Boolean value) {
        this.correspond = value;
    }

}
