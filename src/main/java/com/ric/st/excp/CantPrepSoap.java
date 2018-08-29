package com.ric.st.excp;

/**
 * Exception возникающий при невозможности подготовить SOAP запрос
 * @author lev
 *
 */
public class CantPrepSoap  extends Exception {

	public CantPrepSoap(String message) {
        super(message);
    }
}
