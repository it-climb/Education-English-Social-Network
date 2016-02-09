<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video</title>
</head>
<body>
    <h4 align="center">Film and serials in english!</h4>

    <nav >
        <p align="center">
            <a href="/video">Movies</a>
            <a href="/video">Serials</a>
            <a href="/video">TV-Shows</a>
        </p>
    </nav>

    <table>
        <tr>
            <td><b>Video name</b></td>
            <td><b>Type</b></td>
        </tr>
        <c:forEach var="content" items="${contents}">
            <tr>
                <td><a href="/video?id=${content.id}">${content.name}</a></td>
                <td>${content.type}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br><br>
    <a href="/video/admin">administrate video content (need a password)</a>
</body>
</html>
