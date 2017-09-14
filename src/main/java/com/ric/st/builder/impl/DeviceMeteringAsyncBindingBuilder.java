package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Config;
import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.dao.UserDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.RetStateMeter;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import oracle.net.aso.f;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ExportMeteringDeviceHistoryResultType;
import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringPortTypesAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringServiceAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@Slf4j
@Service
public class DeviceMeteringAsyncBindingBuilder implements DeviceMeteringAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private TaskParMng taskParMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private TaskEolinkParMng teParMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private SoapConfigs soapConfig;
	@Autowired
	private ParDAO parDao;
	
	private DeviceMeteringServiceAsync service;
	private DeviceMeteringPortTypesAsync port;
	private SoapBuilder sb;
	
	/**
	 * Инициализация - создать сервис и порт
	 * @throws CantSendSoap 
	 */
	public void setUp() throws CantSendSoap {
		service = new DeviceMeteringServiceAsync();
    	port = service.getDeviceMeteringPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов
    	sb.setTrace(false);
	}

	/**
	 * Старый вызов получения статуса запроса - TODO: Удалить!
	 * @param ack
	 * @return
	 */
	public RetStateMeter getState(AckRequest ack) {
		Boolean err = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID( ack.getAck().getMessageGUID() );
		sb.setSign(false); // не подписывать запрос состояния!
		
		int i = 2;
		int timeout = 0;
		while (!err && (state == null || state.getRequestState() != 3)){
			sb.makeRndMsgGuid();
			try {
				state = port.getState(gs);
			} catch (Fault e) {
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
				err=true;
				errStr = "Превышено время выполнения запроса!";
			} else {
				log.info("Статус запроса={}", state.getRequestState());
			}
		}
		
		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
		} if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Прочие ошибки
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
		}
		
		return new RetStateMeter(state, err, errStr);

	}
	

	/**
	 * Получить состояние запроса
	 * @param msgGuid - GUID запроса
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED) // TODO поставил транзакц.
	public GetStateResult getState2(Task task) {
		
		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		
		int i = 2;
		int timeout = 0;
		while (!err && (state == null || state.getRequestState() != 3)){
			sb.makeRndMsgGuid();
			try {
				state = port.getState(gs);
			} catch (Fault e) {
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
				err=true;
				errStr = "Превышено время выполнения запроса!";
			} else {
				log.info("Статус запроса={}", state.getRequestState());
			}
		}
		
		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
		} if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else {
			
			for (CommonResultType e : state.getImportResult()) {
					for (Error f: e.getError()) {	
						// Найти элемент задания по Транспортному GUID
						Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
						// Установить статусы ошибки по заданиям
						task2.setState("ERR");
						task2.setResult(f.getDescription());
						log.error("Description={}", f.getDescription());
						errChld = true;
					};
			}
		}
		
		if (!err) {
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
	 * Импортировать показания счетчиков
	 * 
	 * @param task - задание (если есть)
	 * @throws WrongGetMethod 
	 * @throws DatatypeConfigurationException 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importMeteringDeviceValues(Task task) throws WrongGetMethod, DatatypeConfigurationException {
		// Установить параметры SOAP
		reqProp.setVal(task, sb);
		// Трассировка XML
		//sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ImportMeteringDeviceValuesRequest req = new ImportMeteringDeviceValuesRequest(); 

		req.setId("foo");
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(reqProp.getHouseGuid());

		List<Task> lstTask = taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "СчетчикФизический", null).stream()
				.filter(t-> t.getAct().getCd().equals("GIS_ADD_METER_VAL")).collect(Collectors.toList());
		for (Task t: lstTask) {
			// Транспортный GUID
			String tguid = Utl.getRndUuid().toString();
	    	t.setTguid(tguid);

			// счетчик физический (корневой)
			Eolink meter = t.getEolink();
			Eolink meterVers = meter.getChild().stream().filter(d -> 
				d.getObjTp().getCd().equals("СчетчикВерсия")).findFirst().orElse(null);

			Date dtGet = taskParMng.getDate(t, "Счетчик.ДатаСнятияПоказания");
			log.info("DATE={}", dtGet);
			MeteringDevicesValues val = new MeteringDevicesValues();
			val.setMeteringDeviceRootGUID(meter.getGuid());
			//val.setMeteringDeviceVersionGUID(meterVers.getGuid());
			
			if (ulistMng.getResType(meter.getUsl()) == 1) {
				ElectricDeviceValue elVal = new ElectricDeviceValue();
				CurrentValue currElVal = new CurrentValue();
				
				// Дата снятия показания
				currElVal.setDateValue(Utl.getXMLDate(dtGet));
				
				// показания по тарифам
				Double metVal = taskParMng.getDbl(t, "Счетчик.БазПоказ(Т1)");
				currElVal.setMeteringValueT1(BigDecimal.valueOf(metVal));
				metVal = taskParMng.getDbl(t, "СчетчиБазПоказ((Т2)");
				if (metVal != null) {
					currElVal.setMeteringValueT2(BigDecimal.valueOf(metVal));
				}
				metVal = taskParMng.getDbl(t, "Счетчик.БазПоказ(Т3)");
				if (metVal != null) {
					currElVal.setMeteringValueT3(BigDecimal.valueOf(metVal));
				}

				currElVal.setTransportGUID(tguid);
				elVal.getCurrentValue().add(currElVal);
				// эл.энерг.
				val.setElectricDeviceValue(elVal );
			} else if (ulistMng.getResType(meter.getUsl()) == 0) {
				OneRateDeviceValue oneRateVal = new OneRateDeviceValue();
				ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue currOneRateVal = 
						new ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue();
				currOneRateVal.setDateValue(Utl.getXMLDate(dtGet));

				// показания по тарифам
				Double metVal = taskParMng.getDbl(t, "Счетчик.БазПоказ(Т1)");
				currOneRateVal.setMeteringValue(BigDecimal.valueOf(metVal));
				
				// Получить ресурс по коду USL
				NsiRef mres = ulistMng.getResourceByUsl(meter.getUsl());

				currOneRateVal.setMunicipalResource(mres);
				currOneRateVal.setTransportGUID(tguid);
				oneRateVal.getCurrentValue().add(currOneRateVal);
				// г.в., х.в.
				val.setOneRateDeviceValue(oneRateVal );
			}
			req.getMeteringDevicesValues().add(val);
		}		
		try {
			ack = port.importMeteringDeviceValues(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}
    	
		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;

	}
	
	/**
	 * Получить результат импорта показаний счетиков
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importMeteringDeviceValuesAsk(Task task) {
		// Установить параметры SOAP
		reqProp.setVal(task, sb);	
		
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getImportResult().stream().forEach(t -> {
				log.info("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:", 
						reqProp.getFoundTask().getId(), t.getTransportGUID());
				log.info("UniqueNumber={}, Дата обновления={}", t.getUniqueNumber(), Utl.getDateFromXmlGregCal(t.getUpdateDate()));
				// Найти элемент задания по Транспортному GUID
				Task task2 = taskMng.getByTguid(reqProp.getFoundTask(), t.getTransportGUID());
				// Переписать значения параметров в eolink из task
				teParMng.acceptPar(task2);
				task2.setState("ACP");
				
			});
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			
		}
	}

	/**
	 * Экспортировать показания счетчиков по дому
	 * 
	 * @param task - задание (если есть)
	 * @throws CantPrepSoap 
	 * @throws WrongGetMethod 
	 * @throws DatatypeConfigurationException 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
		// Установить параметры SOAP
		reqProp.setVal(task, sb);	
		// Трассировка XML
		//sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportMeteringDeviceHistoryRequest req = new ExportMeteringDeviceHistoryRequest(); 

		req.setId("foo");
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(reqProp.getHouseGuid());
		
		// опции проверки
		Boolean checkOneOpt=false; 
		Boolean checkTwoOpt=false; 
		// Добавить параметры фильтрации показаний
		for (TaskPar p :task.getTaskPar()) {
			
			// Фильтр - Тип - виды приборов учета
			if (p.getPar().getCd().equals("Счетчик.Тип")) {
				checkOneOpt=true;
				log.info("Тип прибора учета1={}", p.getS1());
				NsiRef tp = ulistMng.getNsiElem("NSI", 27, "Тип прибора учета", p.getS1());
				req.getMeteringDeviceType().add(tp);
			}
			// Фильтр - Вид коммунального ресурса
			if (p.getPar().getCd().equals("Счетчик.ВидКоммунРесурса")) {
				if (checkOneOpt) {
					throw new CantPrepSoap("Некорректное количество критериев запроса!");
				}
				checkTwoOpt=true;
				log.info("Вид коммун ресурса1={}", p.getS1());
				NsiRef tp = ulistMng.getNsiElem("NSI", 2, "Вид коммунального ресурса", p.getS1());
				log.info("Вид коммун ресурса2={}", tp.getName());
				req.getMunicipalResource().add(tp);
			}
		}
		
		// Фильтр - приборы учета по RootGuid, кроме дочерних временных заданий
		for (Task t: task.getChild().stream().filter(t-> t.getAct().getCd().equals("GIS_EXP_METER_VAL"))
				.collect(Collectors.toList())) {
			if (checkOneOpt || checkTwoOpt) {
				throw new CantPrepSoap("Некорректное количество критериев запроса!");
			}
			req.getMeteringDeviceRootGUID().add(t.getEolink().getGuid());
		}
		
		// Искать ли архивные
		req.setSerchArchived(false);
		// Отключить показания отправленные информационной системой
		req.setExcludeISValues(false);
		req.setInputDateFrom(Utl.getXMLDate(taskParMng.getDate(task, "Счетчик.ДатаСнятияПоказания")));
		
		try {
			ack = port.exportMeteringDeviceHistory(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}
    	
		if (err) {
			reqProp.getFoundTask().setState("ERR");
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
		
	}	
	
	/**
	 * Получить результат экспорта показаний счетиков
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportMeteringDeviceValuesAsk(Task task) {
		// Установить параметры SOAP
		reqProp.setVal(task, sb);	
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());
		// пользователь
		Integer userId = soapConfig.getCurUser().getId();
		Lst actVal = lstMng.getByCD("GIS_TMP");
		Lst actTask = lstMng.getByCD("GIS_EXP_METERS");

		if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getExportMeteringDeviceHistoryResult().stream().forEach(d -> {
				ExportMeteringDeviceHistoryResultType t = d;
				// найти счетчик по GUID 
				Eolink meter = eolinkMng.getEolinkByGuid(t.getMeteringDeviceRootGUID());
				if (meter == null) {
					// счетчик не найден, создать задание на его выгрузку из ГИС (в нём же выгрузятся показания)
					log.info("При выгрузке показаний, счетчик с GUID={} НЕ НАЙДЕН, попытка разместить задание, для его экспорта из ГИС", 
							t.getMeteringDeviceRootGUID()); 
					Task taskParent = new Task(reqProp.getFoundTask().getEolink(), null, null, "INS", actTask,
							t.getMeteringDeviceRootGUID(), null, null, null, null, null, 0, userId);
					em.persist(taskParent);
				} else {
					// счетчик найден, выгрузить по нему последние показания
					if (t.getOneRateDeviceValue() != null) {
						t.getOneRateDeviceValue().getValues().getCurrentValue().forEach(e -> {
							ru.gosuslugi.dom.schema.integration.device_metering.ExportOneRateMeteringValueKindType.CurrentValue f = e;
							// записать объем по счетчику в EOLINK
							setVol(task, meter, userId, actVal, t.getMeteringDeviceRootGUID(), e.getMeteringValue(), 
									Utl.getDateFromXmlGregCal(e.getDateValue()));
						});
					}
					if (t.getElectricDeviceValue() != null) {
						t.getElectricDeviceValue().getValues().getCurrentValue().forEach(e -> {
							ru.gosuslugi.dom.schema.integration.device_metering.ExportElectricMeteringValueKindType.CurrentValue f = e;

							// записать объем по счетчику в EOLINK
							setVol(task, meter, userId, actVal, t.getMeteringDeviceRootGUID(), e.getMeteringValueT1(), 
									Utl.getDateFromXmlGregCal(e.getDateValue()));
						});
						
					}
					
				}
				});
			}
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

	}
	
	/**
	 * Записать объем по счетчику в EOLINK
	 * @param task - текущее задание
	 * @param meter - счетчик
	 * @param userId - Id пользователя
	 * @param actVal - тип задания
	 * @param rootGUID - Root GUID счетчика
	 * @param vol - объем
	 * @param dt1 - дата внесения
	 */
	private void setVol(Task task, Eolink meter, Integer userId, Lst actVal, String rootGUID,
			BigDecimal vol, Date dt1) {
		// дочернее псевдозадание, хранящее принятые показания по счетчику
		Task taskChild = new Task(meter, task, null, null, actVal,
				null, null, null, null, null, null, 0, userId);
		log.info("Попытка по счетчику rootGUID={}, принять следующие показания:T1={}, дата={}", 
				rootGUID, vol, dt1);   
		Par par = parDao.getByCd(-1, "Счетчик.БазПоказ(Т1)");
		TaskPar taskPar = new TaskPar(taskChild, par, vol.doubleValue(), null, null);
		taskChild.getTaskPar().add(taskPar);
		em.persist(taskChild);
		// переписать показания в объект Eolink
		teParMng.acceptPar(taskChild);
	}
	

}
