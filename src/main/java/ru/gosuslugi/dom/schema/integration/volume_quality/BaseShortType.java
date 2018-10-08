
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Составной тип. Основание
 * 
 * <p>Java class for BaseShortType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseShortType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BaseKind" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseKindShortType"/&gt;
 *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseShortType", propOrder = {
    "baseKind",
    "contractRootGUID"
})
public class BaseShortType {

    @XmlElement(name = "BaseKind", required = true)
    @XmlSchemaType(name = "string")
    protected BaseKindShortType baseKind;
    @XmlElement(name = "ContractRootGUID", required = true)
    protected String contractRootGUID;

    /**
     * Gets the value of the baseKind property.
     * 
     * @return
     *     possible object is
     *     {@link BaseKindShortType }
     *     
     */
    public BaseKindShortType getBaseKind() {
        return baseKind;
    }

    /**
     * Sets the value of the baseKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseKindShortType }
     *     
     */
    public void setBaseKind(BaseKindShortType value) {
        this.baseKind = value;
    }

    /**
     * Gets the value of the contractRootGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractRootGUID() {
        return contractRootGUID;
    }

    /**
     * Sets the value of the contractRootGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractRootGUID(String value) {
        this.contractRootGUID = value;
    }

}
