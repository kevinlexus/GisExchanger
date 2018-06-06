package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HcsBillsAsyncBuilders {

	public void setUp() throws CantSendSoap;
	public ru.gosuslugi.dom.schema.integration.bills.GetStateResult getState2(Task task);
	public void exportNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void exportNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap;
	public void importPaymentDocumentData(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void importPaymentDocumentDataAsk(Task task) throws CantSendSoap, CantPrepSoap;
	public void checkPeriodicImpPd(Task task) throws WrongParam;
}