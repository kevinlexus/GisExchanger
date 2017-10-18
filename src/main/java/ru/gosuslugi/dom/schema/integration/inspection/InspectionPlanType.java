
package ru.gosuslugi.dom.schema.integration.inspection;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Основные реквизиты плана проверок.(экспорт)
 * 
 * <p>Java class for InspectionPlanType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InspectionPlanType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Year" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/>
 *         &lt;element name="Sign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;choice>
 *           &lt;element name="ShouldNotBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;sequence>
 *             &lt;element name="ShouldBeRegistered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *             &lt;element name="URIRegistrationPlanNumber">
 *               &lt;simpleType>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                   &lt;minInclusive value="0"/>
 *                   &lt;pattern value="\d{1,12}"/>
 *                 &lt;/restriction>
 *               &lt;/simpleType>
 *             &lt;/element>
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
@XmlType(name = "InspectionPlanType", propOrder = {
    "year",
    "sign",
    "shouldNotBeRegistered",
    "shouldBeRegistered",
    "uriRegistrationPlanNumber"
})
public class InspectionPlanType {

    @XmlElement(name = "Year")
    protected short year;
    @XmlElement(name = "Sign")
    protected boolean sign;
    @XmlElement(name = "ShouldNotBeRegistered")
    protected Boolean shouldNotBeRegistered;
    @XmlElement(name = "ShouldBeRegistered")
    protected Boolean shouldBeRegistered;
    @XmlElement(name = "URIRegistrationPlanNumber")
    protected BigInteger uriRegistrationPlanNumber;

    /**
     * Gets the value of the year property.
     * 
     */
    public short getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(short value) {
        this.year = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     */
    public boolean isSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     */
    public void setSign(boolean value) {
        this.sign = value;
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
