
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Прикладной идентификатор работы в договоре на выполнение работ (оказание услуг) по капитальному ремонту
 * 
 * <p>Java class for WorkContractIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkContractIdentityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="WorkPlanGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="WorkPlanBusinessIdentity" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}WorkPlanIdentityType"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkContractIdentityType", propOrder = {
    "workPlanGUID",
    "workPlanBusinessIdentity"
})
@XmlSeeAlso({
    WorkContractType.class
})
public class WorkContractIdentityType {

    @XmlElement(name = "WorkPlanGUID")
    protected String workPlanGUID;
    @XmlElement(name = "WorkPlanBusinessIdentity")
    protected WorkPlanIdentityType workPlanBusinessIdentity;

    /**
     * Gets the value of the workPlanGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkPlanGUID() {
        return workPlanGUID;
    }

    /**
     * Sets the value of the workPlanGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPlanGUID(String value) {
        this.workPlanGUID = value;
    }

    /**
     * Gets the value of the workPlanBusinessIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link WorkPlanIdentityType }
     *     
     */
    public WorkPlanIdentityType getWorkPlanBusinessIdentity() {
        return workPlanBusinessIdentity;
    }

    /**
     * Sets the value of the workPlanBusinessIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkPlanIdentityType }
     *     
     */
    public void setWorkPlanBusinessIdentity(WorkPlanIdentityType value) {
        this.workPlanBusinessIdentity = value;
    }

}
