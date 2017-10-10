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

import com.ric.bill.Utl;
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
public class TestSomethingNonSpring {

	@Test
    public void checkCronExpression() throws Exception {
		Date date;
	    CronExpression exp;
	    
	    
/*	    Seconds	 	0-59	 	, - * /
	    Minutes	 	0-59	 	, - * /
	    Hours	 	0-23	 	, - * /
	    Day-of-month	 	1-31	 	, - * ? / L W
	    Month	 	1-12 or JAN-DEC	 	, - * /
	    Day-of-Week	 	1-7 or SUN-SAT	 	, - * ? / L #
	    Year (Optional)	 	empty, 1970-2199	 	, - * /
*/	    
	    //String a = "* * * L-2 * ? *";      
	    String a = "0 * * ? * * *";      
	    // Run every 10 minutes and 30 seconds of any year
	    //String b = "30 */10 * * * ? *"; 
		exp = new CronExpression(a);
        log.info("Правильно ли выражение={}", exp.isValidExpression(a));
	    while (true) {
		    Date dt = new Date();//Utl.getDateFromStr("28.09.2017");
			//log.info("Дата={}", dt); 
			log.info("Тек дата = {}, Подходит ли дата = {}", dt, exp.isSatisfiedBy(dt));
			//log.info("Подходит ли дата={}, {}, {}", exp.isSatisfiedBy(dt), 
				//	exp.getTimeAfter(dt), exp.getTimeBefore(dt));
			Thread.sleep(1000);
		}
	}
	
}
