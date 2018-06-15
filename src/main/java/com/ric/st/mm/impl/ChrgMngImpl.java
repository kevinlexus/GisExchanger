package com.ric.st.mm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.AchargeDAO;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.ChrgDAO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.oralv.Ko;
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
	private AflowDAO aflowDao;
	@Autowired
	private AchargeDAO achrgDao;
	@Autowired
	private ChrgDAO chrgDao;

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
			lstSum = aflowDao.getChrgGrp(lsk, period, uk.getId());
		} else if (appTp==1) {
			// новая разработка
			lstSum = chrgDao.getChrgGrp(ko.getId(), Integer.valueOf(period), uk.getId());
		} else if (appTp==2) {
			// экспериментальная разработка
			lstSum = achrgDao.getChrgGrp(lsk, Integer.valueOf(period), uk.getId());
		}
		return lstSum;
	}


}
