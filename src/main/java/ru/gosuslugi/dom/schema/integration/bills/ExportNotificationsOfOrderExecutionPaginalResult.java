
package ru.gosuslugi.dom.schema.integration.bills;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="exportNotificationsOfOrderExecutionResult" type="{http://dom.gosuslugi.ru/schema/integration/bills/}exportNotificationsOfOrderExecutionResultType" maxOccurs="unbounded"/>
 *           &lt;element name="ExportNotificationsOfOrderExecutionGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.5.0.8""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exportNotificationsOfOrderExecutionResult",
    "exportNotificationsOfOrderExecutionGUID",
    "errorMessage"
})
@XmlRootElement(name = "exportNotificationsOfOrderExecutionPaginalResult")
public class ExportNotificationsOfOrderExecutionPaginalResult
    extends BaseType
{

    protected List<ExportNotificationsOfOrderExecutionResultType> exportNotificationsOfOrderExecutionResult;
    @XmlElement(name = "ExportNotificationsOfOrderExecutionGUID")
    protected String exportNotificationsOfOrderExecutionGUID;
    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the exportNotificationsOfOrderExecutionResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportNotificationsOfOrderExecutionResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportNotificationsOfOrderExecutionResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportNotificationsOfOrderExecutionResultType }
     * 
     * 
     */
    public List<ExportNotificationsOfOrderExecutionResultType> getExportNotificationsOfOrderExecutionResult() {
        if (exportNotificationsOfOrderExecutionResult == null) {
            exportNotificationsOfOrderExecutionResult = new ArrayList<ExportNotificationsOfOrderExecutionResultType>();
        }
        return this.exportNotificationsOfOrderExecutionResult;
    }

    /**
     * Gets the value of the exportNotificationsOfOrderExecutionGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportNotificationsOfOrderExecutionGUID() {
        return exportNotificationsOfOrderExecutionGUID;
    }

    /**
     * Sets the value of the exportNotificationsOfOrderExecutionGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportNotificationsOfOrderExecutionGUID(String value) {
        this.exportNotificationsOfOrderExecutionGUID = value;
    }

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
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "11.5.0.8";
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
