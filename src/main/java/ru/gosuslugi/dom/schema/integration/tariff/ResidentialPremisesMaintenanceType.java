
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Размер платы за содержание жилого помещения
 * 
 * <p>Java class for ResidentialPremisesMaintenanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidentialPremisesMaintenanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/tariff/}TariffCommonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Price" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}PriceType"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="DifferentiationNotSet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Differentiation" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}DifferentiationType" maxOccurs="1000"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Usage" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="WithoutJobs" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Job" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidentialPremisesMaintenanceType", propOrder = {
    "price",
    "differentiationNotSet",
    "differentiation",
    "usage",
    "withoutJobs",
    "job"
})
public class ResidentialPremisesMaintenanceType
    extends TariffCommonType
{

    @XmlElement(name = "Price", required = true)
    protected BigDecimal price;
    @XmlElement(name = "DifferentiationNotSet")
    protected Boolean differentiationNotSet;
    @XmlElement(name = "Differentiation")
    protected List<DifferentiationType> differentiation;
    @XmlElement(name = "Usage", required = true)
    protected List<NsiRef> usage;
    @XmlElement(name = "WithoutJobs")
    protected Boolean withoutJobs;
    @XmlElement(name = "Job")
    protected List<NsiRef> job;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the differentiationNotSet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDifferentiationNotSet() {
        return differentiationNotSet;
    }

    /**
     * Sets the value of the differentiationNotSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDifferentiationNotSet(Boolean value) {
        this.differentiationNotSet = value;
    }

    /**
     * Gets the value of the differentiation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the differentiation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDifferentiation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DifferentiationType }
     * 
     * 
     */
    public List<DifferentiationType> getDifferentiation() {
        if (differentiation == null) {
            differentiation = new ArrayList<DifferentiationType>();
        }
        return this.differentiation;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getUsage() {
        if (usage == null) {
            usage = new ArrayList<NsiRef>();
        }
        return this.usage;
    }

    /**
     * Gets the value of the withoutJobs property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithoutJobs() {
        return withoutJobs;
    }

    /**
     * Sets the value of the withoutJobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithoutJobs(Boolean value) {
        this.withoutJobs = value;
    }

    /**
     * Gets the value of the job property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the job property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getJob() {
        if (job == null) {
            job = new ArrayList<NsiRef>();
        }
        return this.job;
    }

}
