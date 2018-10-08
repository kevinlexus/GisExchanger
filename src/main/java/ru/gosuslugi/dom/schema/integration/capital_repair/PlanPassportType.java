
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Паспорт программы/плана
 * 
 * <p>Java class for PlanPassportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlanPassportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String1000Type"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Territory" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *         &lt;element name="Type"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"&gt;
 *               &lt;enumeration value="Plan"/&gt;
 *               &lt;enumeration value="MunicipalAddressProgram"/&gt;
 *               &lt;enumeration value="RegionalAddressProgram"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="StartMonthYear" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
 *         &lt;element name="EndMonthYear" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlanPassportType", propOrder = {
    "name",
    "territory",
    "type",
    "startMonthYear",
    "endMonthYear"
})
@XmlSeeAlso({
    ExportPlanPassportType.class
})
public class PlanPassportType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Territory", required = true)
    protected OKTMORefType territory;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "StartMonthYear", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar startMonthYear;
    @XmlElement(name = "EndMonthYear", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar endMonthYear;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the startMonthYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartMonthYear() {
        return startMonthYear;
    }

    /**
     * Sets the value of the startMonthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartMonthYear(XMLGregorianCalendar value) {
        this.startMonthYear = value;
    }

    /**
     * Gets the value of the endMonthYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndMonthYear() {
        return endMonthYear;
    }

    /**
     * Sets the value of the endMonthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndMonthYear(XMLGregorianCalendar value) {
        this.endMonthYear = value;
    }

}
