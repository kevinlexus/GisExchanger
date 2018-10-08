package com.ric.st;

import com.dic.bill.RequestConfig;
import com.ric.cmn.excp.WrongGetMethod;
import com.ric.cmn.excp.WrongParam;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.excp.CantSendSoap;

public interface TaskControllers {

	public void searchTask() throws WrongGetMethod, CantSendSoap, CantPrepSoap, WrongParam;
	public RequestConfig getReqConfig();

}
