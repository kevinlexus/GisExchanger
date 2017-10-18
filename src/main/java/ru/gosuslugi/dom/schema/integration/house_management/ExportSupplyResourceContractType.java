
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Экспортируемый договор ресурсоснабжения 
 * 
 * <p>Java class for ExportSupplyResourceContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportSupplyResourceContractType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="IsContract">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractNumber">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="100"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="IsNotContract" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="ContractNumber" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="100"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="ComptetionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Period" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Start">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="StartDate">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;minInclusive value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="End">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="EndDate">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                                   &lt;minInclusive value="-1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContractBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="Offer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="ApartmentBuildingOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="LivingHouseOwner">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;choice>
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
 *                   &lt;/choice>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="Organization">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
 *                 &lt;/extension>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *         &lt;element name="IsPlannedVolume" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PlannedVolumeType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="O"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ContractSubject" maxOccurs="100" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ServiceType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="MunicipalResource">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CountingResource" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="R"/>
 *               &lt;enumeration value="P"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SpecifyingQualityIndicators">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="D"/>
 *               &lt;enumeration value="O"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ObjectAddress" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportObjectAddressType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
 *                   &lt;element name="Pair" maxOccurs="100">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                             &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="HeatingSystemType" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OpenOrNot">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="Opened"/>
 *                                             &lt;enumeration value="Closed"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="CentralizedOrNot">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="Centralized"/>
 *                                             &lt;enumeration value="Decentralized"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *                   &lt;element name="IndicatorValue" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;sequence>
 *                               &lt;choice>
 *                                 &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
 *                                 &lt;sequence>
 *                                   &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
 *                                   &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
 *                                 &lt;/sequence>
 *                               &lt;/choice>
 *                               &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
 *                             &lt;/sequence>
 *                             &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
 *                   &lt;element name="IndicatorValue">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
 *                   &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType" minOccurs="0"/>
 *                   &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType" minOccurs="0"/>
 *                   &lt;element name="FeedingMode" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type">
 *                         &lt;maxLength value="250"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="BillingDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="PaymentDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="ProvidingInformationDate" minOccurs="0">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Date">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *                           &lt;minInclusive value="-1"/>
 *                           &lt;maxInclusive value="30"/>
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="DateType">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;enumeration value="C"/>
 *                           &lt;enumeration value="N"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportSupplyResourceContractType", propOrder = {
    "isContract",
    "isNotContract",
    "comptetionDate",
    "period",
    "contractBase",
    "offer",
    "apartmentBuildingOwner",
    "livingHouseOwner",
    "organization",
    "isPlannedVolume",
    "plannedVolumeType",
    "contractSubject",
    "countingResource",
    "specifyingQualityIndicators",
    "objectAddress",
    "quality",
    "otherQualityIndicator",
    "plannedVolume",
    "billingDate",
    "paymentDate",
    "providingInformationDate"
})
@XmlSeeAlso({
    ExportSupplyResourceContractResultType.class
})
public class ExportSupplyResourceContractType {

    @XmlElement(name = "IsContract")
    protected ExportSupplyResourceContractType.IsContract isContract;
    @XmlElement(name = "IsNotContract")
    protected ExportSupplyResourceContractType.IsNotContract isNotContract;
    @XmlElement(name = "ComptetionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar comptetionDate;
    @XmlElement(name = "Period")
    protected ExportSupplyResourceContractType.Period period;
    @XmlElement(name = "ContractBase")
    protected List<NsiRef> contractBase;
    @XmlElement(name = "Offer")
    protected Boolean offer;
    @XmlElement(name = "ApartmentBuildingOwner")
    protected ExportSupplyResourceContractType.ApartmentBuildingOwner apartmentBuildingOwner;
    @XmlElement(name = "LivingHouseOwner")
    protected ExportSupplyResourceContractType.LivingHouseOwner livingHouseOwner;
    @XmlElement(name = "Organization")
    protected ExportSupplyResourceContractType.Organization organization;
    @XmlElement(name = "IsPlannedVolume")
    protected boolean isPlannedVolume;
    @XmlElement(name = "PlannedVolumeType")
    protected String plannedVolumeType;
    @XmlElement(name = "ContractSubject")
    protected List<ExportSupplyResourceContractType.ContractSubject> contractSubject;
    @XmlElement(name = "CountingResource")
    protected String countingResource;
    @XmlElement(name = "SpecifyingQualityIndicators", required = true)
    protected String specifyingQualityIndicators;
    @XmlElement(name = "ObjectAddress")
    protected List<ExportSupplyResourceContractType.ObjectAddress> objectAddress;
    @XmlElement(name = "Quality")
    protected List<ExportSupplyResourceContractType.Quality> quality;
    @XmlElement(name = "OtherQualityIndicator")
    protected List<ExportSupplyResourceContractType.OtherQualityIndicator> otherQualityIndicator;
    @XmlElement(name = "PlannedVolume")
    protected List<ExportSupplyResourceContractType.PlannedVolume> plannedVolume;
    @XmlElement(name = "BillingDate")
    protected ExportSupplyResourceContractType.BillingDate billingDate;
    @XmlElement(name = "PaymentDate")
    protected ExportSupplyResourceContractType.PaymentDate paymentDate;
    @XmlElement(name = "ProvidingInformationDate")
    protected ExportSupplyResourceContractType.ProvidingInformationDate providingInformationDate;

    /**
     * Gets the value of the isContract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.IsContract }
     *     
     */
    public ExportSupplyResourceContractType.IsContract getIsContract() {
        return isContract;
    }

    /**
     * Sets the value of the isContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.IsContract }
     *     
     */
    public void setIsContract(ExportSupplyResourceContractType.IsContract value) {
        this.isContract = value;
    }

    /**
     * Gets the value of the isNotContract property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.IsNotContract }
     *     
     */
    public ExportSupplyResourceContractType.IsNotContract getIsNotContract() {
        return isNotContract;
    }

    /**
     * Sets the value of the isNotContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.IsNotContract }
     *     
     */
    public void setIsNotContract(ExportSupplyResourceContractType.IsNotContract value) {
        this.isNotContract = value;
    }

    /**
     * Gets the value of the comptetionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getComptetionDate() {
        return comptetionDate;
    }

    /**
     * Sets the value of the comptetionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setComptetionDate(XMLGregorianCalendar value) {
        this.comptetionDate = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.Period }
     *     
     */
    public ExportSupplyResourceContractType.Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.Period }
     *     
     */
    public void setPeriod(ExportSupplyResourceContractType.Period value) {
        this.period = value;
    }

    /**
     * Gets the value of the contractBase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractBase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractBase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NsiRef }
     * 
     * 
     */
    public List<NsiRef> getContractBase() {
        if (contractBase == null) {
            contractBase = new ArrayList<NsiRef>();
        }
        return this.contractBase;
    }

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOffer(Boolean value) {
        this.offer = value;
    }

    /**
     * Gets the value of the apartmentBuildingOwner property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.ApartmentBuildingOwner }
     *     
     */
    public ExportSupplyResourceContractType.ApartmentBuildingOwner getApartmentBuildingOwner() {
        return apartmentBuildingOwner;
    }

    /**
     * Sets the value of the apartmentBuildingOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.ApartmentBuildingOwner }
     *     
     */
    public void setApartmentBuildingOwner(ExportSupplyResourceContractType.ApartmentBuildingOwner value) {
        this.apartmentBuildingOwner = value;
    }

    /**
     * Gets the value of the livingHouseOwner property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.LivingHouseOwner }
     *     
     */
    public ExportSupplyResourceContractType.LivingHouseOwner getLivingHouseOwner() {
        return livingHouseOwner;
    }

    /**
     * Sets the value of the livingHouseOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.LivingHouseOwner }
     *     
     */
    public void setLivingHouseOwner(ExportSupplyResourceContractType.LivingHouseOwner value) {
        this.livingHouseOwner = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.Organization }
     *     
     */
    public ExportSupplyResourceContractType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.Organization }
     *     
     */
    public void setOrganization(ExportSupplyResourceContractType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the isPlannedVolume property.
     * 
     */
    public boolean isIsPlannedVolume() {
        return isPlannedVolume;
    }

    /**
     * Sets the value of the isPlannedVolume property.
     * 
     */
    public void setIsPlannedVolume(boolean value) {
        this.isPlannedVolume = value;
    }

    /**
     * Gets the value of the plannedVolumeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlannedVolumeType() {
        return plannedVolumeType;
    }

    /**
     * Sets the value of the plannedVolumeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlannedVolumeType(String value) {
        this.plannedVolumeType = value;
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
     * {@link ExportSupplyResourceContractType.ContractSubject }
     * 
     * 
     */
    public List<ExportSupplyResourceContractType.ContractSubject> getContractSubject() {
        if (contractSubject == null) {
            contractSubject = new ArrayList<ExportSupplyResourceContractType.ContractSubject>();
        }
        return this.contractSubject;
    }

    /**
     * Gets the value of the countingResource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountingResource() {
        return countingResource;
    }

    /**
     * Sets the value of the countingResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountingResource(String value) {
        this.countingResource = value;
    }

    /**
     * Gets the value of the specifyingQualityIndicators property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecifyingQualityIndicators() {
        return specifyingQualityIndicators;
    }

    /**
     * Sets the value of the specifyingQualityIndicators property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecifyingQualityIndicators(String value) {
        this.specifyingQualityIndicators = value;
    }

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
     * {@link ExportSupplyResourceContractType.ObjectAddress }
     * 
     * 
     */
    public List<ExportSupplyResourceContractType.ObjectAddress> getObjectAddress() {
        if (objectAddress == null) {
            objectAddress = new ArrayList<ExportSupplyResourceContractType.ObjectAddress>();
        }
        return this.objectAddress;
    }

    /**
     * Gets the value of the quality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractType.Quality }
     * 
     * 
     */
    public List<ExportSupplyResourceContractType.Quality> getQuality() {
        if (quality == null) {
            quality = new ArrayList<ExportSupplyResourceContractType.Quality>();
        }
        return this.quality;
    }

    /**
     * Gets the value of the otherQualityIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherQualityIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherQualityIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractType.OtherQualityIndicator }
     * 
     * 
     */
    public List<ExportSupplyResourceContractType.OtherQualityIndicator> getOtherQualityIndicator() {
        if (otherQualityIndicator == null) {
            otherQualityIndicator = new ArrayList<ExportSupplyResourceContractType.OtherQualityIndicator>();
        }
        return this.otherQualityIndicator;
    }

    /**
     * Gets the value of the plannedVolume property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plannedVolume property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlannedVolume().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportSupplyResourceContractType.PlannedVolume }
     * 
     * 
     */
    public List<ExportSupplyResourceContractType.PlannedVolume> getPlannedVolume() {
        if (plannedVolume == null) {
            plannedVolume = new ArrayList<ExportSupplyResourceContractType.PlannedVolume>();
        }
        return this.plannedVolume;
    }

    /**
     * Gets the value of the billingDate property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.BillingDate }
     *     
     */
    public ExportSupplyResourceContractType.BillingDate getBillingDate() {
        return billingDate;
    }

    /**
     * Sets the value of the billingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.BillingDate }
     *     
     */
    public void setBillingDate(ExportSupplyResourceContractType.BillingDate value) {
        this.billingDate = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.PaymentDate }
     *     
     */
    public ExportSupplyResourceContractType.PaymentDate getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.PaymentDate }
     *     
     */
    public void setPaymentDate(ExportSupplyResourceContractType.PaymentDate value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the providingInformationDate property.
     * 
     * @return
     *     possible object is
     *     {@link ExportSupplyResourceContractType.ProvidingInformationDate }
     *     
     */
    public ExportSupplyResourceContractType.ProvidingInformationDate getProvidingInformationDate() {
        return providingInformationDate;
    }

    /**
     * Sets the value of the providingInformationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportSupplyResourceContractType.ProvidingInformationDate }
     *     
     */
    public void setProvidingInformationDate(ExportSupplyResourceContractType.ProvidingInformationDate value) {
        this.providingInformationDate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "noData",
        "regOrg",
        "ind"
    })
    public static class ApartmentBuildingOwner {

        @XmlElement(name = "NoData")
        protected Boolean noData;
        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "date",
        "dateType"
    })
    public static class BillingDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ServiceType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MunicipalResource">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "serviceType",
        "municipalResource",
        "startSupplyDate",
        "endSupplyDate",
        "transportGUID"
    })
    public static class ContractSubject {

        @XmlElement(name = "ServiceType", required = true)
        protected ExportSupplyResourceContractType.ContractSubject.ServiceType serviceType;
        @XmlElement(name = "MunicipalResource", required = true)
        protected ExportSupplyResourceContractType.ContractSubject.MunicipalResource municipalResource;
        @XmlElement(name = "StartSupplyDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar startSupplyDate;
        @XmlElement(name = "EndSupplyDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar endSupplyDate;
        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

        /**
         * Gets the value of the serviceType property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractType.ContractSubject.ServiceType }
         *     
         */
        public ExportSupplyResourceContractType.ContractSubject.ServiceType getServiceType() {
            return serviceType;
        }

        /**
         * Sets the value of the serviceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractType.ContractSubject.ServiceType }
         *     
         */
        public void setServiceType(ExportSupplyResourceContractType.ContractSubject.ServiceType value) {
            this.serviceType = value;
        }

        /**
         * Gets the value of the municipalResource property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractType.ContractSubject.MunicipalResource }
         *     
         */
        public ExportSupplyResourceContractType.ContractSubject.MunicipalResource getMunicipalResource() {
            return municipalResource;
        }

        /**
         * Sets the value of the municipalResource property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractType.ContractSubject.MunicipalResource }
         *     
         */
        public void setMunicipalResource(ExportSupplyResourceContractType.ContractSubject.MunicipalResource value) {
            this.municipalResource = value;
        }

        /**
         * Gets the value of the startSupplyDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStartSupplyDate() {
            return startSupplyDate;
        }

        /**
         * Sets the value of the startSupplyDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStartSupplyDate(XMLGregorianCalendar value) {
            this.startSupplyDate = value;
        }

        /**
         * Gets the value of the endSupplyDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEndSupplyDate() {
            return endSupplyDate;
        }

        /**
         * Sets the value of the endSupplyDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEndSupplyDate(XMLGregorianCalendar value) {
            this.endSupplyDate = value;
        }

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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MunicipalResource
            extends NsiRef
        {


        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ContractNumber">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contractNumber",
        "signingDate",
        "effectiveDate",
        "contractAttachment"
    })
    public static class IsContract {

        @XmlElement(name = "ContractNumber", required = true)
        protected String contractNumber;
        @XmlElement(name = "SigningDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDate;
        @XmlElement(name = "EffectiveDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effectiveDate;
        @XmlElement(name = "ContractAttachment")
        protected List<AttachmentType> contractAttachment;

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
         * Gets the value of the signingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDate() {
            return signingDate;
        }

        /**
         * Sets the value of the signingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDate(XMLGregorianCalendar value) {
            this.signingDate = value;
        }

        /**
         * Gets the value of the effectiveDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffectiveDate() {
            return effectiveDate;
        }

        /**
         * Sets the value of the effectiveDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffectiveDate(XMLGregorianCalendar value) {
            this.effectiveDate = value;
        }

        /**
         * Gets the value of the contractAttachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getContractAttachment() {
            if (contractAttachment == null) {
                contractAttachment = new ArrayList<AttachmentType>();
            }
            return this.contractAttachment;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ContractNumber" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contractNumber",
        "signingDate",
        "effectiveDate",
        "contractAttachment"
    })
    public static class IsNotContract {

        @XmlElement(name = "ContractNumber")
        protected String contractNumber;
        @XmlElement(name = "SigningDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar signingDate;
        @XmlElement(name = "EffectiveDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effectiveDate;
        @XmlElement(name = "ContractAttachment")
        protected List<AttachmentType> contractAttachment;

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
         * Gets the value of the signingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningDate() {
            return signingDate;
        }

        /**
         * Sets the value of the signingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningDate(XMLGregorianCalendar value) {
            this.signingDate = value;
        }

        /**
         * Gets the value of the effectiveDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffectiveDate() {
            return effectiveDate;
        }

        /**
         * Sets the value of the effectiveDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffectiveDate(XMLGregorianCalendar value) {
            this.effectiveDate = value;
        }

        /**
         * Gets the value of the contractAttachment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contractAttachment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContractAttachment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AttachmentType }
         * 
         * 
         */
        public List<AttachmentType> getContractAttachment() {
            if (contractAttachment == null) {
                contractAttachment = new ArrayList<AttachmentType>();
            }
            return this.contractAttachment;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/>
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "noData",
        "regOrg",
        "ind"
    })
    public static class LivingHouseOwner {

        @XmlElement(name = "NoData")
        protected Boolean noData;
        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;

        /**
         * Gets the value of the noData property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isNoData() {
            return noData;
        }

        /**
         * Sets the value of the noData property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setNoData(Boolean value) {
            this.noData = value;
        }

        /**
         * Gets the value of the regOrg property.
         * 
         * @return
         *     possible object is
         *     {@link DRSORegOrgType }
         *     
         */
        public DRSORegOrgType getRegOrg() {
            return regOrg;
        }

        /**
         * Sets the value of the regOrg property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSORegOrgType }
         *     
         */
        public void setRegOrg(DRSORegOrgType value) {
            this.regOrg = value;
        }

        /**
         * Gets the value of the ind property.
         * 
         * @return
         *     possible object is
         *     {@link DRSOIndType }
         *     
         */
        public DRSOIndType getInd() {
            return ind;
        }

        /**
         * Sets the value of the ind property.
         * 
         * @param value
         *     allowed object is
         *     {@link DRSOIndType }
         *     
         */
        public void setInd(DRSOIndType value) {
            this.ind = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ExportObjectAddressType">
     *       &lt;sequence>
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/>
     *         &lt;element name="Pair" maxOccurs="100">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *                   &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="HeatingSystemType" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OpenOrNot">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="Opened"/>
     *                                   &lt;enumeration value="Closed"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="CentralizedOrNot">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="Centralized"/>
     *                                   &lt;enumeration value="Decentralized"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transportGUID",
        "pair"
    })
    public static class ObjectAddress
        extends ExportObjectAddressType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "Pair", required = true)
        protected List<ExportSupplyResourceContractType.ObjectAddress.Pair> pair;

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
         * Gets the value of the pair property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the pair property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPair().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractType.ObjectAddress.Pair }
         * 
         * 
         */
        public List<ExportSupplyResourceContractType.ObjectAddress.Pair> getPair() {
            if (pair == null) {
                pair = new ArrayList<ExportSupplyResourceContractType.ObjectAddress.Pair>();
            }
            return this.pair;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
         *         &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="HeatingSystemType" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OpenOrNot">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="Opened"/>
         *                         &lt;enumeration value="Closed"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="CentralizedOrNot">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="Centralized"/>
         *                         &lt;enumeration value="Decentralized"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pairKey",
            "startSupplyDate",
            "endSupplyDate",
            "heatingSystemType"
        })
        public static class Pair {

            @XmlElement(name = "PairKey", required = true)
            protected String pairKey;
            @XmlElement(name = "StartSupplyDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar startSupplyDate;
            @XmlElement(name = "EndSupplyDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar endSupplyDate;
            @XmlElement(name = "HeatingSystemType")
            protected List<ExportSupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType> heatingSystemType;

            /**
             * Gets the value of the pairKey property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPairKey() {
                return pairKey;
            }

            /**
             * Sets the value of the pairKey property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPairKey(String value) {
                this.pairKey = value;
            }

            /**
             * Gets the value of the startSupplyDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getStartSupplyDate() {
                return startSupplyDate;
            }

            /**
             * Sets the value of the startSupplyDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartSupplyDate(XMLGregorianCalendar value) {
                this.startSupplyDate = value;
            }

            /**
             * Gets the value of the endSupplyDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEndSupplyDate() {
                return endSupplyDate;
            }

            /**
             * Sets the value of the endSupplyDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEndSupplyDate(XMLGregorianCalendar value) {
                this.endSupplyDate = value;
            }

            /**
             * Gets the value of the heatingSystemType property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the heatingSystemType property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getHeatingSystemType().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ExportSupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType }
             * 
             * 
             */
            public List<ExportSupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType> getHeatingSystemType() {
                if (heatingSystemType == null) {
                    heatingSystemType = new ArrayList<ExportSupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType>();
                }
                return this.heatingSystemType;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="OpenOrNot">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="Opened"/>
             *               &lt;enumeration value="Closed"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="CentralizedOrNot">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="Centralized"/>
             *               &lt;enumeration value="Decentralized"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "openOrNot",
                "centralizedOrNot"
            })
            public static class HeatingSystemType {

                @XmlElement(name = "OpenOrNot", required = true)
                protected String openOrNot;
                @XmlElement(name = "CentralizedOrNot", required = true)
                protected String centralizedOrNot;

                /**
                 * Gets the value of the openOrNot property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOpenOrNot() {
                    return openOrNot;
                }

                /**
                 * Sets the value of the openOrNot property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOpenOrNot(String value) {
                    this.openOrNot = value;
                }

                /**
                 * Gets the value of the centralizedOrNot property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCentralizedOrNot() {
                    return centralizedOrNot;
                }

                /**
                 * Sets the value of the centralizedOrNot property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCentralizedOrNot(String value) {
                    this.centralizedOrNot = value;
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Organization
        extends RegOrgType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/>
     *         &lt;element name="IndicatorValue">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressObjectKey",
        "pairKey",
        "indicatorName",
        "indicatorValue"
    })
    public static class OtherQualityIndicator {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "IndicatorName", required = true)
        protected String indicatorName;
        @XmlElement(name = "IndicatorValue", required = true)
        protected ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue indicatorValue;

        /**
         * Gets the value of the addressObjectKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressObjectKey() {
            return addressObjectKey;
        }

        /**
         * Sets the value of the addressObjectKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressObjectKey(String value) {
            this.addressObjectKey = value;
        }

        /**
         * Gets the value of the pairKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPairKey() {
            return pairKey;
        }

        /**
         * Sets the value of the pairKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPairKey(String value) {
            this.pairKey = value;
        }

        /**
         * Gets the value of the indicatorName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicatorName() {
            return indicatorName;
        }

        /**
         * Sets the value of the indicatorName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicatorName(String value) {
            this.indicatorName = value;
        }

        /**
         * Gets the value of the indicatorValue property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue }
         *     
         */
        public ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue getIndicatorValue() {
            return indicatorValue;
        }

        /**
         * Sets the value of the indicatorValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue }
         *     
         */
        public void setIndicatorValue(ExportSupplyResourceContractType.OtherQualityIndicator.IndicatorValue value) {
            this.indicatorValue = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class IndicatorValue
            extends IndicatorValueType
        {


        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "date",
        "dateType"
    })
    public static class PaymentDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Start">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="StartDate">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                         &lt;minInclusive value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="End">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="EndDate">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *                         &lt;minInclusive value="-1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "start",
        "end"
    })
    public static class Period {

        @XmlElement(name = "Start", required = true)
        protected ExportSupplyResourceContractType.Period.Start start;
        @XmlElement(name = "End", required = true)
        protected ExportSupplyResourceContractType.Period.End end;

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractType.Period.Start }
         *     
         */
        public ExportSupplyResourceContractType.Period.Start getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractType.Period.Start }
         *     
         */
        public void setStart(ExportSupplyResourceContractType.Period.Start value) {
            this.start = value;
        }

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link ExportSupplyResourceContractType.Period.End }
         *     
         */
        public ExportSupplyResourceContractType.Period.End getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExportSupplyResourceContractType.Period.End }
         *     
         */
        public void setEnd(ExportSupplyResourceContractType.Period.End value) {
            this.end = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="EndDate">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
         *               &lt;minInclusive value="-1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "endDate",
            "nextMonth"
        })
        public static class End {

            @XmlElement(name = "EndDate")
            protected byte endDate;
            @XmlElement(name = "NextMonth")
            protected Boolean nextMonth;

            /**
             * Gets the value of the endDate property.
             * 
             */
            public byte getEndDate() {
                return endDate;
            }

            /**
             * Sets the value of the endDate property.
             * 
             */
            public void setEndDate(byte value) {
                this.endDate = value;
            }

            /**
             * Gets the value of the nextMonth property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNextMonth() {
                return nextMonth;
            }

            /**
             * Sets the value of the nextMonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNextMonth(Boolean value) {
                this.nextMonth = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="StartDate">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
         *               &lt;minInclusive value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "startDate",
            "nextMonth"
        })
        public static class Start {

            @XmlElement(name = "StartDate")
            protected byte startDate;
            @XmlElement(name = "NextMonth")
            protected Boolean nextMonth;

            /**
             * Gets the value of the startDate property.
             * 
             */
            public byte getStartDate() {
                return startDate;
            }

            /**
             * Sets the value of the startDate property.
             * 
             */
            public void setStartDate(byte value) {
                this.startDate = value;
            }

            /**
             * Gets the value of the nextMonth property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isNextMonth() {
                return nextMonth;
            }

            /**
             * Sets the value of the nextMonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setNextMonth(Boolean value) {
                this.nextMonth = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType" minOccurs="0"/>
     *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType" minOccurs="0"/>
     *         &lt;element name="FeedingMode" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type">
     *               &lt;maxLength value="250"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressObjectKey",
        "pairKey",
        "volume",
        "unit",
        "feedingMode"
    })
    public static class PlannedVolume {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "Volume")
        protected BigDecimal volume;
        @XmlElement(name = "Unit")
        protected String unit;
        @XmlElement(name = "FeedingMode")
        protected String feedingMode;

        /**
         * Gets the value of the addressObjectKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressObjectKey() {
            return addressObjectKey;
        }

        /**
         * Sets the value of the addressObjectKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressObjectKey(String value) {
            this.addressObjectKey = value;
        }

        /**
         * Gets the value of the pairKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPairKey() {
            return pairKey;
        }

        /**
         * Sets the value of the pairKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPairKey(String value) {
            this.pairKey = value;
        }

        /**
         * Gets the value of the volume property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVolume() {
            return volume;
        }

        /**
         * Sets the value of the volume property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVolume(BigDecimal value) {
            this.volume = value;
        }

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

        /**
         * Gets the value of the feedingMode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFeedingMode() {
            return feedingMode;
        }

        /**
         * Sets the value of the feedingMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFeedingMode(String value) {
            this.feedingMode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Date">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
     *               &lt;minInclusive value="-1"/>
     *               &lt;maxInclusive value="30"/>
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DateType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="C"/>
     *               &lt;enumeration value="N"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "date",
        "dateType"
    })
    public static class ProvidingInformationDate {

        @XmlElement(name = "Date")
        protected byte date;
        @XmlElement(name = "DateType", required = true)
        protected String dateType;

        /**
         * Gets the value of the date property.
         * 
         */
        public byte getDate() {
            return date;
        }

        /**
         * Sets the value of the date property.
         * 
         */
        public void setDate(byte value) {
            this.date = value;
        }

        /**
         * Gets the value of the dateType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateType() {
            return dateType;
        }

        /**
         * Sets the value of the dateType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateType(String value) {
            this.dateType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/>
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/>
     *         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
     *         &lt;element name="IndicatorValue" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;sequence>
     *                     &lt;choice>
     *                       &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
     *                       &lt;sequence>
     *                         &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
     *                         &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
     *                       &lt;/sequence>
     *                     &lt;/choice>
     *                     &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
     *                   &lt;/sequence>
     *                   &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressObjectKey",
        "pairKey",
        "qualityIndicator",
        "indicatorValue"
    })
    public static class Quality {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "QualityIndicator", required = true)
        protected NsiRef qualityIndicator;
        @XmlElement(name = "IndicatorValue")
        protected List<ExportSupplyResourceContractType.Quality.IndicatorValue> indicatorValue;

        /**
         * Gets the value of the addressObjectKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressObjectKey() {
            return addressObjectKey;
        }

        /**
         * Sets the value of the addressObjectKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressObjectKey(String value) {
            this.addressObjectKey = value;
        }

        /**
         * Gets the value of the pairKey property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPairKey() {
            return pairKey;
        }

        /**
         * Sets the value of the pairKey property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPairKey(String value) {
            this.pairKey = value;
        }

        /**
         * Gets the value of the qualityIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getQualityIndicator() {
            return qualityIndicator;
        }

        /**
         * Sets the value of the qualityIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setQualityIndicator(NsiRef value) {
            this.qualityIndicator = value;
        }

        /**
         * Gets the value of the indicatorValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the indicatorValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndicatorValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExportSupplyResourceContractType.Quality.IndicatorValue }
         * 
         * 
         */
        public List<ExportSupplyResourceContractType.Quality.IndicatorValue> getIndicatorValue() {
            if (indicatorValue == null) {
                indicatorValue = new ArrayList<ExportSupplyResourceContractType.Quality.IndicatorValue>();
            }
            return this.indicatorValue;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;sequence>
         *           &lt;choice>
         *             &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
         *             &lt;sequence>
         *               &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
         *               &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType" minOccurs="0"/>
         *             &lt;/sequence>
         *           &lt;/choice>
         *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/>
         *         &lt;/sequence>
         *         &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "number",
            "startRange",
            "endRange",
            "okei",
            "correspond"
        })
        public static class IndicatorValue {

            @XmlElement(name = "Number")
            protected BigDecimal number;
            @XmlElement(name = "StartRange")
            protected BigDecimal startRange;
            @XmlElement(name = "EndRange")
            protected BigDecimal endRange;
            @XmlElement(name = "OKEI", namespace = "http://dom.gosuslugi.ru/schema/integration/base/")
            protected String okei;
            @XmlElement(name = "Correspond")
            protected Boolean correspond;

            /**
             * Gets the value of the number property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getNumber() {
                return number;
            }

            /**
             * Sets the value of the number property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setNumber(BigDecimal value) {
                this.number = value;
            }

            /**
             * Gets the value of the startRange property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getStartRange() {
                return startRange;
            }

            /**
             * Sets the value of the startRange property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setStartRange(BigDecimal value) {
                this.startRange = value;
            }

            /**
             * Gets the value of the endRange property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getEndRange() {
                return endRange;
            }

            /**
             * Sets the value of the endRange property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setEndRange(BigDecimal value) {
                this.endRange = value;
            }

            /**
             * Gets the value of the okei property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOKEI() {
                return okei;
            }

            /**
             * Sets the value of the okei property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOKEI(String value) {
                this.okei = value;
            }

            /**
             * Gets the value of the correspond property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isCorrespond() {
                return correspond;
            }

            /**
             * Sets the value of the correspond property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setCorrespond(Boolean value) {
                this.correspond = value;
            }

        }

    }

}
