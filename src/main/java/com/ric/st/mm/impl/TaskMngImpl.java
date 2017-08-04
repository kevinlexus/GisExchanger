package com.ric.st.mm.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.dao.TaskDAO;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.mm.TaskMng;

@Slf4j
@Service
public class TaskMngImpl implements TaskMng{

	@PersistenceContext
	private EntityManager em;

	@Autowired
	TaskDAO taskDAO;
	/**
	 * Установить статус и возвращаемые идентификаторы объектов
	 * @param task - Действие
	 * @param state - состояние
	 * @param guid - GUID, полученный от ГИС
	 * @param un - уникальный номер, полученный от ГИС
	 * @param upDt - дата обновления, полученная от ГИС
	 * @param msgGuid - GUID сообщения (задания), полученный от ГИС
	 */
/*	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void setTaskState(Task task, String state, String result, String guid, String un, Date updDt, String msgGuid) {
		task.setState(state);
		task.setResult(result);
		task.setGuid(guid);
		task.setUn(un);
		task.setUpdDt(updDt);
		task.setMsgGuid(msgGuid);
	}*/
	
	/**
	 * Установить идентификаторы объектов (если не заполненны)
	 * @param eolink - Объект
	 * @param guid - GUID, полученный от ГИС
	 * @param un - уникальный номер, полученный от ГИС
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void setEolinkIdf(Eolink eo, String guid, String un) {
		if (eo.getGuid() == null) {
			eo.setGuid(guid);
		}
		if (eo.getUn() == null) {
			eo.setUn(un);
		}
	}
	
	/**
	 * Вернуть задание по ID родительского задания и транспортному GUID
	 * @param - task - родительское задание
	 * @param - tguid - транспортный GUID
	 */
	public Task getByTguid(Task task, String tguid) {
		
		return taskDAO.getByTguid(task, tguid);
		
	}
	
}
