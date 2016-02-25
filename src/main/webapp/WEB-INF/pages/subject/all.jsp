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
                <td>${subject.name}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="/subject/edit" >Edit mode</a>

</body>
</html>
