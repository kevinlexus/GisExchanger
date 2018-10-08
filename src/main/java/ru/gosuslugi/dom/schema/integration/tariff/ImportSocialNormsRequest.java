
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
 *         &lt;element name="importSocialNorm" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransportGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="TariffGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadSocialNorm" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}SocialNormType"/&gt;
 *                     &lt;element name="CancelSocialNorm"&gt;
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
    "importSocialNorm"
})
@XmlRootElement(name = "importSocialNormsRequest")
public class ImportSocialNormsRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportSocialNormsRequest.ImportSocialNorm> importSocialNorm;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importSocialNorm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importSocialNorm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportSocialNorm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportSocialNormsRequest.ImportSocialNorm }
     * 
     * 
     */
    public List<ImportSocialNormsRequest.ImportSocialNorm> getImportSocialNorm() {
        if (importSocialNorm == null) {
            importSocialNorm = new ArrayList<ImportSocialNormsRequest.ImportSocialNorm>();
        }
        return this.importSocialNorm;
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
     *           &lt;element name="LoadSocialNorm" type="{http://dom.gosuslugi.ru/schema/integration/tariff/}SocialNormType"/&gt;
     *           &lt;element name="CancelSocialNorm"&gt;
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
        "loadSocialNorm",
        "cancelSocialNorm"
    })
    public static class ImportSocialNorm {

        @XmlElement(name = "TransportGUID", required = true)
        protected String transportGUID;
        @XmlElement(name = "TariffGUID")
        protected String tariffGUID;
        @XmlElement(name = "LoadSocialNorm")
        protected SocialNormType loadSocialNorm;
        @XmlElement(name = "CancelSocialNorm")
        protected ImportSocialNormsRequest.ImportSocialNorm.CancelSocialNorm cancelSocialNorm;

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
         * Gets the value of the loadSocialNorm property.
         * 
         * @return
         *     possible object is
         *     {@link SocialNormType }
         *     
         */
        public SocialNormType getLoadSocialNorm() {
            return loadSocialNorm;
        }

        /**
         * Sets the value of the loadSocialNorm property.
         * 
         * @param value
         *     allowed object is
         *     {@link SocialNormType }
         *     
         */
        public void setLoadSocialNorm(SocialNormType value) {
            this.loadSocialNorm = value;
        }

        /**
         * Gets the value of the cancelSocialNorm property.
         * 
         * @return
         *     possible object is
         *     {@link ImportSocialNormsRequest.ImportSocialNorm.CancelSocialNorm }
         *     
         */
        public ImportSocialNormsRequest.ImportSocialNorm.CancelSocialNorm getCancelSocialNorm() {
            return cancelSocialNorm;
        }

        /**
         * Sets the value of the cancelSocialNorm property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportSocialNormsRequest.ImportSocialNorm.CancelSocialNorm }
         *     
         */
        public void setCancelSocialNorm(ImportSocialNormsRequest.ImportSocialNorm.CancelSocialNorm value) {
            this.cancelSocialNorm = value;
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
        public static class CancelSocialNorm {

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
