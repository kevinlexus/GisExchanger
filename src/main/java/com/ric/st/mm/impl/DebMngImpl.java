package com.ric.st.mm.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.ApenyaDAO;
import com.dic.bill.dao.SaldoUslDAO;
import com.dic.bill.model.oralv.Ko;
import com.ric.cmn.Utl;
import com.ric.dto.SumSaldoRec;
import com.ric.dto.SumSaldoRecDTO;
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
	private ApenyaDAO apenyaDao;
	@Autowired
	private SaldoUslDAO saldoUslDao;

	/**
	 * Получить сальдо на начало периода "period" из разных источников
	 * @author Lev
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param ko - Ko объект лиц.счета (обязательно для новой разраб.)
	 * @param period - период выборки
	 * @param appTp - тип информационной системы
	 */
	@Override
	public SumSaldoRecDTO getSumSaldo(String lsk, Ko ko, String period, Integer appTp) {
		SumSaldoRecDTO sal = null;
		if (appTp.equals(0)) {
			// старая разработка
		} else if (appTp.equals(1)) {
			// новая разработка
		} else if (appTp.equals(2)) {
			// экспериментальная разработка
			SumSaldoRec sumSaldoRec = saldoUslDao.getSaldoByLsk(lsk, period);
			sal = getSalAsDTO(sumSaldoRec);
		}
		return sal;
	}

	/**
	 * Преобразовать сальдо в DTO
	 * @param sumSaldoRec - запись сальдо
	 * @return
	 */
	private SumSaldoRecDTO getSalAsDTO(SumSaldoRec sumSaldoRec) {
		SumSaldoRecDTO sal;
		// сложить дебет и кредит, вх. сальдо
		BigDecimal inSal = Utl.nvl(sumSaldoRec.getIndebet(), BigDecimal.ZERO).add(
				Utl.nvl(sumSaldoRec.getInkredit(), BigDecimal.ZERO));
		// сложить дебет и кредит, исх. сальдо
		BigDecimal outSal = Utl.nvl(sumSaldoRec.getOutdebet(), BigDecimal.ZERO).add(
				Utl.nvl(sumSaldoRec.getOutkredit(), BigDecimal.ZERO));
		sal = SumSaldoRecDTO.SumSaldoRecDTOBuilder.aSumSaldoRecDTO()
		.withIndebet(sumSaldoRec.getIndebet())
		.withInkredit(sumSaldoRec.getInkredit())
		.withOutkredit(sumSaldoRec.getOutkredit())
		.withOutdebet(sumSaldoRec.getOutdebet())
		.withPayment(sumSaldoRec.getPayment())
		.withInSal(inSal)
		.withOutSal(outSal)
		.build();
		return sal;
	}

	/**
	 * Получить всю пеню по лиц.счету (основные услуги + дополнительные)
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param ko - Ko объект лиц.счета (обязательно для новой разраб.)
	 * @param period - период выборки
	 * @param appTp - тип информационной системы
	 *
	 */
	@Override
	public BigDecimal getPenAmnt(String lsk, Ko ko, String period, Integer appTp) {
		// пеня по основным услугам
		BigDecimal penMain = BigDecimal.ZERO;
		// пеня по капремонту
		BigDecimal penCap = BigDecimal.ZERO;
		//
		Date lastDate = Utl.getLastDate(Utl.getDateFromPeriod(period));
		if (appTp==0) {
			// старая разработка
		} else if (appTp==1) {
			// новая разработка
		} else if (appTp==2) {
			// экспериментальная разработка
			// получить всю пеню по лиц.счету
			penMain = apenyaDao.getPenAmnt(lsk, lastDate);
		}

		return penMain;
	}



}
