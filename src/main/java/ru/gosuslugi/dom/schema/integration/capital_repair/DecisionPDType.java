
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Тип данных для Решение/информация о порядке представления платежных документов
 * 
 * <p>Java class for DecisionPDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionPDType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DecisionCommonType">
 *       &lt;sequence>
 *         &lt;element name="Reason">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="Protocol">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ProtocolType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DecisionDocument">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="Document" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentDecisionType"/>
 *                             &lt;element name="DocumentIsAbsent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Model" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ModelType"/>
 *         &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionPDType", propOrder = {
    "reason",
    "model",
    "organization"
})
@XmlSeeAlso({
    ExportDecisionPDType.class,
    ru.gosuslugi.dom.schema.integration.capital_repair.ImportDecisionsOrderOfProvidingPDRequest.ImportDecision.LoadDecision.class
})
public class DecisionPDType
    extends DecisionCommonType
{

    @XmlElement(name = "Reason", required = true)
    protected DecisionPDType.Reason reason;
    @XmlElement(name = "Model", required = true)
    @XmlSchemaType(name = "token")
    protected ModelType model;
    @XmlElement(name = "Organization", required = true)
    protected RegOrgType organization;

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link DecisionPDType.Reason }
     *     
     */
    public DecisionPDType.Reason getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecisionPDType.Reason }
     *     
     */
    public void setReason(DecisionPDType.Reason value) {
        this.reason = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link ModelType }
     *     
     */
    public ModelType getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelType }
     *     
     */
    public void setModel(ModelType value) {
        this.model = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setOrganization(RegOrgType value) {
        this.organization = value;
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
     *         &lt;element name="Protocol">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ProtocolType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DecisionDocument">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="Document" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentDecisionType"/>
     *                   &lt;element name="DocumentIsAbsent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "protocol",
        "decisionDocument"
    })
    public static class Reason {

        @XmlElement(name = "Protocol")
        protected DecisionPDType.Reason.Protocol protocol;
        @XmlElement(name = "DecisionDocument")
        protected DecisionPDType.Reason.DecisionDocument decisionDocument;

        /**
         * Gets the value of the protocol property.
         * 
         * @return
         *     possible object is
         *     {@link DecisionPDType.Reason.Protocol }
         *     
         */
        public DecisionPDType.Reason.Protocol getProtocol() {
            return protocol;
        }

        /**
         * Sets the value of the protocol property.
         * 
         * @param value
         *     allowed object is
         *     {@link DecisionPDType.Reason.Protocol }
         *     
         */
        public void setProtocol(DecisionPDType.Reason.Protocol value) {
            this.protocol = value;
        }

        /**
         * Gets the value of the decisionDocument property.
         * 
         * @return
         *     possible object is
         *     {@link DecisionPDType.Reason.DecisionDocument }
         *     
         */
        public DecisionPDType.Reason.DecisionDocument getDecisionDocument() {
            return decisionDocument;
        }

        /**
         * Sets the value of the decisionDocument property.
         * 
         * @param value
         *     allowed object is
         *     {@link DecisionPDType.Reason.DecisionDocument }
         *     
         */
        public void setDecisionDocument(DecisionPDType.Reason.DecisionDocument value) {
            this.decisionDocument = value;
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
         *         &lt;element name="Document" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}DocumentDecisionType"/>
         *         &lt;element name="DocumentIsAbsent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
            "document",
            "documentIsAbsent"
        })
        public static class DecisionDocument {

            @XmlElement(name = "Document")
            protected DocumentDecisionType document;
            @XmlElement(name = "DocumentIsAbsent")
            protected Boolean documentIsAbsent;

            /**
             * Gets the value of the document property.
             * 
             * @return
             *     possible object is
             *     {@link DocumentDecisionType }
             *     
             */
            public DocumentDecisionType getDocument() {
                return document;
            }

            /**
             * Sets the value of the document property.
             * 
             * @param value
             *     allowed object is
             *     {@link DocumentDecisionType }
             *     
             */
            public void setDocument(DocumentDecisionType value) {
                this.document = value;
            }

            /**
             * Gets the value of the documentIsAbsent property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isDocumentIsAbsent() {
                return documentIsAbsent;
            }

            /**
             * Sets the value of the documentIsAbsent property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setDocumentIsAbsent(Boolean value) {
                this.documentIsAbsent = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}ProtocolType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Protocol
            extends ProtocolType
        {


        }

    }

}
