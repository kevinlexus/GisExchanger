
package ru.gosuslugi.dom.schema.integration.house_management;

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
 *           &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportBriefSupplyResourceContractResultType" maxOccurs="unbounded"/&gt;
 *           &lt;choice&gt;
 *             &lt;sequence&gt;
 *               &lt;element name="NextPageContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *               &lt;element name="NextPageObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *             &lt;/sequence&gt;
 *             &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;/choice&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.14.0.1""/&gt;
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
    "contract",
    "nextPageContractRootGUID",
    "nextPageObjectGUID",
    "isLastPage"
})
@XmlRootElement(name = "exportBriefSupplyResourceContractResult")
public class ExportBriefSupplyResourceContractResult
    extends BaseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "Contract")
    protected List<ExportBriefSupplyResourceContractResultType> contract;
    @XmlElement(name = "NextPageContractRootGUID")
    protected String nextPageContractRootGUID;
    @XmlElement(name = "NextPageObjectGUID")
    protected String nextPageObjectGUID;
    @XmlElement(name = "IsLastPage")
    protected Boolean isLastPage;
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
     * {@link ExportBriefSupplyResourceContractResultType }
     * 
     * 
     */
    public List<ExportBriefSupplyResourceContractResultType> getContract() {
        if (contract == null) {
            contract = new ArrayList<ExportBriefSupplyResourceContractResultType>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the nextPageContractRootGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextPageContractRootGUID() {
        return nextPageContractRootGUID;
    }

    /**
     * Sets the value of the nextPageContractRootGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextPageContractRootGUID(String value) {
        this.nextPageContractRootGUID = value;
    }

    /**
     * Gets the value of the nextPageObjectGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextPageObjectGUID() {
        return nextPageObjectGUID;
    }

    /**
     * Sets the value of the nextPageObjectGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextPageObjectGUID(String value) {
        this.nextPageObjectGUID = value;
    }

    /**
     * Gets the value of the isLastPage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsLastPage() {
        return isLastPage;
    }

    /**
     * Sets the value of the isLastPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsLastPage(Boolean value) {
        this.isLastPage = value;
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
            return "11.14.0.1";
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