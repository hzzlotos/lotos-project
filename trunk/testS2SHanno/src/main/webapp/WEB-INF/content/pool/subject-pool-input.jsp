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
 				'subjectPool.name': {
					required: true,
					minlength:3,
					maxlength:20,
					remote: "./subject-pool!checkName.action?oldname=" + encodeURIComponent('${subjectPool.name}')
				}
			},
			messages: {
				'subjectPool.name': {
					remote: "科目名称已存在，请更换！"
				}
 			}
		});
 	});
	</script>
</head>
<body>
	<h1 align="center">科目<s:if test="id==0||id==null">添加</s:if><s:else>修改</s:else></h1>
	<s:form id="inputForm" name="inputForm" action="./subject-pool!save.action" method="post" theme="simple"> 
	<input type="hidden" id="id" name="subjectPool.id" value="${subjectPool.id}"/> 
	<table class="tablebox collapse" align="center">
		<tr>
			<td>科目名</td>
			<td>
			<input type="text" id="name" name="subjectPool.name" value="${subjectPool.name}"/>
			</td>
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit" value="保存" />
			<input type="button" value="返回" onclick="javascript:history.back();"/>
		</td>
		</tr>
		</table>
	</s:form>
</body>
</html>