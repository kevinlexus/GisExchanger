package com.ric.st.builder;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface DeviceMeteringAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean importMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void importMeteringDeviceValuesAsk(Task task) throws CantSendSoap, CantPrepSoap;
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void exportMeteringDeviceValuesAsk(Task task) throws CantPrepSoap, WrongGetMethod, IOException;
	public void saveValToFile(Task task) throws WrongGetMethod, IOException;
	
}
