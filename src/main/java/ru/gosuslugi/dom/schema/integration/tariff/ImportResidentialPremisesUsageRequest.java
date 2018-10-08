
package ru.gosuslugi.dom.schema.integration.tariff;

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
 *         &lt;element name="importResidentialPremisesUsage" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransportGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="TariffGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadResidentialPremisesUsage" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ResidentialPremisesUsageType"/&gt;
 *                     &lt;element name="CancelResidentialPremisesUsage"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type"/&gt;
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
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.14.0.5""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importResidentialPremisesUsage"
})
@XmlRootElement(name = "importResidentialPremisesUsageRequest")
public class ImportResidentialPremisesUsageRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage> importResidentialPremisesUsage;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importResidentialPremisesUsage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importResidentialPremisesUsage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportResidentialPremisesUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage }
     * 
     * 
     */
    public List<ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage> getImportResidentialPremisesUsage() {
        if (importResidentialPremisesUsage == null) {
            importResidentialPremisesUsage = new ArrayList<ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage>();
        }
        return this.importResidentialPremisesUsage;
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
            return "11.14.0.5";
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
     *         &lt;element name="TransportGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="TariffGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadResidentialPremisesUsage" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}ResidentialPremisesUsageType"/&gt;
     *           &lt;element name="CancelResidentialPremisesUsage"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type"/&gt;
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
        "transportGUID",
        "tariffGUID",
        "loadResidentialPremisesUsage",
        "cancelResidentialPremisesUsage"
    })
    public static class ImportResidentialPremisesUsage {

        @XmlElement(name = "TransportGUID", required = true)
        protected String transportGUID;
        @XmlElement(name = "TariffGUID")
        protected String tariffGUID;
        @XmlElement(name = "LoadResidentialPremisesUsage")
        protected ResidentialPremisesUsageType loadResidentialPremisesUsage;
        @XmlElement(name = "CancelResidentialPremisesUsage")
        protected ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage.CancelResidentialPremisesUsage cancelResidentialPremisesUsage;

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
         * Gets the value of the tariffGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTariffGUID() {
            return tariffGUID;
        }

        /**
         * Sets the value of the tariffGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTariffGUID(String value) {
            this.tariffGUID = value;
        }

        /**
         * Gets the value of the loadResidentialPremisesUsage property.
         * 
         * @return
         *     possible object is
         *     {@link ResidentialPremisesUsageType }
         *     
         */
        public ResidentialPremisesUsageType getLoadResidentialPremisesUsage() {
            return loadResidentialPremisesUsage;
        }

        /**
         * Sets the value of the loadResidentialPremisesUsage property.
         * 
         * @param value
         *     allowed object is
         *     {@link ResidentialPremisesUsageType }
         *     
         */
        public void setLoadResidentialPremisesUsage(ResidentialPremisesUsageType value) {
            this.loadResidentialPremisesUsage = value;
        }

        /**
         * Gets the value of the cancelResidentialPremisesUsage property.
         * 
         * @return
         *     possible object is
         *     {@link ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage.CancelResidentialPremisesUsage }
         *     
         */
        public ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage.CancelResidentialPremisesUsage getCancelResidentialPremisesUsage() {
            return cancelResidentialPremisesUsage;
        }

        /**
         * Sets the value of the cancelResidentialPremisesUsage property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage.CancelResidentialPremisesUsage }
         *     
         */
        public void setCancelResidentialPremisesUsage(ImportResidentialPremisesUsageRequest.ImportResidentialPremisesUsage.CancelResidentialPremisesUsage value) {
            this.cancelResidentialPremisesUsage = value;
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
         *         &lt;element name="CancelReason" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}String4000Type"/&gt;
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
            "cancelReason"
        })
        public static class CancelResidentialPremisesUsage {

            @XmlElement(name = "CancelReason", required = true)
            protected String cancelReason;

            /**
             * Gets the value of the cancelReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCancelReason() {
                return cancelReason;
            }

            /**
             * Sets the value of the cancelReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCancelReason(String value) {
                this.cancelReason = value;
            }

        }

    }

}
