<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>books</title>
</head>
<body>
<h1>login-info</h1>


${size}//--//${session.trialid}
	<table border="1" width="360">
	<caption>users</caption>
	<s:textfield name="bean.userName" label="%{getText('userName')}" />
	<s:textfield name="userName" label="request.userName" value="%{#request.userName}" />
	<s:textfield name="userName" label="session.userName" value="%{#session.userName}" />
<s:iterator value="users" status="index">
	<s:if test="#index.odd == false">
		<tr style="background-color: green">
	</s:if>
	<s:else>
		<tr>
	</s:else>
			<td>${id}</td>
			<td>${name}</td>
</s:iterator>
		</tr>
	</table>
	<s:form action="getBooks" method="post" validate="true">
	<s:select list="books" name="aaa"  
                            listKey="value" value="%{#request.aaa}"  
                                listValue="label"></s:select>
    <s:submit value="submit" />
	</s:form>
</body>
</html>