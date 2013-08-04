<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/2.2.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/styles/default.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/static/jquery/jquery-1.8.3.js" type="text/javascript"></script>

<link href="${ctx}/static/jquery-ui/1.10.3/jquery-ui-1.10.3.custom.css" type="text/css" rel="stylesheet">
<script src="${ctx}/static/jquery-ui/1.10.3/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script>
	function showImg(url){
		$("#imgShow").attr("src",url);
		$( "#imgDialog" ).dialog({
			autoOpen: true,
			modal: true,
			width: 500,
		});
	}
</script>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div >
	<a class="btn" href="${ctx}/project/${attachId}">返回</a>
		<div class="span4 offset4">
			<form class="form-search" action="${ctx}/material/show/${projectId}" method="post">
				<label>名称：</label> <input type="text" style="height: 30px" name="search_LIKES_name" class="input-medium" value="${param.search_LIKES_name}">
				<button type="submit" class="btn" id="search_btn">查找</button>
		    </form>
	    </div>
	    <!--<tags:sort/>-->
	</div>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>资料</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${materials.content}" var="material">
			<tr>
				<td><a href="${ctx}/material/update/${material.id}">${material.name}</a></td>
				<td><a href="${ctx}/material/delete/${material.id}">删除</a>
				&nbsp;&nbsp;&nbsp;<a style="cursor: pointer;" onclick="showImg('${ctx}/image/material/${material.filePath}')">查看资料</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div id="imgDialog" title="查看资源" style="display:none;">
		<img width="480px" id="imgShow" src="">
	</div>
	<tags:pagination page="${materials}" paginationSize="5"/>
	<div>
	<a class="btn" href="${ctx}/material/create/${projectId}">创建资料</a>
	</div>
</body>
</html>
