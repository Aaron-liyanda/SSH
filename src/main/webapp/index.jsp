<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>heroList</title>

</head>
<body>

	<h1 align="center">List</h1>
	<table border="1" cellpadding="10" cellspacing="0" width="100%">
	<tr>
		<td width="15%">姓名</td>
		<td width="15%">昵称</td>
		<td width="15%">第一职业</td>
		<td width="15%">第二职业</td>
		<td width="15%">被动</td>
		<td width="*%">操作</td>
	</tr>
	
	<c:forEach items="${request.heroList }" var="hero">
		<tr>
			<td>${hero.name }</td>
			<td>${hero.nickname }</td>
			<td>${hero.first }</td>
			<td>${hero.second }</td>
			<td>${hero.passivity }</td>
			<td>
				<a>修改</a>&nbsp;&nbsp;&nbsp;
				<a href="delhero?id=${hero.id}" >删除</a>
			</td>
		</tr>
	</c:forEach>
	
	</table>
	
	<a href="http://localhost:8080/2018_08_17_ssh_w/showhero">首页</a>
	<a href="http://localhost:8080/2018_08_17_ssh_w/showhero?page=${page+1 }">下一页</a>
	<a href="http://localhost:8080/2018_08_17_ssh_w/showhero?page=${page-1 }">上一页</a>
	<a href="http://localhost:8080/2018_08_17_ssh_w/showhero">首页</a>
	
</body>
</html>