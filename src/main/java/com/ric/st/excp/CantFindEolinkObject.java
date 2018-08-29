package com.ric.st.excp;

/**
 * Exception возникающий при невозможности найти объект в Eolink
 * @author lev
 *
 */
public class CantFindEolinkObject extends Exception {

	public CantFindEolinkObject(String message) {
        super(message);
    }
}
