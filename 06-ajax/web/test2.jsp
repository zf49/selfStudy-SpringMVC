<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/8/28
  Time: 下午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<script src="${pageContext.request.contextPath}/static/jq.js"></script>

    <script>
                 $(function(){
                     $("#btn").click(function () {
                       //  $.post(url,param(可以省略)，success)
                       $.post("${pageContext.request.contextPath}/a2",function(data) {
                             var html= ""

                           for(let i = 0; i < data.length; i++){
                                 html += "<tr>"+

                                     "<td>"+data[i].name+"</td>"+
                                     "<td>"+data[i].age+"</td>"+                                                       "<td>"+data[i].sex+"</td>"+
                                     "</tr>"
                           }
                           
                           $("#content").html(html)


                       })


                     })
                 });



    </script>

</head>
<body>

<input type="button" value="加载数据" id="btn">



    <table>

        <tr>
            <td>name:</td>
            <td>age:</td>
            <td>sex:</td>
        </tr>
         <tbody id="content">

         </tbody>
        

    </table>




</body>
</html>
