
package ru.gosuslugi.dom.schema.integration.tariff;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Экспортируемые сведения о критерии дифференциации
 * 
 * <p>Java class for exportDifferentiationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportDifferentiationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DifferentiationCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="DifferentiationName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DifferentiationValueKind" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}DifferentiationValueKindType"/&gt;
 *         &lt;element name="UsedFor" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}TariffCaseType" maxOccurs="5"/&gt;
 *         &lt;element name="TariffKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="100" minOccurs="0"/&gt;
 *         &lt;element name="NsiItem" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemInfoType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}ListGroup"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IsPlural" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportDifferentiationType", propOrder = {
    "differentiationCode",
    "differentiationName",
    "differentiationValueKind",
    "usedFor",
    "tariffKind",
    "nsiItem",
    "isPlural"
})
public class ExportDifferentiationType {

    @XmlElement(name = "DifferentiationCode", required = true)
    protected BigInteger differentiationCode;
    @XmlElement(name = "DifferentiationName", required = true)
    protected String differentiationName;
    @XmlElement(name = "DifferentiationValueKind", required = true)
    @XmlSchemaType(name = "string")
    protected DifferentiationValueKindType differentiationValueKind;
    @XmlElement(name = "UsedFor", required = true)
    @XmlSchemaType(name = "string")
    protected List<TariffCaseType> usedFor;
    @XmlElement(name = "TariffKind")
    protected List<NsiRef> tariffKind;
    @XmlElement(name = "NsiItem")
    protected ExportDifferentiationType.NsiItem nsiItem;
    @XmlElement(name = "IsPlural")
    protected Boolean isPlural;

    /**
     * Gets the value of the differentiationCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDifferentiationCode() {
        return differentiationCode;
    }

    /**
     * Sets the value of the differentiationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDifferentiationCode(BigInteger value) {
        this.differentiationCode = value;
    }

    /**
     * Gets the value of the differentiationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifferentiationName() {
        return differentiationName;
    }

    /**
     * Sets the value of the differentiationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifferentiationName(String value) {
        this.differentiationName = value;
    }

    /**
     * Gets the value of the differentiationValueKind property.
     * 
     * @return
     *     possible object is
     *     {@link DifferentiationValueKindType }
     *     
     */
    public DifferentiationValueKindType getDifferentiationValueKind() {
        return differentiationValueKind;
    }

    /**
     * Sets the value of the differentiationValueKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link DifferentiationValueKindType }
     *     
     */
    public void setDifferentiationValueKind(DifferentiationValueKindType value) {
        this.differentiationValueKind = value;
    }

    /**
     * Gets the value of the usedFor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usedFor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsedFor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TariffCaseType }
     * 
     * 
     */
    public List<TariffCaseType> getUsedFor() {
        if (usedFor == null) {
            usedFor = new ArrayList<TariffCaseType>();
        }
        return this.usedFor;
    }

    /**
     * Gets the value of the tariffKind property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariffKind property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariffKind().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getTariffKind() {
        if (tariffKind == null) {
            tariffKind = new ArrayList<NsiRef>();
        }
        return this.tariffKind;
    }

    /**
     * Gets the value of the nsiItem property.
     * 
     * @return
     *     possible object is
     *     {@link ExportDifferentiationType.NsiItem }
     *     
     */
    public ExportDifferentiationType.NsiItem getNsiItem() {
        return nsiItem;
    }

    /**
     * Sets the value of the nsiItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportDifferentiationType.NsiItem }
     *     
     */
    public void setNsiItem(ExportDifferentiationType.NsiItem value) {
        this.nsiItem = value;
    }

    /**
     * Gets the value of the isPlural property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPlural() {
        return isPlural;
    }

    /**
     * Sets the value of the isPlural property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPlural(Boolean value) {
        this.isPlural = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemInfoType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}ListGroup"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "listGroup"
    })
    public static class NsiItem
        extends NsiItemInfoType
    {

        @XmlElement(name = "ListGroup", namespace = "http://dom.gosuslugi.ru/schema/integration/nsi-base/", required = true)
        protected String listGroup;

        /**
         * Gets the value of the listGroup property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getListGroup() {
            return listGroup;
        }

        /**
         * Sets the value of the listGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setListGroup(String value) {
            this.listGroup = value;
        }

    }

}
