<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <form:form action="/video/${type}/deleteserie" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
                    <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                    <input type="submit" value="Delete">
                </form:form>
            </td>
            <td>
                <form:form action="/video/${type}/editserie" method="post">
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
                    <input type="hidden" name="serieNumber" value="${content.serieNumber}">
                    <input type="submit" value="Update">
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>

<form:form action="/video/${type}/editserie" method="post">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="seasonNumber" value="${seasonNumber}">
    <input type="submit" value="Add new Series">
</form:form>


</body>
</html>
