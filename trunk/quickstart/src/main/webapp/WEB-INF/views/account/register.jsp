<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>添加用户</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#loginName").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					loginName: {
						remote: "${ctx}/register/checkLoginName"
					}
				},
				messages: {
					loginName: {
						remote: "用户登录名已存在"
					}
				}
			});
			$('#attahArea').change(function () {
				var id = $(this).val();
				if (id) {
					$.ajax({
						url: "${ctx}/register/attahList?parentId=" + id,
						success: function (response) {
							if (response) {
								$("#attahBranch option[value!='']").remove();
								if (null != response && response.length > 0) {
									for (var i = 0; i < response.length; i++) {
										if (null != response[i]) {
											$("#attahBranch").append("<option value='" + response[i].key + "'>" + response[i].value + "</option>");
										}
									}
								}
							}
						}
					});
				} else {
					$("#attahBranch option[value!='']").remove();
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/register" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>用户注册</small></legend>
			<div class="control-group">
				<label for="loginName" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="loginName" name="loginName" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="text" id="plainPassword" name="plainPassword" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">角色:</label>
				<div class="controls">
					<select id="role" name="role">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.key}">${role.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">所属地区:</label>
				<div class="controls">
					<select id="attahArea" name="attahArea">
						<c:forEach items="${attahAreaList}" var="attahArea">
							<option value="${attahArea.id}">${attahArea.name}</option>
						</c:forEach>
					</select>
					<select id="attahBranch" name="attahBranch">
						<c:forEach items="${attahBranchList}" var="attahBranch">
							<option value="${attahBranch.id}">${attahBranch.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>			
			<div class="control-group">
				<label for="plainPassword" class="control-label">权限:</label>
				<div class="controls">
					<select id="auth" name="auth">
						<c:forEach items="${authList}" var="auth">
							<option value="${auth.key}">${auth.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<!-- 
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large required" equalTo="#plainPassword"/>
				</div>
			</div>
			 -->
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
