<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改书籍</title>
<base href="<%=request.getContextPath() + "/"%>">
</head>
<body>

	<form name="bookForm" action="book/doupdate.action" method="post">
		<table align="center" width="500">
			<tr>
				<td colspan="2">修改书籍</td>
			</tr>
			<tr>
			<td style="display: none"><input name="isbn" value="${book.isbn}" type="text" /></td>
			</tr>
			<tr>
				<td>书籍名称:</td>
				<td><input name="bookName" value="${book.bookName}" type="text" /></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input name="price" value="${book.price}" type="text" /></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input name="publisher" value="${book.publisher}" type="text" /></td>
			</tr>
			<tr>
				<td>出版时间:</td>
				<td><input name="publishDate" value="${book.publishDate}" type="text" /></td>
			</tr>
			<tr>
				<td><input type="reset" /></td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>