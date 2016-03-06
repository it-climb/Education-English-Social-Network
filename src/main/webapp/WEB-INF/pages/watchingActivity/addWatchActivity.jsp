<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Watch Activity</title>
</head>
<body>
<form:form method="post" action="/addWatchActivity" modelAttribute="waDto">
    <table>
        <tr>
            <td> Add new watch activity</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${waDto.name}"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="${waDto.description}"/></td>
        </tr>
        <tr>
            <td>URL:</td>
            <td><input type="text" name="url" value="${waDto.url}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
