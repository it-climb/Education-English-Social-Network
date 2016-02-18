<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить активность</title>
</head>
<body>
<form:form method="post" action="addUserAct" modelAttribute="userAct">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>User id</td>
            <td><input type="text" name="User ID" value="${usera}" ></td>
        </tr>
        <tr>
            <td>User email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>User email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>User email</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>User email</td>
            <td><form:input path="email"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
