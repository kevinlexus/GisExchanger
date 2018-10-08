
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoitingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoitingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VotingPlace"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="3000"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoitingType", propOrder = {
    "votingPlace"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ProtocolType.Meeting.class,
    ru.gosuslugi.dom.schema.integration.house_management.ProtocolExportType.Meeting.class
})
public class VoitingType {

    @XmlElement(name = "VotingPlace", required = true)
    protected String votingPlace;

    /**
     * Gets the value of the votingPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVotingPlace() {
        return votingPlace;
    }

    /**
     * Sets the value of the votingPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVotingPlace(String value) {
        this.votingPlace = value;
    }

}
