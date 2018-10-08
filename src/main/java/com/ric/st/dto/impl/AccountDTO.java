package com.ric.st.dto.impl;

import com.dic.bill.model.exs.Task;
import com.ric.st.dto.PrepDTOs;


/**
 * DTO данных лицевого счета
 * @author lev
 *
 */
public class AccountDTO extends BaseDTO implements PrepDTOs {

	// Конструктор
	public AccountDTO(Task task) {
		super(task);
	}

}
