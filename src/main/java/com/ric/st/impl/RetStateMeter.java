package com.ric.st.impl;

import ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult;

// DTO объект
public class RetStateMeter {
	
	private GetStateResult state;
	private Boolean err;
	private String errStr;
	
	public RetStateMeter(ru.gosuslugi.dom.schema.integration.device_metering.GetStateResult state2, Boolean err, String errStr) {
		super();
		setState(state2);
		setErr(err);
		setErrStr(errStr);
	}
	
	public GetStateResult getState() {
		return state;
	}
	public void setState(
			GetStateResult state2) {
		this.state = state2;
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
