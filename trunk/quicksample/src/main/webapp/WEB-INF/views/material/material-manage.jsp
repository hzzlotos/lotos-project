<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.2.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>

<link href="${ctx}/static/jquery-ui/1.10.3/jquery-ui-1.10.3.custom.css" type="text/css" rel="stylesheet">
<script src="${ctx}/static/jquery-ui/1.10.3/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>

<link href="${ctx}/static/jquery-ajaxfileupload/2.1/ajaxfileupload.css" type="text/css" rel="stylesheet">
<script src="${ctx}/static/jquery-ajaxfileupload/2.1/ajaxfileupload.js" type="text/javascript"></script>

	<script>
	var fileName,filePath;
	$(document).ready(function(){
		$( "#dialog_add" ).click(function( event ) {
			$("#fileToUpload").val("");
			$( "#dialog" ).dialog({
				autoOpen: true,
				width: 400,
				buttons: [
					{
						text: "确认",
						click: function() {
							$.ajax({
								url: '${ctx}/material/save',
								method: 'POST',
								//async:false,
								data: {name:name, filePath:filePath,attachId:$("#attachId").val()} ,
								dataType: 'json',
								success: function (response) {
									alert(123)
									//$("#mainField").append(
									//'<div class="control-group"><label for="task_title" class="control-label">'
									//+ name
									//+'<a onclick="">删除</a></label><div class="controls"><img width="100px" height="60px"'
									//+'alt="'+name+'" src="${ctx}/image/material/'+response+'" ></div></div>')
									$("#dialog").dialog( "close" );
								}
							});
							
						}
					},
					{
						text: "取消",
						click: function() {
							$( this ).dialog( "close" );
						}
					}
				]
			});
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
					fileName = data['fileName'];
					filePath = data['filePath'];
					$("#message").html("上传成功！");
					$("#showMessage").show();
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
	}
	</script>
</head>

<body>
	<a class="btn" id="dialog_add">添加资源</a>
	<input type="hidden" id="attachId" value="${attachId}"/>
	<fieldset id="mainField">
		<c:forEach items="${materials}" var="material">
		<div class="control-group">
			<label for="task_title" class="control-label">${material.name}<a onclick="">删除</a></label>
			<div class="controls">
				<img width="100px" height="60px" alt="${material.name}" src="${ctx}/image/material/${material.fileName}" >
			</div>
		</div>
		</c:forEach>
	</fieldset>
	<div id="dialog" title="上传资源" style="display:none;">
		<input id="fileToUpload"  class="btn" type="file" name="fileToUpload">
		<input id="submit_file" class="btn" type="button" value="上传"/>
		<div id="showMessage" class="alert alert-success" style="display:none;"><button data-dismiss="alert" class="close" onclick="doClose()">×</button><span id="message"></span></div>
	</div>
</body>
</html>
