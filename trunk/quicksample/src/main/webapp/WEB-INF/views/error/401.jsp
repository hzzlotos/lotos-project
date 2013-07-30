<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>401 - 无权访问</title>
</head>

<body>
	<h2>401 - 您没有权限访问该页面.</h2>
	<p><a href="${ctx}/logout">退出登录</a></p>
</body>
</html>