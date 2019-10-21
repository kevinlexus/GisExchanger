package com.ric.st.impl;

import com.dic.bill.dao.OrgDAO;
import com.dic.bill.mm.EolinkParMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.scott.Org;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.st.ReqProps;
import com.ric.st.excp.CantPrepSoap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Хранилище настроек SOAP запроса
 *
 * @author lev
 */
@Slf4j
@Service
public class ReqProp implements ReqProps {

    @PersistenceContext
    private EntityManager em;
    private final EolinkParMng eolParMng;
    private final OrgDAO orgDAO;
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
    // УК по данному Task в виде объекта EOLINK
    private Eolink eolinkUk;
    // УК по данному Task в виде объекта T_ORG
    private Org uk;
    // Id подписчика XML (если hostIp не заполнен, то определяется по УК)
    private int signerId;

    public ReqProp(EolinkParMng eolParMng, OrgDAO orgDAO, SoapConfig config) {
        this.eolParMng = eolParMng;
        this.orgDAO = orgDAO;
        this.config = config;
    }

    /*
     * Установить значения настроек до создания объекта SoapBuilder
     */
    @Override
    public void setPropBefore(Task task) throws CantPrepSoap {
        Eolink eolink = task.getEolink();
        this.uk = orgDAO.getByReu(eolink.getOrg().getReu()); // ред.08.08.2019		this.reu = eolink.getUk().getReu(); // ред.07.08.2019
        kul = eolink.getKul();
        nd = eolink.getNd();
        houseGuid = eolink.getGuid();

        // получить УК
        if (task.getProcUk() == null) {
            eolinkUk = getUkByTaskEolink(eolink, task);
        } else {
            eolinkUk = task.getProcUk();
        }
        ppGuid = eolinkUk.getGuid();
        if (ppGuid == null) {
            throw new CantPrepSoap("Не заполнен GUID организации EOLINK.ID=" + eolinkUk.getId());
        }
/*
        if (ppGuid == null) {
            ppGuid = eolinkUk.getGuid2();
            if (ppGuid == null) {
                throw new CantPrepSoap("Не заполнен GUID организации EOLINK.ID="+eolinkUk.getId());
            }
            log.warn("Выполнена подстановка GUID по организации EOLINK.ID={}", eolinkUk.getId());
        }
*/

        // IP адрес сервиса STUNNEL, получить или из application.properties - hostIp (Кис, Полыс)
        // или из параметра по УК (ТСЖ Содружество, Свободы)
        hostIp = null;
        if (config.getHostIp() == null || config.getHostIp().isEmpty()) {
            try {
                hostIp = eolParMng.getStr(eolinkUk, "ГИС ЖКХ.HOST_IP");
            } catch (WrongGetMethod wrongGetMethod) {
                wrongGetMethod.printStackTrace();
                throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.HOST_IP' по организации Eolink.id=" + eolinkUk.getId());
            }
            if (hostIp == null) {
                throw new CantPrepSoap("Не заполнен параметр hostIp по организации Eolink.id=" + eolinkUk.getId()
                        + "(ТСЖ Свобод) либо не заполнен application.properties - hostIp (Кис.Полыс.)");
            }
            try {
                Double signerIdD = eolParMng.getDbl(eolinkUk, "ГИС ЖКХ.SIGNER_ID");
                signerId = signerIdD.intValue();
            } catch (WrongGetMethod wrongGetMethod) {
                wrongGetMethod.printStackTrace();
                throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.SIGNER_ID' по организации Eolink.id=" + eolinkUk.getId());
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

        // IP адрес сервиса STUNNEL, получить или из application.properties - hostIp (Кис, Полыс)
        // или из параметра по УК (ТСЖ Содружество, Свободы)
        hostIp = null;
        if (config.getHostIp() == null || config.getHostIp().isEmpty()) {
            try {
                hostIp = eolParMng.getStr(uk, "ГИС ЖКХ.HOST_IP");
            } catch (WrongGetMethod wrongGetMethod) {
                wrongGetMethod.printStackTrace();
                throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.HOST_IP' по организации Eolink.id=" + uk.getId());
            }
            if (hostIp == null) {
                throw new CantPrepSoap("Не заполнен параметр hostIp по организации Eolink.id=" + uk.getId()
                        + "(ТСЖ Свобод) либо не заполнен application.properties - hostIp (Кис.Полыс.)");
            }
            try {
                Double signerIdD = eolParMng.getDbl(uk, "ГИС ЖКХ.SIGNER_ID");
                signerId = signerIdD.intValue();
            } catch (WrongGetMethod wrongGetMethod) {
                wrongGetMethod.printStackTrace();
                throw new CantPrepSoap("Ошибка при получении параметра 'ГИС ЖКХ.SIGNER_ID' по организации Eolink.id=" + uk.getId());
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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void setPropWOGUID(Task task, SoapBuilder sb) {
        foundTask = em.find(Task.class, task.getId());
        if (task.getEolink() != null) {
            // reu = task.getEolink().getReu();
            reu = task.getEolink().getOrg().getReu(); // ред.07.08.2019
            kul = task.getEolink().getKul();
            nd = task.getEolink().getNd();
            houseGuid = task.getEolink().getGuid();
        }
        // GUID текущей организации
        this.ppGuid = config.getOrgPPGuid();
    }

    /**
     * Получить рекурсивно eolink УК, содержащий PPGUID Организации и другие параметры
     *
     * @param eolink - текущий объект
     * @param task   - задание
     */
    private Eolink getUkByTaskEolink(Eolink eolink, Task task) throws CantPrepSoap {
        Eolink eolFound;
        if (eolink.getObjTp().getCd().equals("Организация")) {
            // родительская организация
            if (eolink.getGuid() == null/* && eolink.getGuid2() == null */) {
                // нет PPGUID
                throw new CantPrepSoap("Не заведен GUID организации по Task.id=" + task.getId());
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
    public Eolink getEolinkUk() {
        return eolinkUk;
    }

    @Override
    public Org getUk() {
        return uk;
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
    public int getSignerId() {
        return signerId;
    }
}
