<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/8/29
  Time: 下午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/jq.js"></script>



    <script>
        function a1() {
          $.post({
              url: "${pageContext.request.contextPath}/a3",
              data: {"name":$("#name").val()},
            success: function(data){
                $("#userInfo").html(data)
            }
          })

        }

        function a2() {
            $.post({
                url: "${pageContext.request.contextPath}/a3",
                data: {"pwd":$("#pwd").val()},
                success: function(data){
                    $("#pwdInfo").html(data)
                }
            })

        }



    </script>
</head>
<body>


<p>
    username：<input type="text" id="name" onblur="a1()">
    <sapn id = "userInfo"></sapn>
</p>
<p>
    password：<input type="text" id="pwd" onblur="a2()">
    <sapn id = "pwdInfo"></sapn>

</p>



</body>
</html>
