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
							$( this ).dialog( "close" );
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
			$.ajaxFileUpload({
				url:'${ctx}/fileupload',
				secureuri:false,
				fileElementId:'fileToUpload',
				dataType: 'json',
				success: function (data, status)
				{
					alert("上传成功");
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			})
		});		
	});
	</script>
</head>

<body>
	<a class="btn" id="dialog_add">添加资源</a>
	<fieldset>
	</fieldset>
	<div id="dialog" title="上传资源" style="display:none;">
		<input id="fileToUpload"  class="btn" type="file" name="fileToUpload">
		<input id="submit_file" class="btn" type="button" value="上传"/>
	</div>
</body>
</html>
