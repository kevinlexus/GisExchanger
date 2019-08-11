
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.metering_device_base.ElectricMeteringValueBaseType;


/**
 * Последние полученные показания (электрическая энергия) и изменяемые сведения о ПУ (коэфф. трансформации). В зависимости от количества показаний, заданных при создании ПУ, определяется его вид по количеству тарифов.
 * 
 * <p>Java class for MunicipalResourceElectricUpdateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MunicipalResourceElectricUpdateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/metering-device-base/}ElectricMeteringValueBaseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="TransformationRatio" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;fractionDigits value="4"/&gt;
 *               &lt;minExclusive value="0"/&gt;
 *               &lt;maxInclusive value="9999999999.9999"/&gt;
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
@XmlType(name = "MunicipalResourceElectricUpdateType", propOrder = {
    "transformationRatio"
})
public class MunicipalResourceElectricUpdateType
    extends ElectricMeteringValueBaseType
{

    @XmlElement(name = "TransformationRatio")
    protected BigDecimal transformationRatio;

    /**
     * Gets the value of the transformationRatio property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransformationRatio() {
        return transformationRatio;
    }

    /**
     * Sets the value of the transformationRatio property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransformationRatio(BigDecimal value) {
        this.transformationRatio = value;
    }

}
