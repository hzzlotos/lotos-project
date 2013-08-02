<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#loginName").focus();
			$.validator.addMethod("checkAttahBranch", function(value, element) {
				if ($("#role").val()==3 && $("#attahBranch").val()=='' ) {
					return false;
				}
			    return true;
			}, "分公司管理员必须选择分公司！");
			<c:if test="${empty user.id}">
			$("#inputForm").validate({
				rules: {
					loginName: {
						remote: "${ctx}/manager/checkLoginName?oldName="+encodeURIComponent('${user.loginName}')
					},
					attahBranch: {
						checkAttahBranch: true
					}
				},
				messages: {
					loginName: {
						remote: "用户登录名已存在"
					}
				}
			});
			</c:if>
			<c:if test="${not empty user.id}">
			$("#inputForm").validate({
				rules: {
					attahBranch: {
						checkAttahBranch: true
					}
				}
			});
			</c:if>
			$('#role').change(function () {
				var id = $(this).val();
				if(id=='1'){
					$('#showOther').hide();
				}else{
					$('#showOther').show();
				}
			})
			$('#attahArea').change(function () {
				var id = $(this).val();
				if (id) {
					$.ajax({
						url: "${ctx}/manager/attahList?parentId=" + id,
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

			if('${user.role}'==1||'${user.role}'==0){
				$('#showOther').hide();
			}else{
				$('#showOther').show();
			}
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/manager/${action}" method="post" class="form-horizontal">
	<input type="hidden" name="id" value="${user.id}">
		<fieldset>
			<div class="control-group">
				<label for="loginName" class="control-label">登录名:</label>
				<div class="controls">
					<c:if test="${empty user.id}">
						<input type="text" id="loginName" name="loginName" class="input-large required" minlength="3"/>
					</c:if>
					<c:if test="${not empty user.id}">
						<input type="text" class="input-large required" value="${user.loginName}" readonly="readonly"/>
					</c:if>
				</div>
			</div>
			<c:if test="${empty user.id}">
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
			</c:if>
			<div class="control-group">
				<label for="plainPassword" class="control-label">角色:</label>
				<div class="controls">
					<select id="role" name="role">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.key}" <c:if test="${user.role==role.key}">selected="selected"</c:if>>${role.value}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div id="showOther">
				<div class="control-group">
					<label for="plainPassword" class="control-label">所属地区:</label>
					<div class="controls">
						<select id="attahArea" name="attahArea">
							<c:forEach items="${attahAreaList}" var="attahAreaVar">
								<option value="${attahAreaVar.id}" <c:if test="${attahArea==attahAreaVar.id}">selected="selected"</c:if>>${attahAreaVar.name}</option>
							</c:forEach>
						</select>
						<select id="attahBranch" name="attahBranch">
							<option value="">-请选择-</option>
							<c:forEach items="${attahBranchList}" var="attahBranchVar">
								<option value="${attahBranchVar.id}" <c:if test="${attahBranch==attahBranchVar.id}">selected="selected"</c:if>>${attahBranchVar.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>			
				<div class="control-group">
					<label for="plainPassword" class="control-label">权限:</label>
					<div class="controls">
						<select id="auth" name="auth">
							<c:forEach items="${authList}" var="auth">
								<option value="${auth.key}"<c:if test="${user.auth==auth.key}">selected="selected"</c:if>>${auth.value}</option>
							</c:forEach>
						</select>
					</div>
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
