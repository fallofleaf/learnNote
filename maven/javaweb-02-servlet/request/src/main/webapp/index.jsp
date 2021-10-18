<%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="text-align: center">
<%--    这里表单表示的意思是以post方式提交到Login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:<input type="text" name="username"><br>
        密码:<input type="text" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbies" value="女孩"> 女孩
        <input type="checkbox" name="hobbies" value="代码"> 代码
        <input type="checkbox" name="hobbies" value="看书"> 看书
        <input type="checkbox" name="hobbies" value="追剧"> 追剧
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
