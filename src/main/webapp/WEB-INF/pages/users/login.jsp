<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form method="post" action="/login">
    <div align="right"><strong>${email}</strong></div>
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"/>
            </td>
        </tr>
    </table>
    <a href="/registration">Registration</a>
</form:form>
</body>
</html>
