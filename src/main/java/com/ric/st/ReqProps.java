package com.ric.st;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.impl.SoapBuilder;

public interface ReqProps {

	public void setProp(Task task, SoapBuilder sb) throws CantPrepSoap;

	public void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap;
		
	public Task getFoundTask();

	public String getHouseGuid();

	public String getPpGuid();

	public String getReu();

	public String getKul();

	public String getNd();
	
}