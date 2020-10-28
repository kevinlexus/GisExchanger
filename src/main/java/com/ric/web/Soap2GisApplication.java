package com.ric.web;

import com.ric.cmn.Utl;
import com.ric.signature.sign.commands.SignCommand;
import com.ric.signature.sign.commands.SignCommands;
import com.ric.st.impl.SoapConfig;
import com.ric.st.impl.TaskController;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.security.auth.message.config.AuthConfigFactory;
import java.net.URL;
import java.net.URLClassLoader;

@SpringBootApplication
@Slf4j
public class Soap2GisApplication {

    public static SignCommands sc;
    public static SignCommands sc2;
    private static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        log.info("****************************************************************");
        log.info("*                                                              *");
        log.info("*                                                              *");
        log.info("*                  Версия GisExchanger - 1.0.19                *");
        log.info("*                                                              *");
        log.info("*                                                              *");
        log.info("****************************************************************");

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader) cl).getURLs();
        log.info("*********** CLASSPATH *********");
        for (URL url : urls) {
            System.out.println(url.getFile());
        }
        log.info("*********** CLASSPATH *********");

        String workingDir = System.getProperty("user.dir");
        log.info("Current working directory : " + workingDir);


        // Не удалять! отвалится ЭЦП!
        //System.setProperty("org.apache.xml.security.resource.config", "resource/tj-msxml.xml");

        String mode = args != null && args.length > 0 ? args[0] : null;

        if (AuthConfigFactory.getFactory() == null) {
            AuthConfigFactory.setFactory(new AuthConfigFactoryImpl());
        }

        if (applicationContext != null && "stop".equals(mode)) {
            System.exit(SpringApplication.exit(applicationContext, (ExitCodeGenerator) () -> 0));
        } else {
            SpringApplication app = new SpringApplication(Soap2GisApplication.class);
            assert args != null;
            applicationContext = app.run(args);

            TaskController taskContr = applicationContext.getBean(TaskController.class);
            SoapConfig soapConfig = applicationContext.getBean(SoapConfig.class);
            //Создать первый объект подписывания XML
            try {
                sc = buildSigner(soapConfig, 1);
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
                    sc2 = buildSigner(soapConfig, 2);
                    log.info("Объект подписывания XML-2 СОЗДАН!");
                } catch (Exception e1) {
                    log.error("****************************************************************");
                    log.error("*                                                              *");
                    log.error("*                                                              *");
                    log.error("* Объект подписывания XML-2 не создан, приложение ОСТАНОВЛЕНО! *");
                    log.error("*                                                              *");
                    log.error("*                                                              *");
                    log.error("****************************************************************");
                    log.error("stackTrace={}", Utl.getStackTraceString(e1));
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

    /**
     * Создать объект подписывания
     *
     * @param soapConfig - конфиг
     * @param cnt        - номер объекта по порядку
     * @return объект подписывания
     */
    private static SignCommands buildSigner(SoapConfig soapConfig, int cnt) throws Exception {
            if (cnt == 1) {
                // первый объект
                if (soapConfig.getSignPath() == null) {
                    throw new RuntimeException("Не установлен параметр signPath в application.properties!");
                }
                return new SignCommand(soapConfig.getSignPass(), soapConfig.getSignPath());
            } else {
                // второй объект
                if (soapConfig.getSignPath2() == null) {
                    throw new RuntimeException("Не установлен параметр signPath2 в application.properties!");
                }
                return new SignCommand(soapConfig.getSignPass2(), soapConfig.getSignPath2());
            }
    }
}
