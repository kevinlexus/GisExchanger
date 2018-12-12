package com.ric.st;

/**
 * Коды ошибок
 */
public interface CommonErrs {
    // счетчик не существует
    static long ERR_METER_NOT_FOUND = 0x1; // 00000001
    // объект не найден в базе Директ
    static long ERR_OBJECT_NOT_FOUND =0x2; // 00000010
    // разные KLSK на один адрес
    static long ERR_DIFF_KLSK_BUT_SAME_ADDR   =0x4; // 00000100
    // найден пустой KLSK в данном адресе
    static long ERR_EMPTY_KLSK   =0x8; // 00001000
    // не найден объект по GUID
    static long ERR_NOT_FOUND_BY_GUID   =0x10; // 00010000
}
