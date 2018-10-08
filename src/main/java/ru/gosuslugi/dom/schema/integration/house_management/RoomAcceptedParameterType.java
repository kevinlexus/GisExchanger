
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoomAcceptedParameterType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RoomNumber"/&gt;
 *     &lt;enumeration value="Square"/&gt;
 *     &lt;enumeration value="ResidentialHouseType"/&gt;
 *     &lt;enumeration value="TerminationDate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoomAcceptedParameterType")
@XmlEnum
public enum RoomAcceptedParameterType {

    @XmlEnumValue("RoomNumber")
    ROOM_NUMBER("RoomNumber"),
    @XmlEnumValue("Square")
    SQUARE("Square"),
    @XmlEnumValue("ResidentialHouseType")
    RESIDENTIAL_HOUSE_TYPE("ResidentialHouseType"),
    @XmlEnumValue("TerminationDate")
    TERMINATION_DATE("TerminationDate");
    private final String value;

    RoomAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoomAcceptedParameterType fromValue(String v) {
        for (RoomAcceptedParameterType c: RoomAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
