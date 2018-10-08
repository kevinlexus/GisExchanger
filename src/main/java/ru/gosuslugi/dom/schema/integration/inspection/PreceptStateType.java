
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PreceptStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PreceptStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Active"/&gt;
 *     &lt;enumeration value="Cancelled"/&gt;
 *     &lt;enumeration value="Fulfiled"/&gt;
 *     &lt;enumeration value="NotFilled"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PreceptStateType")
@XmlEnum
public enum PreceptStateType {


    /**
     * Не отменено (не отозвано).
     * 
     */
    @XmlEnumValue("Active")
    ACTIVE("Active"),

    /**
     * Отменено (отозвано).
     * 
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Fulfiled")
    FULFILED("Fulfiled"),
    @XmlEnumValue("NotFilled")
    NOT_FILLED("NotFilled");
    private final String value;

    PreceptStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PreceptStateType fromValue(String v) {
        for (PreceptStateType c: PreceptStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
