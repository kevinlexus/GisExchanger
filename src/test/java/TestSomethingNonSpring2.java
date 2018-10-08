import org.junit.Test;

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
