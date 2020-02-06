package com.ric.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"com.ric.st", "com.dic.bill", "com.dic.bill.dao", "com.ric.st.builder"}) // это нужно чтобы работали Unit-тесты! (по сути можно закомментить)
@ImportResource({"file:.\\config\\spring.xml"})
@EnableCaching
@EnableJpaRepositories(basePackages= {"com.dic.bill.dao"})
@EnableScheduling
@Slf4j
public class AppConfig  implements ApplicationContextAware {

	static ApplicationContext ctx = null;

	@Autowired
	DataSource ds;

	/**
	 * Инициализация Application context
	 * @param context
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ctx = context;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    // JPA settings
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    // vendorAdapter.setGenerateDdl(true);
	    // vendorAdapter.setShowSql(true);
	    vendorAdapter.setDatabase(Database.ORACLE);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.ric.bill", "com.dic.bill");
		factory.setDataSource(ds);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.enable_lazy_load_no_trans", true);
	    factory.setJpaProperties(jpaProperties);
	    factory.afterPropertiesSet();
	    return factory;
	}
}


