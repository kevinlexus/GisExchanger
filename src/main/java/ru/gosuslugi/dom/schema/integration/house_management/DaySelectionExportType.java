
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип выбора дня для экспорта
 * 
 * <p>Java class for DaySelectionExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DaySelectionExportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Date">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="LastDay" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="IsNextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DaySelectionExportType", propOrder = {
    "date",
    "lastDay",
    "isNextMonth"
})
public class DaySelectionExportType {

    @XmlElement(name = "Date")
    protected Byte date;
    @XmlElement(name = "LastDay")
    protected Boolean lastDay;
    @XmlElement(name = "IsNextMonth")
    protected boolean isNextMonth;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setDate(Byte value) {
        this.date = value;
    }

    /**
     * Gets the value of the lastDay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLastDay() {
        return lastDay;
    }

    /**
     * Sets the value of the lastDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLastDay(Boolean value) {
        this.lastDay = value;
    }

    /**
     * Gets the value of the isNextMonth property.
     * 
     */
    public boolean isIsNextMonth() {
        return isNextMonth;
    }

    /**
     * Sets the value of the isNextMonth property.
     * 
     */
    public void setIsNextMonth(boolean value) {
        this.isNextMonth = value;
    }

}
