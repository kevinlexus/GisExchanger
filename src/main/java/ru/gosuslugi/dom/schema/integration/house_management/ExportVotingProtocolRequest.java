
package ru.gosuslugi.dom.schema.integration.house_management;

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
 *       &lt;choice&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *           &lt;element name="StatusVersionProtocol" minOccurs="0"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;enumeration value="Created"/&gt;
 *                 &lt;enumeration value="Posted"/&gt;
 *                 &lt;enumeration value="Edited"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="100"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.11.0.6""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fiasHouseGuid",
    "statusVersionProtocol",
    "votingProtocolGUID"
})
@XmlRootElement(name = "exportVotingProtocolRequest")
public class ExportVotingProtocolRequest
    extends BaseType
{

    @XmlElement(name = "FIASHouseGuid")
    protected String fiasHouseGuid;
    @XmlElement(name = "StatusVersionProtocol")
    protected String statusVersionProtocol;
    @XmlElement(name = "VotingProtocolGUID")
    protected List<String> votingProtocolGUID;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the fiasHouseGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIASHouseGuid() {
        return fiasHouseGuid;
    }

    /**
     * Sets the value of the fiasHouseGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIASHouseGuid(String value) {
        this.fiasHouseGuid = value;
    }

    /**
     * Gets the value of the statusVersionProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusVersionProtocol() {
        return statusVersionProtocol;
    }

    /**
     * Sets the value of the statusVersionProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusVersionProtocol(String value) {
        this.statusVersionProtocol = value;
    }

    /**
     * Gets the value of the votingProtocolGUID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the votingProtocolGUID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVotingProtocolGUID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVotingProtocolGUID() {
        if (votingProtocolGUID == null) {
            votingProtocolGUID = new ArrayList<String>();
        }
        return this.votingProtocolGUID;
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
            return "11.11.0.6";
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

}
