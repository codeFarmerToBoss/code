package com.neuedu.bookstore.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.bookstore.bean.Book;
import com.neuedu.bookstore.bean.BookVo;

/*
 * 控制器类
 * 
 */
@Controller
public class DemoController {
	
	//url映射可以不在类上进行映射，直接配置方法映射即可
	//URL地址可以配置一级或多级
	//@RequestMapping("input")和@RequestMapping("input/input/input/input/input")
	@RequestMapping("demo/input")
	public String input(Model model,@RequestParam(value="n",required=true,defaultValue="hello mvc")String name) {
		//value="n"指定值得名称，required=true表示值不能为空，defaultValue="hello mvc"设置默认值为hello mvc
		model.addAttribute("input",name);
		return "inputResult";
	}
	
	//使用参数列表接收用户输入的多个参数
	@RequestMapping("demo/input2")
	public String input2(Model model,String name,int id) {
		//value="n"指定值得名称，required=true表示值不能为空，defaultValue="hello mvc"设置默认值为hello mvc
		model.addAttribute("input",name);
		model.addAttribute("input_id",id);
		
		return "inputResult";
	}
	
	//使用参数列表接收用户输入的多个参数
		@RequestMapping("demo/input3")
		public String input3(Model model,Book book) {
			model.addAttribute("input",book.getBookName());
			model.addAttribute("input_id",book.getIsbn());
			
			return "inputResult";
		}
		
		//使用参数列表接收用户输入的多个参数
		@RequestMapping("demo/input4")
		public String input4(Model model,String[] isbn) {
			model.addAttribute("isbns",isbn);
			
			return "inputResult";
		}
		
		//使用参数列表接收用户输入的多个参数
		@RequestMapping("demo/input5")
		public String input5(Model model,BookVo bookVo) {
			
		
			
			model.addAttribute("isbnList",bookVo.getBooks());
					
			return "inputResult";
		}
		
		//传统servlet技术接收用户输入和跳转控制
		@RequestMapping("demo/input6")
		public String input6(HttpServletRequest request,HttpServletResponse response) 
				throws ServletException, IOException {
					
		
			String isbn = request.getParameter("isbn");
			request.setAttribute("input", isbn);
			
			request.getRequestDispatcher("/pages/inputResult.jsp").forward(request, response);
							
			return "inputResult";
			
			
		}
		
		@RequestMapping("/demo/input7/{isbn}")
		public void input7(@PathVariable(value="isbn")String isbn,HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			response.getWriter().write(isbn);
		}
		
		
		
		
		
		
}
