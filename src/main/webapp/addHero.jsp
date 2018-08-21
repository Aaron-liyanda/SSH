<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>增添英雄</h1>
	<form action="addhero" method="get">
		name:<input type="text" name="hero.name" /><br><br>
		nickname:<input type="text" name="hero.nickname""/><br><br>
		first:<input type="text" name="hero.first" /><br><br>
		second:<input type="text" name="hero.second" "/><br><br>
		passivity:<input type="text" name="hero.passivity"/><br><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>