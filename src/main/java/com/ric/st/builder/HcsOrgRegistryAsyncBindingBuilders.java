package com.ric.st.builder;

import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantSendSoap;

public interface HcsOrgRegistryAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public void exportDataProvider();	
	public void exportOrgRegistry(Task task, String reu);
	
}