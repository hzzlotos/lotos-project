<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/common/meta.jsp" %>
	<title>user page</title>
	<link href="${ctx}/css/share.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/util/jquery.js" type="text/javascript"></script>
	<link href="${ctx}/js/validate/jquery.validate.css" type="text/css" rel="stylesheet"/>
	<script src="${ctx}/js/validate/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/js/validate/messages_cn.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
 		//聚焦第一个输入框
 		$("#username").focus();
 		//为registerForm注册validate函数
 		$("#inputForm").validate({
			rules: {
 				'user.username': {
					required: true,
					minlength:6,
					maxlength:20,
					remote: "./user!checkLoginName.action?oldUsername=" + encodeURIComponent('${user.username}')
				},
				'user.email':{
					required: true,
					maxlength:30,
					email:true
				},
				'user.password': {
					required: true,
					minlength:6,
					maxlength:18
				},
				passwordConfirm: {
					required: true,
					equalTo: "#password"
				},
				roleId: {
					required: true
				}
			},
			messages: {
				'user.username': {
					remote: "用户名已存在，请更换！"
				}
 			}
		});
 	});
	</script>
</head>
<body>
	<h1 align="center">用户<s:if test="id==0||id==null">添加</s:if><s:else>修改</s:else></h1>
	<s:form id="inputForm" name="inputForm" action="./user!save.action" method="post" theme="simple">  
	<input type="hidden" id="id" name="user.id" value="${user.id}"/>
	<input type="hidden" id="id" name="subId" value="${subId}"/>
	<table class="tablebox collapse" align="center">
		<tr>
			<td>用户名</td>
			<td>
			<input type="text" id="username" name="user.username" value="${user.username}"/>
			</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td>
			<input type="text" id="email" name="user.email" value="${user.email}"/>
		</td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" id="password" name="user.password" value="${user.password}"/>
			</td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td>
			<input type="text" id="passwordConfirm" name="passwordConfirm" value="${user.password}"/>
			</td>
		</tr>
		<tr>
			<td>请选择科目库</td>
			<td><s:select list="subjectPools" listKey="id" listValue="name" id="subjectPoolid" name="subjectPoolid" value="subjectPoolid"/></td>
		</tr>
		<tr>
			<td>请选择权限</td>
			<td><s:select list="roles" listKey="id" listValue="name" id="roleId" name="roleId" value="roleId"/></td>
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit" value="保存" />
			<input type="reset" value="重置" />
			<input type="button" value="返回" onclick="javascript:history.back();"/>
		</td>
		</tr>
		</table>
	</s:form>
</body>
</html>