
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="RegionalProgramGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="FilterByEndYearMonth" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StartPeriodYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *                   &lt;element name="EndPeriodYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FilterByTerritory" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="1000"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FilterByWorkType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WorkType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FilterByHouseAddress" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FiasHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" maxOccurs="1000"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/>
 *       &lt;attribute name="Offset" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Limit" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;maxInclusive value="1000"/>
 *             &lt;minExclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regionalProgramGUID",
    "filterByEndYearMonth",
    "filterByTerritory",
    "filterByWorkType",
    "filterByHouseAddress"
})
@XmlRootElement(name = "exportRegionalProgramWorkRequest")
public class ExportRegionalProgramWorkRequest
    extends BaseType
{

    @XmlElement(name = "RegionalProgramGUID", required = true)
    protected String regionalProgramGUID;
    @XmlElement(name = "FilterByEndYearMonth")
    protected ExportRegionalProgramWorkRequest.FilterByEndYearMonth filterByEndYearMonth;
    @XmlElement(name = "FilterByTerritory")
    protected ExportRegionalProgramWorkRequest.FilterByTerritory filterByTerritory;
    @XmlElement(name = "FilterByWorkType")
    protected ExportRegionalProgramWorkRequest.FilterByWorkType filterByWorkType;
    @XmlElement(name = "FilterByHouseAddress")
    protected ExportRegionalProgramWorkRequest.FilterByHouseAddress filterByHouseAddress;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;
    @XmlAttribute(name = "Offset", required = true)
    protected int offset;
    @XmlAttribute(name = "Limit", required = true)
    protected int limit;

    /**
     * Gets the value of the regionalProgramGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalProgramGUID() {
        return regionalProgramGUID;
    }

    /**
     * Sets the value of the regionalProgramGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalProgramGUID(String value) {
        this.regionalProgramGUID = value;
    }

    /**
     * Gets the value of the filterByEndYearMonth property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByEndYearMonth }
     *     
     */
    public ExportRegionalProgramWorkRequest.FilterByEndYearMonth getFilterByEndYearMonth() {
        return filterByEndYearMonth;
    }

    /**
     * Sets the value of the filterByEndYearMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByEndYearMonth }
     *     
     */
    public void setFilterByEndYearMonth(ExportRegionalProgramWorkRequest.FilterByEndYearMonth value) {
        this.filterByEndYearMonth = value;
    }

    /**
     * Gets the value of the filterByTerritory property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByTerritory }
     *     
     */
    public ExportRegionalProgramWorkRequest.FilterByTerritory getFilterByTerritory() {
        return filterByTerritory;
    }

    /**
     * Sets the value of the filterByTerritory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByTerritory }
     *     
     */
    public void setFilterByTerritory(ExportRegionalProgramWorkRequest.FilterByTerritory value) {
        this.filterByTerritory = value;
    }

    /**
     * Gets the value of the filterByWorkType property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByWorkType }
     *     
     */
    public ExportRegionalProgramWorkRequest.FilterByWorkType getFilterByWorkType() {
        return filterByWorkType;
    }

    /**
     * Sets the value of the filterByWorkType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByWorkType }
     *     
     */
    public void setFilterByWorkType(ExportRegionalProgramWorkRequest.FilterByWorkType value) {
        this.filterByWorkType = value;
    }

    /**
     * Gets the value of the filterByHouseAddress property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByHouseAddress }
     *     
     */
    public ExportRegionalProgramWorkRequest.FilterByHouseAddress getFilterByHouseAddress() {
        return filterByHouseAddress;
    }

    /**
     * Sets the value of the filterByHouseAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRegionalProgramWorkRequest.FilterByHouseAddress }
     *     
     */
    public void setFilterByHouseAddress(ExportRegionalProgramWorkRequest.FilterByHouseAddress value) {
        this.filterByHouseAddress = value;
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

    /**
     * Gets the value of the offset property.
     * 
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     */
    public void setOffset(int value) {
        this.offset = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     */
    public void setLimit(int value) {
        this.limit = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="StartPeriodYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
     *         &lt;element name="EndPeriodYearMonth" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "startPeriodYearMonth",
        "endPeriodYearMonth"
    })
    public static class FilterByEndYearMonth {

        @XmlElement(name = "StartPeriodYearMonth", required = true)
        @XmlSchemaType(name = "gYearMonth")
        protected XMLGregorianCalendar startPeriodYearMonth;
        @XmlElement(name = "EndPeriodYearMonth", required = true)
        @XmlSchemaType(name = "gYearMonth")
        protected XMLGregorianCalendar endPeriodYearMonth;

        /**
         * Gets the value of the startPeriodYearMonth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartPeriodYearMonth() {
            return startPeriodYearMonth;
        }

        /**
         * Sets the value of the startPeriodYearMonth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartPeriodYearMonth(XMLGregorianCalendar value) {
            this.startPeriodYearMonth = value;
        }

        /**
         * Gets the value of the endPeriodYearMonth property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndPeriodYearMonth() {
            return endPeriodYearMonth;
        }

        /**
         * Sets the value of the endPeriodYearMonth property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndPeriodYearMonth(XMLGregorianCalendar value) {
            this.endPeriodYearMonth = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="FiasHouseGUID" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType" maxOccurs="1000"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fiasHouseGUID"
    })
    public static class FilterByHouseAddress {

        @XmlElement(name = "FiasHouseGUID", required = true)
        protected List<String> fiasHouseGUID;

        /**
         * Gets the value of the fiasHouseGUID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fiasHouseGUID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFiasHouseGUID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFiasHouseGUID() {
            if (fiasHouseGUID == null) {
                fiasHouseGUID = new ArrayList<String>();
            }
            return this.fiasHouseGUID;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="1000"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "oktmo"
    })
    public static class FilterByTerritory {

        @XmlElement(name = "OKTMO", required = true)
        protected List<OKTMORefType> oktmo;

        /**
         * Gets the value of the oktmo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oktmo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOKTMO().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OKTMORefType }
         * 
         * 
         */
        public List<OKTMORefType> getOKTMO() {
            if (oktmo == null) {
                oktmo = new ArrayList<OKTMORefType>();
            }
            return this.oktmo;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="WorkType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="1000"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "workType"
    })
    public static class FilterByWorkType {

        @XmlElement(name = "WorkType", required = true)
        protected List<NsiRef> workType;

        /**
         * Gets the value of the workType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the workType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWorkType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getWorkType() {
            if (workType == null) {
                workType = new ArrayList<NsiRef>();
            }
            return this.workType;
        }

    }

}
