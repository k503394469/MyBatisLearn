<%--
  Created by IntelliJ IDEA.
  User: Mr.k
  Date: 2020/1/2
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>
<form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
    用户名:<input type="text" name="username"><br>
    余额:<input type="text" name="balance"><br>
    <input type="submit" name="submit" value="提交">
</form>
</body>
</html>
