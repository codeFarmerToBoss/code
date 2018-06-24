<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
</head>
<body>
	${error}
	<!--  -->
	<form action="<%=request.getContextPath()%>/system/login.action"
	name="loginForm" method="post">
	<table>
		<tr>
		<th colspan="2">用户登录</th>
		</tr>
		<tr>
		<td>账号：</td>
		<td><input name="account" type="text"></td>
		</tr>
		<tr>
		<td>密码：</td>
		<td><input name="password" type="password"></td>
		</tr>
		
		<tr>
		<td><input type="reset"></td>
		<td><input type="submit"></td>
		</tr>
	
	</table>
	
	</form>
</body>
</html>