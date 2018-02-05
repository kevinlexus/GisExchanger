
package ru.gosuslugi.dom.schema.integration.capital_repair;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType">
 *       &lt;sequence>
 *         &lt;element name="importRegionalProgram">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="RegionalProgramGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="LoadRegionalProgram" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramPasportType" minOccurs="0"/>
 *                   &lt;element name="RegionalProgramDocument" maxOccurs="1000" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;choice minOccurs="0">
 *                     &lt;element name="DeleteRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="PublishRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="CancelRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.10""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importRegionalProgram"
})
@XmlRootElement(name = "importRegionalProgramRequest")
public class ImportRegionalProgramRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected ImportRegionalProgramRequest.ImportRegionalProgram importRegionalProgram;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importRegionalProgram property.
     * 
     * @return
     *     possible object is
     *     {@link ImportRegionalProgramRequest.ImportRegionalProgram }
     *     
     */
    public ImportRegionalProgramRequest.ImportRegionalProgram getImportRegionalProgram() {
        return importRegionalProgram;
    }

    /**
     * Sets the value of the importRegionalProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportRegionalProgramRequest.ImportRegionalProgram }
     *     
     */
    public void setImportRegionalProgram(ImportRegionalProgramRequest.ImportRegionalProgram value) {
        this.importRegionalProgram = value;
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
            return "11.2.0.10";
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
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="RegionalProgramGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="LoadRegionalProgram" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}RegionalProgramPasportType" minOccurs="0"/>
     *         &lt;element name="RegionalProgramDocument" maxOccurs="1000" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;choice minOccurs="0">
     *           &lt;element name="DeleteRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="PublishRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *           &lt;element name="CancelRegionalProgram" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    @XmlType(name = "", propOrder = {
        "transportGuid",
        "regionalProgramGuid",
        "loadRegionalProgram",
        "regionalProgramDocument",
        "deleteRegionalProgram",
        "publishRegionalProgram",
        "cancelRegionalProgram"
    })
    public static class ImportRegionalProgram {

        @XmlElement(name = "TransportGuid")
        protected String transportGuid;
        @XmlElement(name = "RegionalProgramGuid")
        protected String regionalProgramGuid;
        @XmlElement(name = "LoadRegionalProgram")
        protected RegionalProgramPasportType loadRegionalProgram;
        @XmlElement(name = "RegionalProgramDocument")
        protected List<ImportRegionalProgramRequest.ImportRegionalProgram.RegionalProgramDocument> regionalProgramDocument;
        @XmlElement(name = "DeleteRegionalProgram")
        protected Boolean deleteRegionalProgram;
        @XmlElement(name = "PublishRegionalProgram")
        protected Boolean publishRegionalProgram;
        @XmlElement(name = "CancelRegionalProgram")
        protected Boolean cancelRegionalProgram;

        /**
         * Gets the value of the transportGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransportGuid() {
            return transportGuid;
        }

        /**
         * Sets the value of the transportGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransportGuid(String value) {
            this.transportGuid = value;
        }

        /**
         * Gets the value of the regionalProgramGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegionalProgramGuid() {
            return regionalProgramGuid;
        }

        /**
         * Sets the value of the regionalProgramGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegionalProgramGuid(String value) {
            this.regionalProgramGuid = value;
        }

        /**
         * Gets the value of the loadRegionalProgram property.
         * 
         * @return
         *     possible object is
         *     {@link RegionalProgramPasportType }
         *     
         */
        public RegionalProgramPasportType getLoadRegionalProgram() {
            return loadRegionalProgram;
        }

        /**
         * Sets the value of the loadRegionalProgram property.
         * 
         * @param value
         *     allowed object is
         *     {@link RegionalProgramPasportType }
         *     
         */
        public void setLoadRegionalProgram(RegionalProgramPasportType value) {
            this.loadRegionalProgram = value;
        }

        /**
         * Gets the value of the regionalProgramDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the regionalProgramDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRegionalProgramDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportRegionalProgramRequest.ImportRegionalProgram.RegionalProgramDocument }
         * 
         * 
         */
        public List<ImportRegionalProgramRequest.ImportRegionalProgram.RegionalProgramDocument> getRegionalProgramDocument() {
            if (regionalProgramDocument == null) {
                regionalProgramDocument = new ArrayList<ImportRegionalProgramRequest.ImportRegionalProgram.RegionalProgramDocument>();
            }
            return this.regionalProgramDocument;
        }

        /**
         * Gets the value of the deleteRegionalProgram property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isDeleteRegionalProgram() {
            return deleteRegionalProgram;
        }

        /**
         * Sets the value of the deleteRegionalProgram property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setDeleteRegionalProgram(Boolean value) {
            this.deleteRegionalProgram = value;
        }

        /**
         * Gets the value of the publishRegionalProgram property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isPublishRegionalProgram() {
            return publishRegionalProgram;
        }

        /**
         * Sets the value of the publishRegionalProgram property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setPublishRegionalProgram(Boolean value) {
            this.publishRegionalProgram = value;
        }

        /**
         * Gets the value of the cancelRegionalProgram property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelRegionalProgram() {
            return cancelRegionalProgram;
        }

        /**
         * Sets the value of the cancelRegionalProgram property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelRegionalProgram(Boolean value) {
            this.cancelRegionalProgram = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ImportDocumentType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class RegionalProgramDocument
            extends ImportDocumentType
        {


        }

    }

}
