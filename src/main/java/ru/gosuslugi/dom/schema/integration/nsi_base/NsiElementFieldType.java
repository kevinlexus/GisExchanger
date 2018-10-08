
package ru.gosuslugi.dom.schema.integration.nsi_base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Составной тип. Наименование и значение поля для элемента справочника. Абстрактный тип.
 * 
 * <p>Java class for NsiElementFieldType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NsiElementFieldType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Name" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}FieldNameType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NsiElementFieldType", propOrder = {
    "name"
})
@XmlSeeAlso({
    NsiElementStringFieldType.class,
    NsiElementBooleanFieldType.class,
    NsiElementFloatFieldType.class,
    NsiElementDateFieldType.class,
    NsiElementIntegerFieldType.class,
    NsiElementEnumFieldType.class,
    NsiElementNsiFieldType.class,
    NsiElementNsiRefFieldType.class,
    NsiElementOkeiRefFieldType.class,
    NsiElementFiasAddressRefFieldType.class,
    NsiElementAttachmentFieldType.class
})
public abstract class NsiElementFieldType {

    @XmlElement(name = "Name", required = true)
    protected String name;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
