<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>地区管理</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#task_title").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/attach/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${attach.id}"/>
		<input type="hidden" name="parentId" value="${parentId}"/>
		<fieldset>
			<legend><small>地区</small></legend>
			<c:if test="${not empty parentId}">
			<div class="control-group">
				<label for="task_title" class="control-label">上级:</label>
				<div class="controls">
					<input type="text" value="${parentName}" class="input-large required" readonly="readonly"/>
				</div>
			</div>
			</c:if>
			<div class="control-group">
				<label for="task_title" class="control-label">地区名称:</label>
				<div class="controls">
					<input type="text" id="attach" name="name" value="${attach.name}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
