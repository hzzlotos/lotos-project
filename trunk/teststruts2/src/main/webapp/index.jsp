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
��������
<a href="<%=context %>/tags/tags.action?username=u&password=p&age=9&abc=1">tags</a>
<br />
<br />
��������
<a href="<%=context %>/ognl/ognl.action?username=u&password=p">ognl</a>
<br />
<br />
����������
<ol>
	<li><a href="user/user?type=1">������</a></li>
</ol>
<br />
Result����
<ol>
	<li><a href="user/user!global?type=1">����success</a></li>
	<li><a href="user/user!global?type=2">����error</a></li>
	<li><a href="user/user!global?type=3">����global result</a></li>
	<li><a href="admin/admin">admin,�̳�user��</a></li>
</ol>
<br />
ʹ��action���Խ��ղ�����������������
<form action="user/user!add" method="post">
������<input type="text" name="name"></input>
<input type="submit" value="submit"/>
</form>
<br />
Actionִ�е�ʱ�򲢲�һ��Ҫִ��execute����<br />
�����������ļ�������Action��ʱ����method=��ָ��ִ���ĸ�����
Ҳ������url��ַ�ж�ָ̬������̬��������DMI�����Ƽ���<br />
	<a href="<%=context %>/user/useradd?userVO.name=hzz">����û�</a>
	<br />
	<a href="<%=context %>/user/user!add?userVO.name=a">����û�</a>
	<br />
ǰ�߻����̫���action�����Բ��Ƽ�ʹ��
<br />
<a href="path/path.action">·������˵��</a>

</body>
</html>