<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 06.03.16
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Units</title>
</head>
<body>
E-mail = ${email} <br>

    <table border="1">
        <tr>
            <td>Subject</td>
            <td>Level Units</td>
        </tr>
        <c:forEach var="subjectUnit" items="${unitsList}">
            <tr>
                <td>${subjectUnit.subject.name}</td>
                <td>${subjectUnit.levelUnits}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
