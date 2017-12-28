
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharterStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharterStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="Annul"/>
 *     &lt;enumeration value="Reviewed"/>
 *     &lt;enumeration value="ApprovalProcess"/>
 *     &lt;enumeration value="Rejected"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CharterStatusType")
@XmlEnum
public enum CharterStatusType {

    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("Annul")
    ANNUL("Annul"),
    @XmlEnumValue("Reviewed")
    REVIEWED("Reviewed"),
    @XmlEnumValue("ApprovalProcess")
    APPROVAL_PROCESS("ApprovalProcess"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected");
    private final String value;

    CharterStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharterStatusType fromValue(String v) {
        for (CharterStatusType c: CharterStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
