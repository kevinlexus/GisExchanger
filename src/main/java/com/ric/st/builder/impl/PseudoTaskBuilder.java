package com.ric.st.builder.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.ParDAO;
import com.dic.bill.dao.TaskDAO;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.mm.LstMng;
import com.dic.bill.mm.TaskEolinkParMng;
import com.dic.bill.model.bs.Lst;
import com.dic.bill.model.bs.Par;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.TaskPar;
import com.dic.bill.model.exs.TaskToTask;
import com.ric.st.SoapConfigs;
import com.ric.st.builder.PseudoTaskBuilders;

import lombok.extern.slf4j.Slf4j;


/**
 * Построитель заданий
 * @author lev
 * @version 1.00
 *
 */
@Slf4j
@Service
public class PseudoTaskBuilder implements PseudoTaskBuilders {
	@Autowired
	private LstMng lstMng;
	@Autowired
	private SoapConfigs soapConfig;
	@Autowired
	private ParDAO parDao;
	@Autowired
	private TaskEolinkParMng teParMng;
    @PersistenceContext
    private EntityManager em;
	@Autowired
	private TaskDAO taskDao;

	private Task task;

	/* инициализация
	 * @param eolink - объект к которому привязано задание
	 * @param parent - родительское задание (необязательный параметр)
	 * @param actCd - тип задания
	 * @param state - статус состояния
	 */
	@Override
	public void setUp(Eolink eolink, Task parent, String actCd, String state, Integer userId) {
		setUp(eolink, parent, null, actCd, state, userId);
	}

	/* инициализация
	 * @param eolink - объект к которому привязано задание
	 * @param parent - родительское задание (необязательный параметр)
	 * @param parent - ведущее задание (необязательный параметр)
	 * @param actCd - тип задания
	 * @param state - статус состояния
	 */
	@Override
	public void setUp(Eolink eolink, Task parent, Task master, String actCd, String state, Integer userId) {
		Lst actVal = lstMng.getByCD(actCd);
//		Integer userId = soapConfig.getCurUser().getId();
		task = Task.builder()
			.withEolink(eolink)
			.withParent(parent)
			.withMaster(master)
			.withState(state)
			.withAct(actVal)
			.withFk_user(userId)
			.withErrAckCnt(0)
			.withTrace(0).build();
	}

	/**
	 * добавить параметр
	 * @param parCd - CD параметра
	 * @param n1 - значение Double
	 * @param s1 - значение String
	 * @param b1 - значение Boolean
	 * @param d1 - значение Date
	 * @throws WrongParam
	 */
	@Override
	public void addTaskPar (String parCd,  Double n1, String s1, Boolean b1, Date d1) throws WrongParam {
		Par par = parDao.getByCd(-1, parCd);
		if (!par.getDataTp().equals("SI")) {
			throw new WrongParam("Некорректное использоваение параметра ="+parCd+" тип - не SI");
		}

		Double valN1 = null;
		String valS1 = null;
		Date valD1 = null;

		if (par.getTp().equals("NM")) {
			if (s1!=null || b1!=null || d1!=null) {
				throw new WrongParam("Параметр ="+parCd+" имеет тип NM!");
			}
			valN1 = n1;
		} else if (par.getTp().equals("ST")) {
			if (n1!=null || b1!=null || d1!=null) {
				throw new WrongParam("Параметр ="+parCd+" имеет тип ST!");
			}
			valS1 = s1;
		} else if (par.getTp().equals("BL")) {
			if (n1!=null || s1!=null || d1!=null) {
				throw new WrongParam("Параметр ="+parCd+" имеет тип BL!");
			}
			if (b1) {
				valN1 = 1D;
			} else {
				valN1 = 0D;
			}

		} else if (par.getTp().equals("DT")) {
			if (n1!=null || s1!=null || b1!=null) {
				throw new WrongParam("Параметр ="+parCd+" имеет тип Dt!");
			}
			valD1 = d1;
		}

		TaskPar taskPar = new TaskPar(task, par, valN1, valS1, valD1);
		task.getTaskPar().add(taskPar);
	}

	// переписать параметры в объект Eolink
	@Override
	public void saveToEolink() {
		em.persist(task);
		teParMng.acceptPar(task);
	}

	@Override
	public void save() {
		em.persist(task);
	}

	/**
	 * Добавить задание как зависимое, в список выполнения другого задания
	 * @param cd - CD ведущее задания
	 */
	@Override
	public void addAsChild(String cd) {
		Task parent = taskDao.getByCd(cd);
		log.info("******* Прикреплено дочернее задание к родительскому Parent Task.id={}", parent.getId());
		Lst lst = lstMng.getByCD("Связь повторяемого задания");
		TaskToTask t = new TaskToTask(parent, task, lst);
		//parent.getInside().add(t);
		task.getOutside().add(t);
		log.info("******* parent.id={}, getInside().size()={}", parent.getId(), parent.getInside().size());
	}

	/**
	 * Добавить задание как зависимое, в список выполнения другого задания
	 * @param parent - ведущее задание
	 */
	@Override
	public void addAsChild(Task parent) {
		Lst lst = lstMng.getByCD("Связь повторяемого задания");
		TaskToTask t = new TaskToTask(parent, task, lst);
		task.getOutside().add(t);
	}

	@Override
	public Task getTask() {
		return task;
	}

}

