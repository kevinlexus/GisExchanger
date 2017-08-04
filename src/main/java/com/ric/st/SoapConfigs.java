package com.ric.st;


public interface SoapConfigs {

	public int getEnv();
	//public boolean getUseSign();
	public String getOrgPPGuid();
	public String getSrvTestHost();
	public boolean isSrvTest();
	public String getFingerPrint();
	public String getBscLogin();
	public String getBscPass();
	public void setXmlLog();
	public Boolean setUp(Boolean isLoadRef);
	
}
