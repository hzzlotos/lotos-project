<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.newtouch.servlet.FirstServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userName" class="java.lang.String" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>恭喜你登陆成功!</h1>

	<label>userName=<%=userName %></label><br/>
	<label>-----------------------------------------</label><br/>
	<label>request.userName=<%=request.getAttribute("userName")%></label><br/>
	<label>request.userName=<%=request.getAttribute("passWord")%></label><br/>
	<a href="<%=request.getContextPath() %>/jsp/platform.jsp">点击此连接进入论坛!</a>
</body>
</html>