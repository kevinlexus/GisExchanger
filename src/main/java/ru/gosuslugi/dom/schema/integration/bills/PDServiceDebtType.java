
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Задолженность услугам в ПД
 * 
 * <p>Java class for PDServiceDebtType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PDServiceDebtType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="HousingService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
 *                 &lt;sequence minOccurs="0"&gt;
 *                   &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="TotalPayable"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                     &lt;totalDigits value="18"/&gt;
 *                                     &lt;fractionDigits value="2"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="TotalSumDebtPayable"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                     &lt;totalDigits value="18"/&gt;
 *                                     &lt;fractionDigits value="2"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                             &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                             &lt;element name="GeneralMunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                                       &lt;choice&gt;
 *                                         &lt;element name="TotalPayable"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                               &lt;totalDigits value="18"/&gt;
 *                                               &lt;fractionDigits value="2"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="TotalSumDebtPayable"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                               &lt;totalDigits value="18"/&gt;
 *                                               &lt;fractionDigits value="2"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/choice&gt;
 *                                       &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdditionalService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GroupMunicipalService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TypeMunicipalService"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
 *                                 &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
 *                                 &lt;element name="TotalPayable"&gt;
 *                                   &lt;simpleType&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                       &lt;totalDigits value="13"/&gt;
 *                                       &lt;fractionDigits value="2"/&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/simpleType&gt;
 *                                 &lt;/element&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="TotalSumDebtPayable"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                     &lt;totalDigits value="18"/&gt;
 *                                     &lt;fractionDigits value="2"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MunicipalService" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PDServiceDebtType", propOrder = {
    "housingService",
    "additionalService",
    "municipalService",
    "groupMunicipalService"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentExportType.ChargeDebt.class
})
public class PDServiceDebtType {

    @XmlElement(name = "HousingService")
    protected PDServiceDebtType.HousingService housingService;
    @XmlElement(name = "AdditionalService")
    protected PDServiceDebtType.AdditionalService additionalService;
    @XmlElement(name = "MunicipalService")
    protected PDServiceDebtType.MunicipalService municipalService;
    @XmlElement(name = "GroupMunicipalService")
    protected PDServiceDebtType.GroupMunicipalService groupMunicipalService;

    /**
     * Gets the value of the housingService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceDebtType.HousingService }
     *     
     */
    public PDServiceDebtType.HousingService getHousingService() {
        return housingService;
    }

    /**
     * Sets the value of the housingService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceDebtType.HousingService }
     *     
     */
    public void setHousingService(PDServiceDebtType.HousingService value) {
        this.housingService = value;
    }

    /**
     * Gets the value of the additionalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceDebtType.AdditionalService }
     *     
     */
    public PDServiceDebtType.AdditionalService getAdditionalService() {
        return additionalService;
    }

    /**
     * Sets the value of the additionalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceDebtType.AdditionalService }
     *     
     */
    public void setAdditionalService(PDServiceDebtType.AdditionalService value) {
        this.additionalService = value;
    }

    /**
     * Gets the value of the municipalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceDebtType.MunicipalService }
     *     
     */
    public PDServiceDebtType.MunicipalService getMunicipalService() {
        return municipalService;
    }

    /**
     * Sets the value of the municipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceDebtType.MunicipalService }
     *     
     */
    public void setMunicipalService(PDServiceDebtType.MunicipalService value) {
        this.municipalService = value;
    }

    /**
     * Gets the value of the groupMunicipalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceDebtType.GroupMunicipalService }
     *     
     */
    public PDServiceDebtType.GroupMunicipalService getGroupMunicipalService() {
        return groupMunicipalService;
    }

    /**
     * Sets the value of the groupMunicipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceDebtType.GroupMunicipalService }
     *     
     */
    public void setGroupMunicipalService(PDServiceDebtType.GroupMunicipalService value) {
        this.groupMunicipalService = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AdditionalService
        extends ServiceDebtType
    {


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
     *         &lt;element name="TypeMunicipalService"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
     *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
     *                       &lt;element name="TotalPayable"&gt;
     *                         &lt;simpleType&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                             &lt;totalDigits value="13"/&gt;
     *                             &lt;fractionDigits value="2"/&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/simpleType&gt;
     *                       &lt;/element&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;element name="TotalSumDebtPayable"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                           &lt;totalDigits value="18"/&gt;
     *                           &lt;fractionDigits value="2"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MunicipalService" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "typeMunicipalService",
        "municipalService"
    })
    public static class GroupMunicipalService {

        @XmlElement(name = "TypeMunicipalService", required = true)
        protected PDServiceDebtType.GroupMunicipalService.TypeMunicipalService typeMunicipalService;
        @XmlElement(name = "MunicipalService")
        protected List<ServiceDebtType> municipalService;

        /**
         * Gets the value of the typeMunicipalService property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceDebtType.GroupMunicipalService.TypeMunicipalService }
         *     
         */
        public PDServiceDebtType.GroupMunicipalService.TypeMunicipalService getTypeMunicipalService() {
            return typeMunicipalService;
        }

        /**
         * Sets the value of the typeMunicipalService property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceDebtType.GroupMunicipalService.TypeMunicipalService }
         *     
         */
        public void setTypeMunicipalService(PDServiceDebtType.GroupMunicipalService.TypeMunicipalService value) {
            this.typeMunicipalService = value;
        }

        /**
         * Gets the value of the municipalService property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the municipalService property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMunicipalService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ServiceDebtType }
         * 
         * 
         */
        public List<ServiceDebtType> getMunicipalService() {
            if (municipalService == null) {
                municipalService = new ArrayList<ServiceDebtType>();
            }
            return this.municipalService;
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
         *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *         &lt;choice&gt;
         *           &lt;sequence&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Month"/&gt;
         *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}Year"/&gt;
         *             &lt;element name="TotalPayable"&gt;
         *               &lt;simpleType&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                   &lt;totalDigits value="13"/&gt;
         *                   &lt;fractionDigits value="2"/&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/simpleType&gt;
         *             &lt;/element&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="TotalSumDebtPayable"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                 &lt;totalDigits value="18"/&gt;
         *                 &lt;fractionDigits value="2"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
            "month",
            "year",
            "totalPayable",
            "totalSumDebtPayable",
            "orgPPAGUID"
        })
        public static class TypeMunicipalService {

            @XmlElement(name = "ServiceType", required = true)
            protected NsiRef serviceType;
            @XmlElement(name = "Month", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
            protected Integer month;
            @XmlElement(name = "Year", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
            protected Short year;
            @XmlElement(name = "TotalPayable")
            protected BigDecimal totalPayable;
            @XmlElement(name = "TotalSumDebtPayable")
            protected BigDecimal totalSumDebtPayable;
            protected String orgPPAGUID;

            /**
             * Gets the value of the serviceType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getServiceType() {
                return serviceType;
            }

            /**
             * Sets the value of the serviceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setServiceType(NsiRef value) {
                this.serviceType = value;
            }

            /**
             * Месяц
             * Ссылка на пост. 924 – Приложение 2, п. 6 в).
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getMonth() {
                return month;
            }

            /**
             * Sets the value of the month property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setMonth(Integer value) {
                this.month = value;
            }

            /**
             * Год
             * Ссылка на пост. 924 – Приложение 2, п. 6 в).
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getYear() {
                return year;
            }

            /**
             * Sets the value of the year property.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setYear(Short value) {
                this.year = value;
            }

            /**
             * Gets the value of the totalPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTotalPayable() {
                return totalPayable;
            }

            /**
             * Sets the value of the totalPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTotalPayable(BigDecimal value) {
                this.totalPayable = value;
            }

            /**
             * Gets the value of the totalSumDebtPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTotalSumDebtPayable() {
                return totalSumDebtPayable;
            }

            /**
             * Sets the value of the totalSumDebtPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTotalSumDebtPayable(BigDecimal value) {
                this.totalSumDebtPayable = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
     *       &lt;sequence minOccurs="0"&gt;
     *         &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="TotalPayable"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                           &lt;totalDigits value="18"/&gt;
     *                           &lt;fractionDigits value="2"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="TotalSumDebtPayable"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                           &lt;totalDigits value="18"/&gt;
     *                           &lt;fractionDigits value="2"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                   &lt;element name="GeneralMunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                             &lt;choice&gt;
     *                               &lt;element name="TotalPayable"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                     &lt;totalDigits value="18"/&gt;
     *                                     &lt;fractionDigits value="2"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="TotalSumDebtPayable"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                     &lt;totalDigits value="18"/&gt;
     *                                     &lt;fractionDigits value="2"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/choice&gt;
     *                             &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
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
        "municipalResource"
    })
    public static class HousingService
        extends ServiceDebtType
    {

        @XmlElement(name = "MunicipalResource")
        protected List<PDServiceDebtType.HousingService.MunicipalResource> municipalResource;

        /**
         * Gets the value of the municipalResource property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the municipalResource property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMunicipalResource().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PDServiceDebtType.HousingService.MunicipalResource }
         * 
         * 
         */
        public List<PDServiceDebtType.HousingService.MunicipalResource> getMunicipalResource() {
            if (municipalResource == null) {
                municipalResource = new ArrayList<PDServiceDebtType.HousingService.MunicipalResource>();
            }
            return this.municipalResource;
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
         *           &lt;element name="TotalPayable"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                 &lt;totalDigits value="18"/&gt;
         *                 &lt;fractionDigits value="2"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="TotalSumDebtPayable"&gt;
         *             &lt;simpleType&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                 &lt;totalDigits value="18"/&gt;
         *                 &lt;fractionDigits value="2"/&gt;
         *               &lt;/restriction&gt;
         *             &lt;/simpleType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *         &lt;element name="GeneralMunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
         *                   &lt;choice&gt;
         *                     &lt;element name="TotalPayable"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                           &lt;totalDigits value="18"/&gt;
         *                           &lt;fractionDigits value="2"/&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                     &lt;element name="TotalSumDebtPayable"&gt;
         *                       &lt;simpleType&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                           &lt;totalDigits value="18"/&gt;
         *                           &lt;fractionDigits value="2"/&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/simpleType&gt;
         *                     &lt;/element&gt;
         *                   &lt;/choice&gt;
         *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
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
        @XmlType(name = "", propOrder = {
            "totalPayable",
            "totalSumDebtPayable",
            "serviceType",
            "orgPPAGUID",
            "generalMunicipalResource"
        })
        public static class MunicipalResource {

            @XmlElement(name = "TotalPayable")
            protected BigDecimal totalPayable;
            @XmlElement(name = "TotalSumDebtPayable")
            protected BigDecimal totalSumDebtPayable;
            @XmlElement(name = "ServiceType", required = true)
            protected NsiRef serviceType;
            protected String orgPPAGUID;
            @XmlElement(name = "GeneralMunicipalResource")
            protected List<PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource> generalMunicipalResource;

            /**
             * Gets the value of the totalPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTotalPayable() {
                return totalPayable;
            }

            /**
             * Sets the value of the totalPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTotalPayable(BigDecimal value) {
                this.totalPayable = value;
            }

            /**
             * Gets the value of the totalSumDebtPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTotalSumDebtPayable() {
                return totalSumDebtPayable;
            }

            /**
             * Sets the value of the totalSumDebtPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTotalSumDebtPayable(BigDecimal value) {
                this.totalSumDebtPayable = value;
            }

            /**
             * Gets the value of the serviceType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getServiceType() {
                return serviceType;
            }

            /**
             * Sets the value of the serviceType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setServiceType(NsiRef value) {
                this.serviceType = value;
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
             * Gets the value of the generalMunicipalResource property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the generalMunicipalResource property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getGeneralMunicipalResource().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource }
             * 
             * 
             */
            public List<PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource> getGeneralMunicipalResource() {
                if (generalMunicipalResource == null) {
                    generalMunicipalResource = new ArrayList<PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource>();
                }
                return this.generalMunicipalResource;
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
             *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
             *         &lt;choice&gt;
             *           &lt;element name="TotalPayable"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *                 &lt;totalDigits value="18"/&gt;
             *                 &lt;fractionDigits value="2"/&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *           &lt;element name="TotalSumDebtPayable"&gt;
             *             &lt;simpleType&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *                 &lt;totalDigits value="18"/&gt;
             *                 &lt;fractionDigits value="2"/&gt;
             *               &lt;/restriction&gt;
             *             &lt;/simpleType&gt;
             *           &lt;/element&gt;
             *         &lt;/choice&gt;
             *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
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
                "totalPayable",
                "totalSumDebtPayable",
                "orgPPAGUID"
            })
            public static class GeneralMunicipalResource {

                @XmlElement(name = "ServiceType", required = true)
                protected NsiRef serviceType;
                @XmlElement(name = "TotalPayable")
                protected BigDecimal totalPayable;
                @XmlElement(name = "TotalSumDebtPayable")
                protected BigDecimal totalSumDebtPayable;
                protected String orgPPAGUID;

                /**
                 * Gets the value of the serviceType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NsiRef }
                 *     
                 */
                public NsiRef getServiceType() {
                    return serviceType;
                }

                /**
                 * Sets the value of the serviceType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NsiRef }
                 *     
                 */
                public void setServiceType(NsiRef value) {
                    this.serviceType = value;
                }

                /**
                 * Gets the value of the totalPayable property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTotalPayable() {
                    return totalPayable;
                }

                /**
                 * Sets the value of the totalPayable property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTotalPayable(BigDecimal value) {
                    this.totalPayable = value;
                }

                /**
                 * Gets the value of the totalSumDebtPayable property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTotalSumDebtPayable() {
                    return totalSumDebtPayable;
                }

                /**
                 * Sets the value of the totalSumDebtPayable property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTotalSumDebtPayable(BigDecimal value) {
                    this.totalSumDebtPayable = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceDebtType"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MunicipalService
        extends ServiceDebtType
    {


    }

}
