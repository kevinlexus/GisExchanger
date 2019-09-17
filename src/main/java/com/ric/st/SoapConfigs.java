package com.ric.st;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.sec.User;
import com.ric.cmn.excp.UnusableCode;

public interface SoapConfigs {

    String getOrgPPGuid();

    String getHostIp();

    String getFingerPrint();

    String getBscLogin();

    String getBscPass();

    String getPrefixGis();

    Boolean setUp(Boolean isLoadRef);

    User getCurUser();

    Eolink getRkcByHouse(Eolink eolink);

    String getSignPass();

    String getSignPath();

    String getSignPass2();

    String getSignPath2();

    Integer getSignGOST();

    void saveError(Eolink eolink, long err, boolean isSet) throws UnusableCode;
}
