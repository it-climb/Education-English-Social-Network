<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: danil
  Date: 14.02.16
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="right"><strong>${email}</strong></div>
<table class="menu" width="1000px">
    <form method="get" action="/getBySubject">
        <input type="text" name="subject">
        <input type="submit" value="Search">
    </form>
    <p>AutorshipPoints : ${authorshipPoints.authorshipPoints}</p>
    <td>
        <form method="post" action="/asPointsUpAndDown">
            <input type="text" name="asPointsUp">
            <input type="submit" value="Increase">
        </form>
    </td>
    <td>
        <form method="post" action="/asPointsUpAndDown">
            <input type="text" name="asPointsDown">
            <input type="submit" value="OneToOne">
        </form>
    </td>
    <tr>
        <td>Add knowledge level</td>
        <td>
            <form method="post" action="/addKLPoints">
                <input type="text" name="subject">
                <input type="submit" value="Add">
            </form>
        </td>
        </tr>
    <tr>
        <td>Your search :${knowledgePointsBySubject.subject}:${knowledgePointsBySubject.knowledgeLevelPoints}</td>
    </tr>
    <c:forEach var="knowledgePoints" items="${knowledgeLevelPoints}">
        <tr>
                <td>${knowledgePoints.subject} : ${knowledgePoints.knowledgeLevelPoints}</td>
                <td>
                    <form method="post" action="/klPointsUp">
                        <input type="hidden" name="subject" value="${knowledgePoints.subject}">
                        <input type="text" name="klPointsUp">
                        <input type="submit" value="Increase">
                    </form>
                </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
