<%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/21
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--通过表单上传文件，
get上传文件大小有限制
post上传文件大小无限制--%>
<%--获取服务器路径--%>
<form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"></p>
    <p><input type="submit"> | <input type="reset"></p>
</form>
</body>
</html>
