import com.dic.bill.dao.MeterDAO;
import com.dic.bill.dto.MeterData;
import com.dic.bill.model.scott.Meter;
import com.ric.cmn.Utl;
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
import java.util.Date;
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
		Date dt = Utl.getDateFromStr("30.03.2014");
		List<Meter> meterLst = meterDao.findActualByKoUsl(105392, "011", dt);
		for (Meter meter : meterLst) {
			log.info("Х.В. счетчик: Meter.id={}", meter.getId());
			assertTrue(meter.getId().equals(72910) ||meter.getId().equals(73522));
			i++;
	}
		// найти счетчики г.в. по объекту Ko
		meterLst = meterDao.findActualByKoUsl(105392, "015", dt);
		for (Meter meter : meterLst) {
			log.info("Г.В. счетчик: Meter.id={}", meter.getId());
			assertTrue(meter.getId().equals(72911));
			i2++;
		}
		assertTrue(i==1 && i2==1);
		log.info("-----------------End");
    }

	/**
	 * Тест запроса на поиск счетчика по коду услуги и объекту Ko
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void isWorkFindTimesampByUser() throws Exception {

		int i=0, i2 = 0;
		log.info("-----------------Begin");
		Date dt1 = Utl.getDateFromStr("30.03.2014");
		Date dt2 = Utl.getDateFromStr("07.12.2018");
		// найти показания счетчиков
		List<MeterData> lst = meterDao.findMeteringDataTsByUser("GIS", "ins_sch", dt1, dt2);
		for (MeterData t : lst) {
			System.out.println(t.getTs()+" "+t.getGuid());
			i++;
		}
		assertTrue(i==1);
		log.info("-----------------End");
	}

}
