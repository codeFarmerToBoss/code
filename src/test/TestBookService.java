package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Pager;
import com.neuedu.bookstore.service.IBookService;

public class TestBookService {
	
	private ApplicationContext context;
	private IBookService bookService;
	private Logger logger = Logger.getLogger(TestBookService.class);
	
	@Before
	public void init() {
		String configLocation = "applicationContext.xml";
		context = new ClassPathXmlApplicationContext(configLocation);
		bookService = context.getBean(IBookService.class);
	}
	@Test
	public void testFindAll() {
		List<Book> list = bookService.findAll();
		for(Book book:list){
			logger.info(book);
		}
	}
	
	@Test
	public void testfindAllWithCategory() {
		List<Book> list = bookService.findAllWithCategory();
		for(Book book:list){
			logger.info(book);
		}
	}
	
	@Test
	public void testfindBookByIsbn() {
		String isbn = "ISBN-123464-32";
		Book book = bookService.findBookByIsbn(isbn);
		logger.info(book);
		
	}
	
	@Test
	public void testEditBook() {
		Book book = new Book();
		book.setBookName("进化论1");
		book.setIsbn("ISBN-123464-32");
		book.setPrice(30.0);
		logger.info("成功修改");
	}
	
	@Test
	public void testFindByExample() {
		
		Book book = new Book();
		book.setBookName("中");
		book.setIsbn("123464");
		
		List<Book> book2 = bookService.findByExample(book);
		
		for(Book book3:book2) {
			logger.info(book3);
		}
	}
	
	@Test
	public void testFindByIsbnList() {
		
		List<String> Isbn = new ArrayList<>();
		
		Isbn.add("ISBN-123464-54");
		Isbn.add("ISBN-123464-14");
		Isbn.add("ISBN-123464-34");
		Isbn.add("ISBN-123464-42");
		
		List<Book> book = bookService.findByIsbnList(Isbn);
		
		for(Book book1:book) {
			logger.info(book1);
		}
	}
	
	@Test
	public void testFindBookByPager() {
		
		//默认查询第一页，每页查询   5条记录
		Pager<Book> pager = new Pager<Book>(1,4);
		//搜索条件
		Book param = new Book();
		param.setBookName("大英");//根据书籍名称进行模糊查询
		pager.setParam(param);//使用泛型传递查询参数
		int total = bookService.countForPager(pager);//根据查询参数，查询记录总数
		pager.setTotal(total);
		logger.info("上一页："+pager.getPrePage()+"下一页：" 
				+ pager.getNextPages()+"总页数："+pager.getPages());
				
		List<Book> books = bookService.findBookByPager(pager);//根据分页参数及分页控制查询对应得数据
		for(Book book : books) {
			logger.info(book);
		}
	}
	


}
