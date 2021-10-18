<%--
  Created by IntelliJ IDEA.
  User: 14757
  Date: 2021/7/17
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@include file="" %>会将两个页面合二为一--%>
<%@include file="common/header.jsp" %>
<h1>网站主题</h1>
<%@include file="common/footer.jsp" %>
<hr>
<%--JSP标签
<%--<jsp:include page=""/>拼接页面，本质还是两个--%>
--%>
<jsp:include page="common/header.jsp"/>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
