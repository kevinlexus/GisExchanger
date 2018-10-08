
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatusExtendedType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusExtendedType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Project"/&gt;
 *     &lt;enumeration value="Published"/&gt;
 *     &lt;enumeration value="Canceled"/&gt;
 *     &lt;enumeration value="PublishedAndProject"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "StatusExtendedType")
@XmlEnum
public enum StatusExtendedType {


    /**
     * Проект
     * 
     */
    @XmlEnumValue("Project")
    PROJECT("Project"),

    /**
     * Опубликован
     * 
     */
    @XmlEnumValue("Published")
    PUBLISHED("Published"),

    /**
     * Аннулирован
     * 
     */
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("PublishedAndProject")
    PUBLISHED_AND_PROJECT("PublishedAndProject");
    private final String value;

    StatusExtendedType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusExtendedType fromValue(String v) {
        for (StatusExtendedType c: StatusExtendedType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
