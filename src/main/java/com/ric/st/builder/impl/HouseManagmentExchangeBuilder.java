package com.ric.st.builder.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.ReqProps;
import com.ric.st.builder.HouseManagmentExchangeBuilders;

import lombok.extern.slf4j.Slf4j;

/**
 * Методы для работы по обмену информацией по дому с ГИС
 * @author Lev
 * @version 1.00
 * 
 */
@Service
@Slf4j
public class HouseManagmentExchangeBuilder implements HouseManagmentExchangeBuilders {

    @PersistenceContext
    private EntityManager em;

	/**
	 * Подготовка задания для импорта объектов дома
	 * @author Lev
	 */
    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void prepTaskImportHouse(Task task) {
		log.info("******* Task.id={}, подготовка задания для импорта объектов дома", task.getId());
		Task foundTask = em.find(Task.class, task.getId());
		Eolink eolink = task.getEolink();
		String reu = eolink.getReu();
		String kul = eolink.getKul();
		String nd = eolink.getNd();
		String sql = String.format("select exs.p_gis.process_house('%s', '%s', '%s') from dual", reu, kul, nd);
		String ret = em.createNativeQuery(sql).getSingleResult().toString();
		log.info("Sql result:"+ret);
		// успешно выполнено
		foundTask.setState("ACP");
	}

}
