
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


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
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="DelegatedAccessRight" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}TerritoryDelegatedAccessRightType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="IsNextPage" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "delegatedAccessRight",
    "isNextPage"
})
@XmlRootElement(name = "exportTerritoryDelegatedAccessResult")
public class ExportTerritoryDelegatedAccessResult
    extends BaseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "DelegatedAccessRight")
    protected List<TerritoryDelegatedAccessRightType> delegatedAccessRight;
    @XmlElement(name = "IsNextPage")
    protected Object isNextPage;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the delegatedAccessRight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delegatedAccessRight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelegatedAccessRight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerritoryDelegatedAccessRightType }
     * 
     * 
     */
    public List<TerritoryDelegatedAccessRightType> getDelegatedAccessRight() {
        if (delegatedAccessRight == null) {
            delegatedAccessRight = new ArrayList<TerritoryDelegatedAccessRightType>();
        }
        return this.delegatedAccessRight;
    }

    /**
     * Gets the value of the isNextPage property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIsNextPage() {
        return isNextPage;
    }

    /**
     * Sets the value of the isNextPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIsNextPage(Object value) {
        this.isNextPage = value;
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
            return "11.2.0.1";
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
