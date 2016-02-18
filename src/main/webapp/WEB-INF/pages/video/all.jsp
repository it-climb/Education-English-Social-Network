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
            <a href="/video/tvshow">TV-Shows</a>
            <a href="/video/video">Videos</a>
        </p>
    </nav>

    <h2>List of ${typeName}s:</h2><br>

    <table>
        <tr>
            <td><b>Name of ${typeName}</b></td>
            <td><b> Describe</b></td>
        </tr>
        <c:forEach var="content" items="${contents}">
            <tr>
                <c:choose>
                    <c:when test="${type == 'movie' || id == '0'}">
                        <td><a href="/video/${type}?id=${content.id}">${content.name}</a></td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/video/${type}?id=${id}&season=${content.seasonNumber}">${content.name}</a></td>
                    </c:otherwise>
                </c:choose>
                <td>${content.describe}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br><br>

        <a href="/video/${type}/admin">administrate video content <br>(need a password)</a>

</body>
</html>
