package com.ric.st.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import com.ric.st.builder.impl.NsiAsyncBindingBuilder;

import ru.gosuslugi.dom.schema.integration.nsi_base.NsiItemType;
import ru.gosuslugi.dom.schema.integration.nsi_common.ExportNsiItemResult;


/*
 * Хранилище справочников, полученных от ГИС
 */
@Slf4j
public class RefStore {
	private List<Row> mapRef;
    
    // вложенный класс - запись 
    public class Row {
    	private String grp; // группа справочника
    	private BigInteger id; // id справочника
    	private NsiItemType res; // элементы справочника
    	// конструктор
    	public Row (NsiItemType nsiItemType, String grp, BigInteger id) {
    		this.setRes(nsiItemType);
    		this.setGrp(grp);
    		this.setId(id);
    	}
		public String getGrp() {
			return grp;
		}
		public void setGrp(String grp) {
			this.grp = grp;
		}
		public BigInteger getId() {
			return id;
		}
		public void setId(BigInteger id) {
			this.id = id;
		}
		public NsiItemType getRes() {
			return res;
		}
		public void setRes(NsiItemType nsiItemType) {
			this.res = nsiItemType;
		}
    }
    
    // конструктор
    public RefStore() {
    	mapRef = new ArrayList<Row>();
    }
    
	/**
	 * Добавить запись справочника в хранилище
	 * @param nsiItemType - справочник
	 * @param grp - группа
	 */
	public void add(NsiItemType nsiItemType, String grp, BigInteger id) {
		if (nsiItemType == null) {
			log.error("ВНИМАНИЕ! Пустой справочник grp={}, id={}", grp, id);
		}
		mapRef.add(new Row(nsiItemType, grp, id));
	}
	
	/**
	 * Получить справочник по группе и коду
	 * @param grp - группа
	 * @return 
	 * @return 
	 */
	public NsiItemType getByGrpId(String grp, BigInteger id) {
    	Optional<Row> res = mapRef.stream().filter(t -> t.getGrp().equals(grp))
    		.filter(t -> t.getId().equals(id))
    		.findAny();
		return res.get().getRes();
	}

	public List<Row> getMapRef() {
		return mapRef;
	}

}
