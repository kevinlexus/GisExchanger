package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.cmn.excp.ErrorProcessAnswer;
import com.ric.cmn.excp.UnusableCode;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.dic.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HouseManagementAsyncBindingBuilders {

	void setUp(Task task) throws CantSendSoap, CantPrepSoap;
	Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	void exportDeviceDataAsk(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod, UnusableCode;
	Boolean exportContract(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean exportHouseData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportHouseDataAsk(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam, UnusableCode;
	void exportAccountData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportAccountDataAsk(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod, WrongParam;
	Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importAccountDataAsk(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean importHouseUOData(Task task) throws CantPrepSoap, WrongGetMethod;
	void importHouseUODataAsk(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap;
	void importMeteringDeviceDataAsk(Task task) throws CantPrepSoap, WrongGetMethod;
	Boolean exportCaChData(Task task) throws CantPrepSoap, WrongGetMethod;
	void exportCaChDataAsk(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;
	void checkPeriodicHouseExp(Task task) throws WrongParam;
}
