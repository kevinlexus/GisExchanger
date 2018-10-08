
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for URIExaminationStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="URIExaminationStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Placed"/&gt;
 *     &lt;enumeration value="NotPlaced"/&gt;
 *     &lt;enumeration value="Sent"/&gt;
 *     &lt;enumeration value="NotSent"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "URIExaminationStateType")
@XmlEnum
public enum URIExaminationStateType {

    @XmlEnumValue("Placed")
    PLACED("Placed"),
    @XmlEnumValue("NotPlaced")
    NOT_PLACED("NotPlaced"),
    @XmlEnumValue("Sent")
    SENT("Sent"),
    @XmlEnumValue("NotSent")
    NOT_SENT("NotSent");
    private final String value;

    URIExaminationStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static URIExaminationStateType fromValue(String v) {
        for (URIExaminationStateType c: URIExaminationStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
