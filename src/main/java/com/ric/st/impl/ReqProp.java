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

import lombok.extern.slf4j.Slf4j;

/**
 * Хранилище настроек SOAP запроса
 * @author lev
 *
 */
@Slf4j
@Service
public class ReqProp implements ReqProps {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkMng eolinkMng;
	
	Task foundTask;
	String houseGuid;
	String ppGuid;
	String reu;
	String kul;
	String nd;
	SoapBuilder sb;
	/* 
	 * Установить значения настроек
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setVal(Task task, SoapBuilder sb) {
		foundTask = em.find(Task.class, task.getId());
		String reu = task.getEolink().getReu();
		String kul = task.getEolink().getKul();
		String nd = task.getEolink().getNd();
		houseGuid = task.getEolink().getGuid();
		// Установить PPGUID
		ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
	}
	
	public Task getFoundTask() {
		return foundTask;
	}

	public String getHouseGuid() {
		return houseGuid;
	}

	public String getPpGuid() {
		return ppGuid;
	}

	public String getReu() {
		return reu;
	}

	public String getKul() {
		return kul;
	}

	public String getNd() {
		return nd;
	}
	
}
