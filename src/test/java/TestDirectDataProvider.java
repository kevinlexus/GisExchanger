import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.dao.NotifDAO;
import com.dic.bill.dao.PdocDAO;
import com.dic.bill.mm.PdocMng;
import com.dic.bill.model.exs.Eolink;
import com.ric.st.DataProviders;
import com.ric.st.impl.DirectDataProvider;
import com.ric.st.mm.DebMng;
import com.ric.web.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Тестирование провайдера данных из Директа
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestDirectDataProvider {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private PdocDAO pdocDao;
	@Autowired
	private NotifDAO notifDao;
	@Autowired
	private PdocMng pdocMng;
	@Autowired
	private DebMng debMng;
    @Autowired
    private EolinkDAO eolinkDao;

	@Test
    public void testPdoc() throws Exception {
		log.info("Start");
/*
        Eolink house = eolinkDao.getEolinkByReuKulNdTp(null, "0151", "000052", null, null, "Дом");

        log.info("Получен дом Eolink.id={}", house.getId());

		DataProviders dp = new DirectDataProvider();
		dp.transferHouseDataToEolink(6091);
*/
		log.info("End");
    }


}
