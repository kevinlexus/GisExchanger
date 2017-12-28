package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.List;

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
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.SoapConfigs;
import com.ric.st.builder.HcsBillsAsyncBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest.SupplierIDs;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.PaymentDocument;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.PaymentInformation;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption.Volume;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.ChargeInfo;
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@Slf4j
@Service
public class HcsBillsAsyncBuilder implements HcsBillsAsyncBuilders {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private TaskEolinkParMng teParMng;
	@Autowired
	private ReqProps reqProp;
	
	private BillsServiceAsync service;
	private BillsPortsTypeAsync port;
	private SoapBuilder sb;
	
	/**
	 * Инициализация
	 */
	@Override
	public void setUp() throws CantSendSoap {
		service = new BillsServiceAsync();
    	port = service.getBillsPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true);

		// логгинг запросов
    	sb.setTrace(false);
	}


	/**
	 * Получить состояние запроса
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public ru.gosuslugi.dom.schema.integration.bills.GetStateResult getState2(Task task) {
		
		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		
		sb.makeRndMsgGuid();
		try {
			state = port.getState(gs);
		} catch (ru.gosuslugi.dom.schema.integration.bills_service_async.Fault e) {
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
			
			for (CommonResultType e : state.getImportResult()) {
					for (Error f: e.getError()) {	
						// Найти элемент задания по Транспортному GUID
						Task task2 = taskMng.getByTguid(task, e.getTransportGUID());
						// Установить статусы ошибки по заданиям
						task2.setState("ERR");
						errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
						task2.setResult(errStr);
						log.error(errStr);

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
	 * Экспорт извещений о принятии к исполнению распоряжений с результатами квитирования
	 * @param task - задание 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, экспорт изввещений о принятии к исполнению распоряжений с результатами квитирования, вызов", task.getId());
		
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportNotificationsOfOrderExecutionRequest req = new ExportNotificationsOfOrderExecutionRequest(); 
		
		req.setId("foo");
		req.setVersion(req.getVersion());
 
		SupplierIDs suppId = new SupplierIDs();
		req.setSupplierIDs(suppId);
		suppId.setPaymentDocumentID("20КМ615992-01-7104");
		
		try {
			ack = port.exportNotificationsOfOrderExecution(req);
		} catch (ru.gosuslugi.dom.schema.integration.bills_service_async.Fault e) {
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
	 * Получить результат экспорта извещений о принятии к исполнению распоряжений с результатами квитирования
	 * @param task - задание
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, экспорт изввещений о принятии к исполнению распоряжений с результатами квитирования, запрос ответа", task.getId());
		// Трассировка XML
		sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);	
		// получить состояние
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			retState.getExportNotificationsOfOrderExecutionResult().forEach(t-> {
				t.getNotificationOfOrderExecutionWithStatus().forEach(d-> {
					log.info("getNotificationsOfOrderExecutionGUID={}", d.getNotificationsOfOrderExecutionGUID());
				});
			});
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			
		}
	}

	/**
	 * Импорт платежного документа - запрос
	 * @param task - задание 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, импорт платежного документа, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ImportPaymentDocumentRequest req = new ImportPaymentDocumentRequest(); 

		req.setId("foo");
		req.setVersion(req.getVersion());

		addPaymentDocument(task, req);
		
		try {
			ack = port.importPaymentDocumentData(req);
		} catch (ru.gosuslugi.dom.schema.integration.bills_service_async.Fault e) {
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


	private void addPaymentDocument(Task task, ImportPaymentDocumentRequest req) {
		PaymentDocument pd = new PaymentDocument();
		//String accGuid = "e8b19c33-4af1-4702-af14-0d0b24c9dc9e";
		String accGuid = "da94975c-d9e5-4f87-bdac-6705c7aaf437";
		
		pd.setAccountGuid(accGuid );
		pd.setPaymentDocumentNumber("KKK-2");
		
		ChargeInfo chrgInfo = new ChargeInfo();

		// жилищная услуга
		HousingService housService = new HousingService();
		chrgInfo.setHousingService(housService);
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		// @param rate - расценка
		// @param totalAccount - всего начислено за расчетный период (без перерасчетов и льгот), руб.
		// @param totalPay - итого к оплате за расчетный период, руб.
		chrgInfo.setHousingService(addHousingService(task, "Вид жилищной  услуги", "Плата за содержание жилого помещения", 
				15.96D, 563.39D, 563.39D, "NO", null));

		// услуги ОИ
		
		// коммунальные услуги
				chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Холодное водоснабжение", 
				30.62D, 153.1D, 153.1D, "NO", null, true));
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Горячее водоснабжение", 
				31.88D, 63.76D, 63.76D, "NO", null, true));
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Электроснабжение", 
				2.21D, 227.63D, 227.63D, "NO", null, true));
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Водоотведение", 
				14.83D, 103.81D, 103.81D, "NO", null, true));
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Вывоз мусора  бытового", 
				0.83D, 29.3D, 29.3D, "NO", null, true));

		// дополнительные услуги
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setAdditionalService(addAdditionalService(task, "Вид дополнительной услуги", "Запирающее устройство (ЗУ)", 
				37D, 37D, 37D, "NO", null));
		
		// документ выставлен
		pd.setExpose(true);
		pd.setTotalPayableByChargeInfo(new BigDecimal("598.07"));
		
		// Транспортный GUID платежного документа
		String tguidPd = Utl.getRndUuid().toString();
		pd.setTransportGUID(tguidPd);
		
		
		req.getPaymentDocument().add(pd);
		req.setMonth(12);
		req.setYear((short) 2017);
		
		PaymentInformation payInfo = new PaymentInformation();
		req.getPaymentInformation().add(payInfo);
		
		payInfo.setBankBIK("043207612");
		payInfo.setOperatingAccountNumber("40821810726000010021");
		
		// Транспортный GUID платежных реквизитов   
		String tguid = Utl.getRndUuid().toString();
		payInfo.setTransportGUID(tguid);
		
		// сослаться на TGUID платежных реквизитов   
		pd.setPaymentInformationKey(tguid);
		
		reqProp.getFoundTask().setTguid(tguidPd);
	}

	/*
	 * добавить жилищную услугу
	 * @param task - задание
	 * @param chrgInfo - строка начисления
	 * @param name - тип услуги
	 * @param s1 - наименование услуги
	 * @param rate - расценка
	 * @param totalAccount - всего начислено за расчетный период (без перерасчетов и льгот), руб.
	 * @param totalPay - итого к оплате за расчетный период, руб.
	 * @param calcExpl - порядок расчетов
	 * @param vol - объемы
	 */
	private HousingService addHousingService(Task task, String name, String s1, 
			Double rate, Double totalAccount, Double totalPay, String calcExpl, List<Volume> vol) {
		NsiRef mres;
		HousingService housService = new HousingService();
		mres = ulistMng.getNsiElem("NSI", 50, name, s1);
		housService.setServiceType(mres);
		housService.setRate(BigDecimal.valueOf(rate));
		// Итого к оплате за расчетный период, руб.
		housService.setTotalPayable(BigDecimal.valueOf(totalPay));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		housService.setAccountingPeriodTotal(BigDecimal.valueOf(totalAccount));
		// Порядок расчетов
		housService.setCalcExplanation(calcExpl);
		
		// Услуги ОИ TODO пока не дописал ред. 12.12.2017
/*		MunicipalResource mr = new MunicipalResource();
		mr.setServiceType(servType);
		// потребление
		mr.setConsumption(consum);
		// расценка
		mr.setRate(value);
		// итого
		mr.setAccountingPeriodTotal(value);
		// нормативы потребления и объемы
		mr.setServiceInformation(value);
		// перерасчеты и льготы
		mr.setServiceCharge(value);
		
		housService.getMunicipalResource().add(mr ); */
		
		
		return housService;
	}
	
	/*
	 * добавить муниципальную услугу
	 * @param task - задание
	 * @param refId - Id справочника
	 * @param chrgInfo - строка начисления
	 * @param name - тип услуги
	 * @param s1 - наименование услуги
	 * @param totalAccount - всего начислено за расчетный период (без перерасчетов и льгот), руб.
	 * @param totalPay - итого к оплате за расчетный период, руб.
	 * @param vol - объемы
	 * @param isMun - муниципальная - True, ОИ - false 
	 */
	private MunicipalService addMunService(Task task, int refId, String name, String s1, 
			Double rate, Double totalAccount, Double totalPay, String calcExpl, List<Volume> vol, boolean isMun) {
		NsiRef mres;
		MunicipalService munService = new MunicipalService();
		mres = ulistMng.getNsiElem("NSI", refId, name, s1, isMun==true? task.getEolink():null);
		Consumption consump = new Consumption();
		if (vol != null && vol.size() != 0) {
			consump.getVolume().addAll(vol);
		}
		if (consump.getVolume().size() != 0) {
			munService.setConsumption(consump);
		}
		munService.setServiceType(mres);
		munService.setRate(BigDecimal.valueOf(rate));
		// Итого к оплате за расчетный период, руб.
		munService.setTotalPayable(BigDecimal.valueOf(totalPay));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		munService.setAccountingPeriodTotal(BigDecimal.valueOf(totalAccount));
		// Порядок расчетов
		munService.setCalcExplanation(calcExpl);
		return munService;
	}

	/*
	 * добавить дополнительную услугу
	 * @param task - задание
	 * @param chrgInfo - строка начисления
	 * @param name - тип услуги
	 * @param s1 - наименование услуги
	 * @param totalAccount - всего начислено за расчетный период (без перерасчетов и льгот), руб.
	 * @param totalPay - итого к оплате за расчетный период, руб.
	 * @param vol - объемы
	 */
	private AdditionalService addAdditionalService(Task task, String name, String s1, 
			Double rate, Double totalAccount, Double totalPay, String calcExpl, List<Volume> vol) {
		NsiRef mres;
		AdditionalService additionalService = new AdditionalService();
		mres = ulistMng.getNsiElem("NSI", 1, name, s1, task.getEolink());
		additionalService.setServiceType(mres);
		additionalService.setRate(BigDecimal.valueOf(rate));
		// Итого к оплате за расчетный период, руб.
		additionalService.setTotalPayable(BigDecimal.valueOf(totalPay));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		additionalService.setAccountingPeriodTotal(BigDecimal.valueOf(totalAccount));
		// Порядок расчетов
		additionalService.setCalcExplanation(calcExpl);
		return additionalService;
	}
	/**
	 * Получить результат импорта платежного документа
	 * @param task - задание
	 * @throws CantPrepSoap 
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importPaymentDocumentDataAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, импорт платежного документа, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);	
		
		// получить состояние
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
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

	
}
