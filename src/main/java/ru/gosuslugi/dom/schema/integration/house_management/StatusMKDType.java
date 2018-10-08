
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusMKDType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusMKDType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Project"/&gt;
 *     &lt;enumeration value="Rejected"/&gt;
 *     &lt;enumeration value="ApprovalProcess"/&gt;
 *     &lt;enumeration value="Approved"/&gt;
 *     &lt;enumeration value="Locked"/&gt;
 *     &lt;enumeration value="Annul"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StatusMKDType")
@XmlEnum
public enum StatusMKDType {

    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("ApprovalProcess")
    APPROVAL_PROCESS("ApprovalProcess"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Locked")
    LOCKED("Locked"),
    @XmlEnumValue("Annul")
    ANNUL("Annul");
    private final String value;

    StatusMKDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusMKDType fromValue(String v) {
        for (StatusMKDType c: StatusMKDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
