
package ru.gosuslugi.dom.schema.integration.bills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Отчетный период
 * 
 * <p>Java class for ReportPeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportPeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportPeriodType", propOrder = {
    "month",
    "year"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.class,
    ru.gosuslugi.dom.schema.integration.bills.ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.class,
    ru.gosuslugi.dom.schema.integration.bills.ExportSettlementResultType.ReportingPeriod.class
})
public class ReportPeriodType {

    @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected int month;
    @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected short year;

    /**
     * Gets the value of the month property.
     * 
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     */
    public void setMonth(int value) {
        this.month = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(short value) {
        this.year = value;
    }

}
