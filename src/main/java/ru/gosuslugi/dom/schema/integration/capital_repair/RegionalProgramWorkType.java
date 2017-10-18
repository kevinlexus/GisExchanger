
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Работа в РПКР
 * 
 * <p>Java class for RegionalProgramWorkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegionalProgramWorkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FiasHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/>
 *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *         &lt;element name="WorkType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="StartYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *         &lt;element name="EndYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegionalProgramWorkType", propOrder = {
    "fiasHouseGUID",
    "oktmo",
    "workType",
    "startYearMonth",
    "endYearMonth"
})
@XmlSeeAlso({
    ExportRegionalProgramWorkType.class
})
public class RegionalProgramWorkType {

    @XmlElement(name = "FiasHouseGUID", required = true)
    protected String fiasHouseGUID;
    @XmlElement(name = "OKTMO", required = true)
    protected OKTMORefType oktmo;
    @XmlElement(name = "WorkType", required = true)
    protected NsiRef workType;
    @XmlElement(name = "StartYearMonth", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar startYearMonth;
    @XmlElement(name = "EndYearMonth", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar endYearMonth;

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
     * Gets the value of the oktmo property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getOKTMO() {
        return oktmo;
    }

    /**
     * Sets the value of the oktmo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setOKTMO(OKTMORefType value) {
        this.oktmo = value;
    }

    /**
     * Gets the value of the workType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getWorkType() {
        return workType;
    }

    /**
     * Sets the value of the workType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setWorkType(NsiRef value) {
        this.workType = value;
    }

    /**
     * Gets the value of the startYearMonth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartYearMonth() {
        return startYearMonth;
    }

    /**
     * Sets the value of the startYearMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartYearMonth(XMLGregorianCalendar value) {
        this.startYearMonth = value;
    }

    /**
     * Gets the value of the endYearMonth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndYearMonth() {
        return endYearMonth;
    }

    /**
     * Sets the value of the endYearMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndYearMonth(XMLGregorianCalendar value) {
        this.endYearMonth = value;
    }

}
