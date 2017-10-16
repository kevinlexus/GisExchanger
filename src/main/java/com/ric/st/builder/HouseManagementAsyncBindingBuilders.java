package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HouseManagementAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean exportDeviceData(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void exportDeviceDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod;
	public Boolean exportContract(Task task) throws CantPrepSoap;
	public Boolean exportHouseData(Task task) throws CantPrepSoap;
	public void exportHouseDataAck(Task task) throws CantPrepSoap, WrongGetMethod, WrongParam;	
	public void exportAccountData(Task task) throws CantPrepSoap;
	public void exportAccountDataAck(Task task) throws CantPrepSoap, ErrorProcessAnswer, WrongGetMethod;
	public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;	
	public void importAccountDataAck(Task task) throws CantPrepSoap;
	public Boolean importHouseUOData(Task task) throws CantPrepSoap, WrongGetMethod;
	public void importHouseUODataAck(Task task) throws CantPrepSoap;
	public Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap;
	public void importMeteringDeviceDataAck(Task task) throws CantPrepSoap;
	
}
