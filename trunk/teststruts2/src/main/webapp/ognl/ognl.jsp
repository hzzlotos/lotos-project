<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>OGNL表达式语言学习</title>
</head>
<body>
	<ol>
		<li>访问值栈中的action的普通属性: username = <s:property value="username"/>/${username}| password = <s:property value="password"/>/${password}</li>
		<li>访问值栈中对象的普通属性(get set方法)：user.age:<s:property value="user.age"/>/${user.age}| <s:property value="user['age']"/> | <s:property value="user[\"age\"]"/> | wrong: <%--<s:property value="user[age]"/>--%></li>
		<li>访问值栈中对象的普通属性(get set方法): cat.friend.name:<s:property value="cat.friend.name"/>/${cat.friend.name}</li>
		<li>访问值栈中对象的普通方法：password.length():<s:property value="password.length()"/></li>
		<li>访问值栈中对象的普通方法：cat.miaomiao():<s:property value="cat.miaomiao()" /></li>
		<li>访问值栈中action的普通方法：m():<s:property value="m()" /></li>
		<hr />
		<li>访问静态方法：<s:property value="@cn.newtouch.struts2.ognl.S@s()"/></li>
		<li>访问静态属性：<s:property value="@cn.newtouch.struts2.ognl.S@STR"/></li>
		<li>访问Math类的静态方法：<s:property value="@@max(2,3)" /></li>
		<hr />
		<!-- 
		<li>访问普通类的构造方法：<s:property value="new com.bjsxt.struts2.ognl.User(8)"/></li>
		 -->
		<hr />
		<li>访问List:<s:property value="users"/></li>
		<li>访问List中某个元素:<s:property value="users[1]"/></li>
		<li>访问List中元素某个属性的集合:<s:property value="users.{age}"/></li>
		<li>访问List中元素某个属性的集合中的特定值:<s:property value="users.{age}[0]"/> | <s:property value="users[0].age"/></li>
		<li>访问Set:<s:property value="dogs"/></li>
		<!-- set不能去下标值 
		<li>访问Set中某个元素:<s:property value="dogs[1]"/></li>
		-->
		<li>访问Map:<s:property value="dogMap"/></li>
		<li>访问Map中某个元素:<s:property value="dogMap.dog101"/> | <s:property value="dogMap['dog101']"/> | <s:property value="dogMap[\"dog101\"]"/></li>
		<li>访问Map中所有的key:<s:property value="dogMap.keys"/></li>
		<li>访问Map中所有的value:<s:property value="dogMap.values"/></li>
		<li>访问容器的大小：<s:property value="dogMap.size()"/> | <s:property value="users.size"/> </li>
		<hr />
		
		<li>投影(过滤)：<s:property value="users.{?#this.age==1}[0]"/></li><!-- 取出的是集合 -->
		<li>投影：<s:property value="users.{^#this.age>1}.{age}"/></li><!-- ^表示开头的第一个first -->
		<li>投影：<s:property value="users.{$#this.age>1}.{age}"/></li><!-- $表示结尾的最后一个end -->
		<li>投影：<s:property value="users.{$#this.age>1}.{age} == null"/></li>
		<hr />
		<!-- 不用的
		<li>[]:<s:property value="[0].username"/></li>
		-->
	</ol>
	
	<s:debug></s:debug>
</body>
</html> 