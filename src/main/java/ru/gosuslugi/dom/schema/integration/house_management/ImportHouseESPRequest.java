
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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApartmentHouse"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="ApartmentHouseToCreate"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseESPType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ApartmentHouseToUpdate"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateESPType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="NonResidentialPremiseToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesESPType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="NonResidentialPremiseToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateESPType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="EntranceToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceESPType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/extension&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="EntranceToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateESPType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                 &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/extension&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;element name="ResidentialPremises" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;choice&gt;
 *                                 &lt;element name="ResidentialPremisesToCreate"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesESPType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="ResidentialPremisesToUpdate"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateESPType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                           &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomESPType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateESPType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                           &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="LiftToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftESPType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/extension&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="LiftToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateESPType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                                 &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/extension&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}InheritMissingValues" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.6.0.2""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "apartmentHouse",
    "inheritMissingValues"
})
@XmlRootElement(name = "importHouseESPRequest")
public class ImportHouseESPRequest
    extends BaseType
{

    @XmlElement(name = "ApartmentHouse", required = true)
    protected ImportHouseESPRequest.ApartmentHouse apartmentHouse;
    @XmlElement(name = "InheritMissingValues")
    protected Boolean inheritMissingValues;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the apartmentHouse property.
     * 
     * @return
     *     possible object is
     *     {@link ImportHouseESPRequest.ApartmentHouse }
     *     
     */
    public ImportHouseESPRequest.ApartmentHouse getApartmentHouse() {
        return apartmentHouse;
    }

    /**
     * Sets the value of the apartmentHouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportHouseESPRequest.ApartmentHouse }
     *     
     */
    public void setApartmentHouse(ImportHouseESPRequest.ApartmentHouse value) {
        this.apartmentHouse = value;
    }

    /**
     * Gets the value of the inheritMissingValues property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInheritMissingValues() {
        return inheritMissingValues;
    }

    /**
     * Sets the value of the inheritMissingValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInheritMissingValues(Boolean value) {
        this.inheritMissingValues = value;
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
            return "11.6.0.2";
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="ApartmentHouseToCreate"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseESPType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="ApartmentHouseToUpdate"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateESPType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;sequence&gt;
     *           &lt;element name="NonResidentialPremiseToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesESPType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="NonResidentialPremiseToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateESPType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/extension&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/sequence&gt;
     *         &lt;sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="EntranceToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceESPType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/extension&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *             &lt;element name="EntranceToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateESPType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                       &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/extension&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *           &lt;/sequence&gt;
     *           &lt;element name="ResidentialPremises" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;choice&gt;
     *                       &lt;element name="ResidentialPremisesToCreate"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesESPType"&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/extension&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                       &lt;element name="ResidentialPremisesToUpdate"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateESPType"&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                                 &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/extension&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                     &lt;/choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomESPType"&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/extension&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                       &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateESPType"&gt;
     *                               &lt;sequence&gt;
     *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                                 &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                               &lt;/sequence&gt;
     *                             &lt;/extension&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="LiftToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftESPType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/extension&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *             &lt;element name="LiftToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateESPType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                       &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/extension&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *           &lt;/sequence&gt;
     *         &lt;/sequence&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "apartmentHouseToCreate",
        "apartmentHouseToUpdate",
        "nonResidentialPremiseToCreate",
        "nonResidentialPremiseToUpdate",
        "entranceToCreate",
        "entranceToUpdate",
        "residentialPremises",
        "liftToCreate",
        "liftToUpdate"
    })
    public static class ApartmentHouse {

        @XmlElement(name = "ApartmentHouseToCreate")
        protected ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate apartmentHouseToCreate;
        @XmlElement(name = "ApartmentHouseToUpdate")
        protected ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToUpdate apartmentHouseToUpdate;
        @XmlElement(name = "NonResidentialPremiseToCreate")
        protected List<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToCreate> nonResidentialPremiseToCreate;
        @XmlElement(name = "NonResidentialPremiseToUpdate")
        protected List<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToUpdate> nonResidentialPremiseToUpdate;
        @XmlElement(name = "EntranceToCreate")
        protected List<ImportHouseESPRequest.ApartmentHouse.EntranceToCreate> entranceToCreate;
        @XmlElement(name = "EntranceToUpdate")
        protected List<ImportHouseESPRequest.ApartmentHouse.EntranceToUpdate> entranceToUpdate;
        @XmlElement(name = "ResidentialPremises")
        protected List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises> residentialPremises;
        @XmlElement(name = "LiftToCreate")
        protected List<ImportHouseESPRequest.ApartmentHouse.LiftToCreate> liftToCreate;
        @XmlElement(name = "LiftToUpdate")
        protected List<ImportHouseESPRequest.ApartmentHouse.LiftToUpdate> liftToUpdate;

        /**
         * Gets the value of the apartmentHouseToCreate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate }
         *     
         */
        public ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate getApartmentHouseToCreate() {
            return apartmentHouseToCreate;
        }

        /**
         * Sets the value of the apartmentHouseToCreate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate }
         *     
         */
        public void setApartmentHouseToCreate(ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate value) {
            this.apartmentHouseToCreate = value;
        }

        /**
         * Gets the value of the apartmentHouseToUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToUpdate }
         *     
         */
        public ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToUpdate getApartmentHouseToUpdate() {
            return apartmentHouseToUpdate;
        }

        /**
         * Sets the value of the apartmentHouseToUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToUpdate }
         *     
         */
        public void setApartmentHouseToUpdate(ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToUpdate value) {
            this.apartmentHouseToUpdate = value;
        }

        /**
         * Gets the value of the nonResidentialPremiseToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremiseToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNonResidentialPremiseToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToCreate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToCreate> getNonResidentialPremiseToCreate() {
            if (nonResidentialPremiseToCreate == null) {
                nonResidentialPremiseToCreate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToCreate>();
            }
            return this.nonResidentialPremiseToCreate;
        }

        /**
         * Gets the value of the nonResidentialPremiseToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nonResidentialPremiseToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNonResidentialPremiseToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToUpdate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToUpdate> getNonResidentialPremiseToUpdate() {
            if (nonResidentialPremiseToUpdate == null) {
                nonResidentialPremiseToUpdate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.NonResidentialPremiseToUpdate>();
            }
            return this.nonResidentialPremiseToUpdate;
        }

        /**
         * Gets the value of the entranceToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entranceToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntranceToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.EntranceToCreate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.EntranceToCreate> getEntranceToCreate() {
            if (entranceToCreate == null) {
                entranceToCreate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.EntranceToCreate>();
            }
            return this.entranceToCreate;
        }

        /**
         * Gets the value of the entranceToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entranceToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntranceToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.EntranceToUpdate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.EntranceToUpdate> getEntranceToUpdate() {
            if (entranceToUpdate == null) {
                entranceToUpdate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.EntranceToUpdate>();
            }
            return this.entranceToUpdate;
        }

        /**
         * Gets the value of the residentialPremises property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the residentialPremises property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResidentialPremises().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises> getResidentialPremises() {
            if (residentialPremises == null) {
                residentialPremises = new ArrayList<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises>();
            }
            return this.residentialPremises;
        }

        /**
         * Gets the value of the liftToCreate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the liftToCreate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLiftToCreate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.LiftToCreate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.LiftToCreate> getLiftToCreate() {
            if (liftToCreate == null) {
                liftToCreate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.LiftToCreate>();
            }
            return this.liftToCreate;
        }

        /**
         * Gets the value of the liftToUpdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the liftToUpdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLiftToUpdate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportHouseESPRequest.ApartmentHouse.LiftToUpdate }
         * 
         * 
         */
        public List<ImportHouseESPRequest.ApartmentHouse.LiftToUpdate> getLiftToUpdate() {
            if (liftToUpdate == null) {
                liftToUpdate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.LiftToUpdate>();
            }
            return this.liftToUpdate;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
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
            "transportGUID",
            "houseManagementType"
        })
        public static class ApartmentHouseToCreate
            extends ApartmentHouseESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ApartmentHouseUpdateESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="HouseManagementType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
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
            "transportGUID",
            "houseManagementType"
        })
        public static class ApartmentHouseToUpdate
            extends ApartmentHouseUpdateESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "HouseManagementType")
            protected NsiRef houseManagementType;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the houseManagementType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getHouseManagementType() {
                return houseManagementType;
            }

            /**
             * Sets the value of the houseManagementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setHouseManagementType(NsiRef value) {
                this.houseManagementType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
            "transportGUID"
        })
        public static class EntranceToCreate
            extends EntranceESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}EntranceUpdateESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="EntranceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
            "transportGUID",
            "entranceGUID"
        })
        public static class EntranceToUpdate
            extends EntranceUpdateESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "EntranceGUID", required = true)
            protected String entranceGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the entranceGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEntranceGUID() {
                return entranceGUID;
            }

            /**
             * Sets the value of the entranceGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEntranceGUID(String value) {
                this.entranceGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
            "transportGUID"
        })
        public static class LiftToCreate
            extends LiftESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}LiftUpdateESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="LiftGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
            "transportGUID",
            "liftGUID"
        })
        public static class LiftToUpdate
            extends LiftUpdateESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "LiftGUID", required = true)
            protected String liftGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the liftGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLiftGUID() {
                return liftGUID;
            }

            /**
             * Sets the value of the liftGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLiftGUID(String value) {
                this.liftGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
            "transportGUID"
        })
        public static class NonResidentialPremiseToCreate
            extends NonResidentialPremisesESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}NonResidentialPremisesUpdateESPType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
            "transportGUID",
            "premisesGUID"
        })
        public static class NonResidentialPremiseToUpdate
            extends NonResidentialPremisesUpdateESPType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "PremisesGUID", required = true)
            protected String premisesGUID;

            /**
             * Gets the value of the transportGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransportGUID() {
                return transportGUID;
            }

            /**
             * Sets the value of the transportGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransportGUID(String value) {
                this.transportGUID = value;
            }

            /**
             * Gets the value of the premisesGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPremisesGUID() {
                return premisesGUID;
            }

            /**
             * Sets the value of the premisesGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPremisesGUID(String value) {
                this.premisesGUID = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;choice&gt;
         *           &lt;element name="ResidentialPremisesToCreate"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesESPType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="ResidentialPremisesToUpdate"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateESPType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                     &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;sequence&gt;
         *           &lt;element name="LivingRoomToCreate" maxOccurs="unbounded" minOccurs="0"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomESPType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="LivingRoomToUpdate" maxOccurs="unbounded" minOccurs="0"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateESPType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *                     &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *         &lt;/sequence&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "residentialPremisesToCreate",
            "residentialPremisesToUpdate",
            "livingRoomToCreate",
            "livingRoomToUpdate"
        })
        public static class ResidentialPremises {

            @XmlElement(name = "ResidentialPremisesToCreate")
            protected ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate residentialPremisesToCreate;
            @XmlElement(name = "ResidentialPremisesToUpdate")
            protected ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate residentialPremisesToUpdate;
            @XmlElement(name = "LivingRoomToCreate")
            protected List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate> livingRoomToCreate;
            @XmlElement(name = "LivingRoomToUpdate")
            protected List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate> livingRoomToUpdate;

            /**
             * Gets the value of the residentialPremisesToCreate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate }
             *     
             */
            public ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate getResidentialPremisesToCreate() {
                return residentialPremisesToCreate;
            }

            /**
             * Sets the value of the residentialPremisesToCreate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate }
             *     
             */
            public void setResidentialPremisesToCreate(ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate value) {
                this.residentialPremisesToCreate = value;
            }

            /**
             * Gets the value of the residentialPremisesToUpdate property.
             * 
             * @return
             *     possible object is
             *     {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate }
             *     
             */
            public ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate getResidentialPremisesToUpdate() {
                return residentialPremisesToUpdate;
            }

            /**
             * Sets the value of the residentialPremisesToUpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate }
             *     
             */
            public void setResidentialPremisesToUpdate(ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate value) {
                this.residentialPremisesToUpdate = value;
            }

            /**
             * Gets the value of the livingRoomToCreate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToCreate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToCreate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate }
             * 
             * 
             */
            public List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate> getLivingRoomToCreate() {
                if (livingRoomToCreate == null) {
                    livingRoomToCreate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToCreate>();
                }
                return this.livingRoomToCreate;
            }

            /**
             * Gets the value of the livingRoomToUpdate property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the livingRoomToUpdate property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLivingRoomToUpdate().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate }
             * 
             * 
             */
            public List<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate> getLivingRoomToUpdate() {
                if (livingRoomToUpdate == null) {
                    livingRoomToUpdate = new ArrayList<ImportHouseESPRequest.ApartmentHouse.ResidentialPremises.LivingRoomToUpdate>();
                }
                return this.livingRoomToUpdate;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomESPType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
                "transportGUID"
            })
            public static class LivingRoomToCreate
                extends RoomESPType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RoomUpdateESPType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
             *         &lt;element name="LivingRoomGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "transportGUID",
                "livingRoomGUID"
            })
            public static class LivingRoomToUpdate
                extends RoomUpdateESPType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "LivingRoomGUID", required = true)
                protected String livingRoomGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

                /**
                 * Gets the value of the livingRoomGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLivingRoomGUID() {
                    return livingRoomGUID;
                }

                /**
                 * Sets the value of the livingRoomGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLivingRoomGUID(String value) {
                    this.livingRoomGUID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesESPType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
                "transportGUID"
            })
            public static class ResidentialPremisesToCreate
                extends ResidentialPremisesESPType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ResidentialPremisesUpdateESPType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
             *         &lt;element name="PremisesGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "transportGUID",
                "premisesGUID"
            })
            public static class ResidentialPremisesToUpdate
                extends ResidentialPremisesUpdateESPType
            {

                @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
                protected String transportGUID;
                @XmlElement(name = "PremisesGUID", required = true)
                protected String premisesGUID;

                /**
                 * Gets the value of the transportGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTransportGUID() {
                    return transportGUID;
                }

                /**
                 * Sets the value of the transportGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTransportGUID(String value) {
                    this.transportGUID = value;
                }

                /**
                 * Gets the value of the premisesGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPremisesGUID() {
                    return premisesGUID;
                }

                /**
                 * Sets the value of the premisesGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPremisesGUID(String value) {
                    this.premisesGUID = value;
                }

            }

        }

    }

}
