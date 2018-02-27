package com.ric.st.builder.impl;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

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
		//String sql = String.format("select exs.p_gis.process_house('%s', '%s', '%s') from dual", reu, kul, nd);
		//String ret = em.createNativeQuery(sql).getSingleResult().toString();
		
		// вызвать процедуру PL/SQL для подготовки импорта
		StoredProcedureQuery qr = em.createStoredProcedureQuery("exs.p_gis.process_house");
		qr.registerStoredProcedureParameter("P_REU", String.class, ParameterMode.IN);
		qr.registerStoredProcedureParameter("P_KUL", String.class, ParameterMode.IN);
		qr.registerStoredProcedureParameter("P_ND", String.class, ParameterMode.IN);
		qr.setParameter("P_REU", reu);
		qr.setParameter("P_KUL", kul);
		qr.setParameter("P_ND", nd);
				  
		qr.execute();		
		log.info("******* Task.id={}, подготовка задания для импорта объектов дома успешно выполнена!", task.getId());
		//log.info("Sql result:"+ret);
		// успешно выполнено
		foundTask.setState("ACP");
	}

}
