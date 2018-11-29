
package ru.gosuslugi.dom.schema.integration.nsi_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Ссылка на справочник
 * 
 * <p>Java class for nsiRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nsiRef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Code" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiCodeType"/&gt;
 *         &lt;element name="GUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="Name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *               &lt;maxLength value="1200"/&gt;
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
@XmlType(name = "nsiRef", propOrder = {
    "code",
    "guid",
    "name"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.QualityResourcesType.ServiceType.class,
    ru.gosuslugi.dom.schema.integration.volume_quality.QualityResourcesType.MunicipalResource.class,
    ru.gosuslugi.dom.schema.integration.volume_quality.QualityResourcesType.QualityIndicatorResource.class,
    ru.gosuslugi.dom.schema.integration.volume_quality.VolumeResourcesType.ServiceType.class,
    ru.gosuslugi.dom.schema.integration.volume_quality.VolumeResourcesType.MunicipalResource.class
})
public class NsiRef {

    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "GUID", required = true)
    protected String guid;
    @XmlElement(name = "Name")
    protected String name;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the guid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUID() {
        return guid;
    }

    /**
     * Sets the value of the guid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUID(String value) {
        this.guid = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
