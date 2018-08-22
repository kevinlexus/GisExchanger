package com.ric.st.dao;

import java.util.Date;
import java.util.List;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;


public interface UlistDAO {

	List<UlistTp> getListTp(String grp);
	UlistTp getListTp(String grp, Eolink eolink, Integer fkExt);
	int delListByParent(Ulist parent);
	void delListByListTp(UlistTp ulistTp);
	Ulist getListElem(String grp, Integer fkExt, String name, String s1);
	Ulist getListElem(String cd, String name, String guid, Date dt1, Date dt2,
					  Boolean actual, UlistTp ulistTp, Integer npp, String value, Ulist parent,
					  String refCode, String refGuid, String tp);
	//public Ulist getListElemByCd(String cd, Boolean actual);
	Ulist getListElemByGUID(String guid);

	Ulist getListElemByParent(Integer parentId, String cd);

	Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org);
}
