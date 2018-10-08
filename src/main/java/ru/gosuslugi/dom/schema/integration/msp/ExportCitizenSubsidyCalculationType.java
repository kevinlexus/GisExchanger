
package ru.gosuslugi.dom.schema.integration.msp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Расчеты и перерасчеты для гражданина, получающего субсидии
 * 
 * <p>Java class for ExportCitizenSubsidyCalculationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCitizenSubsidyCalculationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}CitizenSubsidyCalculationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CalculationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/msp/}Status"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCitizenSubsidyCalculationType", propOrder = {
    "calculationGuid",
    "status"
})
public class ExportCitizenSubsidyCalculationType
    extends CitizenSubsidyCalculationType
{

    @XmlElement(name = "CalculationGuid", required = true)
    protected String calculationGuid;
    @XmlElement(name = "Status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String status;

    /**
     * Gets the value of the calculationGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalculationGuid() {
        return calculationGuid;
    }

    /**
     * Sets the value of the calculationGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalculationGuid(String value) {
        this.calculationGuid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
