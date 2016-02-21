<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List action</title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>ID</b></td>
        <td><b>E-mail</b></td>
    </tr>
    <c:forEach var="usersAct" items="${userActions}">
        <tr>
            <td>${usersAct.id}</td>
            <td><a href="" >${usersAct.userEmail}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
