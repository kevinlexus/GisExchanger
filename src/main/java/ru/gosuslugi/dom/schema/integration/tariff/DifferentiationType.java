
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Критерии дифференциации тарифов
 * 
 * <p>Java class for DifferentiationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DifferentiationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DifferentiationCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="Operator3"&gt;
 *               &lt;simpleType&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                   &lt;enumeration value="Range"/&gt;
 *                   &lt;enumeration value="ExcludingRange"/&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/simpleType&gt;
 *             &lt;/element&gt;
 *             &lt;element name="ValueEnumeration" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueEnumerationType" maxOccurs="1000"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;choice&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="Operator1"&gt;
 *                 &lt;simpleType&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                     &lt;enumeration value="Equal"/&gt;
 *                     &lt;enumeration value="More"/&gt;
 *                     &lt;enumeration value="NotMore"/&gt;
 *                     &lt;enumeration value="Less"/&gt;
 *                     &lt;enumeration value="NotLess"/&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/simpleType&gt;
 *               &lt;/element&gt;
 *               &lt;choice&gt;
 *                 &lt;element name="ValueDate" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueDateType"/&gt;
 *                 &lt;element name="ValueYear" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueYearType"/&gt;
 *                 &lt;element name="ValueInteger" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueIntegerType"/&gt;
 *                 &lt;element name="ValueReal" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueRealType"/&gt;
 *               &lt;/choice&gt;
 *             &lt;/sequence&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="Operator2"&gt;
 *                 &lt;simpleType&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                     &lt;enumeration value="Range"/&gt;
 *                     &lt;enumeration value="ExcludingRange"/&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/simpleType&gt;
 *               &lt;/element&gt;
 *               &lt;choice&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ValueDate1" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueDateType"/&gt;
 *                   &lt;element name="ValueDate2" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueDateType"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ValueYear1" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueYearType"/&gt;
 *                   &lt;element name="ValueYear2" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueYearType"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ValueInteger1" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueIntegerType"/&gt;
 *                   &lt;element name="ValueInteger2" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueIntegerType"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ValueReal1" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueRealType"/&gt;
 *                   &lt;element name="ValueReal2" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueRealType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/choice&gt;
 *             &lt;/sequence&gt;
 *           &lt;/choice&gt;
 *           &lt;element name="ValueString" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueStringType"/&gt;
 *           &lt;element name="ValueBoolean" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueBooleanType"/&gt;
 *           &lt;element name="ValueMultiline" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueMultilineType"/&gt;
 *           &lt;element name="ValueFIAS" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueFIASType" maxOccurs="1000"/&gt;
 *           &lt;element name="ValueOKTMO" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ValueOKTMOType" maxOccurs="1000"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DifferentiationType", propOrder = {
    "differentiationCode",
    "operator3",
    "valueEnumeration",
    "operator1",
    "valueDate",
    "valueYear",
    "valueInteger",
    "valueReal",
    "operator2",
    "valueDate1",
    "valueDate2",
    "valueYear1",
    "valueYear2",
    "valueInteger1",
    "valueInteger2",
    "valueReal1",
    "valueReal2",
    "valueString",
    "valueBoolean",
    "valueMultiline",
    "valueFIAS",
    "valueOKTMO"
})
public class DifferentiationType {

    @XmlElement(name = "DifferentiationCode", required = true)
    protected BigInteger differentiationCode;
    @XmlElement(name = "Operator3")
    protected String operator3;
    @XmlElement(name = "ValueEnumeration")
    protected List<ValueEnumerationType> valueEnumeration;
    @XmlElement(name = "Operator1")
    protected String operator1;
    @XmlElement(name = "ValueDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar valueDate;
    @XmlElement(name = "ValueYear")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar valueYear;
    @XmlElement(name = "ValueInteger")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger valueInteger;
    @XmlElement(name = "ValueReal")
    protected BigDecimal valueReal;
    @XmlElement(name = "Operator2")
    protected String operator2;
    @XmlElement(name = "ValueDate1")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar valueDate1;
    @XmlElement(name = "ValueDate2")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar valueDate2;
    @XmlElement(name = "ValueYear1")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar valueYear1;
    @XmlElement(name = "ValueYear2")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar valueYear2;
    @XmlElement(name = "ValueInteger1")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger valueInteger1;
    @XmlElement(name = "ValueInteger2")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger valueInteger2;
    @XmlElement(name = "ValueReal1")
    protected BigDecimal valueReal1;
    @XmlElement(name = "ValueReal2")
    protected BigDecimal valueReal2;
    @XmlElement(name = "ValueString")
    protected String valueString;
    @XmlElement(name = "ValueBoolean")
    protected Boolean valueBoolean;
    @XmlElement(name = "ValueMultiline")
    protected ValueMultilineType valueMultiline;
    @XmlElement(name = "ValueFIAS")
    protected List<String> valueFIAS;
    @XmlElement(name = "ValueOKTMO")
    protected List<ValueOKTMOType> valueOKTMO;

    /**
     * Gets the value of the differentiationCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDifferentiationCode() {
        return differentiationCode;
    }

    /**
     * Sets the value of the differentiationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDifferentiationCode(BigInteger value) {
        this.differentiationCode = value;
    }

    /**
     * Gets the value of the operator3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator3() {
        return operator3;
    }

    /**
     * Sets the value of the operator3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator3(String value) {
        this.operator3 = value;
    }

    /**
     * Gets the value of the valueEnumeration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueEnumeration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueEnumeration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueEnumerationType }
     * 
     * 
     */
    public List<ValueEnumerationType> getValueEnumeration() {
        if (valueEnumeration == null) {
            valueEnumeration = new ArrayList<ValueEnumerationType>();
        }
        return this.valueEnumeration;
    }

    /**
     * Gets the value of the operator1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator1() {
        return operator1;
    }

    /**
     * Sets the value of the operator1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator1(String value) {
        this.operator1 = value;
    }

    /**
     * Gets the value of the valueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueDate() {
        return valueDate;
    }

    /**
     * Sets the value of the valueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueDate(XMLGregorianCalendar value) {
        this.valueDate = value;
    }

    /**
     * Gets the value of the valueYear property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueYear() {
        return valueYear;
    }

    /**
     * Sets the value of the valueYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueYear(XMLGregorianCalendar value) {
        this.valueYear = value;
    }

    /**
     * Gets the value of the valueInteger property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueInteger() {
        return valueInteger;
    }

    /**
     * Sets the value of the valueInteger property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueInteger(BigInteger value) {
        this.valueInteger = value;
    }

    /**
     * Gets the value of the valueReal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValueReal() {
        return valueReal;
    }

    /**
     * Sets the value of the valueReal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValueReal(BigDecimal value) {
        this.valueReal = value;
    }

    /**
     * Gets the value of the operator2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator2() {
        return operator2;
    }

    /**
     * Sets the value of the operator2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator2(String value) {
        this.operator2 = value;
    }

    /**
     * Gets the value of the valueDate1 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueDate1() {
        return valueDate1;
    }

    /**
     * Sets the value of the valueDate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueDate1(XMLGregorianCalendar value) {
        this.valueDate1 = value;
    }

    /**
     * Gets the value of the valueDate2 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueDate2() {
        return valueDate2;
    }

    /**
     * Sets the value of the valueDate2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueDate2(XMLGregorianCalendar value) {
        this.valueDate2 = value;
    }

    /**
     * Gets the value of the valueYear1 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueYear1() {
        return valueYear1;
    }

    /**
     * Sets the value of the valueYear1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueYear1(XMLGregorianCalendar value) {
        this.valueYear1 = value;
    }

    /**
     * Gets the value of the valueYear2 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValueYear2() {
        return valueYear2;
    }

    /**
     * Sets the value of the valueYear2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValueYear2(XMLGregorianCalendar value) {
        this.valueYear2 = value;
    }

    /**
     * Gets the value of the valueInteger1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueInteger1() {
        return valueInteger1;
    }

    /**
     * Sets the value of the valueInteger1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueInteger1(BigInteger value) {
        this.valueInteger1 = value;
    }

    /**
     * Gets the value of the valueInteger2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getValueInteger2() {
        return valueInteger2;
    }

    /**
     * Sets the value of the valueInteger2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setValueInteger2(BigInteger value) {
        this.valueInteger2 = value;
    }

    /**
     * Gets the value of the valueReal1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValueReal1() {
        return valueReal1;
    }

    /**
     * Sets the value of the valueReal1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValueReal1(BigDecimal value) {
        this.valueReal1 = value;
    }

    /**
     * Gets the value of the valueReal2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValueReal2() {
        return valueReal2;
    }

    /**
     * Sets the value of the valueReal2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValueReal2(BigDecimal value) {
        this.valueReal2 = value;
    }

    /**
     * Gets the value of the valueString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueString() {
        return valueString;
    }

    /**
     * Sets the value of the valueString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueString(String value) {
        this.valueString = value;
    }

    /**
     * Gets the value of the valueBoolean property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValueBoolean() {
        return valueBoolean;
    }

    /**
     * Sets the value of the valueBoolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValueBoolean(Boolean value) {
        this.valueBoolean = value;
    }

    /**
     * Gets the value of the valueMultiline property.
     * 
     * @return
     *     possible object is
     *     {@link ValueMultilineType }
     *     
     */
    public ValueMultilineType getValueMultiline() {
        return valueMultiline;
    }

    /**
     * Sets the value of the valueMultiline property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueMultilineType }
     *     
     */
    public void setValueMultiline(ValueMultilineType value) {
        this.valueMultiline = value;
    }

    /**
     * Gets the value of the valueFIAS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueFIAS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueFIAS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getValueFIAS() {
        if (valueFIAS == null) {
            valueFIAS = new ArrayList<String>();
        }
        return this.valueFIAS;
    }

    /**
     * Gets the value of the valueOKTMO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueOKTMO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueOKTMO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueOKTMOType }
     * 
     * 
     */
    public List<ValueOKTMOType> getValueOKTMO() {
        if (valueOKTMO == null) {
            valueOKTMO = new ArrayList<ValueOKTMOType>();
        }
        return this.valueOKTMO;
    }

}
