package com.ric.st;

/**
 * Коды ошибок
 */
public interface CommonErrs {
    // счетчик не существует
    long ERR_METER_NOT_FOUND = 0x1; // 0000 0001
    // объект не найден в базе Директ
    long ERR_OBJECT_NOT_FOUND =0x2; // 0000 0010
    // разные KLSK на один адрес
    long ERR_DIFF_KLSK_BUT_SAME_ADDR =0x4; // 0000 0100
    // найден пустой KLSK в данном адресе
    long ERR_EMPTY_KLSK   =0x8; // 00001000
    // не найден счетчик в доме по GUID
    long ERR_METER_NOT_FOUND_BY_GUID =0x10; // 0001 0000
    // счетчик не привязан к Директ
    long ERR_METER_NOT_ASSOC_DIRECT =0x20; // 0010 0000
    // счетчик не является актуальным в Директ
    long ERR_METER_NOT_ACTUAL_DIRECT =0x40; // 0100 0000;
    // ошибка при записи в базу
    long ERROR_WHILE_SAVING_DATA =0x80; // 1000 0000;
}
