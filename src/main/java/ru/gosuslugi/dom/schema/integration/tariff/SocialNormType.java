
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Социальная норма потребления электрической энергии
 * 
 * <p>Java class for SocialNormType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SocialNormType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/tariff/}TariffCommonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}PriceType"/&gt;
 *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ElectricalEnergyUnitType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Differentiation" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}DifferentiationType" maxOccurs="1000"/&gt;
 *           &lt;element name="DifferentiationNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Coefficient" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}CoefficientType" maxOccurs="1000"/&gt;
 *           &lt;element name="CoefficientsNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SocialNormType", propOrder = {
    "price",
    "unit",
    "differentiation",
    "differentiationNotSet",
    "coefficient",
    "coefficientsNotSet"
})
public class SocialNormType
    extends TariffCommonType
{

    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "Unit", required = true)
    protected String unit;
    @XmlElement(name = "Differentiation")
    protected List<DifferentiationType> differentiation;
    @XmlElement(name = "DifferentiationNotSet")
    protected Boolean differentiationNotSet;
    @XmlElement(name = "Coefficient")
    protected List<CoefficientType> coefficient;
    @XmlElement(name = "CoefficientsNotSet")
    protected Boolean coefficientsNotSet;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

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
     * Gets the value of the differentiation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the differentiation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDifferentiation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DifferentiationType }
     * 
     * 
     */
    public List<DifferentiationType> getDifferentiation() {
        if (differentiation == null) {
            differentiation = new ArrayList<DifferentiationType>();
        }
        return this.differentiation;
    }

    /**
     * Gets the value of the differentiationNotSet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDifferentiationNotSet() {
        return differentiationNotSet;
    }

    /**
     * Sets the value of the differentiationNotSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDifferentiationNotSet(Boolean value) {
        this.differentiationNotSet = value;
    }

    /**
     * Gets the value of the coefficient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coefficient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoefficient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoefficientType }
     * 
     * 
     */
    public List<CoefficientType> getCoefficient() {
        if (coefficient == null) {
            coefficient = new ArrayList<CoefficientType>();
        }
        return this.coefficient;
    }

    /**
     * Gets the value of the coefficientsNotSet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCoefficientsNotSet() {
        return coefficientsNotSet;
    }

    /**
     * Sets the value of the coefficientsNotSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCoefficientsNotSet(Boolean value) {
        this.coefficientsNotSet = value;
    }

}
