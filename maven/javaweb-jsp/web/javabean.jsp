<%@ page import="com.flywinter.entity.People" %><%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/18
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//  People people = new People();
//  people.setId();
//  people.setName();
//  people.setAge();
//  people.setAddress();
%>
<jsp:useBean id="people" class="com.flywinter.entity.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="北京"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="李四"/>
<jsp:setProperty name="people" property="age" value="11"/>
<%--<%=people.getAddress()%>--%>
name:<jsp:getProperty name="people" property="name"/>
id:<jsp:getProperty name="people" property="id"/>
age:<jsp:getProperty name="people" property="age"/>
address:<jsp:getProperty name="people" property="address"/>

</body>
</html>
