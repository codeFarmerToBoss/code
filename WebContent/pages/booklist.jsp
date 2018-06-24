<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//使用base标签解决网站的相对路径问题
	String basePath = request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/mycss.css">
<title>书籍列表页面</title>
<base href="<%=basePath %>">

</head>
<body>
	<h2 style="text-align: center;">书籍列表</h2>
	<div class="box1">
	<form name="bookList" action="book/findByName.action" method="post">
	<h6>
	<button><a href="book/add.action">新增图书</a></button>
	<input id="inp1" class="inp1" name="bookName"  type="text" value="输入书名..."/>
	<input id="inp2" class="inp2" type="submit" name="查询" value="查询"/>
	
	</h6>
	</form>
	<table align="center" border="1px">
		<tr>
			<td>isbn</td>
			<td>书籍名称</td>
			<td>价格</td>
			<td>出版社</td>
			<td>出版时间</td>
			<td>封面图片</td>
			<td>分类</td>
			<td colspan="2" >功能</td>
		</tr>
		<c:forEach items="${pager.results}" var="book" varStatus="idx">
		   <c:if test="${idx.index mod 2 ==1}">
		   <tr>
		   </c:if>
		  <c:if test="${idx.index mod 2 ==0}">
		     <tr style="background-color: #ddd;">
		  </c:if>
			<td>${book.isbn}</td>
			<td>${book.bookName}</td>
			<td>${book.price}</td>
			<td>${book.publisher}</td>
			<td>${book.publishDate}</td>
			<td><img height="60" alt="封面图片" src="${book.bookImage }"></td>
			<td>${book.category.id}</td>
			<td><a href="book/update.action?isbn=${book.isbn}">修改</a></td>
			<td><a href="javascript:deleteBook('${book.isbn}')">删除</a></td>
		</tr>
		</c:forEach>
	</table>
	<p style="text-align: center;">
	<c:if test="${pager.currentPage == 1}">
		首页
	</c:if>
	<c:if test="${pager.currentPage != 1}">
		<a href="book/list.action?currentPage=1">首页</a>
	</c:if>
	
	<c:if test="${pager.currentPage <= 1}">
	上一页
	</c:if>
	<c:if test="${pager.currentPage > 1}">
	<a href="book/list.action?currentPage=${pager.currentPage-1}">上一页</a>
	</c:if>
	<c:if test="${pager.currentPage <pager.pages}">
	<a href="book/list.action?currentPage=${pager.currentPage+1}">下一页</a>
	</c:if>
	<c:if test="${pager.currentPage >= pager.pages}">
	下一页
	</c:if>
	<c:if test="${pager.currentPage < pager.pages}">
	<a href="book/list.action?currentPage=${pager.pages}">尾页</a>
	</c:if>
	<c:if test="${pager.currentPage >= pager.pages}">
	尾页
	</c:if>
	当前第${pager.currentPage}页
	共${pager.pages}页 有${pager.total}条记录
	</p>
	</div>
	<script type="text/javascript">
		function deleteBook(isbn){
			if(confirm("确认删除？")){
				location.href="book/del.action?isbn="+isbn;
			}
		}
		
		//查询输入提示字体消息
		window.onload = function () {
			var oinp1 = document.getElementById('inp1');
			oinp1.onfocus = function(){
				oinp1.setAttribute('value','');
			} ;
			oinp1.onblur = function(){
				oinp1.setAttribute('value','输入书名...');
			} ;
			
			//判断输入是否为空
			var oinp2 = document.getElementById('inp2');
			oinp2.onclick = function(){
				var val = oinp1.getAttribute('value');
				console.log(val);
				if(val == '输入书名...'){
					oinp1.setAttribute('value','');
				}
			};
		}
		
		
		
		
		
	
	</script>
	
</body>
</html>