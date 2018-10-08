
package ru.gosuslugi.dom.schema.integration.uk;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.BaseType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


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
 *         &lt;sequence&gt;
 *           &lt;choice&gt;
 *             &lt;element name="Federal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *             &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *             &lt;element name="Municipal" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *           &lt;/choice&gt;
 *           &lt;sequence minOccurs="0"&gt;
 *             &lt;element name="AcceptStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *             &lt;element name="AcceptEndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="DocumentType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="DocumentGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="1000"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.2""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "federal",
    "region",
    "municipal",
    "acceptStartDate",
    "acceptEndDate",
    "documentType",
    "documentGuid"
})
@XmlRootElement(name = "exportDocumentRequest")
public class ExportDocumentRequest
    extends BaseType
{

    @XmlElement(name = "Federal", defaultValue = "true")
    protected Boolean federal;
    @XmlElement(name = "Region")
    protected NsiRef region;
    @XmlElement(name = "Municipal")
    protected OKTMORefType municipal;
    @XmlElement(name = "AcceptStartDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar acceptStartDate;
    @XmlElement(name = "AcceptEndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar acceptEndDate;
    @XmlElement(name = "DocumentType")
    protected NsiRef documentType;
    @XmlElement(name = "DocumentGuid")
    protected List<String> documentGuid;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the federal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFederal() {
        return federal;
    }

    /**
     * Sets the value of the federal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFederal(Boolean value) {
        this.federal = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setRegion(NsiRef value) {
        this.region = value;
    }

    /**
     * Gets the value of the municipal property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getMunicipal() {
        return municipal;
    }

    /**
     * Sets the value of the municipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setMunicipal(OKTMORefType value) {
        this.municipal = value;
    }

    /**
     * Gets the value of the acceptStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcceptStartDate() {
        return acceptStartDate;
    }

    /**
     * Sets the value of the acceptStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcceptStartDate(XMLGregorianCalendar value) {
        this.acceptStartDate = value;
    }

    /**
     * Gets the value of the acceptEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcceptEndDate() {
        return acceptEndDate;
    }

    /**
     * Sets the value of the acceptEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcceptEndDate(XMLGregorianCalendar value) {
        this.acceptEndDate = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setDocumentType(NsiRef value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the documentGuid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentGuid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentGuid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDocumentGuid() {
        if (documentGuid == null) {
            documentGuid = new ArrayList<String>();
        }
        return this.documentGuid;
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
