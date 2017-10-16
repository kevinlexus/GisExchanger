package com.ric.st.builder;

import java.util.Date;

import com.ric.bill.excp.WrongParam;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Task;

public interface PseudoTaskBuilders {

	public void setUp(Eolink eolink, Task parent, String actCd, String state);
	public void addTaskPar (String parCd,  Double n1, String s1, Boolean b1, Date d1) throws WrongParam;
	public void accept();
}
