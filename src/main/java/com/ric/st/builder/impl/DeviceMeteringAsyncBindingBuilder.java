package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.ElectricDeviceValue.CurrentValue;
import ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringPortTypesAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.DeviceMeteringServiceAsync;
import ru.gosuslugi.dom.schema.integration.device_metering_service_async.Fault;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import com.diffplug.common.base.Errors;
import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.EolinkToEolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.bs.AddrTp;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.EolinkToEolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.st.impl.TaskController;
import com.ric.bill.mm.TaskMng;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

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
	private SoapConfig config;
	@Autowired
	private TaskController aControl;
	@Autowired
	private TaskParMng taskParMng;
	@Autowired
	private EolinkParMng eolinkParMng;
	@Autowired
	private TaskEolinkParMng teParMng;
	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private EolinkToEolinkDAO eolinkToEolinkDao;
	
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
	 * Получить состояние запроса
	 * @param msgGuid - GUID запроса
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED) // TODO поставил транзакц.
	private GetStateResult getState2(Task task) {
		
		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		GetStateResult state = null;

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
				};
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
	
/*	@Transactional(readOnly = false, propagation = Propagation.REQUIRED) // TODO поставил транзакц.
	private void getState3(Task task) {
		task.setState("ERS");
		task.setResult("ERRRRRRRRRR");

	}*/
	
	/**
	 * Экспортировать данные счетчиков
	 * 
	 * @param task - задание (если есть)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importMeteringDeviceValues(Task task) {
		Task foundTask = null;
		String houseGuid = null;
		String ppGuid = null;
		foundTask = em.find(Task.class, task.getId());
		String reu = task.getEolink().getReu();
		houseGuid = task.getEolink().getGuid();

		// Установить PPGUID
		ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
		
		AckRequest ack = null;

		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ImportMeteringDeviceValuesRequest req = new ImportMeteringDeviceValuesRequest(); 

		req.setId("foo");
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(houseGuid);
		
		Eolink meter = foundTask.getEolink();
		MeteringDevicesValues val = new MeteringDevicesValues();
		if (meter.getUsl().equals("024")) {
			ElectricDeviceValue elVal = new ElectricDeviceValue();
			CurrentValue currElVal = new CurrentValue();
			currElVal.setDateValue(value);
			currElVal.setMeteringValueT1(value);
			currElVal.setTransportGUID(tguid);
			elVal.getCurrentValue().add(currElVal);
			// эл.энерг.
			val.setElectricDeviceValue(elVal );
		} else if (meter.getUsl().equals("011") || meter.getUsl().equals("015")) {
			OneRateDeviceValue oneRateVal = new OneRateDeviceValue();
			ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue currOneRateVal = 
					new ru.gosuslugi.dom.schema.integration.device_metering.ImportMeteringDeviceValuesRequest.MeteringDevicesValues.OneRateDeviceValue.CurrentValue();
			currOneRateVal.setDateValue(value);
			currOneRateVal.setMeteringValue(value);
			currOneRateVal.setMunicipalResource(value);
			currOneRateVal.setTransportGUID(value);
			oneRateVal.getCurrentValue().add(currOneRateVal);
			// г.в., х.в.
			val.setOneRateDeviceValue(oneRateVal );
			
			
		}
		
		req.getMeteringDevicesValues().add(val);
		
		try {
			ack = port.importMeteringDeviceValues(req);
		} catch (Fault e) {
			e.printStackTrace();
			err = true;
			errMainStr = e.getFaultInfo().getErrorMessage();
		}
    	
		if (err) {
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			foundTask.setState("ACK");
			foundTask.setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;

	}
	
	
	
}
