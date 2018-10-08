
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CharterStatusExportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CharterStatusExportType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Approved"/&gt;
 *     &lt;enumeration value="Terminated"/&gt;
 *     &lt;enumeration value="Annul"/&gt;
 *     &lt;enumeration value="Reviewed"/&gt;
 *     &lt;enumeration value="ApprovalProcess"/&gt;
 *     &lt;enumeration value="Rejected"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CharterStatusExportType")
@XmlEnum
public enum CharterStatusExportType {

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

    CharterStatusExportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CharterStatusExportType fromValue(String v) {
        for (CharterStatusExportType c: CharterStatusExportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
