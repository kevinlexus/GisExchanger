package com.ric.st;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.impl.SoapBuilder;

public interface ReqProps {

    /*
     * Установить значения настроек до создания объекта SoapBuilder
     */
    void setPropBeforeSimple(Task task) throws CantPrepSoap;

    void setPropAfter(Task task);

	void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap;

	Task getFoundTask();

	String getHouseGuid();

	String getReu();

	String getKul();

	String getNd();

	//Eolink getOrg();

    Eolink getUk();

    Integer getAppTp();

	String getGisVersion();

	public String getPpGuid();
	public String getHostIp();

	void setPropBefore(Task task) throws CantPrepSoap;

    int getSignerId();
}