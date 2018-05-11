package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import ru.gosuslugi.dom.schema.integration.payment.GetStateResult;

public interface HcsPaymentAsyncBuilders {

	public void setUp() throws CantSendSoap;
	public GetStateResult getState2(Task task);
	public Boolean importNotificationsOfOrderExecutionCancelation(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void importNotificationsOfOrderExecutionCancelationAsk(Task task) throws CantPrepSoap;
	public void importSupplierNotificationsOfOrderExecution(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void importSupplierNotificationsOfOrderExecutionAsk(Task task) throws CantPrepSoap;
	public Boolean exportPaymentDocumentDetails(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void exportPaymentDocumentDetailsAsk(Task task) throws CantPrepSoap;	
}