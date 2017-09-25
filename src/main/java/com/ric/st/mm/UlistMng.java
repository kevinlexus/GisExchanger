package com.ric.st.mm;

import java.math.BigInteger;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;

import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.impl.RefStore;

public interface UlistMng {

	public Boolean setUp();
	public NsiItemType getNsi(String grp, BigInteger id) throws CantGetNSI;
	public NsiRef getNsiElem(String grp, Integer id, String name, String value);	
	public void loadNsi(String grp) throws CantUpdNSI;
	public RefStore getrStore();
	public void showAll();
	public NsiRef getResourceByUsl(String usl);
	public String getUslByResource(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef nsi);
	public Integer getResType(String usl);
}
