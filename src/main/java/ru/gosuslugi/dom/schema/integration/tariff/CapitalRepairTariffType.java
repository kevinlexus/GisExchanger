
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Минимальный размер взноса на капитальный ремонт
 * 
 * <p>Java class for CapitalRepairTariffType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CapitalRepairTariffType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/tariff/}TariffCommonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}PriceType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="DifferentiationNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Differentiation" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}DifferentiationType" maxOccurs="1000"/&gt;
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
@XmlType(name = "CapitalRepairTariffType", propOrder = {
    "price",
    "differentiationNotSet",
    "differentiation"
})
public class CapitalRepairTariffType
    extends TariffCommonType
{

    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "DifferentiationNotSet")
    protected Boolean differentiationNotSet;
    @XmlElement(name = "Differentiation")
    protected List<DifferentiationType> differentiation;

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

}
