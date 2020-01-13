package com.ric.st;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
import com.dic.bill.model.scott.Org;
import com.ric.st.excp.CantPrepSoap;
import com.ric.st.impl.SoapBuilder;

public interface ReqProps {

    void setPropBefore(Task task) throws CantPrepSoap;
    void setPropBeforeSimple(Task task) throws CantPrepSoap;

    void setPropAfter(Task task);

    void setPropWOGUID(Task task, SoapBuilder sb) throws CantPrepSoap;

    Task getFoundTask();

    String getHouseGuid();

    String getReu();

    String getKul();

    String getNd();

    Eolink getEolinkUk();

    Org getUk();

    String getGisVersion();

    String getPpGuid();

    String getHostIp();


    int getSignerId();
}