<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用于测试用户输入与参数传递</title>
</head>
<body>
用于测试用户输入与参数传递
来自demo的问候：${input}<br>
<c:forEach items="${isbnList}" var="isbn">
${isbn.isbn}
</c:forEach>
<br>
</body>
</html>