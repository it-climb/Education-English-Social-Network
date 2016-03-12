<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Activity</title>
</head>
<body>
<form:form method="post" action="/saveOrUpdatePassingTestActivity" modelAttribute="ptaDto">
    <table>
        <tr>
            <td>Create new Passing Test Activity</td>
        </tr>
        <tr>
            <td><input type="text" value="${ptaDto.name}" name="name"></td>
            <input type="hidden" name="id" value="${ptaDto.id}">
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
