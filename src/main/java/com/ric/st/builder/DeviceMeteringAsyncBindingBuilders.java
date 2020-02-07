package com.ric.st.builder;

import com.dic.bill.model.exs.Task;
import com.ric.cmn.excp.UnusableCode;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;
import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

public interface DeviceMeteringAsyncBindingBuilders {

	public GetStateResult getState2(Task task);
	public void setUp(Task task) throws CantSendSoap, CantPrepSoap;
	public Boolean importMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException;
	public void importMeteringDeviceValuesAsk(Task task) throws CantSendSoap, CantPrepSoap;
	public Boolean exportMeteringDeviceValues(Task task) throws CantPrepSoap, WrongGetMethod, DatatypeConfigurationException, WrongParam;
	public void exportMeteringDeviceValuesAsk(Task task) throws CantPrepSoap, WrongGetMethod, IOException, WrongParam, UnusableCode;
	public void checkPeriodicTask(Task task) throws WrongParam;
}
