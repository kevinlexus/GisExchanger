import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ric.bill.dao.PdocDAO;
import com.ric.bill.model.exs.Pdoc;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

import com.dic.bill.dao.AchargeDAO;
import com.ric.bill.dao.AflowDAO;
import com.ric.web.AppConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * Исправный модуль, для тестирования Spring beans
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestDAOMeth {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private AchargeDAO achargeDao;
	@Autowired
	private AflowDAO aflowDao;

	/**
	 * Проверить, работают ли запросы
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
    public void isWorkAFlowDAOgetChrgGrp() throws Exception {
		log.info("-----------------Begin");

		aflowDao.getChrgGrp("62020006", "201801", 117661).stream().forEach(t-> {
			log.info("Ulist.Id={}, summa={}, price={}, vol={}",
					t.getUlistId(), t.getChrg(), t.getPrice(), t.getVol());
		});

		log.info("-----------------End");
    }



}
