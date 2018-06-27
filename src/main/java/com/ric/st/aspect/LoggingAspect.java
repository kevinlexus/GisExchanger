package com.ric.st.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class LoggingAspect {

	@Before("execution(* com.ric.st.builder.HouseManagementAsyncBindingBuilders.exportHouseData(..))")
	public void logBefore(JoinPoint joinPoint) {

		log.info("Aspect:Вызов экспорта объектов дома");
	}

}