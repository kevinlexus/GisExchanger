package com.ric.st.impl;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.bill.RequestConfig;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.st.TaskControllers;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.TaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.signature.demo.commands.Command;


@Slf4j
@Service
public class TaskController implements TaskControllers {

	@Autowired
	private TaskDAO taskDao; 
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
	private DeviceMeteringAsyncBindingBuilders dm;
	@Autowired
	private TaskBuilders tb;
    @Autowired
	private ApplicationContext ctx;
	public Command sc;

	// конфиг запроса, сделал здесь, чтобы другие сервисы могли использовать один и тот же запрос
	private RequestConfig reqConfig;	

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
		
		System.out.println("DATE="+new Date());
		System.out.println("TimeZone="+TimeZone.getDefault());
		
		log.info("******* searching for Tasks:");
		boolean flag = true;
		// цикл
		while(flag) {
			// перебрать все необработанные действия
			for (Task task: taskDao.getAllUnprocessed()) {
				String objTp, objTpx="xxx";
				//log.info("task.id={}", task.getId());
				// Почистить результаты задания
				taskMng.clearAllResult(task);
				Eolink eo = task.getEolink();
				
				Integer appTp = task.getAppTp();
				String actCd = task.getAct().getCd();
				String state = task.getState();  

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
					case "GIS_SAVE_FILE_VALS":
						// Выгрузка показаний приборов учета в файл
						if (state.equals("INS")) {
							dm.saveValToFile(task);
						}
						break;
					case "GIS_RPT":
						// Запуск повторяемого задания, если задано
						if (state.equals("INS")) {
							TaskPar taskPar = tb.getTrgTask(task);
							if (taskPar!= null) {
								log.info("******* Строка расписания, TaskPar.id={}", taskPar.getId());
								// активировать задание	
								tb.activateRptTask(task);
								// отметить задание выполненным
								tb.setProcTask(taskPar);
							}
						}
						break;
					case "GIS_UPD_HOUSE" :
					case "GIS_ADD_HOUSE" : 
						// Импорт объектов дома
						hb.setUp();
						if (state.equals("INS")) {
							// Обновление объектов дома
							hb.importHouseUOData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.importHouseUODataAck(task);
						}
						
						break;
					case "GIS_EXP_CONTR":
						// Экспорт из ГИС ЖКХ договора управления по указанному в EOLINK дому
						hb.setUp();
						hb.exportContract(task);
						
						break;
					case "GIS_EXP_HOUSE":
						hb.setUp();
						if (state.equals("INS")) {
							// Экспорт объектов дома
							hb.exportHouseData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							hb.exportHouseDataAck(task);
						}
						
						break;
					case "GIS_EXP_ACCS":
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
