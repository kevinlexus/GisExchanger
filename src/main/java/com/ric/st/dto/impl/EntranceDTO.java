package com.ric.st.dto.impl;

import com.dic.bill.model.exs.Task;
import com.ric.st.dto.PrepDTOs;


/**
 * DTO данных подъезда
 * @author lev
 *
 */
public class EntranceDTO extends BaseDTO implements PrepDTOs {

	// Конструктор
	public EntranceDTO(Task task) {
		super(task);
	}

	// Номер подъезда
	private String num;

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}

}
