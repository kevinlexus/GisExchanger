package com.ric.st.dto.impl;

import com.dic.bill.model.exs.Task;
import com.ric.st.dto.PrepDTOs;


/**
 * DTO данных помещения
 * @author lev
 *
 */
public class KwDTO extends BaseDTO implements PrepDTOs {

	// Конструктор
	public KwDTO(Task task) {
		super(task);
	}

	// Номер квартиры
	private String num;
	// Номер подъезда
	private String entrNum;

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getEntrNum() {
		return entrNum;
	}
	public void setEntrNum(String entrNum) {
		this.entrNum = entrNum;
	}

}
