<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subjects edit</title>
</head>
<body>
<table>
    <tr>
        <td><b>Available Subjects:</b></td>
    </tr>
    <c:forEach var="subject" items="${subjects}" >
        <tr>
            <td>${subject.name}</td>
            <td>
                <form action="/subjectDelete" method="post">
                    <input type="hidden" name="id" value="${subject.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="/subjectUpdate" method="post">
                    <input type="hidden" name="id" value="${subject.id}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <form action="/subjectAdd" method="post">
                <input type="submit" value="Add new Subject">
            </form>
        </td>
    </tr>
</table>
<br><br>
<a href="/subject" >View mode</a>

</body>
</html>
