
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *         &lt;element name="ImportResult" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}CapRemCommonResultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportFullContractType" maxOccurs="1000"/&gt;
 *         &lt;element name="Account" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportAccountType" maxOccurs="1000"/&gt;
 *         &lt;element name="Decision" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportDecisionType" maxOccurs="1000"/&gt;
 *         &lt;element name="CreditContract" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportCreditContractType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="FundSizeInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}exportFundSizeInfoType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="Plan" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportPlanPassportType" maxOccurs="1000"/&gt;
 *         &lt;element name="PlanWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportWorkPlanType" maxOccurs="1000"/&gt;
 *         &lt;element name="RegionalProgram" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportRegionalProgramType" maxOccurs="1000"/&gt;
 *         &lt;element name="RegionalProgramWork" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportRegionalProgramWorkType" maxOccurs="1000"/&gt;
 *         &lt;element name="DecisionPD" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportDecisionPDType" maxOccurs="1000"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/&gt;
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
    "importResult",
    "contract",
    "account",
    "decision",
    "creditContract",
    "fundSizeInfo",
    "plan",
    "planWork",
    "regionalProgram",
    "regionalProgramWork",
    "decisionPD"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<CapRemCommonResultType> importResult;
    @XmlElement(name = "Contract")
    protected List<ExportFullContractType> contract;
    @XmlElement(name = "Account")
    protected List<ExportAccountType> account;
    @XmlElement(name = "Decision")
    protected List<ExportDecisionType> decision;
    @XmlElement(name = "CreditContract")
    protected List<ExportCreditContractType> creditContract;
    @XmlElement(name = "FundSizeInfo")
    protected List<ExportFundSizeInfoType> fundSizeInfo;
    @XmlElement(name = "Plan")
    protected List<ExportPlanPassportType> plan;
    @XmlElement(name = "PlanWork")
    protected List<ExportWorkPlanType> planWork;
    @XmlElement(name = "RegionalProgram")
    protected List<ExportRegionalProgramType> regionalProgram;
    @XmlElement(name = "RegionalProgramWork")
    protected List<ExportRegionalProgramWorkType> regionalProgramWork;
    @XmlElement(name = "DecisionPD")
    protected List<ExportDecisionPDType> decisionPD;
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
     * Gets the value of the importResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapRemCommonResultType }
     * 
     * 
     */
    public List<CapRemCommonResultType> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<CapRemCommonResultType>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportFullContractType }
     * 
     * 
     */
    public List<ExportFullContractType> getContract() {
        if (contract == null) {
            contract = new ArrayList<ExportFullContractType>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountType }
     * 
     * 
     */
    public List<ExportAccountType> getAccount() {
        if (account == null) {
            account = new ArrayList<ExportAccountType>();
        }
        return this.account;
    }

    /**
     * Gets the value of the decision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDecisionType }
     * 
     * 
     */
    public List<ExportDecisionType> getDecision() {
        if (decision == null) {
            decision = new ArrayList<ExportDecisionType>();
        }
        return this.decision;
    }

    /**
     * Gets the value of the creditContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCreditContractType }
     * 
     * 
     */
    public List<ExportCreditContractType> getCreditContract() {
        if (creditContract == null) {
            creditContract = new ArrayList<ExportCreditContractType>();
        }
        return this.creditContract;
    }

    /**
     * Gets the value of the fundSizeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundSizeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundSizeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportFundSizeInfoType }
     * 
     * 
     */
    public List<ExportFundSizeInfoType> getFundSizeInfo() {
        if (fundSizeInfo == null) {
            fundSizeInfo = new ArrayList<ExportFundSizeInfoType>();
        }
        return this.fundSizeInfo;
    }

    /**
     * Gets the value of the plan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportPlanPassportType }
     * 
     * 
     */
    public List<ExportPlanPassportType> getPlan() {
        if (plan == null) {
            plan = new ArrayList<ExportPlanPassportType>();
        }
        return this.plan;
    }

    /**
     * Gets the value of the planWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportWorkPlanType }
     * 
     * 
     */
    public List<ExportWorkPlanType> getPlanWork() {
        if (planWork == null) {
            planWork = new ArrayList<ExportWorkPlanType>();
        }
        return this.planWork;
    }

    /**
     * Gets the value of the regionalProgram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionalProgram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionalProgram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportRegionalProgramType }
     * 
     * 
     */
    public List<ExportRegionalProgramType> getRegionalProgram() {
        if (regionalProgram == null) {
            regionalProgram = new ArrayList<ExportRegionalProgramType>();
        }
        return this.regionalProgram;
    }

    /**
     * Gets the value of the regionalProgramWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionalProgramWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionalProgramWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportRegionalProgramWorkType }
     * 
     * 
     */
    public List<ExportRegionalProgramWorkType> getRegionalProgramWork() {
        if (regionalProgramWork == null) {
            regionalProgramWork = new ArrayList<ExportRegionalProgramWorkType>();
        }
        return this.regionalProgramWork;
    }

    /**
     * Gets the value of the decisionPD property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decisionPD property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecisionPD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDecisionPDType }
     * 
     * 
     */
    public List<ExportDecisionPDType> getDecisionPD() {
        if (decisionPD == null) {
            decisionPD = new ArrayList<ExportDecisionPDType>();
        }
        return this.decisionPD;
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
            return "11.0.0.1";
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
