package com.neuedu.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//执行完毕，返回前拦截
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 在处理过程中，执行拦截
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作
		//返回false不执行拦截
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		if (session.getAttribute("LOGIN_USER")!= null) {
				//|| uri.indexOf("system/login.action")!=-1) {//说明登录成功或执行登录功能
			
			//登录成功不拦截
			return true;
		} else {
			
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
			return false;
		}
		
	}

}
