package com.ric.st;

import com.ric.bill.RequestConfig;
import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.excp.WrongParam;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface TaskControllers {

	public void otherTask();
	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap, WrongParam;
	public RequestConfig getReqConfig();
	
}
