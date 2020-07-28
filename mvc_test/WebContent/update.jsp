<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.javaweb.domain.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
<link rel="stylesheet" href="./css/update.css">
</head>
<body>
<%
	User user = (User)request.getAttribute("user");

%>
<form action="<%=request.getContextPath()%>/updateDo.dio" >
		<input type="text" class="hidden" name="username" value="<%=user.getUsername() %>">
        <font>密 码 :  </font><input type="text" name="password" value="<%=user.getPassword() %>"><br><br><br>
        <font>姓 名 :   </font><input type="text" name="name" value="<%=user.getName() %>"><br><br><br>
        <font>电 话 :  </font><input type="text" name="phone" value="<%=user.getPhone() %>"><br><br><br>
        <font>地 址 :  </font><input type="text" name="address" value="<%=user.getAddress() %>"><br><br><br>
        <input type="submit" value="修改" class="submit">
     </form>
      <%
        String msg = (String)request.getAttribute("phone");
        if(msg!=null){
       %>	
        	<script type="text/javascript" language="javascript">
			alert("<%=msg%>");                                        
			</script>
        <%
        	}
        %>
</body>
</html>