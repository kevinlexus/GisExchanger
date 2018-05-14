package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import com.ric.bill.dto.OrgDTO;
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
import com.ric.st.builder.HcsBillsAsyncBuilders2;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.ChrgMng;
import com.ric.st.mm.DebMng;
import com.ric.st.mm.OrgMng;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.bills.CapitalRepairImportType;
import ru.gosuslugi.dom.schema.integration.bills.DebtImportType;
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
import ru.gosuslugi.dom.schema.integration.bills.PDServiceDebtImportType;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.ChargeInfo;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.PenaltiesAndCourtCosts;
import ru.gosuslugi.dom.schema.integration.bills.ServiceChargeImportType;
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

@Slf4j
@Service
public class HcsBillsAsyncBuilder2 implements HcsBillsAsyncBuilders2 {

	@Autowired
	private ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	UlistMng ulistMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private EolinkParMng parMng;
	@Autowired
	private OrgMng orgMng;
	@Autowired
	private ChrgMng chrgMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private DebMng debMng;
	
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


		// получить ПД по лицевым счетам дома
		
		
		// добавить не более 1000 вхождений ПД
/*		taskDao.getByTaskAddrTp(task, "Платёжный документ", null).stream().filter(t-> t.getAct().getCd().equals("GIS_IMP_PAY_DOC"))
		.forEach(Errors.rethrow().wrap(t-> {
			log.info("Добавление платежного документа, Task.id={}", t.getId());
			addPaymentDocument(t, house, req);
		}));
*/		
		// отзываемые платежные документы 
		// req.getWithdrawPaymentDocument().add(wdPd);
		
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
	 * @param task - текущее задание платежного документа
	 * @param req - запрос
	 * @throws CantPrepSoap 
	 * @throws WrongGetMethod 
	 */
	private void addPaymentDocument(Task task, Eolink house, ImportPaymentDocumentRequest req) throws CantPrepSoap, WrongGetMethod {
		PaymentDocument pd = new PaymentDocument();
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.2, лс: 64010002
		// String accGuid = "10d522fa-e2da-4f05-8dbc-3625069eeb88";
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.4, лс: 64010004
		//String accGuid = "d2e66464-9836-4776-95db-e4b37ecb4acb";
		// ТСЖ "Красноарм бастион" ул. Красноармейская, 134, кв.6, л.с. 62020006
		//String accGuid = "e8826280-8cb0-4eaf-8641-9a91dcf4f7d9";
		// Организация
		Eolink uk = house.getParent();
		// Тип информационной системы
		Integer appTp = uk.getAppTp(); 
		// объект ПД из базы
		Eolink eolPd = task.getEolink();
		// лицевой счет
		Eolink acc = eolPd.getParent();
		// GUID лицевого счета
		String accGuid = acc.getGuid();
		
		// дата ПД (обычно последнее число расчетного месяца)
		Date dt = parMng.getDate(eolPd, "ГИС ЖКХ.Дата ПД");
		if (dt == null) {
			throw new CantPrepSoap("Не заполнена дата Платежного Документа");
		}
		// период ПД в формате YYYYMM
		String period = Utl.getPeriodFromDate(dt);
		// день ПД
		Byte day = Utl.getDay(dt).byteValue();
		// месяц ПД
		Integer month = Integer.valueOf(Utl.ltrim(Utl.getPeriodMonth(period),"0"));
		// год ПД
		Short year = Short.valueOf(Utl.getPeriodYear(period));
		
		// лиц.счет
		pd.setAccountGuid(accGuid);
		if (eolPd.getCd() == null) {
			throw new CantPrepSoap("Не заполнен CD документа");
		}
		// Номер ПД из биллинга
		pd.setPaymentDocumentNumber(eolPd.getCd());
		
		List<SumChrgRec> lstSum = chrgMng.getChrgGrp(acc.getLsk(), acc.getKoObj(), period, uk);
		
		// обновить услугами из справочника ГИС
		lstSum.stream().forEach(t-> {
			Ulist ulist = em.find(Ulist.class, t.getUlistId()); 
			t.setUlist(ulist);
		});
		
		ChargeInfo chrgInfo = new ChargeInfo();
		// начисления по видам услуг
		for (SumChrgRec t: lstSum) {
			log.info("ПД: lstSum Ulist.id={}, tp={}", t.getUlist().getId(), t.getUlist().getTp());
			if (t.getUlist().getTp().equals(0)) {
				log.info("ПД: lstSum Ulist.id={}, tp={}", t.getUlist().getId(), t.getUlist().getTp());
				// Тип услуги 0 - жилищная (в т.ч. Усл.на ОИ)
				HousingService housService = new HousingService();
				chrgInfo = new ChargeInfo();
				chrgInfo.setHousingService(housService);
				chrgInfo.setHousingService(addHousingService(task, t, "NO", lstSum));
				pd.getChargeInfo().add(chrgInfo);
			} else if (t.getUlist().getTp().equals(1)) {
				log.info("ПД: lstSum Ulist.id={}, tp={}", t.getUlist().getId(), t.getUlist().getTp());
				// 1 - коммунальная (напр.Х.В.), 
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setMunicipalService(addMunService(task, t, "NO", "M"));

			} else if (t.getUlist().getTp().equals(2)) {
				log.info("ПД: lstSum Ulist.id={}, tp={}", t.getUlist().getId(), t.getUlist().getTp());
				// 2 - дополнительная (напр Замок)
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setAdditionalService(addAdditionalService(task, t, "NO"));
			} else if (t.getUlist().getTp().equals(4)) {
				// 4 - капремонт
				if (pd.getCapitalRepairCharge() != null) {
					throw new CantPrepSoap("Не допускается заполнение в ПД услуги Капремонт более одного раза!");
				}
				CapitalRepairImportType capRepChrg = new CapitalRepairImportType();
				// размер взноса на кв.м, руб (расценка)
				capRepChrg.setContribution(BigDecimal.valueOf(t.getPrice()));
				capRepChrg.setMoneyRecalculation(BigDecimal.ZERO);
				capRepChrg.setMoneyDiscount(BigDecimal.ZERO);
				// всего начислено за расчетный период (без перерасчетов и льгот), руб.
				capRepChrg.setAccountingPeriodTotal(BigDecimal.valueOf(t.getSumma()));
				// итого к оплате за расчетный период, руб.
				capRepChrg.setTotalPayable(BigDecimal.valueOf(t.getSumma()));
				pd.setCapitalRepairCharge(capRepChrg );
			}

		}
		
		// неустойки и судебные расходы (пени)
		PenaltiesAndCourtCosts penCourtCost = new PenaltiesAndCourtCosts();
		// вид неустойки и судебных расходов. НСИ 329 "Неустойки и судебные расходы":
		//- Пени
		//- Штрафы
		//- Государственные пошлины
		//- Судебные издержки.
		NsiRef servType = ulistMng.getNsiElem("NSI", 329, "Вид начисления", "Пени");
		BigDecimal pen = debMng.getPenAmnt(acc.getLsk(), acc.getKoObj(), period, uk);
		penCourtCost.setServiceType(servType );
		penCourtCost.setTotalPayable(pen);
		// основание начисления пени (обязательный параметр)
		String penCause = "задолженность";
		penCourtCost.setCause(penCause);
		pd.getPenaltiesAndCourtCosts().add(penCourtCost );

		log.info("ПД: pen={}", pen);
		
		// задолженность за предыдущие периоды по капремонту (не обязательный по документации)
		/*DebtImportType capDebt = new DebtImportType();
		capDebt.setMonth(value);
		capDebt.setOrgPPAGUID(value);
		capDebt.setTotalPayable(value);
		capDebt.setYear(value);
		pd.getCapitalRepairDebt().add(capDebt);*/

		// задолженность за предыдущие периоды по услугам (не обязательный по док.)
		/*PDServiceDebtImportType pdServDebt = new PDServiceDebtImportType();
		pdServDebt.setAdditionalService(value);
		pdServDebt.setHousingService(value2 );
		pdServDebt.setMunicipalService(value);
		pd.getChargeDebt().add(pdServDebt);*/
		
		Double totalD = lstSum.stream()
				.mapToDouble(t -> t.getSumma()).sum();
		BigDecimal totalPeriod = Utl.getBigDecimalRound(totalD, 2);
		log.info("ПД: totalPeriod={}", totalPeriod);
		// сумма к оплате за расчетный период по услугам, руб. (по всем услугам за расчетный период)
		pd.setTotalPayableByChargeInfo(totalPeriod);
		
		// получить сальдо на начало периода
		BigDecimal sal = Utl.nvl(debMng.getDebAmnt(acc.getLsk(), acc.getKoObj(), period, uk), BigDecimal.ZERO);
		//BigDecimal sal = BigDecimal.valueOf(1111.11D);
		//BigDecimal sal = BigDecimal.valueOf(0D);
		log.info("ПД: sal={}", sal);
		// задолженность
		BigDecimal debt = BigDecimal.ZERO;
		// аванс
		BigDecimal advnc = BigDecimal.ZERO;
	
		if (sal.compareTo(BigDecimal.ZERO) == 1) {
			debt = sal;
		} else if (sal.compareTo(BigDecimal.ZERO) == -1) {
			advnc = sal; 
		}
		
		// задолженность за предыдущие периоды, руб.
		log.info("ПД: debt={}", debt);
		pd.setDebtPreviousPeriods(debt);
		
		// аванс на начало расчетного периода, руб.
		log.info("ПД: advnc={}", advnc);
		pd.setAdvanceBllingPeriod(advnc);
		
		// сумма к оплате с учетом рассрочки платежа и процентов за рассрочку, руб.
		// рассрочка возможна только при наличии хотя бы одной коммунальной услуги в ПД с рассрочкой.
		// log.info("ПД: totalPeriod={}", totalPeriod);
		// pd.setTotalPiecemealPaymentSum(totalPeriod);

		// учтены платежи, поступившие до указанного числа расчетного периода включительно
		pd.setPaymentsTaken(day);
		
		// итого к оплате по неустойкам и судебным издержкам, руб. (итого по всем неустойкам и судебным издержкам).
		// заполняется только для ПД с типом = Текущий
		pd.setTotalByPenaltiesAndCourtCosts(pen);
		
		// итого к оплате за расчетный период всего, руб. (по всему платежному документу)
		pd.setTotalPayableByPD(totalPeriod);
		
		// итого к оплате за расчетный период c учетом задолженности/переплаты, руб. (по всему платежному документу)
		BigDecimal totalPayableByPd = sal.add(totalPeriod).add(pen);
		log.info("ПД: totalPayableByPDWithDebtAndAdvance={}", totalPayableByPd);
		pd.setTotalPayableByPDWithDebtAndAdvance(totalPayableByPd);

		// справочная информация. Составляющие стоимости электрической энергии.
		// pd.getComponentsOfCost()
		
		// оплачено денежных средств, руб (не обязательно) сказано в ГИС, что эта сумма автоматически осуществит квитирование предыдущ. ПД
		//pd.setPaidCash(BigDecimal.valueOf(3444.73D)); 
		
		// дата последней поступившей оплаты (не обязательно)
		//pd.setDateOfLastReceivedPayment(value);
		
		// транспортный GUID платежного документа
		String tguid = Utl.getRndUuid().toString();
		pd.setTransportGUID(tguid);
		task.setTguid(tguid);
		
		// Идентификатор платежного документа ?????
		// pd.setPaymentDocumentID(value);
		
		req.getPaymentDocument().add(pd);
		req.setMonth(month);
		req.setYear(year);
		
		// платежные реквизиты
		PaymentInformation payInfo = new PaymentInformation();
		req.getPaymentInformation().add(payInfo);
		
		// платежные реквизиты (указать РКЦ здесь)
		OrgDTO orgDto = orgMng.getOrgDTO(uk);
		log.info("ПД: BIK=#{}#", orgDto.getBik());
		payInfo.setBankBIK(orgDto.getBik());
		log.info("ПД: OperAccount=#{}#", orgDto.getOperAcc());
		payInfo.setOperatingAccountNumber(orgDto.getOperAcc());
		
		payInfo.setBankBIK("043207612");
		payInfo.setOperatingAccountNumber("40703810526020101092");
		
		// Транспортный GUID платежных реквизитов   
		String tguidPay = Utl.getRndUuid().toString();
		payInfo.setTransportGUID(tguidPay);
		
		// сослаться на TGUID платежных реквизитов   
		pd.setPaymentInformationKey(tguidPay);
		
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
		mres = ulistMng.getNsiElem(rec.getUlist());
		housService.setServiceType(mres);
		housService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// итог по данной услуге (Жилищная услуга + услуги на ОИ)
		Double total = lstSum.stream()
				.filter(t -> t.getUlist().equals(rec.getUlist()) 
						|| t.getUlist().getParent2()!=null 
						&& t.getUlist().getParent2().equals(rec.getUlist()) 
						&& t.getUlist().getTp().equals(3))
				.mapToDouble(t -> t.getSumma()).sum();
		// всего начислено за расчетный период (без перерасчетов и льгот), руб.
		housService.setAccountingPeriodTotal(Utl.getBigDecimalRound(total,2));
		// итого к оплате за расчетный период, руб.
		housService.setTotalPayable(Utl.getBigDecimalRound(total,2));
		// порядок расчетов
		housService.setCalcExplanation(calcExpl);
		
		
		// РЕСУРСЫ НА ОИ
		for (SumChrgRec t: lstSum.stream() // найти дочерние записи (Усл. на ОИ)
				.filter(e -> e.getUlist().getParent2()!=null && e.getUlist().getParent2().equals(rec.getUlist()))
				.filter(e -> e.getUlist().getTp().equals(3))
				.collect(Collectors.toList())) {

			// услуга ГИС ЖКХ
			NsiRef servType = ulistMng.getNsiElem(t.getUlist());
			
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

			log.info("vol={}", t.getVol());

			// потребление при содержании общего имущества (м3)
			volume.setValue(Utl.getBigDecimalRound(t.getVol(), 5));
			consum.setVolume(volume);
			
			// потребление
			mr.setConsumption(consum);
			// Тариф, руб./ед.изм. (для Х.В. на ОИ - это м3) 
			mr.setRate(BigDecimal.valueOf(t.getPrice()));
			// всего начислено за расчетный период, руб (потребление * тариф, округлить!)
			mr.setAccountingPeriodTotal(Utl.getBigDecimalRound(t.getSumma(),2));
			
			// Справочная информация
			//ServiceInformation servInf = new ServiceInformation();
			// Норматив потребления при содержании общего имущества (м3 на м2)
			//servInf.setHouseOverallNeedsNorm(BigDecimal.valueOf(5.01D)); // TODO
			// Суммарный объём коммунальных ресурсов в доме
			// В целях содержания общего имущества
			//servInf.setHouseTotalHouseOverallNeeds(BigDecimal.valueOf(4000)); // TODO
			//mr.setServiceInformation(servInf );
			// перерасчеты и льготы
			ServiceChargeImportType servChrg = new ServiceChargeImportType();
			servChrg.setMoneyDiscount(BigDecimal.valueOf(0D));
			servChrg.setMoneyRecalculation(BigDecimal.valueOf(0D));
			// К оплате за коммунальный ресурс потребления при содержании общего имущества (расценка на площадь)
			mr.setMunicipalServiceCommunalConsumptionPayable(Utl.getBigDecimalRound(t.getSumma(),2)); // TODO
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
		mres = ulistMng.getNsiElem(rec.getUlist());
		Consumption consump = new Consumption();
		
		Volume volume = new Volume();
		
		// Способ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
		volume.setDeterminingMethod(detMethod);
		// Тип предоставления услуги: (I)ndividualConsumption - индивидульное потребление
		volume.setType("I");
		volume.setValue(Utl.getBigDecimalRound(rec.getVol(), 5));
		
		consump.getVolume().add(volume);
		munService.setConsumption(consump);
		munService.setServiceType(mres);
		munService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// Итого к оплате за расчетный период, руб.
		munService.setTotalPayable(Utl.getBigDecimalRound(rec.getSumma(), 2));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		munService.setAccountingPeriodTotal(Utl.getBigDecimalRound(rec.getSumma(),2));
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
		mres = ulistMng.getNsiElem(rec.getUlist());
		
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
		additionalService.setTotalPayable(Utl.getBigDecimalRound(rec.getSumma(),2));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		additionalService.setAccountingPeriodTotal(Utl.getBigDecimalRound(rec.getSumma(),2));
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
				log.info("После импорта платежного документа по Task.id={} и TGUID={}, получены следующие параметры:", 
						reqProp.getFoundTask().getId(), t.getTransportGUID());
				log.info("GUID={}, UniqueNumber={}", t.getGUID(), t.getUniqueNumber());
				// Найти элемент задания по Транспортному GUID
				Task task2 = taskMng.getByTguid(reqProp.getFoundTask(), t.getTransportGUID());
				
				// Записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
				taskMng.setEolinkIdf(task2.getEolink(), t.getGUID(), t.getUniqueNumber(), 1);

				// Переписать значения параметров в eolink из task (здесь не надо)
				// teParMng.acceptPar(task2);
				task2.setState("ACP");
				
			});
			
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			
		}
	}

	
}
