
package ru.gosuslugi.dom.schema.integration.nsi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Элемент справочника виды работ капитального ремонта.
 * 
 * <p>Java class for ImportCapitalRepairWorkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImportCapitalRepairWorkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *           &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="ServiceName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"/>
 *         &lt;element name="WorkGroupRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImportCapitalRepairWorkType", propOrder = {
    "transportGUID",
    "elementGuid",
    "serviceName",
    "workGroupRef"
})
public class ImportCapitalRepairWorkType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "ElementGuid")
    protected String elementGuid;
    @XmlElement(name = "ServiceName", required = true)
    protected String serviceName;
    @XmlElement(name = "WorkGroupRef", required = true)
    protected NsiRef workGroupRef;

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
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the workGroupRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getWorkGroupRef() {
        return workGroupRef;
    }

    /**
     * Sets the value of the workGroupRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setWorkGroupRef(NsiRef value) {
        this.workGroupRef = value;
    }

}
