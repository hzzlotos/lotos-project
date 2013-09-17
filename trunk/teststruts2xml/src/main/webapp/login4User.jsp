<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page import="cn.newtouch.vo.UserBean"%>
<html>
<head>
<title>login page</title>
<SCRIPT type="text/javascript">
function test(){
	testForm = document.forms[0];
	testForm.action = "User!test.action";
	testForm.submit();
}
function test1(){
	testForm = document.forms[0];
	testForm.action = "user!test1.action";
	testForm.submit();
}
</SCRIPT>
</head>
<body>
	<s:form action="user" method="post" validate="true">
	<table align="center">
		<caption><h3><s:text name="login4User" /></h3></caption>	
		
		<s:textfield name="userName123" label="kasousou" value="%{#session.userName}" />
		<s:textfield name="userNameasd" label="asdzxc" value="%{#request.userName}" />
		<s:textfield name="bean.userName" label="UserName" value="%{#request.bean.userName}" />
		<s:password name="bean.passWord" label="passWord" />
		<s:textfield name="bean.age" label="age" value="%{#request.bean.age}" />
		<s:textfield name="bean.birth" label="birth" value="%{#request.bean.birth}" />
		<s:submit value="submit" />
		<s:reset value="reset" />
		<tr>
			<td>
				<input type="button" value="test" onclick="test();"/>
			</td>
			<td>
				<input type="button" value="test1" onclick="test1();"/>
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>