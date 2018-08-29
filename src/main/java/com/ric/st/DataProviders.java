package com.ric.st;

import com.ric.st.excp.CantFindEolinkObject;

public interface DataProviders {

    void transferHouseDataToEolink(Integer houseId) throws CantFindEolinkObject;
}
