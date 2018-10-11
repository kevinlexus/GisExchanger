package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.model.exs.Task;
import com.ric.cmn.excp.ErrorWhileDist;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface HcsBillsAsyncBuilders {

	void setUp(Task task) throws CantSendSoap;
	ru.gosuslugi.dom.schema.integration.bills.GetStateResult getState2(Task task);
	void exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	void exportNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap, WrongGetMethod, ErrorWhileDist, com.ric.cmn.excp.ErrorWhileDist;

	void exportPaymentDocumentData(Task task) throws CantPrepSoap, WrongGetMethod;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	void exportPaymentDocumentDataAsk(Task task) throws CantPrepSoap, WrongGetMethod;

	void importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	void importPaymentDocumentDataAsk(Task task) throws CantSendSoap, CantPrepSoap, WrongGetMethod;
	void checkPeriodicImpExpPd(Task task) throws WrongParam;
}