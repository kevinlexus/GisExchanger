package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dic.bill.mm.EolinkParMng;
import com.ric.cmn.excp.WrongGetMethod;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class ReqProp implements ReqProps {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private EolinkParMng eolParMng;
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
	String hostIp;
	SoapBuilder sb;
	Integer appTp;
	// УК по данному Task
	Eolink uk;

	/*
	 * Установить значения настроек до создания объекта SoapBuilder
	 */
	@Override
	public void setPropBefore(Task task) throws CantPrepSoap {
		//foundTask = em.find(Task.class, task.getId());
		Eolink eolink = task.getEolink();
		reu = eolink.getReu();
		kul = eolink.getKul();
		nd = eolink.getNd();
		houseGuid = eolink.getGuid();

		// получить УК
		Eolink uk = getUkByTaskEolink(eolink, task);
		ppGuid = uk.getGuid();
		appTp = uk.getAppTp();

		// IP адрес сервиса STUNNEL, получить или из application.properties - hostIp (Кис, Полыс)
		// или из параметра по УК (ТСЖ Содружество, Свободы)
		hostIp =  null;
		if (config.getHostIp() == null || config.getHostIp().isEmpty()) {
			try {
				hostIp = eolParMng.getStr(uk, "ГИС ЖКХ.HOST_IP");
			} catch (WrongGetMethod wrongGetMethod) {
				wrongGetMethod.printStackTrace();
				throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.HOST_IP' по организации Eolink.id="+uk.getId());
			}
			if (hostIp==null) {
				throw new CantPrepSoap("Не заполнен параметр hostIp по организации Eolink.id="+uk.getId()
						+"(ТСЖ Свобод) либо не заполнен application.properties - hostIp (Кис.Полыс.)");
			}
		} else {
			hostIp = config.getHostIp();
		}
		//log.info("Использованный hostIp={}", hostIp);
	}

	/*
	 * Установить значения настроек после создания объекта SoapBuilder
	 */
	@Override
	public void setPropAfter(Task task) {
		// найти Task, для использования в транзации
		foundTask = em.find(Task.class, task.getId());
	}

	/*
	 * Установить значения настроек после создания объекта SoapBuilder
	 */
/*
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setPropAfter(Task task, SoapBuilder sb) throws CantPrepSoap {
		this.sb = sb;
		// GUID организации от которой выполняется запрос
		sb.setPpGuid(ppGuid);
		// IP адрес сервиса STUNNEL
		//log.info("Использованный hostIp2={}", hostIp);
		//sb.setHostIp(hostIp);
	}
*/

	/*
	 * Установить значения настроек
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap {
		//foundTask = em.find(Task.class, task.getId());
		if (task.getEolink() != null) {
			reu = task.getEolink().getReu();
			kul = task.getEolink().getKul();
			nd = task.getEolink().getNd();
			houseGuid = task.getEolink().getGuid();
		}
		// GUID текущей организации
		this.sb = sb;
		this.ppGuid = config.getOrgPPGuid();
	}

	/**
	 * Получить рекурсивно eolink УК, содержащий PPGUID Организации и другие параметры
	 * @param eolink - текущий объект
	 * @param task - задание
	 * @return
	 * @throws CantPrepSoap
	 */
	private Eolink getUkByTaskEolink(Eolink eolink, Task task) throws CantPrepSoap {
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
			eolFound = getUkByTaskEolink(eolink.getParent(), task);
		}
		return eolFound;

	}

	@Override
	public Task getFoundTask() {
		//return em.find(Task.class, task.getId());
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
	public Integer getAppTp() {
		return appTp;
	}

	@Override
	public String getGisVersion() {
		return gisVersion;
	}

	public String getPpGuid() {
		return ppGuid;
	}
	public String getHostIp() {
		return hostIp;
	}
}
