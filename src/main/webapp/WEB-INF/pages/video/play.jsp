<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video play</title>
</head>
<body>

    <h2 align="center">${content.name}</h2>
    <h2 align="center">${nameVideoFile}</h2>

    <c:forEach var="videoFile" items="${content.listVideoFiles}">
        <c:if test="${nameVideoFile == videoFile.name}">
            <iframe width="560" height="315" src="${videoFile.url}" frameborder="3" allowfullscreen></iframe><br><br>
        </c:if>
    </c:forEach>
    <%--<h2 align="center">${content.movieContent.}</h2>--%>
   <%-- <iframe width="560" height="315" src="${content.url}" frameborder="3" allowfullscreen></iframe>--%>

    <c:forEach var="videoFile" items="${content.listVideoFiles}">
        <a href="/video/${type}?id=${content.id}&name=${videoFile.name}">${videoFile.name}</a><br>
    </c:forEach>

    <p><a href="/video/${type}">Back to ${typeName} catalog</a></p>

</body>
</html>
