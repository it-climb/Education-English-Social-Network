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
            <table>
                <tr>
                    <td width="150" height="50">First Name:</td>
                    <td height="50"><input type="text" name="firstName" value="${employee.firstName}"/></td>
                </tr>
                <tr>
                    <td width="150" height="50">Second Name:</td>
                    <td height="50"><input type="text" name="secondName" value="${employee.secondName}"/></td>
                </tr>
                </table>
            <table width="200">
                <tr>
                    <td width="50" align="center" height="50">
                        <input type="submit" value="Add">
                    </td>
                </tr>
            </table>
        </form:form>

</body>
</html>

