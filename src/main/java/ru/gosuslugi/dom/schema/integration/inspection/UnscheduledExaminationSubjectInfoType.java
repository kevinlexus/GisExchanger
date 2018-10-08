
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Сведения о субъекте проверки для внеплановой проверки в реестре
 * 
 * <p>Java class for UnscheduledExaminationSubjectInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnscheduledExaminationSubjectInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Organization"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
 *                   &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Individual"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
 *                   &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Citizen" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CitizenInfoType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnscheduledExaminationSubjectInfoType", propOrder = {
    "organization",
    "individual",
    "citizen"
})
public class UnscheduledExaminationSubjectInfoType {

    @XmlElement(name = "Organization")
    protected UnscheduledExaminationSubjectInfoType.Organization organization;
    @XmlElement(name = "Individual")
    protected UnscheduledExaminationSubjectInfoType.Individual individual;
    @XmlElement(name = "Citizen")
    protected CitizenInfoType citizen;

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link UnscheduledExaminationSubjectInfoType.Organization }
     *     
     */
    public UnscheduledExaminationSubjectInfoType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnscheduledExaminationSubjectInfoType.Organization }
     *     
     */
    public void setOrganization(UnscheduledExaminationSubjectInfoType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the individual property.
     * 
     * @return
     *     possible object is
     *     {@link UnscheduledExaminationSubjectInfoType.Individual }
     *     
     */
    public UnscheduledExaminationSubjectInfoType.Individual getIndividual() {
        return individual;
    }

    /**
     * Sets the value of the individual property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnscheduledExaminationSubjectInfoType.Individual }
     *     
     */
    public void setIndividual(UnscheduledExaminationSubjectInfoType.Individual value) {
        this.individual = value;
    }

    /**
     * Gets the value of the citizen property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenInfoType }
     *     
     */
    public CitizenInfoType getCitizen() {
        return citizen;
    }

    /**
     * Sets the value of the citizen property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenInfoType }
     *     
     */
    public void setCitizen(CitizenInfoType value) {
        this.citizen = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
     *         &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
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
        "smallBusiness",
        "actualActivityPlace",
        "otherPersons"
    })
    public static class Individual
        extends RegOrgType
    {

        @XmlElement(name = "SmallBusiness")
        protected boolean smallBusiness;
        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "OtherPersons")
        protected String otherPersons;

        /**
         * Gets the value of the smallBusiness property.
         * 
         */
        public boolean isSmallBusiness() {
            return smallBusiness;
        }

        /**
         * Sets the value of the smallBusiness property.
         * 
         */
        public void setSmallBusiness(boolean value) {
            this.smallBusiness = value;
        }

        /**
         * Gets the value of the actualActivityPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActualActivityPlace() {
            return actualActivityPlace;
        }

        /**
         * Sets the value of the actualActivityPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActualActivityPlace(String value) {
            this.actualActivityPlace = value;
        }

        /**
         * Gets the value of the otherPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOtherPersons() {
            return otherPersons;
        }

        /**
         * Sets the value of the otherPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOtherPersons(String value) {
            this.otherPersons = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
     *         &lt;element name="OtherPersons" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type" minOccurs="0"/&gt;
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
        "smallBusiness",
        "actualActivityPlace",
        "otherPersons"
    })
    public static class Organization
        extends RegOrgType
    {

        @XmlElement(name = "SmallBusiness")
        protected boolean smallBusiness;
        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "OtherPersons")
        protected String otherPersons;

        /**
         * Gets the value of the smallBusiness property.
         * 
         */
        public boolean isSmallBusiness() {
            return smallBusiness;
        }

        /**
         * Sets the value of the smallBusiness property.
         * 
         */
        public void setSmallBusiness(boolean value) {
            this.smallBusiness = value;
        }

        /**
         * Gets the value of the actualActivityPlace property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActualActivityPlace() {
            return actualActivityPlace;
        }

        /**
         * Sets the value of the actualActivityPlace property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActualActivityPlace(String value) {
            this.actualActivityPlace = value;
        }

        /**
         * Gets the value of the otherPersons property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOtherPersons() {
            return otherPersons;
        }

        /**
         * Sets the value of the otherPersons property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOtherPersons(String value) {
            this.otherPersons = value;
        }

    }

}
