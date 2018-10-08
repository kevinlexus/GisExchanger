
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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="importDecision" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadDecision"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionPDType"&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="CancelDecision"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="DecisionGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.10.0.2""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importDecision"
})
@XmlRootElement(name = "importDecisionsOrderOfProvidingPDRequest")
public class ImportDecisionsOrderOfProvidingPDRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportDecisionsOrderOfProvidingPDRequest.ImportDecision> importDecision;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportDecisionsOrderOfProvidingPDRequest.ImportDecision }
     * 
     * 
     */
    public List<ImportDecisionsOrderOfProvidingPDRequest.ImportDecision> getImportDecision() {
        if (importDecision == null) {
            importDecision = new ArrayList<ImportDecisionsOrderOfProvidingPDRequest.ImportDecision>();
        }
        return this.importDecision;
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
            return "11.10.0.2";
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadDecision"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionPDType"&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="CancelDecision"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="DecisionGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
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
        "transportGuid",
        "loadDecision",
        "cancelDecision"
    })
    public static class ImportDecision {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "LoadDecision")
        protected ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision loadDecision;
        @XmlElement(name = "CancelDecision")
        protected ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.CancelDecision cancelDecision;

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
         * Gets the value of the loadDecision property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision }
         *     
         */
        public ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision getLoadDecision() {
            return loadDecision;
        }

        /**
         * Sets the value of the loadDecision property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision }
         *     
         */
        public void setLoadDecision(ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision value) {
            this.loadDecision = value;
        }

        /**
         * Gets the value of the cancelDecision property.
         * 
         * @return
         *     possible object is
         *     {@link ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.CancelDecision }
         *     
         */
        public ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.CancelDecision getCancelDecision() {
            return cancelDecision;
        }

        /**
         * Sets the value of the cancelDecision property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.CancelDecision }
         *     
         */
        public void setCancelDecision(ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.CancelDecision value) {
            this.cancelDecision = value;
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
         *         &lt;element name="DecisionGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
            "decisionGuid"
        })
        public static class CancelDecision {

            @XmlElement(name = "DecisionGuid", required = true)
            protected String decisionGuid;

            /**
             * Gets the value of the decisionGuid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDecisionGuid() {
                return decisionGuid;
            }

            /**
             * Sets the value of the decisionGuid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDecisionGuid(String value) {
                this.decisionGuid = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionPDType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class LoadDecision
            extends DecisionPDType
        {


        }

    }

}
