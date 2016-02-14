<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video play</title>
</head>
<body>


  <%--  <h2 align="center">${content.name}</h2>
    <h2 align="center">serie № ${serie}</h2>--%>

    <c:if test="${playVideo != null}">
        <iframe width="560" height="315" src="${playVideo.url}" frameborder="3" allowfullscreen></iframe><br><br>
    </c:if>

    <c:choose>
        <c:when test="${type == 'video'}">
            <c:forEach var="videoFile" items="${content}">
                <a href="/video/${type}?id=${videoFile.id}">${videoFile.name}</a><br>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <c:forEach var="videoFile" items="${content.listVideoFiles}">
                <a href="/video/${type}?id=${content.id}&serie=${videoFile.serieNumber}">${videoFile.name}</a><br>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <p><a href="/video/${type}">Back to ${typeName} catalog</a></p>

</body>
</html>
