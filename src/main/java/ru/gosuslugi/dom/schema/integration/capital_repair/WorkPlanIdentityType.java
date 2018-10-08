
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Прикладной идентификатор работы в КПР, РАПКР, МАПКР
 * 
 * <p>Java class for WorkPlanIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkPlanIdentityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FiasHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *         &lt;element name="WorkKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
@XmlType(name = "WorkPlanIdentityType", propOrder = {
    "fiasHouseGUID",
    "workKind",
    "endMonthYear"
})
@XmlSeeAlso({
    WorkPlanType.class
})
public class WorkPlanIdentityType {

    @XmlElement(name = "FiasHouseGUID", required = true)
    protected String fiasHouseGUID;
    @XmlElement(name = "WorkKind", required = true)
    protected NsiRef workKind;
    @XmlElement(name = "EndMonthYear", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar endMonthYear;

    /**
     * Gets the value of the fiasHouseGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiasHouseGUID() {
        return fiasHouseGUID;
    }

    /**
     * Sets the value of the fiasHouseGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiasHouseGUID(String value) {
        this.fiasHouseGUID = value;
    }

    /**
     * Gets the value of the workKind property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getWorkKind() {
        return workKind;
    }

    /**
     * Sets the value of the workKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setWorkKind(NsiRef value) {
        this.workKind = value;
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
