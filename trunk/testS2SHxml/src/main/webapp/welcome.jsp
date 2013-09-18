<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
	hello,<%=session.getAttribute("userName") %>,success!
	<a href="ka/getBooks.action"> here</a>
</body>
</html>