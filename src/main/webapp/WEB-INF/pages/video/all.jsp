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
            <a href="/video/movie">Movies</a>
            <a href="/video/serial">Serials</a>
            <a href="/video/tvshow">TV-Shows</a>
        </p>
    </nav>

    <h2>List of ${typeName}s:</h2><br>
    ${fff}
    <table>
        <tr>
            <td><b>Name of ${typeName}</b></td>
            <td><b>Describe</b></td>
        </tr>
        <c:forEach var="content" items="${contents}">
            <tr>
                <c:choose>
                    <c:when test="${type == 'movie'}">
                        <td><a href="/video/${type}?id=${content.id}">${content.name}</a></td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${id == '0'}">
                                <td><a href="/video/${type}?id=${content.id}">${content.name}</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="/video/${type}?id=${id}&season=${content.name}">${content.name}</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <td>${content.describe}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br><br>
    <a href="/video/admin">administrate video content (need a password)</a>
</body>
</html>
