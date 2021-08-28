<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/8/28
  Time: 下午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script src="${pageContext.request.contextPath}/static/jq.js"></script>


  <script>
    function a() {
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{"name":$("username").val()},
      success:function (data) {
         alert(data)

      }
      })
    }
    </script>
  <body>
    
  用户名：<input type="text" id="username" onblur="a()"/>


  </body>
</html>
