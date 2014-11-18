<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="hnml" uri="/taglibs/htld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
</head>
<body>
	
	<h1 align="center" style="color:red;"><hnml:propertie attiName="hello" propName="mvc.properties"></hnml:propertie></h1>
	<form action="<%=request.getContextPath() %>/login/submit/1?aaa=bbb" method="post">
		<table>
			<tr>
				<td><label>用户名:</label></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><label>密码:</label></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><label>上传文件:</label></td>
				<td><input name="file" type="file" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" value="确定" /></td>
				<td><input type="reset"  value="重写" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${null!=errorMessage}">
		<c:out value="${errorMessage}"></c:out>
	</c:if><br/>
	-----------------------------------------------------------------------------
	<form action="<%=request.getContextPath() %>/loginservlet" name="name" method="POST">
		用户名: <input type="text" name="name" />
		<br />
		<input type="submit" value="登录" />
	</form>	
	<a href="<%=request.getContextPath() %>/jsp/check/loginCheck.jsp">验证码图片测试</a>
</body>
</html>