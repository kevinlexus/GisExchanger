package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.cmn.excp.ErrorProcessAnswer;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HouseManagementAsyncBindingBuilders {

	void setUp(Task task) throws CantSendSoap, CantPrepSoap;
	Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	void exportDeviceDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod;
	Boolean exportContract(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean exportHouseData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportHouseDataAck(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;
	void exportAccountData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportAccountDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod, WrongParam;
	Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importAccountDataAck(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean importHouseUOData(Task task) throws CantPrepSoap, WrongGetMethod;
	void importHouseUODataAck(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importMeteringDeviceDataAck(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean exportCaChData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportCaChDataAck(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;
	void checkPeriodicHouseExp(Task task) throws WrongParam;
}
