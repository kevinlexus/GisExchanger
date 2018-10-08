
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Сводный статус объекта жилищного фонда в ГИС ЖКХ (для импорта)
 * 
 * <p>Java class for OGFImportStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OGFImportStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GKNRelationshipStatus"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}GKNRelationshipStatusType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="EGRPRelationshipStatus" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}EGRPRelationshipStatusType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OGFImportStatusType", propOrder = {
    "gknRelationshipStatus",
    "egrpRelationshipStatus"
})
public class OGFImportStatusType {

    @XmlElement(name = "GKNRelationshipStatus", required = true)
    protected OGFImportStatusType.GKNRelationshipStatus gknRelationshipStatus;
    @XmlElement(name = "EGRPRelationshipStatus", required = true)
    protected EGRPRelationshipStatusType egrpRelationshipStatus;

    /**
     * Gets the value of the gknRelationshipStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OGFImportStatusType.GKNRelationshipStatus }
     *     
     */
    public OGFImportStatusType.GKNRelationshipStatus getGKNRelationshipStatus() {
        return gknRelationshipStatus;
    }

    /**
     * Sets the value of the gknRelationshipStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OGFImportStatusType.GKNRelationshipStatus }
     *     
     */
    public void setGKNRelationshipStatus(OGFImportStatusType.GKNRelationshipStatus value) {
        this.gknRelationshipStatus = value;
    }

    /**
     * Gets the value of the egrpRelationshipStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EGRPRelationshipStatusType }
     *     
     */
    public EGRPRelationshipStatusType getEGRPRelationshipStatus() {
        return egrpRelationshipStatus;
    }

    /**
     * Sets the value of the egrpRelationshipStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EGRPRelationshipStatusType }
     *     
     */
    public void setEGRPRelationshipStatus(EGRPRelationshipStatusType value) {
        this.egrpRelationshipStatus = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}GKNRelationshipStatusType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GKNRelationshipStatus
        extends GKNRelationshipStatusType
    {


    }

}
