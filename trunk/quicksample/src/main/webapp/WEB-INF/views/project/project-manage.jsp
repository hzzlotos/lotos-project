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
<head>
	<title>项目管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div >
		<div class="span4 offset4">
			<form class="form-search" action="${ctx}/project/${attachId}" method="post">
				<label>名称：</label> <input type="text" style="height: 30px" name="search_LIKES_name" class="input-medium" value="${param.search_LIKES_name}">
				<button type="submit" class="btn" id="search_btn">查找</button>
		    </form>
	    </div>
	    <!--<tags:sort/>-->
	</div>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>项目</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${projects.content}" var="project">
			<tr>
				<td><a href="${ctx}/project/update/${project.id}">${project.name}</a></td>
				<td><a href="${ctx}/material/show/${project.id}">管理资料</a>
				&nbsp;&nbsp;&nbsp;<a href="${ctx}/project/delete/${project.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${projects}" paginationSize="5"/>
	<div>
	<a class="btn" href="${ctx}/project/create/${attachId}">创建项目</a>
	</div>
</body>
</html>
