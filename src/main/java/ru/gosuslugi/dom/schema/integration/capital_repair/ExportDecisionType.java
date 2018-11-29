
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 *  Экспортируемое решение о выборе способа формирования фонда капитального ремонта
 * 
 * <p>Java class for exportDecisionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportDecisionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DecisionGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusType"/&gt;
 *         &lt;element name="AccountSpecialGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="DecisionsOrganization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportDecisionType", propOrder = {
    "decisionGuid",
    "status",
    "accountSpecialGuid",
    "decisionsOrganization"
})
public class ExportDecisionType
    extends DecisionType
{

    @XmlElement(name = "DecisionGuid", required = true)
    protected String decisionGuid;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusType status;
    @XmlElement(name = "AccountSpecialGuid")
    protected String accountSpecialGuid;
    @XmlElement(name = "DecisionsOrganization")
    protected RegOrgType decisionsOrganization;

    /**
     * Gets the value of the decisionGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionGuid() {
        return decisionGuid;
    }

    /**
     * Sets the value of the decisionGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionGuid(String value) {
        this.decisionGuid = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the accountSpecialGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountSpecialGuid() {
        return accountSpecialGuid;
    }

    /**
     * Sets the value of the accountSpecialGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountSpecialGuid(String value) {
        this.accountSpecialGuid = value;
    }

    /**
     * Gets the value of the decisionsOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getDecisionsOrganization() {
        return decisionsOrganization;
    }

    /**
     * Sets the value of the decisionsOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setDecisionsOrganization(RegOrgType value) {
        this.decisionsOrganization = value;
    }

}
