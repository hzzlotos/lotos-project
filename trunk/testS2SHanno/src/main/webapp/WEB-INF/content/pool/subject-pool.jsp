<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/common/meta.jsp" %>
<title>user page</title>
<link href="${ctx}/css/share.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="${ctx}/js/util/jquery.js"></script>
</head>
<body>
	<h1 align="center">科目列表</h1>
	<s:form id="mainForm" name="mainForm" action="subject-pool.action" method="post" theme="simple" >
	<input type="hidden" name="page.pageNo" id="pageNo" value="${page.pageNo}"/>
	<input type="hidden" name="page.orderBy" id="orderBy" value="${page.orderBy}"/>
	<input type="hidden" name="page.order" id="order" value="${page.order}"/>
	<input type="hidden" id="totalCount" value="${page.totalCount}"/>
	<input type="hidden" id="pageSize" value="${page.pageSize}"/>
	<table class="tablebox collapse" align="center">
	<tr><td colspan="5">
		<input type="button" value="新增科目" onclick="editRecord('./subject-pool!input.action')"/>
		<input type="button" value="批量删除" onclick="batchdelete()"/>
	</td></tr>
		<tr>
			<td>no.</td>
			<td>科目编号</td>
			<td>科目名称</td>
			<td>操作</td>
		</tr>
		<s:iterator value="page.result" status="status">
		<tr>
			<td>${status.count}</td>
			<td>${serialNo}</td>
			<td>${name}</td>
			<td>
				<a onclick="editRecord('./subject-pool!input.action?id=${id}')">修改</a>
				<a onclick="delRecord('./subject-pool!delete.action?id=${id}')">删除</a>
				<a onclick="editRecord('../user/user.action?subId=${id}')">用户管理</a>
			</td>
		</tr>
		</s:iterator>
		<tr><td colspan="5"><%@ include file="/common/turnpage.jsp"%></td></tr>
	</table>
	
	</s:form>
</body>
</html>