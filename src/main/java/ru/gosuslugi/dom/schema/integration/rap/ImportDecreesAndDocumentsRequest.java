
package ru.gosuslugi.dom.schema.integration.rap;

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
 *         &lt;element name="importDecreesAndDocuments" maxOccurs="1000">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence>
 *                     &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                     &lt;element name="DecreeGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;/sequence>
 *                   &lt;choice>
 *                     &lt;sequence>
 *                       &lt;element name="Decree" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                               &lt;sequence>
 *                                 &lt;element name="DecreeInfo">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeInfoType">
 *                                       &lt;/extension>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                             &lt;/restriction>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="ChangeReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ChangeReasonType" minOccurs="0"/>
 *                       &lt;element name="ImportProceduralDocuments" maxOccurs="100" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                               &lt;sequence>
 *                                 &lt;sequence>
 *                                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                                   &lt;element name="ProceduralDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                                 &lt;/sequence>
 *                                 &lt;choice>
 *                                   &lt;element name="ProceduralDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/>
 *                                   &lt;element name="DeleteProceduralDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                                 &lt;/choice>
 *                               &lt;/sequence>
 *                             &lt;/restriction>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                     &lt;element name="CancelDecree">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}CancelReasonType"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="AnnulDecree" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.10.0.5""/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importDecreesAndDocuments"
})
@XmlRootElement(name = "ImportDecreesAndDocumentsRequest")
public class ImportDecreesAndDocumentsRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments> importDecreesAndDocuments;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importDecreesAndDocuments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importDecreesAndDocuments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportDecreesAndDocuments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments }
     * 
     * 
     */
    public List<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments> getImportDecreesAndDocuments() {
        if (importDecreesAndDocuments == null) {
            importDecreesAndDocuments = new ArrayList<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments>();
        }
        return this.importDecreesAndDocuments;
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
            return "11.10.0.5";
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
     *         &lt;sequence>
     *           &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *           &lt;element name="DecreeGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;/sequence>
     *         &lt;choice>
     *           &lt;sequence>
     *             &lt;element name="Decree" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                     &lt;sequence>
     *                       &lt;element name="DecreeInfo">
     *                         &lt;complexType>
     *                           &lt;complexContent>
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeInfoType">
     *                             &lt;/extension>
     *                           &lt;/complexContent>
     *                         &lt;/complexType>
     *                       &lt;/element>
     *                     &lt;/sequence>
     *                   &lt;/restriction>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *             &lt;element name="ChangeReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ChangeReasonType" minOccurs="0"/>
     *             &lt;element name="ImportProceduralDocuments" maxOccurs="100" minOccurs="0">
     *               &lt;complexType>
     *                 &lt;complexContent>
     *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                     &lt;sequence>
     *                       &lt;sequence>
     *                         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                         &lt;element name="ProceduralDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *                       &lt;/sequence>
     *                       &lt;choice>
     *                         &lt;element name="ProceduralDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/>
     *                         &lt;element name="DeleteProceduralDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                       &lt;/choice>
     *                     &lt;/sequence>
     *                   &lt;/restriction>
     *                 &lt;/complexContent>
     *               &lt;/complexType>
     *             &lt;/element>
     *           &lt;/sequence>
     *           &lt;element name="CancelDecree">
     *             &lt;complexType>
     *               &lt;complexContent>
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                   &lt;sequence>
     *                     &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}CancelReasonType"/>
     *                   &lt;/sequence>
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *           &lt;element name="AnnulDecree" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
        "decreeGuid",
        "decree",
        "changeReason",
        "importProceduralDocuments",
        "cancelDecree",
        "annulDecree"
    })
    public static class ImportDecreesAndDocuments {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "DecreeGuid")
        protected String decreeGuid;
        @XmlElement(name = "Decree")
        protected ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree decree;
        @XmlElement(name = "ChangeReason")
        protected ChangeReasonType changeReason;
        @XmlElement(name = "ImportProceduralDocuments")
        protected List<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.ImportProceduralDocuments> importProceduralDocuments;
        @XmlElement(name = "CancelDecree")
        protected ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.CancelDecree cancelDecree;
        @XmlElement(name = "AnnulDecree")
        protected Boolean annulDecree;

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
         * Gets the value of the decreeGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDecreeGuid() {
            return decreeGuid;
        }

        /**
         * Sets the value of the decreeGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDecreeGuid(String value) {
            this.decreeGuid = value;
        }

        /**
         * Gets the value of the decree property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree }
         *     
         */
        public ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree getDecree() {
            return decree;
        }

        /**
         * Sets the value of the decree property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree }
         *     
         */
        public void setDecree(ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree value) {
            this.decree = value;
        }

        /**
         * Gets the value of the changeReason property.
         * 
         * @return
         *     possible object is
         *     {@link ChangeReasonType }
         *     
         */
        public ChangeReasonType getChangeReason() {
            return changeReason;
        }

        /**
         * Sets the value of the changeReason property.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeReasonType }
         *     
         */
        public void setChangeReason(ChangeReasonType value) {
            this.changeReason = value;
        }

        /**
         * Gets the value of the importProceduralDocuments property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the importProceduralDocuments property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImportProceduralDocuments().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.ImportProceduralDocuments }
         * 
         * 
         */
        public List<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.ImportProceduralDocuments> getImportProceduralDocuments() {
            if (importProceduralDocuments == null) {
                importProceduralDocuments = new ArrayList<ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.ImportProceduralDocuments>();
            }
            return this.importProceduralDocuments;
        }

        /**
         * Gets the value of the cancelDecree property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.CancelDecree }
         *     
         */
        public ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.CancelDecree getCancelDecree() {
            return cancelDecree;
        }

        /**
         * Sets the value of the cancelDecree property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.CancelDecree }
         *     
         */
        public void setCancelDecree(ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.CancelDecree value) {
            this.cancelDecree = value;
        }

        /**
         * Gets the value of the annulDecree property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAnnulDecree() {
            return annulDecree;
        }

        /**
         * Sets the value of the annulDecree property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAnnulDecree(Boolean value) {
            this.annulDecree = value;
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
         *         &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/rap/}CancelReasonType"/>
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
            "cancelReason"
        })
        public static class CancelDecree {

            @XmlElement(name = "CancelReason", required = true)
            protected CancelReasonType cancelReason;

            /**
             * Gets the value of the cancelReason property.
             * 
             * @return
             *     possible object is
             *     {@link CancelReasonType }
             *     
             */
            public CancelReasonType getCancelReason() {
                return cancelReason;
            }

            /**
             * Sets the value of the cancelReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link CancelReasonType }
             *     
             */
            public void setCancelReason(CancelReasonType value) {
                this.cancelReason = value;
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
         *       &lt;sequence>
         *         &lt;element name="DecreeInfo">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeInfoType">
         *               &lt;/extension>
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
        @XmlType(name = "", propOrder = {
            "decreeInfo"
        })
        public static class Decree {

            @XmlElement(name = "DecreeInfo", required = true)
            protected ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo decreeInfo;

            /**
             * Gets the value of the decreeInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo }
             *     
             */
            public ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo getDecreeInfo() {
                return decreeInfo;
            }

            /**
             * Sets the value of the decreeInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo }
             *     
             */
            public void setDecreeInfo(ImportDecreesAndDocumentsRequest.ImportDecreesAndDocuments.Decree.DecreeInfo value) {
                this.decreeInfo = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/rap/}DecreeInfoType">
             *     &lt;/extension>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class DecreeInfo
                extends DecreeInfoType
            {


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
         *       &lt;sequence>
         *         &lt;sequence>
         *           &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *           &lt;element name="ProceduralDocumentGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
         *         &lt;/sequence>
         *         &lt;choice>
         *           &lt;element name="ProceduralDocument" type="{http://dom.gosuslugi.ru/schema/integration/rap/}ProceduralDocumentType"/>
         *           &lt;element name="DeleteProceduralDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "proceduralDocumentGUID",
            "proceduralDocument",
            "deleteProceduralDocument"
        })
        public static class ImportProceduralDocuments {

            @XmlElement(name = "TransportGuid", required = true)
            protected String transportGuid;
            @XmlElement(name = "ProceduralDocumentGUID")
            protected String proceduralDocumentGUID;
            @XmlElement(name = "ProceduralDocument")
            protected ProceduralDocumentType proceduralDocument;
            @XmlElement(name = "DeleteProceduralDocument")
            protected Boolean deleteProceduralDocument;

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
             * Gets the value of the proceduralDocumentGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProceduralDocumentGUID() {
                return proceduralDocumentGUID;
            }

            /**
             * Sets the value of the proceduralDocumentGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProceduralDocumentGUID(String value) {
                this.proceduralDocumentGUID = value;
            }

            /**
             * Gets the value of the proceduralDocument property.
             * 
             * @return
             *     possible object is
             *     {@link ProceduralDocumentType }
             *     
             */
            public ProceduralDocumentType getProceduralDocument() {
                return proceduralDocument;
            }

            /**
             * Sets the value of the proceduralDocument property.
             * 
             * @param value
             *     allowed object is
             *     {@link ProceduralDocumentType }
             *     
             */
            public void setProceduralDocument(ProceduralDocumentType value) {
                this.proceduralDocument = value;
            }

            /**
             * Gets the value of the deleteProceduralDocument property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDeleteProceduralDocument() {
                return deleteProceduralDocument;
            }

            /**
             * Sets the value of the deleteProceduralDocument property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDeleteProceduralDocument(Boolean value) {
                this.deleteProceduralDocument = value;
            }

        }

    }

}
