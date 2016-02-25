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
                <form action="/subject/delete" method="post">
                    <input type="hidden" name="id" value="${subject.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="/subject/update" method="post">
                    <input type="hidden" name="id" value="${subject.id}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/subject" >View mode</a>

</body>
</html>
