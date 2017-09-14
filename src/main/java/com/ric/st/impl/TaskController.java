package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
//import com.dic.bill.mm.SaldoMng;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.TaskControllers;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.impl.DeviceMeteringAsyncBindingBuilder;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.bill.mm.TaskMng;
import com.ric.st.mm.UlistMng;

@Slf4j
@Service
public class TaskController implements TaskControllers {

	@Autowired
	private TaskDAO taskDao; 
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private UlistMng ulistMng;
	@Autowired
	private TaskParMng actParMng;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private SoapConfig soapConf;
	@PersistenceContext
    private EntityManager em;
	@Autowired
	private HouseManagementAsyncBindingBuilders hb;
	@Autowired
	private HcsOrgRegistryAsyncBindingBuilders os;
	@Autowired
	private DeviceMeteringAsyncBindingBuilder dm;
	@Autowired
	private ApplicationContext ctx;
	
	public Command sc;

	// конфиг запроса, сделал здесь, чтобы другие сервисы могли использовать один и тот же запрос
	private RequestConfig reqConfig;	
	/**
	 * Выполнить инициализацию объекта 
	 * @return 
	 * @throws EmptyStorable
	 */
	boolean checkNsiUpdates() {
		// проверить обновление справочников
		try {
			ulistMng.refreshNsi("NSI");
			ulistMng.refreshNsi("NSIRAO");
		} catch (Exception e) {
			// сообщение об ошибке
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Задача распределения сальдо
	 */
	public void otherTask() {
		log.info("otherTask started!");
		//saldoMng.distSalByChPay();
	}
	
	/**
	 * Поиск новых действий для обработки 
	 * @throws WrongGetMethod 
	 * @throws CantSendSoap 
	 * @throws CantPrepSoap 
	 */
	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap {
	
		this.reqConfig = ctx.getBean(RequestConfig.class);
		this.reqConfig.setUp("0", "0", null, -1, null, null);
		
		// инит. конфига
		if (!soapConf.setUp(false)) { //TODO отключил синхронизацию справочников
			// Ошибка обновления справочников
			return;
		}

		log.info("******* searching for Tasks:");
		boolean flag = true;
		// цикл
		while(flag) {

			// перебрать все необработанные действия
			for (Task task: taskDao.getAllUnprocessed()) {
				String objTp, objTpx="xxx";
				log.info("task.id={}", task.getId());
				// Почистить результаты задания
				taskMng.clearAllResult(task);
				Eolink eo = task.getEolink();
				
				Integer appTp = task.getAppTp();
				String actCd = task.getAct().getCd();
				String state = task.getState();  
				log.info("******* Task.id={}, act.cd={}, Task.state={}", task.getId(), actCd, state);

				/*if (appTp == 0) {
					// Квартплата
					objTp = task.getEolink().getObjTp().getCd();
					if (task.getEolink().getObjTpx() != null) {
						objTpx = task.getEolink().getObjTpx().getCd();
					}
				} else {
					// Новая разработка
					Ko ko = task.getEolink().getKoObj();
					objTp = ko.getAddrTp().getCd();
				}*/

				// Выполнить задание
				
				try {
					switch (actCd) {
					case "GIS_IMP_HOUSE":
						hb.setUp();
						if (state.equals("INS")) {
							// Обновление объектов дома
							log.info("******* Task={}, Обновление объектов дома", task.getId());
							hb.importHouseUOData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.importHouseUODataAck(task);
						}
						
						break;
					case "GIS_EXP_CONTR":
						// Экспорт из ГИС ЖКХ договора управления по указанному в EOLINK дому
						log.info("******* Task={}, экспорт договора управления", task.getId());
						hb.setUp();
						hb.exportContract(task);
						
						break;
					case "GIS_EXP_HOUSE":
						hb.setUp();
						if (state.equals("INS")) {
							// Экспорт объектов дома
							log.info("******* Task={}, экспорт объектов дома - начало", task.getId());
							hb.exportHouseData(task);
							log.info("******* Task={}, экспорт объектов дома - окончание", task.getId());
							
						} else if (state.equals("ACK")) {
							// Запрос ответа
							log.info("******* Task={}, Запрос ответа по экспорту объектов дома - начало", task.getId());
							hb.exportHouseDataAck(task);
							log.info("******* Task={}, Запрос ответа по экспорту объектов дома - окончание", task.getId());
						}
						
						break;
					case "GIS_EXP_ACCS":
						log.info("******* Task={}, экспорт лицевых счетов", task.getId());
						// Экспорт из ГИС ЖКХ приборов учета
						hb.setUp();
						if (state.equals("INS")) {
							hb.exportAccountData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.exportAccountDataAck(task);
						}
						break;
					case "GIS_EXP_METERS":
						log.info("******* Task={}, экспорт приборов учета", task.getId());
						// Экспорт из ГИС ЖКХ приборов учета
						hb.setUp();
						if (state.equals("INS")) {
							hb.exportDeviceData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.exportDeviceDataAck(task);
						}
						break;
					case "GIS_IMP_ACCS":
						hb.setUp();
						if (state.equals("INS")) {
							// Импорт лицевых счетов
							hb.importAccountData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.importAccountDataAck(task);
						}
						break;
					case "GIS_IMP_METERS":
						hb.setUp();
						if (state.equals("INS")) {
							// Импорт счетчиков
							hb.importMeteringDeviceData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.importMeteringDeviceDataAck(task);
						}
						break;
					case "GIS_IMP_METER_VALS":
						dm.setUp();
						if (state.equals("INS")) {
							// Импорт показаний счетчиков
							dm.importMeteringDeviceValues(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							dm.importMeteringDeviceValuesAsk(task);
						}
						break;
					case "GIS_EXP_METER_VALS":
						dm.setUp();
						if (state.equals("INS")) {
							// Импорт показаний счетчиков
							dm.exportMeteringDeviceValues(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							dm.exportMeteringDeviceValuesAsk(task);
						}
						break;
					case "GIS_EXP_ORG":
						// Экспорт данных организации
						os.setUp();
						os.exportOrgRegistry(task, null);
						
						break;
					default:
						log.error("Ошибка! Нет обработчика по заданию с типом={}", actCd);
						break;
					}
				
				} catch (ErrorProcessAnswer | DatatypeConfigurationException | CantPrepSoap e) {
					e.printStackTrace();
					log.error("Ошибка при отправке задания Task.id={}, message={}", e.getStackTrace());
					taskMng.setState(task, "ERR");
					taskMng.setResult(task, e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					log.error("Ошибка обработки задания Task.id={}, message={}", e.getStackTrace());
					taskMng.setState(task, "ERR");
					taskMng.setResult(task, e.getMessage());
					
				}

			}

		}
		
		
		
	}

	public RequestConfig getReqConfig() {
		return reqConfig;
	}

	public void setReqConfig(RequestConfig reqConfig) {
		this.reqConfig = reqConfig;
	}

}
