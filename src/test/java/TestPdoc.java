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

import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.dao.PdocDAO;
import com.ric.bill.mm.PdocMng;
import com.ric.bill.model.ar.House;
import com.ric.bill.model.exs.Eolink;
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
public class TestPdoc {

	@PersistenceContext
    private EntityManager em;

	@Autowired
	private PdocDAO pdocDao;
	@Autowired
	private PdocMng pdocMng;
	
	@Test
    public void testPdoc() throws Exception {
		log.info("Start");

		pdocDao.getForLoadByHouseWithEntry(7570).stream().forEach(t-> {
			log.info("Платежный документ для лс с подъездом, Pdoc.id={}, Pdoc.cd={}", t.getId(), t.getCd());
		}); ;
		
		pdocDao.getForLoadByHouseWOEntry(7570).stream().forEach(t-> {
			log.info("Платежный документ для лс без подъезда, Pdoc.id={}, Pdoc.cd={}", t.getId(), t.getCd());
		}); ;

		Eolink houseEol = em.find(Eolink.class, 7570);
		pdocMng.getPdocForLoadByHouse(houseEol).stream().forEach(t-> {
			log.info("Платежный документ Pdoc.id={}, Pdoc.cd={}", t.getId(), t.getCd());
		}); ;

		log.info("End");
    }
	

}
