package com.ric.st.impl;

import com.ric.st.CommonErrs;

/**
 * Общие функции модуля GisExchanger
 */
public class CommonUtl {

    /**
     * Получить описание ошибок в строку через ";"
     * @param err - код ошибки в битовом представлении
     * @return
     */
    public static String getErrorDescrByCode(long err) {
        StringBuilder str= new StringBuilder("");
        if ((err & CommonErrs.ERR_METER_NOT_FOUND) > 0) {
            str.append("Не найден соответствующий в Директ счетчик! ");
        }
        if ((err & CommonErrs.ERR_EMPTY_KLSK) > 0) {
            str.append("Пустой KLSK в данном адресе! ");
        }
        if ((err & CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR) > 0) {
            str.append("Разные KLSK на один адрес! ");
        }
        if ((err & CommonErrs.ERR_OBJECT_NOT_FOUND) > 0) {
            str.append("Объект не найден в базе Директ! ");
        }
        if (str.length() >0) {
            return str.toString();
        } else {
            return null;
        }
    }
}
