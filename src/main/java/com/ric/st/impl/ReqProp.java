package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.mm.EolinkMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.excp.CantPrepSoap;

import lombok.extern.slf4j.Slf4j;

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
		reu = task.getEolink().getReu();
		kul = task.getEolink().getKul();
		nd = task.getEolink().getNd();
		houseGuid = task.getEolink().getGuid();
		if (reu == null) {
			// нет кода РЭУ
			throw new CantPrepSoap("Нет кода рэу в Eolink.reu по Task.id="+task.getId());
		}
		// Установить PPGUID
		org = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация");
		if (org == null) {
			// нет Организации
			throw new CantPrepSoap("Не заведена запись организации в Eolink по Task.id="+task.getId());
		}
		ppGuid = org.getGuid();
		if (ppGuid == null) {
			// нет Организации
			throw new CantPrepSoap("Не заведен GUID организации по Task.id="+task.getId());
		}
		appTp = org.getAppTp();
		if (appTp == null) {
			// нет типа Приложения
			throw new CantPrepSoap("Не заведен appTp приложения по Eolink.id="+org.getId());
		}
		
		sb.setPpGuid(ppGuid);
	}
	
	/* 
	 * Установить значения настроек
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap {
		foundTask = em.find(Task.class, task.getId());
		reu = task.getEolink().getReu();
		kul = task.getEolink().getKul();
		nd = task.getEolink().getNd();
		houseGuid = task.getEolink().getGuid();
		// GUID текущей организации
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
	public String getPpGuid() {
		return ppGuid;
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

}
