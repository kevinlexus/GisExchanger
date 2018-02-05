package com.ric.st.dto.impl;

// DTO результат выполенения Soap метода
public class SoapMethodResult {
	// Полученный уникальный номер
	String uniqNum;
	// Полученный GUID
	String guid;
	// Статус выполнения (true - успешно, false - с ошибкой)
	Boolean res;
	// Результат выполнения
	String result;

	public String getUniqNum() {
		return uniqNum;
	}
	public void setUniqNum(String uniqNum) {
		this.uniqNum = uniqNum;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Boolean getRes() {
		return res;
	}
	public void setRes(Boolean res) {
		this.res = res;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	
}
