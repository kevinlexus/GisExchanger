package com.ric.st.builder;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface NsiServiceAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean exportDataProviderNsiItem(Task task) throws WrongGetMethod, DatatypeConfigurationException, CantPrepSoap;
	public void exportDataProviderNsiItemAsk(Task task) throws WrongGetMethod, IOException, CantPrepSoap, WrongParam;
	
}
