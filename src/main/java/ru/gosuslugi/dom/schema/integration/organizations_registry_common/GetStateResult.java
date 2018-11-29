
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
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
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *           &lt;element name="ImportResult" type="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="exportOrgRegistryResult" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}exportOrgRegistryResultType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="exportDataProviderResult" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}exportDataProviderResultType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="exportDelegatedAccessResult" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}exportDelegatedAccessType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="exportObjectsDelegatedAccessResult" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}ObjectsDelegatedAccessRightType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="exportTerritoryDelegatedAccess" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}TerritoryDelegatedAccessRightType" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="IsNextPage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.2.1""/&gt;
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
    "exportOrgRegistryResult",
    "exportDataProviderResult",
    "exportDelegatedAccessResult",
    "exportObjectsDelegatedAccessResult",
    "exportTerritoryDelegatedAccess",
    "isNextPage"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<CommonResultType> importResult;
    protected List<ExportOrgRegistryResultType> exportOrgRegistryResult;
    protected List<ExportDataProviderResultType> exportDataProviderResult;
    protected List<ExportDelegatedAccessType> exportDelegatedAccessResult;
    protected List<ObjectsDelegatedAccessRightType> exportObjectsDelegatedAccessResult;
    protected List<TerritoryDelegatedAccessRightType> exportTerritoryDelegatedAccess;
    @XmlElement(name = "IsNextPage")
    protected Boolean isNextPage;
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
     * {@link CommonResultType }
     * 
     * 
     */
    public List<CommonResultType> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<CommonResultType>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the exportOrgRegistryResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportOrgRegistryResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportOrgRegistryResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportOrgRegistryResultType }
     * 
     * 
     */
    public List<ExportOrgRegistryResultType> getExportOrgRegistryResult() {
        if (exportOrgRegistryResult == null) {
            exportOrgRegistryResult = new ArrayList<ExportOrgRegistryResultType>();
        }
        return this.exportOrgRegistryResult;
    }

    /**
     * Gets the value of the exportDataProviderResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportDataProviderResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportDataProviderResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDataProviderResultType }
     * 
     * 
     */
    public List<ExportDataProviderResultType> getExportDataProviderResult() {
        if (exportDataProviderResult == null) {
            exportDataProviderResult = new ArrayList<ExportDataProviderResultType>();
        }
        return this.exportDataProviderResult;
    }

    /**
     * Gets the value of the exportDelegatedAccessResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportDelegatedAccessResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportDelegatedAccessResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDelegatedAccessType }
     * 
     * 
     */
    public List<ExportDelegatedAccessType> getExportDelegatedAccessResult() {
        if (exportDelegatedAccessResult == null) {
            exportDelegatedAccessResult = new ArrayList<ExportDelegatedAccessType>();
        }
        return this.exportDelegatedAccessResult;
    }

    /**
     * Gets the value of the exportObjectsDelegatedAccessResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportObjectsDelegatedAccessResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportObjectsDelegatedAccessResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectsDelegatedAccessRightType }
     * 
     * 
     */
    public List<ObjectsDelegatedAccessRightType> getExportObjectsDelegatedAccessResult() {
        if (exportObjectsDelegatedAccessResult == null) {
            exportObjectsDelegatedAccessResult = new ArrayList<ObjectsDelegatedAccessRightType>();
        }
        return this.exportObjectsDelegatedAccessResult;
    }

    /**
     * Gets the value of the exportTerritoryDelegatedAccess property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportTerritoryDelegatedAccess property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportTerritoryDelegatedAccess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerritoryDelegatedAccessRightType }
     * 
     * 
     */
    public List<TerritoryDelegatedAccessRightType> getExportTerritoryDelegatedAccess() {
        if (exportTerritoryDelegatedAccess == null) {
            exportTerritoryDelegatedAccess = new ArrayList<TerritoryDelegatedAccessRightType>();
        }
        return this.exportTerritoryDelegatedAccess;
    }

    /**
     * Gets the value of the isNextPage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNextPage() {
        return isNextPage;
    }

    /**
     * Sets the value of the isNextPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNextPage(Boolean value) {
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
            return "10.0.2.1";
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
