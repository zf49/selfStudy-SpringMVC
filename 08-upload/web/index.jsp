<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2021/9/1
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

     <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">

       <input type="file" name="file">
       <input type="submit" value="upload">

     </form>


      <a href="${pageContext.request.contextPath}/statics/A2-report-ZhifangWang.docx">下载文件</a>
  </body>
</html>
