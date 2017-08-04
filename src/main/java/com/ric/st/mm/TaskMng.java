package com.ric.st.mm;

import java.util.Date;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;


public interface TaskMng {

	//public void setTaskState(Task task, String state, String result, String guid, String un, Date updDt, String msgGuid);
	public void setEolinkIdf(Eolink eo, String guid, String un);
	public Task getByTguid(Task task, String tguid);
}
