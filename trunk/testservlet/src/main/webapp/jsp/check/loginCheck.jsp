<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SESSION</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/loginformservlet" name="name" method="POST">
		验证码: <input type="text" name="checkCode" />
		<img src="<%=request.getContextPath() %>/checkcodeservlet" />
		<input type="submit" value="登录" />
	</form>
</body>
</html>