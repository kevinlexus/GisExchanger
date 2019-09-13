package com.ric.web;

import java.net.URL;
import java.net.URLClassLoader;

import javax.security.auth.message.config.AuthConfigFactory;

import com.ric.cmn.Utl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ric.signature.sign.commands.SignCommand;
import com.ric.st.impl.SoapConfig;
import com.ric.st.impl.TaskController;

@SpringBootApplication
@Slf4j
public class Soap2GisApplication {

	public static SignCommand sc;
    public static SignCommand sc2;
	private static ApplicationContext applicationContext = null;

	public static void main(String[] args) {
        log.info("****************************************************************");
        log.info("*                                                              *");
        log.info("*                                                              *");
        log.info("*                  Версия GisExchanger - 1.0.12                 *");
        log.info("*                                                              *");
        log.info("*                                                              *");
        log.info("****************************************************************");

		ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
    	log.info("*********** CLASSPATH *********");
        for(URL url: urls){
        	System.out.println(url.getFile());
        }
        log.info("*********** CLASSPATH *********");

    	String workingDir = System.getProperty("user.dir");
        log.info("Current working directory : " + workingDir);


		// Не удалять! отвалится ЭЦП!
		System.setProperty("org.apache.xml.security.resource.config", "resource/tj-msxml.xml");

        String mode = args != null && args.length > 0 ? args[0] : null;

		if (AuthConfigFactory.getFactory() == null) {
            AuthConfigFactory.setFactory(new AuthConfigFactoryImpl());
        }

        if (applicationContext != null && "stop".equals(mode)) {
            System.exit(SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
                @Override
                public int getExitCode() {
                    return 0;
                }
            }));
        } else {
            SpringApplication app = new SpringApplication(Soap2GisApplication.class);
            assert args != null;
            applicationContext = app.run(args);

            TaskController taskContr = applicationContext.getBean(TaskController.class);
            SoapConfig soapConfig = applicationContext.getBean(SoapConfig.class);
            //Создать первый объект подписывания XML
    		try {
    			sc = new SignCommand(soapConfig.getSignPass(), soapConfig.getSignPath());
    			log.info("Объект подписывания XML-1 СОЗДАН!");
    		} catch (Exception e1) {
                log.error("****************************************************************");
                log.error("*                                                              *");
                log.error("*                                                              *");
                log.error("* Объект подписывания XML-1 не создан, приложение ОСТАНОВЛЕНО! *");
                log.error("*                                                              *");
                log.error("*                                                              *");
                log.error("****************************************************************");
                log.error("stackTrace={}", Utl.getStackTraceString(e1));
                // Завершить выполнение приложения
                SpringApplication.exit(applicationContext, () -> 0);
    		}

            //Создать второй объект подписывания XML (при наличии)
            if (soapConfig.getSignPass2() != null) {
                try {
                    sc2 = new SignCommand(soapConfig.getSignPass2(), soapConfig.getSignPath2());
                    log.info("Объект подписывания XML-2 СОЗДАН!");
                } catch (Exception e1) {
                    log.error("****************************************************************");
                    log.error("*                                                              *");
                    log.error("*                                                              *");
                    log.error("* Объект подписывания XML-2 не создан, приложение ОСТАНОВЛЕНО! *");
                    log.error("*                                                              *");
                    log.error("*                                                              *");
                    log.error("****************************************************************");
                    log.error("stackTrace={}", e1.getStackTrace().toString());
                    // Завершить выполнение приложения
                    SpringApplication.exit(applicationContext, () -> 0);
                }
            }

            try {
				taskContr.searchTask();
			} catch (Exception e) {
				e.printStackTrace();
			}

            // Завершить выполнение приложения
            SpringApplication.exit(applicationContext, () -> 0);
        }

	}
}
