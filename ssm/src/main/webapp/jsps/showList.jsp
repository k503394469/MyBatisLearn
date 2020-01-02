<%--
  Created by IntelliJ IDEA.
  User: Mr.k
  Date: 2020/1/2
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<h1>账户</h1>
<table>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>余额</th>
    </tr>
    <c:forEach items="${accountList}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.username}</td>
            <td>${account.balance}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
