
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContractStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContractStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Project"/>
 *     &lt;enumeration value="ApprovalProcess"/>
 *     &lt;enumeration value="Rejected"/>
 *     &lt;enumeration value="Approved"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="Reviewed"/>
 *     &lt;enumeration value="Annul"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContractStatusType")
@XmlEnum
public enum ContractStatusType {

    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("ApprovalProcess")
    APPROVAL_PROCESS("ApprovalProcess"),
    @XmlEnumValue("Rejected")
    REJECTED("Rejected"),
    @XmlEnumValue("Approved")
    APPROVED("Approved"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("Reviewed")
    REVIEWED("Reviewed"),
    @XmlEnumValue("Annul")
    ANNUL("Annul");
    private final String value;

    ContractStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContractStatusType fromValue(String v) {
        for (ContractStatusType c: ContractStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
