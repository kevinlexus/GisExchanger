
package ru.gosuslugi.dom.schema.integration.tariff;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Тариф на оплату коммунальных ресурсов
 * 
 * <p>Java class for MunicipalResourceTariffType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceTariffType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/tariff/}TariffCommonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}MunicipalResourceTariffPriceType" maxOccurs="1000"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="AllOrganization" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="RegulatedOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" maxOccurs="1000"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="TariffStructure" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="10"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MunicipalResourceTariffType", propOrder = {
    "price",
    "allOrganization",
    "regulatedOrganization",
    "tariffStructure"
})
public class MunicipalResourceTariffType
    extends TariffCommonType
{

    @XmlElement(name = "Price", required = true)
    protected List<MunicipalResourceTariffPriceType> price;
    @XmlElement(name = "AllOrganization")
    protected Boolean allOrganization;
    @XmlElement(name = "RegulatedOrganization")
    protected List<RegOrgType> regulatedOrganization;
    @XmlElement(name = "TariffStructure", required = true)
    protected List<NsiRef> tariffStructure;

    /**
     * Gets the value of the price property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the price property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MunicipalResourceTariffPriceType }
     * 
     * 
     */
    public List<MunicipalResourceTariffPriceType> getPrice() {
        if (price == null) {
            price = new ArrayList<MunicipalResourceTariffPriceType>();
        }
        return this.price;
    }

    /**
     * Gets the value of the allOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllOrganization() {
        return allOrganization;
    }

    /**
     * Sets the value of the allOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllOrganization(Boolean value) {
        this.allOrganization = value;
    }

    /**
     * Gets the value of the regulatedOrganization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regulatedOrganization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegulatedOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegOrgType }
     * 
     * 
     */
    public List<RegOrgType> getRegulatedOrganization() {
        if (regulatedOrganization == null) {
            regulatedOrganization = new ArrayList<RegOrgType>();
        }
        return this.regulatedOrganization;
    }

    /**
     * Gets the value of the tariffStructure property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffStructure property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffStructure().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getTariffStructure() {
        if (tariffStructure == null) {
            tariffStructure = new ArrayList<NsiRef>();
        }
        return this.tariffStructure;
    }

}
