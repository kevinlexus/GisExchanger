
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObjectsDelegatedAccessRightType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectsDelegatedAccessRightType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessRightGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;choice>
 *           &lt;element name="ObjectInfo" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="Type" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="1000"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="AllObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectsDelegatedAccessRightType", propOrder = {
    "accessRightGUID",
    "objectInfo",
    "allObjects"
})
public class ObjectsDelegatedAccessRightType {

    @XmlElement(name = "AccessRightGUID", required = true)
    protected String accessRightGUID;
    @XmlElement(name = "ObjectInfo")
    protected List<ObjectsDelegatedAccessRightType.ObjectInfo> objectInfo;
    @XmlElement(name = "AllObjects")
    protected Boolean allObjects;

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
     * Gets the value of the objectInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectsDelegatedAccessRightType.ObjectInfo }
     * 
     * 
     */
    public List<ObjectsDelegatedAccessRightType.ObjectInfo> getObjectInfo() {
        if (objectInfo == null) {
            objectInfo = new ArrayList<ObjectsDelegatedAccessRightType.ObjectInfo>();
        }
        return this.objectInfo;
    }

    /**
     * Gets the value of the allObjects property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllObjects() {
        return allObjects;
    }

    /**
     * Sets the value of the allObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllObjects(Boolean value) {
        this.allObjects = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="Type" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1000"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "objectGUID",
        "type"
    })
    public static class ObjectInfo {

        @XmlElement(name = "ObjectGUID", required = true)
        protected String objectGUID;
        @XmlElement(name = "Type")
        protected String type;

        /**
         * Gets the value of the objectGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectGUID() {
            return objectGUID;
        }

        /**
         * Sets the value of the objectGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectGUID(String value) {
            this.objectGUID = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
