
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.volume_quality package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Status_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/volume-quality/", "Status");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.volume_quality
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportIntervalRequest }
     * 
     */
    public ImportIntervalRequest createImportIntervalRequest() {
        return new ImportIntervalRequest();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest }
     * 
     */
    public ImportVolumeAndQualityInformationRequest createImportVolumeAndQualityInformationRequest() {
        return new ImportVolumeAndQualityInformationRequest();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType }
     * 
     */
    public NotConformityTemperatureHotWaterType createNotConformityTemperatureHotWaterType() {
        return new NotConformityTemperatureHotWaterType();
    }

    /**
     * Create an instance of {@link VolumeResourcesType }
     * 
     */
    public VolumeResourcesType createVolumeResourcesType() {
        return new VolumeResourcesType();
    }

    /**
     * Create an instance of {@link QualityResourcesType }
     * 
     */
    public QualityResourcesType createQualityResourcesType() {
        return new QualityResourcesType();
    }

    /**
     * Create an instance of {@link QualityServicesType }
     * 
     */
    public QualityServicesType createQualityServicesType() {
        return new QualityServicesType();
    }

    /**
     * Create an instance of {@link QualityServicesType.Heating }
     * 
     */
    public QualityServicesType.Heating createQualityServicesTypeHeating() {
        return new QualityServicesType.Heating();
    }

    /**
     * Create an instance of {@link QualityServicesType.Heating.HeatingConformity }
     * 
     */
    public QualityServicesType.Heating.HeatingConformity createQualityServicesTypeHeatingHeatingConformity() {
        return new QualityServicesType.Heating.HeatingConformity();
    }

    /**
     * Create an instance of {@link QualityServicesType.Gas }
     * 
     */
    public QualityServicesType.Gas createQualityServicesTypeGas() {
        return new QualityServicesType.Gas();
    }

    /**
     * Create an instance of {@link QualityServicesType.Electricity }
     * 
     */
    public QualityServicesType.Electricity createQualityServicesTypeElectricity() {
        return new QualityServicesType.Electricity();
    }

    /**
     * Create an instance of {@link QualityServicesType.HotWater }
     * 
     */
    public QualityServicesType.HotWater createQualityServicesTypeHotWater() {
        return new QualityServicesType.HotWater();
    }

    /**
     * Create an instance of {@link QualityServicesType.ColdWater }
     * 
     */
    public QualityServicesType.ColdWater createQualityServicesTypeColdWater() {
        return new QualityServicesType.ColdWater();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformation() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationDeleteAddressObject() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationRegistrationPeriodInformation() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation();
    }

    /**
     * Create an instance of {@link ImportIntervalRequest.ImportInterval }
     * 
     */
    public ImportIntervalRequest.ImportInterval createImportIntervalRequestImportInterval() {
        return new ImportIntervalRequest.ImportInterval();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link IntervalType }
     * 
     */
    public IntervalType createIntervalType() {
        return new IntervalType();
    }

    /**
     * Create an instance of {@link RegistrationPeriodType }
     * 
     */
    public RegistrationPeriodType createRegistrationPeriodType() {
        return new RegistrationPeriodType();
    }

    /**
     * Create an instance of {@link OtherQualityIndicatorType }
     * 
     */
    public OtherQualityIndicatorType createOtherQualityIndicatorType() {
        return new OtherQualityIndicatorType();
    }

    /**
     * Create an instance of {@link VolumeNotEnergyResourceType }
     * 
     */
    public VolumeNotEnergyResourceType createVolumeNotEnergyResourceType() {
        return new VolumeNotEnergyResourceType();
    }

    /**
     * Create an instance of {@link VolumeEnergyResourceType }
     * 
     */
    public VolumeEnergyResourceType createVolumeEnergyResourceType() {
        return new VolumeEnergyResourceType();
    }

    /**
     * Create an instance of {@link AddressObjectType }
     * 
     */
    public AddressObjectType createAddressObjectType() {
        return new AddressObjectType();
    }

    /**
     * Create an instance of {@link BaseType }
     * 
     */
    public BaseType createBaseType() {
        return new BaseType();
    }

    /**
     * Create an instance of {@link ObjectAddressType }
     * 
     */
    public ObjectAddressType createObjectAddressType() {
        return new ObjectAddressType();
    }

    /**
     * Create an instance of {@link IndicatorValueType }
     * 
     */
    public IndicatorValueType createIndicatorValueType() {
        return new IndicatorValueType();
    }

    /**
     * Create an instance of {@link BaseShortType }
     * 
     */
    public BaseShortType createBaseShortType() {
        return new BaseShortType();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation3 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation3 createNotConformityTemperatureHotWaterTypeDeviation3() {
        return new NotConformityTemperatureHotWaterType.Deviation3();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation6 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation6 createNotConformityTemperatureHotWaterTypeDeviation6() {
        return new NotConformityTemperatureHotWaterType.Deviation6();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation9 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation9 createNotConformityTemperatureHotWaterTypeDeviation9() {
        return new NotConformityTemperatureHotWaterType.Deviation9();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation12 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation12 createNotConformityTemperatureHotWaterTypeDeviation12() {
        return new NotConformityTemperatureHotWaterType.Deviation12();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation15 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation15 createNotConformityTemperatureHotWaterTypeDeviation15() {
        return new NotConformityTemperatureHotWaterType.Deviation15();
    }

    /**
     * Create an instance of {@link NotConformityTemperatureHotWaterType.Deviation18 }
     * 
     */
    public NotConformityTemperatureHotWaterType.Deviation18 createNotConformityTemperatureHotWaterTypeDeviation18() {
        return new NotConformityTemperatureHotWaterType.Deviation18();
    }

    /**
     * Create an instance of {@link VolumeResourcesType.ObjectAddress }
     * 
     */
    public VolumeResourcesType.ObjectAddress createVolumeResourcesTypeObjectAddress() {
        return new VolumeResourcesType.ObjectAddress();
    }

    /**
     * Create an instance of {@link VolumeResourcesType.ServiceType }
     * 
     */
    public VolumeResourcesType.ServiceType createVolumeResourcesTypeServiceType() {
        return new VolumeResourcesType.ServiceType();
    }

    /**
     * Create an instance of {@link VolumeResourcesType.MunicipalResource }
     * 
     */
    public VolumeResourcesType.MunicipalResource createVolumeResourcesTypeMunicipalResource() {
        return new VolumeResourcesType.MunicipalResource();
    }

    /**
     * Create an instance of {@link QualityResourcesType.ObjectAddress }
     * 
     */
    public QualityResourcesType.ObjectAddress createQualityResourcesTypeObjectAddress() {
        return new QualityResourcesType.ObjectAddress();
    }

    /**
     * Create an instance of {@link QualityResourcesType.ServiceType }
     * 
     */
    public QualityResourcesType.ServiceType createQualityResourcesTypeServiceType() {
        return new QualityResourcesType.ServiceType();
    }

    /**
     * Create an instance of {@link QualityResourcesType.MunicipalResource }
     * 
     */
    public QualityResourcesType.MunicipalResource createQualityResourcesTypeMunicipalResource() {
        return new QualityResourcesType.MunicipalResource();
    }

    /**
     * Create an instance of {@link QualityResourcesType.QualityIndicatorResource }
     * 
     */
    public QualityResourcesType.QualityIndicatorResource createQualityResourcesTypeQualityIndicatorResource() {
        return new QualityResourcesType.QualityIndicatorResource();
    }

    /**
     * Create an instance of {@link QualityResourcesType.OtherQualityIndicatorResource }
     * 
     */
    public QualityResourcesType.OtherQualityIndicatorResource createQualityResourcesTypeOtherQualityIndicatorResource() {
        return new QualityResourcesType.OtherQualityIndicatorResource();
    }

    /**
     * Create an instance of {@link QualityServicesType.ObjectAddress }
     * 
     */
    public QualityServicesType.ObjectAddress createQualityServicesTypeObjectAddress() {
        return new QualityServicesType.ObjectAddress();
    }

    /**
     * Create an instance of {@link QualityServicesType.Heating.HeatingConformity.NotConformityTemperature }
     * 
     */
    public QualityServicesType.Heating.HeatingConformity.NotConformityTemperature createQualityServicesTypeHeatingHeatingConformityNotConformityTemperature() {
        return new QualityServicesType.Heating.HeatingConformity.NotConformityTemperature();
    }

    /**
     * Create an instance of {@link QualityServicesType.Gas.GasConformity }
     * 
     */
    public QualityServicesType.Gas.GasConformity createQualityServicesTypeGasGasConformity() {
        return new QualityServicesType.Gas.GasConformity();
    }

    /**
     * Create an instance of {@link QualityServicesType.Electricity.ElectricityConformity }
     * 
     */
    public QualityServicesType.Electricity.ElectricityConformity createQualityServicesTypeElectricityElectricityConformity() {
        return new QualityServicesType.Electricity.ElectricityConformity();
    }

    /**
     * Create an instance of {@link QualityServicesType.HotWater.TemperatureConformity }
     * 
     */
    public QualityServicesType.HotWater.TemperatureConformity createQualityServicesTypeHotWaterTemperatureConformity() {
        return new QualityServicesType.HotWater.TemperatureConformity();
    }

    /**
     * Create an instance of {@link QualityServicesType.HotWater.HotWaterConformity }
     * 
     */
    public QualityServicesType.HotWater.HotWaterConformity createQualityServicesTypeHotWaterHotWaterConformity() {
        return new QualityServicesType.HotWater.HotWaterConformity();
    }

    /**
     * Create an instance of {@link QualityServicesType.ColdWater.ColdWaterConformity }
     * 
     */
    public QualityServicesType.ColdWater.ColdWaterConformity createQualityServicesTypeColdWaterColdWaterConformity() {
        return new QualityServicesType.ColdWater.ColdWaterConformity();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationBase() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.Base();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationAnnulmentRegistrationPeriod() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.AnnulmentRegistrationPeriod();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationDeleteAddressObjectObjectAddress() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.DeleteAddressObject.ObjectAddress();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationRegistrationPeriodInformationQualityResources() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityResources();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationRegistrationPeriodInformationQualityServices() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.QualityServices();
    }

    /**
     * Create an instance of {@link ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources }
     * 
     */
    public ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources createImportVolumeAndQualityInformationRequestImportVolumeAndQualityInformationRegistrationPeriodInformationVolumeResources() {
        return new ImportVolumeAndQualityInformationRequest.ImportVolumeAndQualityInformation.RegistrationPeriodInformation.VolumeResources();
    }

    /**
     * Create an instance of {@link ImportIntervalRequest.ImportInterval.AnnulmentInterval }
     * 
     */
    public ImportIntervalRequest.ImportInterval.AnnulmentInterval createImportIntervalRequestImportIntervalAnnulmentInterval() {
        return new ImportIntervalRequest.ImportInterval.AnnulmentInterval();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/volume-quality/", name = "Status")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createStatus(String value) {
        return new JAXBElement<String>(_Status_QNAME, String.class, null, value);
    }

}
