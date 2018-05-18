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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;

import com.ric.cmn.Utl;
import com.ric.bill.dao.EolinkDAO;
import com.ric.bill.model.exs.Eolink;
import com.ric.bill.model.exs.ServGis;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.hotora.oralv.Org;
import com.ric.bill.model.hotora.oralv.SchetContragent;
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
public class TestSchetContragent {

	@PersistenceContext
    private EntityManager em;

	@Test
    public void test() throws Exception {
		log.info("Start testSchetContragent");

		Org org = em.find(com.ric.bill.model.hotora.oralv.Org.class, 1);
		log.info("Org.name={}", org.getName());
		
		SchetContragent sch = org.getSchetContr();
		log.info("BIK={}", sch.getBik());

		//ServGis sg = em.find(ServGis.class, 12);
				
		//log.info("usl.id={}", sg.getUsl().getNm());
		
		
		log.info("End testSchetContragent");
    }

}
