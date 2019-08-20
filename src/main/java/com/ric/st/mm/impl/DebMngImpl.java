package com.ric.st.mm.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dic.bill.dao.ApenyaDAO;
import com.dic.bill.dao.SaldoUslDAO;
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

	private final ApenyaDAO apenyaDao;
	private final SaldoUslDAO saldoUslDao;

	public DebMngImpl(ApenyaDAO apenyaDao, SaldoUslDAO saldoUslDao) {
		this.apenyaDao = apenyaDao;
		this.saldoUslDao = saldoUslDao;
	}

	/**
	 * Получить сальдо на начало периода "period" из разных источников
	 * @author Lev
	 * @param lsk - лиц.счет (необязательно для новой разраб.)
	 * @param period - период выборки
	 * @param appTp - тип информационной системы
	 */
	@Override
	public SumSaldoRecDTO getSumSaldo(String lsk, String period, Integer appTp) {
		SumSaldoRecDTO sal;
		SumSaldoRec sumSaldoRec = saldoUslDao.getSaldoByLsk(lsk, period);
		sal = getSalAsDTO(sumSaldoRec);
		return sal;
	}

	/**
	 * Преобразовать сальдо в DTO
	 * @param sumSaldoRec - запись сальдо
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
	 * @param period - период выборки
	 *
	 */
	@Override
	public BigDecimal getPenAmnt(String lsk, String period) throws ParseException {
		// пеня по основным услугам
		BigDecimal penMain;
		// пеня по капремонту
		Date lastDate = Utl.getLastDate(Utl.getDateFromPeriod(period));
		// получить всю пеню по лиц.счету
		penMain = apenyaDao.getPenAmnt(lsk, lastDate);

		return penMain;
	}



}
