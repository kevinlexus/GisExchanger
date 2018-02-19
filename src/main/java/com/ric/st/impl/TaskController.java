package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ric.bill.RequestConfig;
import com.ric.bill.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.st.TaskControllers;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.HcsBillsAsyncBuilders;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HcsPaymentAsyncBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.NsiCommonAsyncBindingBuilders;
import com.ric.st.builder.NsiServiceAsyncBindingBuilders;
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
	private HcsBillsAsyncBuilders bill;
	@Autowired
	private HcsPaymentAsyncBuilders pay;
	@Autowired
	private TaskBuilders tb;
    @Autowired
	private ApplicationContext ctx;
	public Command sc;
	@Autowired
	private NsiServiceAsyncBindingBuilders nsiSv;

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
	 * @throws WrongParam 
	 */
	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap, WrongParam {

		
		
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
					case "GIS_CHECK_ORG_EXP_TASK":
						// Проверка наличия заданий по экспорту параметров организаций
						if (state.equals("INS")) {
							os.setUp();
							os.checkPeriodicTask(task);
						}
						break;
					case "GIS_CHECK_HOUSE_MET_TASK":
						// Проверка наличия заданий по экспорту показаний счетчиков
						if (state.equals("INS")) {
							dm.setUp();
							dm.checkPeriodicTask(task);
						}
						break;
					case "GIS_CHECK_HOUSE_EXP_TASK":
						// Проверка наличия заданий по экспорту объектов дома
						if (state.equals("INS")) {
							hb.setUp();
							hb.checkPeriodicTask(task);
						}
						break;
					case "GIS_CHECK_REF_EXP_TASK":
						// Проверка наличия заданий по экспорту справочников организации
						if (state.equals("INS")) {
							nsiSv.setUp();
							nsiSv.checkPeriodicTask(task);
						}
						break;
					case "GIS_SYSTEM_RPT":
						// Запуск повторяемого задания, если задано
						TaskPar taskPar = tb.getTrgTask(task);
						if (taskPar!= null) {
							log.info("******* Строка расписания, TaskPar.id={}", taskPar.getId());
							// добавить в список на выполнение
							tb.activateRptTask(task);
							// добавить в список выполненных заданий
							tb.setProcTask(taskPar);
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
						// Экспорт из ГИС ЖКХ объектов дома
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
						// Экспорт из ГИС ЖКХ лиц.счетов
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
					case "GIS_IMP_PAY_DOCS":
						bill.setUp();
						if (state.equals("INS")) {
							// Импорт платежных документов по дому
							bill.importPaymentDocumentData(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							bill.importPaymentDocumentDataAsk(task);
						}
						break;
					case "GIS_EXP_ORG":
						// Экспорт данных организации
						os.setUp();
						if (state.equals("INS")) {
							os.exportOrgRegistry(task);
						} else if (state.equals("ACK")) {
							os.exportOrgRegistryAsk(task);
						}						
						break;
					case "GIS_EXP_DATA_PROVIDER_NSI_ITEM":
						nsiSv.setUp();
						if (state.equals("INS")) {
							// Экспорт внутреннего справочника организации
							nsiSv.exportDataProviderNsiItem(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							nsiSv.exportDataProviderNsiItemAsk(task);
						}
						break;
					case "GIS_EXP_NOTIF_ORDER_EXECUT":
						// Экспорт извещений исполнения документа
						bill.setUp();
						if (state.equals("INS")) {
							// Импорт внутреннего справочника организации
							bill.exportNotificationsOfOrderExecution(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							bill.exportNotificationsOfOrderExecutionAsk(task);
						}
						
						break;
						
					case "GIS_IMP_NOTIF_ORDER_EXECUT_CANCEL":
						// Экспорт извещений исполнения документа
						pay.setUp();
						if (state.equals("INS")) {
							// Импорт внутреннего справочника организации
							pay.importNotificationsOfOrderExecutionCancelation(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							pay.importNotificationsOfOrderExecutionCancelationAsk(task);
						}
						
						break;

					default:
						log.error("Ошибка! Нет обработчика по заданию с типом={}", actCd);
						break;
					}
				
				} catch (ErrorProcessAnswer | DatatypeConfigurationException | CantPrepSoap e) {
					e.printStackTrace();
					log.error("Ошибка при отправке задания Task.id={}, message={}", task.getId(), 
							e.getMessage());
					//log.error("stackTrace={}", e.getStackTrace().toString());
					taskMng.setState(task, "ERR");
					taskMng.setResult(task, e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
					String errMess = StringUtils.substring(Utl.getStackTraceString(e), 0, 1000); 
					log.error("Ошибка выполнения задания Task.id={}, message={}", task.getId(), 
							errMess);
					//log.error("stackTrace={}", e.getStackTrace());
					if (!task.getAct().getCd().equals("GIS_SYSTEM_RPT")) {
						// не помечать ошибкой системные, повторяемые задания
						taskMng.setState(task, "ERR");
					}
					taskMng.setResult(task, errMess);
					
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
