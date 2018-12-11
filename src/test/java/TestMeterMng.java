import com.dic.bill.dao.MeterDAO;
import com.dic.bill.dto.MeterData;
import com.dic.bill.mm.MeterMng;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Тестирование сервиса MeterMng
 * @author lev
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Slf4j
public class TestMeterMng {

	@PersistenceContext
    private EntityManager em;
	@Autowired
	private MeterDAO meterDao;
	@Autowired
	private MeterMng meterMng;

	/**
	 * Тест на наличие показаний счетчика по GUID и Timestamp
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
    public void isFindMeterDataByGuidTs() throws Exception {
		class LocalMeterData implements MeterData {
			public Date getTs() {
				return Utl.getDateFromStr("30.03.2014");
			}
			public String getGuid() {
				return "2312-1316-4564-4654-4463";
			}
		}

		int i=0, i2 = 0;
		log.info("-----------------Begin");
		// найти счетчики х.в. по объекту Ko
		Date ts = Utl.getDateFromStr("30.03.2014");
		List<MeterData> lst = new ArrayList<>(5);
		MeterData elem = new LocalMeterData();
		lst.add(elem);
		lst.add(elem);
		lst.add(elem);
		lst.add(elem);

		assertTrue(meterMng.getIsMeterDataExist(lst, "2312-1316-4564-4654-4463", ts));

		log.info("-----------------End");
    }


}
