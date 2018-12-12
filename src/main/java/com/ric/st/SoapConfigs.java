package com.ric.st;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.sec.User;

public interface SoapConfigs {

	int getEnv();
	String getOrgPPGuid();
	String getHostIp();
	boolean isSrvTest();
	String getFingerPrint();
	String getBscLogin();
	String getBscPass();
	void setXmlLog();
	Boolean setUp(Boolean isLoadRef);
	User getCurUser();
	Eolink getRkcByHouse(Eolink eolink);
	void saveError(Eolink eolink, long err, boolean isSet);
}
