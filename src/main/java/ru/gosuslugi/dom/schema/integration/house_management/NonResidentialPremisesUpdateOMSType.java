
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Нежилое помещение (обновление данных для ОМС)
 * 
 * <p>Java class for NonResidentialPremisesUpdateOMSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NonResidentialPremisesUpdateOMSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}PremisesBasicUpdateOMSType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FIASChildHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" minOccurs="0"/&gt;
 *         &lt;element name="TotalArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType" minOccurs="0"/&gt;
 *         &lt;element name="IsCommonProperty" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NonResidentialPremisesUpdateOMSType", propOrder = {
    "fiasChildHouseGuid",
    "totalArea",
    "isCommonProperty"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseOMSRequest.ApartmentHouse.NonResidentialPremiseToUpdate.class
})
public class NonResidentialPremisesUpdateOMSType
    extends PremisesBasicUpdateOMSType
{

    @XmlElement(name = "FIASChildHouseGuid")
    protected String fiasChildHouseGuid;
    @XmlElement(name = "TotalArea")
    protected BigDecimal totalArea;
    @XmlElement(name = "IsCommonProperty")
    protected Boolean isCommonProperty;

    /**
     * Gets the value of the fiasChildHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASChildHouseGuid() {
        return fiasChildHouseGuid;
    }

    /**
     * Sets the value of the fiasChildHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASChildHouseGuid(String value) {
        this.fiasChildHouseGuid = value;
    }

    /**
     * Gets the value of the totalArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalArea() {
        return totalArea;
    }

    /**
     * Sets the value of the totalArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalArea(BigDecimal value) {
        this.totalArea = value;
    }

    /**
     * Gets the value of the isCommonProperty property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCommonProperty() {
        return isCommonProperty;
    }

    /**
     * Sets the value of the isCommonProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCommonProperty(Boolean value) {
        this.isCommonProperty = value;
    }

}
