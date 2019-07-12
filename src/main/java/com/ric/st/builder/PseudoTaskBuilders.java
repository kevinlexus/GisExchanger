package com.ric.st.builder;

import java.util.Date;

import com.ric.cmn.excp.WrongParam;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;

public interface PseudoTaskBuilders {

//	public void setUp(Eolink eolink, Task parent, String actCd, String state);
//	public void setUp(Eolink eolink, Task parent, Task master, String actCd, String state);

	/* инициализация
     * @param eolink - объект к которому привязано задание
     * @param parent - родительское задание (необязательный параметр)
     * @param actCd - тип задания
     * @param state - статус состояния
     */
	void setUp(Eolink eolink, Task parent, String actCd, String state, Integer userId);

	/* инициализация
    * @param eolink - объект к которому привязано задание
    * @param parent - родительское задание (необязательный параметр)
    * @param parent - ведущее задание (необязательный параметр)
    * @param actCd - тип задания
    * @param state - статус состояния
    */
    void setUp(Eolink eolink, Task parent, Task master, String actCd, String state, Integer userId, Eolink eolinkUk);

    public void addTaskPar (String parCd, Double n1, String s1, Boolean b1, Date d1) throws WrongParam;
	public void saveToEolink();
	public void save();
	public void addAsChild(String string);
	public void addAsChild(Task parent);
	public Task getTask();
}
