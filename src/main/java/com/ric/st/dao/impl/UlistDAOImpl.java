package com.ric.st.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Ulist;
import com.ric.bill.model.exs.UlistTp;
import com.ric.st.builder.impl.HcsBillsAsyncBuilder;
import com.ric.st.dao.UlistDAO;

import lombok.extern.slf4j.Slf4j;



@Repository
@Slf4j
public class UlistDAOImpl implements UlistDAO {

	@PersistenceContext
    private EntityManager em;

	//конструктор
    public UlistDAOImpl() {

    }

    /*
     * Получить список заголовочных элементов справочников по группе
     * @param grp - группа справочника
     */
    public List<UlistTp> getListTp(String grp) {
		Query query =em.createQuery("select t from UlistTp t where t.grp=:grp");
		query.setParameter("grp", grp);
		return query.getResultList();
    }

    /*
     * Получить заголовочный элемент по группе и коду справочника, организации
     * @param grp
     */
    /**
     *
     * @param grp - группа справочника
     * @param eolink - организация
     * @param fkExt - код справочника
     * @return
     */
    public UlistTp getListTp(String grp, Eolink eolink, Integer fkExt) {
		Query query =em.createQuery("select t from UlistTp t where t.grp=:grp and t.eolink.id=:id and t.fkExt=:fkExt");
		query.setParameter("grp", grp);
		query.setParameter("id", eolink.getId());
		query.setParameter("fkExt", fkExt);
		try {
			return (UlistTp) query.getSingleResult();
		} catch (NoResultException e) {
		  return null;
		}
    }

    /* Получить список элементов справочника по группе и id
     * @param grp - группа справочника
     * @param id - Id справочника
     */
    /*public List<Ulist> getListByGrpId(String grp, BigInteger id) {
		Query query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.grp=grp and tp.id=id");
		query.setParameter("grp", grp);
		query.setParameter("id", id.intValue());
		return query.getResultList();
    }*/

    public void delListByListTp(UlistTp ulistTp) {
		Query query =em.createQuery("delete from Ulist where ulistTp=:ulistTp");
		query.setParameter("ulistTp", ulistTp);
		query.executeUpdate();
    }

    public int delListByParent(Ulist parent) {
        Query query = em.createQuery("delete from Ulist where parent = :parent");
        query.setParameter("parent", parent);
        return query.executeUpdate();
    }

    /* Получить элемент справочника по группе, коду группы, cd элемента
     * @param grp - группа справочника, например "NSI"
     * @param fkExt - код справочника, например 22
     * @param name - CD элемента, например "Причина закрытия лицевого счета"
     * @param s1 - значение элемента, например "Расторжение договора"
     */
    public Ulist getListElem(String grp, Integer fkExt, String name, String s1) {
		Query query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.fkExt=:fkExt and tp.grp=:grp "
				+ "and t.name=:name and t.s1=:s1 and t.parent.actual=true");
		query.setParameter("grp", grp);
		query.setParameter("fkExt", fkExt);
		query.setParameter("name", name);
		query.setParameter("s1", s1);
		Ulist chld = (Ulist) query.getSingleResult();
		return chld.getParent();
    }

    @Override
    public Ulist getListElem(String cd, String name, String guid,Date dt1, Date dt2,
			Boolean actual, UlistTp ulistTp, Integer npp, String value, Ulist parent,
			String refCode, String refGuid, String tp) {

        Query query = em.createQuery("select t from Ulist t where (t.cd = :cd or :cd is null)" +
                "		and (t.name = :name or :name is null)" +
                "		and (t.guid = :guid or :guid is null)" +
                "		and (t.dt1 = :dt1 or :dt1 is null)" +
                "		and (t.dt2 = :dt2 or :dt2 is null)" +
                "		and (t.actual = :actual or :actual is null)" +
                "		and (t.ulistTp = :ulistTp or :ulistTp is null)" +
                "		and (t.npp = :npp or :npp is null)" +
                "		and (t.s1 = :s1 or :s1 is null)" +
                "		and (t.parent = :parent or :parent is null)" +
                "		and (t.refCode = :refCode or :refCode is null)" +
                "		and (t.refGuid = :refGuid or :refGuid is null)" +
                "		and (t.valTp = :tp or :tp is null)");
        query.setParameter("cd", cd);
		query.setParameter("name", name);
		query.setParameter("guid", guid);
		query.setParameter("dt1", dt1);
		query.setParameter("dt2", dt2);
		query.setParameter("actual", actual);
		query.setParameter("ulistTp", ulistTp);
		query.setParameter("npp", npp);
		query.setParameter("s1", value);
		query.setParameter("parent", parent);
		query.setParameter("refCode", refCode);
		query.setParameter("refGuid", refGuid);
		query.setParameter("tp", tp);
		Ulist res = null;
		try {
		    List<Object> res_list = query.getResultList();
		    if (!res_list.isEmpty()) {
		        res = (Ulist)res_list.get(0);
		    }
		    if (res_list.size() > 1) {
		        log.error("Ulist.getListElem : WARNING! NOT UNIQUE RESULT FOUND. CHECK TABLE U_LIST FOR DUBLICATES.");
		    }
		}
		catch (Exception e) {log.error("Ulist.getListElem error:"+e.getMessage());};
		return res;
    }

/*
    @Override
    public Ulist getListElemByCd(String cd, Boolean actual) {
        Query query = em.createQuery("select t from Ulist t where t.cd = :cd and (t.actual = :actual or :actual is null)");
        query.setParameter("cd", cd);
        query.setParameter("actual", actual);
        Ulist res = null;
        try {
            List<Object> res_list = query.getResultList();
            if (!res_list.isEmpty()) {
                res = (Ulist)res_list.get(0);
            }
            if (res_list.size() > 1) {
                log.error("Ulist.getListElemByCd : WARNING! NOT UNIQUE RESULT FOUND. CHECK TABLE U_LIST FOR DUBLICATES.");
            }
        }
        catch (Exception e) {log.error("Ulist.getListElem error:"+e.getMessage());};
        return res;
    }
*/

	/**
	 * Получить элемент справочника по GUID
	 * @param guid - GUID
	 * @return - элемент справочника
	 */
	@Override
	public Ulist getListElemByGUID(String guid) {
		Query query = em.createQuery("select t from com.ric.bill.model.exs.Ulist t where t.guid = :guid");
		query.setParameter("guid", guid);
        Ulist ulist;
        try {
            ulist = (Ulist) query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return ulist;
	}

    /**
     * Получить элемент справочника по GUID
     * @return - элемент справочника
     */
    @Override
    public Ulist getListElemByParent(Integer parentId, String cd) {
        Query query = em.createQuery("select t from com.ric.bill.model.exs.Ulist t " +
                "join t.parent p where p.id=:parentId and t.cd = :cd");
        query.setParameter("parentId", parentId);
        query.setParameter("cd", cd);
        Ulist ulist;
        try {
            ulist = (Ulist) query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
        return ulist;
    }

    /* Получить элемент справочника по группе, коду группы, cd элемента, id организации
     * @param grp - группа справочника, например "NSI"
     * @param fkExt - код справочника, например 22
     * @param name - CD элемента, например "Причина закрытия лицевого счета"
     * @param s1 - значение элемента, например "Расторжение договора"
     * @param org - организация
     */
    @Override
    public Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org) {
    	//log.info("grp={}, fkExt={}, name={}, s1={}, org={}", grp, fkExt, name, s1, org.getId());
    	Query query;
    	if (org != null) {
    		query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.fkExt=fkExt and tp.grp=grp "
    				+ "and t.name=name and t.s1=s1 and t.parent.actual=true "
    				+ "and tp.eolink.id=:org ");
    		query.setParameter("org", org.getId());
    	} else {
    		query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.fkExt=:fkExt and tp.grp=:grp "
    				+ "and t.name=:name and t.s1=:s1 and t.parent.actual=true ");
    	}
		query.setParameter("grp", grp);
		query.setParameter("fkExt", fkExt);
		query.setParameter("name", name);
		query.setParameter("s1", s1);
		Ulist chld = (Ulist) query.getSingleResult();
		return chld.getParent();
    }

}
