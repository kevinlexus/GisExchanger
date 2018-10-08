
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TermQualificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TermQualificationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CURRENTMONTH"/&gt;
 *     &lt;enumeration value="NEXTMONTH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TermQualificationType")
@XmlEnum
public enum TermQualificationType {


    /**
     * текущего расчетного месяца
     * 
     */
    CURRENTMONTH,

    /**
     * следующего месяца за расчетным
     * 
     */
    NEXTMONTH;

    public String value() {
        return name();
    }

    public static TermQualificationType fromValue(String v) {
        return valueOf(v);
    }

}
