
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Коэффициент тарифа
 * 
 * <p>Java class for CoefficientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoefficientType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CoefficientValue" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}CoefficientValueType"/&gt;
 *         &lt;element name="CoefficientDescription" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoefficientType", propOrder = {
    "coefficientValue",
    "coefficientDescription"
})
public class CoefficientType {

    @XmlElement(name = "CoefficientValue", required = true)
    protected BigDecimal coefficientValue;
    @XmlElement(name = "CoefficientDescription", required = true)
    protected String coefficientDescription;

    /**
     * Gets the value of the coefficientValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCoefficientValue() {
        return coefficientValue;
    }

    /**
     * Sets the value of the coefficientValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCoefficientValue(BigDecimal value) {
        this.coefficientValue = value;
    }

    /**
     * Gets the value of the coefficientDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoefficientDescription() {
        return coefficientDescription;
    }

    /**
     * Sets the value of the coefficientDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoefficientDescription(String value) {
        this.coefficientDescription = value;
    }

}
