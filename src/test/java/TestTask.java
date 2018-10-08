import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.dao.TaskDAO;
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
public class TestTask {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private TaskDAO taskDao;

	@Test
	@Rollback(false) // коммитить транзакцию
    public void testTask() throws Exception {
		log.info("-----------------Begin");

		taskDao.getAllUnprocessed().stream().forEach(t-> {
			log.info("t.id={}", t.getId());
		});

/*		String actTp = "GIS_EXP_ORG";
		String parentCD = "SYSTEM_RPT_ORG_EXP";
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Организация", actTp, parentCD)) {
			log.info("Eolink.id={}, name={}", e.getId(), e.getGuid());
		}
*/
		log.info("-----------------End");
    }

}
