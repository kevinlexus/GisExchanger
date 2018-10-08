
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NonResidentialPremiseAcceptedParameterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NonResidentialPremiseAcceptedParameterType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PremisesNum"/&gt;
 *     &lt;enumeration value="Purpose"/&gt;
 *     &lt;enumeration value="Position"/&gt;
 *     &lt;enumeration value="TotalArea"/&gt;
 *     &lt;enumeration value="IsCommonProperty"/&gt;
 *     &lt;enumeration value="TerminationDate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NonResidentialPremiseAcceptedParameterType")
@XmlEnum
public enum NonResidentialPremiseAcceptedParameterType {

    @XmlEnumValue("PremisesNum")
    PREMISES_NUM("PremisesNum"),
    @XmlEnumValue("Purpose")
    PURPOSE("Purpose"),
    @XmlEnumValue("Position")
    POSITION("Position"),
    @XmlEnumValue("TotalArea")
    TOTAL_AREA("TotalArea"),
    @XmlEnumValue("IsCommonProperty")
    IS_COMMON_PROPERTY("IsCommonProperty"),
    @XmlEnumValue("TerminationDate")
    TERMINATION_DATE("TerminationDate");
    private final String value;

    NonResidentialPremiseAcceptedParameterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NonResidentialPremiseAcceptedParameterType fromValue(String v) {
        for (NonResidentialPremiseAcceptedParameterType c: NonResidentialPremiseAcceptedParameterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
