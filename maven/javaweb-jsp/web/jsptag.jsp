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
<%--<jsp:include page=""--%>
<%--localhost:8080/jsptag.jsp?name=name&age=12--%>
<jsp:forward page="jsptag2.jsp">
  <jsp:param name="name" value="name"/>
  <jsp:param name="age" value="11"/>
</jsp:forward>


</body>
</html>
