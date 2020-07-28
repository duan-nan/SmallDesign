<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.javaweb.domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理界面</title>
<link rel="stylesheet" href="./css/table.css">
</head>
<body>
	<form action="<%=request.getContextPath()%>/query.dio">
		<font>姓名: </font><input type="text" name="name"><br> <br>
		<font>电话: </font><input type="text" name="phone"><br> <br>
		<font>地址: </font><input type="text" name="address"><br> <br>
		<input type="submit" value="查询用户" class="submit">
		<br>
		<a href="/mvc_test/regist.jsp">添 加 新 用 户</a>
	</form>

	<hr>

	<p>用户信息</p>
	<table>
		<tr class="first">
			<td>id</td>
			<td>用户名</td>
			<td>姓名</td>
			<td>电话</td>
			<td>地址</td>
			<td>注册时间</td>
			<td>操作方式</td>
		</tr>
		<%
			List<User> list = (List<User>) request.getAttribute("list");
		if (list != null && list.size() > 0) {
			for (User user : list) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getPhone()%></td>
			<td><%=user.getAddress()%></td>
			<td><%=user.getReg_date()%></td>
			<td><a href="<%=request.getContextPath()%>/update.dio?username=<%=user.getUsername()%>">编辑</a>|
			<a href="<%=request.getContextPath()%>/delete.dio?username=<%=user.getUsername()%>">删除</a></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>