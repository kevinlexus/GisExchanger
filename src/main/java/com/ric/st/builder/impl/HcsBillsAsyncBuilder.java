package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.dao.AchargeDAO;
import com.diffplug.common.base.Errors;
import com.ric.bill.Config;
import com.ric.bill.Utl;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.EolinkMng;
import com.ric.bill.mm.EolinkParMng;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.ServGis;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.Ulist;
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
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource.ServiceInformation;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption.Volume;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.ChargeInfo;
import ru.gosuslugi.dom.schema.integration.bills.ServiceChargeImportType;
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
	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private AflowDAO aflowDao; 
	@Autowired
	private AchargeDAO achargeDao; 
	
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
	 * Импорт платежных документов по дому - запрос
	 * внимание! проверить наличие утверждённого устава, с необходимыми услугами
	 * в т.ч. дополнительными! 
	 * Иначе будет SRV008076 - 
	 * Некорректный состав услуг или некорректное указание реквизитов по услугам
	 * @param task - задание 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, импорт платежных документов по дому, вызов", task.getId());
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
		// Дом
		Eolink house = reqProp.getFoundTask().getEolink();
		// Не более 1000 вхождений
		taskDao.getByTaskAddrTp(task, "Платёжный документ", null).stream().filter(t-> t.getAct().getCd().equals("GIS_IMP_PAY_DOC"))
		.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление платежного документа, Task.id={}", t.getId());
			addPaymentDocument(t, house, req);
		}));
		
		// проверять ли расчет документов?
		req.setConfirmAmountsCorrect(true);
		
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

	/**
	 * Добавление платежного документа
	 * @param task - текущее задание
	 * @param req - запрос
	 */
	private void addPaymentDocument(Task task, Eolink house, ImportPaymentDocumentRequest req) {
		PaymentDocument pd = new PaymentDocument();
		//String accGuid = "e8b19c33-4af1-4702-af14-0d0b24c9dc9e";
		//String accGuid = "da94975c-d9e5-4f87-bdac-6705c7aaf437";
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.2, лс: 64010002
		// String accGuid = "10d522fa-e2da-4f05-8dbc-3625069eeb88";
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.4, лс: 64010004
		//String accGuid = "d2e66464-9836-4776-95db-e4b37ecb4acb";
		// ТСЖ "Красноарм бастион" ул. Красноармейская, 134, кв.6, л.с. 62020006
		//String accGuid = "e8826280-8cb0-4eaf-8641-9a91dcf4f7d9";
		// Организация
		Eolink org = house.getParent();
		// Тип информационной системы
		Integer appTp = org.getAppTp(); 
		// лицевой счет
		Eolink acc = task.getEolink();
		// GUID лицевого счета
		String accGuid = acc.getGuid();
		
		pd.setAccountGuid(accGuid );
		pd.setPaymentDocumentNumber("KKK-1");
		
		List<SumChrgRec> lstSum = null;
		if (appTp==0) {
			// старая разработка
			lstSum = aflowDao.getGrp(acc.getLsk(), "201801", 0);
		} else if (appTp==2) {
			// эксперементальная разработка
			lstSum = achargeDao.getGrp(acc.getLsk(), 201801, 1);
		}
		
		ChargeInfo chrgInfo = new ChargeInfo();

		for (SumChrgRec t: lstSum) {

			if (t.getServGis().getTp().equals(0)) {
				// Тип услуги 0-жилищная (в т.ч. Усл.на ОИ)
				HousingService housService = new HousingService();
				chrgInfo.setHousingService(housService);
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setHousingService(addHousingService(task, t, "NO", lstSum));

			} else if (t.getServGis().getTp().equals(1)) {
				// 1-коммунальная (напр.Х.В.), 
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setMunicipalService(addMunService(task, t, "NO", "M"));

			} else if (t.getServGis().getTp().equals(2)) {
				// 2-дополнительная (напр Замок)
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setAdditionalService(addAdditionalService(task, t, "NO"));
			}

		}


/*
		chrgInfo = new ChargeInfo();
		pd.getChargeInfo().add(chrgInfo);
		chrgInfo.setMunicipalService(addMunService(task, 51, "Главная коммунальная услуга", "Горячее водоснабжение", 
				31.88D, 191.28D, 191.28D, "NO", 6D));
*/
/*		chrgInfo = new ChargeInfo();
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
*/

		
		// документ выставлен
		pd.setExpose(true);
		// Итог к оплате по документу
		pd.setTotalPayableByChargeInfo(new BigDecimal("1281.80"));
		
		// Транспортный GUID платежного документа
		String tguidPd = Utl.getRndUuid().toString();
		pd.setTransportGUID(tguidPd);
		
		req.getPaymentDocument().add(pd);
		req.setMonth(2);
		req.setYear((short) 2018);
		
		PaymentInformation payInfo = new PaymentInformation();
		req.getPaymentInformation().add(payInfo);
		
		payInfo.setBankBIK("043207612");
		payInfo.setOperatingAccountNumber("40703810526020101092");
		
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
	 * @param rec - запись начисления 
	 * @param calcExpl - порядок расчетов
	 */
	private HousingService addHousingService(Task task, SumChrgRec rec, 
			String calcExpl, List<SumChrgRec> lstSum) {
		NsiRef mres;
		HousingService housService = new HousingService();
		// услуга ГИС ЖКХ
		mres = ulistMng.getNsiElem(rec.getServGis().getUlist());
		housService.setServiceType(mres);
		housService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		housService.setAccountingPeriodTotal(BigDecimal.valueOf(rec.getSumma()));
		// Итого к оплате за расчетный период, руб.
		housService.setTotalPayable(BigDecimal.valueOf(rec.getSumma()));
		// Порядок расчетов
		housService.setCalcExplanation(calcExpl);
		
		// РЕСУРСЫ НА ОИ
		for (SumChrgRec t: lstSum.stream() // найти дочерние записи (Усл. на ОИ)
				.filter(e -> e.getServGis().getParent().equals(rec.getServGis()))
				.collect(Collectors.toList())) {

			// услуга ГИС ЖКХ
			NsiRef servType = ulistMng.getNsiElem(t.getServGis().getUlist());
			
			MunicipalResource mr = new MunicipalResource();
			mr.setServiceType(servType);
			ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource.Consumption consum = 
					new	ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource.Consumption();
			
			ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume volume = 
					new ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource.Consumption.Volume();
	
			// способ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
			volume.setDeterminingMethod("N");
			// тип предоставления услуги: (I)ndividualConsumption - индивидульное потребление, house(O)verallNeeds - общедомовые нужды
			volume.setType("O");
			// потребление при содержании общего имущества (м3)
			volume.setValue(BigDecimal.valueOf(t.getVol()));
			consum.setVolume(volume);
			
			// потребление
			mr.setConsumption(consum);
			// Тариф, руб./ед.изм. (для Х.В. на ОИ - это м3) 
			mr.setRate(BigDecimal.valueOf(t.getPrice()));
			// всего начислено за расчетный период, руб (потребление * тариф, округлить!)
			mr.setAccountingPeriodTotal(BigDecimal.valueOf(t.getSumma()));
			
			// Справочная информация
			ServiceInformation servInf = new ServiceInformation();
			// Норматив потребления при содержании общего имущества (м3 на м2)
			servInf.setHouseOverallNeedsNorm(BigDecimal.valueOf(5.01D)); // TODO
			// Суммарный объём коммунальных ресурсов в доме
			// В целях содержания общего имущества
			servInf.setHouseTotalHouseOverallNeeds(BigDecimal.valueOf(4000)); // TODO
			mr.setServiceInformation(servInf );
			// перерасчеты и льготы
			ServiceChargeImportType servChrg = new ServiceChargeImportType();
			servChrg.setMoneyDiscount(BigDecimal.valueOf(0D));
			servChrg.setMoneyRecalculation(BigDecimal.valueOf(0D));
			// К оплате за коммунальный ресурс потребления при содержании общего имущества (расценка на площадь)
			mr.setMunicipalServiceCommunalConsumptionPayable(BigDecimal.valueOf(23.74D)); // TODO
			mr.setServiceCharge(servChrg);
			housService.getMunicipalResource().add(mr ); 
		}
		
		return housService;
	}
	
	/*
	 * добавить муниципальную услугу
	 * @param task - задание
	 * @param rec - запись начисления 
	 * @param detMethod - cпособ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
	 */
	private MunicipalService addMunService(Task task, SumChrgRec rec, String calcExpl, String detMethod) {
		NsiRef mres;
		MunicipalService munService = new MunicipalService();
		// внутренний справочник организации №51
		mres = ulistMng.getNsiElem(rec.getServGis().getUlist());
		Consumption consump = new Consumption();
		
		Volume volume = new Volume();
		
		// Способ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
		volume.setDeterminingMethod(detMethod);
		// Тип предоставления услуги: (I)ndividualConsumption - индивидульное потребление
		volume.setType("I");
		volume.setValue(BigDecimal.valueOf(rec.getVol()));
		
		consump.getVolume().add(volume);
		munService.setConsumption(consump);
		munService.setServiceType(mres);
		munService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// Итого к оплате за расчетный период, руб.
		munService.setTotalPayable(BigDecimal.valueOf(rec.getSumma()));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		munService.setAccountingPeriodTotal(BigDecimal.valueOf(rec.getSumma()));
		// Порядок расчетов
		munService.setCalcExplanation(calcExpl);
		return munService;
	}

	/*
	 * добавить дополнительную услугу
	 * @param task - задание
	 * @param rec - запись начисления 
	 */
	private AdditionalService addAdditionalService(Task task, SumChrgRec rec, String calcExpl) {
		NsiRef mres;
		AdditionalService additionalService = new AdditionalService();
		// внутренний справочник организации №1
		mres = ulistMng.getNsiElem(rec.getServGis().getUlist());
		
		ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService.Consumption consumption =
				new ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService.Consumption();
		ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService.Consumption.Volume volume =
				new ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService.Consumption.Volume();
		// Тип предоставления услуги: (I)ndividualConsumption - индивидульное потребление
		volume.setType("I");
		// Потребление
		volume.setValue(BigDecimal.valueOf(rec.getVol()));
		consumption.getVolume().add(volume);

		additionalService.setConsumption(consumption);
		additionalService.setServiceType(mres);
		additionalService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// Итого к оплате за расчетный период, руб.
		additionalService.setTotalPayable(BigDecimal.valueOf(rec.getSumma()));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		additionalService.setAccountingPeriodTotal(BigDecimal.valueOf(rec.getSumma()));
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
		log.info("******* Task.id={}, импорт платежных документов по дому, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);	
		// Трассировка XML
		sb.setTrace(true);
		
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
