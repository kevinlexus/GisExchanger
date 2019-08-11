package com.ric.st.mm.impl;

import com.dic.bill.dto.OrgDTO;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.scott.Org;
import com.ric.st.mm.OrgMng;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    @Qualifier("OrgDAO_DWC")
    com.dic.bill.dao.OrgDAO orgDao2;

    /**
     * Получить DTO организации РКЦ
     * @param appTp - тип информационной системы
     */
    @Override
    public OrgDTO getOrgDTO(Integer appTp) {

        OrgDTO orgDto = null;
        if (appTp==0) {
            // старая разработка
        } else if (appTp==1) {
            // новая разработка
        } else if (appTp==2) {
            // экспериментальная разработка
            Org org = orgDao2.getByOrgTp("РКЦ");
            orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
            orgDto.setBik(org.getBik());
            orgDto.setInn(org.getInn());
            orgDto.setOperAcc(org.getOperAcc());
        }

        return orgDto;

    }

/**
 * Получить DTO организации
 * @param uk - Eolink УК
 */
	@Override
	public OrgDTO getOrgDTO(Eolink uk) {

		// Тип информационной системы
		//Integer appTp = uk.getAppTp();
		OrgDTO orgDto;
        //Org org = orgDao2.getByReu(uk.getReu());
        Org org = orgDao2.getByReu(uk.getOrg().getReu()); // ред.07.08.2019
        orgDto = new OrgDTO(org.getId(), org.getCd(), org.getName());
        orgDto.setBik(org.getBik());
        orgDto.setInn(org.getInn());
        orgDto.setOperAcc(org.getOperAcc());
        orgDto.setOperAccGis(org.getOperAccGis());

		return orgDto;
	}


}
