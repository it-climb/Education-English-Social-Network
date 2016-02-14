<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Descriptions</title>
</head>
<body>
<form:form method="post" action="/descriptionSaveOrUpdate" modelAttribute="description">
    <input type="hidden" name="id" value="${description.id}">
    <input type="hidden" name="wordId" value="${description.word.id}">
    <table>
        <tr>
            <td> Name:</td>
            <td><input type="text" name="Name" value="${description.name}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
