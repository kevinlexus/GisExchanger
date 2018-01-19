package com.ric.st.builder;

import java.io.IOException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;


public interface HcsOrgRegistryAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public GetStateResult getState2(Task task);
	public void exportDataProvider();	
	public boolean exportOrgRegistry(Task task) throws CantPrepSoap;
	public void exportOrgRegistryAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam;
	public void checkPeriodicTask(Task task) throws WrongParam;
	
}