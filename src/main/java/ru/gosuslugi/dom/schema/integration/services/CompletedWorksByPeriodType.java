
package ru.gosuslugi.dom.schema.integration.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Выполненная работа за период
 * 
 * <p>Java class for CompletedWorksByPeriodType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompletedWorksByPeriodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reportingPeriodGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="PlannedWork" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="plannedCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UnplannedWork" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice minOccurs="0"&gt;
 *                     &lt;element name="Accident"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                               &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                               &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attribute name="workType"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/attribute&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DeliveryRestriction"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                               &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attribute name="workType"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="5"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/attribute&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="Work" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="workType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
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
@XmlType(name = "CompletedWorksByPeriodType", propOrder = {
    "reportingPeriodGuid",
    "plannedWork",
    "unplannedWork"
})
public class CompletedWorksByPeriodType {

    @XmlElement(required = true)
    protected String reportingPeriodGuid;
    @XmlElement(name = "PlannedWork")
    protected List<CompletedWorksByPeriodType.PlannedWork> plannedWork;
    @XmlElement(name = "UnplannedWork")
    protected List<CompletedWorksByPeriodType.UnplannedWork> unplannedWork;

    /**
     * Gets the value of the reportingPeriodGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingPeriodGuid() {
        return reportingPeriodGuid;
    }

    /**
     * Sets the value of the reportingPeriodGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingPeriodGuid(String value) {
        this.reportingPeriodGuid = value;
    }

    /**
     * Gets the value of the plannedWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedWorksByPeriodType.PlannedWork }
     * 
     * 
     */
    public List<CompletedWorksByPeriodType.PlannedWork> getPlannedWork() {
        if (plannedWork == null) {
            plannedWork = new ArrayList<CompletedWorksByPeriodType.PlannedWork>();
        }
        return this.plannedWork;
    }

    /**
     * Gets the value of the unplannedWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unplannedWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnplannedWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompletedWorksByPeriodType.UnplannedWork }
     * 
     * 
     */
    public List<CompletedWorksByPeriodType.UnplannedWork> getUnplannedWork() {
        if (unplannedWork == null) {
            unplannedWork = new ArrayList<CompletedWorksByPeriodType.UnplannedWork>();
        }
        return this.unplannedWork;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="WorkPlanItemGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="plannedCount" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
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
        "workPlanItemGUID",
        "plannedCount"
    })
    public static class PlannedWork
        extends CompletedWorkType
    {

        @XmlElement(name = "WorkPlanItemGUID", required = true)
        protected String workPlanItemGUID;
        @XmlElement(required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger plannedCount;

        /**
         * Gets the value of the workPlanItemGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWorkPlanItemGUID() {
            return workPlanItemGUID;
        }

        /**
         * Sets the value of the workPlanItemGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWorkPlanItemGUID(String value) {
            this.workPlanItemGUID = value;
        }

        /**
         * Gets the value of the plannedCount property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPlannedCount() {
            return plannedCount;
        }

        /**
         * Sets the value of the plannedCount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPlannedCount(BigInteger value) {
            this.plannedCount = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/services/}CompletedWorkType"&gt;
     *       &lt;sequence&gt;
     *         &lt;choice minOccurs="0"&gt;
     *           &lt;element name="Accident"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                     &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                     &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;attribute name="workType"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/attribute&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="DeliveryRestriction"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *                     &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;attribute name="workType"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="5"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/attribute&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="Work" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="workType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
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
        "accident",
        "deliveryRestriction",
        "comment",
        "work",
        "workType"
    })
    public static class UnplannedWork
        extends CompletedWorkType
    {

        @XmlElement(name = "Accident")
        protected CompletedWorksByPeriodType.UnplannedWork.Accident accident;
        @XmlElement(name = "DeliveryRestriction")
        protected CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction deliveryRestriction;
        @XmlElement(name = "Comment")
        protected String comment;
        @XmlElement(name = "Work", required = true)
        protected NsiRef work;
        @XmlElement(required = true)
        protected NsiRef workType;

        /**
         * Gets the value of the accident property.
         * 
         * @return
         *     possible object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.Accident }
         *     
         */
        public CompletedWorksByPeriodType.UnplannedWork.Accident getAccident() {
            return accident;
        }

        /**
         * Sets the value of the accident property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.Accident }
         *     
         */
        public void setAccident(CompletedWorksByPeriodType.UnplannedWork.Accident value) {
            this.accident = value;
        }

        /**
         * Gets the value of the deliveryRestriction property.
         * 
         * @return
         *     possible object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction }
         *     
         */
        public CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction getDeliveryRestriction() {
            return deliveryRestriction;
        }

        /**
         * Sets the value of the deliveryRestriction property.
         * 
         * @param value
         *     allowed object is
         *     {@link CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction }
         *     
         */
        public void setDeliveryRestriction(CompletedWorksByPeriodType.UnplannedWork.DeliveryRestriction value) {
            this.deliveryRestriction = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComment() {
            return comment;
        }

        /**
         * Sets the value of the comment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

        /**
         * Gets the value of the work property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getWork() {
            return work;
        }

        /**
         * Sets the value of the work property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setWork(NsiRef value) {
            this.work = value;
        }

        /**
         * Gets the value of the workType property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getWorkType() {
            return workType;
        }

        /**
         * Sets the value of the workType property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setWorkType(NsiRef value) {
            this.workType = value;
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
         *         &lt;element name="accidentObjectKind" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
         *         &lt;element name="accidentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="workType"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="3"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "accidentObjectKind",
            "accidentReason",
            "msType"
        })
        public static class Accident {

            protected NsiRef accidentObjectKind;
            protected String accidentReason;
            @XmlElement(name = "MSType")
            protected NsiRef msType;
            @XmlAttribute(name = "workType")
            protected String workType;

            /**
             * Gets the value of the accidentObjectKind property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getAccidentObjectKind() {
                return accidentObjectKind;
            }

            /**
             * Sets the value of the accidentObjectKind property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setAccidentObjectKind(NsiRef value) {
                this.accidentObjectKind = value;
            }

            /**
             * Gets the value of the accidentReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccidentReason() {
                return accidentReason;
            }

            /**
             * Sets the value of the accidentReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccidentReason(String value) {
                this.accidentReason = value;
            }

            /**
             * Gets the value of the msType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getMSType() {
                return msType;
            }

            /**
             * Sets the value of the msType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setMSType(NsiRef value) {
                this.msType = value;
            }

            /**
             * Gets the value of the workType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkType() {
                return workType;
            }

            /**
             * Sets the value of the workType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkType(String value) {
                this.workType = value;
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
         *         &lt;element name="MSType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
         *         &lt;element name="OrganizationGUID" type="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="workType"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *             &lt;enumeration value="5"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "msType",
            "organizationGUID"
        })
        public static class DeliveryRestriction {

            @XmlElement(name = "MSType")
            protected NsiRef msType;
            @XmlElement(name = "OrganizationGUID")
            protected RegOrgType organizationGUID;
            @XmlAttribute(name = "workType")
            protected String workType;

            /**
             * Gets the value of the msType property.
             * 
             * @return
             *     possible object is
             *     {@link NsiRef }
             *     
             */
            public NsiRef getMSType() {
                return msType;
            }

            /**
             * Sets the value of the msType property.
             * 
             * @param value
             *     allowed object is
             *     {@link NsiRef }
             *     
             */
            public void setMSType(NsiRef value) {
                this.msType = value;
            }

            /**
             * Gets the value of the organizationGUID property.
             * 
             * @return
             *     possible object is
             *     {@link RegOrgType }
             *     
             */
            public RegOrgType getOrganizationGUID() {
                return organizationGUID;
            }

            /**
             * Sets the value of the organizationGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link RegOrgType }
             *     
             */
            public void setOrganizationGUID(RegOrgType value) {
                this.organizationGUID = value;
            }

            /**
             * Gets the value of the workType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWorkType() {
                return workType;
            }

            /**
             * Sets the value of the workType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWorkType(String value) {
                this.workType = value;
            }

        }

    }

}
