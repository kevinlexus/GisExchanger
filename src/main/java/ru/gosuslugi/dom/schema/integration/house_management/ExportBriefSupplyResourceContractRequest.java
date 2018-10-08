
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
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


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
 *           &lt;element name="NextPageContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *           &lt;element name="NextPageObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Criteria" maxOccurs="10"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *                     &lt;choice&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;/sequence&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;/sequence&gt;
 *                       &lt;sequence&gt;
 *                         &lt;element name="ContractNumber" minOccurs="0"&gt;
 *                           &lt;simpleType&gt;
 *                             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
 *                               &lt;maxLength value="100"/&gt;
 *                               &lt;minLength value="1"/&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/simpleType&gt;
 *                         &lt;/element&gt;
 *                         &lt;element name="SigningDateStart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                         &lt;element name="SigningDateEnd" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                         &lt;element name="ContractSubject" maxOccurs="100" minOccurs="0"&gt;
 *                           &lt;complexType&gt;
 *                             &lt;complexContent&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                 &lt;sequence&gt;
 *                                   &lt;element name="ServiceType"&gt;
 *                                     &lt;complexType&gt;
 *                                       &lt;complexContent&gt;
 *                                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *                                         &lt;/extension&gt;
 *                                       &lt;/complexContent&gt;
 *                                     &lt;/complexType&gt;
 *                                   &lt;/element&gt;
 *                                   &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                 &lt;/sequence&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/complexContent&gt;
 *                           &lt;/complexType&gt;
 *                         &lt;/element&gt;
 *                       &lt;/sequence&gt;
 *                     &lt;/choice&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Organization" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.14.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nextPageContractRootGUID",
    "nextPageObjectGUID",
    "criteria",
    "organization"
})
@XmlRootElement(name = "exportBriefSupplyResourceContractRequest")
public class ExportBriefSupplyResourceContractRequest
    extends BaseType
{

    @XmlElement(name = "NextPageContractRootGUID")
    protected String nextPageContractRootGUID;
    @XmlElement(name = "NextPageObjectGUID")
    protected String nextPageObjectGUID;
    @XmlElement(name = "Criteria")
    protected List<ExportBriefSupplyResourceContractRequest.Criteria> criteria;
    @XmlElement(name = "Organization")
    protected RegOrgType organization;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the nextPageContractRootGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextPageContractRootGUID() {
        return nextPageContractRootGUID;
    }

    /**
     * Sets the value of the nextPageContractRootGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextPageContractRootGUID(String value) {
        this.nextPageContractRootGUID = value;
    }

    /**
     * Gets the value of the nextPageObjectGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextPageObjectGUID() {
        return nextPageObjectGUID;
    }

    /**
     * Sets the value of the nextPageObjectGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextPageObjectGUID(String value) {
        this.nextPageObjectGUID = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportBriefSupplyResourceContractRequest.Criteria }
     * 
     * 
     */
    public List<ExportBriefSupplyResourceContractRequest.Criteria> getCriteria() {
        if (criteria == null) {
            criteria = new ArrayList<ExportBriefSupplyResourceContractRequest.Criteria>();
        }
        return this.criteria;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link RegOrgType }
     *     
     */
    public RegOrgType getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegOrgType }
     *     
     */
    public void setOrganization(RegOrgType value) {
        this.organization = value;
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
            return "11.14.0.1";
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
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="ContractNumber" minOccurs="0"&gt;
     *               &lt;simpleType&gt;
     *                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}LongTextType"&gt;
     *                   &lt;maxLength value="100"/&gt;
     *                   &lt;minLength value="1"/&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/simpleType&gt;
     *             &lt;/element&gt;
     *             &lt;element name="SigningDateStart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *             &lt;element name="SigningDateEnd" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *             &lt;element name="ContractSubject" maxOccurs="100" minOccurs="0"&gt;
     *               &lt;complexType&gt;
     *                 &lt;complexContent&gt;
     *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element name="ServiceType"&gt;
     *                         &lt;complexType&gt;
     *                           &lt;complexContent&gt;
     *                             &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *                             &lt;/extension&gt;
     *                           &lt;/complexContent&gt;
     *                         &lt;/complexType&gt;
     *                       &lt;/element&gt;
     *                       &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                     &lt;/sequence&gt;
     *                   &lt;/restriction&gt;
     *                 &lt;/complexContent&gt;
     *               &lt;/complexType&gt;
     *             &lt;/element&gt;
     *           &lt;/sequence&gt;
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
        "fiasHouseGuid",
        "contractGUID",
        "contractRootGUID",
        "contractNumber",
        "signingDateStart",
        "signingDateEnd",
        "contractSubject"
    })
    public static class Criteria {

        @XmlElement(name = "FIASHouseGuid", required = true)
        protected String fiasHouseGuid;
        @XmlElement(name = "ContractGUID")
        protected String contractGUID;
        @XmlElement(name = "ContractRootGUID")
        protected String contractRootGUID;
        @XmlElement(name = "ContractNumber")
        protected String contractNumber;
        @XmlElement(name = "SigningDateStart")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDateStart;
        @XmlElement(name = "SigningDateEnd")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDateEnd;
        @XmlElement(name = "ContractSubject")
        protected List<ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject> contractSubject;

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
         * Gets the value of the contractGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractGUID() {
            return contractGUID;
        }

        /**
         * Sets the value of the contractGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractGUID(String value) {
            this.contractGUID = value;
        }

        /**
         * Gets the value of the contractRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractRootGUID() {
            return contractRootGUID;
        }

        /**
         * Sets the value of the contractRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractRootGUID(String value) {
            this.contractRootGUID = value;
        }

        /**
         * Gets the value of the contractNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractNumber() {
            return contractNumber;
        }

        /**
         * Sets the value of the contractNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractNumber(String value) {
            this.contractNumber = value;
        }

        /**
         * Gets the value of the signingDateStart property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDateStart() {
            return signingDateStart;
        }

        /**
         * Sets the value of the signingDateStart property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDateStart(XMLGregorianCalendar value) {
            this.signingDateStart = value;
        }

        /**
         * Gets the value of the signingDateEnd property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDateEnd() {
            return signingDateEnd;
        }

        /**
         * Sets the value of the signingDateEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDateEnd(XMLGregorianCalendar value) {
            this.signingDateEnd = value;
        }

        /**
         * Gets the value of the contractSubject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractSubject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractSubject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject }
         * 
         * 
         */
        public List<ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject> getContractSubject() {
            if (contractSubject == null) {
                contractSubject = new ArrayList<ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject>();
            }
            return this.contractSubject;
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
         *         &lt;element name="ServiceType"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
            "serviceType",
            "municipalResource"
        })
        public static class ContractSubject {

            @XmlElement(name = "ServiceType", required = true)
            protected ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject.ServiceType serviceType;
            @XmlElement(name = "MunicipalResource", required = true)
            protected NsiRef municipalResource;

            /**
             * Gets the value of the serviceType property.
             * 
             * @return
             *     possible object is
             *     {@link ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject.ServiceType }
             *     
             */
            public ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject.ServiceType getServiceType() {
                return serviceType;
            }

            /**
             * Sets the value of the serviceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject.ServiceType }
             *     
             */
            public void setServiceType(ExportBriefSupplyResourceContractRequest.Criteria.ContractSubject.ServiceType value) {
                this.serviceType = value;
            }

            /**
             * Gets the value of the municipalResource property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getMunicipalResource() {
                return municipalResource;
            }

            /**
             * Sets the value of the municipalResource property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setMunicipalResource(NsiRef value) {
                this.municipalResource = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
             *     &lt;/extension&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ServiceType
                extends NsiRef
            {


            }

        }

    }

}
