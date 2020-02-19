package com.ric.st.builder.impl;


import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.dao.MeterDAO;
import com.dic.bill.dao.ObjParDAO;
import com.dic.bill.dto.MeterData;
import com.dic.bill.mm.EolinkMng;
import com.dic.bill.mm.EolinkParMng;
import com.dic.bill.mm.MeterMng;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.scott.Meter;
import com.dic.bill.model.scott.ObjPar;
import com.ric.cmn.Utl;
import com.ric.cmn.excp.UnusableCode;
import com.ric.cmn.excp.WrongParam;
import com.ric.st.*;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.dao.UlistDAO;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.*;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringPortTypesAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringServiceAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DeviceMeteringAsyncBindingBuilder implements DeviceMeteringAsyncBindingBuilders {

    private final ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
    private final UlistMng ulistMng;
    private final TaskMng taskMng;
    private final EolinkDAO eolinkDao;
    private final ReqProps reqProp;
    private final SoapConfigs soapConfig;
    private final EolinkMng eolinkMng;
    private final MeterDAO meterDao;
    private final MeterMng meterMng;
    private final ConfigApp configApp;

    private final PseudoTaskBuilders ptb;
    private final ObjParDAO objparDao;

    @Value("${appTp}")
    private String appTp;
    @Value("${pathCounter}")
    private String pathCounter;
    @Value("${logQueue:soap2gis-log}")
    private String logQueue;

    private DeviceMeteringServiceAsync service;
    private DeviceMeteringPortTypesAsync port;
    private SoapBuilder sb;

    public DeviceMeteringAsyncBindingBuilder(ApplicationContext ctx, UlistMng ulistMng, ObjParDAO objparDao, ConfigApp configApp, TaskMng taskMng, EolinkDAO eolinkDao, UlistDAO ulistDao, ReqProps reqProp, SoapConfigs soapConfig, EolinkParMng eolParMng, PseudoTaskBuilders ptb, EolinkMng eolinkMng, MeterDAO meterDao, MeterMng meterMng) {
        this.ctx = ctx;
        this.ulistMng = ulistMng;
        this.objparDao = objparDao;
        this.configApp = configApp;
        this.taskMng = taskMng;
        this.eolinkDao = eolinkDao;
        this.reqProp = reqProp;
        this.soapConfig = soapConfig;
        this.ptb = ptb;
        this.eolinkMng = eolinkMng;
        this.meterDao = meterDao;
        this.meterMng = meterMng;
    }

    /**
     * Инициализация - создать сервис и порт
     *
     */
    @Override
    public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
        service = new DeviceMeteringServiceAsync();
        port = service.getDeviceMeteringPortAsync();

        // подоготовительный объект для SOAP
        sb = ctx.getBean(SoapBuilder.class);
        reqProp.setPropBefore(task);
        sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(),
                reqProp.getHostIp());

        // логгинг запросов
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        // Id XML подписчика
        sb.setSignerId(reqProp.getSignerId());
    }


    /**
     * Получить состояние запроса
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public GetStateResult getState2(Task task) {
        // Признак ошибки
        boolean err = false;
        // Признак ошибки в CommonResult
        String errStr = null;
        ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state = null;

        GetStateRequest gs = new GetStateRequest();
        gs.setMessageGUID(task.getMsgGuid());
        sb.setSign(false); // не подписывать запрос состояния!

        sb.makeRndMsgGuid();
        String errMsg = null;
        try {
            state = port.getState(gs);
        } catch (Fault e) {
            errMsg = e.getFaultInfo().getErrorCode();
            e.printStackTrace();
            err = true;
            errStr = "Запрос вернул ошибку!";
        }

        if (state != null && state.getRequestState() != 3) {
            // вернуться, если задание всё еще не выполнено
            log.trace("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());
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
     * Импортировать показания счетчиков
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean importMeteringDeviceValues(Task task) throws DatatypeConfigurationException {
        taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        // Трассировка XML
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ImportMeteringDeviceValuesRequest req = new ImportMeteringDeviceValuesRequest();

        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        req.setFIASHouseGuid(reqProp.getHouseGuid());

        // получить счетчики по дому
        Eolink house = reqProp.getFoundTask().getEolink();
        List<Eolink> MetersEol = eolinkMng.getEolinkByEolinkDownHierarchy(house, "СчетчикФизический");

        // перебрать только те счетчики, по которым есть неотправленные показания (status=0)
        // и по которым есть соответствующий статус отправки показаний в ГИС (gisConnTp=2,3)
        for (Eolink meterEol : MetersEol) {
            if (meterEol.getKoObj() != null) {
                Meter meter = meterEol.getKoObj().getMeter();
                if (Utl.in(Utl.nvl(meter.getGisConnTp(), 0), 2, 3)) {
                    List<ObjPar> values = meterMng.getValuesByMeter(meter, 0, configApp.getPeriod());
                    for (ObjPar value : values) {
                        ImportMeteringDeviceValuesRequest.MeteringDevicesValues val =
                                new ImportMeteringDeviceValuesRequest.MeteringDevicesValues();
                        val.setMeteringDeviceRootGUID(meterEol.getGuid());
                        String tguid = Utl.getRndUuid().toString();
                        value.setTguid(tguid);
                        value.setStatus(1); // статус - в процессе загрузки
                        if (ulistMng.getResType(meter.getUsl().getId()) == 1) {
                            // эл.энерг.
                            ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue elVal
                                    = new ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue();
                            ElectricMeteringValueImportType currElVal = new ElectricMeteringValueImportType();

                            // Дата снятия показания
                            currElVal.setDateValue(Utl.getXMLDate(value.getTs()));
                            currElVal.setMeteringValueT2(value.getN1().toString());
                            currElVal.setTransportGUID(tguid);

                            elVal.setCurrentValue(currElVal);
                            val.setElectricDeviceValue(elVal);
                        } else if (ulistMng.getResType(meter.getUsl().getId()) == 0) {
                            // г.в., х.в.
                            ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue oneRateVal =
                                    new ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue();
                            OneRateMeteringValueImportType currOneRateVal =
                                    new OneRateMeteringValueImportType();
                            currOneRateVal.setDateValue(Utl.getXMLDate(value.getTs()));

                            // показания по тарифам
                            currOneRateVal.setMeteringValue(value.getN1().toString());
                            // Получить ресурс по коду USL
                            NsiRef mres = ulistMng.getResourceByUsl(meter.getUsl().getId());

                            currOneRateVal.setMunicipalResource(mres);
                            currOneRateVal.setTransportGUID(tguid);
                            oneRateVal.getCurrentValue().add(currOneRateVal);
                            val.setOneRateDeviceValue(oneRateVal);
                        }
                        req.getMeteringDevicesValues().add(val);
                    }
                }
            }
        }

        AckRequest ack = null;
        try {
            ack = port.importMeteringDeviceValues(req);
        } catch (Fault e) {
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
        return err;

    }

    /**
     * Получить результат импорта показаний счетиков
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void importMeteringDeviceValuesAsk(Task task) {
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
            // ошибок не найдено
            for (CommonResultType t : retState.getImportResult()) {
                String tguid = t.getTransportGUID();
                // возможны проблемы потери показаний, если выполнялся переход и выгружались показания
                ObjPar value = objparDao.findByTguidAndMg(tguid, configApp.getPeriod());
                if (value==null) {
                    log.error("ОШИБКА! Невозможно найти показания по TGUID={}, mg={} в SCOTT.T_OBJXPAR!",
                            tguid, configApp.getPeriod());
                } else {
                    value.setStatus(2); // статус - загружено
                    value.setTguid(null);
                    // ошибки внутри выполненного задания
                    for (Error f : t.getError()) {
                        String errStr = String.format("Ошибка импорта показаний в ГИС ЖКХ: " +
                                        "TGUID=%s, Error code=%s, Description=%s",
                                tguid, f.getErrorCode(), f.getDescription());
                        value.setStatus(3); // перезаписать статус - ошибка
                        log.error(errStr);
                    }
                }
                reqProp.getFoundTask().setState("ACP");
            }

            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);
        }
    }
    /**
     * Экспортировать показания счетчиков по дому
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Boolean exportMeteringDeviceValues(Task task) throws DatatypeConfigurationException {
        taskMng.logTask(task, true, null);
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        AckRequest ack = null;
        // для обработки ошибок
        boolean err = false;
        String errMainStr = null;

        ExportMeteringDeviceHistoryRequest req = new ExportMeteringDeviceHistoryRequest();

        req.setId("foo");
        req.setVersion(req.getVersion() == null ? reqProp.getGisVersion() : req.getVersion());
        req.getFIASHouseGuid().add(reqProp.getHouseGuid());

        // индивидуальные приборы учета
        NsiRef tp = ulistMng.getNsiElem("NSI", 27, "Тип прибора учета", "Индивидуальный");
        req.getMeteringDeviceType().add(tp);

        // исключить архивные счетчики
        req.setSerchArchived(false);
        // исключать показания отправленные текущей организацией
        req.setExcludeCurrentOrgAsDataSource(true);

        // период, за которой получить показания
        // использовать период из биллинга
        req.setInputDateFrom(Utl.getXMLDate(configApp.getCurDt1()));
        req.setInputDateTo(Utl.getXMLDate(configApp.getCurDt2()));

        try {
            ack = port.exportMeteringDeviceHistory(req);
        } catch (Fault e) {
            e.printStackTrace();
            err = true;
            errMainStr = e.getFaultInfo().getErrorMessage();
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
     * Получить результат экспорта показаний счетиков
     *
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @CacheEvict(value = {"EolinkDAOImpl.getEolinkByGuid" }, allEntries = true) // здесь Evict потому что
    // пользователь может обновить Ko объекта счетчика мз Директа(осуществить привязку)
    // и тогда должен быть получен обновленный объект! ред.07.12.18
    public void exportMeteringDeviceValuesAsk(Task task) throws UnusableCode {
        taskMng.logTask(task, true, null);

        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

        // получить состояние запроса
        GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            // дом
            Eolink house = reqProp.getFoundTask().getEolink();
            // погасить по дому сообщение об ошибке
            soapConfig.saveError(house, CommonErrs.ERR_METER_NOT_FOUND_BY_GUID, false);
            // период выгрузки - получить из биллинга
            String period = configApp.getPeriod();
            Date dt1 = configApp.getCurDt1();
            Date dt2 = configApp.getCurDt2();

            // получить уже сохранённые в базу показания
            List<MeterData> mdLst = meterDao.findMeteringDataTsUsingUser("GIS", "ins_sch", period);
            for (ExportMeteringDeviceHistoryResultType t : retState.getExportMeteringDeviceHistoryResult()) {
                // найти счетчик по GUID
                Eolink meterEol = eolinkDao.getEolinkByGuid(t.getMeteringDeviceRootGUID());
                if (meterEol == null) {
                    // счетчик не найден, записать по дому сообщение об ошибке
                    soapConfig.saveError(house, CommonErrs.ERR_METER_NOT_FOUND_BY_GUID, true);
                    log.trace("При выгрузке показаний, счетчик с GUID={} НЕ НАЙДЕН, ожидается его экспорт из ГИС",
                            t.getMeteringDeviceRootGUID());
                } else {
                    if (meterEol.getKoObj()!=null) {
                        if (meterMng.getCanSaveDataMeter(meterEol, dt2)) {
                            // погасить ошибку неактуальности счетчика в Директ
                            soapConfig.saveError(meterEol, CommonErrs.ERR_METER_NOT_ACTUAL_DIRECT, false);
                            // погасить ошибку отсутствия связи со счетчиком в Директ
                            soapConfig.saveError(meterEol, CommonErrs.ERR_METER_NOT_ASSOC_DIRECT, false);
                            if (t.getOneRateDeviceValue() != null) {
                                for (OneRateCurrentMeteringValueExportType e :
                                        t.getOneRateDeviceValue().getValues().getCurrentValue()) {
                                    // проверить сохранены ли уже показания
                                    if (Utl.between(Utl.getDateFromXmlGregCal(e.getEnterIntoSystem()), dt1, dt2) &&
                                            !meterMng.getIsMeterDataExist(mdLst, t.getMeteringDeviceRootGUID(),
                                            e.getEnterIntoSystem()) && e.getMeteringValue() != null) {
                                        // показания еще не были сохранены, сохранить
                                        log.trace("Получены показания по OneRateDeviceValue: " +
                                                        "MeteringDeviceRootGUID={} DateValue={}, EnterIntoSystem={}, OrgPPAGUID={}, " +
                                                        "ReadingSource={}, val={}",
                                                t.getMeteringDeviceRootGUID(), e.getDateValue(),
                                                e.getEnterIntoSystem(), e.getOrgPPAGUID(), e.getReadingsSource(),
                                                e.getMeteringValue());
                                        // сохранить показание по счетчику в базу
                                        saveMeterData(meterEol, e.getMeteringValue(), e.getEnterIntoSystem(), period, 4);
                                    }
                                }
                            }
                            if (t.getElectricDeviceValue() != null) {
                                for (ElectricCurrentMeteringValueExportType e :
                                        t.getElectricDeviceValue().getValues().getCurrentValue()) {
                                    // проверить сохранены ли уже показания
                                    if (Utl.between(Utl.getDateFromXmlGregCal(e.getEnterIntoSystem()), dt1, dt2) &&
                                            !meterMng.getIsMeterDataExist(mdLst, t.getMeteringDeviceRootGUID(),
                                            e.getEnterIntoSystem()) && e.getMeteringValueT1() != null) {
                                        log.trace("показания по ElectricDeviceValue: GUID={} date={}, enter={}, val={}",
                                                t.getMeteringDeviceRootGUID(), e.getDateValue(), e.getEnterIntoSystem(),
                                                e.getMeteringValueT1());
                                        // сохранить показание по счетчику в базу
                                        saveMeterData(meterEol, e.getMeteringValueT1(), e.getEnterIntoSystem(), period, 4);
                                    }
                                }

                            }
                        } else {
                            soapConfig.saveError(meterEol, CommonErrs.ERR_METER_NOT_ACTUAL_DIRECT, true);
                            log.error("Счетчик Eolink.id={} не является актуальным или отключена связь в Директ ", meterEol.getId());
                        }
                    } else {
                        // Ko не заполнен (счетчик не привязан к Директ, для выгрузки)
                        soapConfig.saveError(meterEol, CommonErrs.ERR_METER_NOT_ASSOC_DIRECT, true);
                        log.error("Счетчик Eolink.id={} не привязан к соответствующему счетчику в Директ " +
                                "по Eolink.FK_KLSK_OBJ", meterEol.getId());
                    }

                }
            }
            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            log.info("******* ACP");
            taskMng.logTask(task, false, true);
        }
    }

    /**
     * Сохранение показания по счетчику в базу
     * @param meter - счетчик
     * @param num1 - показание
     * @param ts - timestamp
     * @param period - период для T_OBJXPAR
     * @param status - статус загрузки, например 4 - загружен от ГИС ЖКХ
     */
    private void saveMeterData(Eolink meter, String num1, XMLGregorianCalendar ts, String period, int status) throws UnusableCode {
        Date dt = Utl.truncDateToSeconds(Utl.getDateFromXmlGregCal(ts));
        log.trace("Попытка отправить показания в биллинг: " +
                        "scott.p_meter.ins_data_meter(p_met_klsk={}, p_n1={}, p_ts={}, p_period={})",
                meter.getKoObj().getId(), num1, dt, period);
        // погасить ошибку записи в биллинг
        soapConfig.saveError(meter, CommonErrs.ERROR_WHILE_SAVING_DATA, false);
        StoredProcedureQuery qr;
        qr = em.createStoredProcedureQuery("scott.p_meter.ins_data_meter");
        qr.registerStoredProcedureParameter(1, Long.class,
                ParameterMode.IN); // p_met_klsk
        qr.registerStoredProcedureParameter(2, Double.class,
                ParameterMode.IN); // p_n1
        qr.registerStoredProcedureParameter(3, Date.class,
                ParameterMode.IN); // p_ts
        qr.registerStoredProcedureParameter(4, String.class,
                ParameterMode.IN);
        qr.registerStoredProcedureParameter(5, Integer.class,
                ParameterMode.IN); // p_n1
        qr.registerStoredProcedureParameter(6, Integer.class,
                ParameterMode.OUT);
        qr.setParameter(1, meter.getKoObj().getId());
        qr.setParameter(2, Double.valueOf(num1));
        qr.setParameter(3, dt);
        qr.setParameter(4, period);
        qr.setParameter(5, status);
        qr.execute();
        Integer ret = (Integer) qr.getOutputParameterValue(6);
        log.trace("Результат исполнения scott.p_meter.ins_data_meter={}", ret);
        if (!ret.equals(0)) {
            soapConfig.saveError(meter, CommonErrs.ERROR_WHILE_SAVING_DATA, true);
        }
        if (ret.equals(1)) {
            log.error("ОШИБКА! Нулевые новые показания!");
        } else if (ret.equals(3)) {
            log.error("ОШИБКА! Новые показания меньше или равны существующим в базе!");
        } else if (ret.equals(4)) {
            log.error("ОШИБКА! Не найден счетчик!");
        } else if (ret.equals(5)) {
            log.error("ОШИБКА! Переданы показания, вызывающие начисление слишком большого объема!");
        } else {
            log.error("Отправлено в биллинг успешно!");
        }
    }

    /**
     * Проверить наличие заданий на выгрузку показаний по счетчикам, по домам
     * и если их нет, - создать
     *
     * @param task - задание
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void checkPeriodicTask(Task task) throws WrongParam {
        Task foundTask = em.find(Task.class, task.getId());
        // создать по всем домам задания, если их нет
        createTask("GIS_EXP_METER_VALS", "SYSTEM_RPT_MET_EXP_VAL", "STP", "Дом",
                "экспорт из ГИС показаний приборов учета");
        createTask("GIS_IMP_METER_VALS", "SYSTEM_RPT_MET_IMP_VAL", "STP", "Дом",
                "'импорт в ГИС показаний приборов учета");
        // Установить статус выполнения задания
        foundTask.setState("ACP");
    }

    private void createTask(String actTp, String parentCD, String state, String eolTp, String purpose) {
        int a;// создавать по 100 штук, иначе -блокировка Task (нужен коммит)
        a = 1;
        for (Eolink e : eolinkDao.getEolinkByTpWoTaskTp(eolTp, actTp, parentCD)) {
            // статус - STP, остановлено (будет запускаться другим заданием)
            ptb.setUp(e, null, actTp, state, soapConfig.getCurUser().getId());
            // добавить как зависимое задание к системному повторяемому заданию
            ptb.addAsChild(parentCD);
            ptb.save();
            log.info("Добавлено задание на {}, по объекту {}, Eolink.id={}", purpose, eolTp, e.getId());
            a++;
            if (a++ >= 100) {
                break;
            }
        }
    }


}
