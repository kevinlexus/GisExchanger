
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for TerritoryDelegatedAccessRightType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerritoryDelegatedAccessRightType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccessRightGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="AllTerritories" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerritoryDelegatedAccessRightType", propOrder = {
    "accessRightGUID",
    "oktmo",
    "region",
    "allTerritories"
})
public class TerritoryDelegatedAccessRightType {

    @XmlElement(name = "AccessRightGUID", required = true)
    protected String accessRightGUID;
    @XmlElement(name = "OKTMO")
    protected List<OKTMORefType> oktmo;
    @XmlElement(name = "Region")
    protected List<NsiRef> region;
    @XmlElement(name = "AllTerritories")
    protected Boolean allTerritories;

    /**
     * Gets the value of the accessRightGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessRightGUID() {
        return accessRightGUID;
    }

    /**
     * Sets the value of the accessRightGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessRightGUID(String value) {
        this.accessRightGUID = value;
    }

    /**
     * Gets the value of the oktmo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oktmo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOKTMO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OKTMORefType }
     * 
     * 
     */
    public List<OKTMORefType> getOKTMO() {
        if (oktmo == null) {
            oktmo = new ArrayList<OKTMORefType>();
        }
        return this.oktmo;
    }

    /**
     * Gets the value of the region property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the region property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getRegion() {
        if (region == null) {
            region = new ArrayList<NsiRef>();
        }
        return this.region;
    }

    /**
     * Gets the value of the allTerritories property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllTerritories() {
        return allTerritories;
    }

    /**
     * Sets the value of the allTerritories property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllTerritories(Boolean value) {
        this.allTerritories = value;
    }

}
