
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Сведения о субъекте проверки для плановой проверки в плане
 * 
 * <p>Java class for ScheduledExaminationSubjectInPlanInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduledExaminationSubjectInPlanInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Organization"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
 *                   &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
 *                   &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/&gt;
 *                   &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
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
@XmlType(name = "ScheduledExaminationSubjectInPlanInfoType", propOrder = {
    "organization",
    "individual"
})
public class ScheduledExaminationSubjectInPlanInfoType {

    @XmlElement(name = "Organization")
    protected ScheduledExaminationSubjectInPlanInfoType.Organization organization;
    @XmlElement(name = "Individual")
    protected ScheduledExaminationSubjectInPlanInfoType.Individual individual;

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType.Organization }
     *     
     */
    public ScheduledExaminationSubjectInPlanInfoType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType.Organization }
     *     
     */
    public void setOrganization(ScheduledExaminationSubjectInPlanInfoType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the individual property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType.Individual }
     *     
     */
    public ScheduledExaminationSubjectInPlanInfoType.Individual getIndividual() {
        return individual;
    }

    /**
     * Sets the value of the individual property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledExaminationSubjectInPlanInfoType.Individual }
     *     
     */
    public void setIndividual(ScheduledExaminationSubjectInPlanInfoType.Individual value) {
        this.individual = value;
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
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String2000Type"/&gt;
     *         &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "actualActivityPlace",
        "smallBusiness"
    })
    public static class Individual
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "SmallBusiness")
        protected boolean smallBusiness;

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
     *         &lt;element name="ActualActivityPlace" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String6000Type"/&gt;
     *         &lt;element name="SmallBusiness" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "actualActivityPlace",
        "smallBusiness"
    })
    public static class Organization
        extends RegOrgType
    {

        @XmlElement(name = "ActualActivityPlace", required = true)
        protected String actualActivityPlace;
        @XmlElement(name = "SmallBusiness")
        protected boolean smallBusiness;

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

    }

}
