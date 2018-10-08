
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Возвращаемый план проверок.
 * 
 * <p>Java class for exportInspectionPlanResultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exportInspectionPlanResultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InspectionPlanGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *         &lt;element name="RegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *         &lt;element name="PlanState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}InspectionPlanStateType"/&gt;
 *         &lt;element name="InspectionPlan"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}URIInformationType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Year" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PlannedExamination" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PlannedExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="RegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
 *                   &lt;element name="State" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationStateType"/&gt;
 *                   &lt;element name="VersionState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationVersionStateType"/&gt;
 *                   &lt;element name="PlannedExaminationInfo"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}exportPlannedExaminationType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationChangeInfoType" minOccurs="0"/&gt;
 *                             &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "exportInspectionPlanResultType", propOrder = {
    "inspectionPlanGuid",
    "registryNumber",
    "planState",
    "inspectionPlan",
    "plannedExamination"
})
public class ExportInspectionPlanResultType {

    @XmlElement(name = "InspectionPlanGuid", required = true)
    protected String inspectionPlanGuid;
    @XmlElement(name = "RegistryNumber")
    protected String registryNumber;
    @XmlElement(name = "PlanState", required = true)
    @XmlSchemaType(name = "token")
    protected InspectionPlanStateType planState;
    @XmlElement(name = "InspectionPlan", required = true)
    protected ExportInspectionPlanResultType.InspectionPlan inspectionPlan;
    @XmlElement(name = "PlannedExamination")
    protected List<ExportInspectionPlanResultType.PlannedExamination> plannedExamination;

    /**
     * Gets the value of the inspectionPlanGuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionPlanGuid() {
        return inspectionPlanGuid;
    }

    /**
     * Sets the value of the inspectionPlanGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionPlanGuid(String value) {
        this.inspectionPlanGuid = value;
    }

    /**
     * Gets the value of the registryNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistryNumber() {
        return registryNumber;
    }

    /**
     * Sets the value of the registryNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistryNumber(String value) {
        this.registryNumber = value;
    }

    /**
     * Gets the value of the planState property.
     * 
     * @return
     *     possible object is
     *     {@link InspectionPlanStateType }
     *     
     */
    public InspectionPlanStateType getPlanState() {
        return planState;
    }

    /**
     * Sets the value of the planState property.
     * 
     * @param value
     *     allowed object is
     *     {@link InspectionPlanStateType }
     *     
     */
    public void setPlanState(InspectionPlanStateType value) {
        this.planState = value;
    }

    /**
     * Gets the value of the inspectionPlan property.
     * 
     * @return
     *     possible object is
     *     {@link ExportInspectionPlanResultType.InspectionPlan }
     *     
     */
    public ExportInspectionPlanResultType.InspectionPlan getInspectionPlan() {
        return inspectionPlan;
    }

    /**
     * Sets the value of the inspectionPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportInspectionPlanResultType.InspectionPlan }
     *     
     */
    public void setInspectionPlan(ExportInspectionPlanResultType.InspectionPlan value) {
        this.inspectionPlan = value;
    }

    /**
     * Gets the value of the plannedExamination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedExamination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedExamination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportInspectionPlanResultType.PlannedExamination }
     * 
     * 
     */
    public List<ExportInspectionPlanResultType.PlannedExamination> getPlannedExamination() {
        if (plannedExamination == null) {
            plannedExamination = new ArrayList<ExportInspectionPlanResultType.PlannedExamination>();
        }
        return this.plannedExamination;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}URIInformationType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Year" type="{http://dom.gosuslugi.ru/schema/integration/base/}YearType"/&gt;
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
        "year"
    })
    public static class InspectionPlan
        extends URIInformationType
    {

        @XmlElement(name = "Year")
        protected short year;

        /**
         * Gets the value of the year property.
         * 
         */
        public short getYear() {
            return year;
        }

        /**
         * Sets the value of the year property.
         * 
         */
        public void setYear(short value) {
            this.year = value;
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
     *         &lt;element name="PlannedExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="RegistryNumber" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}String255Type" minOccurs="0"/&gt;
     *         &lt;element name="State" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationStateType"/&gt;
     *         &lt;element name="VersionState" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationVersionStateType"/&gt;
     *         &lt;element name="PlannedExaminationInfo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}exportPlannedExaminationType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationChangeInfoType" minOccurs="0"/&gt;
     *                   &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
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
    @XmlType(name = "", propOrder = {
        "plannedExaminationGuid",
        "registryNumber",
        "state",
        "versionState",
        "plannedExaminationInfo"
    })
    public static class PlannedExamination {

        @XmlElement(name = "PlannedExaminationGuid", required = true)
        protected String plannedExaminationGuid;
        @XmlElement(name = "RegistryNumber")
        protected String registryNumber;
        @XmlElement(name = "State", required = true)
        @XmlSchemaType(name = "token")
        protected PlannedExaminationStateType state;
        @XmlElement(name = "VersionState", required = true)
        @XmlSchemaType(name = "token")
        protected PlannedExaminationVersionStateType versionState;
        @XmlElement(name = "PlannedExaminationInfo", required = true)
        protected ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo plannedExaminationInfo;

        /**
         * Gets the value of the plannedExaminationGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlannedExaminationGuid() {
            return plannedExaminationGuid;
        }

        /**
         * Sets the value of the plannedExaminationGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlannedExaminationGuid(String value) {
            this.plannedExaminationGuid = value;
        }

        /**
         * Gets the value of the registryNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRegistryNumber() {
            return registryNumber;
        }

        /**
         * Sets the value of the registryNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRegistryNumber(String value) {
            this.registryNumber = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link PlannedExaminationStateType }
         *     
         */
        public PlannedExaminationStateType getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link PlannedExaminationStateType }
         *     
         */
        public void setState(PlannedExaminationStateType value) {
            this.state = value;
        }

        /**
         * Gets the value of the versionState property.
         * 
         * @return
         *     possible object is
         *     {@link PlannedExaminationVersionStateType }
         *     
         */
        public PlannedExaminationVersionStateType getVersionState() {
            return versionState;
        }

        /**
         * Sets the value of the versionState property.
         * 
         * @param value
         *     allowed object is
         *     {@link PlannedExaminationVersionStateType }
         *     
         */
        public void setVersionState(PlannedExaminationVersionStateType value) {
            this.versionState = value;
        }

        /**
         * Gets the value of the plannedExaminationInfo property.
         * 
         * @return
         *     possible object is
         *     {@link ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo }
         *     
         */
        public ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo getPlannedExaminationInfo() {
            return plannedExaminationInfo;
        }

        /**
         * Sets the value of the plannedExaminationInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo }
         *     
         */
        public void setPlannedExaminationInfo(ExportInspectionPlanResultType.PlannedExamination.PlannedExaminationInfo value) {
            this.plannedExaminationInfo = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/inspection/}exportPlannedExaminationType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportExaminationChangeInfoType" minOccurs="0"/&gt;
         *         &lt;element name="CancelledInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExportCancelledInfoWithAttachmentsType" minOccurs="0"/&gt;
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
            "examinationChangeInfo",
            "cancelledInfo"
        })
        public static class PlannedExaminationInfo
            extends ExportPlannedExaminationType
        {

            @XmlElement(name = "ExaminationChangeInfo")
            protected ExportExaminationChangeInfoType examinationChangeInfo;
            @XmlElement(name = "CancelledInfo")
            protected ExportCancelledInfoWithAttachmentsType cancelledInfo;

            /**
             * Gets the value of the examinationChangeInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ExportExaminationChangeInfoType }
             *     
             */
            public ExportExaminationChangeInfoType getExaminationChangeInfo() {
                return examinationChangeInfo;
            }

            /**
             * Sets the value of the examinationChangeInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportExaminationChangeInfoType }
             *     
             */
            public void setExaminationChangeInfo(ExportExaminationChangeInfoType value) {
                this.examinationChangeInfo = value;
            }

            /**
             * Gets the value of the cancelledInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ExportCancelledInfoWithAttachmentsType }
             *     
             */
            public ExportCancelledInfoWithAttachmentsType getCancelledInfo() {
                return cancelledInfo;
            }

            /**
             * Sets the value of the cancelledInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExportCancelledInfoWithAttachmentsType }
             *     
             */
            public void setCancelledInfo(ExportCancelledInfoWithAttachmentsType value) {
                this.cancelledInfo = value;
            }

        }

    }

}
