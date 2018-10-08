package com.ric.st.mm;

import java.util.List;

import com.dic.bill.dto.SumChrgRec;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.oralv.Ko;

/**
 * Интерфейс сервиса получения данных о начислении из разных источников
 * @author Lev
 *
 */
public interface ChrgMng {

	List<SumChrgRec> getChrgGrp(String lsk, Ko ko, String period, Eolink uk, Integer appTp);
}
