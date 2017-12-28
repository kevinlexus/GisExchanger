package com.ric.st.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		Query query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.grp=:grp and tp.id=:id");
		query.setParameter("grp", grp);
		query.setParameter("id", id.intValue());
		return query.getResultList();
    }*/
    
    public void delListByListTp(UlistTp ulistTp) {
		Query query =em.createQuery("delete from Ulist where ulistTp=:ulistTp");
		query.setParameter("ulistTp", ulistTp);
		query.executeUpdate();
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
    
    /* Получить элемент справочника по группе, коду группы, cd элемента, id организации
     * @param grp - группа справочника, например "NSI"
     * @param fkExt - код справочника, например 22
     * @param name - CD элемента, например "Причина закрытия лицевого счета"
     * @param s1 - значение элемента, например "Расторжение договора"
     * @param org - организация
     */
    public Ulist getListElem(String grp, Integer fkExt, String name, String s1, Eolink org) {
    	//log.info("grp={}, fkExt={}, name={}, s1={}, org={}", grp, fkExt, name, s1, org.getId());
    	Query query;
    	if (org != null) {
    		query =em.createQuery("select t from Ulist t join t.ulistTp tp where tp.fkExt=:fkExt and tp.grp=:grp "
    				+ "and t.name=:name and t.s1=:s1 and t.parent.actual=true "
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
