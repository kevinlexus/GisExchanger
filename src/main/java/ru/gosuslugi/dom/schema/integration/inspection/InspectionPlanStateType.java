
package ru.gosuslugi.dom.schema.integration.inspection;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InspectionPlanStateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InspectionPlanStateType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Signed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InspectionPlanStateType")
@XmlEnum
public enum InspectionPlanStateType {


    /**
     * Подписан.
     * 
     */
    @XmlEnumValue("Signed")
    SIGNED("Signed");
    private final String value;

    InspectionPlanStateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InspectionPlanStateType fromValue(String v) {
        for (InspectionPlanStateType c: InspectionPlanStateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
