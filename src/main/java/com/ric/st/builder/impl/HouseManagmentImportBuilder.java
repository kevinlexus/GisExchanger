package com.ric.st.builder.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.builder.HouseManagmentImportBuilders;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HouseManagmentImportBuilder implements HouseManagmentImportBuilders {

    @PersistenceContext
    private EntityManager em;

	@Override
	public void taskExportHouse(Task task) {
		log.info("******* Task.id={}, экспорт всех объектов дома, запрос ответа", task.getId());
		Eolink eolink = task.getEolink();
		String reu = eolink.getReu();
		String kul = eolink.getKul();
		String nd = eolink.getNd();
		String sql = String.format("select exs.p_gis.process_house('%s', '%s', '%s') from dual", reu, kul, nd);
		String ret = em.createNativeQuery(sql).getSingleResult().toString();
		log.info("Sql result:"+ret);
	}

}
