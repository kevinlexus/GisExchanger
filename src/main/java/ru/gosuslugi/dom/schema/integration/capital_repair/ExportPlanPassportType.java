
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Экспортируемый КПР
 * 
 * <p>Java class for ExportPlanPassportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportPlanPassportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}PlanPassportType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusExtendedType"/>
 *         &lt;element name="PlanGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="Document" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportDocumentType" maxOccurs="1000" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportPlanPassportType", propOrder = {
    "status",
    "planGUID",
    "document"
})
public class ExportPlanPassportType
    extends PlanPassportType
{

    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusExtendedType status;
    @XmlElement(name = "PlanGUID", required = true)
    protected String planGUID;
    @XmlElement(name = "Document")
    protected List<ExportDocumentType> document;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusExtendedType }
     *     
     */
    public StatusExtendedType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusExtendedType }
     *     
     */
    public void setStatus(StatusExtendedType value) {
        this.status = value;
    }

    /**
     * Gets the value of the planGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGUID() {
        return planGUID;
    }

    /**
     * Sets the value of the planGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGUID(String value) {
        this.planGUID = value;
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

}
