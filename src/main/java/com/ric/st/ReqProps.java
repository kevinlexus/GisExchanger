package com.ric.st;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.impl.SoapBuilder;

public interface ReqProps {

	void setProp(Task task, SoapBuilder sb) throws CantPrepSoap;

	void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap;

	Task getFoundTask();

	String getHouseGuid();

	String getReu();

	String getKul();

	String getNd();

	Eolink getOrg();

	Integer getAppTp();

	String getGisVersion();

}