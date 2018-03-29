package com.ric.st.mm;

import java.util.List;

import com.ric.bill.dto.OrgDTO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.oralv.Ko;

/**
 * Интерфейс сервиса получения данных о начислении из разных источников
 * @author Lev
 *
 */
public interface ChrgMng {

	public List<SumChrgRec> getChrgGrp(String lsk, Ko ko, String period, Eolink uk);
}
