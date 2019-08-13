package com.ric.st.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.datatype.DatatypeConfigurationException;

import com.dic.bill.dao.AchargeDAO;
import com.ric.st.builder.*;
import com.ric.st.mm.UlistMng;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

//import com.ric.bill.Config;
import com.dic.bill.RequestConfig;
import com.dic.bill.dao.TaskDAO;
import com.ric.cmn.excp.ErrorProcessAnswer;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.mm.TaskMng;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.TaskPar;
import com.ric.cmn.Utl;
import com.ric.signature.sign.commands.Command;
import com.ric.st.TaskControllers;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import lombok.extern.slf4j.Slf4j;

import java.io.File;


/**
 * Основной контроллер заданий
 *
 * @author lev
 * @version 1.12
 */
@Slf4j
@Service
public class TaskController implements TaskControllers {

    @Autowired
    private TaskDAO taskDao;
    @Autowired
    private AchargeDAO achargeDAO;
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
    private HcsOrgRegistryAsyncBindingSimpleBuilders osSimple;
    @Autowired
    private DeviceMeteringAsyncBindingBuilders dm;
    @Autowired
    private HcsBillsAsyncBuilders bill;
    @Autowired
    private HcsPaymentAsyncBuilders pay;
    @Autowired
    private TaskBuilders tb;
    @Autowired
    private UlistMng ulistMng;
    public Command sc;
    @Autowired
    private NsiServiceAsyncBindingBuilders nsiSv;

    // конфиг запроса, сделал здесь, чтобы другие сервисы могли использовать один и тот же запрос
    private RequestConfig reqConfig;

    /**
     * Поиск новых действий для обработки
     *
     * @throws WrongGetMethod
     * @throws CantSendSoap
     * @throws CantPrepSoap
     * @throws WrongParam
     * @ver 1.01
     */
    @Override
    public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap, WrongParam {

        // инит. конфига
        if (!soapConf.setUp(false)) {
            log.error("ОШИБКА инициализации soapConf!");
            return;
        }
        log.info("******* searching for Tasks:");
        boolean flag = true;


/*
		log.info("******* TEST");
		achargeDAO.getChrgGrp("14043087", 201905, 707490).stream()
				.forEach(t-> {
					log.info("ulist={}, chrg={}, chng={}, price={}, sqr={}, ulistId={}, vol={}, norm={}",
							t.getUlist(), t.getChrg(), t.getChng(), t.getPrice(),
							t.getSqr(), t.getUlistId(), t.getVol(), t.getNorm());
				});
		log.info("******* TEST");

		if (1==1) throw new RuntimeException("TEST");
*/
        // цикл
        while (flag) {
            // перебрать все необработанные задания
            for (Task t : taskDao.getAllUnprocessed()) {
                // получить задание заново (могло измениться в базе)
                Task task = em.find(Task.class, t.getId());

                if (Utl.in(task.getState(), "INS", "ACK", "RPT") && task.isActivate()) {
                    // Почистить результаты задания
                    taskMng.clearAllResult(task);
                    String actCd = task.getAct().getCd();
                    String state = task.getState();

                    log.info("Task.actCd={}", actCd);
                    if (actCd.equals("GIS_IMP_ACCS") && !task.getEolink().getId().equals(898125)) {
                        return;
                    }
                    // Выполнить задание
                    try {
                        switch (actCd) {
                            case "GIS_SYSTEM_CHECK":
                                // Системные задания проверок
                                if (state.equals("INS")) {
                                    switch (task.getCd()) {
                                        case "SYSTEM_CHECK_HOUSE_EXP_TASK":
                                            // Проверка наличия заданий по экспорту объектов дома
                                            hb.checkPeriodicHouseExp(task);
                                            break;
                                        case "SYSTEM_CHECK_MET_VAL_TASK":
                                            // Проверка наличия заданий по экспорту показаний счетчиков по помещениям дома
                                            dm.checkPeriodicTask(task);
                                            break;
                                        case "SYSTEM_CHECK_ORG_EXP_TASK":
                                            // Проверка наличия заданий по экспорту параметров организаций
                                            os.checkPeriodicTask(task);
                                            break;
                                        case "SYSTEM_CHECK_REF_EXP_TASK":
                                            // Проверка наличия заданий по экспорту справочников организации
                                            nsiSv.checkPeriodicTask(task);
                                            break;
                                        case "SYSTEM_CHECK_IMP_PD":
                                            // Проверка наличия заданий по импорту ПД
                                            bill.checkPeriodicImpExpPd(task);
                                            break;
                                        case "SYSTEM_CHECK_IMP_SUP_NOTIF":
                                            // Проверка наличия заданий по импорту Извещений по ПД
                                            pay.checkPeriodicSupplierImpNotif(task);
                                            break;
                                        case "SYSTEM_CHECK_IMP_SUP_NOTIF_CANCEL":
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
                                if (taskPar != null) {
                                    // активировать все зависимые задания
                                    //log.info("******* Активировано повторяемое задание Task.id={}", task.getId());
                                    tb.activateRptTask(task);
                                    // добавить в список выполненных заданий
                                    tb.setProcTask(taskPar);
                                    // пометить статус повторяемого выполнения, на случай, если запускалось в ручную state--> "INS"
                                    if (task.getState().equals("INS")) {
                                        taskMng.setState(task, "RPT");
                                    }
                                }
                                break;
                            case "GIS_UPD_HOUSE":
                                // Импорт объектов дома
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    // Обновление объектов дома
                                    hb.importHouseUOData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.importHouseUODataAsk(task);
                                }

                                break;
                            case "GIS_EXP_CONTR":
                                // Экспорт из ГИС ЖКХ договора управления по указанному в EOLINK дому
                                hb.setUp(task);
                                hb.exportContract(task);

                                break;
                            case "GIS_EXP_CACH_DATA":
                                // Экспорт из ГИС ЖКХ уставов УК
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    // Экспорт уставов
                                    hb.exportCaChData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.exportCaChDataAsk(task);
                                }
                                break;
                            case "GIS_EXP_HOUSE":
                                // Экспорт из ГИС ЖКХ объектов дома
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    // Экспорт объектов дома
                                    hb.exportHouseData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.exportHouseDataAsk(task);
                                }
                                break;
                            case "GIS_EXP_ACCS":
                                // Экспорт из ГИС ЖКХ лиц.счетов
                                //hb.setUp(task);
                                if (state.equals("INS")) {
                                    hb.exportAccountData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.exportAccountDataAsk(task);
                                }
                                break;
                            case "GIS_EXP_METERS":
                                // Экспорт из ГИС ЖКХ приборов учета
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    hb.exportDeviceData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.exportDeviceDataAsk(task);
                                }
                                break;
                            case "GIS_IMP_ACCS":
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    // Импорт лицевых счетов
                                    hb.importAccountData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.importAccountDataAsk(task);
                                }
                                break;
                            case "GIS_IMP_METERS":
                                hb.setUp(task);
                                if (state.equals("INS")) {
                                    // Импорт счетчиков
                                    hb.importMeteringDeviceData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    hb.importMeteringDeviceDataAsk(task);
                                }
                                break;
                            case "GIS_IMP_METER_VALS":
                                dm.setUp(task);
                                if (state.equals("INS")) {
                                    // Импорт показаний счетчиков
                                    dm.importMeteringDeviceValues(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    dm.importMeteringDeviceValuesAsk(task);
                                }
                                break;
                            case "GIS_EXP_METER_VALS":
                                dm.setUp(task);
                                if (state.equals("INS")) {
                                    // Импорт показаний счетчиков
                                    dm.exportMeteringDeviceValues(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    dm.exportMeteringDeviceValuesAsk(task);
                                }
                                break;
                            case "GIS_IMP_PAY_DOCS":
                                //bill.setUp(task);
                                if (state.equals("INS")) {
                                    // Импорт платежных документов по дому
                                    bill.importPaymentDocumentData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    bill.importPaymentDocumentDataAsk(task);
                                }
                                break;
                            case "GIS_EXP_PAY_DOCS":
                                //bill.setUp(task);
                                if (state.equals("INS")) {
                                    // экспорт платежных документов по дому
                                    bill.exportPaymentDocumentData(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    bill.exportPaymentDocumentDataAsk(task);
                                }
                                break;
                            case "GIS_IMP_SUP_NOTIFS":
                                pay.setUp(task);
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
                                pay.setUp(task);
                                if (state.equals("INS")) {
                                    // Экспорт отмены извещений исполнения документа
                                    pay.importNotificationsOfOrderExecutionCancelation(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    pay.importNotificationsOfOrderExecutionCancelationAsk(task);
                                }
                                break;
                            case "GIS_EXP_PAY_DETAIL_DOCS":
                                pay.setUp(task);
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
                                osSimple.setUp(task);
                                if (state.equals("INS")) {
                                    osSimple.exportOrgRegistry(task);
                                } else if (state.equals("ACK")) {
                                    osSimple.exportOrgRegistryAsk(task);
                                }
                                break;
                            case "GIS_EXP_DATA_PROVIDER":
                                // Экспорт сведений о поставщиках данных
                                os.setUp(task);
                                if (state.equals("INS")) {
                                    os.exportDataProvider(task);
                                } else if (state.equals("ACK")) {
                                    os.exportDataProviderAsk(task);
                                }
                                break;
                            case "GIS_EXP_DATA_PROVIDER_NSI_ITEM":
                                nsiSv.setUp(task);
                                if (state.equals("INS")) {
                                    // Экспорт внутреннего справочника организации
                                    nsiSv.exportDataProviderNsiItem(task);
                                } else if (state.equals("ACK")) {
                                    // Запрос ответа
                                    nsiSv.exportDataProviderNsiItemAsk(task);
                                }
                                break;
                            case "GIS_EXP_COMMON_NSI_ITEM":
                                nsiSv.setUp(task);
                                if (state.equals("INS")) {
                                    // Экспорт общих справочников
                                    ulistMng.loadNsi("NSI");
                                    ulistMng.loadNsi("NSIRAO");
                                    taskMng.setState(task, "ACP");
                                }
                                break;
                            case "GIS_EXP_NOTIF_1":
                            case "GIS_EXP_NOTIF_8":
                            case "GIS_EXP_NOTIF_16":
                            case "GIS_EXP_NOTIF_24":
                                // Экспорт извещений исполнения документа по дням выгрузки
                                //bill.setUp(task);
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
                        taskMng.setState(task, "ERR");
                        taskMng.setResult(task, e.getMessage());
                    } catch (com.sun.xml.ws.client.ClientTransportException e) {
                        //log.error("Ошибка: ClientTransportException: Bad request либо необходимо проверить туннель!");
                        log.error("Ошибка выполнения задания Task.id={}, Bad request либо необходимо проверить туннель!",
                                task.getId());

                        //		Utl.getStackTraceString(e));
                    } catch (Exception e) {
                        log.error("Ошибка выполнения задания Task.id={}, message={}", task.getId(),
                                Utl.getStackTraceString(e));
                        String errMess = StringUtils.substring(Utl.getStackTraceString(e), 0, 1000);
                        //log.error("stackTrace={}", e.getStackTrace());
                        if (!task.getAct().getCd().equals("GIS_SYSTEM_RPT")) {
                            // не помечать ошибкой системные, повторяемые задания
                            taskMng.setState(task, "ERR");
                        }
                        taskMng.setResult(task, errMess);
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
