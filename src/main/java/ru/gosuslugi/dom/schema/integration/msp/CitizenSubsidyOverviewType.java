
package ru.gosuslugi.dom.schema.integration.msp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Общие сведения о гражданине, получающем субсидии 
 * 
 * <p>Java class for CitizenSubsidyOverviewType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitizenSubsidyOverviewType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/msp/}MSPIndType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Address" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *         &lt;element name="ApartmentNumber" type="{http://dom.gosuslugi.ru/schema/integration/msp/}String36Type" minOccurs="0"/&gt;
 *         &lt;element name="FlatNumber" type="{http://dom.gosuslugi.ru/schema/integration/msp/}String36Type" minOccurs="0"/&gt;
 *         &lt;element name="RegistrationType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *               &lt;enumeration value="Permanent"/&gt;
 *               &lt;enumeration value="Temporary"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Decision" type="{http://dom.gosuslugi.ru/schema/integration/msp/}DecisionType" maxOccurs="1000" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitizenSubsidyOverviewType", propOrder = {
    "address",
    "apartmentNumber",
    "flatNumber",
    "registrationType",
    "fromDate",
    "toDate",
    "decision"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.msp.ExportCitizenSubsidyType.Overview.class
})
public class CitizenSubsidyOverviewType
    extends MSPIndType
{

    @XmlElement(name = "Address", required = true)
    protected String address;
    @XmlElement(name = "ApartmentNumber")
    protected String apartmentNumber;
    @XmlElement(name = "FlatNumber")
    protected String flatNumber;
    @XmlElement(name = "RegistrationType", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String registrationType;
    @XmlElement(name = "FromDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fromDate;
    @XmlElement(name = "ToDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDate;
    @XmlElement(name = "Decision")
    protected List<DecisionType> decision;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the apartmentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets the value of the apartmentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApartmentNumber(String value) {
        this.apartmentNumber = value;
    }

    /**
     * Gets the value of the flatNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlatNumber() {
        return flatNumber;
    }

    /**
     * Sets the value of the flatNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlatNumber(String value) {
        this.flatNumber = value;
    }

    /**
     * Gets the value of the registrationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrationType() {
        return registrationType;
    }

    /**
     * Sets the value of the registrationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationType(String value) {
        this.registrationType = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the decision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DecisionType }
     * 
     * 
     */
    public List<DecisionType> getDecision() {
        if (decision == null) {
            decision = new ArrayList<DecisionType>();
        }
        return this.decision;
    }

}
