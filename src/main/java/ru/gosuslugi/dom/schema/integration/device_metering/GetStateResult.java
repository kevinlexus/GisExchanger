
package ru.gosuslugi.dom.schema.integration.device_metering;

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
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *         &lt;element name="ImportResult" type="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType" maxOccurs="unbounded"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="exportMeteringDeviceHistoryResult" type="{http://dom.gosuslugi.ru/schema/integration/device-metering/}exportMeteringDeviceHistoryResultType" maxOccurs="unbounded"/&gt;
 *           &lt;element name="PagedOutput" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="ExportMeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;element name="LastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/&gt;
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
    "exportMeteringDeviceHistoryResult",
    "pagedOutput"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<CommonResultType> importResult;
    protected List<ExportMeteringDeviceHistoryResultType> exportMeteringDeviceHistoryResult;
    @XmlElement(name = "PagedOutput")
    protected GetStateResult.PagedOutput pagedOutput;
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
     * Gets the value of the exportMeteringDeviceHistoryResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportMeteringDeviceHistoryResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportMeteringDeviceHistoryResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportMeteringDeviceHistoryResultType }
     * 
     * 
     */
    public List<ExportMeteringDeviceHistoryResultType> getExportMeteringDeviceHistoryResult() {
        if (exportMeteringDeviceHistoryResult == null) {
            exportMeteringDeviceHistoryResult = new ArrayList<ExportMeteringDeviceHistoryResultType>();
        }
        return this.exportMeteringDeviceHistoryResult;
    }

    /**
     * Gets the value of the pagedOutput property.
     * 
     * @return
     *     possible object is
     *     {@link GetStateResult.PagedOutput }
     *     
     */
    public GetStateResult.PagedOutput getPagedOutput() {
        return pagedOutput;
    }

    /**
     * Sets the value of the pagedOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStateResult.PagedOutput }
     *     
     */
    public void setPagedOutput(GetStateResult.PagedOutput value) {
        this.pagedOutput = value;
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
            return "10.0.1.1";
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
     *         &lt;element name="ExportMeteringDeviceRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="LastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "exportMeteringDeviceRootGUID",
        "lastPage"
    })
    public static class PagedOutput {

        @XmlElement(name = "ExportMeteringDeviceRootGUID")
        protected String exportMeteringDeviceRootGUID;
        @XmlElement(name = "LastPage")
        protected Boolean lastPage;

        /**
         * Gets the value of the exportMeteringDeviceRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExportMeteringDeviceRootGUID() {
            return exportMeteringDeviceRootGUID;
        }

        /**
         * Sets the value of the exportMeteringDeviceRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExportMeteringDeviceRootGUID(String value) {
            this.exportMeteringDeviceRootGUID = value;
        }

        /**
         * Gets the value of the lastPage property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isLastPage() {
            return lastPage;
        }

        /**
         * Sets the value of the lastPage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setLastPage(Boolean value) {
            this.lastPage = value;
        }

    }

}
