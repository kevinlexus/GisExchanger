
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * КУ и КР для ОЖФ в договоре ресурсоснабжения
 * 
 * <p>Java class for ContractSubjectObjectAdressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractSubjectObjectAdressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceType"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MunicipalResource"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="StartSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="EndSupplyDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractSubjectObjectAdressType", propOrder = {
    "serviceType",
    "municipalResource",
    "startSupplyDate",
    "endSupplyDate"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportSupplyResourceContractObjectAddressRequest.ObjectAddress.LoadObject.Pair.class,
    ru.gosuslugi.dom.schema.integration.house_management.ExportSupplyResourceContractObjectAddressResultType.Pair.class,
    ru.gosuslugi.dom.schema.integration.house_management.ObjectAddressBriefType.Pair.class
})
public class ContractSubjectObjectAdressType {

    @XmlElement(name = "ServiceType", required = true)
    protected ContractSubjectObjectAdressType.ServiceType serviceType;
    @XmlElement(name = "MunicipalResource", required = true)
    protected ContractSubjectObjectAdressType.MunicipalResource municipalResource;
    @XmlElement(name = "StartSupplyDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startSupplyDate;
    @XmlElement(name = "EndSupplyDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endSupplyDate;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ContractSubjectObjectAdressType.ServiceType }
     *     
     */
    public ContractSubjectObjectAdressType.ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSubjectObjectAdressType.ServiceType }
     *     
     */
    public void setServiceType(ContractSubjectObjectAdressType.ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the municipalResource property.
     * 
     * @return
     *     possible object is
     *     {@link ContractSubjectObjectAdressType.MunicipalResource }
     *     
     */
    public ContractSubjectObjectAdressType.MunicipalResource getMunicipalResource() {
        return municipalResource;
    }

    /**
     * Sets the value of the municipalResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractSubjectObjectAdressType.MunicipalResource }
     *     
     */
    public void setMunicipalResource(ContractSubjectObjectAdressType.MunicipalResource value) {
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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
