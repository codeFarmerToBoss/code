<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作结果</title>
</head>
<body>

	
	<c:if test="${result == true }">
		<h3>操作成功</h3>	
		<a href="${url }">点击返回</a>
	</c:if>
	
	<c:if test="${result == false }">
		<h3>操作失败</h3>	
		<a href="${url }">点击返回</a>
		<!-- 解决表单的重复提交问题的三种常用方法
		1.使用JavaScript客户端技术，解决表单的重复提交问题
		2、使用服务端的token标识进行判断
		3.使用服务端的重定向解决重复提交问题
	 -->
	 <div id="showTime"></div>
	 <!-- 使用JavaScript进行跳转 -->
	 <script type="text/javascript">
	 	var delay = 5;
	 	var h ;
	 	function goback(){
	 		delay--;
	 		document.getElementById("showTime").innerHTML = delay + "秒后自动返回";
	 		if(delay == 0){
	 			location.href="${url}";
	 			clearInterval(h);
	 		}
	 	}
	 
	 </script>
	</c:if>
</body>
</html>