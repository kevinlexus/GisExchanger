
package ru.gosuslugi.dom.schema.integration.volume_quality;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Составной тип. Информация о перерывах
 * 
 * <p>Java class for IntervalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntervalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StartDateAndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndDateAndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="MunicipalService" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="RatedResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="IntervalReason"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}String1000Type"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AddressObject" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}AddressObjectType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalType", propOrder = {
    "startDateAndTime",
    "endDateAndTime",
    "municipalService",
    "ratedResource",
    "intervalReason",
    "addressObject"
})
public class IntervalType {

    @XmlElement(name = "StartDateAndTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDateAndTime;
    @XmlElement(name = "EndDateAndTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDateAndTime;
    @XmlElement(name = "MunicipalService", required = true)
    protected NsiRef municipalService;
    @XmlElement(name = "RatedResource")
    protected NsiRef ratedResource;
    @XmlElement(name = "IntervalReason", required = true)
    protected String intervalReason;
    @XmlElement(name = "AddressObject")
    protected List<IntervalType.AddressObject> addressObject;

    /**
     * Gets the value of the startDateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDateAndTime() {
        return startDateAndTime;
    }

    /**
     * Sets the value of the startDateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDateAndTime(XMLGregorianCalendar value) {
        this.startDateAndTime = value;
    }

    /**
     * Gets the value of the endDateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDateAndTime() {
        return endDateAndTime;
    }

    /**
     * Sets the value of the endDateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDateAndTime(XMLGregorianCalendar value) {
        this.endDateAndTime = value;
    }

    /**
     * Gets the value of the municipalService property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMunicipalService() {
        return municipalService;
    }

    /**
     * Sets the value of the municipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMunicipalService(NsiRef value) {
        this.municipalService = value;
    }

    /**
     * Gets the value of the ratedResource property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getRatedResource() {
        return ratedResource;
    }

    /**
     * Sets the value of the ratedResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setRatedResource(NsiRef value) {
        this.ratedResource = value;
    }

    /**
     * Gets the value of the intervalReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervalReason() {
        return intervalReason;
    }

    /**
     * Sets the value of the intervalReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervalReason(String value) {
        this.intervalReason = value;
    }

    /**
     * Gets the value of the addressObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntervalType.AddressObject }
     * 
     * 
     */
    public List<IntervalType.AddressObject> getAddressObject() {
        if (addressObject == null) {
            addressObject = new ArrayList<IntervalType.AddressObject>();
        }
        return this.addressObject;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}AddressObjectType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="NotFromContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "notFromContract"
    })
    public static class AddressObject
        extends AddressObjectType
    {

        @XmlElement(name = "NotFromContract")
        protected Boolean notFromContract;

        /**
         * Gets the value of the notFromContract property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNotFromContract() {
            return notFromContract;
        }

        /**
         * Sets the value of the notFromContract property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNotFromContract(Boolean value) {
            this.notFromContract = value;
        }

    }

}
