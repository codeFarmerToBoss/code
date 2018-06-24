package test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neuedu.bookstore.mapper.BookMapper;
import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Pager;

public class TestBookMapper {

	private BookMapper bookMapper;
	private SqlSession session;
	
	private Logger logger = Logger.getRootLogger();
	
	
	//初始化方法用于初始化mybatis运行环境
	@Before
	public void init() {
		try {
			logger.info("准备初始化mybatis环境");
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		    session = sqlSessionFactory.openSession();
			bookMapper = session.getMapper(BookMapper.class);
			
			logger.info("初始化mybatis环境");
			
			}catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	//使用Junit执行的单元测试
	@Test
	public void testFindAll() {
		
		//查找所有book
		List<Book> books = bookMapper.findAll();
		for (Book book:books) {
			System.out.println(book.toString());
		}
	}
	
	@Test
	public void testFindAllWithCategory() {
		
		//查找所有book
		List<Book> books = bookMapper.findAllWithCategory();
		for (Book book:books) {
			System.out.println(book.toString());
		}
	}
	
	@Test
	public void testfindBookByIsbn() {
		Book book = bookMapper.findBookByIsbn("ISBN-123464-11");
		System.out.println(book.toString());
	}
	
	
	
	@Test
	public void testFindByExample3() {
		Book example = new Book();
		example.setBookName("中");
		example.setIsbn("54");
		
		List<Book> books = bookMapper.findByExample(example);
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testDeleteBook() {
		String isbn = "ISBN-123464-16";
		
		int count = bookMapper.deleteBook(isbn);
		if (count == 1) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
	
	//分页查询
	@Test
	public void testFindByPage() {
		
		//默认查询第一页，每页查询   5条记录
		Pager<Book> pager = new Pager<Book>(1,5);
		//搜索条件
		Book param = new Book();
		param.setBookName("大英");//根据书籍名称进行模糊查询
		pager.setParam(param);//使用泛型传递查询参数
		int total = bookMapper.countForPager(pager);//根据查询参数，查询记录总数
		pager.setTotal(total);
		System.out.println("上一页："+pager.getPrePage()+"下一页：" 
					+ pager.getNextPages()+"总页数："+pager.getPages());
		
		List<Book> books = bookMapper.findBookByPager(pager);//根据分页参数及分页控制查询对应得数据
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	//在test执行完成后，用于资源回收
	@After
	public void destrop() {
		if (session != null) {
			session.commit();
			session.close();
		}
	}
	
	
}
