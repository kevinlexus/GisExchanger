package com.ric.st.mm;

import com.ric.bill.dto.OrgDTO;

/**
 * Интерфейс сервиса организации
 * @author Leo
 *
 */
public interface OrgMng {

	OrgDTO getOrgDTO(Integer appTp);
}
