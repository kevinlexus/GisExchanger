
package ru.gosuslugi.dom.schema.integration.nsi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Элемент справочника оснований принятия решений.
 * 
 * <p>Java class for importBaseDecisionMSPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importBaseDecisionMSPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *           &lt;element name="ElementGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="DecisionName" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type"/&gt;
 *         &lt;element name="DecisionType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *         &lt;element name="IsAppliedToSubsidiaries" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="IsAppliedToRefundOfCharges" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importBaseDecisionMSPType", propOrder = {
    "transportGUID",
    "elementGuid",
    "decisionName",
    "decisionType",
    "isAppliedToSubsidiaries",
    "isAppliedToRefundOfCharges"
})
public class ImportBaseDecisionMSPType {

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "ElementGuid")
    protected String elementGuid;
    @XmlElement(name = "DecisionName", required = true)
    protected String decisionName;
    @XmlElement(name = "DecisionType", required = true)
    protected NsiRef decisionType;
    @XmlElement(name = "IsAppliedToSubsidiaries")
    protected boolean isAppliedToSubsidiaries;
    @XmlElement(name = "IsAppliedToRefundOfCharges")
    protected boolean isAppliedToRefundOfCharges;

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
     * Gets the value of the decisionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDecisionName() {
        return decisionName;
    }

    /**
     * Sets the value of the decisionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDecisionName(String value) {
        this.decisionName = value;
    }

    /**
     * Gets the value of the decisionType property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getDecisionType() {
        return decisionType;
    }

    /**
     * Sets the value of the decisionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setDecisionType(NsiRef value) {
        this.decisionType = value;
    }

    /**
     * Gets the value of the isAppliedToSubsidiaries property.
     * 
     */
    public boolean isIsAppliedToSubsidiaries() {
        return isAppliedToSubsidiaries;
    }

    /**
     * Sets the value of the isAppliedToSubsidiaries property.
     * 
     */
    public void setIsAppliedToSubsidiaries(boolean value) {
        this.isAppliedToSubsidiaries = value;
    }

    /**
     * Gets the value of the isAppliedToRefundOfCharges property.
     * 
     */
    public boolean isIsAppliedToRefundOfCharges() {
        return isAppliedToRefundOfCharges;
    }

    /**
     * Sets the value of the isAppliedToRefundOfCharges property.
     * 
     */
    public void setIsAppliedToRefundOfCharges(boolean value) {
        this.isAppliedToRefundOfCharges = value;
    }

}
