
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.individual_registry_base.FIOType;


/**
 * Инициатор - физическое лицо
 * 
 * <p>Java class for VotingInitiatorIndType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VotingInitiatorIndType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Sex" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *               &lt;maxLength value="1"/&gt;
 *               &lt;enumeration value="M"/&gt;
 *               &lt;enumeration value="F"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}SNILS" minOccurs="0"/&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}VotingInitiatorIndID" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="PlaceBirth" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="255"/&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
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
@XmlType(name = "VotingInitiatorIndType", propOrder = {
    "sex",
    "dateOfBirth",
    "snils",
    "votingInitiatorIndID",
    "placeBirth"
})
public class VotingInitiatorIndType
    extends FIOType
{

    @XmlElement(name = "Sex")
    protected String sex;
    @XmlElement(name = "DateOfBirth")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "SNILS", namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/")
    protected String snils;
    @XmlElement(name = "VotingInitiatorIndID")
    protected VotingInitiatorIndID votingInitiatorIndID;
    @XmlElement(name = "PlaceBirth")
    protected String placeBirth;

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the snils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNILS() {
        return snils;
    }

    /**
     * Sets the value of the snils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNILS(String value) {
        this.snils = value;
    }

    /**
     * Gets the value of the votingInitiatorIndID property.
     * 
     * @return
     *     possible object is
     *     {@link VotingInitiatorIndID }
     *     
     */
    public VotingInitiatorIndID getVotingInitiatorIndID() {
        return votingInitiatorIndID;
    }

    /**
     * Sets the value of the votingInitiatorIndID property.
     * 
     * @param value
     *     allowed object is
     *     {@link VotingInitiatorIndID }
     *     
     */
    public void setVotingInitiatorIndID(VotingInitiatorIndID value) {
        this.votingInitiatorIndID = value;
    }

    /**
     * Gets the value of the placeBirth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceBirth() {
        return placeBirth;
    }

    /**
     * Sets the value of the placeBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceBirth(String value) {
        this.placeBirth = value;
    }

}
