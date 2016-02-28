<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="users.login.login"/></title>
    <title>Login</title>
</head>
<body>
<form:form method="post" action="/userLogin">
    <div align="right"><strong>${email}</strong></div>
    <table>
        <tr>
            <td><spring:message code="users.login.email"/>:</td>
            <td><input type="text" name="email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td><spring:message code="users.login.password"/>:</td>
            <td><input type="password" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="Ok">
            </td>
        </tr>
    </table>
    <a href="/regSave"><spring:message code="users.login.registration"/></a>
</form:form>
</body>
</html>
