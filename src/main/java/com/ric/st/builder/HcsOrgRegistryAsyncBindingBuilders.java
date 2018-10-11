package com.ric.st.builder;

import com.ric.cmn.excp.WrongParam;
import com.dic.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import ru.gosuslugi.dom.schema.integration.organizations_registry_common.GetStateResult;


public interface HcsOrgRegistryAsyncBindingBuilders {

	void setUp(Task task) throws CantSendSoap, CantPrepSoap;
	GetStateResult getState2(Task task);
	boolean exportOrgRegistry(Task task) throws CantPrepSoap;
	void exportOrgRegistryAsk(Task task) throws CantPrepSoap;
	void checkPeriodicTask(Task task) throws WrongParam;
	boolean exportDataProvider(Task task) throws CantPrepSoap;
	void exportDataProviderAsk(Task task) throws CantPrepSoap;

}