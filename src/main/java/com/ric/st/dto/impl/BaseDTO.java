package com.ric.st.dto.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ric.cmn.Utl;
import com.ric.bill.model.exs.Task;
import com.ric.st.dto.PrepDTOs;

/**
 * Базовый класс объектов DTO
 * @author lev
 *
 */
public class BaseDTO implements PrepDTOs {

	// GUID
	private String guid;
	// Транспортный GUID (при обновлении)
	private String transportGuid;
	// Присвоенный уникальный номер из ГИС ЖКХ
	private String unqNum;
	// Список ошибок после отправки в ГИС ЖКХ
	private List<Error> lstError;
	// Задание
	private Task task;
	// Дата добавления/обновления
	private Date updDt;
	
	// Конструктор
	BaseDTO(Task task) {
		// Получить транспортный GUID
		setTransportGuid(Utl.getRndUuid().toString());
		//System.out.println("конструктор TGUID="+getTransportGuid());
		setLstError(new ArrayList<Error>());
		setTask(task);
	}

	// Класс ошибки
	public class Error {
		// Код ошибки из ГИС ЖКХ
		private String errorCode;
		// Описание ошибки из ГИС ЖКХ
		private String errorDesc;
		
		// Конструктор
		public Error(String errorCode, String errorDesc) {
			super();
			this.errorCode = errorCode;
			this.errorDesc = errorDesc;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorDesc() {
			return errorDesc;
		}

		public void setErrorDesc(String errorDesc) {
			this.errorDesc = errorDesc;
		}
	}
	
	
	public void setGuid(String guid) {
		this.guid = guid;
	}

	// private установить транспортный GUID!
	private void setTransportGuid(String transportGuid) {
		this.transportGuid = transportGuid;
	}

	public String getGuid() {
		return guid;
	}

	public String getTransportGuid() {
		return transportGuid;
	}

	public String getUnqNum() {
		return unqNum;
	}

	public void setUnqNum(String unqNum) {
		this.unqNum = unqNum;
	}

	public List<Error> getLstError() {
		return lstError;
	}

	public void addError(String errorCode, String description) {
		lstError.add(new Error(errorCode, description) );
	}

	// private метод
	private void setLstError(List<Error> lstError) {
		this.lstError = lstError;
	}
	
	public Date getUpdDt() {
	    return this.updDt;
	}

	public void setUpdDt(Date dt) {
		this.updDt = dt;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	
}
