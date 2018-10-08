import static org.junit.Assert.assertEquals;

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

import com.dic.bill.dao.EolinkDAO;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.exs.Task;
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
public class TestSomething {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private EolinkDAO eolinkDao;

	@Test
    public void contextLoads() throws Exception {
		log.info("Start");
			String state = "TT1";
			Task oneTask = em.find(Task.class, 11913);
			oneTask.setState(state);
			assertEquals(oneTask.getState(), state);

		log.info("End");
    }

	@Test
    public void testHQL() throws Exception {
		log.info("Start");

		eolinkDao.getValsNotSaved().stream().forEach(t-> {
			log.info("Eolink.id={}", t.getId());
		});;

		log.info("End");
    }

	@Test
    public void testChild() throws Exception {
		log.info("Start");

		Eolink parent = em.find(Eolink.class, 7163);
		eolinkDao.getChildByTp(parent, "Подъезд").stream().forEach(t -> {
			log.info("Eol={}", t.getId());
		});;

		log.info("End-1");
    }




	/*    @Transactional(readOnly=false)
	public void work1() throws EmptyStorable, WrongSetMethod {
    	int rqn =-1;
		Obj obj = objMng.getByCD(-1, "Модуль начисления");

		Dw d = em.find(Dw.class, 8214820);
		Calendar calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 6);
		parMng.setDate(rqn, obj, "Начало расчетного периода", calendar.getTime());
		//d.setDts1(calendar.getTime());

		calendar = new GregorianCalendar(2017, Calendar.FEBRUARY, 8);
		parMng.setDate(rqn, obj, "Конец расчетного периода", calendar.getTime());

		log.info("Check ={}", obj.getId());
		log.info("Check dt1={} {}", parMng.getDate(-1, obj, "Начало расчетного периода"));
    	log.info("Check dt1={}", parMng.getDate(-1, obj, "Конец расчетного периода"));

	}*/


}
