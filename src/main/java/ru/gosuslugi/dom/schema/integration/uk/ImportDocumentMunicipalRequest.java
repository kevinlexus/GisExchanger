
package ru.gosuslugi.dom.schema.integration.uk;

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
 *         &lt;element name="Document" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;choice>
 *                     &lt;element name="importDocument">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentMunicipalType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID" minOccurs="0"/>
 *                             &lt;/sequence>
 *                           &lt;/extension>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulmentDocument">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID"/>
 *                               &lt;element name="ReasonOfAnnulment">
 *                                 &lt;simpleType>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                     &lt;maxLength value="500"/>
 *                                     &lt;minLength value="1"/>
 *                                   &lt;/restriction>
 *                                 &lt;/simpleType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.2.0.2""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "document"
})
@XmlRootElement(name = "importDocumentMunicipalRequest")
public class ImportDocumentMunicipalRequest
    extends BaseType
{

    @XmlElement(name = "Document", required = true)
    protected List<ImportDocumentMunicipalRequest.Document> document;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportDocumentMunicipalRequest.Document }
     * 
     * 
     */
    public List<ImportDocumentMunicipalRequest.Document> getDocument() {
        if (document == null) {
            document = new ArrayList<ImportDocumentMunicipalRequest.Document>();
        }
        return this.document;
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
            return "11.2.0.2";
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;choice>
     *           &lt;element name="importDocument">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentMunicipalType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID" minOccurs="0"/>
     *                   &lt;/sequence>
     *                 &lt;/extension>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulmentDocument">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID"/>
     *                     &lt;element name="ReasonOfAnnulment">
     *                       &lt;simpleType>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                           &lt;maxLength value="500"/>
     *                           &lt;minLength value="1"/>
     *                         &lt;/restriction>
     *                       &lt;/simpleType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
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
        "transportGUID",
        "importDocument",
        "annulmentDocument"
    })
    public static class Document {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        protected ImportDocumentMunicipalRequest.Document.ImportDocument importDocument;
        @XmlElement(name = "AnnulmentDocument")
        protected ImportDocumentMunicipalRequest.Document.AnnulmentDocument annulmentDocument;

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
         * Gets the value of the importDocument property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDocumentMunicipalRequest.Document.ImportDocument }
         *     
         */
        public ImportDocumentMunicipalRequest.Document.ImportDocument getImportDocument() {
            return importDocument;
        }

        /**
         * Sets the value of the importDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDocumentMunicipalRequest.Document.ImportDocument }
         *     
         */
        public void setImportDocument(ImportDocumentMunicipalRequest.Document.ImportDocument value) {
            this.importDocument = value;
        }

        /**
         * Gets the value of the annulmentDocument property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDocumentMunicipalRequest.Document.AnnulmentDocument }
         *     
         */
        public ImportDocumentMunicipalRequest.Document.AnnulmentDocument getAnnulmentDocument() {
            return annulmentDocument;
        }

        /**
         * Sets the value of the annulmentDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDocumentMunicipalRequest.Document.AnnulmentDocument }
         *     
         */
        public void setAnnulmentDocument(ImportDocumentMunicipalRequest.Document.AnnulmentDocument value) {
            this.annulmentDocument = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID"/>
         *         &lt;element name="ReasonOfAnnulment">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="500"/>
         *               &lt;minLength value="1"/>
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
            "documentGUID",
            "reasonOfAnnulment"
        })
        public static class AnnulmentDocument {

            @XmlElement(name = "DocumentGUID", required = true)
            protected String documentGUID;
            @XmlElement(name = "ReasonOfAnnulment", required = true)
            protected String reasonOfAnnulment;

            /**
             * Gets the value of the documentGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocumentGUID() {
                return documentGUID;
            }

            /**
             * Sets the value of the documentGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocumentGUID(String value) {
                this.documentGUID = value;
            }

            /**
             * Gets the value of the reasonOfAnnulment property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReasonOfAnnulment() {
                return reasonOfAnnulment;
            }

            /**
             * Sets the value of the reasonOfAnnulment property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReasonOfAnnulment(String value) {
                this.reasonOfAnnulment = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentMunicipalType">
         *       &lt;sequence>
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentGUID" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "documentGUID"
        })
        public static class ImportDocument
            extends DocumentMunicipalType
        {

            @XmlElement(name = "DocumentGUID")
            protected String documentGUID;

            /**
             * Gets the value of the documentGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocumentGUID() {
                return documentGUID;
            }

            /**
             * Sets the value of the documentGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocumentGUID(String value) {
                this.documentGUID = value;
            }

        }

    }

}
