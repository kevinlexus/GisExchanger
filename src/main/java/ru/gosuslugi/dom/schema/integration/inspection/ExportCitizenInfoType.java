
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Сведения о физическом лице. (экспорт)
 * 
 * <p>Java class for ExportCitizenInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCitizenInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LastName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *         &lt;element name="FirstName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *         &lt;element name="MiddleName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *         &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCitizenInfoType", propOrder = {
    "lastName",
    "firstName",
    "middleName",
    "otherPersons"
})
public class ExportCitizenInfoType {

    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "MiddleName")
    protected String middleName;
    @XmlElement(name = "OtherPersons")
    protected String otherPersons;

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the otherPersons property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherPersons() {
        return otherPersons;
    }

    /**
     * Sets the value of the otherPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherPersons(String value) {
        this.otherPersons = value;
    }

}
