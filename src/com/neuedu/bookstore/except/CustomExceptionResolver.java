package com.neuedu.bookstore.except;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		//根据不同的异常返回不同的视图或返回统一的视图
		ModelAndView view = null;
		if (exception instanceof NullPointerException) {
			view = new ModelAndView("common_error");
			//可以使用model传递提示信息到view中
			return view;
		} else {
			view = new ModelAndView("common_error2");
			view.addObject("message",exception.getMessage());
			return view;
		}
	}

}
