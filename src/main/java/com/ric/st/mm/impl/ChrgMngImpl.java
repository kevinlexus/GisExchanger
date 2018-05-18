package com.ric.st.mm.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementStringFieldType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemInfoType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.dic.bill.dao.AchargeDAO;
import com.diffplug.common.base.Errors;
import com.ric.cmn.Utl;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.ChrgDAO;
import com.ric.bill.dto.OrgDTO;
import com.ric.bill.dto.SumChrgRec;
import com.ric.bill.model.bs.Org;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;
import com.ric.bill.model.hotora.oralv.SchetContragent;
import com.ric.bill.model.oralv.Ko;
import com.ric.st.builder.NsiCommonAsyncBindingBuilders;
import com.ric.st.builder.NsiServiceAsyncBindingBuilders;
import com.ric.st.builder.impl.NsiCommonAsyncBindingBuilder;
import com.ric.st.dao.UlistDAO;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.impl.RefStore;
import com.ric.st.impl.SoapConfig;
import com.ric.st.mm.ChrgMng;
import com.ric.st.mm.OrgMng;
import com.ric.st.mm.UlistMng;

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
	 */
	@Override
	public List<SumChrgRec> getChrgGrp(String lsk, Ko ko, String period, Eolink uk) {
		List<SumChrgRec> lstSum = null;
		// Тип информационной системы
		Integer appTp = uk.getAppTp();
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
