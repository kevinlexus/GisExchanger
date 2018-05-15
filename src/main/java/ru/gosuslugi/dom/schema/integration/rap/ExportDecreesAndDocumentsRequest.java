
package ru.gosuslugi.dom.schema.integration.rap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;element name="DecreeGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/>
 *         &lt;sequence>
 *           &lt;element name="ProceedingDateFrom" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;element name="ProceedingDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.10.0.2""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "decreeGUID",
    "proceedingDateFrom",
    "proceedingDateTo"
})
@XmlRootElement(name = "ExportDecreesAndDocumentsRequest")
public class ExportDecreesAndDocumentsRequest
    extends BaseType
{

    @XmlElement(name = "DecreeGUID")
    protected List<String> decreeGUID;
    @XmlElement(name = "ProceedingDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar proceedingDateFrom;
    @XmlElement(name = "ProceedingDateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar proceedingDateTo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the decreeGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decreeGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecreeGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDecreeGUID() {
        if (decreeGUID == null) {
            decreeGUID = new ArrayList<String>();
        }
        return this.decreeGUID;
    }

    /**
     * Gets the value of the proceedingDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProceedingDateFrom() {
        return proceedingDateFrom;
    }

    /**
     * Sets the value of the proceedingDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProceedingDateFrom(XMLGregorianCalendar value) {
        this.proceedingDateFrom = value;
    }

    /**
     * Gets the value of the proceedingDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProceedingDateTo() {
        return proceedingDateTo;
    }

    /**
     * Sets the value of the proceedingDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProceedingDateTo(XMLGregorianCalendar value) {
        this.proceedingDateTo = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "11.10.0.2";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
