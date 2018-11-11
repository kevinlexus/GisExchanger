package com.ric.st.builder.impl;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import com.dic.bill.dao.AkwtpDAO;
import com.dic.bill.dao.KartDAO;
import com.dic.bill.dao.KwtpDAO;
import com.dic.bill.mm.EolinkParMng;
import com.dic.bill.model.scott.Akwtp;
import com.dic.bill.model.scott.Kart;
import com.dic.bill.model.scott.Kwtp;
import com.dic.bill.model.scott.KwtpMg;
import com.ric.cmn.excp.ErrorWhileDist;
import com.ric.st.impl.SoapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.dao.PdocDAO;
import com.dic.bill.dto.OrgDTO;
import com.dic.bill.dto.SumChrgRec;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.mm.PdocMng;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Pdoc;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.Ulist;
import com.ric.cmn.Utl;
import com.ric.dto.SumSaldoRecDTO;
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
import ru.gosuslugi.dom.schema.integration.bills.*;
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
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.bills_service_async.BillsServiceAsync;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.payments_base.NotificationOfOrderExecutionExportType;

/**
 * Сервис выставления счетов в ГИС ЖКХ
 * @author lev
 * @version 1.15
 */
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
    private EolinkParMng eolParMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private DebMng debMng;
	@Autowired
	private SoapConfig soapConfig;
	@Autowired
	private PdocMng pdocMng;
	@Autowired
	private PdocDAO pdocDao;
	@Autowired
	private EolinkDAO eolinkDao;
    @Autowired
    private KartDAO kartDao;
	@Autowired
	private KwtpDAO kwtpDao;
	@Autowired
	private AkwtpDAO akwtpDao;
	@Autowired
	private PseudoTaskBuilders ptb;
	@Autowired
	private TaskMng taskMng;

	private BillsPortsTypeAsync port;
	private SoapBuilder sb;

	/**
	 * Инициализация
	 */
	@Override
	public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
		BillsServiceAsync service = new BillsServiceAsync();
    	port = service.getBillsPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		reqProp.setPropBefore(task);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(), reqProp.getHostIp());

		// логгинг запросов
    	sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());

	}


	/**
	 * Получить состояние запроса
	 * @param task - задание
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public ru.gosuslugi.dom.schema.integration.bills.GetStateResult getState2(Task task) {

		// Признак ошибки
		Boolean err = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
		sb.makeRndMsgGuid();
		try {
			state = port.getState(gs);
		} catch (ru.gosuslugi.dom.schema.integration.bills_service_async.Fault e) {
			e.printStackTrace();
			err = true;
			errStr = "Запрос вернул ошибку, смотреть в логе!";
		}

		if (state != null && state.getRequestState() != 3) {
			// вернуться, если задание всё еще не выполнено
			log.info("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());

			// контроль кол-ва выполнения запроса
			Integer errAckCnt = reqProp.getFoundTask().getErrAckCnt();
			if (errAckCnt.compareTo(50000) < 0) {
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
			reqProp.getFoundTask().setResult(errStr);
			reqProp.getFoundTask().setState("ERR");
			log.error("Task.id={}, ОШИБКА выполнения запроса = {}", task.getId(), errStr);
		} else {
			assert state != null;
			if (state.getErrorMessage() != null && state.getErrorMessage().getErrorCode() != null) {
                // Ошибки контролей или бизнес-процесса
                errStr = state.getErrorMessage().getDescription();
                reqProp.getFoundTask().setResult(errStr);
                reqProp.getFoundTask().setState("ERR");
                log.error("Task.id={}, ОШИБКА контроля или бизнес-процесса = {}", task.getId(), errStr);
            }
		}
		return state;
	}



	/**
	 * Экспорт извещений о принятии к исполнению распоряжений с результатами квитирования по Организации
	 * @param task - задание
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		taskMng.logTask(task, true, null);

		// Установить параметры SOAP
		reqProp.setPropAfter(task);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ExportNotificationsOfOrderExecutionRequest req = new ExportNotificationsOfOrderExecutionRequest();

		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());

		// УК
		Eolink uk = reqProp.getFoundTask().getEolink();
		// РКЦ (с параметрами)
		Eolink rkc = uk.getParent();
		// период экспорта
		String period = eolParMng.getStr(rkc, "ГИС ЖКХ.PERIOD_EXP_NOTIF");
		if (period==null) {
			throw new CantPrepSoap("По объекту РКЦ (родительская запись УК) не заполнен параметр " +
					"\"ГИС ЖКХ.Период_экспорта_Извещений\", либо некорректно проставлен PARENT_ID от УК к РКЦ!");
		}
		ExportNotificationsOfOrderExecutionRequest.Notifications notif =
                new ExportNotificationsOfOrderExecutionRequest.Notifications();
		// получить начальную дату выгрузки
		Date dt = getExportDate(period);
		log.info("Экспорт Извещений начиная с даты:{}", dt);
        // начиная с даты
        notif.setDateFrom(Utl.getXMLDate(dt));
        // интервал дней
        notif.setDaysInterval(Byte.valueOf("7"));
        // состояния квитирования
        notif.getAckStatus().add(Byte.valueOf("0")); // ред.29.08.2018 - аннулирован ??? как быть? обратная проводка по ПД? TODO
        notif.getAckStatus().add(Byte.valueOf("1"));
        notif.getAckStatus().add(Byte.valueOf("2"));
        notif.getAckStatus().add(Byte.valueOf("3"));
        notif.getAckStatus().add(Byte.valueOf("4"));
        notif.getAckStatus().add(Byte.valueOf("5"));
        req.setNotifications(notif);

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
			taskMng.logTask(task, false, false);

		} else {
			// Установить статус "Запрос статуса"
			reqProp.getFoundTask().setState("ACK");
			reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
			taskMng.logTask(task, false, true);

		}
	}

	/**
	 * получить начальную дату выгрузки
	 * @param period - период
	 * @return
	 */
	private Date getExportDate(String period) {
		// дата выгрузки
		Integer year = Integer.parseInt(Utl.getPeriodYear(period));
		String strYear = String.valueOf(year);
		Integer month = Integer.parseInt(Utl.getPeriodMonth(period));
		String strMonth = String.valueOf(month);
		// день месяца, начиная с которого произойдет выгрузка (всего таких четыре задания по УК, по дням: 1,8,16,24)
		String strDay = null;
		switch (reqProp.getFoundTask().getAct().getCd()) {
			case ("GIS_EXP_NOTIF_1"): {
				strDay = "01";
				break;
			}
			case ("GIS_EXP_NOTIF_8"): {
				strDay = "08";
				break;
			}
			case ("GIS_EXP_NOTIF_16"): {
				strDay = "16";
				break;
			}
			case ("GIS_EXP_NOTIF_24"): {
				strDay = "24";
				break;
			}
		}
		return Utl.getDateFromStr(strDay.concat(".").concat(strMonth).concat(".").concat(strYear));
	}


	/**
	 * Получить результат экспорта извещений о принятии к исполнению распоряжений с результатами квитирования
	 * @param task - задание
	 * @throws CantPrepSoap - невозможно подготовить SOAP
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap, WrongGetMethod, ErrorWhileDist {
		taskMng.logTask(task, true, null);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
		// Установить параметры SOAP
		reqProp.setPropAfter(task);

		// УК
		Eolink uk = reqProp.getFoundTask().getEolink();
		// РКЦ (с параметрами)
		Eolink rkc = uk.getParent();
		// период экспорта
		String mgTo = eolParMng.getStr(rkc, "ГИС ЖКХ.PERIOD_EXP_NOTIF");
		// период на месяц минус 3, чтобы искать извещение в архиве
		String mgFrom = Utl.addMonths(mgTo, -3);
		// номер компьютера
		final String nkom = "888";
		// номер инкассации
		final Integer nink = 1;
		// код операции
		final String oper = "88";

		// получить состояние
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			List<ExportNotificationsOfOrderExecutionResultType> result =
					retState.getExportNotificationsOfOrderExecutionResult();
			for (ExportNotificationsOfOrderExecutionResultType t: result) {
				List<ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus> notifLst =
						t.getNotificationOfOrderExecutionWithStatus();
				for (ExportNotificationsOfOrderExecutionResultType.NotificationOfOrderExecutionWithStatus e: notifLst) {
					String ackStatus = getStrAckStatus(e.getAckStatus());
					NotificationOfOrderExecutionExportType.OrderInfo orderInfo = e.getOrderInfo();
					String pdocNum = orderInfo.getPaymentDocumentNumber();
					String orderId = orderInfo.getOrderID();
					Date orderDt = Utl.getDateFromXmlGregCal(orderInfo.getOrderDate());
					String pdocId = orderInfo.getPaymentDocumentID();
					// найти ПД в биллинге
					if (pdocNum != null) {
						Pdoc pdoc = pdocDao.getByCD(pdocNum);
						if (pdoc != null) {
							// сумма по ПД
							BigDecimal summa = Utl.nvl(pdoc.getSummaOut(), BigDecimal.ZERO);
							// в т.ч. пеня по ПД
							BigDecimal penya = Utl.nvl(pdoc.getPenyaOut(), BigDecimal.ZERO);
							if (summa.equals(BigDecimal.ZERO) && penya.equals(BigDecimal.ZERO)) {
								throw new ErrorWhileDist("ОШИБКА при распределении Оплаты по ПД биллинг - " +
										"отсутствуют итоговые суммы по ПД №="+pdocNum+
										" Возможно необходимо выполнить экспорт ПД!");
							}
							// получить лиц.счет
							Kart kart = pdoc.getEolink().getKart();
							BigDecimal amount = orderInfo.getAmount();
							BigDecimal amountRub = BigDecimal.ZERO;
							if (amount != null) {
								// привести к формату руб.коп.
								amountRub = amount.divide(BigDecimal.valueOf(100));
							}
							Kwtp kwtp = kwtpDao.getByNumDoc(orderId);
							Akwtp akwtp = null;
							if (kwtp==null) {
								// не найдено в текущем периоде
								akwtp = akwtpDao.getByNumDoc(orderId, mgFrom, mgTo);
							}
							if (kwtp==null && akwtp==null && !ackStatus.equals(1)) {
								// не найдено нигде и не аннулировано в ГИС
								String stMonth = Utl.lpad(String.valueOf(orderInfo.getMonth()), "0", 2);
								String stYear = Utl.lpad(String.valueOf(orderInfo.getYear()), "0", 4);
								String dopl = stYear.concat(stMonth);

								// заголовок платежа
								kwtp = Kwtp.KwtpBuilder.aKwtp()
										.withDt(orderDt)
										.withDopl(dopl)
										.withKart(kart)
										.withNumDoc(orderId)
										.withPdoc(pdoc)
										.withSumma(amountRub)
										.withNkom(nkom)
										.withNink(nink)
										.withDtInk(orderDt) // дата инкассации, такая же, как дата платежа
										.withOper(oper)
										.build();
								// уровень распределения по периодам
								// распределить платеж на сумму оплаты долга и пени
								BigDecimal procPen = BigDecimal.ZERO;
								if (!penya.equals(BigDecimal.ZERO)) {
									procPen = penya.divide(summa, RoundingMode.HALF_UP);
								}
								BigDecimal kwtpPenya = amountRub.multiply(procPen);
								kwtpPenya = kwtpPenya.setScale(2, BigDecimal.ROUND_HALF_UP);
								BigDecimal kwtpSumma = amountRub.subtract(kwtpPenya);
								KwtpMg kwtpMg = KwtpMg.KwtpMgBuilder.aKwtpMg()
										.withDt(orderDt)
										.withDopl(dopl)
										.withKart(kart)
										.withSumma(kwtpSumma)
										.withPenya(kwtpPenya)
										.withKwtp(kwtp)
										.withNkom(nkom)
										.withNink(nink)
										.withDtInk(orderDt) // дата инкассации, такая же, как дата платежа
										.withOper(oper)
										.build();
								em.persist(kwtp);
								em.persist(kwtpMg);
								log.info("Получено Извещение об оплате Order.Id={}, по дате={}, ГИС ID={}, биллинг №={}, " +
												"в статусе={}, по лицевому счету={} сумма={} руб",
										orderId, orderDt, pdocId,
										pdocNum, ackStatus, kart.getLsk(),
										amountRub);
							}
							else if (ackStatus.equals(1)) {
								// аннулировано в ГИС
								if (kwtp!=null && !kwtp.getIsAnnul()) {
									// найдено в текущем периоде и не аннулировано в биллинге, аннулировать!
									annulment(orderId, kwtp.getId(), false);
								} else if (akwtp!=null && !akwtp.getIsAnnul()) {
									// найдено в архивном периоде и не аннулировано в биллинге, аннулировать!
									annulment(orderId, akwtp.getId(), true);
								} else {
									throw new ErrorWhileDist("Нет Платежа в биллинге, в C_KWTP,A_KWTP! " +
											"ОШИБКА аннулирования Извещения об оплате Order.Id="+orderId);
								}
							}

						} else {
							log.error("ОШИБКА! ПД CD={} из Извещения, ГИС ID={},- не найден в биллинге!",
									pdocNum, orderInfo.getPaymentDocumentID(),
									pdocNum);
						}
					}
				}
			}
			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			taskMng.logTask(task, false, true);
		}
	}

	private void annulment(String orderId, Integer kwtpId, boolean isArch) throws ErrorWhileDist {
		StoredProcedureQuery qr;
		if (isArch) {
            qr = em.createStoredProcedureQuery("exs.p_gis.annulment_arch_notif");
        } else {
            qr = em.createStoredProcedureQuery("exs.p_gis.annulment_notif");
        }
		qr.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		qr.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
		qr.setParameter(1, kwtpId);
		qr.execute();
		Integer ret = (Integer) qr.getOutputParameterValue(2);
		if (!ret.equals(0)) {
            throw new ErrorWhileDist(
                    "ОШИБКА аннулирования Извещения об оплате Order.Id="+orderId+
                    " exs.p_gis.annulment"+(isArch==true?"_arch":"")+"_notif вернуло="+ret);
        }
	}

	private String getStrAckStatus(byte status) {
		String ackStatus = null;
		switch (status) {
            case 0 : {
                ackStatus="Не проходил квитирование";
                break;
            }
            case 1 : {
                ackStatus="Аннулирован";
                break;
            }
            case 2 : {
                ackStatus="Сквитирован";
                break;
            }
            case 3 : {
                ackStatus="Частично сквитирован";
                break;
            }
            case 4 : {
                ackStatus="Предварительно сквитирован";
                break;
            }
            case 5 : {
                ackStatus="Отсутствует возможность сквитировать";
                break;
            }
        }
        return ackStatus;
	}

	/**
     * Экспорт ПД, на случай их отсутствия в базе
     * @param task - задание
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    public void exportPaymentDocumentData(Task task) throws CantPrepSoap, WrongGetMethod {
        taskMng.logTask(task, true, null);

        // установить параметры SOAP
        reqProp.setPropAfter(task);
        // трассировка XML
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        AckRequest ack = null;
        // для обработки ошибок
        Boolean err = false;
        String errMainStr = null;
        // дом
        Eolink house = reqProp.getFoundTask().getEolink();
        // УК
		Eolink uk = house.getParent();
		// РКЦ (с параметрами)
		Eolink rkc = uk.getParent();

        ExportPaymentDocumentRequest req = new ExportPaymentDocumentRequest();

        req.setId("foo");
        req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());

		String period = eolParMng.getStr(rkc, "ГИС ЖКХ.PERIOD_EXP_PD");
		if (period==null) {
			throw new CantPrepSoap("По объекту РКЦ (родительская запись УК) не заполнен параметр " +
					"\"ГИС ЖКХ.PERIOD_EXP_PD\", либо некорректно проставлен PARENT_ID от УК к РКЦ!");
		}
		int month = Integer.parseInt(Utl.getPeriodMonth(period));
		Integer year = Integer.parseInt(Utl.getPeriodYear(period));
        // период
        req.setMonth(month);
        req.setYear(year.shortValue());
        // дом
        req.setFIASHouseGuid(house.getGuid());
        // добавить GUID необходимых лиц.счетов
        List<Eolink> lst = new ArrayList<Eolink>();
        house.getChild().stream().filter(p->p.getObjTp().getCd().equals("Подъезд")).forEach(p-> {
            // подъезды
            p.getChild().stream().filter(k->k.getObjTp().getCd().equals("Квартира")).forEach(k-> {
                // квартиры
                k.getChild().stream().filter(s->s.getObjTp().getCd().equals("ЛС")).forEach(s->{
                    // лицевой счет
                    req.getAccountNumber().add(s.getKart().getLsk());
                });
            });
        });

        try {
            ack = port.exportPaymentDocumentData(req);
        } catch (ru.gosuslugi.dom.schema.integration.bills_service_async.Fault e) {
            e.printStackTrace();
            err = true;
            errMainStr = e.getFaultInfo().getErrorMessage();
        }

        if (err) {
            reqProp.getFoundTask().setState("ERR");
            reqProp.getFoundTask().setResult("Ошибка при отправке XML: "+errMainStr);
            taskMng.logTask(task, false, false);

        } else {
            // Установить статус "Запрос статуса"
            reqProp.getFoundTask().setState("ACK");
            reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
            taskMng.logTask(task, false, true);

        }
    }

    /**
     * Получить результат экспорта документов
     * @param task - задание
     * @throws CantPrepSoap - невозможно подготовить SOAP
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    public void exportPaymentDocumentDataAsk(Task task) throws CantPrepSoap {
        taskMng.logTask(task, true, null);

        // Трассировка XML
        sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
        // Установить параметры SOAP
        reqProp.setPropAfter(task);
        // получить состояние
        ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

        if (retState == null) {
            // не обработано
        } else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
            retState.getExportPaymentDocResult().forEach(t-> {
                ExportPaymentDocumentResultType.PaymentDocument paymentDocument = t.getPaymentDocument();
                // найти ПД и обновить статусы
                Pdoc pdoc = pdocDao.getByCD(paymentDocument.getPaymentDocumentNumber());
                Integer month = paymentDocument.getMonth();
                Short year = paymentDocument.getYear();
                String stMonth = Utl.lpad(String.valueOf(month), "0", 2);
                String stYear = Utl.lpad(String.valueOf(year), "0", 4);
                Date dt = Utl.getLastDate(Utl.getDateFromPeriod(stYear.concat(stMonth)));

                if (pdoc != null) {
                    if (pdoc.getUn() == null) {
                        // по каким то причинам пустой ID документа в биллинге, заполнить его
                        log.trace("по каким то причинам пустой ID документа в ГИС, заполнить его PaymentDocumentID={}",
                                paymentDocument.getPaymentDocumentID());
                        pdoc.setUn(paymentDocument.getPaymentDocumentID());
                    }
                    if (Utl.nvl(paymentDocument.isWithdraw(), false) && !pdoc.getStatus().equals(2)) {
                        // отменён в ГИС, но не отменён в биллинге - отменить
                        pdoc.setStatus(2);
                        pdoc.setV(0);
                        log.trace("Не был отменен в биллинге, отменен при экспорте!");
                        pdoc.setComm("Не был отменен в биллинге, отменен при экспорте!");
                    } else if (!Utl.nvl(paymentDocument.isWithdraw(), false) && !pdoc.getStatus().equals(1)) {
                        // активный в ГИС, но отменен в биллинге - исправить
                        pdoc.setStatus(1);
                        pdoc.setV(1);
                        log.trace("Был отменен в биллинге, отмечен как \"Загружен\" при экспорте!");
                        pdoc.setComm("Был отменен в биллинге, отмечен как \"Загружен\" при экспорте!");
                    }
                    // итого долг, в т.ч. пеня
                    pdoc.setSummaOut(paymentDocument.getTotalPayableByPDWithDebtAndAdvance());
                    // итого пеня
                    pdoc.setPenyaOut(paymentDocument.getTotalByPenaltiesAndCourtCosts());
                    // дата ПД
                    pdoc.setDt(dt);
                } else {
                    // вообще нет документа в биллинге - создать
                    if (!Utl.nvl(paymentDocument.isWithdraw(), false)) {
                        // только активные ПД - найти лс
                        Eolink acc = eolinkDao.getEolinkByGuid(paymentDocument.getAccountGuid());
                        if (acc!=null) {
                                pdoc = Pdoc.PdocBuilder.aPdoc()
                                        .withEolink(acc)
                                        .withCd(paymentDocument.getPaymentDocumentNumber())
                                        .withUn(paymentDocument.getPaymentDocumentID())
                                        .withStatus(1) // статус - загруженный
                                        .withV(1) // действующий
                                        .withComm("Не был обнаружен в биллинге, создан при экспорте!")
                                        .withSummaOut(paymentDocument.getTotalPayableByPDWithDebtAndAdvance()) // итого долг, в т.ч. пеня
                                        .withPenyaOut(paymentDocument.getTotalByPenaltiesAndCourtCosts()) // итого пеня
                                        .withDt(dt)
                                        .build();
                                em.persist(pdoc);
                            log.trace("Не был обнаружен в биллинге, создан при экспорте! CD={}, Un={}",
                                    paymentDocument.getPaymentDocumentNumber(),
                                    paymentDocument.getPaymentDocumentID()
                                    );
                        } else {
                            log.error("По экспортируемому ПД PaymentDocumentNumber={}, " +
                                    "PaymentDocumentID={}, не найден лицевой счет с GUID={}!",
                                    paymentDocument.getPaymentDocumentNumber(),
                                    paymentDocument.getPaymentDocumentID(),
                                    paymentDocument.getAccountGuid()
                                    );
                        }
                    }
                }
            });

            // Установить статус выполнения задания
            reqProp.getFoundTask().setState("ACP");
            taskMng.logTask(task, false, true);


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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		taskMng.logTask(task, true, null);
		// Установить параметры SOAP
		reqProp.setPropAfter(task);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));
		AckRequest ack = null;
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		// есть ли ПД (их отмена) на загрузку?
		Boolean isExistJob = false;

		ImportPaymentDocumentRequest req = new ImportPaymentDocumentRequest();

		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());
		// Дом
		Eolink house = reqProp.getFoundTask().getEolink();
        // Организация
        Eolink uk = house.getParent();
		Boolean isConfirmCorrect = eolParMng.getBool(uk, "ГИС ЖКХ.CONFIRM_CORRECT");
		if (isConfirmCorrect==null) {
			throw new CantPrepSoap("По объекту УК Eolink.id="+String.valueOf(uk.getId())+" не заполнен параметр " +
					"\"ГИС ЖКХ.CONFIRM_CORRECT\"");
		}
		// РКЦ
		Eolink rkc = uk.getParent();
		// получить период импорта ПД
		String period = eolParMng.getStr(rkc, "ГИС ЖКХ.PERIOD_IMP_PD");
		if (period==null) {
			throw new CantPrepSoap("По объекту РКЦ (родительская запись УК) не заполнен параметр " +
					"\"ГИС ЖКХ.PERIOD_IMP_PD\", либо некорректно проставлен PARENT_ID от УК к РКЦ!");
		}
		// получить дату загрузки ПД
		Date dt = Utl.getLastDate(Utl.getDateFromPeriod(period));

		// платежные реквизиты
		PaymentInformation payInfo = new PaymentInformation();
		req.getPaymentInformation().add(payInfo);

		OrgDTO orgDto = orgMng.getOrgDTO(uk);
		log.info("ПД: BIK=#{}#", orgDto.getBik());
		payInfo.setBankBIK(orgDto.getBik());
		log.info("ПД: OperAccount=#{}#", orgDto.getOperAccGis());
		payInfo.setOperatingAccountNumber(orgDto.getOperAccGis());
		// Транспортный GUID платежных реквизитов
		String tguidPay = Utl.getRndUuid().toString();
		payInfo.setTransportGUID(tguidPay);

		if (pdocMng.getPdocForLoadByHouse(house, dt).stream()
                .filter(t-> t.getV().equals(1)).collect(Collectors.toList()).size() > 0) {
            // получить список незагруженных, действующих ПД в ГИС по Дому
            for (Pdoc t : pdocMng.getPdocForLoadByHouse(house, dt).stream()
                    .filter(t -> t.getV().equals(1)) // действующие
                    .collect(Collectors.toList())) {
                // добавить не более 500 вхождений ПД
                log.info("Добавление платежного документа, Pdoc.id={}", t.getId());
				boolean isAdd = addPaymentDocument(uk, t, house, req, reqProp.getAppTp(), tguidPay);
                t.setIsConfirmCorrect(isConfirmCorrect);
                if (isAdd) {
                	// если хотя бы один документ добавлен - загружать
					isExistJob = true;
				}
            }
            // cчитать корректными значения сумм документов, если они расходятся с автоматически рассчитанными
            if (isConfirmCorrect) {
                req.setConfirmAmountsCorrect(true);
            }

        }

        if (!isExistJob){
        	// не было документов на добавление, найти на отмену
            // получить список недействующих ПД, направленных на отмену в ГИС по Дому
            for (Pdoc t : pdocMng.getPdocForLoadByHouse(house, dt).stream()
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
        }

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
				taskMng.logTask(task, false, false);
			} else {
				// Установить статус "Запрос статуса"
				reqProp.getFoundTask().setState("ACK");
				reqProp.getFoundTask().setMsgGuid(ack.getAck().getMessageGUID());
				taskMng.logTask(task, false, true);
			}

		} else {
			// Установить статус "Выполнено", так как нечего загружать
			log.info("Task.id={}, Нет документов для загрузки!", task.getId());
			reqProp.getFoundTask().setState("ACP");
		}

		// сбросить кол-во ошибок запросов Ack
		reqProp.getFoundTask().setErrAckCnt(0);

	}

	/**
	 * Добавление платежного документа
     * @param uk - организация
	 * @param pdoc - ПД
	 * @param req - запрос
	 * @param appTp - тип информационной системы
	 * @param tguidPay - транспортный GUID платежных реквизитов
	 * @throws CantPrepSoap - невозможно создать SOAP
	 * @throws WrongGetMethod - некорректный параметр
	 * @return - добавлен ли документ
	 */
	private Boolean addPaymentDocument(Eolink uk, Pdoc pdoc, Eolink house,
									   ImportPaymentDocumentRequest req, Integer appTp,
									   String tguidPay)
			throws CantPrepSoap, WrongGetMethod {
		PaymentDocument pd = new PaymentDocument();
		// оступ
		log.info("");
		// услуги повыш коэфф, уже добавленные в ПД (чтобы избежать повторного добавления)
		List lstOverServ = new ArrayList<Integer>(0);
		// лицевой счет
		Eolink acc = pdoc.getEolink();
		// GUID лицевого счета
		String accGuid = acc.getGuid();
		// лиц счет из биллинга
		Kart kart = kartDao.getByLsk(acc.getKart().getLsk());
		if (kart == null) {
			log.error("Не обнаружен лицевой счет: Kart.lsk={}");
			return false;
		}

		// дата ПД (обычно последнее число расчетного месяца)
		Date dt = pdoc.getDt();
		if (dt == null) {
			throw new CantPrepSoap("Не заполнена дата Платежного Документа");
		}
        // почистить результат
        pdoc.setResult(null);
		// период ПД в формате YYYYMM
		String period = Utl.getPeriodFromDate(dt);
		// день ПД
		Byte day = Utl.getDay(dt).byteValue();
		// месяц ПД
		Integer month = Integer.valueOf(Utl.ltrim(Utl.getPeriodMonth(period),"0"));
		// год ПД
		Short year = Short.valueOf(Utl.getPeriodYear(period));
		// № ПД
		String cd;
		if (pdoc.getCd() == null) {
			// если не проставлен № документа в биллинге
			if (appTp==0 || appTp==2) {
				// старая и эксперементальная разработка
				cd = "ПД_".concat(uk.getReu().concat("_").concat(period).concat("_").concat(String.valueOf(pdoc.getId())));
				pdoc.setCd(cd);
				log.info("-------------------------------------------------------------------------------------------");
				log.info("ПД: проставлен № документа cd={}", cd);
			} else { // Прочие разработки

			}
		} else {
            log.info("ПД: использован № документа cd={}", pdoc.getCd());
        }

		// лиц.счет
		pd.setAccountGuid(accGuid);

		// Номер ПД из биллинга
		if (pdoc.getCd() == null) {
			throw new CantPrepSoap("Не заполнен CD документа");
		}
		pd.setPaymentDocumentNumber(pdoc.getCd());
		List<SumChrgRec> lstSum = chrgMng.getChrgGrp(acc.getKart().getLsk(), acc.getKoObj(), period, uk, appTp);

		Task boost = new Task();
		// обновить услугами из справочника ГИС
		lstSum.forEach(t-> {
			Ulist ulist = em.find(Ulist.class, t.getUlistId());
			t.setUlist(ulist);
		});

		ChargeInfo chrgInfo;
		// начисления по видам услуг
		for (SumChrgRec t: lstSum) {
			// наименование услуги и т.п.
            if (!Utl.nvl(t.getUlist().getIsHideInPd(), false)) {
                // если не скрытая услуга (типа Повыш.коэфф.)
                if (t.getUlist().getUlistTp().getFkExt().equals(50)
                        && !t.getUlist().getGuid().equals("7dd57643-4836-4838-900b-cacec6b2f27b")
                        ) {
                    // Общий справочник №50 - жилищная, но не взнос на капремонт
                    HousingService housService = new HousingService();
                    chrgInfo = new ChargeInfo();
                    chrgInfo.setHousingService(housService);
                    chrgInfo.setHousingService(addHousingService(t, "NO", lstSum));
                    pd.getChargeInfo().add(chrgInfo);
                } else if (t.getUlist().getUlistTp().getFkExt().equals(51)) {
                    // Внутренний справочник №51 - коммунальная (напр.Х.В., Отопление)
                    chrgInfo = new ChargeInfo();
                    pd.getChargeInfo().add(chrgInfo);
                    chrgInfo.setMunicipalService(addMunService(t, "NO", "N",
							appTp, lstSum, lstOverServ));

                } else if (t.getUlist().getUlistTp().getFkExt().equals(1)) {
                    // Внутренний справочник №1 - дополнительная (напр Замок)
                    chrgInfo = new ChargeInfo();
                    pd.getChargeInfo().add(chrgInfo);
                    chrgInfo.setAdditionalService(addAdditionalService(t, "NO", kart));
                } else if (t.getUlist().getGuid().equals("7dd57643-4836-4838-900b-cacec6b2f27b")) {
                    // Общий справочник №50 - Взнос на капитальный ремонт
                    if (pd.getCapitalRepairCharge() != null) {
                        throw new CantPrepSoap("Не допускается заполнение в ПД услуги Капремонт более одного раза!");
                    }
                    addCapitalRepair(pd, t);
                }
            }

		}

		// неустойки и судебные расходы (пени)
		PenaltiesAndCourtCosts penCourtCost = new PenaltiesAndCourtCosts();

		// вид неустойки и судебных расходов. НСИ 329 "Неустойки и судебные расходы":
		//- Пени
		//- Штрафы
		//- Государственные пошлины
		//- Судебные издержки.
		BigDecimal pen = Utl.nvl(debMng.getPenAmnt(acc.getKart().getLsk(), acc.getKoObj(), period, appTp), BigDecimal.ZERO);
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

		// Итого начислено
		Double totalD = lstSum.stream() // Итог без капремонта!
				.mapToDouble(t -> t.getChrg()).sum();
		BigDecimal totalPeriod = Utl.getBigDecimalRound(totalD, 2);
		log.info("ПД: ИТОГО начислено за период ={}", totalPeriod);

		// получить запись сальдо
		SumSaldoRecDTO sumSaldo = debMng.getSumSaldo(acc.getKart().getLsk(), acc.getKoObj(),
				period, reqProp.getAppTp());

		// вычесть текущую оплату
		BigDecimal salAmnt = BigDecimal.ZERO;
		if (sumSaldo!=null) {
			BigDecimal inSal = Utl.nvl(sumSaldo.getInSal(), BigDecimal.ZERO);
			BigDecimal pay = Utl.nvl(sumSaldo.getPayment(), BigDecimal.ZERO);
			salAmnt = inSal.subtract(pay);
			log.info("ПД: сальдо на начало периода={}, минус оплата={}, итого={}",
					sumSaldo.getInSal(), sumSaldo.getPayment(), salAmnt);
			// оплачено денежных средств, руб (не обязательно) сказано в ГИС, что эта сумма автоматически осуществит квитирование предыдущ. ПД
			pd.setPaidCash(sumSaldo.getPayment());
			log.info("ПД: оплачено={}", sumSaldo.getPayment());

		}

		// задолженность за предыдущие периоды
		BigDecimal debt = BigDecimal.ZERO;
		if (salAmnt.compareTo(BigDecimal.ZERO) > 0) {
			debt = salAmnt;
		}
		log.info("ПД: задолженность за предыдущие периоды={}", debt);
		pd.setDebtPreviousPeriods(debt);

		// аванс на начало периода
		BigDecimal advnc = BigDecimal.ZERO;
		if (salAmnt.compareTo(BigDecimal.ZERO) < 0) {
			advnc = salAmnt.abs();
		}
		log.info("ПД: аванс на начало расчетного периода={}", advnc);
		pd.setAdvanceBllingPeriod(advnc);

		log.info("ПД: начисление={}", totalPeriod);

		// учтены платежи, поступившие до указанного числа расчетного периода включительно
		pd.setPaymentsTaken(day);

		// итого к оплате по неустойкам и судебным издержкам, руб. (итого по всем неустойкам и судебным издержкам).
		// заполняется только для ПД с типом = Текущий
		if (pen.compareTo(BigDecimal.ZERO) != 0) {
			pd.setTotalByPenaltiesAndCourtCosts(pen);
		}

		// сохранить транспортный GUID ПД
		String tguid = Utl.getRndUuid().toString();
		pd.setTransportGUID(tguid);
		pdoc.setTguid(tguid);

		req.getPaymentDocument().add(pd);
		req.setMonth(month);
		req.setYear(year);

		// сослаться на TGUID платежных реквизитов
		pd.setPaymentInformationKey(tguidPay);
		return true;
	}

	/**
	 * добавить запись о капремонте
     * @param pd - ПД
     * @param rec - строка начисления
     */
	private void addCapitalRepair(PaymentDocument pd, SumChrgRec rec) {
		BigDecimal priceBd = BigDecimal.valueOf(rec.getPrice());
		BigDecimal chrgBd = BigDecimal.valueOf(rec.getChrg());
        BigDecimal chngBd = BigDecimal.valueOf(rec.getChng());
		chrgBd = chrgBd.setScale(2, BigDecimal.ROUND_HALF_UP);
		priceBd = priceBd.setScale(2, BigDecimal.ROUND_HALF_UP);
		log.info("ПД: Капремонт цена={}, начисление={}, перерасчет={}", priceBd, chrgBd, chngBd);
        // Итого к оплате за расчетный период, руб.
        BigDecimal total = chrgBd;
        // перерасчет
        BigDecimal chng = chngBd;
        // добавить перерасчет
        total = chrgBd.add(chngBd);

		PaymentDocumentType.CapitalRepairCharge capRepChrg = new PaymentDocumentType.CapitalRepairCharge();
		// размер взноса на кв.м, руб (расценка)
		capRepChrg.setContribution(priceBd);
		// льгота
		capRepChrg.setMoneyDiscount(BigDecimal.ZERO);
        // перерасчет
        capRepChrg.setMoneyRecalculation(chngBd);
		// всего начислено за расчетный период (без перерасчетов и льгот), руб.
		capRepChrg.setAccountingPeriodTotal(chrgBd);
		// итого к оплате за расчетный период, руб.
		capRepChrg.setTotalPayable(total);
		pd.setCapitalRepairCharge(capRepChrg);
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
		BigDecimal totalChrg = BigDecimal.ZERO;
        BigDecimal totalChng = BigDecimal.ZERO;
		BigDecimal totalPrice = BigDecimal.ZERO;
		List<SumChrgRec> lst = lstSum.stream()
				.filter(t -> t.getUlist().equals(rec.getUlist())
						|| t.getUlist().getParent2()!=null
						&& t.getUlist().getParent2().equals(rec.getUlist())
						&& t.getUlist().getUlistTp().getFkExt().equals(2) // фильтр по Общему справочнику №2
				).collect(Collectors.toList());
		// показать составляющие услуги:
	    for (SumChrgRec t : lst) {
	    	log.info("ПД: Услуга:");
	    	t.getUlist().getChild().forEach(d -> {
		    	log.info("ПД: {}, {}", d.getName(),
		    			d.getS1());
	    	});

	    	log.info("ПД: цена={}, начисление={}, перерасчет={}",
	    			t.getPrice(),
	    			t.getChrg(),
                    t.getChng());
			totalChrg = totalChrg.add(BigDecimal.valueOf(t.getChrg()));
            totalChng = totalChng.add(BigDecimal.valueOf(t.getChng()));
			totalPrice = totalPrice.add(BigDecimal.valueOf(t.getPrice()));
	    }
	    BigDecimal checkSum = BigDecimal.valueOf(rec.getSqr()).multiply(totalPrice);
		log.info("ПД: ИТОГО по Жилищной услуге: площадь={}, цена={}, начисление={}, проверочная сумма={}, перерасчет={}",
					rec.getSqr(), totalPrice, totalChrg, checkSum.setScale(2, RoundingMode.HALF_UP), totalChng);
		log.info("");

		// всего начислено за расчетный период (без перерасчетов и льгот), руб.
		housService.setAccountingPeriodTotal(totalChrg.setScale(2, BigDecimal.ROUND_HALF_UP));
		// итого к оплате за расчетный период, руб.
        BigDecimal total = totalChrg.setScale(2, BigDecimal.ROUND_HALF_UP);
        // перерасчет
        BigDecimal chng = totalChng.setScale(2, BigDecimal.ROUND_HALF_UP);
        // добавить перерасчет
        total = total.add(chng);
        housService.setTotalPayable(total);
		// порядок расчетов
		housService.setCalcExplanation(calcExpl);
		// цена услуги
		housService.setRate(totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));

        // перерасчеты и льготы по жилищной услуге
        ServiceChargeImportType servChrg = new ServiceChargeImportType();
        housService.setServiceCharge(servChrg);
        servChrg.setMoneyRecalculation(chng);

		// РЕСУРСЫ НА ОИ
		for (SumChrgRec t: lstSum.stream() // найти дочерние записи (Усл. на ОИ)
				.filter(e -> e.getUlist().getParent2()!=null && e.getUlist().getParent2().equals(rec.getUlist()))
				.filter(e -> e.getUlist().getUlistTp().getFkExt().equals(2)) // фильтр по Общему справочнику №2
				.collect(Collectors.toList())) {

			// ресурс коммунальной услуги (ХВ, ГВ, Эл.эн)
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
			log.info("начисление из базы ={}", t.getChrg());
			log.info("проверочная сумма={}",
					BigDecimal.valueOf(t.getPrice()).multiply(
							Utl.getBigDecimalRound(t.getSqr(), 5))
					);
            log.info("перерасчет из базы ={}", t.getChng());

			// потребление при содержании общего имущества (м2)
			volume.setValue(BigDecimal.valueOf(t.getSqr()).setScale(2, BigDecimal.ROUND_HALF_UP));
			consum.setVolume(volume);

			// потребление
			mr.setConsumption(consum);

            BigDecimal chrg = BigDecimal.valueOf(t.getChrg()).setScale(2, BigDecimal.ROUND_HALF_UP);
            chng = BigDecimal.valueOf(t.getChng()).setScale(2, BigDecimal.ROUND_HALF_UP);
            total = chrg.add(chng);
                    // Тариф, руб./ед.изм. (для Х.В. на ОИ - это м2)
			mr.setRate(BigDecimal.valueOf(t.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
            // Всего начислено за расчетный период (без перерасчетов и льгот), руб.
			mr.setAccountingPeriodTotal(chrg);
            // итого к оплате за расчетный период, руб.
            mr.setTotalPayable(total);
			// Справочная информация
/*			ServiceInformation servInf = new ServiceInformation();
			// Норматив потребления при содержании общего имущества (м3 на м2)
			servInf.setHouseOverallNeedsNorm(BigDecimal.valueOf(1D)); // TODO
			// Суммарный объём коммунальных ресурсов в доме
			// В целях содержания общего имущества
			servInf.setHouseTotalHouseOverallNeeds(BigDecimal.valueOf(4000)); // TODO
			mr.setServiceInformation(servInf );*/

			// перерасчеты и льготы по муниципальному ресурсу
			ServiceChargeImportType servChrgRes = new ServiceChargeImportType();
			servChrgRes.setMoneyDiscount(BigDecimal.valueOf(0D));
			servChrgRes.setMoneyRecalculation(chng);
			// К оплате за коммунальный ресурс потребления при содержании общего имущества (расценка на площадь)
			mr.setMunicipalServiceCommunalConsumptionPayable(
			        BigDecimal.valueOf(t.getChrg()).setScale(2, BigDecimal.ROUND_HALF_UP));
			mr.setServiceCharge(servChrgRes);
			housService.getMunicipalResource().add(mr );
		}

		return housService;
	}

	/*
	 * добавить муниципальную услугу (Х.В., Г.В., Отопление)
	 * @param rec - запись начисления
	 * @param detMethod - cпособ определения объемов КУ: (N)orm - Норматив, (M)etering device - Прибор учета, (O)ther - Иное
	 * @param appTp - тип разработки
	 * @param lstSum - список начислений по услугам
	 * @param lstOverServ - список услуг повыш коэфф., уже присоединенных в данном ПД к услуге, во избежании дублей

	 */
	private MunicipalService addMunService(SumChrgRec rec, String calcExpl, String detMethod, Integer appTp,
										   List<SumChrgRec> lstSum, List lstOverServ) {
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

		// для Отопления
		vol = Utl.getBigDecimalRound(rec.getVol(), 5);

		volume.setValue(vol);
		//volume.setValue(new BigDecimal("5"));
		consump.getVolume().add(volume);
		munService.setConsumption(consump);
		munService.setServiceType(mres);

		// повышающий коэффициент
        // Ratio - Указывать необходимо согласно постановлениям Правительства Российской Федерации от 16.04.2014 №344 и от 29 июня 2016 г. N 603, то есть 1,1; 1,2; 1,3; 1,4 и т.д
        // AmountOfExcessFees - Разница между итоговой суммой начислений и суммой начисления без повышающего коэффициента
        // Норматив потребления и Объем - Согласно ПП РФ от 29.06.2016 N603 объёмы указываются без повышающего коэффициента
        // https://helpdesk.dom.gosuslugi.ru/browse/HCSINTEGRS-4096 TODO Делать для Полыс.!

        // найти услугу - повышающий коэфф, привязанную к основной услуге
		// (например Г.В. но не Г.В. и Г.В.0 прожив.)
        BigDecimal multChrg = BigDecimal.ZERO;
        BigDecimal multChng = BigDecimal.ZERO;
		// проверить, чтобы она подключилась в ПД всего 1 раз по каждой основной услуге
        if (!lstOverServ.contains(rec.getUlistId())) {
			lstOverServ.add(rec.getUlistId());
			SumChrgRec overServRec = lstSum.stream()
					.filter(t -> t.getUlist().getParent3()!=null
							  && t.getUlist().getParent3().equals(rec.getUlist())
					).findFirst().orElse(null);
			if (overServRec != null) {
				multChng = BigDecimal.valueOf(overServRec.getChng());
				multChrg = BigDecimal.valueOf(overServRec.getChrg());
				BigDecimal ratio = BigDecimal.valueOf(overServRec.getNorm());
				log.info("ПД: Повышающий коэфф по услуге: ratio={}, начисление={}, перерасчет={}",
						ratio, multChrg, multChng);
				MunicipalService.MultiplyingFactor multFactor = new MunicipalService.MultiplyingFactor();
				multFactor.setRatio(ratio);
				multFactor.setAmountOfExcessFees(multChrg);
				munService.setMultiplyingFactor(multFactor);
			}
		}

        // Итого к оплате за расчетный период, руб.
        BigDecimal chrg = BigDecimal.valueOf(rec.getChrg()).setScale(2, BigDecimal.ROUND_HALF_UP);
        // добавить начисление Повыш.коэфф.
        chrg = chrg.add(multChrg);
        BigDecimal total = chrg;
        // перерасчет
        BigDecimal chng = BigDecimal.valueOf(rec.getChng()).setScale(2, BigDecimal.ROUND_HALF_UP);
        // добавить перерасчет Повыш.коэфф.
        chng = chng.add(multChng);
        // добавить перерасчет
        total = total.add(chng);

        BigDecimal checkSum = vol.multiply(BigDecimal.valueOf(rec.getPrice()));
        log.info("ПД: цена={}, объем={}, начисление={}, проверочная сумма без учета Повыш коэфф.={}, перерасчет={}",
                rec.getPrice(), vol, chrg, checkSum.setScale(2, RoundingMode.HALF_UP), chng
        );
        log.info("");

        munService.setRate(BigDecimal.valueOf(rec.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP));
        // Итого к оплате за расчетный период, руб.
        munService.setTotalPayable(total);
        // Всего начислено за расчетный период (без перерасчетов и льгот), руб.
        munService.setAccountingPeriodTotal(chrg);

        // перерасчеты и льготы по муниципальной услуге
		ServiceChargeImportType servChrg = new ServiceChargeImportType();
		munService.setServiceCharge(servChrg);
		servChrg.setMoneyDiscount(BigDecimal.ZERO);
		servChrg.setMoneyRecalculation(chng);

		// Порядок расчетов
		munService.setCalcExplanation(calcExpl);
		return munService;
	}

	/*
	 * добавить дополнительную услугу
	 * @param rec - запись начисления
	 * @kart - лицевой счет
	 */
	private AdditionalService addAdditionalService(SumChrgRec rec, String calcExpl, Kart kart) {
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
		volume.setValue(BigDecimal.valueOf(rec.getSqr()));
		consumption.getVolume().add(volume);
		BigDecimal checkSum = BigDecimal.valueOf(rec.getSqr()).multiply(BigDecimal.valueOf(rec.getPrice()));
    	log.info("ПД: цена={}, объем={}, начисление={}, проверочная сумма={}, перерасчет={}",
    			rec.getPrice(), rec.getVol(), rec.getChrg(), checkSum, rec.getChng()
    			);
    	log.info("");

	  	additionalService.setConsumption(consumption);
		additionalService.setServiceType(mres);

        // Итого к оплате за расчетный период, руб.
        BigDecimal total = BigDecimal.valueOf(rec.getChrg()).setScale(2, BigDecimal.ROUND_HALF_UP);

		// цена
        BigDecimal price = BigDecimal.valueOf(rec.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
        /*BigDecimal priceBd = null;
        if (price.equals(BigDecimal.ZERO)) {
            if (!BigDecimal.valueOf(kart.getOpl()).equals(BigDecimal.ZERO)
                    && !total.equals(BigDecimal.ZERO)) {
                // расценка нулевая, значит услуга - повыш коэфф ОДН
                // создаем расценку как сумма/площадь
                priceBd = total.divide(BigDecimal.valueOf(kart.getOpl()));
            } else {
                priceBd = BigDecimal.ZERO;
            }
        }*/
		additionalService.setRate(price);

        // перерасчет
        BigDecimal chng = BigDecimal.valueOf(rec.getChng()).setScale(2, BigDecimal.ROUND_HALF_UP);
        // добавить перерасчет
        total = total.add(chng);
		additionalService.setTotalPayable(total);
		// Всего начислено за расчетный период (без перерасчетов и льгот), руб.
		additionalService.setAccountingPeriodTotal(BigDecimal.valueOf(rec.getChrg()).setScale(2, BigDecimal.ROUND_HALF_UP));
		// Порядок расчетов
		additionalService.setCalcExplanation(calcExpl);

		// перерасчеты и льготы по дополнительной услуге
		ServiceChargeImportType servChrg = new ServiceChargeImportType();
		additionalService.setServiceCharge(servChrg);
        servChrg.setMoneyDiscount(BigDecimal.ZERO);
        servChrg.setMoneyRecalculation(chng);

		return additionalService;
	}
	/**
	 * Получить результат импорта платежного документа
	 * @param task - задание
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void importPaymentDocumentDataAsk(Task task) throws CantPrepSoap {
		taskMng.logTask(task, true, null);

		// Установить параметры SOAP
		reqProp.setPropAfter(task);
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask() != null && reqProp.getFoundTask().getTrace().equals(1));

		// получить состояние
		ru.gosuslugi.dom.schema.integration.bills.GetStateResult retState = getState2(reqProp.getFoundTask());

		if (retState == null) {
			// не обработано
		} else if (!reqProp.getFoundTask().getState().equals("ERR")) {

			retState.getImportResult().forEach(t -> {
				// Найти ПД по Транспортному GUID
                log.info("попытка найти по TGUID={}", t.getTransportGUID());
				Pdoc pdoc = pdocDao.getByTGUID(t.getTransportGUID());
                log.info("УСПЕШНО - попытка найти по TGUID={}", t.getTransportGUID());

				boolean isErr = false;
				for (Error f: t.getError()) {

					if (f.getErrorCode().equals("SRV008070") && pdoc.getStatus().equals(1) && pdoc.getV().equals(0)) {
						// если пришёл ответ от ГИС "SRV008070" (ПД уже отменён)
						// и если ПД был "загружен" и "отменен", то отметить статус - отменен
						pdoc.setStatus(2);
						// флаг ошибки, чтоб не обработался ниже
						isErr = true;
					} else {
						// прочие варианты
						log.error("Произошла ОШИБКА при загрузке Платежного документа Pdoc.id={}", pdoc.getId());
						String errStr = String.format("Error code=%s, Description=%s", f.getErrorCode(), f.getDescription());
						log.error(errStr);
						// пометить документ, что загружен с ошибкой
						pdoc.setErr(1);
						pdoc.setResult(errStr);
						isErr = true;
					}
				}

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
					pdoc.setResult(null);
				}

			});

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
			taskMng.logTask(task, false, true);

		}
	}

	/**
	 * Проверить наличие заданий на импорт и экспорт ПД
	 * и если их нет, - создать
	 * @param task - задание
	 * @throws WrongParam - некорректный параметр
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicImpExpPd(Task task) throws WrongParam {
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем домам задания на импорт ПД, если их нет
		createTask("GIS_IMP_PAY_DOCS", "SYSTEM_RPT_IMP_PD", "STP", "Дом",
				"импорт ПД");
        // создать по всем домам задания на экспорт ПД, если их нет
		createTask("GIS_EXP_PAY_DOCS", "SYSTEM_RPT_EXP_PD", "STP", "Дом",
				"экспорт ПД");
		// создать по всем УК задания на экспорт Извещений по ПД, если их нет, по дням выгрузки
		createTask("GIS_EXP_NOTIF_1", "SYSTEM_RPT_EXP_NOTIF", "STP", "Организация",
				"экспорт Извещений");
		createTask("GIS_EXP_NOTIF_8", "SYSTEM_RPT_EXP_NOTIF", "STP", "Организация",
				"экспорт Извещений");
		createTask("GIS_EXP_NOTIF_16", "SYSTEM_RPT_EXP_NOTIF", "STP", "Организация",
				"экспорт Извещений");
		createTask("GIS_EXP_NOTIF_24", "SYSTEM_RPT_EXP_NOTIF", "STP", "Организация",
				"экспорт Извещений");
		// Установить статус выполнения задания
		foundTask.setState("ACP");
	}

	private void createTask(String actTp, String parentCD, String state, String eolTp, String purpose) {
		int a;// создавать по 100 штук, иначе -блокировка Task (нужен коммит)
		a=1;
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp(eolTp, actTp, parentCD)) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, state, soapConfig.getCurUser().getId());
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();
			log.info("Добавлено задание на {}, по объекту {}, Eolink.id={}", purpose, eolTp, e.getId());
			a++;
			if (a++>=100) {
				break;
			}
		}
	}


}
