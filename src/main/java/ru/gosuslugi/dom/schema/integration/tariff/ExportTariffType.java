
package ru.gosuslugi.dom.schema.integration.tariff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемые сведения о тарифе
 * 
 * <p>Java class for exportTariffType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportTariffType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TariffGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}StatusType"/&gt;
 *         &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="MunicipalResourceTariff" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}MunicipalResourceTariffType"/&gt;
 *           &lt;element name="ResidentialPremisesMaintenance" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ResidentialPremisesMaintenanceType"/&gt;
 *           &lt;element name="CapitalRepairTariff" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}CapitalRepairTariffType"/&gt;
 *           &lt;element name="SocialNorm" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}SocialNormType"/&gt;
 *           &lt;element name="ResidentialPremisesUsage" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ResidentialPremisesUsageType"/&gt;
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
@XmlType(name = "exportTariffType", propOrder = {
    "tariffGUID",
    "status",
    "cancelReason",
    "municipalResourceTariff",
    "residentialPremisesMaintenance",
    "capitalRepairTariff",
    "socialNorm",
    "residentialPremisesUsage"
})
public class ExportTariffType {

    @XmlElement(name = "TariffGUID", required = true)
    protected String tariffGUID;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusType status;
    @XmlElement(name = "CancelReason")
    protected String cancelReason;
    @XmlElement(name = "MunicipalResourceTariff")
    protected MunicipalResourceTariffType municipalResourceTariff;
    @XmlElement(name = "ResidentialPremisesMaintenance")
    protected ResidentialPremisesMaintenanceType residentialPremisesMaintenance;
    @XmlElement(name = "CapitalRepairTariff")
    protected CapitalRepairTariffType capitalRepairTariff;
    @XmlElement(name = "SocialNorm")
    protected SocialNormType socialNorm;
    @XmlElement(name = "ResidentialPremisesUsage")
    protected ResidentialPremisesUsageType residentialPremisesUsage;

    /**
     * Gets the value of the tariffGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffGUID() {
        return tariffGUID;
    }

    /**
     * Sets the value of the tariffGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffGUID(String value) {
        this.tariffGUID = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the cancelReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Sets the value of the cancelReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelReason(String value) {
        this.cancelReason = value;
    }

    /**
     * Gets the value of the municipalResourceTariff property.
     * 
     * @return
     *     possible object is
     *     {@link MunicipalResourceTariffType }
     *     
     */
    public MunicipalResourceTariffType getMunicipalResourceTariff() {
        return municipalResourceTariff;
    }

    /**
     * Sets the value of the municipalResourceTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link MunicipalResourceTariffType }
     *     
     */
    public void setMunicipalResourceTariff(MunicipalResourceTariffType value) {
        this.municipalResourceTariff = value;
    }

    /**
     * Gets the value of the residentialPremisesMaintenance property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialPremisesMaintenanceType }
     *     
     */
    public ResidentialPremisesMaintenanceType getResidentialPremisesMaintenance() {
        return residentialPremisesMaintenance;
    }

    /**
     * Sets the value of the residentialPremisesMaintenance property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialPremisesMaintenanceType }
     *     
     */
    public void setResidentialPremisesMaintenance(ResidentialPremisesMaintenanceType value) {
        this.residentialPremisesMaintenance = value;
    }

    /**
     * Gets the value of the capitalRepairTariff property.
     * 
     * @return
     *     possible object is
     *     {@link CapitalRepairTariffType }
     *     
     */
    public CapitalRepairTariffType getCapitalRepairTariff() {
        return capitalRepairTariff;
    }

    /**
     * Sets the value of the capitalRepairTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapitalRepairTariffType }
     *     
     */
    public void setCapitalRepairTariff(CapitalRepairTariffType value) {
        this.capitalRepairTariff = value;
    }

    /**
     * Gets the value of the socialNorm property.
     * 
     * @return
     *     possible object is
     *     {@link SocialNormType }
     *     
     */
    public SocialNormType getSocialNorm() {
        return socialNorm;
    }

    /**
     * Sets the value of the socialNorm property.
     * 
     * @param value
     *     allowed object is
     *     {@link SocialNormType }
     *     
     */
    public void setSocialNorm(SocialNormType value) {
        this.socialNorm = value;
    }

    /**
     * Gets the value of the residentialPremisesUsage property.
     * 
     * @return
     *     possible object is
     *     {@link ResidentialPremisesUsageType }
     *     
     */
    public ResidentialPremisesUsageType getResidentialPremisesUsage() {
        return residentialPremisesUsage;
    }

    /**
     * Sets the value of the residentialPremisesUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidentialPremisesUsageType }
     *     
     */
    public void setResidentialPremisesUsage(ResidentialPremisesUsageType value) {
        this.residentialPremisesUsage = value;
    }

}
