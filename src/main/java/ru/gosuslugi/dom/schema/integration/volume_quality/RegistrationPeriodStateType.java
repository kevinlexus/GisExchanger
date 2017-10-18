
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistrationPeriodStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RegistrationPeriodStateType">
 *   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type">
 *     &lt;enumeration value="Draft"/>
 *     &lt;enumeration value="Placed"/>
 *     &lt;enumeration value="Annulled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RegistrationPeriodStateType")
@XmlEnum
public enum RegistrationPeriodStateType {

    @XmlEnumValue("Draft")
    DRAFT("Draft"),
    @XmlEnumValue("Placed")
    PLACED("Placed"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled");
    private final String value;

    RegistrationPeriodStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RegistrationPeriodStateType fromValue(String v) {
        for (RegistrationPeriodStateType c: RegistrationPeriodStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
