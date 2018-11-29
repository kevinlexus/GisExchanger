
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип данных, описывающий запрос на экспорт краткой информации об одном жилом доме
 * 
 * <p>Java class for ExportBriefLivingHouseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportBriefLivingHouseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *         &lt;element name="HouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportBriefLivingHouseRequestType", propOrder = {
    "transportGUID",
    "houseGuid"
})
public class ExportBriefLivingHouseRequestType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "HouseGuid", required = true)
    protected String houseGuid;

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
     * Gets the value of the houseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseGuid() {
        return houseGuid;
    }

    /**
     * Sets the value of the houseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseGuid(String value) {
        this.houseGuid = value;
    }

}
