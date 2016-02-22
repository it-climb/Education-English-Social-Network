<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Video play</title>
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

    <c:if test="${playVideo != null}">
        ${playVideo.name}<br>
        ${playVideo.describe}<br>
        <iframe width="560" height="315" src="${playVideo.url}" frameborder="3" allowfullscreen></iframe><br><br>
    </c:if>

  <c:if test="${type == 'video'}">
      <c:forEach var="videoFile" items="${content}">
         <a href="/video/${type}?id=${videoFile.id}">${videoFile.name}</a><br>
      </c:forEach>
      <p><a href="/video/${type}">Back to ${typeName} catalog</a></p><br><br>
      <a href="/video/video/admin">administrate video content <br>(need a password)</a>
  </c:if>
  <c:if test="${type == 'movie'}">
      <c:forEach var="videoFile" items="${content.listVideoFiles}">
         <a href="/video/${type}?id=${content.id}&serie=${videoFile.serieNumber}">${videoFile.name}</a><br>
      </c:forEach>
      <p><a href="/video/${type}">Back to ${typeName} catalog</a></p>
  </c:if>
  <c:if test="${type == 'tvshow'}">
      <c:forEach var="videoFile" items="${content.listVideoFiles}">
         <a href="/video/${type}?id=${id}&season=${content.seasonNumber}&serie=${videoFile.serieNumber}">${videoFile.name}</a><br>
      </c:forEach>
      <p><a href="/video/${type}">Back to ${typeName} catalog</a></p>
  </c:if>



</body>
</html>
