package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.diffplug.common.base.Errors;
import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.EolinkToEolinkDAO;
import com.ric.bill.dao.KartHpDAO;
import com.ric.bill.dao.ParDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.EolinkToEolinkMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.bs.AddrTp;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.TaskControllers;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.RetStateHouse;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.AccountIndType;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.Accommodation;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.PayerInfo;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ClosedAccountAttributesType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountResultType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChAsyncRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChRequestCriteriaType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.Entrance;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataResultType;
import ru.gosuslugi.dom.schema.integration.house_management.GetStateResult;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicExportType;
import ru.gosuslugi.dom.schema.integration.house_management.HouseBasicUpdateUOType;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportAccountRequest.Account;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ApartmentHouseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.EntranceToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.NonResidentialPremiseToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.NonResidentialPremiseToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToCreate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportHouseUORequest.ApartmentHouse.ResidentialPremises.ResidentialPremisesToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate;
import ru.gosuslugi.dom.schema.integration.house_management.ImportMeteringDeviceDataRequest.MeteringDevice.DeviceDataToUpdate.ArchiveDevice;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.NonResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceBasicCharacteristicsType.ResidentialPremiseDevice;
import ru.gosuslugi.dom.schema.integration.house_management.MeteringDeviceFullInformationType;
import ru.gosuslugi.dom.schema.integration.house_management.MunicipalResourceElectricType;
import ru.gosuslugi.dom.schema.integration.house_management.MunicipalResourceNotElectricType;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@Slf4j
@Service
public class HouseManagementAsyncBindingBuilder implements HouseManagementAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private SoapConfig config;
	@Autowired
	private TaskParMng taskParMng;
	@Autowired
	private EolinkDAO eolinkDao; 
	@Autowired
	private EolinkParMng eolinkParMng;
	@Autowired
	private TaskEolinkParMng teParMng;
	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private EolinkMng eolinkMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private EolinkToEolinkDAO eolinkToEolinkDao;
	@Autowired
	private EolinkToEolinkMng eolToEolMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private SoapConfigs soapConfig;
	@Autowired
	private ParDAO parDao;
	@Autowired
	TaskControllers taskCtrl;
	@Autowired
	private PseudoTaskBuilders ptb; 
	
	private HouseManagementServiceAsync service;
	private HouseManagementPortsTypeAsync port;
	private SoapBuilder sb;
	
	/**
	 * Инициализация - создать сервис и порт
	 * @throws CantSendSoap 
	 */
	public void setUp() throws CantSendSoap {
		service = new HouseManagementServiceAsync();
    	port = service.getHouseManagementPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов, по умолчанию
    	sb.setTrace(false);
	}


	/**
	 * Старый вызов получения статуса запроса - TODO: Удалить!
	 * @param ack
	 * @return
	 */
	public RetStateHouse getState(AckRequest ack) {
		Boolean err = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID( ack.getAck().getMessageGUID() );
		sb.setSign(false); // не подписывать запрос состояния!
		
		int i = 2;
		int timeout = 0;
		while (!err && (state == null || state.getRequestState() != 3)){
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
		} else if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Прочие ошибки
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
		}
		
		return new RetStateHouse(state, err, errStr);

	}
	

	/**
	 * Получить состояние запроса
	 * @param msgGuid - GUID запроса
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public GetStateResult getState2(Task task) {
		
		//sb.setTrace(true);

		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
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
			return null;
		}		
		
		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else {
//			if (state != null) {
				for (ImportResult t : state.getImportResult()) {
					for (CommonResult e : t.getCommonResult()) {
						for (Error f: e.getError()) {	
							// Найти элемент задания по Транспортному GUID
							Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
							//if (task2.getAct().getCd().equals("GIS_ARCH_METER")
							//	|| task2.getAct().getCd().equals("GIS_ADD_METER")) {
								// Если задание было - архивация счетчика, и пришёл ответ, что счетчик уже архивирован,
								// не считать это ошибкой 
							//	log.info("Ошибка, Error code={}, Description={}", f.getErrorCode(), f.getDescription());
							//} else {
								// Прочие задания
								// установить статусы ошибки по заданиям
								task2.setState("ERR");
								errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
								task2.setResult(errStr);
								log.error(errStr);
								errChld = true;
							//}
						};
					};
				}
			//}
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
	 * Экспортировать данные счетчиков
	 * 
	 * @param task - задание (если есть)
	 * @throws CantPrepSoap 
	 * @throws WrongGetMethod 
	 * @throws DatatypeConfigurationException 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException {
		log.info("******* Task.id={}, экспорт приборов учета, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		AckRequest ack = null;

		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportMeteringDeviceDataRequest req = new ExportMeteringDeviceDataRequest(); 

		req.setId("foo");
		//sb.setSign(true);
		req.setVersion(req.getVersion());
		if (task.getGuid() != null){
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;

	}
	
	
	/**
	 * Получить результат экспорта счетчиков
	 * @throws ErrorProcessAnswer 
	 * @throws CantPrepSoap 
	 * @throws WrongGetMethod 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportDeviceDataAck(Task task) throws ErrorProcessAnswer, CantPrepSoap, WrongGetMethod {
		log.info("******* Task.id={}, экспорт приборов учета, запрос ответа", task.getId());
		// тип помещения 0 - жилое, 1 - не жилое
		Integer premiseTp = null;
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		Eolink houseEol = reqProp.getFoundTask().getEolink();
		
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			// пользователь
			Integer userId = soapConfig.getCurUser().getId();
			Lst actParent = lstMng.getByCD("GIS_EXP_METER_VALS");
			Lst actChild = lstMng.getByCD("GIS_EXP_METER_VAL");
			// Ошибок не найдено
			for (ExportMeteringDeviceDataResultType d : retState.getExportMeteringDeviceDataResult()) {
				ExportMeteringDeviceDataResultType t = d;

				log.info("Получен счетчик:");
				log.info("Root GUID={}", t.getMeteringDeviceRootGUID());
				log.info("Version GUID={}", t.getMeteringDeviceVersionGUID());
				log.info("GISGKHNumber={}", t.getMeteringDeviceGISGKHNumber());
				log.info("Серийный номер={}", t.getBasicChatacteristicts().getMeteringDeviceNumber());
				
				String premiseGUID = null;
				if (t.getBasicChatacteristicts().getResidentialPremiseDevice() != null) {
					// Счетчик жилого помещения
					// получить GUID помещения
					premiseTp = 0;
					premiseGUID = t.getBasicChatacteristicts().getResidentialPremiseDevice().getPremiseGUID();
					log.info("Тип помещения, к которому привязан счетчик - ЖИЛОЕ, GUID={}", premiseGUID);
				} else if (t.getBasicChatacteristicts().getNonResidentialPremiseDevice() != null) {
					// Счетчик не жилого помещения
					// получить GUID помещения
					log.info("Тип помещения, к которому привязан счетчик - НЕ ЖИЛОЕ, GUID={}", premiseGUID);
					premiseGUID = t.getBasicChatacteristicts().getNonResidentialPremiseDevice().getPremiseGUID();
					premiseTp = 1;
					
				} else {
					// Прочие типы не обрабатывать
					log.error("Получен не обрабатываемый тип счетчика: Счетчик: Root GUID=", t.getMeteringDeviceRootGUID());
					//throw new ErrorProcessAnswer("Получен не обрабатываемый тип счетчика: Счетчик: Root GUID="+ t.getMeteringDeviceRootGUID());
					continue;
				}
				
				// Получить список лс, к которым привязан счетчик
				List<String> guidLst = null; 
				if (premiseTp == 0) {
					guidLst = t.getBasicChatacteristicts().getResidentialPremiseDevice()
							.getAccountGUID().stream().collect(Collectors.toList());
				} else if (premiseTp == 1) {
					guidLst = t.getBasicChatacteristicts().getNonResidentialPremiseDevice()
							.getAccountGUID().stream().collect(Collectors.toList());
				}
				
				//Integer ex;
				//kartHpDao.findOne(ex);
				
				// найти корневую запись счетчика
				Eolink rootEol = eolinkMng.getEolinkByGuid(t.getMeteringDeviceRootGUID()); 
				// найти версию счетчика, по GUID
				Eolink versionEol = eolinkMng.getEolinkByGuid(t.getMeteringDeviceVersionGUID());
				// найти помещение, к которому прикреплен счетчик
				Eolink premiseEol = eolinkMng.getEolinkByGuid(premiseGUID);

				List<MunicipalResourceNotElectricType> munResNenerg
					= t.getMunicipalResourceNotEnergy();
				MunicipalResourceElectricType munResEl
					= t.getMunicipalResourceEnergy();
				String usl = null;
				
				if (rootEol != null) {
					log.info("Счетчик с GUID={} уже находится в базе, обновление параметров", t.getMeteringDeviceRootGUID());
					// найдено, обновить параметры счетчика TODO
					if (Utl.nvl(rootEol.getStatus(),0) == 1 && t.getStatusRootDoc().equals("Archival")) {
						// счетчик активный, отметить архивным
						rootEol.setStatus(0);
						log.info("Попытка отметить счетчик АРХИВНЫМ");
					} else if (Utl.nvl(rootEol.getStatus(),0) != 1 && t.getStatusRootDoc().equals("Active")) {
						// счетчик архивный, отметить активным
						rootEol.setStatus(1);
						log.info("Попытка отметить счетчик АКТИВНЫМ");
					}
					
					// Проверить, заполнить usl
					if (rootEol.getUsl() == null) {
						if (munResNenerg.size() > 0) {
							// Коммунальные услуги, получить первый попавшийся код усл TODO
							// может в Отоплении будут другие коды услуг!
							for (MunicipalResourceNotElectricType m: munResNenerg) {
								usl = ulistMng.getUslByResource(m.getMunicipalResource());
								//log.info("Check={}, {}", m.getMunicipalResource().getGUID(), m.getMunicipalResource().getName());
								break;
							}
						} else if (munResEl != null) {
							// Электроэнергия
							usl = "024";
						}
						rootEol.setUsl(usl);
						log.info("Попытка отметить счетчик кодом услуги usl={}", usl);
						
					}
				} else if (rootEol == null) {
					// не найдено, создать новую корневую запись счетчика
					AddrTp addrTp = lstMng.getAddrTpByCD("СчетчикФизический");
					
					if (munResNenerg.size() > 0) {
						// Коммунальные услуги, получить первый попавшийся код усл TODO
						// может в Отоплении будут другие коды услуг!
						for (MunicipalResourceNotElectricType m: munResNenerg) {
							usl = ulistMng.getUslByResource(m.getMunicipalResource());
							break;
						}
					} else if (munResEl != null) {
						// Электроэнергия
						usl = "024";
					}
					
					rootEol = new Eolink(houseEol.getReu(), houseEol.getKul(), houseEol.getNd(), premiseEol.getKw(), null,
							null, usl, null, t.getMeteringDeviceRootGUID(), t.getMeteringDeviceGISGKHNumber(), null , addrTp, 
							reqProp.getFoundTask().getAppTp(), null, null, premiseEol, config.getCurUser(), 1);

					log.info("Попытка создать запись корневого счетчика в Eolink: GUID={}", t.getMeteringDeviceRootGUID());
					em.persist(rootEol);
					//bc.setMeteringDeviceNumber(teParMng.getStr(t, "Счетчик.НомерПУ"));
					if (t.getStatusRootDoc().equals("Archival")) {
						// счетчик активный, отметить архивным
						rootEol.setStatus(0);
						log.info("Попытка отметить счетчик АРХИВНЫМ");
					} else if (t.getStatusRootDoc().equals("Active")) {
						// счетчик архивный, отметить активным
						rootEol.setStatus(1);
						log.info("Попытка отметить счетчик АКТИВНЫМ");
					}
					
					
					if (t.getStatusRootDoc().equals("Active")) {
						// Создать задание на выгрузку показаний по созданному счетчику, если он активен
						Task taskParent = new Task(reqProp.getFoundTask().getEolink(), null, null, "INS", actParent,
								null, null, null, null, null, null, 0, userId);
						Task taskChild = new Task(rootEol, null, null, "INS", actChild,
								null, null, null, null, null, null, 0, userId);
						
						// Установить дату снятия показаний - с самого начала месяца
						Par par = parDao.getByCd(-1, "Счетчик.ДатаСнятияПоказания");
						
						TaskPar taskPar = new TaskPar(taskParent, par, null, null, taskCtrl.getReqConfig().getCurDt1());
						taskParent.getTaskPar().add(taskPar);

						taskParent.getChild().add(taskChild);
						em.persist(taskParent);
					}
				}
				
				// Привязать счетчик к лиц.счетам
				for (String lskGUID: guidLst) {
					Eolink lskEol = eolinkMng.getEolinkByGuid(lskGUID);
					eolToEolMng.saveParentChild(lskEol, rootEol, "Логическая связь");
				}

				// Параметры счетчика
				eolinkParMng.setStr(rootEol, "Счетчик.НомерПУ", t.getBasicChatacteristicts().getMeteringDeviceNumber()); 
				eolinkParMng.setStr(rootEol, "Счетчик.Модель", t.getBasicChatacteristicts().getMeteringDeviceModel()); 
				eolinkParMng.setStr(rootEol, "ПУ.Марка", t.getBasicChatacteristicts().getMeteringDeviceStamp()); 
				eolinkParMng.setDate(rootEol, "Счетчик.ДатаВводаЭкс", 
						Utl.getDateFromXmlGregCal(t.getBasicChatacteristicts().getCommissioningDate())); 
				
				if (versionEol == null) {
					// не найдена версия счетчика, создать
					AddrTp addrTp = lstMng.getAddrTpByCD("СчетчикВерсия");
					versionEol = new Eolink(houseEol.getReu(), houseEol.getKul(), houseEol.getNd(), premiseEol.getKw(), null,
							null, null, null, t.getMeteringDeviceVersionGUID(), null, null , addrTp, 
							reqProp.getFoundTask().getAppTp(), null, null, rootEol, config.getCurUser(),1);
					// пометить прочие записи неактивными
					eolinkMng.setChildActive(rootEol, "СчетчикВерсия", 0);
					log.info("Попытка создать запись версии счетчика в Eolink: GUID={}", t.getMeteringDeviceVersionGUID());
					em.persist(versionEol);
				}
				

			} 			
			reqProp.getFoundTask().setState("ACP");
		}
	}
	
	/**
	 * Экспортировать договора управления по дому
	 * @param task - задание (если есть)
     * @param reu - REU из Квартплаты
     * @param kul - KUL из Квартплаты
     * @param nd -  ND из Квартплаты
	 * @return 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportContract(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, экспорт договора управления, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);

		String houseGuid = reqProp.getFoundTask().getEolink().getGuid();
		
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportCAChAsyncRequest req = new ExportCAChAsyncRequest(); 
		AckRequest ack = null;
		req.setId("foo");
		sb.setSign(true);
		req.setVersion(req.getVersion());
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else if (retState.getErr()) {
				err = true;
				String errStr = retState.getErrStr();
				reqProp.getFoundTask().setState("ERR");
				reqProp.getFoundTask().setResult("Вложенная ошибка XML: "+errStr);
		} else {
			// Ошибок нет, обработка
			Task foundTask2 = reqProp.getFoundTask();
			try {
				retState.getState().getExportCAChResult().stream().forEach(Errors.rethrow().wrap(t-> {
					String contractGUID = null;
					if (t.getContract()!=null) {
						// Договор управления
						contractGUID = t.getContract().getContractGUID();
					} else if (t.getCharter()!=null) {
						// Устав ТСЖ
						contractGUID = t.getCharter().getCharterGUID();
					}
					Eolink contrEol = eolinkMng.getEolinkByGuid(contractGUID); 
					if (contrEol == null) {
						// Документ не существует в базе, - создать
						AddrTp addrTp = lstMng.getAddrTpByCD("Документ");
						Lst objTpx = null;
						if (t.getContract()!=null) {
							// Договор управления
							objTpx = lstMng.getByCD("Договор управления");
						} else if (t.getCharter()!=null) {
							// Устав ТСЖ
							objTpx = lstMng.getByCD("Устав");
						}
						contrEol = new Eolink(contractGUID, null, null, addrTp, foundTask2.getAppTp(), objTpx, null, config.getCurUser());
						// установить Parent_id ведущий к дому
						contrEol.setParent(task.getEolink());
						em.persist(contrEol);
						log.info("Создан договор управления или устав! guid={}", contractGUID);
					} else {
						log.info("Договор управления или устав существует, обновление параметров! guid={}", contractGUID);
					}
					// сохранить параметры
					if (t.getContract()!=null) {
						// установить Parent_id ведущий к дому
						contrEol.setParent(task.getEolink());
						// Договор управления
						eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Дата подписания", 
								Utl.getDateFromXmlGregCal(t.getContract().getSigningDate() ));
						eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Планируемая дата завершения", 
								Utl.getDateFromXmlGregCal(t.getContract().getPlanDateComptetion()));
						eolinkParMng.setStr(contrEol, "ГИС ЖКХ.GUID Версии документа", 
								t.getContract().getContractVersionGUID());
					} else if (t.getCharter()!=null) {
						// установить Parent_id ведущий к дому
						contrEol.setParent(task.getEolink());
						// Устав
						eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Дата регистрации", 
								Utl.getDateFromXmlGregCal(t.getCharter().getDate() ));
					} else {
						// Не найдено ни то ни другое
					}
					}));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
		}
		return err;
	}
	
	/**
	 * Экспортировать данные дома
	 * @param task - задание (если есть)
     * @param reu - REU из Квартплаты
     * @param kul - KUL из Квартплаты
     * @param nd -  ND из Квартплаты
	 * @return 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportHouseData(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, экспорт объектов дома, вызов", task.getId());
		// Установить параметры SOAP
		sb.setTrace(true);

		reqProp.setProp(task, sb);
		Eolink houseEol = reqProp.getFoundTask().getEolink();
		String houseGuid = houseEol.getGuid();

		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportHouseRequest req = new ExportHouseRequest(); 
		req.setId("foo");
		sb.setSign(true);
		req.setVersion(req.getVersion());
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		
		return err;
	}

	
	/**
	 * Получить результат экспорта объектов дома
	 * @throws WrongGetMethod 
	 * @throws CantPrepSoap 
	 * @throws WrongParam 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportHouseDataAck(Task task) throws WrongGetMethod, CantPrepSoap, WrongParam {
		log.info("******* Task.id={}, экспорт объектов дома, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		Eolink houseEol = reqProp.getFoundTask().getEolink();
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());
		Date curDate = new Date();
		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {
			// Ошибок нет, обработка
			Task foundTask2 = reqProp.getFoundTask(); 
			// Сохранить уникальный номер дома
			houseEol.setUn(retState.getExportHouseResult().getHouseUniqueNumber());
			
			ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse ah = 
					retState.getExportHouseResult().getApartmentHouse();

			if (ah != null) {
				// Многоквартирный дом
				HouseBasicExportType bc = ah.getBasicCharacteristicts();
				
				ptb.setUp(houseEol, task, "GIS_TMP", null);
				Date dtModify = Utl.getDateFromXmlGregCal(retState.getExportHouseResult().getModificationDate());
				// нет связи с кадастром
				ptb.addTaskPar("ГИС ЖКХ.Дата модификации", 
						null, null, null, dtModify);

				if (bc.isNoRSOGKNEGRPRegistered()!=null && bc.isNoRSOGKNEGRPRegistered()) {
					// нет связи с кадастром
					ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
							null, null, true, null);
				} else {
					// есть связь с кадастром
					ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
							null, null, false, null);
				}
				if (bc.getCadastralNumber() != null) {
					// есть кадастровый номер
					ptb.addTaskPar("ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)", 
							null, bc.getCadastralNumber(), null, null);
				}
				// сохранить параметры в объекте Eolink, через дочернее задание
				ptb.saveToEolink();
				
				Map<Integer, Eolink> entryMap = new HashMap<Integer, Eolink>();
				
				// Подъезды
				List<String> lstEntryGuid = new ArrayList<String>();
				for (Entrance t: ah.getEntrance()) {
					log.info("Подъезд: №={}, GUID={}", t.getEntranceNum(), t.getEntranceGUID());
					Eolink entryEol = eolinkMng.getEolinkByGuid(t.getEntranceGUID());
					lstEntryGuid.add(t.getEntranceGUID());
					if (entryEol == null) {
						// не найдено, создать подъезд
						AddrTp addrTp = lstMng.getAddrTpByCD("Подъезд");
						entryEol = new Eolink(reqProp.getReu(), reqProp.getKul(), reqProp.getNd(), null, null, 
								Integer.valueOf(t.getEntranceNum()),
								null, null, t.getEntranceGUID(), null, null, addrTp, foundTask2.getAppTp(), null, null, 
								houseEol, config.getCurUser(), 1);
						// сохранить, для иерархии
						entryMap.put(Integer.valueOf(t.getEntranceNum()), entryEol);
						em.persist(entryEol);
					}			

					// обновить параметры подъезда
					entryEol.setEntry(Integer.valueOf(t.getEntranceNum()));
					ptb.setUp(entryEol, task, "GIS_TMP", null);
					ptb.addTaskPar("ГИС ЖКХ.Дата модификации", null, null, null, Utl.getDateFromXmlGregCal(t.getModificationDate()));
					Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
					if (dtTerm!=null && (dtTerm.getTime() < curDate.getTime())) {
						// Объект не активен
						entryEol.setStatus(0);
					} else {
						// Объект активен
						entryEol.setStatus(1);
					}
					ptb.saveToEolink();
				}
				// проверить наличие подъезда из базы в ГИСе
				List<Eolink> lstEntry = eolinkDao.getChildByTp(houseEol, "Подъезд");
				lstEntry.stream().forEach(t-> {
					if (!lstEntryGuid.contains(t.getGuid())) {
						// не найден, промаркировать неактивным
						log.info("Подъезд №{} помечен неактивным!", t.getEntry());
						t.setStatus(0);
					}
				});
				
				// Жилые помещения 
				ah.getResidentialPremises().stream().forEach(Errors.rethrow().wrap(t-> {
					log.info("Жилое помещение: №={}, UniqNumber={}, GUID={}", 
							t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
					Eolink premisEol = eolinkMng.getEolinkByGuid(t.getPremisesGUID());
					if (premisEol == null) {
						// не найдено, создать помещение
						AddrTp addrTp = lstMng.getAddrTpByCD("Квартира");
						String num;
						if (reqProp.getAppTp().equals(1)) {
							// старая разработка, усечь лиц.счет до 7 знаков
							num = t.getPremisesNum().substring(0, 7);
							// добавить лидирующие нули
							num = Utl.lpad(num, "0", 7);
						} else {
							// новая и эксперем. разраб.
							num = t.getPremisesNum();
						}
						premisEol = new Eolink(reqProp.getReu(), reqProp.getKul(), reqProp.getNd(), 
								num , null, 
								t.getEntranceNum()!=null ? Integer.valueOf(t.getEntranceNum()) : null,
								null, null, t.getPremisesGUID(), t.getPremisesUniqueNumber(), null, addrTp, 
								foundTask2.getAppTp(), null, null, 
								t.getEntranceNum()!=null ? entryMap.get(Integer.valueOf(t.getEntranceNum())) : houseEol, // присоединить к родителю: подъезд, или дом, если не найден подъезд
								config.getCurUser(), 1
								 );
						log.info("Попытка создать запись жилого помещения в Eolink: № подъезда:{}, № квартиры={}, un={}, GUID={}",
								t.getEntranceNum(), 
								t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
						em.persist(premisEol);
						
					}

					// обновить параметры помещения
					// прикрепить к подъезду, взятому из ГИС ЖКХ
					if (t.getEntranceNum()!=null) {
						Integer entryNum = Integer.valueOf(t.getEntranceNum());
						premisEol.setEntry(entryNum);
						// обновить родительский подъезд
						Eolink entry = lstEntry.stream().filter(e-> e.getEntry().equals(entryNum)).findFirst().orElse(null);
						if (entry != null) {
							premisEol.setParent(entry);
						}
					}
					
					
					ptb.setUp(premisEol, task, "GIS_TMP", null);
					ptb.addTaskPar("ГИС ЖКХ.Дата модификации", null, null, null, Utl.getDateFromXmlGregCal(t.getModificationDate()));
					Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
					if (dtTerm!=null && (dtTerm.getTime() < curDate.getTime())) {
						// Объект не активен
						premisEol.setStatus(0);
					} else {
						// Объект активен
						premisEol.setStatus(1);
					}
					if (t.getGrossArea()!=null) {
						ptb.addTaskPar("Площадь.Общая", t.getGrossArea().doubleValue(), null, null, null);
					}
					
					if (t.getCadastralNumber() != null) {
						// есть кадастровый номер
						ptb.addTaskPar("ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)", 
								null, t.getCadastralNumber(), null, null);
					}
				
					t.getLivingRoom().forEach(f-> {
						log.info("f.isNoRSOGKNEGRPRegistered()1={}", f.isNoRSOGKNEGRPRegistered());
					});
					
					if (t.isNoRSOGKNEGRPRegistered()!=null && t.isNoRSOGKNEGRPRegistered()) {
						// нет связи с кадастром
						ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
								null, null, true, null);
					} else {
						// есть связь с кадастром
						ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
								null, null, false, null);
					}
					ptb.saveToEolink();
					
				}));
				
				// Нежилые помещения 
				for (NonResidentialPremises t : ah.getNonResidentialPremises()) {
					log.info("Нежилое помещение: №={}, UniqNumber={}, GUID={}", 
							t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
					Eolink premisEol = eolinkMng.getEolinkByGuid(t.getPremisesGUID());
					if (premisEol == null) {
						// Не найдено, создать помещение
						AddrTp addrTp = lstMng.getAddrTpByCD("Помещение нежилое");
						premisEol = new Eolink(reqProp.getReu(), reqProp.getKul(), reqProp.getNd(), Utl.lpad(t.getPremisesNum(), "0", 7), null, null,
								null, null, t.getPremisesGUID(), t.getPremisesUniqueNumber(), null, 
								addrTp, foundTask2.getAppTp(), null, null, houseEol, config.getCurUser(), 1);
						log.info("Попытка создать запись Нежилого помещения в Eolink: № квартиры={}, un={}, GUID={}", 
								t.getPremisesNum(), t.getPremisesUniqueNumber(), t.getPremisesGUID());
						em.persist(premisEol);
					}
					// обновить параметры помещения
					ptb.setUp(premisEol, task, "GIS_TMP", null);
					ptb.addTaskPar("ГИС ЖКХ.Дата модификации", null, null, null, Utl.getDateFromXmlGregCal(t.getModificationDate()));
					Date dtTerm = Utl.getDateFromXmlGregCal(t.getTerminationDate());
					if (dtTerm!=null && (dtTerm.getTime() < curDate.getTime())) {
						// Объект не активен
						premisEol.setStatus(0);
					} else {
						// Объект активен
						premisEol.setStatus(1);
					}
					if (t.getTotalArea()!=null) {
						ptb.addTaskPar("Площадь.Общая", t.getTotalArea().doubleValue(), null, null, null);
					}
					
					if (t.getCadastralNumber() != null) {
						// есть кадастровый номер
						ptb.addTaskPar("ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)", 
								null, t.getCadastralNumber(), null, null);
					}
				
					if (t.isNoRSOGKNEGRPRegistered()!=null && t.isNoRSOGKNEGRPRegistered()) {
						// нет связи с кадастром
						ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
								null, null, true, null);
					} else {
						// есть связь с кадастром
						ptb.addTaskPar("ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН", 
								null, null, false, null);
					}
					
					ptb.saveToEolink();
					
				};
				
			}

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			log.info("******* Task.id={}, экспорт объектов дома успешно выполнен", task.getId());
		}
			
	}

	/**
	 * Экспортировать лицевые счета
	 * @param task - задание
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportAccountData(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, экспорт лицевых счетов, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);
		
		ExportAccountRequest req = new ExportAccountRequest();
		req.setId("foo");
		req.setVersion(req.getVersion());
		
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
	}

	/**
	 * Получить результат экспорта лицевых счетов
	 * @param task - задание
	 * @throws CantPrepSoap 
	 * @throws WrongParam 
	 * @throws CantProcessAnswer 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportAccountDataAck(Task task) throws ErrorProcessAnswer, CantPrepSoap, WrongParam, ErrorProcessAnswer {
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		Eolink houseEol = reqProp.getFoundTask().getEolink();

		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());
		
		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			// Ошибок не найдено
			for (ExportAccountResultType t : retState.getExportAccountResult()) {
				String guid = null;
				for (ru.gosuslugi.dom.schema.integration.house_management.AccountExportType.Accommodation d :t.getAccommodation()) {
					if (d.getPremisesGUID() != null) {
						// Лиц счет на помещение
						guid = d.getPremisesGUID();
					} else if (d.getLivingRoomGUID() != null) {
						// Лиц счет на комнату
						guid = d.getLivingRoomGUID();
					} else {
						throw new ErrorProcessAnswer("Не найден GUID объекта лицевого счета с GUID="+t.getAccountGUID());
					}
					
				}
				// Найти лицевой счет
				Eolink accountEol = eolinkMng.getEolinkByGuid(t.getAccountGUID());

				if (accountEol != null) {
					// Лиц.счет уже существует, обновить его параметры
					log.info("Попытка обновить запись Лицевого счета в Eolink: GUID={}, AccountNumber={} ", t.getAccountGUID(),
							t.getAccountNumber());
				} else {
					// Создать новый лицевой счет

					// Найти объект на который ссылаться
					Eolink parentEol = eolinkMng.getEolinkByGuid(guid);
					if (parentEol == null) {
						throw new ErrorProcessAnswer("Не найдено помещение для прикрепления лицевого счета!");
					}

					AddrTp addrTp = lstMng.getAddrTpByCD("ЛС");
					
					String num;
					// усечь лиц.счет до 8 знаков
					num = t.getAccountNumber().substring(0, 8);
					accountEol = new Eolink(houseEol.getReu(), houseEol.getKul(), houseEol.getNd(), null, num, 
							null, null, null, t.getAccountGUID(), t.getUnifiedAccountNumber(), 
							null, addrTp, 
							reqProp.getFoundTask().getAppTp(), null, null, parentEol, config.getCurUser(), 1);

					log.info("Попытка создать запись Лицевого счета в Eolink: GUID={}, AccountNumber={}", 
							t.getAccountGUID(), num);
					em.persist(accountEol);
				}

				// обновить параметры лс
				ptb.setUp(houseEol, task, "GIS_TMP", null);
				if (t.getClosed()!= null) {
					// лс закрыт
					accountEol.setStatus(0);
					// Признак закрытия лицевого счета, если установлен
					Date dtTerminate = Utl.getDateFromXmlGregCal(t.getClosed().getCloseDate());
					ptb.addTaskPar("ГИС ЖКХ.Дата закрытия", 
							null, null, null, dtTerminate);
					ptb.addTaskPar("ГИС ЖКХ.Причина закрытия", 
							null, "ГИС ЖКХ.Причина закрытия", null, null);
				}
				

			}
			reqProp.getFoundTask().setState("ACP");
		}
		log.info("Запрос на выгрузку Лицевых счетов обработан. Task.id={}", task.getId());
	}
		
	/**
	 * Импортировать лицевые счета
	 * @return - признак ошибки 
	 * @throws WrongGetMethod 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap {
		log.info("******* Task.id={}, импорт лицевых счетов, вызов", task.getId());
		// Установить параметры SOAP
		sb.setTrace(true);

		reqProp.setProp(task, sb);

		ImportAccountRequest req = new ImportAccountRequest();
		req.setVersion(req.getVersion());
		req.setId("foo");
		
		List<Task> lstTask = taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "ЛС", null).stream()
				.filter(t-> t.getAct().getCd().equals("GIS_ADD_ACC")).collect(Collectors.toList());
		for (Task t: lstTask) {
			log.info("Обработка Task.id={}, лиц.счета={}", t.getId(), t.getEolink().getLsk());
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
			ac.getAccommodation().add(acm );
			// № лицевого счета
			ac.setAccountNumber(t.getEolink().getLsk());
	
			// Сведения о плательщике (решили оставить "val")
			PayerInfo pf = new PayerInfo();
			AccountIndType ind = new AccountIndType();
			ind.setFirstName("val");
			ind.setSurname("val");
			ind.setPatronymic("val");
			pf.setInd(ind );
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
		
	}
	
	
	/**
	 * Получить результат импорта лицевых счетов
	 * @throws CantPrepSoap 
	 * @throws WrongGetMethod 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importAccountDataAck(Task task) throws CantPrepSoap, WrongGetMethod {
		log.info("******* Task.id={}, Импорт лицевых счетов, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		
		sb.setTrace(true);
		
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			//retState.getImportResult().stream().forEach(t -> {
			for (ImportResult t: retState.getImportResult()) {
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
						status=0;
					} else {
						status=1;
					}
					// Есть дата обновления, установить GUID
					task2.setGuid(d.getGUID());
					task2.setUn(d.getUniqueNumber());
					task2.setUpdDt(Utl.getDateFromXmlGregCal(d.getUpdateDate()));
					log.info("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:", 
							reqProp.getFoundTask().getId(), d.getTransportGUID());
					log.info("GUID={}, UniqueNumber={}", d.getGUID(), d.getUniqueNumber());
					// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
					taskMng.setEolinkIdf(task2.getEolink(), d.getGUID(), d.getUniqueNumber(), status);
					task2.setState("ACP");
				}
			}
			
			if (taskDao.getChildAnyErr(reqProp.getFoundTask())) {
				log.info("Найдены ошибки / Невыполнение в дочерних заданиях! Task.id={}", task.getId()); 
				// Установить статус
				reqProp.getFoundTask().setResult("Найдены ошибки / Невыполнение в дочерних заданиях!");
				reqProp.getFoundTask().setState("ERR");
			} else {
				log.info("Импорт лицевых счетов успешно выполнен! Task.id={}", task.getId()); 
				// Установить статус выполнения задания
				reqProp.getFoundTask().setState("ACP");
			}
			
		}
	}
	
		
	/*
	 * Обновление объектов дома
	 * 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importHouseUOData(Task task) throws WrongGetMethod, CantPrepSoap {
		log.info("******* Task.id={}, Импорт объектов дома, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);
		ImportHouseUORequest req = new ImportHouseUORequest();
		req.setId("foo");
		req.setVersion(req.getVersion());
		//sb.setSign(true);

		ApartmentHouse ah = new ApartmentHouse();

		// установить базовые параметры
		if (reqProp.getFoundTask().getAct().getCd().equals("GIS_ADD_HOUSE")){
	    	// Добавить дом
			log.info("Добавление дома, Task.id={}", reqProp.getFoundTask().getId());
	    	BasicCharacteristicts bc = new BasicCharacteristicts();
	       	bc.setFIASHouseGuid(reqProp.getFoundTask().getEolink().getGuid());
			Double totSqr = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
	    	bc.setTotalSquare(BigDecimal.valueOf(totSqr));

	    	Date dtBuild = teParMng.getDate(reqProp.getFoundTask(), "ГИС ЖКХ.Дата постройки");
			String dtBuiltStr = Utl.getStrFromDate(dtBuild);
			dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length()-4, dtBuiltStr.length());
			Integer usedYear = Integer.valueOf(dtBuiltStr);
	    	bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());
	    	
	    	Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
	    	bc.setCulturalHeritage((cult==1d) ? true : false );
	    	
	    	// установить часовую зону
	    	bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 32/*30*/, "Часовая зона", "Asia/Novokuznetsk")); // ред.28.12.17 странно было 31 поменял на 32
			
	    	Double et = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наибольшее(1-11)");
	    	bc.setFloorCount(String.valueOf(et));
	    	
			Boolean isGkn = teParMng.getBool(reqProp.getFoundTask(), "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
	    	if (isGkn != null && isGkn) {
		    	// Ключ связи с ГКН/ЕГРП отсутствует.
		    	bc.setNoRSOGKNEGRPRegistered(true);
	    	} else {
		    	// Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
		    	bc.setCadastralNumber(teParMng.getStr(reqProp.getFoundTask(), 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
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
	    	ac.setUndergroundFloorCount(String.valueOf(underEt));

			Double etMin = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наименьшее(1-10)");
			log.info("etMin={}", etMin);
			Integer etMin2 = etMin.intValue();
	    	ac.setMinFloorCount(etMin2.byteValue());

	    	String tguid = Utl.getRndUuid().toString();
	    	reqProp.getFoundTask().setTguid(tguid);
	    	ac.setTransportGUID(tguid);

	    	ac.setBasicCharacteristicts(bc);
	    	ah.setApartmentHouseToCreate(ac);
	    	
		} else if (reqProp.getFoundTask().getAct().getCd().equals("GIS_UPD_HOUSE")){
	    	// Обновить дом
			log.info("Обновление дома, Task.id={}", reqProp.getFoundTask().getId());
	    	HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
	       	bc.setFIASHouseGuid(reqProp.getFoundTask().getEolink().getGuid());
			Double totSqr = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
	    	bc.setTotalSquare(BigDecimal.valueOf(totSqr));
			
	    	Date dtBuild = teParMng.getDate(reqProp.getFoundTask(), "ГИС ЖКХ.Дата постройки");
			String dtBuiltStr = Utl.getStrFromDate(dtBuild);
			dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length()-4, dtBuiltStr.length());
			Integer usedYear = Integer.valueOf(dtBuiltStr);
	    	bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

	    	Double cult = teParMng.getDbl(reqProp.getFoundTask(), "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
	    	bc.setCulturalHeritage((cult==1d) ? true : false );

	    	// установить часовую зону
	    	bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 32/*30*/, "Часовая зона", "Asia/Novokuznetsk")); //TODO проверить почему стояло 30, когда часовая зона по OLSON это 31

	    	Double et = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наибольшее(1-11)");
	    	bc.setFloorCount(String.valueOf(et));
	    	
			Boolean isGkn = teParMng.getBool(reqProp.getFoundTask(), "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
	    	if (isGkn != null && isGkn) {
		    	// Ключ связи с ГКН/ЕГРП отсутствует.
		    	bc.setNoRSOGKNEGRPRegistered(true);
	    	} else {
		    	// Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
		    	bc.setCadastralNumber(teParMng.getStr(reqProp.getFoundTask(), 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
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
	    	ac.setUndergroundFloorCount(String.valueOf(underEt));

			Double etMin = teParMng.getDbl(reqProp.getFoundTask(), "Количество этажей, наименьшее(1-10)");
			Integer etMin2 = etMin.intValue();
	    	ac.setMinFloorCount(etMin2.byteValue());
	    	
	    	String tguid = Utl.getRndUuid().toString();
	    	reqProp.getFoundTask().setTguid(tguid);
	    	log.info("Установлен house TGUID={}", tguid);
	    	ac.setTransportGUID(tguid);

	    	ac.setBasicCharacteristicts(bc);
	    	ah.setApartmentHouseToUpdate(ac);
		}
    	
		// Добавить подъезды
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_ENTRY"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление подъезда, Task.id={}", t.getId());
	    	EntranceToCreate ec = new EntranceToCreate();
	    	String entryNum = String.valueOf(t.getEolink().getEntry());
	    	ec.setEntranceNum(entryNum);

	    	// год постройки 
			Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");
			String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
			dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length()-4, dtEntrBuiltStr.length());
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
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Подъезд", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_ENTRY"))
		.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление подъезда, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
	    	EntranceToUpdate eu = new EntranceToUpdate();
	    	eu.setEntranceGUID(t.getEolink().getGuid());
	    	String entryNum = String.valueOf(t.getEolink().getEntry());
	    	eu.setEntranceNum(entryNum);
	    	
	    	// год постройки 
			Date dtEntrBuild = teParMng.getDate(t, "ГИС ЖКХ.Дата постройки");
			
			String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
			dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length()-4, dtEntrBuiltStr.length());
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
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_PRMS"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление жилого помещения, Task.id={}", t.getId());
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
		    	// Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
		    	rc.setCadastralNumber(teParMng.getStr(t, 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
	    	}

	    	// наличие подъезда
	    	if (t.getEolink().getParent().getObjTp().getCd().equals("Подъезд")) {
	    		// есть подъезд
		    	// номер подъезда
		    	String entryNum = String.valueOf(t.getEolink().getEntry());
		    	if (entryNum!=null ) {
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
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_PRMS"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление НЕжилого помещения, Task.id={}", t.getId());
			NonResidentialPremiseToCreate rc = 
	    			new NonResidentialPremiseToCreate();

			Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
	    	if (isGkn != null && isGkn) {
		    	// Ключ связи с ГКН/ЕГРП отсутствует.
		    	rc.setNoRSOGKNEGRPRegistered(true);
	    	} else {
		    	// Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
		    	rc.setCadastralNumber(teParMng.getStr(t, 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
	    	}
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));

    		String commProp = teParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");
	    	rc.setIsCommonProperty(commProp.equals("Да") ? true: false);
	    	
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
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_PRMS"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление жилого помещения, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
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
		    	rc.setCadastralNumber(teParMng.getStr(t, 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
	    	}

	    	// наличие подъезда
	    	if (t.getEolink().getParent().getObjTp().getCd().equals("Подъезд")) {
	    		// есть подъезд
		    	// номер подъезда
		    	String entryNum = String.valueOf(t.getEolink().getEntry());
		    	if (entryNum!=null ) {
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
		taskDao.getByTaskAddrTp(reqProp.getFoundTask(), "Помещение нежилое", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_PRMS"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление НЕжилого помещения, Task.id={}, Guid={}", t.getId(), t.getEolink().getGuid());
			NonResidentialPremiseToUpdate rc = 
	    			new NonResidentialPremiseToUpdate(); 
			Boolean isGkn = teParMng.getBool(t, "ГИС ЖКХ.Признак.ОтсутствияСвязи.ГКН");
	    	if (isGkn != null && isGkn) {
		    	// Ключ связи с ГКН/ЕГРП отсутствует.
		    	rc.setNoRSOGKNEGRPRegistered(true);
	    	} else {
		    	// Ключ связи с ГКН/ЕГРП присутствует, поставить номер ГКН
		    	rc.setCadastralNumber(teParMng.getStr(t, 
		    			"ГИС ЖКХ.Кадастровый номер (для связывания сведений с ГКН и ЕГРП)"));
	    	}
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(),"0"));
    		String commProp = teParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");
	    	
	    	rc.setIsCommonProperty(commProp.equals("Да") ? true: false);
	    	
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
    	
    	req.setVersion(req.getVersion());
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
	}

	/**
	 * Получить результат отправки обновления объектов дома
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importHouseUODataAck(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, Импорт объектов дома, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			//log.info("Проверка1"); 
			Task foundTask2 = reqProp.getFoundTask();
			retState.getImportResult().stream().forEach(t-> {
				//log.info("Проверка2"); 
				t.getCommonResult().forEach( d-> {
					//log.info("Проверка3"); 
						
						// Найти элемент задания по Транспортному GUID
						Task task2 = taskMng.getByTguid(foundTask2, d.getTransportGUID());
						if (d.getUpdateDate() != null){
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
							log.info("После импорта объектов по Task.id={} и TGUID={}, получены следующие параметры:", 
									reqProp.getFoundTask().getId(), d.getTransportGUID());
							log.info("GUID={}, UniqueNumber={}", d.getGUID(), d.getUniqueNumber());
						}
				});
			}); 
			
			if (taskDao.getChildAnyErr(reqProp.getFoundTask())) {
				log.info("Найдены ошибки / Невыполнение в дочерних заданиях! Task.id={}", task.getId()); 
				// Установить статус
				reqProp.getFoundTask().setResult("Найдены ошибки / Невыполнение в дочерних заданиях!");
				reqProp.getFoundTask().setState("ERR");
			} else {
				log.info("Импорт объектов дома успешно выполнен! Task.id={}", task.getId()); 
				// Установить статус выполнения задания
				reqProp.getFoundTask().setState("ACP");
			}
		}
		
	}
	
	/**
	 * Импортировать счетчики (приборы учета)
	 * @return - признак ошибки 
	 * @throws WrongGetMethod 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap {
		log.info("******* Task.id={}, импорт приборов учета, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		sb.setTrace(true);

		ImportMeteringDeviceDataRequest req = new ImportMeteringDeviceDataRequest();
		req.setVersion(req.getVersion());
		req.setId("foo");

		req.setFIASHouseGuid(reqProp.getHouseGuid());
		
		// получить все дочерние задания
		List<Task> lstTask = reqProp.getFoundTask().getChild();
		for (Task t: lstTask) {
			MeteringDevice md = new MeteringDevice();
			// Транспортный GUID
			String tguid = Utl.getRndUuid().toString();
			t.setTguid(tguid);
			md.setTransportGUID(tguid);

			Eolink e = t.getEolink();
			
			if (!e.getObjTp().getCd().equals("СчетчикФизический")) {
				throw new CantPrepSoap("Некорректный тип объекта по заданию Task.id="+t.getId());
			} 
			
			String versionGuid = null;
			// для архивации и обновления
			DeviceDataToUpdate devDataUpd = null;

			if (t.getAct().getCd().equals("GIS_ARCH_METER") || t.getAct().getCd().equals("GIS_UPD_METER_BEFORE_VAL")){
				// Если архивация или обновление - найти версию счетчика
				Boolean isFoundVers = false;
				for (Eolink ver: e.getChild()) {
					if (ver.getStatus().equals(1) && ver.getObjTp().getCd().equals("СчетчикВерсия")) {
						// Взять GUID первой активной версии счетчика 
						versionGuid = ver.getGuid();
						isFoundVers = true;
						break;
					}
				};
				if (!isFoundVers) {
					throw new CantPrepSoap("Не найдена активная версия счетчика для "+t.getAct().getName()+" по счетчику Eolink.id="+e.getId());
				}
				devDataUpd = new DeviceDataToUpdate();
			}

			
			if (t.getAct().getCd().equals("GIS_ADD_METER") || t.getAct().getCd().equals("GIS_UPD_METER_BEFORE_VAL")){
				int varMeter;
				if (t.getAct().getCd().equals("GIS_ADD_METER")) {
					// Добавить счетчик
					log.info("Добавление счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
					varMeter = 0;
				} else {
					// Обновить счетчик
					log.info("Обновление счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
					varMeter = 1;
				}
				
				if (varMeter == 0 && t.getEolink().getGuid() != null) {
					// GUID не должен быть заполнен при добавлении счетчика
					throw new CantPrepSoap("По объекту уже имеется GUID, невозможно импортировать! Задание Task.id="+t.getId());
				}
				
				Eolink premiseEol = t.getEolink().getParent();
				MeteringDeviceBasicCharacteristicsType bc = new MeteringDeviceBasicCharacteristicsType();
				
				// Дата ввода в эксплуатацию.
		    	Date dtBegin = teParMng.getDate(t, "Счетчик.ДатаВводаЭкс");
				try {
					bc.setCommissioningDate(Utl.getXMLDate(dtBegin
							));
				} catch (DatatypeConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					throw new CantPrepSoap("Некорректная дата ввода в эксплуатацию прибора учета");
				} 
				bc.setMeteringDeviceNumber(teParMng.getStr(t, "Счетчик.НомерПУ"));
				bc.setRemoteMeteringMode(false);
				bc.setTemperatureSensor(false);
				bc.setPressureSensor(false);
				
				bc.setMeteringDeviceNumber(teParMng.getStr(t, "Счетчик.НомерПУ"));
				bc.setMeteringDeviceModel(teParMng.getStr(t, "Счетчик.Модель"));
				bc.setMeteringDeviceStamp(teParMng.getStr(t, "ПУ.Марка"));

				if (premiseEol.getObjTp().getCd().equals("Квартира")) {
					// Жилое помещение
					ResidentialPremiseDevice premiseRsd = new ResidentialPremiseDevice();
					premiseRsd.setPremiseGUID(premiseEol.getGuid());
					// Добавить лицевые счета
					eolinkToEolinkDao.getParentEolink(e, "Логическая связь").stream().forEach(d-> {
						premiseRsd.getAccountGUID().add(d.getGuid());
						log.info("К счетчику добавлена связь с лиц.счетом GUID={}", d.getGuid());
					});
					
					bc.setResidentialPremiseDevice(premiseRsd);
				} else if (premiseEol.getObjTp().getCd().equals("Помещение нежилое")) {
					
					NonResidentialPremiseDevice premiseNrsd = new NonResidentialPremiseDevice();
					premiseNrsd.setPremiseGUID(premiseEol.getGuid());
					// Нежилое помещение
					bc.setNonResidentialPremiseDevice(premiseNrsd );
					// Добавить лицевые счета
					eolinkToEolinkDao.getParentEolink(e, "Логическая связь").stream().forEach(d-> {
						premiseNrsd.getAccountGUID().add(d.getGuid());
						log.info("К счетчику добавлена связь с лиц.счетом GUID={}", d.getGuid());
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
				MunicipalResourceNotElectricType munResNenerg = new MunicipalResourceNotElectricType();
				
				NsiRef mres = null;
				// Получить ресурс по коду USL
				mres = ulistMng.getResourceByUsl(e.getUsl());
				
				if (ulistMng.getResType(e.getUsl()) != 1) {
					// Не эл.энерг.
					munResNenerg.setMunicipalResource(mres);
					munResNenerg.setMeteringValue(BigDecimal.valueOf(taskParMng.getDbl(t, "Счетчик.Показ(Т1)")));
					mdinf.getMunicipalResourceNotEnergy().add(munResNenerg);
				} else {
					// Сведения о коммунальном ресурсе и базовые показания ПУ (электрическая энергия)
					MunicipalResourceElectricType mresEl = new MunicipalResourceElectricType();
					mresEl.setMeteringValueT1(BigDecimal.valueOf(taskParMng.getDbl(t, "Счетчик.Показ(Т1)")));
					mdinf.setMunicipalResourceEnergy(mresEl);
				}
				
			
		} else if (t.getAct().getCd().equals("GIS_ARCH_METER")){
				// Архивация счетчика
				log.info("Архивация счетчика в ГИС, Task.id={}", reqProp.getFoundTask().getId());
				// Взять GUID первой активной версии счетчика 
				devDataUpd.setMeteringDeviceVersionGUID(versionGuid);
				
				ArchiveDevice archDev = new ArchiveDevice();
				String reason = taskParMng.getStr(t, "ГИС ЖКХ.Причина архивации");
				archDev.setArchivingReason(ulistMng.getNsiElem("NSI", 21, "Причина архивации прибора учета", reason));
				//log.info("reason={}, nsi={}", reason, ulistMng.getNsiElem("NSI", 21, "Причина архивации прибора учета", reason));
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
			reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
	}	
	
	
	/**
	 * Получить результат импорта счетчиков
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importMeteringDeviceDataAck(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, импорт приборов учета, запрос ответа", task.getId());
		sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		
		// получить состояние
		GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getImportResult().stream().forEach(t -> {
				t.getCommonResult().stream().forEach(d -> {
					// Найти элемент задания (счетчик) по Транспортному GUID
					Task task2 = taskMng.getByTguid(task, d.getTransportGUID());
					if (task2.getAct().getCd().equals("GIS_ADD_METER")) {
						// Переписать значения параметров в eolink из task
						teParMng.acceptPar(task2);
						// Счетчик физический
						Eolink meterEol = task2.getEolink(); 
						// Установить статус активности счетчика
						task2.getEolink().setStatus(1);
						
						task2.setGuid(d.getImportMeteringDevice().getMeteringDeviceGUID());
						task2.setUn(d.getUniqueNumber());
						task2.setUpdDt(Utl.getDateFromXmlGregCal(d.getUpdateDate()));
						log.info("После импорта объектов в ГИС, по Task.id={} и TGUID={}, получены следующие параметры:", 
								reqProp.getFoundTask().getId(), d.getTransportGUID());
						log.info("Версия счетчика: GUID={}", d.getGUID());
						log.info("Корневой счетчик: GUID={}, UniqueNumber={}", 
								d.getImportMeteringDevice().getMeteringDeviceGUID(), 
								d.getUniqueNumber());
						
						// создать версию счетчика, если не создана
						Eolink versionEol = eolinkMng.getEolinkByGuid(d.getImportMeteringDevice().getMeteringDeviceGUID());
						if (versionEol == null) {
							// не найдено, создать новую запись версии счетчика
							AddrTp addrTp = lstMng.getAddrTpByCD("СчетчикВерсия");
							versionEol = new Eolink(meterEol.getReu(), meterEol.getKul(), meterEol.getNd(), 
									null, null, 
									null, null, null, d.getGUID(), 
									null, null , addrTp, 
									reqProp.getFoundTask().getAppTp(), null, null, meterEol, config.getCurUser(), 1);
	
							log.info("Попытка создать запись версии счетчика в Eolink: GUID={}", 
									d.getGUID(), null);
							em.persist(versionEol);
						}
						
						// Записать идентификаторы ПУ корневого (физического) счетчика, полученного от ГИС (если уже не установлены)
						taskMng.setEolinkIdf(task2.getEolink(), d.getImportMeteringDevice().getMeteringDeviceGUID(),
								d.getUniqueNumber(), 1);
						// Поставить отметку, что успешно обновлено в ГИС  
						task2.setState("ACP");
					} else if (task2.getAct().getCd().equals("GIS_UPD_METER_BEFORE_VAL")) {
						// Отработано задание "Обновление счетчика"
						// Переписать значения параметров в eolink из task
						teParMng.acceptPar(task2);
						// Поставить отметку, что успешно обновлено в ГИС  
						task2.setState("ACP");
						log.info("Параметры счетчика обновлены");
					} else if (task2.getAct().getCd().equals("GIS_ARCH_METER")) {
						// Отработано задание "Архивация счетчика"
						// Установить неактивный статус у дочерних записей - версий счетчика
						task2.getEolink().getChild().stream()
										.filter(e-> e.getObjTp().getCd().equals("СчетчикВерсия"))
										.forEach(e-> {
											e.setStatus(0);
										});
						// Установить статус неактивности счетчика
						task2.getEolink().setStatus(0);
						// Поставить отметку, что успешно обновлено в ГИС  
						task2.setState("ACP");
						log.info("Cчетчик архивирован");
					}
					
				});
			});
			
			if (taskDao.getChildAnyErr(reqProp.getFoundTask())) {
				log.info("Найдены ошибки / Невыполнение в дочерних заданиях! Task.id={}", task.getId()); 
				reqProp.getFoundTask().setResult("Найдены ошибки / Невыполнение в дочерних заданиях!");
				// Установить статус
				reqProp.getFoundTask().setState("ERR");
			} else {
				log.info("Импорт счетчиков успешно выполнен! Task.id={}", task.getId()); 
				// Установить статус выполнения задания
				reqProp.getFoundTask().setState("ACP");
			}
			
		}
	}

	
	/**
	 * Проверить наличие заданий на экспорт объектов дома
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicHouseExp(Task task) throws WrongParam {
		log.info("******* Task.id={}, проверка наличия заданий на экспорт объектов дома, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на экспорт объектов дома, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", "GIS_EXP_HOUSE")) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_EXP_HOUSE", "STP");
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");
			ptb.save();
			log.info("Добавлено задание на экспорт объектов дома по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}
	
	/**
	 * Проверить наличие заданий на подготовку импорта объектов дома
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicHouseImp(Task task) throws WrongParam {
		log.info("******* Task.id={}, проверка наличия заданий на подготовку импорта объектов дома, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на экспорт объектов дома, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", "GIS_PREP_HOUSE_IMP")) {// TODO ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_PREP_HOUSE_IMP", "STP");// TODO ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addAsChild("SYSTEM_RPT_HOUSE_PREP");      // TODO ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ ПРОВЕРИТЬ  
			ptb.save();
			log.info("Добавлено задание на подготовку импорта объектов дома по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

	/**
	 * Проверить наличие заданий на выгрузку лицевх счетов
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicAccExp(Task task) throws WrongParam {
		log.info("******* Task.id={}, проверка наличия заданий на выгрузку объектов дома, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на выгрузку лицевых счетов, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", "GIS_EXP_ACCS")) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_EXP_ACCS", "STP");
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");
			ptb.save();
			log.info("Добавлено задание на выгрузку лицевых счетов по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

	/**
	 * Проверить наличие заданий на выгрузку счетчиков
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicMetExp(Task task) throws WrongParam {
		log.info("******* Task.id={}, проверка наличия заданий на выгрузку счетчиков ИПУ, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на выгрузку счетчиков ИПУ дома, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", "GIS_EXP_METERS")) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_EXP_METERS", "STP");
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addTaskPar("ГИС ЖКХ.Включая архивные", null, null, false, null);
			ptb.addAsChild("SYSTEM_RPT_HOUSE_EXP");
			ptb.save();
			log.info("Добавлено задание на выгрузку счетчиков ИПУ по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

}
