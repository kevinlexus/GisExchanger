package com.ric.st.dao;

import java.util.Date;
import java.util.List;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;


public interface UlistDAO {

	public List<UlistTp> getListTp(String grp);
	public UlistTp getListTp(String grp, Eolink eolink, Integer fkExt);
	public int delListByParent(Ulist parent);
	public void delListByListTp(UlistTp ulistTp);
	public Ulist getListElem(String grp, Integer fkExt, String name, String s1);
	public Ulist getListElem(String cd, String name, String guid,Date dt1, Date dt2,
			Boolean actual, UlistTp ulistTp, Integer npp, String value, Ulist parent,
			String refCode, String refGuid, String tp);
	public Ulist getListElemByCd(String cd, Boolean actual);
    public Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org);	
}
