
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Cведения об исполнении протокола
 * 
 * <p>Java class for FulfileOffenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FulfileOffenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActualFulfiledOffenceDate" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}LimitedDateType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FulfileOffenceType", propOrder = {
    "actualFulfiledOffenceDate"
})
public class FulfileOffenceType {

    @XmlElement(name = "ActualFulfiledOffenceDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actualFulfiledOffenceDate;

    /**
     * Gets the value of the actualFulfiledOffenceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualFulfiledOffenceDate() {
        return actualFulfiledOffenceDate;
    }

    /**
     * Sets the value of the actualFulfiledOffenceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualFulfiledOffenceDate(XMLGregorianCalendar value) {
        this.actualFulfiledOffenceDate = value;
    }

}
