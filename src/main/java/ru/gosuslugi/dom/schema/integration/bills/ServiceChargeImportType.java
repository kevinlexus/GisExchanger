
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Начисление по услуге
 * 
 * <p>Java class for ServiceChargeImportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceChargeImportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}MoneyRecalculation" minOccurs="0"/&gt;
 *         &lt;element name="MoneyDiscount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="13"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceChargeImportType", propOrder = {
    "moneyRecalculation",
    "moneyDiscount"
})
public class ServiceChargeImportType {

    @XmlElement(name = "MoneyRecalculation")
    protected BigDecimal moneyRecalculation;
    @XmlElement(name = "MoneyDiscount")
    protected BigDecimal moneyDiscount;

    /**
     * Перерасчеты, корректировки (руб)
     * Ссылка на пост. 924 – Приложение 2, п. 20.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyRecalculation() {
        return moneyRecalculation;
    }

    /**
     * Sets the value of the moneyRecalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyRecalculation(BigDecimal value) {
        this.moneyRecalculation = value;
    }

    /**
     * Gets the value of the moneyDiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyDiscount() {
        return moneyDiscount;
    }

    /**
     * Sets the value of the moneyDiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyDiscount(BigDecimal value) {
        this.moneyDiscount = value;
    }

}
