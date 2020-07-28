<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="./css/regist.css">
</head>
<body>
 	<form action="<%=request.getContextPath()%>/add.dio" >
        <font>用户名: </font><input type="text" name="username"><br><br><br>
        <font>密 码 :  </font><input type="text" name="password"><br><br><br>
        <font>姓 名 :   </font><input type="text" name="name"><br><br><br>
        <font>电 话 :  </font><input type="text" name="phone"><br><br><br>
        <font>地 址 :  </font><input type="text" name="address"><br><br><br>
        <input type="submit" value="添加" class="submit">
     </form>
      <%
        String msg = (String)request.getAttribute("msg");
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