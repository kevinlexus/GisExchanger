import com.dic.bill.dao.EolinkDAO2;
import com.dic.bill.dto.HouseUkTaskRec;
import com.dic.bill.model.bs.Lst2;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestEolinkDAO {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private EolinkDAO2 eolinkDAO2;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(true)
    public void testGetHouseByTpWoTaskTp() throws Exception {
		log.info("Test eolinkDAO.getHouseByTpWoTaskTp - Start");

		for (HouseUkTaskRec t : eolinkDAO2.getHouseByTpWoTaskTp("GIS_EXP_HOUSE", "GIS_EXP_ACCS")) {
			log.info("check house.id={}, task.id={}, uk.id={}", t.getEolHouseId(), t.getMasterTaskId(), t.getEolUkId());
		}

/*
		Eolink eolink = em.find(Eolink.class, 706814);
		Eolink procUk = em.find(Eolink.class, 708111);
		Task parent = em.find(Task.class, 1544869);
		Task master = em.find(Task.class, 1544862);
		Lst2 lst2 = em.find(Lst2.class, 145);
		Task task = Task.builder()
				.withEolink(eolink)
				.withParent(parent)
				.withMaster(master)
				.withState("STP")
				.withAct(lst2)
				.withFk_user(1)
				.withErrAckCnt(0)
				.withProcUk(procUk)
				.withTrace(0).build();
		em.persist(task);
		eolinkDAO2.getHouseByTpWoTaskTp(null, null);
*/
	}


}
