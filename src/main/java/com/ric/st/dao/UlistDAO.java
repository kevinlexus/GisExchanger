package com.ric.st.dao;

import java.util.List;

import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Ulist;
import com.dic.bill.model.exs.UlistTp;


public interface UlistDAO {

	List<UlistTp> getListTp(String grp);
	UlistTp getListTp(String grp, Eolink eolink, Integer fkExt);
	int delListByParent(Ulist parent);
	void delListByListTp(UlistTp ulistTp);
	Ulist getListElem(String grp, Integer fkExt, String name, String s1);
	Ulist getListElemByGUID(String guid);

	Ulist getListElemByParent(Integer parentId, String name);

	Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org);
}
