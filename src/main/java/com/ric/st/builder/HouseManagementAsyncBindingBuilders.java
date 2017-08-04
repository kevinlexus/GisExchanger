package com.ric.st.builder;

import java.util.List;

import ru.gosuslugi.dom.schema.integration.house_management.ImportResult;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.st.dto.impl.SoapMethodResult;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface HouseManagementAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean exportDeviceData(Task task);
	public Boolean exportContract(Task task);
	public Boolean exportHouseData(Task task);
	public void exportHouseDataAck(Task task);	
	public void exportAccountData();
	public Boolean importAccountData(Task task) throws WrongGetMethod, CantPrepSoap;	
	public void importAccountDataAck(Task task);
	public Boolean importHouseUOData(Task task) throws WrongGetMethod;
	public void importHouseUODataAck(Task task);
}
