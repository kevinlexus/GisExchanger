package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.mm.EolinkParMng;
import com.ric.cmn.excp.WrongGetMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	private final EolinkParMng eolParMng;
	private final EolinkDAO eolinkDAO;
	private final SoapConfig config;

	@Value("${gisVersion}")
	private String gisVersion;

	private Task foundTask;
	private String houseGuid;
	private String ppGuid;
	private String reu;
	private String kul;
	private String nd;
	private String hostIp;
	// УК по данному Task
	private Eolink uk;
	// Id подписчика XML (если hostIp не заполнен, то определяется по УК)
	private int signerId;

	public ReqProp(EolinkParMng eolParMng, EolinkDAO eolinkDAO, SoapConfig config) {
		this.eolParMng = eolParMng;
		this.eolinkDAO = eolinkDAO;
		this.config = config;
	}

	/*
	 * Установить значения настроек до создания объекта SoapBuilder
	 */
	@Override
	public void setPropBefore(Task task) throws CantPrepSoap {
		Eolink eolink = task.getEolink();
		this.reu = eolink.getReu();
		kul = eolink.getKul();
		nd = eolink.getNd();
		houseGuid = eolink.getGuid();

		Eolink uk;
		// получить УК
		if (task.getProcUk() == null) {
			uk = getUkByTaskEolink(eolink, task);
		} else {
			uk = task.getProcUk();
		}
		ppGuid = uk.getGuid();

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
			try {
				Double signerIdD = eolParMng.getDbl(uk, "ГИС ЖКХ.SIGNER_ID");
				signerId = signerIdD.intValue();
			} catch (WrongGetMethod wrongGetMethod) {
				wrongGetMethod.printStackTrace();
				throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.SIGNER_ID' по организации Eolink.id="+uk.getId());
			}
		} else {
			signerId = 1;
			hostIp = config.getHostIp();
		}
	}

	/*
	 * Установить значения настроек до создания объекта SoapBuilder для простых запросов,
	 * типа получения параметров организации
	 *
	 */
	@Override
	public void setPropBeforeSimple(Task task) throws CantPrepSoap {
		// получить GUID организации с уровня РКЦ
		Eolink uk = task.getEolink();
		ppGuid = uk.getParent().getGuid();
		//appTp = uk.getAppTp();

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
			try {
				Double signerIdD = eolParMng.getDbl(uk, "ГИС ЖКХ.SIGNER_ID");
				signerId = signerIdD.intValue();
			} catch (WrongGetMethod wrongGetMethod) {
				wrongGetMethod.printStackTrace();
				throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.SIGNER_ID' по организации Eolink.id="+uk.getId());
			}
		} else {
			signerId = 1;
			hostIp = config.getHostIp();
		}
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
		foundTask = em.find(Task.class, task.getId());
		if (task.getEolink() != null) {
			reu = task.getEolink().getReu();
			kul = task.getEolink().getKul();
			nd = task.getEolink().getNd();
			houseGuid = task.getEolink().getGuid();
		}
		// GUID текущей организации
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
	public Eolink getUk() {
		return uk;
	}

	@Override
	public Integer getAppTp() {
		return 2; // всегда возвращать 2 - эксперементальная разработка
	}

	@Override
	public String getGisVersion() {
		return gisVersion;
	}

	@Override
	public String getPpGuid() {
		return ppGuid;
	}
	@Override
	public String getHostIp() {
		return hostIp;
	}
	@Override
	public int getSignerId() {	return signerId; }
}
