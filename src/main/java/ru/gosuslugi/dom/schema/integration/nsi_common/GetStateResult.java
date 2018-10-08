
package ru.gosuslugi.dom.schema.integration.nsi_common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *         &lt;element name="NsiItem" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemType"/&gt;
 *         &lt;element name="NsiPagingItem"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TotalItemsCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="TotalPages" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="CurrentPage" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="NsiList" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiListType"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.2""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "nsiItem",
    "nsiPagingItem",
    "nsiList"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "NsiItem")
    protected NsiItemType nsiItem;
    @XmlElement(name = "NsiPagingItem")
    protected GetStateResult.NsiPagingItem nsiPagingItem;
    @XmlElement(name = "NsiList")
    protected NsiListType nsiList;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the nsiItem property.
     * 
     * @return
     *     possible object is
     *     {@link NsiItemType }
     *     
     */
    public NsiItemType getNsiItem() {
        return nsiItem;
    }

    /**
     * Sets the value of the nsiItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiItemType }
     *     
     */
    public void setNsiItem(NsiItemType value) {
        this.nsiItem = value;
    }

    /**
     * Gets the value of the nsiPagingItem property.
     * 
     * @return
     *     possible object is
     *     {@link GetStateResult.NsiPagingItem }
     *     
     */
    public GetStateResult.NsiPagingItem getNsiPagingItem() {
        return nsiPagingItem;
    }

    /**
     * Sets the value of the nsiPagingItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStateResult.NsiPagingItem }
     *     
     */
    public void setNsiPagingItem(GetStateResult.NsiPagingItem value) {
        this.nsiPagingItem = value;
    }

    /**
     * Gets the value of the nsiList property.
     * 
     * @return
     *     possible object is
     *     {@link NsiListType }
     *     
     */
    public NsiListType getNsiList() {
        return nsiList;
    }

    /**
     * Sets the value of the nsiList property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiListType }
     *     
     */
    public void setNsiList(NsiListType value) {
        this.nsiList = value;
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
            return "10.0.1.2";
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiItemType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="TotalItemsCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="TotalPages" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="CurrentPage" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "totalItemsCount",
        "totalPages",
        "currentPage"
    })
    public static class NsiPagingItem
        extends NsiItemType
    {

        @XmlElement(name = "TotalItemsCount")
        protected int totalItemsCount;
        @XmlElement(name = "TotalPages")
        protected int totalPages;
        @XmlElement(name = "CurrentPage", required = true)
        protected Object currentPage;

        /**
         * Gets the value of the totalItemsCount property.
         * 
         */
        public int getTotalItemsCount() {
            return totalItemsCount;
        }

        /**
         * Sets the value of the totalItemsCount property.
         * 
         */
        public void setTotalItemsCount(int value) {
            this.totalItemsCount = value;
        }

        /**
         * Gets the value of the totalPages property.
         * 
         */
        public int getTotalPages() {
            return totalPages;
        }

        /**
         * Sets the value of the totalPages property.
         * 
         */
        public void setTotalPages(int value) {
            this.totalPages = value;
        }

        /**
         * Gets the value of the currentPage property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCurrentPage() {
            return currentPage;
        }

        /**
         * Sets the value of the currentPage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCurrentPage(Object value) {
            this.currentPage = value;
        }

    }

}
