<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="resources/assets/css/stylepages.css" rel="stylesheet">
    <title>Edit Employee</title>
</head>
<body>
<<<<<<< HEAD
<div id="container">
    <div id="header">
        <%@ include file="/resources/assets/jsp/navigationbar.jsp"%>
    </div>
    <div id="content">
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
                    <%--<td width="50" height="50">--%>
                        <%--<form method="post" action="/dep">--%>
                            <%--<input type="submit" value="Cancel">--%>
                        <%--</form>--%>
                    <%--</td>--%>
                </tr>
            </table>
        </form:form>
    </div>
</div>

=======
<form:form method="post" action="/employeeSaveOrUpdate" modelAttribute="employee">

    <input type="hidden" name="departmentId" value="${employee.department.id}">
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
>>>>>>> origin/EESN-task-Leha-Home-Page
</body>
</html>

