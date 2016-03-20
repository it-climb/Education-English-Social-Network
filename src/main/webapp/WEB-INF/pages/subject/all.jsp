<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subjects</title>
</head>
<body>

    <table>
        <tr>
            <td><b>Available Subjects:</b></td>
        </tr>
        <c:forEach var="subject" items="${subjects}" >
            <tr>
                <td>${subject.id}</td>
                <td>${subject.name}</td>
                <td>${subject.activity.id}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="/subjectEdit" >Edit mode</a>

</body>
</html>
