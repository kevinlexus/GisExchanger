package com.ric.st.mm;

import java.math.BigInteger;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.impl.RefStore;

public interface UlistMng {

	public Boolean setUp();
	public String getPrefixedCD(String cd, String grp);
	public NsiItemType getNsi(String grp, BigInteger id) throws CantGetNSI;
	public NsiRef getNsiElem(String grp, Integer id, String name, String value);	
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef 
			getNsiElem(String grp, Integer id, String name, String value, Eolink org);
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef 
			getNsiElem(Ulist elem);
	public void loadNsi(String grp) throws CantUpdNSI;
	public RefStore getrStore();
	public void showAll();
	public NsiRef getResourceByUsl(String usl);
	public String getUslByResource(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef nsi);
	public Integer getResType(String usl);
	public Integer mergeElement(UlistTp ulistTp, String grp, Integer id, NsiElementType t, Integer idx);

}
