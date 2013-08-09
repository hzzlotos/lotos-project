<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<% String context = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>Insert title here</title>
</head>
<body>
访问属性
<a href="<%=context %>/tags/tags.action?username=u&password=p&age=9&abc=1">tags</a>
<br />
<br />
访问属性
<a href="<%=context %>/ognl/ognl.action?username=u&password=p">ognl</a>
<br />
<br />
向结果传参数
<ol>
	<li><a href="user/user?type=1">传参数</a></li>
</ol>
<br />
Result类型
<ol>
	<li><a href="user/user!global?type=1">返回success</a></li>
	<li><a href="user/user!global?type=2">返回error</a></li>
	<li><a href="user/user!global?type=3">返回global result</a></li>
	<li><a href="admin/admin">admin,继承user包</a></li>
</ol>
<br />
使用action属性接收参数，测试中文问题
<form action="user/user!add" method="post">
姓名：<input type="text" name="name"></input>
<input type="submit" value="submit"/>
</form>
<br />
Action执行的时候并不一定要执行execute方法<br />
可以在配置文件中配置Action的时候用method=来指定执行哪个方法
也可以在url地址中动态指定（动态方法调用DMI）（推荐）<br />
	<a href="<%=context %>/user/useradd?userVO.name=hzz">添加用户</a>
	<br />
	<a href="<%=context %>/user/user!add?userVO.name=a">添加用户</a>
	<br />
前者会产生太多的action，所以不推荐使用
<br />
<a href="path/path.action">路径问题说明</a>

</body>
</html>