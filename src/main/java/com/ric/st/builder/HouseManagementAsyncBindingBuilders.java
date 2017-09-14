package com.ric.st.builder;

import com.ric.bill.excp.ErrorProcessAnswer;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HouseManagementAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean exportDeviceData(Task task) throws CantPrepSoap;
	public void exportDeviceDataAck(Task task) throws ErrorProcessAnswer;
	public Boolean exportContract(Task task);
	public Boolean exportHouseData(Task task);
	public void exportHouseDataAck(Task task) throws WrongGetMethod;	
	public void exportAccountData(Task task);
	public void exportAccountDataAck(Task task) throws ErrorProcessAnswer;
	public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;	
	public void importAccountDataAck(Task task);
	public Boolean importHouseUOData(Task task) throws WrongGetMethod;
	public void importHouseUODataAck(Task task);
	public Boolean importMeteringDeviceData(Task task) throws WrongGetMethod, CantPrepSoap;
	public void importMeteringDeviceDataAck(Task task);
	
}
