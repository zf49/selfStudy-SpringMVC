<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/8/31
  Time: 下午2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登陆</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">

    username: <input type="text" name="username"/>
    password: <input type="text" name="pwd"/>
    <input type="submit" value="submit">
    
</form>


</body>
</html>
