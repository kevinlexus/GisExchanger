
package ru.gosuslugi.dom.schema.integration.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;


/**
 * Базовый тип выполненной работы для экспорта
 * 
 * <p>Java class for CompletedWorkExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletedWorkExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="photos" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="MonthlyWork" type="{http://dom.gosuslugi.ru/schema/integration/services/}MonthlyWorkType" minOccurs="0"/&gt;
 *         &lt;element name="ActGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/services/}WorkPriceType" minOccurs="0"/&gt;
 *         &lt;element name="Amount" type="{http://dom.gosuslugi.ru/schema/integration/services/}WorkAmountType" minOccurs="0"/&gt;
 *         &lt;element name="TotalCost" type="{http://dom.gosuslugi.ru/schema/integration/services/}WorkCostType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompletedWorkExportType", propOrder = {
    "photos",
    "monthlyWork",
    "actGUID",
    "price",
    "amount",
    "totalCost"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.services.CompletedWorksByPeriodExportType.PlannedWork.class,
    ru.gosuslugi.dom.schema.integration.services.CompletedWorksByPeriodExportType.UnplannedWork.class
})
public class CompletedWorkExportType {

    protected List<AttachmentType> photos;
    @XmlElement(name = "MonthlyWork")
    protected MonthlyWorkType monthlyWork;
    @XmlElement(name = "ActGUID")
    protected String actGUID;
    @XmlElement(name = "Price")
    protected BigDecimal price;
    @XmlElement(name = "Amount")
    protected BigDecimal amount;
    @XmlElement(name = "TotalCost")
    protected BigDecimal totalCost;

    /**
     * Gets the value of the photos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the photos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhotos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentType }
     * 
     * 
     */
    public List<AttachmentType> getPhotos() {
        if (photos == null) {
            photos = new ArrayList<AttachmentType>();
        }
        return this.photos;
    }

    /**
     * Gets the value of the monthlyWork property.
     * 
     * @return
     *     possible object is
     *     {@link MonthlyWorkType }
     *     
     */
    public MonthlyWorkType getMonthlyWork() {
        return monthlyWork;
    }

    /**
     * Sets the value of the monthlyWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonthlyWorkType }
     *     
     */
    public void setMonthlyWork(MonthlyWorkType value) {
        this.monthlyWork = value;
    }

    /**
     * Gets the value of the actGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActGUID() {
        return actGUID;
    }

    /**
     * Sets the value of the actGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActGUID(String value) {
        this.actGUID = value;
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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCost(BigDecimal value) {
        this.totalCost = value;
    }

}
