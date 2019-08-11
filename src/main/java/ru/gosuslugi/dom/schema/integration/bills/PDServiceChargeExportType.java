
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Потребление и начисление по услугам в ПД (экспорт)
 * 
 * <p>Java class for PDServiceChargeExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PDServiceChargeExportType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="HousingService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
 *                 &lt;sequence minOccurs="0"&gt;
 *                   &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
 *                   &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                             &lt;element name="Consumption" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Volume"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                                               &lt;attribute name="type"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;enumeration value="O"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                               &lt;attribute name="determiningMethod"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;length value="1"/&gt;
 *                                                     &lt;enumeration value="N"/&gt;
 *                                                     &lt;enumeration value="M"/&gt;
 *                                                     &lt;enumeration value="O"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Rate" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="6"/&gt;
 *                                   &lt;totalDigits value="14"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
 *                             &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ServiceInformation" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                                       &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                                       &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="recalculationReason"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="500"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="sum"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                             &lt;fractionDigits value="2"/&gt;
 *                                             &lt;minInclusive value="-9999999999.99"/&gt;
 *                                             &lt;maxInclusive value="9999999999.99"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="13"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TotalPayable" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
 *                             &lt;element name="GeneralMunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/bills/}GeneralMunicipalResourceExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="recalculationReason"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="500"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="sum"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;minInclusive value="-9999999999.99"/&gt;
 *                                   &lt;maxInclusive value="9999999999.99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
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
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
 *                   &lt;element name="Consumption" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Volume" maxOccurs="2"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                                     &lt;attribute name="type"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="I"/&gt;
 *                                           &lt;enumeration value="O"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="recalculationReason"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                   &lt;maxLength value="500"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="sum"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;minInclusive value="-9999999999.99"/&gt;
 *                                   &lt;maxInclusive value="9999999999.99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
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
 *         &lt;element name="MunicipalService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ServiceCharge" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType"&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PiecemealPayment" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="paymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="pastPaymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="piecemealPaymentPercentRub"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="piecemealPaymentPercent"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;minInclusive value="0"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;totalDigits value="5"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="piecemealPaymentSum"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="recalculationReason"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;minLength value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="sum"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                   &lt;minInclusive value="-9999999999.99"/&gt;
 *                                   &lt;maxInclusive value="9999999999.99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
 *                   &lt;element name="Consumption" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Volume" maxOccurs="2"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                                     &lt;attribute name="type"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="I"/&gt;
 *                                           &lt;enumeration value="O"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                     &lt;attribute name="determiningMethod"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;length value="1"/&gt;
 *                                           &lt;enumeration value="N"/&gt;
 *                                           &lt;enumeration value="M"/&gt;
 *                                           &lt;enumeration value="O"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Ratio"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="5"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="18"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="18"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="18"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;totalDigits value="18"/&gt;
 *                         &lt;fractionDigits value="2"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GroupMunicipalService"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TypeMunicipalService" type="{http://dom.gosuslugi.ru/schema/integration/bills/}TypeMunicipalServiceExportType"/&gt;
 *                   &lt;element name="MunicipalService" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/&gt;
 *                             &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="recalculationReason"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="500"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="sum"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                             &lt;fractionDigits value="2"/&gt;
 *                                             &lt;minInclusive value="-9999999999.99"/&gt;
 *                                             &lt;maxInclusive value="9999999999.99"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
 *                             &lt;element name="Consumption" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Volume" maxOccurs="2"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;simpleContent&gt;
 *                                             &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
 *                                               &lt;attribute name="type"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;enumeration value="I"/&gt;
 *                                                     &lt;enumeration value="O"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                               &lt;attribute name="determiningMethod"&gt;
 *                                                 &lt;simpleType&gt;
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                     &lt;length value="1"/&gt;
 *                                                     &lt;enumeration value="N"/&gt;
 *                                                     &lt;enumeration value="M"/&gt;
 *                                                     &lt;enumeration value="O"/&gt;
 *                                                   &lt;/restriction&gt;
 *                                                 &lt;/simpleType&gt;
 *                                               &lt;/attribute&gt;
 *                                             &lt;/extension&gt;
 *                                           &lt;/simpleContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Ratio"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                             &lt;totalDigits value="5"/&gt;
 *                                             &lt;fractionDigits value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                             &lt;totalDigits value="13"/&gt;
 *                                             &lt;fractionDigits value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="13"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="13"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="13"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                   &lt;totalDigits value="13"/&gt;
 *                                   &lt;fractionDigits value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
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
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PDServiceChargeExportType", propOrder = {
    "housingService",
    "additionalService",
    "municipalService",
    "groupMunicipalService"
})
public class PDServiceChargeExportType {

    @XmlElement(name = "HousingService")
    protected PDServiceChargeExportType.HousingService housingService;
    @XmlElement(name = "AdditionalService")
    protected PDServiceChargeExportType.AdditionalService additionalService;
    @XmlElement(name = "MunicipalService")
    protected PDServiceChargeExportType.MunicipalService municipalService;
    @XmlElement(name = "GroupMunicipalService")
    protected PDServiceChargeExportType.GroupMunicipalService groupMunicipalService;

    /**
     * Gets the value of the housingService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeExportType.HousingService }
     *     
     */
    public PDServiceChargeExportType.HousingService getHousingService() {
        return housingService;
    }

    /**
     * Sets the value of the housingService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeExportType.HousingService }
     *     
     */
    public void setHousingService(PDServiceChargeExportType.HousingService value) {
        this.housingService = value;
    }

    /**
     * Gets the value of the additionalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeExportType.AdditionalService }
     *     
     */
    public PDServiceChargeExportType.AdditionalService getAdditionalService() {
        return additionalService;
    }

    /**
     * Sets the value of the additionalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeExportType.AdditionalService }
     *     
     */
    public void setAdditionalService(PDServiceChargeExportType.AdditionalService value) {
        this.additionalService = value;
    }

    /**
     * Gets the value of the municipalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeExportType.MunicipalService }
     *     
     */
    public PDServiceChargeExportType.MunicipalService getMunicipalService() {
        return municipalService;
    }

    /**
     * Sets the value of the municipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeExportType.MunicipalService }
     *     
     */
    public void setMunicipalService(PDServiceChargeExportType.MunicipalService value) {
        this.municipalService = value;
    }

    /**
     * Gets the value of the groupMunicipalService property.
     * 
     * @return
     *     possible object is
     *     {@link PDServiceChargeExportType.GroupMunicipalService }
     *     
     */
    public PDServiceChargeExportType.GroupMunicipalService getGroupMunicipalService() {
        return groupMunicipalService;
    }

    /**
     * Sets the value of the groupMunicipalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link PDServiceChargeExportType.GroupMunicipalService }
     *     
     */
    public void setGroupMunicipalService(PDServiceChargeExportType.GroupMunicipalService value) {
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
     *         &lt;element name="Consumption" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Volume" maxOccurs="2"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                           &lt;attribute name="type"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="I"/&gt;
     *                                 &lt;enumeration value="O"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="recalculationReason"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="500"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="sum"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;minInclusive value="-9999999999.99"/&gt;
     *                         &lt;maxInclusive value="9999999999.99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
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
        "serviceCharge",
        "consumption",
        "paymentRecalculation"
    })
    public static class AdditionalService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "Consumption")
        protected PDServiceChargeExportType.AdditionalService.Consumption consumption;
        @XmlElement(name = "PaymentRecalculation")
        protected PDServiceChargeExportType.AdditionalService.PaymentRecalculation paymentRecalculation;

        /**
         * Gets the value of the serviceCharge property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceChargeType }
         *     
         */
        public ServiceChargeType getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceChargeType }
         *     
         */
        public void setServiceCharge(ServiceChargeType value) {
            this.serviceCharge = value;
        }

        /**
         * Gets the value of the consumption property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.AdditionalService.Consumption }
         *     
         */
        public PDServiceChargeExportType.AdditionalService.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.AdditionalService.Consumption }
         *     
         */
        public void setConsumption(PDServiceChargeExportType.AdditionalService.Consumption value) {
            this.consumption = value;
        }

        /**
         * Gets the value of the paymentRecalculation property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.AdditionalService.PaymentRecalculation }
         *     
         */
        public PDServiceChargeExportType.AdditionalService.PaymentRecalculation getPaymentRecalculation() {
            return paymentRecalculation;
        }

        /**
         * Sets the value of the paymentRecalculation property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.AdditionalService.PaymentRecalculation }
         *     
         */
        public void setPaymentRecalculation(PDServiceChargeExportType.AdditionalService.PaymentRecalculation value) {
            this.paymentRecalculation = value;
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
         *         &lt;element name="Volume" maxOccurs="2"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
         *                 &lt;attribute name="type"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="I"/&gt;
         *                       &lt;enumeration value="O"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
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
            "volume"
        })
        public static class Consumption {

            @XmlElement(name = "Volume", required = true)
            protected List<PDServiceChargeExportType.AdditionalService.Consumption.Volume> volume;

            /**
             * Gets the value of the volume property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the volume property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVolume().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PDServiceChargeExportType.AdditionalService.Consumption.Volume }
             * 
             * 
             */
            public List<PDServiceChargeExportType.AdditionalService.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PDServiceChargeExportType.AdditionalService.Consumption.Volume>();
                }
                return this.volume;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
             *       &lt;attribute name="type"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="I"/&gt;
             *             &lt;enumeration value="O"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Volume {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "type")
                protected String type;

                /**
                 * Тип объема потребления КУ
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
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
         *         &lt;element name="recalculationReason"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="500"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="sum"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;minInclusive value="-9999999999.99"/&gt;
         *               &lt;maxInclusive value="9999999999.99"/&gt;
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
            "recalculationReason",
            "sum"
        })
        public static class PaymentRecalculation {

            @XmlElement(required = true)
            protected String recalculationReason;
            @XmlElement(required = true)
            protected BigDecimal sum;

            /**
             * Gets the value of the recalculationReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecalculationReason() {
                return recalculationReason;
            }

            /**
             * Sets the value of the recalculationReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecalculationReason(String value) {
                this.recalculationReason = value;
            }

            /**
             * Gets the value of the sum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSum() {
                return sum;
            }

            /**
             * Sets the value of the sum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSum(BigDecimal value) {
                this.sum = value;
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
     *         &lt;element name="TypeMunicipalService" type="{http://dom.gosuslugi.ru/schema/integration/bills/}TypeMunicipalServiceExportType"/&gt;
     *         &lt;element name="MunicipalService" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/&gt;
     *                   &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="recalculationReason"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="500"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="sum"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                   &lt;fractionDigits value="2"/&gt;
     *                                   &lt;minInclusive value="-9999999999.99"/&gt;
     *                                   &lt;maxInclusive value="9999999999.99"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
     *                   &lt;element name="Consumption" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Volume" maxOccurs="2"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                                     &lt;attribute name="type"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;enumeration value="I"/&gt;
     *                                           &lt;enumeration value="O"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                     &lt;attribute name="determiningMethod"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;length value="1"/&gt;
     *                                           &lt;enumeration value="N"/&gt;
     *                                           &lt;enumeration value="M"/&gt;
     *                                           &lt;enumeration value="O"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Ratio"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                   &lt;totalDigits value="5"/&gt;
     *                                   &lt;fractionDigits value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                   &lt;totalDigits value="13"/&gt;
     *                                   &lt;fractionDigits value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="13"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="13"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="13"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="13"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
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
        "typeMunicipalService",
        "municipalService"
    })
    public static class GroupMunicipalService {

        @XmlElement(name = "TypeMunicipalService", required = true)
        protected TypeMunicipalServiceExportType typeMunicipalService;
        @XmlElement(name = "MunicipalService")
        protected List<PDServiceChargeExportType.GroupMunicipalService.MunicipalService> municipalService;

        /**
         * Gets the value of the typeMunicipalService property.
         * 
         * @return
         *     possible object is
         *     {@link TypeMunicipalServiceExportType }
         *     
         */
        public TypeMunicipalServiceExportType getTypeMunicipalService() {
            return typeMunicipalService;
        }

        /**
         * Sets the value of the typeMunicipalService property.
         * 
         * @param value
         *     allowed object is
         *     {@link TypeMunicipalServiceExportType }
         *     
         */
        public void setTypeMunicipalService(TypeMunicipalServiceExportType value) {
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
         * {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService }
         * 
         * 
         */
        public List<PDServiceChargeExportType.GroupMunicipalService.MunicipalService> getMunicipalService() {
            if (municipalService == null) {
                municipalService = new ArrayList<PDServiceChargeExportType.GroupMunicipalService.MunicipalService>();
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeImportType" minOccurs="0"/&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}PiecemealPayment" minOccurs="0"/&gt;
         *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="recalculationReason"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="500"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="sum"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;fractionDigits value="2"/&gt;
         *                         &lt;minInclusive value="-9999999999.99"/&gt;
         *                         &lt;maxInclusive value="9999999999.99"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
         *         &lt;element name="Consumption" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Volume" maxOccurs="2"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
         *                           &lt;attribute name="type"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;enumeration value="I"/&gt;
         *                                 &lt;enumeration value="O"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                           &lt;attribute name="determiningMethod"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;length value="1"/&gt;
         *                                 &lt;enumeration value="N"/&gt;
         *                                 &lt;enumeration value="M"/&gt;
         *                                 &lt;enumeration value="O"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Ratio"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;totalDigits value="5"/&gt;
         *                         &lt;fractionDigits value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;totalDigits value="13"/&gt;
         *                         &lt;fractionDigits value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="13"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="13"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="13"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="13"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
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
            "serviceCharge",
            "piecemealPayment",
            "paymentRecalculation",
            "serviceInformation",
            "consumption",
            "multiplyingFactor",
            "municipalServiceIndividualConsumptionPayable",
            "municipalServiceCommunalConsumptionPayable",
            "amountOfPaymentMunicipalServiceIndividualConsumption",
            "amountOfPaymentMunicipalServiceCommunalConsumption"
        })
        public static class MunicipalService
            extends ServicePDType
        {

            @XmlElement(name = "ServiceCharge")
            protected ServiceChargeImportType serviceCharge;
            @XmlElement(name = "PiecemealPayment")
            protected ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment piecemealPayment;
            @XmlElement(name = "PaymentRecalculation")
            protected PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation paymentRecalculation;
            @XmlElement(name = "ServiceInformation")
            protected ru.gosuslugi.dom.schema.integration.bills.ServiceInformation serviceInformation;
            @XmlElement(name = "Consumption")
            protected PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption consumption;
            @XmlElement(name = "MultiplyingFactor")
            protected PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor multiplyingFactor;
            @XmlElement(name = "MunicipalServiceIndividualConsumptionPayable")
            protected BigDecimal municipalServiceIndividualConsumptionPayable;
            @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
            protected BigDecimal municipalServiceCommunalConsumptionPayable;
            @XmlElement(name = "AmountOfPaymentMunicipalServiceIndividualConsumption")
            protected BigDecimal amountOfPaymentMunicipalServiceIndividualConsumption;
            @XmlElement(name = "AmountOfPaymentMunicipalServiceCommunalConsumption")
            protected BigDecimal amountOfPaymentMunicipalServiceCommunalConsumption;

            /**
             * Gets the value of the serviceCharge property.
             * 
             * @return
             *     possible object is
             *     {@link ServiceChargeImportType }
             *     
             */
            public ServiceChargeImportType getServiceCharge() {
                return serviceCharge;
            }

            /**
             * Sets the value of the serviceCharge property.
             * 
             * @param value
             *     allowed object is
             *     {@link ServiceChargeImportType }
             *     
             */
            public void setServiceCharge(ServiceChargeImportType value) {
                this.serviceCharge = value;
            }

            /**
             * Рассрочка
             * 
             * @return
             *     possible object is
             *     {@link ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment }
             *     
             */
            public ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment getPiecemealPayment() {
                return piecemealPayment;
            }

            /**
             * Sets the value of the piecemealPayment property.
             * 
             * @param value
             *     allowed object is
             *     {@link ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment }
             *     
             */
            public void setPiecemealPayment(ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment value) {
                this.piecemealPayment = value;
            }

            /**
             * Gets the value of the paymentRecalculation property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation }
             *     
             */
            public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation getPaymentRecalculation() {
                return paymentRecalculation;
            }

            /**
             * Sets the value of the paymentRecalculation property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation }
             *     
             */
            public void setPaymentRecalculation(PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation value) {
                this.paymentRecalculation = value;
            }

            /**
             * Справочная информация
             * 
             * @return
             *     possible object is
             *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
             *     
             */
            public ru.gosuslugi.dom.schema.integration.bills.ServiceInformation getServiceInformation() {
                return serviceInformation;
            }

            /**
             * Sets the value of the serviceInformation property.
             * 
             * @param value
             *     allowed object is
             *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
             *     
             */
            public void setServiceInformation(ru.gosuslugi.dom.schema.integration.bills.ServiceInformation value) {
                this.serviceInformation = value;
            }

            /**
             * Gets the value of the consumption property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption }
             *     
             */
            public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption getConsumption() {
                return consumption;
            }

            /**
             * Sets the value of the consumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption }
             *     
             */
            public void setConsumption(PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption value) {
                this.consumption = value;
            }

            /**
             * Gets the value of the multiplyingFactor property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor }
             *     
             */
            public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor getMultiplyingFactor() {
                return multiplyingFactor;
            }

            /**
             * Sets the value of the multiplyingFactor property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor }
             *     
             */
            public void setMultiplyingFactor(PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor value) {
                this.multiplyingFactor = value;
            }

            /**
             * Gets the value of the municipalServiceIndividualConsumptionPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getMunicipalServiceIndividualConsumptionPayable() {
                return municipalServiceIndividualConsumptionPayable;
            }

            /**
             * Sets the value of the municipalServiceIndividualConsumptionPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setMunicipalServiceIndividualConsumptionPayable(BigDecimal value) {
                this.municipalServiceIndividualConsumptionPayable = value;
            }

            /**
             * Gets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getMunicipalServiceCommunalConsumptionPayable() {
                return municipalServiceCommunalConsumptionPayable;
            }

            /**
             * Sets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setMunicipalServiceCommunalConsumptionPayable(BigDecimal value) {
                this.municipalServiceCommunalConsumptionPayable = value;
            }

            /**
             * Gets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountOfPaymentMunicipalServiceIndividualConsumption() {
                return amountOfPaymentMunicipalServiceIndividualConsumption;
            }

            /**
             * Sets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountOfPaymentMunicipalServiceIndividualConsumption(BigDecimal value) {
                this.amountOfPaymentMunicipalServiceIndividualConsumption = value;
            }

            /**
             * Gets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountOfPaymentMunicipalServiceCommunalConsumption() {
                return amountOfPaymentMunicipalServiceCommunalConsumption;
            }

            /**
             * Sets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountOfPaymentMunicipalServiceCommunalConsumption(BigDecimal value) {
                this.amountOfPaymentMunicipalServiceCommunalConsumption = value;
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
             *         &lt;element name="Volume" maxOccurs="2"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
             *                 &lt;attribute name="type"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;enumeration value="I"/&gt;
             *                       &lt;enumeration value="O"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *                 &lt;attribute name="determiningMethod"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;length value="1"/&gt;
             *                       &lt;enumeration value="N"/&gt;
             *                       &lt;enumeration value="M"/&gt;
             *                       &lt;enumeration value="O"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/extension&gt;
             *             &lt;/simpleContent&gt;
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
                "volume"
            })
            public static class Consumption {

                @XmlElement(name = "Volume", required = true)
                protected List<PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume> volume;

                /**
                 * Gets the value of the volume property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the volume property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getVolume().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume }
                 * 
                 * 
                 */
                public List<PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume> getVolume() {
                    if (volume == null) {
                        volume = new ArrayList<PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume>();
                    }
                    return this.volume;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
                 *       &lt;attribute name="type"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;enumeration value="I"/&gt;
                 *             &lt;enumeration value="O"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *       &lt;attribute name="determiningMethod"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;length value="1"/&gt;
                 *             &lt;enumeration value="N"/&gt;
                 *             &lt;enumeration value="M"/&gt;
                 *             &lt;enumeration value="O"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/extension&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Volume {

                    @XmlValue
                    protected BigDecimal value;
                    @XmlAttribute(name = "type")
                    protected String type;
                    @XmlAttribute(name = "determiningMethod")
                    protected String determiningMethod;

                    /**
                     * Тип объема потребления КУ
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setValue(BigDecimal value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the type property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     * Sets the value of the type property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setType(String value) {
                        this.type = value;
                    }

                    /**
                     * Gets the value of the determiningMethod property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDeterminingMethod() {
                        return determiningMethod;
                    }

                    /**
                     * Sets the value of the determiningMethod property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDeterminingMethod(String value) {
                        this.determiningMethod = value;
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
             *         &lt;element name="Ratio"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;totalDigits value="5"/&gt;
             *               &lt;fractionDigits value="2"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;totalDigits value="13"/&gt;
             *               &lt;fractionDigits value="2"/&gt;
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
                "ratio",
                "amountOfExcessFees"
            })
            public static class MultiplyingFactor {

                @XmlElement(name = "Ratio", required = true)
                protected BigDecimal ratio;
                @XmlElement(name = "AmountOfExcessFees")
                protected BigDecimal amountOfExcessFees;

                /**
                 * Gets the value of the ratio property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getRatio() {
                    return ratio;
                }

                /**
                 * Sets the value of the ratio property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setRatio(BigDecimal value) {
                    this.ratio = value;
                }

                /**
                 * Gets the value of the amountOfExcessFees property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getAmountOfExcessFees() {
                    return amountOfExcessFees;
                }

                /**
                 * Sets the value of the amountOfExcessFees property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setAmountOfExcessFees(BigDecimal value) {
                    this.amountOfExcessFees = value;
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
             *         &lt;element name="recalculationReason"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="500"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="sum"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;fractionDigits value="2"/&gt;
             *               &lt;minInclusive value="-9999999999.99"/&gt;
             *               &lt;maxInclusive value="9999999999.99"/&gt;
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
                "recalculationReason",
                "sum"
            })
            public static class PaymentRecalculation {

                @XmlElement(required = true)
                protected String recalculationReason;
                @XmlElement(required = true)
                protected BigDecimal sum;

                /**
                 * Gets the value of the recalculationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRecalculationReason() {
                    return recalculationReason;
                }

                /**
                 * Sets the value of the recalculationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRecalculationReason(String value) {
                    this.recalculationReason = value;
                }

                /**
                 * Gets the value of the sum property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getSum() {
                    return sum;
                }

                /**
                 * Sets the value of the sum property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setSum(BigDecimal value) {
                    this.sum = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
     *       &lt;sequence minOccurs="0"&gt;
     *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
     *         &lt;element name="MunicipalResource" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *                   &lt;element name="Consumption" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Volume"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;simpleContent&gt;
     *                                   &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                                     &lt;attribute name="type"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;enumeration value="O"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                     &lt;attribute name="determiningMethod"&gt;
     *                                       &lt;simpleType&gt;
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                           &lt;length value="1"/&gt;
     *                                           &lt;enumeration value="N"/&gt;
     *                                           &lt;enumeration value="M"/&gt;
     *                                           &lt;enumeration value="O"/&gt;
     *                                         &lt;/restriction&gt;
     *                                       &lt;/simpleType&gt;
     *                                     &lt;/attribute&gt;
     *                                   &lt;/extension&gt;
     *                                 &lt;/simpleContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Rate" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="6"/&gt;
     *                         &lt;totalDigits value="14"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
     *                   &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ServiceInformation" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
     *                             &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
     *                             &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="recalculationReason"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="500"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="sum"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                   &lt;fractionDigits value="2"/&gt;
     *                                   &lt;minInclusive value="-9999999999.99"/&gt;
     *                                   &lt;maxInclusive value="9999999999.99"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="13"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TotalPayable" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
     *                   &lt;element name="GeneralMunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/bills/}GeneralMunicipalResourceExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="recalculationReason"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                         &lt;maxLength value="500"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="sum"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;minInclusive value="-9999999999.99"/&gt;
     *                         &lt;maxInclusive value="9999999999.99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
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
        "serviceCharge",
        "municipalResource",
        "paymentRecalculation"
    })
    public static class HousingService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected ServiceChargeType serviceCharge;
        @XmlElement(name = "MunicipalResource")
        protected List<PDServiceChargeExportType.HousingService.MunicipalResource> municipalResource;
        @XmlElement(name = "PaymentRecalculation")
        protected PDServiceChargeExportType.HousingService.PaymentRecalculation paymentRecalculation;

        /**
         * Gets the value of the serviceCharge property.
         * 
         * @return
         *     possible object is
         *     {@link ServiceChargeType }
         *     
         */
        public ServiceChargeType getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link ServiceChargeType }
         *     
         */
        public void setServiceCharge(ServiceChargeType value) {
            this.serviceCharge = value;
        }

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
         * {@link PDServiceChargeExportType.HousingService.MunicipalResource }
         * 
         * 
         */
        public List<PDServiceChargeExportType.HousingService.MunicipalResource> getMunicipalResource() {
            if (municipalResource == null) {
                municipalResource = new ArrayList<PDServiceChargeExportType.HousingService.MunicipalResource>();
            }
            return this.municipalResource;
        }

        /**
         * Gets the value of the paymentRecalculation property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.HousingService.PaymentRecalculation }
         *     
         */
        public PDServiceChargeExportType.HousingService.PaymentRecalculation getPaymentRecalculation() {
            return paymentRecalculation;
        }

        /**
         * Sets the value of the paymentRecalculation property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.HousingService.PaymentRecalculation }
         *     
         */
        public void setPaymentRecalculation(PDServiceChargeExportType.HousingService.PaymentRecalculation value) {
            this.paymentRecalculation = value;
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
         *         &lt;element name="Consumption" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Volume"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;simpleContent&gt;
         *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
         *                           &lt;attribute name="type"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;enumeration value="O"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                           &lt;attribute name="determiningMethod"&gt;
         *                             &lt;simpleType&gt;
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                 &lt;length value="1"/&gt;
         *                                 &lt;enumeration value="N"/&gt;
         *                                 &lt;enumeration value="M"/&gt;
         *                                 &lt;enumeration value="O"/&gt;
         *                               &lt;/restriction&gt;
         *                             &lt;/simpleType&gt;
         *                           &lt;/attribute&gt;
         *                         &lt;/extension&gt;
         *                       &lt;/simpleContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Rate" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="6"/&gt;
         *               &lt;totalDigits value="14"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AccountingPeriodTotal" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ServiceCharge" type="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType" minOccurs="0"/&gt;
         *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ServiceInformation" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
         *                   &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
         *                   &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="recalculationReason"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="500"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="sum"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;fractionDigits value="2"/&gt;
         *                         &lt;minInclusive value="-9999999999.99"/&gt;
         *                         &lt;maxInclusive value="9999999999.99"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="13"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TotalPayable" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="orgPPAGUID" type="{http://dom.gosuslugi.ru/schema/integration/base/}GUIDType" minOccurs="0"/&gt;
         *         &lt;element name="GeneralMunicipalResource" type="{http://dom.gosuslugi.ru/schema/integration/bills/}GeneralMunicipalResourceExportType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "consumption",
            "rate",
            "accountingPeriodTotal",
            "serviceCharge",
            "municipalServiceCommunalConsumptionPayable",
            "serviceInformation",
            "paymentRecalculation",
            "amountOfPaymentMunicipalServiceCommunalConsumption",
            "totalPayable",
            "orgPPAGUID",
            "generalMunicipalResource"
        })
        public static class MunicipalResource {

            @XmlElement(name = "ServiceType", required = true)
            protected NsiRef serviceType;
            @XmlElement(name = "Consumption")
            protected PDServiceChargeExportType.HousingService.MunicipalResource.Consumption consumption;
            @XmlElement(name = "Rate")
            protected BigDecimal rate;
            @XmlElement(name = "AccountingPeriodTotal")
            protected BigDecimal accountingPeriodTotal;
            @XmlElement(name = "ServiceCharge")
            protected ServiceChargeType serviceCharge;
            @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
            protected BigDecimal municipalServiceCommunalConsumptionPayable;
            @XmlElement(name = "ServiceInformation")
            protected PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation serviceInformation;
            @XmlElement(name = "PaymentRecalculation")
            protected PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation paymentRecalculation;
            @XmlElement(name = "AmountOfPaymentMunicipalServiceCommunalConsumption")
            protected BigDecimal amountOfPaymentMunicipalServiceCommunalConsumption;
            @XmlElement(name = "TotalPayable")
            protected BigDecimal totalPayable;
            protected String orgPPAGUID;
            @XmlElement(name = "GeneralMunicipalResource")
            protected List<GeneralMunicipalResourceExportType> generalMunicipalResource;

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
             * Gets the value of the consumption property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption }
             *     
             */
            public PDServiceChargeExportType.HousingService.MunicipalResource.Consumption getConsumption() {
                return consumption;
            }

            /**
             * Sets the value of the consumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption }
             *     
             */
            public void setConsumption(PDServiceChargeExportType.HousingService.MunicipalResource.Consumption value) {
                this.consumption = value;
            }

            /**
             * Gets the value of the rate property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRate() {
                return rate;
            }

            /**
             * Sets the value of the rate property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRate(BigDecimal value) {
                this.rate = value;
            }

            /**
             * Gets the value of the accountingPeriodTotal property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAccountingPeriodTotal() {
                return accountingPeriodTotal;
            }

            /**
             * Sets the value of the accountingPeriodTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAccountingPeriodTotal(BigDecimal value) {
                this.accountingPeriodTotal = value;
            }

            /**
             * Gets the value of the serviceCharge property.
             * 
             * @return
             *     possible object is
             *     {@link ServiceChargeType }
             *     
             */
            public ServiceChargeType getServiceCharge() {
                return serviceCharge;
            }

            /**
             * Sets the value of the serviceCharge property.
             * 
             * @param value
             *     allowed object is
             *     {@link ServiceChargeType }
             *     
             */
            public void setServiceCharge(ServiceChargeType value) {
                this.serviceCharge = value;
            }

            /**
             * Gets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getMunicipalServiceCommunalConsumptionPayable() {
                return municipalServiceCommunalConsumptionPayable;
            }

            /**
             * Sets the value of the municipalServiceCommunalConsumptionPayable property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setMunicipalServiceCommunalConsumptionPayable(BigDecimal value) {
                this.municipalServiceCommunalConsumptionPayable = value;
            }

            /**
             * Gets the value of the serviceInformation property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation }
             *     
             */
            public PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation getServiceInformation() {
                return serviceInformation;
            }

            /**
             * Sets the value of the serviceInformation property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation }
             *     
             */
            public void setServiceInformation(PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation value) {
                this.serviceInformation = value;
            }

            /**
             * Gets the value of the paymentRecalculation property.
             * 
             * @return
             *     possible object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation }
             *     
             */
            public PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation getPaymentRecalculation() {
                return paymentRecalculation;
            }

            /**
             * Sets the value of the paymentRecalculation property.
             * 
             * @param value
             *     allowed object is
             *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation }
             *     
             */
            public void setPaymentRecalculation(PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation value) {
                this.paymentRecalculation = value;
            }

            /**
             * Gets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountOfPaymentMunicipalServiceCommunalConsumption() {
                return amountOfPaymentMunicipalServiceCommunalConsumption;
            }

            /**
             * Sets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountOfPaymentMunicipalServiceCommunalConsumption(BigDecimal value) {
                this.amountOfPaymentMunicipalServiceCommunalConsumption = value;
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
             * {@link GeneralMunicipalResourceExportType }
             * 
             * 
             */
            public List<GeneralMunicipalResourceExportType> getGeneralMunicipalResource() {
                if (generalMunicipalResource == null) {
                    generalMunicipalResource = new ArrayList<GeneralMunicipalResourceExportType>();
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
             *         &lt;element name="Volume"&gt;
             *           &lt;complexType&gt;
             *             &lt;simpleContent&gt;
             *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
             *                 &lt;attribute name="type"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;enumeration value="O"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *                 &lt;attribute name="determiningMethod"&gt;
             *                   &lt;simpleType&gt;
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *                       &lt;length value="1"/&gt;
             *                       &lt;enumeration value="N"/&gt;
             *                       &lt;enumeration value="M"/&gt;
             *                       &lt;enumeration value="O"/&gt;
             *                     &lt;/restriction&gt;
             *                   &lt;/simpleType&gt;
             *                 &lt;/attribute&gt;
             *               &lt;/extension&gt;
             *             &lt;/simpleContent&gt;
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
                "volume"
            })
            public static class Consumption {

                @XmlElement(name = "Volume", required = true)
                protected PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume volume;

                /**
                 * Gets the value of the volume property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume }
                 *     
                 */
                public PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume getVolume() {
                    return volume;
                }

                /**
                 * Sets the value of the volume property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume }
                 *     
                 */
                public void setVolume(PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume value) {
                    this.volume = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;simpleContent&gt;
                 *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
                 *       &lt;attribute name="type"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;enumeration value="O"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *       &lt;attribute name="determiningMethod"&gt;
                 *         &lt;simpleType&gt;
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
                 *             &lt;length value="1"/&gt;
                 *             &lt;enumeration value="N"/&gt;
                 *             &lt;enumeration value="M"/&gt;
                 *             &lt;enumeration value="O"/&gt;
                 *           &lt;/restriction&gt;
                 *         &lt;/simpleType&gt;
                 *       &lt;/attribute&gt;
                 *     &lt;/extension&gt;
                 *   &lt;/simpleContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Volume {

                    @XmlValue
                    protected BigDecimal value;
                    @XmlAttribute(name = "type")
                    protected String type;
                    @XmlAttribute(name = "determiningMethod")
                    protected String determiningMethod;

                    /**
                     * Тип объема потребления КУ
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setValue(BigDecimal value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the type property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     * Sets the value of the type property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setType(String value) {
                        this.type = value;
                    }

                    /**
                     * Gets the value of the determiningMethod property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDeterminingMethod() {
                        return determiningMethod;
                    }

                    /**
                     * Sets the value of the determiningMethod property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDeterminingMethod(String value) {
                        this.determiningMethod = value;
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
             *         &lt;element name="recalculationReason"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="500"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="sum"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;fractionDigits value="2"/&gt;
             *               &lt;minInclusive value="-9999999999.99"/&gt;
             *               &lt;maxInclusive value="9999999999.99"/&gt;
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
                "recalculationReason",
                "sum"
            })
            public static class PaymentRecalculation {

                @XmlElement(required = true)
                protected String recalculationReason;
                @XmlElement(required = true)
                protected BigDecimal sum;

                /**
                 * Gets the value of the recalculationReason property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRecalculationReason() {
                    return recalculationReason;
                }

                /**
                 * Sets the value of the recalculationReason property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRecalculationReason(String value) {
                    this.recalculationReason = value;
                }

                /**
                 * Gets the value of the sum property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getSum() {
                    return sum;
                }

                /**
                 * Sets the value of the sum property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setSum(BigDecimal value) {
                    this.sum = value;
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
             *         &lt;element name="houseOverallNeedsNorm" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
             *         &lt;element name="houseOverallNeedsCurrentValue" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
             *         &lt;element name="houseTotalHouseOverallNeeds" type="{http://dom.gosuslugi.ru/schema/integration/bills/}VolumePDType" minOccurs="0"/&gt;
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
                "houseOverallNeedsNorm",
                "houseOverallNeedsCurrentValue",
                "houseTotalHouseOverallNeeds"
            })
            public static class ServiceInformation {

                protected BigDecimal houseOverallNeedsNorm;
                protected BigDecimal houseOverallNeedsCurrentValue;
                protected BigDecimal houseTotalHouseOverallNeeds;

                /**
                 * Gets the value of the houseOverallNeedsNorm property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getHouseOverallNeedsNorm() {
                    return houseOverallNeedsNorm;
                }

                /**
                 * Sets the value of the houseOverallNeedsNorm property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setHouseOverallNeedsNorm(BigDecimal value) {
                    this.houseOverallNeedsNorm = value;
                }

                /**
                 * Gets the value of the houseOverallNeedsCurrentValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getHouseOverallNeedsCurrentValue() {
                    return houseOverallNeedsCurrentValue;
                }

                /**
                 * Sets the value of the houseOverallNeedsCurrentValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setHouseOverallNeedsCurrentValue(BigDecimal value) {
                    this.houseOverallNeedsCurrentValue = value;
                }

                /**
                 * Gets the value of the houseTotalHouseOverallNeeds property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getHouseTotalHouseOverallNeeds() {
                    return houseTotalHouseOverallNeeds;
                }

                /**
                 * Sets the value of the houseTotalHouseOverallNeeds property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setHouseTotalHouseOverallNeeds(BigDecimal value) {
                    this.houseTotalHouseOverallNeeds = value;
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
         *         &lt;element name="recalculationReason"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;minLength value="1"/&gt;
         *               &lt;maxLength value="500"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="sum"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;minInclusive value="-9999999999.99"/&gt;
         *               &lt;maxInclusive value="9999999999.99"/&gt;
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
            "recalculationReason",
            "sum"
        })
        public static class PaymentRecalculation {

            @XmlElement(required = true)
            protected String recalculationReason;
            @XmlElement(required = true)
            protected BigDecimal sum;

            /**
             * Gets the value of the recalculationReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecalculationReason() {
                return recalculationReason;
            }

            /**
             * Sets the value of the recalculationReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecalculationReason(String value) {
                this.recalculationReason = value;
            }

            /**
             * Gets the value of the sum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSum() {
                return sum;
            }

            /**
             * Sets the value of the sum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSum(BigDecimal value) {
                this.sum = value;
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
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServicePDType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ServiceCharge" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType"&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PiecemealPayment" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="paymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="pastPaymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="piecemealPaymentPercentRub"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="piecemealPaymentPercent"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;minInclusive value="0"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;totalDigits value="5"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="piecemealPaymentSum"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PaymentRecalculation" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="recalculationReason"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;minLength value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="sum"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                         &lt;minInclusive value="-9999999999.99"/&gt;
     *                         &lt;maxInclusive value="9999999999.99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceInformation" minOccurs="0"/&gt;
     *         &lt;element name="Consumption" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Volume" maxOccurs="2"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
     *                           &lt;attribute name="type"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="I"/&gt;
     *                                 &lt;enumeration value="O"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                           &lt;attribute name="determiningMethod"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;length value="1"/&gt;
     *                                 &lt;enumeration value="N"/&gt;
     *                                 &lt;enumeration value="M"/&gt;
     *                                 &lt;enumeration value="O"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/simpleContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MultiplyingFactor" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Ratio"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="5"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                         &lt;fractionDigits value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MunicipalServiceIndividualConsumptionPayable" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="18"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MunicipalServiceCommunalConsumptionPayable" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="18"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AmountOfPaymentMunicipalServiceIndividualConsumption" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="18"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="AmountOfPaymentMunicipalServiceCommunalConsumption" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;totalDigits value="18"/&gt;
     *               &lt;fractionDigits value="2"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
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
        "serviceCharge",
        "piecemealPayment",
        "paymentRecalculation",
        "serviceInformation",
        "consumption",
        "multiplyingFactor",
        "municipalServiceIndividualConsumptionPayable",
        "municipalServiceCommunalConsumptionPayable",
        "amountOfPaymentMunicipalServiceIndividualConsumption",
        "amountOfPaymentMunicipalServiceCommunalConsumption"
    })
    public static class MunicipalService
        extends ServicePDType
    {

        @XmlElement(name = "ServiceCharge")
        protected PDServiceChargeExportType.MunicipalService.ServiceCharge serviceCharge;
        @XmlElement(name = "PiecemealPayment")
        protected PDServiceChargeExportType.MunicipalService.PiecemealPayment piecemealPayment;
        @XmlElement(name = "PaymentRecalculation")
        protected PDServiceChargeExportType.MunicipalService.PaymentRecalculation paymentRecalculation;
        @XmlElement(name = "ServiceInformation")
        protected ru.gosuslugi.dom.schema.integration.bills.ServiceInformation serviceInformation;
        @XmlElement(name = "Consumption")
        protected PDServiceChargeExportType.MunicipalService.Consumption consumption;
        @XmlElement(name = "MultiplyingFactor")
        protected PDServiceChargeExportType.MunicipalService.MultiplyingFactor multiplyingFactor;
        @XmlElement(name = "MunicipalServiceIndividualConsumptionPayable")
        protected BigDecimal municipalServiceIndividualConsumptionPayable;
        @XmlElement(name = "MunicipalServiceCommunalConsumptionPayable")
        protected BigDecimal municipalServiceCommunalConsumptionPayable;
        @XmlElement(name = "AmountOfPaymentMunicipalServiceIndividualConsumption")
        protected BigDecimal amountOfPaymentMunicipalServiceIndividualConsumption;
        @XmlElement(name = "AmountOfPaymentMunicipalServiceCommunalConsumption")
        protected BigDecimal amountOfPaymentMunicipalServiceCommunalConsumption;

        /**
         * Gets the value of the serviceCharge property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.MunicipalService.ServiceCharge }
         *     
         */
        public PDServiceChargeExportType.MunicipalService.ServiceCharge getServiceCharge() {
            return serviceCharge;
        }

        /**
         * Sets the value of the serviceCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.MunicipalService.ServiceCharge }
         *     
         */
        public void setServiceCharge(PDServiceChargeExportType.MunicipalService.ServiceCharge value) {
            this.serviceCharge = value;
        }

        /**
         * Gets the value of the piecemealPayment property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.MunicipalService.PiecemealPayment }
         *     
         */
        public PDServiceChargeExportType.MunicipalService.PiecemealPayment getPiecemealPayment() {
            return piecemealPayment;
        }

        /**
         * Sets the value of the piecemealPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.MunicipalService.PiecemealPayment }
         *     
         */
        public void setPiecemealPayment(PDServiceChargeExportType.MunicipalService.PiecemealPayment value) {
            this.piecemealPayment = value;
        }

        /**
         * Gets the value of the paymentRecalculation property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.MunicipalService.PaymentRecalculation }
         *     
         */
        public PDServiceChargeExportType.MunicipalService.PaymentRecalculation getPaymentRecalculation() {
            return paymentRecalculation;
        }

        /**
         * Sets the value of the paymentRecalculation property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.MunicipalService.PaymentRecalculation }
         *     
         */
        public void setPaymentRecalculation(PDServiceChargeExportType.MunicipalService.PaymentRecalculation value) {
            this.paymentRecalculation = value;
        }

        /**
         * Справочная информация
         * 
         * @return
         *     possible object is
         *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
         *     
         */
        public ru.gosuslugi.dom.schema.integration.bills.ServiceInformation getServiceInformation() {
            return serviceInformation;
        }

        /**
         * Sets the value of the serviceInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
         *     
         */
        public void setServiceInformation(ru.gosuslugi.dom.schema.integration.bills.ServiceInformation value) {
            this.serviceInformation = value;
        }

        /**
         * Gets the value of the consumption property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.MunicipalService.Consumption }
         *     
         */
        public PDServiceChargeExportType.MunicipalService.Consumption getConsumption() {
            return consumption;
        }

        /**
         * Sets the value of the consumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.MunicipalService.Consumption }
         *     
         */
        public void setConsumption(PDServiceChargeExportType.MunicipalService.Consumption value) {
            this.consumption = value;
        }

        /**
         * Gets the value of the multiplyingFactor property.
         * 
         * @return
         *     possible object is
         *     {@link PDServiceChargeExportType.MunicipalService.MultiplyingFactor }
         *     
         */
        public PDServiceChargeExportType.MunicipalService.MultiplyingFactor getMultiplyingFactor() {
            return multiplyingFactor;
        }

        /**
         * Sets the value of the multiplyingFactor property.
         * 
         * @param value
         *     allowed object is
         *     {@link PDServiceChargeExportType.MunicipalService.MultiplyingFactor }
         *     
         */
        public void setMultiplyingFactor(PDServiceChargeExportType.MunicipalService.MultiplyingFactor value) {
            this.multiplyingFactor = value;
        }

        /**
         * Gets the value of the municipalServiceIndividualConsumptionPayable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMunicipalServiceIndividualConsumptionPayable() {
            return municipalServiceIndividualConsumptionPayable;
        }

        /**
         * Sets the value of the municipalServiceIndividualConsumptionPayable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMunicipalServiceIndividualConsumptionPayable(BigDecimal value) {
            this.municipalServiceIndividualConsumptionPayable = value;
        }

        /**
         * Gets the value of the municipalServiceCommunalConsumptionPayable property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMunicipalServiceCommunalConsumptionPayable() {
            return municipalServiceCommunalConsumptionPayable;
        }

        /**
         * Sets the value of the municipalServiceCommunalConsumptionPayable property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMunicipalServiceCommunalConsumptionPayable(BigDecimal value) {
            this.municipalServiceCommunalConsumptionPayable = value;
        }

        /**
         * Gets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmountOfPaymentMunicipalServiceIndividualConsumption() {
            return amountOfPaymentMunicipalServiceIndividualConsumption;
        }

        /**
         * Sets the value of the amountOfPaymentMunicipalServiceIndividualConsumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmountOfPaymentMunicipalServiceIndividualConsumption(BigDecimal value) {
            this.amountOfPaymentMunicipalServiceIndividualConsumption = value;
        }

        /**
         * Gets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmountOfPaymentMunicipalServiceCommunalConsumption() {
            return amountOfPaymentMunicipalServiceCommunalConsumption;
        }

        /**
         * Sets the value of the amountOfPaymentMunicipalServiceCommunalConsumption property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmountOfPaymentMunicipalServiceCommunalConsumption(BigDecimal value) {
            this.amountOfPaymentMunicipalServiceCommunalConsumption = value;
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
         *         &lt;element name="Volume" maxOccurs="2"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
         *                 &lt;attribute name="type"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="I"/&gt;
         *                       &lt;enumeration value="O"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *                 &lt;attribute name="determiningMethod"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;length value="1"/&gt;
         *                       &lt;enumeration value="N"/&gt;
         *                       &lt;enumeration value="M"/&gt;
         *                       &lt;enumeration value="O"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
         *               &lt;/extension&gt;
         *             &lt;/simpleContent&gt;
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
            "volume"
        })
        public static class Consumption {

            @XmlElement(name = "Volume", required = true)
            protected List<PDServiceChargeExportType.MunicipalService.Consumption.Volume> volume;

            /**
             * Gets the value of the volume property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the volume property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVolume().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PDServiceChargeExportType.MunicipalService.Consumption.Volume }
             * 
             * 
             */
            public List<PDServiceChargeExportType.MunicipalService.Consumption.Volume> getVolume() {
                if (volume == null) {
                    volume = new ArrayList<PDServiceChargeExportType.MunicipalService.Consumption.Volume>();
                }
                return this.volume;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://dom.gosuslugi.ru/schema/integration/bills/&gt;ConsumptionVolumeType"&gt;
             *       &lt;attribute name="type"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="I"/&gt;
             *             &lt;enumeration value="O"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *       &lt;attribute name="determiningMethod"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;length value="1"/&gt;
             *             &lt;enumeration value="N"/&gt;
             *             &lt;enumeration value="M"/&gt;
             *             &lt;enumeration value="O"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
             *     &lt;/extension&gt;
             *   &lt;/simpleContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Volume {

                @XmlValue
                protected BigDecimal value;
                @XmlAttribute(name = "type")
                protected String type;
                @XmlAttribute(name = "determiningMethod")
                protected String determiningMethod;

                /**
                 * Тип объема потребления КУ
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValue(BigDecimal value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * Gets the value of the determiningMethod property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDeterminingMethod() {
                    return determiningMethod;
                }

                /**
                 * Sets the value of the determiningMethod property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDeterminingMethod(String value) {
                    this.determiningMethod = value;
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
         *         &lt;element name="Ratio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="5"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="AmountOfExcessFees" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
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
            "ratio",
            "amountOfExcessFees"
        })
        public static class MultiplyingFactor {

            @XmlElement(name = "Ratio", required = true)
            protected BigDecimal ratio;
            @XmlElement(name = "AmountOfExcessFees")
            protected BigDecimal amountOfExcessFees;

            /**
             * Gets the value of the ratio property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRatio() {
                return ratio;
            }

            /**
             * Sets the value of the ratio property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRatio(BigDecimal value) {
                this.ratio = value;
            }

            /**
             * Gets the value of the amountOfExcessFees property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmountOfExcessFees() {
                return amountOfExcessFees;
            }

            /**
             * Sets the value of the amountOfExcessFees property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmountOfExcessFees(BigDecimal value) {
                this.amountOfExcessFees = value;
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
         *         &lt;element name="recalculationReason"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;minLength value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="sum"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;minInclusive value="-9999999999.99"/&gt;
         *               &lt;maxInclusive value="9999999999.99"/&gt;
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
            "recalculationReason",
            "sum"
        })
        public static class PaymentRecalculation {

            @XmlElement(required = true)
            protected String recalculationReason;
            @XmlElement(required = true)
            protected BigDecimal sum;

            /**
             * Gets the value of the recalculationReason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecalculationReason() {
                return recalculationReason;
            }

            /**
             * Sets the value of the recalculationReason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecalculationReason(String value) {
                this.recalculationReason = value;
            }

            /**
             * Gets the value of the sum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSum() {
                return sum;
            }

            /**
             * Sets the value of the sum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSum(BigDecimal value) {
                this.sum = value;
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
         *         &lt;element name="paymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;totalDigits value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="pastPaymentPeriodPiecemealPaymentSum" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;totalDigits value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="piecemealPaymentPercentRub"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;totalDigits value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="piecemealPaymentPercent"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;minInclusive value="0"/&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;totalDigits value="5"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="piecemealPaymentSum"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *               &lt;fractionDigits value="2"/&gt;
         *               &lt;totalDigits value="18"/&gt;
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
            "paymentPeriodPiecemealPaymentSum",
            "pastPaymentPeriodPiecemealPaymentSum",
            "piecemealPaymentPercentRub",
            "piecemealPaymentPercent",
            "piecemealPaymentSum"
        })
        public static class PiecemealPayment {

            protected BigDecimal paymentPeriodPiecemealPaymentSum;
            protected BigDecimal pastPaymentPeriodPiecemealPaymentSum;
            @XmlElement(required = true)
            protected BigDecimal piecemealPaymentPercentRub;
            @XmlElement(required = true)
            protected BigDecimal piecemealPaymentPercent;
            @XmlElement(required = true)
            protected BigDecimal piecemealPaymentSum;

            /**
             * Gets the value of the paymentPeriodPiecemealPaymentSum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPaymentPeriodPiecemealPaymentSum() {
                return paymentPeriodPiecemealPaymentSum;
            }

            /**
             * Sets the value of the paymentPeriodPiecemealPaymentSum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPaymentPeriodPiecemealPaymentSum(BigDecimal value) {
                this.paymentPeriodPiecemealPaymentSum = value;
            }

            /**
             * Gets the value of the pastPaymentPeriodPiecemealPaymentSum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPastPaymentPeriodPiecemealPaymentSum() {
                return pastPaymentPeriodPiecemealPaymentSum;
            }

            /**
             * Sets the value of the pastPaymentPeriodPiecemealPaymentSum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPastPaymentPeriodPiecemealPaymentSum(BigDecimal value) {
                this.pastPaymentPeriodPiecemealPaymentSum = value;
            }

            /**
             * Gets the value of the piecemealPaymentPercentRub property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPiecemealPaymentPercentRub() {
                return piecemealPaymentPercentRub;
            }

            /**
             * Sets the value of the piecemealPaymentPercentRub property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPiecemealPaymentPercentRub(BigDecimal value) {
                this.piecemealPaymentPercentRub = value;
            }

            /**
             * Gets the value of the piecemealPaymentPercent property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPiecemealPaymentPercent() {
                return piecemealPaymentPercent;
            }

            /**
             * Sets the value of the piecemealPaymentPercent property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPiecemealPaymentPercent(BigDecimal value) {
                this.piecemealPaymentPercent = value;
            }

            /**
             * Gets the value of the piecemealPaymentSum property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPiecemealPaymentSum() {
                return piecemealPaymentSum;
            }

            /**
             * Sets the value of the piecemealPaymentSum property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPiecemealPaymentSum(BigDecimal value) {
                this.piecemealPaymentSum = value;
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
         *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}ServiceChargeType"&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ServiceCharge
            extends ServiceChargeType
        {


        }

    }

}
