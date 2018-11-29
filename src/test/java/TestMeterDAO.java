import com.dic.bill.dao.KartDAO;
import com.dic.bill.dao.MeterDAO;
import com.dic.bill.model.scott.Kart;
import com.dic.bill.model.scott.Ko;
import com.dic.bill.model.scott.Meter;
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
 * Тестирование DAO Meter
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestMeterDAO {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private MeterDAO meterDao;

	/**
	 * Тест запроса на поиск счетчика по коду услуги и объекту Ko
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
    public void isWorkKartDAOFindByKulNdKw() throws Exception {

		int i=0, i2 = 0;
		log.info("-----------------Begin");
		// найти счетчики х.в. по объекту Ko
		List<Meter> meterLst = meterDao.findByKoUsl(105392, "011");
		for (Meter meter : meterLst) {
			log.info("Х.В. счетчик: Meter.id={}", meter.getId());
			assertTrue(meter.getId().equals(72910));
			i++;
	}
		// найти счетчики г.в. по объекту Ko
		meterLst = meterDao.findByKoUsl(105392, "015");
		for (Meter meter : meterLst) {
			log.info("Г.В. счетчик: Meter.id={}", meter.getId());
			assertTrue(meter.getId().equals(72911));
			i2++;
		}
		assertTrue(i>0 && i2>0);
/*
		List<Kart> lstKart;
		lstKart = kartDao.findByKulNdKw("0174", "000012", "0000066");
		// проверить совпадение id дома
		for (Kart kart : lstKart) {
			log.info("Проверка лиц.счета="+kart.getLsk());
			assertTrue(kart.getLsk().equals("14042300"));
			assertTrue(kart.getHouse().getId().equals(37985));
		}
*/
        log.info("-----------------End");
    }


}
