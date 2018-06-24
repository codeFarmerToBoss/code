package test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.bookstore.view.BookController;

public class TestBookController {

	private ApplicationContext context;
	private BookController bookController;
	private Logger logger = Logger.getLogger(TestBookService.class);
	
	@Before
	public void init() {
		String configLocation = "applicationContext.xml";
		String configLocation2 = "application-mvc.xml";
		context = new ClassPathXmlApplicationContext(configLocation,configLocation2);
		bookController = context.getBean(BookController.class);
	}
	@Test
	public void testBookList() {
//		String result = bookController.listBook();
//		
//		logger.info(result);
	}
}
