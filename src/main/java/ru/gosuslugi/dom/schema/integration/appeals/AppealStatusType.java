
package ru.gosuslugi.dom.schema.integration.appeals;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AppealStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AppealStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Send"/&gt;
 *     &lt;enumeration value="Executed"/&gt;
 *     &lt;enumeration value="Withdrawn"/&gt;
 *     &lt;enumeration value="InWork"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AppealStatusType")
@XmlEnum
public enum AppealStatusType {

    @XmlEnumValue("Send")
    SEND("Send"),
    @XmlEnumValue("Executed")
    EXECUTED("Executed"),
    @XmlEnumValue("Withdrawn")
    WITHDRAWN("Withdrawn"),
    @XmlEnumValue("InWork")
    IN_WORK("InWork");
    private final String value;

    AppealStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AppealStatusType fromValue(String v) {
        for (AppealStatusType c: AppealStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
