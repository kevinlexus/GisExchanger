
package ru.gosuslugi.dom.schema.integration.house_management;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.BaseAsyncResponseType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.ErrorMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}BaseAsyncResponseType"&gt;
 *       &lt;choice minOccurs="0"&gt;
 *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *         &lt;element name="ImportResult" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
 *                   &lt;element name="CommonResult" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType"&gt;
 *                           &lt;choice minOccurs="0"&gt;
 *                             &lt;element name="ImportHouseUO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
 *                             &lt;element name="ImportHouseRSO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
 *                             &lt;element name="ImportHouseOMS" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
 *                             &lt;element name="ImportHouseESP" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
 *                             &lt;element name="importContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importContractResultType"/&gt;
 *                             &lt;element name="importCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importCharterResultType"/&gt;
 *                             &lt;element name="importMeteringDevice"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ImportAccount"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/&gt;
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ImportSupplyResourceContractObjectAddress"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ImportSupplyResourceContract"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                       &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ImportSupplyResourceContractProject"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *                 &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportHouseResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportHouseResultType"/&gt;
 *         &lt;element name="exportBriefBasicHouseResult"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ResultItem" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportBriefBasicHouseResultType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportBriefApartmentHouseResult"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ApartmentHouseInfo" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefApartmentHouseType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportBriefLivingHouseResult"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ResultItem" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportBriefLivingHouseResultType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportMeteringDeviceDataResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportMeteringDeviceDataResultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="exportStatusCAChResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportStatusCAChResultType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="exportCAChResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportCAChResultType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="exportStatusPublicPropertyContractResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportStatusPublicPropertyContractResultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="exportAccountResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportAccountResultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="VotingProtocol" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportVotingProtocolResultType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="exportSupplyResourceContractResult" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportSupplyResourceContractResultType" maxOccurs="1000"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="ExportContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportSupplyResourceContractObjectAddress" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ObjectAddress" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportSupplyResourceContractObjectAddressResultType" maxOccurs="1000"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="ExportObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                     &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportBriefSupplyResourceContractResult" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportBriefSupplyResourceContractResultType" maxOccurs="unbounded"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="NextPageContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                       &lt;element name="NextPageObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="exportAccountIndividualServicesResult" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportAccountIndividualServicesResultType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="rolloverCAChStatus" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportRolloverStatusCAChResultType"/&gt;
 *         &lt;element name="exportBriefSocialHireContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportBriefSocialHireContractResultType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="11.0.0.1""/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorMessage",
    "importResult",
    "exportHouseResult",
    "exportBriefBasicHouseResult",
    "exportBriefApartmentHouseResult",
    "exportBriefLivingHouseResult",
    "exportMeteringDeviceDataResult",
    "exportStatusCAChResult",
    "exportCAChResult",
    "exportStatusPublicPropertyContractResult",
    "exportAccountResult",
    "votingProtocol",
    "exportSupplyResourceContractResult",
    "exportSupplyResourceContractObjectAddress",
    "exportBriefSupplyResourceContractResult",
    "exportAccountIndividualServicesResult",
    "rolloverCAChStatus",
    "exportBriefSocialHireContract"
})
@XmlRootElement(name = "getStateResult")
public class GetStateResult
    extends BaseAsyncResponseType
{

    @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
    protected ErrorMessageType errorMessage;
    @XmlElement(name = "ImportResult")
    protected List<GetStateResult.ImportResult> importResult;
    protected ExportHouseResultType exportHouseResult;
    protected GetStateResult.ExportBriefBasicHouseResult exportBriefBasicHouseResult;
    protected GetStateResult.ExportBriefApartmentHouseResult exportBriefApartmentHouseResult;
    protected GetStateResult.ExportBriefLivingHouseResult exportBriefLivingHouseResult;
    protected List<ExportMeteringDeviceDataResultType> exportMeteringDeviceDataResult;
    protected List<ExportStatusCAChResultType> exportStatusCAChResult;
    protected List<ExportCAChResultType> exportCAChResult;
    protected List<ExportStatusPublicPropertyContractResultType> exportStatusPublicPropertyContractResult;
    protected List<ExportAccountResultType> exportAccountResult;
    @XmlElement(name = "VotingProtocol")
    protected List<ExportVotingProtocolResultType> votingProtocol;
    protected List<GetStateResult.ExportSupplyResourceContractResult> exportSupplyResourceContractResult;
    protected List<GetStateResult.ExportSupplyResourceContractObjectAddress> exportSupplyResourceContractObjectAddress;
    protected List<GetStateResult.ExportBriefSupplyResourceContractResult> exportBriefSupplyResourceContractResult;
    protected List<ExportAccountIndividualServicesResultType> exportAccountIndividualServicesResult;
    protected ExportRolloverStatusCAChResultType rolloverCAChStatus;
    protected List<ExportBriefSocialHireContractResultType> exportBriefSocialHireContract;
    @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
    protected String version;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMessageType }
     *     
     */
    public ErrorMessageType getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMessageType }
     *     
     */
    public void setErrorMessage(ErrorMessageType value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the importResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStateResult.ImportResult }
     * 
     * 
     */
    public List<GetStateResult.ImportResult> getImportResult() {
        if (importResult == null) {
            importResult = new ArrayList<GetStateResult.ImportResult>();
        }
        return this.importResult;
    }

    /**
     * Gets the value of the exportHouseResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExportHouseResultType }
     *     
     */
    public ExportHouseResultType getExportHouseResult() {
        return exportHouseResult;
    }

    /**
     * Sets the value of the exportHouseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportHouseResultType }
     *     
     */
    public void setExportHouseResult(ExportHouseResultType value) {
        this.exportHouseResult = value;
    }

    /**
     * Gets the value of the exportBriefBasicHouseResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetStateResult.ExportBriefBasicHouseResult }
     *     
     */
    public GetStateResult.ExportBriefBasicHouseResult getExportBriefBasicHouseResult() {
        return exportBriefBasicHouseResult;
    }

    /**
     * Sets the value of the exportBriefBasicHouseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStateResult.ExportBriefBasicHouseResult }
     *     
     */
    public void setExportBriefBasicHouseResult(GetStateResult.ExportBriefBasicHouseResult value) {
        this.exportBriefBasicHouseResult = value;
    }

    /**
     * Gets the value of the exportBriefApartmentHouseResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetStateResult.ExportBriefApartmentHouseResult }
     *     
     */
    public GetStateResult.ExportBriefApartmentHouseResult getExportBriefApartmentHouseResult() {
        return exportBriefApartmentHouseResult;
    }

    /**
     * Sets the value of the exportBriefApartmentHouseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStateResult.ExportBriefApartmentHouseResult }
     *     
     */
    public void setExportBriefApartmentHouseResult(GetStateResult.ExportBriefApartmentHouseResult value) {
        this.exportBriefApartmentHouseResult = value;
    }

    /**
     * Gets the value of the exportBriefLivingHouseResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetStateResult.ExportBriefLivingHouseResult }
     *     
     */
    public GetStateResult.ExportBriefLivingHouseResult getExportBriefLivingHouseResult() {
        return exportBriefLivingHouseResult;
    }

    /**
     * Sets the value of the exportBriefLivingHouseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStateResult.ExportBriefLivingHouseResult }
     *     
     */
    public void setExportBriefLivingHouseResult(GetStateResult.ExportBriefLivingHouseResult value) {
        this.exportBriefLivingHouseResult = value;
    }

    /**
     * Gets the value of the exportMeteringDeviceDataResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportMeteringDeviceDataResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportMeteringDeviceDataResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportMeteringDeviceDataResultType }
     * 
     * 
     */
    public List<ExportMeteringDeviceDataResultType> getExportMeteringDeviceDataResult() {
        if (exportMeteringDeviceDataResult == null) {
            exportMeteringDeviceDataResult = new ArrayList<ExportMeteringDeviceDataResultType>();
        }
        return this.exportMeteringDeviceDataResult;
    }

    /**
     * Gets the value of the exportStatusCAChResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportStatusCAChResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportStatusCAChResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusCAChResultType }
     * 
     * 
     */
    public List<ExportStatusCAChResultType> getExportStatusCAChResult() {
        if (exportStatusCAChResult == null) {
            exportStatusCAChResult = new ArrayList<ExportStatusCAChResultType>();
        }
        return this.exportStatusCAChResult;
    }

    /**
     * Gets the value of the exportCAChResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportCAChResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportCAChResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportCAChResultType }
     * 
     * 
     */
    public List<ExportCAChResultType> getExportCAChResult() {
        if (exportCAChResult == null) {
            exportCAChResult = new ArrayList<ExportCAChResultType>();
        }
        return this.exportCAChResult;
    }

    /**
     * Gets the value of the exportStatusPublicPropertyContractResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportStatusPublicPropertyContractResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportStatusPublicPropertyContractResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportStatusPublicPropertyContractResultType }
     * 
     * 
     */
    public List<ExportStatusPublicPropertyContractResultType> getExportStatusPublicPropertyContractResult() {
        if (exportStatusPublicPropertyContractResult == null) {
            exportStatusPublicPropertyContractResult = new ArrayList<ExportStatusPublicPropertyContractResultType>();
        }
        return this.exportStatusPublicPropertyContractResult;
    }

    /**
     * Gets the value of the exportAccountResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportAccountResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportAccountResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountResultType }
     * 
     * 
     */
    public List<ExportAccountResultType> getExportAccountResult() {
        if (exportAccountResult == null) {
            exportAccountResult = new ArrayList<ExportAccountResultType>();
        }
        return this.exportAccountResult;
    }

    /**
     * Gets the value of the votingProtocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the votingProtocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVotingProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportVotingProtocolResultType }
     * 
     * 
     */
    public List<ExportVotingProtocolResultType> getVotingProtocol() {
        if (votingProtocol == null) {
            votingProtocol = new ArrayList<ExportVotingProtocolResultType>();
        }
        return this.votingProtocol;
    }

    /**
     * Gets the value of the exportSupplyResourceContractResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportSupplyResourceContractResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportSupplyResourceContractResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStateResult.ExportSupplyResourceContractResult }
     * 
     * 
     */
    public List<GetStateResult.ExportSupplyResourceContractResult> getExportSupplyResourceContractResult() {
        if (exportSupplyResourceContractResult == null) {
            exportSupplyResourceContractResult = new ArrayList<GetStateResult.ExportSupplyResourceContractResult>();
        }
        return this.exportSupplyResourceContractResult;
    }

    /**
     * Gets the value of the exportSupplyResourceContractObjectAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportSupplyResourceContractObjectAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportSupplyResourceContractObjectAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStateResult.ExportSupplyResourceContractObjectAddress }
     * 
     * 
     */
    public List<GetStateResult.ExportSupplyResourceContractObjectAddress> getExportSupplyResourceContractObjectAddress() {
        if (exportSupplyResourceContractObjectAddress == null) {
            exportSupplyResourceContractObjectAddress = new ArrayList<GetStateResult.ExportSupplyResourceContractObjectAddress>();
        }
        return this.exportSupplyResourceContractObjectAddress;
    }

    /**
     * Gets the value of the exportBriefSupplyResourceContractResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportBriefSupplyResourceContractResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportBriefSupplyResourceContractResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetStateResult.ExportBriefSupplyResourceContractResult }
     * 
     * 
     */
    public List<GetStateResult.ExportBriefSupplyResourceContractResult> getExportBriefSupplyResourceContractResult() {
        if (exportBriefSupplyResourceContractResult == null) {
            exportBriefSupplyResourceContractResult = new ArrayList<GetStateResult.ExportBriefSupplyResourceContractResult>();
        }
        return this.exportBriefSupplyResourceContractResult;
    }

    /**
     * Gets the value of the exportAccountIndividualServicesResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportAccountIndividualServicesResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportAccountIndividualServicesResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportAccountIndividualServicesResultType }
     * 
     * 
     */
    public List<ExportAccountIndividualServicesResultType> getExportAccountIndividualServicesResult() {
        if (exportAccountIndividualServicesResult == null) {
            exportAccountIndividualServicesResult = new ArrayList<ExportAccountIndividualServicesResultType>();
        }
        return this.exportAccountIndividualServicesResult;
    }

    /**
     * Gets the value of the rolloverCAChStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ExportRolloverStatusCAChResultType }
     *     
     */
    public ExportRolloverStatusCAChResultType getRolloverCAChStatus() {
        return rolloverCAChStatus;
    }

    /**
     * Sets the value of the rolloverCAChStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportRolloverStatusCAChResultType }
     *     
     */
    public void setRolloverCAChStatus(ExportRolloverStatusCAChResultType value) {
        this.rolloverCAChStatus = value;
    }

    /**
     * Gets the value of the exportBriefSocialHireContract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportBriefSocialHireContract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportBriefSocialHireContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportBriefSocialHireContractResultType }
     * 
     * 
     */
    public List<ExportBriefSocialHireContractResultType> getExportBriefSocialHireContract() {
        if (exportBriefSocialHireContract == null) {
            exportBriefSocialHireContract = new ArrayList<ExportBriefSocialHireContractResultType>();
        }
        return this.exportBriefSocialHireContract;
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
            return "11.0.0.1";
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
     *         &lt;element name="ApartmentHouseInfo" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}BriefApartmentHouseType"/&gt;
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
        "apartmentHouseInfo"
    })
    public static class ExportBriefApartmentHouseResult {

        @XmlElement(name = "ApartmentHouseInfo", required = true)
        protected BriefApartmentHouseType apartmentHouseInfo;

        /**
         * Gets the value of the apartmentHouseInfo property.
         * 
         * @return
         *     possible object is
         *     {@link BriefApartmentHouseType }
         *     
         */
        public BriefApartmentHouseType getApartmentHouseInfo() {
            return apartmentHouseInfo;
        }

        /**
         * Sets the value of the apartmentHouseInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link BriefApartmentHouseType }
         *     
         */
        public void setApartmentHouseInfo(BriefApartmentHouseType value) {
            this.apartmentHouseInfo = value;
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
     *         &lt;element name="ResultItem" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportBriefBasicHouseResultType" maxOccurs="unbounded"/&gt;
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
        "resultItem"
    })
    public static class ExportBriefBasicHouseResult {

        @XmlElement(name = "ResultItem", required = true)
        protected List<ExportBriefBasicHouseResultType> resultItem;

        /**
         * Gets the value of the resultItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resultItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResultItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportBriefBasicHouseResultType }
         * 
         * 
         */
        public List<ExportBriefBasicHouseResultType> getResultItem() {
            if (resultItem == null) {
                resultItem = new ArrayList<ExportBriefBasicHouseResultType>();
            }
            return this.resultItem;
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
     *         &lt;element name="ResultItem" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportBriefLivingHouseResultType" maxOccurs="unbounded"/&gt;
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
        "resultItem"
    })
    public static class ExportBriefLivingHouseResult {

        @XmlElement(name = "ResultItem", required = true)
        protected List<ExportBriefLivingHouseResultType> resultItem;

        /**
         * Gets the value of the resultItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the resultItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResultItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportBriefLivingHouseResultType }
         * 
         * 
         */
        public List<ExportBriefLivingHouseResultType> getResultItem() {
            if (resultItem == null) {
                resultItem = new ArrayList<ExportBriefLivingHouseResultType>();
            }
            return this.resultItem;
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
     *         &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportBriefSupplyResourceContractResultType" maxOccurs="unbounded"/&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;element name="NextPageContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *             &lt;element name="NextPageObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "contract",
        "nextPageContractRootGUID",
        "nextPageObjectGUID",
        "isLastPage"
    })
    public static class ExportBriefSupplyResourceContractResult {

        @XmlElement(name = "Contract", required = true)
        protected List<ExportBriefSupplyResourceContractResultType> contract;
        @XmlElement(name = "NextPageContractRootGUID")
        protected String nextPageContractRootGUID;
        @XmlElement(name = "NextPageObjectGUID")
        protected String nextPageObjectGUID;
        @XmlElement(name = "IsLastPage")
        protected Boolean isLastPage;

        /**
         * Gets the value of the contract property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contract property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContract().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportBriefSupplyResourceContractResultType }
         * 
         * 
         */
        public List<ExportBriefSupplyResourceContractResultType> getContract() {
            if (contract == null) {
                contract = new ArrayList<ExportBriefSupplyResourceContractResultType>();
            }
            return this.contract;
        }

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
         * Gets the value of the isLastPage property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsLastPage() {
            return isLastPage;
        }

        /**
         * Sets the value of the isLastPage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsLastPage(Boolean value) {
            this.isLastPage = value;
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
     *         &lt;element name="ObjectAddress" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportSupplyResourceContractObjectAddressResultType" maxOccurs="1000"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="ExportObjectGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *           &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
        "objectAddress",
        "exportObjectGUID",
        "isLastPage"
    })
    public static class ExportSupplyResourceContractObjectAddress {

        @XmlElement(name = "ObjectAddress", required = true)
        protected List<ExportSupplyResourceContractObjectAddressResultType> objectAddress;
        @XmlElement(name = "ExportObjectGUID")
        protected String exportObjectGUID;
        @XmlElement(name = "IsLastPage")
        protected Boolean isLastPage;

        /**
         * Gets the value of the objectAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the objectAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getObjectAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractObjectAddressResultType }
         * 
         * 
         */
        public List<ExportSupplyResourceContractObjectAddressResultType> getObjectAddress() {
            if (objectAddress == null) {
                objectAddress = new ArrayList<ExportSupplyResourceContractObjectAddressResultType>();
            }
            return this.objectAddress;
        }

        /**
         * Gets the value of the exportObjectGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExportObjectGUID() {
            return exportObjectGUID;
        }

        /**
         * Sets the value of the exportObjectGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExportObjectGUID(String value) {
            this.exportObjectGUID = value;
        }

        /**
         * Gets the value of the isLastPage property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsLastPage() {
            return isLastPage;
        }

        /**
         * Sets the value of the isLastPage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsLastPage(Boolean value) {
            this.isLastPage = value;
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
     *         &lt;element name="Contract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}exportSupplyResourceContractResultType" maxOccurs="1000"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="IsLastPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *           &lt;element name="ExportContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "contract",
        "isLastPage",
        "exportContractRootGUID"
    })
    public static class ExportSupplyResourceContractResult {

        @XmlElement(name = "Contract", required = true)
        protected List<ExportSupplyResourceContractResultType> contract;
        @XmlElement(name = "IsLastPage")
        protected Boolean isLastPage;
        @XmlElement(name = "ExportContractRootGUID")
        protected String exportContractRootGUID;

        /**
         * Gets the value of the contract property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contract property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContract().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractResultType }
         * 
         * 
         */
        public List<ExportSupplyResourceContractResultType> getContract() {
            if (contract == null) {
                contract = new ArrayList<ExportSupplyResourceContractResultType>();
            }
            return this.contract;
        }

        /**
         * Gets the value of the isLastPage property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isIsLastPage() {
            return isLastPage;
        }

        /**
         * Sets the value of the isLastPage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsLastPage(Boolean value) {
            this.isLastPage = value;
        }

        /**
         * Gets the value of the exportContractRootGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExportContractRootGUID() {
            return exportContractRootGUID;
        }

        /**
         * Sets the value of the exportContractRootGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExportContractRootGUID(String value) {
            this.exportContractRootGUID = value;
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
     *       &lt;choice&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}ErrorMessage"/&gt;
     *         &lt;element name="CommonResult" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType"&gt;
     *                 &lt;choice minOccurs="0"&gt;
     *                   &lt;element name="ImportHouseUO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
     *                   &lt;element name="ImportHouseRSO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
     *                   &lt;element name="ImportHouseOMS" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
     *                   &lt;element name="ImportHouseESP" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
     *                   &lt;element name="importContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importContractResultType"/&gt;
     *                   &lt;element name="importCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importCharterResultType"/&gt;
     *                   &lt;element name="importMeteringDevice"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ImportAccount"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/&gt;
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ImportSupplyResourceContractObjectAddress"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ImportSupplyResourceContract"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                             &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ImportSupplyResourceContractProject"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/choice&gt;
     *       &lt;attribute ref="{http://dom.gosuslugi.ru/schema/integration/base/}version use="required" fixed="10.0.1.1""/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "errorMessage",
        "commonResult"
    })
    public static class ImportResult {

        @XmlElement(name = "ErrorMessage", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
        protected ErrorMessageType errorMessage;
        @XmlElement(name = "CommonResult")
        protected List<GetStateResult.ImportResult.CommonResult> commonResult;
        @XmlAttribute(name = "version", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String version;

        /**
         * Gets the value of the errorMessage property.
         * 
         * @return
         *     possible object is
         *     {@link ErrorMessageType }
         *     
         */
        public ErrorMessageType getErrorMessage() {
            return errorMessage;
        }

        /**
         * Sets the value of the errorMessage property.
         * 
         * @param value
         *     allowed object is
         *     {@link ErrorMessageType }
         *     
         */
        public void setErrorMessage(ErrorMessageType value) {
            this.errorMessage = value;
        }

        /**
         * Gets the value of the commonResult property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the commonResult property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCommonResult().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetStateResult.ImportResult.CommonResult }
         * 
         * 
         */
        public List<GetStateResult.ImportResult.CommonResult> getCommonResult() {
            if (commonResult == null) {
                commonResult = new ArrayList<GetStateResult.ImportResult.CommonResult>();
            }
            return this.commonResult;
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
                return "10.0.1.1";
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/base/}CommonResultType"&gt;
         *       &lt;choice minOccurs="0"&gt;
         *         &lt;element name="ImportHouseUO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
         *         &lt;element name="ImportHouseRSO" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
         *         &lt;element name="ImportHouseOMS" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
         *         &lt;element name="ImportHouseESP" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFImportStatusType"/&gt;
         *         &lt;element name="importContract" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importContractResultType"/&gt;
         *         &lt;element name="importCharter" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}importCharterResultType"/&gt;
         *         &lt;element name="importMeteringDevice"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ImportAccount"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ImportSupplyResourceContractObjectAddress"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ImportSupplyResourceContract"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                   &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ImportSupplyResourceContractProject"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/choice&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "importHouseUO",
            "importHouseRSO",
            "importHouseOMS",
            "importHouseESP",
            "importContract",
            "importCharter",
            "importMeteringDevice",
            "importAccount",
            "importSupplyResourceContractObjectAddress",
            "importSupplyResourceContract",
            "importSupplyResourceContractProject"
        })
        public static class CommonResult
            extends CommonResultType
        {

            @XmlElement(name = "ImportHouseUO")
            protected OGFImportStatusType importHouseUO;
            @XmlElement(name = "ImportHouseRSO")
            protected OGFImportStatusType importHouseRSO;
            @XmlElement(name = "ImportHouseOMS")
            protected OGFImportStatusType importHouseOMS;
            @XmlElement(name = "ImportHouseESP")
            protected OGFImportStatusType importHouseESP;
            protected ImportContractResultType importContract;
            protected ImportCharterResultType importCharter;
            protected GetStateResult.ImportResult.CommonResult.ImportMeteringDevice importMeteringDevice;
            @XmlElement(name = "ImportAccount")
            protected GetStateResult.ImportResult.CommonResult.ImportAccount importAccount;
            @XmlElement(name = "ImportSupplyResourceContractObjectAddress")
            protected GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress importSupplyResourceContractObjectAddress;
            @XmlElement(name = "ImportSupplyResourceContract")
            protected GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContract importSupplyResourceContract;
            @XmlElement(name = "ImportSupplyResourceContractProject")
            protected GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractProject importSupplyResourceContractProject;

            /**
             * Gets the value of the importHouseUO property.
             * 
             * @return
             *     possible object is
             *     {@link OGFImportStatusType }
             *     
             */
            public OGFImportStatusType getImportHouseUO() {
                return importHouseUO;
            }

            /**
             * Sets the value of the importHouseUO property.
             * 
             * @param value
             *     allowed object is
             *     {@link OGFImportStatusType }
             *     
             */
            public void setImportHouseUO(OGFImportStatusType value) {
                this.importHouseUO = value;
            }

            /**
             * Gets the value of the importHouseRSO property.
             * 
             * @return
             *     possible object is
             *     {@link OGFImportStatusType }
             *     
             */
            public OGFImportStatusType getImportHouseRSO() {
                return importHouseRSO;
            }

            /**
             * Sets the value of the importHouseRSO property.
             * 
             * @param value
             *     allowed object is
             *     {@link OGFImportStatusType }
             *     
             */
            public void setImportHouseRSO(OGFImportStatusType value) {
                this.importHouseRSO = value;
            }

            /**
             * Gets the value of the importHouseOMS property.
             * 
             * @return
             *     possible object is
             *     {@link OGFImportStatusType }
             *     
             */
            public OGFImportStatusType getImportHouseOMS() {
                return importHouseOMS;
            }

            /**
             * Sets the value of the importHouseOMS property.
             * 
             * @param value
             *     allowed object is
             *     {@link OGFImportStatusType }
             *     
             */
            public void setImportHouseOMS(OGFImportStatusType value) {
                this.importHouseOMS = value;
            }

            /**
             * Gets the value of the importHouseESP property.
             * 
             * @return
             *     possible object is
             *     {@link OGFImportStatusType }
             *     
             */
            public OGFImportStatusType getImportHouseESP() {
                return importHouseESP;
            }

            /**
             * Sets the value of the importHouseESP property.
             * 
             * @param value
             *     allowed object is
             *     {@link OGFImportStatusType }
             *     
             */
            public void setImportHouseESP(OGFImportStatusType value) {
                this.importHouseESP = value;
            }

            /**
             * Gets the value of the importContract property.
             * 
             * @return
             *     possible object is
             *     {@link ImportContractResultType }
             *     
             */
            public ImportContractResultType getImportContract() {
                return importContract;
            }

            /**
             * Sets the value of the importContract property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportContractResultType }
             *     
             */
            public void setImportContract(ImportContractResultType value) {
                this.importContract = value;
            }

            /**
             * Gets the value of the importCharter property.
             * 
             * @return
             *     possible object is
             *     {@link ImportCharterResultType }
             *     
             */
            public ImportCharterResultType getImportCharter() {
                return importCharter;
            }

            /**
             * Sets the value of the importCharter property.
             * 
             * @param value
             *     allowed object is
             *     {@link ImportCharterResultType }
             *     
             */
            public void setImportCharter(ImportCharterResultType value) {
                this.importCharter = value;
            }

            /**
             * Gets the value of the importMeteringDevice property.
             * 
             * @return
             *     possible object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportMeteringDevice }
             *     
             */
            public GetStateResult.ImportResult.CommonResult.ImportMeteringDevice getImportMeteringDevice() {
                return importMeteringDevice;
            }

            /**
             * Sets the value of the importMeteringDevice property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportMeteringDevice }
             *     
             */
            public void setImportMeteringDevice(GetStateResult.ImportResult.CommonResult.ImportMeteringDevice value) {
                this.importMeteringDevice = value;
            }

            /**
             * Gets the value of the importAccount property.
             * 
             * @return
             *     possible object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportAccount }
             *     
             */
            public GetStateResult.ImportResult.CommonResult.ImportAccount getImportAccount() {
                return importAccount;
            }

            /**
             * Sets the value of the importAccount property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportAccount }
             *     
             */
            public void setImportAccount(GetStateResult.ImportResult.CommonResult.ImportAccount value) {
                this.importAccount = value;
            }

            /**
             * Gets the value of the importSupplyResourceContractObjectAddress property.
             * 
             * @return
             *     possible object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress }
             *     
             */
            public GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress getImportSupplyResourceContractObjectAddress() {
                return importSupplyResourceContractObjectAddress;
            }

            /**
             * Sets the value of the importSupplyResourceContractObjectAddress property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress }
             *     
             */
            public void setImportSupplyResourceContractObjectAddress(GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractObjectAddress value) {
                this.importSupplyResourceContractObjectAddress = value;
            }

            /**
             * Gets the value of the importSupplyResourceContract property.
             * 
             * @return
             *     possible object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContract }
             *     
             */
            public GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContract getImportSupplyResourceContract() {
                return importSupplyResourceContract;
            }

            /**
             * Sets the value of the importSupplyResourceContract property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContract }
             *     
             */
            public void setImportSupplyResourceContract(GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContract value) {
                this.importSupplyResourceContract = value;
            }

            /**
             * Gets the value of the importSupplyResourceContractProject property.
             * 
             * @return
             *     possible object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractProject }
             *     
             */
            public GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractProject getImportSupplyResourceContractProject() {
                return importSupplyResourceContractProject;
            }

            /**
             * Sets the value of the importSupplyResourceContractProject property.
             * 
             * @param value
             *     allowed object is
             *     {@link GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractProject }
             *     
             */
            public void setImportSupplyResourceContractProject(GetStateResult.ImportResult.CommonResult.ImportSupplyResourceContractProject value) {
                this.importSupplyResourceContractProject = value;
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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}UnifiedAccountNumber"/&gt;
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/account-base/}ServiceID"/&gt;
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
                "unifiedAccountNumber",
                "serviceID"
            })
            public static class ImportAccount {

                @XmlElement(name = "UnifiedAccountNumber", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
                protected String unifiedAccountNumber;
                @XmlElement(name = "ServiceID", namespace = "http://dom.gosuslugi.ru/schema/integration/account-base/", required = true)
                protected String serviceID;

                /**
                 * Gets the value of the unifiedAccountNumber property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUnifiedAccountNumber() {
                    return unifiedAccountNumber;
                }

                /**
                 * Sets the value of the unifiedAccountNumber property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUnifiedAccountNumber(String value) {
                    this.unifiedAccountNumber = value;
                }

                /**
                 * Gets the value of the serviceID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getServiceID() {
                    return serviceID;
                }

                /**
                 * Sets the value of the serviceID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setServiceID(String value) {
                    this.serviceID = value;
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
             *         &lt;element name="MeteringDeviceGUID" type="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}MeteringDeviceGUIDType"/&gt;
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
                "meteringDeviceGUID"
            })
            public static class ImportMeteringDevice {

                @XmlElement(name = "MeteringDeviceGUID", required = true)
                protected String meteringDeviceGUID;

                /**
                 * Gets the value of the meteringDeviceGUID property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMeteringDeviceGUID() {
                    return meteringDeviceGUID;
                }

                /**
                 * Sets the value of the meteringDeviceGUID property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMeteringDeviceGUID(String value) {
                    this.meteringDeviceGUID = value;
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
             *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
             *         &lt;element name="ContractRootGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "contractGUID",
                "contractRootGUID"
            })
            public static class ImportSupplyResourceContract {

                @XmlElement(name = "ContractGUID", required = true)
                protected String contractGUID;
                @XmlElement(name = "ContractRootGUID", required = true)
                protected String contractRootGUID;

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
             *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractGUID"/&gt;
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
                "contractGUID"
            })
            public static class ImportSupplyResourceContractObjectAddress {

                @XmlElement(name = "ContractGUID", required = true)
                protected String contractGUID;

                /**
                 * Идентификатор версии договора ресурсоснабжения в ГИС ЖКХ  
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
             *         &lt;element name="ContractGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
                "contractGUID"
            })
            public static class ImportSupplyResourceContractProject {

                @XmlElement(name = "ContractGUID", required = true)
                protected String contractGUID;

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

            }

        }

    }

}
