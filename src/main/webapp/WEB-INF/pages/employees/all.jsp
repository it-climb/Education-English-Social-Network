<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title>AllEmployee</title>
</head>
<body>
        <table width="200px">
            <tr>
                <td width="200" height="50"> Departmet <b>${department.name}:</b></td>
            </tr>
        </table>
        <table width="400px" border="2">
            <tr>
                <td width="50" align="center"><b>ID</b></td>
                <td width="200" align="center"><b>Name</b></td>
                <td width="70" align="center"><b>Age</b></td>
                <td colspan="2" align="center"><b>Actions</b></td>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>

                    <td width="50" align="center">${employee.id}</td>
                    <td width="200">${employee.firstName} ${employee.secondName}</td>
                    <td width="50" align="center">${employee.age}</td>

                    <td width="70" align="center" valign="middle">
                        <form method="post" action="/employeeDelete">
                            <input type="hidden" name="id" value=${employee.id}>
                            <input type="submit" value="Delete">
                        </form>
                    </td>

                    <td width="90" align="center" valign="middle">
                        <form method="post" action="/employeeEdit">
                            <input type="hidden" name="id" value=${employee.id}>
                            <input type="submit" value="Update">
                        </form>
                    </td>

                </tr>

            </c:forEach>
            </table>
        <table width=300px>
            <tr>
                <td align="center" valign="middle">
                    <form method="post" action="/employeeEdit">
                        <input type="hidden" name="department_id" value=${department.id}>
                        <input type="submit" value="Add new employee">
                    </form>
                </td>
            </tr>
        </table>

</body>
</html>