<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>资源管理</title>
</head>

<body>
	<TABLE border=0 height=600px align=left>
	<TR>
		<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
			<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
		</TD>
		<TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="core/standardData.html"></IFRAME></TD>
	</TR>
	</TABLE>
</body>
</html>
