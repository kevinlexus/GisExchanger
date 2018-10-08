
package ru.gosuslugi.dom.schema.integration.nsi_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Составной тип. Наименование и значение поля типа "Ссылка на элемент справочника ФИАС" для элемента справочника.
 * 
 * <p>Java class for NsiElementFiasAddressRefFieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiElementFiasAddressRefFieldType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}NsiElementFieldType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NsiRef" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Guid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="aoGuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiElementFiasAddressRefFieldType", propOrder = {
    "nsiRef"
})
public class NsiElementFiasAddressRefFieldType
    extends NsiElementFieldType
{

    @XmlElement(name = "NsiRef")
    protected NsiElementFiasAddressRefFieldType.NsiRef nsiRef;

    /**
     * Gets the value of the nsiRef property.
     * 
     * @return
     *     possible object is
     *     {@link NsiElementFiasAddressRefFieldType.NsiRef }
     *     
     */
    public NsiElementFiasAddressRefFieldType.NsiRef getNsiRef() {
        return nsiRef;
    }

    /**
     * Sets the value of the nsiRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiElementFiasAddressRefFieldType.NsiRef }
     *     
     */
    public void setNsiRef(NsiElementFiasAddressRefFieldType.NsiRef value) {
        this.nsiRef = value;
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
     *         &lt;element name="Guid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="aoGuid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "guid",
        "aoGuid"
    })
    public static class NsiRef {

        @XmlElement(name = "Guid", required = true)
        protected String guid;
        @XmlElement(required = true)
        protected String aoGuid;

        /**
         * Gets the value of the guid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGuid() {
            return guid;
        }

        /**
         * Sets the value of the guid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGuid(String value) {
            this.guid = value;
        }

        /**
         * Gets the value of the aoGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAoGuid() {
            return aoGuid;
        }

        /**
         * Sets the value of the aoGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAoGuid(String value) {
            this.aoGuid = value;
        }

    }

}
