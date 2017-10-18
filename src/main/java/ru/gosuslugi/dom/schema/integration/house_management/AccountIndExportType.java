
package ru.gosuslugi.dom.schema.integration.house_management;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import ru.gosuslugi.dom.schema.integration.individual_registry_base.FIOExportType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Физическое лицо
 * 
 * <p>Java class for AccountIndExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountIndExportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}FIOExportType">
 *       &lt;sequence>
 *         &lt;element name="Sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1"/>
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="F"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://dom.gosuslugi.ru/schema/integration/individual-registry-base/}SNILS"/>
 *           &lt;element name="ID">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Type" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
 *                     &lt;element name="Series" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="45"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="Number" minOccurs="0">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;minLength value="1"/>
 *                           &lt;maxLength value="45"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIndExportType", propOrder = {
    "sex",
    "dateOfBirth",
    "snils",
    "id"
})
public class AccountIndExportType
    extends FIOExportType
{

    @XmlElement(name = "Sex")
    protected String sex;
    @XmlElement(name = "DateOfBirth")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "SNILS", namespace = "http://dom.gosuslugi.ru/schema/integration/individual-registry-base/")
    protected String snils;
    @XmlElement(name = "ID")
    protected AccountIndExportType.ID id;

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the snils property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSNILS() {
        return snils;
    }

    /**
     * Sets the value of the snils property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSNILS(String value) {
        this.snils = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link AccountIndExportType.ID }
     *     
     */
    public AccountIndExportType.ID getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountIndExportType.ID }
     *     
     */
    public void setID(AccountIndExportType.ID value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Type" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/>
     *         &lt;element name="Series" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="45"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Number" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="45"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "series",
        "number",
        "issueDate"
    })
    public static class ID {

        @XmlElement(name = "Type")
        protected NsiRef type;
        @XmlElement(name = "Series")
        protected String series;
        @XmlElement(name = "Number")
        protected String number;
        @XmlElement(name = "IssueDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar issueDate;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setType(NsiRef value) {
            this.type = value;
        }

        /**
         * Gets the value of the series property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSeries() {
            return series;
        }

        /**
         * Sets the value of the series property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSeries(String value) {
            this.series = value;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumber(String value) {
            this.number = value;
        }

        /**
         * Gets the value of the issueDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getIssueDate() {
            return issueDate;
        }

        /**
         * Sets the value of the issueDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setIssueDate(XMLGregorianCalendar value) {
            this.issueDate = value;
        }

    }

}
