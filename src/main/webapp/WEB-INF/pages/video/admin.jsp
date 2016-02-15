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
    </tr>
    <c:forEach var="content" items="${contents}">
        <tr>
            <td>${content.name}</td>
            <td>
                <form:form action="/video/${type}/delete" method="post">
                    <input type="submit" value="Delete">
                    <input type="hidden" name="id" value="${content.id}">
                </form:form>
            </td>
            <td>
                <form:form action="/video/${type}/update" method="post">
                    <input type="submit" value="Update">
                    <input type="hidden" name="id" value="${content.id}">
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form:form action="/video/${type}/update" method="post">
    <input type="submit" value="Add new ${typeName}">
</form:form>

<p><a href="/video">Back to Catalog</a></p>

</body>
</html>
