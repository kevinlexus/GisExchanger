package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.dic.bill.mm.SaldoMng;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.excp.EmptyStorable;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.mm.TaskParMng;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.oralv.Ko;
import com.ric.st.TaskControllers;
import com.ric.st.builder.HcsOrgRegistryAsyncBindingBuilders;
import com.ric.st.builder.HouseManagementAsyncBindingBuilders;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.mm.TaskMng;
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
//	@Autowired
//	private SaldoMng saldoMng;
	public Command sc;

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

/*	private void updLs(Task task) throws WrongGetMethod, CantSendSoap {
		try {
			hb.addAccount();
		} catch (Fault | DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}*/
	
	
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

		


/*		log.info("Check String={}", Utl.replDays("Вт, Ср, Пт, Пн, Сб, Вс, Чт"));
		
		SimpleDateFormat formatter = new SimpleDateFormat("E");
		String str = formatter.format(Utl.getDateFromStr("24.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("25.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("26.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("27.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("28.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("29.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("30.07.2017"));
		log.info("Check Day={}", str);
		str = formatter.format(Utl.getDateFromStr("31.07.2017"));
		log.info("Check Day={}", str);
		*/
		
	/*	

		try {
			os.setUp();
			//os.exportDataProvider();
			os.exportOrgRegistry(null, "Y8");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("Получены параметры организации!");
		
		

		if (1==1) {
			return;
		}

		*/
		// инит. конфига
		if (!soapConf.setUp(false)) { //TODO отключил синхронизацию справочников
			// Ошибка обновления справочников
			return;
		}

		// ulistMng.showAll();
		
		log.info("******* searching for Tasks:");
		boolean flag = true;
		
		//hb.setUp();
		//hb.exportAccountData();

		// цикл
		while(flag) {

			// перебрать все необработанные действия
			for (Task task: taskDao.getAllUnprocessed()) {
				String objTp, objTpx="xxx";
				Integer appTp = task.getEolink().getAppTp();
				String actCd = task.getAct().getCd();
				String state = task.getState();  
				log.info("******* Task.id={}, act.cd={}, Task.state={}", task.getId(), actCd, state);
				if (appTp == 0) {
					// Квартплата
					objTp = task.getEolink().getObjTp().getCd();
					if (task.getEolink().getObjTpx() != null) {
						objTpx = task.getEolink().getObjTpx().getCd();
					}
				} else {
					// Новая разработка
					Ko ko = task.getEolink().getKoObj();
					objTp = ko.getAddrTp().getCd();
					
				}

				// Выполнить задание
				
				switch (actCd) {
				case "GIS_UPD_HOUSE":
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
				case "GIS_EXP_METER":
					log.info("******* Task={}, экспорт приборов учета", task.getId());
					// Экспорт из ГИС ЖКХ приборов учета
					hb.setUp();
					hb.exportDeviceData(task);
					
					break;
				case "GIS_ADD_ACC":
					hb.setUp();
					if (state.equals("INS")) {
						// Импорт лицевого счета
						hb.importAccountData(task);
					} else if (state.equals("ACK")) {
						// Запрос ответа
						hb.importAccountDataAck(task);
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
				
			}

		}
		
		
		
	}



}
