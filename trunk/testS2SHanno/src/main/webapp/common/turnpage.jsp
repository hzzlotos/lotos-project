<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="./taglibs.jsp"%>
<link href="../css/share.css" rel="stylesheet" type="text/css" />
<script src="../js/util/table.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$("#"+$("#pageNo").val()).addClass("red");
	});
</script>
<span class="ll">共 <s:if test="page.totalCount>0">${page.totalCount}</s:if><s:else>0</s:else>&nbsp;条记录 | 共 <s:if test="page.totalPages>0">${page.totalPages}</s:if><s:else>0</s:else>&nbsp;页 | &nbsp;</span> 
	<s:if test="page.pageNo>3">
	<a onclick="jumpPage(1);" title="最前页"><<</a>
	</s:if>
	<s:if test="page.pageNo>1">
	<a onclick="jumpPage(${page.pageNo-1});" title="前一页"><</a>
	</s:if>
	<s:if test="page.pageNo>3">
		<s:if test="page.totalPages>=(page.pageNo+2)">
			<c:forEach var="i" begin="${page.pageNo-2}" end="${page.pageNo+2}" step="1">
		<a onclick="jumpPage(${i});" id="${i}">${i}</a>
		</c:forEach>
		</s:if>
		<s:else>
			<s:if test="page.totalPages==4">
			<c:forEach var="i" begin="1" end="4" step="1">
			<a onclick="jumpPage(${i});" id="${i}">${i}</a>
			</c:forEach>
			</s:if>
			<s:else>
			<c:forEach var="i" begin="${page.totalPages-4}" end="${page.totalPages}" step="1">
			<a onclick="jumpPage(${i});" id="${i}">${i}</a>
			</c:forEach>
			</s:else>
		</s:else>
	</s:if>
	<s:else>
		<s:if test="page.totalPages>=5">
			<c:forEach var="i" begin="1" end="5" step="1">
			<a onclick="jumpPage(${i});" id="${i}">${i}</a>
			</c:forEach>
		</s:if>
		<s:else>
			<s:if test="page.totalPages>0">
			<c:forEach var="i" begin="1" end="${page.totalPages}" step="1">
			<a onclick="jumpPage(${i});" id="${i}">${i}</a>
			</c:forEach>
			</s:if>
		</s:else>
	</s:else>
	<s:if test="page.totalPages>page.pageNo">
	<a onclick="jumpPage(${page.pageNo+1});" title="下一页">></a>
	</s:if>
	<s:if test="page.totalPages>(page.pageNo+2)">
	<a onclick="jumpPage(${page.totalPages});" title="最后页">>></a>
	</s:if>
    <span class="ll">&nbsp; |&nbsp; 第 <input type="text" size="2" id="num" onkeypress="if(event.keyCode==13) {skipsubmit();}"/> 页   <input type="button" value="go" onclick="skipsubmit();" /></span> 