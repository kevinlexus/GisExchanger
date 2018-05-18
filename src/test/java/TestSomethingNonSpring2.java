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
import com.ric.bill.model.exs.Task;
import com.ric.st.builder.impl.DeviceMeteringAsyncBindingBuilder;
import com.ric.web.AppConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * Исправный модуль, для тестирования Non Spring beans 
 * @author lev
 *
 */
@Slf4j
public class TestSomethingNonSpring2 {

	@Test
    public void justTest() throws Exception {
		
		log.info("Answer={}", func(0));
		
	}

	private Double func(Integer idx) {
		try {
			log.info("Check={}", idx);
			return (double) (100/idx);
		} finally {
			log.info("Finally");
		}
	}
}
