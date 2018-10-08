package com.ric.st.dto;

import java.util.Date;
import java.util.List;

import com.dic.bill.model.exs.Task;
import com.ric.st.dto.impl.BaseDTO.Error;

public interface PrepDTOs {
	public void setGuid(String guid);
	public String getGuid();
	public String getTransportGuid();
	public String getUnqNum();
	public void setUnqNum(String string);
	public List<Error> getLstError();
	public void addError(String errorCode, String description);
	public Task getTask();
	public void setTask(Task task);
	public Date getUpdDt();
	public void setUpdDt(Date dt);

}
