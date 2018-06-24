package com.neuedu.bookstore.view;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.css.ViewCSS;

import com.google.gson.Gson;
import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.Category;
import com.neuedu.bookstore.bean.Pager;
import com.neuedu.bookstore.bean.Result;
import com.neuedu.bookstore.service.IBookService;
import com.neuedu.bookstore.service.ICategoryService;

/*spring mvc 提供了多种编写控制器的方法，本例演示了其中最常用的一种
 * 1、编写一个普通的Java类，不需要继承任何类或者实现任何接口
 * 2.编写一个方法，返回string类型
 * 3.1、在前面使用@Controller生明本类是一个控制器,@RequestMapping声明调用的地址
 * 3.2、编写一个jsp视图页面
 * 4、部署程序到jsp页面，并运行服务器
 * 5、在浏览器输入控制器的访问地址，可以查看到程序的运行结果
 */

@Controller
@RequestMapping("/book")
public class BookController {

	private Logger logger = Logger.getRootLogger();
	//在控制层整合或调用业务逻辑层
	@Autowired
	private IBookService IBookService;
	@Autowired
	private ICategoryService CategoryService;
	
	@RequestMapping("/list")
	public String listBook(Model model,Pager<Book> pager,@RequestParam(defaultValue="1")int currentPage) {
		//Model是spring mvc封装的数据模型，用于在mvc各组件中传递数据，类似于HttpServletRequest对象
		
		//默认查询第一页，每页查询   5条记录
		
		int total = IBookService.countForPager(pager);//根据查询参数，查询记录总数
		pager.setTotal(total);
		
		pager.setCurrentPage(currentPage);//获取请求页面
		
		List<Book> books = IBookService.findBookByPager(pager);//根据分页参数及分页控制查询对应得数据
		pager.setResults(books);
		
		int pages = pager.getPages();
		
		model.addAttribute("page",pager);//类似于request.setAttribute(,);
		
		return "booklist";//返回页面的名称
	}
	
	@RequestMapping("/findByName")
	public String findByName(Model model,Pager<Book> pager, String bookName) {
		
		Book param = new Book();
		param.setBookName(bookName);//根据书籍名称进行模糊查询
		pager.setParam(param);//使用泛型传递查询参数
		
		List<Book> books = IBookService.findBookByPager(pager);
		pager.setResults(books);
		
		return "booklist";
	}
	
	@RequestMapping("/del")
	public String doDelBook(Model model, String isbn) {
		
		
		boolean ret = IBookService.deleteBook(isbn);
		
		if (ret) {
//			return "redirect:/book/list.action";
			//操作提示：使用model返回操作结果
			model.addAttribute("result",new Boolean(true));
			model.addAttribute("url", "list.action");
			return "result";
		}else {
			return "redirect:/book/list.action";
		}
	}
	
	@RequestMapping("/add")
	public ModelAndView toAddBook() {
		//查询书籍分类信息，并传递到页面信息
		List<Category> list = CategoryService.findAll();
		
		ModelAndView view = new ModelAndView("addbook");
		//view.addObject("categorys", list);
		view.getModelMap().put("categorys", list);
		
		return view;
	}
	
	@RequestMapping("/doadd")
	//spring mvc可以把表单或url参数封装到一个对象中
	//spring mvc可以把参数转换成基本数据类型，并封装到对象中
	public String addBook(Model model,@Validated Book book,BindingResult result,MultipartFile file1,HttpServletRequest request) throws IllegalStateException, IOException {
		//（网页）客户端提交数据到spring mvc后，会先进行数据的封装与转换，数据校验，完成后再进行控制器类进行处理
		//可以使用校验框架进行数据的集中校验，并获取校验结果，根据校验结果，进行跳转控制
		if (result.hasErrors()) {
			//去除所有的校验错误或字段校验错误
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error :errors) {
				logger.debug(error.getObjectName());
			}
			
			//把异常信息传回页面进行显示
			model.addAttribute("errors", errors);
			return "addbook";
			
		}
		
		//通过表单验证后，执行上传
		//如果文件不位空，写入上传路径
		 if(!file1.isEmpty()) {
	            //上传文件路径
	            String path = request.getServletContext().getRealPath("/uploads/");
	            //上传文件名
	            String filename = file1.getOriginalFilename();
	            String fileExt = filename.substring(filename.lastIndexOf("."));
	            String uuid = UUID.randomUUID().toString();//随机UUID文件名
	            
	            String newFile = uuid + fileExt;
	            File filepath = new File(path,newFile);
	            logger.info(newFile);
	            logger.info(filepath.getAbsolutePath());
	            
	            //判断路径是否存在，如果不存在就创建一个
	            if (!filepath.getParentFile().exists()) { 
	                filepath.getParentFile().mkdirs();
	            }
	            //将上传文件保存到一个目标文件当中
	            file1.transferTo(new File(path + File.separator + newFile));
	            
	            //上传成功,保存上传后的文件路径到book对象中，在调用业务类保存到数据库中
	            book.setBookImage("uploads/"+ newFile);
	        } 
		
//		boolean r = new Random().nextInt(10)%2==1?true:false;
//		if (r) 
//			throw new NullPointerException("模拟空指针异常");
		
		boolean ret = IBookService.addBook(book);
		
		//接收表单处理后，如果使用请求转发进行跳转会产生表单重复提交问题（刷新页面会重复提交）
		//为了解决表单重复提交，在处理更新操作后，一般会执行重定向跳转
		
		if (ret) {
//			return "forward:/book/list.action";
			return "redirect:/book/list.action";
		}else {
//			return "forward:/book/add.action";
			return "redirect:/book/list.action";
		}
	}
	
	@RequestMapping("/update")
	public ModelAndView toUpdateBook(String isbn) {
		//查询书籍分类信息，并传递到页面信息
		Book book = IBookService.findBookByIsbn(isbn);
		
		ModelAndView view = new ModelAndView("updatebook");
		view.getModelMap().put("book", book);
		
		return view;
	}
	@RequestMapping("/doupdate")
	public String updateBook(Model model,@Validated Book book,BindingResult result) {
		if (result.hasErrors()) {
			//去除所有的校验错误或字段校验错误
			List<ObjectError> errors = result.getAllErrors();
			
			for(ObjectError error :errors) {
				logger.debug(error.getObjectName());
			}
			
			//把异常信息传回页面进行显示
			model.addAttribute("errors", errors);
			return "updatebook";
			
		}
		
		boolean ret = IBookService.editBook(book);
		logger.info(book);
		
		if (ret) {
			return "redirect:/book/list.action";
		}else {
			return "redirect:/book/update.action";
		}
	}

	@RequestMapping("/search")
	@ResponseBody//页面内提示
	public String search(Book book) {
		
		logger.info("+++++" + book.getIsbn());
		
		Book book2 = IBookService.findBookByIsbn(book.getIsbn());
		
		Result result  = null;
		if (book2 != null) {
			result = new Result(true);
			String string = new Gson().toJson(result);
//			return s;
//			return "{result:true}";
		} else {
			result = new Result(false);
//			return result;
//			return "{result:false}";
		}
		String s = new Gson().toJson(result);//利用json把Java对象转换为json字符串
		return s;
	}
	
	
	
}
