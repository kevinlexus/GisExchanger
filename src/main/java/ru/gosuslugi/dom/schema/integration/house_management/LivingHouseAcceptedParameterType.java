
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LivingHouseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LivingHouseAcceptedParameterType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FiasHouseGuid"/&gt;
 *     &lt;enumeration value="TotalSquare"/&gt;
 *     &lt;enumeration value="State"/&gt;
 *     &lt;enumeration value="InnerWallMaterial"/&gt;
 *     &lt;enumeration value="ProjectSeries"/&gt;
 *     &lt;enumeration value="ProjectType"/&gt;
 *     &lt;enumeration value="BuildingYear"/&gt;
 *     &lt;enumeration value="UsedYear"/&gt;
 *     &lt;enumeration value="TotalWear"/&gt;
 *     &lt;enumeration value="FloorCount"/&gt;
 *     &lt;enumeration value="Energy"/&gt;
 *     &lt;enumeration value="OKTMO"/&gt;
 *     &lt;enumeration value="OlsonTZ"/&gt;
 *     &lt;enumeration value="ResidentialSquare"/&gt;
 *     &lt;enumeration value="CulturalHeritage"/&gt;
 *     &lt;enumeration value="ResidentialHouseType"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LivingHouseAcceptedParameterType")
@XmlEnum
public enum LivingHouseAcceptedParameterType {

    @XmlEnumValue("FiasHouseGuid")
    FIAS_HOUSE_GUID("FiasHouseGuid"),
    @XmlEnumValue("TotalSquare")
    TOTAL_SQUARE("TotalSquare"),
    @XmlEnumValue("State")
    STATE("State"),
    @XmlEnumValue("InnerWallMaterial")
    INNER_WALL_MATERIAL("InnerWallMaterial"),
    @XmlEnumValue("ProjectSeries")
    PROJECT_SERIES("ProjectSeries"),
    @XmlEnumValue("ProjectType")
    PROJECT_TYPE("ProjectType"),
    @XmlEnumValue("BuildingYear")
    BUILDING_YEAR("BuildingYear"),
    @XmlEnumValue("UsedYear")
    USED_YEAR("UsedYear"),
    @XmlEnumValue("TotalWear")
    TOTAL_WEAR("TotalWear"),
    @XmlEnumValue("FloorCount")
    FLOOR_COUNT("FloorCount"),
    @XmlEnumValue("Energy")
    ENERGY("Energy"),
    OKTMO("OKTMO"),
    @XmlEnumValue("OlsonTZ")
    OLSON_TZ("OlsonTZ"),
    @XmlEnumValue("ResidentialSquare")
    RESIDENTIAL_SQUARE("ResidentialSquare"),
    @XmlEnumValue("CulturalHeritage")
    CULTURAL_HERITAGE("CulturalHeritage"),
    @XmlEnumValue("ResidentialHouseType")
    RESIDENTIAL_HOUSE_TYPE("ResidentialHouseType");
    private final String value;

    LivingHouseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LivingHouseAcceptedParameterType fromValue(String v) {
        for (LivingHouseAcceptedParameterType c: LivingHouseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
