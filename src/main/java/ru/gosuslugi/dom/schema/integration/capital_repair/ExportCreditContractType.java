
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Экспортируемый кредитный договор/договор займа
 * 
 * <p>Java class for ExportCreditContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportCreditContractType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}CreditContractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Holder" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *         &lt;element name="RepaymentStatus" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}String50Type"/&gt;
 *         &lt;element name="TerminationInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}TerminationInfoType" minOccurs="0"/&gt;
 *         &lt;element name="Status"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Published"/&gt;
 *               &lt;enumeration value="Canceled"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CreditContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportCreditContractType", propOrder = {
    "holder",
    "repaymentStatus",
    "terminationInfo",
    "status",
    "creditContractGUID"
})
public class ExportCreditContractType
    extends CreditContractType
{

    @XmlElement(name = "Holder", required = true)
    protected RegOrgType holder;
    @XmlElement(name = "RepaymentStatus", required = true)
    protected String repaymentStatus;
    @XmlElement(name = "TerminationInfo")
    protected TerminationInfoType terminationInfo;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "CreditContractGUID", required = true)
    protected String creditContractGUID;

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setHolder(RegOrgType value) {
        this.holder = value;
    }

    /**
     * Gets the value of the repaymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentStatus() {
        return repaymentStatus;
    }

    /**
     * Sets the value of the repaymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentStatus(String value) {
        this.repaymentStatus = value;
    }

    /**
     * Gets the value of the terminationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TerminationInfoType }
     *     
     */
    public TerminationInfoType getTerminationInfo() {
        return terminationInfo;
    }

    /**
     * Sets the value of the terminationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminationInfoType }
     *     
     */
    public void setTerminationInfo(TerminationInfoType value) {
        this.terminationInfo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the creditContractGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditContractGUID() {
        return creditContractGUID;
    }

    /**
     * Sets the value of the creditContractGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditContractGUID(String value) {
        this.creditContractGUID = value;
    }

}
