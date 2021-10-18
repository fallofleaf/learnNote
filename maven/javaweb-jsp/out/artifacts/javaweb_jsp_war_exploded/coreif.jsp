<%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/18
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL标签库，才能使用JSTL核心库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>测试if</h1>

<hr>

<form action="coreif.jsp" method="get">
<%--  EL表达式获取表单中的数据
${param.参数名}
--%>
  <input type="text" name="username" value="${param.username}">
</form>

</body>
</html>
