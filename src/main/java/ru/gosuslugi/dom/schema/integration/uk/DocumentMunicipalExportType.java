
package ru.gosuslugi.dom.schema.integration.uk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Документ закона/нормативно-правового акта уровня муниципальных образований для операции экспорта
 * 
 * <p>Java class for DocumentMunicipalExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentMunicipalExportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentPortalExportType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="Municipal" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentMunicipalExportType", propOrder = {
    "municipal"
})
public class DocumentMunicipalExportType
    extends DocumentPortalExportType
{

    @XmlElement(name = "Municipal")
    protected OKTMORefType municipal;

    /**
     * Gets the value of the municipal property.
     * 
     * @return
     *     possible object is
     *     {@link OKTMORefType }
     *     
     */
    public OKTMORefType getMunicipal() {
        return municipal;
    }

    /**
     * Sets the value of the municipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link OKTMORefType }
     *     
     */
    public void setMunicipal(OKTMORefType value) {
        this.municipal = value;
    }

}
