package com.ric.st.builder;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;

import com.fasterxml.jackson.databind.JsonNode;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;

public interface DeviceMeteringAsyncBindingBuilders {

	public GetStateResult getState2(Task task);
	public void setUp() throws CantSendSoap;
	public Boolean importMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void importMeteringDeviceValuesAsk(Task task) throws CantSendSoap, CantPrepSoap;
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void exportMeteringDeviceValuesAsk(Task task) throws CantPrepSoap, WrongGetMethod, IOException, WrongParam;
	public String exportMeteringDeviceValuesSrv(JsonNode json) throws CantPrepSoap, WrongGetMethod, IOException, WrongParam;
	public void saveValToFile(Task task) throws WrongGetMethod, IOException;
	public void checkPeriodicTask(Task task) throws WrongParam;	
}
