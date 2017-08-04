package com.ric.st.hotora.model.scott;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Лицевой счет 
 * @author lev
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "KART", schema="SCOTT")
public class Kart implements java.io.Serializable  {

	public Kart() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lsk", updatable = false, nullable = false)
	private String lsk;
	
    @Column(name = "reu", updatable = false, nullable = false)
	private String reu; 
	
    @Column(name = "kul", updatable = false, nullable = false)
	private String kul; 

    @Column(name = "nd", updatable = false, nullable = false)
	private String nd; 

    @Column(name = "fio", updatable = false, nullable = false)
	private String fio; 
    
	@Column(name="ANT")
	private BigDecimal ant;

	@Column(name="AVN_EL")
	private BigDecimal avnEl;

	@Column(name="BALPL")
	private BigDecimal balpl;

	@Column(name="BANK_ID")
	private BigDecimal bankId;

	@Column(name="BEKPL")
	private BigDecimal bekpl;

	@Column(name="C_LSK_ID")
	private BigDecimal cLskId;

	@Column(name="COMTEL")
	private BigDecimal comtel;

	@Column(name="DGW")
	private BigDecimal dgw;

	@Column(name="DOLG_GES")
	private BigDecimal dolgGes;

	@Column(name="DOP_GW")
	private BigDecimal dopGw;

	@Column(name="DOP_HW")
	private BigDecimal dopHw;

	@Column(name="DOP_KAN")
	private BigDecimal dopKan;

	@Column(name="DOP_MEL")
	private BigDecimal dopMel;

	@Column(name="DOP_OT")
	private BigDecimal dopOt;

	@Column(name="DOP_PL")
	private BigDecimal dopPl;

	@Column(name="DTERREL")
	private Date dterrel;

	@Column(name="DTERRGW")
	private Date dterrgw;

	@Column(name="DTERRHW")
	private Date dterrhw;

	@Column(name="EL_PL")
	private BigDecimal elPl;

	@Column(name="END_KNAI")
	private Date endKnai;

	@Column(name="FK_KOOP")
	private BigDecimal fkKoop;

	@Column(name="GES_LSK")
	private BigDecimal gesLsk;

	@Column(name="GR_EL")
	private BigDecimal grEl;

	@Column(name="GR_GV")
	private BigDecimal grGv;

	@Column(name="GR_HV")
	private BigDecimal grHv;

	@Column(name="GR_TR")
	private BigDecimal grTr;

	private String gt;

	@Column(name="HOUSE_ID")
	private BigDecimal houseId;

	@Column(name="ID_GW")
	private String idGw;

	@Column(name="ID_HW")
	private String idHw;

	@Column(name="ID_KWT")
	private String idKwt;

	@Column(name="K_LSK_ID")
	private BigDecimal kLskId;

	@Column(name="KOD_ORG")
	private String kodOrg;

	@Column(name="KPR_CEM")
	private BigDecimal kprCem;

	@Column(name="KPR_OT")
	private BigDecimal kprOt;

	@Column(name="KPR_S")
	private BigDecimal kprS;

	@Column(name="KPR_WR")
	private BigDecimal kprWr;

	@Column(name="KWT_KARM")
	private BigDecimal kwtKarm;

	@Column(name="KWT_LG")
	private BigDecimal kwtLg;

	@Column(name="LPDT")
	private Date lpdt;

	@Column(name="M_PROV")
	private BigDecimal mProv;

	@Column(name="MEL_LG")
	private BigDecimal melLg;

	@Column(name="MOT_N")
	private BigDecimal motN;

	@Column(name="NABOR_ID")
	private BigDecimal naborId;

	@Column(name="O_PEN")
	private BigDecimal oPen;

	@Column(name="ORG_DOLG")
	private BigDecimal orgDolg;

	@Column(name="PECH_DOG")
	private BigDecimal pechDog;

	@Column(name="PSCH_DT")
	private Date pschDt;

	@Column(name="PSCH_NAC")
	private BigDecimal pschNac;

	@Column(name="SCH_EL")
	private BigDecimal schEl;

	@Column(name="SCH_GAZ")
	private BigDecimal schGaz;

	@Column(name="SCHEL_DT")
	private Date schelDt;

	@Column(name="STRA_DAT")
	private String straDat;

	@Column(name="STRA_KRE")
	private String straKre;

	@Column(name="SUB_DATA")
	private Date subData;

	@Column(name="SUB_NACH")
	private Date subNach;

	@Column(name="SUB_PRIZ")
	private BigDecimal subPriz;

	@Column(name="SUBS_COR")
	private BigDecimal subsCor;

	@Column(name="TEL_DATA")
	private String telData;

	@Column(name="TEL_NACH")
	private BigDecimal telNach;

	@Column(name="VVOD_EL")
	private String vvodEl;

	@Column(name="VVOD_GW")
	private String vvodGw;

	@Column(name="VVOD_OT")
	private String vvodOt;
    
    public String getLsk() {
		return lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}
	
	public String getReu() {
		return reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public String getKul() {
		return kul;
	}

	public void setKul(String kul) {
		this.kul = kul;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}


	public BigDecimal getAnt() {
		return ant;
	}

	public void setAnt(BigDecimal ant) {
		this.ant = ant;
	}

	public BigDecimal getAvnEl() {
		return avnEl;
	}

	public void setAvnEl(BigDecimal avnEl) {
		this.avnEl = avnEl;
	}

	public BigDecimal getBalpl() {
		return balpl;
	}

	public void setBalpl(BigDecimal balpl) {
		this.balpl = balpl;
	}

	public BigDecimal getBankId() {
		return bankId;
	}

	public void setBankId(BigDecimal bankId) {
		this.bankId = bankId;
	}

	public BigDecimal getBekpl() {
		return bekpl;
	}

	public void setBekpl(BigDecimal bekpl) {
		this.bekpl = bekpl;
	}

	public BigDecimal getcLskId() {
		return cLskId;
	}

	public void setcLskId(BigDecimal cLskId) {
		this.cLskId = cLskId;
	}

	public BigDecimal getComtel() {
		return comtel;
	}

	public void setComtel(BigDecimal comtel) {
		this.comtel = comtel;
	}

	public BigDecimal getDgw() {
		return dgw;
	}

	public void setDgw(BigDecimal dgw) {
		this.dgw = dgw;
	}

	public BigDecimal getDolgGes() {
		return dolgGes;
	}

	public void setDolgGes(BigDecimal dolgGes) {
		this.dolgGes = dolgGes;
	}

	public BigDecimal getDopGw() {
		return dopGw;
	}

	public void setDopGw(BigDecimal dopGw) {
		this.dopGw = dopGw;
	}

	public BigDecimal getDopHw() {
		return dopHw;
	}

	public void setDopHw(BigDecimal dopHw) {
		this.dopHw = dopHw;
	}

	public BigDecimal getDopKan() {
		return dopKan;
	}

	public void setDopKan(BigDecimal dopKan) {
		this.dopKan = dopKan;
	}

	public BigDecimal getDopMel() {
		return dopMel;
	}

	public void setDopMel(BigDecimal dopMel) {
		this.dopMel = dopMel;
	}

	public BigDecimal getDopOt() {
		return dopOt;
	}

	public void setDopOt(BigDecimal dopOt) {
		this.dopOt = dopOt;
	}

	public BigDecimal getDopPl() {
		return dopPl;
	}

	public void setDopPl(BigDecimal dopPl) {
		this.dopPl = dopPl;
	}

	public Date getDterrel() {
		return dterrel;
	}

	public void setDterrel(Date dterrel) {
		this.dterrel = dterrel;
	}

	public Date getDterrgw() {
		return dterrgw;
	}

	public void setDterrgw(Date dterrgw) {
		this.dterrgw = dterrgw;
	}

	public Date getDterrhw() {
		return dterrhw;
	}

	public void setDterrhw(Date dterrhw) {
		this.dterrhw = dterrhw;
	}

	public BigDecimal getElPl() {
		return elPl;
	}

	public void setElPl(BigDecimal elPl) {
		this.elPl = elPl;
	}

	public Date getEndKnai() {
		return endKnai;
	}

	public void setEndKnai(Date endKnai) {
		this.endKnai = endKnai;
	}

	public BigDecimal getFkKoop() {
		return fkKoop;
	}

	public void setFkKoop(BigDecimal fkKoop) {
		this.fkKoop = fkKoop;
	}

	public BigDecimal getGesLsk() {
		return gesLsk;
	}

	public void setGesLsk(BigDecimal gesLsk) {
		this.gesLsk = gesLsk;
	}

	public BigDecimal getGrEl() {
		return grEl;
	}

	public void setGrEl(BigDecimal grEl) {
		this.grEl = grEl;
	}

	public BigDecimal getGrGv() {
		return grGv;
	}

	public void setGrGv(BigDecimal grGv) {
		this.grGv = grGv;
	}

	public BigDecimal getGrHv() {
		return grHv;
	}

	public void setGrHv(BigDecimal grHv) {
		this.grHv = grHv;
	}

	public BigDecimal getGrTr() {
		return grTr;
	}

	public void setGrTr(BigDecimal grTr) {
		this.grTr = grTr;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public BigDecimal getHouseId() {
		return houseId;
	}

	public void setHouseId(BigDecimal houseId) {
		this.houseId = houseId;
	}

	public String getIdGw() {
		return idGw;
	}

	public void setIdGw(String idGw) {
		this.idGw = idGw;
	}

	public String getIdHw() {
		return idHw;
	}

	public void setIdHw(String idHw) {
		this.idHw = idHw;
	}

	public String getIdKwt() {
		return idKwt;
	}

	public void setIdKwt(String idKwt) {
		this.idKwt = idKwt;
	}

	public BigDecimal getkLskId() {
		return kLskId;
	}

	public void setkLskId(BigDecimal kLskId) {
		this.kLskId = kLskId;
	}

	public String getKodOrg() {
		return kodOrg;
	}

	public void setKodOrg(String kodOrg) {
		this.kodOrg = kodOrg;
	}

	public BigDecimal getKprCem() {
		return kprCem;
	}

	public void setKprCem(BigDecimal kprCem) {
		this.kprCem = kprCem;
	}

	public BigDecimal getKprOt() {
		return kprOt;
	}

	public void setKprOt(BigDecimal kprOt) {
		this.kprOt = kprOt;
	}

	public BigDecimal getKprS() {
		return kprS;
	}

	public void setKprS(BigDecimal kprS) {
		this.kprS = kprS;
	}

	public BigDecimal getKprWr() {
		return kprWr;
	}

	public void setKprWr(BigDecimal kprWr) {
		this.kprWr = kprWr;
	}

	public BigDecimal getKwtKarm() {
		return kwtKarm;
	}

	public void setKwtKarm(BigDecimal kwtKarm) {
		this.kwtKarm = kwtKarm;
	}

	public BigDecimal getKwtLg() {
		return kwtLg;
	}

	public void setKwtLg(BigDecimal kwtLg) {
		this.kwtLg = kwtLg;
	}

	public Date getLpdt() {
		return lpdt;
	}

	public void setLpdt(Date lpdt) {
		this.lpdt = lpdt;
	}

	public BigDecimal getmProv() {
		return mProv;
	}

	public void setmProv(BigDecimal mProv) {
		this.mProv = mProv;
	}

	public BigDecimal getMelLg() {
		return melLg;
	}

	public void setMelLg(BigDecimal melLg) {
		this.melLg = melLg;
	}

	public BigDecimal getMotN() {
		return motN;
	}

	public void setMotN(BigDecimal motN) {
		this.motN = motN;
	}

	public BigDecimal getNaborId() {
		return naborId;
	}

	public void setNaborId(BigDecimal naborId) {
		this.naborId = naborId;
	}

	public BigDecimal getoPen() {
		return oPen;
	}

	public void setoPen(BigDecimal oPen) {
		this.oPen = oPen;
	}

	public BigDecimal getOrgDolg() {
		return orgDolg;
	}

	public void setOrgDolg(BigDecimal orgDolg) {
		this.orgDolg = orgDolg;
	}

	public BigDecimal getPechDog() {
		return pechDog;
	}

	public void setPechDog(BigDecimal pechDog) {
		this.pechDog = pechDog;
	}

	public Date getPschDt() {
		return pschDt;
	}

	public void setPschDt(Date pschDt) {
		this.pschDt = pschDt;
	}

	public BigDecimal getPschNac() {
		return pschNac;
	}

	public void setPschNac(BigDecimal pschNac) {
		this.pschNac = pschNac;
	}

	public BigDecimal getSchEl() {
		return schEl;
	}

	public void setSchEl(BigDecimal schEl) {
		this.schEl = schEl;
	}

	public BigDecimal getSchGaz() {
		return schGaz;
	}

	public void setSchGaz(BigDecimal schGaz) {
		this.schGaz = schGaz;
	}

	public Date getSchelDt() {
		return schelDt;
	}

	public void setSchelDt(Date schelDt) {
		this.schelDt = schelDt;
	}

	public String getStraDat() {
		return straDat;
	}

	public void setStraDat(String straDat) {
		this.straDat = straDat;
	}

	public String getStraKre() {
		return straKre;
	}

	public void setStraKre(String straKre) {
		this.straKre = straKre;
	}

	public Date getSubData() {
		return subData;
	}

	public void setSubData(Date subData) {
		this.subData = subData;
	}

	public Date getSubNach() {
		return subNach;
	}

	public void setSubNach(Date subNach) {
		this.subNach = subNach;
	}

	public BigDecimal getSubPriz() {
		return subPriz;
	}

	public void setSubPriz(BigDecimal subPriz) {
		this.subPriz = subPriz;
	}

	public BigDecimal getSubsCor() {
		return subsCor;
	}

	public void setSubsCor(BigDecimal subsCor) {
		this.subsCor = subsCor;
	}

	public String getTelData() {
		return telData;
	}

	public void setTelData(String telData) {
		this.telData = telData;
	}

	public BigDecimal getTelNach() {
		return telNach;
	}

	public void setTelNach(BigDecimal telNach) {
		this.telNach = telNach;
	}

	public String getVvodEl() {
		return vvodEl;
	}

	public void setVvodEl(String vvodEl) {
		this.vvodEl = vvodEl;
	}

	public String getVvodGw() {
		return vvodGw;
	}

	public void setVvodGw(String vvodGw) {
		this.vvodGw = vvodGw;
	}

	public String getVvodOt() {
		return vvodOt;
	}

	public void setVvodOt(String vvodOt) {
		this.vvodOt = vvodOt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Kart)) {
			return false;
		}
		Kart other = (Kart) obj;
		if (ant == null) {
			if (other.ant != null) {
				return false;
			}
		} else if (!ant.equals(other.ant)) {
			return false;
		}
		if (avnEl == null) {
			if (other.avnEl != null) {
				return false;
			}
		} else if (!avnEl.equals(other.avnEl)) {
			return false;
		}
		if (balpl == null) {
			if (other.balpl != null) {
				return false;
			}
		} else if (!balpl.equals(other.balpl)) {
			return false;
		}
		if (bankId == null) {
			if (other.bankId != null) {
				return false;
			}
		} else if (!bankId.equals(other.bankId)) {
			return false;
		}
		if (bekpl == null) {
			if (other.bekpl != null) {
				return false;
			}
		} else if (!bekpl.equals(other.bekpl)) {
			return false;
		}
		if (cLskId == null) {
			if (other.cLskId != null) {
				return false;
			}
		} else if (!cLskId.equals(other.cLskId)) {
			return false;
		}
		if (comtel == null) {
			if (other.comtel != null) {
				return false;
			}
		} else if (!comtel.equals(other.comtel)) {
			return false;
		}
		if (dgw == null) {
			if (other.dgw != null) {
				return false;
			}
		} else if (!dgw.equals(other.dgw)) {
			return false;
		}
		if (dolgGes == null) {
			if (other.dolgGes != null) {
				return false;
			}
		} else if (!dolgGes.equals(other.dolgGes)) {
			return false;
		}
		if (dopGw == null) {
			if (other.dopGw != null) {
				return false;
			}
		} else if (!dopGw.equals(other.dopGw)) {
			return false;
		}
		if (dopHw == null) {
			if (other.dopHw != null) {
				return false;
			}
		} else if (!dopHw.equals(other.dopHw)) {
			return false;
		}
		if (dopKan == null) {
			if (other.dopKan != null) {
				return false;
			}
		} else if (!dopKan.equals(other.dopKan)) {
			return false;
		}
		if (dopMel == null) {
			if (other.dopMel != null) {
				return false;
			}
		} else if (!dopMel.equals(other.dopMel)) {
			return false;
		}
		if (dopOt == null) {
			if (other.dopOt != null) {
				return false;
			}
		} else if (!dopOt.equals(other.dopOt)) {
			return false;
		}
		if (dopPl == null) {
			if (other.dopPl != null) {
				return false;
			}
		} else if (!dopPl.equals(other.dopPl)) {
			return false;
		}
		if (dterrel == null) {
			if (other.dterrel != null) {
				return false;
			}
		} else if (!dterrel.equals(other.dterrel)) {
			return false;
		}
		if (dterrgw == null) {
			if (other.dterrgw != null) {
				return false;
			}
		} else if (!dterrgw.equals(other.dterrgw)) {
			return false;
		}
		if (dterrhw == null) {
			if (other.dterrhw != null) {
				return false;
			}
		} else if (!dterrhw.equals(other.dterrhw)) {
			return false;
		}
		if (elPl == null) {
			if (other.elPl != null) {
				return false;
			}
		} else if (!elPl.equals(other.elPl)) {
			return false;
		}
		if (endKnai == null) {
			if (other.endKnai != null) {
				return false;
			}
		} else if (!endKnai.equals(other.endKnai)) {
			return false;
		}
		if (fio == null) {
			if (other.fio != null) {
				return false;
			}
		} else if (!fio.equals(other.fio)) {
			return false;
		}
		if (fkKoop == null) {
			if (other.fkKoop != null) {
				return false;
			}
		} else if (!fkKoop.equals(other.fkKoop)) {
			return false;
		}
		if (gesLsk == null) {
			if (other.gesLsk != null) {
				return false;
			}
		} else if (!gesLsk.equals(other.gesLsk)) {
			return false;
		}
		if (grEl == null) {
			if (other.grEl != null) {
				return false;
			}
		} else if (!grEl.equals(other.grEl)) {
			return false;
		}
		if (grGv == null) {
			if (other.grGv != null) {
				return false;
			}
		} else if (!grGv.equals(other.grGv)) {
			return false;
		}
		if (grHv == null) {
			if (other.grHv != null) {
				return false;
			}
		} else if (!grHv.equals(other.grHv)) {
			return false;
		}
		if (grTr == null) {
			if (other.grTr != null) {
				return false;
			}
		} else if (!grTr.equals(other.grTr)) {
			return false;
		}
		if (gt == null) {
			if (other.gt != null) {
				return false;
			}
		} else if (!gt.equals(other.gt)) {
			return false;
		}
		if (houseId == null) {
			if (other.houseId != null) {
				return false;
			}
		} else if (!houseId.equals(other.houseId)) {
			return false;
		}
		if (idGw == null) {
			if (other.idGw != null) {
				return false;
			}
		} else if (!idGw.equals(other.idGw)) {
			return false;
		}
		if (idHw == null) {
			if (other.idHw != null) {
				return false;
			}
		} else if (!idHw.equals(other.idHw)) {
			return false;
		}
		if (idKwt == null) {
			if (other.idKwt != null) {
				return false;
			}
		} else if (!idKwt.equals(other.idKwt)) {
			return false;
		}
		if (kLskId == null) {
			if (other.kLskId != null) {
				return false;
			}
		} else if (!kLskId.equals(other.kLskId)) {
			return false;
		}
		if (kodOrg == null) {
			if (other.kodOrg != null) {
				return false;
			}
		} else if (!kodOrg.equals(other.kodOrg)) {
			return false;
		}
		if (kprCem == null) {
			if (other.kprCem != null) {
				return false;
			}
		} else if (!kprCem.equals(other.kprCem)) {
			return false;
		}
		if (kprOt == null) {
			if (other.kprOt != null) {
				return false;
			}
		} else if (!kprOt.equals(other.kprOt)) {
			return false;
		}
		if (kprS == null) {
			if (other.kprS != null) {
				return false;
			}
		} else if (!kprS.equals(other.kprS)) {
			return false;
		}
		if (kprWr == null) {
			if (other.kprWr != null) {
				return false;
			}
		} else if (!kprWr.equals(other.kprWr)) {
			return false;
		}
		if (kul == null) {
			if (other.kul != null) {
				return false;
			}
		} else if (!kul.equals(other.kul)) {
			return false;
		}
		if (kwtKarm == null) {
			if (other.kwtKarm != null) {
				return false;
			}
		} else if (!kwtKarm.equals(other.kwtKarm)) {
			return false;
		}
		if (kwtLg == null) {
			if (other.kwtLg != null) {
				return false;
			}
		} else if (!kwtLg.equals(other.kwtLg)) {
			return false;
		}
		if (lpdt == null) {
			if (other.lpdt != null) {
				return false;
			}
		} else if (!lpdt.equals(other.lpdt)) {
			return false;
		}
		if (lsk == null) {
			if (other.lsk != null) {
				return false;
			}
		} else if (!lsk.equals(other.lsk)) {
			return false;
		}
		if (mProv == null) {
			if (other.mProv != null) {
				return false;
			}
		} else if (!mProv.equals(other.mProv)) {
			return false;
		}
		if (melLg == null) {
			if (other.melLg != null) {
				return false;
			}
		} else if (!melLg.equals(other.melLg)) {
			return false;
		}
		if (motN == null) {
			if (other.motN != null) {
				return false;
			}
		} else if (!motN.equals(other.motN)) {
			return false;
		}
		if (naborId == null) {
			if (other.naborId != null) {
				return false;
			}
		} else if (!naborId.equals(other.naborId)) {
			return false;
		}
		if (nd == null) {
			if (other.nd != null) {
				return false;
			}
		} else if (!nd.equals(other.nd)) {
			return false;
		}
		if (oPen == null) {
			if (other.oPen != null) {
				return false;
			}
		} else if (!oPen.equals(other.oPen)) {
			return false;
		}
		if (orgDolg == null) {
			if (other.orgDolg != null) {
				return false;
			}
		} else if (!orgDolg.equals(other.orgDolg)) {
			return false;
		}
		if (pechDog == null) {
			if (other.pechDog != null) {
				return false;
			}
		} else if (!pechDog.equals(other.pechDog)) {
			return false;
		}
		if (pschDt == null) {
			if (other.pschDt != null) {
				return false;
			}
		} else if (!pschDt.equals(other.pschDt)) {
			return false;
		}
		if (pschNac == null) {
			if (other.pschNac != null) {
				return false;
			}
		} else if (!pschNac.equals(other.pschNac)) {
			return false;
		}
		if (reu == null) {
			if (other.reu != null) {
				return false;
			}
		} else if (!reu.equals(other.reu)) {
			return false;
		}
		if (schEl == null) {
			if (other.schEl != null) {
				return false;
			}
		} else if (!schEl.equals(other.schEl)) {
			return false;
		}
		if (schGaz == null) {
			if (other.schGaz != null) {
				return false;
			}
		} else if (!schGaz.equals(other.schGaz)) {
			return false;
		}
		if (schelDt == null) {
			if (other.schelDt != null) {
				return false;
			}
		} else if (!schelDt.equals(other.schelDt)) {
			return false;
		}
		if (straDat == null) {
			if (other.straDat != null) {
				return false;
			}
		} else if (!straDat.equals(other.straDat)) {
			return false;
		}
		if (straKre == null) {
			if (other.straKre != null) {
				return false;
			}
		} else if (!straKre.equals(other.straKre)) {
			return false;
		}
		if (subData == null) {
			if (other.subData != null) {
				return false;
			}
		} else if (!subData.equals(other.subData)) {
			return false;
		}
		if (subNach == null) {
			if (other.subNach != null) {
				return false;
			}
		} else if (!subNach.equals(other.subNach)) {
			return false;
		}
		if (subPriz == null) {
			if (other.subPriz != null) {
				return false;
			}
		} else if (!subPriz.equals(other.subPriz)) {
			return false;
		}
		if (subsCor == null) {
			if (other.subsCor != null) {
				return false;
			}
		} else if (!subsCor.equals(other.subsCor)) {
			return false;
		}
		if (telData == null) {
			if (other.telData != null) {
				return false;
			}
		} else if (!telData.equals(other.telData)) {
			return false;
		}
		if (telNach == null) {
			if (other.telNach != null) {
				return false;
			}
		} else if (!telNach.equals(other.telNach)) {
			return false;
		}
		if (vvodEl == null) {
			if (other.vvodEl != null) {
				return false;
			}
		} else if (!vvodEl.equals(other.vvodEl)) {
			return false;
		}
		if (vvodGw == null) {
			if (other.vvodGw != null) {
				return false;
			}
		} else if (!vvodGw.equals(other.vvodGw)) {
			return false;
		}
		if (vvodOt == null) {
			if (other.vvodOt != null) {
				return false;
			}
		} else if (!vvodOt.equals(other.vvodOt)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ant == null) ? 0 : ant.hashCode());
		result = prime * result + ((avnEl == null) ? 0 : avnEl.hashCode());
		result = prime * result + ((balpl == null) ? 0 : balpl.hashCode());
		result = prime * result + ((bankId == null) ? 0 : bankId.hashCode());
		result = prime * result + ((bekpl == null) ? 0 : bekpl.hashCode());
		result = prime * result + ((cLskId == null) ? 0 : cLskId.hashCode());
		result = prime * result + ((comtel == null) ? 0 : comtel.hashCode());
		result = prime * result + ((dgw == null) ? 0 : dgw.hashCode());
		result = prime * result + ((dolgGes == null) ? 0 : dolgGes.hashCode());
		result = prime * result + ((dopGw == null) ? 0 : dopGw.hashCode());
		result = prime * result + ((dopHw == null) ? 0 : dopHw.hashCode());
		result = prime * result + ((dopKan == null) ? 0 : dopKan.hashCode());
		result = prime * result + ((dopMel == null) ? 0 : dopMel.hashCode());
		result = prime * result + ((dopOt == null) ? 0 : dopOt.hashCode());
		result = prime * result + ((dopPl == null) ? 0 : dopPl.hashCode());
		result = prime * result + ((dterrel == null) ? 0 : dterrel.hashCode());
		result = prime * result + ((dterrgw == null) ? 0 : dterrgw.hashCode());
		result = prime * result + ((dterrhw == null) ? 0 : dterrhw.hashCode());
		result = prime * result + ((elPl == null) ? 0 : elPl.hashCode());
		result = prime * result + ((endKnai == null) ? 0 : endKnai.hashCode());
		result = prime * result + ((fio == null) ? 0 : fio.hashCode());
		result = prime * result + ((fkKoop == null) ? 0 : fkKoop.hashCode());
		result = prime * result + ((gesLsk == null) ? 0 : gesLsk.hashCode());
		result = prime * result + ((grEl == null) ? 0 : grEl.hashCode());
		result = prime * result + ((grGv == null) ? 0 : grGv.hashCode());
		result = prime * result + ((grHv == null) ? 0 : grHv.hashCode());
		result = prime * result + ((grTr == null) ? 0 : grTr.hashCode());
		result = prime * result + ((gt == null) ? 0 : gt.hashCode());
		result = prime * result + ((houseId == null) ? 0 : houseId.hashCode());
		result = prime * result + ((idGw == null) ? 0 : idGw.hashCode());
		result = prime * result + ((idHw == null) ? 0 : idHw.hashCode());
		result = prime * result + ((idKwt == null) ? 0 : idKwt.hashCode());
		result = prime * result + ((kLskId == null) ? 0 : kLskId.hashCode());
		result = prime * result + ((kodOrg == null) ? 0 : kodOrg.hashCode());
		result = prime * result + ((kprCem == null) ? 0 : kprCem.hashCode());
		result = prime * result + ((kprOt == null) ? 0 : kprOt.hashCode());
		result = prime * result + ((kprS == null) ? 0 : kprS.hashCode());
		result = prime * result + ((kprWr == null) ? 0 : kprWr.hashCode());
		result = prime * result + ((kul == null) ? 0 : kul.hashCode());
		result = prime * result + ((kwtKarm == null) ? 0 : kwtKarm.hashCode());
		result = prime * result + ((kwtLg == null) ? 0 : kwtLg.hashCode());
		result = prime * result + ((lpdt == null) ? 0 : lpdt.hashCode());
		result = prime * result + ((lsk == null) ? 0 : lsk.hashCode());
		result = prime * result + ((mProv == null) ? 0 : mProv.hashCode());
		result = prime * result + ((melLg == null) ? 0 : melLg.hashCode());
		result = prime * result + ((motN == null) ? 0 : motN.hashCode());
		result = prime * result + ((naborId == null) ? 0 : naborId.hashCode());
		result = prime * result + ((nd == null) ? 0 : nd.hashCode());
		result = prime * result + ((oPen == null) ? 0 : oPen.hashCode());
		result = prime * result + ((orgDolg == null) ? 0 : orgDolg.hashCode());
		result = prime * result + ((pechDog == null) ? 0 : pechDog.hashCode());
		result = prime * result + ((pschDt == null) ? 0 : pschDt.hashCode());
		result = prime * result + ((pschNac == null) ? 0 : pschNac.hashCode());
		result = prime * result + ((reu == null) ? 0 : reu.hashCode());
		result = prime * result + ((schEl == null) ? 0 : schEl.hashCode());
		result = prime * result + ((schGaz == null) ? 0 : schGaz.hashCode());
		result = prime * result + ((schelDt == null) ? 0 : schelDt.hashCode());
		result = prime * result + ((straDat == null) ? 0 : straDat.hashCode());
		result = prime * result + ((straKre == null) ? 0 : straKre.hashCode());
		result = prime * result + ((subData == null) ? 0 : subData.hashCode());
		result = prime * result + ((subNach == null) ? 0 : subNach.hashCode());
		result = prime * result + ((subPriz == null) ? 0 : subPriz.hashCode());
		result = prime * result + ((subsCor == null) ? 0 : subsCor.hashCode());
		result = prime * result + ((telData == null) ? 0 : telData.hashCode());
		result = prime * result + ((telNach == null) ? 0 : telNach.hashCode());
		result = prime * result + ((vvodEl == null) ? 0 : vvodEl.hashCode());
		result = prime * result + ((vvodGw == null) ? 0 : vvodGw.hashCode());
		result = prime * result + ((vvodOt == null) ? 0 : vvodOt.hashCode());
		return result;
	}
	
}

