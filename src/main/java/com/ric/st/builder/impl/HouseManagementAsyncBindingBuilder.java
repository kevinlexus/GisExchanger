package com.ric.st.builder.impl;


import com.dic.bill.dao.*;
import com.dic.bill.dto.HouseUkTaskRec;
import com.dic.bill.mm.*;
import com.dic.bill.model.bs.AddrTp;
import com.dic.bill.model.bs.Lst2;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.Ulist;
import com.dic.bill.model.scott.*;
import com.diffplug.common.base.Errors;
import com.ric.cmn.Utl;
import com.ric.cmn.excp.*;
import com.ric.st.CommonErrs;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.dao.UlistDAO;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.RetStateHouse;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.*;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.*;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.util.*;

/**
 * Сервис обмена информацией с ГИС ЖКХ по Дому
 *
 * @author Leo
 * @version 1.04
 */
@Slf4j
@Service
public class HouseManagementAsyncBindingBuilder implements HouseManagementAsyncBindingBuilders {

    private final ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
    private final UlistMng ulistMng;
    private final SoapConfig config;
    private final TaskParMng taskParMng;
    private final EolinkDAO eolinkDao;
    private final EolinkDAO2 eolinkDao2;
    private final AddrTpDAO addrTpDAO;
    private final OrgDAO orgDAO;
    private final UlistDAO ulistDAO;
    private final EolinkParMng eolinkParMng;
    private final TaskEolinkParMng teParMng;
    private final TaskDAO taskDao;
    private final KartMng kartMng;
    private final EolinkMng eolinkMng;
    private final TaskMng taskMng;
    private final LstMng lstMng;
    private final ReqProps reqProp;
    private final SoapConfigs soapConfig;
    private final MeterMng meterMng;
    private final PseudoTaskBuilders ptb;

    private HouseManagementPortsTypeAsync port;
    private SoapBuilder sb;

    @Autowired
    public HouseManagementAsyncBindingBuilder(UlistMng ulistMng, ApplicationContext ctx, SoapConfig config,
                                              TaskParMng taskParMng, EolinkDAO eolinkDao, EolinkDAO2 eolinkDao2, AddrTpDAO addrTpDAO, OrgDAO orgDAO, UlistDAO ulistDAO, EolinkParMng eolinkParMng,
                                              TaskEolinkParMng teParMng, TaskMng taskMng, PseudoTaskBuilders ptb,
                                              ReqProps reqProp, MeterMng meterMng, TaskDAO taskDao,
                                              SoapConfigs soapConfig, KartMng kartMng,
                                              EolinkMng eolinkMng, LstMng lstMng) {
        this.ulistMng = ulistMng;
        this.ctx = ctx;
        this.config = config;
        this.taskParMng = taskParMng;
        this.eolinkDao = eolinkDao;
        this.eolinkDao2 = eolinkDao2;
        this.addrTpDAO = addrTpDAO;
        this.orgDAO = orgDAO;
        this.ulistDAO = ulistDAO;
        this.eolinkParMng = eolinkParMng;
        this.teParMng = teParMng;
        this.taskMng = taskMng;
        this.ptb = ptb;
        this.reqProp = reqProp;
        this.meterMng = meterMng;
        this.taskDao = taskDao;
        this.soapConfig = soapConfig;
        this.kartMng = kartMng;
        this.eolinkMng = eolinkMng;
        this.lstMng = lstMng;
    }

    /**
     * Инициализация - создать сервис и порт
     */
    @Override
    public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
        HouseManagementServiceAsync service;
        service = new HouseManagementServiceAsync();
        port = service.getHouseManagementPortAsync();

        // подоготовительный объект для SOAP
        sb = ctx.getBean(SoapBuilder.class);
        reqProp.setPropBefore(task);
        sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(), reqProp.getHostIp());

        // логгинг запросов, по умолчанию
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        // Id XML подписчика
        sb.setSignerId(reqProp.getSignerId());
    }


    /**
     * Старый вызов получения статуса запроса
     *
     * @param ack - запрос
     */
    public RetStateHouse getState(AckRequest ack) {
        boolean err = false;
        String errStr = null;
        ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state = null;

        GetStateRequest gs = new GetStateRequest();
        gs.setMessageGUID(ack.getAck().getMessageGUID());
        sb.setSign(false); // не подписывать запрос состояния!

        int i = 2;
        int timeout = 0;
        while (!err && (state == null || state.getRequestState() != 3)) {
            sb.makeRndMsgGuid();
            try {
                state = port.getState(gs);
            } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e) {
                e.printStackTrace();
                err = true;
                errStr = "Запрос вернул ошибку!";
            }
            // задержка
            try {
                timeout = 100 * i;
                i = i * 2;
                log.info("timeout={}", timeout);
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (timeout > 36000000) {
                // не более 10 часов выполнить проверку запроса
                err = true;
                errStr = "Превышено время выполнения запроса!";
            } else {
                if (state == null) {
                    err = true;
                    errStr = "ОШИБКА! state == null";
                } else {
                    log.info("Статус запроса={}", state.getRequestState());
                }
            }
        }

        // Показать ошибки, если есть
        if (err) {
            // Ошибки во время выполнения
            log.info(errStr);
        } else if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
            // Прочие ошибки
            err = true;
            errStr = state.getErrorMessage().getDescription();
            log.info("Ошибка выполнения запроса = {}", errStr);
        }

        return new RetStateHouse(state, err, errStr);

    }


    /**
     * Получить состояние запроса
     *
     * @param task - задание
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public GetStateResult getState2(Task task) {
        // Признак ошибки
        boolean err = false;
        // Признак ошибки в CommonResult
        String errStr = null;
        ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state = null;

        GetStateRequest gs = new GetStateRequest();
        gs.setMessageGUID(task.getMsgGuid());
        sb.setSign(false); // не подписывать запрос состояния!

        sb.makeRndMsgGuid();
        String errMsg = null;
        try {
            state = port.getState(gs);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e) {
            errMsg = e.getFaultInfo().getErrorCode();
            e.printStackTrace();
            err = true;
            errStr = "Запрос вернул ошибку!";
        }

        if (state != null && state.getRequestState() != 3) {
            // вернуться, если задание всё еще не выполнено
            log.info("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());

            if (state.getRequestState() == 1) {
                // статус запроса - ACK - увеличить время ожидания + 10 секунд
                task.alterDtNextStart(10);
            }
            return null;
        }

        // Показать ошибки, если есть
        if (err) {
            // Ошибки во время выполнения
            log.info(errStr);
            task.setState("ERR");
            task.setResult(errStr);
            reqProp.getFoundTask().setResult(errMsg);
            log.error("Task.id={}, ОШИБКА выполнения запроса = {}", task.getId(), errStr);
        } else {
            if (state == null) {
                log.error("ОШИБКА! state==null");
            } else if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
                // Ошибки контролей или бизнес-процесса
                errStr = state.getErrorMessage().getDescription();
                log.info("Ошибка выполнения запроса = {}", errStr);
                task.setState("ERR");
                task.setResult(errStr);
            }
        }

        return state;

    }


    /**
     * Экспортировать данные счетчиков
     *
     * @param task - задание
     * @throws CantPrepSoap                   - не может приготовить SOAP сообщение
     * @throws WrongGetMethod                 - некорректное получение параметра
     * @throws DatatypeConfigurationException - ошибка типа
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
        taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        AckRequest ack = null;

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ExportMeteringDeviceDataRequest req = new ExportMeteringDeviceDataRequest();

        req.setId("foo");
        //sb.setSign(true);
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        if (task.getGuid() != null) {
            // По GUID еще не созданного счетчика
            req.setMeteringDeviceRootGUID(task.getGuid());
        } else if (task.getEolink() != null) {
            // По дому
            req.setFIASHouseGuid(task.getEolink().getGuid());
        } else {
            throw new CantPrepSoap("Не указан один из объектов для выгрузки счетчиков!");
        }

        // искать архивные
        Boolean searchArch = taskParMng.getBool(task, "ГИС ЖКХ.Включая архивные");
        req.setSearchArchived(searchArch);
        if (searchArch) {
            req.setArchiveDateFrom(Utl.getXMLDate(taskParMng.getDate(task, "ГИС ЖКХ.Начальная дата архивации")));
            req.setArchiveDateTo(Utl.getXMLDate(taskParMng.getDate(task, "ГИС ЖКХ.Конечная дата архивации")));
        }

        try {
            ack = port.exportMeteringDeviceData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }

        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }

    }


    /**
     * Получить результат экспорта счетчиков
     *
     * @throws ErrorProcessAnswer - ошибка процессинга ответа
     * @throws WrongGetMethod     - ошибка получения параметра
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict(value = {"EolinkDAOImpl.getEolinkByGuid"}, allEntries = true) // здесь Evict потому что
    // пользователь может обновить Ko объекта счетчика мз Директа(осуществить привязку)
    // и тогда должен быть получен обновленный объект! ред.07.12.18
    public void exportDeviceDataAsk(Task task) throws ErrorProcessAnswer, WrongGetMethod, UnusableCode {
        taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        Eolink houseEol = reqProp.getFoundTask().getEolink();

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());
        if (retState == null) {
            // не обработано
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {

            // автоматическое связывание счетчика с SCOTT.METER в Директ
            Boolean autoBind = taskParMng.getBool(task, "ГИС ЖКХ.AUTO_CONNECT_DIRECT");
            log.info("autoBind={}", autoBind);
            // Ошибок не найдено
            for (ExportMeteringDeviceDataResultType t : retState.getExportMeteringDeviceDataResult()) {
                // тип счетчика: 0 - жилой ИПУ, 1 - не жилой ИПУ, 2 - общедомовой ПУ
                int meterTp;
                log.trace("Получен счетчик:");
                log.trace("Root GUID={}", t.getMeteringDeviceRootGUID());
                log.trace("Version GUID={}", t.getMeteringDeviceVersionGUID());
                log.trace("GISGKHNumber={}", t.getMeteringDeviceGISGKHNumber());
                log.trace("Серийный номер={}", t.getBasicChatacteristicts().getMeteringDeviceNumber());

                String premiseGUID;
                if (t.getBasicChatacteristicts().getResidentialPremiseDevice() != null) {
                    // Счетчик жилого помещения
                    // получить GUID помещения
                    meterTp = 0;
                    // получить первый элемент (в биллинге Директ, только привязка One to One)
                    premiseGUID = t.getBasicChatacteristicts().getResidentialPremiseDevice().getPremiseGUID().get(0);
                    log.trace("Cчетчик ЖИЛОГО помещения, GUID={}", premiseGUID);
                } else if (t.getBasicChatacteristicts().getNonResidentialPremiseDevice() != null) {
                    // Счетчик нежилого помещения
                    // получить GUID помещения
                    // получить первый элемент (в биллинге Директ, только привязка One to One)
                    premiseGUID = t.getBasicChatacteristicts().getNonResidentialPremiseDevice().getPremiseGUID().get(0);
                    log.trace("Cчетчик НЕЖИЛОГО помещения, GUID={}", premiseGUID);
                    meterTp = 1;
                } else if (t.getBasicChatacteristicts().getApartmentHouseDevice() != null) {
                    log.error("Необрабатываемый тип счетчика - ПУ жилого дома: Root GUID={}",
                            t.getMeteringDeviceRootGUID());
                    continue;
                } else if (t.getBasicChatacteristicts().getCollectiveApartmentDevice() != null) {
                    log.error("Необрабатываемый тип счетчика - общеквартирный ПУ "
                            + "(для квартир коммунального заселения): Root GUID={}", t.getMeteringDeviceRootGUID());
                    continue;
                } else if (t.getBasicChatacteristicts().getCollectiveDevice() != null) {
                    log.trace("Счетчик - общедомовой ПУ: GUID={}", houseEol.getGuid());
                    premiseGUID = houseEol.getGuid();
                    meterTp = 2;
                } else if (t.getBasicChatacteristicts().getLivingRoomDevice() != null) {
                    log.error("Необрабатываемый тип счетчика - комнатный ПУ "
                            + ": Root GUID={}", t.getMeteringDeviceRootGUID());
                    continue;
                } else {
                    // Прочие типы не обрабатывать
                    log.error("Необрабатываемый тип счетчика прочего типа: Root GUID={}",
                            t.getMeteringDeviceRootGUID());
                    continue;
                }

                // найти корневую запись счетчика
                Eolink rootEol = eolinkDao.getEolinkByGuid(t.getMeteringDeviceRootGUID());
                // найти версию счетчика, по GUID
                Eolink versionEol = eolinkDao.getEolinkByGuid(t.getMeteringDeviceVersionGUID());
                // найти помещение, к которому прикреплен счетчик
                Eolink premiseEol = eolinkDao.getEolinkByGuid(premiseGUID);

                if (rootEol == null) {
                    // не найдено, создать новую корневую запись счетчика
                    AddrTp addrTp = lstMng.getAddrTpByCD("СчетчикФизический");

                    if (meterTp == 0 || meterTp == 1) {
                        // счетчик жилых или нежилых помещений
                        rootEol = Eolink.builder()
                                .withGuid(t.getMeteringDeviceRootGUID())
                                .withUn(t.getMeteringDeviceGISGKHNumber())
                                .withObjTp(addrTp)
                                .withParent(premiseEol)
                                .withUser(config.getCurUser())
                                .withStatus(1).build();
                    } else {
                        // счетчик общедомовой
                        rootEol = Eolink.builder()
                                .withGuid(t.getMeteringDeviceRootGUID())
                                .withUn(t.getMeteringDeviceGISGKHNumber())
                                .withObjTp(addrTp)
                                .withParent(premiseEol)
                                .withUser(config.getCurUser())
                                .withStatus(1).build();
                    }

                    log.trace("Попытка создать запись корневого счетчика в Eolink: GUID={}", t.getMeteringDeviceRootGUID());
                    em.persist(rootEol);

                }

                // обновить параметры созданного счетчика или уже имеющегося
                if (Utl.nvl(rootEol.getStatus(), 0) == 1 && t.getStatusRootDoc().equals("Archival")) {
                    // счетчик активный, отметить архивным
                    rootEol.setStatus(0);
                    log.trace("Попытка отметить счетчик АРХИВНЫМ");
                } else if (Utl.nvl(rootEol.getStatus(), 0) != 1 && t.getStatusRootDoc().equals("Active")) {
                    // счетчик архивный, отметить активным
                    rootEol.setStatus(1);
                    log.trace("Попытка отметить счетчик АКТИВНЫМ");
                }

/*
                if (rootEol.getGuid().equals("7552c05e-d80b-4573-a2ba-6a99d587274f")
                        || rootEol.getGuid().equals("108f346e-a33b-4c43-a345-bfd011c7af19")) {
                    log.trace("--------------{}, {}----{}------",
                            t.getMunicipalResourceEnergy(), t.getMunicipalResourceNotEnergy(), t.getMunicipalResources());
                }

*/
                log.trace("isConsumedVolume={}",
                        t.getBasicChatacteristicts().isConsumedVolume());

                String usl = null;
                // счетчик предоставляет ОБЪЕМ
                for (DeviceMunicipalResourceType d : t.getMunicipalResources()) {
                    usl = ulistMng.getUslByResource(d.getMunicipalResource());
                    //servCd = ulistMng.getServCdByResource(d.getMunicipalResource());
                    break; // XXX Lev: Сделал выход, по первому элементу, пока так, в будущем
                    // надо будет сделать возможность наличия несколько услуг для одного счетчика!
                }

                if (usl == null) {
                    // счетчик предоставляет ПОКАЗАНИЯ
                    List<MunicipalResourceNotElectricExportType> munResNenerg
                            = t.getMunicipalResourceNotEnergy();
                    MunicipalResourceElectricExportType munResEl
                            = t.getMunicipalResourceEnergy();
                    // проверить, заполнить usl
                    if (munResNenerg.size() > 0) {
                        // Коммунальные услуги, получить первый попавшийся код усл
                        // может в Отоплении будут другие коды услуг!
                        for (MunicipalResourceNotElectricExportType m : munResNenerg) {
                            //log.trace("res.GUID={}", m.getMunicipalResource().getGUID());
                            usl = ulistMng.getUslByResource(m.getMunicipalResource());
                            //servCd = ulistMng.getServCdByResource(m.getMunicipalResource());
                            //log.trace("res.usl={}, servCd={}", usl, servCd);
                            break;
                        }
                    } else if (munResEl != null) {
                        // Электроэнергия
                        usl = "024";
                        //servCd = "Электроснабжение";
                    }
                }

                if (rootEol.getUsl() == null) {
                    rootEol.setUsl(usl);
                    log.trace("Попытка отметить счетчик кодом услуги usl={}", usl);
                }

                // найти Ko счетчика, по Ko помещения и коду услуги
                // связывание, пользователь будет сам связывать в Директ
                if (autoBind != null && autoBind) {
                    soapConfig.saveError(premiseEol, CommonErrs.ERR_EMPTY_KLSK | CommonErrs.ERR_METER_NOT_FOUND,
                            false);
                    if (premiseEol.getKoObj() == null) {
                        log.error("ОШИБКА! По помещению Eolink.id=" + premiseEol.getId() + " не заполнен KLSK! " +
                                " Необходимо произвести экспорт дома Eolink.id=" + houseEol.getId());
                        soapConfig.saveError(premiseEol, CommonErrs.ERR_EMPTY_KLSK, true);
                        //rootEol.setComm("ОШИБКА! По помещению Eolink.id="+premiseEol.getId()+" не заполнен KLSK! " +
                        //        " Необходимо произвести экспорт дома Eolink.id="+houseEol.getId());
                    } else if (usl == null) {
                        throw new ErrorProcessAnswer("Некорректно определён код услуги USL, " +
                                "в методе ulistMng.getUslByResource");
                    } else {
                        Meter meter = meterMng.getActualMeterByKoPremiseUsl(premiseEol.getKoObj(), usl,
                                new Date());
                        if (meter == null) {
                            log.error("ОШИБКА! По помещению Eolink.id={} не найден счетчик в карточке Лиц.счета.",
                                    premiseEol.getId());
                            soapConfig.saveError(premiseEol, CommonErrs.ERR_METER_NOT_FOUND, true);
                        } else {
                            // здесь устанавливается именно Ko счетчика, не объекта!
                            if (rootEol.getKoObj() == null) {
                                // только если уже нет привязки!
                                log.trace("Попытка установки нового KLSK={}, по счетчику Eolink.id={}",
                                        meter.getKo().getId(), rootEol.getId());
                                rootEol.setKoObj(meter.getKo());
                            }
                        }
                    }
                }
                // привязать счетчик к лиц.счетам
                /* FIXME Временно убрал - так как счетчик привязан к помещению ред.03.12.2018.
                   разобраться или удалить!
                */
                /*if (meterTp == 0 || meterTp == 1) {
                    Eolink lskEol = null;
                    // счетчик жилых или нежилых помещений
                    for (String lskGUID : lstAccGuid) {
                        lskEol = eolinkDao.getEolinkByGuid(lskGUID);
                        eolToEolMng.saveParentChild(lskEol, rootEol, "Логическая связь");
                    }

                    // заполнить Ko счетчика по последнему лицевому счету
                    // (нельзя ко всем, так как Eolink - Ko - связь один к одному
                    if (servCd != null && lskEol != null && lskEol.getKoObj() != null && rootEol.getKoObj() == null) {
                        Ko meterKo = meterLogMng.getKoByLskNum(lskEol.getKoObj(),
                                t.getBasicChatacteristicts().getMeteringDeviceNumber(), servCd);
                        rootEol.setKoObj(meterKo);
                    }
                }*/

                // параметры счетчика
                eolinkParMng.setStr(rootEol, "Счетчик.НомерПУ", t.getBasicChatacteristicts().getMeteringDeviceNumber());
                eolinkParMng.setStr(rootEol, "Счетчик.Модель", t.getBasicChatacteristicts().getMeteringDeviceModel());
                eolinkParMng.setStr(rootEol, "ПУ.Марка", t.getBasicChatacteristicts().getMeteringDeviceStamp());
                eolinkParMng.setDate(rootEol, "Счетчик.ДатаВводаЭкс",
                        Utl.getDateFromXmlGregCal(t.getBasicChatacteristicts().getCommissioningDate()));
                eolinkParMng.setDate(rootEol, "Счетчик.ДатаУстановки",
                        Utl.getDateFromXmlGregCal(t.getBasicChatacteristicts().getInstallationDate()));
                eolinkParMng.setBool(rootEol, "ГИС ЖКХ.Признак_ПУ_КР", t.getBasicChatacteristicts().isConsumedVolume());

                if (versionEol == null) {
                    // не найдена версия счетчика, создать
                    AddrTp addrTp = lstMng.getAddrTpByCD("СчетчикВерсия");

                    versionEol = Eolink.builder()
                            .withGuid(t.getMeteringDeviceVersionGUID())
                            .withObjTp(addrTp)
                            .withParent(rootEol)
                            .withUser(config.getCurUser())
                            .withStatus(1).build();

                    // пометить прочие записи неактивными
                    eolinkMng.setChildActive(rootEol, "СчетчикВерсия", 0);
                    log.trace("Попытка создать запись версии счетчика в Eolink: GUID={}", t.getMeteringDeviceVersionGUID());
                    em.persist(versionEol);
                }
            }
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);

        }

    }

    /**
     * Экспортировать договора управления по дому
     *
     * @param task - задание (если есть)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportContract(Task task) {
        // note Не доделано, Не работает!
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        String houseGuid = reqProp.getFoundTask().getEolink().getGuid();

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ExportCAChAsyncRequest req = new ExportCAChAsyncRequest();
        AckRequest ack = null;
        req.setId("foo");
        sb.setSign(true);
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        ExportCAChRequestCriteriaType criteria = new ExportCAChRequestCriteriaType();
        Eolink uk = eolinkMng.getEolinkByReuKulNdTp(reqProp.getReu(), null, null, null, null, "Организация");

        criteria.setFIASHouseGuid(houseGuid);
        criteria.setUOGUID(uk.getGuid());
        criteria.setLastVersionOnly(true);
        req.getCriteria().add(criteria);

        try {
            ack = port.exportCAChData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }
        // Показать ошибки, если есть
        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }

    }


    /**
     * Получить результат экспорта договоров управления по дому
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportContractAsk(Task task) throws WrongGetMethod {
        // note Не доделано, Не работает!
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());
        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            // Ошибок нет, обработка
            for (ExportCAChResultType t : retState.getExportCAChResult()) {
                String contractGUID = null;
                if (t.getContract() != null) {
                    // Договор управления
                    contractGUID = t.getContract().getContractGUID();
                } else if (t.getCharter() != null) {
                    // Устав ТСЖ
                    contractGUID = t.getCharter().getCharterGUID();
                }
                Eolink contrEol = eolinkDao.getEolinkByGuid(contractGUID);
                if (contrEol == null) {
                    // Документ не существует в базе, - создать
                    AddrTp addrTp = lstMng.getAddrTpByCD("Документ");
                    Lst2 objTpx = null;
                    if (t.getContract() != null) {
                        // Договор управления
                        objTpx = lstMng.getByCD("Договор управления");
                    } else if (t.getCharter() != null) {
                        // Устав ТСЖ
                        objTpx = lstMng.getByCD("Устав");
                    }
                    contrEol = Eolink.builder()
                            .withGuid(contractGUID)
                            .withObjTp(addrTp)
                            //.withAppTp(1)
                            .withObjTpx(objTpx)
                            .withUser(config.getCurUser())
                            .withStatus(1).build();

                    //contrEol = new Eolink(contractGUID, null, null, addrTp, foundTask2.getAppTp(), objTpx, null, config.getCurUser());
                    // установить Parent_id ведущий к дому
                    contrEol.setParent(task.getEolink());
                    em.persist(contrEol);
                    log.trace("Создан договор управления или устав! guid={}", contractGUID);
                } else {
                    log.trace("Договор управления или устав существует, обновление параметров! guid={}", contractGUID);
                }
                // сохранить параметры
                if (t.getContract() != null) {
                    // установить Parent_id ведущий к дому
                    contrEol.setParent(task.getEolink());
                    // Договор управления
                    eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Дата подписания",
                            Utl.getDateFromXmlGregCal(t.getContract().getSigningDate()));
                    eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Планируемая дата завершения",
                            Utl.getDateFromXmlGregCal(t.getContract().getPlanDateComptetion()));
                    eolinkParMng.setStr(contrEol, "ГИС ЖКХ.GUID Версии документа",
                            t.getContract().getContractVersionGUID());
                } else if (t.getCharter() != null) {
                    // установить Parent_id ведущий к дому
                    contrEol.setParent(task.getEolink());
                    // Устав
                    eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Дата регистрации",
                            Utl.getDateFromXmlGregCal(t.getCharter().getDate()));
                }
            }

            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            //log.info("******* Task.id={}, экспорт объектов дома выполнен", task.getId());
            taskMng.logTask(task, false, true);
        }

    }


    /**
     * Экспорт сокращенного состава информации о договоре ресурсоснабжения
     * (для последующей загрузки по ним лиц.счетов)
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportBriefSupplyResourceContract(Task task) {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        String houseGuid = reqProp.getFoundTask().getEolink().getGuid();

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ExportBriefSupplyResourceContractRequest req = new ExportBriefSupplyResourceContractRequest();
        AckRequest ack = null;
        req.setId("foo");
        sb.setSign(true);
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());

        ExportBriefSupplyResourceContractRequest.Criteria criteria =
                new ExportBriefSupplyResourceContractRequest.Criteria();
        criteria.setFIASHouseGuid(houseGuid);

/*
        // GUID организации
        RegOrgType orgType = new RegOrgType();
        orgType.setOrgRootEntityGUID(task.getProcUk().getGuid());
        req.setOrganization(orgType);
*/
        req.getCriteria().add(criteria);

        try {
            ack = port.exportBriefSupplyResourceContract(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }
        // Показать ошибки, если есть
        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }

    }


    /**
     * Получить результат экспорта сокращенного состава информации о договоре ресурсоснабжения
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportBriefSupplyResourceContractAsk(Task task) {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            // ошибок не найдено
            for (GetStateResult.ExportBriefSupplyResourceContractResult t :
                    retState.getExportBriefSupplyResourceContractResult()) {
                for (ExportBriefSupplyResourceContractResultType contract : t.getContract()) {
                    if (contract.getTerminateContract() == null) {
                        log.info("contract.getContractRootGUID()={}", contract.getContractRootGUID());
                        log.info("contract.getContractGUID()={}", contract.getContractGUID());
                        for (ObjectAddressBriefType adr : contract.getObjectAddress()) {
                            if (adr.getFIASHouseGuid() != null) {
                                log.info("FIAS_HOUSE_GUID={}", adr.getFIASHouseGuid());
                            }
                            if (adr.getPremisesGUID() != null) {
                                log.info("FIAS_PREMISES_GUID={}", adr.getPremisesGUID());
                            }
                            for (ObjectAddressBriefType.Pair pair : adr.getPair()) {
                                log.info("Municipal_Resource_GUID={}", pair.getMunicipalResource().getGUID());
                                Ulist elem = ulistDAO.getListElemByGUID(pair.getMunicipalResource().getGUID());
                                for (Ulist chld : elem.getChild()) {
                                    log.info("Municipal_Resource_Child_S1={}", chld.getS1());
                                }
                            }
                        }
                        for (ExportBriefSupplyResourceContractResultType.ContractSubject subj :
                                contract.getContractSubject()) {
                            log.info("Contract: Municipal_Resource_GUID={}", subj.getMunicipalResource().getGUID());
                            log.info("ServiceTypeGUID={}, ServiceTypeName={}",
                                    subj.getServiceType().getGUID(), subj.getServiceType().getName());
                        }
                    }
                }
            }

            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
    }


    /**
     * Экспортировать договора по УК - метод был создан, для попытки выгрузки GUID домов определенной УК
     * - не взлетело, так как требуется GUID дома. ГИС еще не сделал метод по выгрузке всех домов УК ред. 25.07.2018
     *
     * @param task - задание (если есть)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportCaChData(Task task) {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        sb.setSign(true);

        Eolink house = reqProp.getFoundTask().getEolink();

        ExportCAChAsyncRequest req = new ExportCAChAsyncRequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());

        ExportCAChRequestCriteriaType criteria = new ExportCAChRequestCriteriaType();
        criteria.setContractGUID("3ec632db-8b83-4b9c-bce5-b1defe2e0637");
        // GUID УК
        //criteria.setUOGUID(uk.getGuid());
        // GUID Дома
        //criteria.setFIASHouseGuid(house.getGuid());
        // только последние версии договоров
        // criteria.setLastVersionOnly(true);
        req.getCriteria().add(criteria);

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        AckRequest ack = null;
        try {
            ack = port.exportCAChData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }

        // Показать ошибки, если есть
        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }

    }


    /**
     * Получить результат экспорта договоров по УК
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportCaChDataAsk(Task task) {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());
        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            log.info("Получены договора и уставы:");
            List<ExportCAChResultType> res = retState.getExportCAChResult();
            res.forEach(t -> {
                // договора
                if (t.getContract() != null) {
                    t.getContract().getContractObject().forEach(d -> log.info("По договору GUID={}, найден дом GUID={}",
                            t.getContract().getContractGUID(), d.getFIASHouseGuid()));
                }
                // уставы
                if (t.getCharter() != null) {
                    t.getCharter().getContractObject().forEach(d -> {
                        d.getFIASHouseGuid();
                        log.info("По уставу GUID={}, найден дом GUID={}",
                                t.getCharter().getCharterGUID(), d.getFIASHouseGuid());
                    });
                }
            });

            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
    }

    /**
     * Экспортировать данные дома
     *
     * @param task - задание (если есть)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportHouseData(Task task) {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        Eolink houseEol = reqProp.getFoundTask().getEolink();
        String houseGuid = houseEol.getGuid();

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ExportHouseRequest req = new ExportHouseRequest();
        req.setId("foo");
        sb.setSign(true);
        req.setVersion("12.2.0.1");  // здесь просит именно эту версию
        req.setFIASHouseGuid(houseGuid);

        AckRequest ack = null;

        try {
            ack = port.exportHouseData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e) {
            e.printStackTrace();
            err = true;
            errMainStr = e.getFaultInfo().getErrorMessage();
        }

        // Показать ошибки, если есть
        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }
    }


    /**
     * Получить результат экспорта объектов дома
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportHouseDataAsk(Task task) throws UnusableCode {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask().getTrace().equals(1));

        // дом
        Eolink houseEol = reqProp.getFoundTask().getEolink();
        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());
        Date curDate = new Date();
        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            // Ошибок нет, обработка
            // Сохранить уникальный номер дома
            houseEol.setUn(retState.getExportHouseResult().getHouseUniqueNumber());

            ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse ah =
                    retState.getExportHouseResult().getApartmentHouse();

            if (ah != null) {
                // Многоквартирный дом
                // статус - активный
                houseEol.setStatus(1);

                Map<Integer, Eolink> entryMap = new HashMap<>();

                // Подъезды
                List<String> lstEntryGuid = new ArrayList<>();
                for (Entrance t : ah.getEntrance()) {
                    log.trace("Подъезд: №={}, GUID={}", t.getEntranceNum(), t.getEntranceGUID());
                    Eolink entryEol = eolinkDao.getEolinkByGuid(t.getEntranceGUID());
                    lstEntryGuid.add(t.getEntranceGUID());
                    if (entryEol == null) {
                        // не найдено, создать подъезд
                        AddrTp addrTp = lstMng.getAddrTpByCD("Подъезд");

                        entryEol = Eolink.builder()
                                .withOrg(reqProp.getUk())
                                .withKul(reqProp.getKul())
                                .withNd(reqProp.getNd())
                                .withEntry(Integer.valueOf(t.getEntranceNum()))
                                .withGuid(t.getEntranceGUID())
                                .withObjTp(addrTp)
                                .withParent(houseEol)
                                .withUser(config.getCurUser())
                                .withStatus(1).build();
                        // сохранить, для иерархии
                        entryMap.put(Integer.valueOf(t.getEntranceNum()), entryEol);
                        em.persist(entryEol);
                        // добавить подъезд к дому, чтобы выбирался позже
                        houseEol.getChild().add(entryEol);
                    }

                    // обновить параметры подъезда
                    entryEol.setEntry(Integer.valueOf(t.getEntranceNum()));
                    Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
                    if (dtTerm != null && (dtTerm.getTime() < curDate.getTime())) {
                        // Объект не активен
                        entryEol.setStatus(0);
                    } else {
                        // Объект активен
                        entryEol.setStatus(1);
                    }
                }

                // проверить наличие подъезда по дому, с данным GUID
                List<Eolink> lstEntry = eolinkDao.getChildByTp(houseEol, "Подъезд");
                lstEntry.forEach(t -> {
                    log.trace("Подъезд из базы: id={}, entry={}", t.getId(), t.getEntry());
                    if (!lstEntryGuid.contains(t.getGuid())) {
                        // не найден, промаркировать неактивным
                        log.trace("Подъезд №{} помечен неактивным!", t.getEntry());
                        t.setStatus(0);
                    }
                });

                // ЖИЛЫЕ помещения
                for (ExportHouseResultType.ApartmentHouse.ResidentialPremises t : ah.getResidentialPremises()) {
                    log.trace("Жилое помещение: №={}, UniqNumber={}, GUID={}",
                            t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
                    Eolink premisEol = eolinkDao.getEolinkByGuid(t.getPremisesGUID());
                    // обработка номера помещения
                    String num;
                    num = prepNum(t);
                    if (premisEol == null) {
                        // не найдено, создать помещение
                        AddrTp addrTp = lstMng.getAddrTpByCD("Квартира");
                        Ko premisKo = null;
                        premisEol = Eolink.builder()
                                .withOrg(reqProp.getUk())
                                .withKul(reqProp.getKul())
                                .withNd(reqProp.getNd())
                                .withKw(num)
                                .withEntry(t.getEntranceNum() != null ? Integer.valueOf(t.getEntranceNum()) : null)
                                .withGuid(t.getPremisesGUID())
                                .withUn(t.getPremisesUniqueNumber())
                                .withObjTp(addrTp)
                                .withKoObj(premisKo)
                                .withParent(t.getEntranceNum() != null ?
                                        entryMap.get(Integer.valueOf(t.getEntranceNum())) : houseEol)   // присоединить к родителю:
                                // подъезд, или дом, если не найден подъезд
                                .withUser(config.getCurUser())
                                .withStatus(1)
                                .build();

                        log.info("Попытка создать запись жилого помещения в Eolink: № подъезда:{}, № помещения={}, un={}, GUID={}",
                                t.getEntranceNum(),
                                t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
                        em.persist(premisEol);
                    }

                    // обновить комнаты
                    AddrTp addrTp = lstMng.getAddrTpByCD("Комната");
                    for (ExportHouseResultType.ApartmentHouse.ResidentialPremises.LivingRoom r : t.getLivingRoom()) {
                        log.trace("Комната, UniqNumber={}, GUID={}",
                                r.getLivingRoomUniqueNumber(), r.getLivingRoomGUID());
                        Eolink roomEol = eolinkDao.getEolinkByGuid(r.getLivingRoomGUID());
                        if (roomEol == null) {
                            // не найдено, создать комнату
                            roomEol = Eolink.builder()
                                    .withGuid(r.getLivingRoomGUID())
                                    .withUn(r.getLivingRoomUniqueNumber())
                                    .withObjTp(addrTp)
                                    .withKoObj(null) // TODO сделать ko! ред.21.08.2018
                                    .withParent(premisEol) // присоединить к квартире
                                    .withUser(config.getCurUser())
                                    .withStatus(1)
                                    .build();
                            log.info("Попытка создать запись комнаты в Eolink:un={}, GUID={}",
                                    r.getLivingRoomUniqueNumber(), r.getLivingRoomGUID());
                            em.persist(roomEol);
                        }

                    }

                    // погасить ошибки
                    soapConfig.saveError(premisEol, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR |
                            CommonErrs.ERR_EMPTY_KLSK | CommonErrs.ERR_DOUBLE_KLSK_EOLINK |
                            CommonErrs.ERR_NOT_FOUND_ACTUAL_OBJ, false);
                    // обновить параметры помещения
                    if (premisEol.getKoObj() == null) {
                        // найти соответствующий объект Ko помещения
                        Ko ko = null;
                        try {
                            ko = kartMng.getKoPremiseByKulNdKw(reqProp.getKul(), reqProp.getNd(), num);
                        } catch (DifferentKlskBySingleAdress differentKlskBySingleAdress) {
                            // в KART разные KLSK на один адрес!
                            soapConfig.saveError(premisEol, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR, true);
                        } catch (EmptyId emptyId) {
                            // в KART найден пустой KLSK в данном адресе!
                            soapConfig.saveError(premisEol, CommonErrs.ERR_EMPTY_KLSK, true);
                        }
                        if (ko == null) {
                            // не найден актуальный (действующий объект) в Kart с KLSK
                            soapConfig.saveError(premisEol, CommonErrs.ERR_NOT_FOUND_ACTUAL_OBJ, true);
                        } else {
                            Eolink checkEolink = eolinkDao2.getEolinkByKlskId(ko.getId());
                            if (checkEolink != null) {
                                soapConfig.saveError(premisEol, CommonErrs.ERR_DOUBLE_KLSK_EOLINK, true);
                            } else {
                                log.info("Попытка установить по объекту помещения Eolink.id={}, Ko.id={}",
                                        premisEol.getId(), ko.getId());
                                premisEol.setKoObj(ko);
                            }
                        }
                    }

                    // прикрепить к подъезду, взятому из ГИС ЖКХ
                    if (t.getEntranceNum() != null) {
                        Integer entryNum = Integer.valueOf(t.getEntranceNum());
                        premisEol.setEntry(entryNum);
                        // обновить родительский подъезд
                        Eolink entry = lstEntry.stream().filter(e -> e.getEntry().equals(entryNum))
                                .findFirst().orElse(null);
                        premisEol.setParent(entry);
                    } else {
                        // помещение без отдельного входа
                        premisEol.setParent(houseEol);
                    }

                    Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
                    if (dtTerm != null && (dtTerm.getTime() < curDate.getTime())) {
                        if (premisEol.getStatus() != 0) {
                            // Объект не активен
                            premisEol.setStatus(0);
                        }
                    } else {
                        if (premisEol.getStatus() != 1) {
                            // Объект активен
                            premisEol.setStatus(1);
                        }
                    }
                    t.getLivingRoom().forEach(f -> log.trace("f.isNoRSOGKNEGRPRegistered()1={}", f.isNoRSOGKNEGRPRegistered()));
                }

                // НЕЖИЛЫЕ помещения
                for (NonResidentialPremises t : ah.getNonResidentialPremises()) {
                    log.trace("Нежилое помещение: №={}, UniqNumber={}, GUID={}",
                            t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
                    Eolink premisEol = eolinkDao.getEolinkByGuid(t.getPremisesGUID());
                    // обработка номера помещения
                    String num;
                    num = prepNum(t);

                    if (premisEol == null) {
                        // Не найдено, создать помещение
                        AddrTp addrTp = lstMng.getAddrTpByCD("Помещение нежилое");

                        premisEol = Eolink.builder()
                                .withOrg(reqProp.getUk())
                                .withKul(reqProp.getKul())
                                .withNd(reqProp.getNd())
                                .withKw(num)
                                .withGuid(t.getPremisesGUID())
                                .withObjTp(addrTp)
                                .withParent(houseEol)
                                .withUser(config.getCurUser())
                                .withStatus(1).build();

                        log.info("Попытка создать запись Нежилого помещения в Eolink: № помещения={}, un={}, GUID={}",
                                t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
                        em.persist(premisEol);
                    }

                    // погасить ошибки
                    soapConfig.saveError(premisEol, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR |
                            CommonErrs.ERR_EMPTY_KLSK | CommonErrs.ERR_DOUBLE_KLSK_EOLINK, false);

                    // обновить параметры помещения
                    // найти соответствующий объект Ko
                    if (premisEol.getKoObj() == null) {
                        Ko ko = null;
                        try {
                            ko = kartMng.getKoPremiseByKulNdKw(reqProp.getKul(), reqProp.getNd(), num);
                        } catch (DifferentKlskBySingleAdress differentKlskBySingleAdress) {
                            // разные KLSK на один адрес!";
                            soapConfig.saveError(premisEol, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR, true);
                        } catch (EmptyId emptyId) {
                            // найден пустой KLSK в данном адресе!";
                            soapConfig.saveError(premisEol, CommonErrs.ERR_EMPTY_KLSK, true);
                        }

                        if (ko == null) {
                            // вернулся пустой KLSK
                            soapConfig.saveError(premisEol, CommonErrs.ERR_EMPTY_KLSK, true);
                        } else {
                            Eolink checkEolink = eolinkDao2.getEolinkByKlskId(ko.getId());
                            if (checkEolink != null) {
                                soapConfig.saveError(premisEol, CommonErrs.ERR_DOUBLE_KLSK_EOLINK, true);
                            } else {
                                //log.info("Попытка установить по объекту Eolink.id={}, Ko.id={}",
                                //      premisEol.getId(), ko.getId());
                                premisEol.setKoObj(ko);
                            }
                        }
                    }
                    Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
                    // помещение без отдельного входа - убрал, зачем оно здесь обновляется? ред. 17.07.2019
                    // premisEol.setParent(houseEol);

                    if (dtTerm != null && (dtTerm.getTime() < curDate.getTime())) {
                        if (premisEol.getStatus() != 0) {
                            // Объект не активен
                            premisEol.setStatus(0);
                        }
                    } else {
                        if (premisEol.getStatus() != 1) {
                            // Объект активен
                            premisEol.setStatus(1);
                        }
                    }
                }
            }
            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            //log.info("******* Task.id={}, экспорт объектов дома выполнен", task.getId());
            taskMng.logTask(task, false, true);
        }
    }

    /**
     * Подготовить номер жилого помещения
     *
     * @param t
     */
    private String prepNum(
            ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.ResidentialPremises t) {
        String num;
        // усечь № кв. до 7 знаков
        if (t.getPremisesNum().length() > 7) {
            num = t.getPremisesNum().substring(0, 7);
        } else {
            num = t.getPremisesNum();
        }
        // добавить лидирующие нули
        num = Utl.lpad(num, "0", 7);
        return num;
    }

    /**
     * Подготовить номер нежилого помещения
     *
     * @param t
     */
    private String prepNum(
            ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises t) {
        String num;
        // усечь № кв. до 7 знаков
        if (t.getPremisesNum().length() > 7) {
            num = t.getPremisesNum().substring(0, 7);
        } else {
            num = t.getPremisesNum();
        }
        // добавить лидирующие нули
        num = Utl.lpad(num, "0", 7);
        return num;
    }

    /**
     * Экспортировать лицевые счета
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportAccountData(Task task) throws CantPrepSoap, CantSendSoap, WrongParam {
        taskMng.logTask(task, true, null);
        if (task.getProcUk() == null)
            throw new WrongParam("По заданию task.id=" + task.getId() + " не заполнен TASK.FK_PROC_UK");
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        ExportAccountRequest req = new ExportAccountRequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());

        // GUID дома
        req.setFIASHouseGuid(task.getEolink().getGuid());

        AckRequest ack = null;
        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;
        try {
            ack = port.exportAccountData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            err = true;
            e1.printStackTrace();
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }

        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);
        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);
        }
    }

    /**
     * Получить результат экспорта лицевых счетов
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportAccountDataAsk(Task task) throws CantPrepSoap, WrongParam, ErrorProcessAnswer, CantSendSoap {
        taskMng.logTask(task, true, null);
        if (task.getProcUk() == null)
            throw new WrongParam("По заданию task.id=" + task.getId() + " не заполнен TASK.FK_PROC_UK");
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            // ошибок не найдено
            for (ExportAccountResultType t : retState.getExportAccountResult()) {

                // примечание по объекту
                String guid = null;
                for (ru.gosuslugi.dom.schema.integration.house_management.AccountExportType.Accommodation d : t.getAccommodation()) {
                    if (d.getPremisesGUID() != null) {
                        // Лиц счет на помещение
                        guid = d.getPremisesGUID();
                    } else if (d.getLivingRoomGUID() != null) {
                        // Лиц счет на комнату
                        guid = d.getLivingRoomGUID();
                    } else {
                        // Лиц счет на дом
                        guid = d.getFIASHouseGuid();
                    }
                    log.trace("лиц.счет={}", t.getAccountNumber());
                    for (AccountReasonsImportType.TKOContract tkoContract :
                            t.getAccountReasons().getTKOContract()) {
                        log.trace("Основание ТКО лиц.счета Contract GUID={}", tkoContract.getContractGUID());
                    }

                    for (AccountReasonsImportType.SupplyResourceContract suppContr :
                            t.getAccountReasons().getSupplyResourceContract()) {
                        log.trace("Основание лиц.счета Contract GUID={}", suppContr.getContractGUID());
                    }
                }

                // найти лицевой счет
                Eolink accountEol = eolinkDao.getEolinkByGuid(t.getAccountGUID());
                String num;
                // усечь № лиц.счета до 8 знаков
                if (t.getAccountNumber().length() > 8) {
                    num = t.getAccountNumber().substring(0, 8);
                } else {
                    num = t.getAccountNumber();
                }

                if (accountEol == null) {
                    // Создать новый лицевой счет

                    // Найти объект на который ссылаться
                    Eolink parentEol = eolinkDao.getEolinkByGuid(guid);
                    if (parentEol == null) {
                        throw new ErrorProcessAnswer("Не найдено помещение c GUID=" + guid + ", для прикрепления лицевого счета, " +
                                "попробуйте выполнить экспорт объектов дома!");
                    }

                    // Найти лицевой счет в Kart
                    Kart kart = em.find(Kart.class, num);
                    if (kart == null) {
                        log.error("ОШИБКА! Не найден лиц.счет в SCOTT.KART c lsk=" + num);
                    } else {
                        AddrTp addrTp = lstMng.getAddrTpByCD("ЛС");

                        accountEol = Eolink.builder()
                                .withGuid(t.getAccountGUID())
                                .withUn(t.getUnifiedAccountNumber()) // ЕЛС
                                .withServiceId(t.getServiceID()) // идентификатор ЖКУ
                                .withKart(kart)
                                .withObjTp(addrTp)
                                .withParent(parentEol)
                                .withUk(task.getProcUk())
                                .withUser(config.getCurUser())
                                .withStatus(1).build();

                        log.info("Попытка создать запись лицевого счета в Eolink: GUID={}, AccountNumber={}, ServiceId={}",
                                t.getAccountGUID(), num, t.getServiceID());
                        em.persist(accountEol);
                    }
                } else {
                    // Лиц.счет уже существует, обновить его параметры
                    log.trace("Попытка обновить запись лицевого счета в Eolink: GUID={}, AccountNumber={}, " +
                                    "UnifiedAccountNumber={}, ServiceId={}", t.getAccountGUID(),
                            t.getAccountNumber(), t.getUnifiedAccountNumber(), t.getServiceID());
                    // GUID
                    if (accountEol.getGuid() == null) {
                        accountEol.setGuid(t.getAccountGUID());
                    }
                    // ЕЛС
                    if (accountEol.getUn() == null) {
                        accountEol.setUn(t.getUnifiedAccountNumber());
                    }
                    // идентификатор ЖКУ
                    if (accountEol.getServiceId() == null) {
                        accountEol.setServiceId(t.getServiceID());
                    }
                    // отметить закрытый лс
                    if (t.getClosed() != null) {
                        // лс закрыт
                        accountEol.setStatus(0);
                    }
                }

            }
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
    }

    /**
     * Импортировать лицевые счета
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importAccountData(Task task) throws CantPrepSoap, CantSendSoap, WrongParam, UnusableCode {
        if (!(Utl.in(task.getEolink().getId(),884135,884114,884120,707492))) {
            return;
        }

        taskMng.logTask(task, true, null);
        if (task.getProcUk() == null)
            throw new WrongParam("По заданию task.id=" + task.getId() + " не заполнен TASK.FK_PROC_UK");
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        ImportAccountRequest req = new ImportAccountRequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());

        Eolink houseEol = task.getEolink();

        // создать отсутствующие в EOLINK объекты лицевых счетов по данному Дому и УК из KART
        List<Kart> lstKartAbsent = eolinkMng.getKartNotExistsInEolink(houseEol.getId(), task.getProcUk().getId());

        log.info("Кол-во лиц.счетов на загрузку {}", lstKartAbsent.size());
        for (Kart kart : lstKartAbsent) {
            log.info("Попытка создать лиц.счет в EOLINK, lsk={}", kart.getLsk());
            Eolink eolKw = eolinkDao2.getEolinkByKlskId(kart.getKoPremise().getId());
            if (eolKw == null) {
                log.error("ОШИБКА! По лиц.счету KART.LSK={} не найден объект типа 'Квартира' в EOLINK, c помощью K_LSK_ID={}",
                        kart.getLsk(), kart.getKoKw().getId());
            } else {
                AddrTp objTp = addrTpDAO.getByCd("ЛС");
                Eolink eolKart = Eolink.builder()
                        .withUk(task.getProcUk())
                        .withObjTp(objTp)
                        .withStatus(1)
                        .withParent(eolKw)
                        .withOrg(kart.getUk())
                        .withKart(kart).build();
                em.persist(eolKart);
            }
        }

        // получить лиц.счета для добавления/обновления в ГИС
        List<Eolink> lstLskForUpdate =
                new ArrayList<>(eolinkMng.getLskEolByHouseEol(houseEol.getId(), task.getProcUk().getId()));

        boolean isExistJob = false;
        for (Eolink lskEol : lstLskForUpdate) {
//            for (Eolink lskEol : lstLskForUpdate.stream().filter(t->t.getId()>=995195 && t.getId()<=995197).collect(Collectors.toList())) {
            Kart kart = lskEol.getKart();
            // погасить ошибки
            soapConfig.saveError(lskEol, CommonErrs.ERR_LSK_NOT_FOUND |
                    CommonErrs.ERR_INCORRECT_PARENT | CommonErrs.ERR_EMPTY_FIO, false);

            if (kart == null) {
                // не найден лиц.счет
                log.error("Объект лиц.счета EOLINK.ID={}, не найден в SCOTT.KART по LSK", lskEol.getId());
                soapConfig.saveError(lskEol, CommonErrs.ERR_LSK_NOT_FOUND, true);
            } else if (kart.getKIm() == null || kart.getKFam() == null || kart.getKOt() == null) {
                // не заполнены ФИО собственника в SCOTT.KART
                soapConfig.saveError(lskEol, CommonErrs.ERR_EMPTY_FIO, true);
            } else {
                ImportAccountRequest.Account ac = new ImportAccountRequest.Account();
                req.getAccount().add(ac);

                String reu = lskEol.getUk().getOrg().getReu();
                if (reu == null) {
                    throw new WrongParam("Не заполнен код REU в организации EOLINK.ID=" + lskEol.getUk().getId());
                }
                Org uk = orgDAO.getByReu(reu);
                if (uk == null) {
                    throw new WrongParam("По коду REU=" + reu + " не найдена организация в справочнике T_ORG");
                }
                if (uk.isUO()) {
                    // лиц.счет УК
                    ac.setIsUOAccount(true);
                } else if (uk.isTKO()) {
                    // лиц.счет ТКО
                    ac.setIsTKOAccount(true);

                    /*  note пока не убирать код в комментарии - понадобится ред. 19.08.2019
                    // основания лиц.счета
                    AccountReasonsImportType reason = new AccountReasonsImportType();
                    AccountReasonsImportType.TKOContract tkoContract = new AccountReasonsImportType.TKOContract();
                    tkoContract.setContractGUID("8c9cd2af-26b1-417d-b0ff-7a5cff1f1433");
                    reason.getTKOContract().add(tkoContract);
                    ac.setAccountReasons(reason);
                */
                } else {
                    throw new WrongParam("ОШИБКА! Неподдерживаемый тип организации SCOTT.T_ORG.ORG_TP_GIS=" + uk.getOrgTpGis()
                            + ", SCOTT.T_ORG.ID=" + uk.getId());
                }

                ac.setLivingPersonsNumber(Utl.nvl(kart.getKpr(), 0));
                ac.setTotalSquare(Utl.nvl(kart.getOpl(), BigDecimal.ZERO));
                ac.setHeatedArea(Utl.nvl(kart.getOpl(), BigDecimal.ZERO));

                // транспортный GUID
                String tguid = Utl.getRndUuid().toString();
                lskEol.setTguid(tguid);
                ac.setTransportGUID(tguid);

                // привязка к помещению или к дому
                AccountType.Accommodation acm = new AccountType.Accommodation();
                ac.getAccommodation().add(acm);
                if (lskEol.getParent().getObjTp().getCd().equals("Квартира")) {
                    acm.setPremisesGUID(lskEol.getParent().getGuid());
                } else if (lskEol.getParent().getObjTp().getCd().equals("Дом")) {
                    acm.setFIASHouseGuid(lskEol.getParent().getGuid());
                } else {
                    log.error("Объект лицевого счета EOLINK.ID={} имеет некорректную родительскую запись с типом={}, " +
                            "разрешённые типы: Квартира, Дом", lskEol.getId(), lskEol.getParent().getObjTp().getCd());
                    soapConfig.saveError(lskEol, CommonErrs.ERR_INCORRECT_PARENT, true);
                    continue;
                }

                // № лицевого счета
                ac.setAccountNumber(kart.getLsk());

                // Сведения о плательщике (решили оставить "val")
                AccountType.PayerInfo pf = new AccountType.PayerInfo();
                AccountIndType ind = new AccountIndType();
                ind.setFirstName(kart.getKIm());
                ind.setSurname(kart.getKFam());
                ind.setPatronymic(kart.getKOt());
                pf.setInd(ind);
                ac.setPayerInfo(pf);

                if (lskEol.getGuid() != null) {
                    // Account GUID, только при обновлении лиц.счета
                    ac.setAccountGUID(lskEol.getGuid());
                }

                if (!kart.isActual()) {
                    // закрытый лиц.счет
                    Optional<StateSch> stateSchOpt = kartMng.getKartStateByDate(kart, new Date());
                    if (stateSchOpt.isPresent()) {
                        StateSch stateSch = stateSchOpt.get();
                        if (stateSch.getReason() != null) {
                            // дата закрытия пустая - проставить первую дату месяца
                            Date stateSchDt = stateSch.getDt1() == null ? Utl.getFirstDate(new Date()) : stateSch.getDt1();

                            // причина закрытия лиц.счета
                            ClosedAccountAttributesType closedAttributes = new ClosedAccountAttributesType();
                            String reasonGuid = stateSch.getReason().getGuid();
                            Ulist reasonUlist = ulistDAO.getListElemByGUID(reasonGuid);
                            NsiRef reasonNsiElem = ulistMng.getNsiElem(reasonUlist);
                            closedAttributes.setCloseReason(reasonNsiElem);
                            try {
                                closedAttributes.setCloseDate(Utl.getXMLDate(stateSchDt));
                            } catch (DatatypeConfigurationException e) {
                                throw new WrongParam("Некорректная дата закрытия лиц счета lsk=" + kart.getLsk());
                            }
                            ac.setClosed(closedAttributes);
                            // установить статус - закрытый в Eolink
                            lskEol.setStatus(0);
                        }
                    }
                }
                isExistJob = true;
            }
        }

        if (isExistJob) {
            log.info("******* Task.id={}, импорт лиц.счетов по дому, вызов", task.getId());
            AckRequest ack = null;
            // для обработки ошибок
            boolean err = false;
            String errMainStr = null;
            try {
                ack = port.importAccountData(req);
            } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
                e1.printStackTrace();
                err = true;
                errMainStr = e1.getFaultInfo().getErrorMessage();
            }

            if (err) {
                reqProp.getFoundTask().setState("ERR");
                reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
                taskMng.logTask(task, false, false);
            } else {
                // Установить статус "Запрос статуса"
                reqProp.getFoundTask().setState("ACK");
                reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
                taskMng.logTask(task, false, true);
            }
        } else {
            // Установить статус "Выполнено", так как нечего загружать
            log.info("Task.id={}, Нет документов для загрузки!", task.getId());
            reqProp.getFoundTask().setState("ACP");
        }
        // сбросить кол-во ошибок запросов Ack
        //reqProp.getFoundTask().setErrAckCnt(0);
    }


    /**
     * Получить результат импорта лицевых счетов
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importAccountDataAsk(Task task) throws CantPrepSoap, WrongParam, CantSendSoap, UnusableCode {
        taskMng.logTask(task, true, null);
        if (task.getProcUk() == null)
            throw new WrongParam("По заданию task.id=" + task.getId() + " не заполнен TASK.FK_PROC_UK");
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR")) {
            // ошибок не найдено
            for (GetStateResult.ImportResult t : retState.getImportResult()) {
                for (GetStateResult.ImportResult.CommonResult d : t.getCommonResult()) {

                    // найти элемент лиц.счета по Транспортному GUID
                    Eolink lskEol = eolinkDao2.getEolinkByTGUID(d.getTransportGUID());
                    // погасить ошибки
                    soapConfig.saveError(lskEol, CommonErrs.ERR_IMPORT, false);

                    // ошибки внутри выполненного задания
                    for (Error f : d.getError()) {
                        String errStr = String.format("Ошибка импорта лиц.счета в ГИС ЖКХ: " +
                                "Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
                        soapConfig.saveError(lskEol, CommonErrs.ERR_IMPORT, true);
                        lskEol.setComm(errStr);
                        log.error(errStr);
                    }

                    if (lskEol.getGuid() == null) {
                        lskEol.setGuid(d.getGUID());
                    }
                    if (lskEol.getUn() == null) {
                        lskEol.setUn(d.getUniqueNumber());
                    }
                    log.trace("После импорта объектов получены следующие параметры:");
                    log.trace("GUID={}, UniqueNumber={}", d.getGUID(), d.getUniqueNumber());
                }
            }
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
    }


    /*
     * Обновление объектов дома
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importHouseUOData(Task task) throws WrongGetMethod, CantPrepSoap {
        //log.info("******* Task.id={}, Импорт объектов дома, вызов", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask().getTrace().equals(1));
        ImportHouseUORequest req = new ImportHouseUORequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        //sb.setSign(true);

        ApartmentHouse ah = new ApartmentHouse();

        // установить базовые параметры
        if (reqProp.getFoundTask().getAct().getCd().equals("GIS_ADD_HOUSE")) {
            // Добавить дом
            log.trace("Добавление дома, Task.id={}", reqProp.getFoundTask().getId());
            BasicCharacteristicts bc = new BasicCharacteristicts();
            bc.setFIASHouseGuid(reqProp.getFoundTask().getEolink().getGuid());
            Double totSqr = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
            bc.setTotalSquare(BigDecimal.valueOf(totSqr));

            Date dtBuild = teParMng.getDate(reqProp.getFoundTask(), "ГИС ЖКХ.Дата постройки");
            String dtBuiltStr = Utl.getStrFromDate(dtBuild);
            dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length() - 4);
            Integer usedYear = Integer.valueOf(dtBuiltStr);
            bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

            Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
            bc.setCulturalHeritage(cult == 1d);

            // установить часовую зону
            bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 32/*30*/, "Часовая зона", "Asia/Novokuznetsk")); // ред.28.12.17 странно было 31 поменял на 32

            Double et = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наибольшее(1-11)");
            bc.setFloorCount(et.byteValue());

            Boolean isGkn = teParMng.getBool(reqProp.getFoundTask(), "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
            if (isGkn != null && isGkn) {
                // Ключ связи с ГКН/ЕГРП отсутствует.
                bc.setNoRSOGKNEGRPRegistered(true);
            } else {
                // Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
                String gknKey = teParMng.getStr(reqProp.getFoundTask(),
                        "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                if (gknKey == null) {
                    throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + reqProp.getFoundTask().getId());
                }
                bc.setCadastralNumber(gknKey);
            }

            // установить ОКТМО
            OKTMORefType oktmo = new OKTMORefType();
            String oktmo2 = teParMng.getStr(reqProp.getFoundTask(), "ГИС ЖКХ.ОКТМО");

            oktmo.setCode(oktmo2);
            oktmo.setName(oktmo2);
            bc.setOKTMO(oktmo);

            // установить состояние объекта
            ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
            String state = teParMng.getStr(reqProp.getFoundTask(), "ГИС ЖКХ.Состояние");
            bc.setState(ulistMng.getNsiElem("NSI", 24, "Состояние дома", state));

            Double underEt = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Количество подземных этажей");
            ac.setUndergroundFloorCount(underEt.byteValue());

            Double etMin = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наименьшее(1-10)");
            log.trace("etMin={}", etMin);
            Integer etMin2 = etMin.intValue();
            ac.setMinFloorCount(etMin2.byteValue());

            String tguid = Utl.getRndUuid().toString();
            reqProp.getFoundTask().setTguid(tguid);
            ac.setTransportGUID(tguid);

            ac.setBasicCharacteristicts(bc);
            ah.setApartmentHouseToCreate(ac);

        } else if (reqProp.getFoundTask().getAct().getCd().equals("GIS_UPD_HOUSE")) {
            // Обновить дом
            log.trace("Обновление дома, Task.id={}", reqProp.getFoundTask().getId());
            HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
            bc.setFIASHouseGuid(reqProp.getFoundTask().getEolink().getGuid());
            Double totSqr = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
            bc.setTotalSquare(BigDecimal.valueOf(totSqr));

            Date dtBuild = teParMng.getDate(reqProp.getFoundTask(), "ГИС ЖКХ.Дата постройки");
            String dtBuiltStr = Utl.getStrFromDate(dtBuild);
            dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length() - 4);
            int usedYear = Integer.parseInt(dtBuiltStr);
            bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

            Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
            bc.setCulturalHeritage(cult == 1d);

            // установить часовую зону
            bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 32/*30*/, "Часовая зона", "Asia/Novokuznetsk")); //TODO проверить почему стояло 30, когда часовая зона по OLSON это 31

            Double et = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наибольшее(1-11)");
            bc.setFloorCount(et.byteValue());

            Boolean isGkn = teParMng.getBool(reqProp.getFoundTask(), "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
            if (isGkn != null && isGkn) {
                // Ключ связи с ГКН/ЕГРП отсутствует.
                bc.setNoRSOGKNEGRPRegistered(true);
            } else {
                String gknKey = teParMng.getStr(reqProp.getFoundTask(),
                        "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                if (gknKey == null) {
                    throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + reqProp.getFoundTask().getId());
                }
                bc.setCadastralNumber(gknKey);
            }

            // установить ОКТМО
            OKTMORefType oktmo = new OKTMORefType();
            String oktmo2 = teParMng.getStr(reqProp.getFoundTask(), "ГИС ЖКХ.ОКТМО");

            oktmo.setCode(oktmo2);
            oktmo.setName(oktmo2);
            bc.setOKTMO(oktmo);

            // установить состояние объекта
            String state = teParMng.getStr(reqProp.getFoundTask(), "ГИС ЖКХ.Состояние");
            bc.setState(ulistMng.getNsiElem("NSI", 24, "Состояние дома", state));

            ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();

            Double underEt = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Количество подземных этажей");
            ac.setUndergroundFloorCount(underEt.byteValue());

            Double etMin = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наименьшее(1-10)");
            int etMin2 = etMin.intValue();
            ac.setMinFloorCount((byte) etMin2);

            String tguid = Utl.getRndUuid().toString();
            reqProp.getFoundTask().setTguid(tguid);
            log.trace("Установлен house TGUID={}", tguid);
            ac.setTransportGUID(tguid);

            ac.setBasicCharacteristicts(bc);
            ah.setApartmentHouseToUpdate(ac);
        }

        // Добавить подъезды
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null,
                1).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_ENTRY"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Добавление подъезда, Task.id={}", t.getId());
                    EntranceToCreate ec = new EntranceToCreate();
                    String entryNum = String.valueOf(t.getEolink().getEntry());
                    ec.setEntranceNum(entryNum);

                    // год постройки
                    Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");
                    String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
                    dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length() - 4);
                    ec.setCreationYear(Short.valueOf(dtEntrBuiltStr));

                    // этажность
                    Double etEntr = teParMng.getDbl(t, "Количество этажей, наибольшее(1-11)");
                    ec.setStoreysCount(etEntr.byteValue());

                    // Трансп. GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    ec.setTransportGUID(t.getTguid());

                    ah.getEntranceToCreate().add(ec);
                }));
        // Обновить подъезды
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null, 1).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_ENTRY"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Обновление подъезда, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
                    EntranceToUpdate eu = new EntranceToUpdate();
                    eu.setEntranceGUID(t.getEolink().getGuid());
                    String entryNum = String.valueOf(t.getEolink().getEntry());
                    eu.setEntranceNum(entryNum);

                    // год постройки
                    Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");

                    String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
                    dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length() - 4);
                    eu.setCreationYear(Short.valueOf(dtEntrBuiltStr));

                    // этажность
                    Double etEntr = teParMng.getDbl(t, "Количество этажей, наибольшее(1-11)");
                    eu.setStoreysCount(etEntr.byteValue());

                    // Трансп. GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    eu.setTransportGUID(t.getTguid());
                    ah.getEntranceToUpdate().add(eu);
                }));

        // Добавить жилое помещение(ия)
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null, 1).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_PRMS"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Добавление жилого помещения, Task.id={}", t.getId());
                    ResidentialPremises rp = new ResidentialPremises();
                    ResidentialPremisesToCreate rc =
                            new ResidentialPremisesToCreate();

                    // Тип - отдельная квартира
                    rc.setPremisesCharacteristic(ulistMng.getNsiElem("NSI", 30, "Характеристика помещения",
                            "Отдельная квартира"));

                    Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
                    if (isGkn != null && isGkn) {
                        // Ключ связи с ГКН/ЕГРП отсутствует.
                        rc.setNoRSOGKNEGRPRegistered(true);
                    } else {
                        String gknKey = teParMng.getStr(t,
                                "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                        if (gknKey == null) {
                            throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + t.getId());
                        }
                        // Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
                        rc.setCadastralNumber(gknKey);
                    }

                    // наличие подъезда
                    if (t.getEolink().getParent().getObjTp().getCd().equals("Подъезд")) {
                        // есть подъезд
                        // номер подъезда
                        String entryNum = String.valueOf(t.getEolink().getEntry());
                        if (entryNum != null) {
                            rc.setEntranceNum(entryNum);
                        }
                    } else {
                        // нет подъезда
                        rc.setHasNoEntrance(true);
                    }

                    // Номер помещения
                    rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));
                    // Общая площадь
                    Double totalArea = teParMng.getDbl(t, "Площадь.Общая");
                    rc.setTotalArea(BigDecimal.valueOf(totalArea));

                    // Жилая площадь
                    Double grossArea = teParMng.getDbl(t, "Площадь.Жилая");
                    if (grossArea != null) {
                        rc.setGrossArea(BigDecimal.valueOf(grossArea));
                    } else {
                        rc.setNoGrossArea(true);
                    }

                    // Транспортный GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    rc.setTransportGUID(t.getTguid());

                    rp.setResidentialPremisesToCreate(rc);
                    ah.getResidentialPremises().add(rp);
                }));

        // Добавить НЕжилое помещение(ия)
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null, 1).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_PRMS"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Добавление НЕжилого помещения, Task.id={}", t.getId());
                    NonResidentialPremiseToCreate rc =
                            new NonResidentialPremiseToCreate();

                    Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
                    if (isGkn != null && isGkn) {
                        // Ключ связи с ГКН/ЕГРП отсутствует.
                        rc.setNoRSOGKNEGRPRegistered(true);
                    } else {
                        // Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
                        String gknKey = teParMng.getStr(t,
                                "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                        if (gknKey == null) {
                            throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + t.getId());
                        }
                        rc.setCadastralNumber(gknKey);
                    }
                    // Номер помещения
                    rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));

                    String commProp = teParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");
                    rc.setIsCommonProperty(commProp.equals("Да"));

                    // Общая площадь
                    Double totalArea = teParMng.getDbl(t, "Площадь.Общая");
                    rc.setTotalArea(BigDecimal.valueOf(totalArea));

                    // Транспортный GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    rc.setTransportGUID(t.getTguid());

                    ah.getNonResidentialPremiseToCreate().add(rc);
                }));

        // Обновить жилое помещение(ия)
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null, 1).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_PRMS"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Обновление жилого помещения, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
                    ResidentialPremises rp = new ResidentialPremises();
                    ResidentialPremisesToUpdate rc =
                            new ResidentialPremisesToUpdate();
                    // Тип - отдельная квартира
                    rc.setPremisesCharacteristic(ulistMng.getNsiElem("NSI", 30, "Характеристика помещения",
                            "Отдельная квартира"));
                    Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
                    if (isGkn != null && isGkn) {
                        // Ключ связи с ГКН/ЕГРП отсутствует.
                        rc.setNoRSOGKNEGRPRegistered(true);
                    } else {
                        // Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
                        String gknKey = teParMng.getStr(t,
                                "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                        if (gknKey == null) {
                            throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + t.getId());
                        }
                        rc.setCadastralNumber(gknKey);
                    }

                    // наличие подъезда
                    if (t.getEolink().getParent().getObjTp().getCd().equals("Подъезд")) {
                        // есть подъезд
                        // номер подъезда
                        String entryNum = String.valueOf(t.getEolink().getEntry());
                        if (entryNum != null) {
                            rc.setEntranceNum(entryNum);
                        }
                    } else {
                        // нет подъезда
                        rc.setHasNoEntrance(true);
                    }

                    // Номер помещения
                    rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));
                    // Общая площадь
                    Double totalArea = teParMng.getDbl(t, "Площадь.Общая");
                    rc.setTotalArea(BigDecimal.valueOf(totalArea));
                    // Жилая площадь
                    Double grossArea = teParMng.getDbl(t, "Площадь.Жилая");
                    if (grossArea != null) {
                        rc.setGrossArea(BigDecimal.valueOf(grossArea));
                    } else {
                        rc.setNoGrossArea(true);
                    }
                    // Дата закрытия, если установлено - убрал параметр 26.12.2017 из за сложности восстановления через интерфейс ГИС!!!
	    	/*Date dtTerminate = teParMng.getDate(t, "ГИС ЖКХ.Дата закрытия");
	    	if (dtTerminate != null) {
		    	rc.setTerminationDate(Utl.getXMLDate(dtTerminate));
	    	}

	    	rc.setTerminationDate(null);*/

                    // Транспортный GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    rc.setTransportGUID(t.getTguid());

                    // GUID
                    rc.setPremisesGUID(t.getEolink().getGuid());

                    rp.setResidentialPremisesToUpdate(rc);
                    ah.getResidentialPremises().add(rp);
                }));

        // Обновить НЕжилое помещение(ия)
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null, 1).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_PRMS"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Обновление НЕжилого помещения, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
                    NonResidentialPremiseToUpdate rc =
                            new NonResidentialPremiseToUpdate();
                    Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
                    if (isGkn != null && isGkn) {
                        // Ключ связи с ГКН/ЕГРП отсутствует.
                        rc.setNoRSOGKNEGRPRegistered(true);
                    } else {
                        // Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
                        String gknKey = teParMng.getStr(t,
                                "ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)");
                        if (gknKey == null) {
                            throw new CantPrepSoap("Отсутствует Кадастровый номер, для связывания сведений с ГКН и ЕГРП! Task.Id=" + t.getId());
                        }
                        rc.setCadastralNumber(gknKey);
                    }
                    // Номер помещения
                    rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));
                    String commProp = teParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");

                    rc.setIsCommonProperty(commProp.equals("Да"));

                    // Дата закрытия, если установлено - убрал параметр 26.12.2017 из за сложности восстановления через интерфейс ГИС!!!
	    	/*Date dtTerminate = teParMng.getDate(t, "ГИС ЖКХ.Дата закрытия");
	    	if (dtTerminate != null) {
		    	rc.setTerminationDate(Utl.getXMLDate(dtTerminate));
	    	}*/

                    // Общая площадь
                    Double totalArea = teParMng.getDbl(t, "Площадь.Общая");
                    rc.setTotalArea(BigDecimal.valueOf(totalArea));

                    // Транспортный GUID
                    String tguid = Utl.getRndUuid().toString();
                    t.setTguid(tguid);
                    rc.setTransportGUID(t.getTguid());

                    // GUID
                    rc.setPremisesGUID(t.getEolink().getGuid());
                    ah.getNonResidentialPremiseToUpdate().add(rc);
                }));

        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        req.setId("foo");
        req.setApartmentHouse(ah);
        AckRequest ack = null;

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        try {
            ack = port.importHouseUOData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }

        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
            taskMng.logTask(task, false, false);

        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);

        }
    }

    /**
     * Получить результат отправки обновления объектов дома
     *
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importHouseUODataAsk(Task task) {
        //log.info("******* Task.id={}, Импорт объектов дома, запрос ответа", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            //log.trace("Проверка1");
            Task foundTask2 = reqProp.getFoundTask();
            retState.getImportResult().forEach(t -> {
                //log.trace("Проверка2");
                t.getCommonResult().forEach(d -> {
                    //log.trace("Проверка3");

                    // Найти элемент задания по Транспортному GUID
                    Task task2 = taskMng.getByTguid(foundTask2, d.getTransportGUID());
                    if (d.getUpdateDate() != null) {
                        // Есть дата обновления, установить GUID
                        task2.setState("ACP");
                        task2.setGuid(d.getGUID());
                        task2.setUn(d.getUniqueNumber());
                        task2.setUpdDt(Utl.getDateFromXmlGregCal(d.getUpdateDate()));

                        // Переписать значения параметров в eolink из task
                        teParMng.acceptPar(task2);
                        // Установить статус активности
                        task2.getEolink().setStatus(1);

                        // Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
                        taskMng.setEolinkIdf(task2.getEolink(), d.getGUID(), d.getUniqueNumber(), 1);
                        log.trace("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:",
                                reqProp.getFoundTask().getId(), d.getTransportGUID());
                        log.trace("GUID={}, UniqueNumber={}", d.getGUID(), d.getUniqueNumber());
                    }
                });
            });

            if (taskDao.getChildAnyErr(reqProp.getFoundTask())) {
                log.error("Найдены ошибки / Невыполнение в дочерних заданиях! Task.id={}", task.getId());
                // Установить статус
                reqProp.getFoundTask().setResult("Найдены ошибки / Невыполнение в дочерних заданиях!");
                reqProp.getFoundTask().setState("ERR");
                taskMng.logTask(task, false, false);

            } else {
                log.info("******* Task.id={}, Импорт объектов дома выполнен", task.getId());
                // Установить статус выполнения задания
                reqProp.getFoundTask().setState("ACP");
                taskMng.logTask(task, false, true);

            }
        }

    }


    /**
     * Проверить наличие заданий
     * и если их нет, - создать
     *
     * @param task
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void checkPeriodicHouseExp(Task task) throws WrongParam {
        Task foundTask = em.find(Task.class, task.getId());
        // создать по всем домам задания на экспорт объектов дома, если их нет
        // создавать по 10 штук, иначе - блокировка Task (нужен коммит)
        int a = 1;
        for (Eolink e : eolinkDao.getEolinkByTpWoTaskTp("Дом", "GIS_EXP_HOUSE", "SYSTEM_RPT_HOUSE_EXP")) {
            // статус - INS
            ptb.setUp(e, null, "GIS_EXP_HOUSE", "INS", soapConfig.getCurUser().getId());
            // добавить как зависимое задание к системному повторяемому заданию
            ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");
            ptb.save();
            // сохранить ведущее задание
            Task parent = ptb.getTask();

            // создать зависимое задание, выгрузки счетчиков ИПУ. оно не должно запуститься до выполнения ведущего
            ptb.setUp(e, null, parent, "GIS_EXP_METERS", "INS", soapConfig.getCurUser().getId(), null);
            // добавить как зависимое задание к системному повторяемому заданию
            ptb.addTaskPar("ГИС ЖКХ.Включая архивные", null, null, false, null);
            ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");
            ptb.save();
            log.info("Добавлено задание на экспорт счетчиков ИПУ по Дому Eolink.id={}", e.getId());

            a++;
            if (a >= 100) {
                break;
            }
        }

        // создать зависимые задания по домам по экспорту лиц.счетов, с указанием Ук - владельца счета
        // получить дома без заданий
        for (HouseUkTaskRec t : eolinkDao2.getHouseByTpWoTaskTp("GIS_EXP_HOUSE", "GIS_EXP_ACCS")) {

            Eolink eolHouse = em.find(Eolink.class, t.getEolHouseId());
            Eolink procUk = em.find(Eolink.class, t.getEolUkId());
            Task masterTask = em.find(Task.class, t.getMasterTaskId());
            ptb.setUp(eolHouse, null, masterTask, "GIS_EXP_ACCS", "INS",
                    soapConfig.getCurUser().getId(), procUk);
            ptb.save();
            log.info("Добавлено задание на экспорт лиц.счетов по Дому Eolink.id={}, Task.procUk.id={}",
                    eolHouse.getId(), procUk.getId());
            // добавить зависимое задание к системному повторяемому заданию
            // (будет запускаться системным заданием)
            ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");

        }

        // создать независимые задания по домам по импорту лиц.счетов, с указанием Ук - владельца счета
        // получить дома без заданий
        for (HouseUkTaskRec t : eolinkDao2.getHouseByTpWoTaskTp("GIS_IMP_ACCS")) {

            Eolink eolHouse = em.find(Eolink.class, t.getEolHouseId());
            Eolink procUk = em.find(Eolink.class, t.getEolUkId());
            ptb.setUp(eolHouse, null, null, "GIS_IMP_ACCS", "INS",
                    soapConfig.getCurUser().getId(), procUk);
            ptb.save();
            log.info("Добавлено задание на импорт лиц.счетов по Дому Eolink.id={}, Task.procUk.id={}",
                    eolHouse.getId(), procUk.getId());
            // добавить зависимое задание к системному повторяемому заданию
            // (будет запускаться системным заданием)
            ptb.addAsChild("SYSTEM_RPT_HOUSE_IMP");

        }
        // Установить статус выполнения задания
        foundTask.setState("ACP");
    }

}
