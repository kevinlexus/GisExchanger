
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 *  Тип для информации об объеме КР
 * 
 * <p>Java class for VolumeResourcesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VolumeResourcesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ObjectAddress">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServiceType">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="MunicipalResource">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="CommunalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;element name="VolumeNotEnergyResource" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeNotEnergyResourceType"/>
 *           &lt;element name="VolumeEnergyResource" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}VolumeEnergyResourceType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VolumeResourcesType", propOrder = {
    "objectAddress",
    "serviceType",
    "municipalResource",
    "communalResource",
    "volumeNotEnergyResource",
    "volumeEnergyResource"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources.class
})
public class VolumeResourcesType {

    @XmlElement(name = "ObjectAddress", required = true)
    protected VolumeResourcesType.ObjectAddress objectAddress;
    @XmlElement(name = "ServiceType", required = true)
    protected VolumeResourcesType.ServiceType serviceType;
    @XmlElement(name = "MunicipalResource")
    protected VolumeResourcesType.MunicipalResource municipalResource;
    @XmlElement(name = "CommunalResource")
    protected NsiRef communalResource;
    @XmlElement(name = "VolumeNotEnergyResource")
    protected VolumeNotEnergyResourceType volumeNotEnergyResource;
    @XmlElement(name = "VolumeEnergyResource")
    protected VolumeEnergyResourceType volumeEnergyResource;

    /**
     * Gets the value of the objectAddress property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeResourcesType.ObjectAddress }
     *     
     */
    public VolumeResourcesType.ObjectAddress getObjectAddress() {
        return objectAddress;
    }

    /**
     * Sets the value of the objectAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeResourcesType.ObjectAddress }
     *     
     */
    public void setObjectAddress(VolumeResourcesType.ObjectAddress value) {
        this.objectAddress = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeResourcesType.ServiceType }
     *     
     */
    public VolumeResourcesType.ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeResourcesType.ServiceType }
     *     
     */
    public void setServiceType(VolumeResourcesType.ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeResourcesType.MunicipalResource }
     *     
     */
    public VolumeResourcesType.MunicipalResource getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeResourcesType.MunicipalResource }
     *     
     */
    public void setMunicipalResource(VolumeResourcesType.MunicipalResource value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the communalResource property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getCommunalResource() {
        return communalResource;
    }

    /**
     * Sets the value of the communalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setCommunalResource(NsiRef value) {
        this.communalResource = value;
    }

    /**
     * Gets the value of the volumeNotEnergyResource property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeNotEnergyResourceType }
     *     
     */
    public VolumeNotEnergyResourceType getVolumeNotEnergyResource() {
        return volumeNotEnergyResource;
    }

    /**
     * Sets the value of the volumeNotEnergyResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeNotEnergyResourceType }
     *     
     */
    public void setVolumeNotEnergyResource(VolumeNotEnergyResourceType value) {
        this.volumeNotEnergyResource = value;
    }

    /**
     * Gets the value of the volumeEnergyResource property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeEnergyResourceType }
     *     
     */
    public VolumeEnergyResourceType getVolumeEnergyResource() {
        return volumeEnergyResource;
    }

    /**
     * Sets the value of the volumeEnergyResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeEnergyResourceType }
     *     
     */
    public void setVolumeEnergyResource(VolumeEnergyResourceType value) {
        this.volumeEnergyResource = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MunicipalResource
        extends NsiRef
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ObjectAddress
        extends ObjectAddressType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ServiceType
        extends NsiRef
    {


    }

}
