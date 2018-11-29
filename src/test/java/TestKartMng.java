import com.dic.bill.dao.KartDAO;
import com.dic.bill.mm.KartMng;
import com.dic.bill.model.scott.Kart;
import com.dic.bill.model.scott.Ko;
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
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Тестирование сервиса KartMng
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestKartMng {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private KartMng kartMng;

	/**
	 * Тест запроса на поиск k_lsk_id квартиры по параметрам
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
    public void isWorkKartMngGetKlskByKulNdKw() throws Exception {

		log.info("-----------------Begin");
		Ko ko = kartMng.getKlskByKulNdKw("0174", "000012", "0000066");
		log.info("Получен klsk={}", ko.getId());
		assertTrue(ko.getId().equals(105392));

        log.info("-----------------End");
    }


}
