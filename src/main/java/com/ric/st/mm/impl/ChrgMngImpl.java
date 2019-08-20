package com.ric.st.mm.impl;

import java.util.List;

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

	private final AchargeDAO achrgDao;

	public ChrgMngImpl(AchargeDAO achrgDao) {
		this.achrgDao = achrgDao;
	}

	/**
	 * Получить записи начисления из разных источников
	 * @author Lev
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param period - период выборки
	 * @param uk - УК из Eolink
	 */
	@Override
	public List<SumChrgRec> getChrgGrp(String lsk, String period, Eolink uk) {
		List<SumChrgRec> lstSum;
		lstSum = achrgDao.getChrgGrp(lsk, Integer.valueOf(period), uk.getId());
		return lstSum;
	}


}
