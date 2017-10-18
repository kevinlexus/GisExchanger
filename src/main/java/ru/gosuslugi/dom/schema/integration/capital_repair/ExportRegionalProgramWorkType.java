
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
 * &lt;complexType name="ExportRegionalProgramWorkType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramWorkType">
 *       &lt;sequence>
 *         &lt;element name="WorkGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
