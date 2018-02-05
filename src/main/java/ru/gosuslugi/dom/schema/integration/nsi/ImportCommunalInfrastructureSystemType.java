
package ru.gosuslugi.dom.schema.integration.nsi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Элемент справочника "Система коммунальной инфраструктуры"
 * 
 * <p>Java class for importCommunalInfrastructureSystemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importCommunalInfrastructureSystemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *           &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="SystemName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"/>
 *         &lt;element name="CommunalSystemInfrastructureType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importCommunalInfrastructureSystemType", propOrder = {
    "transportGUID",
    "elementGuid",
    "systemName",
    "communalSystemInfrastructureType"
})
public class ImportCommunalInfrastructureSystemType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "ElementGuid")
    protected String elementGuid;
    @XmlElement(name = "SystemName", required = true)
    protected String systemName;
    @XmlElement(name = "CommunalSystemInfrastructureType", required = true)
    protected NsiRef communalSystemInfrastructureType;

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
     * Gets the value of the elementGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementGuid() {
        return elementGuid;
    }

    /**
     * Sets the value of the elementGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementGuid(String value) {
        this.elementGuid = value;
    }

    /**
     * Gets the value of the systemName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * Sets the value of the systemName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemName(String value) {
        this.systemName = value;
    }

    /**
     * Gets the value of the communalSystemInfrastructureType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getCommunalSystemInfrastructureType() {
        return communalSystemInfrastructureType;
    }

    /**
     * Sets the value of the communalSystemInfrastructureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setCommunalSystemInfrastructureType(NsiRef value) {
        this.communalSystemInfrastructureType = value;
    }

}
