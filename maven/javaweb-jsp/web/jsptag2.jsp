<%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/18
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Page2</h2>
<%--取出参数--%>
name:<%=request.getParameter("name")%>
age:<%=request.getParameter("age")%>
</body>
</html>
