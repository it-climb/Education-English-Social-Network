<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new one</title>
</head>
<body>
<form:form method="post" action="/addComment" modelAttribute="comment">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>Comment:</td>
            <td><form:input path="message" /></td>
        </tr>

        <tr>
            <td>userAcc:</td>
            <td><form:input path="userAcc" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>