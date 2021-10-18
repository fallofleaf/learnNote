<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径需要寻找到项目的类路径--%>
<%--${pageContext.request.contextPath}代表当前的项目--%>
<%@page pageEncoding="UTF-8" %>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名:<input type="text" name="username"><br>
    密码:<input type="text" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
