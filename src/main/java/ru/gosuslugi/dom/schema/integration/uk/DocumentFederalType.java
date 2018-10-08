
package ru.gosuslugi.dom.schema.integration.uk;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.RegionType;


/**
 * Документ закона/нормативно-правового акта федерального уровня
 * 
 * <p>Java class for DocumentFederalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentFederalType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentPortalType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Аudience" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="HeaderDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="PeopleDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="ProviderDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="GovernmentAuthorityDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                   &lt;element name="DefaultSearchDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Federal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/base/}RegionType" maxOccurs="1000"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentFederalType", propOrder = {
    "\u0430udience",
    "federal",
    "region"
})
public class DocumentFederalType
    extends DocumentPortalType
{

    @XmlElement(name = "\u0410udience")
    protected DocumentFederalType.Аudience аudience;
    @XmlElement(name = "Federal", defaultValue = "true")
    protected Boolean federal;
    @XmlElement(name = "Region")
    protected List<RegionType> region;

    /**
     * Gets the value of the аudience property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentFederalType.Аudience }
     *     
     */
    public DocumentFederalType.Аudience getАudience() {
        return аudience;
    }

    /**
     * Sets the value of the аudience property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentFederalType.Аudience }
     *     
     */
    public void setАudience(DocumentFederalType.Аudience value) {
        this.аudience = value;
    }

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
     * {@link RegionType }
     * 
     * 
     */
    public List<RegionType> getRegion() {
        if (region == null) {
            region = new ArrayList<RegionType>();
        }
        return this.region;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="HeaderDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="PeopleDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="ProviderDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="GovernmentAuthorityDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *         &lt;element name="DefaultSearchDocument" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "headerDocument",
        "peopleDocument",
        "providerDocument",
        "governmentAuthorityDocument",
        "defaultSearchDocument"
    })
    public static class Аudience {

        @XmlElement(name = "HeaderDocument", defaultValue = "true")
        protected Boolean headerDocument;
        @XmlElement(name = "PeopleDocument", defaultValue = "true")
        protected Boolean peopleDocument;
        @XmlElement(name = "ProviderDocument", defaultValue = "true")
        protected Boolean providerDocument;
        @XmlElement(name = "GovernmentAuthorityDocument", defaultValue = "true")
        protected Boolean governmentAuthorityDocument;
        @XmlElement(name = "DefaultSearchDocument", defaultValue = "true")
        protected Boolean defaultSearchDocument;

        /**
         * Gets the value of the headerDocument property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isHeaderDocument() {
            return headerDocument;
        }

        /**
         * Sets the value of the headerDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setHeaderDocument(Boolean value) {
            this.headerDocument = value;
        }

        /**
         * Gets the value of the peopleDocument property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPeopleDocument() {
            return peopleDocument;
        }

        /**
         * Sets the value of the peopleDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPeopleDocument(Boolean value) {
            this.peopleDocument = value;
        }

        /**
         * Gets the value of the providerDocument property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isProviderDocument() {
            return providerDocument;
        }

        /**
         * Sets the value of the providerDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setProviderDocument(Boolean value) {
            this.providerDocument = value;
        }

        /**
         * Gets the value of the governmentAuthorityDocument property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isGovernmentAuthorityDocument() {
            return governmentAuthorityDocument;
        }

        /**
         * Sets the value of the governmentAuthorityDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setGovernmentAuthorityDocument(Boolean value) {
            this.governmentAuthorityDocument = value;
        }

        /**
         * Gets the value of the defaultSearchDocument property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDefaultSearchDocument() {
            return defaultSearchDocument;
        }

        /**
         * Sets the value of the defaultSearchDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDefaultSearchDocument(Boolean value) {
            this.defaultSearchDocument = value;
        }

    }

}
