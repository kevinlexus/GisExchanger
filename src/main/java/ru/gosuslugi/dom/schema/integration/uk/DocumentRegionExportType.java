
package ru.gosuslugi.dom.schema.integration.uk;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Документ закона/нормативно-правового акта регионального уровня для операции экспорта
 * 
 * <p>Java class for DocumentRegionExportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRegionExportType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/uk/}DocumentPortalExportType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="Region" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/>
 *         &lt;element name="Municipal" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType" maxOccurs="1000"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentRegionExportType", propOrder = {
    "region",
    "municipal"
})
public class DocumentRegionExportType
    extends DocumentPortalExportType
{

    @XmlElement(name = "Region")
    protected NsiRef region;
    @XmlElement(name = "Municipal")
    protected List<OKTMORefType> municipal;

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link NsiRef }
     *     
     */
    public NsiRef getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link NsiRef }
     *     
     */
    public void setRegion(NsiRef value) {
        this.region = value;
    }

    /**
     * Gets the value of the municipal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the municipal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMunicipal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OKTMORefType }
     * 
     * 
     */
    public List<OKTMORefType> getMunicipal() {
        if (municipal == null) {
            municipal = new ArrayList<OKTMORefType>();
        }
        return this.municipal;
    }

}
