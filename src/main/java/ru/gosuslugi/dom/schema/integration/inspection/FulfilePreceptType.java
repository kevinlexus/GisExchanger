
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Cведения об исполнении предписания
 * 
 * <p>Java class for FulfilePreceptType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FulfilePreceptType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActualFulfiledPreceptDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FulfilePreceptType", propOrder = {
    "actualFulfiledPreceptDate"
})
public class FulfilePreceptType {

    @XmlElement(name = "ActualFulfiledPreceptDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actualFulfiledPreceptDate;

    /**
     * Gets the value of the actualFulfiledPreceptDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualFulfiledPreceptDate() {
        return actualFulfiledPreceptDate;
    }

    /**
     * Sets the value of the actualFulfiledPreceptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualFulfiledPreceptDate(XMLGregorianCalendar value) {
        this.actualFulfiledPreceptDate = value;
    }

}
