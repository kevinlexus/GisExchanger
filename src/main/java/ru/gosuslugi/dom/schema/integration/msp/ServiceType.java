
package ru.gosuslugi.dom.schema.integration.msp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ColdWater"/&gt;
 *     &lt;enumeration value="HotWater"/&gt;
 *     &lt;enumeration value="Sewerage"/&gt;
 *     &lt;enumeration value="Electricity"/&gt;
 *     &lt;enumeration value="Gas"/&gt;
 *     &lt;enumeration value="SolidFuel"/&gt;
 *     &lt;enumeration value="LiquidGas"/&gt;
 *     &lt;enumeration value="Heating"/&gt;
 *     &lt;enumeration value="Waste"/&gt;
 *     &lt;enumeration value="Maintenance"/&gt;
 *     &lt;enumeration value="Repairs"/&gt;
 *     &lt;enumeration value="Rent"/&gt;
 *     &lt;enumeration value="CollectiveHotWater"/&gt;
 *     &lt;enumeration value="CollectiveColdWater"/&gt;
 *     &lt;enumeration value="CollectiveElectricity"/&gt;
 *     &lt;enumeration value="CollectiveSewerage"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ServiceType")
@XmlEnum
public enum ServiceType {

    @XmlEnumValue("ColdWater")
    COLD_WATER("ColdWater"),
    @XmlEnumValue("HotWater")
    HOT_WATER("HotWater"),
    @XmlEnumValue("Sewerage")
    SEWERAGE("Sewerage"),
    @XmlEnumValue("Electricity")
    ELECTRICITY("Electricity"),
    @XmlEnumValue("Gas")
    GAS("Gas"),
    @XmlEnumValue("SolidFuel")
    SOLID_FUEL("SolidFuel"),
    @XmlEnumValue("LiquidGas")
    LIQUID_GAS("LiquidGas"),
    @XmlEnumValue("Heating")
    HEATING("Heating"),
    @XmlEnumValue("Waste")
    WASTE("Waste"),
    @XmlEnumValue("Maintenance")
    MAINTENANCE("Maintenance"),
    @XmlEnumValue("Repairs")
    REPAIRS("Repairs"),
    @XmlEnumValue("Rent")
    RENT("Rent"),
    @XmlEnumValue("CollectiveHotWater")
    COLLECTIVE_HOT_WATER("CollectiveHotWater"),
    @XmlEnumValue("CollectiveColdWater")
    COLLECTIVE_COLD_WATER("CollectiveColdWater"),
    @XmlEnumValue("CollectiveElectricity")
    COLLECTIVE_ELECTRICITY("CollectiveElectricity"),
    @XmlEnumValue("CollectiveSewerage")
    COLLECTIVE_SEWERAGE("CollectiveSewerage");
    private final String value;

    ServiceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceType fromValue(String v) {
        for (ServiceType c: ServiceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
