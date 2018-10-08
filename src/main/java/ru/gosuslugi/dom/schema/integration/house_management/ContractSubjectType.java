
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Предмет договора
 * 
 * <p>Java class for ContractSubjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractSubjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceType"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalResource"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="PlannedVolume" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
 *                   &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
 *                   &lt;element name="FeedingMode"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
 *                         &lt;maxLength value="250"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "ContractSubjectType", propOrder = {
    "serviceType",
    "municipalResource",
    "startSupplyDate",
    "endSupplyDate",
    "plannedVolume"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.SupplyResourceContractType.ContractSubject.class,
    ru.gosuslugi.dom.schema.integration.house_management.SupplyResourceContractProjectType.ContractSubject.class
})
public class ContractSubjectType {

    @XmlElement(name = "ServiceType", required = true)
    protected ContractSubjectType.ServiceType serviceType;
    @XmlElement(name = "MunicipalResource", required = true)
    protected ContractSubjectType.MunicipalResource municipalResource;
    @XmlElement(name = "StartSupplyDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startSupplyDate;
    @XmlElement(name = "EndSupplyDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endSupplyDate;
    @XmlElement(name = "PlannedVolume")
    protected ContractSubjectType.PlannedVolume plannedVolume;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ContractSubjectType.ServiceType }
     *     
     */
    public ContractSubjectType.ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSubjectType.ServiceType }
     *     
     */
    public void setServiceType(ContractSubjectType.ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link ContractSubjectType.MunicipalResource }
     *     
     */
    public ContractSubjectType.MunicipalResource getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSubjectType.MunicipalResource }
     *     
     */
    public void setMunicipalResource(ContractSubjectType.MunicipalResource value) {
        this.municipalResource = value;
    }

    /**
     * Gets the value of the startSupplyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartSupplyDate() {
        return startSupplyDate;
    }

    /**
     * Sets the value of the startSupplyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartSupplyDate(XMLGregorianCalendar value) {
        this.startSupplyDate = value;
    }

    /**
     * Gets the value of the endSupplyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndSupplyDate() {
        return endSupplyDate;
    }

    /**
     * Sets the value of the endSupplyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndSupplyDate(XMLGregorianCalendar value) {
        this.endSupplyDate = value;
    }

    /**
     * Gets the value of the plannedVolume property.
     * 
     * @return
     *     possible object is
     *     {@link ContractSubjectType.PlannedVolume }
     *     
     */
    public ContractSubjectType.PlannedVolume getPlannedVolume() {
        return plannedVolume;
    }

    /**
     * Sets the value of the plannedVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSubjectType.PlannedVolume }
     *     
     */
    public void setPlannedVolume(ContractSubjectType.PlannedVolume value) {
        this.plannedVolume = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
     *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
     *         &lt;element name="FeedingMode"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
     *               &lt;maxLength value="250"/&gt;
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
    @XmlType(name = "", propOrder = {
        "volume",
        "unit",
        "feedingMode"
    })
    public static class PlannedVolume {

        @XmlElement(name = "Volume", required = true)
        protected BigDecimal volume;
        @XmlElement(name = "Unit", required = true)
        protected String unit;
        @XmlElement(name = "FeedingMode", required = true)
        protected String feedingMode;

        /**
         * Gets the value of the volume property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVolume() {
            return volume;
        }

        /**
         * Sets the value of the volume property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVolume(BigDecimal value) {
            this.volume = value;
        }

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

        /**
         * Gets the value of the feedingMode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeedingMode() {
            return feedingMode;
        }

        /**
         * Sets the value of the feedingMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeedingMode(String value) {
            this.feedingMode = value;
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
