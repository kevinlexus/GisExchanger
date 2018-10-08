
package ru.gosuslugi.dom.schema.integration.volume_quality;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContractType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContractType"&gt;
 *   &lt;restriction base="{http://dom.gosuslugi.ru/schema/integration/base/}String100Type"&gt;
 *     &lt;enumeration value="DRSO"/&gt;
 *     &lt;enumeration value="DTKO"/&gt;
 *     &lt;enumeration value="ManagementContract"/&gt;
 *     &lt;enumeration value="Charter"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContractType")
@XmlEnum
public enum ContractType {

    DRSO("DRSO"),
    DTKO("DTKO"),
    @XmlEnumValue("ManagementContract")
    MANAGEMENT_CONTRACT("ManagementContract"),
    @XmlEnumValue("Charter")
    CHARTER("Charter");
    private final String value;

    ContractType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContractType fromValue(String v) {
        for (ContractType c: ContractType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
