
package ru.gosuslugi.dom.schema.integration.uk;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;


/**
 * Документ закона/нормативно-правового акта уровня муниципальных образований
 * 
 * <p>Java class for DocumentMunicipalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentMunicipalType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentPortalType">
 *       &lt;sequence>
 *         &lt;element name="Municipal" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentMunicipalType", propOrder = {
    "municipal"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.uk.ImportDocumentMunicipalRequest.Document.ImportDocument.class
})
public class DocumentMunicipalType
    extends DocumentPortalType
{

    @XmlElement(name = "Municipal", required = true)
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
