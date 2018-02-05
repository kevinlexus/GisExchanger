
package ru.gosuslugi.dom.schema.integration.base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ISName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String255Type"/>
 *         &lt;element name="ISOperatorName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String255Type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isName",
    "isOperatorName"
})
@XmlRootElement(name = "ISCreator")
public class ISCreator {

    @XmlElement(name = "ISName", required = true)
    protected String isName;
    @XmlElement(name = "ISOperatorName", required = true)
    protected String isOperatorName;

    /**
     * Gets the value of the isName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISName() {
        return isName;
    }

    /**
     * Sets the value of the isName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISName(String value) {
        this.isName = value;
    }

    /**
     * Gets the value of the isOperatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOperatorName() {
        return isOperatorName;
    }

    /**
     * Sets the value of the isOperatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOperatorName(String value) {
        this.isOperatorName = value;
    }

}
