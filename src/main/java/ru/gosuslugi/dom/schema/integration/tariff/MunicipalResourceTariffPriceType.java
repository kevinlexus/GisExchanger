
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Дифференцированная цена тарифа на оплату коммунальных ресурсов
 * 
 * <p>Java class for MunicipalResourceTariffPriceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceTariffPriceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="TariffStructure" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="Description" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type"/&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}PriceType"/&gt;
 *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="DifferentiationNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Differentiation" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}DifferentiationType" maxOccurs="1000"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MunicipalResourceTariffPriceType", propOrder = {
    "priceGUID",
    "tariffStructure",
    "description",
    "price",
    "unit",
    "differentiationNotSet",
    "differentiation"
})
public class MunicipalResourceTariffPriceType {

    @XmlElement(name = "PriceGUID")
    protected String priceGUID;
    @XmlElement(name = "TariffStructure", required = true)
    protected NsiRef tariffStructure;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "Unit", required = true)
    protected String unit;
    @XmlElement(name = "DifferentiationNotSet")
    protected Boolean differentiationNotSet;
    @XmlElement(name = "Differentiation")
    protected List<DifferentiationType> differentiation;

    /**
     * Gets the value of the priceGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriceGUID() {
        return priceGUID;
    }

    /**
     * Sets the value of the priceGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriceGUID(String value) {
        this.priceGUID = value;
    }

    /**
     * Gets the value of the tariffStructure property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getTariffStructure() {
        return tariffStructure;
    }

    /**
     * Sets the value of the tariffStructure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setTariffStructure(NsiRef value) {
        this.tariffStructure = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

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
