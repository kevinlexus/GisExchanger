package com.ric.st.builder.impl;


import com.dic.bill.dao.*;
import com.dic.bill.dto.HouseUkTaskRec;
import com.dic.bill.mm.*;
import com.dic.bill.model.bs.AddrTp;
import com.dic.bill.model.bs.Lst2;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.scott.Kart;
import com.dic.bill.model.scott.Ko;
import com.dic.bill.model.scott.Meter;
import com.diffplug.common.base.Errors;
import com.ric.cmn.Utl;
import com.ric.cmn.excp.*;
import com.ric.st.CommonErrs;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.CommonUtl;
import com.ric.st.impl.RetStateHouse;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.Accommodation;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.PayerInfo;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType.AccountReasons.OverhaulFormingKindOMSDescision;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType.AccountReasons.OverhaulFormingKindProtocol;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest.Account;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.*;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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
    private final EolinkParMng eolinkParMng;
    private final TaskEolinkParMng teParMng;
    private final TaskDAO taskDao;
    private final KartMng kartMng;
    private final EolinkMng eolinkMng;
    private final TaskMng taskMng;
    private final LstMng lstMng;
    private final EolinkToEolinkDAO eolinkToEolinkDao;
    private final ReqProps reqProp;
    private final SoapConfigs soapConfig;
    private final MeterMng meterMng;
    private final PseudoTaskBuilders ptb;

    private HouseManagementPortsTypeAsync port;
    private SoapBuilder sb;

    @Value("${appTp}")
    private Integer appTp;

    @Autowired
    public HouseManagementAsyncBindingBuilder(UlistMng ulistMng, ApplicationContext ctx, SoapConfig config,
                                              TaskParMng taskParMng, EolinkDAO eolinkDao, EolinkDAO2 eolinkDao2, EolinkParMng eolinkParMng,
                                              EolinkToEolinkDAO eolinkToEolinkDao,
                                              TaskEolinkParMng teParMng, TaskMng taskMng, PseudoTaskBuilders ptb,
                                              ReqProps reqProp, MeterMng meterMng, TaskDAO taskDao,
                                              SoapConfigs soapConfig, KartDAO kartDao, KartMng kartMng,
                                              EolinkMng eolinkMng, LstMng lstMng) {
        this.ulistMng = ulistMng;
        this.ctx = ctx;
        this.config = config;
        this.taskParMng = taskParMng;
        this.eolinkDao = eolinkDao;
        this.eolinkDao2 = eolinkDao2;
        this.eolinkParMng = eolinkParMng;
        this.eolinkToEolinkDao = eolinkToEolinkDao;
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
        Boolean err = false;
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public GetStateResult getState2(Task task) {
        // Признак ошибки
        boolean err = false;
        // Признак ошибки в CommonResult
        boolean errChld = false;
        String errStr = null;
        ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state = null;

        GetStateRequest gs = new GetStateRequest();
        gs.setMessageGUID(task.getMsgGuid());
        sb.setSign(false); // не подписывать запрос состояния!

        sb.makeRndMsgGuid();
        try {
            state = port.getState(gs);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e) {
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
        } else {
            if (state == null) {
                err = true;
                log.error("ОШИБКА! state==null");
            } else if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
                // Ошибки контролей или бизнес-процесса
                err = true;
                errStr = state.getErrorMessage().getDescription();
                log.info("Ошибка выполнения запроса = {}", errStr);
                task.setState("ERR");
                task.setResult(errStr);
            } else {
                // для импортов, поиск ошибок в дочерних заданиях
                for (ImportResult t : state.getImportResult()) {
                    for (CommonResult e : t.getCommonResult()) {
                        for (Error f : e.getError()) {
                            // Найти элемент задания по Транспортному GUID
                            Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
                            // Прочие задания
                            // установить статусы ошибки по дочерним заданиям
                            task2.setState("ERR");
                            errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
                            task2.setResult(errStr);
                            log.error(errStr);
                            errChld = true;
                        }
                        ;
                    }
                    ;
                }
            }
        }

        if (!err) {
            // контроль заданий импорта данных
            // если в главном задании нет ошибок, но в любом дочернем задании обнаружена ошибка - статус - "Ошибка"
            // и если уже не установлен признак ошибки
            if (errChld && !task.getState().equals("ERR")
                    && !task.getState().equals("ERS")) {
                task.setState("ERS");
                task.setResult(errStr);
                log.error("Ошибки в элементе CommonResult");
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
        taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        ;

        AckRequest ack = null;

        // для обработки ошибок
        Boolean err = false;
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
        return err;

    }


    /**
     * Получить результат экспорта счетчиков
     *
     * @throws ErrorProcessAnswer - ошибка процессинга ответа
     * @throws CantPrepSoap       - невозможно подготовить SOAP запрос
     * @throws WrongGetMethod     - ошибка получения параметра
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict(value = {"EolinkDAOImpl.getEolinkByGuid"}, allEntries = true) // здесь Evict потому что
    // пользователь может обновить Ko объекта счетчика мз Директа(осуществить привязку)
    // и тогда должен быть получен обновленный объект! ред.07.12.18
    public void exportDeviceDataAsk(Task task) throws ErrorProcessAnswer, CantPrepSoap, WrongGetMethod, UnusableCode {
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
                Integer meterTp = null;
                log.trace("Получен счетчик:");
                log.trace("Root GUID={}", t.getMeteringDeviceRootGUID());
                log.trace("Version GUID={}", t.getMeteringDeviceVersionGUID());
                log.trace("GISGKHNumber={}", t.getMeteringDeviceGISGKHNumber());
                log.trace("Серийный номер={}", t.getBasicChatacteristicts().getMeteringDeviceNumber());

                String premiseGUID = null;
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
                    log.error("Необрабатываемый тип счетчика прочего типа: Root GUID=",
                            t.getMeteringDeviceRootGUID());
                    continue;
                }

                // Получить список лс, к которым привязан счетчик
                List<String> lstAccGuid = null;
                if (meterTp == 0) {
                    lstAccGuid = new ArrayList<>(t.getBasicChatacteristicts().getResidentialPremiseDevice()
                            .getAccountGUID());
                } else if (meterTp == 1) {
                    lstAccGuid = new ArrayList<>(t.getBasicChatacteristicts().getNonResidentialPremiseDevice()
                            .getAccountGUID());
                }

                // найти корневую запись счетчика
                Eolink rootEol = eolinkDao.getEolinkByGuid(t.getMeteringDeviceRootGUID());
                // найти версию счетчика, по GUID
                Eolink versionEol = eolinkDao.getEolinkByGuid(t.getMeteringDeviceVersionGUID());
                // найти помещение, к которому прикреплен счетчик
                Eolink premiseEol = eolinkDao.getEolinkByGuid(premiseGUID);

                String servCd = null;
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
                        Meter meter = meterMng.getActualMeterByKoUsl(premiseEol.getKoObj(), usl,
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
     * @throws CantPrepSoap - невозможно подготовить SOAP
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean exportContract(Task task) throws CantPrepSoap {
        //log.info("******* Task.id={}, экспорт договора управления, вызов", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);

        String houseGuid = reqProp.getFoundTask().getEolink().getGuid();

        // для обработки ошибок
        Boolean err = false;
        String errMainStr = null;

        ExportCAChAsyncRequest req = new ExportCAChAsyncRequest();
        AckRequest ack = null;
        req.setId("foo");
        sb.setSign(true);
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        ExportCAChRequestCriteriaType criteria = new ExportCAChRequestCriteriaType();
        Eolink uk = eolinkMng.getEolinkByReuKulNdTp(reqProp.getReu(), null, null, null, null, "Организация");

        criteria.setFIASHouseGuid(houseGuid);//"a209e075-f304-4d1a-a15a-f723b6c2dd4e"); // г.Березовский, Комсомольский б-р, 10
        criteria.setUOGUID(uk.getGuid());//"b21dadf0-e7e6-4824-aa04-19bd617bb3e1"); // GUID ООО "УК ЖКС"  (Пром)
        criteria.setLastVersionOnly(true);
        req.getCriteria().add(criteria);

        try {
            ack = port.exportCAChData(req);
        } catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
            e1.printStackTrace();
            err = true;
            errMainStr = e1.getFaultInfo().getErrorMessage();
        }

        RetStateHouse retState = null;
        if (!err) {
            retState = getState(ack);
        }

        // Показать ошибки, если есть
        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: " + errMainStr);
        } else if (retState.getErr()) {
            err = true;
            String errStr = retState.getErrStr();
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Вложенная ошибка XML: " + errStr);
        } else {
            // Ошибок нет, обработка
            try {
                retState.getState().getExportCAChResult().forEach(Errors.rethrow().wrap(t -> {
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
                                //.withAppTp(reqProp.getAppTp())
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
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
        return err;
    }


    /**
     * Экспортировать договора по УК - метод был создан, для попытки выгрузки GUID домов определенной УК
     * - не взлетело, так как требуется GUID дома. ГИС еще не сделал метод по выгрузке всех домов УК ред. 25.07.2018
     *
     * @param task - задание (если есть)
     * @throws CantPrepSoap - невозможно подготовить SOAP
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean exportCaChData(Task task) throws CantPrepSoap {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        sb.setSign(true);

        Eolink house = reqProp.getFoundTask().getEolink();
        Eolink uk = house.getParent();

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
        Boolean err = false;
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

        return err;

    }


    /**
     * Получить результат экспорта договоров по УК
     *
     * @throws WrongGetMethod
     * @throws CantPrepSoap   - невозможно подготовить SOAP
     * @throws WrongParam
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportCaChDataAsk(Task task) throws WrongGetMethod, CantPrepSoap, WrongParam {
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
                    t.getContract().getContractObject().forEach(d -> {
                        log.info("По договору GUID={}, найден дом GUID={}",
                                t.getContract().getContractGUID(), d.getFIASHouseGuid());
                    });
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
     * @return
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean exportHouseData(Task task) throws CantPrepSoap {
        //log.info("******* Task.id={}, экспорт объектов дома, вызов", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        Eolink houseEol = reqProp.getFoundTask().getEolink();
        String houseGuid = houseEol.getGuid();

        // для обработки ошибок
        Boolean err = false;
        String errMainStr = null;

        ExportHouseRequest req = new ExportHouseRequest();
        req.setId("foo");
        sb.setSign(true);
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        req.setFIASHouseGuid(houseGuid);
        AckRequest ack = null;
        try {
            ack = port.exportHouseData(req);
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

        return err;
    }


    /**
     * Получить результат экспорта объектов дома
     *
     * @throws WrongGetMethod
     * @throws CantPrepSoap
     * @throws WrongParam
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportHouseDataAsk(Task task) throws WrongGetMethod, CantPrepSoap, WrongParam, UnusableCode {
        //log.info("******* Task.id={}, экспорт объектов дома, запрос ответа", task.getId());
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
                HouseBasicExportType bc = ah.getBasicCharacteristicts();

                Map<Integer, Eolink> entryMap = new HashMap<Integer, Eolink>();

                // Подъезды
                List<String> lstEntryGuid = new ArrayList<String>();
                for (Entrance t : ah.getEntrance()) {
                    log.trace("Подъезд: №={}, GUID={}", t.getEntranceNum(), t.getEntranceGUID());
                    Eolink entryEol = eolinkDao.getEolinkByGuid(t.getEntranceGUID());
                    lstEntryGuid.add(t.getEntranceGUID());
                    if (entryEol == null) {
                        // не найдено, создать подъезд
                        AddrTp addrTp = lstMng.getAddrTpByCD("Подъезд");

                        entryEol = Eolink.builder()
                                .withReu(reqProp.getReu())
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
                lstEntry.stream().forEach(t -> {
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
                                .withReu(reqProp.getReu())
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
                            CommonErrs.ERR_EMPTY_KLSK | CommonErrs.ERR_DOUBLE_KLSK_EOLINK, false);
                    // обновить параметры помещения
                    if (premisEol.getKoObj() == null) {
                        // найти соответствующий объект Ko
                        Ko ko = null;
                        try {
                            ko = kartMng.getKoByKulNdKw(reqProp.getKul(), reqProp.getNd(), num);
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
                            List<Eolink> checkEolink = eolinkDao2.getEolinkByKlskId(ko.getId());
                            if (checkEolink != null) {
                                soapConfig.saveError(premisEol, CommonErrs.ERR_DOUBLE_KLSK_EOLINK, true);
                            } else {
                                //log.info("Попытка установить по объекту Eolink.id={}, Ko.id={}",
                                //      premisEol.getId(), ko.getId());
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
                        if (premisEol.getStatus()!=0) {
                            // Объект не активен
                            premisEol.setStatus(0);
                        }
                    } else {
                        if (premisEol.getStatus()!=1) {
                            // Объект активен
                            premisEol.setStatus(1);
                        }
                    }
                    t.getLivingRoom().forEach(f -> {
                        log.trace("f.isNoRSOGKNEGRPRegistered()1={}", f.isNoRSOGKNEGRPRegistered());
                    });
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
                                .withReu(reqProp.getReu())
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
                            ko = kartMng.getKoByKulNdKw(reqProp.getKul(), reqProp.getNd(), num);
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
                            List<Eolink> checkEolink = eolinkDao2.getEolinkByKlskId(ko.getId());
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
                        if (premisEol.getStatus()!=0) {
                            // Объект не активен
                            premisEol.setStatus(0);
                        }
                    } else {
                        if (premisEol.getStatus()!=1) {
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
     * @return
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
        if (reqProp.getAppTp().equals(0) || reqProp.getAppTp().equals(2)) {
            // старая и эксперем. разработка, добавить лидирующие нули
            num = Utl.lpad(num, "0", 7);
        }
        return num;
    }

    /**
     * Подготовить номер нежилого помещения
     *
     * @param t
     * @return
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
        if (reqProp.getAppTp().equals(0) || reqProp.getAppTp().equals(2)) {
            // старая и эксперем. разработка, добавить лидирующие нули
            num = Utl.lpad(num, "0", 7);
        }
        return num;
    }

    /**
     * Экспортировать лицевые счета
     *
     * @param task - задание
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportAccountData(Task task) throws CantPrepSoap, CantSendSoap, WrongParam {
        taskMng.logTask(task, true, null);
        if (task.getProcUk() == null)
            throw new WrongParam("По заданию task.id=" + task.getId() + " не заполнен TASK.FK_PROC_UK");
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        ;

        ExportAccountRequest req = new ExportAccountRequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());

        // GUID дома
        req.setFIASHouseGuid(task.getEolink().getGuid());

        AckRequest ack = null;
        // для обработки ошибок
        Boolean err = false;
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void exportAccountDataAsk(Task task) throws CantPrepSoap, WrongParam, WrongGetMethod, ErrorProcessAnswer, CantSendSoap {
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
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            // Ошибок не найдено
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

                // #####################
                OverhaulFormingKindProtocol protocol = t.getAccountReasons().getOverhaulFormingKindProtocol();
                if (protocol != null) {
                    log.trace("########## Лиц.счет={}, Протокол решения собственников о выбранном "
                                    + "способе формирования фонда капитального ремонта, GUID={}",
                            num,
                            protocol.getOverhaulFormingKindProtocolGUID());
                }
                OverhaulFormingKindOMSDescision decision = t.getAccountReasons().getOverhaulFormingKindOMSDescision();
                if (decision != null) {
                    log.trace("########## Лиц.счет={}, Решение ОМС о выбранном способе "
                                    + "формирования фонда капитального ремонта, GUID={}",
                            num,
                            decision.getOverhaulFormingKindOMSDescisionGUID());
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
                        throw new ErrorProcessAnswer("Не найден лицевой счет с lsk=" + num);
                    }

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
                } else {
                    // Лиц.счет уже существует, обновить его параметры
                    log.trace("Попытка обновить запись лицевого счета в Eolink: GUID={}, AccountNumber={}, ServiceId={}", t.getAccountGUID(),
                            t.getAccountNumber(), t.getServiceID());
                    // идентификатор ЖКУ
                    accountEol.setServiceId(t.getServiceID());
                }

                // отметить закрытого лс
                //ptb.setUp(houseEol, task, "GIS_TMP", null, soapConfig.getCurUser().getId());
                if (t.getClosed() != null) {
                    // лс закрыт
                    accountEol.setStatus(0);
                }
            }
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);

        }

		/* Lev: убрал. создаёт путаницу
		 * Boolean addPrepImport = taskParMng.getBool(task, "ГИС ЖКХ.Подготовить задание на импорт");
		if (reqProp.getAppTp() != 2 && addPrepImport != null && addPrepImport) {
			// если не эксп. версия приложения и установлен параметр подготовки
			log.trace("******* Task.id={}, подготовка задания для импорта лицевых счетов дома", task.getId());
			prepTaskImportAccount(houseEol);
			log.trace("******* Task.id={}, подготовка задания для импорта лицевых счетов дома выполнена", task.getId());
		}*/


    }

    /**
     * Импортировать лицевые счета
     *
     * @return - признак ошибки
     * @throws WrongGetMethod
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap, WrongParam, CantSendSoap {
        // индивидуально выполнить setUp - так как может выполняться от имени РСО
        setUp(task);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        // Трассировка XML
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        ImportAccountRequest req = new ImportAccountRequest();
        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());



        List<Task> lstTask = taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "ЛС", null, reqProp.getAppTp()).stream()
                .filter(t -> t.getAct().getCd().equals("GIS_ADD_ACC")).collect(Collectors.toList());
        for (Task t : lstTask) {
            log.trace("Обработка Task.id={}, лиц.счета={}", t.getId(), t.getEolink().getKart().getLsk());
            // Обработать все лиц.счета в дочерних заданиях
            Account ac = new Account();
            req.getAccount().add(ac);

            try {
                ac.setCreationDate(Utl.getXMLDate(teParMng.getDate(t, "ГИС ЖКХ.Дата начала действия")));
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
                throw new CantPrepSoap("Ошибка при конвертации даты!");
            }

            ac.setLivingPersonsNumber(teParMng.getDbl(t, "113ГС-ЭПМД-1.1-17.10.-Количество проживающих").intValue());
            ac.setTotalSquare(BigDecimal.valueOf(teParMng.getDbl(t, "Площадь.Общая")));
            ac.setHeatedArea(BigDecimal.valueOf(teParMng.getDbl(t, "ГИС ЖКХ.Площадь отапливаемая")));

            // Лиц.счет УК
            ac.setIsUOAccount(true);

            // Транспортный GUID
            String tguid = Utl.getRndUuid().toString();
            t.setTguid(tguid);
            ac.setTransportGUID(tguid);

            Accommodation acm = new Accommodation();

            // Тип объекта
            String objTp = t.getEolink().getObjTp().getCd();

            String objGuid;
            if (objTp.equals("Дом")) {
                objGuid = t.getEolink().getGuid();
                acm.setFIASHouseGuid(objGuid);
            } else if (objTp.equals("ЛС")) {
                // Использовать GUID родительского объекта (дома)
                objGuid = t.getEolink().getParent().getGuid();
                acm.setPremisesGUID(objGuid);
            }
            ac.getAccommodation().add(acm);
            // № лицевого счета
            ac.setAccountNumber(t.getEolink().getKart().getLsk());

            // Сведения о плательщике (решили оставить "val")
            PayerInfo pf = new PayerInfo();
            AccountIndType ind = new AccountIndType();
            ind.setFirstName("val");
            ind.setSurname("val");
            ind.setPatronymic("val");
            pf.setInd(ind);
            ac.setPayerInfo(pf);

            // Account GUID, при обновлении лиц.счета
            ac.setAccountGUID(t.getEolink().getGuid());

            // Признак закрытия лицевого счета, если установлен
            Date dtTerminate = teParMng.getDate(t, "ГИС ЖКХ.Дата закрытия");
            if (dtTerminate != null) {
                ClosedAccountAttributesType closedTp = new ClosedAccountAttributesType();
                try {
                    closedTp.setCloseDate(Utl.getXMLDate(dtTerminate));
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                    throw new CantPrepSoap("Ошибка при конвертации даты!");
                }
                String closeReason = teParMng.getStr(t, "ГИС ЖКХ.Причина закрытия");
                closedTp.setCloseReason(ulistMng.getNsiElem("NSI", 22, "Причина закрытия лицевого счета", closeReason));
                closedTp.setDescription(closeReason);
                ac.setClosed(closedTp);
            }
        }

        AckRequest ack = null;

        // для обработки ошибок
        Boolean err = false;
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
        return err;

    }


    /**
     * Получить результат импорта лицевых счетов
     *
     * @throws CantPrepSoap
     * @throws WrongGetMethod
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importAccountDataAsk(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam {
        //log.info("******* Task.id={}, Импорт лицевых счетов, запрос ответа", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        ;

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            //retState.getImportResult().stream().forEach(t -> {
            for (ImportResult t : retState.getImportResult()) {
                for (CommonResult d : t.getCommonResult()) {
                    // Найти элемент задания по Транспортному GUID
                    Task task2 = taskMng.getByTguid(task, d.getTransportGUID());
                    // Переписать значения параметров в eolink из task
                    teParMng.acceptPar(task2);
                    // Признак закрытия лицевого счета, если установлен
                    Date dtTerminate = taskParMng.getDate(task2, "ГИС ЖКХ.Дата закрытия");
                    // Установить статус активности счета
                    Integer status = null;
                    if (dtTerminate != null) {
                        status = 0;
                    } else {
                        status = 1;
                    }
                    // Есть дата обновления, установить GUID
                    task2.setGuid(d.getGUID());
                    task2.setUn(d.getUniqueNumber());
                    task2.setUpdDt(Utl.getDateFromXmlGregCal(d.getUpdateDate()));
                    log.trace("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:",
                            reqProp.getFoundTask().getId(), d.getTransportGUID());
                    log.trace("GUID={}, UniqueNumber={}", d.getGUID(), d.getUniqueNumber());
                    // Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
                    taskMng.setEolinkIdf(task2.getEolink(), d.getGUID(), d.getUniqueNumber(), status);
                    task2.setState("ACP");
                }
            }

            if (taskDao.getChildAnyErr(reqProp.getFoundTask())) {
                log.trace("Найдены ошибки / Невыполнение в дочерних заданиях! Task.id={}", task.getId());
                // Установить статус
                reqProp.getFoundTask().setResult("Найдены ошибки / Невыполнение в дочерних заданиях!");
                reqProp.getFoundTask().setState("ERR");
                taskMng.logTask(task, false, false);

            } else {
                log.info("******* Task.id={}, Импорт лицевых счетов, выполнен", task.getId());
                // Установить статус выполнения задания
                reqProp.getFoundTask().setState("ACP");
                taskMng.logTask(task, false, true);

            }
        }
    }


    /*
     * Обновление объектов дома
     *
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean importHouseUOData(Task task) throws WrongGetMethod, CantPrepSoap {
        //log.info("******* Task.id={}, Импорт объектов дома, вызов", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        ;
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
            dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length() - 4, dtBuiltStr.length());
            Integer usedYear = Integer.valueOf(dtBuiltStr);
            bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

            Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
            bc.setCulturalHeritage((cult == 1d) ? true : false);

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
            dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length() - 4, dtBuiltStr.length());
            Integer usedYear = Integer.valueOf(dtBuiltStr);
            bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

            Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
            bc.setCulturalHeritage((cult == 1d) ? true : false);

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
            Integer etMin2 = etMin.intValue();
            ac.setMinFloorCount(etMin2.byteValue());

            String tguid = Utl.getRndUuid().toString();
            reqProp.getFoundTask().setTguid(tguid);
            log.trace("Установлен house TGUID={}", tguid);
            ac.setTransportGUID(tguid);

            ac.setBasicCharacteristicts(bc);
            ah.setApartmentHouseToUpdate(ac);
        }

        // Добавить подъезды
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null,
                reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_ENTRY"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Добавление подъезда, Task.id={}", t.getId());
                    EntranceToCreate ec = new EntranceToCreate();
                    String entryNum = String.valueOf(t.getEolink().getEntry());
                    ec.setEntranceNum(entryNum);

                    // год постройки
                    Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");
                    String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
                    dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length() - 4, dtEntrBuiltStr.length());
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
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null, reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_ENTRY"))
                .forEach(Errors.rethrow().wrap(t -> {
                    log.trace("Обновление подъезда, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
                    EntranceToUpdate eu = new EntranceToUpdate();
                    eu.setEntranceGUID(t.getEolink().getGuid());
                    String entryNum = String.valueOf(t.getEolink().getEntry());
                    eu.setEntranceNum(entryNum);

                    // год постройки
                    Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");

                    String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
                    dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length() - 4, dtEntrBuiltStr.length());
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
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null, reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_PRMS"))
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
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null, reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_ADD_PRMS"))
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
                    rc.setIsCommonProperty(commProp.equals("Да") ? true : false);

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
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null, reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_PRMS"))
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
        taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null, reqProp.getAppTp()).stream().filter(t -> t.getAct().getCd().equals("GIS_UPD_PRMS"))
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

                    rc.setIsCommonProperty(commProp.equals("Да") ? true : false);

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
        Boolean err = false;
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
        return err;
    }

    /**
     * Получить результат отправки обновления объектов дома
     *
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importHouseUODataAsk(Task task) throws CantPrepSoap {
        //log.info("******* Task.id={}, Импорт объектов дома, запрос ответа", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        ;

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            //log.trace("Проверка1");
            Task foundTask2 = reqProp.getFoundTask();
            retState.getImportResult().stream().forEach(t -> {
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
     * Импортировать счетчики (приборы учета)
     *
     * @return - признак ошибки
     * @throws WrongGetMethod
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap {
        //log.info("******* Task.id={}, импорт приборов учета, вызов", task.getId());
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);
        ;

        ImportMeteringDeviceDataRequest req = new ImportMeteringDeviceDataRequest();
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        req.setId("foo");

        req.setFIASHouseGuid(reqProp.getHouseGuid());

        // получить все дочерние задания
        List<Task> lstTask = reqProp.getFoundTask().getChild();
        for (Task t : lstTask) {
            MeteringDevice md = new MeteringDevice();
            // Транспортный GUID
            String tguid = Utl.getRndUuid().toString();
            t.setTguid(tguid);
            md.setTransportGUID(tguid);

            Eolink e = t.getEolink();

            if (!e.getObjTp().getCd().equals("СчетчикФизический")) {
                throw new CantPrepSoap("Некорректный тип объекта по заданию Task.id=" + t.getId());
            }

            String versionGuid = null;
            // для архивации и обновления
            DeviceDataToUpdate devDataUpd = null;

            if (t.getAct().getCd().equals("GIS_ARCH_METER") || t.getAct().getCd().equals("GIS_UPD_METER_BEFORE_VAL")) {
                // Если архивация или обновление - найти версию счетчика
                Boolean isFoundVers = false;
                for (Eolink ver : e.getChild()) {
                    if (ver.getStatus().equals(1) && ver.getObjTp().getCd().equals("СчетчикВерсия")) {
                        // Взять GUID первой активной версии счетчика
                        versionGuid = ver.getGuid();
                        isFoundVers = true;
                        break;
                    }
                }
                ;
                if (!isFoundVers) {
                    throw new CantPrepSoap("Не найдена активная версия счетчика для " + t.getAct().getName() + " по счетчику Eolink.id=" + e.getId());
                }
                devDataUpd = new DeviceDataToUpdate();
            }


            if (t.getAct().getCd().equals("GIS_ADD_METER") || t.getAct().getCd().equals("GIS_UPD_METER_BEFORE_VAL")) {
                int varMeter;
                if (t.getAct().getCd().equals("GIS_ADD_METER")) {
                    // Добавить счетчик
                    log.trace("Добавление счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
                    varMeter = 0;
                } else {
                    // Обновить счетчик
                    log.trace("Обновление счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
                    varMeter = 1;
                }

                if (varMeter == 0 && t.getEolink().getGuid() != null) {
                    // GUID не должен быть заполнен при добавлении счетчика
                    throw new CantPrepSoap("По объекту уже имеется GUID, невозможно импортировать! Задание Task.id=" + t.getId());
                }

                Eolink premiseEol = t.getEolink().getParent();
                MeteringDeviceBasicCharacteristicsType bc = new MeteringDeviceBasicCharacteristicsType();

                // Дата ввода в эксплуатацию
                Date dtBegin = teParMng.getDate(t, "Счетчик.ДатаВводаЭкс");
                try {
                    bc.setCommissioningDate(Utl.getXMLDate(dtBegin
                    ));
                } catch (DatatypeConfigurationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    throw new CantPrepSoap("Некорректная дата ввода в эксплуатацию счетчика");
                }

                // Дата установки
                Date dtInstall = teParMng.getDate(t, "Счетчик.ДатаУстановки");
                try {
                    bc.setInstallationDate(Utl.getXMLDate(dtInstall
                    ));
                } catch (DatatypeConfigurationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    throw new CantPrepSoap("Некорректная дата установки счетчика");
                }

                bc.setMeteringDeviceNumber(teParMng.getStr(t, "Счетчик.НомерПУ"));
                bc.setRemoteMeteringMode(false);
                bc.setTemperatureSensor(false);
                bc.setPressureSensor(false);

                bc.setMeteringDeviceNumber(teParMng.getStr(t, "Счетчик.НомерПУ"));
                bc.setMeteringDeviceModel(teParMng.getStr(t, "Счетчик.Модель"));
                bc.setMeteringDeviceStamp(teParMng.getStr(t, "ПУ.Марка"));

                // признак, что прибор передаёт объем потребленного ресурса КР
                Boolean isVol = teParMng.getBool(t, "ГИС ЖКХ.Признак_ПУ_КР");
                if (isVol != null) {
                    bc.setConsumedVolume(teParMng.getBool(t, "ГИС ЖКХ.Признак_ПУ_КР"));
                } else {
                    bc.setConsumedVolume(false);
                }

                if (premiseEol.getObjTp().getCd().equals("Квартира")) {
                    // Жилое помещение
                    ResidentialPremiseDevice premiseRsd = new ResidentialPremiseDevice();
                    // premiseRsd.setPremiseGUID(premiseEol.getGuid()); TODO Отключил, так как после новой версии ГИС не компилировалось ред.27.09.2018
                    // Добавить лицевые счета
                    eolinkToEolinkDao.getParentEolink(e, "Логическая связь").stream().forEach(d -> {
                        premiseRsd.getAccountGUID().add(d.getGuid());
                        log.trace("К счетчику добавлена связь с лиц.счетом GUID={}", d.getGuid());
                    });

                    bc.setResidentialPremiseDevice(premiseRsd);
                } else if (premiseEol.getObjTp().getCd().equals("Помещение нежилое")) {

                    NonResidentialPremiseDevice premiseNrsd = new NonResidentialPremiseDevice();
                    // premiseNrsd.setPremiseGUID(premiseEol.getGuid()); TODO Отключил, так как после новой версии ГИС не компилировалось ред.27.09.2018
                    // Нежилое помещение
                    bc.setNonResidentialPremiseDevice(premiseNrsd);
                    // Добавить лицевые счета
                    eolinkToEolinkDao.getParentEolink(e, "Логическая связь").stream().forEach(d -> {
                        premiseNrsd.getAccountGUID().add(d.getGuid());
                        log.trace("К счетчику добавлена связь с лиц.счетом GUID={}", d.getGuid());
                    });
                }

                MeteringDeviceFullInformationType mdinf = new MeteringDeviceFullInformationType();
                if (varMeter == 0) {
                    // добавить счетчик
                    md.setDeviceDataToCreate(mdinf);
                } else {
                    // обновить счетчик, "до передачи показаний" - метод
                    devDataUpd.setMeteringDeviceVersionGUID(e.getGuid());
                    devDataUpd.setUpdateBeforeDevicesValues(mdinf);
                    devDataUpd.setMeteringDeviceVersionGUID(versionGuid);
                    md.setDeviceDataToUpdate(devDataUpd);
                }

                mdinf.setBasicChatacteristicts(bc);
                // не связан с другим счетчиком
                mdinf.setNotLinkedWithMetering(true);

                // Сведения о коммунальном ресурсе и базовые показания ПУ (тепловая энергия, газ, горячая вода, холодная вода, сточные бытовые воды)
                MunicipalResourceNotElectricBaseType munResNenerg = new MunicipalResourceNotElectricBaseType();

                NsiRef mres = null;
                // Получить ресурс по коду USL
                mres = ulistMng.getResourceByUsl(e.getUsl());

                if (ulistMng.getResType(e.getUsl()) != 1) {
                    // Не эл.энерг.
                    munResNenerg.setMunicipalResource(mres);
                    munResNenerg.setMeteringValue(String.valueOf(taskParMng.getDbl(t, "Счетчик.Показ(Т1)")));
                    mdinf.getMunicipalResourceNotEnergy().add(munResNenerg);
                } else {
                    // Сведения о коммунальном ресурсе и базовые показания ПУ (электрическая энергия)
                    MunicipalResourceElectricBaseType mresEl = new MunicipalResourceElectricBaseType();
                    mresEl.setMeteringValueT1(String.valueOf(taskParMng.getDbl(t, "Счетчик.Показ(Т1)")));
                    mdinf.setMunicipalResourceEnergy(mresEl);
                }


            } else if (t.getAct().getCd().equals("GIS_ARCH_METER")) {
                // Архивация счетчика
                log.trace("Архивация счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
                // Взять GUID первой активной версии счетчика
                devDataUpd.setMeteringDeviceVersionGUID(versionGuid);

                ArchiveDevice archDev = new ArchiveDevice();
                String reason = taskParMng.getStr(t, "ГИС ЖКХ.Причина архивации");
                archDev.setArchivingReason(ulistMng.getNsiElem("NSI", 21, "Причина архивации прибора учета", reason));
                //log.trace("reason={}, nsi={}", reason, ulistMng.getNsiElem("NSI", 21, "Причина архивации прибора учета", reason));
                devDataUpd.setArchiveDevice(archDev);
                md.setDeviceDataToUpdate(devDataUpd);
            }

            req.getMeteringDevice().add(md);
        }

        AckRequest ack = null;
        // для обработки ошибок
        Boolean err = false;
        String errMainStr = null;

        try {
            ack = port.importMeteringDeviceData(req);
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
        return err;
    }


    /**
     * Получить результат импорта счетчиков
     *
     * @throws CantPrepSoap
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importMeteringDeviceDataAsk(Task task) throws CantPrepSoap {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null ? reqProp.getFoundTask().getTrace().equals(1) : false);

        // получить состояние
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
            return;
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            for (ImportResult importResult : retState.getImportResult()) {
                for (CommonResult t : importResult.getCommonResult()) {
                    // TODO сделать реализаию импорта счетчика
                }
            }
        }
            /*.stream().forEach(t -> {
                t.getCommonResult().stream().forEach(d -> {

                        }*/
        // Записать идентификаторы ПУ корневого (физического) счетчика, полученного от ГИС (если уже не установлены)
        //    taskMng.setEolinkIdf(task2.getEolink(), d.getImportMeteringDevice().getMeteringDeviceGUID(),
        //          d.getUniqueNumber(), 1);
        // task2.getEolink().setStatus(0);

    }


    /**
     * Проверить наличие заданий на экспорт объектов дома
     * и если их нет, - создать
     *
     * @param task
     * @throws WrongParam
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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

            // сохранить ведущее задание
            parent = ptb.getTask();

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

        // создать зависимые задания по домам по выгрузке лиц.счетов, с указанием Ук - владельца счета
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
        // Установить статус выполнения задания
        foundTask.setState("ACP");
    }

}
