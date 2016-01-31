<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="#" th:action="@{regUser1}" th:object="${user}" method="post">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" th:field="*{email}" /></td>
            <td th:if="${#fields.hasErrors('email')}" th:errors="*{email}">Name Error</td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" th:th:field="*{password}" /></td>
            <td th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Name Error</td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
