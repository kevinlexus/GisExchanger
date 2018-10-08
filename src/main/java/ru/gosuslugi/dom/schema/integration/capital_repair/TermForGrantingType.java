
package ru.gosuslugi.dom.schema.integration.capital_repair;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TermForGrantingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TermForGrantingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="COINCIDES"/&gt;
 *     &lt;enumeration value="OTHER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TermForGrantingType")
@XmlEnum
public enum TermForGrantingType {


    /**
     * совпадает со сроком, установленным для внесения платы за жилое помещение и коммунальные услуги
     * 
     */
    COINCIDES,

    /**
     * иной срок
     * 
     */
    OTHER;

    public String value() {
        return name();
    }

    public static TermForGrantingType fromValue(String v) {
        return valueOf(v);
    }

}
