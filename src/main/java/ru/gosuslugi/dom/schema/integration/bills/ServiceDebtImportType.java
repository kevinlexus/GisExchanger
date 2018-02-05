
package ru.gosuslugi.dom.schema.integration.bills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Задолженность по услуге за период при импорте
 * 
 * <p>Java class for ServiceDebtImportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceDebtImportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/bills/}DebtImportType">
 *       &lt;sequence>
 *         &lt;element name="ServiceType" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDebtImportType", propOrder = {
    "serviceType"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.bills.PDServiceDebtImportType.HousingService.class,
    ru.gosuslugi.dom.schema.integration.bills.PDServiceDebtImportType.AdditionalService.class,
    ru.gosuslugi.dom.schema.integration.bills.PDServiceDebtImportType.MunicipalService.class
})
public class ServiceDebtImportType
    extends DebtImportType
{

    @XmlElement(name = "ServiceType", required = true)
    protected NsiRef serviceType;

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

}
