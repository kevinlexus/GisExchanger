
package ru.gosuslugi.dom.schema.integration.uk;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType">
 *       &lt;choice minOccurs="0">
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/>
 *         &lt;element name="ImportDocumentResult" type="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType" maxOccurs="unbounded"/>
 *         &lt;element name="Document" type="{http://dom.gosuslugi.ru/schema/integration/uk/}exportDocumentType" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.2""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "importDocumentResult",
    "document"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportDocumentResult")
    protected List<CommonResultType> importDocumentResult;
    @XmlElement(name = "Document")
    protected List<ExportDocumentType> document;
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
     * Gets the value of the importDocumentResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importDocumentResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportDocumentResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonResultType }
     * 
     * 
     */
    public List<CommonResultType> getImportDocumentResult() {
        if (importDocumentResult == null) {
            importDocumentResult = new ArrayList<CommonResultType>();
        }
        return this.importDocumentResult;
    }

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDocumentType }
     * 
     * 
     */
    public List<ExportDocumentType> getDocument() {
        if (document == null) {
            document = new ArrayList<ExportDocumentType>();
        }
        return this.document;
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
            return "11.2.0.2";
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
