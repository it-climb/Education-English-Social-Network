<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="post" action="/addReadActivity" modelAttribute="raDto">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${raDto.name}"/></td>
        </tr>
        <tr>
            <td>Text:</td>
            <td><input type="text" name="text" value="${raDto.text}"/></td>
        </tr>
        <tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
