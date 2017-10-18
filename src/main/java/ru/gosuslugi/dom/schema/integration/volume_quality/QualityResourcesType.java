
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 *  Тип для информации о показателях качества КР
 * 
 * <p>Java class for QualityResourcesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QualityResourcesType">
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
 *         &lt;element name="ServiceType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MunicipalResource" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="QualityIndicatorResource">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                   &lt;sequence>
 *                     &lt;element name="IndicatorValue" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorValueType"/>
 *                   &lt;/sequence>
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="OtherQualityIndicatorResource">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}OtherQualityIndicatorType">
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
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
@XmlType(name = "QualityResourcesType", propOrder = {
    "objectAddress",
    "serviceType",
    "municipalResource",
    "qualityIndicatorResource",
    "otherQualityIndicatorResource"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.volume_quality.ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources.class
})
public class QualityResourcesType {

    @XmlElement(name = "ObjectAddress", required = true)
    protected QualityResourcesType.ObjectAddress objectAddress;
    @XmlElement(name = "ServiceType")
    protected QualityResourcesType.ServiceType serviceType;
    @XmlElement(name = "MunicipalResource")
    protected QualityResourcesType.MunicipalResource municipalResource;
    @XmlElement(name = "QualityIndicatorResource")
    protected QualityResourcesType.QualityIndicatorResource qualityIndicatorResource;
    @XmlElement(name = "OtherQualityIndicatorResource")
    protected QualityResourcesType.OtherQualityIndicatorResource otherQualityIndicatorResource;

    /**
     * Gets the value of the objectAddress property.
     * 
     * @return
     *     possible object is
     *     {@link QualityResourcesType.ObjectAddress }
     *     
     */
    public QualityResourcesType.ObjectAddress getObjectAddress() {
        return objectAddress;
    }

    /**
     * Sets the value of the objectAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityResourcesType.ObjectAddress }
     *     
     */
    public void setObjectAddress(QualityResourcesType.ObjectAddress value) {
        this.objectAddress = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link QualityResourcesType.ServiceType }
     *     
     */
    public QualityResourcesType.ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityResourcesType.ServiceType }
     *     
     */
    public void setServiceType(QualityResourcesType.ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link QualityResourcesType.MunicipalResource }
     *     
     */
    public QualityResourcesType.MunicipalResource getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityResourcesType.MunicipalResource }
     *     
     */
    public void setMunicipalResource(QualityResourcesType.MunicipalResource value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the qualityIndicatorResource property.
     * 
     * @return
     *     possible object is
     *     {@link QualityResourcesType.QualityIndicatorResource }
     *     
     */
    public QualityResourcesType.QualityIndicatorResource getQualityIndicatorResource() {
        return qualityIndicatorResource;
    }

    /**
     * Sets the value of the qualityIndicatorResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityResourcesType.QualityIndicatorResource }
     *     
     */
    public void setQualityIndicatorResource(QualityResourcesType.QualityIndicatorResource value) {
        this.qualityIndicatorResource = value;
    }

    /**
     * Gets the value of the otherQualityIndicatorResource property.
     * 
     * @return
     *     possible object is
     *     {@link QualityResourcesType.OtherQualityIndicatorResource }
     *     
     */
    public QualityResourcesType.OtherQualityIndicatorResource getOtherQualityIndicatorResource() {
        return otherQualityIndicatorResource;
    }

    /**
     * Sets the value of the otherQualityIndicatorResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityResourcesType.OtherQualityIndicatorResource }
     *     
     */
    public void setOtherQualityIndicatorResource(QualityResourcesType.OtherQualityIndicatorResource value) {
        this.otherQualityIndicatorResource = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}OtherQualityIndicatorType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OtherQualityIndicatorResource
        extends OtherQualityIndicatorType
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
     *       &lt;sequence>
     *         &lt;element name="IndicatorValue" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorValueType"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "indicatorValue"
    })
    public static class QualityIndicatorResource
        extends NsiRef
    {

        @XmlElement(name = "IndicatorValue", required = true)
        protected IndicatorValueType indicatorValue;

        /**
         * Gets the value of the indicatorValue property.
         * 
         * @return
         *     possible object is
         *     {@link IndicatorValueType }
         *     
         */
        public IndicatorValueType getIndicatorValue() {
            return indicatorValue;
        }

        /**
         * Sets the value of the indicatorValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link IndicatorValueType }
         *     
         */
        public void setIndicatorValue(IndicatorValueType value) {
            this.indicatorValue = value;
        }

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
