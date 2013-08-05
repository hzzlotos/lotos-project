<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.2.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>

<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>

<link href="${ctx}/static/jquery-ajaxfileupload/2.1/ajaxfileupload.css" type="text/css" rel="stylesheet">
<script src="${ctx}/static/jquery-ajaxfileupload/2.1/ajaxfileupload.js" type="text/javascript"></script>

	<title>资料管理</title>
	
	<script>
		$(document).ready(function() {
			$("#name").focus();
			$.validator.addMethod("checkfileName", function(value, element) {
				if ($("#fileName").val()=='') {
					return false;
				}
			    return true;
			}, "请上传资源！");
			$("#inputForm").validate({
				rules: {
					name: {
						remote: "${ctx}/material/checkName?oldName="+encodeURIComponent('${material.name}')
					},
					theFileName:{
						checkfileName : true
					}
				},
				messages: {
					name: {
						remote: "该资料名称已存在"
					}
				}
			});
			$( "#submit_file" ).click(function( event ) {
				if($("#fileToUpload").val()==''){
					$("#message").html("请选择文件！");
					$("#showMessage").show();
					return;
				}
				$.ajaxFileUpload({
					url:'${ctx}/fileupload',
					secureuri:false,
					fileElementId:'fileToUpload',
					dataType: 'json',
					success: function (data, status)
					{
						$("#fileName").val(data['fileName']);
						$("#filePath").val(data['filePath']);
						$("#message").html("上传成功！");
						$("#showMessage").show();
						$("#image").hide();
					},
					error: function (data, status, e)
					{
						alert(e);
					}
				})
			});	
		});
		function doClose(){
			$("#showMessage").hide();
			return false;
		}
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/material/${action}/${projectId}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${material.id}"/>		
		<input type="hidden" id="filePath" name="theFilePath" value=""/>
		<fieldset>
			<legend><small>资料</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">资料名称:</label>
				<div class="controls">
					<input type="text" id="name" name="name" value="${material.name}" style="height: 30px" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="task_title" class="control-label">上传资料:</label>
				<div class="controls">
					<input type="text" style="height: 30px" class="input-large required" id="fileName" name="theFileName" value="${material.fileName}" readonly="readonly"/>
				</div>
				<div class="controls">
					<input id="fileToUpload"  class="btn" type="file" name="fileToUpload">
					<input id="submit_file" class="btn" type="button" value="上传"/>
					<div id="showMessage" class="alert alert-success" style="display:none;"><a class="close" onclick="doClose()">×</a><span id="message"></span></div>
					<c:if test="${not empty material.fileName}">
					<img width="100px" height="60px" id="image" src="${ctx}/image/material/${material.filePath}">
					</c:if>
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
