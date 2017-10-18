
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Статус размещения проверки в ЕРП
 * 
 * <p>Java class for exportExaminationURIStateResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportExaminationURIStateResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;choice>
 *           &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element name="URIRegistrationNumber" minOccurs="0">
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                   &lt;minInclusive value="0"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/element>
 *             &lt;element name="URIRegistrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *             &lt;element name="URIExaminationState">
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/inspection/}URIExaminationStateType">
 *                   &lt;enumeration value="Placed"/>
 *                   &lt;enumeration value="NotPlaced"/>
 *                   &lt;enumeration value="Sent"/>
 *                   &lt;enumeration value="NotSent"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/element>
 *             &lt;element name="ReceievedFromURI" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportExaminationURIStateResultType", propOrder = {
    "examinationGuid",
    "shouldNotBeRegistered",
    "shouldBeRegistered",
    "uriRegistrationNumber",
    "uriRegistrationDate",
    "uriExaminationState",
    "receievedFromURI"
})
public class ExportExaminationURIStateResultType {

    @XmlElement(name = "ExaminationGuid", required = true)
    protected String examinationGuid;
    @XmlElement(name = "ShouldNotBeRegistered")
    protected Boolean shouldNotBeRegistered;
    @XmlElement(name = "ShouldBeRegistered")
    protected Boolean shouldBeRegistered;
    @XmlElement(name = "URIRegistrationNumber")
    protected BigInteger uriRegistrationNumber;
    @XmlElement(name = "URIRegistrationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar uriRegistrationDate;
    @XmlElement(name = "URIExaminationState")
    protected URIExaminationStateType uriExaminationState;
    @XmlElement(name = "ReceievedFromURI")
    protected Boolean receievedFromURI;

    /**
     * Gets the value of the examinationGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExaminationGuid() {
        return examinationGuid;
    }

    /**
     * Sets the value of the examinationGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExaminationGuid(String value) {
        this.examinationGuid = value;
    }

    /**
     * Gets the value of the shouldNotBeRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShouldNotBeRegistered() {
        return shouldNotBeRegistered;
    }

    /**
     * Sets the value of the shouldNotBeRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShouldNotBeRegistered(Boolean value) {
        this.shouldNotBeRegistered = value;
    }

    /**
     * Gets the value of the shouldBeRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShouldBeRegistered() {
        return shouldBeRegistered;
    }

    /**
     * Sets the value of the shouldBeRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShouldBeRegistered(Boolean value) {
        this.shouldBeRegistered = value;
    }

    /**
     * Gets the value of the uriRegistrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getURIRegistrationNumber() {
        return uriRegistrationNumber;
    }

    /**
     * Sets the value of the uriRegistrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setURIRegistrationNumber(BigInteger value) {
        this.uriRegistrationNumber = value;
    }

    /**
     * Gets the value of the uriRegistrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getURIRegistrationDate() {
        return uriRegistrationDate;
    }

    /**
     * Sets the value of the uriRegistrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setURIRegistrationDate(XMLGregorianCalendar value) {
        this.uriRegistrationDate = value;
    }

    /**
     * Gets the value of the uriExaminationState property.
     * 
     * @return
     *     possible object is
     *     {@link URIExaminationStateType }
     *     
     */
    public URIExaminationStateType getURIExaminationState() {
        return uriExaminationState;
    }

    /**
     * Sets the value of the uriExaminationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link URIExaminationStateType }
     *     
     */
    public void setURIExaminationState(URIExaminationStateType value) {
        this.uriExaminationState = value;
    }

    /**
     * Gets the value of the receievedFromURI property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReceievedFromURI() {
        return receievedFromURI;
    }

    /**
     * Sets the value of the receievedFromURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReceievedFromURI(Boolean value) {
        this.receievedFromURI = value;
    }

}
