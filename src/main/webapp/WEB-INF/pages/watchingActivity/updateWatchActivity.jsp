<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="get" action="/updateWatchActivity" modelAttribute="updateWADto">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${updateWADto.name}"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${updateWADto.description}"/></td>
        </tr>
        <tr>
            <td>URL:</td>
            <td><input type="text" name="url" value="${updateWADto.url}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
</form:form>
<form method="post" action="/deleteWatchActivity">
    <input type="submit" value="Delete">
</form>
</body>
</html>
