package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
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

import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.PdocDAO;
import com.ric.bill.dto.OrgDTO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.PdocMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Pdoc;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.Ulist;
import com.ric.cmn.Utl;
import com.ric.st.ReqProps;
import com.ric.st.builder.HcsBillsAsyncBuilders;
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
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.bills.CapitalRepairImportType;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest;
import ru.gosuslugi.dom.schema.integration.bills.ExportNotificationsOfOrderExecutionRequest.SupplierIDs;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.PaymentDocument;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.PaymentInformation;
import ru.gosuslugi.dom.schema.integration.bills.ImportPaymentDocumentRequest.WithdrawPaymentDocument;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.AdditionalService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.HousingService.MunicipalResource;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption;
import ru.gosuslugi.dom.schema.integration.bills.PDServiceChargeType.MunicipalService.Consumption.Volume;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.ChargeInfo;
import ru.gosuslugi.dom.schema.integration.bills.PaymentDocumentType.PenaltiesAndCourtCosts;
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
	private OrgMng orgMng;
	@Autowired
	private ChrgMng chrgMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private DebMng debMng;

	@Autowired
	private PdocMng pdocMng;
	@Autowired
	private PdocDAO pdocDao;

	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private PseudoTaskBuilders ptb;

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
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		sb.setTrace(false);
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

			// контроль кол-ва выполнения запроса
			Integer errAckCnt = reqProp.getFoundTask().getErrAckCnt();
			if (errAckCnt.compareTo(1000) < 0) {
				// увеличить на 1 кол-во ошибок
				reqProp.getFoundTask().setErrAckCnt(++errAckCnt);
			} else {
				// ошибка
				log.error("Task.id={}, Превышено количество запросов статуса!", task.getId());
				reqProp.getFoundTask().setState("ERA");
			}

			return null;
		}

		// Показать ошибки, если есть
		if (err) {
			// Ошибки во время выполнения
			log.info(errStr);
			task.setResult(errStr);
			log.error("Task.id={}, ОШИБКА выполнения запроса = {}", task.getId(), errStr);
		} else if (!err && state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
			// Ошибки контролей или бизнес-процесса
			// task.setState("ERR");
			errStr = state.getErrorMessage().getDescription();
			task.setResult(errStr);
			log.error("Task.id={}, ОШИБКА контроля или бизнес-процесса = {}", task.getId(), errStr);
		}
		return state;
	}



	/**
	 * Экспорт извещений о принятии к исполнению распоряжений с результатами квитирования
	 * @param task - задание
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
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
	}


	/**
	 * Получить результат экспорта извещений о принятии к исполнению распоряжений с результатами квитирования
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
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
	public void importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(true);
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		// есть ли ПД (их отмена) на загрузку?
		Boolean isExistJob = false;

		ImportPaymentDocumentRequest req = new ImportPaymentDocumentRequest();

		req.setId("foo");
		req.setVersion(req.getVersion());
		// Дом
		Eolink house = reqProp.getFoundTask().getEolink();

		// получить список незагруженных, действующих ПД в ГИС по Дому
		for (Pdoc t : pdocMng.getPdocForLoadByHouse(house).stream()
				.filter(t-> t.getV().equals(1)) // действующие
				.collect(Collectors.toList())) {
			// добавить не более 1000 вхождений ПД
			log.info("Добавление платежного документа, Pdoc.id={}", t.getId());
			addPaymentDocument(t, house, req);
			isExistJob = true;
		}

		// получить список недействующих ПД, направленных на отмену в ГИС по Дому
		for (Pdoc t : pdocMng.getPdocForLoadByHouse(house).stream()
				.filter(t-> t.getV().equals(0)) // недействующие
				.collect(Collectors.toList())
				) {
			// добавить не более 1000 вхождений ПД
			log.info("Отмена платежного документа, Pdoc.id={}", t.getId());
			// сохранить транспортный GUID ПД
			String tguid = Utl.getRndUuid().toString();
			t.setTguid(tguid);

			WithdrawPaymentDocument wdPd = new WithdrawPaymentDocument();
			wdPd.setPaymentDocumentID(t.getUn());
			wdPd.setTransportGUID(tguid);
			req.getWithdrawPaymentDocument().add(wdPd);
			isExistJob = true;
		}

		// Не включать! Не пойдёт автоматическое квитирование!
		// Считать корректными значения сумм документа, если они расходятся с автоматически рассчитанными
		//req.setConfirmAmountsCorrect(true);

		if (isExistJob) {
			log.info("******* Task.id={}, импорт платежных документов по дому, вызов", task.getId());
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

		} else {
			// Установить статус "Выполнено", так как нечего загружать
			//log.info("Task.id={}, Нет документов для загрузки!", task.getId());
			reqProp.getFoundTask().setState("ACP");
		}

		// сбросить кол-во ошибок запросов Ack
		reqProp.getFoundTask().setErrAckCnt(0);

	}

	/**
	 * Добавление платежного документа
	 * @param pdoc - ПД
	 * @param req - запрос
	 * @throws CantPrepSoap
	 * @throws WrongGetMethod
	 */
	private void addPaymentDocument(Pdoc pdoc, Eolink house, ImportPaymentDocumentRequest req) throws CantPrepSoap, WrongGetMethod {
		PaymentDocument pd = new PaymentDocument();
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.2, лс: 64010002
		// String accGuid = "10d522fa-e2da-4f05-8dbc-3625069eeb88";
		// ТСЖ "Золотые купола", ул. Двужильного, 36а, кв.4, лс: 64010004
		//String accGuid = "d2e66464-9836-4776-95db-e4b37ecb4acb";
		// ТСЖ "Красноарм бастион" ул. Красноармейская, 134, кв.6, л.с. 62020006
		//String accGuid = "e8826280-8cb0-4eaf-8641-9a91dcf4f7d9";
		// Организация
		Eolink uk = house.getParent();
		// лицевой счет
		Eolink acc = pdoc.getEolink();
		// GUID лицевого счета
		String accGuid = acc.getGuid();
		// Тип информационной системы
		Integer appTp = uk.getAppTp();

		// дата ПД (обычно последнее число расчетного месяца)
		Date dt = pdoc.getDt();
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

		// Номер ПД из биллинга
		if (pdoc.getCd() == null) {
			throw new CantPrepSoap("Не заполнен CD документа");
		}
		pd.setPaymentDocumentNumber(pdoc.getCd());

		List<SumChrgRec> lstSum = chrgMng.getChrgGrp(acc.getLsk(), acc.getKoObj(), period, uk);

/*		log.info("Суммы по документу:");
		Double itg = 0D;
		for (SumChrgRec t: lstSum) {
			itg = itg + t.getSumma();
		}
		log.info("Суммы по документу итого={}:", itg);
		log.info(""); */

		// обновить услугами из справочника ГИС
		lstSum.stream().forEach(t-> {
			Ulist ulist = em.find(Ulist.class, t.getUlistId());
			t.setUlist(ulist);
		});

		ChargeInfo chrgInfo = new ChargeInfo();
		// начисления по видам услуг
		for (SumChrgRec t: lstSum) {
			// наименование услуги и т.п.
/*	    	t.getUlist().getChild().forEach(d -> {
		    	log.info("Вид={}, Услуга={}", d.getName(),
		    			d.getS1());
	    	});
			log.info("ПД: lstSum Ulist.id={}, tp={}, summa={}, price={}", t.getUlist().getId(), t.getUlist().getTp(), t.getSumma(), t.getPrice());
*/
			if (t.getUlist().getTp().equals(0)) {
				// Тип услуги 0 - жилищная (в т.ч. Усл.на ОИ)
				HousingService housService = new HousingService();
				chrgInfo = new ChargeInfo();
				chrgInfo.setHousingService(housService);
				chrgInfo.setHousingService(addHousingService(t, "NO", lstSum));
				pd.getChargeInfo().add(chrgInfo);
			} else if (t.getUlist().getTp().equals(1)) {
				// 1 - коммунальная (напр.Х.В., Отопление)
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setMunicipalService(addMunService(t, "NO", "N", appTp));

			} else if (t.getUlist().getTp().equals(2)) {
				// 2 - дополнительная (напр Замок)
				chrgInfo = new ChargeInfo();
				pd.getChargeInfo().add(chrgInfo);
				chrgInfo.setAdditionalService(addAdditionalService(t, "NO"));
			} else if (t.getUlist().getTp().equals(4)) {
				// 4 - капремонт
				if (pd.getCapitalRepairCharge() != null) {
					throw new CantPrepSoap("Не допускается заполнение в ПД услуги Капремонт более одного раза!");
				}
				log.info("ПД: Капремонт цена={}, сумма={}", t.getPrice(), t.getSumma());
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


		BigDecimal pen = debMng.getPenAmnt(acc.getLsk(), acc.getKoObj(), period, uk);
		if (pen.compareTo(BigDecimal.ZERO) != 0) {
			// добавить только в случае суммы <> 0, иначе НЕ сквитируется ПД
			NsiRef servType = ulistMng.getNsiElem("NSI", 329, "Вид начисления", "Пени");
			penCourtCost.setServiceType(servType );
			penCourtCost.setTotalPayable(pen);
			// основание начисления пени (обязательный параметр)
			String penCause = "задолженность";
			penCourtCost.setCause(penCause);
			pd.getPenaltiesAndCourtCosts().add(penCourtCost );
			log.info("ПД: pen={}", pen);
		}

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

		Double totalD = lstSum.stream().filter(t-> !t.getUlist().getTp().equals(4)) // Итог без капремонта!
				.mapToDouble(t -> t.getSumma()).sum();
		BigDecimal totalPeriod = Utl.getBigDecimalRound(totalD, 2);
		log.info("ПД: totalPeriod={}", totalPeriod);
		// сумма к оплате за расчетный период по услугам, руб. (по всем услугам за расчетный период)
		// pd.setTotalPayableByChargeInfo(totalPeriod); ОТКЛЮЧИЛ!

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
		if (pen.compareTo(BigDecimal.ZERO) != 0) {
			pd.setTotalByPenaltiesAndCourtCosts(pen);
		}

		// итого к оплате за расчетный период всего, руб. (по всему платежному документу)
		// pd.setTotalPayableByPD(totalPeriod);  ОТКЛЮЧИЛ!

		// итого к оплате за расчетный период c учетом задолженности/переплаты, руб. (по всему платежному документу)
/*		BigDecimal totalPayableByPd = sal.add(totalPeriod).add(pen);
		log.info("ПД: totalPayableByPDWithDebtAndAdvance={}", totalPayableByPd);
		pd.setTotalPayableByPDWithDebtAndAdvance(totalPayableByPd);  ОТКЛЮЧИЛ!
*/
		// справочная информация. Составляющие стоимости электрической энергии.
		// pd.getComponentsOfCost()

		// оплачено денежных средств, руб (не обязательно) сказано в ГИС, что эта сумма автоматически осуществит квитирование предыдущ. ПД
		//pd.setPaidCash(BigDecimal.valueOf(3444.73D));

		// дата последней поступившей оплаты (не обязательно)
		//pd.setDateOfLastReceivedPayment(value);

		// сохранить транспортный GUID ПД
		String tguid = Utl.getRndUuid().toString();
		pd.setTransportGUID(tguid);
		pdoc.setTguid(tguid);

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
	 * @param rec - запись начисления
	 * @param calcExpl - порядок расчетов
	 */
	private HousingService addHousingService(SumChrgRec rec,
			String calcExpl, List<SumChrgRec> lstSum) {
		NsiRef mres;
		HousingService housService = new HousingService();
		// услуга ГИС ЖКХ
		mres = ulistMng.getNsiElem(rec.getUlist());
		housService.setServiceType(mres);
		// итог по данной услуге (Жилищная услуга + услуги на ОИ)
		log.info("ПД: ЖИЛИЩНАЯ услуга GUID={}, складывается из:", rec.getUlist().getGuid());
		BigDecimal totalSum = BigDecimal.ZERO;
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<SumChrgRec> lst = lstSum.stream()
				.filter(t -> t.getUlist().equals(rec.getUlist())
						|| t.getUlist().getParent2()!=null
						&& t.getUlist().getParent2().equals(rec.getUlist())
						&& t.getUlist().getTp().equals(3)).collect(Collectors.toList());
		// показать составляющие услуги:
	    for (SumChrgRec t : lst) {
	    	log.info("ПД: Услуга:");
	    	t.getUlist().getChild().forEach(d -> {
		    	log.info("Вид={}, Услуга={}", d.getName(),
		    			d.getS1());
	    	});

	    	log.info("ПД: цена={}, сумма={}",
	    			t.getPrice(),
	    			t.getSumma());
			totalSum = totalSum.add(BigDecimal.valueOf(t.getSumma()));
			totalPrice = totalPrice.add(BigDecimal.valueOf(t.getPrice()));
	    }
	    totalSum = new BigDecimal("1045.51");
	    BigDecimal checkSum = BigDecimal.valueOf(rec.getSqr()).multiply(totalPrice);
		log.info("ПД: ИТОГО по Жилищной услуге: площадь={}, цена={}, сумма={}, проверочная сумма={}",
					rec.getSqr(), totalPrice, totalSum, checkSum.setScale(2, RoundingMode.HALF_UP));
		log.info("");

		// всего начислено за расчетный период (без перерасчетов и льгот), руб.
		housService.setAccountingPeriodTotal(totalSum);
		// итого к оплате за расчетный период, руб.
		housService.setTotalPayable(totalSum);
		// порядок расчетов
		housService.setCalcExplanation(calcExpl);
		// цена услуги
		housService.setRate(totalPrice);

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

			log.info("Ресурс на ОИ GUID={}", t.getUlist().getGuid());
			log.info("объем={}", t.getSqr());
			log.info("цена={}", t.getPrice());
			log.info("сумма из базы ={}", t.getSumma());
			log.info("проверочная сумма={}",
					BigDecimal.valueOf(t.getPrice()).multiply(
							Utl.getBigDecimalRound(t.getSqr(), 5))
					);

			// потребление при содержании общего имущества (м2)
//			volume.setValue(new BigDecimal("44.7"));
//			consum.setVolume(volume);
			volume.setValue(BigDecimal.valueOf(t.getSqr()));
			consum.setVolume(volume);

			// потребление
			mr.setConsumption(consum);
			// Тариф, руб./ед.изм. (для Х.В. на ОИ - это м2)
//			mr.setRate(new BigDecimal("2"));
			mr.setRate(BigDecimal.valueOf(t.getPrice()));
			// всего начислено за расчетный период, руб (потребление * тариф)
//			mr.setAccountingPeriodTotal(new BigDecimal("89.4"));
			mr.setAccountingPeriodTotal(BigDecimal.valueOf(t.getSumma()));

			// Справочная информация
/*			ServiceInformation servInf = new ServiceInformation();
			// Норматив потребления при содержании общего имущества (м3 на м2)
			servInf.setHouseOverallNeedsNorm(BigDecimal.valueOf(1D)); // TODO
			// Суммарный объём коммунальных ресурсов в доме
			// В целях содержания общего имущества
			servInf.setHouseTotalHouseOverallNeeds(BigDecimal.valueOf(4000)); // TODO
			mr.setServiceInformation(servInf );*/
			// перерасчеты и льготы
			ServiceChargeImportType servChrg = new ServiceChargeImportType();
			servChrg.setMoneyDiscount(BigDecimal.valueOf(0D));
			servChrg.setMoneyRecalculation(BigDecimal.valueOf(0D));
			// К оплате за коммунальный ресурс потребления при содержании общего имущества (расценка на площадь)
			//mr.setMunicipalServiceCommunalConsumptionPayable(new BigDecimal("89.4")); // TODO
			mr.setMunicipalServiceCommunalConsumptionPayable(BigDecimal.valueOf(t.getSumma())); // TODO
			mr.setServiceCharge(servChrg);
			housService.getMunicipalResource().add(mr );
		}

		return housService;
	}

	/*
	 * добавить муниципальную услугу
	 * @param rec - запись начисления
	 * @param detMethod - cпособ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
	 * @param appTp - тип разработки
	 */
	private MunicipalService addMunService(SumChrgRec rec, String calcExpl, String detMethod, Integer appTp) {
		NsiRef mres;
		MunicipalService munService = new MunicipalService();
		// внутренний справочник организации №51
		mres = ulistMng.getNsiElem(rec.getUlist());
    	log.info("ПД: КОММУНАЛЬНАЯ Услуга: GUID={}", rec.getUlist().getGuid());
    	rec.getUlist().getChild().forEach(d -> {
	    	log.info("Вид={}, Услуга={}", d.getName(),
	    			d.getS1());
    	});

		Consumption consump = new Consumption();
		Volume volume = new Volume();

		// Способ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
		volume.setDeterminingMethod(detMethod);
		// Тип предоставления услуги: (I)ndividualConsumption - индивидульное потребление
		volume.setType("I");

		BigDecimal vol = null;

		// Для Отопления
		//if ()
		if (appTp==0 && Utl.nvl(rec.getUlist().getPrepTp(), 0)==1) {
			// старая разработка и тип подготовки услуги = 1 (только для Отопления)
			// общая площадь
			BigDecimal sqr = Utl.getBigDecimalRound(rec.getSqr(), 5);
			// вспомогательный коэфф
			BigDecimal coeff = Utl.getBigDecimalRound(rec.getCoeff(),5);
			// для отопления: Объем гКал =  м2 * коэфф
			vol = sqr.multiply(coeff);
		} else {
			// прочие разработки
			vol = Utl.getBigDecimalRound(rec.getVol(), 5);
		}

		volume.setValue(vol);
		//volume.setValue(new BigDecimal("5"));
		consump.getVolume().add(volume);
		munService.setConsumption(consump);
		munService.setServiceType(mres);

		BigDecimal checkSum = vol.multiply(BigDecimal.valueOf(rec.getPrice()));
    	log.info("ПД: цена={}, объем={}, сумма={}, проверочная сумма={}",
    			rec.getPrice(), vol, rec.getSumma(), checkSum.setScale(2, RoundingMode.HALF_UP)
    			);
    	log.info("");

		munService.setRate(BigDecimal.valueOf(rec.getPrice()));
		// Итого к оплате за расчетный период, руб.
		munService.setTotalPayable(BigDecimal.valueOf(rec.getSumma()));
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		munService.setAccountingPeriodTotal(BigDecimal.valueOf(rec.getSumma()));

//		log.info("Расчет: vol={}, price={}, amnt={}, summa={}", vol, rec.getPrice(),
//				vol.multiply(BigDecimal.valueOf(rec.getPrice())), rec.getSumma());
		// Порядок расчетов
		munService.setCalcExplanation(calcExpl);
		return munService;
	}

	/*
	 * добавить дополнительную услугу
	 * @param rec - запись начисления
	 */
	private AdditionalService addAdditionalService(SumChrgRec rec, String calcExpl) {
    	log.info("ПД: ДОПОЛНИТЕЛЬНАЯ Услуга: GUID={}", rec.getUlist().getGuid());
    	rec.getUlist().getChild().forEach(d -> {
	    	log.info("Вид={}, Услуга={}", d.getName(),
	    			d.getS1());
    	});
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
		BigDecimal checkSum = BigDecimal.valueOf(rec.getVol()).multiply(BigDecimal.valueOf(rec.getPrice()));
    	log.info("ПД: цена={}, объем={}, сумма={}, проверочная сумма={}",
    			rec.getPrice(), rec.getVol(), rec.getSumma(), checkSum
    			);
    	log.info("");

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
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importPaymentDocumentDataAsk(Task task) throws CantPrepSoap {
		log.info("******* Task.id={}, импорт платежных документов по дому, запрос ответа", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		// Трассировка XML
		sb.setTrace(false);

		// получить состояние
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {

			retState.getImportResult().stream().forEach(t -> {
				// Найти ПД по Транспортному GUID
				Pdoc pdoc = pdocDao.getByTGUID(t.getTransportGUID());

				boolean isErr = false;
				for (Error f: t.getError()) {
					log.error("Произошла ОШИБКА при загрузке Платежного документа Pdoc.id={}", pdoc.getId());
					String errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
					log.error(errStr);
					// пометить документ, что загружен с ошибкой
					pdoc.setErr(1);
					isErr = true;
				};

				if (!isErr) {
					log.info("После импорта платежного документа по Task.id={} и TGUID={}, получены следующие параметры:",
							reqProp.getFoundTask().getId(), t.getTransportGUID());
					log.info("GUID={}, UniqueNumber={}", t.getGUID(), t.getUniqueNumber());
					// записать идентификаторы объекта, полученного от внешней системы (если уже не установлены)
					if (pdoc.getGuid() == null) {
						pdoc.setGuid(t.getGUID());
						pdoc.setUn(t.getUniqueNumber());
					}

					// установить статус, если не было ошибки
					if (pdoc.getStatus().equals(0) && pdoc.getV().equals(1)) {
						// если был "добавлен" и "действующий", то статус - загружен
						pdoc.setStatus(1);
					} else if (pdoc.getStatus().equals(1) && pdoc.getV().equals(0)) {
						// если был "загружен" и "отменен", то статус - отменен
						pdoc.setStatus(2);
					}

				}

			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");

		}
	}

	/**
	 * Проверить наличие заданий на импорт ПД
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicImpPd(Task task) throws WrongParam {
		//log.info("******* Task.id={}, проверка наличия заданий на импорт ПД, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на импорт ПД, если их нет
		String actTp = "GIS_IMP_PAY_DOCS";
		String parentCD = "SYSTEM_RPT_IMP_PD";
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Дом", actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, "STP");
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.info("Добавлено задание на импорт ПД по Дому Eolink.id={}", e.getId());
		};

		// Установить статус выполнения задания
		foundTask.setState("ACP");
		//log.info("******* Task.id={}, проверка наличия заданий импорт ПД, выполнено!", task.getId());
	}


}
