
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;element name="RegionalProgramGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="Territory" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regionalProgramGuid",
    "territory"
})
@XmlRootElement(name = "exportRegionalProgramRequest")
public class ExportRegionalProgramRequest
    extends BaseType
{

    @XmlElement(name = "RegionalProgramGuid")
    protected String regionalProgramGuid;
    @XmlElement(name = "Territory")
    protected OKTMORefType territory;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the regionalProgramGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalProgramGuid() {
        return regionalProgramGuid;
    }

    /**
     * Sets the value of the regionalProgramGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalProgramGuid(String value) {
        this.regionalProgramGuid = value;
    }

    /**
     * Gets the value of the territory property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getTerritory() {
        return territory;
    }

    /**
     * Sets the value of the territory property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setTerritory(OKTMORefType value) {
        this.territory = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "11.2.0.10";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
