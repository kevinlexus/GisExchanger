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
    public void justTest() throws Exception {
		Integer idx = 5;
		
		
		//log.info("idx2={}", func(idx));
		log.info("idx3={}", idx);
	}

	private void func(Integer idx) {
		log.info("idx1={}", idx);
		idx=6;		
		//return idx;
	}
	class CheckMe {
		String name;
		Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
	}
	

	@Test
    public void justAdvanceTest() throws Exception {
		
		CheckMe checkMe = new CheckMe();
		checkMe.setAge(31);
		checkMe.setName("Andrew");
		func2(checkMe);
		//log.info("idx2={}", func(idx));
		log.info("age={}, name={}", checkMe.getAge(), checkMe.getName());
		
	}

	private void func2(CheckMe checkMe) {
		checkMe = new CheckMe();

		checkMe.setAge(33);
		checkMe.setName("Lev");
		
	}
	
	
/*	@Test
    public void checkCronExpression() throws Exception {
		Date date;
	    CronExpression exp;
	    
	    //String a = "* 2 * ? * * *";    
	    String a = "0 21/5 * ? * * *";    
        log.info("Правильно ли выражение={}", CronExpression.isValidExpression(a));
	    while (true) {
			exp = new CronExpression(a);
		    Date dt = new Date();//Utl.getDateFromStr("28.09.2017");
			//log.info("Дата={}", dt); 
		    if (exp.isSatisfiedBy(dt)) {
				log.info("Тек дата = {}, Подходит ли дата = {}", dt, exp.isSatisfiedBy(dt));
		    }
			//log.info("Подходит ли дата={}, {}, {}", exp.isSatisfiedBy(dt), 
				//	exp.getTimeAfter(dt), exp.getTimeBefore(dt));
			Thread.sleep(1000);
		}
	}*/
	
}
