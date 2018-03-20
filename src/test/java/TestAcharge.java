import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

import com.dic.bill.dao.AchargeDAO;
import com.ric.bill.dao.AflowDAO;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.ServGis;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.hotora.scott.Usl;
import com.ric.st.builder.impl.DeviceMeteringAsyncBindingBuilder;
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
public class TestAcharge {

	@PersistenceContext
    private EntityManager em;

//	@Autowired
//	private AchargeDAO achargeDao;
	@Autowired
	private AflowDAO aflowDao;
	
	@Test
	@Rollback(false) // коммитить транзакцию
    public void testAfterLsk() throws Exception {
		log.info("-----------------Begin");

/*		achargeDao.getAfterLsk("00000026").stream().forEach(t-> {
			log.info("Kart: lsk={}, kul={}", t.getLsk(), t.getKul());
		});;
		
		achargeDao.getByLsk("00000026").stream().forEach(t-> {
			log.info("Acharge1: lsk={}", t.getLsk());
		});;
		
		achargeDao.getByLskPeriod("00000026", 201402).stream().forEach(t-> {
			log.info("Acharge2: lsk={}", t.getLsk());
		});;*/

		/*ServGis t = em.find(ServGis.class, 1);
		System.out.println("1id="+t.getId());
		System.out.println("id="+t.getUsl().getId());
		System.out.println("id="+t.getOrg());
		t = em.find(ServGis.class, 2);
		System.out.println("2id="+t.getId());
		System.out.println("id="+t.getUsl().getId());
		System.out.println("id="+t.getOrg());
		t = em.find(ServGis.class, 3);
		System.out.println("3id="+t.getId());
		System.out.println("id="+t.getOrg());
		System.out.println("id="+t.getUsl().getId());
		
		Usl u = em.find(Usl.class, "003");
		log.info("Usl={}", u);
		log.info("Usl.id={}, Usl.nm={}, GUID={}", u.getId(), u.getNm(), u.getServGis().getUlist().getGuid());*/

		aflowDao.getGrp3("62020006", "201801", 0, 117661).stream().forEach(t-> {
			log.info("Ulist.Id={}, summa={}, price={}, vol={}", t.getUlistId(), t.getSumma(), t.getPrice(), t.getVol());
			//log.info("test={}", t.getID());
		});

/*		achargeDao.getGrp("00000276", 201404, 1).stream().forEach(t-> {
			System.out.println("id="+t.getServGis().getUlist().getGuid());
		});*/
		//log.info("Acharge2: usl={}, GUID={}, summa={}", t.getServGis().getUsl(),/* t.getServGis().getUlist().getGuid(),*/ t.getSumma());
		
		log.info("-----------------End");
    }

}
