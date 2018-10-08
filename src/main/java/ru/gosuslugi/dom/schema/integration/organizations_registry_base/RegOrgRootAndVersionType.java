
package ru.gosuslugi.dom.schema.integration.organizations_registry_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Организация и версия организации в реестре организаций
 * 
 * <p>Java class for RegOrgRootAndVersionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegOrgRootAndVersionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgVersionGUID"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}orgRootEntityGUID"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegOrgRootAndVersionType", propOrder = {
    "orgVersionGUID",
    "orgRootEntityGUID"
})
public class RegOrgRootAndVersionType {

    protected String orgVersionGUID;
    protected String orgRootEntityGUID;

    /**
     * Gets the value of the orgVersionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgVersionGUID() {
        return orgVersionGUID;
    }

    /**
     * Sets the value of the orgVersionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgVersionGUID(String value) {
        this.orgVersionGUID = value;
    }

    /**
     * Gets the value of the orgRootEntityGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRootEntityGUID() {
        return orgRootEntityGUID;
    }

    /**
     * Sets the value of the orgRootEntityGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRootEntityGUID(String value) {
        this.orgRootEntityGUID = value;
    }

}
