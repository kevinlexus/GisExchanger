package com.ric.st.mm.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.ApenyaDAO;
import com.dic.bill.dao.SaldoUslDAO;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.hotora.SaldoDAO;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.oralv.Ko;
import com.ric.cmn.Utl;
import com.ric.st.mm.DebMng;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервис получения данных о задолженности, пени из разных источников
 * @author lev
 * @version 1.02
 *
 */
@Slf4j
@Service
public class DebMngImpl implements DebMng {

	@Autowired
	private SaldoDAO saldoDao;
	@Autowired
	private AflowDAO aflowDao;
	@Autowired
	private ApenyaDAO apenyaDao;
	@Autowired
	private SaldoUslDAO saldoUslDao;

	/**
	 * Получить сальдо на начало периода "period" из разных источников
	 * @author Lev
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param ko - Ko объект лиц.счета (обязательно для новой разраб.)
	 * @param period - период выборки
	 * @param uk - УК из Eolink
	 */
	@Override
	public BigDecimal getDebAmnt(String lsk, Ko ko, String period, Eolink uk) {
		BigDecimal sal = null;
		// Тип информационной системы
		Integer appTp = uk.getAppTp();
		//Date lastDate = Utl.getLastDate(Utl.getDateFromPeriod(period));
		if (appTp==0) {
			// старая разработка
			sal = saldoDao.getAmntByLsk(lsk, period);
		} else if (appTp==1) {
			// новая разработка
			// TODO
		} else if (appTp==2) {
			// экспериментальная разработка
			sal = saldoUslDao.getAmntByLsk(lsk, period);
		}
		return sal;
	}

	/**
	 * Получить всю пеню по лиц.счету (основные услуги + дополнительные)
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param ko - Ko объект лиц.счета (обязательно для новой разраб.)
	 * @param period - период выборки
	 * @param uk - УК из Eolink
	 *
	 */
	@Override
	public BigDecimal getPenAmnt(String lsk, Ko ko, String period, Eolink uk) {
		// пеня по основным услугам
		BigDecimal penMain = BigDecimal.ZERO;
		// пеня по капремонту
		BigDecimal penCap = BigDecimal.ZERO;
		// Тип информационной системы
		Integer appTp = uk.getAppTp();
		Date lastDate = Utl.getLastDate(Utl.getDateFromPeriod(period));
		if (appTp==0) {
			// старая разработка
			penMain = Utl.nvl(aflowDao.getPenAmnt(lsk, lastDate), BigDecimal.ZERO);
			penCap = Utl.nvl(aflowDao.getPenAmntByUsl(lsk, "073", lastDate), BigDecimal.ZERO);
			penMain.add(penCap);
		} else if (appTp==1) {
			// новая разработка
			// TODO
		} else if (appTp==2) {
			// экспериментальная разработка
			// получить всю пеню по лиц.счету
			penMain = apenyaDao.getPenAmnt(lsk, lastDate);
		}

		return penMain;
	}



}
