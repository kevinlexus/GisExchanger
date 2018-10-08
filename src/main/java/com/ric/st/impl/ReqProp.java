package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.mm.EolinkMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.excp.CantPrepSoap;

/**
 * Хранилище настроек SOAP запроса
 * @author lev
 *
 */
@Service
public class ReqProp implements ReqProps {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private SoapConfig config;
	@Value("${gisVersion}")
	private String gisVersion;

	Task foundTask;
	String houseGuid;
	String ppGuid;
	String reu;
	String kul;
	String nd;
	SoapBuilder sb;
	Eolink org;
	Integer appTp;
	/*
	 * Установить значения настроек
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setProp(Task task, SoapBuilder sb) throws CantPrepSoap {
		foundTask = em.find(Task.class, task.getId());
		Eolink eolink = task.getEolink();
		reu = eolink.getReu();
		kul = eolink.getKul();
		nd = eolink.getNd();
		houseGuid = eolink.getGuid();

		// получить PPGUID
		Eolink org = getOrgWithPPGUID(eolink, task);
		ppGuid = org.getGuid();
		appTp = org.getAppTp();

		this.sb = sb;
		sb.setPpGuid(ppGuid);
	}

	/**
	 * Получить рекурсивно eolink, содержащий PPGUID Организации и другие параметры
	 * @param eolink - текущий уровень объекта
	 * @param task - задание
	 * @return
	 * @throws CantPrepSoap
	 */
	private Eolink getOrgWithPPGUID(Eolink eolink, Task task) throws CantPrepSoap {
		Eolink eolFound = null;
		if (eolink.getObjTp().getCd().equals("Организация")/* && eolink.getParent() == null ред.04.09.2018*/) {
			// родительская организация
			if (eolink.getGuid() == null ) {
				// нет PPGUID
				throw new CantPrepSoap("Не заведен GUID организации по Task.id="+task.getId());
			} else {
				// вернуть объект, содержащий PPGUID
				eolFound = eolink;
			}
		} else {
			// не организация, или не родительская организация
			// получить объект, содержащий PPGUID, у уровня выше
			eolFound = getOrgWithPPGUID(eolink.getParent(), task);
		}
		return eolFound;

	}

	/*
	 * Установить значения настроек
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap {
		foundTask = em.find(Task.class, task.getId());
		if (task.getEolink() != null) {
			reu = task.getEolink().getReu();
			kul = task.getEolink().getKul();
			nd = task.getEolink().getNd();
			houseGuid = task.getEolink().getGuid();
		}
		// GUID текущей организации
		this.sb = sb;
		sb.setPpGuid(config.getOrgPPGuid());
	}

	@Override
	public Task getFoundTask() {
		return foundTask;
	}

	@Override
	public String getHouseGuid() {
		return houseGuid;
	}

	@Override
	public String getReu() {
		return reu;
	}

	@Override
	public String getKul() {
		return kul;
	}

	@Override
	public String getNd() {
		return nd;
	}

	@Override
	public Eolink getOrg() {
		return org;
	}

	@Override
	public Integer getAppTp() {
		return appTp;
	}

	@Override
	public String getGisVersion() {
		return gisVersion;
	}

}
