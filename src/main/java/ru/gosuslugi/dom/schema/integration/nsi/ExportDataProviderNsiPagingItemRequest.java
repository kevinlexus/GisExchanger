
package ru.gosuslugi.dom.schema.integration.nsi;

import java.math.BigInteger;
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
 *       &lt;sequence>
 *         &lt;element name="RegistryNumber">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemRegistryNumberType">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="51"/>
 *               &lt;enumeration value="59"/>
 *               &lt;enumeration value="219"/>
 *               &lt;enumeration value="302"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Page">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ModifiedAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.1.0.5""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registryNumber",
    "page",
    "modifiedAfter"
})
@XmlRootElement(name = "exportDataProviderNsiPagingItemRequest")
public class ExportDataProviderNsiPagingItemRequest
    extends BaseType
{

    @XmlElement(name = "RegistryNumber", required = true)
    protected BigInteger registryNumber;
    @XmlElement(name = "Page")
    protected int page;
    @XmlElement(name = "ModifiedAfter")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifiedAfter;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the registryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRegistryNumber() {
        return registryNumber;
    }

    /**
     * Sets the value of the registryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRegistryNumber(BigInteger value) {
        this.registryNumber = value;
    }

    /**
     * Gets the value of the page property.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Gets the value of the modifiedAfter property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifiedAfter() {
        return modifiedAfter;
    }

    /**
     * Sets the value of the modifiedAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifiedAfter(XMLGregorianCalendar value) {
        this.modifiedAfter = value;
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
            return "11.1.0.5";
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
