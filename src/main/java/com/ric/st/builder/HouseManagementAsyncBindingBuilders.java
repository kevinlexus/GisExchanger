package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface HouseManagementAsyncBindingBuilders {

	void setUp() throws CantSendSoap;
	Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	void exportDeviceDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod;
	Boolean exportContract(Task task) throws CantPrepSoap;
	Boolean exportHouseData(Task task) throws CantPrepSoap;
	void exportHouseDataAck(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;
	void exportAccountData(Task task) throws CantPrepSoap;
	void exportAccountDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod, WrongParam;
	Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importAccountDataAck(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean importHouseUOData(Task task) throws CantPrepSoap, WrongGetMethod;
	void importHouseUODataAck(Task task) throws CantPrepSoap;
	Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importMeteringDeviceDataAck(Task task) throws CantPrepSoap;
	Boolean exportCaChData(Task task) throws CantPrepSoap;
	void exportCaChDataAck(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;
	void checkPeriodicHouseExp(Task task) throws WrongParam;
}
