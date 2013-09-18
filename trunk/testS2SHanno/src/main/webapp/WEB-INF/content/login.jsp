<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html>
<head>
<%@ include file="/common/meta.jsp" %>
<title>login page</title>
<!-- 自动跳转
<meta http-equiv="refresh" content="10;url=http://www.baidu.com/">
-->
<link href="${ctx}/css/share.css" rel="stylesheet" type="text/css" />
<SCRIPT type="text/javascript" src="${ctx}/js/util/jquery.js"></SCRIPT>
</head>
<body>
	<form method="post" id="loginForm" name="loginForm" action="${ctx}/login!enter.action">
	<h1 align="center">欢迎！</h1>
	<table class="tablebox collapse" align="center">
		<tr>
			<td><label>用户名：</label></td>
			<td><input  type="text" id="username" name="username" value="${username}" style="width:150px"/></td>
		</tr>
  		<tr>
  			<td>密  码：</td>
  			<td><input type="password" id="password" name="password" style="width:150px"/></td>
		</tr>
		<s:select list="subjectPools" listKey="id" listValue="name" id="subjectPoolId" name="subjectPoolId" value="subjectPoolId" label="科目库" headerKey="0" headerValue="系统管理员登录" cssStyle="width:150px"/>
		<tr><td colspan="2"><s:submit value="登录" theme="simple"/><s:reset value="重置" theme="simple"/></td></tr>
	</table>
	</form>
	<div id="message" style="line-height: 35px;margin-left:45%;">
		<s:actionmessage theme="custom" cssClass="tipbox"/>
</div>
</body>
</html>