package com.ric.web;

import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({"com.ric.st", "com.ric.bill.dao", "com.dic.bill", "com.dic.bill.dao", 
	"com.ric.bill.mm", "com.ric.bill", "com.ric.st.builder"}) // это нужно чтобы работали Unit-тесты! (по сути можно закомментить)
@ImportResource("spring.xml")
@EnableCaching
@EnableJpaRepositories(basePackages= {"com.ric.bill.dao", "com.dic.bill.dao"})
@EnableScheduling
public class AppConfig  implements ApplicationContextAware {

	static ApplicationContext ctx = null;
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ctx = context;
	}
	
	/**
	 * Note that this is a static method which expose ApplicationContext
	 **/
	public static ApplicationContext getContext(){
	      return ctx;
	}

}
