
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Работа в КПР
 * 
 * <p>Java class for WorkPlanType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkPlanType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkPlanIdentityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *         &lt;element name="Financing" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkFinancingType"/&gt;
 *         &lt;element name="SpecificCost" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyPositiveType" minOccurs="0"/&gt;
 *         &lt;element name="MaximumCost" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}MoneyPositiveType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkPlanType", propOrder = {
    "oktmo",
    "financing",
    "specificCost",
    "maximumCost"
})
@XmlSeeAlso({
    ExportWorkPlanType.class
})
public class WorkPlanType
    extends WorkPlanIdentityType
{

    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "Financing", required = true)
    protected WorkFinancingType financing;
    @XmlElement(name = "SpecificCost")
    protected BigDecimal specificCost;
    @XmlElement(name = "MaximumCost")
    protected BigDecimal maximumCost;

    /**
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the financing property.
     * 
     * @return
     *     possible object is
     *     {@link WorkFinancingType }
     *     
     */
    public WorkFinancingType getFinancing() {
        return financing;
    }

    /**
     * Sets the value of the financing property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkFinancingType }
     *     
     */
    public void setFinancing(WorkFinancingType value) {
        this.financing = value;
    }

    /**
     * Gets the value of the specificCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpecificCost() {
        return specificCost;
    }

    /**
     * Sets the value of the specificCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpecificCost(BigDecimal value) {
        this.specificCost = value;
    }

    /**
     * Gets the value of the maximumCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaximumCost() {
        return maximumCost;
    }

    /**
     * Sets the value of the maximumCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaximumCost(BigDecimal value) {
        this.maximumCost = value;
    }

}
