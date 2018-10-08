
package ru.gosuslugi.dom.schema.integration.uk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gosuslugi.dom.schema.integration.uk package. 
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

    private final static QName _DocumentGUID_QNAME = new QName("http://dom.gosuslugi.ru/schema/integration/uk/", "DocumentGUID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gosuslugi.dom.schema.integration.uk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportDocumentRegionRequest }
     * 
     */
    public ImportDocumentRegionRequest createImportDocumentRegionRequest() {
        return new ImportDocumentRegionRequest();
    }

    /**
     * Create an instance of {@link ImportDocumentMunicipalRequest }
     * 
     */
    public ImportDocumentMunicipalRequest createImportDocumentMunicipalRequest() {
        return new ImportDocumentMunicipalRequest();
    }

    /**
     * Create an instance of {@link DocumentFederalExportType }
     * 
     */
    public DocumentFederalExportType createDocumentFederalExportType() {
        return new DocumentFederalExportType();
    }

    /**
     * Create an instance of {@link DocumentFederalType }
     * 
     */
    public DocumentFederalType createDocumentFederalType() {
        return new DocumentFederalType();
    }

    /**
     * Create an instance of {@link ImportDocumentMunicipalRequest.Document }
     * 
     */
    public ImportDocumentMunicipalRequest.Document createImportDocumentMunicipalRequestDocument() {
        return new ImportDocumentMunicipalRequest.Document();
    }

    /**
     * Create an instance of {@link ImportDocumentRegionRequest.Document }
     * 
     */
    public ImportDocumentRegionRequest.Document createImportDocumentRegionRequestDocument() {
        return new ImportDocumentRegionRequest.Document();
    }

    /**
     * Create an instance of {@link ExportDocumentRequest }
     * 
     */
    public ExportDocumentRequest createExportDocumentRequest() {
        return new ExportDocumentRequest();
    }

    /**
     * Create an instance of {@link ExportDocumentResult }
     * 
     */
    public ExportDocumentResult createExportDocumentResult() {
        return new ExportDocumentResult();
    }

    /**
     * Create an instance of {@link ExportDocumentType }
     * 
     */
    public ExportDocumentType createExportDocumentType() {
        return new ExportDocumentType();
    }

    /**
     * Create an instance of {@link GetStateResult }
     * 
     */
    public GetStateResult createGetStateResult() {
        return new GetStateResult();
    }

    /**
     * Create an instance of {@link DocumentPortalType }
     * 
     */
    public DocumentPortalType createDocumentPortalType() {
        return new DocumentPortalType();
    }

    /**
     * Create an instance of {@link DocumentPortalExportType }
     * 
     */
    public DocumentPortalExportType createDocumentPortalExportType() {
        return new DocumentPortalExportType();
    }

    /**
     * Create an instance of {@link DocumentMunicipalType }
     * 
     */
    public DocumentMunicipalType createDocumentMunicipalType() {
        return new DocumentMunicipalType();
    }

    /**
     * Create an instance of {@link DocumentMunicipalExportType }
     * 
     */
    public DocumentMunicipalExportType createDocumentMunicipalExportType() {
        return new DocumentMunicipalExportType();
    }

    /**
     * Create an instance of {@link DocumentRegionType }
     * 
     */
    public DocumentRegionType createDocumentRegionType() {
        return new DocumentRegionType();
    }

    /**
     * Create an instance of {@link DocumentRegionExportType }
     * 
     */
    public DocumentRegionExportType createDocumentRegionExportType() {
        return new DocumentRegionExportType();
    }

    /**
     * Create an instance of {@link DocumentFederalExportType.Audience }
     * 
     */
    public DocumentFederalExportType.Audience createDocumentFederalExportTypeAudience() {
        return new DocumentFederalExportType.Audience();
    }

    /**
     * Create an instance of {@link DocumentFederalType.Аudience }
     * 
     */
    public DocumentFederalType.Аudience createDocumentFederalTypeАudience() {
        return new DocumentFederalType.Аudience();
    }

    /**
     * Create an instance of {@link ImportDocumentMunicipalRequest.Document.ImportDocument }
     * 
     */
    public ImportDocumentMunicipalRequest.Document.ImportDocument createImportDocumentMunicipalRequestDocumentImportDocument() {
        return new ImportDocumentMunicipalRequest.Document.ImportDocument();
    }

    /**
     * Create an instance of {@link ImportDocumentMunicipalRequest.Document.AnnulmentDocument }
     * 
     */
    public ImportDocumentMunicipalRequest.Document.AnnulmentDocument createImportDocumentMunicipalRequestDocumentAnnulmentDocument() {
        return new ImportDocumentMunicipalRequest.Document.AnnulmentDocument();
    }

    /**
     * Create an instance of {@link ImportDocumentRegionRequest.Document.ImportDocument }
     * 
     */
    public ImportDocumentRegionRequest.Document.ImportDocument createImportDocumentRegionRequestDocumentImportDocument() {
        return new ImportDocumentRegionRequest.Document.ImportDocument();
    }

    /**
     * Create an instance of {@link ImportDocumentRegionRequest.Document.AnnulmentDocument }
     * 
     */
    public ImportDocumentRegionRequest.Document.AnnulmentDocument createImportDocumentRegionRequestDocumentAnnulmentDocument() {
        return new ImportDocumentRegionRequest.Document.AnnulmentDocument();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://dom.gosuslugi.ru/schema/integration/uk/", name = "DocumentGUID")
    public JAXBElement<String> createDocumentGUID(String value) {
        return new JAXBElement<String>(_DocumentGUID_QNAME, String.class, null, value);
    }

}
