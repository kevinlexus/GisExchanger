package com.ric.st.impl;

import com.dic.bill.model.scott.House;
import com.ric.st.DataProviders;
import com.ric.st.excp.CantFindEolinkObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DirectDataProvider implements DataProviders {

    @PersistenceContext
    private EntityManager em;

    /**
     * Перенос информации по дому из Директа в Eolink
     */
    @Override
    public void transferHouseDataToEolink(Integer houseId) throws CantFindEolinkObject {
        House house = em.find(House.class, houseId);
        // 1.проверить, существуют ли указанный дом в Eolink

        if (house == null) {
            throw new CantFindEolinkObject("Не возможно найти дом с House.id="+houseId);
        }


        // 2.перенести помещения, проверить, существуют ли подъезды в Eolink


        // 3.перенести лс, проверить, существуют ли помещения в Eolink



    }
}
