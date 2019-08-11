
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Протокол. Добавить сведения о передаче материалов по делу об административном правонарушении в суд.
 * 
 * <p>Java class for AddSubmittedInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddSubmittedInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CourtName" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
 *         &lt;element name="SubmittedDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/&gt;
 *         &lt;element name="SubmittedNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddSubmittedInformationType", propOrder = {
    "courtName",
    "submittedDate",
    "submittedNumber"
})
public class AddSubmittedInformationType {

    @XmlElement(name = "CourtName", required = true)
    protected String courtName;
    @XmlElement(name = "SubmittedDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar submittedDate;
    @XmlElement(name = "SubmittedNumber", required = true)
    protected String submittedNumber;

    /**
     * Gets the value of the courtName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * Sets the value of the courtName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourtName(String value) {
        this.courtName = value;
    }

    /**
     * Gets the value of the submittedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmittedDate() {
        return submittedDate;
    }

    /**
     * Sets the value of the submittedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmittedDate(XMLGregorianCalendar value) {
        this.submittedDate = value;
    }

    /**
     * Gets the value of the submittedNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmittedNumber() {
        return submittedNumber;
    }

    /**
     * Sets the value of the submittedNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmittedNumber(String value) {
        this.submittedNumber = value;
    }

}
