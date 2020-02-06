package com.ric.st.impl;

import com.dic.bill.Lock;
import com.dic.bill.model.scott.Param;
import com.ric.cmn.Utl;
import com.ric.st.ConfigApp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.util.*;

/**
 * Конфигуратор приложения
 *
 * @author lev
 * @version 1.00
 */
@Service
@Slf4j
public class ConfigAppImpl implements ConfigApp {

    private final ApplicationContext ctx;
    @PersistenceContext
    private EntityManager em;

    // номер текущего запроса
    private int reqNum = 0;

    // прогресс текущего формирования
    private Integer progress;

    // блокировщик выполнения процессов
    private Lock lock;

    public ConfigAppImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    // Получить Calendar текущего периода
    private List<Calendar> getCalendarCurrentPeriod() {
        List<Calendar> calendarLst = new ArrayList<>();

        Param param = em.find(Param.class, 1);
        if (param == null) {
            log.error("ВНИМАНИЕ! Установить SCOTT.PARAMS.ID=1");
        }

        Calendar calendar1, calendar2;
        calendar1 = new GregorianCalendar();
        calendar1.clear(Calendar.ZONE_OFFSET);

        calendar2 = new GregorianCalendar();
        calendar2.clear(Calendar.ZONE_OFFSET);


        // получить даты начала и окончания периода
        assert param != null;
        Date dt = null;
        try {
            dt = Utl.getDateFromPeriod(param.getPeriod().concat("01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dt1 = Utl.getFirstDate(dt);
        Date dt2 = Utl.getLastDate(dt1);

        calendar1.setTime(dt1);
        calendarLst.add(calendar1);

        calendar2.setTime(dt2);
        calendarLst.add(calendar2);

        return calendarLst;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getPeriod() {
        return Utl.getPeriodFromDate(getCalendarCurrentPeriod().get(0).getTime());
    }

    @Override
    public String getPeriodNext() {
        try {
            return Utl.addMonths(Utl.getPeriodFromDate(getCalendarCurrentPeriod().get(0).getTime()), 1);
        } catch (ParseException e) {
            log.error(Utl.getStackTraceString(e));
            return null;
        }
    }

    @Override
    public String getPeriodBack() {
        try {
            return Utl.addMonths(Utl.getPeriodFromDate(getCalendarCurrentPeriod().get(0).getTime()), -1);
        } catch (ParseException e) {
            log.error(Utl.getStackTraceString(e));
            return null;
        }
    }

    /**
     * Получить первую дату текущего месяца
     */
    @Override
    public Date getCurDt1() {
        return getCalendarCurrentPeriod().get(0).getTime();
    }

    /**
     * Получить последнюю дату текущего периода
     */
    @Override
    public Date getCurDt2() {
        return getCalendarCurrentPeriod().get(1).getTime();
    }

}
