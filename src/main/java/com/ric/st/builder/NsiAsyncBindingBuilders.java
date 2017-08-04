package com.ric.st.builder;

import java.math.BigInteger;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiListType;
import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;

public interface NsiAsyncBindingBuilders {

	public NsiListType getNsiList(String tp) throws Fault, CantSignSoap, CantSendSoap, ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault;
	public NsiItemType getNsiItem(String TypeList,BigInteger TypeItem) throws Fault, CantSignSoap, CantSendSoap, ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault;
	
}
