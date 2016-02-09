<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<table>
    <tr>
        <td><b>Video name</b></td>
        <td><b>Type</b></td>
    </tr>
    <c:forEach var="content" items="${contents}">
        <tr>
            <td><a href="/video?id=${content.id}">${content.name}</a></td>
            <td>${content.type}</td>
            <td>
                <form:form action="/video/delete" method="post">
                    <input type="submit" value="Delete">
                    <input type="hidden" name="id" value="${content.id}">
                </form:form>
            </td>
            <td>
                <form:form action="/video/edit" method="post">
                    <input type="submit" value="Update">
                    <input type="hidden" name="id" value="${content.id}">
                </form:form>
            </td>
        </tr>
    </c:forEach>

</table>

<form:form action="/video/edit" method="post">
    <input type="submit" value="Add new Video">
</form:form>

<p><a href="/video">Back to Catalog</a></p>

</body>
</html>
