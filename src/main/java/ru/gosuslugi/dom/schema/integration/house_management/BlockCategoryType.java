
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BlockCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BlockCategoryType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Residential"/&gt;
 *     &lt;enumeration value="NonResidential"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BlockCategoryType")
@XmlEnum
public enum BlockCategoryType {


    /**
     * Жилое
     * 
     */
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential"),

    /**
     * Нежилое
     * 
     */
    @XmlEnumValue("NonResidential")
    NON_RESIDENTIAL("NonResidential");
    private final String value;

    BlockCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BlockCategoryType fromValue(String v) {
        for (BlockCategoryType c: BlockCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
