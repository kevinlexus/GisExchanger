
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
 * &lt;complexType name="QualityResourcesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ObjectAddress"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServiceType" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalResource" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IsSignedAct" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="QualityIndicatorResource"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="IndicatorValue" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorValueType" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="OtherQualityIndicatorResource"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}OtherQualityIndicatorType"&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
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
@XmlType(name = "QualityResourcesType", propOrder = {
    "objectAddress",
    "serviceType",
    "municipalResource",
    "isSignedAct",
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
    @XmlElement(name = "IsSignedAct")
    protected Boolean isSignedAct;
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
     * Gets the value of the isSignedAct property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSignedAct() {
        return isSignedAct;
    }

    /**
     * Sets the value of the isSignedAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSignedAct(Boolean value) {
        this.isSignedAct = value;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ObjectAddressType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "notFromContract"
    })
    public static class ObjectAddress
        extends ObjectAddressType
    {

        @XmlElement(name = "NotFromContract")
        protected Boolean notFromContract;

        /**
         * Gets the value of the notFromContract property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotFromContract() {
            return notFromContract;
        }

        /**
         * Sets the value of the notFromContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotFromContract(Boolean value) {
            this.notFromContract = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}OtherQualityIndicatorType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="IndicatorValue" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IndicatorValueType" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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

        @XmlElement(name = "IndicatorValue")
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
