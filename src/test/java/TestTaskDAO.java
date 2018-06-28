import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ric.bill.dao.TaskDAO;
import com.ric.bill.model.exs.Task;
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
public class TestTaskDAO {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private TaskDAO taskDao;

	@Test
    public void testPdoc() throws Exception {
		log.info("Start");
		Task task = em.find(Task.class, 1544216);
		log.info("Start method");
		taskDao.getByTaskAddrTp(task, "ЛС", null, 1).stream()
				.filter(t-> t.getAct().getCd().equals("GIS_ADD_ACC")).collect(Collectors.toList()).forEach(t-> {
						log.info("id={}", t.getId());
				});


		log.info("End");
    }


}
