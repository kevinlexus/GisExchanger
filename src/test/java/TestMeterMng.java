import com.dic.bill.dao.MeterDAO;
import com.dic.bill.dto.MeterData;
import com.dic.bill.mm.MeterMng;
import com.dic.bill.model.exs.Eolink;
import com.dic.bill.model.scott.Meter;
import com.ric.cmn.Utl;
import com.ric.st.CommonErrs;
import com.ric.st.impl.CommonUtl;
import com.ric.st.impl.SoapConfig;
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
import javax.xml.datatype.XMLGregorianCalendar;
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
	@Autowired
	private SoapConfig soapConfig;

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
		XMLGregorianCalendar ts = Utl.getXMLDate(Utl.getDateFromStr("30.03.2014"));
		List<MeterData> lst = new ArrayList<>(5);
		MeterData elem = new LocalMeterData();
		lst.add(elem);
		lst.add(elem);
		lst.add(elem);
		lst.add(elem);

		assertTrue(meterMng.getIsMeterDataExist(lst, "2312-1316-4564-4654-4463", ts));

		log.info("-----------------End");
    }

	/**
	 * Тест на корректность записи кода ошибки в Eolink
	 * @throws Exception
	 */
	@Test
	@Rollback(true)
	public void isErrEolinkSetCorrectly() throws Exception {
		long err = (CommonErrs.ERR_OBJECT_NOT_FOUND | CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR
				| CommonErrs.ERR_EMPTY_KLSK);
		System.out.println("Ошибки1:"+CommonUtl.getErrorDescrByCode(err));
		// добавить ошибку
		err |= CommonErrs.ERR_METER_NOT_FOUND;
		System.out.println("Ошибки2:"+CommonUtl.getErrorDescrByCode(err));
		// погасить ошибки
		err ^= CommonErrs.ERR_EMPTY_KLSK | CommonErrs.ERR_OBJECT_NOT_FOUND;
		System.out.println("Ошибки3:"+CommonUtl.getErrorDescrByCode(err));
	}

	@Test
	@Rollback(false)
	public void justCheck() throws Exception {
		System.out.println("begin");
		Eolink eolink = em.find(Eolink.class, 707538);
		soapConfig.saveError(eolink, CommonErrs.ERR_METER_NOT_FOUND, true);
		soapConfig.saveError(eolink, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR, true);
		soapConfig.saveError(eolink, CommonErrs.ERR_METER_NOT_FOUND, false);
		soapConfig.saveError(eolink, CommonErrs.ERR_DIFF_KLSK_BUT_SAME_ADDR, false);
		System.out.println("end");
	}

}
