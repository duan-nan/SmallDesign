<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
<div class="loading">
        <h2>Welcome</h2>
        <form action="<%=request.getContextPath()%>/login.dio" method="get">
            <div class="input">
                <input type="text" id="username" name="username" required>
                <label for="username">Username</label>
            </div>
            <div class="input">
                <input type="password" id="Password" name="password" required>
                <label for="Password">Password</label>
            </div>
            <input type="submit" value="登陆" class="login">
        </form>
        <%
        String loginError = (String)request.getAttribute("loginError");
        if(loginError!=null){
        %>	
        	<script type="text/javascript" language="javascript">
			alert("<%=loginError%>");                                        
			</script>
        <%
        	}
        %>
    </div>
</body>
</html>