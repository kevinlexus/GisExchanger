
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntervalKindType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IntervalKindType"&gt;
 *   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"&gt;
 *     &lt;enumeration value="IntervalInProviding"/&gt;
 *     &lt;enumeration value="RestrictionInProviding"/&gt;
 *     &lt;enumeration value="SuspensionOfProviding"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "IntervalKindType")
@XmlEnum
public enum IntervalKindType {

    @XmlEnumValue("IntervalInProviding")
    INTERVAL_IN_PROVIDING("IntervalInProviding"),
    @XmlEnumValue("RestrictionInProviding")
    RESTRICTION_IN_PROVIDING("RestrictionInProviding"),
    @XmlEnumValue("SuspensionOfProviding")
    SUSPENSION_OF_PROVIDING("SuspensionOfProviding");
    private final String value;

    IntervalKindType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IntervalKindType fromValue(String v) {
        for (IntervalKindType c: IntervalKindType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
