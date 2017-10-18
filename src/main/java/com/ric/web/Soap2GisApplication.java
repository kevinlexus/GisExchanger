package com.ric.web;

import javax.security.auth.message.config.AuthConfigFactory;

import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ric.bill.Config;
import com.ric.st.impl.TaskController;

import ru.gosuslugi.dom.signature.demo.commands.Command;
import ru.gosuslugi.dom.signature.demo.commands.SignCommand;

@SpringBootApplication
public class Soap2GisApplication {

	public static Command sc;
	private static ApplicationContext applicationContext = null;
	
	public static void main(String[] args) {
		// Не удалять! отвалится ЭЦП!
		System.setProperty("org.apache.xml.security.resource.config", "resource/tj-msxml.xml");
		  
		//Создать объект подписывания XML
		try {
			sc = new SignCommand();
			//System.out.println("Объект подписывания XML СОЗДАН!");
		} catch (Exception e1) {
			System.out.println("Объект подписывания XML не создан!");
			e1.printStackTrace();
		}

        String mode = args != null && args.length > 0 ? args[0] : null;

		if (AuthConfigFactory.getFactory() == null) {
            AuthConfigFactory.setFactory(new AuthConfigFactoryImpl());
        }
        
        if (applicationContext != null && mode != null && "stop".equals(mode)) {
            System.exit(SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
                @Override
                public int getExitCode() {
                    return 0;
                }
            }));
        } else {
        	System.out.println("CHECCCCCCCCCCCCCK 1");
            SpringApplication app = new SpringApplication(Soap2GisApplication.class);
        	System.out.println("CHECCCCCCCCCCCCCK 2");
            applicationContext = app.run(args);
        	System.out.println("CHECCCCCCCCCCCCCK 3");
            
            TaskController taskContr = applicationContext.getBean(TaskController.class);
            Config config = applicationContext.getBean(Config.class);
            
            if (config.getAppTp() == 1) {
                taskContr.otherTask();
            	
            } else {

            	try {
    				taskContr.searchTask();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
            	
            }
            
            // Завершить выполнение приложения
            SpringApplication.exit(applicationContext, () -> 0);
        }
		
	}
}
