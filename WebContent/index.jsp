<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

	jsp的执行有翻译、编译和执行 三大过程；三个过程都是在jsp服务器中完成的
	修改jsp文件后，第一次访问会执行jsp翻译，编译和执行；第二次及其访问直接执行编译后的类（没有翻译和编译）
	
	翻译：是把执行jsp文件翻译成Java文件
	编译：是把Java文件编译成class字节码/类文件
	执行：是jvm解析和执行class类文件
	
	servlet的生命周期方法：init方法，service方法：doGet/doPost/service,destroy方法
	
	init方法，第一次范根servlet时执行servlet的实例化和初始化init方法，第2~n次访问不执行；只执行一次
	service方法：每次请求servlet都会执行，可执行多次；它是多线程执行的， 可能产生线程同步问题（如：一个线程修改了另一个线程的数据）
	destory方法：单Tomact服务器正常关闭时，会执行一次销毁方法；只执行一次
	
	Filter过滤器的生命周期：
		1、生命周期方法：init、doFilter、destory
		2、当服务器启动时，会执行实例化（构造）方法和初始化init方法，init方法只执行一次
		3、每次通过过滤器的请求都会执行doFilter方法，会执行多次
		4、当服务器关闭时，会执行一次destory方法，只执行一次
	
	listener监听器：
		1、监听器有多种，常见的：上下文环境监听器，session会话监听器，属性监听器
		2、上下文环境监听器是监听服务器的，session监听器是监听用户会话创建和销毁的，属性监听器用于监听服务器内置对象属性的绑定与解绑定

</body>
</html>