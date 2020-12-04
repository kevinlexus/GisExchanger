package com.ric.st.impl;

import com.ric.cmn.excp.UnusableCode;
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
    public static String getErrorDescrByCode(long err) throws UnusableCode {
        StringBuilder str= new StringBuilder("");
        if (err > 0x3FFF) { // переводить максимальное число в биты, заполнить все 0 единицами, получить макс значение,
            // например: 00111111‬, при добавлении нового кода менять!
            throw new UnusableCode("Некорректный код маски = "+err);
        }

        if ((err & CommonErrs.ERR_METER_NOT_FOUND) > 0) {
            str.append("Не найден соответствующий в Директ счетчик! ");
        }
        if ((err & CommonErrs.ERR_EMPTY_KLSK) > 0) {
            str.append("Пустой KLSK в KART по данным в kul,nd,kw! ");
        }
        if ((err & CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR) > 0) {
            str.append("Разные KLSK в KART по данным в kul,nd,kw! ");
        }
        if ((err & CommonErrs.ERR_OBJECT_NOT_FOUND) > 0) {
            str.append("Объект не найден в базе Директ! ");
        }
        if ((err & CommonErrs.ERR_METER_NOT_FOUND_BY_GUID) > 0) {
            str.append("Не найден счетчик в доме по GUID! ");
        }
        if ((err & CommonErrs.ERR_METER_NOT_ASSOC_DIRECT) > 0) {
            str.append("При выгрузке показаний, обнаружено что счетчик не привязан к Директ! ");
        }
        if ((err & CommonErrs.ERR_METER_NOT_ACTUAL_DIRECT) > 0) {
            str.append("Счетчик не является актуальным в Директ! ");
        }
        if ((err & CommonErrs.ERROR_WHILE_SAVING_DATA) > 0) {
            str.append("Ошибка при записи в базу данных! ");
        }
        if ((err & CommonErrs.ERR_DOUBLE_KLSK_EOLINK) > 0) {
            str.append("Дублирующийся FK_KLSK_OBJ в таблице Eolink! ");
        }
        if ((err & CommonErrs.ERR_LSK_NOT_FOUND) > 0) {
            str.append("Объект лиц.счета EOLINK не найден в SCOTT.KART по LSK! ");
        }
        if ((err & CommonErrs.ERR_INCORRECT_PARENT) > 0) {
            str.append("Объект лицевого счета EOLINK имеет некорректную родительскую запись! ");
        }
        if ((err & CommonErrs.ERR_NOT_FOUND_ACTUAL_OBJ) > 0) {
            str.append("Не найден актуальный объект Помещения по KLSK в SCOTT.KART! ");
        }
        if ((err & CommonErrs.ERR_EMPTY_FIO) > 0) {
            str.append("Не заполнено Ф.И.О. собственника в SCOTT.KART! ");
        }

        if (str.length() >0) {
            return str.toString();
        } else {
            return null;
        }
    }
}
