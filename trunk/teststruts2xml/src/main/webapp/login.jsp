<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>login page</title>
<SCRIPT type="text/javascript" 
           src="${pageContext.request.contextPath}/js/jquery.js"></SCRIPT> 
<SCRIPT type="text/javascript">
function test(){
	testForm = document.forms[0];
	testForm.action = "login!test.action";
	testForm.submit();
}
function testJosn() 
{ 
   $.post( 
   "${pageContext.request.contextPath}/json/jsontest.action",{username:"wangsh"},function (data) 
	   { 
	       var json = eval(data); 
	       window.alert("----------"+json.username); 
	   } 
   ); 
} 
</SCRIPT>
</head>
<body>
	111<s:property value="%{getText('welcome')}" />222

	<s:form action="login" method="post" validate="true">
	<table align="center">
		<caption><h3><s:text name="login" /></h3></caption>	
		<s:textfield name="userName2" key="UserName" value="%{#session.userName}" />
		<s:textfield name="bean.userName" label="userName" value="%{#request.userName}" />
		<s:password name="bean.passWord" label="passWord" />
		<s:submit value="submit" />
		<s:reset value="reset" />
		<tr>
			<td>
				<input type="button" value="test" onclick="test();"/>
			</td>
		</tr>
		<!--  
		<tr>
			<td>
				<s:property value="exception.message"/>
			</td>
		</tr>
		
		<tr>
			<td>
				<s:property value="exceptionStack"/>
			</td>
		</tr>
		-->
	</table>
	</s:form>
	
	
	<div>
       <a 
           href="${pageContext.request.contextPath}/json/jsontest.action">测试Json</a> 
       <button name="测试JSON" id="testbut" onclick="testJosn();"> 
           测试JSON 
       </button>
	
	
	</div>
</body>
</html>