<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>资源管理</title>
  <style>
	body {
	background-color: white;
	margin:0; padding:0;
	text-align: center;
	}
	div, p, table, th, td {
		list-style:none;
		margin:0; padding:0;
		color:#333; font-size:12px;
		font-family:dotum, Verdana, Arial, Helvetica, AppleGothic, sans-serif;
	}
	#testIframe {margin-left: 10px;}
  </style>
  <SCRIPT type="text/javascript" >
  <!--
	var zTree;
	var demoIframe;
	var zNodes;
	var setting = {
			view: {
				dblClickExpand: false,
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable:true,
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj("tree");
					if (treeNode.isParent) {
						zTree.expandNode(treeNode);
						return false;
					} else {
						demoIframe.attr("src","${ctx}/material/show/"+treeNode.id);
						return true;
					}
				}
			}
		};


	$(document).ready(function(){
		$.ajax({
			url: '${ctx}/material/attahTree',
			method: 'POST',
			success: function (response) {
				if (response) {
					var zNodes = response;
					var t = $("#tree");
					t = $.fn.zTree.init(t, setting, zNodes);
					zTree = $.fn.zTree.getZTreeObj("tree");
					demoIframe = $("#testIframe");
					demoIframe.bind("load", loadReady);
				} else {
					MSG.error(response.message, true);
				}
			}
		});
	});

	function loadReady() {
		var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
		htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
		maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
		h = demoIframe.height() >= maxH ? minH:maxH ;
		if (h < 530) h = 530;
		demoIframe.height(h);
	}

  //-->
  </SCRIPT>
</head>

<body>
<div style="height:610px">
	<TABLE border=0 height=600px align=left>
	<TR>
		<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
			<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
		</TD>
		<TD width=770px align=left valign=top><IFRAME style="margin-top: 5px" ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC=""></IFRAME></TD>
	</TR>
	</TABLE>
</div>
</body>
</html>
