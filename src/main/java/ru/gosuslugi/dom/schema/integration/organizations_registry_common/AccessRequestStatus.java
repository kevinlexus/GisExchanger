
package ru.gosuslugi.dom.schema.integration.organizations_registry_common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccessRequestStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccessRequestStatus"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Created"/&gt;
 *     &lt;enumeration value="Accepted"/&gt;
 *     &lt;enumeration value="Declined"/&gt;
 *     &lt;enumeration value="Revoked"/&gt;
 *     &lt;enumeration value="Annulled"/&gt;
 *     &lt;enumeration value="Closed"/&gt;
 *     &lt;enumeration value="Preset"/&gt;
 *     &lt;enumeration value="Waiting_approval"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AccessRequestStatus")
@XmlEnum
public enum AccessRequestStatus {


    /**
     * Создана
     * 
     */
    @XmlEnumValue("Created")
    CREATED("Created"),

    /**
     * Принята
     * 
     */
    @XmlEnumValue("Accepted")
    ACCEPTED("Accepted"),
    @XmlEnumValue("Declined")
    DECLINED("Declined"),

    /**
     * Отозвана
     * 
     */
    @XmlEnumValue("Revoked")
    REVOKED("Revoked"),
    @XmlEnumValue("Annulled")
    ANNULLED("Annulled"),
    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("Preset")
    PRESET("Preset"),
    @XmlEnumValue("Waiting_approval")
    WAITING_APPROVAL("Waiting_approval");
    private final String value;

    AccessRequestStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccessRequestStatus fromValue(String v) {
        for (AccessRequestStatus c: AccessRequestStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
