<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SESSION</title>
</head>
<body>
	<form action="../LoginFormServlet" name="name" method="POST">
		用户名: <input type="text" name="userName" />
		<br />
		密  码: <input type="password" name="passWord" />
		<br />
		验证码: <input type="text" name="checkCode" />
		<img src="/session/CheckCodeServlet" />
		<input type="submit" value="登录" />
	</form>
</body>
</html>