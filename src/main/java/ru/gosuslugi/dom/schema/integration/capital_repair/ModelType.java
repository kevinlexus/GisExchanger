
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModelType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ModelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="SeparatePD"/>
 *     &lt;enumeration value="UnifiedPD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ModelType")
@XmlEnum
public enum ModelType {


    /**
     * Отдельным платежным документом
     * 
     */
    @XmlEnumValue("SeparatePD")
    SEPARATE_PD("SeparatePD"),

    /**
     * В составе единого платежного документа
     * 
     */
    @XmlEnumValue("UnifiedPD")
    UNIFIED_PD("UnifiedPD");
    private final String value;

    ModelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ModelType fromValue(String v) {
        for (ModelType c: ModelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
