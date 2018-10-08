import com.dic.bill.dao.NotifDAO;
import com.dic.bill.dao.PdocDAO;
import com.dic.bill.mm.PdocMng;
import com.ric.st.mm.DebMng;
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
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 * Исправный модуль, для тестирования вызова процедуры
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestProc {

	@PersistenceContext
    private EntityManager em;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Rollback(true)
    public void testProc() throws Exception {
		Integer ret = null;
		Integer par = null;

		log.info("Start");
		StoredProcedureQuery qr;
		qr = em.createStoredProcedureQuery("exs.p_gis.annulment_notif");
		qr.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		qr.registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT);
		par=434168;
		qr.setParameter(1, par);
		qr.execute();
		ret = (Integer) qr.getOutputParameterValue(2);
		log.info("ret={}", ret);
		log.info("End");
    }


}
