package com.ric.st.builder.impl;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.ric.st.impl.SoapConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.dao.EolinkDAO;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.mm.TaskParMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.UlistTp;
import com.ric.st.ReqProps;
import com.ric.st.builder.NsiServiceAsyncBindingBuilders;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.dao.UlistDAO;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.impl.SoapBuilder;
import com.ric.st.mm.UlistMng;
import com.sun.xml.ws.developer.WSBindingProvider;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.schema.integration.base.*;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.nsi.ExportDataProviderNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_service_async.NsiPortsTypeAsync;
import ru.gosuslugi.dom.schema.integration.nsi_service_async.NsiServiceAsync;

@Service
@Slf4j
public class NsiServiceAsyncBindingBuilder implements NsiServiceAsyncBindingBuilders {

	@Autowired
	private ApplicationContext ctx;
	@Autowired
	private UlistDAO ulistDao;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private ReqProps reqProp;
	@Autowired
	private TaskParMng taskParMng;
	@Autowired
	private UlistMng ulistMng;
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private PseudoTaskBuilders ptb;
	@Autowired
	private SoapConfig soapConfig;

	private NsiServiceAsync service;
	private NsiPortsTypeAsync port;
	private SoapBuilder sb;

	@Override
	public void setUp(Task task) throws CantSendSoap, CantPrepSoap {
    	// создать сервис и порт
		service = new NsiServiceAsync();
    	port = service.getNsiPortAsync();

    	// подоготовительный объект для SOAP
    	sb = ctx.getBean(SoapBuilder.class);
		reqProp.setPropBefore(task);
		sb.setUp((BindingProvider) port, (WSBindingProvider) port, true, reqProp.getPpGuid(), reqProp.getHostIp());
		// логгинг запросов
    	sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// Id XML подписчика
		sb.setSignerId(reqProp.getSignerId());
	}

	/**
	 * Получить состояние запроса
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public ru.gosuslugi.dom.schema.integration.nsi.GetStateResult getState2(Task task) {

		// Признак ошибки
		boolean err = false;
		// Признак ошибки в CommonResult
		boolean errChld = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.nsi.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!

		sb.makeRndMsgGuid();
		try {
			Holder<ResultHeader> hld = new Holder<>();
			state = port.getState(gs);
		} catch (ru.gosuslugi.dom.schema.integration.nsi_service_async.Fault e) {
			e.printStackTrace();
			err = true;
			errStr = "Запрос вернул ошибку!";
		}

		if (state != null && state.getRequestState() != 3) {
			// вернуться, если задание всё еще не выполнено
			log.info("Статус запроса={}, Task.id={}", state.getRequestState(), task.getId());
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
	 * Получить внутренний справочник организации
	 * @param task - задание
	 * @throws WrongGetMethod
	 * @throws DatatypeConfigurationException
	 * @throws CantPrepSoap
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportDataProviderNsiItem(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		//log.info("******* Task.id={}, экспорт внутреннего справочника организации, вызов", task.getId());
		taskMng.logTask(task, true, null);
		// Установить параметры SOAP
		reqProp.setPropAfter(task);
		AckRequest ack = null;
		// Трассировка XML
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;

		ExportDataProviderNsiItemRequest req = new ExportDataProviderNsiItemRequest();
		req.setId("foo");
		req.setVersion(req.getVersion()==null?reqProp.getGisVersion():req.getVersion());
		Double regNum = taskParMng.getDbl(task, "ГИС ЖКХ.Номер справочника");
		req.setRegistryNumber(BigInteger.valueOf(regNum.longValue()));
		try {
			ack = port.exportDataProviderNsiItem(req);
		} catch (ru.gosuslugi.dom.schema.integration.nsi_service_async.Fault e) {
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
	 * Получить результат запроса внутреннего справочника организации
	 * @param task - задание
	 * @throws WrongGetMethod
	 * @throws IOException
	 * @throws CantPrepSoap
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportDataProviderNsiItemAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam {
		//log.info("******* Task.id={}, экспорт внутреннего справочника организации, запрос ответа", task.getId());
		taskMng.logTask(task, true, null);
		// Установить параметры SOAP
		reqProp.setPropAfter(task);
		sb.setTrace(reqProp.getFoundTask()!=null? reqProp.getFoundTask().getTrace().equals(1): false);
		// получить состояние запроса
		ru.gosuslugi.dom.schema.integration.nsi.GetStateResult retState = getState2(reqProp.getFoundTask());
		if (retState == null) {
			// не обработано
			return;
		} else if (!reqProp.getFoundTask().getState().equals("ERR") && !reqProp.getFoundTask().getState().equals("ERS")) {
			Eolink eolink = task.getEolink();
			String grp = "NSI";
			Double regNum = taskParMng.getDbl(task, "ГИС ЖКХ.Номер справочника");
			int tp = regNum.intValue();
			// получить из нашей базы
			UlistTp ulistTp = ulistDao.getListTp(grp, eolink, tp);
			String prefix = ulistMng.getPrefixedCD(String.valueOf(tp), grp);
			if (ulistTp == null) {
				// не найден заголовок, создать новый
				ulistTp= new UlistTp(prefix, tp, "Внутренний справочник организации",
						new Date(), grp, null, eolink);
				em.persist(ulistTp);
				log.info("Создан заголовочный элемент ListTp :{}", prefix);
			}
			// String org = ulistTp.getEolink().getReu();
			String org = ulistTp.getEolink().getOrg().getReu();

			// загрузить полученные элементы
			Integer idx = 0;
			for (NsiElementType t :retState.getNsiItem().getNsiElement()){
                idx = ulistMng.mergeElement(ulistTp, grp, tp, t, idx, org);
			}

			// Установить статус выполнения задания
			reqProp.getFoundTask().setState("ACP");
		}


	}

	/**
	 * Проверить наличие заданий по экспорту справочников организации
	 * и если их нет, - создать
	 * @param task
	 * @throws WrongParam
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void checkPeriodicTask(Task task) throws WrongParam {
		//log.info("******* Task.id={}, проверка наличия заданий по экспорту справочников организации, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем организациям задания, если их нет
		// добавить как зависимое задание к системному повторяемому заданию
		String actTp = "GIS_EXP_DATA_PROVIDER_NSI_ITEM";
		String parentCD = "SYSTEM_RPT_REF_EXP";
		// создавать по 10 штук, иначе -блокировка Task (нужен коммит)
		int a=1;
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Организация", actTp, parentCD)) {
			// статус - INS, чтобы сразу выполнилось
			ptb.setUp(e, null, actTp, "INS", soapConfig.getCurUser().getId());
			// Справочник № 1
			ptb.addTaskPar("ГИС ЖКХ.Номер справочника", 1D, null, null, null);
			ptb.addAsChild(parentCD);
			ptb.save();

			// Справочник № 51
			ptb.setUp(e, null, actTp, "INS", soapConfig.getCurUser().getId());
			ptb.addTaskPar("ГИС ЖКХ.Номер справочника", 51D, null, null, null);
			ptb.addAsChild(parentCD);
			ptb.save();

			log.info("Добавлено задание по экспорту справочников организации по Организации Eolink.id={}", e.getId());
			a++;
			if (a>=100) {
				break;
			}
		};
		// Установить статус выполнения задания
		foundTask.setState("ACP");
		//log.info("******* Task.id={}, проверка наличия заданий по экспорту справочников организации, выполнено!", task.getId());

	}

}
