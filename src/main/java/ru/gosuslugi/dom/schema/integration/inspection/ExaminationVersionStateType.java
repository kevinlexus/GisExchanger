
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExaminationVersionStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExaminationVersionStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Active"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExaminationVersionStateType")
@XmlEnum
public enum ExaminationVersionStateType {


    /**
     * Опубликована.
     * 
     */
    @XmlEnumValue("Active")
    ACTIVE("Active");
    private final String value;

    ExaminationVersionStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExaminationVersionStateType fromValue(String v) {
        for (ExaminationVersionStateType c: ExaminationVersionStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
