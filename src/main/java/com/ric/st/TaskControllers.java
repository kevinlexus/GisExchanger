package com.ric.st;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface TaskControllers {

	public void otherTask();
	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap;
	
}
