package com.ric.st.impl;

import com.dic.bill.dao.UserDAO;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.sec.User;
import com.ric.cmn.excp.UnusableCode;
import com.ric.st.SoapConfigs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SoapConfig implements SoapConfigs {


    private final UserDAO userDao;
    @Value("${baseOrgGUID}")
    private String baseOrgGUID;
    @Value("${fingerPrint}")
    private String fingerPrint;
    @Value("${basicPass}")
    private String basicPass;
    @Value("${basicLogin}")
    private String basicLogin;

    @Value("${signPass}")
    private String signPass;
    @Value("${signPath:#{null}}")
    private String signPath;

    @Value("${signPass2:#{null}}")
    private String signPass2;
    @Value("${signPath2:#{null}}")
    private String signPath2;

    @Value("${hostIp}")
    private String hostIp;

    // Пользователь, от имени которого выполняются процессы
    private User user;

    public SoapConfig(UserDAO userDao) {
        this.userDao = userDao;
    }

    // среда выполнения
    public int getEnv() {
        return 0; // HOTORA
        //return 1; Direct (на прямую))
    }

    /**
     * Получить OrgPPGUID организации
     */
    public String getOrgPPGuid() {
        // Базовый GUID организации, осуществляющей обмен! (для справочников NSI и т.п.)

        //return "9b051b50-937d-44f7-b03b-ff621d84ea3d"; // МП "РИЦ" (СИТ-2)
        //return "d2bf560f-bccb-41d0-8c7a-54de0c5049ec"; // МП "РИЦ" (Пром)
        return baseOrgGUID;


        //return "b9fe4d27-020d-44dc-8bfd-b5972a504f45"; // Металлплощадка (СИТ-2)
        //return "b21dadf0-e7e6-4824-aa04-19bd617bb3e1"; // ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ "УПРАВЛЯЮЩАЯ КОМПАНИЯ ЖИЛКОМСЕРВИС"  (Пром)
        //return null;
        //return "a81aaf05-6afd-4795-b40c-f62b82c350b5"; // ООО "УК Металлплощадка" (СИТ-1) взято на странице Личный кабинет -> Информационные системы -> Поставщики инф.
        //return "44de0b23-6e64-4f5c-ab56-d7c67e4c8f55"; // ТСЖ " АПРЕЛЬ" (Пром)

        //return null;
    }

    /**
     * Получить URL endpoint
     */
    public String getHostIp() {
        return hostIp;
        //	return "http://127.0.0.1:8080";
//		return "http://217.107.108.147:10082";
//		return "http://217.107.108.156:10082";
//		return "http://api.dom.gosuslugi.ru:443";
    }

    /**
     * Тестовый режим? (стучаться ли на тестовые сервера?)
     */
    public boolean isSrvTest() {
        return true;
    }

    /**
     * Получить fingerprint
     */
    public String getFingerPrint() {
        return fingerPrint;
        //return "2021d448e368a0b39c2bfcd4435574c05ca8c435";
    }

    /**
     * Получить логин basic-авторизации
     */
    public String getBscLogin() {
        return basicLogin;
        //return "sit";
    }

    /**
     * Получить пароль basic-авторизации
     */
    public String getBscPass() {
        //return "rZ_GG72XS^Vf55ZW";
        return basicPass;
        //return "xw{p&&Ee3b9r8?amJv*]";
    }

    /**
     * Вернуть префикс CD элементов в справочниках локальной системы
     */
    public String getPrefixGis() {
        return "GIS";
    }

    public void setXmlLog() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
    }

    public Boolean setUp(Boolean isLoadRef) {
        log.info("загрузка данных пользователя");
        this.user = userDao.getByCd("GEN");
        return true;
    }

    /**
     * Вернуть пользователя, от имени которого выполняются процессы
     */
    public User getCurUser() {
        return this.user;
    }

    /**
     * Получить объект уровня РКЦ - по объекту типа Дом
     *
     * @param house - объект Eolink - дом
     */
    @Override
    public Eolink getRkcByHouse(Eolink house) {
        Eolink uk = house.getParent();
        return uk.getParent();
    }

    public String getSignPass() {
        return signPass;
    }

    public String getSignPath() {
        return signPath;
    }

    public String getSignPass2() {
        return signPass2;
    }

    public String getSignPath2() {
        return signPath2;
    }

    /**
     * Сохранить ошибки
     *
     * @param eolink - объект
     * @param mask   - битовый код маски
     */
    @Override
    public void saveError(Eolink eolink, long mask, boolean isSet) throws UnusableCode {
        //log.info("******* saveError Eolink.id={}, set={}, err={}", eolink.getId(), isSet, mask);
        long errPrev = 0L, errActual;
        if (eolink.getErr() != null) {
            errPrev = eolink.getErr();
        }
        if (isSet) {
            // совместить биты ошибки с источником
            errActual = errPrev | mask;
        } else {
            // обнулить соответствующие биты ошибки
            errActual = errPrev & (~mask);
        }
        if (errPrev != errActual) {
            //log.info("******* SAVE Eolink.id={}, set={}, err={}", eolink.getId(), isSet, mask);
            // сохранить в случае изменения значения
            String comm = CommonUtl.getErrorDescrByCode(errActual);
            eolink.setComm(comm);
            eolink.setErr(errActual);
        }
    }

}
