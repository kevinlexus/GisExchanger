
package ru.gosuslugi.dom.schema.integration.rap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecreeStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DecreeStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Published"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Annulled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DecreeStatusType")
@XmlEnum
public enum DecreeStatusType {

    @XmlEnumValue("Published")
    PUBLISHED("Published"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled");
    private final String value;

    DecreeStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DecreeStatusType fromValue(String v) {
        for (DecreeStatusType c: DecreeStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
