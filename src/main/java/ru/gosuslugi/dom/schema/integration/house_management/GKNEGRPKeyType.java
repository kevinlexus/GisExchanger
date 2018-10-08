
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Сведения из ГКН для УО и ОМС
 * 
 * <p>Java class for GKN_EGRP_KeyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GKN_EGRP_KeyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CadastralNumber"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}No_RSO_GKN_EGRP_Registered"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ConditionalNumber"/&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}RightOrEncumbrance" maxOccurs="unbounded"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GKN_EGRP_KeyType", propOrder = {
    "cadastralNumber",
    "noRSOGKNEGRPRegistered",
    "conditionalNumber",
    "rightOrEncumbrance"
})
@XmlSeeAlso({
    HouseBasicUpdateUOType.class,
    HouseBasicUpdateOMSType.class,
    HouseBasicUpdateESPType.class,
    HouseBasicUOType.class,
    ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseOMSType.BasicCharacteristicts.class,
    ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseESPType.BasicCharacteristicts.class,
    ru.gosuslugi.dom.schema.integration.house_management.LivingHouseOMSType.BasicCharacteristicts.class,
    BlockUOType.class,
    BlockOMSType.class,
    BlockUpdateUOType.class,
    BlockUpdateOMSType.class,
    PremisesBasicUOType.class,
    PremisesBasicOMSType.class,
    PremisesBasicESPType.class,
    PremisesBasicUpdateUOType.class,
    PremisesBasicUpdateOMSType.class,
    PremisesBasicUpdateESPType.class,
    RoomUOType.class,
    RoomOMSType.class,
    RoomESPType.class,
    RoomUpdateUOType.class,
    RoomUpdateOMSType.class,
    RoomUpdateESPType.class,
    RoomExportType.class
})
public class GKNEGRPKeyType {

    @XmlElement(name = "CadastralNumber")
    protected String cadastralNumber;
    @XmlElement(name = "No_RSO_GKN_EGRP_Registered")
    protected Boolean noRSOGKNEGRPRegistered;
    @XmlElement(name = "ConditionalNumber")
    protected String conditionalNumber;
    @XmlElement(name = "RightOrEncumbrance")
    protected List<RightOrEncumbrance> rightOrEncumbrance;

    /**
     * Gets the value of the cadastralNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    /**
     * Sets the value of the cadastralNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadastralNumber(String value) {
        this.cadastralNumber = value;
    }

    /**
     * Gets the value of the noRSOGKNEGRPRegistered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNoRSOGKNEGRPRegistered() {
        return noRSOGKNEGRPRegistered;
    }

    /**
     * Sets the value of the noRSOGKNEGRPRegistered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNoRSOGKNEGRPRegistered(Boolean value) {
        this.noRSOGKNEGRPRegistered = value;
    }

    /**
     * Gets the value of the conditionalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionalNumber() {
        return conditionalNumber;
    }

    /**
     * Sets the value of the conditionalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionalNumber(String value) {
        this.conditionalNumber = value;
    }

    /**
     * Gets the value of the rightOrEncumbrance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rightOrEncumbrance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRightOrEncumbrance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RightOrEncumbrance }
     * 
     * 
     */
    public List<RightOrEncumbrance> getRightOrEncumbrance() {
        if (rightOrEncumbrance == null) {
            rightOrEncumbrance = new ArrayList<RightOrEncumbrance>();
        }
        return this.rightOrEncumbrance;
    }

}
