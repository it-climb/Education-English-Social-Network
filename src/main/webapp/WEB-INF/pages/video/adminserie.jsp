<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <c:forEach var="content" items="${contents}">
        <tr>
            <td>${content.name}</td>
            <td>
                <form action="video/${type}/deleteserie" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
                    <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                    <input type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="video/${type}/" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
                    <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="video/${type}/" method="post">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
    <input type="submit" value="Add new Series">
</form>


</body>
</html>
