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
	$(document).ready(function(){
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).dialog({
				autoOpen: true,
				width: 400,
				buttons: [
					{
						text: "Ok",
						click: function() {
							$( this ).dialog( "close" );
						}
					},
					{
						text: "Cancel",
						click: function() {
							$( this ).dialog( "close" );
						}
					}
				]
			});
			event.preventDefault();
		});
		
	});
	</script>

</head>

<body>
	<a class="btn" href="${ctx}/material/show/">添加资源</a>
	<a href="#" id="dialog-link" class="ui-state-default ui-corner-all"><span class="ui-icon ui-icon-newwin"></span>Open Dialog</a>
	<fieldset>
	</fieldset>
	<div id="dialog" title="Dialog Title" style="display:none;">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
	</div>
</body>
</html>
