<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>HelloWorld</title>
<script type="text/javascript" src="./js/jquery.1.9.1.js"></script>
</head>
<body>
	<a href="<%=request.getContextPath()%>/login/index">请登录</a>
	<a id="dosomethings">异步做些事情</a>
</body>
<script>
	$(document).ready(function() {
		$("#dosomethings").click(function() {
			$.post("./ajax/testAjax", function(data) {
				var threadId = data;
				alert(threadId)
				setTimeout(getprogress(threadId), 1000);
			});
		});
	});
	var flag = true;
	function getprogress(threadId) {
		$.post("./ajax/getprogress/" + threadId, function(data) {
			alert("当前进度===" + data);
			if (data == 100 || data == "null") {
				flag = false;
			}
			if (flag) {
				setTimeout(getprogress(threadId), 1000);
			}
		});
	}
</script>
</html>