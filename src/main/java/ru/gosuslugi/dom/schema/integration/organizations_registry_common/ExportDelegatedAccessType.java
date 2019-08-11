
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Результат экспорта сведений о делегированных правах
 * 
 * <p>Java class for exportDelegatedAccessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportDelegatedAccessType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ParentOrg" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}orgPPAGUID"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrg"/&gt;
 *         &lt;element name="AccessRequest" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}AccessRequest" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportDelegatedAccessType", propOrder = {
    "parentOrg",
    "orgPPAGUID",
    "regOrg",
    "accessRequest"
})
public class ExportDelegatedAccessType {

    @XmlElement(name = "ParentOrg")
    protected RegOrgType parentOrg;
    @XmlElement(namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String orgPPAGUID;
    @XmlElement(name = "RegOrg", namespace = "http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/", required = true)
    protected RegOrgType regOrg;
    @XmlElement(name = "AccessRequest")
    protected List<AccessRequest> accessRequest;

    /**
     * Gets the value of the parentOrg property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getParentOrg() {
        return parentOrg;
    }

    /**
     * Sets the value of the parentOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setParentOrg(RegOrgType value) {
        this.parentOrg = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
    }

    /**
     * Gets the value of the regOrg property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getRegOrg() {
        return regOrg;
    }

    /**
     * Sets the value of the regOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setRegOrg(RegOrgType value) {
        this.regOrg = value;
    }

    /**
     * Gets the value of the accessRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessRequest }
     * 
     * 
     */
    public List<AccessRequest> getAccessRequest() {
        if (accessRequest == null) {
            accessRequest = new ArrayList<AccessRequest>();
        }
        return this.accessRequest;
    }

}
