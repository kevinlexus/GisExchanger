
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемая работа в РПКР (включая идентификатор)
 * 
 * <p>Java class for ExportRegionalProgramWorkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportRegionalProgramWorkType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramWorkType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportRegionalProgramWorkType", propOrder = {
    "workGUID"
})
public class ExportRegionalProgramWorkType
    extends RegionalProgramWorkType
{

    @XmlElement(name = "WorkGUID", required = true)
    protected String workGUID;

    /**
     * Gets the value of the workGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkGUID() {
        return workGUID;
    }

    /**
     * Sets the value of the workGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkGUID(String value) {
        this.workGUID = value;
    }

}
