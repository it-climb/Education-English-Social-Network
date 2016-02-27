<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/video/${type}/saveseason" modelAttribute="newcontent">
    <table>
        <tr>
            <td>Name of Season: </td>
            <td><input type="text" name="name" value="${content.name}"></td>
        </tr>
        <tr>
            <td>Describe of Season: </td>
            <td><input type="text" name="describe" value="${content.describe}"></td>
        </tr>
        <tr>
            <td>Unique number of Season: </td>
            <td><input type="text" name="seasonNumber" value="${content.seasonNumber}"></td>
        </tr>
        <tr>
            <td><input type="hidden" name="id" value="${id}"></td>
            <td><input type="submit" value="Save season"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
