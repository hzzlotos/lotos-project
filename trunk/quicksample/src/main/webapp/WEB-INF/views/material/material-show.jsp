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
	<script>
	function showImg(e){
		$("#imgShow").attr("src",$(e).attr("src"));
		$( "#imgDialog" ).dialog({
			autoOpen: true,
			modal: true,
			width: 500,
		});
	}
	</script>
</head>

<body>
	<fieldset id="mainField">
		<c:forEach items="${materials}" var="material">
			<div id="${material.id}">
				<img width="100px" height="60px" src="${ctx}/image/material/${material.fileName}" style="cursor: pointer;" onclick="showImg(this)" >
				<label for="task_title" class="control-label">${material.name}</label>
			</div>
		</c:forEach>
	</fieldset>
	<div id="imgDialog" title="查看资源" style="display:none;">
		<img width="500px" id="imgShow" src="">
	</div>
</body>
</html>
