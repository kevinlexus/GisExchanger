
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Блок дома блокированной застройки  (для экспорта)
 * 
 * <p>Java class for BlockExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlockExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFExportStatusType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BlockNum" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}PremisesNumType"/&gt;
 *         &lt;element name="PremisesCharacteristic" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="TotalArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="GrossArea" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType"/&gt;
 *           &lt;element name="NoGrossArea" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminationDate" minOccurs="0"/&gt;
 *         &lt;element name="AnnulmentReason" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *         &lt;element name="AnnulmentInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OGFData" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="InformationConfirmed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Category" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BlockCategoryType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlockExportType", propOrder = {
    "blockNum",
    "premisesCharacteristic",
    "totalArea",
    "grossArea",
    "noGrossArea",
    "terminationDate",
    "annulmentReason",
    "annulmentInfo",
    "ogfData",
    "informationConfirmed",
    "category"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.LivingHouse.Block.class
})
public class BlockExportType
    extends OGFExportStatusType
{

    @XmlElement(name = "BlockNum", required = true)
    protected String blockNum;
    @XmlElement(name = "PremisesCharacteristic")
    protected NsiRef premisesCharacteristic;
    @XmlElement(name = "TotalArea")
    protected BigDecimal totalArea;
    @XmlElement(name = "GrossArea")
    protected BigDecimal grossArea;
    @XmlElement(name = "NoGrossArea")
    protected Boolean noGrossArea;
    @XmlElement(name = "TerminationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar terminationDate;
    @XmlElement(name = "AnnulmentReason")
    protected NsiRef annulmentReason;
    @XmlElement(name = "AnnulmentInfo")
    protected String annulmentInfo;
    @XmlElement(name = "OGFData")
    protected List<OGFData> ogfData;
    @XmlElement(name = "InformationConfirmed")
    protected Boolean informationConfirmed;
    @XmlElement(name = "Category")
    @XmlSchemaType(name = "string")
    protected BlockCategoryType category;

    /**
     * Gets the value of the blockNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockNum() {
        return blockNum;
    }

    /**
     * Sets the value of the blockNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockNum(String value) {
        this.blockNum = value;
    }

    /**
     * Gets the value of the premisesCharacteristic property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getPremisesCharacteristic() {
        return premisesCharacteristic;
    }

    /**
     * Sets the value of the premisesCharacteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setPremisesCharacteristic(NsiRef value) {
        this.premisesCharacteristic = value;
    }

    /**
     * Gets the value of the totalArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalArea() {
        return totalArea;
    }

    /**
     * Sets the value of the totalArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalArea(BigDecimal value) {
        this.totalArea = value;
    }

    /**
     * Gets the value of the grossArea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossArea() {
        return grossArea;
    }

    /**
     * Sets the value of the grossArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossArea(BigDecimal value) {
        this.grossArea = value;
    }

    /**
     * Gets the value of the noGrossArea property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoGrossArea() {
        return noGrossArea;
    }

    /**
     * Sets the value of the noGrossArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoGrossArea(Boolean value) {
        this.noGrossArea = value;
    }

    /**
     * Gets the value of the terminationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationDate() {
        return terminationDate;
    }

    /**
     * Sets the value of the terminationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationDate(XMLGregorianCalendar value) {
        this.terminationDate = value;
    }

    /**
     * Gets the value of the annulmentReason property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getAnnulmentReason() {
        return annulmentReason;
    }

    /**
     * Sets the value of the annulmentReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setAnnulmentReason(NsiRef value) {
        this.annulmentReason = value;
    }

    /**
     * Gets the value of the annulmentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnulmentInfo() {
        return annulmentInfo;
    }

    /**
     * Sets the value of the annulmentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnulmentInfo(String value) {
        this.annulmentInfo = value;
    }

    /**
     * Gets the value of the ogfData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ogfData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOGFData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OGFData }
     * 
     * 
     */
    public List<OGFData> getOGFData() {
        if (ogfData == null) {
            ogfData = new ArrayList<OGFData>();
        }
        return this.ogfData;
    }

    /**
     * Gets the value of the informationConfirmed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInformationConfirmed() {
        return informationConfirmed;
    }

    /**
     * Sets the value of the informationConfirmed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInformationConfirmed(Boolean value) {
        this.informationConfirmed = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link BlockCategoryType }
     *     
     */
    public BlockCategoryType getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockCategoryType }
     *     
     */
    public void setCategory(BlockCategoryType value) {
        this.category = value;
    }

}
