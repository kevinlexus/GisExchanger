
package ru.gosuslugi.dom.schema.integration.licenses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.EntpsType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.LegalType;


/**
 * Информация о лицензиате
 * 
 * <p>Java class for LicenseOrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LicenseOrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Legal"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Entrp"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LicenseOrganizationType", propOrder = {
    "legal",
    "entrp"
})
public class LicenseOrganizationType {

    @XmlElement(name = "Legal")
    protected LicenseOrganizationType.Legal legal;
    @XmlElement(name = "Entrp")
    protected LicenseOrganizationType.Entrp entrp;

    /**
     * Gets the value of the legal property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseOrganizationType.Legal }
     *     
     */
    public LicenseOrganizationType.Legal getLegal() {
        return legal;
    }

    /**
     * Sets the value of the legal property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseOrganizationType.Legal }
     *     
     */
    public void setLegal(LicenseOrganizationType.Legal value) {
        this.legal = value;
    }

    /**
     * Gets the value of the entrp property.
     * 
     * @return
     *     possible object is
     *     {@link LicenseOrganizationType.Entrp }
     *     
     */
    public LicenseOrganizationType.Entrp getEntrp() {
        return entrp;
    }

    /**
     * Sets the value of the entrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link LicenseOrganizationType.Entrp }
     *     
     */
    public void setEntrp(LicenseOrganizationType.Entrp value) {
        this.entrp = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}EntpsType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Entrp
        extends EntpsType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}LegalType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Legal
        extends LegalType
    {


    }

}
