
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *       &lt;sequence&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="PlacingCharter"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ContractObject" maxOccurs="unbounded"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/extension&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/extension&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="EditCharter"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;choice&gt;
 *                                 &lt;element name="Add"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/extension&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/extension&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="Edit"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
 *                                           &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/&gt;
 *                                           &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/extension&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                             &lt;complexType&gt;
 *                                               &lt;complexContent&gt;
 *                                                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
 *                                                   &lt;sequence&gt;
 *                                                     &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
 *                                                   &lt;/sequence&gt;
 *                                                 &lt;/extension&gt;
 *                                               &lt;/complexContent&gt;
 *                                             &lt;/complexType&gt;
 *                                           &lt;/element&gt;
 *                                           &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/extension&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                                 &lt;element name="Annulment"&gt;
 *                                   &lt;complexType&gt;
 *                                     &lt;complexContent&gt;
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                         &lt;sequence&gt;
 *                                           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
 *                                         &lt;/sequence&gt;
 *                                       &lt;/restriction&gt;
 *                                     &lt;/complexContent&gt;
 *                                   &lt;/complexType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/choice&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="RollOverCharter"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                     &lt;element name="RollToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="TerminateCharter"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Reason"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *                           &lt;maxLength value="255"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="AnnulmentCharter"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="PlaceCharterPaymentsInfo"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="AnnulmentCharterPaymentsInfo"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.9.0.1""/&gt;
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
    "placingCharter",
    "editCharter",
    "rollOverCharter",
    "terminateCharter",
    "annulmentCharter",
    "placeCharterPaymentsInfo",
    "annulmentCharterPaymentsInfo"
})
@XmlRootElement(name = "importCharterRequest")
public class ImportCharterRequest
    extends BaseType
{

    @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String transportGUID;
    @XmlElement(name = "PlacingCharter")
    protected ImportCharterRequest.PlacingCharter placingCharter;
    @XmlElement(name = "EditCharter")
    protected ImportCharterRequest.EditCharter editCharter;
    @XmlElement(name = "RollOverCharter")
    protected ImportCharterRequest.RollOverCharter rollOverCharter;
    @XmlElement(name = "TerminateCharter")
    protected ImportCharterRequest.TerminateCharter terminateCharter;
    @XmlElement(name = "AnnulmentCharter")
    protected ImportCharterRequest.AnnulmentCharter annulmentCharter;
    @XmlElement(name = "PlaceCharterPaymentsInfo")
    protected ImportCharterRequest.PlaceCharterPaymentsInfo placeCharterPaymentsInfo;
    @XmlElement(name = "AnnulmentCharterPaymentsInfo")
    protected ImportCharterRequest.AnnulmentCharterPaymentsInfo annulmentCharterPaymentsInfo;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

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
     * Gets the value of the placingCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.PlacingCharter }
     *     
     */
    public ImportCharterRequest.PlacingCharter getPlacingCharter() {
        return placingCharter;
    }

    /**
     * Sets the value of the placingCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.PlacingCharter }
     *     
     */
    public void setPlacingCharter(ImportCharterRequest.PlacingCharter value) {
        this.placingCharter = value;
    }

    /**
     * Gets the value of the editCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.EditCharter }
     *     
     */
    public ImportCharterRequest.EditCharter getEditCharter() {
        return editCharter;
    }

    /**
     * Sets the value of the editCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.EditCharter }
     *     
     */
    public void setEditCharter(ImportCharterRequest.EditCharter value) {
        this.editCharter = value;
    }

    /**
     * Gets the value of the rollOverCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.RollOverCharter }
     *     
     */
    public ImportCharterRequest.RollOverCharter getRollOverCharter() {
        return rollOverCharter;
    }

    /**
     * Sets the value of the rollOverCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.RollOverCharter }
     *     
     */
    public void setRollOverCharter(ImportCharterRequest.RollOverCharter value) {
        this.rollOverCharter = value;
    }

    /**
     * Gets the value of the terminateCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.TerminateCharter }
     *     
     */
    public ImportCharterRequest.TerminateCharter getTerminateCharter() {
        return terminateCharter;
    }

    /**
     * Sets the value of the terminateCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.TerminateCharter }
     *     
     */
    public void setTerminateCharter(ImportCharterRequest.TerminateCharter value) {
        this.terminateCharter = value;
    }

    /**
     * Gets the value of the annulmentCharter property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.AnnulmentCharter }
     *     
     */
    public ImportCharterRequest.AnnulmentCharter getAnnulmentCharter() {
        return annulmentCharter;
    }

    /**
     * Sets the value of the annulmentCharter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.AnnulmentCharter }
     *     
     */
    public void setAnnulmentCharter(ImportCharterRequest.AnnulmentCharter value) {
        this.annulmentCharter = value;
    }

    /**
     * Gets the value of the placeCharterPaymentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.PlaceCharterPaymentsInfo }
     *     
     */
    public ImportCharterRequest.PlaceCharterPaymentsInfo getPlaceCharterPaymentsInfo() {
        return placeCharterPaymentsInfo;
    }

    /**
     * Sets the value of the placeCharterPaymentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.PlaceCharterPaymentsInfo }
     *     
     */
    public void setPlaceCharterPaymentsInfo(ImportCharterRequest.PlaceCharterPaymentsInfo value) {
        this.placeCharterPaymentsInfo = value;
    }

    /**
     * Gets the value of the annulmentCharterPaymentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ImportCharterRequest.AnnulmentCharterPaymentsInfo }
     *     
     */
    public ImportCharterRequest.AnnulmentCharterPaymentsInfo getAnnulmentCharterPaymentsInfo() {
        return annulmentCharterPaymentsInfo;
    }

    /**
     * Sets the value of the annulmentCharterPaymentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportCharterRequest.AnnulmentCharterPaymentsInfo }
     *     
     */
    public void setAnnulmentCharterPaymentsInfo(ImportCharterRequest.AnnulmentCharterPaymentsInfo value) {
        this.annulmentCharterPaymentsInfo = value;
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
            return "11.9.0.1";
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}AnnulmentType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
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
        "charterVersionGUID"
    })
    public static class AnnulmentCharter
        extends AnnulmentType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoVersionGUID"/&gt;
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
        "charterPaymentsInfoVersionGUID"
    })
    public static class AnnulmentCharterPaymentsInfo {

        @XmlElement(name = "CharterPaymentsInfoVersionGUID", required = true)
        protected String charterPaymentsInfoVersionGUID;

        /**
         * Gets the value of the charterPaymentsInfoVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterPaymentsInfoVersionGUID() {
            return charterPaymentsInfoVersionGUID;
        }

        /**
         * Sets the value of the charterPaymentsInfoVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterPaymentsInfoVersionGUID(String value) {
            this.charterPaymentsInfoVersionGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ContractObject" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="Add"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/extension&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/extension&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Edit"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
     *                               &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/&gt;
     *                               &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/extension&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                                 &lt;complexType&gt;
     *                                   &lt;complexContent&gt;
     *                                     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                                       &lt;sequence&gt;
     *                                         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                                       &lt;/sequence&gt;
     *                                     &lt;/extension&gt;
     *                                   &lt;/complexContent&gt;
     *                                 &lt;/complexType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/extension&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Annulment"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/choice&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
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
        "contractObject",
        "charterVersionGUID"
    })
    public static class EditCharter
        extends CharterType
    {

        @XmlElement(name = "ContractObject")
        protected List<ImportCharterRequest.EditCharter.ContractObject> contractObject;
        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCharterRequest.EditCharter.ContractObject }
         * 
         * 
         */
        public List<ImportCharterRequest.EditCharter.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ImportCharterRequest.EditCharter.ContractObject>();
            }
            return this.contractObject;
        }

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;choice&gt;
         *           &lt;element name="Add"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/extension&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/extension&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="Edit"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
         *                     &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/&gt;
         *                     &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/extension&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
         *                       &lt;complexType&gt;
         *                         &lt;complexContent&gt;
         *                           &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                             &lt;sequence&gt;
         *                               &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                             &lt;/sequence&gt;
         *                           &lt;/extension&gt;
         *                         &lt;/complexContent&gt;
         *                       &lt;/complexType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/extension&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="Annulment"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
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
            "transportGUID",
            "add",
            "edit",
            "annulment"
        })
        public static class ContractObject {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "Add")
            protected ImportCharterRequest.EditCharter.ContractObject.Add add;
            @XmlElement(name = "Edit")
            protected ImportCharterRequest.EditCharter.ContractObject.Edit edit;
            @XmlElement(name = "Annulment")
            protected ImportCharterRequest.EditCharter.ContractObject.Annulment annulment;

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
             * Gets the value of the add property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Add }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Add getAdd() {
                return add;
            }

            /**
             * Sets the value of the add property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Add }
             *     
             */
            public void setAdd(ImportCharterRequest.EditCharter.ContractObject.Add value) {
                this.add = value;
            }

            /**
             * Gets the value of the edit property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Edit }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Edit getEdit() {
                return edit;
            }

            /**
             * Sets the value of the edit property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Edit }
             *     
             */
            public void setEdit(ImportCharterRequest.EditCharter.ContractObject.Edit value) {
                this.edit = value;
            }

            /**
             * Gets the value of the annulment property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Annulment }
             *     
             */
            public ImportCharterRequest.EditCharter.ContractObject.Annulment getAnnulment() {
                return annulment;
            }

            /**
             * Sets the value of the annulment property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterRequest.EditCharter.ContractObject.Annulment }
             *     
             */
            public void setAnnulment(ImportCharterRequest.EditCharter.ContractObject.Annulment value) {
                this.annulment = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
             *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/extension&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/extension&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
                "baseMService",
                "houseService",
                "addService",
                "isManagedByContract"
            })
            public static class Add
                extends ManageObjectType
            {

                @XmlElement(name = "BaseMService", required = true)
                protected BaseServiceCharterType baseMService;
                @XmlElement(name = "HouseService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService> houseService;
                @XmlElement(name = "AddService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Add.AddService> addService;
                @XmlElement(name = "IsManagedByContract")
                protected Boolean isManagedByContract;

                /**
                 * Gets the value of the baseMService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseMService() {
                    return baseMService;
                }

                /**
                 * Sets the value of the baseMService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseMService(BaseServiceCharterType value) {
                    this.baseMService = value;
                }

                /**
                 * Gets the value of the houseService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the houseService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHouseService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Add.HouseService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService> getHouseService() {
                    if (houseService == null) {
                        houseService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Add.HouseService>();
                    }
                    return this.houseService;
                }

                /**
                 * Gets the value of the addService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the addService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAddService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Add.AddService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Add.AddService> getAddService() {
                    if (addService == null) {
                        addService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Add.AddService>();
                    }
                    return this.addService;
                }

                /**
                 * Gets the value of the isManagedByContract property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isIsManagedByContract() {
                    return isManagedByContract;
                }

                /**
                 * Sets the value of the isManagedByContract property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsManagedByContract(Boolean value) {
                    this.isManagedByContract = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                    "baseServiceCharter"
                })
                public static class AddService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                    "baseServiceCharter"
                })
                public static class HouseService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
                    }

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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
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
                "contractObjectVersionGUID"
            })
            public static class Annulment {

                @XmlElement(name = "ContractObjectVersionGUID", required = true)
                protected String contractObjectVersionGUID;

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractObjectVersionGUID"/&gt;
             *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType" minOccurs="0"/&gt;
             *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/extension&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/extension&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
                "contractObjectVersionGUID",
                "baseMService",
                "houseService",
                "addService",
                "isManagedByContract"
            })
            public static class Edit
                extends ManageObjectType
            {

                @XmlElement(name = "ContractObjectVersionGUID", required = true)
                protected String contractObjectVersionGUID;
                @XmlElement(name = "BaseMService")
                protected BaseServiceCharterType baseMService;
                @XmlElement(name = "HouseService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService> houseService;
                @XmlElement(name = "AddService")
                protected List<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService> addService;
                @XmlElement(name = "IsManagedByContract")
                protected Boolean isManagedByContract;

                /**
                 * Gets the value of the contractObjectVersionGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContractObjectVersionGUID() {
                    return contractObjectVersionGUID;
                }

                /**
                 * Sets the value of the contractObjectVersionGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContractObjectVersionGUID(String value) {
                    this.contractObjectVersionGUID = value;
                }

                /**
                 * Gets the value of the baseMService property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseMService() {
                    return baseMService;
                }

                /**
                 * Sets the value of the baseMService property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseMService(BaseServiceCharterType value) {
                    this.baseMService = value;
                }

                /**
                 * Gets the value of the houseService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the houseService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getHouseService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService> getHouseService() {
                    if (houseService == null) {
                        houseService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Edit.HouseService>();
                    }
                    return this.houseService;
                }

                /**
                 * Gets the value of the addService property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the addService property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAddService().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ImportCharterRequest.EditCharter.ContractObject.Edit.AddService }
                 * 
                 * 
                 */
                public List<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService> getAddService() {
                    if (addService == null) {
                        addService = new ArrayList<ImportCharterRequest.EditCharter.ContractObject.Edit.AddService>();
                    }
                    return this.addService;
                }

                /**
                 * Gets the value of the isManagedByContract property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isIsManagedByContract() {
                    return isManagedByContract;
                }

                /**
                 * Sets the value of the isManagedByContract property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsManagedByContract(Boolean value) {
                    this.isManagedByContract = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                    "baseServiceCharter"
                })
                public static class AddService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
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
                 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                    "baseServiceCharter"
                })
                public static class HouseService
                    extends ContractServiceType
                {

                    @XmlElement(name = "BaseServiceCharter", required = true)
                    protected BaseServiceCharterType baseServiceCharter;

                    /**
                     * Gets the value of the baseServiceCharter property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public BaseServiceCharterType getBaseServiceCharter() {
                        return baseServiceCharter;
                    }

                    /**
                     * Sets the value of the baseServiceCharter property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BaseServiceCharterType }
                     *     
                     */
                    public void setBaseServiceCharter(BaseServiceCharterType value) {
                        this.baseServiceCharter = value;
                    }

                }

            }

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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterPaymentsInfoType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
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
        "charterVersionGUID"
    })
    public static class PlaceCharterPaymentsInfo
        extends CharterPaymentsInfoType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ContractObject" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                   &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                   &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
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
    @XmlType(name = "", propOrder = {
        "contractObject"
    })
    public static class PlacingCharter
        extends CharterType
    {

        @XmlElement(name = "ContractObject", required = true)
        protected List<ImportCharterRequest.PlacingCharter.ContractObject> contractObject;

        /**
         * Gets the value of the contractObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportCharterRequest.PlacingCharter.ContractObject }
         * 
         * 
         */
        public List<ImportCharterRequest.PlacingCharter.ContractObject> getContractObject() {
            if (contractObject == null) {
                contractObject = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject>();
            }
            return this.contractObject;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ManageObjectType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *         &lt;element name="BaseMService" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *         &lt;element name="HouseService" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AddService" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IsManagedByContract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
            "baseMService",
            "houseService",
            "addService",
            "isManagedByContract"
        })
        public static class ContractObject
            extends ManageObjectType
        {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "BaseMService", required = true)
            protected BaseServiceCharterType baseMService;
            @XmlElement(name = "HouseService")
            protected List<ImportCharterRequest.PlacingCharter.ContractObject.HouseService> houseService;
            @XmlElement(name = "AddService")
            protected List<ImportCharterRequest.PlacingCharter.ContractObject.AddService> addService;
            @XmlElement(name = "IsManagedByContract")
            protected Boolean isManagedByContract;

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
             * Gets the value of the baseMService property.
             * 
             * @return
             *     possible object is
             *     {@link BaseServiceCharterType }
             *     
             */
            public BaseServiceCharterType getBaseMService() {
                return baseMService;
            }

            /**
             * Sets the value of the baseMService property.
             * 
             * @param value
             *     allowed object is
             *     {@link BaseServiceCharterType }
             *     
             */
            public void setBaseMService(BaseServiceCharterType value) {
                this.baseMService = value;
            }

            /**
             * Gets the value of the houseService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the houseService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHouseService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportCharterRequest.PlacingCharter.ContractObject.HouseService }
             * 
             * 
             */
            public List<ImportCharterRequest.PlacingCharter.ContractObject.HouseService> getHouseService() {
                if (houseService == null) {
                    houseService = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject.HouseService>();
                }
                return this.houseService;
            }

            /**
             * Gets the value of the addService property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the addService property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAddService().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ImportCharterRequest.PlacingCharter.ContractObject.AddService }
             * 
             * 
             */
            public List<ImportCharterRequest.PlacingCharter.ContractObject.AddService> getAddService() {
                if (addService == null) {
                    addService = new ArrayList<ImportCharterRequest.PlacingCharter.ContractObject.AddService>();
                }
                return this.addService;
            }

            /**
             * Gets the value of the isManagedByContract property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsManagedByContract() {
                return isManagedByContract;
            }

            /**
             * Sets the value of the isManagedByContract property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsManagedByContract(Boolean value) {
                this.isManagedByContract = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                "baseServiceCharter"
            })
            public static class AddService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseServiceCharter", required = true)
                protected BaseServiceCharterType baseServiceCharter;

                /**
                 * Gets the value of the baseServiceCharter property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseServiceCharter() {
                    return baseServiceCharter;
                }

                /**
                 * Sets the value of the baseServiceCharter property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseServiceCharter(BaseServiceCharterType value) {
                    this.baseServiceCharter = value;
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
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractServiceType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="BaseServiceCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BaseServiceCharterType"/&gt;
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
                "baseServiceCharter"
            })
            public static class HouseService
                extends ContractServiceType
            {

                @XmlElement(name = "BaseServiceCharter", required = true)
                protected BaseServiceCharterType baseServiceCharter;

                /**
                 * Gets the value of the baseServiceCharter property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public BaseServiceCharterType getBaseServiceCharter() {
                    return baseServiceCharter;
                }

                /**
                 * Sets the value of the baseServiceCharter property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BaseServiceCharterType }
                 *     
                 */
                public void setBaseServiceCharter(BaseServiceCharterType value) {
                    this.baseServiceCharter = value;
                }

            }

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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}RollOverType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
     *         &lt;element name="RollToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
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
        "charterVersionGUID",
        "rollToDate"
    })
    public static class RollOverCharter
        extends RollOverType
    {

        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;
        @XmlElement(name = "RollToDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar rollToDate;

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
        }

        /**
         * Gets the value of the rollToDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getRollToDate() {
            return rollToDate;
        }

        /**
         * Sets the value of the rollToDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setRollToDate(XMLGregorianCalendar value) {
            this.rollToDate = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}TerminateType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Reason"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
     *               &lt;maxLength value="255"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}CharterVersionGUID"/&gt;
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
        "reason",
        "charterVersionGUID"
    })
    public static class TerminateCharter
        extends TerminateType
    {

        @XmlElement(name = "Reason", required = true)
        protected String reason;
        @XmlElement(name = "CharterVersionGUID", required = true)
        protected String charterVersionGUID;

        /**
         * Gets the value of the reason property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReason() {
            return reason;
        }

        /**
         * Sets the value of the reason property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReason(String value) {
            this.reason = value;
        }

        /**
         * Gets the value of the charterVersionGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharterVersionGUID() {
            return charterVersionGUID;
        }

        /**
         * Sets the value of the charterVersionGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharterVersionGUID(String value) {
            this.charterVersionGUID = value;
        }

    }

}
