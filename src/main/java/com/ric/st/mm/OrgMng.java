package com.ric.st.mm;

import com.ric.bill.dto.OrgDTO;
import com.ric.bill.model.exs.Eolink;

/**
 * Интерфейс сервиса организации
 * @author Leo
 *
 */
public interface OrgMng {

	OrgDTO getOrgDTO(Integer appTp);

    OrgDTO getOrgDTO(Eolink uk);
}
