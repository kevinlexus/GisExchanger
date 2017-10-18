
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Заявка на предоставление доступа
 * 
 * <p>Java class for AccessRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccessRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessRequestGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *         &lt;element name="Type" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}AccessRequestType"/>
 *         &lt;element name="ApplicationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-common/}AccessRequestStatus"/>
 *         &lt;element name="StatusChangeDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="StatusReason" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DelegatedAccessRight" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AccessRightGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="TerritoryInfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="AllTerritories" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="ExistListOfTerritory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ObjectInfo">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="AllObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="ExistListOfObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="InformationType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "AccessRequest", propOrder = {
    "accessRequestGUID",
    "type",
    "applicationDate",
    "startDate",
    "endDate",
    "status",
    "statusChangeDate",
    "statusReason",
    "delegatedAccessRight"
})
public class AccessRequest {

    @XmlElement(name = "AccessRequestGUID", required = true)
    protected String accessRequestGUID;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected AccessRequestType type;
    @XmlElement(name = "ApplicationDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar applicationDate;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "Status", required = true)
    @XmlSchemaType(name = "string")
    protected AccessRequestStatus status;
    @XmlElement(name = "StatusChangeDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar statusChangeDate;
    @XmlElement(name = "StatusReason")
    protected String statusReason;
    @XmlElement(name = "DelegatedAccessRight")
    protected List<AccessRequest.DelegatedAccessRight> delegatedAccessRight;

    /**
     * Gets the value of the accessRequestGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessRequestGUID() {
        return accessRequestGUID;
    }

    /**
     * Sets the value of the accessRequestGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessRequestGUID(String value) {
        this.accessRequestGUID = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AccessRequestType }
     *     
     */
    public AccessRequestType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessRequestType }
     *     
     */
    public void setType(AccessRequestType value) {
        this.type = value;
    }

    /**
     * Gets the value of the applicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets the value of the applicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDate(XMLGregorianCalendar value) {
        this.applicationDate = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AccessRequestStatus }
     *     
     */
    public AccessRequestStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessRequestStatus }
     *     
     */
    public void setStatus(AccessRequestStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatusChangeDate() {
        return statusChangeDate;
    }

    /**
     * Sets the value of the statusChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatusChangeDate(XMLGregorianCalendar value) {
        this.statusChangeDate = value;
    }

    /**
     * Gets the value of the statusReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusReason() {
        return statusReason;
    }

    /**
     * Sets the value of the statusReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusReason(String value) {
        this.statusReason = value;
    }

    /**
     * Gets the value of the delegatedAccessRight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delegatedAccessRight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelegatedAccessRight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessRequest.DelegatedAccessRight }
     * 
     * 
     */
    public List<AccessRequest.DelegatedAccessRight> getDelegatedAccessRight() {
        if (delegatedAccessRight == null) {
            delegatedAccessRight = new ArrayList<AccessRequest.DelegatedAccessRight>();
        }
        return this.delegatedAccessRight;
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
     *         &lt;element name="AccessRightGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="TerritoryInfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="AllTerritories" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="ExistListOfTerritory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ObjectInfo">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="AllObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="ExistListOfObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="InformationType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded"/>
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
        "accessRightGUID",
        "territoryInfo",
        "objectInfo",
        "isActual",
        "informationType"
    })
    public static class DelegatedAccessRight {

        @XmlElement(name = "AccessRightGUID", required = true)
        protected String accessRightGUID;
        @XmlElement(name = "TerritoryInfo", required = true)
        protected AccessRequest.DelegatedAccessRight.TerritoryInfo territoryInfo;
        @XmlElement(name = "ObjectInfo", required = true)
        protected AccessRequest.DelegatedAccessRight.ObjectInfo objectInfo;
        @XmlElement(name = "IsActual")
        protected boolean isActual;
        @XmlElement(name = "InformationType", required = true)
        protected List<NsiRef> informationType;

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
         * Gets the value of the territoryInfo property.
         * 
         * @return
         *     possible object is
         *     {@link AccessRequest.DelegatedAccessRight.TerritoryInfo }
         *     
         */
        public AccessRequest.DelegatedAccessRight.TerritoryInfo getTerritoryInfo() {
            return territoryInfo;
        }

        /**
         * Sets the value of the territoryInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link AccessRequest.DelegatedAccessRight.TerritoryInfo }
         *     
         */
        public void setTerritoryInfo(AccessRequest.DelegatedAccessRight.TerritoryInfo value) {
            this.territoryInfo = value;
        }

        /**
         * Gets the value of the objectInfo property.
         * 
         * @return
         *     possible object is
         *     {@link AccessRequest.DelegatedAccessRight.ObjectInfo }
         *     
         */
        public AccessRequest.DelegatedAccessRight.ObjectInfo getObjectInfo() {
            return objectInfo;
        }

        /**
         * Sets the value of the objectInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link AccessRequest.DelegatedAccessRight.ObjectInfo }
         *     
         */
        public void setObjectInfo(AccessRequest.DelegatedAccessRight.ObjectInfo value) {
            this.objectInfo = value;
        }

        /**
         * Gets the value of the isActual property.
         * 
         */
        public boolean isIsActual() {
            return isActual;
        }

        /**
         * Sets the value of the isActual property.
         * 
         */
        public void setIsActual(boolean value) {
            this.isActual = value;
        }

        /**
         * Gets the value of the informationType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the informationType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInformationType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NsiRef }
         * 
         * 
         */
        public List<NsiRef> getInformationType() {
            if (informationType == null) {
                informationType = new ArrayList<NsiRef>();
            }
            return this.informationType;
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
         *       &lt;choice>
         *         &lt;element name="AllObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="ExistListOfObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "allObjects",
            "existListOfObjects"
        })
        public static class ObjectInfo {

            @XmlElement(name = "AllObjects")
            protected Boolean allObjects;
            @XmlElement(name = "ExistListOfObjects")
            protected Boolean existListOfObjects;

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
             * Gets the value of the existListOfObjects property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isExistListOfObjects() {
                return existListOfObjects;
            }

            /**
             * Sets the value of the existListOfObjects property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setExistListOfObjects(Boolean value) {
                this.existListOfObjects = value;
            }

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
         *       &lt;choice>
         *         &lt;element name="AllTerritories" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="ExistListOfTerritory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "allTerritories",
            "existListOfTerritory"
        })
        public static class TerritoryInfo {

            @XmlElement(name = "AllTerritories")
            protected Boolean allTerritories;
            @XmlElement(name = "ExistListOfTerritory")
            protected Boolean existListOfTerritory;

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

            /**
             * Gets the value of the existListOfTerritory property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isExistListOfTerritory() {
                return existListOfTerritory;
            }

            /**
             * Sets the value of the existListOfTerritory property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setExistListOfTerritory(Boolean value) {
                this.existListOfTerritory = value;
            }

        }

    }

}
