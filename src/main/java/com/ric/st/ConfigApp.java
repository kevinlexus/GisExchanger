package com.ric.st;

import java.util.Date;

public interface ConfigApp {

    String getPeriod();

	String getPeriodNext();

	String getPeriodBack();

	Date getCurDt1();

	Date getCurDt2();
}