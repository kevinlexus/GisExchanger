package com.ric.st.mm.impl;

import com.dic.bill.model.exs.Ulist;
import com.dic.bill.model.exs.UlistTp;
import com.ric.cmn.Utl;
import com.ric.st.builder.NsiCommonAsyncBindingBuilders;
import com.ric.st.dao.UlistDAO;
import com.ric.st.excp.CantGetNSI;
import com.ric.st.excp.CantSendSoap;
import com.ric.st.excp.CantSignSoap;
import com.ric.st.excp.CantUpdNSI;
import com.ric.st.impl.RefStore;
import com.ric.st.impl.SoapConfig;
import com.ric.st.mm.UlistMng;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gosuslugi.dom.schema.integration.nsi_base.*;
import ru.gosuslugi.dom.schema.integration.nsi_base.NsiElementNsiRefFieldType.NsiRef;
import ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
//import ru.gosuslugi.dom.schema.integration.nsi_common_service.Fault;

/**
 * Сервис справочников ГИС ЖКХ
 * @author lev
 *
 */
@Slf4j
@Service
public class UlistMngImpl implements UlistMng {

	@Autowired
	private UlistDAO ulistDao;
	@Autowired
	private NsiCommonAsyncBindingBuilders nsiCommonBuilder;
	@Autowired
	private SoapConfig config;
	@PersistenceContext
    private EntityManager em;

	// Хранилище справочников ГИС ЖКХ
	private RefStore rStore;

	// Инициализация
	@Override
	public Boolean setUp() {
		// загрузка справочников из ГИС ЖКХ
		if (!loadRef()){
			return false;
		} else {
			log.info("справочники обновлены из ГИС");
			return true;
		}

	}

	// префикс для элементов справочника
	private String getPrefixedCD(String cd, String grp, String code, String org, String idx) {
		if (idx==null) {
			return getPrefixedCD(cd, grp)+"_"+code+"_"+org;
		} else {
			return getPrefixedCD(cd, grp)+"_"+code+"_"+org+"_"+idx;
		}
	}

	// префикс для заголовка справочника
	@Override
	public String getPrefixedCD(String cd, String grp) {
		return config.getPrefixGis()+"_"+grp+"_"+cd;
	}

	/**
	 * Создать или обновить справочник NSI или NSIRAO
	 * @param lst
	 * @param nsiItem
	 * @param grp
	 * @throws CantUpdNSI
	 * @throws Exception
	 */
	private void updNsiList(List<UlistTp> lst, NsiItemInfoType nsiItem, String grp) throws CantUpdNSI {
		String prefix = getPrefixedCD(nsiItem.getRegistryNumber().toString(), grp);
		// найти заголовочный элемент в нашей базе
		Optional<UlistTp> el = lst.stream()
				.filter(t-> t.getCd().equals(prefix))
				.findAny();
		if (!el.isPresent()) {
			// не найден элемент, создать новый
			UlistTp lstTp = new UlistTp(prefix, nsiItem.getRegistryNumber().intValue(), nsiItem.getName(),
					Utl.getDateFromXmlGregCal(nsiItem.getModified()),
					grp, null);
			em.persist(lstTp);
			log.info("Создан заголовочный элемент ListTp :{}", prefix);
			// обновить элементы справочника
			log.info("Создание справочника: {}", prefix);
			updNsiItem(lstTp, grp, nsiItem.getRegistryNumber());
			log.info("Создан справочник: {}", prefix);
		} else {
			// найден элемент, проверить дату обновления
			if (el.get().getDt1() == null || el.get().getDt1().getTime() != Utl.getDateFromXmlGregCal(nsiItem.getModified()).getTime()) {
				SimpleDateFormat sm = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.S a z");
				String strDate1 = sm.format(el.get().getDt1());
				String strDate2 = sm.format(Utl.getDateFromXmlGregCal(nsiItem.getModified()));
				log.info("Даты обновления: старая ={}, новая 2 ={}", strDate1, strDate2);
				// обновить элементы справочника
				updNsiItem(el.get(), grp, nsiItem.getRegistryNumber());
				// установить дату обновления
				el.get().setDt1(Utl.getDateFromXmlGregCal(nsiItem.getModified()));
				log.info("Обновлён справочник: {}", prefix);
			}
			//проверить Name
			if (!el.get().getName().equals(nsiItem.getName())) {
				//обновить Name
				el.get().setName(nsiItem.getName());
				log.info("Обновлён заголовочный элемент, Name справочника: {}", prefix);
			}
		}
	}

	/**
	 * Обновить справочник NSI
	 * @param ulistTp - тип
	 * @param grp - группа
	 * @param id - Id справочника
	 * @throws CantUpdNSI
	 */
	private void updNsiItem(UlistTp ulistTp, String grp, BigInteger id) throws CantUpdNSI {
		// получить из ГИС справочник
		NsiItemType res = null;
		try {
			res = nsiCommonBuilder.getNsiItem(grp, id);
		} catch (Fault e) {
			log.error(Utl.getStackTraceString(e));
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		} catch (CantSignSoap e) {
			log.error(Utl.getStackTraceString(e));
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		} catch (CantSendSoap e) {
			log.error(Utl.getStackTraceString(e));
			throw new CantUpdNSI("Ошибка при обновлении справочника NSI grp="+ grp+", id="+ id);
		}
        String org = "###";

		if (res != null) {
			Integer idx = 0;
			for (NsiElementType t: res.getNsiElement()) {
				idx = mergeElement(ulistTp, grp, id.intValue(), t, idx, org);
		    }
		} else {
			log.info("Нет элементов в базе ГИС по справочнику grp={}, id={}", grp, id);
		}
	}

	@Override
	public Integer mergeElement(UlistTp ulistTp, String grp, Integer id, NsiElementType t, Integer idx, String org) {
		// получить cd новой записи
	    String log_place = "UlistMngImpl.mergeElement: ";

	    // CD в данном справочнике нужно практически только для того, чтобы искать дочерние записи полей (fields),
        // не обеспечивается уникальность. Главная запись ищется по GUID
		String cd = getPrefixedCD(id.toString(), grp, t.getCode(), org, null).concat("_ROOT");
		// создать новый элемент
		List<NsiElementFieldType> lst2 =  t.getNsiElementField();

		// создать запись главного элемента с CD в Ulist
		log.info("Check1={}", Utl.nvl(t.getCode(), "-------"));
		String code = null;
		if (t.getCode()==null || t.getCode().length()==0) {
			code = "------";
		} else {
			code = t.getCode();
		}
		//Ulist main = ulistDao.getListElemByCd(cd, null);
		Ulist main = ulistDao.getListElemByGUID(t.getGUID());
		if (main == null) {
			main = Ulist.UlistBuilder.anUlist()
                    .withCd(cd)
					.withName(code)
                    .withGuid(t.getGUID())
                    .withDt1(Utl.getDateFromXmlGregCal(t.getStartDate()))
                    .withDt2(Utl.getDateFromXmlGregCal(t.getEndDate()))
                    .withActual(t.isIsActual())
                    .withUlistTp(ulistTp)
                    .withNpp(0)
                    .withS1(null)
                    .withParent(null)
                    .withRefCode(null)
                    .withRefGuid(null)
                    .withValTp(null)
					.build();
/*
	        main = new Ulist(code, t.getGUID(),
				Utl.getDateFromXmlGregCal(t.getStartDate()), Utl.getDateFromXmlGregCal(t.getEndDate()),
				t.isIsActual(), ulistTp, 0, null, null, null, null, null);
*/
	        em.persist(main);
	        log.info("Создана главная запись GUID={}, ID={}", main.getGuid(), main.getId());
		} else {
		    main.setDt1(Utl.getDateFromXmlGregCal(t.getStartDate()));
		    main.setDt2(Utl.getDateFromXmlGregCal(t.getEndDate()));
		    main.setName(code);
		    main.setActual(t.isIsActual());
		    main.setNpp(0);
		    main.setUlistTp(ulistTp);
		    main.setS1(null);
		    main.setParent(null);
		    main.setRefCode(null);
		    main.setRefGuid(null);
		    main.setValTp(null);
		    main.setParent2(null);
		    em.persist(main);
			log.info("Главная запись ID={},  есть в базе, обновление актуальной информацией...", main.getId());
		}

		// создать записи fields в Ulist
		for (NsiElementFieldType d : lst2) {
			// получить cd новой записи
			String fldCd;
			Ulist ulist = null;
			if (d.getClass().equals(NsiElementStringFieldType.class)) {
				NsiElementStringFieldType fld = (NsiElementStringFieldType) d;
				// создать запись в Ulist
				String name = null;
				if (fld.getName()==null || fld.getName().length()==0) {
					name = "------";
				} else {
					name = fld.getName();
				}
                fldCd = getPrefixedCD(id.toString(), grp, t.getCode(), org, name);
                ulist = Ulist.UlistBuilder.anUlist()
                        .withCd(fldCd)
                        .withName(name)
                        .withGuid(null)
                        .withDt1(null)
                        .withDt2(null)
                        .withActual(main.getActual())
                        .withUlistTp(ulistTp)
                        .withNpp(idx)
                        .withS1(fld.getValue())
                        .withParent(main)
                        .withRefCode(null)
                        .withRefGuid(null)
                        .withValTp("ST")
                        .build();
/*
				ulist = new Ulist(fldCd, name, null,
				        null, null, null, ulistTp, idx, fld.getValue(), main, null,
                        null, "ST");
*/
				log.info("######## id={}, name={}", main.getId(), name);
				Ulist old = ulistDao.getListElemByParent(main.getId(), name);
				if (old != null) {
				    copyFrom(ulist, old);
				    ulist = old;
					log.info("Поле Name={} существует в базе, обновляем S1={}",
                            name, ulist.getS1());
				} else {
                    log.info("Создано поле Name={}, S1={}", name, ulist.getS1());
                }
			} else if (d.getClass().equals(NsiElementNsiRefFieldType.class)) {
				NsiElementNsiRefFieldType fld = (NsiElementNsiRefFieldType) d;
				// создать запись в Ulist
				String name = null;
				if (fld.getName()==null || fld.getName().length()==0) {
					name = "------";
				} else {
					name = fld.getName();
				}
                fldCd = getPrefixedCD(id.toString(), grp, t.getCode(), org, name);
				NsiRef nRef = fld.getNsiRef();
				if (nRef != null) {
                    ulist = Ulist.UlistBuilder.anUlist()
                            .withCd(fldCd)
                            .withName(name)
                            .withGuid(null)
                            .withDt1(null)
                            .withDt2(null)
                            .withActual(main.getActual())
                            .withUlistTp(ulistTp)
                            .withNpp(idx)
                            .withS1(null)
                            .withParent(main)
                            .withRefCode(nRef.getRef().getCode())
                            .withRefGuid(nRef.getRef().getGUID())
                            .withValTp("RF")
                            .build();
/*
				    ulist = new Ulist(fldCd, name, null, null, null, null, ulistTp, idx,
                           null, main,
                            nRef.getRef().getCode(),
                            nRef.getRef().getGUID(), "RF");
*/
				    Ulist old = ulistDao.getListElemByParent(main.getId(), fldCd);
					if (old != null) {
						copyFrom(ulist, old);
						ulist = old;
                        log.info("Поле CD={}, Name={} существует в базе, обновляем RefGuid={}", fldCd, name,
                                nRef.getRef().getGUID());
                    } else {
                        log.info("Создано поле CD={}, Name={}, RefGuid={}", fldCd, name,
                                nRef.getRef().getGUID());
                    }
				}
			}

			if (ulist!=null) {
				em.persist(ulist);
				log.info("Обработан элемент справочника  List: {} Id: {} ", ulist.getName(),
						ulist.getId());
			}
		}
		log.info("Обработан элемент справочника List :{}", cd);
		return idx;
	}

	private void copyFrom(Ulist from, Ulist to) {
		to.setName(from.getName());
		to.setGuid(from.getGuid());
		to.setDt1(from.getDt1());
		to.setDt2(from.getDt2());
		to.setActual(from.getActual());
		to.setUlistTp(from.getUlistTp());
		to.setNpp(from.getNpp());
		to.setS1(from.getS1());
		to.setGuid(from.getGuid());
		to.setParent(from.getParent());
		to.setRefCode(from.getRefCode());
		to.setRefGuid(from.getRefGuid());
		to.setValTp(from.getValTp());
		to.setParent2(from.getParent2());
	}

	/**
	 * Получить справочник Nsi
	 * @param grp - группа, например NSI, NSIRAO
	 * @param id - идентификатор справочника
	 * @return
	 * @throws CantGetNSI
	 */
	@Override
	public NsiItemType getNsi(String grp, BigInteger id) throws CantGetNSI {
		// получить из ГИС
		NsiItemType res;
		try {
			log.info("Запрос справочника из ГИС: grp={}, id={}", grp, id);
			res = nsiCommonBuilder.getNsiItem(grp, id);
		} catch (CantSignSoap | CantSendSoap | ru.gosuslugi.dom.schema.integration.nsi_common_service_async.Fault e1) {
			log.error(Utl.getStackTraceString(e1));
			throw new CantGetNSI("Ошибка получения справочника NSI по группе grp="+grp);
		}

		return res;
	}


	// загрузить справочники в память
	public Boolean loadRef() {
		// получить необходимые справочники из ГИС, поместить в хранилище в памяти
		setrStore(new RefStore());
		try {
			getrStore().add(getNsi("NSI", BigInteger.valueOf(21)), "NSI", BigInteger.valueOf(21));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(27)), "NSI", BigInteger.valueOf(27));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(22)), "NSI", BigInteger.valueOf(22));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(24)), "NSI", BigInteger.valueOf(24));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(30)), "NSI", BigInteger.valueOf(30));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(32)), "NSI", BigInteger.valueOf(32));
			getrStore().add(getNsi("NSI", BigInteger.valueOf(2)), "NSI", BigInteger.valueOf(2));
		} catch (CantGetNSI e) {
			log.error("Ошибка получения справочников NSI!");
			return false;
		}
		return true;
	}


	/**
	 * Загрузить NSI справочники из ГИС
	 * @return
	 * @throws CantSendSoap
	 * @throws CantSignSoap
	 * @throws Fault
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void loadNsi(String grp) throws CantUpdNSI {
		// Обновить виды справочников
		// получить из нашей базы
		List<UlistTp> lst =  ulistDao.getListTp(grp);
		// получить из ГИС
		NsiListType res = null;
		try {
			log.info("Запрос справочников группы grp={}", grp);
			res = nsiCommonBuilder.getNsiList(grp);
		} catch (Fault | CantSignSoap | CantSendSoap e1) {
			log.error(Utl.getStackTraceString(e1));
			throw new CantUpdNSI("Ошибка обновления группы справочников grp="+grp);
		}
		if (res == null) {
			log.error("ВНИМАНИЕ! XML ответ - пустой, grp={}", grp);
			throw new CantUpdNSI("Ошибка обновления группы справочников grp="+grp);
		}
		// обработать каждый справочник
		try {
			for (NsiItemInfoType nsiItemInfoType : res.getNsiItemInfo()) {
				updNsiList(lst, nsiItemInfoType, grp);
			}
		} catch (Exception e) {
			log.error(Utl.getStackTraceString(e));
			throw new CantUpdNSI("Ошибка обновления справочника");
		}

	}

	/**
	 * Получить элемент справочника по соответствию полей имя и значение
	 * @param grp - Группа справочника, например "NSI"
	 * @param id - № справочника
	 * @param name - имя искомого элемента
	 * @param value - значение искомого элемента
	 */
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
		getNsiElem2(String grp, Integer id, String name, String value) {

		NsiItemType res = getrStore().getByGrpId(grp, BigInteger.valueOf(id));
		Optional<NsiElementType> elem = res.getNsiElement().stream().filter(t ->

					t.getNsiElementField().stream().filter(v ->
							v.getClass().equals(NsiElementStringFieldType.class)
							&& v.getName().equals(name))
							.anyMatch(v -> ((NsiElementStringFieldType) v).getValue().equals(value))

				).findFirst();
		if (elem.isPresent()) {
			ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef t =
					new ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef();
	    	t.setCode(elem.get().getCode());
	    	t.setGUID(elem.get().getGUID());
			return t;
		} else {
			return null;
		}
	}

	/**
	 * Получить элемент справочника, сохранённый в базе данных, по соответствию полей имя и значение
	 * @param grp - Группа справочника, например "NSI"
	 * @param id - № справочника
	 * @param name - имя искомого элемента
	 * @param value - значение искомого элемента
	 */
	@Override
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
		getNsiElem(String grp, Integer id, String name, String value) {

		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef t =
				new ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef();

		Ulist elem = ulistDao.getListElem(grp, id, name, value);
		t.setCode(elem.getName());
		t.setGUID(elem.getGuid());
		return t;
	}

	/**
	 * Получить элемент справочника, сохранённый в базе данных, по соответствию полей имя и значение и организация
	 * @param grp - Группа справочника, например "NSI"
	 * @param id - № справочника
	 * @param name - имя искомого элемента
	 * @param value - значение искомого элемента
	 * @param org - организация
	 */
/*
	@Override
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
		getNsiElem(String grp, Integer id, String name, String value, Eolink org) {

		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef t =
				new ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef();

		Ulist elem = ulistDao.getListElem(grp, id, name, value, org);
		t.setCode(elem.getName());
		t.setGUID(elem.getGuid());
		return t;
	}
*/

	/**
	 * Получить элемент справочника, сохранённый в базе данных, по элементу
	 * @param elem - Элемент
	 */
	@Override
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef
		getNsiElem(Ulist elem) {

		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef t =
				new ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef();
		t.setCode(elem.getName());
		t.setGUID(elem.getGuid());
		return t;
	}


	/**
	 * Вывести на экран содержимое всех загруженных справочников (TODO)
	 */
	@Override
	public void showAll() {
		getrStore().getMapRef().stream().forEach(d -> {
			log.info("Grp={}, Res={}", d.getGrp(), d.getRes());
			/*	d.getRes().getNsiElement().stream().forEach(t -> {
					t.getNsiElementField().stream().forEach(e-> {
						if (e.getClass().equals(NsiElementStringFieldType.class)) {
							log.info("Elem={},  Value={}", e.getName(), ((NsiElementStringFieldType) e).getValue());

						}
					});

				}); */
		});
	}

	@Override
	public RefStore getrStore() {
		return rStore;
	}

	private void setrStore(RefStore rStore) {
		this.rStore = rStore;
	}

	/**
	 * Получить коммунальный ресурс NSI по коду USL
	 */
	@Override
    @Cacheable(cacheNames="UlistMngImpl.getResourceByUsl", key="{#usl }", unless = "#result == null")
	public ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef getResourceByUsl(String usl) {
		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef mres = null;
		switch (usl) {
		case "011":
			mres  = getNsiElem("NSI", 2, "Вид коммунального ресурса", "Холодная вода");
			break;
		case "015":
			mres = getNsiElem("NSI", 2, "Вид коммунального ресурса", "Горячая вода");
			break;
		case "024":
			mres = getNsiElem("NSI", 2, "Вид коммунального ресурса", "Электрическая энергия");
			break;
		default:
			break;
		}

		return mres;
	}

	/**
	 * Получить код USL по коммунальному ресурсу NSI по коду USL
	 */
	@Override
    @Cacheable(cacheNames="UlistMngImpl.getUslByResource", key="{#nsi.getGUID() }", unless = "#result == null")
	public String getUslByResource(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef nsi) {
		String usl = null;
		String servCd = getServCdByResource(nsi);
		log.info("************ servCd={}, nsi.GUID={}", servCd, nsi.getGUID());
		if (servCd.equals("Холодная вода")) {
			usl = "011";
		} else if (servCd.equals("Горячая вода")) {
			usl = "015";
		} else if (servCd.equals("Электрическая энергия")) {
			usl = "038";
		} else if (servCd.equals("Отопление")) {
			usl = "007";
		}
		return usl;
	}

	/**
	 * Получить CD услуги Serv по коммунальному ресурсу NSI по коду USL
	 */
	@Override
    @Cacheable(cacheNames="UlistMngImpl.getServCdByResource", key="{#nsi.getGUID() }", unless = "#result == null")
	public String getServCdByResource(ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef nsi) {
		//log.info("NSI guid={}", nsi.getGUID());
		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef mresHw =
				getNsiElem("NSI", 2, "Вид коммунального ресурса", "Холодная вода");
		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef mresGw =
				getNsiElem("NSI", 2, "Вид коммунального ресурса", "Горячая вода");
		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef mresEl =
				getNsiElem("NSI", 2, "Вид коммунального ресурса", "Электрическая энергия");
		ru.gosuslugi.dom.schema.integration.nsi_base.NsiRef mresHeat =
				getNsiElem("NSI", 2, "Вид коммунального ресурса", "Тепловая энергия");
		if (nsi.getGUID().equals(mresHw.getGUID())) {
			return "Холодная вода";
		} else if (nsi.getGUID().equals(mresGw.getGUID())) {
			return "Горячая вода";
		} else if (nsi.getGUID().equals(mresEl.getGUID())) {
			return "Электроснабжение";
		} else if (nsi.getGUID().equals(mresHeat.getGUID())) {
			return "Отопление";
		} else {
			return null;
		}
	}

	/**
	 * Получить тип ресурса по коду USL
	 */
	@Override
	public Integer getResType(String usl) {
		// тип ресурса 0 - коммунальный, 1 - электроэнергия
		Integer tp = 0;
		switch (usl) {
		case "011":
			tp = 0;
			break;
		case "015":
			tp = 0;
			break;
		case "038":
			tp = 1;
			break;
		default:
			break;
		}
		return tp;
	}



}
