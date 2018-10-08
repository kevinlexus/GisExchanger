
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Результат экспорта договоров ресурсоснабжения
 * 
 * <p>Java class for exportSupplyResourceContractResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportSupplyResourceContractResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportSupplyResourceContractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="ContractState"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="NotTakeEffect"/&gt;
 *               &lt;enumeration value="Proceed"/&gt;
 *               &lt;enumeration value="Expired"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VersionNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VersionStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Posted"/&gt;
 *               &lt;enumeration value="Terminated"/&gt;
 *               &lt;enumeration value="Draft"/&gt;
 *               &lt;enumeration value="Annul"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TerminateContract" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AnnulmentContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportAnnulmentType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportSupplyResourceContractResultType", propOrder = {
    "contractRootGUID",
    "contractGUID",
    "contractState",
    "versionNumber",
    "versionStatus",
    "terminateContract",
    "annulmentContract"
})
public class ExportSupplyResourceContractResultType
    extends ExportSupplyResourceContractType
{

    @XmlElement(name = "ContractRootGUID", required = true)
    protected String contractRootGUID;
    @XmlElement(name = "ContractGUID", required = true)
    protected String contractGUID;
    @XmlElement(name = "ContractState", required = true)
    protected String contractState;
    @XmlElement(name = "VersionNumber", required = true)
    protected BigInteger versionNumber;
    @XmlElement(name = "VersionStatus", required = true)
    protected String versionStatus;
    @XmlElement(name = "TerminateContract")
    protected ExportSupplyResourceContractResultType.TerminateContract terminateContract;
    @XmlElement(name = "AnnulmentContract")
    protected ExportAnnulmentType annulmentContract;

    /**
     * Gets the value of the contractRootGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractRootGUID() {
        return contractRootGUID;
    }

    /**
     * Sets the value of the contractRootGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractRootGUID(String value) {
        this.contractRootGUID = value;
    }

    /**
     * Gets the value of the contractGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractGUID() {
        return contractGUID;
    }

    /**
     * Sets the value of the contractGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractGUID(String value) {
        this.contractGUID = value;
    }

    /**
     * Gets the value of the contractState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractState() {
        return contractState;
    }

    /**
     * Sets the value of the contractState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractState(String value) {
        this.contractState = value;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersionNumber(BigInteger value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the versionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionStatus() {
        return versionStatus;
    }

    /**
     * Sets the value of the versionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionStatus(String value) {
        this.versionStatus = value;
    }

    /**
     * Gets the value of the terminateContract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractResultType.TerminateContract }
     *     
     */
    public ExportSupplyResourceContractResultType.TerminateContract getTerminateContract() {
        return terminateContract;
    }

    /**
     * Sets the value of the terminateContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractResultType.TerminateContract }
     *     
     */
    public void setTerminateContract(ExportSupplyResourceContractResultType.TerminateContract value) {
        this.terminateContract = value;
    }

    /**
     * Gets the value of the annulmentContract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportAnnulmentType }
     *     
     */
    public ExportAnnulmentType getAnnulmentContract() {
        return annulmentContract;
    }

    /**
     * Sets the value of the annulmentContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportAnnulmentType }
     *     
     */
    public void setAnnulmentContract(ExportAnnulmentType value) {
        this.annulmentContract = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ReasonRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "reasonRef"
    })
    public static class TerminateContract
        extends TerminateType
    {

        @XmlElement(name = "ReasonRef", required = true)
        protected NsiRef reasonRef;

        /**
         * Gets the value of the reasonRef property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getReasonRef() {
            return reasonRef;
        }

        /**
         * Sets the value of the reasonRef property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setReasonRef(NsiRef value) {
            this.reasonRef = value;
        }

    }

}
