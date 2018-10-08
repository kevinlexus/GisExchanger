
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessRequestType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessRequestType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ForInformationSystemOperator"/&gt;
 *     &lt;enumeration value="ForCalculationCenter"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AccessRequestType")
@XmlEnum
public enum AccessRequestType {


    /**
     * Для оператора информационной системы
     * 
     * 
     */
    @XmlEnumValue("ForInformationSystemOperator")
    FOR_INFORMATION_SYSTEM_OPERATOR("ForInformationSystemOperator"),

    /**
     * Для расчетного центра
     * 
     */
    @XmlEnumValue("ForCalculationCenter")
    FOR_CALCULATION_CENTER("ForCalculationCenter");
    private final String value;

    AccessRequestType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessRequestType fromValue(String v) {
        for (AccessRequestType c: AccessRequestType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
