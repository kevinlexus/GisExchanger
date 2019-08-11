
package ru.gosuslugi.dom.schema.integration.nsi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Тип позиции справочника 337 "Коммунальные ресурсы, потребляемые при использовании и содержании общего имущества в многоквартирном доме".
 * 
 * <p>Java class for importGeneralNeedsMunicipalResourceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importGeneralNeedsMunicipalResourceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *         &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;element name="GeneralMunicipalResourceName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String255Type"/&gt;
 *         &lt;element name="MunicipalResourceRef" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="SortOrder"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;maxLength value="3"/&gt;
 *                 &lt;minLength value="1"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="SortOrderNotDefined" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importGeneralNeedsMunicipalResourceType", propOrder = {
    "transportGUID",
    "elementGuid",
    "generalMunicipalResourceName",
    "municipalResourceRef",
    "okei",
    "sortOrder",
    "sortOrderNotDefined"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.nsi.ImportGeneralNeedsMunicipalResourceRequest.TopLevelMunicipalResource.ImportGeneralMunicipalResource.class
})
public class ImportGeneralNeedsMunicipalResourceType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "ElementGuid")
    protected String elementGuid;
    @XmlElement(name = "GeneralMunicipalResourceName", required = true)
    protected String generalMunicipalResourceName;
    @XmlElement(name = "MunicipalResourceRef", required = true)
    protected NsiRef municipalResourceRef;
    @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String okei;
    @XmlElement(name = "SortOrder")
    protected String sortOrder;
    @XmlElement(name = "SortOrderNotDefined")
    protected Boolean sortOrderNotDefined;

    /**
     * Gets the value of the transportGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportGUID() {
        return transportGUID;
    }

    /**
     * Sets the value of the transportGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportGUID(String value) {
        this.transportGUID = value;
    }

    /**
     * Gets the value of the elementGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementGuid() {
        return elementGuid;
    }

    /**
     * Sets the value of the elementGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementGuid(String value) {
        this.elementGuid = value;
    }

    /**
     * Gets the value of the generalMunicipalResourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralMunicipalResourceName() {
        return generalMunicipalResourceName;
    }

    /**
     * Sets the value of the generalMunicipalResourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralMunicipalResourceName(String value) {
        this.generalMunicipalResourceName = value;
    }

    /**
     * Gets the value of the municipalResourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getMunicipalResourceRef() {
        return municipalResourceRef;
    }

    /**
     * Sets the value of the municipalResourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setMunicipalResourceRef(NsiRef value) {
        this.municipalResourceRef = value;
    }

    /**
     * (не используется)
     * Единница измерения из справочника ОКЕИ.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOKEI() {
        return okei;
    }

    /**
     * Sets the value of the okei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOKEI(String value) {
        this.okei = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortOrder(String value) {
        this.sortOrder = value;
    }

    /**
     * Gets the value of the sortOrderNotDefined property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSortOrderNotDefined() {
        return sortOrderNotDefined;
    }

    /**
     * Sets the value of the sortOrderNotDefined property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSortOrderNotDefined(Boolean value) {
        this.sortOrderNotDefined = value;
    }

}
