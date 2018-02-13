package com.ric.st.builder.impl;


import static org.hamcrest.CoreMatchers.hasItem;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;
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
import ru.gosuslugi.dom.schema.integration.base.AckRequest;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType;
import ru.gosuslugi.dom.schema.integration.base.CommonResultType.Error;
import ru.gosuslugi.dom.schema.integration.base.GetStateRequest;
import ru.gosuslugi.dom.schema.integration.nsi.ExportDataProviderNsiItemRequest;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementFieldType;
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

	private NsiServiceAsync service;
	private NsiPortsTypeAsync port;
	private SoapBuilder sb; 

	public void setUp() throws CantSendSoap {
    	// создать сервис и порт
		service = new NsiServiceAsync();
    	port = service.getNsiPortAsync();

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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public ru.gosuslugi.dom.schema.integration.nsi.GetStateResult getState2(Task task) {
		
		// Признак ошибки
		Boolean err = false;
		// Признак ошибки в CommonResult
		Boolean errChld = false;
		String errStr = null;
		ru.gosuslugi.dom.schema.integration.nsi.GetStateResult state = null;

		GetStateRequest gs = new GetStateRequest();
		gs.setMessageGUID(task.getMsgGuid());
		sb.setSign(false); // не подписывать запрос состояния!
		
		sb.makeRndMsgGuid();
		try {
			state = port.getState(gs);
		} catch (ru.gosuslugi.dom.schema.integration.nsi_service_async.Fault e) {
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
	 * Получить внутренний справочник организации 
	 * @param task - задание
	 * @throws WrongGetMethod 
	 * @throws DatatypeConfigurationException 
	 * @throws CantPrepSoap
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Boolean exportDataProviderNsiItem(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap {
		log.info("******* Task.id={}, экспорт внутреннего справочника организации, вызов", task.getId());
		// Установить параметры SOAP
		reqProp.setProp(task, sb);
		AckRequest ack = null;
		// Трассировка XML
		sb.setTrace(true);
		// для обработки ошибок
		Boolean err = false;
		String errMainStr = null;
		
		ExportDataProviderNsiItemRequest req = new ExportDataProviderNsiItemRequest();
		req.setId("foo");
		req.setVersion(req.getVersion());
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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void exportDataProviderNsiItemAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam {
		log.info("******* Task.id={}, экспорт внутреннего справочника организации, запрос ответа", task.getId());
		sb.setTrace(true);
		// Установить параметры SOAP
		reqProp.setProp(task, sb);	
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
			} else {
				// найден заголовок, удалить имеющиеся дочерние элементы
				/*
				Iterator<Ulist> it = ulistTp.getUlist().iterator();
				while (it.hasNext()) {
					it.next();
					it.remove();
				}
				*/
			}
			
			// загрузить полученные элементы
			Integer idx = 0;
			for (NsiElementType t :retState.getNsiItem().getNsiElement()){
				idx = ulistMng.addElement(ulistTp, grp, tp, t, idx);
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
		log.info("******* Task.id={}, проверка наличия заданий по экспорту справочников организации, вызов", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		// создать по всем организациям задания, если их нет
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Организация", "GIS_EXP_DATA_PROVIDER_NSI_ITEM")) {
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, "GIS_EXP_DATA_PROVIDER_NSI_ITEM", "STP");
			// добавить как дочернее задание к системному повторяемому заданию
			ptb.addTaskPar("ГИС ЖКХ.Номер справочника", 1D, null, null, null);
			ptb.addAsChild("SYSTEM_RPT_REF_EXP");
			ptb.save();
			log.info("Добавлено задание по экспорту справочников организации по Организации Eolink.id={}", e.getId());
		};
		// Установить статус выполнения задания
		foundTask.setState("ACP");
		
	}
	
}
