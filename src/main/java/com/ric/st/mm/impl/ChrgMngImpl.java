package com.ric.st.mm.impl;

import java.util.List;

import com.dic.bill.model.scott.Ko;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.AchargeDAO;
import com.dic.bill.dto.SumChrgRec;
import com.dic.bill.model.exs.Eolink;
import com.ric.st.mm.ChrgMng;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервис получения данных о начислении из разных источников
 * @author lev
 * @version 1.01
 *
 */
@Slf4j
@Service
public class ChrgMngImpl implements ChrgMng {

	@Autowired
	private AchargeDAO achrgDao;

	/**
	 * Получить записи начисления из разных источников
	 * @author Lev
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param ko - Ko объект лиц.счета (обязательно для новой разраб.)
	 * @param period - период выборки
	 * @param uk - УК из Eolink
	 * @param appTp - тип информационной системы
	 */
	@Override
	public List<SumChrgRec> getChrgGrp(String lsk, Ko ko, String period, Eolink uk, Integer appTp) {
		List<SumChrgRec> lstSum = null;
		if (appTp==0) {
			// старая разработка
		} else if (appTp==1) {
			// новая разработка
		} else if (appTp==2) {
			// экспериментальная разработка
			lstSum = achrgDao.getChrgGrp(lsk, Integer.valueOf(period), uk.getId());
		}
		return lstSum;
	}


}
