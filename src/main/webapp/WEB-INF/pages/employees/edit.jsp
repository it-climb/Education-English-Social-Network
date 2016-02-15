<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<form:form method="post" action="/employeeSaveOrUpdate" modelAttribute="employee">

    <input type="hidden" name="departmentId" value="${employee.department.id}">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="hidden" name="version" value="${employee.version}">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Second Name:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
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
