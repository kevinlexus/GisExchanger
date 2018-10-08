
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Информация о регистрации в ЕРП
 * 
 * <p>Java class for URIInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="URIInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;element name="URIRegistrationPlanNumber"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                 &lt;minInclusive value="0"/&gt;
 *                 &lt;pattern value="\d{1,12}"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "URIInformationType", propOrder = {
    "shouldNotBeRegistered",
    "shouldBeRegistered",
    "uriRegistrationPlanNumber"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.inspection.ExportInspectionPlanResultType.InspectionPlan.class
})
public class URIInformationType {

    @XmlElement(name = "ShouldNotBeRegistered")
    protected Boolean shouldNotBeRegistered;
    @XmlElement(name = "ShouldBeRegistered")
    protected Boolean shouldBeRegistered;
    @XmlElement(name = "URIRegistrationPlanNumber")
    protected BigInteger uriRegistrationPlanNumber;

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
     * Gets the value of the uriRegistrationPlanNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getURIRegistrationPlanNumber() {
        return uriRegistrationPlanNumber;
    }

    /**
     * Sets the value of the uriRegistrationPlanNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setURIRegistrationPlanNumber(BigInteger value) {
        this.uriRegistrationPlanNumber = value;
    }

}
