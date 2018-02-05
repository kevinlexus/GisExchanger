package com.ric.st.dao;

import java.util.List;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;


public interface UlistDAO {

	public List<UlistTp> getListTp(String grp);
	public UlistTp getListTp(String grp, Eolink eolink, Integer fkExt);
	public void delListByListTp(UlistTp ulistTp);
	public Ulist getListElem(String grp, Integer fkExt, String name, String s1);
    public Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org);	
}
