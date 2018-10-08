package com.ric.st.builder.impl;


import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dic.bill.dao.TaskDAO;
import com.ric.cmn.excp.WrongGetMethod;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.TaskPar;
import com.ric.cmn.Utl;
import com.ric.st.builder.TaskBuilders;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервисы обслуживания задач
 * @author lev
 * @version 1.1
 *
 */
@Slf4j
@Service
public class TaskBuilder implements TaskBuilders {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private TaskDAO taskDao;
	// расписание
	List<TaskPar> lstSched = new ArrayList<TaskPar>(20);
	// список сработавших событий в расписании
	List<Integer> lstTrg = new ArrayList<Integer>();
	// список обработанных событий в расписании
	List<Integer> lstTrgProc = new ArrayList<Integer>();

    /**
     * Активация повторяемого задания
     * @param - task - повторяемое задание
     * @throws WrongGetMethod
     */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void activateRptTask(Task task) throws WrongGetMethod {
		Task foundTask = em.find(Task.class, task.getId());
		//log.info("******* Task.id={}, Повторяемое задание", foundTask.getId());
		/* найти все связи с зависимыми записями, в заданиях которых нет родителя (главные),
		   а так же если у этих заданий либо не имеется зависимых заданий, либо имеются и
		   они НЕ находятся в статусах INS, ACK (т.е. на обработке)
		   (по определённому типу связи)
		*/
		foundTask.getInside().stream()
		.filter(t-> t.getTp().getCd().equals("Связь повторяемого задания"))
	    .filter(t-> t.getChild().getParent() == null) // только главные
	    .filter(t-> t.getChild().getMaster() == null) // только независимые
	    .forEach(t-> {
	    	// ведущее задание
			Task master = t.getChild().getMaster();
			// зависимые задания
			List<Task> slave = t.getChild().getSlave();
			// текущее задание
			Task current = t.getChild();
			if (!Utl.in(current.getState(), "INS", "ACK", "ERA" )) {
				// если не выполняется и без ошибки запроса статуса "ERA"
				if (master == null && slave.size() == 0) {
					// нет зависимых по DEP_ID заданий
			    	//log.info("------------Основное задание Task.id={} НЕТ Зависимых заданий по DEP_ID, ВКЛ!", current.getId());
			    	// и нет зависимых заданий, то поставить на выполнение
			    	current.setState("INS");
				} else {
		    		// есть зависимые задания, проверить их статусы
			    	//log.info("------------Основное задание Task.id={} Есть Зависимые по DEP_ID задания!", current.getId());
					if(slave.stream()
					    .filter(e -> Utl.in(e.getState(), "INS", "ACK", "ERA" )).count() == 0L) {
				    	// зависимые задания, не выполняются и без ошибки запроса статуса "ERA", поставить на выполнение основное и зависимые
				    	//log.info("------------Основное задание по DEP_ID Task.id={} Зависимые задания по DEP_ID НЕ выполняются, ВКЛ!", current.getId());
				    	current.setState("INS");
				    	slave.stream().forEach(e -> {
					    	//log.info("------------Зависимое задание по DEP_ID Task.id={}, ВКЛ!", e.getId());
					    	e.setState("INS");
				    	});
					} else {
				    	//log.info("------------Основное задание Task.id={} Зависимые задания по DEP_ID выполняются, НЕ ВКЛ!", current.getId());
					}
				}

			}

	    });
	}

    /**
     * Загрузка списка запланированных задач
     */
    @Scheduled(fixedDelay =20000)
    public void timer() {
    	loadSchedules();
    }

    /**
     * Загрузка списка запланированных задач
     */
    @Scheduled(fixedDelay =2000)
    public void timer2() {
    	//log.info("cheeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    /**
     * Определить статусы заданий
     * @throws java.text.ParseException
     */
    @Scheduled(fixedDelay =1000)
    public void checkSchedule() throws java.text.ParseException {
        Date dt = new Date();
		synchronized (lstSched) {
			for (TaskPar t : lstSched) {
				//log.info("Expression TaskPar.id={} s1={}", t.getId(), t.getS1());
				CronExpression exp = new CronExpression(t.getS1());
				// либо удовлетворено условие по дате-времени, либо ручной запуск state --> "INS"
				if (exp.isSatisfiedBy(dt) || t.getTask().getState().equals("INS")) {
					//log.info("Запустить задание!");
					// Запустить задание, если уже не запущено
					if (!lstTrg.contains(t.getId())) {
						//log.info("Задание запущено!");
						// добавить отметку о необходимости выполнения
						lstTrg.add(t.getId());
					} else {
						//log.info("Уже запущено!");
					}
				} else {
					// Убрать все отметки если есть отметка о выполнении задания
					if (lstTrgProc.contains(t.getId())) {
						//log.info("Убрать отметки!");

						for (Iterator<Integer> iter = lstTrg.listIterator(); iter.hasNext(); ) {
							if (iter.next().equals(t.getId())) {
								iter.remove();
							}
						}
						for (Iterator<Integer> iter = lstTrgProc.listIterator(); iter.hasNext(); ) {
							if (iter.next().equals(t.getId())) {
								iter.remove();
							}
						}
					}
				}
			}
		}
    }


    /**
     * Проверить, выполнять ли задание
     * @param task
     * @return
     * @return
     */
    @Override
	public TaskPar getTrgTask(Task task) {
    	// проверить, если поступило в обработку, но еще не выполнено
    	for (TaskPar t : task.getTaskPar().stream()
    			.filter(t-> t.getPar().getCd().equals("ГИС ЖКХ.Crone"))
    			.collect(Collectors.toList())) {
        	if (lstTrg.contains(t.getId()) && !lstTrgProc.contains(t.getId())) {
            	//log.info("..............Выполнить задание TaskPar.id={}", t.getId());
        		return t;
        	}
    	};
    	return null;
    }

    /**
     * Отметить выполненное задание
     * @param taskPar - параметр задания
     * @return
     */
    @Override
	public void setProcTask(TaskPar taskPar) {
    	//log.info("..............Попытка отметить что выполнено задание!");
    	//log.info("..............Попытка отметить что выполнено задание TaskPar.id={}", taskPar.getId());
    	// проверить, что еще не выполнено
    	if (!lstTrgProc.contains(taskPar.getId())) {
    		// добавить отметку о выполнении
        	lstTrgProc.add(taskPar.getId());
        	//log.info("..............Отмечено что выполнено задание TaskPar.id={}", taskPar.getId());
        	//log.info("..............Отмечено что выполнено задание!");
    	}
    }

    /**
     * Загрузить расписания работы всех заданий типа GIS_SYSTEM_RPT
     */
    private void loadSchedules() {
    	// Получить все параметры определённого типа по всем задачам
		synchronized (lstSched) {
			lstSched = new ArrayList<TaskPar>(0);
			List<Task> lstTask = taskDao.getByTp("GIS_SYSTEM_RPT").stream().collect(Collectors.toList());
			for (Task t : lstTask) {
				TaskPar par = t.getTaskPar().stream()
						.filter(d -> d.getPar().getCd().equals("ГИС ЖКХ.Crone"))
						.findFirst().orElse(null);
				if (par != null) {
					lstSched.add(par);
				} else {
					log.error("ОШИБКА! Не обнаружен параметр \"ГИС ЖКХ.Crone\" по повторояемому заданию с типом \"GIS_SYSTEM_RPT\"");
				}
			}
		}
    }

}