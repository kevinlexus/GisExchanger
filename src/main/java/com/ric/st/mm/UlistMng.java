package com.ric.st.mm;

import java.math.BigInteger;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.impl.RefStore;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;

public interface UlistMng {

	Boolean setUp();
	String getPrefixedCD(String cd, String grp);
	NsiItemType getNsi(String grp, BigInteger id) throws CantGetNSI;
	NsiRef getNsiElem(String grp, Integer id, String name, String value);
	ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
			getNsiElem(String grp, Integer id, String name, String value, Eolink org);
	ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
			getNsiElem(Ulist elem);
	void loadNsi(String grp) throws CantUpdNSI;
	RefStore getrStore();
	void showAll();
	NsiRef getResourceByUsl(String usl);
	Integer getResType(String usl);
	Integer mergeElement(UlistTp ulistTp, String grp, Integer id, NsiElementType t, Integer idx);
	String getUslByResource(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef nsi);
	String getServCdByResource(NsiRef nsi);

}
