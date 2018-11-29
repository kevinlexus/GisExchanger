
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * Результат запроса краткой информации о жилом доме
 * 
 * <p>Java class for ExportBriefLivingHouseResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportBriefLivingHouseResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransportGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LivingHouseInfo" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefLivingHouseType"/&gt;
 *           &lt;element name="Error" type="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessageType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "ExportBriefLivingHouseResultType", propOrder = {
    "transportGUID",
    "livingHouseInfo",
    "error"
})
public class ExportBriefLivingHouseResultType {

    @XmlElement(name = "TransportGUID", required = true)
    protected String transportGUID;
    @XmlElement(name = "LivingHouseInfo")
    protected BriefLivingHouseType livingHouseInfo;
    @XmlElement(name = "Error")
    protected List<ErrorMessageType> error;

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
     * Gets the value of the livingHouseInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BriefLivingHouseType }
     *     
     */
    public BriefLivingHouseType getLivingHouseInfo() {
        return livingHouseInfo;
    }

    /**
     * Sets the value of the livingHouseInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BriefLivingHouseType }
     *     
     */
    public void setLivingHouseInfo(BriefLivingHouseType value) {
        this.livingHouseInfo = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorMessageType }
     * 
     * 
     */
    public List<ErrorMessageType> getError() {
        if (error == null) {
            error = new ArrayList<ErrorMessageType>();
        }
        return this.error;
    }

}
