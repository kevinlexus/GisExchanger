package com.ric.st;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;
import com.ric.st.impl.SoapBuilder;

public interface ReqProps {

	public void setVal(Task task, SoapBuilder sb);

	public Task getFoundTask();

	public String getHouseGuid();

	public String getPpGuid();

	public String getReu();

	public String getKul();

	public String getNd();
	
}