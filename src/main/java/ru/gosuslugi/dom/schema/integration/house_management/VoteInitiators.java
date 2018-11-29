
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgRootAndVersionType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}VotingInitiatorIndType"/&gt;
 *         &lt;element name="Org" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgRootAndVersionType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ind",
    "org"
})
@XmlRootElement(name = "VoteInitiators")
public class VoteInitiators {

    @XmlElement(name = "Ind")
    protected VotingInitiatorIndType ind;
    @XmlElement(name = "Org")
    protected RegOrgRootAndVersionType org;

    /**
     * Gets the value of the ind property.
     * 
     * @return
     *     possible object is
     *     {@link VotingInitiatorIndType }
     *     
     */
    public VotingInitiatorIndType getInd() {
        return ind;
    }

    /**
     * Sets the value of the ind property.
     * 
     * @param value
     *     allowed object is
     *     {@link VotingInitiatorIndType }
     *     
     */
    public void setInd(VotingInitiatorIndType value) {
        this.ind = value;
    }

    /**
     * Gets the value of the org property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgRootAndVersionType }
     *     
     */
    public RegOrgRootAndVersionType getOrg() {
        return org;
    }

    /**
     * Sets the value of the org property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgRootAndVersionType }
     *     
     */
    public void setOrg(RegOrgRootAndVersionType value) {
        this.org = value;
    }

}
