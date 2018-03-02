package com.ric.st.builder.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.ParDAO;
import com.ric.bill.dao.TaskDAO;
import com.ric.bill.dao.TaskToTaskDAO;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.mm.LstMng;
import com.ric.bill.mm.TaskEolinkParMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.bs.Par;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.bill.model.exs.TaskToTask;
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
	// 
	/* инициализация
	 * @param eolink - объект к которому привязано задание
	 * @param parent - родительское задание (не обязательный параметр)
	 * @param actCd - тип задания
	 * @param state - статус состояния
	 */
	public void setUp(Eolink eolink, Task parent, String actCd, String state) {
		Lst actVal = lstMng.getByCD(actCd);
		Integer userId = soapConfig.getCurUser().getId();

		task = new Task(eolink, parent, null, state, actVal,
				null, null, null, null, null, null, 0, userId);
		
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
		Lst lst = lstMng.getByCD("Связь повторяемого задания");
		TaskToTask t = new TaskToTask(parent, task, lst);
		parent.getInside().add(t);
		
	}

	/**
	 * Добавить задание как зависимое, в список выполнения другого задания
	 * @param parent - ведущее задание 
	 */
	@Override
	public void addAsChild(Task parent) {
		Lst lst = lstMng.getByCD("Связь повторяемого задания");
		TaskToTask t = new TaskToTask(parent, task, lst);
		parent.getInside().add(t);
		
	}

	@Override
	public Task getTask() {
		return task;
	}

}

