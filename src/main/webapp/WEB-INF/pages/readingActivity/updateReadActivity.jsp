<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="post" action="/updateReadActivity" modelAttribute="updateRADto">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${id}" ></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${updateRADto.name}"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="text" value="${updateRADto.text}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
</form:form>
<form method="post" action="/deleteReadActivity">
    <input type="submit" value="Delete">
</form>
</body>
</html>
