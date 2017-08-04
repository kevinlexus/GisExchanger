package com.ric.st.builder;

import java.math.BigInteger;

import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiListResult;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;

public interface NsiBindingBuilders {

	public ExportNsiListResult getNsiList(String tp) throws Fault, CantSignSoap, CantSendSoap;
	public ExportNsiItemResult getNsiItem(String TypeList,BigInteger TypeItem) throws Fault, CantSignSoap, CantSendSoap;
	
}
