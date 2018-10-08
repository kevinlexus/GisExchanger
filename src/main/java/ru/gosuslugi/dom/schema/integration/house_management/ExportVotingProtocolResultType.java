
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for exportVotingProtocolResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportVotingProtocolResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ProtocolExportType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StatusProtocol"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Created"/&gt;
 *               &lt;enumeration value="Posted"/&gt;
 *               &lt;enumeration value="Edited"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VotingProtocolGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="StatusVersionProtocol"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="Created"/&gt;
 *               &lt;enumeration value="Posted"/&gt;
 *               &lt;enumeration value="Edited"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VersionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="VersionDateModification" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="VersionDatePlacement" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportVotingProtocolResultType", propOrder = {
    "statusProtocol",
    "votingProtocolGUID",
    "statusVersionProtocol",
    "versionNumber",
    "versionDateModification",
    "versionDatePlacement"
})
public class ExportVotingProtocolResultType
    extends ProtocolExportType
{

    @XmlElement(name = "StatusProtocol", required = true)
    protected String statusProtocol;
    @XmlElement(name = "VotingProtocolGUID", required = true)
    protected String votingProtocolGUID;
    @XmlElement(name = "StatusVersionProtocol", required = true)
    protected String statusVersionProtocol;
    @XmlElement(name = "VersionNumber")
    protected int versionNumber;
    @XmlElement(name = "VersionDateModification")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar versionDateModification;
    @XmlElement(name = "VersionDatePlacement")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar versionDatePlacement;

    /**
     * Gets the value of the statusProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusProtocol() {
        return statusProtocol;
    }

    /**
     * Sets the value of the statusProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusProtocol(String value) {
        this.statusProtocol = value;
    }

    /**
     * Gets the value of the votingProtocolGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVotingProtocolGUID() {
        return votingProtocolGUID;
    }

    /**
     * Sets the value of the votingProtocolGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVotingProtocolGUID(String value) {
        this.votingProtocolGUID = value;
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
     * Gets the value of the versionNumber property.
     * 
     */
    public int getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     */
    public void setVersionNumber(int value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the versionDateModification property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVersionDateModification() {
        return versionDateModification;
    }

    /**
     * Sets the value of the versionDateModification property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVersionDateModification(XMLGregorianCalendar value) {
        this.versionDateModification = value;
    }

    /**
     * Gets the value of the versionDatePlacement property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVersionDatePlacement() {
        return versionDatePlacement;
    }

    /**
     * Sets the value of the versionDatePlacement property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVersionDatePlacement(XMLGregorianCalendar value) {
        this.versionDatePlacement = value;
    }

}
