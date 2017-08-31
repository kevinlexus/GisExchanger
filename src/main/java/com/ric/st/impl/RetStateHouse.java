package com.ric.st.impl;

import ru.gosuslugi.dom.schema.integration.house_management.GetStateResult;

// DTO объект
public class RetStateHouse {
	
	private ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state;
	private Boolean err;
	private String errStr;
	
	public RetStateHouse(GetStateResult state, Boolean err, String errStr) {
		super();
		setState(state);
		setErr(err);
		setErrStr(errStr);
	}
	
	public ru.gosuslugi.dom.schema.integration.house_management.GetStateResult getState() {
		return state;
	}
	public void setState(
			ru.gosuslugi.dom.schema.integration.house_management.GetStateResult state) {
		this.state = state;
	}
	public Boolean getErr() {
		return err;
	}
	public void setErr(Boolean err) {
		this.err = err;
	}
	public String getErrStr() {
		return errStr;
	}
	public void setErrStr(String errStr) {
		this.errStr = errStr;
	}

}
