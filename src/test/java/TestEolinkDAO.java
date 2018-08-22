import com.dic.bill.dao.AchargeDAO;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.PdocDAO;
import com.ric.bill.mm.LstMng;
import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.Pdoc;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskToTask;
import com.ric.st.builder.PseudoTaskBuilders;
import com.ric.st.impl.SoapConfig;
import com.ric.web.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
public class TestEolinkDAO {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkDAO eolinkDao;
	@Autowired
	private PseudoTaskBuilders ptb;
	@Autowired
	private LstMng lstMng;
	@Autowired
	private PdocDAO pdocDao;


	/**
	 * Проверить, работают ли запросы
	 * @throws Exception
	 */
	@Test
	@Rollback(false)
    public void isWorkTask() throws Exception {
		log.info("-----------------Begin");

		String actTp = "GIS_EXP_ORG";
		String parentCD = "SYSTEM_RPT_ORG_EXP";
/*
		for (Eolink e: eolinkDao.getEolinkByTpWoTaskTp("Организация", "GIS_EXP_ORG", "SYSTEM_RPT_ORG_EXP")) {
			log.info("check id={}", e.getId());
			// статус - STP, остановлено (будет запускаться другим заданием)
			ptb.setUp(e, null, actTp, "INS", 4);
			// добавить как зависимое задание к системному повторяемому заданию
			ptb.addAsChild(parentCD);
			ptb.save();

		}
*/
		Eolink eolink = em.find(Eolink.class, 707479);
		Task parent = em.find(Task.class, 1544621);
		Lst actVal = lstMng.getByCD(actTp);
		Task createdTask = Task.builder()
				.withEolink(eolink)
				.withParent(null)
				.withMaster(null)
				.withState("INS")
				.withAct(actVal)
				.withFk_user(4)
				.withErrAckCnt(0)
				.withCd("БЛАБЛАБЛА")
				.withTrace(0).build();
		//em.persist(createdTask);

		Lst lst = lstMng.getByCD("Связь повторяемого задания");
		TaskToTask t = new TaskToTask(parent, createdTask, lst);
		parent.getInside().add(t);

		em.persist(createdTask);

		log.info("-----------------End");
    }

}
