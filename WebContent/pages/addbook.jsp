<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增书籍</title>
<base href="<%=request.getContextPath() + "/"%>">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
</head>
<body>

	<c:if test="${errors != null }">
	输入有误：<br />
		<c:forEach items="${errors}" var="er">
			<c:out value="${er.defaultMessage}"></c:out>
			<br />
		</c:forEach>
	</c:if>
	<!-- 执行文件上传需要修改form表单的类型enctype="multipart/form-data" -->
	<form name="bookForm" enctype="multipart/form-data" action="book/doadd.action" method="post">
		<table align="center" width="500">
			<tr>
				<td colspan="2">新增书籍</td>
			</tr>
			<tr>
				<td>出版号:</td>
				<td><input id="isbn" name="isbn" type="text" /><span id="isbnMsg"></span></td>
			</tr>
			<tr>
				<td>书籍名称:</td>
				<td><input name="bookName" type="text" /></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input name="price" type="text" /></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input name="publisher" type="text" /></td>
			</tr>
			<tr>
				<td>出版时间:</td>
				<td><input name="publishDate" type="text" /></td>
			</tr>
			<tr>
				<td>封面图片:</td>
				<!-- 文件上传时，文件域的名称不要与对象名一致，因为它们的类型不一致 ，spring mvc无法完成-->
				<td><input name="file1" type="file" /></td>
			</tr>
			<tr>
				<td>上架类型:</td>
				<td><select name="category.id">
						<c:forEach items="${categorys}" var="cate">
							<option value="${cate.id }">${cate.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="reset" /></td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
	$(document).ready(function(){//监听文档是否加载完毕
		  $("#isbn").blur(function(){//文档加载完毕后，监听失去焦点事件
			  //1.获取bookName的值
			  var  tempIsbn = $("#isbn").val();
			  //2.校验数据后发送ajax请求到服务器，查询书籍是否因录入系统
			  //使用json发送数据到服务器
			  $.post("book/search.action",{"isbn":tempIsbn},function(data){
				  //回调函数：发送异步请求到服务器，服务器处理后会返回相关数据，服务器返回后浏览器会自动调用(回调)该函数
				  //3.服务器返回查询结果后，提示用户操作 
				  //alert(data); 
				  //var d = eval(data);//eval函数把返回的字符串转换成json对象
				  var obj =JSON.parse(data);
				  if (obj.result) {
					$("#isbnMsg").text("书籍已经存在");
				} else {
					$("#isbnMsg").text("书籍不存在");
				}
			  });
		  });
	   }
	);

	</script>
	
</body>
</html>