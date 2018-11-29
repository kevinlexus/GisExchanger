
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип данных, описывающий запрос на экспорт краткой базовой информации об одном доме
 * 
 * <p>Java class for ExportBriefBasicHouseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportBriefBasicHouseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *         &lt;element name="Criteria" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportBriefBasicCriteriaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportBriefBasicHouseRequestType", propOrder = {
    "transportGUID",
    "criteria"
})
public class ExportBriefBasicHouseRequestType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "Criteria", required = true)
    protected ExportBriefBasicCriteriaType criteria;

    /**
     * Gets the value of the transportGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportGUID() {
        return transportGUID;
    }

    /**
     * Sets the value of the transportGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportGUID(String value) {
        this.transportGUID = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link ExportBriefBasicCriteriaType }
     *     
     */
    public ExportBriefBasicCriteriaType getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportBriefBasicCriteriaType }
     *     
     */
    public void setCriteria(ExportBriefBasicCriteriaType value) {
        this.criteria = value;
    }

}
