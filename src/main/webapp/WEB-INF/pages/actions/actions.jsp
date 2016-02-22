<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Action list</title>
</head>
<body>
<table width="600px">
    <tr>
        <td><b>Description</b></td>
        <td><b>Time</b></td>
    </tr>
    <c:forEach var="acctionsList" items="${listActions}">
        <tr>
            <td>${acctionsList.description}</td>
            <td>${acctionsList.time}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
