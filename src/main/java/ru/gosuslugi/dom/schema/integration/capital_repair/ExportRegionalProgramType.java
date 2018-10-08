
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Экспортируемая региональная программа капитального ремонта (включая идентификатор, статус, документы и территорию)
 * 
 * <p>Java class for ExportRegionalProgramType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportRegionalProgramType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramPasportType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Territory" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *         &lt;element name="RegionalProgramGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="Documents" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ExportDocumentType" maxOccurs="1000" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}StatusExtendedType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportRegionalProgramType", propOrder = {
    "territory",
    "regionalProgramGuid",
    "documents",
    "status"
})
public class ExportRegionalProgramType
    extends RegionalProgramPasportType
{

    @XmlElement(name = "Territory", required = true)
    protected OKTMORefType territory;
    @XmlElement(name = "RegionalProgramGuid", required = true)
    protected String regionalProgramGuid;
    @XmlElement(name = "Documents")
    protected List<ExportDocumentType> documents;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "token")
    protected StatusExtendedType status;

    /**
     * Gets the value of the territory property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getTerritory() {
        return territory;
    }

    /**
     * Sets the value of the territory property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setTerritory(OKTMORefType value) {
        this.territory = value;
    }

    /**
     * Gets the value of the regionalProgramGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionalProgramGuid() {
        return regionalProgramGuid;
    }

    /**
     * Sets the value of the regionalProgramGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionalProgramGuid(String value) {
        this.regionalProgramGuid = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDocumentType }
     * 
     * 
     */
    public List<ExportDocumentType> getDocuments() {
        if (documents == null) {
            documents = new ArrayList<ExportDocumentType>();
        }
        return this.documents;
    }

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

}
