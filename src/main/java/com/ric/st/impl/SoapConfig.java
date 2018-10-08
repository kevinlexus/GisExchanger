package com.ric.st.impl;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dic.bill.dao.UserDAO;
import com.ric.cmn.excp.EmptyStorable;
import com.dic.bill.model.sec.User;
import com.ric.st.SoapConfigs;
import com.ric.st.mm.UlistMng;

@Slf4j
@Service
public class SoapConfig implements SoapConfigs {


	@Autowired
	private UlistMng ulistMng;
	@Autowired
	private TaskController taskContr;
	@Autowired
	private UserDAO userDao;
	@Value("${baseOrgGUID}")
	private String baseOrgGUID;
	@Value("${fingerPrint}")
	private String fingerPrint;
	@Value("${basicPass}")
	private String basicPass;
	@Value("${basicLogin}")
	private String basicLogin;
	@Value("${signPass}")
	private String signPass;
	@Value("${signPath}")
	private String signPath;

	// Пользователь, от имени которого выполняются процессы
	private User user;

	// среда выполнения
	public int getEnv() {
		return 0; // HOTORA
		//return 1; Direct (на прямую))
	}

	/**
	 *	Получить OrgPPGUID организации
	 */
	public String getOrgPPGuid() {
		// Базовый GUID организации, осуществляющей обмен! (для справочников NSI и т.п.)

		//return "9b051b50-937d-44f7-b03b-ff621d84ea3d"; // МП "РИЦ" (СИТ-2)
		//return "d2bf560f-bccb-41d0-8c7a-54de0c5049ec"; // МП "РИЦ" (Пром)
		return baseOrgGUID;


		//return "b9fe4d27-020d-44dc-8bfd-b5972a504f45"; // Металлплощадка (СИТ-2)
		//return "b21dadf0-e7e6-4824-aa04-19bd617bb3e1"; // ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ "УПРАВЛЯЮЩАЯ КОМПАНИЯ ЖИЛКОМСЕРВИС"  (Пром)
		//return null;
		//return "a81aaf05-6afd-4795-b40c-f62b82c350b5"; // ООО "УК Металлплощадка" (СИТ-1) взято на странице Личный кабинет -> Информационные системы -> Поставщики инф.
		//return "44de0b23-6e64-4f5c-ab56-d7c67e4c8f55"; // ТСЖ " АПРЕЛЬ" (Пром)

		//return null;
	}

	/**
	 * Получить URL тестового сервера
	 */
	public String getSrvTestHost() {
		return "http://127.0.0.1:8080";
//		return "http://217.107.108.147:10082";
//		return "http://217.107.108.156:10082";
//		return "http://api.dom.gosuslugi.ru:443";
	}

	/**
	 * Тестовый режим? (стучаться ли на тестовые сервера?)
	 */
	public boolean isSrvTest() {
		return true;
	}

	/**
	 * Получить fingerprint
	 */
	public String getFingerPrint() {
		return fingerPrint;
		//return "2021d448e368a0b39c2bfcd4435574c05ca8c435";
	}

	/**
	 * Получить логин basic-авторизации
	 */
	public String getBscLogin() {
		return basicLogin;
		//return "sit";
	}

	/**
	 * Получить пароль basic-авторизации
	 */
	public String getBscPass() {
		//return "rZ_GG72XS^Vf55ZW";
		return basicPass;
		//return "xw{p&&Ee3b9r8?amJv*]";
	}

	/**
	 * Вернуть префикс CD элементов в справочниках локальной системы
	 * @return
	 */
	public String getPrefixGis() {
		return "GIS";
	}

	public void setXmlLog() {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "999999");
	}


	/**
	 * Выполнить загрузку справочников
	 * @return - выполнено успешно?
	 */
/*
	boolean refreshNsi() {
		// загрузить справочники
		try {
			ulistMng.loadNsi("NSI");
			ulistMng.loadNsi("NSIRAO");
		} catch (Exception e) {
			// сообщение об ошибке
			e.printStackTrace();
			return false;
		}
		return true;
	}
*/


	public Boolean setUp(Boolean isLoadRef) {
		log.info("загрузка данных пользователя");
		this.user = userDao.getByCd("GEN");

		/*log.info("проверка обновлений справочников");
		if (isLoadRef) {
			if (!refreshNsi()) {
				log.error("Ошибка при обновлении справочников!");
				return false;
			}
		}*/

		// Инициализация сервиса ulistMng
		/*if (!ulistMng.setUp()) {
			log.error("Ошибка инициализации сервиса ulistMng!");
			return false;
		}*/

    	return true;
	}

	/**
	 * Вернуть пользователя, от имени которого выполняются процессы
	 */
	public User getCurUser() {
		return this.user;
	}

	public String getSignPass() {
		return signPass;
	}

	public void setSignPass(String signPass) {
		this.signPass = signPass;
	}

	public String getSignPath() {
		return signPath;
	}

	public void setSignPath(String signPath) {
		this.signPath = signPath;
	}


}
