package com.ric.st.builder;

import com.ric.bill.excp.WrongGetMethod;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;

public interface TaskBuilders {

	public void activateRptTask(Task task) throws WrongGetMethod;
	public TaskPar getTrgTask(Task task);
	public void setProcTask(TaskPar taskPar);
}
