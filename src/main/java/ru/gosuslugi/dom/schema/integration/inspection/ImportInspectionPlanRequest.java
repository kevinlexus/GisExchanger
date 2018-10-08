
package ru.gosuslugi.dom.schema.integration.inspection;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="ImportInspectionPlan" maxOccurs="1000"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="InspectionPlanGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;element name="InspectionPlan" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}InspectionPlanType"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="ImportPlannedExamination" maxOccurs="1000"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                               &lt;element name="PlannedExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;choice&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element name="PlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationType"/&gt;
 *                                 &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationChangeInfoType" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                               &lt;element name="CancelPlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/&gt;
 *                               &lt;element name="AnnulPlannedExamination" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                             &lt;/choice&gt;
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
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.5.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "importInspectionPlan"
})
@XmlRootElement(name = "importInspectionPlanRequest")
public class ImportInspectionPlanRequest
    extends BaseType
{

    @XmlElement(name = "ImportInspectionPlan", required = true)
    protected List<ImportInspectionPlanRequest.ImportInspectionPlan> importInspectionPlan;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the importInspectionPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importInspectionPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportInspectionPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportInspectionPlanRequest.ImportInspectionPlan }
     * 
     * 
     */
    public List<ImportInspectionPlanRequest.ImportInspectionPlan> getImportInspectionPlan() {
        if (importInspectionPlan == null) {
            importInspectionPlan = new ArrayList<ImportInspectionPlanRequest.ImportInspectionPlan>();
        }
        return this.importInspectionPlan;
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
            return "11.5.0.1";
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
     *         &lt;sequence&gt;
     *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;/sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="InspectionPlanGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="InspectionPlan" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}InspectionPlanType"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="ImportPlannedExamination" maxOccurs="1000"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *                     &lt;element name="PlannedExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                   &lt;/sequence&gt;
     *                   &lt;choice&gt;
     *                     &lt;sequence&gt;
     *                       &lt;element name="PlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationType"/&gt;
     *                       &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationChangeInfoType" minOccurs="0"/&gt;
     *                     &lt;/sequence&gt;
     *                     &lt;element name="CancelPlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/&gt;
     *                     &lt;element name="AnnulPlannedExamination" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *                   &lt;/choice&gt;
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
        "transportGUID",
        "inspectionPlanGuid",
        "inspectionPlan",
        "importPlannedExamination"
    })
    public static class ImportInspectionPlan {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "InspectionPlanGuid")
        protected String inspectionPlanGuid;
        @XmlElement(name = "InspectionPlan")
        protected InspectionPlanType inspectionPlan;
        @XmlElement(name = "ImportPlannedExamination", required = true)
        protected List<ImportInspectionPlanRequest.ImportInspectionPlan.ImportPlannedExamination> importPlannedExamination;

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
         * Gets the value of the inspectionPlan property.
         * 
         * @return
         *     possible object is
         *     {@link InspectionPlanType }
         *     
         */
        public InspectionPlanType getInspectionPlan() {
            return inspectionPlan;
        }

        /**
         * Sets the value of the inspectionPlan property.
         * 
         * @param value
         *     allowed object is
         *     {@link InspectionPlanType }
         *     
         */
        public void setInspectionPlan(InspectionPlanType value) {
            this.inspectionPlan = value;
        }

        /**
         * Gets the value of the importPlannedExamination property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the importPlannedExamination property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImportPlannedExamination().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImportInspectionPlanRequest.ImportInspectionPlan.ImportPlannedExamination }
         * 
         * 
         */
        public List<ImportInspectionPlanRequest.ImportInspectionPlan.ImportPlannedExamination> getImportPlannedExamination() {
            if (importPlannedExamination == null) {
                importPlannedExamination = new ArrayList<ImportInspectionPlanRequest.ImportInspectionPlan.ImportPlannedExamination>();
            }
            return this.importPlannedExamination;
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
         *         &lt;sequence&gt;
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
         *           &lt;element name="PlannedExaminationGuid" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *         &lt;/sequence&gt;
         *         &lt;choice&gt;
         *           &lt;sequence&gt;
         *             &lt;element name="PlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}PlannedExaminationType"/&gt;
         *             &lt;element name="ExaminationChangeInfo" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}ExaminationChangeInfoType" minOccurs="0"/&gt;
         *           &lt;/sequence&gt;
         *           &lt;element name="CancelPlannedExamination" type="{http://dom.gosuslugi.ru/schema/integration/inspection/}CancelledInfoWithAttachmentsType"/&gt;
         *           &lt;element name="AnnulPlannedExamination" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
            "plannedExaminationGuid",
            "plannedExamination",
            "examinationChangeInfo",
            "cancelPlannedExamination",
            "annulPlannedExamination"
        })
        public static class ImportPlannedExamination {

            @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
            protected String transportGUID;
            @XmlElement(name = "PlannedExaminationGuid")
            protected String plannedExaminationGuid;
            @XmlElement(name = "PlannedExamination")
            protected PlannedExaminationType plannedExamination;
            @XmlElement(name = "ExaminationChangeInfo")
            protected ExaminationChangeInfoType examinationChangeInfo;
            @XmlElement(name = "CancelPlannedExamination")
            protected CancelledInfoWithAttachmentsType cancelPlannedExamination;
            @XmlElement(name = "AnnulPlannedExamination")
            protected Boolean annulPlannedExamination;

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
             * Gets the value of the plannedExamination property.
             * 
             * @return
             *     possible object is
             *     {@link PlannedExaminationType }
             *     
             */
            public PlannedExaminationType getPlannedExamination() {
                return plannedExamination;
            }

            /**
             * Sets the value of the plannedExamination property.
             * 
             * @param value
             *     allowed object is
             *     {@link PlannedExaminationType }
             *     
             */
            public void setPlannedExamination(PlannedExaminationType value) {
                this.plannedExamination = value;
            }

            /**
             * Gets the value of the examinationChangeInfo property.
             * 
             * @return
             *     possible object is
             *     {@link ExaminationChangeInfoType }
             *     
             */
            public ExaminationChangeInfoType getExaminationChangeInfo() {
                return examinationChangeInfo;
            }

            /**
             * Sets the value of the examinationChangeInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link ExaminationChangeInfoType }
             *     
             */
            public void setExaminationChangeInfo(ExaminationChangeInfoType value) {
                this.examinationChangeInfo = value;
            }

            /**
             * Gets the value of the cancelPlannedExamination property.
             * 
             * @return
             *     possible object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public CancelledInfoWithAttachmentsType getCancelPlannedExamination() {
                return cancelPlannedExamination;
            }

            /**
             * Sets the value of the cancelPlannedExamination property.
             * 
             * @param value
             *     allowed object is
             *     {@link CancelledInfoWithAttachmentsType }
             *     
             */
            public void setCancelPlannedExamination(CancelledInfoWithAttachmentsType value) {
                this.cancelPlannedExamination = value;
            }

            /**
             * Gets the value of the annulPlannedExamination property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isAnnulPlannedExamination() {
                return annulPlannedExamination;
            }

            /**
             * Sets the value of the annulPlannedExamination property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setAnnulPlannedExamination(Boolean value) {
                this.annulPlannedExamination = value;
            }

        }

    }

}
