<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SESSION</title>
</head>
<body>
	<form action="./LoginServlet" name="name" method="POST">
		用户名: <input type="text" name="name" />
		<br />
		<input type="submit" value="登录" />
	</form>
	<a href="<%=request.getContextPath() %>/donotagain/login.jsp">验证码测试</a>
	
	<a href="<%=request.getContextPath() %>/check/loginCheck.jsp">验证码图片测试</a>
</body>
</html>