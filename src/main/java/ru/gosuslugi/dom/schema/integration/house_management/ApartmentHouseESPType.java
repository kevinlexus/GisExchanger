
package ru.gosuslugi.dom.schema.integration.house_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;


/**
 * Многоквартирный дом (для импорта от ЕСП)
 * 
 * <p>Java class for ApartmentHouseESPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApartmentHouseESPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BasicCharacteristicts"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}GKN_EGRP_KeyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
 *                   &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType"/&gt;
 *                   &lt;element name="State" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="LifeCycleStage" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
 *                   &lt;element name="UsedYear" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}UsedYearType"/&gt;
 *                   &lt;element name="FloorCount" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}FloorType"/&gt;
 *                   &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
 *                   &lt;element name="OlsonTZ" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
 *                   &lt;element name="CulturalHeritage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="OGFData" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="UndergroundFloorCount" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}UndergroundFloorType"/&gt;
 *         &lt;element name="MinFloorCount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte"&gt;
 *               &lt;maxInclusive value="99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApartmentHouseESPType", propOrder = {
    "basicCharacteristicts",
    "undergroundFloorCount",
    "minFloorCount"
})
@XmlSeeAlso({
    ru.gosuslugi.dom.schema.integration.house_management.ImportHouseESPRequest.ApartmentHouse.ApartmentHouseToCreate.class
})
public class ApartmentHouseESPType {

    @XmlElement(name = "BasicCharacteristicts", required = true)
    protected ApartmentHouseESPType.BasicCharacteristicts basicCharacteristicts;
    @XmlElement(name = "UndergroundFloorCount")
    protected byte undergroundFloorCount;
    @XmlElement(name = "MinFloorCount")
    protected Byte minFloorCount;

    /**
     * Gets the value of the basicCharacteristicts property.
     * 
     * @return
     *     possible object is
     *     {@link ApartmentHouseESPType.BasicCharacteristicts }
     *     
     */
    public ApartmentHouseESPType.BasicCharacteristicts getBasicCharacteristicts() {
        return basicCharacteristicts;
    }

    /**
     * Sets the value of the basicCharacteristicts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApartmentHouseESPType.BasicCharacteristicts }
     *     
     */
    public void setBasicCharacteristicts(ApartmentHouseESPType.BasicCharacteristicts value) {
        this.basicCharacteristicts = value;
    }

    /**
     * Gets the value of the undergroundFloorCount property.
     * 
     */
    public byte getUndergroundFloorCount() {
        return undergroundFloorCount;
    }

    /**
     * Sets the value of the undergroundFloorCount property.
     * 
     */
    public void setUndergroundFloorCount(byte value) {
        this.undergroundFloorCount = value;
    }

    /**
     * Gets the value of the minFloorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getMinFloorCount() {
        return minFloorCount;
    }

    /**
     * Sets the value of the minFloorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setMinFloorCount(Byte value) {
        this.minFloorCount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://dom.gosuslugi.ru/schema/integration/house-management/}GKN_EGRP_KeyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="FIASHouseGuid" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}FIASHouseGUIDType"/&gt;
     *         &lt;element name="TotalSquare" type="{http://dom.gosuslugi.ru/schema/integration/premises-base/}PremisesAreaType"/&gt;
     *         &lt;element name="State" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="LifeCycleStage" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef" minOccurs="0"/&gt;
     *         &lt;element name="UsedYear" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}UsedYearType"/&gt;
     *         &lt;element name="FloorCount" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}FloorType"/&gt;
     *         &lt;element name="OKTMO" type="{http://dom.gosuslugi.ru/schema/integration/base/}OKTMORefType"/&gt;
     *         &lt;element name="OlsonTZ" type="{http://dom.gosuslugi.ru/schema/integration/nsi-base/}nsiRef"/&gt;
     *         &lt;element name="CulturalHeritage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="OGFData" type="{http://dom.gosuslugi.ru/schema/integration/house-management/}OGFData" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fiasHouseGuid",
        "totalSquare",
        "state",
        "lifeCycleStage",
        "usedYear",
        "floorCount",
        "oktmo",
        "olsonTZ",
        "culturalHeritage",
        "ogfData"
    })
    public static class BasicCharacteristicts
        extends GKNEGRPKeyType
    {

        @XmlElement(name = "FIASHouseGuid", required = true)
        protected String fiasHouseGuid;
        @XmlElement(name = "TotalSquare", required = true)
        protected BigDecimal totalSquare;
        @XmlElement(name = "State", required = true)
        protected NsiRef state;
        @XmlElement(name = "LifeCycleStage")
        protected NsiRef lifeCycleStage;
        @XmlElement(name = "UsedYear")
        protected short usedYear;
        @XmlElement(name = "FloorCount")
        protected byte floorCount;
        @XmlElement(name = "OKTMO", required = true)
        protected OKTMORefType oktmo;
        @XmlElement(name = "OlsonTZ", required = true)
        protected NsiRef olsonTZ;
        @XmlElement(name = "CulturalHeritage")
        protected boolean culturalHeritage;
        @XmlElement(name = "OGFData")
        protected List<OGFData> ogfData;

        /**
         * Gets the value of the fiasHouseGuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFIASHouseGuid() {
            return fiasHouseGuid;
        }

        /**
         * Sets the value of the fiasHouseGuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFIASHouseGuid(String value) {
            this.fiasHouseGuid = value;
        }

        /**
         * Gets the value of the totalSquare property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotalSquare() {
            return totalSquare;
        }

        /**
         * Sets the value of the totalSquare property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotalSquare(BigDecimal value) {
            this.totalSquare = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setState(NsiRef value) {
            this.state = value;
        }

        /**
         * Gets the value of the lifeCycleStage property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getLifeCycleStage() {
            return lifeCycleStage;
        }

        /**
         * Sets the value of the lifeCycleStage property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setLifeCycleStage(NsiRef value) {
            this.lifeCycleStage = value;
        }

        /**
         * Gets the value of the usedYear property.
         * 
         */
        public short getUsedYear() {
            return usedYear;
        }

        /**
         * Sets the value of the usedYear property.
         * 
         */
        public void setUsedYear(short value) {
            this.usedYear = value;
        }

        /**
         * Gets the value of the floorCount property.
         * 
         */
        public byte getFloorCount() {
            return floorCount;
        }

        /**
         * Sets the value of the floorCount property.
         * 
         */
        public void setFloorCount(byte value) {
            this.floorCount = value;
        }

        /**
         * Gets the value of the oktmo property.
         * 
         * @return
         *     possible object is
         *     {@link OKTMORefType }
         *     
         */
        public OKTMORefType getOKTMO() {
            return oktmo;
        }

        /**
         * Sets the value of the oktmo property.
         * 
         * @param value
         *     allowed object is
         *     {@link OKTMORefType }
         *     
         */
        public void setOKTMO(OKTMORefType value) {
            this.oktmo = value;
        }

        /**
         * Gets the value of the olsonTZ property.
         * 
         * @return
         *     possible object is
         *     {@link NsiRef }
         *     
         */
        public NsiRef getOlsonTZ() {
            return olsonTZ;
        }

        /**
         * Sets the value of the olsonTZ property.
         * 
         * @param value
         *     allowed object is
         *     {@link NsiRef }
         *     
         */
        public void setOlsonTZ(NsiRef value) {
            this.olsonTZ = value;
        }

        /**
         * Gets the value of the culturalHeritage property.
         * 
         */
        public boolean isCulturalHeritage() {
            return culturalHeritage;
        }

        /**
         * Sets the value of the culturalHeritage property.
         * 
         */
        public void setCulturalHeritage(boolean value) {
            this.culturalHeritage = value;
        }

        /**
         * Gets the value of the ogfData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ogfData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOGFData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OGFData }
         * 
         * 
         */
        public List<OGFData> getOGFData() {
            if (ogfData == null) {
                ogfData = new ArrayList<OGFData>();
            }
            return this.ogfData;
        }

    }

}
