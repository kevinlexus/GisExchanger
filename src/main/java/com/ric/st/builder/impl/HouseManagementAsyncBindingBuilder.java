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
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.base.OKTMORefType;
import ru.gosuslugi.dom.schema.integration.house_management.AccountIndType;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.Accommodation;
import ru.gosuslugi.dom.schema.integration.house_management.AccountType.PayerInfo;
import ru.gosuslugi.dom.schema.integration.house_management.ApartmentHouseUOType.BasicCharacteristicts;
import ru.gosuslugi.dom.schema.integration.house_management.ClosedAccountAttributesType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportAccountRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChAsyncRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportCAChRequestCriteriaType;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseRequest;
import ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse.NonResidentialPremises;
import ru.gosuslugi.dom.schema.integration.house_management.ExportMeteringDeviceDataRequest;
import ru.gosuslugi.dom.schema.integration.house_management.GetStateResult;
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
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;
import ru.gosuslugi.dom.schema.integration.house_management.ImportResult.CommonResult;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.house_management_service_async.HouseManagementServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import com.diffplug.common.base.Errors;
import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.bs.AddrTp;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.impl.SoapConfig;
import com.ric.st.impl.TaskController;
import com.ric.st.mm.TaskMng;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

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
	
	private HouseManagementServiceAsync service;
	private HouseManagementPortsTypeAsync port;
	private SoapBuilder sb;
	
	// внутренний DTO класс
	private class RetState {
		
		private ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state;
		private Boolean err;
		private String errStr;
		
		private RetState(GetStateResult state, Boolean err, String errStr) {
			super();
			setState(state);
			setErr(err);
			setErrStr(errStr);
		}
		
		public ru.gosuslugi.dom.schema.integration.house_management.GetStateResult getState() {
			return state;
		}
		public void setState(
				ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state) {
			this.state = state;
		}
		public Boolean getErr() {
			return err;
		}
		public void setErr(Boolean err) {
			this.err = err;
		}
		public String getErrStr() {
			return errStr;
		}
		public void setErrStr(String errStr) {
			this.errStr = errStr;
		}

	}
	
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

		// логгинг запросов
    	sb.setTrace(false);
	}

	/**
	 * Старый вызов получения статуса запроса - TODO: Удалить!
	 * @param ack
	 * @return
	 */
	private RetState getState(AckRequest ack) {
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
		} if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Прочие ошибки
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
		}
		
		return new RetState(state, err, errStr);

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
		ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
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
		} if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			err = true;
			errStr = state.getErrorMessage().getDescription();
			log.info("Ошибка выполнения запроса = {}", errStr);
			task.setState("ERR");
			task.setResult(errStr);
		} else {
			
			for (ImportResult t : state.getImportResult()) {
				for (CommonResult e : t.getCommonResult()) {
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
		}
		
		if (!err) {
			// если в главном задании нет ошибок, но в любом дочернем задании обнаружена ошибка - статус - "Ошибка"
			if (errChld) {
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
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Boolean exportDeviceData(Task task) {
		Task foundTask = null;
		String houseGuid = null;
		String ppGuid = null;
		foundTask = em.find(Task.class, task.getId());
		String reu = task.getEolink().getReu();
		houseGuid = task.getEolink().getGuid();

		// Установить PPGUID
		ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
		
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportMeteringDeviceDataRequest req = new ExportMeteringDeviceDataRequest(); 

		AckRequest ack = null;
		req.setId("foo");
		sb.setSign(true);
		req.setVersion(req.getVersion());
		req.setFIASHouseGuid(houseGuid);
		
		try {
			ack = port.exportMeteringDeviceData(req);
		} catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
			e1.printStackTrace();
			err = true;
			errMainStr = e1.getFaultInfo().getErrorMessage();
		}
    	
		RetState retState = null;
    	if (!err) {
    		retState = getState(ack);
    	}

    	// Показать ошибки, если есть
		if (err) {
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else if (retState.getErr()) {
				err = true;
				String errStr = retState.getErrStr();
				foundTask.setState("ERR");
				foundTask.setResult("Вложенная ошибка XML: "+errStr);
		} else {
			// Ошибок нет, обработка
			
			try {
				retState.getState().getExportMeteringDeviceDataResult().stream().forEach(t-> {
					log.info("Счетчик:{}", t.getMeteringDeviceGISGKHNumber() );
					// TODO сделать сохранение счетчиков

				});
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Установить статус выполнения задания
			foundTask.setState("ACP");
		}
		
		return err;

	}
	
	/**
	 * Экспортировать договора управления по дому
	 * @param task - задание (если есть)
     * @param reu - REU из Квартплаты
     * @param kul - KUL из Квартплаты
     * @param nd -  ND из Квартплаты
	 * @return 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Boolean exportContract(Task task) {
		Task foundTask = null;
		String houseGuid = null;
		String ppGuid = null;
		// если есть задание
		foundTask = em.find(Task.class, task.getId());
		String reu = task.getEolink().getReu();
		houseGuid = task.getEolink().getGuid();
		
		// Установить PPGUID
		ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
		
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportCAChAsyncRequest req = new ExportCAChAsyncRequest(); 
		AckRequest ack = null;
		req.setId("foo");
		sb.setSign(true);
		req.setVersion(req.getVersion());
		ExportCAChRequestCriteriaType criteria = new ExportCAChRequestCriteriaType();
		Eolink uk = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация");
		
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
    	
		RetState retState = null;
    	if (!err) {
    		retState = getState(ack);
    	}

    	// Показать ошибки, если есть
		if (err) {
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else if (retState.getErr()) {
				err = true;
				String errStr = retState.getErrStr();
				foundTask.setState("ERR");
				foundTask.setResult("Вложенная ошибка XML: "+errStr);
		} else {
			// Ошибок нет, обработка
			Task foundTask2 = foundTask;
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
						contrEol = new Eolink(contractGUID, null, null, addrTp, foundTask2.getAppTp(), objTpx, null);
						// установить Parent_id ведущий к дому
						contrEol.setParEolink(task.getEolink());
						em.persist(contrEol);
						log.info("Создан договор управления или устав! guid={}", contractGUID);
					} else {
						log.info("Договор управления или устав существует, обновление параметров! guid={}", contractGUID);
					}
					// сохранить параметры
					if (t.getContract()!=null) {
						// установить Parent_id ведущий к дому
						contrEol.setParEolink(task.getEolink());
						// Договор управления
						eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Дата подписания", 
								Utl.getDateFromXmlGregCal(t.getContract().getSigningDate() ));
						eolinkParMng.setDate(contrEol, "ГИС ЖКХ.Планируемая дата завершения", 
								Utl.getDateFromXmlGregCal(t.getContract().getPlanDateComptetion()));
						eolinkParMng.setStr(contrEol, "ГИС ЖКХ.GUID Версии документа", 
								t.getContract().getContractVersionGUID());
					} else if (t.getCharter()!=null) {
						// установить Parent_id ведущий к дому
						contrEol.setParEolink(task.getEolink());
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
			foundTask.setState("ACP");
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
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Boolean exportHouseData(Task task) {
		Task foundTask = null;
		String houseGuid = null;
		Eolink houseEol = null;
		String ppGuid = null;
		foundTask = em.find(Task.class, task.getId());
		String reu = task.getEolink().getReu();
		houseEol = task.getEolink();
		houseGuid = houseEol.getGuid();

		// Установить PPGUID
		ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);

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
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			foundTask.setState("ACK");
			foundTask.setMsgGuid(ack.getAck().getMessageGUID());
		}
		
		return err;
	}

	
	/**
	 * Получить результат экспорта объектов дома
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void exportHouseDataAck(Task task) {
		Task foundTask = null;
		Eolink houseEol = null;
		foundTask = em.find(Task.class, task.getId());
		houseEol = task.getEolink();
		String reu = houseEol.getReu();
		String kul = houseEol.getKul();
		String nd = houseEol.getNd();
		// Установить PPGUID
		String ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
		// получить состояние
		GetStateResult retState = getState2(foundTask);
		
		if (!foundTask.getState().equals("ERR")) {
			// Ошибок нет, обработка
			Task foundTask2 = foundTask; 
			// Сохранить уникальный номер дома
			houseEol.setUn(retState.getExportHouseResult().getHouseUniqueNumber());
			
			ru.gosuslugi.dom.schema.integration.house_management.ExportHouseResultType.ApartmentHouse ah = 
					retState.getExportHouseResult().getApartmentHouse();
			if (ah != null) {
				Map<Integer, Eolink> entryMap = new HashMap<Integer, Eolink>();
				
				Eolink houseEol2 = houseEol;
				// Подъезды
				ah.getEntrance().stream().forEach(t-> {
					log.info("Подъезд: № {}", t.getEntranceNum());
					Eolink entryEol = eolinkMng.getEolinkByGuid(t.getEntranceGUID());
					if (entryEol != null) {
						// найдено, обновить параметры подъезда
					} else if (entryEol == null) {
						// не найдено, создать подъезд
						AddrTp addrTp = lstMng.getAddrTpByCD("Подъезд");
						entryEol = new Eolink(reu, kul, nd, null, null, Integer.valueOf(t.getEntranceNum()),
								null, null, t.getEntranceGUID(), null, null, addrTp, foundTask2.getAppTp(), null, null, houseEol2);
						// сохранить, для иерархии
						entryMap.put(Integer.valueOf(t.getEntranceNum()), entryEol);
						em.persist(entryEol);
					}					
				});
				
				// Жилые помещения 
				ah.getResidentialPremises().stream().forEach(Errors.rethrow().wrap(t-> {
					log.info("Жилое помещение: № подъезда:{}, № квартиры:{}, un:{}", t.getEntranceNum(), t.getPremisesNum(), t.getPremisesUniqueNumber());
					Eolink premisEol = eolinkMng.getEolinkByGuid(t.getPremisesGUID());
					if (premisEol != null) {
						// найдено, обновить параметры помещения
						if (t.getGrossArea()!=null) {
							eolinkParMng.setDbl(premisEol, "Площадь.Общая", t.getGrossArea().doubleValue());
						}
					} else if (premisEol == null) {
						// не найдено, создать помещение
						AddrTp addrTp = lstMng.getAddrTpByCD("Квартира");
						premisEol = new Eolink(reu, kul, nd, Utl.lpad(t.getPremisesNum(), "0", 7), null, 
								t.getEntranceNum()!=null ? Integer.valueOf(t.getEntranceNum()) : null,
								null, null, t.getPremisesGUID(), t.getPremisesUniqueNumber(), null, addrTp, foundTask2.getAppTp(), null, null, 
								t.getEntranceNum()!=null ? entryMap.get(Integer.valueOf(t.getEntranceNum())) : null 
								 );
						em.persist(premisEol);
						if (t.getGrossArea()!=null) {
							eolinkParMng.setDbl(premisEol, "Площадь.Общая", t.getGrossArea().doubleValue());
						}
					}
				}));
				
				// Нежилые помещения 
				ah.getNonResidentialPremises().stream().forEach(Errors.rethrow().wrap(t-> {
					log.info("Нежилое помещение: № квартиры:{}, un:{}", null, t.getPremisesNum(), t.getPremisesUniqueNumber());
					Eolink premisEol = eolinkMng.getEolinkByGuid(t.getPremisesGUID());
					if (premisEol != null) {
						// Найдено, обновить параметры помещения
						if (t.getTotalArea()!=null) {
							eolinkParMng.setDbl(premisEol, "Площадь.Общая", t.getTotalArea().doubleValue());
						}
					} else if (premisEol == null) {
						// Не найдено, создать помещение
						AddrTp addrTp = lstMng.getAddrTpByCD("Квартира");
						premisEol = new Eolink(reu, kul, nd, Utl.lpad(t.getPremisesNum(), "0", 7), null, null,
								null, null, t.getPremisesGUID(), t.getPremisesUniqueNumber(), null, addrTp, foundTask2.getAppTp(), null, null, null);
						em.persist(premisEol);
						if (t.getTotalArea()!=null) {
							eolinkParMng.setDbl(premisEol, "Площадь.Общая", t.getTotalArea().doubleValue());
						}
					}
				}));
				
			}

			// Установить статус выполнения задания
			foundTask.setState("ACP");
		}
			
	}

	
	public void exportAccountData() {
		ExportAccountRequest req = new ExportAccountRequest();
		req.setVersion(req.getVersion());
		req.setId("foo");
		
		// Установить PPGUID
		String ppGuid = "b21dadf0-e7e6-4824-aa04-19bd617bb3e1";
		sb.setPpGuid(ppGuid);
		
		//req.setFIASHouseGuid("a209e075-f304-4d1a-a15a-f723b6c2dd4e"); // здесь есть лиц.счета
		req.setFIASHouseGuid("0cca0a4b-1f3f-43c7-bb6b-1790955b1728");

		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		String errStr = null;

		AckRequest ack = null;
		
		try {
			ack = port.exportAccountData(req);
		} catch (ru.gosuslugi.dom.schema.integration.house_management_service_async.Fault e1) {
			e1.printStackTrace();
			err = true;
			errMainStr = e1.getFaultInfo().getErrorMessage();
			log.info("Error main={}", errMainStr);
		}

		RetState retState = null;
    	if (!err) {
    		retState = getState(ack);
			retState.getState().getExportAccountResult().stream().forEach(t -> {
				log.info("Лиц счет GUID={}, number={}", t.getAccountGUID(), t.getAccountNumber());
			});
		}
		
		
	}

		
	/**
	 * Импортировать лицевой счет
	 * @return 
	 * @throws WrongGetMethod 
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap {
		Task foundTask = null;
		foundTask = em.find(Task.class, task.getId());
		// Тип объекта
		String objTp = foundTask.getEolink().getObjTp().getCd();

		ImportAccountRequest req = new ImportAccountRequest();
		req.setVersion(req.getVersion());
		req.setId("foo");
		
		// Установить PPGUID
		String ppGuid = eolinkMng.getEolinkByReuKulNdTp(task.getEolink().getReu(), null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);
		
		Task foundTask2 = foundTask;
		taskDao.getByTaskAddrTp(foundTask, "ЛС", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_ACC"))
		.forEach(Errors.rethrow().wrap(t-> {
			// Обработать все лиц.счета в дочерних заданиях
			Account ac = new Account();
			req.getAccount().add(ac);
			try {
				ac.setCreationDate(Utl.getXMLDate(teParMng.getDate(t, "ГИС ЖКХ.Дата начала действия")));
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
				throw new CantPrepSoap("Ошибка при конвертации даты!");
			}
			ac.setLivingPersonsNumber((byte) 7);
			ac.setTotalSquare(new BigDecimal("100"));
			ac.setHeatedArea(new BigDecimal("100"));
			ac.setIsUOAccount(true);
			
			// Транспортный GUID
			String tguid = Utl.getRndUuid().toString();
	    	t.setTguid(tguid);
			ac.setTransportGUID(tguid);
			
			Accommodation acm = new Accommodation();
	
			// Использовать GUID родительского объекта
			String objGuid = foundTask2.getEolink().getParEolink().getGuid();
			if (objTp.equals("Дом")) {
				acm.setFIASHouseGuid(objGuid);
			} else if (objTp.equals("ЛС")) {
				acm.setPremisesGUID(objGuid);
			}
			ac.getAccommodation().add(acm );
			// № лицевого счета
			ac.setAccountNumber(foundTask2.getEolink().getLsk());
	
			PayerInfo pf = new PayerInfo();
			AccountIndType ind = new AccountIndType();
			ind.setFirstName("val");
			ind.setSurname("val");
			ind.setPatronymic("val");
			pf.setInd(ind );
			ac.setPayerInfo(pf);
			
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
				String closeReason = taskParMng.getStr(t, "ГИС ЖКХ.Причина закрытия");
				closedTp.setCloseReason(ulistMng.getNsiElem("NSI", 22, "Причина закрытия лицевого счета", closeReason));
				closedTp.setDescription(closeReason);
				ac.setClosed(closedTp);
	    	}
		
		}));	
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
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			foundTask.setState("ACK");
			foundTask.setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
		
	}
	
	
	/**
	 * Получить результат импорта лицевого счета
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void importAccountDataAck(Task task) {
		Task foundTask = em.find(Task.class, task.getId());
		
		Eolink houseEol = foundTask.getEolink();
		String reu = houseEol.getReu();
		// Установить PPGUID
		String ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);

		// получить состояние
		GetStateResult retState = getState2(foundTask);

		if (!foundTask.getState().equals("ERR") && !foundTask.getState().equals("ERS")) {
			retState.getImportResult().stream().forEach(t -> {
				t.getCommonResult().stream().forEach(d -> {
					// Найти элемент задания по Транспортному GUID
					Task task2 = taskMng.getByTguid(task, d.getTransportGUID());
					// Переписать значения параметров в eolink из task
					teParMng.acceptPar(task2);

					// Есть дата обновления, установить GUID
					task2.setState("ACP");
					task2.setGuid(d.getGUID());
					task2.setUn(d.getUniqueNumber());
					task2.setUpdDt(Utl.getDateFromXmlGregCal(d.getUpdateDate()));
					// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
					taskMng.setEolinkIdf(task2.getEolink(), d.getGUID(), d.getUniqueNumber());
				});
			});
			
			// Установить статус выполнения задания
			foundTask.setState("ACP");
			
		}
	}
	
		
	/*
	 * Обновление объектов дома
	 * 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Boolean importHouseUOData(Task task) throws WrongGetMethod {

		Task foundTask = em.find(Task.class, task.getId());
		ImportHouseUORequest req = new ImportHouseUORequest();
		req.setId("foo");
		req.setVersion(req.getVersion());
		sb.setSign(true);
		// Установить PPGUID
		String ppGuid = eolinkMng.getEolinkByReuKulNdTp(foundTask.getEolink().getReu(), null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);

		ApartmentHouse ah = new ApartmentHouse();

		// установить базовые параметры
		if (foundTask.getAct().getCd().equals("GIS_ADD_HOUSE")){
	    	// Добавить дом
			log.info("Добавление дома, Task.id={}", foundTask.getId());
	    	BasicCharacteristicts bc = new BasicCharacteristicts();
			Double totSqr = taskParMng.getDbl(foundTask, "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
	    	bc.setTotalSquare(BigDecimal.valueOf(totSqr));

	    	Date dtBuild = taskParMng.getDate(foundTask, "ГИС ЖКХ.Дата постройки");
			String dtBuiltStr = Utl.getStrFromDate(dtBuild);
			dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length()-4, dtBuiltStr.length());
			Integer usedYear = Integer.valueOf(dtBuiltStr);
	    	bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());
	    	
	    	Double cult = taskParMng.getDbl(foundTask, "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
	    	bc.setCulturalHeritage((cult==1d) ? true : false );
	    	
	    	// установить часовую зону
	    	bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 30, "Часовая зона", "Asia/Novokuznetsk"));
			
	    	Double et = taskParMng.getDbl(foundTask, "Количество этажей, наибольшее(1-11)");
	    	bc.setFloorCount(String.valueOf(et));
	    	
	    	// нет связи с росреестром TODO
	    	bc.setNoRSOGKNEGRPRegistered(true);

	    	// установить ОКТМО
	    	OKTMORefType oktmo = new OKTMORefType();  
			String oktmo2 = taskParMng.getStr(foundTask, "ГИС ЖКХ.ОКТМО");

	    	oktmo.setCode(oktmo2);
	    	oktmo.setName(oktmo2);
	    	bc.setOKTMO(oktmo);
	    	
	    	// установить состояние объекта 
	    	ApartmentHouseToCreate ac = new ApartmentHouseToCreate();
			String state = taskParMng.getStr(foundTask, "ГИС ЖКХ.Состояние");
	    	bc.setState(ulistMng.getNsiElem("NSI", 24, "Состояние дома", state));

			Double underEt = taskParMng.getDbl(foundTask, "ГИС ЖКХ.Количество подземных этажей");
	    	ac.setUndergroundFloorCount(String.valueOf(underEt));

			Double etMin = taskParMng.getDbl(foundTask, "Количество этажей, наименьшее(1-10)");
			Integer etMin2 = etMin.intValue();
	    	ac.setMinFloorCount(etMin2.byteValue());

	    	String tguid = Utl.getRndUuid().toString();
	    	foundTask.setTguid(tguid);
	    	ac.setTransportGUID(tguid);

	    	ac.setBasicCharacteristicts(bc);
	    	ah.setApartmentHouseToCreate(ac);
	    	
		} else if (foundTask.getAct().getCd().equals("GIS_UPD_HOUSE")){
	    	// Обновить дом
			log.info("Обновление дома, Task.id={}", foundTask.getId());
	    	HouseBasicUpdateUOType bc = new HouseBasicUpdateUOType();
	       	bc.setFIASHouseGuid(foundTask.getEolink().getGuid());
			Double totSqr = teParMng.getDbl(foundTask, "ГИС ЖКХ.Общая площадь жилых помещений по паспорту помещения");
	    	bc.setTotalSquare(BigDecimal.valueOf(totSqr));
			
	    	Date dtBuild = teParMng.getDate(foundTask, "ГИС ЖКХ.Дата постройки");
			String dtBuiltStr = Utl.getStrFromDate(dtBuild);
			dtBuiltStr = dtBuiltStr.substring(dtBuiltStr.length()-4, dtBuiltStr.length());
			Integer usedYear = Integer.valueOf(dtBuiltStr);
	    	bc.setUsedYear(BigDecimal.valueOf(usedYear).shortValue());

	    	Double cult = teParMng.getDbl(foundTask, "ГИС ЖКХ.Наличие статуса объекта культурного наследия");
	    	bc.setCulturalHeritage((cult==1d) ? true : false );

	    	// установить часовую зону
	    	bc.setOlsonTZ(ulistMng.getNsiElem("NSI", 30, "Часовая зона", "Asia/Novokuznetsk"));

	    	Double et = teParMng.getDbl(foundTask, "Количество этажей, наибольшее(1-11)");
	    	bc.setFloorCount(String.valueOf(et));
	    	
	    	// нет связи с росреестром TODO
	    	bc.setNoRSOGKNEGRPRegistered(true);

	    	// установить ОКТМО
	    	OKTMORefType oktmo = new OKTMORefType();  
			String oktmo2 = teParMng.getStr(foundTask, "ГИС ЖКХ.ОКТМО");

	    	oktmo.setCode(oktmo2);
	    	oktmo.setName(oktmo2);
	    	bc.setOKTMO(oktmo);
	    	
	    	// установить состояние объекта 
			String state = teParMng.getStr(foundTask, "ГИС ЖКХ.Состояние");
	    	bc.setState(ulistMng.getNsiElem("NSI", 24, "Состояние дома", state));

	    	ApartmentHouseToUpdate ac = new ApartmentHouseToUpdate();
	    	
			Double underEt = teParMng.getDbl(foundTask, "ГИС ЖКХ.Количество подземных этажей");
	    	ac.setUndergroundFloorCount(String.valueOf(underEt));

			Double etMin = teParMng.getDbl(foundTask, "113ГС-ЭПМД-1.1-17.6.-Количество этажей, наименьшее");
			Integer etMin2 = etMin.intValue();
	    	ac.setMinFloorCount(etMin2.byteValue());
	    	
	    	String tguid = Utl.getRndUuid().toString();
	    	foundTask.setTguid(tguid);
	    	log.info("Установлен house TGUID={}", tguid);
	    	ac.setTransportGUID(tguid);

	    	ac.setBasicCharacteristicts(bc);
	    	ah.setApartmentHouseToUpdate(ac);
		}
    	
		// Добавить подъезды
		taskDao.getByTaskAddrTp(foundTask, "Подъезд", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_ENTRY"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление подъезда, Task.id={}", t.getId());
	    	EntranceToCreate ec = new EntranceToCreate();
	    	String entryNum = String.valueOf(t.getEolink().getEntry());
	    	ec.setEntranceNum(entryNum);

	    	// год постройки 
			Date dtEntrBuild = taskParMng.getDate(t, "ГИС ЖКХ.Дата постройки");
			String dtEntrBuiltStr = Utl.getStrFromDate(dtEntrBuild);
			dtEntrBuiltStr = dtEntrBuiltStr.substring(dtEntrBuiltStr.length()-4, dtEntrBuiltStr.length());
			ec.setCreationYear(Short.valueOf(dtEntrBuiltStr));
	    	
			// этажность
			Double etEntr = taskParMng.getDbl(t, "Количество этажей, наибольшее(1-11)");
			ec.setStoreysCount(etEntr.byteValue());
	    	
			// Трансп. GUID
	    	String tguid = Utl.getRndUuid().toString();
	    	t.setTguid(tguid);
	    	ec.setTransportGUID(t.getTguid());

	    	ah.getEntranceToCreate().add(ec);
		}));
		// Обновить подъезды
		taskDao.getByTaskAddrTp(foundTask, "Подъезд", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_ENTRY"))
		.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление подъезда, Task.id={}", t.getId());
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
		taskDao.getByTaskAddrTp(foundTask, "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_PRMS_RSD"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление жилого помещения, Task.id={}", t.getId());
			ResidentialPremises rp = new ResidentialPremises(); 
	    	ResidentialPremisesToCreate rc = 
	    			new ResidentialPremisesToCreate(); 
	
			// Тип - отдельная квартира
	    	rc.setPremisesCharacteristic(ulistMng.getNsiElem("NSI", 30, "Характеристика помещения", 
	    			"Отдельная квартира"));
	    	// Ключ связи с ГКН/ЕГРП отсутствует.
	    	rc.setNoRSOGKNEGRPRegistered(true);
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));
	    	// Номер подъезда
	    	String entryNum = String.valueOf(t.getEolink().getEntry());
	    	rc.setEntranceNum(entryNum);
			// Общая площадь
			Double totalArea = taskParMng.getDbl(t, "Площадь.Общая");
	    	rc.setTotalArea(BigDecimal.valueOf(totalArea));

			// Жилая площадь
			Double grossArea = taskParMng.getDbl(t, "Площадь.Жилая");
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
		taskDao.getByTaskAddrTp(foundTask, "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_ADD_PRMS_NORSD"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление НЕжилого помещения, Task.id={}", t.getId());
			NonResidentialPremises rp = new NonResidentialPremises(); 
			NonResidentialPremiseToCreate rc = 
	    			new NonResidentialPremiseToCreate();

	    	// Ключ связи с ГКН/ЕГРП отсутствует.
	    	rc.setNoRSOGKNEGRPRegistered(true);
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(), "0"));

    		String commProp = taskParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");
	    	rc.setIsCommonProperty(commProp.equals("Да") ? true: false);
	    	
	    	// Общая площадь
			Double totalArea = taskParMng.getDbl(t, "Площадь.Общая");
	    	rc.setTotalArea(BigDecimal.valueOf(totalArea));

			// Транспортный GUID
	    	String tguid = Utl.getRndUuid().toString();
	    	t.setTguid(tguid);
	    	rc.setTransportGUID(t.getTguid());
	    	
			ah.getNonResidentialPremiseToCreate().add(rc);
		}));

		// Обновить жилое помещение(ия)
		taskDao.getByTaskAddrTp(foundTask, "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_PRMS_RSD"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление жилого помещения, Task.id={}", t.getId());
			ResidentialPremises rp = new ResidentialPremises(); 
	    	ResidentialPremisesToUpdate rc = 
	    			new ResidentialPremisesToUpdate(); 
			// Тип - отдельная квартира
	    	rc.setPremisesCharacteristic(ulistMng.getNsiElem("NSI", 30, "Характеристика помещения", 
	    			"Отдельная квартира"));
	    	// Ключ связи с ГКН/ЕГРП отсутствует.
	    	rc.setNoRSOGKNEGRPRegistered(true);
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(),"0"));
	    	// Номер подъезда
	    	String entryNum = String.valueOf(t.getEolink().getEntry());
	    	rc.setEntranceNum(entryNum);
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
	    	// Дата закрытия, если установлено 
	    	Date dtTerminate = teParMng.getDate(t, "ГИС ЖКХ.Дата закрытия");
	    	if (dtTerminate != null) {
		    	rc.setTerminationDate(Utl.getXMLDate(dtTerminate));
	    	}
	    	
			
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
		taskDao.getByTaskAddrTp(foundTask, "Квартира", null).stream().filter(t-> t.getAct().getCd().equals("GIS_UPD_PRMS_NORSD"))
			.forEach(Errors.rethrow().wrap(t-> {
			log.info("Обновление НЕжилого помещения, Task.id={}", t.getId());
			NonResidentialPremises rp = new NonResidentialPremises(); 
			NonResidentialPremiseToUpdate rc = 
	    			new NonResidentialPremiseToUpdate(); 
	    	// Ключ связи с ГКН/ЕГРП отсутствует.
	    	rc.setNoRSOGKNEGRPRegistered(true);
	    	// Номер помещения
	    	rc.setPremisesNum(Utl.ltrim(t.getEolink().getKw(),"0"));
    		String commProp = teParMng.getStr(t, "Помещение, сост.общ.имущ.МКД");
	    	
	    	rc.setIsCommonProperty(commProp.equals("Да") ? true: false);
	    	
	    	// Дата закрытия, если установлено 
	    	Date dtTerminate = teParMng.getDate(t, "ГИС ЖКХ.Дата закрытия");
	    	if (dtTerminate != null) {
		    	rc.setTerminationDate(Utl.getXMLDate(dtTerminate));
	    	}

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
			foundTask.setState("ERR");
			foundTask.setResult("Ошибка при отправке XML: "+errMainStr);
		} else {
			// Установить статус "Запрос статуса"
			foundTask.setState("ACK");
			foundTask.setMsgGuid(ack.getAck().getMessageGUID());
		}
		return err;
	}

	/**
	 * Получить результат отправки обновления объектов дома
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void importHouseUODataAck(Task task) {
		Task foundTask = em.find(Task.class, task.getId());
		
		Eolink houseEol = foundTask.getEolink();
		String reu = houseEol.getReu();
		// Установить PPGUID
		String ppGuid = eolinkMng.getEolinkByReuKulNdTp(reu, null, null, null, null, "Организация").getGuid();
		sb.setPpGuid(ppGuid);

		// получить состояние
		GetStateResult retState = getState2(foundTask);

		if (!foundTask.getState().equals("ERR") && !foundTask.getState().equals("ERS")) {
			foundTask.setState("ACP");
			Task foundTask2 = foundTask;
			Boolean err = false;
			retState.getImportResult().stream().forEach(t-> {
				t.getCommonResult().forEach( d-> {
						
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
							
							// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
							taskMng.setEolinkIdf(task2.getEolink(), d.getGUID(), d.getUniqueNumber());
							log.info("После отправки XML, по TGUID={} получены: UnqNum={}, GUID={}", 
									d.getTransportGUID(), d.getUniqueNumber(), d.getGUID());
						}
				});
			}); 
			
		}
		
	}
}
