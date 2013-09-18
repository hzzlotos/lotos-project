<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>books</title>
</head>
<body>
	<table border="1" width="360">
	<caption>books</caption>
	<%
		ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack");
	
		String[] books = (String[])vs.findValue("books");
		
		for (String book : books) {
	%>
		<tr>
			<td>book name:</td>
			<td><%=book%></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>