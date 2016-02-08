<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video</title>
</head>
<body>
    <h4 align="center">Film and serials in english!</h4>

    <nav >
        <p align="center">
            <a href="/video/movies">Movies</a>
            <a href="/video/serials">Serials</a>
            <a href="/video/tvshows">TV-Shows</a>
        </p>
    </nav>
    <p>${content.id}</p>
    <p>${videoUrl}</p>
    <iframe width="560" height="315" src="${videoUrl}" frameborder="3" allowfullscreen></iframe>

</body>
</html>
