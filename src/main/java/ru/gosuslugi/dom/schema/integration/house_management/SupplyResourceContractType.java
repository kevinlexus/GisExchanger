
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.base.AttachmentType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.organizations_registry_base.RegOrgType;


/**
 * Договор ресурсоснабжения
 * 
 * <p>Java class for SupplyResourceContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupplyResourceContractType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="IsContract"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ContractNumber"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="100"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="IsNotContract"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="ContractNumber" minOccurs="0"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="1"/&gt;
 *                           &lt;maxLength value="100"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                     &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                     &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;choice&gt;
 *           &lt;element name="IndefiniteTerm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="AutomaticRollOverOneYear" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *             &lt;element name="ComptetionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Period" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Start"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="StartDate"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                                   &lt;maxInclusive value="30"/&gt;
 *                                   &lt;minInclusive value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="End"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="EndDate"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                                   &lt;maxInclusive value="30"/&gt;
 *                                   &lt;minInclusive value="-1"/&gt;
 *                                   &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
 *         &lt;element name="IndicationsAnyDay" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ContractBase" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Offer" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="ApartmentBuildingOwner"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="LivingHouseOwner"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Organization"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/organizations-registry-base/}RegOrgType"&gt;
 *                 &lt;/extension&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ApartmentBuildingRepresentativeOwner"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ApartmentBuildingSoleOwner"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                     &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
 *                     &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="IsPlannedVolume" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="PlannedVolumeType" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="D"/&gt;
 *               &lt;enumeration value="O"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ContractSubject" maxOccurs="100"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CountingResource" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="R"/&gt;
 *               &lt;enumeration value="P"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SpecifyingQualityIndicators"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="D"/&gt;
 *               &lt;enumeration value="O"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ObjectAddress" maxOccurs="15000" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
 *                   &lt;element name="Pair" maxOccurs="100"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="HeatingSystemType" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="OpenOrNot"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;enumeration value="Opened"/&gt;
 *                                             &lt;enumeration value="Closed"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CentralizedOrNot"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;enumeration value="Centralized"/&gt;
 *                                             &lt;enumeration value="Decentralized"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
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
 *                   &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                             &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
 *                             &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
 *                             &lt;element name="FeedingMode"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
 *                                   &lt;maxLength value="250"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CountingResource" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="R"/&gt;
 *                         &lt;enumeration value="P"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Quality" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="IndicatorValue"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OtherQualityIndicator" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;sequence&gt;
 *                       &lt;choice&gt;
 *                         &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                         &lt;sequence&gt;
 *                           &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                           &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
 *                         &lt;/sequence&gt;
 *                       &lt;/choice&gt;
 *                       &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TemperatureChart" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                   &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="FlowLineTemperature"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                         &lt;fractionDigits value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="OppositeLineTemperature"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                         &lt;fractionDigits value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="BillingDate" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Date"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                           &lt;minInclusive value="-1"/&gt;
 *                           &lt;maxInclusive value="30"/&gt;
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DateType"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;enumeration value="C"/&gt;
 *                           &lt;enumeration value="N"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="PaymentDate" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Date"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                           &lt;minInclusive value="-1"/&gt;
 *                           &lt;maxInclusive value="30"/&gt;
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DateType"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;enumeration value="C"/&gt;
 *                           &lt;enumeration value="N"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="ProvidingInformationDate" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Date"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *                           &lt;minInclusive value="-1"/&gt;
 *                           &lt;maxInclusive value="30"/&gt;
 *                           &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="DateType"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;enumeration value="C"/&gt;
 *                           &lt;enumeration value="N"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="VolumeDepends" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="OneTimePayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="AccrualProcedure" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="D"/&gt;
 *               &lt;enumeration value="O"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Tariff" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="ForAllAddressObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Norm" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
 *                     &lt;element name="ForAllAddressObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;/choice&gt;
 *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
 *                   &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
@XmlType(name = "SupplyResourceContractType", propOrder = {
    "isContract",
    "isNotContract",
    "indefiniteTerm",
    "automaticRollOverOneYear",
    "comptetionDate",
    "period",
    "indicationsAnyDay",
    "contractBase",
    "offer",
    "apartmentBuildingOwner",
    "livingHouseOwner",
    "organization",
    "apartmentBuildingRepresentativeOwner",
    "apartmentBuildingSoleOwner",
    "isPlannedVolume",
    "plannedVolumeType",
    "contractSubject",
    "countingResource",
    "specifyingQualityIndicators",
    "objectAddress",
    "quality",
    "otherQualityIndicator",
    "temperatureChart",
    "billingDate",
    "paymentDate",
    "providingInformationDate",
    "meteringDeviceInformation",
    "volumeDepends",
    "oneTimePayment",
    "accrualProcedure",
    "tariff",
    "norm"
})
public class SupplyResourceContractType {

    @XmlElement(name = "IsContract")
    protected SupplyResourceContractType.IsContract isContract;
    @XmlElement(name = "IsNotContract")
    protected SupplyResourceContractType.IsNotContract isNotContract;
    @XmlElement(name = "IndefiniteTerm")
    protected Boolean indefiniteTerm;
    @XmlElement(name = "AutomaticRollOverOneYear")
    protected Boolean automaticRollOverOneYear;
    @XmlElement(name = "ComptetionDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar comptetionDate;
    @XmlElement(name = "Period")
    protected SupplyResourceContractType.Period period;
    @XmlElement(name = "IndicationsAnyDay")
    protected Boolean indicationsAnyDay;
    @XmlElement(name = "ContractBase")
    protected List<NsiRef> contractBase;
    @XmlElement(name = "Offer")
    protected Boolean offer;
    @XmlElement(name = "ApartmentBuildingOwner")
    protected SupplyResourceContractType.ApartmentBuildingOwner apartmentBuildingOwner;
    @XmlElement(name = "LivingHouseOwner")
    protected SupplyResourceContractType.LivingHouseOwner livingHouseOwner;
    @XmlElement(name = "Organization")
    protected SupplyResourceContractType.Organization organization;
    @XmlElement(name = "ApartmentBuildingRepresentativeOwner")
    protected SupplyResourceContractType.ApartmentBuildingRepresentativeOwner apartmentBuildingRepresentativeOwner;
    @XmlElement(name = "ApartmentBuildingSoleOwner")
    protected SupplyResourceContractType.ApartmentBuildingSoleOwner apartmentBuildingSoleOwner;
    @XmlElement(name = "IsPlannedVolume")
    protected boolean isPlannedVolume;
    @XmlElement(name = "PlannedVolumeType")
    protected String plannedVolumeType;
    @XmlElement(name = "ContractSubject", required = true)
    protected List<SupplyResourceContractType.ContractSubject> contractSubject;
    @XmlElement(name = "CountingResource")
    protected String countingResource;
    @XmlElement(name = "SpecifyingQualityIndicators", required = true)
    protected String specifyingQualityIndicators;
    @XmlElement(name = "ObjectAddress")
    protected List<SupplyResourceContractType.ObjectAddress> objectAddress;
    @XmlElement(name = "Quality")
    protected List<SupplyResourceContractType.Quality> quality;
    @XmlElement(name = "OtherQualityIndicator")
    protected List<SupplyResourceContractType.OtherQualityIndicator> otherQualityIndicator;
    @XmlElement(name = "TemperatureChart")
    protected List<SupplyResourceContractType.TemperatureChart> temperatureChart;
    @XmlElement(name = "BillingDate")
    protected SupplyResourceContractType.BillingDate billingDate;
    @XmlElement(name = "PaymentDate")
    protected SupplyResourceContractType.PaymentDate paymentDate;
    @XmlElement(name = "ProvidingInformationDate")
    protected SupplyResourceContractType.ProvidingInformationDate providingInformationDate;
    @XmlElement(name = "MeteringDeviceInformation")
    protected Boolean meteringDeviceInformation;
    @XmlElement(name = "VolumeDepends")
    protected Boolean volumeDepends;
    @XmlElement(name = "OneTimePayment")
    protected Boolean oneTimePayment;
    @XmlElement(name = "AccrualProcedure")
    protected String accrualProcedure;
    @XmlElement(name = "Tariff")
    protected List<SupplyResourceContractType.Tariff> tariff;
    @XmlElement(name = "Norm")
    protected List<SupplyResourceContractType.Norm> norm;

    /**
     * Gets the value of the isContract property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.IsContract }
     *     
     */
    public SupplyResourceContractType.IsContract getIsContract() {
        return isContract;
    }

    /**
     * Sets the value of the isContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.IsContract }
     *     
     */
    public void setIsContract(SupplyResourceContractType.IsContract value) {
        this.isContract = value;
    }

    /**
     * Gets the value of the isNotContract property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.IsNotContract }
     *     
     */
    public SupplyResourceContractType.IsNotContract getIsNotContract() {
        return isNotContract;
    }

    /**
     * Sets the value of the isNotContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.IsNotContract }
     *     
     */
    public void setIsNotContract(SupplyResourceContractType.IsNotContract value) {
        this.isNotContract = value;
    }

    /**
     * Gets the value of the indefiniteTerm property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndefiniteTerm() {
        return indefiniteTerm;
    }

    /**
     * Sets the value of the indefiniteTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndefiniteTerm(Boolean value) {
        this.indefiniteTerm = value;
    }

    /**
     * Gets the value of the automaticRollOverOneYear property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutomaticRollOverOneYear() {
        return automaticRollOverOneYear;
    }

    /**
     * Sets the value of the automaticRollOverOneYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutomaticRollOverOneYear(Boolean value) {
        this.automaticRollOverOneYear = value;
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
     *     {@link SupplyResourceContractType.Period }
     *     
     */
    public SupplyResourceContractType.Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.Period }
     *     
     */
    public void setPeriod(SupplyResourceContractType.Period value) {
        this.period = value;
    }

    /**
     * Gets the value of the indicationsAnyDay property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndicationsAnyDay() {
        return indicationsAnyDay;
    }

    /**
     * Sets the value of the indicationsAnyDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndicationsAnyDay(Boolean value) {
        this.indicationsAnyDay = value;
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
     *     {@link SupplyResourceContractType.ApartmentBuildingOwner }
     *     
     */
    public SupplyResourceContractType.ApartmentBuildingOwner getApartmentBuildingOwner() {
        return apartmentBuildingOwner;
    }

    /**
     * Sets the value of the apartmentBuildingOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.ApartmentBuildingOwner }
     *     
     */
    public void setApartmentBuildingOwner(SupplyResourceContractType.ApartmentBuildingOwner value) {
        this.apartmentBuildingOwner = value;
    }

    /**
     * Gets the value of the livingHouseOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.LivingHouseOwner }
     *     
     */
    public SupplyResourceContractType.LivingHouseOwner getLivingHouseOwner() {
        return livingHouseOwner;
    }

    /**
     * Sets the value of the livingHouseOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.LivingHouseOwner }
     *     
     */
    public void setLivingHouseOwner(SupplyResourceContractType.LivingHouseOwner value) {
        this.livingHouseOwner = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.Organization }
     *     
     */
    public SupplyResourceContractType.Organization getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.Organization }
     *     
     */
    public void setOrganization(SupplyResourceContractType.Organization value) {
        this.organization = value;
    }

    /**
     * Gets the value of the apartmentBuildingRepresentativeOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.ApartmentBuildingRepresentativeOwner }
     *     
     */
    public SupplyResourceContractType.ApartmentBuildingRepresentativeOwner getApartmentBuildingRepresentativeOwner() {
        return apartmentBuildingRepresentativeOwner;
    }

    /**
     * Sets the value of the apartmentBuildingRepresentativeOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.ApartmentBuildingRepresentativeOwner }
     *     
     */
    public void setApartmentBuildingRepresentativeOwner(SupplyResourceContractType.ApartmentBuildingRepresentativeOwner value) {
        this.apartmentBuildingRepresentativeOwner = value;
    }

    /**
     * Gets the value of the apartmentBuildingSoleOwner property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.ApartmentBuildingSoleOwner }
     *     
     */
    public SupplyResourceContractType.ApartmentBuildingSoleOwner getApartmentBuildingSoleOwner() {
        return apartmentBuildingSoleOwner;
    }

    /**
     * Sets the value of the apartmentBuildingSoleOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.ApartmentBuildingSoleOwner }
     *     
     */
    public void setApartmentBuildingSoleOwner(SupplyResourceContractType.ApartmentBuildingSoleOwner value) {
        this.apartmentBuildingSoleOwner = value;
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
     * {@link SupplyResourceContractType.ContractSubject }
     * 
     * 
     */
    public List<SupplyResourceContractType.ContractSubject> getContractSubject() {
        if (contractSubject == null) {
            contractSubject = new ArrayList<SupplyResourceContractType.ContractSubject>();
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
     * {@link SupplyResourceContractType.ObjectAddress }
     * 
     * 
     */
    public List<SupplyResourceContractType.ObjectAddress> getObjectAddress() {
        if (objectAddress == null) {
            objectAddress = new ArrayList<SupplyResourceContractType.ObjectAddress>();
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
     * {@link SupplyResourceContractType.Quality }
     * 
     * 
     */
    public List<SupplyResourceContractType.Quality> getQuality() {
        if (quality == null) {
            quality = new ArrayList<SupplyResourceContractType.Quality>();
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
     * {@link SupplyResourceContractType.OtherQualityIndicator }
     * 
     * 
     */
    public List<SupplyResourceContractType.OtherQualityIndicator> getOtherQualityIndicator() {
        if (otherQualityIndicator == null) {
            otherQualityIndicator = new ArrayList<SupplyResourceContractType.OtherQualityIndicator>();
        }
        return this.otherQualityIndicator;
    }

    /**
     * Gets the value of the temperatureChart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temperatureChart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemperatureChart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractType.TemperatureChart }
     * 
     * 
     */
    public List<SupplyResourceContractType.TemperatureChart> getTemperatureChart() {
        if (temperatureChart == null) {
            temperatureChart = new ArrayList<SupplyResourceContractType.TemperatureChart>();
        }
        return this.temperatureChart;
    }

    /**
     * Gets the value of the billingDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.BillingDate }
     *     
     */
    public SupplyResourceContractType.BillingDate getBillingDate() {
        return billingDate;
    }

    /**
     * Sets the value of the billingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.BillingDate }
     *     
     */
    public void setBillingDate(SupplyResourceContractType.BillingDate value) {
        this.billingDate = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.PaymentDate }
     *     
     */
    public SupplyResourceContractType.PaymentDate getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.PaymentDate }
     *     
     */
    public void setPaymentDate(SupplyResourceContractType.PaymentDate value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the providingInformationDate property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyResourceContractType.ProvidingInformationDate }
     *     
     */
    public SupplyResourceContractType.ProvidingInformationDate getProvidingInformationDate() {
        return providingInformationDate;
    }

    /**
     * Sets the value of the providingInformationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyResourceContractType.ProvidingInformationDate }
     *     
     */
    public void setProvidingInformationDate(SupplyResourceContractType.ProvidingInformationDate value) {
        this.providingInformationDate = value;
    }

    /**
     * Gets the value of the meteringDeviceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMeteringDeviceInformation() {
        return meteringDeviceInformation;
    }

    /**
     * Sets the value of the meteringDeviceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMeteringDeviceInformation(Boolean value) {
        this.meteringDeviceInformation = value;
    }

    /**
     * Gets the value of the volumeDepends property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVolumeDepends() {
        return volumeDepends;
    }

    /**
     * Sets the value of the volumeDepends property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVolumeDepends(Boolean value) {
        this.volumeDepends = value;
    }

    /**
     * Gets the value of the oneTimePayment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOneTimePayment() {
        return oneTimePayment;
    }

    /**
     * Sets the value of the oneTimePayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOneTimePayment(Boolean value) {
        this.oneTimePayment = value;
    }

    /**
     * Gets the value of the accrualProcedure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccrualProcedure() {
        return accrualProcedure;
    }

    /**
     * Sets the value of the accrualProcedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccrualProcedure(String value) {
        this.accrualProcedure = value;
    }

    /**
     * Gets the value of the tariff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tariff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTariff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractType.Tariff }
     * 
     * 
     */
    public List<SupplyResourceContractType.Tariff> getTariff() {
        if (tariff == null) {
            tariff = new ArrayList<SupplyResourceContractType.Tariff>();
        }
        return this.tariff;
    }

    /**
     * Gets the value of the norm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the norm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNorm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplyResourceContractType.Norm }
     * 
     * 
     */
    public List<SupplyResourceContractType.Norm> getNorm() {
        if (norm == null) {
            norm = new ArrayList<SupplyResourceContractType.Norm>();
        }
        return this.norm;
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
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regOrg",
        "ind",
        "noData"
    })
    public static class ApartmentBuildingOwner {

        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;
        @XmlElement(name = "NoData")
        protected Boolean noData;

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
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
    public static class ApartmentBuildingRepresentativeOwner {

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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
    public static class ApartmentBuildingSoleOwner {

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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Date"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;minInclusive value="-1"/&gt;
     *               &lt;maxInclusive value="30"/&gt;
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DateType"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="C"/&gt;
     *               &lt;enumeration value="N"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ContractSubjectType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
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
        "transportGUID"
    })
    public static class ContractSubject
        extends ContractSubjectType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;

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
     *         &lt;element name="ContractNumber"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="100"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100"/&gt;
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
        @XmlElement(name = "ContractAttachment", required = true)
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ContractNumber" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *               &lt;maxLength value="100"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SigningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *         &lt;element name="ContractAttachment" type="{http://dom.gosuslugi.ru/schema/integration/base/}AttachmentType" maxOccurs="100" minOccurs="0"/&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;choice&gt;
     *         &lt;element name="RegOrg" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSORegOrgType"/&gt;
     *         &lt;element name="Ind" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOIndType"/&gt;
     *         &lt;element name="NoData" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "regOrg",
        "ind",
        "noData"
    })
    public static class LivingHouseOwner {

        @XmlElement(name = "RegOrg")
        protected DRSORegOrgType regOrg;
        @XmlElement(name = "Ind")
        protected DRSOIndType ind;
        @XmlElement(name = "NoData")
        protected Boolean noData;

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
     *           &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *           &lt;element name="ForAllAddressObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="NormGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "addressObjectKey",
        "forAllAddressObjects",
        "pairKey",
        "normGUID"
    })
    public static class Norm {

        @XmlElement(name = "AddressObjectKey")
        protected List<String> addressObjectKey;
        @XmlElement(name = "ForAllAddressObjects")
        protected Boolean forAllAddressObjects;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "NormGUID", required = true)
        protected String normGUID;

        /**
         * Gets the value of the addressObjectKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the addressObjectKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddressObjectKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAddressObjectKey() {
            if (addressObjectKey == null) {
                addressObjectKey = new ArrayList<String>();
            }
            return this.addressObjectKey;
        }

        /**
         * Gets the value of the forAllAddressObjects property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isForAllAddressObjects() {
            return forAllAddressObjects;
        }

        /**
         * Sets the value of the forAllAddressObjects property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setForAllAddressObjects(Boolean value) {
            this.forAllAddressObjects = value;
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
         * Gets the value of the normGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNormGUID() {
            return normGUID;
        }

        /**
         * Sets the value of the normGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNormGUID(String value) {
            this.normGUID = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}ObjectAddressType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}TransportGUID"/&gt;
     *         &lt;element name="Pair" maxOccurs="100"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="HeatingSystemType" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="OpenOrNot"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;enumeration value="Opened"/&gt;
     *                                   &lt;enumeration value="Closed"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CentralizedOrNot"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;enumeration value="Centralized"/&gt;
     *                                   &lt;enumeration value="Decentralized"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
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
     *         &lt;element name="PlannedVolume" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *                   &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
     *                   &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
     *                   &lt;element name="FeedingMode"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
     *                         &lt;maxLength value="250"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CountingResource" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="R"/&gt;
     *               &lt;enumeration value="P"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MeteringDeviceInformation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "pair",
        "plannedVolume",
        "countingResource",
        "meteringDeviceInformation"
    })
    public static class ObjectAddress
        extends ObjectAddressType
    {

        @XmlElement(name = "TransportGUID", namespace = "http://dom.gosuslugi.ru/schema/integration/base/", required = true)
        protected String transportGUID;
        @XmlElement(name = "Pair", required = true)
        protected List<SupplyResourceContractType.ObjectAddress.Pair> pair;
        @XmlElement(name = "PlannedVolume")
        protected List<SupplyResourceContractType.ObjectAddress.PlannedVolume> plannedVolume;
        @XmlElement(name = "CountingResource")
        protected String countingResource;
        @XmlElement(name = "MeteringDeviceInformation")
        protected Boolean meteringDeviceInformation;

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
         * {@link SupplyResourceContractType.ObjectAddress.Pair }
         * 
         * 
         */
        public List<SupplyResourceContractType.ObjectAddress.Pair> getPair() {
            if (pair == null) {
                pair = new ArrayList<SupplyResourceContractType.ObjectAddress.Pair>();
            }
            return this.pair;
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
         * {@link SupplyResourceContractType.ObjectAddress.PlannedVolume }
         * 
         * 
         */
        public List<SupplyResourceContractType.ObjectAddress.PlannedVolume> getPlannedVolume() {
            if (plannedVolume == null) {
                plannedVolume = new ArrayList<SupplyResourceContractType.ObjectAddress.PlannedVolume>();
            }
            return this.plannedVolume;
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
         * Gets the value of the meteringDeviceInformation property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isMeteringDeviceInformation() {
            return meteringDeviceInformation;
        }

        /**
         * Sets the value of the meteringDeviceInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setMeteringDeviceInformation(Boolean value) {
            this.meteringDeviceInformation = value;
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
         *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *         &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="HeatingSystemType" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="OpenOrNot"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;enumeration value="Opened"/&gt;
         *                         &lt;enumeration value="Closed"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CentralizedOrNot"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;enumeration value="Centralized"/&gt;
         *                         &lt;enumeration value="Decentralized"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
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
            @XmlElement(name = "EndSupplyDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar endSupplyDate;
            @XmlElement(name = "HeatingSystemType")
            protected SupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType heatingSystemType;

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
             * @return
             *     possible object is
             *     {@link SupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType }
             *     
             */
            public SupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType getHeatingSystemType() {
                return heatingSystemType;
            }

            /**
             * Sets the value of the heatingSystemType property.
             * 
             * @param value
             *     allowed object is
             *     {@link SupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType }
             *     
             */
            public void setHeatingSystemType(SupplyResourceContractType.ObjectAddress.Pair.HeatingSystemType value) {
                this.heatingSystemType = value;
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
             *         &lt;element name="OpenOrNot"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;enumeration value="Opened"/&gt;
             *               &lt;enumeration value="Closed"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CentralizedOrNot"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;enumeration value="Centralized"/&gt;
             *               &lt;enumeration value="Decentralized"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
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
         *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
         *         &lt;element name="Volume" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}DRSOVolumeType"/&gt;
         *         &lt;element name="Unit" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKEIType"/&gt;
         *         &lt;element name="FeedingMode"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String250Type"&gt;
         *               &lt;maxLength value="250"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
            "pairKey",
            "volume",
            "unit",
            "feedingMode"
        })
        public static class PlannedVolume {

            @XmlElement(name = "PairKey", required = true)
            protected String pairKey;
            @XmlElement(name = "Volume", required = true)
            protected BigDecimal volume;
            @XmlElement(name = "Unit", required = true)
            protected String unit;
            @XmlElement(name = "FeedingMode", required = true)
            protected String feedingMode;

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
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="IndicatorName" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OtherQualityIndicatorNameType"/&gt;
     *         &lt;choice&gt;
     *           &lt;sequence&gt;
     *             &lt;choice&gt;
     *               &lt;element name="Number" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *               &lt;sequence&gt;
     *                 &lt;element name="StartRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *                 &lt;element name="EndRange" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueNumberType"/&gt;
     *               &lt;/sequence&gt;
     *             &lt;/choice&gt;
     *             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/base/}OKEI" minOccurs="0"/&gt;
     *           &lt;/sequence&gt;
     *           &lt;element name="Correspond" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
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
        "addressObjectKey",
        "pairKey",
        "indicatorName",
        "number",
        "startRange",
        "endRange",
        "okei",
        "correspond",
        "additionalInformation"
    })
    public static class OtherQualityIndicator {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "IndicatorName", required = true)
        protected String indicatorName;
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
        @XmlElement(name = "AdditionalInformation")
        protected String additionalInformation;

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

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInformation(String value) {
            this.additionalInformation = value;
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
     *         &lt;element name="Date"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;minInclusive value="-1"/&gt;
     *               &lt;maxInclusive value="30"/&gt;
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DateType"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="C"/&gt;
     *               &lt;enumeration value="N"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Start"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="StartDate"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *                         &lt;maxInclusive value="30"/&gt;
     *                         &lt;minInclusive value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="End"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="EndDate"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *                         &lt;maxInclusive value="30"/&gt;
     *                         &lt;minInclusive value="-1"/&gt;
     *                         &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
        "start",
        "end"
    })
    public static class Period {

        @XmlElement(name = "Start", required = true)
        protected SupplyResourceContractType.Period.Start start;
        @XmlElement(name = "End", required = true)
        protected SupplyResourceContractType.Period.End end;

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractType.Period.Start }
         *     
         */
        public SupplyResourceContractType.Period.Start getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractType.Period.Start }
         *     
         */
        public void setStart(SupplyResourceContractType.Period.Start value) {
            this.start = value;
        }

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link SupplyResourceContractType.Period.End }
         *     
         */
        public SupplyResourceContractType.Period.End getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractType.Period.End }
         *     
         */
        public void setEnd(SupplyResourceContractType.Period.End value) {
            this.end = value;
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
         *         &lt;element name="EndDate"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
         *               &lt;maxInclusive value="30"/&gt;
         *               &lt;minInclusive value="-1"/&gt;
         *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="StartDate"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
         *               &lt;maxInclusive value="30"/&gt;
         *               &lt;minInclusive value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NextMonth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Date"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
     *               &lt;minInclusive value="-1"/&gt;
     *               &lt;maxInclusive value="30"/&gt;
     *               &lt;pattern value="(-1)|[1-9]|([1][0-9])|([2][0-9])|30"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DateType"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="C"/&gt;
     *               &lt;enumeration value="N"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="QualityIndicator" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="IndicatorValue"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AdditionalInformation" type="{http://dom.gosuslugi.ru/schema/integration/base/}String500Type" minOccurs="0"/&gt;
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
        "addressObjectKey",
        "pairKey",
        "qualityIndicator",
        "indicatorValue",
        "additionalInformation"
    })
    public static class Quality {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "QualityIndicator", required = true)
        protected NsiRef qualityIndicator;
        @XmlElement(name = "IndicatorValue", required = true)
        protected SupplyResourceContractType.Quality.IndicatorValue indicatorValue;
        @XmlElement(name = "AdditionalInformation")
        protected String additionalInformation;

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
         * @return
         *     possible object is
         *     {@link SupplyResourceContractType.Quality.IndicatorValue }
         *     
         */
        public SupplyResourceContractType.Quality.IndicatorValue getIndicatorValue() {
            return indicatorValue;
        }

        /**
         * Sets the value of the indicatorValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupplyResourceContractType.Quality.IndicatorValue }
         *     
         */
        public void setIndicatorValue(SupplyResourceContractType.Quality.IndicatorValue value) {
            this.indicatorValue = value;
        }

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAdditionalInformation(String value) {
            this.additionalInformation = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}IndicatorValueType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;choice&gt;
     *           &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" maxOccurs="unbounded"/&gt;
     *           &lt;element name="ForAllAddressObjects" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;/choice&gt;
     *         &lt;element name="PairKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
     *         &lt;element name="PriceGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType"/&gt;
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
        "addressObjectKey",
        "forAllAddressObjects",
        "pairKey",
        "priceGUID"
    })
    public static class Tariff {

        @XmlElement(name = "AddressObjectKey")
        protected List<String> addressObjectKey;
        @XmlElement(name = "ForAllAddressObjects")
        protected Boolean forAllAddressObjects;
        @XmlElement(name = "PairKey", required = true)
        protected String pairKey;
        @XmlElement(name = "PriceGUID", required = true)
        protected String priceGUID;

        /**
         * Gets the value of the addressObjectKey property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the addressObjectKey property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddressObjectKey().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAddressObjectKey() {
            if (addressObjectKey == null) {
                addressObjectKey = new ArrayList<String>();
            }
            return this.addressObjectKey;
        }

        /**
         * Gets the value of the forAllAddressObjects property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isForAllAddressObjects() {
            return forAllAddressObjects;
        }

        /**
         * Sets the value of the forAllAddressObjects property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setForAllAddressObjects(Boolean value) {
            this.forAllAddressObjects = value;
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
         * Gets the value of the priceGUID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPriceGUID() {
            return priceGUID;
        }

        /**
         * Sets the value of the priceGUID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPriceGUID(String value) {
            this.priceGUID = value;
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
     *         &lt;element name="AddressObjectKey" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *         &lt;element name="OutsideTemperature" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="FlowLineTemperature"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *               &lt;fractionDigits value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="OppositeLineTemperature"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *               &lt;fractionDigits value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
        "addressObjectKey",
        "outsideTemperature",
        "flowLineTemperature",
        "oppositeLineTemperature"
    })
    public static class TemperatureChart {

        @XmlElement(name = "AddressObjectKey")
        protected String addressObjectKey;
        @XmlElement(name = "OutsideTemperature")
        protected int outsideTemperature;
        @XmlElement(name = "FlowLineTemperature", required = true)
        protected BigDecimal flowLineTemperature;
        @XmlElement(name = "OppositeLineTemperature", required = true)
        protected BigDecimal oppositeLineTemperature;

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
         * Gets the value of the outsideTemperature property.
         * 
         */
        public int getOutsideTemperature() {
            return outsideTemperature;
        }

        /**
         * Sets the value of the outsideTemperature property.
         * 
         */
        public void setOutsideTemperature(int value) {
            this.outsideTemperature = value;
        }

        /**
         * Gets the value of the flowLineTemperature property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getFlowLineTemperature() {
            return flowLineTemperature;
        }

        /**
         * Sets the value of the flowLineTemperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setFlowLineTemperature(BigDecimal value) {
            this.flowLineTemperature = value;
        }

        /**
         * Gets the value of the oppositeLineTemperature property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOppositeLineTemperature() {
            return oppositeLineTemperature;
        }

        /**
         * Sets the value of the oppositeLineTemperature property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOppositeLineTemperature(BigDecimal value) {
            this.oppositeLineTemperature = value;
        }

    }

}
