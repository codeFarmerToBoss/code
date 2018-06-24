package com.neuedu.bookstore.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class LoginController {

	@RequestMapping("/login")
	public String loggin(String account,String password,HttpServletRequest request) {
		
		if ("admin".equals(account) && "admin".equals(password)) {
			//request.getSession(true);当参数值为true时与无参数的功能一致request.getSession();
			//表示系统中会话则返回该会话，没有会话则创建新的会话并返回
			//request.getSession(false);表示系统中会话则返回该会话，没有会话则返回null
			//会话默认的有效时长是30分钟，在特定场景可调整会话的失效时长
			//会话失效有3种 1、会话超时失效，2.、客户端挂关闭3、在服务器内调用session
			HttpSession session = request.getSession(true);
			session.setAttribute("LOGIN_USER", account);
			
			return "redirect:/book/list.action";	//成功
		} else {
			
			request.setAttribute("error", "账号或者密码错误");
			return "login";	//登录失败返回登录页面
		}
		
	}
	
	@RequestMapping("/login2")
	public String loggin2(String account,String password,HttpSession session) {
		
		if ("admin".equals(account) && "admin".equals(password)) {
			
			return "redirect:/book/list.action";	//成功
		} else {
			return "login";	//登录失败返回登录页面
		}
		
	}
}
