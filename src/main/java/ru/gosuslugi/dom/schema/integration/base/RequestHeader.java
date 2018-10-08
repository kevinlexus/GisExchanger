
package ru.gosuslugi.dom.schema.integration.base;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}HeaderType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="SenderID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *           &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="IsOperatorSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ISCreator" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "senderID",
    "orgPPAGUID",
    "isOperatorSignature",
    "isCreator"
})
@XmlRootElement(name = "RequestHeader")
public class RequestHeader
    extends HeaderType
{

    @XmlElement(name = "SenderID")
    protected String senderID;
    protected String orgPPAGUID;
    @XmlElement(name = "IsOperatorSignature")
    protected Boolean isOperatorSignature;
    @XmlElement(name = "ISCreator")
    protected List<ISCreator> isCreator;

    /**
     * Gets the value of the senderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderID() {
        return senderID;
    }

    /**
     * Sets the value of the senderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderID(String value) {
        this.senderID = value;
    }

    /**
     * Gets the value of the orgPPAGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPPAGUID() {
        return orgPPAGUID;
    }

    /**
     * Sets the value of the orgPPAGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPPAGUID(String value) {
        this.orgPPAGUID = value;
    }

    /**
     * Gets the value of the isOperatorSignature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOperatorSignature() {
        return isOperatorSignature;
    }

    /**
     * Sets the value of the isOperatorSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOperatorSignature(Boolean value) {
        this.isOperatorSignature = value;
    }

    /**
     * Сведения об иной ИС, с использованием которой была сформирована информация (589/944/,п.164). Только для запросов размещения информации.Gets the value of the isCreator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isCreator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getISCreator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ISCreator }
     * 
     * 
     */
    public List<ISCreator> getISCreator() {
        if (isCreator == null) {
            isCreator = new ArrayList<ISCreator>();
        }
        return this.isCreator;
    }

}
