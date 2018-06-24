package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.mapper.BookMapper;
import com.neuedu.bookstore.mapper.CategoryMapper;

public class TestMybatis {

	public static void main(String[] args) {
		int count = 0;
		//1、加载mybatis运行环境
		try {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		//2、通过mybatis代理实例化Mapper数据操作接口
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		
		BookMapper bookMapper = session.getMapper(BookMapper.class);
		
		//3、调用接口对象进行数据操作
//		Category category1 = new Category(0, "11计算机");
//		int count1 = mapper.addCategory(category1);
//		//提交数据库
//		//4、对数据造作结果进行处理
//		if (count == 1) {
//			System.out.println("新增成功");
//		} else {
//			System.out.println("新增失败");
//		}

		//删除
//		count = mapper.deleteById(2); 
//		if (count == 1) {
//			System.out.println("删除成功");
//		} else {
//			System.out.println("删除失败");
//		}
		
		//修改
//		Category category2 = new Category(3, "英语");
//		count = mapper.editCategory(category2);
//		if (count == 1) {
//			System.out.println("修改成功");
//		} else {
//			System.out.println("修改失败");
//		}
		
//		//模糊查询
//		Category category = new Category(0, "%计算%"); 
//		List<Category> namelist = mapper.searchByName(category);
//		for (Category catg : namelist) {
//			System.out.println(catg.toString());
//		}
//		
//		//查询出所有的书籍信息，及其分类信息
//		List<Category> list = mapper.findAllCategoryToBook();
//			for (Category cat : list) {
//				System.out.println(cat.toString());
//			}
		//查找所有	
//		List<Category> list1 = mapper.findAll();
//		for (Category cat : list1) {
//			System.out.println(cat.toString());
//		}
		
		List<Book> bList = bookMapper.findAll();
		for(Book book : bList) {
			System.out.println(book.toString());
		}
		
		session.commit();
		//5、关闭数据库连接
		session.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
