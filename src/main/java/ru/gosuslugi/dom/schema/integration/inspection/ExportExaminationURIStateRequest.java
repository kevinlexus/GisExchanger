
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="ExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/&gt;
 *         &lt;element name="URIRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="1000"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.1.0.8""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "examinationGuid",
    "uriRegistrationNumber"
})
@XmlRootElement(name = "exportExaminationURIStateRequest")
public class ExportExaminationURIStateRequest
    extends BaseType
{

    @XmlElement(name = "ExaminationGuid")
    protected List<String> examinationGuid;
    @XmlElement(name = "URIRegistrationNumber")
    protected List<String> uriRegistrationNumber;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the examinationGuid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the examinationGuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExaminationGuid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExaminationGuid() {
        if (examinationGuid == null) {
            examinationGuid = new ArrayList<String>();
        }
        return this.examinationGuid;
    }

    /**
     * Gets the value of the uriRegistrationNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uriRegistrationNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getURIRegistrationNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getURIRegistrationNumber() {
        if (uriRegistrationNumber == null) {
            uriRegistrationNumber = new ArrayList<String>();
        }
        return this.uriRegistrationNumber;
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
            return "11.1.0.8";
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
