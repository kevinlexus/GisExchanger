
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
 *         &lt;element name="importFundSizeInfo" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransportGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="FundSizeInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="LoadFundSizeInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}FundSizeInfoType"/&gt;
 *                     &lt;element name="CancelFundSizeInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="12.0.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importFundSizeInfo"
})
@XmlRootElement(name = "importFundSizeInfoRequest")
public class ImportFundSizeInfoRequest
    extends BaseType
{

    @XmlElement(required = true)
    protected List<ImportFundSizeInfoRequest.ImportFundSizeInfo> importFundSizeInfo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importFundSizeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importFundSizeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportFundSizeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportFundSizeInfoRequest.ImportFundSizeInfo }
     * 
     * 
     */
    public List<ImportFundSizeInfoRequest.ImportFundSizeInfo> getImportFundSizeInfo() {
        if (importFundSizeInfo == null) {
            importFundSizeInfo = new ArrayList<ImportFundSizeInfoRequest.ImportFundSizeInfo>();
        }
        return this.importFundSizeInfo;
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
            return "12.0.0.1";
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
     *         &lt;element name="FundSizeInfoGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="LoadFundSizeInfo" type="{http://dom.gosuslugi.ru/schema/integration/capital-repair/}FundSizeInfoType"/&gt;
     *           &lt;element name="CancelFundSizeInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "fundSizeInfoGuid",
        "loadFundSizeInfo",
        "cancelFundSizeInfo"
    })
    public static class ImportFundSizeInfo {

        @XmlElement(name = "TransportGuid", required = true)
        protected String transportGuid;
        @XmlElement(name = "FundSizeInfoGuid")
        protected String fundSizeInfoGuid;
        @XmlElement(name = "LoadFundSizeInfo")
        protected FundSizeInfoType loadFundSizeInfo;
        @XmlElement(name = "CancelFundSizeInfo")
        protected Boolean cancelFundSizeInfo;

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
         * Gets the value of the fundSizeInfoGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFundSizeInfoGuid() {
            return fundSizeInfoGuid;
        }

        /**
         * Sets the value of the fundSizeInfoGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFundSizeInfoGuid(String value) {
            this.fundSizeInfoGuid = value;
        }

        /**
         * Gets the value of the loadFundSizeInfo property.
         * 
         * @return
         *     possible object is
         *     {@link FundSizeInfoType }
         *     
         */
        public FundSizeInfoType getLoadFundSizeInfo() {
            return loadFundSizeInfo;
        }

        /**
         * Sets the value of the loadFundSizeInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link FundSizeInfoType }
         *     
         */
        public void setLoadFundSizeInfo(FundSizeInfoType value) {
            this.loadFundSizeInfo = value;
        }

        /**
         * Gets the value of the cancelFundSizeInfo property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancelFundSizeInfo() {
            return cancelFundSizeInfo;
        }

        /**
         * Sets the value of the cancelFundSizeInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancelFundSizeInfo(Boolean value) {
            this.cancelFundSizeInfo = value;
        }

    }

}
