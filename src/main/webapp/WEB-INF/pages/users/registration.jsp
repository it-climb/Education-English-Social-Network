<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        .error{
            color: #ff0000;
        }
    </style>
</head>
<body>
<form:form method="post" action="/regSave">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
            <td><form:errors path="email" cssClass="error"/> </td>
        </tr> <tr>
            <td>Password:</td>
            <td><input type="text" name="password" value="${user.password}"/></td>
            <td><form:errors path="password" cssClass="error"/> </td>
        </tr> <tr>
            <td colspan="2"><input type="submit" value="OK"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
