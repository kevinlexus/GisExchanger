package com.ric.st.mm;

import java.math.BigDecimal;
import java.text.ParseException;

import com.ric.dto.SumSaldoRecDTO;

/**
 * Интерфейс сервиса получения данных о задолженности, пени из разных источников
 * @author Lev
 *
 */
public interface DebMng {

	BigDecimal getPenAmnt(String lsk, String period) throws ParseException;
	SumSaldoRecDTO getSumSaldo(String lsk, String period, Integer appTp);
}
