
package ru.gosuslugi.dom.schema.integration.tariff;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TariffCaseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TariffCaseType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MunicipalResourceTariff"/&gt;
 *     &lt;enumeration value="ResidentialPremisesMaintenance"/&gt;
 *     &lt;enumeration value="CapitalRepairTariff"/&gt;
 *     &lt;enumeration value="SocialNorm"/&gt;
 *     &lt;enumeration value="ResidentialPremisesUsage"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TariffCaseType")
@XmlEnum
public enum TariffCaseType {


    /**
     * Тариф на оплату коммунальных ресурсов
     * 
     */
    @XmlEnumValue("MunicipalResourceTariff")
    MUNICIPAL_RESOURCE_TARIFF("MunicipalResourceTariff"),

    /**
     * Размер платы за содержание жилого помещения
     * 
     */
    @XmlEnumValue("ResidentialPremisesMaintenance")
    RESIDENTIAL_PREMISES_MAINTENANCE("ResidentialPremisesMaintenance"),

    /**
     * Минимальный размер взноса на капитальный ремонт
     * 
     */
    @XmlEnumValue("CapitalRepairTariff")
    CAPITAL_REPAIR_TARIFF("CapitalRepairTariff"),

    /**
     * Социальная норма потребления электрической энергии
     * 
     */
    @XmlEnumValue("SocialNorm")
    SOCIAL_NORM("SocialNorm"),

    /**
     * Размер платы за пользование жилым помещением
     * 
     */
    @XmlEnumValue("ResidentialPremisesUsage")
    RESIDENTIAL_PREMISES_USAGE("ResidentialPremisesUsage");
    private final String value;

    TariffCaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TariffCaseType fromValue(String v) {
        for (TariffCaseType c: TariffCaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
