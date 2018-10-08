
package ru.gosuslugi.dom.schema.integration.tariff;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DifferentiationValueKindType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DifferentiationValueKindType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Enumeration"/&gt;
 *     &lt;enumeration value="FIAS"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="Year"/&gt;
 *     &lt;enumeration value="Real"/&gt;
 *     &lt;enumeration value="Integer"/&gt;
 *     &lt;enumeration value="Boolean"/&gt;
 *     &lt;enumeration value="String"/&gt;
 *     &lt;enumeration value="Multiline"/&gt;
 *     &lt;enumeration value="OKTMO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DifferentiationValueKindType")
@XmlEnum
public enum DifferentiationValueKindType {


    /**
     * Перечислимый
     * 
     */
    @XmlEnumValue("Enumeration")
    ENUMERATION("Enumeration"),

    /**
     * FIAS-перечислимый (выбор из справочника ФИАС)
     * 
     */
    FIAS("FIAS"),

    /**
     * Дата
     * 
     */
    @XmlEnumValue("Date")
    DATE("Date"),

    /**
     * Год
     * 
     */
    @XmlEnumValue("Year")
    YEAR("Year"),

    /**
     * Вещественное число
     * 
     */
    @XmlEnumValue("Real")
    REAL("Real"),

    /**
     * Целое число
     * 
     */
    @XmlEnumValue("Integer")
    INTEGER("Integer"),

    /**
     * Логическое значение
     * 
     */
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),

    /**
     * Строка
     * 
     */
    @XmlEnumValue("String")
    STRING("String"),

    /**
     * Многострочный
     * 
     */
    @XmlEnumValue("Multiline")
    MULTILINE("Multiline"),

    /**
     * OKTMO-перечислимый (выбор из справочника ОКТМО)
     * 
     */
    OKTMO("OKTMO");
    private final String value;

    DifferentiationValueKindType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DifferentiationValueKindType fromValue(String v) {
        for (DifferentiationValueKindType c: DifferentiationValueKindType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
