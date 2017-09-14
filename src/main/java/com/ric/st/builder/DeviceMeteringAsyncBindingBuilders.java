package com.ric.st.builder;

import javax.xml.datatype.DatatypeConfigurationException;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface DeviceMeteringAsyncBindingBuilders {

	public void setUp() throws CantSendSoap;
	public Boolean importMeteringDeviceValues(Task task) throws WrongGetMethod, DatatypeConfigurationException;
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;	
}
