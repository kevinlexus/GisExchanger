package com.ric.st.dto.impl;

import com.ric.bill.model.exs.Task;
import com.ric.st.dto.PrepDTOs;

/**
 * DTO данных дома
 * @author lev
 *
 */
public class HouseDTO extends BaseDTO implements PrepDTOs {

	// Конструктор
	public HouseDTO(Task task) {
		super(task);
	}
	
}
