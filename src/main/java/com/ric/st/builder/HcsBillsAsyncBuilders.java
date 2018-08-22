package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface HcsBillsAsyncBuilders {

	void setUp() throws CantSendSoap;
	ru.gosuslugi.dom.schema.integration.bills.GetStateResult getState2(Task task);
	void exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	void exportNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap;

	void exportPaymentDocumentData(Task task) throws CantPrepSoap;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	void exportPaymentDocumentDataAsk(Task task) throws CantPrepSoap;

	void importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	void importPaymentDocumentDataAsk(Task task) throws CantSendSoap, CantPrepSoap;
	void checkPeriodicImpExpPd(Task task) throws WrongParam;
}