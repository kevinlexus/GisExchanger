package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ric.bill.Config;
import com.ric.bill.RequestConfig;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.TaskMng;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.cmn.Utl;
import com.ric.signature.sign.commands.Command;
import com.ric.st.TaskControllers;
import com.ric.st.builder.DeviceMeteringAsyncBindingBuilders;
import com.ric.st.builder.HcsBillsAsyncBuilders;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HcsPaymentAsyncBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.builder.NsiServiceAsyncBindingBuilders;
import com.ric.st.builder.TaskBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import lombok.extern.slf4j.Slf4j;


/**
 * Основной контроллер заданий
 * @author lev
 * @version 1.02
 *
 */
@Slf4j
@Service
public class TaskController implements TaskControllers {

	@Autowired
	private TaskDAO taskDao;
	@Autowired
	private TaskMng taskMng;
	@Autowired
	private Config config;
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
	public Command sc;
	@Autowired
	private NsiServiceAsyncBindingBuilders nsiSv;
    @Autowired
    private AmqpTemplate ampqTemplate;
    @Value("${ampqOn:true}")
    private boolean ampqOn;



	// конфиг запроса, сделал здесь, чтобы другие сервисы могли использовать один и тот же запрос
	private RequestConfig reqConfig;

	/**
	 * Задача распределения сальдо
	 */
	@Override
	public void otherTask() {
		log.info("otherTask started!");
		//saldoMng.distSalByChPay();
	}
	/**
     * Бин для слушателя сообщений ampq
     */
	@Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        log.info("Создание слушателя сообщений");
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("soap2gis-in");
        container.setMessageListener(new MessageListener() {
            @Override
			public void onMessage(Message message) {
                String msg = new String(message.getBody());
                rmqTask(msg);
                log.info("Rmq message:"+msg);
            }
        });
        return container;
    }
	/**
	 * Парсер запросов ampq
	 */
	private void rmqTask(String message) {
	    /*
	        message:
	                {"cmd":"exportMeteringDeviceValues",
	                  "data" :
	                      {
	                      "FIASHouseGuid" : "fiasguid",
	                      "meteringType" : "metering type",
	                      "resourceType" : "resource type",
	                      "rootGuid" : "root guid",
	                      "messageGuid" : "message guid",
	                      "orgGuid" : "org Guid",
	                      "date" : "dd-MM-yyyy"
	                      }
	                  }
	    */
	    ObjectMapper mapper = new ObjectMapper();
	    JsonNode json = null;
	    try {
            json = mapper.readTree(message);


            String cmd = json.has("cmd") ? json.get("cmd").asText() : null;

            if (cmd != null && json.has("data")
                    && cmd.equals("exportMeteringDeviceValues"))
                try {
                    dm.setUp();
                    String ret = dm.exportMeteringDeviceValuesSrv(json.get("data"));
                    if (ampqOn) ampqTemplate.convertAndSend("soap2gis-out", ret);
                } catch (Exception e) {
                    log.error("Ощибка при экспорте показаний счётчиков:"+e.getMessage());
                    e.printStackTrace();
                }
            else {
                log.error("rmqTask: не правильный json:{}",message);
            }
	    } catch (Exception e) {
            log.error("rmqTask: Ошибка парсинга json:"+e.getMessage());
        }
	}

	/**
	 * Поиск новых действий для обработки
	 * @throws WrongGetMethod
	 * @throws CantSendSoap
	 * @throws CantPrepSoap
	 * @throws WrongParam
	 * @ver 1.01
	 */
	@Override
	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap, WrongParam {

		this.reqConfig = new RequestConfig();
		this.reqConfig.setUp("0", "0", null, -1, null, null, null,
				config.getCurDt1(), config.getCurDt2());

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
			//log.info("******* начало обработки действий *******");
			for (Task task: taskDao.getAllUnprocessed()) {
				//log.info("task.id={}", task.getId());
				// Почистить результаты задания
				taskMng.clearAllResult(task);
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
					case "GIS_SYSTEM_CHECK" :
						// Системные задания проверок
						if (state.equals("INS")) {
							switch (task.getCd()) {
							case "SYSTEM_CHECK_HOUSE_EXP_TASK" :
								// Проверка наличия заданий по экспорту объектов дома
								hb.checkPeriodicHouseExp(task);
								break;
							case "SYSTEM_CHECK_HOUSE_MET_TASK" :
								// Проверка наличия заданий по экспорту счетчиков по помещениям дома
								hb.checkPeriodicMetExp(task);
								break;
							case "SYSTEM_CHECK_MET_VAL_TASK" :
								// Проверка наличия заданий по экспорту показаний счетчиков по помещениям дома
								dm.checkPeriodicTask(task);
								break;
							case "SYSTEM_CHECK_ORG_EXP_TASK" :
								// Проверка наличия заданий по экспорту параметров организаций
								os.checkPeriodicTask(task);
								break;
							case "SYSTEM_CHECK_REF_EXP_TASK" :
								// Проверка наличия заданий по экспорту справочников организации
								nsiSv.checkPeriodicTask(task);
								break;
							case "SYSTEM_CHECK_IMP_PD" :
								// Проверка наличия заданий по импорту ПД
								bill.checkPeriodicImpPd(task);
								break;
							case "SYSTEM_CHECK_IMP_SUP_NOTIF" :
								// Проверка наличия заданий по импорту Извещений по ПД
								pay.checkPeriodicSupplierImpNotif(task);
								break;
							case "SYSTEM_CHECK_IMP_SUP_NOTIF_CANCEL" :
								// Проверка наличия заданий по импорту отмены Извещений по ПД
								pay.checkPeriodicImpCancelNotif(task);
								break;
							}
						}
						break;
					case "GIS_SAVE_FILE_VALS":
						// Выгрузка показаний приборов учета в файл
						if (state.equals("INS")) {
							dm.saveValToFile(task);
						}
						break;
					case "GIS_SYSTEM_RPT":
						// Запуск повторяемого задания, если задано
						TaskPar taskPar = tb.getTrgTask(task);
						if (taskPar!= null) {
							// активировать все зависимые задания
							tb.activateRptTask(task);
							// добавить в список выполненных заданий
							tb.setProcTask(taskPar);
							// пометить статус повторяемого выполнения, на случай, если запускалось в ручную state--> "INS"
							if (task.getState().equals("INS")) {
								taskMng.setState(task, "RPT");
							}
						}
						//taskMng.setState(task, "ACP");
						break;
					case "GIS_UPD_HOUSE" :
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
					case "GIS_IMP_SUP_NOTIFS":
						pay.setUp();
						if (state.equals("INS")) {
							// Импорт извещений исполнения распоряжений
							pay.importSupplierNotificationsOfOrderExecution(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							pay.importSupplierNotificationsOfOrderExecutionAsk(task);
						}
						break;

					case "GIS_IMP_CANCEL_NOTIFS":
						// Экспорт отмены извещений исполнения документа
						pay.setUp();
						if (state.equals("INS")) {
							// Экспорт отмены извещений исполнения документа
							pay.importNotificationsOfOrderExecutionCancelation(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							pay.importNotificationsOfOrderExecutionCancelationAsk(task);
						}
						break;
					case "GIS_EXP_PAY_DETAIL_DOCS":
						pay.setUp();
						if (state.equals("INS")) {
							// экспорт детализации платежного документа
							pay.exportPaymentDocumentDetails(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							pay.exportPaymentDocumentDetailsAsk(task);
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

					case "GIS_EXP_NOTIF":
						// Экспорт извещений исполнения документа
						bill.setUp();
						if (state.equals("INS")) {
							// Экспорт извещений исполнения документа
							bill.exportNotificationsOfOrderExecution(task);
						} else if (state.equals("ACK")) {
							// Запрос ответа
							bill.exportNotificationsOfOrderExecutionAsk(task);
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
			//log.info("******* окончание обработки действий *******");

		}



	}

	@Override
	public RequestConfig getReqConfig() {
		return reqConfig;
	}

	public void setReqConfig(RequestConfig reqConfig) {
		this.reqConfig = reqConfig;
	}

}
