<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.newtouch.web.DoNotAgain.TokenProcessor"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SESSION</title>
</head>
<body>
	<form action="FormDealServlet" name="name" method="POST">
		<input type="text" name="<%=TokenProcessor.KEY %>" 
		value="<%=(String)request.getSession().getAttribute(TokenProcessor.KEY) %>" >
		<br />
		字段: <input type="text" name="p1" />
		<br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>