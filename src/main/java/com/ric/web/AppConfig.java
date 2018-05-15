package com.ric.web;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
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

import com.ric.st.impl.TaskController;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan({"com.ric.st", "com.ric.bill.dao", "com.dic.bill", "com.dic.bill.dao", "com.ric.bill.dao.hotora",
	"com.ric.bill.mm", "com.ric.bill", "com.ric.st.builder"}) // это нужно чтобы работали Unit-тесты! (по сути можно закомментить)
@ImportResource("spring.xml")
@EnableCaching
@EnableJpaRepositories(basePackages= {"com.ric.bill.dao", "com.dic.bill.dao", "com.ric.bill.dao.hotora"})
@EnableScheduling
@Slf4j
public class AppConfig  implements ApplicationContextAware {

	static ApplicationContext ctx = null;

	@Autowired
	DataSource ds;
	
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
	
	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
	/**
	 * Бин для фабрики соединения ampq
	 */
	@Bean
	public ConnectionFactory connectionFactory(
	        @Value("${rmqHost}") String rmqHost,
	        @Value("${rmqUser}") String rmqUser,
	        @Value("${rmqPassword}") String rmqPassword) {
	    log.info("Создание конфигурации соединения. Host:{}, user:{}",rmqHost,rmqUser);
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(rmqHost);
        connectionFactory.setUsername(rmqUser);
        connectionFactory.setPassword(rmqPassword);
        return connectionFactory;
	}
}


