
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Тип для создания ПУ, редактирования ПУ до начала внесения показаний, а также для экспорта сведений о ПУ
 * 
 * <p>Java class for MeteringDeviceFullInformationExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeteringDeviceFullInformationExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BasicChatacteristicts" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MeteringDeviceBasicCharacteristicsType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="NotLinkedWithMetering" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="LinkedWithMetering"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="InstallationPlace"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;enumeration value="in"/&gt;
 *                           &lt;enumeration value="out"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="MunicipalResourceNotEnergy" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceNotElectricExportType" maxOccurs="3"/&gt;
 *           &lt;element name="MunicipalResourceEnergy" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}MunicipalResourceElectricExportType"/&gt;
 *           &lt;element name="MunicipalResources" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DeviceMunicipalResourceType" maxOccurs="3"/&gt;
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
@XmlType(name = "MeteringDeviceFullInformationExportType", propOrder = {
    "basicChatacteristicts",
    "notLinkedWithMetering",
    "linkedWithMetering",
    "municipalResourceNotEnergy",
    "municipalResourceEnergy",
    "municipalResources"
})
@XmlSeeAlso({
    ExportMeteringDeviceDataResultType.class
})
public class MeteringDeviceFullInformationExportType {

    @XmlElement(name = "BasicChatacteristicts", required = true)
    protected MeteringDeviceBasicCharacteristicsType basicChatacteristicts;
    @XmlElement(name = "NotLinkedWithMetering")
    protected Boolean notLinkedWithMetering;
    @XmlElement(name = "LinkedWithMetering")
    protected MeteringDeviceFullInformationExportType.LinkedWithMetering linkedWithMetering;
    @XmlElement(name = "MunicipalResourceNotEnergy")
    protected List<MunicipalResourceNotElectricExportType> municipalResourceNotEnergy;
    @XmlElement(name = "MunicipalResourceEnergy")
    protected MunicipalResourceElectricExportType municipalResourceEnergy;
    @XmlElement(name = "MunicipalResources")
    protected List<DeviceMunicipalResourceType> municipalResources;

    /**
     * Gets the value of the basicChatacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceBasicCharacteristicsType }
     *     
     */
    public MeteringDeviceBasicCharacteristicsType getBasicChatacteristicts() {
        return basicChatacteristicts;
    }

    /**
     * Sets the value of the basicChatacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceBasicCharacteristicsType }
     *     
     */
    public void setBasicChatacteristicts(MeteringDeviceBasicCharacteristicsType value) {
        this.basicChatacteristicts = value;
    }

    /**
     * Gets the value of the notLinkedWithMetering property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotLinkedWithMetering() {
        return notLinkedWithMetering;
    }

    /**
     * Sets the value of the notLinkedWithMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotLinkedWithMetering(Boolean value) {
        this.notLinkedWithMetering = value;
    }

    /**
     * Gets the value of the linkedWithMetering property.
     * 
     * @return
     *     possible object is
     *     {@link MeteringDeviceFullInformationExportType.LinkedWithMetering }
     *     
     */
    public MeteringDeviceFullInformationExportType.LinkedWithMetering getLinkedWithMetering() {
        return linkedWithMetering;
    }

    /**
     * Sets the value of the linkedWithMetering property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeteringDeviceFullInformationExportType.LinkedWithMetering }
     *     
     */
    public void setLinkedWithMetering(MeteringDeviceFullInformationExportType.LinkedWithMetering value) {
        this.linkedWithMetering = value;
    }

    /**
     * Gets the value of the municipalResourceNotEnergy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipalResourceNotEnergy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipalResourceNotEnergy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MunicipalResourceNotElectricExportType }
     * 
     * 
     */
    public List<MunicipalResourceNotElectricExportType> getMunicipalResourceNotEnergy() {
        if (municipalResourceNotEnergy == null) {
            municipalResourceNotEnergy = new ArrayList<MunicipalResourceNotElectricExportType>();
        }
        return this.municipalResourceNotEnergy;
    }

    /**
     * Gets the value of the municipalResourceEnergy property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceElectricExportType }
     *     
     */
    public MunicipalResourceElectricExportType getMunicipalResourceEnergy() {
        return municipalResourceEnergy;
    }

    /**
     * Sets the value of the municipalResourceEnergy property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceElectricExportType }
     *     
     */
    public void setMunicipalResourceEnergy(MunicipalResourceElectricExportType value) {
        this.municipalResourceEnergy = value;
    }

    /**
     * Gets the value of the municipalResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipalResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipalResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceMunicipalResourceType }
     * 
     * 
     */
    public List<DeviceMunicipalResourceType> getMunicipalResources() {
        if (municipalResources == null) {
            municipalResources = new ArrayList<DeviceMunicipalResourceType>();
        }
        return this.municipalResources;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="InstallationPlace"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="in"/&gt;
     *               &lt;enumeration value="out"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="LinkedMeteringDeviceVersionGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType" maxOccurs="10" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "installationPlace",
        "linkedMeteringDeviceVersionGUID"
    })
    public static class LinkedWithMetering {

        @XmlElement(name = "InstallationPlace", required = true)
        protected String installationPlace;
        @XmlElement(name = "LinkedMeteringDeviceVersionGUID")
        protected List<String> linkedMeteringDeviceVersionGUID;

        /**
         * Gets the value of the installationPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInstallationPlace() {
            return installationPlace;
        }

        /**
         * Sets the value of the installationPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInstallationPlace(String value) {
            this.installationPlace = value;
        }

        /**
         * Gets the value of the linkedMeteringDeviceVersionGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the linkedMeteringDeviceVersionGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLinkedMeteringDeviceVersionGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLinkedMeteringDeviceVersionGUID() {
            if (linkedMeteringDeviceVersionGUID == null) {
                linkedMeteringDeviceVersionGUID = new ArrayList<String>();
            }
            return this.linkedMeteringDeviceVersionGUID;
        }

    }

}
