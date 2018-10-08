
package ru.gosuslugi.dom.schema.integration.volume_quality;

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
 *         &lt;element name="importInterval" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseShortType"/&gt;
 *                   &lt;element name="IntervalGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadInterval" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IntervalType"/&gt;
 *                     &lt;element name="AnnulmentInterval"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="ReasonOfAnnulment"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
 *                                     &lt;minLength value="1"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
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
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.11.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importInterval"
})
@XmlRootElement(name = "importIntervalRequest")
public class ImportIntervalRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportIntervalRequest.ImportInterval> importInterval;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importInterval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importInterval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportInterval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportIntervalRequest.ImportInterval }
     * 
     * 
     */
    public List<ImportIntervalRequest.ImportInterval> getImportInterval() {
        if (importInterval == null) {
            importInterval = new ArrayList<ImportIntervalRequest.ImportInterval>();
        }
        return this.importInterval;
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
            return "11.11.0.1";
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
     *         &lt;element name="Base" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}BaseShortType"/&gt;
     *         &lt;element name="IntervalGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadInterval" type="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}IntervalType"/&gt;
     *           &lt;element name="AnnulmentInterval"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="ReasonOfAnnulment"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
     *                           &lt;minLength value="1"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
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
        "base",
        "intervalGuid",
        "transportGuid",
        "loadInterval",
        "annulmentInterval"
    })
    public static class ImportInterval {

        @XmlElement(name = "Base", required = true)
        protected BaseShortType base;
        @XmlElement(name = "IntervalGuid")
        protected String intervalGuid;
        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "LoadInterval")
        protected IntervalType loadInterval;
        @XmlElement(name = "AnnulmentInterval")
        protected ImportIntervalRequest.ImportInterval.AnnulmentInterval annulmentInterval;

        /**
         * Gets the value of the base property.
         * 
         * @return
         *     possible object is
         *     {@link BaseShortType }
         *     
         */
        public BaseShortType getBase() {
            return base;
        }

        /**
         * Sets the value of the base property.
         * 
         * @param value
         *     allowed object is
         *     {@link BaseShortType }
         *     
         */
        public void setBase(BaseShortType value) {
            this.base = value;
        }

        /**
         * Gets the value of the intervalGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIntervalGuid() {
            return intervalGuid;
        }

        /**
         * Sets the value of the intervalGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIntervalGuid(String value) {
            this.intervalGuid = value;
        }

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
         * Gets the value of the loadInterval property.
         * 
         * @return
         *     possible object is
         *     {@link IntervalType }
         *     
         */
        public IntervalType getLoadInterval() {
            return loadInterval;
        }

        /**
         * Sets the value of the loadInterval property.
         * 
         * @param value
         *     allowed object is
         *     {@link IntervalType }
         *     
         */
        public void setLoadInterval(IntervalType value) {
            this.loadInterval = value;
        }

        /**
         * Gets the value of the annulmentInterval property.
         * 
         * @return
         *     possible object is
         *     {@link ImportIntervalRequest.ImportInterval.AnnulmentInterval }
         *     
         */
        public ImportIntervalRequest.ImportInterval.AnnulmentInterval getAnnulmentInterval() {
            return annulmentInterval;
        }

        /**
         * Sets the value of the annulmentInterval property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportIntervalRequest.ImportInterval.AnnulmentInterval }
         *     
         */
        public void setAnnulmentInterval(ImportIntervalRequest.ImportInterval.AnnulmentInterval value) {
            this.annulmentInterval = value;
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
         *         &lt;element name="ReasonOfAnnulment"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/volume-quality/}ReasonOfAnnulmentType"&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
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
            "reasonOfAnnulment"
        })
        public static class AnnulmentInterval {

            @XmlElement(name = "ReasonOfAnnulment", required = true)
            protected String reasonOfAnnulment;

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

    }

}
