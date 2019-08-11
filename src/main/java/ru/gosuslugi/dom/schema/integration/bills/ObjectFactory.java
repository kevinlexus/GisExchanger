
package ru.gosuslugi.dom.schema.integration.bills;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ru.gosuslugi.dom.schema.integration.payments_base.PaymentInformationType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.bills package. 
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

    private final static QName _InsuranceProductGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "InsuranceProductGUID");
    private final static QName _PaymentPeriodStatus_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "PaymentPeriodStatus");
    private final static QName _MoneyRecalculation_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "MoneyRecalculation");
    private final static QName _MoneyDiscount_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "MoneyDiscount");
    private final static QName _ServiceCharge_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "ServiceCharge");
    private final static QName _PaymentInformation_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "PaymentInformation");
    private final static QName _AckStatus_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/bills/", "AckStatus");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.bills
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest }
     * 
     */
    public ImportPaymentDocumentRequest createImportPaymentDocumentRequest() {
        return new ImportPaymentDocumentRequest();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionRequest }
     * 
     */
    public ExportNotificationsOfOrderExecutionRequest createExportNotificationsOfOrderExecutionRequest() {
        return new ExportNotificationsOfOrderExecutionRequest();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionPaginalRequest }
     * 
     */
    public ExportNotificationsOfOrderExecutionPaginalRequest createExportNotificationsOfOrderExecutionPaginalRequest() {
        return new ExportNotificationsOfOrderExecutionPaginalRequest();
    }

    /**
     * Create an instance of {@link ImportAcknowledgmentRequest }
     * 
     */
    public ImportAcknowledgmentRequest createImportAcknowledgmentRequest() {
        return new ImportAcknowledgmentRequest();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest }
     * 
     */
    public ImportRSOSettlementsRequest createImportRSOSettlementsRequest() {
        return new ImportRSOSettlementsRequest();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest }
     * 
     */
    public ImportIKUSettlementsRequest createImportIKUSettlementsRequest() {
        return new ImportIKUSettlementsRequest();
    }

    /**
     * Create an instance of {@link ExportSettlementsRequest }
     * 
     */
    public ExportSettlementsRequest createExportSettlementsRequest() {
        return new ExportSettlementsRequest();
    }

    /**
     * Create an instance of {@link ImportInsuranceProductRequest }
     * 
     */
    public ImportInsuranceProductRequest createImportInsuranceProductRequest() {
        return new ImportInsuranceProductRequest();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceExportType }
     * 
     */
    public GeneralMunicipalResourceExportType createGeneralMunicipalResourceExportType() {
        return new GeneralMunicipalResourceExportType();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceExportType.Consumption }
     * 
     */
    public GeneralMunicipalResourceExportType.Consumption createGeneralMunicipalResourceExportTypeConsumption() {
        return new GeneralMunicipalResourceExportType.Consumption();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceType }
     * 
     */
    public GeneralMunicipalResourceType createGeneralMunicipalResourceType() {
        return new GeneralMunicipalResourceType();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceType.Consumption }
     * 
     */
    public GeneralMunicipalResourceType.Consumption createGeneralMunicipalResourceTypeConsumption() {
        return new GeneralMunicipalResourceType.Consumption();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceExportType }
     * 
     */
    public TypeMunicipalServiceExportType createTypeMunicipalServiceExportType() {
        return new TypeMunicipalServiceExportType();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceExportType.Consumption }
     * 
     */
    public TypeMunicipalServiceExportType.Consumption createTypeMunicipalServiceExportTypeConsumption() {
        return new TypeMunicipalServiceExportType.Consumption();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceType }
     * 
     */
    public TypeMunicipalServiceType createTypeMunicipalServiceType() {
        return new TypeMunicipalServiceType();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceType.Consumption }
     * 
     */
    public TypeMunicipalServiceType.Consumption createTypeMunicipalServiceTypeConsumption() {
        return new TypeMunicipalServiceType.Consumption();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType }
     * 
     */
    public PaymentDocumentExportType createPaymentDocumentExportType() {
        return new PaymentDocumentExportType();
    }

    /**
     * Create an instance of {@link PDServiceDebtType }
     * 
     */
    public PDServiceDebtType createPDServiceDebtType() {
        return new PDServiceDebtType();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.GroupMunicipalService }
     * 
     */
    public PDServiceDebtType.GroupMunicipalService createPDServiceDebtTypeGroupMunicipalService() {
        return new PDServiceDebtType.GroupMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.HousingService }
     * 
     */
    public PDServiceDebtType.HousingService createPDServiceDebtTypeHousingService() {
        return new PDServiceDebtType.HousingService();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.HousingService.MunicipalResource }
     * 
     */
    public PDServiceDebtType.HousingService.MunicipalResource createPDServiceDebtTypeHousingServiceMunicipalResource() {
        return new PDServiceDebtType.HousingService.MunicipalResource();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.Insurance }
     * 
     */
    public PaymentDocumentExportType.Insurance createPaymentDocumentExportTypeInsurance() {
        return new PaymentDocumentExportType.Insurance();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.Insurance.Consumption }
     * 
     */
    public PaymentDocumentExportType.Insurance.Consumption createPaymentDocumentExportTypeInsuranceConsumption() {
        return new PaymentDocumentExportType.Insurance.Consumption();
    }

    /**
     * Create an instance of {@link CapitalRepairType }
     * 
     */
    public CapitalRepairType createCapitalRepairType() {
        return new CapitalRepairType();
    }

    /**
     * Create an instance of {@link PaymentDocumentType }
     * 
     */
    public PaymentDocumentType createPaymentDocumentType() {
        return new PaymentDocumentType();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.Insurance }
     * 
     */
    public PaymentDocumentType.Insurance createPaymentDocumentTypeInsurance() {
        return new PaymentDocumentType.Insurance();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.Insurance.Consumption }
     * 
     */
    public PaymentDocumentType.Insurance.Consumption createPaymentDocumentTypeInsuranceConsumption() {
        return new PaymentDocumentType.Insurance.Consumption();
    }

    /**
     * Create an instance of {@link CapitalRepairImportType }
     * 
     */
    public CapitalRepairImportType createCapitalRepairImportType() {
        return new CapitalRepairImportType();
    }

    /**
     * Create an instance of {@link PDServiceChargeType }
     * 
     */
    public PDServiceChargeType createPDServiceChargeType() {
        return new PDServiceChargeType();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService createPDServiceChargeTypeGroupMunicipalService() {
        return new PDServiceChargeType.GroupMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService.MunicipalService }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService.MunicipalService createPDServiceChargeTypeGroupMunicipalServiceMunicipalService() {
        return new PDServiceChargeType.GroupMunicipalService.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption createPDServiceChargeTypeGroupMunicipalServiceMunicipalServiceConsumption() {
        return new PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.MunicipalService }
     * 
     */
    public PDServiceChargeType.MunicipalService createPDServiceChargeTypeMunicipalService() {
        return new PDServiceChargeType.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.MunicipalService.Consumption }
     * 
     */
    public PDServiceChargeType.MunicipalService.Consumption createPDServiceChargeTypeMunicipalServiceConsumption() {
        return new PDServiceChargeType.MunicipalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.AdditionalService }
     * 
     */
    public PDServiceChargeType.AdditionalService createPDServiceChargeTypeAdditionalService() {
        return new PDServiceChargeType.AdditionalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.AdditionalService.Consumption }
     * 
     */
    public PDServiceChargeType.AdditionalService.Consumption createPDServiceChargeTypeAdditionalServiceConsumption() {
        return new PDServiceChargeType.AdditionalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService }
     * 
     */
    public PDServiceChargeType.HousingService createPDServiceChargeTypeHousingService() {
        return new PDServiceChargeType.HousingService();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.MunicipalResource }
     * 
     */
    public PDServiceChargeType.HousingService.MunicipalResource createPDServiceChargeTypeHousingServiceMunicipalResource() {
        return new PDServiceChargeType.HousingService.MunicipalResource();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption }
     * 
     */
    public PDServiceChargeType.HousingService.MunicipalResource.Consumption createPDServiceChargeTypeHousingServiceMunicipalResourceConsumption() {
        return new PDServiceChargeType.HousingService.MunicipalResource.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType }
     * 
     */
    public PDServiceDebtImportType createPDServiceDebtImportType() {
        return new PDServiceDebtImportType();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.GroupMunicipalService }
     * 
     */
    public PDServiceDebtImportType.GroupMunicipalService createPDServiceDebtImportTypeGroupMunicipalService() {
        return new PDServiceDebtImportType.GroupMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.HousingService }
     * 
     */
    public PDServiceDebtImportType.HousingService createPDServiceDebtImportTypeHousingService() {
        return new PDServiceDebtImportType.HousingService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.HousingService.MunicipalResource }
     * 
     */
    public PDServiceDebtImportType.HousingService.MunicipalResource createPDServiceDebtImportTypeHousingServiceMunicipalResource() {
        return new PDServiceDebtImportType.HousingService.MunicipalResource();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType }
     * 
     */
    public PDServiceChargeExportType createPDServiceChargeExportType() {
        return new PDServiceChargeExportType();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService createPDServiceChargeExportTypeGroupMunicipalService() {
        return new PDServiceChargeExportType.GroupMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService.MunicipalService createPDServiceChargeExportTypeGroupMunicipalServiceMunicipalService() {
        return new PDServiceChargeExportType.GroupMunicipalService.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption createPDServiceChargeExportTypeGroupMunicipalServiceMunicipalServiceConsumption() {
        return new PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService }
     * 
     */
    public PDServiceChargeExportType.MunicipalService createPDServiceChargeExportTypeMunicipalService() {
        return new PDServiceChargeExportType.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.Consumption }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.Consumption createPDServiceChargeExportTypeMunicipalServiceConsumption() {
        return new PDServiceChargeExportType.MunicipalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.AdditionalService }
     * 
     */
    public PDServiceChargeExportType.AdditionalService createPDServiceChargeExportTypeAdditionalService() {
        return new PDServiceChargeExportType.AdditionalService();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.AdditionalService.Consumption }
     * 
     */
    public PDServiceChargeExportType.AdditionalService.Consumption createPDServiceChargeExportTypeAdditionalServiceConsumption() {
        return new PDServiceChargeExportType.AdditionalService.Consumption();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService }
     * 
     */
    public PDServiceChargeExportType.HousingService createPDServiceChargeExportTypeHousingService() {
        return new PDServiceChargeExportType.HousingService();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.MunicipalResource }
     * 
     */
    public PDServiceChargeExportType.HousingService.MunicipalResource createPDServiceChargeExportTypeHousingServiceMunicipalResource() {
        return new PDServiceChargeExportType.HousingService.MunicipalResource();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption }
     * 
     */
    public PDServiceChargeExportType.HousingService.MunicipalResource.Consumption createPDServiceChargeExportTypeHousingServiceMunicipalResourceConsumption() {
        return new PDServiceChargeExportType.HousingService.MunicipalResource.Consumption();
    }

    /**
     * Create an instance of {@link CapitalRepairYearExportType }
     * 
     */
    public CapitalRepairYearExportType createCapitalRepairYearExportType() {
        return new CapitalRepairYearExportType();
    }

    /**
     * Create an instance of {@link CapitalRepairYearImportType }
     * 
     */
    public CapitalRepairYearImportType createCapitalRepairYearImportType() {
        return new CapitalRepairYearImportType();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType }
     * 
     */
    public ExportSettlementResultType createExportSettlementResultType() {
        return new ExportSettlementResultType();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType.ReportingPeriod }
     * 
     */
    public ExportSettlementResultType.ReportingPeriod createExportSettlementResultTypeReportingPeriod() {
        return new ExportSettlementResultType.ReportingPeriod();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType.Contract }
     * 
     */
    public ExportSettlementResultType.Contract createExportSettlementResultTypeContract() {
        return new ExportSettlementResultType.Contract();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionResultType }
     * 
     */
    public ExportNotificationsOfOrderExecutionResultType createExportNotificationsOfOrderExecutionResultType() {
        return new ExportNotificationsOfOrderExecutionResultType();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus }
     * 
     */
    public ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus createExportNotificationsOfOrderExecutionResultTypeNotificationOfOrderExecutionWithStatus() {
        return new ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList }
     * 
     */
    public ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList createExportNotificationsOfOrderExecutionResultTypeNotificationOfOrderExecutionWithStatusAcknowledgmentRequestsList() {
        return new ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList();
    }

    /**
     * Create an instance of {@link ExportPaymentDocumentResultType }
     * 
     */
    public ExportPaymentDocumentResultType createExportPaymentDocumentResultType() {
        return new ExportPaymentDocumentResultType();
    }

    /**
     * Create an instance of {@link ExportPaymentDocumentResultType.PaymentDocument }
     * 
     */
    public ExportPaymentDocumentResultType.PaymentDocument createExportPaymentDocumentResultTypePaymentDocument() {
        return new ExportPaymentDocumentResultType.PaymentDocument();
    }

    /**
     * Create an instance of {@link ImportInsuranceProductRequest.InsuranceProduct }
     * 
     */
    public ImportInsuranceProductRequest.InsuranceProduct createImportInsuranceProductRequestInsuranceProduct() {
        return new ImportInsuranceProductRequest.InsuranceProduct();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement createImportIKUSettlementsRequestImportSettlement() {
        return new ImportIKUSettlementsRequest.ImportSettlement();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement.Settlement createImportIKUSettlementsRequestImportSettlementSettlement() {
        return new ImportIKUSettlementsRequest.ImportSettlement.Settlement();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod createImportIKUSettlementsRequestImportSettlementSettlementReportingPeriod() {
        return new ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract createImportIKUSettlementsRequestImportSettlementSettlementContract() {
        return new ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest.ImportSettlement }
     * 
     */
    public ImportRSOSettlementsRequest.ImportSettlement createImportRSOSettlementsRequestImportSettlement() {
        return new ImportRSOSettlementsRequest.ImportSettlement();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest.ImportSettlement.Settlement }
     * 
     */
    public ImportRSOSettlementsRequest.ImportSettlement.Settlement createImportRSOSettlementsRequestImportSettlementSettlement() {
        return new ImportRSOSettlementsRequest.ImportSettlement.Settlement();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod }
     * 
     */
    public ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod createImportRSOSettlementsRequestImportSettlementSettlementReportingPeriod() {
        return new ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod();
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest.PaymentDocument }
     * 
     */
    public ImportPaymentDocumentRequest.PaymentDocument createImportPaymentDocumentRequestPaymentDocument() {
        return new ImportPaymentDocumentRequest.PaymentDocument();
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest.PaymentInformation }
     * 
     */
    public ImportPaymentDocumentRequest.PaymentInformation createImportPaymentDocumentRequestPaymentInformation() {
        return new ImportPaymentDocumentRequest.PaymentInformation();
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest.PaymentProviderInformation }
     * 
     */
    public ImportPaymentDocumentRequest.PaymentProviderInformation createImportPaymentDocumentRequestPaymentProviderInformation() {
        return new ImportPaymentDocumentRequest.PaymentProviderInformation();
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest.WithdrawPaymentDocument }
     * 
     */
    public ImportPaymentDocumentRequest.WithdrawPaymentDocument createImportPaymentDocumentRequestWithdrawPaymentDocument() {
        return new ImportPaymentDocumentRequest.WithdrawPaymentDocument();
    }

    /**
     * Create an instance of {@link ExportPaymentDocumentRequest }
     * 
     */
    public ExportPaymentDocumentRequest createExportPaymentDocumentRequest() {
        return new ExportPaymentDocumentRequest();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionRequest.SupplierIDs }
     * 
     */
    public ExportNotificationsOfOrderExecutionRequest.SupplierIDs createExportNotificationsOfOrderExecutionRequestSupplierIDs() {
        return new ExportNotificationsOfOrderExecutionRequest.SupplierIDs();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionRequest.Notifications }
     * 
     */
    public ExportNotificationsOfOrderExecutionRequest.Notifications createExportNotificationsOfOrderExecutionRequestNotifications() {
        return new ExportNotificationsOfOrderExecutionRequest.Notifications();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionPaginalRequest.SupplierIDs }
     * 
     */
    public ExportNotificationsOfOrderExecutionPaginalRequest.SupplierIDs createExportNotificationsOfOrderExecutionPaginalRequestSupplierIDs() {
        return new ExportNotificationsOfOrderExecutionPaginalRequest.SupplierIDs();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionPaginalRequest.Notifications }
     * 
     */
    public ExportNotificationsOfOrderExecutionPaginalRequest.Notifications createExportNotificationsOfOrderExecutionPaginalRequestNotifications() {
        return new ExportNotificationsOfOrderExecutionPaginalRequest.Notifications();
    }

    /**
     * Create an instance of {@link ImportAcknowledgmentRequest.AcknowledgmentRequestInfo }
     * 
     */
    public ImportAcknowledgmentRequest.AcknowledgmentRequestInfo createImportAcknowledgmentRequestAcknowledgmentRequestInfo() {
        return new ImportAcknowledgmentRequest.AcknowledgmentRequestInfo();
    }

    /**
     * Create an instance of {@link ImportAcknowledgmentRequest.AckCancellation }
     * 
     */
    public ImportAcknowledgmentRequest.AckCancellation createImportAcknowledgmentRequestAckCancellation() {
        return new ImportAcknowledgmentRequest.AckCancellation();
    }

    /**
     * Create an instance of {@link ExportSettlementsRequest.Period }
     * 
     */
    public ExportSettlementsRequest.Period createExportSettlementsRequestPeriod() {
        return new ExportSettlementsRequest.Period();
    }

    /**
     * Create an instance of {@link ExportInsuranceProductRequest }
     * 
     */
    public ExportInsuranceProductRequest createExportInsuranceProductRequest() {
        return new ExportInsuranceProductRequest();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link InsuranceProductType }
     * 
     */
    public InsuranceProductType createInsuranceProductType() {
        return new InsuranceProductType();
    }

    /**
     * Create an instance of {@link ServiceChargeType }
     * 
     */
    public ServiceChargeType createServiceChargeType() {
        return new ServiceChargeType();
    }

    /**
     * Create an instance of {@link ru.gosuslugi.dom.schema.integration.bills.ServiceInformation }
     * 
     */
    public ru.gosuslugi.dom.schema.integration.bills.ServiceInformation createServiceInformation() {
        return new ru.gosuslugi.dom.schema.integration.bills.ServiceInformation();
    }

    /**
     * Create an instance of {@link ServiceInformationType }
     * 
     */
    public ServiceInformationType createServiceInformationType() {
        return new ServiceInformationType();
    }

    /**
     * Create an instance of {@link ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment }
     * 
     */
    public ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment createPiecemealPayment() {
        return new ru.gosuslugi.dom.schema.integration.bills.PiecemealPayment();
    }

    /**
     * Create an instance of {@link ru.gosuslugi.dom.schema.integration.bills.PaymentRecalculation }
     * 
     */
    public ru.gosuslugi.dom.schema.integration.bills.PaymentRecalculation createPaymentRecalculation() {
        return new ru.gosuslugi.dom.schema.integration.bills.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PaymentPeriodType }
     * 
     */
    public PaymentPeriodType createPaymentPeriodType() {
        return new PaymentPeriodType();
    }

    /**
     * Create an instance of {@link HousePaymentPeriodType }
     * 
     */
    public HousePaymentPeriodType createHousePaymentPeriodType() {
        return new HousePaymentPeriodType();
    }

    /**
     * Create an instance of {@link DebtImportType }
     * 
     */
    public DebtImportType createDebtImportType() {
        return new DebtImportType();
    }

    /**
     * Create an instance of {@link DebtImportCRType }
     * 
     */
    public DebtImportCRType createDebtImportCRType() {
        return new DebtImportCRType();
    }

    /**
     * Create an instance of {@link ServicePDImportType }
     * 
     */
    public ServicePDImportType createServicePDImportType() {
        return new ServicePDImportType();
    }

    /**
     * Create an instance of {@link ServicePDType }
     * 
     */
    public ServicePDType createServicePDType() {
        return new ServicePDType();
    }

    /**
     * Create an instance of {@link DebtType }
     * 
     */
    public DebtType createDebtType() {
        return new DebtType();
    }

    /**
     * Create an instance of {@link ServiceDebtType }
     * 
     */
    public ServiceDebtType createServiceDebtType() {
        return new ServiceDebtType();
    }

    /**
     * Create an instance of {@link ServiceDebtImportType }
     * 
     */
    public ServiceDebtImportType createServiceDebtImportType() {
        return new ServiceDebtImportType();
    }

    /**
     * Create an instance of {@link MunicipalServicePDType }
     * 
     */
    public MunicipalServicePDType createMunicipalServicePDType() {
        return new MunicipalServicePDType();
    }

    /**
     * Create an instance of {@link ServiceChargeImportType }
     * 
     */
    public ServiceChargeImportType createServiceChargeImportType() {
        return new ServiceChargeImportType();
    }

    /**
     * Create an instance of {@link CapitalRepairMonthlyImportType }
     * 
     */
    public CapitalRepairMonthlyImportType createCapitalRepairMonthlyImportType() {
        return new CapitalRepairMonthlyImportType();
    }

    /**
     * Create an instance of {@link ReportPeriodRSOInfoType }
     * 
     */
    public ReportPeriodRSOInfoType createReportPeriodRSOInfoType() {
        return new ReportPeriodRSOInfoType();
    }

    /**
     * Create an instance of {@link ReportPeriodIKUInfoType }
     * 
     */
    public ReportPeriodIKUInfoType createReportPeriodIKUInfoType() {
        return new ReportPeriodIKUInfoType();
    }

    /**
     * Create an instance of {@link ReportPeriodType }
     * 
     */
    public ReportPeriodType createReportPeriodType() {
        return new ReportPeriodType();
    }

    /**
     * Create an instance of {@link AnnulmentType }
     * 
     */
    public AnnulmentType createAnnulmentType() {
        return new AnnulmentType();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceExportType.ServiceInformation }
     * 
     */
    public GeneralMunicipalResourceExportType.ServiceInformation createGeneralMunicipalResourceExportTypeServiceInformation() {
        return new GeneralMunicipalResourceExportType.ServiceInformation();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceExportType.PaymentRecalculation }
     * 
     */
    public GeneralMunicipalResourceExportType.PaymentRecalculation createGeneralMunicipalResourceExportTypePaymentRecalculation() {
        return new GeneralMunicipalResourceExportType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceExportType.Consumption.Volume }
     * 
     */
    public GeneralMunicipalResourceExportType.Consumption.Volume createGeneralMunicipalResourceExportTypeConsumptionVolume() {
        return new GeneralMunicipalResourceExportType.Consumption.Volume();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceType.PaymentRecalculation }
     * 
     */
    public GeneralMunicipalResourceType.PaymentRecalculation createGeneralMunicipalResourceTypePaymentRecalculation() {
        return new GeneralMunicipalResourceType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceType.ServiceInformation }
     * 
     */
    public GeneralMunicipalResourceType.ServiceInformation createGeneralMunicipalResourceTypeServiceInformation() {
        return new GeneralMunicipalResourceType.ServiceInformation();
    }

    /**
     * Create an instance of {@link GeneralMunicipalResourceType.Consumption.Volume }
     * 
     */
    public GeneralMunicipalResourceType.Consumption.Volume createGeneralMunicipalResourceTypeConsumptionVolume() {
        return new GeneralMunicipalResourceType.Consumption.Volume();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceExportType.MultiplyingFactor }
     * 
     */
    public TypeMunicipalServiceExportType.MultiplyingFactor createTypeMunicipalServiceExportTypeMultiplyingFactor() {
        return new TypeMunicipalServiceExportType.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceExportType.PaymentRecalculation }
     * 
     */
    public TypeMunicipalServiceExportType.PaymentRecalculation createTypeMunicipalServiceExportTypePaymentRecalculation() {
        return new TypeMunicipalServiceExportType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceExportType.Consumption.Volume }
     * 
     */
    public TypeMunicipalServiceExportType.Consumption.Volume createTypeMunicipalServiceExportTypeConsumptionVolume() {
        return new TypeMunicipalServiceExportType.Consumption.Volume();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceType.MultiplyingFactor }
     * 
     */
    public TypeMunicipalServiceType.MultiplyingFactor createTypeMunicipalServiceTypeMultiplyingFactor() {
        return new TypeMunicipalServiceType.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceType.PaymentRecalculation }
     * 
     */
    public TypeMunicipalServiceType.PaymentRecalculation createTypeMunicipalServiceTypePaymentRecalculation() {
        return new TypeMunicipalServiceType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link TypeMunicipalServiceType.Consumption.Volume }
     * 
     */
    public TypeMunicipalServiceType.Consumption.Volume createTypeMunicipalServiceTypeConsumptionVolume() {
        return new TypeMunicipalServiceType.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.AddressInfo }
     * 
     */
    public PaymentDocumentExportType.AddressInfo createPaymentDocumentExportTypeAddressInfo() {
        return new PaymentDocumentExportType.AddressInfo();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.CapitalRepairCharge }
     * 
     */
    public PaymentDocumentExportType.CapitalRepairCharge createPaymentDocumentExportTypeCapitalRepairCharge() {
        return new PaymentDocumentExportType.CapitalRepairCharge();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.PenaltiesAndCourtCosts }
     * 
     */
    public PaymentDocumentExportType.PenaltiesAndCourtCosts createPaymentDocumentExportTypePenaltiesAndCourtCosts() {
        return new PaymentDocumentExportType.PenaltiesAndCourtCosts();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.CapitalRepairDebt }
     * 
     */
    public PaymentDocumentExportType.CapitalRepairDebt createPaymentDocumentExportTypeCapitalRepairDebt() {
        return new PaymentDocumentExportType.CapitalRepairDebt();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.ChargeDebt }
     * 
     */
    public PaymentDocumentExportType.ChargeDebt createPaymentDocumentExportTypeChargeDebt() {
        return new PaymentDocumentExportType.ChargeDebt();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.ComponentsOfCost }
     * 
     */
    public PaymentDocumentExportType.ComponentsOfCost createPaymentDocumentExportTypeComponentsOfCost() {
        return new PaymentDocumentExportType.ComponentsOfCost();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.PaymentProviderInformation }
     * 
     */
    public PaymentDocumentExportType.PaymentProviderInformation createPaymentDocumentExportTypePaymentProviderInformation() {
        return new PaymentDocumentExportType.PaymentProviderInformation();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.AdditionalService }
     * 
     */
    public PDServiceDebtType.AdditionalService createPDServiceDebtTypeAdditionalService() {
        return new PDServiceDebtType.AdditionalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.MunicipalService }
     * 
     */
    public PDServiceDebtType.MunicipalService createPDServiceDebtTypeMunicipalService() {
        return new PDServiceDebtType.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.GroupMunicipalService.TypeMunicipalService }
     * 
     */
    public PDServiceDebtType.GroupMunicipalService.TypeMunicipalService createPDServiceDebtTypeGroupMunicipalServiceTypeMunicipalService() {
        return new PDServiceDebtType.GroupMunicipalService.TypeMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource }
     * 
     */
    public PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource createPDServiceDebtTypeHousingServiceMunicipalResourceGeneralMunicipalResource() {
        return new PDServiceDebtType.HousingService.MunicipalResource.GeneralMunicipalResource();
    }

    /**
     * Create an instance of {@link PaymentDocumentExportType.Insurance.Consumption.Volume }
     * 
     */
    public PaymentDocumentExportType.Insurance.Consumption.Volume createPaymentDocumentExportTypeInsuranceConsumptionVolume() {
        return new PaymentDocumentExportType.Insurance.Consumption.Volume();
    }

    /**
     * Create an instance of {@link CapitalRepairType.PaymentRecalculation }
     * 
     */
    public CapitalRepairType.PaymentRecalculation createCapitalRepairTypePaymentRecalculation() {
        return new CapitalRepairType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.ChargeInfo }
     * 
     */
    public PaymentDocumentType.ChargeInfo createPaymentDocumentTypeChargeInfo() {
        return new PaymentDocumentType.ChargeInfo();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.CapitalRepairCharge }
     * 
     */
    public PaymentDocumentType.CapitalRepairCharge createPaymentDocumentTypeCapitalRepairCharge() {
        return new PaymentDocumentType.CapitalRepairCharge();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.PenaltiesAndCourtCosts }
     * 
     */
    public PaymentDocumentType.PenaltiesAndCourtCosts createPaymentDocumentTypePenaltiesAndCourtCosts() {
        return new PaymentDocumentType.PenaltiesAndCourtCosts();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.ComponentsOfCost }
     * 
     */
    public PaymentDocumentType.ComponentsOfCost createPaymentDocumentTypeComponentsOfCost() {
        return new PaymentDocumentType.ComponentsOfCost();
    }

    /**
     * Create an instance of {@link PaymentDocumentType.Insurance.Consumption.Volume }
     * 
     */
    public PaymentDocumentType.Insurance.Consumption.Volume createPaymentDocumentTypeInsuranceConsumptionVolume() {
        return new PaymentDocumentType.Insurance.Consumption.Volume();
    }

    /**
     * Create an instance of {@link CapitalRepairImportType.PaymentRecalculation }
     * 
     */
    public CapitalRepairImportType.PaymentRecalculation createCapitalRepairImportTypePaymentRecalculation() {
        return new CapitalRepairImportType.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService.MunicipalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService.MunicipalService.PaymentRecalculation createPDServiceChargeTypeGroupMunicipalServiceMunicipalServicePaymentRecalculation() {
        return new PDServiceChargeType.GroupMunicipalService.MunicipalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService.MunicipalService.MultiplyingFactor }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService.MunicipalService.MultiplyingFactor createPDServiceChargeTypeGroupMunicipalServiceMunicipalServiceMultiplyingFactor() {
        return new PDServiceChargeType.GroupMunicipalService.MunicipalService.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption.Volume createPDServiceChargeTypeGroupMunicipalServiceMunicipalServiceConsumptionVolume() {
        return new PDServiceChargeType.GroupMunicipalService.MunicipalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.MunicipalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeType.MunicipalService.PaymentRecalculation createPDServiceChargeTypeMunicipalServicePaymentRecalculation() {
        return new PDServiceChargeType.MunicipalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.MunicipalService.MultiplyingFactor }
     * 
     */
    public PDServiceChargeType.MunicipalService.MultiplyingFactor createPDServiceChargeTypeMunicipalServiceMultiplyingFactor() {
        return new PDServiceChargeType.MunicipalService.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.MunicipalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeType.MunicipalService.Consumption.Volume createPDServiceChargeTypeMunicipalServiceConsumptionVolume() {
        return new PDServiceChargeType.MunicipalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.AdditionalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeType.AdditionalService.PaymentRecalculation createPDServiceChargeTypeAdditionalServicePaymentRecalculation() {
        return new PDServiceChargeType.AdditionalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.AdditionalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeType.AdditionalService.Consumption.Volume createPDServiceChargeTypeAdditionalServiceConsumptionVolume() {
        return new PDServiceChargeType.AdditionalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeType.HousingService.PaymentRecalculation createPDServiceChargeTypeHousingServicePaymentRecalculation() {
        return new PDServiceChargeType.HousingService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation }
     * 
     */
    public PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation createPDServiceChargeTypeHousingServiceMunicipalResourceServiceInformation() {
        return new PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.MunicipalResource.PaymentRecalculation }
     * 
     */
    public PDServiceChargeType.HousingService.MunicipalResource.PaymentRecalculation createPDServiceChargeTypeHousingServiceMunicipalResourcePaymentRecalculation() {
        return new PDServiceChargeType.HousingService.MunicipalResource.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume }
     * 
     */
    public PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume createPDServiceChargeTypeHousingServiceMunicipalResourceConsumptionVolume() {
        return new PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.AdditionalService }
     * 
     */
    public PDServiceDebtImportType.AdditionalService createPDServiceDebtImportTypeAdditionalService() {
        return new PDServiceDebtImportType.AdditionalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.MunicipalService }
     * 
     */
    public PDServiceDebtImportType.MunicipalService createPDServiceDebtImportTypeMunicipalService() {
        return new PDServiceDebtImportType.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.GroupMunicipalService.TypeMunicipalService }
     * 
     */
    public PDServiceDebtImportType.GroupMunicipalService.TypeMunicipalService createPDServiceDebtImportTypeGroupMunicipalServiceTypeMunicipalService() {
        return new PDServiceDebtImportType.GroupMunicipalService.TypeMunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.GroupMunicipalService.MunicipalService }
     * 
     */
    public PDServiceDebtImportType.GroupMunicipalService.MunicipalService createPDServiceDebtImportTypeGroupMunicipalServiceMunicipalService() {
        return new PDServiceDebtImportType.GroupMunicipalService.MunicipalService();
    }

    /**
     * Create an instance of {@link PDServiceDebtImportType.HousingService.MunicipalResource.GeneralMunicipalResource }
     * 
     */
    public PDServiceDebtImportType.HousingService.MunicipalResource.GeneralMunicipalResource createPDServiceDebtImportTypeHousingServiceMunicipalResourceGeneralMunicipalResource() {
        return new PDServiceDebtImportType.HousingService.MunicipalResource.GeneralMunicipalResource();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation createPDServiceChargeExportTypeGroupMunicipalServiceMunicipalServicePaymentRecalculation() {
        return new PDServiceChargeExportType.GroupMunicipalService.MunicipalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor createPDServiceChargeExportTypeGroupMunicipalServiceMunicipalServiceMultiplyingFactor() {
        return new PDServiceChargeExportType.GroupMunicipalService.MunicipalService.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume createPDServiceChargeExportTypeGroupMunicipalServiceMunicipalServiceConsumptionVolume() {
        return new PDServiceChargeExportType.GroupMunicipalService.MunicipalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.ServiceCharge }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.ServiceCharge createPDServiceChargeExportTypeMunicipalServiceServiceCharge() {
        return new PDServiceChargeExportType.MunicipalService.ServiceCharge();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.PiecemealPayment }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.PiecemealPayment createPDServiceChargeExportTypeMunicipalServicePiecemealPayment() {
        return new PDServiceChargeExportType.MunicipalService.PiecemealPayment();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.PaymentRecalculation createPDServiceChargeExportTypeMunicipalServicePaymentRecalculation() {
        return new PDServiceChargeExportType.MunicipalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.MultiplyingFactor }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.MultiplyingFactor createPDServiceChargeExportTypeMunicipalServiceMultiplyingFactor() {
        return new PDServiceChargeExportType.MunicipalService.MultiplyingFactor();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.MunicipalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeExportType.MunicipalService.Consumption.Volume createPDServiceChargeExportTypeMunicipalServiceConsumptionVolume() {
        return new PDServiceChargeExportType.MunicipalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.AdditionalService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeExportType.AdditionalService.PaymentRecalculation createPDServiceChargeExportTypeAdditionalServicePaymentRecalculation() {
        return new PDServiceChargeExportType.AdditionalService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.AdditionalService.Consumption.Volume }
     * 
     */
    public PDServiceChargeExportType.AdditionalService.Consumption.Volume createPDServiceChargeExportTypeAdditionalServiceConsumptionVolume() {
        return new PDServiceChargeExportType.AdditionalService.Consumption.Volume();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.PaymentRecalculation }
     * 
     */
    public PDServiceChargeExportType.HousingService.PaymentRecalculation createPDServiceChargeExportTypeHousingServicePaymentRecalculation() {
        return new PDServiceChargeExportType.HousingService.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation }
     * 
     */
    public PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation createPDServiceChargeExportTypeHousingServiceMunicipalResourceServiceInformation() {
        return new PDServiceChargeExportType.HousingService.MunicipalResource.ServiceInformation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation }
     * 
     */
    public PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation createPDServiceChargeExportTypeHousingServiceMunicipalResourcePaymentRecalculation() {
        return new PDServiceChargeExportType.HousingService.MunicipalResource.PaymentRecalculation();
    }

    /**
     * Create an instance of {@link PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume }
     * 
     */
    public PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume createPDServiceChargeExportTypeHousingServiceMunicipalResourceConsumptionVolume() {
        return new PDServiceChargeExportType.HousingService.MunicipalResource.Consumption.Volume();
    }

    /**
     * Create an instance of {@link CapitalRepairYearExportType.CapitalRepairMonthlyCharge }
     * 
     */
    public CapitalRepairYearExportType.CapitalRepairMonthlyCharge createCapitalRepairYearExportTypeCapitalRepairMonthlyCharge() {
        return new CapitalRepairYearExportType.CapitalRepairMonthlyCharge();
    }

    /**
     * Create an instance of {@link CapitalRepairYearImportType.CapitalRepairMonthlyCharge }
     * 
     */
    public CapitalRepairYearImportType.CapitalRepairMonthlyCharge createCapitalRepairYearImportTypeCapitalRepairMonthlyCharge() {
        return new CapitalRepairYearImportType.CapitalRepairMonthlyCharge();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType.Annuled }
     * 
     */
    public ExportSettlementResultType.Annuled createExportSettlementResultTypeAnnuled() {
        return new ExportSettlementResultType.Annuled();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus }
     * 
     */
    public ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus createExportSettlementResultTypeReportingPeriodReportPeriodStatus() {
        return new ExportSettlementResultType.ReportingPeriod.ReportPeriodStatus();
    }

    /**
     * Create an instance of {@link ExportSettlementResultType.Contract.NoContract }
     * 
     */
    public ExportSettlementResultType.Contract.NoContract createExportSettlementResultTypeContractNoContract() {
        return new ExportSettlementResultType.Contract.NoContract();
    }

    /**
     * Create an instance of {@link ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest }
     * 
     */
    public ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest createExportNotificationsOfOrderExecutionResultTypeNotificationOfOrderExecutionWithStatusAcknowledgmentRequestsListAcknowledgmentRequest() {
        return new ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus.AcknowledgmentRequestsList.AcknowledgmentRequest();
    }

    /**
     * Create an instance of {@link ExportPaymentDocumentResultType.PaymentDocument.PaymentInformation }
     * 
     */
    public ExportPaymentDocumentResultType.PaymentDocument.PaymentInformation createExportPaymentDocumentResultTypePaymentDocumentPaymentInformation() {
        return new ExportPaymentDocumentResultType.PaymentDocument.PaymentInformation();
    }

    /**
     * Create an instance of {@link ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate }
     * 
     */
    public ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate createImportInsuranceProductRequestInsuranceProductCreateOrUpdate() {
        return new ImportInsuranceProductRequest.InsuranceProduct.CreateOrUpdate();
    }

    /**
     * Create an instance of {@link ImportInsuranceProductRequest.InsuranceProduct.Remove }
     * 
     */
    public ImportInsuranceProductRequest.InsuranceProduct.Remove createImportInsuranceProductRequestInsuranceProductRemove() {
        return new ImportInsuranceProductRequest.InsuranceProduct.Remove();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod createImportIKUSettlementsRequestImportSettlementSettlementReportingPeriodAnnulmentReportingPeriod() {
        return new ImportIKUSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod();
    }

    /**
     * Create an instance of {@link ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract }
     * 
     */
    public ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract createImportIKUSettlementsRequestImportSettlementSettlementContractNoContract() {
        return new ImportIKUSettlementsRequest.ImportSettlement.Settlement.Contract.NoContract();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest.ImportSettlement.Settlement.Contract }
     * 
     */
    public ImportRSOSettlementsRequest.ImportSettlement.Settlement.Contract createImportRSOSettlementsRequestImportSettlementSettlementContract() {
        return new ImportRSOSettlementsRequest.ImportSettlement.Settlement.Contract();
    }

    /**
     * Create an instance of {@link ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod }
     * 
     */
    public ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod createImportRSOSettlementsRequestImportSettlementSettlementReportingPeriodAnnulmentReportingPeriod() {
        return new ImportRSOSettlementsRequest.ImportSettlement.Settlement.ReportingPeriod.AnnulmentReportingPeriod();
    }

    /**
     * Create an instance of {@link ImportPaymentDocumentRequest.PaymentDocument.DetailsPaymentInformation }
     * 
     */
    public ImportPaymentDocumentRequest.PaymentDocument.DetailsPaymentInformation createImportPaymentDocumentRequestPaymentDocumentDetailsPaymentInformation() {
        return new ImportPaymentDocumentRequest.PaymentDocument.DetailsPaymentInformation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "InsuranceProductGUID")
    public JAXBElement<String> createInsuranceProductGUID(String value) {
        return new JAXBElement<String>(_InsuranceProductGUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "PaymentPeriodStatus")
    public JAXBElement<String> createPaymentPeriodStatus(String value) {
        return new JAXBElement<String>(_PaymentPeriodStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "MoneyRecalculation")
    public JAXBElement<BigDecimal> createMoneyRecalculation(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MoneyRecalculation_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "MoneyDiscount")
    public JAXBElement<BigDecimal> createMoneyDiscount(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_MoneyDiscount_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "ServiceCharge")
    public JAXBElement<ServiceChargeType> createServiceCharge(ServiceChargeType value) {
        return new JAXBElement<ServiceChargeType>(_ServiceCharge_QNAME, ServiceChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "PaymentInformation")
    public JAXBElement<PaymentInformationType> createPaymentInformation(PaymentInformationType value) {
        return new JAXBElement<PaymentInformationType>(_PaymentInformation_QNAME, PaymentInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/bills/", name = "AckStatus")
    public JAXBElement<Byte> createAckStatus(Byte value) {
        return new JAXBElement<Byte>(_AckStatus_QNAME, Byte.class, null, value);
    }

}
