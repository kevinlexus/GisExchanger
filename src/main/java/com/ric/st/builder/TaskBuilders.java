package com.ric.st.builder;

import com.ric.cmn.excp.WrongGetMethod;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.exs.TaskPar;

public interface TaskBuilders {

	public void activateRptTask(Task task) throws WrongGetMethod;
	public TaskPar getTrgTask(Task task);
	public void setProcTask(TaskPar taskPar);
}
