package com.ric.st.mm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ric.bill.dto.OrgDTO;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.hotora.oralv.SchetContragent;
import com.ric.st.mm.OrgMng;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервис справочника организации из разных источников
 * @author lev
 * @version 1.00
 *
 */
@Service("OrgMng_Soap2Gis")
@Slf4j
public class OrgMngImpl implements OrgMng {

@Autowired
@Qualifier("OrgDAO_BWC")
com.ric.bill.dao.OrgDAO orgDao;

@Autowired
@Qualifier("OrgDAO_DWC")
com.dic.bill.dao.OrgDAO orgDao2;

@Autowired
@Qualifier("OrgDAO_BWC_hotora")
com.ric.bill.dao.hotora.OrgDAO orgDao3;

/**
 * Получить DTO организации РКЦ
 * @param appTp - тип информационной системы
 */
@Override
public OrgDTO getOrgDTO(Integer appTp) {

	OrgDTO orgDto = null;
	if (appTp==0) {
		// старая разработка
		log.info("================CHECK");
		com.ric.bill.model.hotora.oralv.Org org = orgDao3.getByCD("МП \"РИЦ\"");
		orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
		SchetContragent schetContr = org.getSchetContr();
		orgDto.setBik(schetContr.getBik());
		orgDto.setInn(schetContr.getInn());
		orgDto.setOperAcc(schetContr.getOperAcc());
	} else if (appTp==1) {
		// новая разработка
		Org org = orgDao.getByCD("МП \"РИЦ\"");

		orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
		orgDto.setBik(org.getBik());
		orgDto.setInn(org.getInn());
		orgDto.setOperAcc(org.getOperAcc());
	} else if (appTp==2) {
		// экспериментальная разработка
		com.dic.bill.model.scott.Org org = orgDao2.getByOrgTp("РКЦ");

		orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
		orgDto.setBik(org.getBik());
		orgDto.setInn(org.getInn());
		orgDto.setOperAcc(org.getOperAcc());
	}

	return orgDto;

}

/**
 * Получить DTO организации - пока закомментировал, не удалять! Lev 21.03.2018
 * @param eolinkUk - Eolink УК
 */
/*	@Override
	public OrgDTO getOrgDTO(Eolink uk) {

		// Тип информационной системы
		Integer appTp = uk.getAppTp();
		OrgDTO orgDto;
		if (appTp==0) {
			// старая разработка

		} else if (appTp==2) {
			// новая разработка
			Org org = orgDao.getByKlsk(uk.getKoObj().getId());
			orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
			orgDto.setBik(org.getBik());
			orgDto.setInn(org.getInn());
			orgDto.setOperAcc(org.getOperAcc());
		} else if (appTp==2) {
			// экспериментальная разработка
			com.dic.bill.model.scott.Org org = orgDao2.getByReu(uk.getReu());
			orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
			orgDto.setBik(org.getBik());
			orgDto.setInn(org.getInn());
			orgDto.setOperAcc(org.getOperAcc());
		}

		return orgDto;
	} */


}
