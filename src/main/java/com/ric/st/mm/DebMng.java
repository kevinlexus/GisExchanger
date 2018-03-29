package com.ric.st.mm;

import java.math.BigDecimal;
import java.util.List;

import com.ric.bill.dto.OrgDTO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.dto.SumDebRec;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.oralv.Ko;

/**
 * Интерфейс сервиса получения данных о задолженности, пени из разных источников
 * @author Lev
 *
 */
public interface DebMng {

	public BigDecimal getDebAmnt(String lsk, Ko ko, String period, Eolink uk);
	public BigDecimal getPenAmnt(String lsk, Ko ko, String period, Eolink uk);
}
