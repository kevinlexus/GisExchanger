
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExaminationStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExaminationStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Planned"/&gt;
 *     &lt;enumeration value="Assigned"/&gt;
 *     &lt;enumeration value="Finished"/&gt;
 *     &lt;enumeration value="Cancelled"/&gt;
 *     &lt;enumeration value="Annulled"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ExaminationStateType")
@XmlEnum
public enum ExaminationStateType {


    /**
     * Выполняется.
     * 
     */
    @XmlEnumValue("Planned")
    PLANNED("Planned"),
    @XmlEnumValue("Assigned")
    ASSIGNED("Assigned"),

    /**
     * Завершена.
     * 
     */
    @XmlEnumValue("Finished")
    FINISHED("Finished"),

    /**
     * Отменена.
     * 
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled");
    private final String value;

    ExaminationStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExaminationStateType fromValue(String v) {
        for (ExaminationStateType c: ExaminationStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
