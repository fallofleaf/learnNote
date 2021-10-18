<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/18
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  ArrayList<String> people = new ArrayList<>();
  people.add(0,"1");
  people.add(1,"2");
  people.add(2,"3");
  people.add(3,"4");
  request.setAttribute("list",people);
%>
<%--var 每一次遍历出来的遍历
items要遍历的对象
begin 开始
step 步长
end 结束
--%>
<c:forEach var="people" items="${list}">
  <c:out value="${people}"/>
</c:forEach>

<hr>
<c:forEach var="people" items="${list}" begin="1" end="3" step="2">
  <c:out value="${people}"/>
</c:forEach>
</body>
</html>
